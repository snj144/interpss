package org.interpss.core.dclf;

import static org.junit.Assert.assertTrue;

import org.interpss.BaseTestSetup;
import org.interpss.display.DclfOutFunc;
import org.junit.Test;

import com.interpss.common.datatype.UnitType;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.dclf.DclfAlgorithm;
import com.interpss.pssl.simu.IpssPTrading;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class DclfIeee14BusCaseTest extends BaseTestSetup {
	@Test
	public void runSingleAclfCaseTest() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
		
		DclfAlgorithm algo = IpssPTrading.createDclfAlgorithm(simuCtx.getAclfNet())
					.runDclfAnalysis(true);

		//System.out.println(DclfOutFunc.dclfResults(algo));
		
		//System.out.println(algo.getBranchFlow("0001", "0002", "1", UnitType.mW));
		assertTrue(Math.abs(algo.getBranchFlow("0001", "0002", "1", UnitType.mW) - 147.88) < 0.01);
	}

	@Test
	public void lineOutageCaseTest() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
		
		DclfAlgorithm algo = IpssPTrading.createDclfAlgorithm(simuCtx.getAclfNet())
					.runDclfAnalysis(true);

		double x1 = IpssPTrading.wrapAlgorithm(algo)
			.setInjectionBusId("0004")
			.setWithdrawBusId("0007")
			.setBranchFromBusId("0004").toBusId("0007")
			.getPowerTransferDistFactor();
		//System.out.println(x1);

		double x2 = IpssPTrading.wrapAlgorithm(algo)
			.setInjectionBusId("0004")
			.setWithdrawBusId("0007")
			.setBranchFromBusId("0004").toBusId("0009")
			.getPowerTransferDistFactor();
		//System.out.println(x2);

		double x3 = IpssPTrading.wrapAlgorithm(algo)
			.setInjectionBusId("0004")
			.setWithdrawBusId("0007")
			.setBranchFromBusId("0005").toBusId("0006")
			.getPowerTransferDistFactor();
		//System.out.println(x3);
	
		assertTrue(Math.abs(x1 + x2 + x3 - 1.0) < 0.0001);
		
		double pFlow = algo.getBranchFlow("0004", "0007", "1", UnitType.mW);
		double derating1 = pFlow * x2 / ( 1.0 - x1);
		double derating2 = pFlow * x3 / ( 1.0 - x1);

		//System.out.println("Mw flow 4->7: " + pFlow);
		//System.out.println("derating 4->9: " + derating1);
		//System.out.println("derating 5->6: " + derating2);
		assertTrue(Math.abs(derating1 - 14.71922) < 0.0001);
		assertTrue(Math.abs(derating2 - 14.26586) < 0.0001);
		
		AclfBranch outageBranch = algo.getAclfNetwork().getAclfBranch("0004", "0007", "1");
		AclfBranch transferBranch = algo.getAclfNetwork().getAclfBranch("0004", "0009", "1");
		double f = algo.getLineOutageDFactor(outageBranch, transferBranch);
		//System.out.println("LODF (4->7) -> (4->9): " + f);
		assertTrue(Math.abs(f - 0.50782) < 0.0001);
		
		//System.out.println(DclfOutFunc.lineOutageAnalysisTitle("", outageBranch.getId()));		
		//System.out.println(DclfOutFunc.lineOutageAnalysisBranchFlow(transferBranch, algo, pFlow, f));		
	}
}