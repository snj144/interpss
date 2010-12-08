package org.interpss.numeric.sparse;

import org.interpss.numeric.sparse.base.SparseEquation;


/**
 * Sparse Equation of data type double for solving the [A]X=B problem. 
 * To outside, the index number is from 0 to n-1
 *
 * - 7/25/06 modified for SparseEqn plugin implementation

 */

public interface SparseEqnDouble extends SparseEquation {

  /**
   * Add the aij element to the matrix. If aij exists, aij += x.
	* 
	* @param x the aij element
	* @param i the element row number (1-n convention)
	* @param j the element column number (1-n convention)
   */
	void addToAij( final double x, final int i, final int j );

  /**
   * Get the bi element.
	* 
	* @param i the element row number
	* @return the bi element
   */
	double getXi( final int i );

  /**
   * Set the aij element.
	* 
	* @param x the aij element
	* @param i the element row number 
	* @param j the element column number 
   */
	void setAij( final double x, final int i, final int j );
	
	/**
	* Get the aij element.
	* 
	* @param i the element row number 
	* @param j the element column number 
	*/
	double getAij(final int i, final int j );
		
	/**
	 * Set bi element.
	 * 
	 * @param bi the bi element
	 * @param i row number 
	 */
	void setBi( final double bi, final int i );
	
	/**
	 * add to the element.
	 * 
	 * @param bi the bi element
	 * @param i row number 
	 */
	void addToBi( final double bi, final int i );	
}