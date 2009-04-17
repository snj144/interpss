package org.interpss.editor.graphcellsbase.cellviews;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import org.interpss.editor.jgraph.cells.BusCell;
import org.jgraph.graph.CellViewRenderer;
import org.jgraph.graph.GraphConstants;
import org.jgraph.graph.VertexRenderer;
import org.jgraph.graph.VertexView;



/**
 * @author Gaudenz Alder
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class JGraphBusView extends VertexView {
    
	protected static transient BusViewRenderer renderer = new BusViewRenderer();
    
    public JGraphBusView() {
        super();
    }
	
    public JGraphBusView(Object cell) {
        super(cell);
    }
    
    public CellViewRenderer getRenderer() {
        return renderer;
    }

	/**
	* 	Set attributes for rotating the bus orientation
	*/
	public void rotateSetAttributes() {
		Rectangle2D bound = GraphConstants.getBounds(allAttributes);
		GraphConstants.setBounds(allAttributes, 
				new Rectangle((int) bound.getX(), (int) bound.getY(),
						(int)bounds.getHeight(), (int)bounds.getWidth()));
		getBusCell().getAttributes().applyMap(allAttributes);
	}
	/**
	*	Get the BusCell ojbect associated with this view
	*
	* @return the cell
	*/
	public BusCell getBusCell() {
		return (BusCell)getCell();
	}
	/**
	 * Overrides the parent method to udpate the cached points.
	 */
	public void update() {
		super.update();
		Rectangle2D bound = GraphConstants.getBounds(allAttributes);
		if ( getBusCell().isHorizontal() )
			GraphConstants.setBounds(allAttributes, 
					new Rectangle((int) bound.getX(), (int) bound.getY(),
							(int)bounds.getWidth(), BusCell.DefaultBusWidth));
		else 
			GraphConstants.setBounds(allAttributes, 
					new Rectangle((int) bound.getX(), (int) bound.getY(),
							BusCell.DefaultBusWidth, (int)bounds.getHeight()));
	}
	
	/**
	 * Returns the intersection of the bounding rectangle and the
	 * straight line between the source and the specified point p.
	 * The specified point is expected not to intersect the bounds.
	 */
	public Point getPerimeterPoint(Point source, Point p) {
		Rectangle r = (Rectangle)getBounds();
		
		double x = r.getX();
		double y = r.getY();
		double a = (r.getWidth() + 1) / 2;
		double b = (r.getHeight() + 1) / 2;
		
		// x0,y0 - center of ellipse
		double x0 = x + a;
		double y0 = y + b;

		Point point = null;
		if (getBusCell().isVertical()) {
			if ( x0 > p.x)
				point = new Point((int)r.getX(), (int)(y0));
			else 	
				point = new Point((int)(r.getX()+r.getWidth()-1), (int)(y0));
		}
		else {
			if ( y0 > p.y)
				point = new Point((int)(x0), (int)(r.getY()));
			else 	
				point = new Point((int)(x0), (int)(r.getY()+r.getHeight()-1));
		}

		return point;
	}
    
    public static class BusViewRenderer extends VertexRenderer {
        
    	public void paint(Graphics g) {
    		int b = borderWidth;
    		Graphics2D g2 = (Graphics2D) g;

    		Dimension d = getSize();
    		
    		boolean tmp = selected;
    			
    		if (super.isOpaque()) {
    			g.setColor(super.getBackground());
    			g.fillRect(b - 1, b - 1, d.width - b, d.height - b);
    		}
    			
    		try {
    			setBorder(null);
    			setOpaque(false);
    			selected = false;
    			super.paint(g);
    		} finally {
    			selected = tmp;
    		}
    			
    		if (bordercolor != null) {
    			g.setColor(bordercolor);
    			g2.setStroke(new BasicStroke(b));
    			g.drawRect(b - 1, b - 1, d.width - b, d.height - b);
    		}
    			
    		if (selected) {
    			g2.setStroke(GraphConstants.SELECTION_STROKE);
    			g.setColor(this.highlightColor);
    			g.drawRect(b - 1, b - 1, d.width - b, d.height - b);
    		}
    	}
//        protected void installAttributes(JGraph graph, Map attributes) {
////            setOpaque(GraphConstants.isOpaque(attributes));
////            Color foreground = GraphConstants.getForeground(attributes);
////            setForeground((foreground != null) ? foreground : graph.getForeground());
////            Color background = GraphConstants.getBackground(attributes);
////            setBackground((background != null) ? background : graph.getBackground());
////            Font font = GraphConstants.getFont(attributes);
////            setFont((font != null) ? font : graph.getFont());
//            Border border= GraphConstants.getBorder(attributes);
//            Color bordercolor = GraphConstants.getBorderColor(attributes);
//            if(border != null)
//                setBorder(border);
//            else if (bordercolor != null) {
//                int borderWidth = Math.max(1, Math.round(GraphConstants.getLineWidth(attributes)));
//                setBorder(BorderFactory.createLineBorder(bordercolor, borderWidth));
//            }
////            else if (bordercolor == null)//case with no border
////            {
////            	setBorder(BorderFactory.createLineBorder(null, 0));
////            }
////    		gradientColor = GraphConstants.getGradientColor(attributes);
//        }
    }
  
}
