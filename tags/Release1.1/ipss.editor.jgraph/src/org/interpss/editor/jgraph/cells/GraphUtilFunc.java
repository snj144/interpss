package org.interpss.editor.jgraph.cells;


import java.awt.Dimension;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

import org.interpss.editor.jgraph.ui.form.IGBusForm;
import org.jgraph.JGraph;



public class GraphUtilFunc {

	/**
	 * Returns the label position of the specified view in the given graph.
	 */
	public static Rectangle2D getLabelPosition(double scale,Dimension d, Rectangle2D bounds, int offset, String postion) {
		if (bounds != null && d != null) {
			double x=0.0, y=0.0;
			if (BusCell.LABEL_POSITION_CENTER.equals(postion)) {
				x = bounds.getX() + 0.5*(bounds.getWidth() - d.width);
				y = bounds.getY() + 0.5*(bounds.getHeight() - d.height);
			}
			else if (BusCell.LABEL_POSITION_UP.equals(postion)) {
				x = bounds.getX() + 0.5*(bounds.getWidth() - d.width);
				y = bounds.getY() - ( offset + d.height );
			}
			else if (BusCell.LABEL_POSITION_LEFT.equals(postion)) {
				x = bounds.getX() - ( offset + d.width );
				y = bounds.getY()+ 0.5*(bounds.getHeight());
			}
			else if (BusCell.LABEL_POSITION_RIGHT.equals(postion)) {
				x = bounds.getX() - ( offset + d.height);
				y = bounds.getY() - 0.5*(bounds.getHeight() - d.height);
			}
			else if (BusCell.LABEL_POSITION_DOWN.equals(postion)) {
				x = bounds.getX()+ 0.5*(bounds.getWidth() - d.width);
				y = bounds.getY() + offset;
			}
			return new Double(x*scale, y*scale, d.width*scale, d.height*scale);
		}
		return null;
	}
	
	/**
	* Returns the BusCell identified by the id
	*
	* @param id the id
	* @param graph the graph object
	* @return the BusCell found
	*/
	public static BusCell getBusCell(String id, JGraph graph) {
		Object[] cells = graph.getDescendants(graph.getRoots());
		for (int i = 0; i < cells.length; i++ ) {
			if (cells[i] instanceof BusCell) {
				BusCell cell = (BusCell)cells[i];
				IGBusForm form = (IGBusForm)cell.getUserObject();
				if (id.equals(form.getId()))
					return cell;
			}
		}
		return null;
	}
	
	/**
	* Rebuid the LabelCell and BusCell/BranchEdge relationship
	*
	* @param graph the graph object
	*/
	public static void rebuildLabelRelationship(JGraph graph) {
		Object[] cells = graph.getDescendants(graph.getRoots());
		for (int i = 0; i < cells.length; i++ ) {
			/*
			 * AnnotateLabelCell is a child of LabelCell, so we have to check it first here
			 */
			if (cells[i] instanceof AnnotateLabelCell) {
				AnnotateLabelCell cell = (AnnotateLabelCell)cells[i];
				if (cell.getUserObject() instanceof IGBusForm) {
					IGBusForm form = (IGBusForm)cell.getUserObject();
					BusCell bus = getBusCell(form.getId(), graph);
					if (bus != null) {
						bus.set_labelAnnotate(cell);
						cell.setParentCell(bus);
					}
				}	
			}	
			else if (cells[i] instanceof LabelCell) {
				LabelCell cell = (LabelCell)cells[i];
				if (cell.getUserObject() instanceof IGBusForm) {
					IGBusForm form = (IGBusForm)cell.getUserObject();
					BusCell bus = getBusCell(form.getId(), graph);
					if (bus != null) {
						bus.setLabel(cell);
						cell.setParentCell(bus);
					}
				}	
			}	
		}
	}
	
}
