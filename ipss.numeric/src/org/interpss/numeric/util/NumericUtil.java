/*
 * @(#)NumericUtil.java   
 *
 * Copyright (C) 2006-2010 www.interpss.com
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
 * @Date 12/10/2010
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.numeric.util;

public class NumericUtil {
	private static final double ERR = 1.0e-10;
	
	/**
	 * Check if the two ints are equal
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static boolean equals(int x, int y) {
		return x == y;
	}

	/**
	 * Check if the two doubles are equal regarding to standard err
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static boolean equals(double x, double y) {
		return equals(x, y, ERR);
	}

	/**
	 * Check if the two doubles are equal regarding to the err
	 * 
	 * @param x
	 * @param y
	 * @param err
	 * @return
	 */
	public static boolean equals(double x, double y, double err) {
		return Math.abs(x - y) < err;
	}
}
