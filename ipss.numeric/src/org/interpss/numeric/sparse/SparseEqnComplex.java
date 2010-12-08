package org.interpss.numeric.sparse;

import org.apache.commons.math.complex.Complex;
import org.interpss.numeric.sparse.base.SparseEqnObject;

/**
 * Sparse Equation of data type Complex for solving the [A]X=B problem. 
 * To outside, the index number is from 0 to n-1
 *
 * - 7/25/06 modified for SparseEqn plugin implementation

 */

public interface SparseEqnComplex extends SparseEqnObject<Complex, Complex> {
}
