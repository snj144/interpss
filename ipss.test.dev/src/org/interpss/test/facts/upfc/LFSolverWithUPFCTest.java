package org.interpss.test.facts.upfc;

import static org.junit.Assert.*;

import org.apache.commons.math.complex.Complex;
import org.interpss.facts.upfc.LFSolverWithUPFC;
import org.interpss.facts.upfc.UPFCControlType;
import org.interpss.facts.upfc.UPFCLF;
import org.interpss.test.DevTestSetup;
import org.junit.Test;

import com.interpss.common.datatype.UnitType;
import com.interpss.common.exp.InterpssException;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfGenCode;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclf.adpter.SwingBusAdapter;
import com.interpss.core.algo.LoadflowAlgorithm;

public class LFSolverWithUPFCTest extends DevTestSetup {

	@Test
	public void testConstPQSimple() throws InterpssException {
		AclfNetwork net = createNet();
        LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
        algo.loadflow();
		
        String branchID = net.getBranch("Bus1", "Bus2").getId();
        double tunedP = net.getAclfBranch(branchID).powerTo2From().getReal();
        double tunedQ = net.getAclfBranch(branchID).powerTo2From().getImaginary();
        double tunedV = net.getAclfBus("Bus1").getVoltageMag();
        System.out.println("Power flow before control: pji=" + tunedP + ", qji=" + tunedQ);
        UPFCLF myUPFC = new UPFCLF(branchID, true, new Complex(0.0, -5.0), new Complex(0.0, -5.0), UPFCControlType.ActiveAndReactivePowerFlow, tunedP * 0.95, tunedQ * 0.95, tunedV, net);
        UPFCLF[] upfcArray = {myUPFC};
        LFSolverWithUPFC solver = new LFSolverWithUPFC(net, upfcArray);
        
        // output loadflow calculation results
        assertTrue(solver.solveLF());
        assertTrue(Math.abs(myUPFC.getSsh(net).getReal()) < 0.0001);
        assertTrue(Math.abs(myUPFC.getSerialSji(net).getReal() - tunedP * 0.95) < 0.0001);
        assertTrue(Math.abs(myUPFC.getSerialSji(net).getImaginary() - tunedQ * 0.95) < 0.0001);
	}
	
	private static AclfNetwork createNet() {
        // create a sample 5-bus system for Loadflow
        AclfNetwork net = CoreObjectFactory.createAclfNetwork();
        double basekVA = 100000.0;
        net.setBaseKva(basekVA);
        AclfBus bus0 = CoreObjectFactory.createAclfBus("Bus0", net);
        // set bus name and description attributes
        bus0.setAttributes("Bus 0", "");
        // set bus base voltage
        bus0.setBaseVoltage(4000.0);
        // set bus to be a swing bus
        bus0.setGenCode(AclfGenCode.SWING);
        // adapt the bus object to a swing bus object
        SwingBusAdapter swingBus = bus0.toSwingBus();
        // set swing bus attributes
        swingBus.setVoltMag(1.0, UnitType.PU);
        swingBus.setVoltAng(0.0, UnitType.Deg);
        // add the bus into the network
        //net.addBus(bus1);
        
        AclfBus bus1 = CoreObjectFactory.createAclfBus("Bus1", net);
        // set bus name and description attributes
        bus1.setAttributes("Bus 1", "");
        // set bus base voltage
        bus1.setBaseVoltage(4000.0);
        bus1.setLoadCode(AclfLoadCode.CONST_P);
        bus1.setLoadP(0.2);
        bus1.setLoadQ(0.1);

        AclfBus bus2 = CoreObjectFactory.createAclfBus("Bus2", net);
        bus2.setAttributes("Bus 2", "");
        bus2.setBaseVoltage(4000.0);
        bus2.setLoadCode(AclfLoadCode.CONST_P);
        bus2.setLoadP(1.0);
        bus2.setLoadQ(0.8);

        // create first AclfBranch object
        AclfBranch branch1 = CoreObjectFactory.createAclfBranch();
        // set branch name, description and circuit number
        branch1.setAttributes("Branch 1", "", "1");
        // set branch parameters
        branch1.setZ(new Complex(0.0, 0.1));
        // add the branch from Bus1 to Bus2
        net.addBranch(branch1, "Bus0", "Bus1");
        
        // create second AclfBranch object
        AclfBranch branch2 = CoreObjectFactory.createAclfBranch();
        // set branch name, description and circuit number
        branch2.setAttributes("Branch 1", "", "1");
        // set branch parameters
        branch2.setZ(new Complex(0.0, 0.1));
        // add the branch from Bus1 to Bus2
        net.addBranch(branch2, "Bus1", "Bus2");
        
        return net;
	}

}