package com.interpss.test.ui.editor.bus.dist;

import javax.swing.JButton;
import javax.swing.JComponent;

import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.NamedComponentFinder;

import com.interpss.editor.data.dist.DistBusData;
import com.interpss.editor.form.GBusForm;
import com.interpss.editor.ui.SimuAppSpringAppCtxUtil;
import com.interpss.editor.ui.edit.NBBusEditDialog;
import com.interpss.test.ui.TestUI_UtilFunc;
import com.interpss.test.ui.editor.bus.TestBusEditorBase;

public class TestDistBusEditorCase extends TestBusEditorBase {
	public void testNonContributeCase() {
		System.out.println("TestDistBusEditorCase testNonContributeCase begin");
		
		TestUI_UtilFunc.createTestingDistGNetForm(netContainer);
		GBusForm form = (GBusForm)netContainer.getGBusForm("0001");
		NBBusEditDialog busEditor = (NBBusEditDialog)SimuAppSpringAppCtxUtil.getBusDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "" );

		TestUI_UtilFunc.radioButtonAction(finder, busEditor, "nonContributeRadioButton");

	    // click the Save Button
	    finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
		
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

		TestUI_UtilFunc.radioButtonAction(finder, busEditor, "utilityRadioButton");

	    // click the Save Button
	    finder.setName("saveButton");
	    JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
		
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

		TestUI_UtilFunc.radioButtonAction(finder, busEditor, "generatorRadioButton");

	    // click the Save Button
	    finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
		
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

		TestUI_UtilFunc.radioButtonAction(finder, busEditor, "synMotorRadioButton");

	    // click the Save Button
	    finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
		
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

		TestUI_UtilFunc.radioButtonAction(finder, busEditor, "indMotorRadioButton");

	    // click the Save Button
	    finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
		
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

		TestUI_UtilFunc.radioButtonAction(finder, busEditor, "mixedLoadRadioButton");

	    // click the Save Button
	    finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
		
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

