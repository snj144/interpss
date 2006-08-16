package com.interpss.editor.jgraph.cells;

import org.jgraph.JGraph;
import org.jgraph.graph.Port;

public interface IIpssEdge {
	public void connect(JGraph graph, Port aSource, Port aTarget) ;
}
