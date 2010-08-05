package org.interpss.sample.gml;

import java.io.File;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.graphdrawing.gml.GraphmlType;

public class GmlHelper {
	@SuppressWarnings("unchecked")
	public static GraphmlType load(String filename) throws Exception {
		File file = new File(filename);
		JAXBElement<GraphmlType> elem = 
			(JAXBElement<GraphmlType>)createUnmarshaller().unmarshal(file);
		return elem.getValue();
	}
	
	@SuppressWarnings("unchecked")
	public static GraphmlType load(InputStream in) throws Exception {
		JAXBElement<GraphmlType> elem = 
			(JAXBElement<GraphmlType>)createUnmarshaller().unmarshal(in);
		return elem.getValue();
	}
	
	private static Unmarshaller unmarshaller = null;
	private static Unmarshaller createUnmarshaller() throws JAXBException {
		if (unmarshaller == null) {
			JAXBContext jaxbContext = JAXBContext.newInstance("org.graphdrawing.gml");
			unmarshaller = jaxbContext.createUnmarshaller();
		}
		return unmarshaller;
	}		
}
