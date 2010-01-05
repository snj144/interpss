 /*
  * @(#)TestDistBranchEditorCase.java   
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

package org.interpss.test.ui.editor.branch.dist;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import org.interpss.editor.SimuAppSpringAppCtxUtil;
import org.interpss.editor.data.dist.DistBranchData;
import org.interpss.editor.form.GBranchForm;
import org.interpss.editor.ui.edit.NBBranchEditDialog;
import org.interpss.test.ui.TestUIBase;
import org.interpss.test.ui.TestUI_UtilFunc;

import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.NamedComponentFinder;

import org.interpss.editor.jgraph.ui.form.IGBranchForm;

public class TestDistBranchEditorCase extends TestUIBase {
	public void testBreakerCase() {
		System.out.println("TestDistBranchEditorCase testBreakerCase begin");
			
		TestUI_UtilFunc.createTestingDistGNetForm(netContainer);
		
		GBranchForm form = (GBranchForm)netContainer.getGBranchForm("0001->0002");
		NBBranchEditDialog branchEditor = (NBBranchEditDialog)SimuAppSpringAppCtxUtil.getBranchDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");
		
		TestUI_UtilFunc.radioButtonClickAction(finder, branchEditor, "breakerRadioButton");

		JComboBox nameComboBox = TestUI_UtilFunc.findComboBox(finder, branchEditor, "nameComboBox");
		nameComboBox.setSelectedItem("My Breaker"); 

		TestUI_UtilFunc.setTextField(finder, branchEditor, "rTextField", "1.0");
		
		finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(netContainer.isDataDirty());
			
		DistBranchData data = form.getDistBranchData();
		assertTrue(data.getBranchCode().equals(IGBranchForm.DistBranchCode_Breaker));		
		assertTrue(form.getName().equals("My Breaker"));		
		assertTrue(data.getZR() == 1.0);		
		
		// launch the dialog again
		branchEditor.init(netContainer, form);
		finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		assertTrue(data.getBranchCode().equals(IGBranchForm.DistBranchCode_Breaker));		
		assertTrue(form.getName().equals("My Breaker"));		
		assertTrue(data.getZR() == 1.0);		

		System.out.println("TestDistBranchEditorCase testBreakerCase end");
	}

	public void testFeederCase() {
		System.out.println("TestDistBranchEditorCase testFeederCase begin");
			
		TestUI_UtilFunc.createTestingDistGNetForm(netContainer);
		
		GBranchForm form = (GBranchForm)netContainer.getGBranchForm("0001->0002");
		NBBranchEditDialog branchEditor = (NBBranchEditDialog)SimuAppSpringAppCtxUtil.getBranchDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");
		
		TestUI_UtilFunc.radioButtonClickAction(finder, branchEditor, "feederRadioButton");

		JComboBox nameComboBox = TestUI_UtilFunc.findComboBox(finder, branchEditor, "nameComboBox");
		nameComboBox.setSelectedItem("My Feeder"); 

		JComboBox lengthUnitComboBox = TestUI_UtilFunc.findComboBox(finder, branchEditor, "lengthUnitComboBox");
		lengthUnitComboBox.setSelectedIndex(0);
		TestUI_UtilFunc.checkComboBoxSelection(lengthUnitComboBox, "Ft"); // "Ft", "M"

		TestUI_UtilFunc.setTextField(finder, branchEditor, "lengthTextField",  "1.0");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "x_1000TextField",  "2.0");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "r_1000TextField",  "3.0");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "x0_x1TextField",   "1.0");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "r0_r1TextField",   "1.0");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "b1_1000TextField", "6.0");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "b0_b1TextField", "1.0");

		finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(netContainer.isDataDirty());
			
		DistBranchData data = form.getDistBranchData();
		assertTrue(data.getBranchCode().equals(IGBranchForm.DistBranchCode_Feeder));		
		assertTrue(form.getName().equals("My Feeder"));		
		assertTrue(data.getLengthUnit().equals("Ft"));		
		assertTrue(data.getLength() == 1.0);		
		assertTrue(data.getZX() == 2.0);		
		assertTrue(data.getZR() == 3.0);		
		assertTrue(data.getZ0X() == 2.0);		
		assertTrue(data.getZ0R() == 3.0);		
		assertTrue(data.getHalfShuntB() == 0.5*6.0);		
		assertTrue(data.getHalfShuntB0() == 0.5*6.0);		

		// launch the dialog again
		branchEditor.init(netContainer, form);
		finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		assertTrue(data.getBranchCode().equals(IGBranchForm.DistBranchCode_Feeder));		
		assertTrue(form.getName().equals("My Feeder"));		
		assertTrue(data.getLengthUnit().equals("Ft"));		
		assertTrue(data.getLength() == 1.0);		
		assertTrue(data.getZX() == 2.0);		
		assertTrue(data.getZR() == 3.0);		
		assertTrue(data.getZ0X() == 2.0);		
		assertTrue(data.getZ0R() == 3.0);		
		assertTrue(data.getHalfShuntB() == 0.5*6.0);		
		assertTrue(data.getHalfShuntB0() == 0.5*6.0);		

		// launch the dialog again
		branchEditor.init(netContainer, form);

	    lengthUnitComboBox = TestUI_UtilFunc.findComboBox(finder, branchEditor, "lengthUnitComboBox");
		lengthUnitComboBox.setSelectedIndex(1);
		TestUI_UtilFunc.checkComboBoxSelection(lengthUnitComboBox, "M"); // "Ft", "M"

		finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		assertTrue(data.getLengthUnit().equals("M"));		

		System.out.println("TestDistBranchEditorCase testFeederCase end");
	}

	public void testXfrCase() {
		System.out.println("TestDistBranchEditorCase testXfrCase begin");
			
		TestUI_UtilFunc.createTestingDistGNetForm(netContainer);
		
		GBranchForm form = (GBranchForm)netContainer.getGBranchForm("0001->0002");
		NBBranchEditDialog branchEditor = (NBBranchEditDialog)SimuAppSpringAppCtxUtil.getBranchDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");
		
		TestUI_UtilFunc.radioButtonClickAction(finder, branchEditor, "xfrRadioButton");

		JComboBox nameComboBox = TestUI_UtilFunc.findComboBox(finder, branchEditor, "xfrNameComboBox");
		nameComboBox.setSelectedItem("My Xfr"); 

		TestUI_UtilFunc.setTextField(finder, branchEditor, "xfrRatingTextField", "1.0");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "xTextField", "4.0");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "x0_x1TextField", "1.0");
		
		finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(netContainer.isDataDirty());
			
		DistBranchData data = form.getDistBranchData();
		assertTrue(data.getBranchCode().equals(IGBranchForm.DistBranchCode_Xfr));		
		assertTrue(form.getName().equals("My Xfr"));		

		// launch the dialog again
		branchEditor.init(netContainer, form);
		finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		assertTrue(data.getBranchCode().equals(IGBranchForm.DistBranchCode_Xfr));		
		assertTrue(form.getName().equals("My Xfr"));		

		System.out.println("TestDistBranchEditorCase testXfrCase end");
	}
}

