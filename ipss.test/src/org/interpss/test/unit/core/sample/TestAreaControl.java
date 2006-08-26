package org.interpss.test.unit.core.sample;

import org.interpss.test.unit.TestBaseAppCtx;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.UnitType;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfGenCode;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.aclfadj.AreaInterchangeController;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.util.sample.SampleCases;

public class TestAreaControl extends TestBaseAppCtx {
	public void testCase1() {
  		System.out.println("Begin TestAreaControl.testCase1()");

  		AclfAdjNetwork net = CoreObjectFactory.createAclfAdjNetwork();
		SampleCases.load_LF_5BusSystem(net, SpringAppContext.getIpssMsgHub());

		AclfBus bus4 = net.getAclfBus("4");
		bus4.setGenCode(AclfGenCode.SWING_LITERAL);
		final SwingBusAdapter swing = (SwingBusAdapter)bus4.adapt(SwingBusAdapter.class);
		swing.setVoltMag(1.05, UnitType.PU);
		swing.setVoltAng(0.38, UnitType.Rad);
		
		
		try {
			AreaInterchangeController controller = CoreObjectFactory.createAreaInterchangeController(1, "Area1", net);
			AclfBus bus = net.getAclfBus("4");
			assertTrue(bus != null);
			controller.setAclfBus(bus);
			controller.setPSpecOut(150.0, UnitType.mW, net.getBaseKva());
			controller.setTolerance(0.1, UnitType.mW, net.getBaseKva());
		} catch (Exception e) {
			System.err.print(e.toString());
		}
		
		//System.out.println(net.net2String());

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.loadflow(SpringAppContext.getIpssMsgHub());
  		//System.out.println(net.net2String());
	  	
  		assertEquals(true, net.isLfConverged());

  		//System.out.println("Area1 output power: " + net.areaOutputPower(1, UnitType.PU));
  		assertEquals(true, Math.abs(net.areaOutputPower(1, UnitType.PU)-1.4994)<0.0001);
		
		System.out.println("End TestAreaControl.testCase1()");
	}
}

