package org.interpss.editor.data.common;

import java.util.logging.Level;

import com.interpss.common.rec.BaseDataBean;
import com.interpss.common.util.IpssLogger;

/**
*	ZForm class for defining z data object.
*/

public class ZData extends BaseDataBean {
	private double r = 0.0;
	private double x = 0.0;

    public ZData() { }	
    public ZData(double r, double x) { this.r = r; this.x = x;}	

    public void setR(double x) { this.r = x; }
    public double getR() { return this.r; }

    public void setX(double x) { this.x = x; }
    public double getX() { return this.x; }
    
    /**
     * Rules: if x != 0.0 and r != 0.0 and x_r != 0.0, and the values are inconsistent, will throws an exception
     *        if x == 0.0 and r != 0.0 and x_r != 0.0, then x = r * x_r 
     *        if x != 0.0 and r == 0.0 and x_r != 0.0, then r = x / x_r 
     *        if x == 0.0 and r == 0.0 and x_r != 0.0, exception 
     *        if x_r == 0.0, do nothing 
     * 
     * @param x_r
     */
    public void resetXR(double x_r) throws Exception {
    	if ( x_r == 0.0) {
    		return;
    	}	
    	else if ( this.x != 0.0 && this.r != 0.0 && Math.abs((x_r-x/r)/x_r) > 0.01) {
    		throw new Exception("x, r and x_r inconsistent in ZForm.setX_R(), " + x + ", " + r + ", " + x_r);
    	}
    	else if ( this.x == 0.0 && this.r == 0.0 ) {
   			IpssLogger.getLogger().log(Level.WARNING, "x = 0.0 and r = 0.0 in ZForm.setX_R(), x/r=" + x_r);
    	}
    	else if ( this.x != 0.0 && this.r == 0.0 ) {
    		this.r = this.x / x_r;
    	}
    	else if ( this.x == 0.0 && this.r != 0.0 ) {
    		this.x = this.r * x_r;
    	}
    }
    
    public double getX_R() {
    	if (r == 0.0)
    		return 0.0;
    	else
    		return x/r;
    }
}