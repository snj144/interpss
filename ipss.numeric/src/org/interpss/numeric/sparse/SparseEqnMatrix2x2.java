package org.interpss.numeric.sparse;

import org.apache.commons.math.complex.Complex;
import org.interpss.numeric.datatype.Matrix_xy;
import org.interpss.numeric.datatype.Vector_xy;
import org.interpss.numeric.sparse.base.SparseEqnObject;

/**
 * Sparse Equation of data type 2x2 matrix for solving the [A]X=B problem. 
 * To outside, the index number is from 0 to n-1
 *
 * - 7/25/06 modified for SparseEqn plugin implementation

 */

public interface SparseEqnMatrix2x2 extends SparseEqnObject<Matrix_xy, Vector_xy> {
	/**
	   * Set bi element.
		* 
		* @param c the bi element
		* @param i row number 
	   */
	public void setBi( final Complex c, final int i );
		
  /**
   * add to bi element.
	* 
	* @param c the bi element
	* @param i row number 
   */
	public void addToBi( final Complex c, final int i );
}