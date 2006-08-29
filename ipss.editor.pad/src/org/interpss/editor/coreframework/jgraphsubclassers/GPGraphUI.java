package org.interpss.editor.coreframework.jgraphsubclassers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ByteArrayOutputStream;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.TransferHandler;

import org.interpss.editor.coreframework.GPDocument;
import org.interpss.editor.jgraph.GraphSpringAppContext;
import org.interpss.editor.jgraph.cells.BranchEdge;
import org.interpss.editor.jgraph.cells.BusCell;
import org.interpss.editor.jgraph.cells.LabelCell;
import org.interpss.editor.jgraph.cells.SimpleLabelCell;
import org.jgraph.JGraph;
import org.jgraph.graph.ConnectionSet;
import org.jgraph.graph.GraphTransferHandler;
import org.jgraph.graph.GraphTransferable;
import org.jgraph.graph.ParentMap;
import org.jgraph.plaf.basic.BasicGraphUI;

import com.interpss.common.util.IpssLogger;

/**
 * The base class JGraph BasicGraphUI subclasser for GPGraphpad. It allows to
 * render backround pictures and handles the copy/paste outside from GPGraphpad.
 */
public class GPGraphUI extends BasicGraphUI {

	GPDocument document;

	public void setDocument(GPDocument document) {
		this.document = document;
	}

	public GPGraphUI() {
		super();
	}

	//
	// Override Parent Methods
	//
	// @jdk14
	protected TransferHandler createTransferHandler() {
		return new GPTransferHandler();
	}

	/**
	 * Paint the background of this graph. Calls paintGrid.
	 */
	protected void paintBackground(Graphics g) {
		Rectangle pageBounds = graph.getBounds();
		if (document == null)
			return;
		if (document.getBackgroundImage() != null) {
			// Use clip and pageBounds
			double s = graph.getScale();
			Graphics2D g2 = (Graphics2D) g;
			AffineTransform tmp = g2.getTransform();
			g2.scale(s, s);
			g.drawImage(document.getBackgroundImage(), 0, 0, graph);
			g2.setTransform(tmp);
		} else if (document.isPageVisible()) { // FIX: Use clip
			int w = (int) (document.getPageFormat().getWidth());
			int h = (int) (document.getPageFormat().getHeight());
			Point2D p = graph.toScreen(new Point(w, h));
			w = (int) p.getX();
			h = (int) p.getY();
			g.setColor(graph.getHandleColor());
			g.fillRect(0, 0, graph.getWidth(), graph.getHeight());
			g.setColor(Color.darkGray);
			g.fillRect(3, 3, w, h);
			g.setColor(graph.getBackground());
			g.fillRect(1, 1, w - 1, h - 1);
			pageBounds = new Rectangle(0, 0, w, h);
		}
		if (graph.isGridVisible())
			paintGrid(graph.getGridSize(), g, pageBounds);
	}



	protected boolean startEditing(Object cell, MouseEvent event) {
		completeEditing();

		if (cell instanceof SimpleLabelCell) {
			return super.startEditing(cell, event);
		} else if (cell instanceof LabelCell) {
			LabelCell lcell = (LabelCell) cell;
			if (lcell.getParentCell() instanceof BusCell
					|| lcell.getParentCell() instanceof BranchEdge) {
				IpssLogger
						.getLogger()
						.info(
								"Starting Editing a Bus/Branch object and launch Bus Dialog");
				GraphSpringAppContext.getEditorDialog(lcell.getParentCell(),
						document.getGraph());
				graph.clearSelection();
				return true;
			}
		} else if (cell instanceof BusCell || cell instanceof BranchEdge) {
			IpssLogger
					.getLogger()
					.info(
							"Starting Editing a Bus/Branch object and launch Bus/BranchEditor Dialog");
			GraphSpringAppContext.getEditorDialog(cell, document.getGraph());
			graph.clearSelection();
			return true;
		}

		return false;
	}

	public GPDocument getDocument() {
		return document;
	}
}
