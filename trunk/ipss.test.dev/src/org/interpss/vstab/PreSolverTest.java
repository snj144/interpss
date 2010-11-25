package org.interpss.vstab;

import org.interpss.BaseTestSetup;
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
	LoadflowAlgorithm algo =CoreObjectFactory.createLoadflowAlgorithm(msg);
	net.accept(algo);
	algo.loadflow(); // load flow to create a study base case
	
	LambdaParam lambda=new LambdaParam(net.getNoBus()+1,1);
	PredictorStepSolver preSolver=new PredictorStepSolver(net,lambda,msg);
	preSolver.stepSolver();
	// print J-matrix
    VstabFuncOut.printJmatix(preSolver.getAugmentedJacobi());
    // print tangent vector
    VstabFuncOut.printRealVector(preSolver.getDeltaXLambda());
	
	
	}
	
   }
