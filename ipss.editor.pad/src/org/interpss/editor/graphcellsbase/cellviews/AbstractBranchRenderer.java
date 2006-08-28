package org.interpss.editor.graphcellsbase.cellviews;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

import org.jgraph.graph.EdgeRenderer;
import org.jgraph.graph.EdgeView;
import org.jgraph.graph.GraphConstants;
import org.jgraph.util.Bezier;
import org.jgraph.util.Spline2D;

/**
*	Branch view renderer
*/

public abstract class AbstractBranchRenderer extends EdgeRenderer {       
	/**
	 * Returns the shape that represents the current edge
	 * in the context of the current graph.
	 * This method sets the global beginShape, lineShape
	 * and endShape variables as a side-effect.
	 */
	protected Shape createShape() {
		int n = view.getPointCount();
		if (n > 1) {
			// Following block may modify static vars as side effect (Flyweight Design)
			EdgeView tmp = view;
			Point2D[] p = new Point2D[n];
			for (int i = 0; i < n; i++)
				p[i] = tmp.getAttributes().createPoint(tmp.getPoint(i));
			// End of Side-Effect Block
			// Undo Possible MT-Side Effects
			if (view != tmp) {
				view = tmp;
				installAttributes(view);
			}
			// End of Undo
			if (view.sharedPath == null) {
				view.sharedPath = new GeneralPath(GeneralPath.WIND_NON_ZERO);
			} else {
				view.sharedPath.reset();
			}
			view.beginShape = view.lineShape = view.endShape = null;
			Point2D p0 = p[0];
			Point2D pe = p[n - 1];
			Point2D p1 = p[1];
			Point2D p2 = p[n - 2];
          
			if(lineStyle == GraphConstants.STYLE_BEZIER && n > 2) {
				bezier = new Bezier(p);
				p2 = bezier.getPoint(bezier.getPointCount()-1);
			} else if(lineStyle == GraphConstants.STYLE_SPLINE && n > 2) {
				spline = new Spline2D(p);
				double[] point = spline.getPoint(0.99);
				p2.setLocation(point[0], point[1]);
			}
			
			if (beginDeco != GraphConstants.ARROW_NONE) {
				view.beginShape = createLineEnd(beginSize, beginDeco, p1, p0);
			}
			if (endDeco != GraphConstants.ARROW_NONE) {
				view.endShape = createLineEnd(endSize, endDeco, p2, pe);
			}
			view.sharedPath.moveTo((float) p0.getX(), (float) p0.getY());

			if (lineStyle == GraphConstants.STYLE_BEZIER && n > 2) {
				Point2D[] b = bezier.getPoints();
				view.sharedPath.quadTo((float) b[0].getX(), (float) b[0].getY(), (float) p1.getX(), (float) p1.getY());
				for (int i = 2; i < n - 1; i++) {
					Point2D b0 = b[2*i-3];
					Point2D b1 = b[2*i-2];
					view.sharedPath.curveTo(
						(float) b0.getX(),
						(float) b0.getY(),
						(float) b1.getX(),
						(float) b1.getY(),
						(float) p[i].getX(),
						(float) p[i].getY());
				}
				view.sharedPath.quadTo(
					(float) b[b.length-1].getX(),
					(float) b[b.length-1].getY(),
					(float) p[n - 1].getX(),
					(float) p[n - 1].getY());
			}
			else if (lineStyle == GraphConstants.STYLE_SPLINE && n > 2) {
				for (double t = 0; t <= 1; t += 0.01) {
					double[] xy = spline.getPoint(t);
					view.sharedPath.lineTo((float) xy[0], (float) xy[1]);
				}
			}
            /* The above is copied from EdgeRenderer class without modification, the following part are for InterPSS application */
                        
			else {
                for (int i = 1; i < n/2; i++) {
                    view.sharedPath.lineTo((float)p[i].getX(), (float)p[i].getY());
                }        
                
                Point pp1 = new Point((int)Math.round(p[n/2 - 1].getX()), (int)Math.round(p[n/2 - 1].getY()));
                Point pp2 = new Point((int)Math.round(p[n/2].getX()), (int)Math.round(p[n/2].getY()));
                addBranchSymbol(view.sharedPath, beginSize, pp1, pp2, view);

                for (int i = n/2; i < n - 1; i++) {
                    view.sharedPath.lineTo((float)p[i].getX(), (float)p[i].getY());
                }                    
                view.sharedPath.lineTo((float)pe.getX(), (float)pe.getY());                            
			}
			view.sharedPath.moveTo((float) pe.getX(), (float) pe.getY());
			view.lineShape = (GeneralPath) view.sharedPath.clone();
			if (view.endShape != null)
				view.sharedPath.append(view.endShape, true);
			if (view.beginShape != null)
				view.sharedPath.append(view.beginShape, true);
			return view.sharedPath;
		}
		return null;                        
	}
        
	protected Shape createCircle(int size, Point src, Point dst) {
		int d = (int) Math.max(1, dst.distance(src));
		int ax = - (size * (dst.x - src.x) / d);
		int ay = - (size * (dst.y - src.y) / d);
		return new Ellipse2D.Float( dst.x + ax / 2 - size / 2,
                                            dst.y + ay / 2 - size / 2,
                                            size,
                                            size);
	}            

	protected abstract void addBranchSymbol(GeneralPath path, int size, Point src, Point dst, EdgeView aView);
}
