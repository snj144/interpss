package org.opencim.rdf;

import java.io.File;

import org.apache.xmlbeans.XmlObject;
import org.opencim.common.CIMLogger;

public class CIMXmlReader {
	private File xmlFile = null; 
	
	public CIMXmlReader(String filename) throws Exception {
		xmlFile = new File(filename);
		if (xmlFile == null) {
			throw new Exception("File cannot be found: " + filename);
		}
	}

    public void parseXmlDoc() throws Exception {
    	CIMLogger.getLogger().info("Begin to parse xml file ...");
   	 	XmlObject cimXmlObj = XmlObject.Factory.parse(xmlFile);
   	 	XmlUtil.cimXmlStructAnalysis(cimXmlObj);
    }
}
