package org.interpss.schema;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.interpss.BaseTestSetup;
import org.interpss.schema.DclfStudyCaseXmlType.AreaTransferAnalysis;
import org.interpss.xml.IpssXmlParser;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.dclf.DclfAlgorithm;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class DclfAreaTransferIeee14BusCaseTest extends BaseTestSetup {
	@Test
	public void runSingleAclfCaseTest() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
		
		File xmlFile = new File("testData/xml/RunAreaTransferCase.xml");
  		IpssXmlParser parser = new IpssXmlParser(xmlFile);
  		//System.out.println("----->" + parser.getRootElem().toString());

	  	assertTrue(parser.getRunStudyCase().getAnalysisRunType() == RunStudyCaseXmlType.AnalysisRunType.RUN_DCLF);
		
	  	IPSSMsgHub msg = SpringAppContext.getIpssMsgHub();
	  	
		DclfAlgorithm algo = CoreObjectFactory.createDclfAlgorithm(simuCtx.getAclfAdjNet());
		assertTrue(algo.checkCondition(msg));
			
		DclfStudyCaseXmlType dclfCase = parser.getRunDclfStudyCase().getDclfStudyCaseList().getDclfStudyCaseArray(0);

		for (AreaTransferAnalysis sen : dclfCase.getAreaTransferAnalysisArray()) {
		}
	}
}
