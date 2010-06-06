package org.interpss.vstab.core;

import org.apache.commons.math.linear.RealMatrix;

public interface Jacobi4VSA {
	public void setFullJacobi(RealMatrix fullJacobi);
	
    public RealMatrix getFullJacobi();
    
    public void setReducedJacobi(RealMatrix reducedJacobi) ;
    
   	public RealMatrix getReducedJacobi() ;

   	public void setSubJpv(RealMatrix Jpv);
   
   	public RealMatrix getSubJpv();
   	
   	public void setSubJqv(RealMatrix Jqv);
   	
   	public RealMatrix getSubJqv();
   	
	public void setRightEigVctrMatrix(RealMatrix newRightEigVctrMatrix);
	
	public RealMatrix getRightEigVctrMatrix();
	
	
	public void setLeftEigVctrMatrix(RealMatrix newLeftEigVctrMatrix);
	
	public RealMatrix getLeftEigVctrMatrix();
   	
	public RealMatrix getEigValues();
	
	public void setEigValues(RealMatrix eigValueMatrix);
   	
}
