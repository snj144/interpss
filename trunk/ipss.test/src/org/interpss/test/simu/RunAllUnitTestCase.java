package org.interpss.test.simu;

import java.util.logging.Level;

import org.interpss.test.simu.adapter.RunAllCustomAdapterTestCase;
import org.interpss.test.simu.core.RunAllCoreTestCase;
import org.interpss.test.simu.dstab.RunAllDStabTestCase;
import org.interpss.test.simu.spring.RunAllSpringTestCase;
import org.interpss.test.simu.util.TestUtilCase;

import junit.framework.TestCase;

import com.interpss.common.util.IpssLogger;

public class RunAllUnitTestCase extends TestCase {
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