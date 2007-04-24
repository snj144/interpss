 /*
  * @(#)BaseControllerData.java   
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

package org.interpss.dstab.control.base;

/**
 * Base class for defining controller data
 * 
 * @author mzhou
 *
 */
public abstract class BaseControllerData {
	private static String[][] rangeParameters;

	public abstract void setValue(String name, double value);
	public abstract void setValue(String name, int value);

	/**
	 * 
	 * 
	 * @param s
	 * @return
	 */
	public double getMaxValue(String s) {
		return getParamValue(s, 2);
	}

	public double getMinValue(String s) {
		return getParamValue(s, 1);
	}
	

	public boolean isOutRange(String name, double value) {
		return getMaxValue(name) <= value && value >= getMinValue(name);
	}

	protected void setRangeParameters(String[][] p) {
		rangeParameters = p;
	}
	
	private static double getParamValue(String s, int position) {
		for (String[] sAry : rangeParameters) {
			if (s.equals(sAry[0])) {
				return new Double(sAry[position]).doubleValue();
			}
		}
		return 0.0;
	}
}
