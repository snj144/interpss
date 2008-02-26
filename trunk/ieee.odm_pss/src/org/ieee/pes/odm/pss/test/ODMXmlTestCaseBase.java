package org.ieee.pes.odm.pss.test;

import org.custommonkey.xmlunit.SimpleNamespaceContext;
import org.custommonkey.xmlunit.XMLTestCase;
import org.ieee.pes.odm.pss.model.IEEEODMPSSModelParser;

public class ODMXmlTestCaseBase extends XMLTestCase {
	protected static final String XPath_BaseCase = "/pss:PSSStudyCase/pss:baseCase/";
	protected static final String XPath_BusList = "/pss:PSSStudyCase/pss:baseCase/pss:busList/";
	protected static final String XPath_BranchList = "/pss:PSSStudyCase/pss:baseCase/pss:branchList/";
	
	
	public SimpleNamespaceContext getNamespaceCtx() {
        java.util.Map<String, String> prefixMap = new java.util.HashMap<String, String>();
        prefixMap.put(IEEEODMPSSModelParser.Token_nsPrefix, IEEEODMPSSModelParser.Token_nsUrl);
        return new SimpleNamespaceContext(prefixMap);
	}	
}