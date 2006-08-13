package com.interpss.tools;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;

import org.apache.commons.math.complex.Complex;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.interpss.common.SpringAppContext;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.acsc.AcscBusFault;
import com.interpss.core.acsc.SimpleFaultCode;
import com.interpss.core.acsc.SimpleFaultNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.algorithm.SimpleFaultAlgorithm;
import com.interpss.core.util.sample.SampleCases;
import com.interpss.report.bean.RptMainTitleBean;
import com.interpss.report.bean.aclf.AclfRptBeanFactory;
import com.interpss.report.bean.aclf.AclfRptSubrptControlRec;
import com.interpss.report.bean.acsc.AcscRptBeanFactory;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuObjectFactory;
import com.interpss.simu.io.IpssFileAdapter;

import custom.input.FileAdapter_IeeeCommonFormat;

public class ReportTester {
	public static JasperPrint createAcsc3PFaultReport(IPSSMsgHub msg) {
		SimuContext simuCtx = SimuObjectFactory.createSimuCtxTypeAcscFaultNet(msg);
		
  		SimpleFaultNetwork faultNet = simuCtx.getAcscFaultNet();
		SampleCases.load_SC_5BusSystem(faultNet, msg);
		//System.out.println(faultNet.net2String());

  		AcscBusFault fault = CoreObjectFactory.createAcscBusFault("2", faultNet);
		fault.setFaultCode(SimpleFaultCode.GROUND_3P_LITERAL);
		fault.setZLGFault(new Complex(0.0, 0.0));
		fault.setZLLFault(new Complex(0.0, 0.0));
		
	  	SimpleFaultAlgorithm algo = CoreObjectFactory.createSimpleFaultAlgorithm(faultNet);
	  	algo.calculateBusFault(fault, msg);
	  	
		Map<String,Object> parameters = new HashMap<String,Object>();
		parameters.put("FaultSummarySubreportFilename", "reportTemplate/acsc/AcscFaultSummarySubReport.jasper");
		try {
			// set the main title bean attributes
			parameters.put("ReportMainTitleBean", RptMainTitleBean.anAcscSample());	

			parameters.put("FaultSummaryJBeanDatasource", AcscRptBeanFactory.getFaultSummaryDataSource(simuCtx));
			
			String rptName = "reportTemplate/acsc/Acsc3PFaultMaster.jasper";
			JasperPrint jprint = JasperFillManager.fillReport(rptName, parameters,
					                       AcscRptBeanFactory.getAcscVoltAmpsDataSource(simuCtx));
//			JasperPrint jprint = JasperFillManager.fillReport(rptName, parameters, 
//											AcscRptBeanFactory.getAcscVoltAmps3PSampleDataSource());
			return jprint;
		} catch (Exception e) {
			IpssLogger.logErr(e);
		}
		return null;
	}

