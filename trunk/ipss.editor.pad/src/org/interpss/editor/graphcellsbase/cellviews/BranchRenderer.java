package org.interpss.editor.graphcellsbase.cellviews;

import java.awt.Point;
import java.awt.geom.GeneralPath;

import org.interpss.editor.jgraph.ui.form.IGBranchForm;
import org.interpss.editor.jgraph.ui.form.IGNetForm;
import org.jgraph.graph.EdgeView;

import com.interpss.common.util.IpssLogger;


/**
*	AcscBranch view renderer
*/

public class BranchRenderer extends AbstractBranchRenderer {
	private static final long serialVersionUID = 1;

	protected void addBranchSymbol(GeneralPath path, int sz, Point src, Point dst, EdgeView vw) {
        if (vw instanceof JGraphBranchEdgeView == false) return;
        JGraphBranchEdgeView aView = (JGraphBranchEdgeView) vw;
        if (aView.getBranchForm().getAppType().equals(IGNetForm.AppType_Distribution)) {
            String branchType = aView.getBranchForm().getDistBranchData().getBranchCode();
            boolean branchStatus = aView.getBranchForm().getStatus();
            IpssLogger.getLogger().info("Paint dist branch, branchType: " + branchType);
            if (IGBranchForm.DistBranchCode_Feeder.equalsIgnoreCase(branchType)) {
                if (branchStatus) {
                    addClosedFeederSymbol(  path, sz, src, dst); 
                } else {
                    addOpenFeederSymbol(  path, sz, src, dst); 
                }
            } else if (IGBranchForm.DistBranchCode_Xfr.equalsIgnoreCase(branchType) ) {
                if (branchStatus) {
                    addClosedXFormerSymbol(  path, sz, src, dst); 
                } else {
                    addOpenXFormerSymbol(  path, sz, src, dst); 
                }                        
            } else if (IGBranchForm.DistBranchCode_Breaker.equalsIgnoreCase(branchType)) {
                if (branchStatus) {
                    addClosedBreakerSymbol(  path, sz, src, dst); 
                } else {
                    addOpenBreakerSymbol(  path, sz, src, dst); 
                }            
            }
        }
        else {
            String branchType = aView.getBranchForm().getAcscBranchData().getLfCode(); 
            IpssLogger.getLogger().info("Paint Aclf/Acsc branch, branchType: " + branchType);
            boolean branchStatus = aView.getBranchForm().getStatus();
            if (IGBranchForm.TransBranchLfCode_Line.equalsIgnoreCase(branchType)) {
                if (branchStatus) {
                    addClosedFeederSymbol(  path, sz, src, dst); 
                } else {
                    addOpenFeederSymbol(  path, sz, src, dst); 
                }
            } else if (IGBranchForm.TransBranchLfCode_Xfr.equalsIgnoreCase(branchType) || 
            		IGBranchForm.TransBranchLfCode_PsXfr.equalsIgnoreCase(branchType)) {
                if (branchStatus) {
                    addClosedXFormerSymbol(  path, sz, src, dst); 
                } else {
                    addOpenXFormerSymbol(  path, sz, src, dst); 
                }                        
            } 
        }
    }
               
    private void addClosedFeederSymbol(GeneralPath path, int sz, Point src, Point dst) {  
    	//IpssLogger.getLogger().info("addClosedFeederSymbol() called");
        //int d = (int) Math.max(1, dst.distance(src));
        path.lineTo(dst.x, dst.y);
    }    
    
