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

public class TestMixedLoadBusEditorCase extends TestBusEditorBase {
	public void testMixedLoadCase() {
		System.out.println("TestMixedLoadBusEditorCase testMixedLoadCase begin");
		
		TestUI_UtilFunc.createTestingDistGNetForm(netContainer);
		GBusForm form = (GBusForm)netContainer.getGBusForm("0001");
		NBBusEditDialog busEditor = (NBBusEditDialog)SimuAppSpringAppCtxUtil.getBusDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "" );

		TestUI_UtilFunc.radioButtonAction(finder, busEditor, "mixedLoadRadioButton");
		
		JComboBox pfUnitComboBox = TestUI_UtilFunc.findComboBox(finder, busEditor, "pfUnitComboBox");
		pfUnitComboBox.setSelectedIndex(0);
		TestUI_UtilFunc.checkComboBoxSelection(pfUnitComboBox, "PU"); // "PU", "%"

		JComboBox ratedKWUnitComboBox = TestUI_UtilFunc.findComboBox(finder, busEditor, "totalKVAUnitComboBox");
		ratedKWUnitComboBox.setSelectedIndex(0);
		TestUI_UtilFunc.checkComboBoxSelection(ratedKWUnitComboBox, "KVA"); // "KVA", "MVA"

		JComboBox ratedVUnitComboBox = TestUI_UtilFunc.findComboBox(finder, busEditor, "ratedVUnitComboBox");
		ratedVUnitComboBox.setSelectedIndex(0);
		TestUI_UtilFunc.checkComboBoxSelection(ratedVUnitComboBox, "PU"); // PU | Volt | KV

		TestUI_UtilFunc.setTextField(finder, busEditor, "totalKVATextField", "100.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "ratedVTextField", "1.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "pfTextField", "0.8");
		TestUI_UtilFunc.setTextField(finder, busEditor, "motorPercentTextField", "95.0");		
		
	    TestUI_UtilFunc.setZTable_XR_5Points(finder, busEditor, "zTable");

		TestUI_UtilFunc.setSolidGrounding(finder, busEditor);
		
	    // click the Save Button
	    finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
		
		DistBusData data = form.getDistBusData();
		assertTrue(data.getBusCode().equals(DistBusData.BusCode_MixedLoad));		
		assertTrue(data.getBusRating() == 100.0);		
		assertTrue(data.getRatedVolt() == 1.0);		
		assertTrue(data.getPFactor() == 0.8);		
		assertTrue(data.getMotorPercent() == 95.0);	
		assertTrue(data.getPFactorUnit().equals("PU"));
		assertTrue(data.getBusRatingUnit().equals("KVA"));
		assertTrue(data.getRatedVoltUnit().equals("PU"));		
		TestUI_UtilFunc.checkBusZ_XR_5Points(data);
		TestUI_UtilFunc.checkSolidGrounding(data);		
		
		// launch the editor again
		busEditor.init(netContainer, form);
	    finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		data = form.getDistBusData();
		assertTrue(data.getBusCode().equals(DistBusData.BusCode_MixedLoad));		

		assertTrue(data.getBusRating() == 100.0);		
		assertTrue(data.getRatedVolt() == 1.0);		
		assertTrue(data.getPFactor() == 0.8);		
		assertTrue(data.getMotorPercent() == 95.0);	
		assertTrue(data.getPFactorUnit().equals("PU"));
		assertTrue(data.getBusRatingUnit().equals("KVA"));
		assertTrue(data.getRatedVoltUnit().equals("PU"));		
		TestUI_UtilFunc.checkBusZ_XR_5Points(data);
		TestUI_UtilFunc.checkSolidGrounding(data);		

		System.out.println("TestMixedLoadBusEditorCase testMixedLoadCase end");
	}	
}

