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
// TODO: please specify the following parameters 
 * 	   vsh - ?
 *     qc - ?  (Mike : it seems to me qc is used for vref and qc(max) 
 *     gsh + j bsh - 	
 *     
 */

public class SVCControl extends AbstractAclfBus {
	int position = 0;     // SVC position in the J-matrix

	// SVC variables
    private double vsh;
    private double thetash;  
    
    // SVC constants, do not change in the Loadflow calculation process
    SVCControlType ctype;
    private double gsh;
    private double bsh;
    private double qc;
    
    // bus load
    private Complex load = new Complex(0.0,0.0);
    
	public SVCControl(AclfBus bus, int n, SVCControlType type) {
		this.setParentAclfBus(bus);
		this.position = n;
		this.ctype = type;
	}

	/**
	 * init SVC state before Loadflow calculation
	 * 
	 * @return true if init is successful
	 */
	public boolean init() {
		double vi = this.getBus().getVoltageMag();
		double thetai = this.getBus().getVoltageAng();
		double ysh = Math.sqrt(gsh * gsh + bsh * bsh);
		double thetaysh = Math.acos(gsh / ysh);
		
		vsh = 1.0;
		thetash = thetai - thetaysh - Math.acos(vi * gsh / vsh / ysh);
		while (thetash < -Math.PI)
			thetash += 2 * Math.PI;
		while (thetash > Math.PI)
			thetash -= 2 * Math.PI;
		// codes to verify the init result is required here
		return true;
	}
	
	public AclfBus getBus() {
		return this.getParentAclfBus();
	}

	public int getPosition() {
		return position;
	} 
	
	public void setQc(double qc) {
		this.qc = qc;
	}
	
	public double getVsh() {
		return this.vsh;
	}

	public double getThedash() {
		return this.thetash;
	}

	public void setYsh(double gsh, double bsh) {
		this.gsh = gsh;
		this.bsh = bsh;
	}

	public Complex mismatch() {
		Complex pIn2Net = this.getBus().powerIntoNet();
		// equivalent P+jQ of SVC
		Vector_xy pq = getBi();
		// extra load on the same bus
		Complex load = new Complex(getLoadP(), getLoadQ());
		return new Complex(pq.x,pq.y).subtract(load).subtract(pIn2Net);
	}
	
	// define extra load on the same bus
	@Override
	public boolean isLoad() {
		return true;
	}

	@Override
	public double getLoadP() {
		return this.load.getReal();
	}

	@Override
	public double getLoadQ() {
		return this.load.getImaginary();
	}

	public void setLoad(Complex load) {
		this.load = load;
	}
	
    /**
     * J-matrix element at [i,i]. It will used to modify (add to) the network J-matrix element
     * This J-matrix part should be the same for all control types, because it contains the partial derivatives of power mismatch
     * over traditional variables (v, theta), such power mismatch is calculated by adding traditional power mismatches and equivalent
     * injected power of SVC, such injected power expression will be the same for all kinds of controls
     * 
     * @return
     */
    public Matrix_xy getJii() {
    	double vi = getBus().getVoltageMag();
    	double thetai = getBus().getVoltageAng();
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
    	double vi = getBus().getVoltageMag();
    	double thetai = getBus().getVoltageAng();
        // Update A part of the extended Jacobian
        Matrix_xy m = new Matrix_xy();
        m.yx = (2 * vsh * gsh - vi * (gsh * Math.cos(thetai - thetash) - bsh * Math.sin(thetai - thetash))); // dPeq/dVsh
        m.yy = -vi * vsh * (gsh * Math.sin(thetai - thetash) + bsh * Math.cos(thetai - thetash)); // dPeq/dthetash
        if (this.ctype == SVCControlType.ConstV) {
            m.xx = 0.0; // dFSVC/dVsh
            m.xy = 0.0; // dFSVC/dthetash
        }
        else if (this.ctype == SVCControlType.ConstQ) {
            m.xx = vi * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash)); // dFSVC/dvsh
            m.xy = -vi * vsh * (gsh * Math.cos(thetai - thetash) + bsh * Math.sin(thetai - thetash)); // dFSVC/dthetash
        }
        else if (this.ctype == SVCControlType.ConstB) {
        	m.xx = -bsh / vi * Math.cos(thetash - thetai) - gsh / vi * Math.sin(thetash - thetai);// dFSVC/dvsh
        	m.xy = bsh * vsh / vi * Math.sin(thetash - thetai) - gsh * vsh / vi * Math.cos(thetash - thetai);	// dFSVC/dthetash
        }
        return m;
    }

    /**
     * J-matrix element at [i,n]
     * This J-matrix part should be the same for all kinds of controls
     * 
     * @return
     */
    public Matrix_xy getJin() {
    	double vi = getBus().getVoltageMag();
    	double thetai = getBus().getVoltageAng();
        
    	Matrix_xy m = new Matrix_xy();
    	m.xx = -(vi * (gsh * Math.cos(thetai - thetash) + bsh * Math.sin(thetai - thetash))); // dPi/dVsh
        m.xy = -(vi * vsh * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash))); // dPi/dthetash
        m.yx = -(vi * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash))); // dQi/dVsh
        m.yy = -(-vi * vsh * (gsh * Math.cos(thetai - thetash) + bsh * Math.sin(thetai - thetash))); // dQi/dthetash
    
        return m;
    }

    /**
     * J-matrix element at [n,i]
     * The dPeq/dVi and dPeq/dthetai will be the same for all control types
     * 
     * @return
     */
    public Matrix_xy getJni() {
    	double vi = getBus().getVoltageMag();
    	double thetai = getBus().getVoltageAng();
        Matrix_xy m = new Matrix_xy();
        
        m.yy = -vsh * (gsh * Math.cos(thetai - thetash) - bsh * Math.sin(thetai - thetash)) * vi; // dPeq/dVi
        m.yx = vi * vsh * (gsh * Math.sin(thetai - thetash) + bsh * Math.cos(thetai - thetash)); // dPeq/dthetai
        if (this.ctype == SVCControlType.ConstV) {
            m.xy = 1.0 * vi; // dFSVC/dVi
            m.xx = 0.0; // dFSVC/dthetai
        }
        else if (this.ctype == SVCControlType.ConstQ) {
            m.xy = (2 * vi * bsh + vsh * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash))) * vi; // dFSVC/dVi
            m.xx = vi * vsh * (gsh * Math.cos(thetai - thetash) + bsh * Math.sin(thetai - thetash)); // dFSVC/dthetai
        }
        else if (this.ctype == SVCControlType.ConstB) {
        	m.xy = bsh * vsh / vi * Math.cos(thetash - thetai) + gsh * vsh / vi * Math.sin(thetash - thetai); // dFSVC/dVi
        	m.xx = -bsh * vsh / vi * Math.sin(thetash - thetai) + gsh * vsh / vi * Math.cos(thetash - thetai);	// dFSVC/dthetai
        }
        return m;
    }

    
    /**
     * B vector element at [i]. It will be used to modify (add to) the network power mismatch vector
     * Should be the same for all control types
     * 
     * @return
     */
    public Vector_xy getBi() {
        double vi = getBus().getVoltageMag();
        double thetai = getBus().getVoltageAng();
        
        Vector_xy b = new Vector_xy();
        b.x = (vi * gsh - vsh * (gsh * Math.cos(thetai - thetash) + bsh * Math.sin(thetai - thetash))); // dFpi/Vi
        b.y = -(vi * bsh + vsh * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash))); // dFqi/Vi
        return b;
    }
    
    /**
     * B vector element at [n].
     * The dPeq should be the same for all control types
     * 
     * @return
     */
    public Vector_xy getBn() {
        double vi = getBus().getVoltageMag();
        double thetai = getBus().getVoltageAng();
        
        Vector_xy b = new Vector_xy();
        // dPeq
        b.y = (vsh * vsh * gsh - vi * vsh * (gsh * Math.cos(thetai - thetash) - bsh * Math.sin(thetai - thetash)));
        if (this.ctype == SVCControlType.ConstV) {	// dVi
            b.x = (vi - qc);
        }
        else if (this.ctype == SVCControlType.ConstQ) {	// dQi
            b.x = ((vi * vi * bsh + vi * vsh * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash))) + qc);
        }
        else if (this.ctype == SVCControlType.ConstB) {	// dXi
        	b.x = (1 - vsh / vi * Math.cos(thetash - thetai)) * bsh - vsh / vi * Math.sin(thetash - thetai) * gsh - qc;
        }
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
        // TODO: at this point, we can check if there is any limit violation. If yes,
        //       change SVC control mode, for example from ConstV to ConstQ
    }

}
