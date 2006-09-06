package org.interpss.report.impl;

/*
 * Fault Report for both 3P and NS faults
 */

import java.util.HashMap;
import java.util.Map;

import org.interpss.editor.data.proj.CaseData;
import org.interpss.editor.jgraph.GraphSpringAppContext;
import org.interpss.editor.jgraph.ui.app.IAppSimuContext;
import org.interpss.report.IIpssReport;
import org.interpss.report.bean.RptMainTitleBean;
import org.interpss.report.bean.acsc.AcscRptBeanFactory;
import org.interpss.report.mapper.SimuCtxReportMapper;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import com.interpss.common.SpringAppContext;
import com.interpss.common.util.IpssLogger;
import com.interpss.simu.SimuContext;

public class AcscFaultReport implements IIpssReport {
	private String fnameAcscFaultMaster = "reportTemplate/acsc/Acsc3PFaultMaster.jasper";
	private String fnameSubFaultSummary   = "reportTemplate/acsc/AcscFaultSummarySubReport.jasper";
	
	public JasperPrint createReport(String version) {
		Map<String, Object> parameters = new HashMap<String, Object>(); 
		parameters.put("FaultSummarySubreportFilename", fnameSubFaultSummary);
		
		try {
			IAppSimuContext appSimuCtx = GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext();
			SimuContext simuCtx = (SimuContext)appSimuCtx.getSimuCtx();
			SimuCtxReportMapper mapper = new SimuCtxReportMapper(SpringAppContext.getIpssMsgHub());

			// map the title bean
			RptMainTitleBean titleBean = new RptMainTitleBean();
			mapper.mapping(appSimuCtx, titleBean, RptMainTitleBean.class);
			titleBean.setReportTitle("Short Circuit Calculation");
			titleBean.setCaseName(appSimuCtx.getCurrentCaseName(CaseData.CaseType_Acsc));
			parameters.put("ReportMainTitleBean", titleBean);	
			
			parameters.put("FaultSummaryJBeanDatasource", AcscRptBeanFactory.getFaultSummaryDataSource(simuCtx));

			return JasperFillManager.fillReport(fnameAcscFaultMaster, parameters,
									AcscRptBeanFactory.getAcscVoltAmpsDataSource(simuCtx));
		} catch (Exception e) {
			IpssLogger.logErr(e);
			SpringAppContext.getIpssMsgHub().sendErrorMsg(e.toString());
		}			
		return null;
	}

	/**
	 * @param fnameAcscFaultMaster the fnameAcsc3PFaultMaster to set
	 */
	public void setFnameAcscFaultMaster(String fnameAcscFaultMaster) {
		this.fnameAcscFaultMaster = fnameAcscFaultMaster;
	}

	/**
	 * @param fnameSubFaultSummary the fnameSubFaultSummary to set
	 */
	public void setFnameSubFaultSummary(String fnameSubFaultSummary) {
		this.fnameSubFaultSummary = fnameSubFaultSummary;
	}
}
