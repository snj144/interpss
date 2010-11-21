package org.interpss.facts;

import com.interpss.common.datatype.Matrix_xy;
import com.interpss.common.datatype.Vector_xy;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.sparse.SparseEqnMatrix2x2;

public class SVCConstVControl {
	// network variables
	AclfBus busi = null;  // bus the SVC connected to
	int position = 0;     // SVC position in the J-matrix

	// SVC varbiles
    private double vsh;
    private double thetash;
    
    // SCV constants, do not change in the Loadflow calculation process
    private double gsh;
    private double bsh;
    private double vc; 

    public SVCConstVControl(AclfBus bus, int n, double vc, double gsh, double bsh) {
        this.busi = bus;
        this.position = n;

        this.vc = vc;
        this.gsh = gsh;
        this.bsh = bsh;
    }
    
    public AclfBus getBus() {
    	return busi;
    }
    
    public int getPosition() {
    	return this.position;
    }
    
    public Matrix_xy getJii() {
    	double vi = busi.getVoltageMag();
    	double thetai = busi.getVoltageAng();
        // Update A part of the extended Jacobian
        Matrix_xy m = new Matrix_xy();
        m.xx = (2 * vi * gsh - vsh * (gsh * Math.cos(thetai - thetash) + bsh * Math.sin(thetai - thetash))) * vi; // dPi/dVi
        m.xy = vi * vsh * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash)); // dPi/dthetai
        m.yx = (2 * vi * bsh + vsh * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash))) * vi; // dQi/dVi
        m.yy = vi * vsh * (gsh * Math.cos(thetai - thetash) + bsh * Math.sin(thetai - thetash)); // dQi/dthetai
        return m;
    }
    
    public Matrix_xy getJnn() {
    	double vi = busi.getVoltageMag();
    	double thetai = busi.getVoltageAng();
        // Update A part of the extended Jacobian
        Matrix_xy m = new Matrix_xy();
        m.xx = (2 * vsh * gsh - vi * (gsh * Math.cos(thetai - thetash) - bsh * Math.sin(thetai - thetash))); // dPeq/dVsh
        m.xy = -vi * vsh * (gsh * Math.sin(thetai - thetash) + bsh * Math.cos(thetai - thetash)); // dPeq/dthetash
        m.yx = 0.0; // dFSVC/dVsh
        m.yy = 0.0; // dFSVC/dthetash
        return m;
    }

    public Matrix_xy getJin() {
    	double vi = busi.getVoltageMag();
    	double thetai = busi.getVoltageAng();
        
    	Matrix_xy m = new Matrix_xy();
    	m.xx = vi * (gsh * Math.cos(thetai - thetash) + bsh * Math.sin(thetai - thetash)); // dPi/dVsh
        m.xy = vi * vsh * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash)); // dPi/dthetash
        m.yx = vi * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash)); // dQi/dVsh
        m.yy = -vi * vsh * (gsh * Math.cos(thetai - thetash) + bsh * Math.sin(thetai - thetash)); // dQi/dthetash
    
        return m;
    }

    public Matrix_xy getJni() {
    	double vi = busi.getVoltageMag();
    	double thetai = busi.getVoltageAng();
        Matrix_xy m = new Matrix_xy();
        
        m.xx = -vsh * (gsh * Math.cos(thetai - thetash) - bsh * Math.sin(thetai - thetash)) * vi; // dPeq/dVi
        m.xy = vi * vsh * (gsh * Math.sin(thetai - thetash) + bsh * Math.cos(thetai - thetash)); // dPeq/dthetai
        m.yx = 1.0 * vi; // dFSVC/dVi
        m.yy = 0.0; // dFSVC/dthetai
        return m;
    }

    
    public Vector_xy getBi() {
        double vi = busi.getVoltageMag();
        double thetai = busi.getVoltageAng();
        
        Vector_xy b = new Vector_xy();
        b.x = -(vi * gsh - vsh * (gsh * Math.cos(thetai - thetash) + bsh * Math.sin(thetai - thetash))); // dFpi/Vi
        b.y =  (vi * gsh + vsh * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash))); // dFqi/Vi
        return b;
    }
    
    public Vector_xy getBn() {
        double vi = busi.getVoltageMag();
        double thetai = busi.getVoltageAng();
        
        Vector_xy b = new Vector_xy();
        // dPeq
        b.x = (vsh * vsh * gsh - vi * vsh * (gsh * Math.cos(thetai - thetash) - bsh * Math.sin(thetai - thetash)));
        // dVi
        b.y = (vi - vc);
        return b;
    }

    public void update(SparseEqnMatrix2x2 lfEqn) {
        vsh -= lfEqn.getBVect_xy(this.position).x;
        thetash -= lfEqn.getBVect_xy(this.position).y;
        System.out.println("vsh: " + vsh + ", thetash: " + thetash);
    }
}