	public static JasperPrint createAclfSummaryReport(IPSSMsgHub msg) {
		IpssFileAdapter adapter = new FileAdapter_IeeeCommonFormat();
		SimuContext simuCtx = null;
		try {
			simuCtx = adapter.load("testData/ieee14.ieee", msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		AclfNetwork net = simuCtx.getAclfNet();

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.loadflow(msg);
		
		
		Map<String,Object> parameters = new HashMap<String,Object>();
		parameters.put("MismatchSubreportFilename", "reportTemplate/aclf/AclfMismatchSubReport.jasper");
		parameters.put("PVLimitSubreportFilename",  "reportTemplate/aclf/AclfPVLimitSubReport.jasper");
		parameters.put("PQLimitSubreportFilename",  "reportTemplate/aclf/AclfPQLimitSubReport.jasper");
		parameters.put("FuncLoadSubreportFilename",  "reportTemplate/aclf/AclfFuncLoadSubReport.jasper");
		parameters.put("RemoteQBusSubreportFilename",  "reportTemplate/aclf/AclfRemoteQBusSubReport.jasper");
		parameters.put("TapVControlSubreportFilename",  "reportTemplate/aclf/AclfTapVControlSubReport.jasper");
		parameters.put("PsXfrPControlSubreportFilename",  "reportTemplate/aclf/AclfPsXfrPControlSubReport.jasper");

		try {
			// set the main title bean attributes
			parameters.put("ReportMainTitleBean", RptMainTitleBean.anAclfSample());	
			
			// set MaxMismatch sub-report bean attributes
			parameters.put("MismatchJBeanDatasource", AclfRptBeanFactory.getMaxMismatchSampleDataSource());
			
			AclfRptSubrptControlRec contRec = new AclfRptSubrptControlRec();
			contRec.setPvLimitSubreport(false);
			//parameters.put("PVLimitJBeanDatasource", AclfRptBeanFactory.getPVLimitSampleDataSource());
			contRec.setPqLimitSubreport(false);
			//parameters.put("PQLimitJBeanDatasource", AclfRptBeanFactory.getPQLimitSampleDataSource());
			contRec.setFuncloadSubreport(false);
			//parameters.put("FuncLoadJBeanDatasource", AclfRptBeanFactory.getFuncLoadSampleDataSource());
			parameters.put("RemoteQBusJBeanDatasource", AclfRptBeanFactory.getRemoteQBusSampleDataSource());
			parameters.put("TapVControlJBeanDatasource", AclfRptBeanFactory.getTapVControlSampleDataSource());
			parameters.put("PsXfrPControlJBeanDatasource", AclfRptBeanFactory.getPSXfrPControlSampleDataSource());
			parameters.put("SubreportControlRec", contRec);	

			String rptName = "reportTemplate/aclf/AclfSummaryMaster.jasper";
			JasperPrint jprint = JasperFillManager.fillReport(rptName, parameters,
					                       AclfRptBeanFactory.getSummaryBusDataSource(simuCtx));
			return jprint;
		} catch (Exception e) {
			IpssLogger.logErr(e);
		}
		return null;
	}

	public static JasperPrint createAclfBusStyleReport(IPSSMsgHub msg) {
		IpssFileAdapter adapter = new FileAdapter_IeeeCommonFormat();
		SimuContext simuCtx = null;
		try {
			simuCtx = adapter.load("testData/ieee14.ieee", msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		AclfNetwork net = simuCtx.getAclfNet();

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.loadflow(msg);
		
		
		Map<String,Object> parameters = new HashMap<String,Object>();
		parameters.put("MismatchSubreportFilename", "reportTemplate/aclf/AclfMismatchSubReport.jasper");
		parameters.put("PVLimitSubreportFilename",  "reportTemplate/aclf/AclfPVLimitSubReport.jasper");
		parameters.put("PQLimitSubreportFilename",  "reportTemplate/aclf/AclfPQLimitSubReport.jasper");
		parameters.put("FuncLoadSubreportFilename",  "reportTemplate/aclf/AclfFuncLoadSubReport.jasper");
		parameters.put("RemoteQBusSubreportFilename",  "reportTemplate/aclf/AclfRemoteQBusSubReport.jasper");
		parameters.put("TapVControlSubreportFilename",  "reportTemplate/aclf/AclfTapVControlSubReport.jasper");
		parameters.put("PsXfrPControlSubreportFilename",  "reportTemplate/aclf/AclfPsXfrPControlSubReport.jasper");

		try {
			// set the main title bean attributes
			parameters.put("ReportMainTitleBean", RptMainTitleBean.anAclfSample());	
			
			// set MaxMismatch sub-report bean attributes
			parameters.put("MismatchJBeanDatasource", AclfRptBeanFactory.getMaxMismatchSampleDataSource());
			
			AclfRptSubrptControlRec contRec = new AclfRptSubrptControlRec();
			contRec.setPvLimitSubreport(false);
			//parameters.put("PVLimitJBeanDatasource", AclfRptBeanFactory.getPVLimitSampleDataSource());
			contRec.setPqLimitSubreport(false);
			//parameters.put("PQLimitJBeanDatasource", AclfRptBeanFactory.getPQLimitSampleDataSource());
			contRec.setFuncloadSubreport(false);
			//parameters.put("FuncLoadJBeanDatasource", AclfRptBeanFactory.getFuncLoadSampleDataSource());
			parameters.put("RemoteQBusJBeanDatasource", AclfRptBeanFactory.getRemoteQBusSampleDataSource());
			parameters.put("TapVControlJBeanDatasource", AclfRptBeanFactory.getTapVControlSampleDataSource());
			parameters.put("PsXfrPControlJBeanDatasource", AclfRptBeanFactory.getPSXfrPControlSampleDataSource());
			parameters.put("SubreportControlRec", contRec);	
			String rptName = "reportTemplate/aclf/AclfBusStyleMaster.jasper";
			JasperPrint jprint = JasperFillManager.fillReport(rptName, parameters,
											AclfRptBeanFactory.getBusStyleDataSource(simuCtx));
			return jprint;
		} catch (Exception e) {
			IpssLogger.logErr(e);
		}
		return null;
	}

	public static void main(String[] args) {
		String xmlfile = "c:/eclipse/interpss3.2/ipss.editor/properties/springConfig/editorAppContext.xml";
		SpringAppContext.SpringAppCtx = new FileSystemXmlApplicationContext(xmlfile);
		
//		JasperPrint jprint = createAclfSummaryReport(msg);
//		JasperPrint jprint = createAclfBusStyleReport(msg);
		JasperPrint jprint = createAcsc3PFaultReport(SpringAppContext.getIpssMsgHub());
		JRViewer view = new JRViewer(jprint);
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().add(view);
		frame.setSize(1000, 1000);
		frame.setVisible(true);
	}
}
