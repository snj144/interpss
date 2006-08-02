package com.interpss.test.unit.spring;

import java.util.logging.Level;

import com.interpss.common.util.IpssLogger;

import junit.framework.*;

public class RunAllSpringTestCase extends TestCase {
	public static void main(String args[]) {
		IpssLogger.getLogger().setLevel(Level.WARNING);
		
		System.out.println("Begin RunAllSpringTestCase ...");

		runAll();

		System.out.println("End RunAllSpringTestCase ...");
		System.exit(0);
	}
	
	public static void runAll() {
		System.out.println("Run All Spring Test cases");
		System.out.println("=========================");
		junit.textui.TestRunner.run(TestCustomFileAdapter.class);
		junit.textui.TestRunner.run(TestDStabController.class);
		junit.textui.TestRunner.run(TestSimuAppCtx.class);
	}
}