 /*
  * @(#)NetDataUtil.java   
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

package org.interpss.editor.ui.util;

/**
	Network data related manipulation util functions
*/
	
public class NetDataUtil {
	/**
	*	Calculate ratia x/y, if y == 0.0, return 0.0
	*
	* @param x parameter x
	* @param y parameter y
	* @return the ratio
	*/
	public static double ratio(double x, double y) {
		if ( y == 0.0 )
			return 0.0;
		else
			return x / y;	
	}

	/**
	*	Calculate value x * raito
	*
	* @param x parameter x
	* @param ratio parameter ratio
	* @return the value
	*/
	public static double calValue(double x, double ratio) {
		return x * ratio;
	}
}