package org.interpss.test.ui.run;

import java.util.logging.Level;

import org.interpss.test.ui.run.TestCaseInfoDialogCase;
import org.interpss.test.ui.run.aclf.TestAclfCaseInfoCase;
import org.interpss.test.ui.run.acsc.TestAcscBranchFaultCaseInfoCase;
import org.interpss.test.ui.run.acsc.TestAcscBusFaultCaseInfoCase;
import org.interpss.test.ui.run.acsc.TestAcscCaseInfoCase;
import org.interpss.test.ui.run.dstab.TestDStabAdvancedCaseInfoCase;
import org.interpss.test.ui.run.dstab.TestDStabCaseInfoCase;
import org.interpss.test.ui.run.dstab.TestDStabDEventCaseInfoCase;
import org.interpss.test.ui.run.dstab.TestMuitlpleCasesCaseInfoCase;
import org.interpss.test.ui.run.dstab.TestMuitlpleEventsCaseInfoCase;

import com.interpss.common.util.IpssLogger;

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

		// multiple case has been disabled now
		//		junit.textui.TestRunner.run(TestMuitlpleCasesCaseInfoCase.class);
	}
}