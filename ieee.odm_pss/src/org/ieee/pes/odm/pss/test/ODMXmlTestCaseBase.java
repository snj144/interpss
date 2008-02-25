package org.ieee.pes.odm.pss.test;

import org.custommonkey.xmlunit.SimpleNamespaceContext;
import org.custommonkey.xmlunit.XMLTestCase;

public class ODMXmlTestCaseBase extends XMLTestCase {
	protected static final String XPath_BusList = "/pss:PSSStudyCase/pss:baseCase/pss:busList/";
	protected static final String XPath_BranchList = "/pss:PSSStudyCase/pss:baseCase/pss:branchList/";
	
	
	public SimpleNamespaceContext getNamespaceCtx() {
        java.util.Map<String, String> prefixMap = new java.util.HashMap<String, String>();
        prefixMap.put("pss", "http://www.ieee.org/cmte/psace/oss/odm/pss/Schema/v1");
        return new SimpleNamespaceContext(prefixMap);
	}	
}