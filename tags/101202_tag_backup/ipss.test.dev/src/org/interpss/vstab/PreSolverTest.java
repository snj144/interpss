package org.interpss.vstab;

import static org.junit.Assert.assertTrue;

import org.interpss.BaseTestSetup;
import org.interpss.vstab.cpf.CPFAlgorithm;
import org.interpss.vstab.cpf.impl.PredictorStepSolver;
import org.junit.Test;

import com.interpss.common.CoreCommonSpringCtx;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.util.sample.SampleCases;

public class PreSolverTest extends BaseTestSetup {
	@Test
	public void testCase1() {
    IPSSMsgHub msg = CoreCommonSpringCtx.getIpssMsgHub();
	
	// create a sample 5-bus system for Loadflow 
	AclfNetwork net = CoreObjectFactory.createAclfNetwork();
	SampleCases.load_LF_5BusSystem(net, msg);
	
	
	// run Loadflow analysis of the base case
	LoadflowAlgorithm algo =CoreObjectFactory.createLoadflowAlgorithm(msg);
	net.accept(algo);
//	System.out.println(net.net2String());
	// Loadflow alreagy run, commnted out by mike
	//algo.loadflow(); // load flow to create a study base case
	
	//LambdaParam lambda=new LambdaParam(net.getNoBus()+1,1);
	
	CPFAlgorithm cpfAlgo = VStabObjectFactory.createCPFAlgorithmImpl(net, msg);
	assertTrue(cpfAlgo.getSortNumOfContParam()==6);
	PredictorStepSolver preSolver=cpfAlgo.getPreStepSolver();
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
