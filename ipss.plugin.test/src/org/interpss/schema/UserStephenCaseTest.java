package org.interpss.schema;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.interpss.BaseTestSetup;
import org.interpss.PluginSpringAppContext;
import org.interpss.custom.IpssFileAdapter;
import org.interpss.mapper.IpssXmlMapper;
import org.interpss.xml.IpssXmlParser;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.mapper.IpssMapper;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;
import com.interpss.simu.multicase.MultiStudyCase;
import com.interpss.simu.multicase.aclf.AclfStudyCase;

public class UserStephenCaseTest extends BaseTestSetup {
	@Test
	public void caseTest1() throws Exception {
		IpssFileAdapter adapter = PluginSpringAppContext.getCustomFileAdapter("ieee");
		SimuContext simuCtx = adapter.load("testData/ieee_format/ieee14.ieee", SpringAppContext.getIpssMsgHub());
  		// save net to a String
  		String netStr = SerializeEMFObjectUtil.saveModel(simuCtx.getAclfAdjNet());

		File xmlFile = new File("testData/xml/usertest/mytest.xml");
  		IpssXmlParser parser = new IpssXmlParser(xmlFile);
  		//System.out.println("----->" + parser.getRootElem().toString());
  		
	  	assertTrue(parser.getRunStudyCase().getAnalysisRunType() == RunStudyCaseXmlType.AnalysisRunType.RUN_ACLF);
  		
	  	MultiStudyCase mscase = SimuObjectFactory.createAclfMultiStudyCase(SimuCtxType.ACLF_ADJ_NETWORK);
	  	int cnt = 0;
	  	for ( AclfStudyCaseXmlType aclfCase : parser.getRunStudyCase().getRunAclfStudyCase().getAclfStudyCaseList().getAclfStudyCaseArray()) {
			AclfAdjNetwork net = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(netStr);
	  		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
		  	IpssMapper mapper = new IpssXmlMapper();
	  		
		  	if (aclfCase.getAclfAlgorithm() == null) 
		  		aclfCase.setAclfAlgorithm(parser.getRunStudyCase().getRunAclfStudyCase().getDefaultAclfAlgorithm());
		  	if (aclfCase.getModification() != null)
			  	mapper.mapping(aclfCase.getModification(), net, ModificationXmlType.class);
		  	mapper.mapping(aclfCase.getAclfAlgorithm(), algo, AclfAlgorithmXmlType.class);
	  	
	  		assertTrue(algo.loadflow(SpringAppContext.getIpssMsgHub()));

	  		AclfStudyCase scase = SimuObjectFactory.createAclfStudyCase(aclfCase.getRecId(), aclfCase.getRecName(), ++cnt, mscase);
	  		scase.setNetModelString(SerializeEMFObjectUtil.saveModel(net));
	  	}
	  	
  		assertTrue(mscase.getStudyCase(1) != null);
  		assertTrue(mscase.getStudyCase(2) != null);
  		
//  		System.out.println(net.net2String());
  		AclfAdjNetwork net = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(mscase.getStudyCase(1).getNetModelString());
  		AclfBus busIncreased = net.getAclfBus("No12");
  		
  		net = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(mscase.getStudyCase(2).getNetModelString());
  		AclfBus busBase = net.getAclfBus("No12");

  		double dP = busIncreased.getLoadP() - busBase.getLoadP();
  		double dQ = busIncreased.getLoadQ() - busBase.getLoadQ();
  		assertTrue(Math.abs(dP - busBase.getLoadP()*0.1) < 0.00001);
  		assertTrue(Math.abs(dQ - busBase.getLoadQ()*0.1) < 0.00001);
	}			

	@Test
	public void caseTest2() throws Exception {
		IpssFileAdapter adapter = PluginSpringAppContext.getCustomFileAdapter("ieee");
		SimuContext simuCtx = adapter.load("testData/ieee_format/ieee14.ieee", SpringAppContext.getIpssMsgHub());
  		// save net to a String
  		String netStr = SerializeEMFObjectUtil.saveModel(simuCtx.getAclfAdjNet());

		File xmlFile = new File("testData/xml/usertest/N-1.xml");
  		IpssXmlParser parser = new IpssXmlParser(xmlFile);
  		//System.out.println("----->" + parser.getRootElem().toString());

  		assertTrue(parser.getRunStudyCase().getAnalysisRunType() == RunStudyCaseXmlType.AnalysisRunType.RUN_ACLF);
  		
	  	MultiStudyCase mscase = SimuObjectFactory.createAclfMultiStudyCase(SimuCtxType.ACLF_ADJ_NETWORK);
	  	int cnt = 0;
	  	for ( AclfStudyCaseXmlType aclfCase : parser.getRunStudyCase().getRunAclfStudyCase().getAclfStudyCaseList().getAclfStudyCaseArray()) {
			AclfAdjNetwork net = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(netStr);
	  		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
		  	IpssMapper mapper = new IpssXmlMapper();

		  	if (aclfCase.getModification() != null)
			  	mapper.mapping(aclfCase.getModification(), net, ModificationXmlType.class);
		  	if (aclfCase.getAclfAlgorithm() == null) 
		  		aclfCase.setAclfAlgorithm(parser.getRunStudyCase().getRunAclfStudyCase().getDefaultAclfAlgorithm());
		  	mapper.mapping(aclfCase.getAclfAlgorithm(), algo, AclfAlgorithmXmlType.class);
	  		
	  		assertTrue(algo.loadflow(SpringAppContext.getIpssMsgHub()));
	  	
	  		AclfStudyCase scase = SimuObjectFactory.createAclfStudyCase(aclfCase.getRecId(), aclfCase.getRecName(), ++cnt, mscase);
	  		scase.setNetModelString(SerializeEMFObjectUtil.saveModel(net));
	  	}

  		assertTrue(mscase.getStudyCase(1) != null);
  		assertTrue(mscase.getStudyCase(2) != null);

  		AclfAdjNetwork net = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(mscase.getStudyCase(1).getNetModelString());
  		assertTrue(net.getBranch("No1", "No2").isActive() == false);
  		
  		net = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(mscase.getStudyCase(2).getNetModelString());
  		assertTrue(net.getBranch("No1", "No5").isActive() == false);
	}			
}
