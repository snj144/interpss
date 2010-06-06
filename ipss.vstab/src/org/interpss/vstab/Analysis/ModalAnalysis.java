package org.interpss.vstab.Analysis;

import java.util.List;

import org.apache.commons.math.complex.Complex;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.linear.RealVector;

public interface ModalAnalysis {

	
	// dominant mode corresponding to the minimum eigenvalue
	public RealMatrix getReducedJacobi();
	
	public void setReducedJacobi(RealMatrix reducedJacobi);
	
	public Mode getDominantMode();
	
	public Mode getMode(int modeIndex);

	
	public List<Mode> getDominantMode(int NumofDomMode);

	
	public double getBusPartFactor(int busIdx ,int modeIdx);
	
	public double getBranchPartFactor(int branchIdx,int modeIdx);
	
	public double getGenPartFactor(int busIdx,int modeIdx);
	
	

	
}
