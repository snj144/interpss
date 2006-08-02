package com.interpss.test.unit.db;

import java.util.logging.Level;

import com.interpss.common.util.IpssLogger;

import junit.framework.*;

public class RunAllDatabaseTestCase extends TestCase {
	public static void main(String args[]) {
		IpssLogger.getLogger().setLevel(Level.WARNING);
		
		System.out.println("Begin RunAllDBTestCase ...");

		runAll();

		System.out.println("End RunAllDBTestCase ...");
		System.exit(0);
	}
	
	public static void runAll() {
		System.out.println("Run All Database Test cases");
		System.out.println("===========================");
		junit.textui.TestRunner.run(ProjectDBTest.class);
		junit.textui.TestRunner.run(RefDataDBTest.class);
		junit.textui.TestRunner.run(SimuRecDBTest.class);
	}
}