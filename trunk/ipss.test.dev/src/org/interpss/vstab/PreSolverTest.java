package org.interpss.vstab;

import static org.junit.Assert.assertTrue;

import org.interpss.BaseTestSetup;
import org.interpss.vstab.cpf.CPFAlgorithm;
import org.interpss.vstab.cpf.impl.CPFAlgorithmImpl;
import org.interpss.vstab.cpf.impl.LambdaParam;
import org.interpss.vstab.cpf.impl.PredictorStepSolver;
import org.interpss.vstab.util.VstabFuncOut;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.pssl.simu.IpssAclf;
import com.interpss.simu.util.sample.SampleCases;

public class PreSolverTest extends BaseTestSetup {
	@Test
	public void testCase1() {
    IPSSMsgHub msg = IpssAclf.getMsgHub();
	
	// create a sample 5-bus system for Loadflow 
	AclfNetwork net = CoreObjectFactory.createAclfNetwork();
	SampleCases.load_LF_5BusSystem(net, SpringAppContext.getIpssMsgHub());
	System.out.println(net.net2String());
	LoadflowAlgorithm algo =CoreObjectFactory.createLoadflowAlgorithm(msg);
	net.accept(algo);
	algo.loadflow(); // load flow to create a study base case
	
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
