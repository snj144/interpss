package org.interpss.test.vstab;

import static org.junit.Assert.assertTrue;

import org.interpss.display.AclfOutFunc;
import org.interpss.test.DevTestSetup;
import org.interpss.vstab.VStabObjectFactory;
import org.interpss.vstab.cpf.CPFAlgorithm;
import org.interpss.vstab.cpf.impl.CorrectorStepSolver;
import org.junit.Test;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.util.sample.SampleCases;
import com.interpss.spring.CoreCommonSpringCtx;

public class CorrStepSolverTest extends DevTestSetup {
	/**
	 * Test Lambda as the continuation parameter;
	 */
//	@Test
//	public void testCase1() {
//    IPSSMsgHub msg = SpringAppContext.getIpssMsgHub();
//	
//	// create a sample 5-bus system for Loadflow 
//	AclfNetwork net = CoreObjectFactory.createAclfNetwork();
//	SampleCases.load_LF_5BusSystem(net, msg);
//	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(msg);
////	net.accept(algo);
////	System.out.println(AclfOutFunc.loadFlowSummary(net)); // output load flow result 
//	
//	// create CPF algorithm;
//	CPFAlgorithm cpfAlgo = VStabObjectFactory.createCPFAlgorithmImpl(net, msg);
//	double fixVal=2.5;
//	cpfAlgo.setFixedValOfContPara(fixVal);// set fixval to 1.5 intentionally for testing
//	CorrectorStepSolver corSolver=cpfAlgo.getCorrStepSolver();
//	algo.setNrSolver(corSolver);
//	net.accept(algo);
//	assertTrue(net.isLfConverged());
//	assertTrue((cpfAlgo.getLambdaParam().getVal()-fixVal)<1e-5);
////	System.out.println("lambda="+cpfAlgo.getLambdaParam().getVal());
////	System.out.println(AclfOutFunc.loadFlowSummary(net));
//	}
	
	/**
	 * Test the bus voltage magnitude as the continuation parameter;
	 */
	@Test
	public void testCase2() {
		    IPSSMsgHub msg = CoreCommonSpringCtx.getIpssMsgHub();
			
			// create a sample 5-bus system for Loadflow 
			AclfNetwork net = CoreObjectFactory.createAclfNetwork();
			SampleCases.load_LF_5BusSystem(net, msg);
			LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(msg);
			net.accept(algo);
//			System.out.println(AclfOutFunc.loadFlowSummary(net));
			// create CPF algorithm;
			CPFAlgorithm cpfAlgo = VStabObjectFactory.createCPFAlgorithmImpl(net, msg);

			double fixVal=0.956;
			net.getAclfBus("2").setVoltageMag(fixVal);
			
			cpfAlgo.setSorNumofContParam(4);// sortNumber=4 ,namely vmag of bus2 is selected as the continuation parameter
			cpfAlgo.setFixedValOfContPara(fixVal);// set fixedVal to 1.5 intentionally for testing
			System.out.println("cpfAlgo SortNum="+cpfAlgo.getSortNumOfContParam());
			CorrectorStepSolver corSolver=cpfAlgo.getCorrStepSolver();
			algo.setNrSolver(corSolver);
			net.accept(algo);
			System.out.println(AclfOutFunc.loadFlowSummary(net));
			System.out.println("SortNumber of bus2 ="+net.getAclfBus("2").getSortNumber());
			assertTrue(net.isLfConverged());
			assertTrue((net.getAclfBus("2").getVoltageMag()-fixVal)<1e-5);// bus2
//			System.out.println("lambda="+cpfAlgo.getLambdaParam().getVal());
			
	}
}
