package org.interpss.vstab;

import org.apache.commons.math.complex.Complex;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.linear.RealVector;

public interface ModalAnalysis {

	
	
	public void getDominatantModel();
	
	public Complex getDominatantEigenValue();
	
	public double getDominatantRealEigenValue(int NumofSmallestEig);
	
	public RealVector getDominatantVector();
	
	
}
