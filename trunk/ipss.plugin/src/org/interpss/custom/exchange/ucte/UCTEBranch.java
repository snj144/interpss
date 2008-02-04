 /*
  * @(#)UCTEBranch.java   
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
  * @Date 02/01/2008
  * 
  *   Revision History
  *   ================
  *
  */
package org.interpss.custom.exchange.ucte;

import com.interpss.core.aclf.impl.AclfBranchImpl;

public class UCTEBranch extends AclfBranchImpl {
	private String orderCode;
	private int currentLimit;
	private double fromRatedKV, toRatedKV, normialMva;

	public UCTEBranch(String name) {
		super();
      	setName(name);
	}

	public String getOrderCode() {
		return this.orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public int getCurrentLimit() {
		return this.currentLimit;
	}

	public void setCurrentLimit(int currentLimit) {
		this.currentLimit = currentLimit;
	}

	public double getFromRatedKV() {
		return this.fromRatedKV;
	}

	public void setFromRatedKV(double fromRatedKV) {
		this.fromRatedKV = fromRatedKV;
	}

	public double getToRatedKV() {
		return this.toRatedKV;
	}

	public void setToRatedKV(double toRatedKV) {
		this.toRatedKV = toRatedKV;
	}

	public double getNormialMva() {
		return this.normialMva;
	}

	public void setNormialMva(double normialMva) {
		this.normialMva = normialMva;
	}
}
