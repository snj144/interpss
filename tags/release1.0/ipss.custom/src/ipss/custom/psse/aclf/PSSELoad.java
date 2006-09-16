 /*
  * @(#)PSSELoad.java   
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

import com.interpss.common.util.XmlUtil;
import com.interpss.core.aclfadj.impl.RegulateLoadImpl;

public class PSSELoad extends RegulateLoadImpl {

	private int areaNo = 0;
	private int zoneNo = 0;
	private int ownerNo = 0;
	private Complex constPLoad = new Complex(0.0,0.0);   // in pu
	private Complex constILoad = new Complex(0.0,0.0);   // in pu
	private Complex constZLoad = new Complex(0.0,0.0);   // in pu

	/**
	 * @return the areaNo
	 */
	public int getAreaNo() {
		return areaNo;
	}
	/**
	 * @param areaNo the areaNo to set
	 */
	public void setAreaNo(int areaNo) {
		this.areaNo = areaNo;
	}
	/**
	 * @return the pLoad
	 */
	/**
	 * @return the zoneNo
	 */
	public int getZoneNo() {
		return zoneNo;
	}
	/**
	 * @param zoneNo the zoneNo to set
	 */
	public void setZoneNo(int zoneNo) {
		this.zoneNo = zoneNo;
	}
	/**
	 * @return the ownerNo
	 */
	public int getOwnerNo() {
		return ownerNo;
	}
	/**
	 * @param ownerNo the ownerNo to set
	 */
	public void setOwnerNo(int ownerNo) {
		this.ownerNo = ownerNo;
	}
	
	public String toString() {
		return XmlUtil.toXmlString(this);
	}
	/**
	 * @return the constILoad
	 */
	public Complex getConstILoad() {
		return constILoad;
	}
	/**
	 * @param constILoad the constILoad to set
	 */
	public void setConstILoad(Complex constILoad) {
		this.constILoad = constILoad;
	}
	/**
	 * @return the constPLoad
	 */
	public Complex getConstPLoad() {
		return constPLoad;
	}
	/**
	 * @param constPLoad the constPLoad to set
	 */
	public void setConstPLoad(Complex constPLoad) {
		this.constPLoad = constPLoad;
	}
	/**
	 * @return the constZLoad
	 */
	public Complex getConstZLoad() {
		return constZLoad;
	}
	/**
	 * @param constZLoad the constZLoad to set
	 */
	public void setConstZLoad(Complex constZLoad) {
		this.constZLoad = constZLoad;
	}
}
