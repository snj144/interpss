package org.interpss.schema;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.interpss.BaseTestSetup;
import org.interpss.core.adapter.IpssXmlAdapter;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class Ieee14BusXmlScriptRunAclfCaseTest extends BaseTestSetup {
	@Test
	public void runSingleAclfCaseTest() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
		
		AclfNetwork net = simuCtx.getAclfNet();
  		assertTrue((net.getBusList().size() == 14 && net.getBranchList().size() == 20));

		File xmlFile = new File("testData/xml/RunAclfCase.xml");
  		IpssXmlAdapter parser = new IpssXmlAdapter(xmlFile);
  		//System.out.println("----->" + parser.getRootElem().toString());

  		RunAclfStudyCaseType aclfCase = parser.getRunAclfStudyCaseList()[0];
	  	assertTrue(parser.getRootElem().getRunTask() == RunTaskDataType.RUN_ACLF);
  		
	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	parser.mapping(aclfCase, algo, RunAclfStudyCaseType.class);
	  	
	  	assertTrue(algo.getMaxIterations() == 20);
	  	assertTrue(algo.getTolerance() == 1.0E-4);
	  	
  		assertTrue(algo.loadflow(SpringAppContext.getIpssMsgHub()));
	}			

	@Test
	public void runSingleAclfCaseModificationTest() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
		
		AclfNetwork net = simuCtx.getAclfNet();
  		assertTrue((net.getBusList().size() == 14 && net.getBranchList().size() == 20));

		File xmlFile = new File("testData/xml/RunAclfCaseModification.xml");
  		IpssXmlAdapter parser = new IpssXmlAdapter(xmlFile);
  		//System.out.println("----->" + parser.getRootElem().toString());

  		RunAclfStudyCaseType aclfCase = parser.getRunAclfStudyCaseList()[0];
  		
	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	parser.mapping(aclfCase, algo, RunAclfStudyCaseType.class);
	  	
	  	assertTrue(!net.getBranch("0010->0009(1)").isActive());
	  	
  		assertTrue(algo.loadflow(SpringAppContext.getIpssMsgHub()));
	}}
