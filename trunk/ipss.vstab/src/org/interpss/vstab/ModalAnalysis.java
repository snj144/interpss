package org.interpss.vstab;

import org.apache.commons.math.complex.Complex;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.linear.RealVector;

public interface ModalAnalysis {

	
	
	public void getDominatantModel();
	
	public Complex getDominatantEigenValue();
	
	public double getDomRealEigenValue(int NumofSmallestEig);
	
	public RealVector getDominatantVector();
	
	public double getBusPartFactor(int busIdx);
	
	public double getBranchPartFactor(int branchIdx);
	
	public double getGenPartFactor(int busIdx);
	
}
