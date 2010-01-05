 /*
  * @(#)UtilFunc.java   
  *
  * Copyright (C) 2007 www.opencim.org
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
  * @Date 03/04/2007
  * 
  *   Revision History
  *   ================
  *
  */

package org.opencim.datatype.util;

import java.lang.reflect.Constructor;

import org.opencim.common.CIMLogger;
import org.opencim.datatype.base.AnInitConstructor;

public class DataTypeUtilFunc {
	/**
	 *  Check if MRID string has ilegal charaters.
	 * 
	 * @param mRID
	 * @return
	 */
	public static boolean hasMRIDIlegalChar(String mRID) {
		return false;
	}
	
	/**
	 * Create a object based on the class type and a init string.
	 * 
	 * @param klass Class of the object to be created
	 * @param str init string, for example (10.0, MVA) for ApparentPower
	 * @return
	 */
	public static Object createDataObject(Class<?> klass, String str) {
		for (Constructor<?> c : klass.getConstructors() ) {
			if (c.getAnnotation(AnInitConstructor.class) != null)
				try {
					return c.newInstance(str);
				} catch (Exception e) {
					CIMLogger.getLogger().severe(e.toString());
					return null;
				}
		}
		//CIMLogger.getLogger().warning("Class " + klass.getName() + " does not have a annotated constructor");
		return null;
	}
}
