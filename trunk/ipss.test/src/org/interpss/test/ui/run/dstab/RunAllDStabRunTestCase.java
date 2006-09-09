package org.interpss.test.ui.run.dstab;

import java.util.logging.Level;

import junit.framework.TestCase;

import com.interpss.common.util.IpssLogger;

public class RunAllDStabRunTestCase extends TestCase {
	public static void main(String args[]) {
		IpssLogger.getLogger().setLevel(Level.WARNING);
		runAll();
		System.exit(0);
	}
	
	public static void runAll() {
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