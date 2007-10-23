 /*
  * @(#)DStabLoadChangeData.java   
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

package org.interpss.editor.data.dstab;

import com.interpss.common.util.NetUtilFunc;

public class DStabLoadChangeData extends DStabControllerData {
	private static final long serialVersionUID = 1;

	public final static String LowFreq = "LowFrequency";
	public final static String LowVolt = "LowVoltage";
	public final static String FixedTime = "FixedTime";
	
	private String busNameId;
	private double changeFactor;  // in %
	private String changeType = LowFreq;
	private double threshhold = 0.0;
	private double delayTime = 0.0;
	
	/**
	 * @return Returns the busId.
	 */
	public String getBusNameId() {
		return busNameId;
	}
	public String getBusId() {
		return NetUtilFunc.getBusIdFromDisplayNameId(getBusNameId());
	}
	/**
	 * @param busId The busId to set.
	 */
	public void setBusNameId(String busId) {
		this.busNameId = busId;
	}
	/**
	 * @return Returns the changeFactor.
	 */
	public double getChangeFactor() {
		return changeFactor;
	}
	/**
	 * @param changeFactor The changeFactor to set.
	 */
	public void setChangeFactor(double changeFactor) {
		this.changeFactor = changeFactor;
	}
	public String getChangeType() {
		return changeType;
	}
	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}
	public double getThreshhold() {
		return threshhold;
	}
	public void setThreshhold(double threshhold) {
		this.threshhold = threshhold;
	}
	public double getDelayTime() {
		return delayTime;
	}
	public void setDelayTime(double delayTime) {
		this.delayTime = delayTime;
	}
}
