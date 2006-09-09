package org.interpss.test.ui.editor.branch;

import java.util.logging.Level;

import junit.framework.TestCase;

import org.interpss.test.ui.editor.branch.aclf.TestAclfAdjBranchEditorCase;
import org.interpss.test.ui.editor.branch.aclf.TestAclfBranchEditorCase;
import org.interpss.test.ui.editor.branch.acsc.TestAcscBranchEditorCase;
import org.interpss.test.ui.editor.branch.dist.TestDistBranchEditorCase;
import org.interpss.test.ui.editor.branch.dist.TestXfrBranchEditorCase;
import org.interpss.test.ui.editor.branch.dstab.TestDStabBranchEditorCase;

import com.interpss.common.util.IpssLogger;

public class RunAllBranchEditTestCase extends TestCase {
	public static void main(String args[]) {
 		IpssLogger.getLogger().setLevel(Level.WARNING);		
		runAll();
	}
	
	public static void runAll() {
		System.out.println("Run All ui.edit.branch test cases");
		System.out.println("=================================");
		junit.textui.TestRunner.run(TestBranchBaseInfoEditorCase.class);
		junit.textui.TestRunner.run(TestAclfBranchEditorCase.class);
		junit.textui.TestRunner.run(TestAclfAdjBranchEditorCase.class);
		junit.textui.TestRunner.run(TestAcscBranchEditorCase.class);
		junit.textui.TestRunner.run(TestDStabBranchEditorCase.class);

		System.out.println("Run All ui.edit.bus.dist test cases");
		System.out.println("===================================");
		junit.textui.TestRunner.run(TestDistBranchEditorCase.class);
		junit.textui.TestRunner.run(TestXfrBranchEditorCase.class);

	}
}