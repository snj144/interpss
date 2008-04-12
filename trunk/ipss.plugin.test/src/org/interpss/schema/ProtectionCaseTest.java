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
import org.interpss.editor.mapper.RunForm2AlgorithmMapper;
import org.interpss.schema.RunStudyCaseXmlType.RunAclfStudyCase.AclfStudyCaseList.AclfStudyCase;
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
	  		
  		ProtectionRuleBaseXmlType ruleBase = parser.getRunAclfStudyCase().getProtectionRuleBase();
	  	assertTrue(ruleBase != null);
	  	
	  	ProtectionRuleSetXmlType ruleSet1 = ruleBase.getProtectionRuleSetList().getProtectionRuleSetArray()[0];
	  	assertTrue(ruleSet1.getBranchProtectionRuleArray().length == 1);
	  	ProtectionRuleSetXmlType.BranchProtectionRule rule1 = ruleSet1.getBranchProtectionRuleArray()[0];
	  	ProtectionConditionXmlType cond = rule1.getCondition();
	  	// branch 0010->0009 Mva limit is zero. Therefore, always violation
	  	assertTrue(ProtectionRuleHanlder.evlBranchCondition(cond, net, msg));

	  	
	  	ProtectionRuleSetXmlType ruleSet2 = ruleBase.getProtectionRuleSetList().getProtectionRuleSetArray()[1];
	  	assertTrue(ruleSet2.getBusProtectionRuleArray().length == 1);
	  	
	  	ProtectionRuleSetXmlType.BusProtectionRule rule2 = ruleSet2.getBusProtectionRuleArray()[0];
	  	cond = rule2.getCondition();
	  	assertTrue(!ProtectionRuleHanlder.evlBusCondition(cond, net, 1.2, 0.8, msg));
	  	// volatge at 0003 1.01
	  	assertTrue(ProtectionRuleHanlder.evlBusCondition(cond, net, 1.0, 0.8, msg));
	  	assertTrue(ProtectionRuleHanlder.evlBusCondition(cond, net, 1.2, 1.05, msg));
	  	
	  	ProtectionRuleHanlder.applyAclfRuleSet(net, parser.getRunAclfStudyCase().getProtectionRuleBase(), 1, 1.2, 0.8, msg);
	  	assertTrue(!net.getAclfBranch("0010->0009(1)").isActive());
	}		
}
