package org.interpss.vstab;

import org.apache.commons.math.linear.RealMatrix;

public interface EigenAnalysis {
	public void setJacobiMatrix(RealMatrix jacobi);
	public void runEigenStrAnalysis();
	public ESAResult getESAResult();

}
