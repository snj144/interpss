package org.interpss.test.ui.editor.proj;

import java.util.logging.Level;

import junit.framework.TestCase;

import com.interpss.common.util.IpssLogger;

public class RunAlProjIEditTestCase extends TestCase {
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
	}
}