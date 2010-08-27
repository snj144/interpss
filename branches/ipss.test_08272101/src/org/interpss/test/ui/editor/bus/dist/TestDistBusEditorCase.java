 /*
  * @(#)TestDistBusEditorCase.java   
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

import javax.swing.JButton;
import javax.swing.JComponent;

import org.interpss.editor.SimuAppSpringAppCtxUtil;
import org.interpss.editor.data.dist.DistBusData;
import org.interpss.editor.form.GBusForm;
import org.interpss.editor.ui.edit.NBBusEditDialog;
import org.interpss.test.ui.TestUIBase;
import org.interpss.test.ui.TestUI_UtilFunc;

import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.NamedComponentFinder;


public class TestDistBusEditorCase extends TestUIBase {
	public void testNonContributeCase() {
		System.out.println("TestDistBusEditorCase testNonContributeCase begin");
		
		TestUI_UtilFunc.createTestingDistGNetForm(netContainer);
		GBusForm form = (GBusForm)netContainer.getGBusForm("0001");
		NBBusEditDialog busEditor = (NBBusEditDialog)SimuAppSpringAppCtxUtil.getBusDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "" );

		TestUI_UtilFunc.radioButtonClickAction(finder, busEditor, "nonContributeRadioButton");

	    // click the Save Button
	    finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(netContainer.isDataDirty());
		
		DistBusData data = form.getDistBusData();
		assertTrue(data.getBusCode().equals(DistBusData.BusCode_NonContribute));		
		
		System.out.println("TestDistBusEditorCase testNonContributeCase end");
	}

	public void testUtilityCase() {
		System.out.println("TestDistBusEditorCase testUtilityCase begin");
		
		TestUI_UtilFunc.createTestingDistGNetForm(netContainer);
		GBusForm form = (GBusForm)netContainer.getGBusForm("0001");
		NBBusEditDialog busEditor = (NBBusEditDialog)SimuAppSpringAppCtxUtil.getBusDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "" );

		TestUI_UtilFunc.radioButtonClickAction(finder, busEditor, "utilityRadioButton");
		TestUI_UtilFunc.setTextField(finder, busEditor, "voltageTextField", "1000.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "angleTextField", "0.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "mva3PTextField", "100");
		TestUI_UtilFunc.setTextField(finder, busEditor, "x_r3PTextField", "20.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "mva1PTextField", "50.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "x_r1PTextField", "30.0");

	    // click the Save Button
	    finder.setName("saveButton");
	    JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(netContainer.isDataDirty());
		
		DistBusData data = form.getDistBusData();
		assertTrue(data.getBusCode().equals(DistBusData.BusCode_Utility));		

		// launch the editor again
		busEditor.init(netContainer, form);
	    finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		data = form.getDistBusData();
		assertTrue(data.getBusCode().equals(DistBusData.BusCode_Utility));		

		System.out.println("TestDistBusEditorCase testUtilityCase end");
	}

	public void testGeneratorCase() {
		System.out.println("TestDistBusEditorCase testGeneratorCase begin");
		
		TestUI_UtilFunc.createTestingDistGNetForm(netContainer);
		GBusForm form = (GBusForm)netContainer.getGBusForm("0001");
		NBBusEditDialog busEditor = (NBBusEditDialog)SimuAppSpringAppCtxUtil.getBusDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "" );

		TestUI_UtilFunc.radioButtonClickAction(finder, busEditor, "generatorRadioButton");
		TestUI_UtilFunc.setTextField(finder, busEditor, "ratedKWTextField", "100.0");
	    TestUI_UtilFunc.setZTable_XR_3Points(finder, busEditor, "zTable");

	    // click the Save Button
	    finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(netContainer.isDataDirty());
		
		DistBusData data = form.getDistBusData();
		assertTrue(data.getBusCode().equals(DistBusData.BusCode_Generator));		
		
		// launch the editor again
		busEditor.init(netContainer, form);
	    finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		data = form.getDistBusData();
		assertTrue(data.getBusCode().equals(DistBusData.BusCode_Generator));		

		System.out.println("TestDistBusEditorCase testGeneratorCase end");
	}

	public void testSynMotorCase() {
		System.out.println("TestDistBusEditorCase testSynMotorCase begin");
		
		TestUI_UtilFunc.createTestingDistGNetForm(netContainer);
		GBusForm form = (GBusForm)netContainer.getGBusForm("0001");
		NBBusEditDialog busEditor = (NBBusEditDialog)SimuAppSpringAppCtxUtil.getBusDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "" );

		TestUI_UtilFunc.radioButtonClickAction(finder, busEditor, "synMotorRadioButton");
		TestUI_UtilFunc.setTextField(finder, busEditor, "ratedHPTextField", "100.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "effTextField", "95.0");		
	    TestUI_UtilFunc.setZTable_XR_3Points(finder, busEditor, "zTable");

	    // click the Save Button
	    finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(netContainer.isDataDirty());
		
		DistBusData data = form.getDistBusData();
		assertTrue(data.getBusCode().equals(DistBusData.BusCode_SynMotor));		
		
		// launch the editor again
		busEditor.init(netContainer, form);
	    finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		data = form.getDistBusData();
		assertTrue(data.getBusCode().equals(DistBusData.BusCode_SynMotor));		

		System.out.println("TestDistBusEditorCase testSynMotorCase end");
	}
	
	public void testIndMotorCase() {
		System.out.println("TestDistBusEditorCase testIndMotorCase begin");
		
		TestUI_UtilFunc.createTestingDistGNetForm(netContainer);
		GBusForm form = (GBusForm)netContainer.getGBusForm("0001");
		NBBusEditDialog busEditor = (NBBusEditDialog)SimuAppSpringAppCtxUtil.getBusDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "" );

		TestUI_UtilFunc.radioButtonClickAction(finder, busEditor, "indMotorRadioButton");
		TestUI_UtilFunc.setTextField(finder, busEditor, "ratedHPTextField", "100.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "effTextField", "95.0");		
	    TestUI_UtilFunc.setZTable_XR_3Points(finder, busEditor, "zTable");

	    // click the Save Button
	    finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(netContainer.isDataDirty());
		
		DistBusData data = form.getDistBusData();
		assertTrue(data.getBusCode().equals(DistBusData.BusCode_IndMotor));		
		
		// launch the editor again
		busEditor.init(netContainer, form);
	    finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		data = form.getDistBusData();
		assertTrue(data.getBusCode().equals(DistBusData.BusCode_IndMotor));		

		System.out.println("TestDistBusEditorCase testIndMotorCase end");
	}
	
	public void testMixedLoadCase() {
		System.out.println("TestDistBusEditorCase testMixedLoadCase begin");
		
		TestUI_UtilFunc.createTestingDistGNetForm(netContainer);
		GBusForm form = (GBusForm)netContainer.getGBusForm("0001");
		NBBusEditDialog busEditor = (NBBusEditDialog)SimuAppSpringAppCtxUtil.getBusDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "" );

		TestUI_UtilFunc.radioButtonClickAction(finder, busEditor, "mixedLoadRadioButton");
		TestUI_UtilFunc.setTextField(finder, busEditor, "totalKVATextField", "100.0");
	    TestUI_UtilFunc.setZTable_XR_3Points(finder, busEditor, "zTable");

	    // click the Save Button
	    finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(netContainer.isDataDirty());
		
		DistBusData data = form.getDistBusData();
		assertTrue(data.getBusCode().equals(DistBusData.BusCode_MixedLoad));		
		
		// launch the editor again
		busEditor.init(netContainer, form);
	    finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		data = form.getDistBusData();
		assertTrue(data.getBusCode().equals(DistBusData.BusCode_MixedLoad));		

		System.out.println("TestDistBusEditorCase testMixedLoadCase end");
	}	
}

