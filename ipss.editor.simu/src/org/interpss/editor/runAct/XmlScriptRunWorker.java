 /*
  * @(#)XmlScriptRunWorker.java   
  *
  * Copyright (C) 2006 www.interpss.org
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
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.editor.runAct;

import org.apache.xmlbeans.XmlException;
import org.interpss.editor.mapper.RunForm2AlgorithmMapper;
import org.interpss.editor.ui.IOutputTextDialog;
import org.interpss.editor.ui.UISpringAppContext;
import org.interpss.schema.RunAclfStudyCaseXmlType;
import org.interpss.schema.AnalysisRunTaskXmlData;
import org.interpss.xml.IpssXmlParser;

import com.interpss.common.SpringAppContext;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;

public class XmlScriptRunWorker {
	/**
	 * Run the XMl scripts
	 * 
	 * @param scripts run scripts, a XML document
	 * @param simuCtx
	 * @return
	 */
	public static boolean runCase(String scripts, SimuContext simuCtx) {
		IpssXmlParser parser;
		try {
  			parser = new IpssXmlParser(scripts);
		} catch (XmlException e) {
			IpssLogger.logErr(e);
  			SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Invalid Xml", e.toString());
			return false;
		}
 
		if (parser.getRunStudyCase().getAnalysisRunTask() == AnalysisRunTaskXmlData.RUN_ACLF ) {
			LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(simuCtx.getAclfAdjNet());
		  	if (parser.getRunAclfStudyCaseList().length > 0) {
			  	RunAclfStudyCaseXmlType aclfCase = parser.getRunAclfStudyCaseList()[0];
			  	RunForm2AlgorithmMapper mapper = new RunForm2AlgorithmMapper();
			  	mapper.mapping(aclfCase, algo, RunAclfStudyCaseXmlType.class);
						  	
				algo.loadflow(simuCtx.getMsgHub());
			  	if (aclfCase.getDiaplaySummary()) {
			  		IOutputTextDialog dialog = UISpringAppContext.getOutputTextDialog("Loadflow Analysis Info");
				  	dialog.display(simuCtx.getAclfAdjNet());
			  	}
		  	}
		  	else {
	  			SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Invalid Xml", "runAclfStudyCase element not defined");
				return false;
		  	}
		}
		return true;
	}
}
