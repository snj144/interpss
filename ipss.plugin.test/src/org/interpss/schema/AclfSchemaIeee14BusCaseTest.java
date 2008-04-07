package org.interpss.schema;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.interpss.BaseTestSetup;
import org.interpss.PluginSpringAppContext;
import org.interpss.editor.mapper.RunForm2AlgorithmMapper;
import org.interpss.schema.RunStudyCaseXmlType.RunAclfStudyCase.AclfStudyCaseList.AclfStudyCase;
import org.interpss.xml.IpssXmlParser;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.mapper.IpssMapper;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;
import com.interpss.simu.multicase.MultiStudyCase;
import com.interpss.simu.multicase.StudyCase;

public class AclfSchemaIeee14BusCaseTest extends BaseTestSetup {
	@Test
	public void runSingleAclfCaseTest() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
  		// save net to a String
  		String netStr = SerializeEMFObjectUtil.saveModel(simuCtx.getAclfAdjNet());

		File xmlFile = new File("testData/xml/RunAclfCase.xml");
  		IpssXmlParser parser = new IpssXmlParser(xmlFile);
  		//System.out.println("----->" + parser.getRootElem().toString());

	  	assertTrue(parser.getRunStudyCase().getAnalysisRunType() == RunStudyCaseXmlType.AnalysisRunType.RUN_ACLF);
  		
	  	MultiStudyCase mscase = SimuObjectFactory.createMultiStudyCase(SimuCtxType.ACLF_ADJ_NETWORK);
	  	int cnt = 0;
  		double i = 0.0;
	  	for ( AclfStudyCase aclfCase : parser.getRunStudyCase().getRunAclfStudyCase().getAclfStudyCaseList().getAclfStudyCaseArray()) {
			AclfAdjNetwork net = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(netStr);
	  		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
		  	IpssMapper mapper = new RunForm2AlgorithmMapper();
	  		mapper.mapping(aclfCase.getAclfAlgorithm(), algo, AclfAlgorithmXmlType.class);
	  	
	  		assertTrue(algo.getMaxIterations() == 20);
	  		assertTrue(algo.getTolerance() == 1.0E-4);
	  		assertTrue(algo.loadflow(SpringAppContext.getIpssMsgHub()));
	  		i = net.getAclfBranch("0004->0007(1)").current(UnitType.PU, net.getBaseKva());
	  		
	  		StudyCase scase = SimuObjectFactory.createStudyCase(aclfCase.getRecId(), aclfCase.getRecName(), ++cnt, mscase);
	  		scase.setNetModelString(SerializeEMFObjectUtil.saveModel(net));
	  	}
  		assertTrue(mscase.getStudyCase(1) != null);
  		assertTrue(mscase.getStudyCase(2) != null);
  		assertTrue(mscase.getStudyCase(3) != null);
  		
//  		System.out.println(net.net2String());
  		AclfAdjNetwork net = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(mscase.getStudyCase(1).getNetModelString());
	  	assertTrue(Math.abs(net.getAclfBranch("0004->0007(1)").current(UnitType.PU, net.getBaseKva())-i) < 1.0E-5);

  		net = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(mscase.getStudyCase(2).getNetModelString());
	  	assertTrue(Math.abs(net.getAclfBranch("0004->0007(1)").current(UnitType.PU, net.getBaseKva())-i) < 1.0E-5);

