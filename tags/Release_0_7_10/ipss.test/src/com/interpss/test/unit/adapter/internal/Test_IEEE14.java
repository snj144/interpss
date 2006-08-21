package com.interpss.test.unit.adapter.internal;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.UnitType;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.editor.SimuAppSpringAppCtxUtil;
import com.interpss.simu.SimuContext;
import com.interpss.simu.io.IpssFileAdapter;
import com.interpss.test.unit.TestBaseAppCtx;

public class Test_IEEE14 extends TestBaseAppCtx {
	public void testCase1() throws Exception {
  		System.out.println("Test_IEEE14 testCase1 begins ...");
		
  		/*
  		 * Load the loadflow datafile into the application
  		 */
		IpssFileAdapter adapter = SimuAppSpringAppCtxUtil.getCustomFileAdapter("ipssdat");
		SimuContext simuCtx = adapter.load("testData/ipssdata/ieee14.ipssdat", SpringAppContext.getIpssMsgHub());
		
		/*
		 * Check the loadflow network has 14 buses and 20 branches
		 */
		AclfNetwork net = simuCtx.getAclfNet();
  		//System.out.println(net.net2String());
  		assertEquals(true, (net.getBusList().size() == 14 && net.getBranchList().size() == 20));

  		/*
  		 * Get the default loadflow algorithm and Run loadflow analysis. By default, it uses
  		 * NR method with convergence error tolerance 0.0001 pu
  		 */
	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.loadflow(SpringAppContext.getIpssMsgHub());
  		//System.out.println(net.net2String());
	  	
	  	/*
	  	 * Check if loadflow has converged
	  	 */
  		assertEquals(true, net.isLfConverged());
  		
  		/*
  		 * Bus (id="1") is a swing bus. Make sure the P and Q results are with the expected values
  		 */
  		AclfBus swingBus = (AclfBus)net.getBus("1");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.adapt(SwingBusAdapter.class);
  		assertEquals(true, Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getReal()-2.32386)<0.0001);
  		assertEquals(true, Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getImaginary()+0.16889)<0.0001);
  		
  		System.out.println("Test_IEEE14 testCase1 ends");
	}
}

