package org.interpss.report.impl;


import java.util.HashMap;
import java.util.Map;

import org.interpss.editor.data.proj.CaseData;
import org.interpss.editor.jgraph.GraphSpringAppContext;
import org.interpss.editor.jgraph.ui.app.IAppSimuContext;
import org.interpss.report.IIpssReport;
import org.interpss.report.bean.RptMainTitleBean;
import org.interpss.report.bean.aclf.AclfRptBeanFactory;
import org.interpss.report.mapper.SimuCtxReportMapper;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import com.interpss.common.SpringAppContext;
import com.interpss.common.util.IpssLogger;
import com.interpss.simu.SimuContext;

public class AclfSummaryReport extends AclfBaseReport implements IIpssReport {
	private String fnameAclfSummaryMaster = "reportTemplate/aclf/AclfSummaryMaster.jasper";
	
	public JasperPrint createReport(String version) {
		Map<String, Object> parameters = new HashMap<String, Object>(); 
		addSubreportFile(parameters);
		
		try {
			IAppSimuContext appSimuCtx = GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext();
			SimuContext simuCtx = (SimuContext)appSimuCtx.getSimuCtx();
			SimuCtxReportMapper mapper = new SimuCtxReportMapper(SpringAppContext.getIpssMsgHub());

			// map the title bean
			RptMainTitleBean titleBean = new RptMainTitleBean();
			mapper.mapping(appSimuCtx, titleBean, RptMainTitleBean.class);
			titleBean.setReportTitle("Load Flow (Summary)");
			titleBean.setCaseName(appSimuCtx.getCurrentCaseName(CaseData.CaseType_Aclf));
			parameters.put("ReportMainTitleBean", titleBean);	
			
			addSubreports(parameters, appSimuCtx, mapper);

			return JasperFillManager.fillReport(fnameAclfSummaryMaster, parameters,
					   							AclfRptBeanFactory.getSummaryBusDataSource(simuCtx));
		} catch (Exception e) {
			IpssLogger.logErr(e);
			SpringAppContext.getIpssMsgHub().sendErrorMsg(e.toString());
		}			
		return null;
	}

	/**
	 * @param fnameAclfSummaryMaster the fnameAclfSummaryMaster to set
	 */
	public void setFnameAclfSummaryMaster(String fnameAclfSummaryMaster) {
		this.fnameAclfSummaryMaster = fnameAclfSummaryMaster;
	}
}
