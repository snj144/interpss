/*
 * @(#)ODMThrowableAdvice.java   
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
 * @Date 09/15/2010
 * 
 *   Revision History
 *   ================
 *
 */

package org.ieee.odm.common;

import java.lang.reflect.Method;

import javax.xml.bind.JAXBException;

import org.springframework.aop.ThrowsAdvice;

public class ODMThrowableAdvice implements ThrowsAdvice {
	public static boolean printTrace = false;
	
	public ODMThrowableAdvice() {
	}

	public void afterThrowing(Exception ex) throws Throwable {
		ODMLogger.getLogger().severe("Caught: " + ex.getClass().getName() +
				"\nMessage: " + ex.toString());
	}

	public void afterThrowing(Method method, Object[] args, Object target,
			JAXBException ex) throws Throwable {
		ODMLogger.getLogger().severe("Caught: " + ex.getClass().getName() +
				", Method: " + target.getClass().getSimpleName() + "." +method.getName() +
				"\nError Message: " + ex.toString());
		if (printTrace)
			ex.printStackTrace();
	}

	public void afterThrowing(Method method, Object[] args, Object target,
			ODMException ex) throws Throwable {
		ODMLogger.getLogger().severe("Caught: " + ex.getClass().getName() +
				", Method: " + target.getClass().getSimpleName() + "." +method.getName() +
				"\nError Message: " + ex.toString());
		if (printTrace)
			ex.printStackTrace();
	}
}