  		net = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(mscase.getStudyCase(3).getNetModelString());
	  	assertTrue(Math.abs(net.getAclfBranch("0004->0007(1)").current(UnitType.PU, net.getBaseKva())-i) < 1.0E-5);
	}			

	@Test
	public void runDefaultAclfCaseTest() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
  		// save net to a String
  		String netStr = SerializeEMFObjectUtil.saveModel(simuCtx.getAclfAdjNet());

		File xmlFile = new File("testData/xml/RunAclfDefaultCase.xml");
  		IpssXmlParser parser = new IpssXmlParser(xmlFile);
  		//System.out.println("----->" + parser.getRootElem().toString());

	  	assertTrue(parser.getRunStudyCase().getAnalysisRunType() == RunStudyCaseXmlType.AnalysisRunType.RUN_ACLF);
  		
	  	MultiStudyCase mscase = SimuObjectFactory.createMultiStudyCase(SimuCtxType.ACLF_ADJ_NETWORK);
	  	int cnt = 0;
  		double i = 0.0;
	  	for ( AclfStudyCase aclfCase : parser.getRunStudyCase().getRunAclfStudyCase().getAclfStudyCaseList().getAclfStudyCaseArray()) {
			AclfAdjNetwork net = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(netStr);
	  		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
		  	IpssMapper mapper = new RunForm2AlgorithmMapper();

		  	if (aclfCase.getAclfAlgorithm() == null) 
		  		aclfCase.setAclfAlgorithm(parser.getRunStudyCase().getRunAclfStudyCase().getDefaultAclfAlgorithm());
		  	
		  	mapper.mapping(aclfCase.getAclfAlgorithm(), algo, AclfAlgorithmXmlType.class);
	  	
	  		assertTrue(algo.getMaxIterations() == 20);
	  		assertTrue(algo.getTolerance() == 1.0E-4);
	  		assertTrue(algo.loadflow(SpringAppContext.getIpssMsgHub()));
	  		i = net.getAclfBranch("0004->0007(1)").current(UnitType.PU, net.getBaseKva());
	  		
	  		StudyCase scase = SimuObjectFactory.createStudyCase(aclfCase.getRecId(), aclfCase.getRecName(), ++cnt, mscase);
	  		scase.setNetModelString(SerializeEMFObjectUtil.saveModel(net));
	  	}
  		assertTrue(mscase.getStudyCase(1) != null);
  		assertTrue(mscase.getStudyCase(2) != null);
  		assertTrue(mscase.getStudyCase(3) != null);
  		
