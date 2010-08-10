package org.interpss.sample.gml;

import java.util.List;

import org.graphdrawing.gml.GraphType;
import org.graphdrawing.gml.GraphmlType;

public class TestCode {
	public static void main(String[] args) throws Exception {
		// load the Gml file
		GraphmlType gml = GmlHelper.load("testData/gml/sample_002.gml");
		
		// retrieve all Graph objects, there may be more than one graphs
		List<GraphType> glist = GmlHelper.getGraphObjects(gml);
		System.out.println("no of graphes: " + glist.size());
	}
}
