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
	private int currentLimit;
	private double fromRatedKV, toRatedKV, normialMva;

	private String regulationType;
	private double dUPhase, uKvPhase; 
	private int nPhase, n1Phase; 
	
	private double dUAngle, thetaDegAngle, pMwAngle;  
	private int nAngle, n1Angle; 
	
	public UCTEBranch(String name, String orderCode) {
		super();
      	setName(name);
      	this.setCircuitNumber(orderCode);
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

	public String getRegulationType() {
		return this.regulationType;
	}

	public void setRegulationType(String regulationType) {
		this.regulationType = regulationType;
	}

	public double getDUPhase() {
		return this.dUPhase;
	}

	public void setDUPhase(double phase) {
		this.dUPhase = phase;
	}

	public double getUKvPhase() {
		return this.uKvPhase;
	}

	public void setUKvPhase(double kvPhase) {
		this.uKvPhase = kvPhase;
	}

	public int getNPhase() {
		return this.nPhase;
	}

	public void setNPhase(int phase) {
		this.nPhase = phase;
	}

	public int getN1Phase() {
		return this.n1Phase;
	}

	public void setN1Phase(int phase) {
		this.n1Phase = phase;
	}

	public double getDUAngle() {
		return this.dUAngle;
	}

	public void setDUAngle(double angle) {
		this.dUAngle = angle;
	}

	public double getThetaDegAngle() {
		return this.thetaDegAngle;
	}

	public void setThetaDegAngle(double thetaDegAngle) {
		this.thetaDegAngle = thetaDegAngle;
	}

	public double getPMwAngle() {
		return this.pMwAngle;
	}

	public void setPMwAngle(double mwAngle) {
		this.pMwAngle = mwAngle;
	}

	public int getNAngle() {
		return this.nAngle;
	}

	public void setNAngle(int angle) {
		this.nAngle = angle;
	}

	public int getN1Angle() {
		return this.n1Angle;
	}

	public void setN1Angle(int angle) {
		this.n1Angle = angle;
	}
}
