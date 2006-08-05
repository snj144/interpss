package com.interpss.test.ui.editor.bus.dist;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.NamedComponentFinder;

import com.interpss.editor.data.dist.DistBusData;
import com.interpss.editor.form.GBusForm;
import com.interpss.editor.ui.SimuAppSpringAppCtxUtil;
import com.interpss.editor.ui.edit.NBBusEditDialog;
import com.interpss.test.ui.TestUI_UtilFunc;
import com.interpss.test.ui.editor.bus.TestBusEditorBase;

public class TestUtilityBusEditorCase extends TestBusEditorBase {

	public void testCase_1() {
		System.out.println("TestUtilityBusEditorCase testCase_1 begin");
		
		TestUI_UtilFunc.createTestingDistGNetForm(netContainer);
		GBusForm form = (GBusForm)netContainer.getGBusForm("0001");
		DistBusData data = form.getDistBusData();
		data.setBusCode(DistBusData.BusCode_Utility);
		
		NBBusEditDialog busEditor = (NBBusEditDialog)SimuAppSpringAppCtxUtil.getBusDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "" );

		JComboBox mvaUnitComboBox = TestUI_UtilFunc.findComboBox(finder, busEditor, "mvaUnitComboBox");
		mvaUnitComboBox.setSelectedIndex(0);
		TestUI_UtilFunc.checkComboBoxSelection(mvaUnitComboBox, "MVA"); // "MVA", "KVA", "KAmps", "Amps"
		
		JComboBox vUnitComboBox = TestUI_UtilFunc.findComboBox(finder, busEditor, "vUnitComboBox");
		vUnitComboBox.setSelectedIndex(0);
		TestUI_UtilFunc.checkComboBoxSelection(vUnitComboBox, "PU");  // "PU", "Volt", "KV"
		
		TestUI_UtilFunc.setTextField(finder, busEditor, "voltageTextField", "1000.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "angleTextField", "0.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "mva3PTextField", "100");
		TestUI_UtilFunc.setTextField(finder, busEditor, "x_r3PTextField", "20.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "mva1PTextField", "50.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "x_r1PTextField", "30.0");

		TestUI_UtilFunc.setSolidGrounding(finder, busEditor);
	    
	    // click the Save Button
	    finder.setName("saveButton");
	    JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
		
		assertTrue(data.getRatedVolt() == 1000.0);		
		assertTrue(data.getVAngle() == 0.0);		
		assertTrue(data.getMvaRating3P() == 100.0);		
		assertTrue(data.getX_r3P() == 20.0);		
		assertTrue(data.getMvaRating1P() == 50.0);		
		assertTrue(data.getX_r1P() == 30.0);		
		assertTrue(data.getRatedVoltUnit().equals("PU"));		
		assertTrue(data.getMvaRatingUnit().equals("MVA"));		
		TestUI_UtilFunc.checkSolidGrounding(data);

		// launch the editor again
		busEditor.init(netContainer, form);
	    finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		assertTrue(data.getRatedVolt() == 1000.0);		
		assertTrue(data.getVAngle() == 0.0);		
		assertTrue(data.getMvaRating3P() == 100.0);		
		assertTrue(data.getX_r3P() == 20.0);		
		assertTrue(data.getMvaRating1P() == 50.0);		
		assertTrue(data.getX_r1P() == 30.0);
		assertTrue(data.getRatedVoltUnit().equals("PU"));		
		assertTrue(data.getMvaRatingUnit().equals("MVA"));		
		TestUI_UtilFunc.checkSolidGrounding(data);

		// launch the editor again
		busEditor.init(netContainer, form);

		mvaUnitComboBox = TestUI_UtilFunc.findComboBox(finder, busEditor, "mvaUnitComboBox");
		mvaUnitComboBox.setSelectedIndex(1);
		TestUI_UtilFunc.checkComboBoxSelection(mvaUnitComboBox, "KVA"); // "MVA", "KVA", "KAmps", "Amps"
		
		vUnitComboBox = TestUI_UtilFunc.findComboBox(finder, busEditor, "vUnitComboBox");
		vUnitComboBox.setSelectedIndex(1);
		TestUI_UtilFunc.checkComboBoxSelection(vUnitComboBox, "Volt");  // "PU", "Volt", "KV"

		TestUI_UtilFunc.setUnGrounding(finder, busEditor);
	    
		finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		assertTrue(data.getRatedVoltUnit().equals("Volt"));		
		assertTrue(data.getMvaRatingUnit().equals("KVA"));		
		TestUI_UtilFunc.checkUnGrounding(data);
	    
		// launch the editor again
		busEditor.init(netContainer, form);

		mvaUnitComboBox = TestUI_UtilFunc.findComboBox(finder, busEditor, "mvaUnitComboBox");
		mvaUnitComboBox.setSelectedIndex(2);
		TestUI_UtilFunc.checkComboBoxSelection(mvaUnitComboBox, "KAmps"); // "MVA", "KVA", "KAmps", "Amps"
		
		vUnitComboBox = TestUI_UtilFunc.findComboBox(finder, busEditor, "vUnitComboBox");
		vUnitComboBox.setSelectedIndex(2);
		TestUI_UtilFunc.checkComboBoxSelection(vUnitComboBox, "KV");  // "PU", "Volt", "KV"

		TestUI_UtilFunc.setZGrounding(finder, busEditor);
	    
		finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		assertTrue(data.getRatedVoltUnit().equals("KV"));		
		assertTrue(data.getMvaRatingUnit().equals("KAmps"));
		TestUI_UtilFunc.checkZGrounding(data);
		
		// launch the editor again
		busEditor.init(netContainer, form);

		mvaUnitComboBox = TestUI_UtilFunc.findComboBox(finder, busEditor, "mvaUnitComboBox");
		mvaUnitComboBox.setSelectedIndex(3);
		TestUI_UtilFunc.checkComboBoxSelection(mvaUnitComboBox, "Amps"); // "MVA", "KVA", "KAmps", "Amps"
		
		finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		assertTrue(data.getMvaRatingUnit().equals("Amps"));

		System.out.println("TestUtilityBusEditorCase testCase_1 end");
	}
}

