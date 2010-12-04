package org.interpss.schema;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.interpss.PluginTestSetup;
import org.interpss.xml.IpssXmlParser;
import org.junit.Test;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.dclf.DclfAlgorithm;
import com.interpss.core.dclf.SenAnalysisType;
import com.interpss.pssl.simu.IpssPTrading;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;
import com.interpss.spring.CoreCommonSpringCtx;

public class DclfAreaTransferIeee14BusCaseTest extends PluginTestSetup {
	@Test
	public void runSingleAclfCaseTest() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
		
		File xmlFile = new File("testData/xml/RunAreaTransferCase.xml");
  		IpssXmlParser parser = new IpssXmlParser(xmlFile);
  		//System.out.println("----->" + parser.getRootElem().toString());

	  	assertTrue(parser.getRunStudyCase().getAnalysisRunType() == RunStudyCaseXmlType.AnalysisRunType.RUN_DCLF);
		
	  	IPSSMsgHub msg = CoreCommonSpringCtx.getIpssMsgHub();
	  	
		DclfAlgorithm algo = CoreObjectFactory.createDclfAlgorithm(simuCtx.getAclfNet(), msg);
		assertTrue(algo.checkCondition());
			
		DclfStudyCaseXmlType dclfCase = parser.getRunDclfStudyCase().getDclfStudyCaseList().getDclfStudyCaseArray(0);

		for (AreaTransferAnalysisXmlType atFactor : dclfCase.getAreaTransferAnalysisArray()) {
			algo.getInjectBusList().clear();
			for (SenAnalysisBusRecXmlType bus :  atFactor.getInjectBusList().getInjectBusArray()){
				algo.calculateSensitivity(SenAnalysisType.PANGLE, bus.getBusId());
				algo.addInjectBus(bus.getBusId(), bus.getPercent());
			}
			algo.getWithdrawBusList().clear();
			for (SenAnalysisBusRecXmlType bus :  atFactor.getWithdrawBusList().getWithdrawBusArray()){
				algo.calculateSensitivity(SenAnalysisType.PANGLE, bus.getBusId());
				algo.addWithdrawBus(bus.getBusId(), bus.getPercent());
			}
			
			for (BranchRecXmlType branch : atFactor.getBranchArray()) {
				double f = algo.getAreaTransferFactor(branch.getFromBusId(), branch.getToBusId(), "1");
				System.out.println("ATFactor: " + branch.getFromBusId() + "->" + branch.getToBusId() + " " + f);
			}
		}
	}

	@Test
	public void runDSL_SingleAclfCaseTest() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
		
		DclfAlgorithm algo = IpssPTrading.createDclfAlgorithm(simuCtx.getAclfNet())
					.runSenAnalysis("testData/xml/RunAreaTransferCase.xml");
			
		File xmlFile = new File("testData/xml/RunAreaTransferCase.xml");
  		IpssXmlParser parser = new IpssXmlParser(xmlFile);
  		//System.out.println("----->" + parser.getRootElem().toString());
	  	IPSSMsgHub msg = CoreCommonSpringCtx.getIpssMsgHub();
		DclfStudyCaseXmlType dclfCase = parser.getRunDclfStudyCase().getDclfStudyCaseList().getDclfStudyCaseArray(0);
		for (AreaTransferAnalysisXmlType atFactor : dclfCase.getAreaTransferAnalysisArray()) {
			for (BranchRecXmlType branch : atFactor.getBranchArray()) {
				double f = algo.getAreaTransferFactor(branch.getFromBusId(), branch.getToBusId(), "1");
				System.out.println("ATFactor: " + branch.getFromBusId() + "->" + branch.getToBusId() + " " + f);
			}
		}
	}
}
