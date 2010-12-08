package org.interpss.numeric.sparse.base;



/**
 * Sparse Equation of data type T for solving the [A]X=B problem. 
 * To outside, the index number is from 0 to n-1
 *
 */

public interface SparseEqnObject<TAij, TBi> extends SparseEquation {
  /**
   * Add the aij element to the matrix. If aij exists, aij += x.
	* 
	* @param x the aij element
	* @param i the element row number 
	* @param j the element column number 
   */
	void addToAij( final TAij x, final int i, final int j );

  /**
   * Get the bi element.
	* 
	* @param i the element row number 
	* @return the bi element
   */
	TBi getXi( final int i );

  /**
   * Set the aij element.
	* 
	* @param x the aij element
	* @param i the element row number 
	* @param j the element column number 
   */
	void setAij( final TAij x, final int i, final int j );

	/**
	* Get the aij element.
	* 
	* @param i the element row number 
	* @param j the element column number 
	* @return aij 
	*/
	TAij getAij(final int i, final int j );
		
	/**
   * Set bi element.
	* 
	* @param bi the bi element
	* @param i row number 
   */
	void setBi( final TBi bi, final int i );
	
	/**
	 * add to bi element.
		* 
		* @param bi the bi element
		* @param i row number 
	   */
	void addToBi( final TBi bi, final int i );	
	
	/**
	 * Get zero aii row number
	 * @return
	 */
	int getZeroAii_row();		
}
