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

import com.interpss.common.datatype.Constants;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.msg.StdoutMsgListener;
import com.interpss.common.msg.TextMessage;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.Num2Str;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.acsc.AcscBusFault;
import com.interpss.core.acsc.SimpleFaultCode;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.datatype.DStabSimuTimeEvent;
import com.interpss.dstab.devent.DynamicEvent;
import com.interpss.dstab.devent.DynamicEventType;
import com.interpss.dstab.mach.ControllerType;
import com.interpss.dstab.mach.Machine;
import com.interpss.dstab.util.DStabOutFunc;
import com.interpss.dstab.util.DynamicEventProcessor;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.logging.Level;
import org.apache.commons.math.complex.Complex;

public class RunCaseBase {
    public static byte MsgOutLevel  = TextMessage.TYPE_WARN;

    public static byte Output_Default       = 1;
    public static byte Output_Mach_Angle    = 2;
    public static byte Output_Exc_Efd       = 3;
    public static byte Output_Gov_Pm        = 4;
    public static byte Output_Pss_Vpss      = 5;
    
    protected static IPSSMsgHub msg;
    
    public static void setUp() {
        msg = new IPSSMsgHub();
        try {
            msg.addMsgListener(new StdoutMsgListener(MsgOutLevel));
        } catch (Exception e) {
            msg.sendErrorMsg(e.toString());
        }
        IpssLogger.getLogger().setLevel(Level.WARNING);
    }
    
    public static void outputSimuResults(Machine mach, Machine refMach, double t, double dt, byte outType) {
        Hashtable states = mach.getStates(mach.getMachineBus(), refMach);
        if (outType == Output_Default) {
            states.put(DStabOutFunc.OUT_SYMBOL_MACH_ID, mach.getId());
            states.put(DStabOutFunc.OUT_SYMBOL_TIME, new Double(t+dt));
            try{
                System.out.print(DStabOutFunc.getStateStr(states));
            } catch (Exception e) {}
        }
        else {
            String str = Num2Str.toStr("00.000", t+dt) + " ";
            double x = 0.0;
            if (outType == Output_Mach_Angle)
                x = ((Double)states.get(DStabOutFunc.OUT_SYMBOL_MACH_ANG));
            else if (outType == Output_Exc_Efd) {
                Hashtable excStates = 	(Hashtable)states.get(ControllerType.EXCITER_LITERAL);
//                x = ((Double)excStates.get(DStabOutFunc.OUT_SYMBOL_EXC_EFD));
                excStates.put(DStabOutFunc.OUT_SYMBOL_TIME, new Double(t+dt));
                System.out.println(excStates);
            }
            else if (outType == Output_Gov_Pm)
                x = ((Double)states.get(DStabOutFunc.OUT_SYMBOL_MACH_PM));
            else if (outType == Output_Pss_Vpss) {
                Hashtable pssStates = 	(Hashtable)states.get(ControllerType.STABILIZER_LITERAL);
                x = ((Double)pssStates.get(DStabOutFunc.OUT_SYMBOL_PSS_VS));
            }
            str += Num2Str.toStr(10, Num2Str.toStr("0.0000", x));
//            System.out.println(str);
        }
    }
    
    public static void runLoadflow(AclfNetwork net, IPSSMsgHub msg) {
        // run loadflow
        LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
        algo.setLfMethod(AclfMethod.PQ_LITERAL);
        algo.setMaxIterations(20);
        algo.setTolerance(0.0001);
        algo.loadflow(msg);
        if (!net.isLfConverged()) {
            System.out.println("Loadflow diverged");
            System.exit(0);
        }
    }
    
    public static void addBusFaultDEnventData(DStabilityNetwork net, IPSSMsgHub msg) {
        // define a bus fault event
        DynamicEvent event1 = DStabObjectFactory.createDEvent("event1", "Bus Fault at Bus2", DynamicEventType.BUS_FAULT_LITERAL, net, msg);
        event1.setStartTimeSec(1.0);
        event1.setDurationSec(0.175);
        
        DStabBus faultBus = net.getDStabBus("Common220");
        AcscBusFault fault = CoreObjectFactory.createAcscBusFault("Bus Fault at station 220kV Bus" );
        fault.setAcscBus(faultBus);
        fault.setFaultCode(SimpleFaultCode.GROUND_3P_LITERAL);
        fault.setZLGFault(Constants.SmallScZ);
        fault.setZLLFault(new Complex(0.0, 0.0));
        event1.setBusFault(fault);
    }
    
    public static void runDStabSimulation(DStabilityNetwork net, IPSSMsgHub msg, double totalTime, double dt, byte outType) {
        if (outType == Output_Default)
            System.out.println(DStabOutFunc.getStateTitleStr());
        else {
            String str = "";
            if (outType == Output_Mach_Angle)
                str = "  Angle";
            else if (outType == Output_Mach_Angle)
                str = "  Angle";
            else if (outType == Output_Exc_Efd)
                str = "   Efd";
            else if (outType == Output_Gov_Pm)
                str = "   Pm";
            else if (outType == Output_Pss_Vpss)
                str = "  Vpss";
            System.out.println("Time    " + str);
            System.out.println("-----   ----------");
        }

        DynamicEventProcessor handler = new DynamicEventProcessor(msg);

        Machine refMach = net.getMachine("InfBus");
        //Machine refMach = null;
        
        double t = 0.0;
        outputSimuResults(net.getMachine("G1bus"), refMach, t-dt, dt, outType);

        while (t <= totalTime) {
            handler.onMsgEventStatus(new DStabSimuTimeEvent(DStabSimuTimeEvent.ProessDynamicEvent, net, t));
            
            for (Iterator itr = net.getDBusDeviceList().iterator(); itr.hasNext(); ) {
                Machine mach = (Machine)itr.next();
                
                // solve DEqn for the step. This includes all controller's nextStep() call
                mach.nextStep(dt, DynamicSimuMethods.MODIFIED_EULER_LITERAL, mach.getDStabBus(), net, msg);
                
                
                if (mach.getId().equals("G1bus"))
                    outputSimuResults(mach, refMach, t, dt, outType);
            }
            net.solveNetEqn(false, msg);
            t += dt;
        }
    }
}
