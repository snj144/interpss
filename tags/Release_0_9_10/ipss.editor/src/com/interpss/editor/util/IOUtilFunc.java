package com.interpss.editor.util;

import java.io.FileInputStream;
import java.io.InputStream;

import org.interpss.editor.form.base.BaseBranchForm;
import org.jgraph.JGraph;

import com.interpss.common.util.IpssLogger;
import com.interpss.editor.coreframework.GPGraphpad;
import com.interpss.editor.coreframework.GPSessionParameters;
import com.interpss.editor.jgraph.GraphSpringAppContext;
import com.interpss.editor.jgraph.cells.GraphUtilFunc;
import com.interpss.editor.project.IpssGraphCodec;

public class IOUtilFunc  {
	/**
	 * Create a JGraph object and Load a Ipss graphic file into the object
	 * 
	 * @param filename
	 * @return the JGraph object
	 */
	public static JGraph loadIpssGraphFile(String filename) {
		GPGraphpad pad = new GPGraphpad((GPSessionParameters)null); 
		JGraph graph = GraphSpringAppContext.getIpssGraph();
		
		try {
			InputStream in = new FileInputStream(filename);					
			BaseBranchForm.XmlBinding = false;
			IpssGraphCodec.getInstance(pad).read(in, graph);
			BaseBranchForm.XmlBinding = true;
			GraphUtilFunc.rebuildLabelRelationship(graph);
		} catch (Exception e) {
			IpssLogger.logErr(e);
		}
		return graph;
	}
}
