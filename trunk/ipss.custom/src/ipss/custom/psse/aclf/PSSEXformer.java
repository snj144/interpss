 /*
  * @(#)PSSEXformer.java   
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
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */
package ipss.custom.psse.aclf;

import org.apache.commons.math.complex.Complex;

import ipss.custom.psse.OwnerRec;

import com.interpss.common.datatype.LimitType;
import com.interpss.core.aclf.impl.AclfBranchExtImpl;

public class PSSEXformer extends AclfBranchExtImpl {
	private int flagWinding = 1;
	private int flagZ = 1;
	private int flagMagnetizing = 1;
	private double magG = 0.0;
	private double magB = 0.0;
	private double mvaRating = 0.0;   // in mav
	private double fromRatedVoltage;  // in Volts
	private double toRatedVoltage;    // in Volts
	private int xfrTableIdNumber = 0;
  	
	private int controlMode =0;
	private String contBusId = "";
	private boolean controlOnFromSide = false;
	private LimitType rmLimit = null; 
	private LimitType vmLimit = null; 
	private int adjSteps = 0;

	private Complex loadDropCZ = new Complex(0.0,0.0);

	private OwnerRec[]  ownerList = new OwnerRec[4];
	
	public PSSEXformer(String cirId) {
      	setCircuitNumber(cirId);
	}
	
	public OwnerRec getOwnerRec(int i) {
		if (ownerList[i] == null)
			ownerList[i] = new OwnerRec();
		return ownerList[i];
	}

	/**
	 * @return the falgMagnetizing
	 */
	public int getFlagMagnetizing() {
		return flagMagnetizing;
	}

	/**
	 * @param falgMagnetizing the flagMagnetizing to set
	 */
	public void setFlagMagnetizing(int flagMagnetizing) {
		this.flagMagnetizing = flagMagnetizing;
	}

	/**
	 * @return the fladWinding
	 */
	public int getFlagWinding() {
		return flagWinding;
	}

	/**
	 * @param fladWinding the fladWinding to set
	 */
	public void setFlagWinding(int fladWinding) {
		this.flagWinding = fladWinding;
	}

	/**
	 * @return the flagZ
	 */
	public int getFlagZ() {
		return flagZ;
	}

	/**
	 * @param flagZ the flagZ to set
	 */
	public void setFlagZ(int flagZ) {
		this.flagZ = flagZ;
	}

	/**
	 * @return the magB
	 */
	public double getMagB() {
		return magB;
	}

	/**
	 * @param magB the magB to set
	 */
	public void setMagB(double magB) {
		this.magB = magB;
	}

	/**
	 * @return the magG
	 */
	public double getMagG() {
		return magG;
	}

	/**
	 * @param magG the magG to set
	 */
	public void setMagG(double magG) {
		this.magG = magG;
	}

	/**
	 * @return the fromRatedVoltage
	 */
	public double getFromRatedVoltage() {
		return fromRatedVoltage;
	}

	/**
	 * @param fromRatedVoltage the fromRatedVoltage to set
	 */
	public void setFromRatedVoltage(double fromRatedVoltage) {
		this.fromRatedVoltage = fromRatedVoltage;
	}

	/**
	 * @return the mvaRating
	 */
	public double getMvaRating() {
		return mvaRating;
	}

	/**
	 * @param mvaRating the mvaRating to set
	 */
	public void setMvaRating(double mvaRating) {
		this.mvaRating = mvaRating;
	}

	/**
	 * @return the toRatedVoltage
	 */
	public double getToRatedVoltage() {
		return toRatedVoltage;
	}

	/**
	 * @param toRatedVoltage the toRatedVoltage to set
	 */
	public void setToRatedVoltage(double toRatedVoltage) {
		this.toRatedVoltage = toRatedVoltage;
	}

	/**
	 * @return the xfrTableIdNumber
	 */
	public int getXfrTableIdNumber() {
		return xfrTableIdNumber;
	}

	/**
	 * @param xfrTableIdNumber the xfrTableIdNumber to set
	 */
	public void setXfrTableIdNumber(int xfrTableIdNumber) {
		this.xfrTableIdNumber = xfrTableIdNumber;
	}
	
	public String toString() {
		StringBuffer result = new StringBuffer(super.toString());
		return result.toString();
	}

	/**
	 * @return the adjSteps
	 */
	public int getAdjSteps() {
		return adjSteps;
	}

	/**
	 * @param adjSteps the adjSteps to set
	 */
	public void setAdjSteps(int adjSteps) {
		this.adjSteps = adjSteps;
	}

	/**
	 * @return the contBusId
	 */
	public String getContBusId() {
		return contBusId;
	}

	/**
	 * @param contBusId the contBusId to set
	 */
	public void setContBusId(String contBusId) {
		this.contBusId = contBusId;
	}

	/**
	 * @return the controlMode
	 */
	public int getControlMode() {
		return controlMode;
	}

	/**
	 * @param controlMode the controlMode to set
	 */
	public void setControlMode(int controlMode) {
		this.controlMode = controlMode;
	}

	/**
	 * @return the loadDropCZ
	 */
	public Complex getLoadDropCZ() {
		return loadDropCZ;
	}

	/**
	 * @param loadDropCZ the loadDropCZ to set
	 */
	public void setLoadDropCZ(Complex loadDropCZ) {
		this.loadDropCZ = loadDropCZ;
	}

	/**
	 * @return the rmLimit
	 */
	public LimitType getRmLimit() {
		return rmLimit;
	}

	/**
	 * @param rmLimit the rmLimit to set
	 */
	public void setRmLimit(LimitType rmLimit) {
		this.rmLimit = rmLimit;
	}

	/**
	 * @return the vmLimit
	 */
	public LimitType getVmLimit() {
		return vmLimit;
	}

	/**
	 * @param vmLimit the vmLimit to set
	 */
	public void setVmLimit(LimitType vmLimit) {
		this.vmLimit = vmLimit;
	}

	/**
	 * @return the controlOnFromSide
	 */
	public boolean getControlOnFromSide() {
		return controlOnFromSide;
	}

	/**
	 * @param controlOnFromSide the controlOnFromSide to set
	 */
	public void setControlOnFromSide(boolean controlOnFromSide) {
		this.controlOnFromSide = controlOnFromSide;
	}	
}
