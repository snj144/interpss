 /*
  * @(#)GmlHelper.java   
  *
  * Copyright (C) 2010 www.interpss.org
  *
  * This program is free software; you can redistribute it and/or
  * modify it under the terms of the GNU LESSER GENERAL PUBLIC LICENSE
  * as published by the Free Software Foundation; either version 2.1
  * of the License, or (at your option) any later version.
  *
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  *
  * @Author Mike Zhou
  * @Version 1.0
  * @Date 08/15/2010
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.sample.gml;

import java.io.File;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.graphdrawing.gml.EdgeType;
import org.graphdrawing.gml.GraphType;
import org.graphdrawing.gml.GraphmlType;
import org.graphdrawing.gml.NodeType;

import com.interpss.common.exp.InterpssException;
import com.interpss.common.util.NetUtilFunc;
import com.interpss.common.util.StringUtil;
import com.interpss.core.aclf.adj.AclfAdjNetwork;

public class GmlHelper {
	/**
	 * create GraphmlType object from the xml file
	 * 
	 * @param filename
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static GraphmlType load(String filename) throws Exception {
		File file = new File(filename);
		JAXBElement<GraphmlType> elem = 
			(JAXBElement<GraphmlType>)createUnmarshaller().unmarshal(file);
		return elem.getValue();
	}
	
	/**
	 * create GraphmlType object from the input stream
	 * 
	 * @param in
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static GraphmlType load(InputStream in) throws Exception {
		JAXBElement<GraphmlType> elem = 
			(JAXBElement<GraphmlType>)createUnmarshaller().unmarshal(in);
		return elem.getValue();
	}
	
	/**
	 * get all GraphType objects from the GraphmlType object
	 * 
	 * @param gml
	 * @return
	 */
	public static List<GraphType> getGraphObjects(GraphmlType gml) {
		List<GraphType> glist = new LinkedList<GraphType>();
		for (Object obj : gml.getGraphOrData()) {
			if (obj instanceof GraphType) {
				GraphType graph = (GraphType)obj;
				glist.add(graph);
			}
		}
		return glist;
	}
	
	/**
	 * Based on the GraphType object, create a sub network from the fromNet
	 * 
	 * @param fromNet
	 * @param gmlGraph
	 * @return
	 * @throws InterpssException
	 */
	public static AclfAdjNetwork createSubNet(AclfAdjNetwork fromNet, GraphType gmlGraph) throws InterpssException {
		List<String> busIdList = new LinkedList<String>();
		List<String> branchIdList = new LinkedList<String>();
		// get bus id and branch id from the graph object
		for ( Object o : gmlGraph.getDataOrNodeOrEdge()) {
			if (o instanceof NodeType) {
				NodeType node = (NodeType)o;
				//System.out.println("Node: " + node.getId());
				busIdList.add(node.getId());
			}
			else if (o instanceof EdgeType) {
				EdgeType edge = (EdgeType)o;
				//System.out.println("Edge: " + edge.getSource() + "->" + edge.getTarget());
				// TODO branch cir number should be considered
				branchIdList.add(NetUtilFunc.formBranchId(edge.getSource(), edge.getTarget()));
			}
		}
		String[] busIdAry = StringUtil.convertObjectAry2StrAry(busIdList.toArray());
		String[] branchIdAry = StringUtil.convertObjectAry2StrAry(branchIdList.toArray());

		// create a sub network from the original AclfNetwork object, based
		// on the bus ids and branch ids in the graph object
		return fromNet.createSubAclfAdjNet(busIdAry, branchIdAry);
	}

/*
 * 	private area	
 */
	
	private static Unmarshaller unmarshaller = null;
	private static Unmarshaller createUnmarshaller() throws JAXBException {
		if (unmarshaller == null) {
			JAXBContext jaxbContext = JAXBContext.newInstance("org.graphdrawing.gml");
			unmarshaller = jaxbContext.createUnmarshaller();
		}
		return unmarshaller;
	}
}
