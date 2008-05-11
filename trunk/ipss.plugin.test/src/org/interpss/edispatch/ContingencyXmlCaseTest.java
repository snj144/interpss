package org.interpss.edispatch;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.interpss.BaseTestSetup;
import org.interpss.gridgain.result.IRemoteResult;
import org.interpss.gridgain.result.RemoteResultFactory;
import org.interpss.gridgain.secass.ContingencyAnaysisJob;
import org.interpss.mapper.IpssXmlMapper;
import org.interpss.schema.AclfAlgorithmXmlType;
import org.interpss.schema.AclfStudyCaseXmlType;
import org.interpss.schema.ModificationXmlType;
import org.interpss.schema.RunStudyCaseXmlType;
import org.interpss.xml.IpssXmlParser;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.mapper.IpssMapper;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;
import com.interpss.simu.multicase.ContingencyAnalysis;
import com.interpss.simu.multicase.aclf.AclfStudyCase;
import com.interpss.simu.multicase.result.AclfBranchResultRec;
import com.interpss.simu.multicase.result.AclfBusResultRec;

public class ContingencyXmlCaseTest extends BaseTestSetup {
	@Test
	public void simpleCaseTest() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
	  	ContingencyAnalysis mscase = SimuObjectFactory.createContingencyAnalysis(SimuCtxType.ACLF_ADJ_NETWORK, simuCtx.getAclfAdjNet());

	  	String netStr = SerializeEMFObjectUtil.saveModel(simuCtx.getAclfAdjNet());

		File xmlFile = new File("testData/xml/contingency/simpleTest.xml");
  		IpssXmlParser parser = new IpssXmlParser(xmlFile);
  		//System.out.println("----->" + parser.getRootElem().toString());
  		
	  	assertTrue(parser.getRunStudyCase().getAnalysisRunType() == RunStudyCaseXmlType.AnalysisRunType.CONTINGENCY_ANALYSIS);
  		
	  	int cnt = 0;
	  	for ( AclfStudyCaseXmlType aclfCase : parser.getContingencyAnalysis().getAclfStudyCaseList().getAclfStudyCaseArray()) {
			AclfAdjNetwork net = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(netStr);
	  		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
		  	IpssMapper mapper = new IpssXmlMapper();
		  	mapper.mapping(aclfCase.getModification(), net, ModificationXmlType.class);
		  	mapper.mapping(parser.getContingencyAnalysis().getDefaultAclfAlgorithm(), algo, AclfAlgorithmXmlType.class);
		  	
	  		assertTrue(algo.loadflow(SpringAppContext.getIpssMsgHub()));
	  		
	  		AclfStudyCase scase = SimuObjectFactory
	  				.createAclfStudyCase(aclfCase.getRecId(), aclfCase.getRecName(), ++cnt, mscase);
	  		scase.getResult().transferAclfResult(net);
	  		
	  		mscase.updateResult("Description", scase.getResult());
	  	}

		AclfBusResultRec rbus = mscase.getBusResult().get("0001");
  		assertTrue(rbus != null);
	  	assertTrue(Math.abs(rbus.getHighVoltMagPU()-1.0600) < 0.001);
	  	assertTrue(Math.abs(rbus.getLowVoltMagPU()-1.0600) < 0.001);
		
		rbus = mscase.getBusResult().get("0014");
  		assertTrue(rbus != null);
	  	assertTrue(Math.abs(rbus.getHighVoltMagPU()-1.0426) < 0.001);
	  	assertTrue(Math.abs(rbus.getLowVoltMagPU()-1.0340) < 0.001);

	  	AclfBranchResultRec rbra = mscase.getBranchResult().get("0002->0003(1)");
  		assertTrue(rbra != null);
	  	assertTrue(Math.abs(rbra.getMvaFlow()-75.91) < 0.01);
/*	  	
		IRemoteResult resultHandler = RemoteResultFactory
				.createHandler(ContingencyAnaysisJob.class);
		System.out.println(resultHandler
				.toString(IRemoteResult.DisplayType_SecAssessment, mscase)
				.toString());

		System.out.println(resultHandler
				.toString(IRemoteResult.DisplayType_SecViolation, mscase)
				.toString());
*/				
	}
}
