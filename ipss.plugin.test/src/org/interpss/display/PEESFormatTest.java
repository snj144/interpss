package org.interpss.display;

import static org.junit.Assert.assertTrue;

import org.ieee.odm.adapter.IODMPSSAdapter;
import org.ieee.odm.adapter.xbean.v30.XBeanPSSEV30Adapter;
import org.interpss.display.impl.AclfOut_PSSE;
import org.interpss.mapper.IEEEODMMapper;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class PEESFormatTest {
	@Test
	public void testCase1() throws Exception {
		IODMPSSAdapter adapter = new XBeanPSSEV30Adapter(IpssLogger.getLogger());
		assertTrue(adapter.parseInputFile("testData/psse/PSSE_5Bus_Test.raw"));		
		
		AclfNetwork net = null;
		IEEEODMMapper mapper = new IEEEODMMapper();
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, SpringAppContext.getIpssMsgHub());
		if (mapper.mapping(adapter.getModel(), simuCtx, SimuContext.class)) {
  	  		simuCtx.setName("Sample18Bus");
  	  		simuCtx.setDesc("This project is created by input file adapter.getModel()");
  			net = simuCtx.getAclfNet();
  			//System.out.println(net.net2String());
		}
		else {
  	  		System.out.println("Error: ODM model to InterPSS SimuCtx mapping error, please contact support@interpss.com");
  	  		return;
		}		
		
	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, SpringAppContext.getIpssMsgHub());
	  	algo.setLfMethod(AclfMethod.PQ);
	  	algo.loadflow();
	  	
	  	System.out.println(AclfOutFunc.lfResultsPsseStyle(net, AclfOut_PSSE.Format.GUI));

	  	System.out.println(AclfOutFunc.lfResultsBusStyle(net));
	}
}
