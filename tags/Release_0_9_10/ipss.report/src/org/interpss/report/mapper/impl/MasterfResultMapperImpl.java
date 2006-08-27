package org.interpss.report.mapper.impl;

import org.interpss.report.bean.RptMainTitleBean;

import com.interpss.common.util.IpssLogger;
import com.interpss.editor.jgraph.GraphSpringAppContext;
import com.interpss.editor.jgraph.ui.app.IAppSimuContext;
import com.interpss.editor.jgraph.ui.data.IProjectData;

public class MasterfResultMapperImpl {
	public static void mapMasterTitleBean(IAppSimuContext appSimuCtx, RptMainTitleBean titleBean) {
		try {
			titleBean.setVersionNumber(GraphSpringAppContext.getIpssGraphicEditor().getVersion());
			IProjectData projData = appSimuCtx.getProjData();
			titleBean.setProjectName(projData.getProjectName());
			titleBean.setUserName("InterPSS");
			titleBean.setFileName(projData.getFilename());
			titleBean.setReportNumber("InterPSS-Aclf-0001");
		} catch (Exception e) {
			IpssLogger.logErr(e);
		}
	}
}