package org.interpss.sample.dstab;

import org.apache.commons.math.complex.Complex;

import com.interpss.dstab.DStabBranch;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.test.unit.TestBaseAppCtx;
import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBranchCode;
import com.interpss.core.aclf.AclfGenCode;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;

public class TestSetupBase extends TestBaseAppCtx {
	protected IPSSMsgHub msg;

	public TestSetupBase() { 
		msg = SpringAppContext.getIpssMsgHub();
	}

	/**
	 * Create a two-bus system for transient stability unit testing
	 * 
	 * @return the net contains the bus
	 */
	public DStabilityNetwork createTestDStabBus() {
		DStabilityNetwork net = DStabObjectFactory.createDStabilityNetwork();

		// First bus is PQ Gen bus
		DStabBus bus1 = DStabObjectFactory.createDStabBus("Gen", net);
		bus1.setName("Gen Bus");
		bus1.setBaseVoltage(1000);
		bus1.setGenCode(AclfGenCode.GEN_PQ_LITERAL);
		bus1.setLoadCode(AclfLoadCode.CONST_P_LITERAL);
		bus1.setGenP(0.8);
		bus1.setGenQ(0.6);
		
		// Second bus is a Swing bus
		DStabBus bus2 = DStabObjectFactory.createDStabBus("Swing", net);
		bus2.setName("Swing Bus");
		bus2.setBaseVoltage(1000);
		bus2.setGenCode(AclfGenCode.SWING_LITERAL);
		SwingBusAdapter swing = (SwingBusAdapter)bus2.adapt(SwingBusAdapter.class);
		swing.setVoltMag(0.9434, UnitType.PU);
		swing.setVoltAng(-4.86444, UnitType.Deg);

		// a line branch connect the two buses
		DStabBranch branch = DStabObjectFactory.createDStabBranch("Gen", "Swing", net);
		branch.setBranchCode(AclfBranchCode.LINE_LITERAL);
		branch.setZ(new Complex(0.0, 0.1));
		
		// run load flow
	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.setLfMethod(AclfMethod.NR_LITERAL);
	  	algo.loadflow(msg);
	  	
	  	// uncommet this line to see the net object states
  		//System.out.println(net.net2String());
	  	
		return net;
	}
}

