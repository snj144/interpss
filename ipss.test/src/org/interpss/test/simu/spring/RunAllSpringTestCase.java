 /*
  * @(#)RunAllSpringTestCase.java   
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

package org.interpss.test.simu.spring;

import java.util.logging.Level;

import com.interpss.common.util.IpssLogger;

import junit.framework.*;

public class RunAllSpringTestCase extends TestCase {
	public static void main(String args[]) {
		IpssLogger.getLogger().setLevel(Level.WARNING);
		
		System.out.println("Begin RunAllSpringTestCase ...");

		runAll();

		System.out.println("End RunAllSpringTestCase ...");
		System.exit(0);
	}
	
	public static void runAll() {
		System.out.println("Run All Spring Test cases");
		System.out.println("=========================");
		junit.textui.TestRunner.run(TestCustomFileAdapter.class);
		junit.textui.TestRunner.run(TestDStabController.class);
		junit.textui.TestRunner.run(TestSimuAppCtx.class);
	}
}