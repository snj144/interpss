package org.interpss.numeric.sparse.impl;

import org.apache.commons.math.linear.Array2DRowRealMatrix;
import org.apache.commons.math.linear.LUDecomposition;
import org.apache.commons.math.linear.LUDecompositionImpl;
import org.apache.commons.math.linear.RealMatrix;
import org.interpss.numeric.sparse.base.AbstractSparseEqnDouble;

/**
 * Sparse Equation of data type double for solving the [A]X=B problem. 
   using the apache common math lib
 */

public class SparseEqnDoubleCommonMathImpl extends AbstractSparseEqnDouble {
	RealMatrix A = null;
	double[] B = null;
	double[] X = null;
	
	public SparseEqnDoubleCommonMathImpl() {
	}

	public SparseEqnDoubleCommonMathImpl(int n) {
		this.setDimension(n);
	}
	
	public void setDimension(int n) {
		super.setDimension(n);
		this.A = new Array2DRowRealMatrix( n, n );
		this.B = new double[n];
	}
	
	public void addToAij( final double x, final int i, final int j ) {
		double x0 = this.A.getEntry(i, j);
		this.A.setEntry(i, j, x0+x);
	}

	public void setAij( final double x, final int i, final int j ) {
		this.A.setEntry(i, j, x);
	}
		
	public double getAij( final int i, final int j ) {
		return this.A.getEntry(i, j);
	}

	public double getXi( final int i ) {
		return this.X[i];
	}
	
	@Override
	public void setBi( final double bi, final int i ) {
		this.B[i] = bi;
	}

	@Override
	public void addToBi( final double bi, final int i ) {
		this.B[i] += bi;
	}
	
	@Override
	public void solveEqn() {
		LUDecomposition lu = new LUDecompositionImpl(A);
		this.X = lu.getSolver().solve(B);
	}
}