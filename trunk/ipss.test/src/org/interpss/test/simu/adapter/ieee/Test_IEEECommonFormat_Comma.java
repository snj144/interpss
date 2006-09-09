package org.interpss.test.simu.adapter.ieee;

import org.interpss.editor.SimuAppSpringAppCtxUtil;
import org.interpss.test.simu.TestBaseAppCtx;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.UnitType;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;
import com.interpss.simu.io.IpssFileAdapter;

public class Test_IEEECommonFormat_Comma extends TestBaseAppCtx {
	public void testCase1() throws Exception {
  		System.out.println("Test_IEEECommonFormat testCase1 begins ...");
		
		IpssFileAdapter adapter = SimuAppSpringAppCtxUtil.getCustomFileAdapter("ieee");
		SimuContext simuCtx = adapter.load("testData/ieee_format/ieee14_comma.ieee", SpringAppContext.getIpssMsgHub());

		AclfNetwork net = simuCtx.getAclfNet();
  		assertEquals(true, (net.getBusList().size() == 14 && net.getBranchList().size() == 20));

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.loadflow(SpringAppContext.getIpssMsgHub());
  		//System.out.println(net.net2String());
	  	
  		assertEquals(true, net.isLfConverged());		
  		AclfBus swingBus = (AclfBus)net.getBus("1");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.adapt(SwingBusAdapter.class);
  		assertEquals(true, Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getReal()-2.32393)<0.0001);
  		assertEquals(true, Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getImaginary()+0.16549)<0.0001);
  		
  		System.out.println("Test_IEEECommonFormat testCase1 ends");
	}
}

