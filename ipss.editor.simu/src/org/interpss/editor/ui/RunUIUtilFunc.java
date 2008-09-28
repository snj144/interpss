 /*
  * @(#)RunUtilFunc.java   
  *
  * Copyright (C) 2006-2007 www.interpss.org
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
  * @Date 12/15/2007
  * 
  *   Revision History
  *   ================
  *
  */


package org.interpss.editor.ui;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

import org.interpss.editor.jgraph.GraphSpringAppContext;
import org.interpss.editor.jgraph.ui.app.IAppSimuContext;
import org.interpss.schema.InterPSSXmlType;
import org.interpss.xml.IpssXmlParser;

import com.interpss.common.util.IpssLogger;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;

public class RunUIUtilFunc  {
	public static String Template_RunCase_Aclf = "template/RunCaseAclfTemplate.xml";
	public static String Template_RunCase_Acsc = "template/RunCaseAcscTemplate.xml";
	public static String Template_RunCase_DStab = "template/RunCaseDStabTemplate.xml";
	public static String Template_RunCase_SenAnalysis = "template/RunCaseSenAnalysisTemplate.xml";	
	
	public static enum NetIdTypeEnum {LoadBus, GenBus, AllBus, LineBranch, XfrBranch, AllBranch}
	
	public static Set<String> getIdArray(AclfNetwork net, NetIdTypeEnum type) {
		Set<String> set = new TreeSet<String>();
		if (type == NetIdTypeEnum.AllBus || type == NetIdTypeEnum.GenBus || type == NetIdTypeEnum.LoadBus)
			for (Bus bus : net.getBusList()) {
				AclfBus aclfBus = (AclfBus)bus;
				if (type == NetIdTypeEnum.GenBus) {
					if (aclfBus.isGen()) 
						set.add(bus.getId());
				}	
				else if (type == NetIdTypeEnum.LoadBus) {
					if (aclfBus.isLoad())
						set.add(bus.getId());
				}
				else
					set.add(bus.getId());
			}
		else if (type == NetIdTypeEnum.AllBranch || type == NetIdTypeEnum.LineBranch || type == NetIdTypeEnum.XfrBranch)
			for (Branch bra : net.getBranchList()) {
				AclfBranch aclfBra = (AclfBranch)bra;
				if (type == NetIdTypeEnum.LineBranch) {
					if (aclfBra.isLine()) 
						set.add(bra.getId());
				}
				else if (type == NetIdTypeEnum.XfrBranch) {
					if (aclfBra.isXfr())
						set.add(bra.getId());
				}
				else
					set.add(bra.getId());
			}
		return set;
	}
	
	/**
	 * Load IpssXmlDoc from the file. If file not existing, load the info from the template.
	 * 
	 * @param filename
	 * @param caseType
	 * @return
	 * @throws Exception
	 */
	public static InterPSSXmlType loadIpssXmlDoc(String filename, IAppSimuContext.CaseType caseType) throws Exception {
  		IpssXmlParser parser;
  		try {
  			File xmlFile = new File(filename);
  			parser = new IpssXmlParser(xmlFile);
  			return parser.getRootDoc();
  		} catch (Exception e) {
  			IpssLogger.getLogger().info("This might be caused by first time loading the file, " + e.toString());
  		}

  		// use template file
		if (caseType == IAppSimuContext.CaseType.Aclf || caseType == IAppSimuContext.CaseType.Scripts) {
			filename = Template_RunCase_Aclf;
		}
		else if (caseType == IAppSimuContext.CaseType.SenAnalysis) {
			filename = Template_RunCase_SenAnalysis;
		}
		else if (caseType == IAppSimuContext.CaseType.Acsc) {
			filename = Template_RunCase_Acsc;
		}	
		else if (caseType == IAppSimuContext.CaseType.DStab) {
			filename = Template_RunCase_DStab;
		}	
  		
  		String wdir = GraphSpringAppContext.getIpssGraphicEditor().getWorkspace();
		filename = wdir+System.getProperty("file.separator")+filename;
		File xmlFile = new File(filename);
		parser = new IpssXmlParser(xmlFile);
		return parser.getRootDoc();
	}	
}
