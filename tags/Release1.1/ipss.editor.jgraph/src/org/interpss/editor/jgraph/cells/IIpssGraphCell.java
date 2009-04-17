package org.interpss.editor.jgraph.cells;

import java.awt.geom.Rectangle2D;

import org.jgraph.JGraph;
import org.jgraph.graph.DefaultGraphCell;

public interface IIpssGraphCell {

	public void insert(JGraph graph,Rectangle2D bounds);
}
