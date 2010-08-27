 /*
  * @(#)RunAllBranchEditTestCase.java   
  *
  * Copyright (C) 2006 www.interpss.org
  *
  * This program is free software; you can redistribute it and/or
  * modify it under the terms of the GNU LESSER GENERAL PUBLIC LICENSE
  * as published by the Free Software Foundation; either version 2.1
  * of the License, or (at your option) any later version.
  *
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  *
  * @Author Mike Zhou
  * @Version 1.0
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

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