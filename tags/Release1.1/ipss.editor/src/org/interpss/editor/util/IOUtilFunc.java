package org.interpss.editor.util;

import java.io.FileInputStream;
import java.io.InputStream;

import org.interpss.editor.coreframework.GPGraphpad;
import org.interpss.editor.coreframework.GPSessionParameters;
import org.interpss.editor.form.base.BaseBranchForm;
import org.interpss.editor.jgraph.GraphSpringAppContext;
import org.interpss.editor.jgraph.cells.GraphUtilFunc;
import org.interpss.editor.project.IpssGraphCodec;
import org.jgraph.JGraph;

import com.interpss.common.util.IpssLogger;

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