    private void addOpenFeederSymbol(GeneralPath path, int sz, Point src, Point dst) {   
        int d = (int) Math.max(1, dst.distance(src));
        int size = Math.max(2,Math.min(d/4, 2*sz));
        int ax = (size * (dst.x - src.x) / d) / 2;
        int ax2 = Math.round(size / 5.0f * (dst.x - src.x) / d);
        int ay = (size * (dst.y - src.y) / d) / 2; 
        int ay2 = Math.round(size / 5.0f * (dst.y - src.y) / d);
        int size2 = (int) Math.round(Math.sqrt(ax2*ax2 + ay2*ay2));

        Point p1 = new Point((dst.x+src.x)/2 - ax - ax2,(dst.y+src.y)/2 - ay - ay2);
        Point p2 = new Point((dst.x+src.x)/2 - ax,(dst.y+src.y)/2 - ay);
        Point p3 = new Point((dst.x+src.x)/2 + ax,(dst.y+src.y)/2 + ay);
        Point p4 = new Point((dst.x+src.x)/2 + ax + ax2,(dst.y+src.y)/2 + ay + ay2);
                
        path.lineTo(p1.x, p1.y);
        path.append(createCircle(size2, p2, p1), false);
        path.append(createCircle(size2, p3, p4), false);
        path.moveTo(p4.x, p4.y);
    }    
    
    private void addClosedBreakerSymbol(GeneralPath path, int sz, Point src, Point dst) {   
        int d = (int) Math.max(1, dst.distance(src));
        int size = Math.max(2,Math.min(d/4, 2*sz));
        int ax = (size * (dst.x - src.x) / d) / 2;
        int ax2 = Math.round(size / 5.0f * (dst.x - src.x) / d);
        int ay = (size * (dst.y - src.y) / d) / 2; 
        int ay2 = Math.round(size / 5.0f * (dst.y - src.y) / d);
        int size2 = (int) Math.round(Math.sqrt(ax2*ax2 + ay2*ay2));

        Point p1 = new Point((dst.x+src.x)/2 - ax - ax2,(dst.y+src.y)/2 - ay - ay2);
        Point p2 = new Point((dst.x+src.x)/2 - ax,(dst.y+src.y)/2 - ay);
        Point p3 = new Point((dst.x+src.x)/2 + ax,(dst.y+src.y)/2 + ay);
        Point p4 = new Point((dst.x+src.x)/2 + ax + ax2,(dst.y+src.y)/2 + ay + ay2);

        path.lineTo(p1.x, p1.y);
        path.append(createCircle(size2, p1, p2), false);
        path.moveTo(p2.x, p2.y);
        path.lineTo(p3.x, p3.y);
        path.append(createCircle(size2, p3, p4), false);
        path.moveTo(p4.x, p4.y);
    }  
    
    private void addOpenBreakerSymbol(GeneralPath path, int sz, Point src, Point dst) {   
        int d = (int) Math.max(1, dst.distance(src));
        int size = Math.max(2,Math.min(d/4, 2*sz));
        int ax = (size * (dst.x - src.x) / d) / 2;
        int ax2 = Math.round(size / 5.0f * (dst.x - src.x) / d);
        int ay = (size * (dst.y - src.y) / d) / 2; 
        int ay2 = Math.round(size / 5.0f * (dst.y - src.y) / d);
        int size2 = (int) Math.round(Math.sqrt(ax2*ax2 + ay2*ay2));

        double degree = 0;
        int dx = 0;
        int dy = 0;
        if (ax == 0 && ay == 0) {
            return;
        } else if (ax == 0) {
            dx = size/2 * ay / Math.abs(ay);
            dy = (int) Math.round(size * 0.866) * ay / Math.abs(ay);
        } else if (ay == 0) {
            dx = (int) Math.round(size * 0.866) * ax / Math.abs(ax);
            dy = -size/2 * ax / Math.abs(ax);
        } else {
            degree = Math.atan(((double)ay)/ax) - Math.PI/6;
            dx = (int) Math.round(size * Math.cos(degree)) * ax / Math.abs(ax);
            dy = (int) Math.round(size * Math.sin(degree)) * ax / Math.abs(ax);
        }         
        
        Point p1 = new Point((dst.x+src.x)/2 - ax - ax2,(dst.y+src.y)/2 - ay - ay2);
        Point p2 = new Point((dst.x+src.x)/2 - ax,(dst.y+src.y)/2 - ay);
        Point p3 = new Point((dst.x+src.x)/2 + ax,(dst.y+src.y)/2 + ay);
        Point p4 = new Point((dst.x+src.x)/2 + ax + ax2,(dst.y+src.y)/2 + ay + ay2);
                
        path.lineTo(p1.x, p1.y);
        path.append(createCircle(size2, p1, p2), false);
        path.moveTo(p2.x, p2.y);
        path.lineTo(p2.x + dx, p2.y + dy);
        path.moveTo(p3.x, p3.y);
        path.append(createCircle(size2, p3, p4), false);
        path.moveTo(p4.x, p4.y);
    }      
    
