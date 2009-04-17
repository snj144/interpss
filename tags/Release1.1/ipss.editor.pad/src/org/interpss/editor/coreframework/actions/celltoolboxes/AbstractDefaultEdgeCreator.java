/*
 * Created on 17 juin 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.interpss.editor.coreframework.actions.celltoolboxes;

import java.awt.geom.Point2D;

import org.interpss.editor.jgraph.cells.IIpssEdge;
import org.interpss.editor.util.IEdgeFactory;
import org.jgraph.graph.AttributeMap;
import org.jgraph.graph.GraphCell;
import org.jgraph.graph.Port;
import org.jgraph.graph.PortView;


/**
 * @author Raphael Valyi
 * 
 * This is the super class of various java beans containing their own data for the
 * default cell creation of a given graph cell EDGE type once a button is pressed. This class
 * contains generic methods to insert the cell in the graph model.
 * @see org.jgraph.pad.actions.celltoolboxes.ToolBoxLine
 * @see org.jgraph.pad.actions.celltoolboxes.ToolBoxEdge
 */
public abstract class AbstractDefaultEdgeCreator extends AbstractCellCreator
		implements IEdgeFactory {
	
	private boolean isButtonDoChanges= false;
//	public void actionPerformed(ActionEvent e) {
//		super.actionPerformed(e);
//		graphpad.getCurrentGraph().setPortsVisible(true);
//	}
	
//	public AbstractDefaultEdgeCreator() {
//		super();
//		graphpad.getCurrentGraph().setPortsVisible(true);
//	}
//	public GraphCell addEdge(Point2D start, Point2D current,
//			PortView firstPort, PortView port) {
//		
//		// creation of the cell:
//		GraphCell cell = createCell();
////		Object label = getCellLabel();
////
////		// creation of the cell model (user object) and/or properties map:
////		Map properties = getUserObjectProperties(cell);
////		ICellBuisnessObject user = (ICellBuisnessObject) GPPluginInvoker.instanciateObjectForKey("UserObject.class");
////		user.setProperties(properties);
////		user.setValue(label);
////		if (cell instanceof MutableTreeNode)
////			((MutableTreeNode) cell).setUserObject(user);
//
//		// view attributes creation:
//		AttributeMap attributeMap = new AttributeMap();
//
//		Point tempPoint = new Point((int) start.getX(), (int) start.getY());
//		Point tempPoint2 = new Point((int) current.getX(), (int) current.getY());
//		Point2D p = graphpad.getCurrentGraph().fromScreen(new Point(tempPoint));
//		Point2D p2 = graphpad.getCurrentGraph().fromScreen(
//				new Point(tempPoint2));
//		ArrayList list = new ArrayList();
//		list.add(p);
//		list.add(p2);
//
//		GraphConstants.setPoints(attributeMap, list);
//
//		Map viewMap = new Hashtable();
//
//		if (firstPort != null && port != null) {
//			// Count directed parallel edges only
//			Object[] edges = DefaultGraphModel.getEdgesBetween(graphpad
//					.getCurrentGraph().getModel(), firstPort.getCell(), port
//					.getCell(), true);
//			if (edges != null && edges.length > 0) {
//				Edge.Routing router = FormatRoutingParallel.parallelEdgeRouter;
//				Map tmpMap = new Hashtable();
//				GraphConstants.setRouting(tmpMap, router);
//				GraphConstants
//						.setLineStyle(tmpMap, GraphConstants.STYLE_BEZIER);
//				for (int i = 0; i < edges.length; i++) {
//					EdgeView view = (EdgeView) graphpad.getCurrentGraph()
//							.getGraphLayoutCache().getMapping(edges[i], false);
//					if (view != null
//							&& GraphConstants.getRouting(view
//									.getAllAttributes()) == null
//							&& view.getPointCount() < 3)
//						viewMap.put(edges[i], tmpMap);
//				}
//				GraphConstants.setRouting(attributeMap, router);
//				GraphConstants.setLineStyle(attributeMap,
//						GraphConstants.STYLE_BEZIER);
//			}
//		}
//
//		attributeMap = adaptAttributeMap(cell, attributeMap);
//
//		// insertion of the cell:
//		viewMap.put(cell, attributeMap);
//
//		viewMap.put(cell, attributeMap);
//		Object[] insert = new Object[] { cell };
//		ConnectionSet cs = new ConnectionSet();
//		if (firstPort != null)
//			cs.connect(cell, firstPort.getCell(), true);
//		if (port != null)
//			cs.connect(cell, port.getCell(), false);
//		graphpad.getCurrentGraph().getGraphLayoutCache().insert(insert,
//				viewMap, cs, null, null);
//
//		return cell;
//	}
	


	public GraphCell addEdge(Point2D start, Point2D current,
			PortView firstPort, PortView port) {
		
		// creation of the cell:
		GraphCell cell = createCell();

		((IIpssEdge)cell).connect(graphpad.getCurrentGraph(),(Port)firstPort.getCell(),(Port)port.getCell());
		actionForCell(cell);
		return cell;
	}
	/**
	 * override it if you need
	 */
	public AttributeMap adaptAttributeMap(GraphCell cell,
			AttributeMap attributeMap) {
		return attributeMap;
	}
	
    public void actionForButtonDown() {
		if (!getCurrentGraph().isPortsVisible())
		{
			graphpad.getCurrentGraph().setPortsVisible(true);
			isButtonDoChanges = true;
		}
    	
    	
    }
    public void actionForButtonUp() {
    	if (isButtonDoChanges)
    		graphpad.getCurrentGraph().setPortsVisible(false);
    	isButtonDoChanges= false;
    }
}
