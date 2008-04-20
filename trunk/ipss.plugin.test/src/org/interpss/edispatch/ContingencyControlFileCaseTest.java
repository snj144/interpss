package org.interpss.edispatch;

import static org.junit.Assert.assertTrue;

import org.interpss.BaseTestSetup;
import org.interpss.custom.run.psseCon.ContingencyFileParser;
import org.interpss.schema.InterPSSXmlType;
import org.interpss.schema.RunStudyCaseXmlType.RunAclfStudyCase.AclfStudyCaseList.AclfStudyCase;
import org.junit.Test;

public class ContingencyControlFileCaseTest extends BaseTestSetup {
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
	}
}
