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

public class Test_IEEECommonFormat extends TestBaseAppCtx {
	public void testCase1() throws Exception {
  		System.out.println("Test_IEEECommonFormat testCase1 begins ...");
		
		IpssFileAdapter adapter = SimuAppSpringAppCtxUtil.getCustomFileAdapter("ieee");
		SimuContext simuCtx = adapter.load("testData/ieee_format/ieee14.ieee", SpringAppContext.getIpssMsgHub());

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

  		//System.out.println(AclfOut.lfResultsBusStyle(net));
  		
  		System.out.println("Test_IEEECommonFormat testCase1 ends");
	}

	public void testCase2() throws Exception{
  		System.out.println("Test_IEEECommonFormat testCase2 begins ...");
		
		IpssFileAdapter adapter = SimuAppSpringAppCtxUtil.getCustomFileAdapter("ieee");
		SimuContext simuCtx = adapter.load("testData/ieee_format/ieee30.ieee", SpringAppContext.getIpssMsgHub());

		AclfNetwork net = simuCtx.getAclfNet();
  		assertEquals(true, (net.getBusList().size() == 30 && net.getBranchList().size() == 41));

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.loadflow(SpringAppContext.getIpssMsgHub());
  		//System.out.println(net.net2String());
	  	
  		assertEquals(true, net.isLfConverged());		
 		AclfBus swingBus = (AclfBus)net.getBus("1");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.adapt(SwingBusAdapter.class);
  		assertEquals(true, Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getReal()-2.6095)<0.0001);
  		assertEquals(true, Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getImaginary()+0.1653)<0.0001);
  		
  		//System.out.println(AclfOut.lfResultsBusStyle(net));

  		System.out.println("Test_IEEECommonFormat testCase2 ends");
	}

	public void testCase3() throws Exception{
  		System.out.println("Test_IEEECommonFormat testCase3 begins ...");
		
		IpssFileAdapter adapter = SimuAppSpringAppCtxUtil.getCustomFileAdapter("ieee");
		SimuContext simuCtx = adapter.load("testData/ieee_format/ieee57.ieee", SpringAppContext.getIpssMsgHub());

		AclfNetwork net = simuCtx.getAclfNet();
  		assertEquals(true, (net.getBusList().size() == 57 && net.getBranchList().size() == 80));

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.loadflow(SpringAppContext.getIpssMsgHub());
  		//System.out.println(net.net2String());
	  	
  		assertEquals(true, net.isLfConverged());		
 		AclfBus swingBus = (AclfBus)net.getBus("1");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.adapt(SwingBusAdapter.class);
		//System.out.println(swing.getGenResults(UnitType.PU, net.getBaseKva()).re);
		//System.out.println(swing.getGenResults(UnitType.PU, net.getBaseKva()).im);
  		assertEquals(true, Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getReal()-4.7942)<0.0001);
  		assertEquals(true, Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getImaginary()-1.2951)<0.0001);
  		
  		//System.out.println(AclfOut.lfResultsBusStyle(net));

  		System.out.println("Test_IEEECommonFormat testCase3 ends");
	}

	public void testCase4() throws Exception{
  		System.out.println("Test_IEEECommonFormat testCase4 begins ...");
		
		IpssFileAdapter adapter = SimuAppSpringAppCtxUtil.getCustomFileAdapter("ieee");
		SimuContext simuCtx = adapter.load("testData/ieee_format/ieee118.ieee", SpringAppContext.getIpssMsgHub());

		AclfNetwork net = simuCtx.getAclfNet();
  		assertEquals(true, (net.getBusList().size() == 118 && net.getBranchList().size() == 186));

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.loadflow(SpringAppContext.getIpssMsgHub());
  		//System.out.println(net.net2String());
	  	
  		assertEquals(true, net.isLfConverged());		
 		AclfBus swingBus = (AclfBus)net.getBus("69");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.adapt(SwingBusAdapter.class);
		//System.out.println(swing.getGenResults(UnitType.PU, net.getBaseKva()).re);
		//System.out.println(swing.getGenResults(UnitType.PU, net.getBaseKva()).im);
  		assertEquals(true, Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getReal()-5.1348)<0.0001);
  		assertEquals(true, Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getImaginary()+0.8239)<0.0001);
  		
  		System.out.println("Test_IEEECommonFormat testCase4 ends");
	}

	public void xtestCase5() throws Exception{
  		System.out.println("Test_IEEECommonFormat testCase5 begins ...");
		
		IpssFileAdapter adapter = SimuAppSpringAppCtxUtil.getCustomFileAdapter("ieee");
		SimuContext simuCtx = adapter.load("testData/ieee_format/ieee300.ieee", SpringAppContext.getIpssMsgHub());

		AclfNetwork net = simuCtx.getAclfNet();
  		assertEquals(true, (net.getBusList().size() == 300 && net.getBranchList().size() == 411));

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.loadflow(SpringAppContext.getIpssMsgHub());
  		//System.out.println(net.net2String());
	  	
  		assertEquals(true, net.isLfConverged());		
 		AclfBus swingBus = (AclfBus)net.getBus("69");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.adapt(SwingBusAdapter.class);
		//System.out.println(swing.getGenResults(UnitType.PU, net.getBaseKva()).re);
		//System.out.println(swing.getGenResults(UnitType.PU, net.getBaseKva()).im);
  		assertEquals(true, Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getReal()-5.1348)<0.0001);
  		assertEquals(true, Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getImaginary()+0.8239)<0.0001);
  		
  		System.out.println("Test_IEEECommonFormat testCase5 ends");
	}
}

