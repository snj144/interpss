package org.interpss.numeric.sparse.base;

import org.interpss.numeric.sparse.SparseEqnDouble;

public class AbstractSparseEqnDouble extends AbstractSparseEquation implements SparseEqnDouble {

	@Override
	public void addToAij(double x, int i, int j) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addToBi(double bi, int i) {
		throw new UnsupportedOperationException();
	}

	@Override
	public double getAij(int i, int j) {
		throw new UnsupportedOperationException();
	}

	@Override
	public double getXi(int i) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setAij(double x, int i, int j) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setBi(double bi, int i) {
		throw new UnsupportedOperationException();
	}
}