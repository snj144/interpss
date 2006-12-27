 /*
  * @(#)CalculationException.java   
  *
  * Copyright (C) 2006 www.interpss.com
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
  * @Author Ron Oosterwijk
  * @Version 1.0
  * @Date Dec 2006
  * 
  *   Revision History
  *   ================
  *
  */

package funcTest.dstab.common;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBranchCode;
import com.interpss.core.aclf.AclfGenCode;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.CapacitorBusAdapter;
import com.interpss.core.aclf.LineAdapter;
import com.interpss.core.aclf.LoadBusAdapter;
import com.interpss.core.aclf.PQBusAdapter;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.aclf.XfrAdapter;
import com.interpss.core.net.Area;
import com.interpss.core.net.Zone;
import com.interpss.dstab.DStabBranch;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.mach.EConstMachine;
import com.interpss.dstab.mach.Eq1Machine;
import com.interpss.dstab.mach.RoundRotorMachine;
import com.interpss.dstab.mach.MachineType;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;
import org.apache.commons.math.complex.Complex;

public class simpleSMIB {
    /**
     *  The following case is simple SMIB for testing exciters in proj.crm
     */
    public static DStabilityNetwork createSimulationNetwork(IPSSMsgHub msg) {
        // Create a DStabNetwork object
        SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.DSTABILITY_NET_LITERAL, msg);
        DStabilityNetwork net = simuCtx.getDStabilityNet();
        net.setAllowParallelBranch(true);
        
        // Create area and zone objects
        Area area = CoreObjectFactory.createArea(1, net);
        Zone zone = CoreObjectFactory.createZone(1, net);
        
        DStabBus bus1 = DStabObjectFactory.createDStabBus("G1bus", net);
        bus1.setName("G1 20kV Bus");
        bus1.setArea(area);
        bus1.setZone(zone);
        bus1.setBaseVoltage(20000);
        bus1.setGenCode(AclfGenCode.GEN_PQ_LITERAL);
        PQBusAdapter pqBus = (PQBusAdapter)bus1.adapt(PQBusAdapter.class);
        pqBus.setGen(new Complex(3.89*0.8, 3.89*0.10), UnitType.PU, net.getBaseKva());
        bus1.setLoadCode(AclfLoadCode.NON_LOAD_LITERAL);
        
        DStabBus bus2 = DStabObjectFactory.createDStabBus("Common220", net);
        bus2.setName("Station 220kV Bus");
        bus2.setArea(area);
        bus2.setZone(zone);
        bus2.setBaseVoltage(220000);
        bus2.setGenCode(AclfGenCode.NON_GEN_LITERAL);
        bus2.setLoadCode(AclfLoadCode.NON_LOAD_LITERAL);
                
        DStabBus bus3 = DStabObjectFactory.createDStabBus("InfBus", net);
        bus3.setName("Infinite Bus");
        bus3.setArea(area);
        bus3.setZone(zone);
        bus3.setBaseVoltage(220000);
        bus3.setGenCode(AclfGenCode.SWING_LITERAL);
        SwingBusAdapter swing = (SwingBusAdapter)bus3.adapt(SwingBusAdapter.class);
        swing.setVoltMag(1.0, UnitType.PU);
        swing.setVoltAng(0.0, UnitType.Deg);
        bus3.setLoadCode(AclfLoadCode.NON_LOAD_LITERAL);
        
        DStabBranch branch1 = DStabObjectFactory.createDStabBranch("G1bus", "Common220", net);
        branch1.setName("T1");
        branch1.setArea(area);
        branch1.setZone(zone);
        branch1.setBranchCode(AclfBranchCode.XFORMER_LITERAL);
        XfrAdapter xfr = (XfrAdapter)branch1.adapt(XfrAdapter.class);
        xfr.setZ(new Complex(0.0025/3.89, 0.1264/3.89), UnitType.PU, 1.0, 1.0, msg);
        // when z unit = PU, base volt and base Kva are not needed
        
        DStabBranch branch2 = DStabObjectFactory.createDStabBranch("Common220", "InfBus", net);
        branch2.setName("CCT1");
        branch2.setArea(area);
        branch2.setZone(zone);
        branch2.setBranchCode(AclfBranchCode.LINE_LITERAL);
        LineAdapter line1 = (LineAdapter)branch2.adapt(LineAdapter.class);
        line1.setZ(new Complex(0.0145/3.89, 0.0666/3.89), UnitType.PU, 1.0, 1.0, msg);
        
        return net;
    }
    
    public static void addDSimuData(DStabilityNetwork net, IPSSMsgHub msg) {
        // create and define the first machine object
        RoundRotorMachine mach1 = (RoundRotorMachine)DStabObjectFactory.
                createMachine("G1bus", "Mach1", MachineType.EQ11_ED11_ROUND_ROTOR_LITERAL, net, "G1bus");
        
        // set gen data
        mach1.setRating(389, "Mva", net.getBaseKva());
        mach1.setRatedVoltage(20000.0);
        mach1.setMultiFactors();
        mach1.setPoles(2);
        mach1.setH(3.28);
        mach1.setXd(1.98);
        mach1.setXd1(0.264);
        mach1.setXd11(0.215);
        mach1.setXq(1.92);
        mach1.setXq1(0.45);
        mach1.setXq11(0.215);
        mach1.setXl(0.15);
        mach1.setRa(0.0024);
        mach1.setTd01(7.3);
        mach1.setTd011(0.037);
        mach1.setTq01(1.4);
        mach1.setTq011(0.056);
        mach1.setSliner(2.0);  // no saturation
        mach1.setS100(1.0);
        mach1.setS120(1.0);
        //System.out.println("MachineData: " + mach1.getMachData());
        
        // create and define a machine object on Gen2
        EConstMachine mach2 = DStabObjectFactory.createInfiniteMachine("InfBus", "Mach2", net, "InfBus");
        //System.out.println("MachineData: " + mach2.getMachData());
    }

}
