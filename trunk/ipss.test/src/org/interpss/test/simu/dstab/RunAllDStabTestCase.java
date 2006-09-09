package org.interpss.test.simu.dstab;

import java.util.logging.Level;

import org.interpss.test.simu.dstab.controller.exc.TestSimpleExcitorCase;
import org.interpss.test.simu.dstab.controller.gov.TestSimpleGovernorCase;
import org.interpss.test.simu.dstab.controller.pss.TestSimpleStabilizerCase;
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
	}
}