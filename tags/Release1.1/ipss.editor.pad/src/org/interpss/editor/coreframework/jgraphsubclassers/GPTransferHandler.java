package org.interpss.editor.coreframework.jgraphsubclassers;

import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.TransferHandler;

import org.jgraph.JGraph;
import org.jgraph.graph.AttributeMap;
import org.jgraph.graph.CellView;
import org.jgraph.graph.ConnectionSet;
import org.jgraph.graph.DefaultGraphModel;
import org.jgraph.graph.GraphConstants;
import org.jgraph.graph.GraphLayoutCache;
import org.jgraph.graph.GraphModel;
import org.jgraph.graph.GraphTransferHandler;
import org.jgraph.graph.GraphTransferable;
import org.jgraph.graph.ParentMap;
import org.interpss.editor.jgraph.cells.AnnotateLabelCell;
import org.interpss.editor.jgraph.cells.BusCell;
import org.interpss.editor.jgraph.cells.LabelCell;
public class GPTransferHandler extends GraphTransferHandler {

	
	protected Transferable createTransferable(JGraph graph, Object[] cells) {
		Object[] flat = graph.getDescendants(graph.order(getCopyCells(cells)));
		ParentMap pm = ParentMap.create(graph.getModel(), flat, false, true);
		ConnectionSet cs = ConnectionSet.create(graph.getModel(), flat, false);
		Map viewAttributes = GraphConstants.createAttributes(flat, graph
				.getGraphLayoutCache());
		Rectangle2D bounds = graph.getCellBounds(graph.getSelectionCells());
		bounds = new AttributeMap.SerializableRectangle2D(bounds.getX(), bounds
				.getY(), bounds.getWidth(), bounds.getHeight());
		out = flat;
		return create(graph, flat, viewAttributes, bounds, cs, pm);
	}
	
	private Object[] getCopyCells(Object[] cells) {
		
		java.util.List list = new ArrayList();
		for (int i = 0; i < cells.length; i++) {
			if (!((cells[i] instanceof LabelCell) && (((LabelCell) cells[i])
					.getParentCell() instanceof BusCell))) {
				list.add(cells[i]);
				if (cells[i] instanceof BusCell) {
					list.add(((BusCell) cells[i]).getLabel());
					list.add(((BusCell) cells[i]).get_labelAnnotate());
				}
			}
		}
		return list.toArray();
	}
}