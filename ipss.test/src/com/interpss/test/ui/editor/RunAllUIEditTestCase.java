package com.interpss.test.ui.editor;

import java.util.logging.Level;

import com.interpss.common.util.IpssLogger;
import com.interpss.test.ui.editor.branch.dist.TestDistBranchEditorCase;
import com.interpss.test.ui.editor.branch.dist.TestXfrBranchEditorCase;
import com.interpss.test.ui.editor.bus.TestBusBaseInfoEditorCase;
import com.interpss.test.ui.editor.bus.aclf.TestAclfAdjBusEditorCase;
import com.interpss.test.ui.editor.bus.aclf.TestAclfBusEditorCase;
import com.interpss.test.ui.editor.bus.acsc.TestAcscBusEditorCase;
import com.interpss.test.ui.editor.bus.dist.TestDistBusEditorCase;
import com.interpss.test.ui.editor.bus.dist.TestGeneratorBusEditorCase;
import com.interpss.test.ui.editor.bus.dist.TestIndMotorBusEditorCase;
import com.interpss.test.ui.editor.bus.dist.TestMixedLoadBusEditorCase;
import com.interpss.test.ui.editor.bus.dist.TestSynMotorBusEditorCase;
import com.interpss.test.ui.editor.bus.dist.TestUtilityBusEditorCase;
import com.interpss.test.ui.editor.bus.dstab.TestDStabBusEditorCase;
import com.interpss.test.ui.editor.proj.TestProjEditorAclfCase;
import com.interpss.test.ui.editor.proj.TestProjEditorAcscCase;
import com.interpss.test.ui.editor.proj.TestProjEditorCancelCase;
import com.interpss.test.ui.editor.proj.TestProjEditorDStabCase;
import com.interpss.test.ui.editor.proj.TestProjEditorDistCase;

import junit.framework.*;

public class RunAllUIEditTestCase extends TestCase {
	public static void main(String args[]) {
 		IpssLogger.getLogger().setLevel(Level.WARNING);		
		runAll();
	}
	
	public static void runAll() {
		System.out.println("Run All ui.edit.proj test cases");
		System.out.println("===============================");
		junit.textui.TestRunner.run(TestProjEditorCancelCase.class);
		junit.textui.TestRunner.run(TestProjEditorAclfCase.class);
		junit.textui.TestRunner.run(TestProjEditorAcscCase.class);
		junit.textui.TestRunner.run(TestProjEditorDStabCase.class);
		junit.textui.TestRunner.run(TestProjEditorDistCase.class);

		System.out.println("Run All ui.edit.bus test cases");
		System.out.println("==============================");
		junit.textui.TestRunner.run(TestBusBaseInfoEditorCase.class);
		junit.textui.TestRunner.run(TestAclfBusEditorCase.class);
		junit.textui.TestRunner.run(TestAclfAdjBusEditorCase.class);
		junit.textui.TestRunner.run(TestAcscBusEditorCase.class);
		junit.textui.TestRunner.run(TestDStabBusEditorCase.class);

		System.out.println("Run All ui.edit.bus.dist test cases");
		System.out.println("===================================");
		junit.textui.TestRunner.run(TestDistBusEditorCase.class);
		junit.textui.TestRunner.run(TestUtilityBusEditorCase.class);
		junit.textui.TestRunner.run(TestGeneratorBusEditorCase.class);
		junit.textui.TestRunner.run(TestSynMotorBusEditorCase.class);
		junit.textui.TestRunner.run(TestIndMotorBusEditorCase.class);
		junit.textui.TestRunner.run(TestMixedLoadBusEditorCase.class);
		junit.textui.TestRunner.run(TestDistBranchEditorCase.class);
		junit.textui.TestRunner.run(TestXfrBranchEditorCase.class);
/*
		System.out.println("Run All ui.edit.branch test cases");
		System.out.println("=================================");
		junit.textui.TestRunner.run(TestBranchBaseInfoEditorCase.class);
		junit.textui.TestRunner.run(TestAclfBranchEditorCase.class);
		junit.textui.TestRunner.run(TestAclfAdjBranchEditorCase.class);
		junit.textui.TestRunner.run(TestAcscBranchEditorCase.class);
		junit.textui.TestRunner.run(TestDStabBranchEditorCase.class);
*/		
	}
}