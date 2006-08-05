package com.interpss.test.ui.run;

import java.util.logging.Level;

import com.interpss.common.util.IpssLogger;
import com.interpss.test.ui.run.TestCaseInfoDialogCase;
import com.interpss.test.ui.run.aclf.TestAclfCaseInfoCase;
import com.interpss.test.ui.run.acsc.TestAcscBranchFaultCaseInfoCase;
import com.interpss.test.ui.run.acsc.TestAcscBusFaultCaseInfoCase;
import com.interpss.test.ui.run.acsc.TestAcscCaseInfoCase;
import com.interpss.test.ui.run.dstab.TestDStabAdvancedCaseInfoCase;
import com.interpss.test.ui.run.dstab.TestDStabCaseInfoCase;
import com.interpss.test.ui.run.dstab.TestDStabDEventCaseInfoCase;
import com.interpss.test.ui.run.dstab.TestMuitlpleCasesCaseInfoCase;
import com.interpss.test.ui.run.dstab.TestMuitlpleEventsCaseInfoCase;

import junit.framework.*;

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
		junit.textui.TestRunner.run(TestMuitlpleCasesCaseInfoCase.class);
	}
}