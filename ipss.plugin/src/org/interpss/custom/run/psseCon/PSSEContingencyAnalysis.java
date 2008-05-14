/*
 * @(#)PSSEContingencyAnalysis.java   
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
 * @Date 04/15/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.custom.run.psseCon;

import org.interpss.custom.run.CustomRunScriptPluginBase;
import org.interpss.schema.AclfAlgorithmXmlType;
import org.interpss.schema.GridComputingXmlType;
import org.interpss.schema.InterPSSXmlType;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.StringUtil;


public class PSSEContingencyAnalysis extends CustomRunScriptPluginBase {
	@Override
	public InterPSSXmlType createIpssXmlDocument(String scripts, IPSSMsgHub msg) {
		IpssLogger.getLogger().info("Run custom scripts with plugin: PSSEContingencyAnalysis");
		try {
			String[] strAry = StringUtil.strToken2Array(scripts, System.getProperty("line.separator"));
			//for(String s : strAry) System.out.println(s);
			// parse the contingency control for modification to the network 
			InterPSSXmlType ipssXmlDoc = ContingencyFileParser.parseControlFile(strAry);
			
			// add script run control scripts to the xml document 
			createAclfRunXmlScripts(ipssXmlDoc);
			return ipssXmlDoc;
		} catch (Exception e) {
			msg.sendErrorMsg(e.toString());
			return null;
		}
	}

	private boolean createAclfRunXmlScripts(InterPSSXmlType ipssXmlDoc) {
		// grid computing settings
		GridComputingXmlType gridRun = ipssXmlDoc.getRunStudyCase().addNewGridRun();
		gridRun.setEnableGridRun(true);
		gridRun.setRemoteJobCreation(true);
		GridComputingXmlType.AclfOption opt = gridRun.addNewAclfOption();
		opt.setReturnStudyCase(GridComputingXmlType.AclfOption.ReturnStudyCase.DIVERGED_CASE);
		
		// default Aclf Algorithm settings
		AclfAlgorithmXmlType algo = ipssXmlDoc.getRunStudyCase().getCustomRun().getRunAclfStudyCase().addNewDefaultAclfAlgorithm();
		algo.setLfMethod(AclfAlgorithmXmlType.LfMethod.NR);
		algo.setMaxIterations(20);
		algo.setTolerance(0.0001);
		algo.setNonDivergent(true);
		return true;
	}
}
