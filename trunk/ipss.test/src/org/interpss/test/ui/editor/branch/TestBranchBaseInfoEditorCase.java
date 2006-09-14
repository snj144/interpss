 /*
  * @(#)TestBranchBaseInfoEditorCase.java   
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

import javax.swing.JButton;
import javax.swing.JComponent;

import org.interpss.editor.SimuAppSpringAppCtxUtil;
import org.interpss.editor.form.GBranchForm;
import org.interpss.editor.ui.edit.NBBranchEditDialog;
import org.interpss.test.ui.TestUIBase;
import org.interpss.test.ui.TestUI_UtilFunc;


import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.*;

public class TestBranchBaseInfoEditorCase extends TestUIBase {
	public void testSimpleSaveCase() {
		System.out.println("TestAclfBusEditorCase testSimpleSaveCase begin");
		
		TestUI_UtilFunc.createTestingAclfGNetForm(netContainer);
		
		GBranchForm form = (GBranchForm)netContainer.getGBranchForm("0001->0002");
		NBBranchEditDialog branchEditor = (NBBranchEditDialog)SimuAppSpringAppCtxUtil.getBranchDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");

		TestUI_UtilFunc.setTextField(finder, branchEditor, "branchNameTextField", "Branch Name");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "areaTextField", "2");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "zoneTextField", "2");
		TestUI_UtilFunc.checkBoxAction(finder, branchEditor, "inServiceCheckBox", true);
		
		TestUI_UtilFunc.setTextField(finder, branchEditor, "xTextField", "0.1");

		finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(netContainer.isDataDirty());
	    
		assertTrue(form.getName().equals("Branch Name"));
		assertTrue(form.getArea() == 2);
		assertTrue(form.getZone() == 2);
		assertTrue(form.getStatus());
		
		// launch the dialog again
		branchEditor.init(netContainer, form);
		finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(netContainer.isDataDirty());

		assertTrue(form.getName().equals("Branch Name"));
		assertTrue(form.getArea() == 2);
		assertTrue(form.getZone() == 2);
		assertTrue(form.getStatus());
		
		System.out.println("TestAclfBusEditorCase testSimpleSaveCase end");
	}
}

