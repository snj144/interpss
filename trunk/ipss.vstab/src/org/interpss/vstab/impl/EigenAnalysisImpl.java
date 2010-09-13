package org.interpss.vstab.impl;

import org.apache.commons.math.linear.RealMatrix;
import org.interpss.vstab.ESAResult;
import org.interpss.vstab.EigenAnalysis;

public class EigenAnalysisImpl implements EigenAnalysis {
    
    protected RealMatrix jacobiMatrix=null;
    protected ESAResult result=null;

	@Override
	public void runEigenStrAnalysis() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setJacobiMatrix(RealMatrix jacobi) {
		this.jacobiMatrix=jacobi;
		
	}

	@Override
	public ESAResult getESAResult() {
		
		return result;
	}


	}


