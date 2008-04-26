package org.interpss.core.aclf;

import static org.junit.Assert.assertTrue;

import org.interpss.BaseTestSetup;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.ComplexFunc;
import com.interpss.common.datatype.UnitType;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.util.sample.SampleCases;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class IEEE14BusCaseTest  extends BaseTestSetup {
	@Test
	public void run3WXfrOffCase() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE14Bus_3WXfrOff.ipss", simuCtx);
		
		AclfNetwork net = simuCtx.getAclfNet();
	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	
  		assertTrue(algo.loadflow(SpringAppContext.getIpssMsgHub()));

  		AclfBus swingBus = (AclfBus)net.getBus("0001");
  		SwingBusAdapter swing = (SwingBusAdapter)swingBus.adapt(SwingBusAdapter.class);
		System.out.println(ComplexFunc.toString(swing.getGenResults(UnitType.PU, net.getBaseKva())));
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getReal()-2.35978)<0.0001);
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getImaginary()+0.22723)<0.0001);
	}			

	@Test
	public void runIEEE14BusAdjustChangeStep() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
		
		AclfNetwork net = simuCtx.getAclfNet();
	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.setLfMethod(AclfMethod.NR);
	  	algo.setNonDivergent(true);
	  	
  		assertTrue(algo.loadflow(SpringAppContext.getIpssMsgHub()));
  		AclfBus swingBus = (AclfBus)net.getBus("0001");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.adapt(SwingBusAdapter.class);
		//System.out.println(ComplexFunc.toString(swing.getGenResults(UnitType.PU, net.getBaseKva())));
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getReal()-2.32428)<0.0001);
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getImaginary()+0.26235)<0.0001);
	}			

	@Test
	public void runSampleAdjustChangeStep() throws Exception {
		// step-1: define and load a EMF network object
  		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		SampleCases.load_LF_5BusSystem(net, SpringAppContext.getIpssMsgHub());
		//System.out.println(net.net2String());
		
		AclfBus bus = net.getAclfBus("1");
		bus.setLoadP(2.0);
		bus.setLoadQ(1.1);

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.setLfMethod(AclfMethod.NR);
	  	algo.setNonDivergent(true);

	  	assertTrue(!algo.loadflow(SpringAppContext.getIpssMsgHub()));
	  	
	  	bus.setLoadCode(AclfLoadCode.EXPONENTIAL);
	  	bus.setExpLoadP(0.9);
	  	bus.setExpLoadQ(3.0);
	  	algo.setMaxIterations(40);
	  	assertTrue(algo.loadflow(SpringAppContext.getIpssMsgHub()));
	}			
}
