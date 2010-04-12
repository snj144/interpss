package org.interpss.core.aclf;

import static org.junit.Assert.assertTrue;

import org.interpss.BaseTestSetup;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class IEEE14SwingCheckTest  extends BaseTestSetup {
	@Test
	public void run3WXfrOffCase() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
		
		AclfNetwork net = simuCtx.getAclfNet();
	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, SpringAppContext.getIpssMsgHub());

	  	net.getBranch("0007", "0008").setStatus(false);
	  	net.getBranch("0001", "0002").setStatus(false);
	  	
		if (!algo.checkSwingBus())
			algo.assignSwingBus();
  		assertTrue(!net.getBus("0008").isActive());
		//for (Bus bus : net.getBusList())
		//	System.out.println("id, intFlag, status: " + 
		//			bus.getId() + ", " + bus.getIntFlag() + ", " + bus.isActive());
		
  		assertTrue(algo.loadflow());
	}			
}
