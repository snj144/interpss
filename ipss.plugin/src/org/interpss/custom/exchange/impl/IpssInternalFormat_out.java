 /*
  * @(#)IpssInternalFormat_in.java   
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

package org.interpss.custom.exchange.impl;

import java.io.BufferedWriter;

import com.interpss.common.datatype.UnitType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.CapacitorBusAdapter;
import com.interpss.core.aclf.GenBusAdapter;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.aclfadj.PVBusLimit;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;
import com.interpss.simu.SimuContext;

public class IpssInternalFormat_out {
    public static boolean save(final BufferedWriter out, final SimuContext simuCtx, final IPSSMsgHub msg) throws Exception {
    	AclfAdjNetwork net = simuCtx.getAclfAdjNet();
    	
    	// out put network info
    	out.write("AclfNetInfo\n");
        out.write(String.format("%3.2f%n", net.getBaseKva()));
        out.write("end\n");
        
        // out put bus info
        double baseMva = net.getBaseKva() * 0.001;
        out.write(String.format("%s%n", "BusInfo"));
		for (Bus b : net.getBusList()) {
			AclfBus bus = (AclfBus) b;
			out.write(String.format("%8s %10.0f %6.3f %5.1f %7.2f %7.2f %7.2f %7.2f %n", 
					bus.getId(),               // bus id
					bus.getBaseVoltage(),      // bus base voltage
					bus.getVoltageMag(),       // bus voltage in pu
					bus.getVoltageAng(UnitType.Deg), // bus voltage angle in deg
					bus.getGenP()*baseMva,         // bus gen P in MW
					bus.getGenQ()*baseMva,         // bus gen Q in MVar
					bus.getLoadP()*baseMva,        // bus load P in MW
					bus.getLoadQ()*baseMva));      // bus load Q in Mvar
		}
        out.write(String.format("%s%n", "end"));

        out.write(String.format("%s%n", "SwingBusInfo"));
		for (Bus b : net.getBusList()) {
			AclfBus bus = (AclfBus) b;
			if (bus.isSwing())
				out.write(String.format("%s%n", bus.getId()));  // Swing bus id
		}
        out.write(String.format("%s%n", "end"));

        out.write(String.format("%s%n", "PVBusInfo"));
		for (PVBusLimit pv : net.getPvBusLimitList()) {
			out.write(String.format("%8s %7.4f %7.2f %7.2f %n", 
					pv.getAclfBus().getId(),
					pv.getVSpecified(),
					pv.getQLimit().getMin()*baseMva,
					pv.getQLimit().getMax()*baseMva));
		}
        out.write(String.format("%s%n", "end"));

        out.write(String.format("%s%n", "CapacitorBusInfo"));
		for (Bus b : net.getBusList()) {
			AclfBus bus = (AclfBus) b;
			if (bus.isCapacitor()) {
				CapacitorBusAdapter cap = (CapacitorBusAdapter)bus.adapt(CapacitorBusAdapter.class);
				out.write(String.format("%8s %7.2f %n", bus.getId(), cap.getQ())); // capacitor Q in pu
			}
		}
        out.write(String.format("%s%n", "end"));

        out.write(String.format("%s%n", "BranchInfo"));
		for (Branch b : net.getBranchList()) {
			AclfBranch branch = (AclfBranch) b;
			out.write(String.format("%8s %8s %10.5f %10.5f %10.5f%n", 
					branch.getFromBus().getId(), 
					branch.getToBus().getId(),
					branch.getZ().getReal(),
					branch.getZ().getImaginary(),
					branch.getHShuntY().getImaginary()));
		}
        out.write(String.format("%s%n", "end"));

        out.write(String.format("%s%n", "XformerInfo"));
		for (Branch b : net.getBranchList()) {
			AclfBranch branch = (AclfBranch) b;
			if (branch.isXfr())
				out.write(String.format("%8s %8s %3s   %7.4f %n", 
						branch.getFromBus().getId(), 
						branch.getToBus().getId(),
						branch.getCircuitNumber(),
						branch.getFromTurnRatio()));
		}
        out.write(String.format("%s%n", "end"));

        out.write(String.format("%s%n", "EndOfFile"));
         
        return true;
    }
}