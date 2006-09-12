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
	private String busNameId;
	private double changeFactor;  // in %
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
}
