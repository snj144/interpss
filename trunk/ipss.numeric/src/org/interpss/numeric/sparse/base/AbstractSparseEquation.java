/*
 * @(#)AbstractSparseEquation.java   
 *
 * Copyright (C) 2006-2010 www.interpss.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU LESSER GENERAL PUBLIC LICENSE
 * as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * @Author Mike Zhou
 * @Version 1.0
 * @Date 12/10/2010
 * 
 *   Revision History
 *   ================
 *
 */

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
	public boolean luMatrixAndSolveEqn(double tolerance)  throws IpssNumericException {
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
	public void setB2Zero() {
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
	public void solveEqn() throws IpssNumericException {
		throw new UnsupportedOperationException();
	}
}