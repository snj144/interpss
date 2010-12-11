package org.interpss.test.facts;

import org.apache.commons.math.complex.Complex;
import org.interpss.display.AclfOutFunc;
import org.interpss.facts.SVCControl;
import org.interpss.facts.SVCControlType;
import org.interpss.facts.SVCNrSolver;
import org.interpss.test.DevTestSetup;
import org.junit.Test;

import com.interpss.common.datatype.UnitType;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfGenCode;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclf.adpter.LoadBusAdapter;
import com.interpss.core.aclf.adpter.SwingBusAdapter;
import com.interpss.core.algorithm.LoadflowAlgorithm;

public class SimpleSVCTest extends DevTestSetup { 
	@Test
	public void testCase() {
		AclfNetwork net = createNet();
		
        AclfBus bus = net.getAclfBus("Bus2");
        SVCControl svc = new SVCControl(bus, net.getNoBus()+1, SVCControlType.ConstB);
        svc.setQc(0.05);
        svc.setYsh(0.0, -5.0);

        // set svc as AclfBus extension
        bus.setExtensionObject(svc);
        
        SVCControl[] svcArray = {svc};
        SVCNrSolver svcNrSolver = new SVCNrSolver(net, svcArray);
        
        // create a Loadflow algo object
        LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm();
        // set algo NR solver to the CustomNrSolver
        algo.setNrSolver(svcNrSolver);

        // run Loadflow
        net.accept(algo);
        // output loadflow calculation results
        System.out.println(AclfOutFunc.loadFlowSummary(net));
        Complex vic = new Complex(bus.getVoltageMag() * Math.cos(bus.getVoltageAng()), bus.getVoltageMag() * Math.sin(bus.getVoltageAng()));
        Complex vshc = new Complex(svc.getVsh() * Math.cos(svc.getThedash()), svc.getVsh() * Math.sin(svc.getThedash()));
        Complex yshc = new Complex(0.0, -5.0);
        Complex yc = (vic.subtract(vshc)).multiply(yshc).divide(vic);
        
        System.out.println("yshunt=(" + yc.getReal() + ")+i(" + yc.getImaginary() + ")");
        System.out.println("Vsh, Thedash: " + svc.getVsh() + ", " + svc.getThedash());	
	}
	
	public static AclfNetwork createNet() {
        // create a sample 5-bus system for Loadflow
        AclfNetwork net = CoreObjectFactory.createAclfNetwork();
        double basekVA = 100000.0;
        net.setBaseKva(basekVA);
        AclfBus bus1 = CoreObjectFactory.createAclfBus("Bus1", net);
        // set bus name and description attributes
        bus1.setAttributes("Bus 1", "");
        // set bus base voltage
        bus1.setBaseVoltage(4000.0);
        // set bus to be a swing bus
        bus1.setGenCode(AclfGenCode.SWING);
        // adapt the bus object to a swing bus object
        SwingBusAdapter swingBus = bus1.toSwingBus();
        // set swing bus attributes
        swingBus.setVoltMag(1.0, UnitType.PU);
        swingBus.setVoltAng(0.0, UnitType.Deg);
        // add the bus into the network
        //net.addBus(bus1);

        AclfBus bus2 = CoreObjectFactory.createAclfBus("Bus2", net);
        bus2.setAttributes("Bus 2", "");
        bus2.setBaseVoltage(4000.0);
        // set the bus to a non-generator bus
        bus2.setGenCode(AclfGenCode.NON_GEN);
        // set the bus to a constant power load bus
        bus2.setLoadCode(AclfLoadCode.CONST_P);
//        bus2.setVoltageMag(1.05);
        // adapt the bus object to a Load bus object
        LoadBusAdapter loadBus = bus2.toLoadBus();
        // set load to the bus
        loadBus.setLoad(new Complex(1.0, 0.8), UnitType.PU);
        //net.addBus(bus2);

        // create an AclfBranch object
        AclfBranch branch = CoreObjectFactory.createAclfBranch();
        // set branch name, description and circuit number
        branch.setAttributes("Branch 1", "", "1");
        // set branch parameters
        branch.setZ(new Complex(0.0, 0.1));
//        lineBranch.setZ(new Complex(0.05, 0.1), UnitType.PU, 4000.0, msg);
        // add the branch from Bus1 to Bus2
        net.addBranch(branch, "Bus1", "Bus2");
        
        return net;
	}
}

