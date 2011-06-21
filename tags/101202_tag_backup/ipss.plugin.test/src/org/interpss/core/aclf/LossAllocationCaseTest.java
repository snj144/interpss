package org.interpss.core.aclf;

import static org.junit.Assert.assertTrue;

import org.interpss.BaseTestSetup;
import org.interpss.display.AclfOutFunc;
import org.junit.Test;

import com.interpss.common.CoreCommonSpringCtx;
import com.interpss.common.datatype.UnitType;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.algorithm.loss.ActivePowerWalkDirection;
import com.interpss.core.algorithm.loss.LossCalNetAdapter;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;
import com.interpss.simu.util.sample.SampleCases;

public class LossAllocationCaseTest  extends BaseTestSetup {
	@Test
	public void lossAllocationStep() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
		
		AclfNetwork net = simuCtx.getAclfNet();
	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, CoreCommonSpringCtx.getIpssMsgHub());
	  	algo.setLfMethod(AclfMethod.NR);
	  	algo.setNonDivergent(true);
  		assertTrue(algo.loadflow());
  		/*
  		for (Branch bra : net.getBranchList()) {
  			System.out.println("Branch id, loss: " + bra.getId() + ", " + 
  					((AclfBranch)bra).loss().getReal() + ", " +
  					((AclfBranch)bra).loss().getReal()*100 + "MW");
  		}
  		*/
  		LossCalNetAdapter netAdapter = (LossCalNetAdapter)net.getAdapter(LossCalNetAdapter.class);
  		assertTrue(!netAdapter.hasActivePowerLoop());

  		//netAdapter.initForWalkThrough();
  		netAdapter.lossAllocation(ActivePowerWalkDirection.SOURC2_LOAD); 
		System.out.println(AclfOutFunc.loadLossAllocation(net));

  		//netAdapter.initForWalkThrough();
  		netAdapter.lossAllocation(ActivePowerWalkDirection.LOAD2_SOURCE); 
		System.out.println(AclfOutFunc.genLossAllocation(net));
	}	
	
	@Test
	public void sample5BusTest() {
  		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		SampleCases.load_LF_5BusSystem(net, CoreCommonSpringCtx.getIpssMsgHub());
		//System.out.println(net.net2String());

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, CoreCommonSpringCtx.getIpssMsgHub());
	  	algo.setLfMethod(AclfMethod.NR);
	  	algo.setMaxIterations(20);
	  	algo.setTolerance(0.0001, UnitType.PU, net.getBaseKva());
	  	algo.loadflow();
  		//System.out.println(net.net2String());
  		assertTrue(net.isLfConverged());
  		
  		LossCalNetAdapter netAdapter = (LossCalNetAdapter)net.getAdapter(LossCalNetAdapter.class);
  		assertTrue(!netAdapter.hasActivePowerLoop());

  		//netAdapter.initForWalkThrough();
  		netAdapter.lossAllocation(ActivePowerWalkDirection.SOURC2_LOAD); 
		System.out.println(AclfOutFunc.loadLossAllocation(net));

  		//netAdapter.initForWalkThrough();
  		netAdapter.lossAllocation(ActivePowerWalkDirection.LOAD2_SOURCE); 
		System.out.println(AclfOutFunc.genLossAllocation(net));
	}	
}