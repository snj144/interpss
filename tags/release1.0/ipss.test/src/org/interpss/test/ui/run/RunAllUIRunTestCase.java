 /*
  * @(#)RunAllUIRunTestCase.java   
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

package org.interpss.test.ui.run;

import java.util.logging.Level;

import junit.framework.TestCase;

import org.interpss.test.ui.run.aclf.TestAclfCaseInfoCase;
import org.interpss.test.ui.run.acsc.TestAcscBranchFaultCaseInfoCase;
import org.interpss.test.ui.run.acsc.TestAcscBusFaultCaseInfoCase;
import org.interpss.test.ui.run.acsc.TestAcscCaseInfoCase;
import org.interpss.test.ui.run.dstab.TestDStabAdvancedCaseInfoCase;
import org.interpss.test.ui.run.dstab.TestDStabCaseInfoCase;
import org.interpss.test.ui.run.dstab.TestDStabDEventCaseInfoCase;
import org.interpss.test.ui.run.dstab.TestMuitlpleEventsCaseInfoCase;

import com.interpss.common.util.IpssLogger;

public class RunAllUIRunTestCase extends TestCase {
	public static void main(String args[]) {
		IpssLogger.getLogger().setLevel(Level.WARNING);
		runAll();
		System.exit(0);
	}
	
	public static void runAll() {
		System.out.println("Run All editor.jgraph JUnit ui.run test cases");
		System.out.println("=============================================");
		junit.textui.TestRunner.run(TestCaseInfoDialogCase.class);
		junit.textui.TestRunner.run(TestAclfCaseInfoCase.class);
		junit.textui.TestRunner.run(TestAcscCaseInfoCase.class);
		junit.textui.TestRunner.run(TestAcscBusFaultCaseInfoCase.class);
		junit.textui.TestRunner.run(TestAcscBranchFaultCaseInfoCase.class);

		System.out.println("Run All editor.jgraph JUnit ui.run.dstab test cases");
		System.out.println("===================================================");
		junit.textui.TestRunner.run(TestDStabCaseInfoCase.class);
		junit.textui.TestRunner.run(TestDStabAdvancedCaseInfoCase.class);
		junit.textui.TestRunner.run(TestDStabDEventCaseInfoCase.class);
		junit.textui.TestRunner.run(TestMuitlpleEventsCaseInfoCase.class);

		// multiple case has been disabled now
		//		junit.textui.TestRunner.run(TestMuitlpleCasesCaseInfoCase.class);
	}
}