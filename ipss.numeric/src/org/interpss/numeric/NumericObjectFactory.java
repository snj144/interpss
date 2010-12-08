package org.interpss.numeric;

import org.interpss.numeric.sparse.SparseEqnDouble;
import org.interpss.spring.NumericSpringCtx;

public class NumericObjectFactory {
	public static SparseEqnDouble createSparseEqnDouble() {
		return NumericSpringCtx.getSparseEqnDouble();
	}
}
