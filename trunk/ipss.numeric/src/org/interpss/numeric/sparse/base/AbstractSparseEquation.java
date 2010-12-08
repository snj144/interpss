package org.interpss.numeric.sparse.base;

import org.interpss.numeric.exp.IpssNumericException;

public class AbstractSparseEquation implements SparseEquation {
	int dimenstion = 0;

	@Override
	public int getDimension() {
		return this.dimenstion;
	}

	@Override
	public long getTotalElements() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getZeroAii_row() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void increaseDimension() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isLUed() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean luMatrix(double tolerance) throws IpssNumericException {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean luMatrixAndSolveEqn(double tolerance) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void reset() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setB2Unit(int i) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setDimension(int n) {
		this.dimenstion = n;
	}

	@Override
	public void setLUed(boolean b) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setToZero() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void solveEqn() {
		throw new UnsupportedOperationException();
	}
}