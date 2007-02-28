 /*
  * @(#)KundurP864_Common.java   
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

package org.interpss.sample.dstab;

/*
 * This sample will be a two bus system. 
 */

import java.util.Hashtable;
import java.util.logging.Level;

import org.apache.commons.math.complex.Complex;
import org.interpss.dstab.control.exc.simple.SimpleExciter;
import org.interpss.editor.EditorSpringAppContext;
import org.interpss.test.simu.dstab.controller.annotate.CustomAnnotateExciter;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Constants;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.msg.StdoutMsgListener;
import com.interpss.common.msg.TextMessage;
import com.interpss.common.util.IpssLogger;
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
import com.interpss.core.acsc.AcscBusFault;
import com.interpss.core.acsc.SimpleFaultCode;
import com.interpss.core.net.Area;
import com.interpss.core.net.Zone;
import com.interpss.dstab.DStabBranch;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.devent.DynamicEvent;
import com.interpss.dstab.devent.DynamicEventType;
import com.interpss.dstab.mach.EConstMachine;
import com.interpss.dstab.mach.Eq1Machine;
import com.interpss.dstab.mach.Machine;
import com.interpss.dstab.mach.MachineType;
import com.interpss.dstab.util.DStabOutFunc;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class KundurP864_Common {
	public static byte MsgOutLevel  = TextMessage.TYPE_WARN;
	
    public static String scripts = 
    	"var exciter = new Object();" +
    	"function getObjectName() { return 'exciter';}" +

    	"exciter.Ka = 50.0;" +
    	"exciter.Ta = 0.05;" +
    	"exciter.Vrmax = 10.0;" +
    	"exciter.Vrmin = 0.0;" +

    	"exciter.stateVref = 0.0;" +

    	"var ImportBlock = JavaImporter(com.interpss.dstab.controller.block," +
    	"                               com.interpss.dstab," +
    	"                               com.interpss.dstab.util);" +
    	"with (ImportBlock) {" +
    	"   exciter.controlBlock = new DelayControlBlock(IControlBlock.Type_Limit, exciter.Ka, exciter.Ta, exciter.Vrmax, exciter.Vrmin);" +

    	"   exciter.initStates = function(mach) {" +
		"      exciter.controlBlock.initState(mach.getEfd());" +
		"      var vt = mach.getMachineBus().getVoltage().abs() / mach.getVMultiFactor();" +
		"      exciter.stateVref = vt + exciter.controlBlock.getU0();" +
		"   };" +

    	"   exciter.calculateU = function(mach) {" +
    	"      var vt = mach.getMachineBus().getVoltage().abs() / mach.getVMultiFactor();" +
    	"      var vpss = 0.0;" +
    	"      if (mach.hasStabilizer()) {" +
    	"         vpss = mach.getStabilizer().getOutput();" +
    	"      };" +
    	"      return exciter.stateVref + vpss - vt;" +
    	"   };" +
    	
    	"   exciter.nextStep = function(mach, dt, method, baseFreq) {" +
		"      if (method == DynamicSimuMethods.MODIFIED_EULER_LITERAL) {" +
		"         var u = exciter.calculateU(mach);" +
		"         exciter.controlBlock.eulerStep1(u, dt);" +
		"         exciter.controlBlock.eulerStep2(u, dt);" +
		"      }" +
		"   };" +

		"   exciter.getOutput = function(mach) {" +
    	"      return exciter.controlBlock.getY(exciter.calculateU(mach));" +
    	"   };" +

    	"   exciter.getStates = function(mach, hashtable) {" +
    	"      hashtable.put(DStabOutFunc.OUT_SYMBOL_EXC_EFD, new java.lang.Double(exciter.getOutput(mach)));" +
    	"   };" +
    	
    	"   exciter.setRefPoint = function(x) {" +
    	"      exciter.stateVref = xt;" +
    	"   };" +
    	"}";
    
	public static void setUp(IPSSMsgHub msg) {
		String SpringConfigXmlFile = "c:/eclipse/InterpssDev/ipss.editor/properties/springConfig/editorAppContext.xml";
		SpringAppContext.SpringAppCtxConfigXmlFile = SpringConfigXmlFile;
		EditorSpringAppContext.springAppContextSetup();

		// Define a session message object to handle simulation session message
		try {
			msg.addMsgListener(new StdoutMsgListener(MsgOutLevel));
 		} catch (Exception e) {
 			msg.sendErrorMsg(e.toString());
		}
 		IpssLogger.getLogger().setLevel(Level.WARNING);
	}

	/**
	 *  The following case is from Kundur book P864
	 */
	public static DStabilityNetwork setNetworkData(IPSSMsgHub msg) {
		// Create a DStabNetwork object 
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.DSTABILITY_NET_LITERAL, msg);
		DStabilityNetwork net = simuCtx.getDStabilityNet();
		net.setAllowParallelBranch(true);

		// Create area and zone objects
		Area area = CoreObjectFactory.createArea(1, net);
		Zone zone = CoreObjectFactory.createZone(1, net);
		
		DStabBus bus1 = DStabObjectFactory.createDStabBus("LT", net);
		bus1.setName("LT Bus");
		bus1.setArea(area);
		bus1.setZone(zone);
		bus1.setBaseVoltage(24000);
		bus1.setGenCode(AclfGenCode.GEN_PQ_LITERAL);
		PQBusAdapter pqBus = (PQBusAdapter)bus1.adapt(PQBusAdapter.class);
		pqBus.setGen(new Complex(22.2*0.9, 22.2*0.436), UnitType.PU, net.getBaseKva());
		bus1.setLoadCode(AclfLoadCode.NON_LOAD_LITERAL);
		
		DStabBus bus2 = DStabObjectFactory.createDStabBus("HT", net);
		bus2.setName("HT Bus");
		bus2.setArea(area);
		bus2.setZone(zone);
		bus2.setBaseVoltage(500000);
		bus2.setGenCode(AclfGenCode.CAPACITOR_LITERAL);
		CapacitorBusAdapter capBus = (CapacitorBusAdapter)bus2.adapt(CapacitorBusAdapter.class);
		capBus.setQ(4.0, UnitType.PU, net.getBaseKva());
		bus2.setLoadCode(AclfLoadCode.CONST_P_LITERAL);
		LoadBusAdapter loadBus = (LoadBusAdapter)bus2.adapt(LoadBusAdapter.class);
		loadBus.setLoad(new Complex(10.0, 8.0), UnitType.PU, net.getBaseKva());
        
		DStabBus bus3 = DStabObjectFactory.createDStabBus("InfBus", net);
		bus3.setName("Inititive Bus");
		bus3.setArea(area);
		bus3.setZone(zone);
		bus3.setBaseVoltage(500000);
		bus3.setGenCode(AclfGenCode.SWING_LITERAL);
		SwingBusAdapter swing = (SwingBusAdapter)bus3.adapt(SwingBusAdapter.class);
		swing.setVoltMag(0.90081, UnitType.PU);
		swing.setVoltAng(0.0, UnitType.Deg);
		bus3.setLoadCode(AclfLoadCode.NON_LOAD_LITERAL);

		DStabBranch branch1 = DStabObjectFactory.createDStabBranch("LT", "HT", net);
		branch1.setName("Branch1");
		branch1.setArea(area);
		branch1.setZone(zone);
		branch1.setBranchCode(AclfBranchCode.XFORMER_LITERAL);
		XfrAdapter xfr = (XfrAdapter)branch1.adapt(XfrAdapter.class);	
		xfr.setZ(new Complex(0.0, 0.15/22.2), UnitType.PU, 1.0, 1.0, msg);  
				// when z unit = PU, base volt and base Kva are not needed
		
		DStabBranch branch2 = DStabObjectFactory.createDStabBranch("HT", "InfBus", net);
		branch2.setName("Branch2");
		branch2.setArea(area);
		branch2.setZone(zone);
		branch2.setBranchCode(AclfBranchCode.LINE_LITERAL);
		LineAdapter line2 = (LineAdapter)branch2.adapt(LineAdapter.class);
		line2.setZ(new Complex(0.0, 0.5/22.2), UnitType.PU, 1.0, 1.0, msg);

		DStabBranch branch3 = DStabObjectFactory.createDStabBranch("HT", "InfBus", net);
		branch3.setName("Branch1");
		branch3.setArea(area);
		branch3.setZone(zone);
		branch3.setBranchCode(AclfBranchCode.LINE_LITERAL);
		LineAdapter line3 = (LineAdapter)branch3.adapt(LineAdapter.class);			
		line3.setZ(new Complex(0.0, 0.93/22.2), UnitType.PU, 1.0, 1.0, msg);
		return net;
	}

	public static void addDSimuData(DStabilityNetwork net, IPSSMsgHub msg) {
		// create and define the first machine object
		Eq1Machine mach1 = (Eq1Machine)DStabObjectFactory.
						createMachine("LT", "Mach1", MachineType.EQ1_MODEL_LITERAL, net, "LT");
		if (!mach1.getDStabBus().getId().equals("LT"))
			System.out.println("*** Something is worng");
		if (net.getDStabBus("LT").getMachine() == null)
			System.out.println("**** Something is worng");

		// set gen data
		mach1.setRating(2220, "Mva", net.getBaseKva());
		mach1.setRatedVoltage(24000.0);
		mach1.setMultiFactors(mach1.getMachineBus());
		mach1.setH(3.5);
		mach1.setPoles(2);
		mach1.setXd(1.81);
		mach1.setXq(1.76);
		mach1.setXl(0.14);
		mach1.setRa(0.0);
		mach1.setXd1(0.30);
		mach1.setTd01(8.0);
		mach1.setSliner(2.0);  // no saturation
		mach1.setS100(1.0);
		mach1.setS120(1.0);
		System.out.println("MachineData: " + mach1.getMachData());
		
		// create and define a machine object on Gen2
		EConstMachine mach2 = DStabObjectFactory.createInfiniteMachine("InfBus", "Mach2", net, "InfBus");
		System.out.println("MachineData: " + mach2.getMachData());
	}
	
	public static void addControllerData(DStabilityNetwork net, IPSSMsgHub msg) {
/*
		SimpleExciter exc1 = new SimpleExciter("LT", "Exc1", "InterPSS");
		exc1.getData().setKa(50.0);
		exc1.getData().setTa(0.05);
		exc1.getData().setVrmax(10.0);
		exc1.getData().setVrmin(0.0);
		System.out.println("ExcData: " + exc1.getDataXmlString());
*/		
		CustomAnnotateExciter exc1 = new CustomAnnotateExciter();
		exc1.k = 50.0;
		exc1.t = 0.05;
		exc1.vmax = 10.0;
		exc1.vmin = 0.0;
		//System.out.println("ExcData: " + exc1.toString());

		Machine mach1 = net.getMachine("LT");
		mach1.addExciter(exc1);
/*
		SimpleStabilizer pss1 = new SimpleStabilizer("LT", "PSS1", "InterPSS");
		pss1.getData().setKs(1.0);
		pss1.getData().setT1(0.05);
		pss1.getData().setT2(0.5);
		pss1.getData().setT3(0.05);
		pss1.getData().setT4(0.25);
		pss1.getData().setVsmax(0.2);
		pss1.getData().setVsmin(-0.2);
		System.out.println("PSSData: " + pss1.getDataXmlString());

		SimpleGovernor gov1 = new SimpleGovernor("LT", "Gov1", "InterPSS");
		gov1.getData().setK(10.0);
		gov1.getData().setT1(0.5);
		gov1.getData().setPmax(1.2);
		gov1.getData().setPmin(0.0);
		System.out.println("GovData: " + gov1.getDataXmlString());
*/
	}

	public static void addDEnventData(DStabilityNetwork net, IPSSMsgHub msg) {
		// define a bus fault event
		DynamicEvent event1 = DStabObjectFactory.createDEvent("event1", "Bus Fault at Bus2", DynamicEventType.BUS_FAULT_LITERAL, net, msg);
		event1.setStartTimeSec(0.1);
		event1.setDurationSec(0.1);
		
		DStabBus faultBus = net.getDStabBus("HT");
		AcscBusFault fault = CoreObjectFactory.createAcscBusFault("Bus Fault at HT" );
  		fault.setAcscBus(faultBus);
		fault.setFaultCode(SimpleFaultCode.GROUND_3P_LITERAL);
		fault.setZLGFault(Constants.SmallScZ);
		fault.setZLLFault(new Complex(0.0, 0.0));
		event1.setBusFault(fault);		
	}
	
	public static void outputSimuResults(DStabBus abus, Machine refMach, double t, double dt) {
		Hashtable states = abus.getMachine().getStates(abus, refMach);
		states.put(DStabOutFunc.OUT_SYMBOL_MACH_ID, abus.getMachine().getId());
		states.put(DStabOutFunc.OUT_SYMBOL_TIME, new Double(t+dt));
		try{
			System.out.print(DStabOutFunc.getStateStr(states));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 }
