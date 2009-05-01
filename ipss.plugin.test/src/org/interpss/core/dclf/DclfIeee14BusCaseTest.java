package org.interpss.core.dclf;

import org.interpss.BaseTestSetup;
import org.junit.Test;

import com.interpss.common.datatype.UnitType;
import com.interpss.core.dclf.DclfAlgorithm;
import com.interpss.pssl.plugin.IpssUtil;
import com.interpss.pssl.simu.IpssPTrading;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class DclfIeee14BusCaseTest extends BaseTestSetup {
	@Test
	public void runSingleAclfCaseTest() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
		
		DclfAlgorithm algo = IpssPTrading.createDclfAlgorithm(simuCtx.getAclfNet())
					.runDclfAnalysis(true);

		System.out.println(IpssUtil.outDclfResult(algo).toString());
		
		System.out.println(algo.getBranchFlow("0001", "0002", "1", UnitType.mW));
	}
}
