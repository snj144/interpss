package org.interpss.vstab;

import static org.junit.Assert.assertTrue;

import org.interpss.BaseTestSetup;
import org.interpss.vstab.cpf.CPFAlgorithm;
import org.interpss.vstab.cpf.impl.CPFAlgorithmImpl;
import org.interpss.vstab.cpf.impl.LambdaParam;
import org.interpss.vstab.cpf.impl.PredictorStepSolver;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.util.sample.SampleCases;

public class PreSolverTest extends BaseTestSetup {
	@Test
	public void testCase1() {
    IPSSMsgHub msg = SpringAppContext.getIpssMsgHub();
	
	// create a sample 5-bus system for Loadflow 
	AclfNetwork net = CoreObjectFactory.createAclfNetwork();
	SampleCases.load_LF_5BusSystem(net, msg);
	System.out.println(net.net2String());
	
	// run Loadflow analysis of the base case
	LoadflowAlgorithm algo =CoreObjectFactory.createLoadflowAlgorithm(msg);
	net.accept(algo);
	// Loadflow alreagy run, commnted out by mike
	//algo.loadflow(); // load flow to create a study base case
	
	LambdaParam lambda=new LambdaParam(net.getNoBus()+1,1);
	CPFAlgorithm cpf=new CPFAlgorithmImpl(net,lambda,msg);
	PredictorStepSolver preSolver=cpf.createPreStepSolver();
	preSolver.stepSolver();
	assertTrue((preSolver.getAugmentedJacobi().getElement(3, 6).xx-1.60)<1e-9);// bus1.loadP=1.60
	assertTrue((preSolver.getDeltaXLambda().getEntry(0)-(-0.73935))<0.0001);
	assertTrue((preSolver.getDeltaXLambda().getEntry(10)-1.0)<1e-9); // Delta_Lambda=1
	
	// print J-matrix
//    VstabFuncOut.printJmatix(preSolver.getAugmentedJacobi(),6,2);
    // print tangent vector
//    VstabFuncOut.printRealVector(preSolver.getDeltaXLambda());
	}
}
