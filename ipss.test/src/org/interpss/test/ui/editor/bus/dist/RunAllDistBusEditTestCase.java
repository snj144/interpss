 /*
  * @(#)RunAllDistBusEditTestCase.java   
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

package org.interpss.test.ui.editor.bus.dist;

import java.util.logging.Level;

import junit.framework.TestCase;

import com.interpss.common.util.IpssLogger;

public class RunAllDistBusEditTestCase extends TestCase {
	public static void main(String args[]) {
 		IpssLogger.getLogger().setLevel(Level.WARNING);		
		runAll();
	}
	
	public static void runAll() {
		System.out.println("Run All ui.edit.bus.dist test cases");
		System.out.println("===================================");
		junit.textui.TestRunner.run(TestDistBusEditorCase.class);
		junit.textui.TestRunner.run(TestUtilityBusEditorCase.class);
		junit.textui.TestRunner.run(TestGeneratorBusEditorCase.class);
		junit.textui.TestRunner.run(TestSynMotorBusEditorCase.class);
		junit.textui.TestRunner.run(TestIndMotorBusEditorCase.class);
		junit.textui.TestRunner.run(TestMixedLoadBusEditorCase.class);
	}
}