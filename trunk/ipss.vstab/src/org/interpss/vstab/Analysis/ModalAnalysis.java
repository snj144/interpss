package org.interpss.vstab.Analysis;

import org.apache.commons.math.complex.Complex;
import org.apache.commons.math.linear.RealVector;

public interface ModalAnalysis {

	
	// dominant mode corresponding to the minimum eigenvalue
	public void getDominantMode();
	
	//public Mode getMode(int modeIndex);
	
	public Complex getDominantEigenValue();
	
	public double getDomRealEigenValue(int NumofSmallestEig);
	
	public RealVector getDominantRightVector();
	
	public RealVector getDominantLeftVector();
	
	public double getBusPartFactor(int busIdx);
	
	public double getBranchPartFactor(int branchIdx);
	
	public double getGenPartFactor(int busIdx);
	
}
