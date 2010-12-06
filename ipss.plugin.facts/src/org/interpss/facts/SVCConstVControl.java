package org.interpss.facts;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.datatype.Matrix_xy;
import com.interpss.common.datatype.Vector_xy;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.impl.AbstractAclfBus;
import com.interpss.core.sparse.SparseEqnMatrix2x2;

/**
 * A SVC implementation
 * 
 *     i - The SVC connected bus position in the J-matrix
 *     n - The SVC position in the J-matrix
 * 
 * @author mzhou
 *
 */
public class SVCConstVControl extends AbstractAclfBus {
	// network variables
	AclfBus busi = null;  // bus the SVC connected to
	int position = 0;     // SVC position in the J-matrix

	// SVC variables
    private double vsh = 1.0;
    private double thetash = 0.0;  
    
    // SVC constants, do not change in the Loadflow calculation process
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

    /*
     * define as a capacitor bus. The Q will be treated as Yshunt
     */
    
    @Override
    public boolean isCapacitor() { 
    	return true; 
    }
    
    @Override
    public 	Complex getShuntY() {
    	double vi = busi.getVoltageMag();
    	double thetai = busi.getVoltageAng();
		double g = gsh - vsh * (gsh * Math.cos(thetai - thetash) + bsh * Math.sin(thetai - thetash)) / vi;
		double b = bsh + vsh * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash)) / vi;
    	return new Complex(g, b);
    }

//    @Override
//	public double getGenP() {
//    	double vi = busi.getVoltageMag();
//    	double thetai = busi.getVoltageAng();
//		return (-vi * vi * gsh + vi * vsh * (gsh * Math.cos(thetai - thetash) + bsh * Math.sin(thetai - thetash)));
//	}
//
//	@Override
//    public double getGenQ() { 
//    	double vi = busi.getVoltageMag();
//    	double thetai = busi.getVoltageAng();
//    	System.out.println(vi * vi * bsh + vi * vsh * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash)));
//		return (vi * vi * bsh + vi * vsh * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash)));
////    	return 0;
//    }

    /*
     * define as a load bus
     */
    
    @Override
    public boolean isLoad() { 
    	return true; 
    }
    
//    @Override
//    public double getLoadP() { 
//    	return 1.0; 
//    }
//    
//    @Override
//    public double getLoadQ() { 
//    	return 0.8; 
//    }
    
    /**
     * J-matrix element at [i,i]. It will used to modify (add to) the network J-matrix element
     * 
     * @return
     */
    public Matrix_xy getJii() {
    	double vi = busi.getVoltageMag();
    	double thetai = busi.getVoltageAng();
        // Update A part of the extended Jacobian
        Matrix_xy m = new Matrix_xy();
        m.xy = -(-(2 * vi * gsh - vsh * (gsh * Math.cos(thetai - thetash) + bsh * Math.sin(thetai - thetash))) * vi); // dPi/dVi
        m.xx = -(vi * vsh * (-gsh * Math.sin(thetai - thetash) + bsh * Math.cos(thetai - thetash))); // dPi/dthetai
        m.yy = -((2 * vi * bsh + vsh * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash))) * vi); // dQi/dVi
        m.yx = -(vi * vsh * (gsh * Math.cos(thetai - thetash) - bsh * Math.sin(thetai - thetash))); // dQi/dthetai
        return m;
    }
    
    /**
     * J-matrix element at [n,n]
     * 
     * @return
     */
    public Matrix_xy getJnn() {
    	double vi = busi.getVoltageMag();
    	double thetai = busi.getVoltageAng();
        // Update A part of the extended Jacobian
        Matrix_xy m = new Matrix_xy();
        m.yx = (2 * vsh * gsh - vi * (gsh * Math.cos(thetai - thetash) - bsh * Math.sin(thetai - thetash))); // dPeq/dVsh
        m.yy = -vi * vsh * (gsh * Math.sin(thetai - thetash) + bsh * Math.cos(thetai - thetash)); // dPeq/dthetash
        m.xx = 0.0; // dFSVC/dVsh
        m.xy = 0.0; // dFSVC/dthetash
        return m;
    }

    /**
     * J-matrix element at [i,n]
     * 
     * @return
     */
    public Matrix_xy getJin() {
    	double vi = busi.getVoltageMag();
    	double thetai = busi.getVoltageAng();
        
    	Matrix_xy m = new Matrix_xy();
    	m.xx = -(vi * (gsh * Math.cos(thetai - thetash) + bsh * Math.sin(thetai - thetash))); // dPi/dVsh
        m.xy = -(vi * vsh * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash))); // dPi/dthetash
        m.yx = -(vi * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash))); // dQi/dVsh
        m.yy = -(-vi * vsh * (gsh * Math.cos(thetai - thetash) + bsh * Math.sin(thetai - thetash))); // dQi/dthetash
    
        return m;
    }

    /**
     * J-matrix element at [n,i]
     * 
     * @return
     */
    public Matrix_xy getJni() {
    	double vi = busi.getVoltageMag();
    	double thetai = busi.getVoltageAng();
        Matrix_xy m = new Matrix_xy();
        
        m.yy = -vsh * (gsh * Math.cos(thetai - thetash) - bsh * Math.sin(thetai - thetash)) * vi; // dPeq/dVi
        m.yx = vi * vsh * (gsh * Math.sin(thetai - thetash) + bsh * Math.cos(thetai - thetash)); // dPeq/dthetai
        m.xy = 1.0 * vi; // dFSVC/dVi
        m.xx = 0.0; // dFSVC/dthetai
        return m;
    }

    
    /**
     * B vector element at [i]. It will be used to modify (add to) the network power mismatch vector
     * 
     * @return
     */
    public Vector_xy getBi() {
        double vi = busi.getVoltageMag();
        double thetai = busi.getVoltageAng();
        
        Vector_xy b = new Vector_xy();
        b.x = (vi * gsh - vsh * (gsh * Math.cos(thetai - thetash) + bsh * Math.sin(thetai - thetash))); // dFpi/Vi
        b.y = -(vi * bsh + vsh * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash))); // dFqi/Vi
//        System.out.println("gsh = " + b.y * vi);
        return b;
    }
    
    /**
     * B vector element at [n].
     * 
     * @return
     */
    public Vector_xy getBn() {
        double vi = busi.getVoltageMag();
        double thetai = busi.getVoltageAng();
        
        Vector_xy b = new Vector_xy();
        // dPeq
        b.y = (vsh * vsh * gsh - vi * vsh * (gsh * Math.cos(thetai - thetash) - bsh * Math.sin(thetai - thetash)));
        // dVi
        b.x = (vi - vc);
        return b;
    }

    /**
     * Update the SVC controller internal states only
     * 
     * @param lfEqn
     */
    public void update(SparseEqnMatrix2x2 lfEqn) {
        vsh -= lfEqn.getBVect_xy(this.position).x;
        thetash -= lfEqn.getBVect_xy(this.position).y;
//        System.out.println("vsh: " + vsh + ", thetash: " + thetash);
    }
}

