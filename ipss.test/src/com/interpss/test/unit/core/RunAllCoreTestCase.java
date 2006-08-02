package com.interpss.test.unit.core;

import java.util.logging.Level;

import com.interpss.common.util.IpssLogger;
import com.interpss.test.unit.core.net.AreaImplTest;
import com.interpss.test.unit.core.net.BranchImplTest;
import com.interpss.test.unit.core.net.BusImplTest;
import com.interpss.test.unit.core.net.NetRuleTest;
import com.interpss.test.unit.core.net.NetworkImplTest;
import com.interpss.test.unit.core.sample.TestSample;
import com.interpss.test.unit.core.sparse.SparseEqnComplexTest;
import com.interpss.test.unit.core.sparse.SparseEqnDoubleTest;
import com.interpss.test.unit.core.sparse.SparseEqnIntegerTest;
import com.interpss.test.unit.core.sparse.SparseEqnMatrix2x2Test;

public class RunAllCoreTestCase {
	public static void main(String args[]) {
		IpssLogger.getLogger().setLevel(Level.WARNING);
		
		System.out.println("Begin RunAllCoreSparseTestCase ...");

		runAll();

		System.out.println("End RunAllCoreSparseTestCase ...");
		System.exit(0);
	}
	
	public static void runAll() {
		System.out.println("Run All core.sparse JUnit test cases");
		System.out.println("====================================");
		junit.textui.TestRunner.run(SparseEqnIntegerTest.class);
		junit.textui.TestRunner.run(SparseEqnDoubleTest.class);
		junit.textui.TestRunner.run(SparseEqnComplexTest.class);
		junit.textui.TestRunner.run(SparseEqnMatrix2x2Test.class);

		System.out.println("Run All core.sample JUnit test cases");
		System.out.println("====================================");
		junit.textui.TestRunner.run(TestSample.class);
		
		System.out.println("Run All core.net JUnit test cases");
		System.out.println("=================================");
		junit.textui.TestRunner.run(AreaImplTest.class);
		junit.textui.TestRunner.run(BranchImplTest.class);
		junit.textui.TestRunner.run(BusImplTest.class);
		junit.textui.TestRunner.run(NetRuleTest.class);	
		junit.textui.TestRunner.run(NetworkImplTest.class);	
	}
}