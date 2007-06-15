 /*
  * @(#)WashoutControlBlock.java   
  *
  * Copyright (C) 2006 www.interpss.org
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
  * @Date 10/30/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.dstab.control.cml.block;

import com.interpss.common.exp.InterpssRuntimeException;
import com.interpss.dstab.controller.block.adapt.ControlBlock1stOrderAdapter;

public class WashoutControlBlock extends ControlBlock1stOrderAdapter {
	private double k = 0.0;
	private double t = 0.0;
	
	public WashoutControlBlock(double k, double t) {
		this.k = k;
		this.t = t;
	}
	
	public boolean initStateU0(double u0) {
		setU(u0);
		setStateX(getK() * u0);
		return true;
	}
	
	public boolean initStateY0(double y0) {
		if (y0 != 0.0) {
			throw new InterpssRuntimeException("Washout block, initStateY0(), y0 should = 0.0");
		}
		setU(0.0);
		setStateX(0.0);
		return true;
	}
	
	public double getU0() {
		return getU();
	}
	
	public double getY() {
		double u = getU();
		double y = getK()*u - getStateX();
		return y;
	}

	protected double dX_dt(double u) {
		return (getK() * u - getStateX()) / getT();
	}

	/**
	 * @return the k
	 */
	public double getK() {
		return k;
	}

	/**
	 * @return the t
	 */
	public double getT() {
		return t;
	}
}
