package org.interpss.vstab;

import org.apache.commons.math.linear.RealMatrix;

import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.sparse.SparseEqnDouble;
import com.interpss.core.sparse.SparseEqnMatrix2x2;

public interface Jacobi4VSA {
    public RealMatrix getFullJacobi();
   	public RealMatrix getReducedJacobi() ;
   	public RealMatrix getSubJptheta();
   	public RealMatrix getSubJpv();
   	public RealMatrix getSubJqtheta();
   	public RealMatrix getSubJqv();
}
