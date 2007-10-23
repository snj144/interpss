 /*
  * @(#)GainBlock.java   
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


import com.interpss.common.datatype.LimitType;
import com.interpss.dstab.controller.block.IStaticBlock;
import com.interpss.dstab.controller.block.adapt.StaticBlockAdapter;

public class GainBlock extends StaticBlockAdapter {
	private double k = 0.0;
	private LimitType limit = null;
	
	public GainBlock(double k) {
		setType(IStaticBlock.Type.NoLimit);
		this.k = k;
	}
	
	public GainBlock(Type type, double k, double max, double min) {
		this(k);
		setType(type);
		limit = new LimitType(max, min);
	}

	public boolean initStateY0(double y0) {
		u = y0/getK();
		if (getType() == IStaticBlock.Type.Limit)
			return !limit.isViolated(y0);
		else {
			return true;
		}
	}
	
	public boolean initStateU0(double u0) {
		double y0 = u0 * getK();
		return initStateY0(y0);
	}

	public double getU0(double y0) {
		return y0/getK();
	}
	
	public double getU0() {
		return u;
	}
	
	public void eulerStep1(double u, double dt) {
		this.u = u;
	}
	
	public void eulerStep2(double u, double dt) {
		this.u = u;
	}	

	public double getY() {
		double u = getU();
		if (getType() == IStaticBlock.Type.Limit) 
			return limit.limit(u*getK());
		else
			return u*getK();
	}
	
	/**
	 * @return the kp
	 */
	public double getK() {
		return k;
	}

	/**
	 * @return the limit
	 */
	public LimitType getLimit() {
		return limit;
	}
	
	public String toString() {
		String str = "type, k, limit: " + getType() + ", "  + k  + ", "  +  limit;
		return str;
	}	
}
