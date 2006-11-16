 /*
  * @(#)RunAllDStabTestCase.java   
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

package org.interpss.test.simu.dstab.ieeeModel;

import java.util.logging.Level;

import com.interpss.common.util.IpssLogger;

public class RunAllIEEEModelTestCase {
	
	public static void main(String args[]) {
		IpssLogger.getLogger().setLevel(Level.WARNING);
		
		runAll();
		System.exit(1);
	}
	
	public static void runAll() {
		System.out.println("Run All test.dstab.ieeeModel JUnit test cases");
		System.out.println("=============================================");
		junit.textui.TestRunner.run(TestIEEE11ModelCase.class);
		junit.textui.TestRunner.run(TestIEEE12ModelCase.class);
		junit.textui.TestRunner.run(TestIEEE21ModelCase.class);
		junit.textui.TestRunner.run(TestIEEE22ModelCase.class);
	}
}