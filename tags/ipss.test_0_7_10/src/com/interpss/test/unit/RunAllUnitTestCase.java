package com.interpss.test.unit;

import java.util.logging.Level;

import junit.framework.TestCase;

import com.interpss.common.util.IpssLogger;
import com.interpss.test.unit.adapter.RunAllCustomAdapterTestCase;
import com.interpss.test.unit.core.RunAllCoreTestCase;
import com.interpss.test.unit.db.RunAllDatabaseTestCase;
import com.interpss.test.unit.dstab.RunAllDStabTestCase;
import com.interpss.test.unit.spring.RunAllSpringTestCase;
import com.interpss.test.unit.util.TestUtilCase;

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