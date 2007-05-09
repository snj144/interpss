 /*
  * @(#)TestSetupBase.java   
  *
  * Copyright (C) 2006 www.interpss.org
  *
  * This program is free software; you can redistribute it and/or
  * modify it under the terms of the GNU LESSER GENERAL PUBLIC LICENSE
  * as published by the Free Software Foundation; either version 2.1
  * of the License, or (at your option) any later version.
  *
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  *
  * @Author Mike Zhou
  * @Version 1.0
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

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
	protected DStabilityNetwork net = null;

	public TestSetupBase() { 
		msg = SpringAppContext.getIpssMsgHub();
 	}
	
	public Machine createMachine() {
		net = DStabObjectFactory.createDStabilityNetwork();
		net.setFrequency(60.0);

		DStabBus bus = DStabObjectFactory.createDStabBus("BusId", net);
		bus.setName("BusName");
		bus.setBaseVoltage(1000);
		bus.setGenCode(AclfGenCode.GEN_PQ_LITERAL);

		Eq1Machine mach = (Eq1Machine)DStabObjectFactory.
							createMachine("MachId", "MachName", MachineType.EQ1_MODEL_LITERAL, net, "BusId");
		mach.setRating(100, "Mva", net.getBaseKva());
		mach.setRatedVoltage(1000.0);
		mach.setMultiFactors(bus);
		return mach;
	}
}