//  		System.out.println(net.net2String());
  		AclfAdjNetwork net = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(mscase.getStudyCase(1).getNetModelString());
	  	assertTrue(Math.abs(net.getAclfBranch("0004->0007(1)").current(UnitType.PU, net.getBaseKva())-i) < 1.0E-5);

  		net = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(mscase.getStudyCase(2).getNetModelString());
	  	assertTrue(Math.abs(net.getAclfBranch("0004->0007(1)").current(UnitType.PU, net.getBaseKva())-i) < 1.0E-5);

  		net = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(mscase.getStudyCase(3).getNetModelString());
	  	assertTrue(Math.abs(net.getAclfBranch("0004->0007(1)").current(UnitType.PU, net.getBaseKva())-i) < 1.0E-5);
	}			

	@Test
	public void runSingleAclfCaseModificationTest() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
		
		AclfNetwork net = simuCtx.getAclfNet();
  		assertTrue((net.getBusList().size() == 14 && net.getBranchList().size() == 20));

		File xmlFile = new File("testData/xml/RunAclfCaseModification.xml");
  		IpssXmlParser parser = new IpssXmlParser(xmlFile);
  		//System.out.println("----->" + parser.getRootElem().toString());

  		AclfStudyCase aclfCase = parser.getRunStudyCase().getRunAclfStudyCase().getAclfStudyCaseList().getAclfStudyCaseArray()[0];
  			
	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	// modification of the study case also applied
	  	IpssMapper mapper = new RunForm2AlgorithmMapper();
	  	mapper.mapping(aclfCase.getModification(), net, ModificationXmlType.class);
	  	mapper.mapping(aclfCase.getAclfAlgorithm(), algo, AclfAlgorithmXmlType.class);
	  	
	  	assertTrue(!net.getBranch("0010->0009(1)").isActive());
	  	
	  	// load increased by 0.1 pu
	  	assertTrue(net.getAclfBus("0014").getLoadCode() == AclfLoadCode.EXPONENTIAL);
	  	
	  	// branch Z increase by 10%
	  	assertTrue(Math.abs(net.getAclfBranch("0004->0007(1)").getZ().getImaginary()-0.20912*1.1) < 1.0E-5);

	  	assertTrue(algo.loadflow(SpringAppContext.getIpssMsgHub()));
	}

	@Test
	public void modificationOnlyTest() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
		
		AclfNetwork net = simuCtx.getAclfNet();
  		assertTrue((net.getBusList().size() == 14 && net.getBranchList().size() == 20));

		File xmlFile = new File("testData/xml/ModificationOnly.xml");
  		IpssXmlParser parser = new IpssXmlParser(xmlFile);
  		//System.out.println("----->" + parser.getRootElem().toString());

  		ModificationXmlType mod = parser.getModification();
  		
		IpssMapper mapper = PluginSpringAppContext.getRunForm2AlgorithmMapper();
		mapper.mapping(mod, net, ModificationXmlType.class);
	  	
	  	assertTrue(!net.getBranch("0010->0009(1)").isActive());
	  	assertTrue(!net.getBus("0006").isActive());
	  	
	  	// load increased by 0.1 pu
	  	assertTrue(net.getAclfBus("0014").getLoadP() == 1.1*0.149);
	  	assertTrue(net.getAclfBus("0014").getLoadQ() == 1.1*0.05);
	  	
	  	// load set to 0.15+j0.06 pu
	  	assertTrue(net.getAclfBus("0013").getLoadP() == 0.15);
	  	assertTrue(net.getAclfBus("0013").getLoadQ() == 0.06);

	  	// load added 1.0+j1.0 MVA
	  	assertTrue(net.getAclfBus("0012").getLoadP() == 0.071);
	  	assertTrue(Math.abs(net.getAclfBus("0012").getLoadQ()-0.026) < 1.0E-5);

		final SwingBusAdapter gen = (SwingBusAdapter)net.getAclfBus("0001").adapt(SwingBusAdapter.class);
	  	assertTrue(gen.getVoltMag(UnitType.PU) == (1.06*1.01));

	  	// branch Z increase by 10%
	  	assertTrue(Math.abs(net.getAclfBranch("0004->0007(1)").getZ().getImaginary()-0.20912*1.1) < 1.0E-5);
	}
	
	@Test
	public void modificationPersistanceTest() throws Exception {
		File xmlFile = new File("testData/xml/ModificationOnly.xml");
  		IpssXmlParser parser = new IpssXmlParser(xmlFile);
  		//System.out.println("----->" + parser.getRootElem().toString());

  		ModificationXmlType mod = parser.getModification();
  		
  		IpssXmlParser wrapper = new IpssXmlParser();
  		wrapper.getRoot().setModification(mod);
  		
  		parser = new IpssXmlParser(wrapper.toString());

  		mod = parser.getModification();
  		
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
		
		AclfNetwork net = simuCtx.getAclfNet();
  		assertTrue((net.getBusList().size() == 14 && net.getBranchList().size() == 20));

  		IpssMapper mapper = PluginSpringAppContext.getRunForm2AlgorithmMapper();
		mapper.mapping(mod, net, ModificationXmlType.class);
	  	
	  	assertTrue(!net.getBranch("0010->0009(1)").isActive());
	  	assertTrue(!net.getBus("0006").isActive());
	  	
	  	// load increased by 0.1 pu
	  	assertTrue(net.getAclfBus("0014").getLoadP() == 1.1*0.149);
	  	assertTrue(net.getAclfBus("0014").getLoadQ() == 1.1*0.05);
	  	
	  	// load set to 0.15+j0.06 pu
	  	assertTrue(net.getAclfBus("0013").getLoadP() == 0.15);
	  	assertTrue(net.getAclfBus("0013").getLoadQ() == 0.06);

	  	// load added 1.0+j1.0 MVA
	  	assertTrue(net.getAclfBus("0012").getLoadP() == 0.071);
	  	assertTrue(Math.abs(net.getAclfBus("0012").getLoadQ()-0.026) < 1.0E-5);

		final SwingBusAdapter gen = (SwingBusAdapter)net.getAclfBus("0001").adapt(SwingBusAdapter.class);
	  	assertTrue(gen.getVoltMag(UnitType.PU) == (1.06*1.01));

	  	// branch Z increase by 10%
	  	assertTrue(Math.abs(net.getAclfBranch("0004->0007(1)").getZ().getImaginary()-0.20912*1.1) < 1.0E-5);
	}  		
}
