package com.interpss.editor.graphcellsbase.cellviews;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import org.jgraph.graph.CellViewRenderer;
import org.jgraph.graph.EdgeView;

import com.interpss.editor.form.GBranchForm;
import com.interpss.editor.jgraph.cells.BranchEdge;
import com.interpss.editor.jgraph.cells.BusCell;


public class JGraphBranchEdgeView extends EdgeView {
	private static final long serialVersionUID = 1;
	public static int Pos_Offset = 15;
	protected static transient BranchRenderer renderer = new BranchRenderer();

	
    public JGraphBranchEdgeView() {
        super();
    }
	/**
	*	Constructor
	*
	* @param cell branch cell object
	* @param graph the graph object
	* @param cell to view mapper object
	*/
	public JGraphBranchEdgeView(Object cell) {
		super(cell);
	}
	/**
	 * 	Returns a renderer for the class.
	 *
	 * @return the renderer
	 */
	public CellViewRenderer getRenderer() {
		if (getPointCount() == 2) 
			addDrawPoints();
		return renderer;
	} 
	/**
	* 	Get the BranchEdge object associated with this view
	* @return the edge object
	*/
	public BranchEdge getBranchEdge() {
		return(BranchEdge)getCell();
	}
	/**
	* Override Superclass Method - when Shift-click, add a point
	*
	* @param event a mouse event
	* @return true or false
	*/
	public boolean isAddPointEvent(MouseEvent event) {
		// Points are Added using Shift-Click
		return event.isShiftDown();
	}

	/**
	* Override Superclass Method - when Shift-click and a branch point is clicked,
	* remove the point
	*
	* @param event a mouse event
	* @return true or false
	*/
	public boolean isRemovePointEvent(MouseEvent event) {
		// Points are Removed using Shift-Click
		return event.isShiftDown();
	}

	/**
	 * Add two drawing points to the branch.
	 */
	public void addDrawPoints() {
		BusCell sbus = getBranchEdge().getSourceBus();
		BusCell tbus = getBranchEdge().getTargetBus();
/** added by mike */      
        if (sbus == null || tbus == null)
            return;
/** end */      
        Point2D p1 =  getPoint(0);
		Point2D p2 =  getPoint(1);
		if (sbus.isVertical()) {
			if (p1.getX() < p2.getX() ) 
				addPoint(1, new Point2D.Float((float)p1.getX()+Pos_Offset, (float)p1.getY()));
			else 
				addPoint(1, new Point2D.Float((float)p1.getX()-Pos_Offset, (float)p1.getY()));
		}		
		else {
			if (p1.getY() < p2.getY() ) 
				addPoint(1, new Point2D.Float((float)p1.getX(), (float)p1.getY()+Pos_Offset));
			else if (p1.getY() > p2.getY()) 
				addPoint(1, new Point2D.Float((float)p1.getX(), (float)p1.getY()-Pos_Offset));
		}
		
		if (tbus.isVertical()) {
			if (p1.getX() < p2.getX() ) 
				addPoint(2, new Point2D.Float((float)p2.getX()-Pos_Offset, (float)p2.getY()));
			else 
				addPoint(2, new Point2D.Float((float)p2.getX()+Pos_Offset, (float)p2.getY()));
		}
		else {
			if (p1.getY() > p2.getY()) 
				addPoint(2, new Point2D.Float((float)p2.getX(), (float)p2.getY()+Pos_Offset));
			else  
				addPoint(2, new Point2D.Float((float)p2.getX(), (float)p2.getY()-Pos_Offset));
		}
	}
        
	/**  
	*  	Return branch form object for rendering 
	*
	* @return the Branch form object
	*/
	public GBranchForm getBranchForm() {
		BranchEdge aCell = (BranchEdge)getCell();
		return (GBranchForm)aCell.getUserObject();
	}
	
	
	
}
