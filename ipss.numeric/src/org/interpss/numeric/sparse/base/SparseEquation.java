package org.interpss.numeric.sparse.base;

import org.interpss.numeric.exp.IpssNumericException;

/*
 *
 * SparseEquation
 *
 */

/**
 * Base Sparse Equation for solving sparse matrix problems.
 * 
 * - 7/25/06 modified for SparseEqn plugin implementation
 *
 */

public interface SparseEquation {
	/**
	 * 	get matrix dimension.
     * 
     * @return the dimension
     */
	int getDimension();

	/**
	 * 	Set matrix dimension. The index number is from 0 to n-1
     * 
     * @param n
     */
	void setDimension( final int n );

	/**
	 * Increase matrix dimension by 1. B[n] = 0.0, aii(n)=1.0, aij(n)=0.0 
     * 
     * @param n
     */
	void increaseDimension();
	
	/**
	 * 	Check if the sparse matrix is LUed
	 *
	 * @return true/false
	 */
	boolean isLUed();

	/**
	 * Set the sparse matrix LU status
	 *
	 * @param b true/false
	 */
	void setLUed( final boolean b );
	
	/**
	 * Get the total elements in the matrix
	 * 
	 * @return the total elements
	 */
	long getTotalElements();	
	
	/**
	 * LU decomposition of the matrix.
	 * 
	 * @param tolerance the tolerance for matrix singular detection
	 * @return if succeed return true.
	 */
	boolean luMatrix( final double tolerance) throws IpssNumericException;
		
	/**
	 * LU decomposition of the matrix and the solve the [A]X = B problem.
	 * 
	 * @param tolerance the tolerance for matrix singular detection
	 * @return if succeed return true.
	 */
	boolean luMatrixAndSolveEqn( final double tolerance)  throws IpssNumericException;
		
	/**
	 * Solve the [A]X = B problem
	 * 
	 */
	void solveEqn();			

	/**
	 * Set all b elements to 0.0 and bi = 1.0, a unit vector.
	 * 
	 * @param i the element row number (1-n convention)
	 */
	void setB2Unit(final int i);
	
	/**
	 * Reset the matrix to zero - set all aii and bi to 0.0 and clear the sparse structure
	 * 
	 */
	void reset();

	/**
	 * Reset all matrix element to zero, preserve the matrix sparse structure.
	 * 
	 */
	void setToZero();
	
	/**
	 * During the LU process, aii might be zero. An exception will be thrown. This function
	 * is for getting zero aii row number for error reporting
	 * 
	 * @return the row number
	 */
	int getZeroAii_row();	
}	