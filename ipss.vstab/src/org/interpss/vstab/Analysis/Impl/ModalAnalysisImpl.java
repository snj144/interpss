package org.interpss.vstab.Analysis.Impl;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.math.complex.Complex;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.linear.RealVector;
import org.interpss.vstab.Analysis.ModalAnalysis;
import org.interpss.vstab.Analysis.Mode;
import org.interpss.vstab.Analysis.ModeComparator;
import org.interpss.vstab.core.Jacobi4VSA;
import org.interpss.vstab.core.impl.Jacobi4VSAImpl;

public class ModalAnalysisImpl extends Jacobi4VSAImpl implements ModalAnalysis 
    {
	
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
    	setReducedJacobi(J4vsa.getReducedJacobi());
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
	public Mode getDominantMode() {
		formModeList();
		Mode domiMode =this.modeList.get(0);
		for(Iterator it = this.modeList.listIterator(1);it.hasNext();){
			Mode aMode =(Mode) it.next();
			if(Math.abs(domiMode.getEigenValue())>Math.abs(aMode.getEigenValue()))
				domiMode=aMode;
		}
		return domiMode;
		

	}
	
	@Override
	public List<Mode> getDominantMode(int NumofDomMode) {
		formModeList();
		ModeComparator modecp =new ModeComparator();
		Collections.sort(getModeList(), modecp);
		List<Mode> domiMode =getModeList().subList(0, NumofDomMode-1);
		return domiMode;
	}

	protected void formModeList() {
		setReducedJacobi(this.Jvsa.getReducedJacobi());
		RealMatrix diag =getEigValues();
		Mode aMode=new Mode();
		this.modeList.clear(); // make sure it is empty before adding any;
		for(int i =0;i<diag.getColumnDimension();i++){
			aMode.setEigenValue(diag.getEntry(i, i));
			aMode.setRightVector(getRightEigVctrMatrix().getColumnVector(i));
			aMode.setLeftVector(getLeftEigVctrMatrix().getRowVector(i));
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

	protected List<Mode> getModeList(){
		return this.modeList;
	}

	@Override
	public RealMatrix getReducedJacobi() {
		return this.reducedJacobi;
	}

	@Override
	public void setReducedJacobi(RealMatrix reducedJacobi) {
		this.reducedJacobi=reducedJacobi;
		
	}






}
