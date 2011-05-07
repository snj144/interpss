/*
 * @(#)DelayControlBlock.java   
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

import com.interpss.common.util.IpssLogger;
import com.interpss.dstab.controller.block.ILimitExpression;
import com.interpss.dstab.controller.block.IStaticBlock;
import com.interpss.dstab.controller.block.adapt.ControlBlock1stOrderAdapter;
import com.interpss.dstab.datatype.ExpCalculator;
import com.interpss.dstab.datatype.LimitExpression;

public class DelayControlBlock extends ControlBlock1stOrderAdapter implements
		ILimitExpression {
	protected double k = 0.0;
	protected double t = 0.0;
	protected LimitExpression limit = null;

	public DelayControlBlock(double k, double t) {
		setType(IStaticBlock.Type.NoLimit);
		this.k = k;
		this.t = t;
	}

	public DelayControlBlock(Type type, double k, double t, double max,
			double min) {
		this(k, t);
		setType(type);
		limit = new LimitExpression(max, min);
	}

	public DelayControlBlock(Type type, double k, double t,
			ExpCalculator maxExp, double min) {
		this(k, t);
		setType(type);
		limit = new LimitExpression(maxExp, min);
	}

	public DelayControlBlock(Type type, double k, double t, double max,
			ExpCalculator minExp) {
		this(k, t);
		setType(type);
		limit = new LimitExpression(max, minExp);
	}

	public DelayControlBlock(Type type, double k, double t,
			ExpCalculator maxExp, ExpCalculator minExp) {
		this(k, t);
		setType(type);
		limit = new LimitExpression(maxExp, minExp);
	}

	public boolean initStateY0(double y0, double[] maxDAry, double[] minDAry) {
		if (getK() <= 0.0) {
			IpssLogger.getLogger().severe(
					"DelayControlBlock.initState(), k <= 0.0");
			return false;
		}
		setU(y0 / getK());
		setStateX(y0);

		if (getType() == IStaticBlock.Type.Limit
				|| getType() == IStaticBlock.Type.NonWindup) {
			return !limit.isViolated(y0, maxDAry, minDAry);
		} else
			return true;
	}

	@Override
	public boolean initStateY0(double y0) {
		if (getK() <= 0.0) {
			IpssLogger.getLogger().severe(
					"DelayControlBlock.initState(), k <= 0.0");
			return false;
		}
		setU(y0 / getK());
		setStateX(y0);
		if (getType() == IStaticBlock.Type.Limit
				|| getType() == IStaticBlock.Type.NonWindup) {
			return !limit.isViolated(y0);
		} else
			return true;
	}

	public boolean initStateU0(double u0, double[] maxDAry, double[] minDAry) {
		setU(u0);
		double y0 = u0 * getK();
		return initStateY0(y0, maxDAry, minDAry);
	}

	@Override
	public boolean initStateU0(double u0) {
		setU(u0);
		double y0 = u0 * getK();
		return initStateY0(y0);
	}

	@Override
	public double getU0() {
		return getU();
	}

	@Override
	public void eulerStep1(double u, double dt) {
		eulerStep1(u, dt, null, null);
	}

	@Override
	public void eulerStep2(double u, double dt) {
		eulerStep2(u, dt, null, null);
	}

	public void eulerStep1(double u, double dt, double[] maxDAry,
			double[] minDAry) {
		super.eulerStep1(u, dt);
		if (getType() == IStaticBlock.Type.NonWindup) {
			if (limit.isViolated(getStateX(), maxDAry, minDAry)) {
				setDxDt(0.0);
				setStateX(limit.limit(getStateX(), maxDAry, minDAry));
			}
		}
	}

	public void eulerStep2(double u, double dt, double[] maxDAry,
			double[] minDAry) {
		super.eulerStep2(u, dt);
		if (getType() == IStaticBlock.Type.NonWindup)
			setStateX(limit.limit(getStateX(), maxDAry, minDAry));
	}

	@Override
	public double getY() {
		//System.out.println("state " + getStateX());
		double y = getStateX();
		if (getT() <= 0.0)
			y = getK() * getU();
		if (getType() == IStaticBlock.Type.Limit)
			return limit.limit(y);
		else
			return y;
	}

	@Override
	protected double dX_dt(double u) {
		if (getT() > 0.0)
			return (getK() * u - getStateX()) / getT();
		else
			return 0.0;
	}

	/**
	 * @return the k
	 */
	public double getK() {
		return k;
	}

	/**
	 * @return the limit
	 */
	public LimitExpression getLimit() {
		return limit;
	}

	/**
	 * @return the t
	 */
	public double getT() {
		return t;
	}

	@Override
	public String toString() {
		String str = "type, k, t, limit: " + getType() + ", " + k + ", " + t
				+ ", " + limit;
		return str;
	}
}
