package org.interpss.schema.test;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.interpss.schema.InterPSSDocument;
import org.interpss.schema.InterPSSType;
import org.junit.Test;

public class SampleModificationTestCase {
	@Test
	public void  sampleFileTest() throws Exception {
		String filename = "xml/SampleModification.xml";
		File xmlFile = new File(filename);
		if (xmlFile == null) {
			throw new Exception("File cannot be found: " + filename);
		}
		
		InterPSSDocument ipssDoc = InterPSSDocument.Factory.parse(xmlFile);	
		InterPSSType ipss = ipssDoc.getInterPSS();
		
		assertTrue(ipss.getModification().getNetChangeRec().getBusChangeRecArray().length == 1);
		assertTrue(ipss.getModification().getNetChangeRec().getBranchChangeRecArray().length == 1);

		assertTrue(ipss.getModification().getAclfNetChangeRec().getAclfBusChangeRecArray().length == 2);
		assertTrue(ipss.getModification().getAclfNetChangeRec().getAclfBranchChangeRecArray().length == 0);

		assertTrue(ipss.getRunStudyCase().getRunAclfStudyCaseArray().length == 1);
	}
}
