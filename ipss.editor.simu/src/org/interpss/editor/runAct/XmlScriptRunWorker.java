/*
 * @(#)XmlScriptRunWorker.java   
 *
 * Copyright (C) 2008 www.interpss.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU LESSER GENERAL PUBLIC LICENSE
 * as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * @Author Mike Zhou
 * @Version 1.0
 * @Date 01/15/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.editor.runAct;

import org.apache.xmlbeans.XmlException;
import org.interpss.PluginSpringCtx;
import org.interpss.editor.runAct.xml.XmlScriptAclfRun;
import org.interpss.editor.runAct.xml.XmlScriptAcscRun;
import org.interpss.editor.runAct.xml.XmlScriptContingency;
import org.interpss.editor.runAct.xml.XmlScriptDStabRun;
import org.interpss.editor.runAct.xml.XmlScriptDclfRun;
import org.interpss.gridgain.GridRunner;
import org.interpss.schema.ModificationXmlType;
import org.interpss.schema.RunStudyCaseXmlType;
import org.interpss.xml.IpssXmlParser;

import com.interpss.common.CoreCommonSpringCtx;
import com.interpss.common.mapper.IpssMapper;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.simu.SimuContext;

public class XmlScriptRunWorker {
	/**
	 * Run the XMl scripts
	 * 
	 * @param scripts
	 *            run scripts, a string representing an XML document
	 * @param simuCtx
	 *            the SimuContext object
	 * @return
	 */
	public static boolean runCase(String scripts, SimuContext simuCtx) {
		// create the XML parser and parse the run scripts
		IpssXmlParser parser;
		try {
			parser = new IpssXmlParser(scripts);
		} catch (XmlException e) {
			IpssLogger.logErr(e);
			CoreCommonSpringCtx.getEditorDialogUtil().showErrMsgDialog(
					"Invalid Xml", e.toString());
			return false;
		}

		// Apply the modification to the base Network object
		IPSSMsgHub msg = simuCtx.getMsgHub();
		if (parser.getModification() != null) {
			IpssMapper mapper = PluginSpringCtx.getIpssXmlMapper();
			mapper.mapping(parser.getModification(), simuCtx.getNetwork());
		}
		
		RunStudyCaseXmlType xmlStudyCase = parser.getRunStudyCase();
		GridRunner.RemoteNodeDebug = xmlStudyCase.getGridRunOption() != null
				&& xmlStudyCase.getGridRunOption().getRemoteNodeDebug();
		if (xmlStudyCase.getAnalysisRunType() == RunStudyCaseXmlType.AnalysisRunType.RUN_ACLF) {
			return XmlScriptAclfRun.runAclf(parser.getRootDoc().getInterPSS(), simuCtx.getAclfNet(), msg);
		} else if (xmlStudyCase.getAnalysisRunType() == RunStudyCaseXmlType.AnalysisRunType.RUN_DCLF) {
			return XmlScriptDclfRun.runDclf(parser.getRootDoc().getInterPSS(), simuCtx.getAclfNet(),
					msg);
		} else if (xmlStudyCase.getAnalysisRunType() == RunStudyCaseXmlType.AnalysisRunType.RUN_ACSC) {
			return XmlScriptAcscRun.runAcsc(parser.getRootDoc().getInterPSS(), simuCtx.getAcscNet(),
					msg);
		} else if (xmlStudyCase.getAnalysisRunType() == RunStudyCaseXmlType.AnalysisRunType.RUN_D_STAB) {
			return XmlScriptDStabRun.runDStab(parser.getRootDoc().getInterPSS(), simuCtx, msg);
		}
		else if (xmlStudyCase.getAnalysisRunType() == RunStudyCaseXmlType.AnalysisRunType.CONTINGENCY_ANALYSIS) {
			return XmlScriptContingency.runContingencyAnalysis(parser.getRootDoc().getInterPSS(), simuCtx.getAclfNet(), msg);
		}
		msg.sendErrorMsg("Error: wrong analysus type, " + xmlStudyCase.getAnalysisRunType());
		return false;
	}
}
