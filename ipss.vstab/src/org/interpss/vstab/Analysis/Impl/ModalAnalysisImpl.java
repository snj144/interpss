package org.interpss.vstab.Analysis.Impl;

import java.util.Hashtable;
import java.util.List;

import org.apache.commons.math.complex.Complex;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.linear.RealVector;
import org.interpss.vstab.Analysis.ModalAnalysis;
import org.interpss.vstab.Analysis.Mode;
import org.interpss.vstab.core.Jacobi4VSA;

public class ModalAnalysisImpl implements ModalAnalysis {
    private double braPartFactor;
    private double busPartFactor;
    private double genPartFactor;
    
    private RealVector domiRightVector;
    private RealVector domiLeftVector;
    private RealMatrix rightEigenVectorMatrix;
    private RealMatrix leftEigenVectorMatrix;
    private RealMatrix reducedJacobi;
    private Jacobi4VSA Jvsa=null;
     
    private List<Mode> modeList=null;
    public ModalAnalysisImpl(Jacobi4VSA J4vsa){
    	this.Jvsa=J4vsa;
    	this.reducedJacobi=J4vsa.getReducedJacobi();
    }
    
	@Override
	public double getBranchPartFactor(int branchIdx,int modeIndex) {
		
    return this.braPartFactor;
	}

	@Override
	public double getBusPartFactor(int busIndex,int modeIndex) {
		/*
		 * Kunder(Chinese edition) P673
		 */
		this.busPartFactor=this.rightEigenVectorMatrix.getEntry(busIndex, modeIndex)*
		                        this.leftEigenVectorMatrix.getEntry(modeIndex, busIndex);
		return this.busPartFactor;
		
	}
	@Override
	public double getGenPartFactor(int busIdx,int modeIndex) {
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
	public Mode getDominantMode() {
		return null;
		

	}

	@Override
	public RealVector getDominantRightVector() {
		// TODO Auto-generated method stub
		this.domiRightVector=this.getDominantMode().getRightVector();
		return this.domiRightVector;
	}

	@Override
	public RealVector getDominantLeftVector() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void formModeList() {
		reducedJacobi =this.Jvsa.getReducedJacobi();
		
		this.rightEigenVectorMatrix=this.Jvsa.getRightEigenVectors(reducedJacobi);
		this.leftEigenVectorMatrix=this.Jvsa.getLeftEigenVectors(reducedJacobi);
		RealMatrix diag =this.Jvsa.getEigValues(reducedJacobi);
		Mode aMode=new Mode();
		this.modeList.clear(); // make sure it is empty before adding any;
		for(int i =0;i<diag.getColumnDimension();i++){
			aMode.setEigenValue(diag.getEntry(i, i));
			aMode.setRightVector(this.rightEigenVectorMatrix.getColumnVector(i));
			aMode.setLeftVector(this.leftEigenVectorMatrix.getRowVector(i));
			this.modeList.add(aMode);
		}
		
	}

	@Override
	public Mode getMode(int modeIndex) {
		try{
		Mode aMode =this.modeList.get(modeIndex);
		return aMode;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}


}
