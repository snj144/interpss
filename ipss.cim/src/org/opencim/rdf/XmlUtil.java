package org.opencim.rdf;

import java.util.HashSet;
import java.util.Set;

import org.apache.xmlbeans.XmlObject;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class XmlUtil {
	public static final String CIMNSDeclare = 
//	    "declare namespace xml='http://www.w3c.org/xml';" +
		"declare namespace rdf='http://www.w3.org/1999/02/22-rdf-syntax-ns#';" +
		"declare namespace cim='http://iec.ch/TC57/2001/CIM-schema-cim10#';";
	
	public static String getElemName(XmlObject obj) {
        return obj.getDomNode().getNodeName();
    }

	public static String getArrtribute(XmlObject obj, String attribName) {
        return obj.selectPath(CIMNSDeclare+"$this/@"+attribName)[0].getDomNode().getNodeValue();
    }

	public static String getArrtribute(XmlObject obj, String elemName, String attribName) {
        return obj.selectPath(CIMNSDeclare+"$this/"+elemName+"/@"+attribName)[0].getDomNode().getNodeValue();
    }

	public static String getElemText(XmlObject obj, String elemName) {
    	Element elem = (Element)obj.selectPath(CIMNSDeclare+"$this/"+elemName)[0].getDomNode();
    	NodeList list = elem.getChildNodes();
    	for (int i = 0; i < list.getLength(); i++) {
    		Node ni = list.item(i);
    		if (ni instanceof Text) 
    			return ((Text)ni).getData();
    	}
        return "";
    }
	
	public static void cimXmlStructAnalysis(XmlObject cimXmlObj) {
        XmlObject[] elements = cimXmlObj.selectPath(XmlUtil.CIMNSDeclare + "$this/rdf:RDF/*");
        System.out.println("Total CIM elements " + elements.length);
        //System.out.println("An element:\n " + elements[0].toString());
        
        Set<String> set = new HashSet<String>();
        for (XmlObject o : elements) {
        	String name = XmlUtil.getElemName(o);
        	if (!set.contains(name))
        		set.add(name);
        }
        System.out.println("Total CIM Types " + set.size());
        System.out.println("Type Details " + set.toString());		
        
        // Find out top topological type
    	int n = 0;
    	n = findTopType(cimXmlObj, "TopologicalIsland", "Topological");
        	
        if ( n == 0 )
        	n = findTopType(cimXmlObj, "TopologicalNode", "Topological");
        
        if ( n == 0 )
        	n = findTopType(cimXmlObj, "ConnectivityNode", "Topological");

        n = 0;
        // Find out top Operation type
    	n = findTopType(cimXmlObj, "SubControlArea", "Operational");
    	
    	if (n == 0)
        	n = findTopType(cimXmlObj, "Substation", "Operational");

    	if (n == 0)
        	n = findTopType(cimXmlObj, "VoltageLevel", "Operational");
    	
    	if (n == 0)
        	n = findTopType(cimXmlObj, "Bay", "Operational");
	}
	
	private static int findTopType(XmlObject cimXmlObj, String typeName, String viewName) {
		XmlObject[] elements = cimXmlObj.selectPath(XmlUtil.CIMNSDeclare + "$this/rdf:RDF/cim:" 
				+ typeName);
        if (elements.length > 0)
            System.out.println("Top " + viewName + " Type: " + typeName);
		return elements.length;
	}
}
