package org.interpss.vstab.core;

import org.apache.commons.math.linear.RealMatrix;

public interface Jacobi4VSA {
    public RealMatrix getFullJacobi();
   	public RealMatrix getReducedJacobi() ;
   	public RealMatrix getSubJptheta();
   	public RealMatrix getSubJpv();
   	public RealMatrix getSubJqtheta();
   	public RealMatrix getSubJqv();
   	public RealMatrix getRightEigenVectors(RealMatrix Jacobi);
   	public RealMatrix getLeftEigenVectors(RealMatrix Jacobi);
	public RealMatrix getEigValues(RealMatrix Jacobi);
   	
}
