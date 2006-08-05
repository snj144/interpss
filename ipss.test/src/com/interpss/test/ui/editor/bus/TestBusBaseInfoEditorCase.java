package com.interpss.test.ui.editor.bus;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import com.interpss.editor.form.GBusForm;
import com.interpss.editor.ui.SimuAppSpringAppCtxUtil;
import com.interpss.editor.ui.edit.NBBusEditDialog;
import com.interpss.test.ui.TestUI_UtilFunc;

import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.*;

public class TestBusBaseInfoEditorCase extends TestBusEditorBase {
	public void testSimpleSaveCase() {
		System.out.println("TestAclfBusEditorCase testSimpleSaveCase begin");
		
		TestUI_UtilFunc.createTestingAclfGNetForm(netContainer);
		GBusForm form = (GBusForm)netContainer.getGBusForm("0001");
		NBBusEditDialog busEditor = (NBBusEditDialog)SimuAppSpringAppCtxUtil.getBusDataEditor(
				netContainer, form, false);
		
	    // click the Save Button
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "saveButton" );
		JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
	    
		System.out.println("TestAclfBusEditorCase testSimpleSaveCase end");
	}

	public void testBusBaseInfoCase() {
		System.out.println("TestAclfBusEditorCase testBusBaseInfoCase begin");
		
		TestUI_UtilFunc.createTestingAclfGNetForm(netContainer);
		GBusForm form = (GBusForm)netContainer.getGBusForm("0001");
		NBBusEditDialog busEditor = (NBBusEditDialog)SimuAppSpringAppCtxUtil.getBusDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "" );

		TestUI_UtilFunc.setTextField(finder, busEditor, "busNameTextField", "Bus Name");
		
		JComboBox baseVoltComboBox = TestUI_UtilFunc.findComboBox(finder, busEditor, "baseVoltComboBox");
		baseVoltComboBox.setSelectedItem("2000.0");
		
		JComboBox baseUnitComboBox = TestUI_UtilFunc.findComboBox(finder, busEditor, "baseUnitComboBox");
		baseUnitComboBox.setSelectedIndex(0);  // Volt selected
		
		TestUI_UtilFunc.setTextField(finder, busEditor, "areaTextField", "2");
		TestUI_UtilFunc.setTextField(finder, busEditor, "zoneTextField", "2");
		TestUI_UtilFunc.checkBoxAction(finder, busEditor, "inServiceCheckBox", true);
	    
	    // click the Save Button
	    finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
	    
		assertTrue(form.getName().equals("Bus Name"));
		assertTrue(form.getBaseVoltage() == 2000.0);
		assertTrue(form.getBaseVoltUnit().equals("Volt"));
		assertTrue(form.getArea() == 2);
		assertTrue(form.getZone() == 2);
		assertTrue(form.getStatus());

		// launch editor again
		busEditor.init(netContainer, form);
		
	    // click the Save Button
	    finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );		
		
		assertTrue(form.getName().equals("Bus Name"));
		assertTrue(form.getBaseVoltage() == 2000.0);
		assertTrue(form.getBaseVoltUnit().equals("Volt"));
		assertTrue(form.getArea() == 2);
		assertTrue(form.getZone() == 2);
		assertTrue(form.getStatus());

		// launch editor again
		busEditor.init(netContainer, form);
		
		finder.setName("baseUnitComboBox");
		baseUnitComboBox = ( JComboBox ) finder.find( busEditor, 0);
		baseUnitComboBox.setSelectedIndex(1);  // KV selected
		
		TestUI_UtilFunc.checkBoxAction(finder, busEditor, "inServiceCheckBox", false);

	    // click the Save Button
	    finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
	    
		assertTrue(form.getBaseVoltUnit().equals("KV"));
		assertTrue(!form.getStatus());

		System.out.println("TestAclfBusEditorCase testBusBaseInfoCase end");
	}
}

