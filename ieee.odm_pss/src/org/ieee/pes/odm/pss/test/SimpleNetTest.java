package org.ieee.pes.odm.pss.test;

import java.io.File;

import org.custommonkey.xmlunit.XMLUnit;
import org.ieee.pes.odm.pss.model.IEEEODMPSSModelParser;
import org.junit.Test;

public class SimpleNetTest extends ODMXmlTestCaseBase {
	@Test
	public void testValidXml() throws Exception {
		new IEEEODMPSSModelParser(new File("testdata/sample/SimpleNet.xml"));
	}

	@Test 
	public void testInvalidXml() {
		try {
			new IEEEODMPSSModelParser(new File("testdata/sample/SimpleNetNotValid.xml"));
			assertTrue(false);
		} catch (Exception e) {
		}
	}
	
	@Test
    public void testXPathValues() throws Exception {
    	IEEEODMPSSModelParser parser = new IEEEODMPSSModelParser(new File("testdata/sample/SimpleNet.xml"));
        String xmlStr = parser.toXmlDoc();
        System.out.println(xmlStr);
        
        XMLUnit.setXpathNamespaceContext(getNamespaceCtx());
        assertXpathEvaluatesTo("V1.00", "/pss:PSSStudyCase/pss:schemaVersion", xmlStr);
        assertXpathEvaluatesTo("100.0", XPath_BaseCase+"pss:baseKva", xmlStr);

        assertXpathEvaluatesTo("Bus1", XPath_BusList+"pss:bus[1]/pss:id", xmlStr);
        assertXpathEvaluatesTo("Bus2", XPath_BusList+"pss:bus[2]/pss:id", xmlStr);
        
        assertXpathEvaluatesTo("Bus1", XPath_BranchList+"pss:branch[1]/pss:fromBus/pss:idRef", xmlStr);
        assertXpathEvaluatesTo("Bus2", XPath_BranchList+"pss:branch[1]/pss:toBus/pss:idRef", xmlStr);
    }
}