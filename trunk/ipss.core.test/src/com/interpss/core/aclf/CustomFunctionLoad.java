package com.interpss.core.aclf;

import org.apache.commons.math.complex.Complex;

import com.interpss.core.aclf.impl.BaseAclfBusImpl;

public class CustomFunctionLoad extends BaseAclfBusImpl {
	private double loadP = 1.6, loadQ = 0.8, 
			constP = 0.3, constI = 0.4, constZ = 0.3;
	
	public boolean isLoad() {
		return true; 
	}
	
	public double getLoadP() {
		double v = getParentAclfBus().getVoltageMag();
		return loadP*(constP + constI*v) ;	
	}
	
	public double getLoadQ() {
		double v = getParentAclfBus().getVoltageMag();
		return loadQ*(constP + constI*v) ;	
	}

	// put const Z part as an impedance
	public Complex getShuntY() {
		return new Complex(loadP*constZ,loadQ*constZ).conjugate();	
	}
}
