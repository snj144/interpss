package org.interpss.vstab;

import org.interpss.BaseTestSetup;
import org.interpss.display.AclfOutFunc;
import org.interpss.vstab.cpf.CPFAlgorithm;
import org.interpss.vstab.cpf.impl.CorrectorStepSolver;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.util.sample.SampleCases;

public class CorrStepSolverTest extends BaseTestSetup {
	@Test
	public void testCase1() {
    IPSSMsgHub msg = SpringAppContext.getIpssMsgHub();
	
	// create a sample 5-bus system for Loadflow 
	AclfNetwork net = CoreObjectFactory.createAclfNetwork();
	SampleCases.load_LF_5BusSystem(net, msg);
	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(msg);
	net.accept(algo);
	System.out.println(AclfOutFunc.loadFlowSummary(net)); // output load flow result 
	
	// create CPF algorithm;
	CPFAlgorithm cpfAlgo = VStabObjectFactory.createCPFAlgorithmImpl(net, msg);
	CorrectorStepSolver corSolver=cpfAlgo.getCorrStepSolver();
	
	algo.setNrSolver(corSolver);
	net.accept(algo);
	System.out.println("lambda="+cpfAlgo.getLambdaParam().getVal());
	System.out.println(AclfOutFunc.loadFlowSummary(net));
	}
}
