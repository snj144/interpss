package org.interpss.test.unit.adapter;

import java.util.logging.Level;

import org.interpss.test.unit.adapter.ieee.Test_IEEECommonFormat;
import org.interpss.test.unit.adapter.ieee.Test_IEEECommonFormat_Comma;
import org.interpss.test.unit.adapter.internal.Test_Bus1824;
import org.interpss.test.unit.adapter.internal.Test_Bus6384;
import org.interpss.test.unit.adapter.internal.Test_IEEE14;

import com.interpss.common.util.IpssLogger;

import junit.framework.*;

public class RunAllCustomAdapterTestCase extends TestCase {
	public static void main(String args[]) {
		IpssLogger.getLogger().setLevel(Level.WARNING);
		
		System.out.println("Begin RunAllCustomAdapterTestCase ...");

		runAll();

		System.out.println("End RunAllCustomAdapterTestCase ...");
		System.exit(0);
	}
	
	public static void runAll() {
		System.out.println("Run All Interpss Internal format adapter Test cases");
		System.out.println("===================================================");
		junit.textui.TestRunner.run(Test_IEEE14.class);
		junit.textui.TestRunner.run(Test_Bus1824.class);
		junit.textui.TestRunner.run(Test_Bus6384.class);

		System.out.println("Run All IEEE common format adapter Test cases");
		System.out.println("=============================================");
		junit.textui.TestRunner.run(Test_IEEECommonFormat.class);
		junit.textui.TestRunner.run(Test_IEEECommonFormat_Comma.class);
	}
}