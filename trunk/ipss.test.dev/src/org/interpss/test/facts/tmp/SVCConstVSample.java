package org.interpss.test.facts.tmp;

import org.interpss.facts.SVCNrSolver;
import org.interpss.facts.dep.SVCConstVControl;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;


public class SVCConstVSample {
	
    private double vc;  // Fixed voltage
    private AclfNetwork net;    // Power network
    private String busID;   // Location of the SVC
    
    public double getVc() {
        return vc;
    }
    
    public AclfNetwork getNet() {
        return net;
    }
    
    public SVCConstVSample(double vc, AclfNetwork net, String busID) {
        this.vc = vc;
        this.net = net;
        this.busID = busID;
    }
    
    // Customize the loadflow algorithm to realize the control objective
    public void createLoadflowAlgorithm(IPSSMsgHub msg) {
    	AclfBus bus = net.getAclfBus(busID);
    	int n = net.getNoBus();
    	
    	double gsh = 0.0, bsh = 1.0;
    	
    	SVCConstVControl svc = new SVCConstVControl(bus, n+1, this.vc, gsh, bsh);
        // create a Loadflow algo object
        LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm();
        
        // set algo NR solver to the CustomNrSolver
        SVCConstVControl[] svcAry = {svc};
        algo.setNrSolver(new SVCNrSolver(net, svcAry));

        // run Loadflow
        net.accept(algo);
        
        System.out.println("Solve the load flow with SVC successfully at " + busID + "!");
    }
}
