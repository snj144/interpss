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

public class SPChangeRunMEExciter extends RunCaseBase {
    
    public static void main(String[] args) {
        setUp();
        
        // Create a 3-bus network, see Kunder's book page-846. There are three buses
        // in the system: 'LT', 'HT' and 'InfBus'
        DStabilityNetwork net = simpleSMIB.createSimulationNetwork(msg);
        
        // Set machine data: Machine at 'LT' is with the round rotor model. 
        // Machine at 'InfBus' is an infinite bus
        simpleSMIB.addDSimuData(net, msg);
        
        // Create an MEExciter object
        custom.dstab.exc.st5b.st5bExciter exc = new custom.dstab.exc.st5b.st5bExciter();
        // input conditioning
        exc.getData().setTr(0.020);
        exc.getData().setKir(-0.050);
        exc.getData().setKia(0.020);
        // voltage regulator
        exc.getData().setTb1(10.00);
        exc.getData().setTc1(2.0);
        exc.getData().setTc2(0.100);
        exc.getData().setTb2(0.050);
        exc.getData().setVrmax(10.0);
        exc.getData().setVrmin(-0.850);
        // uel regulator
        exc.getData().setTub1(10.0);
        exc.getData().setTuc1(2.0);
        exc.getData().setTuc2(0.100);
        exc.getData().setTub2(0.050);
        // oel regulator
        exc.getData().setTob1(10.0);
        exc.getData().setToc1(2.0);
        exc.getData().setToc2(0.100);
        exc.getData().setTob2(0.050);
        // regulator gain and gcu
        exc.getData().setKr(300.0);
        exc.getData().setT1(0.003);
        // rotating exciter
        exc.getData().setK3(4.0);
        exc.getData().setT3(0.011);
        exc.getData().setV3max(10.0);
        exc.getData().setV3min(-8.0);
        exc.getData().setK4(2.9);
        exc.getData().setT4(0.90);
        exc.getData().setKif(1.90);
        exc.getData().setVfdmax(7.0);
        exc.getData().setVfdmin(0.0);
        exc.getData().setKvf(0.75);
        
        // add exciter to the machine G1
        DStabBus bus = net.getDStabBus("G1bus");
        bus.getMachine().addExciter(exc);
                
        // run loadflow
        runLoadflow(net, msg);
        
        // Initial system for transient stability simulaiton.
        net.initialization(msg);
        //System.out.println(net.net2String());
        
        // Setpoint change 
        double v = exc.getRefPoint() + 0.05;
        exc.setRefPoint(v);
        
        double totalTime = 15.0;
        double dt = 0.002;
        
        // Perform transent stability simulation. 
        // You can use [Output_Default, Output_Mach_Angle, Output_Exc_Efd, Output_Gov_Pm, Output_Pss_Vpss] for the output type
        runDStabSimulation(net, msg, totalTime, dt, Output_Exc_Efd);
    }
    
}
