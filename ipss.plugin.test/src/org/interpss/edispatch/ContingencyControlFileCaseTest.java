package org.interpss.edispatch;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.interpss.BaseTestSetup;
import org.interpss.PluginSpringAppContext;
import org.interpss.custom.IpssFileAdapter;
import org.interpss.custom.run.psseCon.ContingencyFileParser;
import org.interpss.editor.mapper.RunForm2AlgorithmMapper;
import org.interpss.mapper.IpssXmlMapper;
import org.interpss.schema.AclfAlgorithmXmlType;
import org.interpss.schema.InterPSSXmlType;
import org.interpss.schema.ModificationXmlType;
import org.interpss.schema.RunStudyCaseXmlType.RunAclfStudyCase.AclfStudyCaseList.AclfStudyCase;
import org.interpss.xml.IpssXmlParser;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.mapper.IpssMapper;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;

public class ContingencyControlFileCaseTest extends BaseTestSetup {
	@Test
	public void cr113BusSwitchingModelCaseTest() throws Exception {
		IpssFileAdapter adapter = PluginSpringAppContext.getCustomFileAdapter("psse");
		SimuContext simuCtx = adapter.load("testData/edispatch/CR113Bus.raw", SpringAppContext.getIpssMsgHub());
 		//System.out.println(simuCtx.getAclfNet().net2String());

 		assertTrue(simuCtx.getAclfNet().getSwitchBreakBranch("60701", null) != null);
 		assertTrue(simuCtx.getAclfNet().getSwitchBreakBranch("60702", null) != null);
	}

	@Test
	public void cr113BusCaseTest() throws Exception {
		IpssFileAdapter adapter = PluginSpringAppContext.getCustomFileAdapter("psse");
		SimuContext simuCtx = adapter.load("testData/edispatch/CR113Bus.raw", SpringAppContext.getIpssMsgHub());
// 		System.out.println(simuCtx.getAclfNet().net2String());

  		String netStr = SerializeEMFObjectUtil.saveModel(simuCtx.getAclfAdjNet());

		File xmlFile = new File("testData/edispatch/RunCR113Bus.xml");
  		IpssXmlParser parser = new IpssXmlParser(xmlFile);
  		//System.out.println("----->" + parser.getRootElem().toString());

	  	for ( AclfStudyCase aclfCase : parser.getRunStudyCase().getRunAclfStudyCase().getAclfStudyCaseList().getAclfStudyCaseArray()) {
			AclfAdjNetwork net = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(netStr);
	  		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
		  	IpssMapper mapper = new IpssXmlMapper();
		  	mapper.mapping(aclfCase.getModification(), net, ModificationXmlType.class);
		  	
		  	mapper = new RunForm2AlgorithmMapper();
		  	mapper.mapping( parser.getRunStudyCase().getRunAclfStudyCase().getDefaultAclfAlgorithm(), 
	  							algo, AclfAlgorithmXmlType.class);
	  	
	  		assertTrue(algo.loadflow(SpringAppContext.getIpssMsgHub()));
	  	}	
	}
	
	@Test
	public void simpleCaseTest() throws Exception {
		InterPSSXmlType ipssDoc = ContingencyFileParser.parseControlFile("testData/edispatch/contingency.con");
/*
CONTINGENCY LOSEWESTBIGT
OPEN LINE FROM BUS 3004 TO BUS 152 CIRCUIT 1
END
CONTINGENCY LOSEEASTBIGT
OPEN LINE FROM BUS 151 TO BUS 201 CIRCUIT 1
END
CONTINGENCY LOSE2LINESWE
OPEN LINE FROM BUS 3004 TO BUS 152 CIRCUIT 1
OPEN LINE FROM BUS 3006 TO BUS 153 CIRCUIT 1
END
CONTINGENCY LOSE2LINEEA
OPEN LINE FROM BUS 151 TO BUS 201 CIRCUIT 1
OPEN LINE FROM BUS 152 TO BUS 202 CIRCUIT 1
END
END
 */
		assertTrue(ipssDoc.getRunStudyCase().getRunAclfStudyCase().getAclfStudyCaseList().getAclfStudyCaseArray().length == 4);
		
		AclfStudyCase scase = ipssDoc.getRunStudyCase().getRunAclfStudyCase().getAclfStudyCaseList().getAclfStudyCaseArray()[0];
		assertTrue(scase.getModification().getBranchChangeRecList().getBranchChangeRecArray()[0].getFromBusId().equals("3004"));
		assertTrue(scase.getModification().getBranchChangeRecList().getBranchChangeRecArray()[0].getToBusId().equals("152"));
		assertTrue(scase.getModification().getBranchChangeRecList().getBranchChangeRecArray()[0].getCircuitNumber().equals("1"));

		scase = ipssDoc.getRunStudyCase().getRunAclfStudyCase().getAclfStudyCaseList().getAclfStudyCaseArray()[2];
		assertTrue(scase.getModification().getBranchChangeRecList().getBranchChangeRecArray()[0].getFromBusId().equals("3004"));
		assertTrue(scase.getModification().getBranchChangeRecList().getBranchChangeRecArray()[0].getToBusId().equals("152"));
		assertTrue(scase.getModification().getBranchChangeRecList().getBranchChangeRecArray()[0].getCircuitNumber().equals("1"));

		assertTrue(scase.getModification().getBranchChangeRecList().getBranchChangeRecArray()[1].getFromBusId().equals("3006"));
		assertTrue(scase.getModification().getBranchChangeRecList().getBranchChangeRecArray()[1].getToBusId().equals("153"));
		assertTrue(scase.getModification().getBranchChangeRecList().getBranchChangeRecArray()[1].getCircuitNumber().equals("1"));
		
		//System.out.println(ipssDoc.toString());
	}
}
