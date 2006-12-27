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

import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.datatype.DStabSimuTimeEvent;
import com.interpss.dstab.mach.Machine;
import com.interpss.dstab.util.DStabOutFunc;
import com.interpss.dstab.util.DynamicEventProcessor;
import java.util.Iterator;

public class NoFaultRun extends RunCaseBase {
    
    public static void main(String[] args) {
        setUp();
        
        // create an SMIB network
        DStabilityNetwork net = simpleSMIB.createSimulationNetwork(msg);
        
        // set machine data
        simpleSMIB.addDSimuData(net, msg);
        
        // run loadflow
        runLoadflow(net, msg);
        
        
        // initial bus sc data, transfer machine sc info to bus.
        net.initialization(msg);
        //System.out.println(net.net2String());
        
        double totalTime = 1.0;
        double dt = 0.005;
        
        runDStabSimulation(net, msg, totalTime, dt, Output_Default);
    }
    
}
