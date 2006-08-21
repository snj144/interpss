package com.interpss.editor.graphcellsbase.cellviews;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import org.jgraph.JGraph;
import org.jgraph.graph.CellView;
import org.jgraph.graph.CellViewRenderer;
import org.jgraph.graph.EdgeView;
import org.jgraph.graph.GraphCellEditor;
import org.jgraph.graph.GraphConstants;
import org.jgraph.graph.VertexView;

import com.interpss.editor.coreframework.jgraphsubclassers.GPGraphModel;
import com.interpss.editor.jgraph.cells.AnnotateLabelCell;
import com.interpss.editor.jgraph.cells.BusCell;
import com.interpss.editor.jgraph.cells.LabelCell;
import com.interpss.editor.jgraph.ui.form.IUserData;

/**
 * @author Gaudenz Alder
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class JGraphLabelView extends VertexView {
    
	protected static transient MultiLinedRenderer renderer = new MultiLinedRenderer();
    
    public JGraphLabelView() {
        super();
    }
    
    public JGraphLabelView(Object cell) {
        super(cell);
    }
    
    public CellViewRenderer getRenderer() {
        return renderer;
    }

    public GraphCellEditor getEditor() {
        return null;
    }
    
    public Point2D getPerimeterPoint(EdgeView edge, Point2D source, Point2D p) {
		Rectangle2D bounds = getBounds();
		double x = bounds.getX();
		double y = bounds.getY();
		double width = bounds.getWidth();
		double height = bounds.getHeight();
		double xCenter = x + width / 2;
		double yCenter = y + height / 2;
		double dx = p.getX() - xCenter; // Compute Angle
		double dy = p.getY() - yCenter;
		double alpha = Math.atan2(dy, dx);
		double xout = 0, yout = 0;
		double pi = Math.PI;
		double pi2 = Math.PI / 2.0;
		double beta = pi2 - alpha;
		double t = Math.atan2(height, width);
		if (alpha < -pi + t || alpha > pi - t) { // Left edge
			xout = x;
			yout = yCenter - width * Math.tan(alpha) / 2;
		} else if (alpha < -t) { // Top Edge
			yout = y;
			xout = xCenter - height * Math.tan(beta) / 2;
		} else if (alpha < t) { // Right Edge
			xout = x + width;
			yout = yCenter + width * Math.tan(alpha) / 2;
		} else { // Bottom Edge
			yout = y + height;
			xout = xCenter + height * Math.tan(beta) / 2;
		}
		return new Point2D.Double(xout, yout);
	}
    
    
    public static class MultiLinedRenderer extends JTextArea implements CellViewRenderer {
    	
    	protected transient JGraph graph = null;

    	transient protected Color gradientColor = null;
    	
    	/** Cached hasFocus and selected value. */
    	transient protected boolean hasFocus,
    		selected,
    		preview;

    	public MultiLinedRenderer() {
            setLineWrap(true);
            setWrapStyleWord(true);
        }

        public Component getRendererComponent(
                JGraph graph,
                CellView view,
                boolean sel,
                boolean focus,
                boolean preview) {
        	

            String labelText="";
            LabelCell cell= (LabelCell)view.getCell();
        	if (cell.getParentCell() == null) {
        		if (cell instanceof AnnotateLabelCell)
        			labelText =((GPGraphModel)graph.getModel()).getGFormContainer().getGNetForm().getLabel(IUserData.NET_ANNOTATE_LABEL);
        		else
        			labelText =((GPGraphModel)graph.getModel()).getGFormContainer().getGNetForm().getLabel(IUserData.NET_LABEL);
        	}		
        	else if (cell.getParentCell() instanceof BusCell ) {
        		if (cell instanceof AnnotateLabelCell)
        		    labelText =((BusCell)(cell.getParentCell())).getBusForm().getLabel(IUserData.BUS_ANNOTATE_LABEL);
        		else
        			labelText =((BusCell)(cell.getParentCell())).getBusForm().getLabel(IUserData.BUS_LABEL);
        	}

        	
            setText(labelText);
        	
//            setText(view.getCell().toString());
            this.graph = graph;
            this.selected = sel;
            this.preview = preview;
            this.hasFocus = focus;
            Map attributes = view.getAllAttributes();
            installAttributes(graph, attributes);
            return this;
        }
        
    	public void paint(Graphics g) {
    		try {
    			if (gradientColor != null && !preview) {
    				setOpaque(false);
    				Graphics2D g2d = (Graphics2D) g;
    				g2d.setPaint(new GradientPaint(0, 0, getBackground(), getWidth(),
    						getHeight(), gradientColor, true));
    				g2d.fillRect(0, 0, getWidth(), getHeight());
    			}
    			super.paint(g);
    			paintSelectionBorder(g);
    		} catch (IllegalArgumentException e) {
    			// JDK Bug: Zero length string passed to TextLayout constructor
    		}
    	}

    	/**
    	 * Provided for subclassers to paint a selection border.
    	 */
    	protected void paintSelectionBorder(Graphics g) {
    		((Graphics2D) g).setStroke(GraphConstants.SELECTION_STROKE);
    		if (hasFocus && selected)
    			g.setColor(graph.getLockedHandleColor());
    		else if (selected)
    			g.setColor(graph.getHighlightColor());
    		if (selected) {
    			Dimension d = getSize();
    			g.drawRect(0, 0, d.width - 1, d.height - 1);
    		}
    	}

        protected void installAttributes(JGraph graph, Map attributes) {
            setOpaque(GraphConstants.isOpaque(attributes));
            Color foreground = GraphConstants.getForeground(attributes);
            setForeground((foreground != null) ? foreground : graph.getForeground());
            Color background = GraphConstants.getBackground(attributes);
            setBackground((background != null) ? background : graph.getBackground());
            Font font = GraphConstants.getFont(attributes);
            setFont((font != null) ? font : graph.getFont());
            Border border= GraphConstants.getBorder(attributes);
            Color bordercolor = GraphConstants.getBorderColor(attributes);
            if(border != null)
                setBorder(border);
            else if (bordercolor != null) {
                int borderWidth = Math.max(1, Math.round(GraphConstants.getLineWidth(attributes)));
                setBorder(BorderFactory.createLineBorder(bordercolor, borderWidth));
            }
            else if (bordercolor == null)//case with no border
            {
            	setBorder(BorderFactory.createLineBorder(null, 0));
            }
    		gradientColor = GraphConstants.getGradientColor(attributes);
        }
        
    }
  
}
