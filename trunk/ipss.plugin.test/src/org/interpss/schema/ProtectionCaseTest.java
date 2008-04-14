/*
 * @(#)ProtectionCaseTest.java   
 *
 * Copyright (C) 2006-2008 www.interpss.org
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

package org.interpss.schema;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.interpss.BaseTestSetup;
import org.interpss.PluginSpringAppContext;
import org.interpss.editor.mapper.RunForm2AlgorithmMapper;
import org.interpss.schema.RunStudyCaseXmlType.RunAclfStudyCase.AclfStudyCaseList.AclfStudyCase;
import org.interpss.schema.RunStudyCaseXmlType.RunAclfStudyCase.AclfRuleBase;
import org.interpss.xml.IpssXmlParser;
import org.interpss.xml.ProtectionRuleHanlder;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.mapper.IpssMapper;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class ProtectionCaseTest extends BaseTestSetup {
	@Test
	public void run3WXfrOffCaseTest() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
  		// save net to a String
  		String netStr = SerializeEMFObjectUtil.saveModel(simuCtx.getAclfAdjNet());

		File xmlFile = new File("testData/xml/IEEE14Bus_W3XfrOff.xml");
  		IpssXmlParser parser = new IpssXmlParser(xmlFile);
  		//System.out.println("----->" + parser.getRootElem().toString());

	  	assertTrue(parser.getRunStudyCase().getAnalysisRunType() == RunStudyCaseXmlType.AnalysisRunType.RUN_ACLF);
  		
		AclfAdjNetwork net = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(netStr);
		net.getAclfBranch("0005->0006(1)").setRatingMva1(70.0);

		AclfStudyCase aclfCase = parser.getRunStudyCase().getRunAclfStudyCase().getAclfStudyCaseList().getAclfStudyCaseArray()[0];
  		IpssMapper mapper = PluginSpringAppContext.getIpssXmlMapper();
		mapper.mapping(aclfCase.getModification(), net, ModificationXmlType.class);


		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
		mapper = new RunForm2AlgorithmMapper();
		mapper.mapping(aclfCase.getAclfAlgorithm(), algo, AclfAlgorithmXmlType.class);
  		
  		assertTrue(algo.getMaxIterations() == 20);
  		assertTrue(algo.getTolerance() == 1.0E-4);
  		assertTrue(algo.loadflow(SpringAppContext.getIpssMsgHub()));
  		//System.out.println(net.net2String());  	
  		
	  	assertTrue(!net.getAclfBus("0007").isActive());
	  	assertTrue(!net.getAclfBus("0008").isActive());

	  	assertTrue(!net.getAclfBranch("0004->0007(1)").isActive());
	  	assertTrue(!net.getAclfBranch("0004->0009(1)").isActive());
	  	assertTrue(!net.getAclfBranch("0007->0009(1)").isActive());
	  	assertTrue(!net.getAclfBranch("0007->0008(1)").isActive());
	}
	
	@Test
	public void runAclfProtectCaseTest() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
  		// save net to a String
  		String netStr = SerializeEMFObjectUtil.saveModel(simuCtx.getAclfAdjNet());

		File xmlFile = new File("testData/xml/RunAclfCaseProtection.xml");
  		IpssXmlParser parser = new IpssXmlParser(xmlFile);
  		//System.out.println("----->" + parser.getRootElem().toString());

	  	assertTrue(parser.getRunStudyCase().getAnalysisRunType() == RunStudyCaseXmlType.AnalysisRunType.RUN_ACLF);
  		
	  	AclfStudyCase aclfCase = parser.getRunStudyCase().getRunAclfStudyCase().getAclfStudyCaseList().getAclfStudyCaseArray()[0];
		AclfAdjNetwork net = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(netStr);
  		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	IpssMapper mapper = new RunForm2AlgorithmMapper();
  		mapper.mapping(aclfCase.getAclfAlgorithm(), algo, AclfAlgorithmXmlType.class);
	  	
  		assertTrue(algo.getMaxIterations() == 20);
  		assertTrue(algo.getTolerance() == 1.0E-4);
  		assertTrue(algo.loadflow(SpringAppContext.getIpssMsgHub()));
  		//System.out.println(net.net2String());
	  		
  		AclfRuleBase aclfRuleBase = parser.getRunAclfStudyCase().getAclfRuleBase();
	  	assertTrue(aclfRuleBase != null);
	  	
	  	ProtectionRuleSetXmlType ruleSet = aclfRuleBase.getProtectionRuleSetList().getProtectionRuleSetArray()[0];
	  	assertTrue(ruleSet.getProtectionRuleList().getProtectionRuleArray().length == 2);
	  	ProtectionRuleSetXmlType.ProtectionRuleList.ProtectionRule rule1 = ruleSet.getProtectionRuleList().getProtectionRuleArray()[0];
	  	ProtectionConditionXmlType cond = rule1.getCondition();
	  	// branch 0010->0009 Mva limit is zero. Therefore, always violation
	  	assertTrue(ProtectionRuleHanlder.evlBranchCondition(cond, net, msg));

	  	ProtectionRuleSetXmlType.ProtectionRuleList.ProtectionRule rule2 = ruleSet.getProtectionRuleList().getProtectionRuleArray()[1];
	  	cond = rule2.getCondition();
	  	assertTrue(!ProtectionRuleHanlder.evlBusCondition(cond, net, 1.2, 0.8, msg));
	  	// volatge at 0003 1.01
	  	assertTrue(ProtectionRuleHanlder.evlBusCondition(cond, net, 1.0, 0.8, msg));
	  	assertTrue(ProtectionRuleHanlder.evlBusCondition(cond, net, 1.2, 1.05, msg));
	  	
	  	ProtectionRuleHanlder.applyAclfRuleSet(net, parser.getRunAclfStudyCase().getAclfRuleBase(), 1, 1.2, 0.8, msg);
	  	assertTrue(!net.getAclfBranch("0010->0009(1)").isActive());
	}		
}
