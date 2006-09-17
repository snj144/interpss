 /*
  * @(#)RunAllSimuUnitTestCase.java   
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


package org.interpss.test.simu;

import java.util.logging.Level;

import org.interpss.test.simu.adapter.RunAllCustomAdapterTestCase;
import org.interpss.test.simu.core.RunAllCoreTestCase;
import org.interpss.test.simu.dstab.RunAllDStabTestCase;
import org.interpss.test.simu.spring.RunAllSpringTestCase;
import org.interpss.test.simu.util.TestUtilCase;

import junit.framework.TestCase;

import com.interpss.common.util.IpssLogger;

public class RunAllSimuUnitTestCase extends TestCase {
	public static void main(String args[]) {
		IpssLogger.getLogger().setLevel(Level.WARNING);
		
		System.out.println("Begin RunAllUnitTestCase ...");

		runAll();

		System.out.println("End RunAllUnitTestCase ...");
		System.exit(0);
	}
	
	public static void runAll() {
		RunAllCustomAdapterTestCase.runAll();

		RunAllCoreTestCase.runAll();

		RunAllDStabTestCase.runAll();

		RunAllSpringTestCase.runAll();
		
		junit.textui.TestRunner.run(TestUtilCase.class);
	}
}