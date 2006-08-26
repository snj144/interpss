package org.interpss.test.unit;

import java.util.logging.Level;

import org.interpss.test.unit.adapter.RunAllCustomAdapterTestCase;
import org.interpss.test.unit.core.RunAllCoreTestCase;
import org.interpss.test.unit.db.RunAllDatabaseTestCase;
import org.interpss.test.unit.dstab.RunAllDStabTestCase;
import org.interpss.test.unit.spring.RunAllSpringTestCase;
import org.interpss.test.unit.util.TestUtilCase;

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

		RunAllDatabaseTestCase.runAll();

		RunAllDStabTestCase.runAll();

		RunAllSpringTestCase.runAll();
		
		junit.textui.TestRunner.run(TestUtilCase.class);
	}
}