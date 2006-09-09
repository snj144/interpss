package org.interpss.test.simu.dstab.controller;

import org.interpss.test.simu.TestBaseAppCtx;

import com.interpss.common.SpringAppContext;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclf.AclfGenCode;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.mach.Eq1Machine;
import com.interpss.dstab.mach.Machine;
import com.interpss.dstab.mach.MachineType;

public class TestSetupBase extends TestBaseAppCtx {
	protected IPSSMsgHub msg;

	public TestSetupBase() { 
		msg = SpringAppContext.getIpssMsgHub();
 	}
	
	public Machine createMachine() {
		DStabilityNetwork net = DStabObjectFactory.createDStabilityNetwork();

		DStabBus bus = DStabObjectFactory.createDStabBus("BusId", net);
		bus.setName("BusName");
		bus.setBaseVoltage(1000);
		bus.setGenCode(AclfGenCode.GEN_PQ_LITERAL);

		Eq1Machine mach = (Eq1Machine)DStabObjectFactory.
							createMachine("MachId", "MachName", MachineType.EQ1_MODEL_LITERAL, net, "BusId");
		mach.setRating(100, "Mva", net.getBaseKva());
		mach.setRatedVoltage(1000.0);
		mach.setMultiFactors();
		return mach;
	}
}

