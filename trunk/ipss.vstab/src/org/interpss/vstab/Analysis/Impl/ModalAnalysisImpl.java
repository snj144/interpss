package org.interpss.vstab.Analysis.Impl;

import org.apache.commons.math.complex.Complex;
import org.apache.commons.math.linear.RealVector;
import org.interpss.vstab.Analysis.ModalAnalysis;

public class ModalAnalysisImpl implements ModalAnalysis {
    private double braPartFactor;
    private double busPartFactor;
    private double genPartFactor;
    
    private RealVector domiRightVector;
    private RealVector domiLeftVector;
    
    
	@Override
	public double getBranchPartFactor(int branchIdx) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getBusPartFactor(int busIdx) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double getGenPartFactor(int busIdx) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double getDomRealEigenValue(int NumofSmallestEig) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Complex getDominantEigenValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getDominantMode() {
		// TODO Auto-generated method stub

	}

	@Override
	public RealVector getDominantRightVector() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RealVector getDominantLeftVector() {
		// TODO Auto-generated method stub
		return null;
	}



}
