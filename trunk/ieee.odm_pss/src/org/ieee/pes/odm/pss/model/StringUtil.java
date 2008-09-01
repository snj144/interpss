/*
 * @(#)StringUtil.java   
 *
 * Copyright (C) 2006 www.interpss.com
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
 * @Date 02/15/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.ieee.pes.odm.pss.model;

public class StringUtil {
	/**
	 * convert charters [beginCol, endCol] of the input string to a double. Return 0.0 number if empty. 
	 * 
	 * @param str input string
	 * @param beginCol begin column, starts from 1 ...
	 * @param endCol end column
	 * @return the number
	 */
	public static double getDouble(String str, int beginCol, int endCol) throws Exception {
		if (str.length() < endCol)
			return 0.0;
		String s = str.substring(beginCol-1, endCol);
		if (s.trim().equals(""))
			return 0.0;
		else
			return new Double(s.trim()).doubleValue();
	}

	/**
	 * convert str to a double. Return defaultValue number if empty. 
	 * 
	 * @param str input string
	 * @return the number
	 */
	public static double getDouble(String str, double defaultValue) {
		try {
			return new Double(str.trim()).doubleValue();
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * convert str to an int. Return defaultValue number if empty. 
	 * 
	 * @param str input string
	 * @return the number
	 */
	public static int getInt(String str, int defaultValue) {
		try {
			return new Integer(str.trim()).intValue();
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * convert charters [beginCol, endCol] of the input string to an int. Return 0 if empty. 
	 * 
	 * @param str input string
	 * @param beginCol begin column, starts from 1 ...
	 * @param endCol end column
	 * @return the number
	 */
	public static int getInt(String str, int beginCol, int endCol) throws Exception {
		if (str.length() < endCol)
			return 0;
		String s = str.substring(beginCol-1, endCol);
		if (s.trim().equals(""))
			return 0;
		else
			return new Integer(s.trim()).intValue();
	}

	/**
	 * convert charters [beginCol, endCol] of the input string to an String. Return null if empty. 
	 * 
	 * @param str input string
	 * @param beginCol begin column, starts from 1 ...
	 * @param endCol end column
	 * @return the string
	 */
	public static String getString(String str, int beginCol, int endCol) {
		if (str.length() < endCol)
			return null;
		return str.substring(beginCol-1, endCol).trim();
	}
	
	/**
	 * convert charters [beginCol, endCol] of the input string to an String. Return null if empty. 
	 * 
	 * @param str input string
	 * @param beginCol begin column, starts from 1 ...
	 * @param endCol end column
	 * @return the string
	 */
	public static String getStringReturnEmptyString(String str, int beginCol, int endCol) {
		if (str.length() < endCol)
			return "";
		return str.substring(beginCol-1, endCol).trim();
	}
	
	
}
