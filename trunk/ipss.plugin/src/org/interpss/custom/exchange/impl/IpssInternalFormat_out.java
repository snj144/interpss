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
					bus.getId(), 
					bus.getBaseVoltage(), 
					bus.getVoltageMag(), 
					bus.getVoltageAng(UnitType.Deg), 
					bus.getGenP()*baseMva,
					bus.getGenQ()*baseMva,
					bus.getLoadP()*baseMva,
					bus.getLoadQ()*baseMva));
		}
        out.write(String.format("%s%n", "end"));

        out.write(String.format("%s%n", "SwingBusInfo"));
		for (Bus b : net.getBusList()) {
			AclfBus bus = (AclfBus) b;
			if (bus.isSwing())
				out.write(String.format("%s%n", bus.getId()));
		}
        out.write(String.format("%s%n", "end"));
/*
        out.write(String.format("%s%n", "PVBusInfo"));
		for (PVBusLimit pv : net.getPvBusLimitList()) {
			GenBusAdapter genBus = (GenBusAdapter) pv.getAclfBus().adapt(
					GenBusAdapter.class);
			out.write(String.format("%s%n", "2       1.045     -40      50"));
		}
        out.write(String.format("%s%n", "end"));

        out.write(String.format("%s%n", "CapacitorBusInfo"));
		for (Bus b : net.getBusList()) {
			AclfBus bus = (AclfBus) b;
			if (bus.isCapacitor())
				out.write(String.format("%8s %s %n", bus.getId(), ".19"));
		}
        out.write(String.format("%s%n", "end"));

        out.write(String.format("%s%n", "BranchInfo"));
		for (Branch b : net.getBranchList()) {
			AclfBranch branch = (AclfBranch) b;
			out.write(String.format("%8s %8s %s%n", branch.getFromBus().getId(), branch.getToBus().getId(),
					" .01938       .05917      .0264"));
		}
        out.write(String.format("%s%n", "end"));

        out.write(String.format("%s%n", "XformerInfo"));
		for (Branch b : net.getBranchList()) {
			AclfBranch branch = (AclfBranch) b;
			if (branch.isXfr())
				out.write(String.format("%8s %8s %s% n", branch.getFromBus().getId(), branch.getToBus().getId(),
						"1       .978"));
		}
        out.write(String.format("%s%n", "end"));

        out.write(String.format("%s%n", "EndOfFile"));
*/         
        return true;
    }
}