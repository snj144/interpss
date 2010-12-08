package org.interpss.numeric.sparse;

import org.interpss.numeric.sparse.base.SparseEquation;


/**
 * Sparse Equation of data type integer. The purpose is for arranging network bus number
 * to minimize the non-zero fill-ins. 	To outside, the index number is from 0 to n-1
 *
 * - 7/25/06 modified for SparseEqn plugin implementation
 *
 */

public interface SparseEqnInteger extends SparseEquation {

  /**
   * Arrange bus bus according to the Tinney-2 rule
	*
   */
	void arrangeRowNoT2();

  /**
   * Arrange bus bus according to the Tinney-3 rule
	*
   */
	void arrangeRowNoT3();
	
  /**
   * After the bus number arrangement, get the new bus number from an old bus number.
	*
	* @param i old bus number
	* @return the new bus number
   */
	public int getOld2New( final int i );

  /**
   * Set the aij element
	* 
	* @param n the aij element
	* @param i the element row number (1-n convention)
	* @param j the element column number (1-n convention)
   */
	void setAij( final int n, final int i, final int j );
}


