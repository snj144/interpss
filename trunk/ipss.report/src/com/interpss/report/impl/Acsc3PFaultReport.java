package com.interpss.report.impl;


import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import com.interpss.common.SpringAppContext;
import com.interpss.common.util.IpssLogger;
import com.interpss.editor.data.proj.CaseData;
import com.interpss.editor.jgraph.GraphSpringAppContext;
import com.interpss.editor.jgraph.ui.app.IAppSimuContext;
import com.interpss.report.IIpssReport;
import com.interpss.report.bean.RptMainTitleBean;
import com.interpss.report.bean.acsc.AcscRptBeanFactory;
import com.interpss.report.mapper.SimuCtxReportMapper;
import com.interpss.simu.SimuContext;

public class Acsc3PFaultReport implements IIpssReport {
	private String fnameAcsc3PFaultMaster = "reportTemplate/acsc/Acsc3PFaultMaster.jasper";
	private String fnameSubFaultSummary   = "reportTemplate/acsc/AcscFaultSummarySubReport.jasper";
	
	public JasperPrint createReport(String version) {
		Map<String, Object> parameters = new HashMap<String, Object>(); 
		parameters.put("FaultSummaryJBeanDatasource", fnameSubFaultSummary);
		
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

			return JasperFillManager.fillReport(fnameAcsc3PFaultMaster, parameters,
									AcscRptBeanFactory.getAcscVoltAmpsDataSource(simuCtx));
		} catch (Exception e) {
			IpssLogger.logErr(e);
			SpringAppContext.getIpssMsgHub().sendErrorMsg(e.toString());
		}			
		return null;
	}

	/**
	 * @param fnameAcsc3PFaultMaster the fnameAcsc3PFaultMaster to set
	 */
	public void setFnameAcsc3PFaultMaster(String fnameAcsc3PFaultMaster) {
		this.fnameAcsc3PFaultMaster = fnameAcsc3PFaultMaster;
	}

	/**
	 * @param fnameSubFaultSummary the fnameSubFaultSummary to set
	 */
	public void setFnameSubFaultSummary(String fnameSubFaultSummary) {
		this.fnameSubFaultSummary = fnameSubFaultSummary;
	}
}
