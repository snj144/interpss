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

package funcTest.dstab.exc;

import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DStabilityNetwork;
import funcTest.dstab.common.simpleSMIB;
import funcTest.dstab.common.RunCaseBase;

public class NoFaultRunMEExciter extends RunCaseBase {
    
    public static void main(String[] args) {
        setUp();
        
        // Create a 3-bus network, see Kunder's book page-846. There are three buses
        // in the system: 'LT', 'HT' and 'InfBus'
        DStabilityNetwork net = simpleSMIB.createSimulationNetwork(msg);
        
        // Set machine data: Machine at 'LT' is with the Eq1 model. 
        // Machine at 'InfBus' is an infinite bus
        simpleSMIB.addDSimuData(net, msg);
        
        // Create an MEExciter object
        custom.dstab.exc.st5b.st5bExciter exc = new custom.dstab.exc.st5b.st5bExciter();
        exc.getData().setKc(0.06);
        exc.getData().setKr(300.0);
        exc.getData().setT1(0.003);
        exc.getData().setTb1(0.350);
        exc.getData().setTb2(0.020);
        exc.getData().setTc1(2.0);
        exc.getData().setTc2(10.0);
        exc.getData().setTob1(0.35);
        exc.getData().setTob2(0.02);
        exc.getData().setToc1(2.0);
        exc.getData().setToc2(10.0);
        exc.getData().setTub1(2.0);
        exc.getData().setTub2(0.0);
        exc.getData().setTuc1(10.0);
        exc.getData().setTuc2(0.02);
        exc.getData().setVrmax(10.0);
        exc.getData().setVrmin(-0.85);
        
        // add exciter to the machine G1
        DStabBus bus = net.getDStabBus("G1bus");
        bus.getMachine().addExciter(exc);
                
        // run loadflow
        runLoadflow(net, msg);
        
        // Initial system for transient stability simulaiton.
        net.initialization(msg);
        System.out.println(net.net2String());
        
        double totalTime = 1.0;
        double dt = 0.005;
        
        // Perform transent stability simulation. 
        // You can use [Output_Default, Output_Mach_Angle, Output_Exc_Efd, Output_Gov_Pm, Output_Pss_Vpss] for the output type
        runDStabSimulation(net, msg, totalTime, dt, Output_Default);
    }
    
}
