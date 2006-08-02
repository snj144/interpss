package com.interpss.test.unit.dstab;

import java.util.logging.Level;

import com.interpss.common.util.IpssLogger;
import com.interpss.test.unit.dstab.controller.exc.TestSimpleExcitorCase;
import com.interpss.test.unit.dstab.controller.gov.TestSimpleGovernorCase;
import com.interpss.test.unit.dstab.controller.pss.TestSimpleStabilizerCase;
import com.interpss.test.unit.dstab.mach.TestEConstMachineCase;
import com.interpss.test.unit.dstab.mach.TestEq1Ed1MachineCase;
import com.interpss.test.unit.dstab.mach.TestEq1MachineCase;
import com.interpss.test.unit.dstab.mach.TestRoundRotorMachineCase;
import com.interpss.test.unit.dstab.mach.TestSalientPoleMachineCase;

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
	}
}