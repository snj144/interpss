package org.interpss.test.simu.core;

import java.util.logging.Level;

import org.interpss.test.simu.core.net.AreaImplTest;
import org.interpss.test.simu.core.net.BranchImplTest;
import org.interpss.test.simu.core.net.BusImplTest;
import org.interpss.test.simu.core.net.NetRuleTest;
import org.interpss.test.simu.core.net.NetworkImplTest;
import org.interpss.test.simu.core.sample.TestSample;
import org.interpss.test.simu.core.sparse.SparseEqnComplexTest;
import org.interpss.test.simu.core.sparse.SparseEqnDoubleTest;
import org.interpss.test.simu.core.sparse.SparseEqnIntegerTest;
import org.interpss.test.simu.core.sparse.SparseEqnMatrix2x2Test;

import com.interpss.common.util.IpssLogger;

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