    protected void addClosedXFormerSymbol(GeneralPath path, int sz, Point src, Point dst) {
    	//IpssLogger.getLogger().info("addClosedXFormerSymbol() called");
    	int d = (int) Math.max(1, dst.distance(src));
        int size = Math.max(1,Math.min(d/4, (int)(sz * 1.5)));
        int ax = Math.round((size * (dst.x * 1.0f - src.x) / d) * 3 / 8);
        int ay = Math.round((size * (dst.y * 1.0f - src.y) / d) * 3 / 8);
        size = (int) Math.round(Math.sqrt(9*ax*ax + 9*ay*ay));
                
        Point p1 = new Point((dst.x+src.x)/2, (dst.y+src.y)/2);
        Point p2 = new Point((dst.x+src.x)/2 + ax, (dst.y+src.y)/2 + ay);
        Point p3 = new Point((dst.x+src.x)/2 + 3*ax,(dst.y+src.y)/2 + 3*ay);
        Point p4 = new Point((dst.x+src.x)/2 + 4*ax,(dst.y+src.y)/2 + 4*ay);
        
        path.lineTo(p1.x, p1.y);
        path.append(createCircle(size, p1, p3), false);
        path.append(createCircle(size, p2, p4), false);
        path.moveTo(p4.x, p4.y);
    }    
    
    protected void addOpenXFormerSymbol(GeneralPath path, int sz, Point src, Point dst) {
    	int d = (int) Math.max(1, dst.distance(src));
        int size = Math.max(1,Math.min(d/4, (int)(sz * 1.5)));
        int ax = Math.round((size * (dst.x * 1.0f - src.x) / d) * 3 / 8);
        int ay = Math.round((size * (dst.y * 1.0f - src.y) / d) * 3 / 8);
        int ax2 = Math.round(size / 4.0f * (dst.x - src.x) / d);
        int ay2 = Math.round(size / 4.0f * (dst.y - src.y) / d);
        int size2 = (int) Math.round(Math.sqrt(ax2*ax2 + ay2*ay2));        
        size = (int) Math.round(Math.sqrt(9*ax*ax + 9*ay*ay));

        Point p1 = new Point((dst.x+src.x)/2 - 3*ax - ax2, (dst.y+src.y)/2 - 3*ay - ay2);
        Point p2 = new Point((dst.x+src.x)/2 - 3*ax, (dst.y+src.y)/2 - 3*ay);
        Point p3 = new Point((dst.x+src.x)/2 - 2*ax, (dst.y+src.y)/2 - 2*ay);
        Point p4 = new Point((dst.x+src.x)/2 - 2*ax + ax2, (dst.y+src.y)/2 - 2*ay + ay2);        
        Point p5 = new Point((dst.x+src.x)/2, (dst.y+src.y)/2);
        Point p6 = new Point((dst.x+src.x)/2 + ax, (dst.y+src.y)/2 + ay);
        Point p7 = new Point((dst.x+src.x)/2 + 3*ax,(dst.y+src.y)/2 + 3*ay);
        Point p8 = new Point((dst.x+src.x)/2 + 4*ax,(dst.y+src.y)/2 + 4*ay);

        path.lineTo(p1.x, p1.y);
        path.append(createCircle(size2, p2, p1), false);
        path.append(createCircle(size2, p3, p4), false);
        path.moveTo(p4.x, p4.y);         
        path.lineTo(p5.x, p5.y);
        path.append(createCircle(size, p5, p7), false);
        path.append(createCircle(size, p6, p8), false);
        path.moveTo(p8.x, p8.y);
    }    
}
