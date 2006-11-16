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

package org.interpss.test.simu.dstab;

import java.util.logging.Level;

import org.interpss.test.simu.dstab.controller.block.TestDelayCase;
import org.interpss.test.simu.dstab.controller.block.TestFilterCase;
import org.interpss.test.simu.dstab.controller.block.TestIntegrationCase;
import org.interpss.test.simu.dstab.controller.block.TestPIBlockCase;
import org.interpss.test.simu.dstab.controller.block.TestWashoutCase;
import org.interpss.test.simu.dstab.controller.exc.TestSimpleExcitorCase;
import org.interpss.test.simu.dstab.controller.gov.TestSimpleGovernorCase;
import org.interpss.test.simu.dstab.controller.pss.TestSimpleStabilizerCase;
import org.interpss.test.simu.dstab.ieeeModel.TestIEEE11ModelCase;
import org.interpss.test.simu.dstab.ieeeModel.TestIEEE12ModelCase;
import org.interpss.test.simu.dstab.ieeeModel.TestIEEE21ModelCase;
import org.interpss.test.simu.dstab.ieeeModel.TestIEEE22ModelCase;
import org.interpss.test.simu.dstab.mach.TestEConstMachineCase;
import org.interpss.test.simu.dstab.mach.TestEq1Ed1MachineCase;
import org.interpss.test.simu.dstab.mach.TestEq1MachineCase;
import org.interpss.test.simu.dstab.mach.TestRoundRotorMachineCase;
import org.interpss.test.simu.dstab.mach.TestSalientPoleMachineCase;

import com.interpss.common.util.IpssLogger;

public class RunAllDStabTestCase {
	
	public static void main(String args[]) {
		IpssLogger.getLogger().setLevel(Level.WARNING);
		
		runAll();
		System.exit(1);
	}
	
	public static void runAll() {
		System.out.println("Run All test.dstab JUnit test cases");
		System.out.println("===================================");
		junit.textui.TestRunner.run(TestEq1Ed1MachineCase.class);
		junit.textui.TestRunner.run(TestEq1MachineCase.class);
		junit.textui.TestRunner.run(TestEConstMachineCase.class);
		junit.textui.TestRunner.run(TestRoundRotorMachineCase.class);
		junit.textui.TestRunner.run(TestSalientPoleMachineCase.class);

		junit.textui.TestRunner.run(TestSimpleExcitorCase.class);
		junit.textui.TestRunner.run(TestSimpleGovernorCase.class);
		junit.textui.TestRunner.run(TestSimpleStabilizerCase.class);

		junit.textui.TestRunner.run(TestDelayCase.class);
		junit.textui.TestRunner.run(TestFilterCase.class);
		junit.textui.TestRunner.run(TestWashoutCase.class);
		junit.textui.TestRunner.run(TestIntegrationCase.class);
		junit.textui.TestRunner.run(TestPIBlockCase.class);
		
		junit.textui.TestRunner.run(TestIEEE11ModelCase.class);
		junit.textui.TestRunner.run(TestIEEE12ModelCase.class);
		junit.textui.TestRunner.run(TestIEEE21ModelCase.class);
		junit.textui.TestRunner.run(TestIEEE22ModelCase.class);		
	}
}