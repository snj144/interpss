package org.interpss.test.ui.editor.bus.dist;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import org.interpss.editor.SimuAppSpringAppCtxUtil;
import org.interpss.editor.data.dist.DistBusData;
import org.interpss.editor.form.GBusForm;
import org.interpss.editor.ui.edit.NBBusEditDialog;
import org.interpss.test.ui.TestUIBase;
import org.interpss.test.ui.TestUI_UtilFunc;

import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.NamedComponentFinder;


public class TestSynMotorBusEditorCase extends TestUIBase {
	public void testSynMotorCase() {
		System.out.println("TestSynMotorBusEditorCase testSynMotorCase begin");
		
		TestUI_UtilFunc.createTestingDistGNetForm(netContainer);
		GBusForm form = (GBusForm)netContainer.getGBusForm("0001");
		NBBusEditDialog busEditor = (NBBusEditDialog)SimuAppSpringAppCtxUtil.getBusDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "" );

		TestUI_UtilFunc.radioButtonClickAction(finder, busEditor, "synMotorRadioButton");

		JComboBox pfUnitComboBox = TestUI_UtilFunc.findComboBox(finder, busEditor, "pfUnitComboBox");
		pfUnitComboBox.setSelectedIndex(0);
		TestUI_UtilFunc.checkComboBoxSelection(pfUnitComboBox, "PU"); // "PU", "%"

		JComboBox ratedKWUnitComboBox = TestUI_UtilFunc.findComboBox(finder, busEditor, "ratedHPUnitComboBox");
		ratedKWUnitComboBox.setSelectedIndex(0);
		TestUI_UtilFunc.checkComboBoxSelection(ratedKWUnitComboBox, "HP"); // "HP", "KW"

		JComboBox ratedVUnitComboBox = TestUI_UtilFunc.findComboBox(finder, busEditor, "ratedVUnitComboBox");
		ratedVUnitComboBox.setSelectedIndex(0);
		TestUI_UtilFunc.checkComboBoxSelection(ratedVUnitComboBox, "PU"); // PU | Volt | KV

		TestUI_UtilFunc.setTextField(finder, busEditor, "ratedHPTextField", "100.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "ratedVTextField", "1.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "pfTextField", "0.8");
		TestUI_UtilFunc.setTextField(finder, busEditor, "effTextField", "95.0");		
		TestUI_UtilFunc.setTextField(finder, busEditor, "loadingTextField", "90.0");		
		
	    TestUI_UtilFunc.setZTable_XR_3Points(finder, busEditor, "zTable");

		TestUI_UtilFunc.setSolidGrounding(finder, busEditor);
		
	    // click the Save Button
	    finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(netContainer.isDataDirty());
		
		DistBusData data = form.getDistBusData();
		assertTrue(data.getBusCode().equals(DistBusData.BusCode_SynMotor));	
		assertTrue(data.getBusRating() == 100.0);		
		assertTrue(data.getRatedVolt() == 1.0);		
		assertTrue(data.getPFactor() == 0.8);		
		assertTrue(data.getEff() == 95.0);	
		assertTrue(data.getLoading() == 90.0);	
		assertTrue(data.getPFactorUnit().equals("PU"));
		assertTrue(data.getBusRatingUnit().equals("HP"));
		assertTrue(data.getRatedVoltUnit().equals("PU"));		
		TestUI_UtilFunc.checkBusZ_XR_3Points(data);
		TestUI_UtilFunc.checkSolidGrounding(data);		
		
		// launch the editor again
		busEditor.init(netContainer, form);
	    finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		data = form.getDistBusData();
		assertTrue(data.getBusCode().equals(DistBusData.BusCode_SynMotor));		
		assertTrue(data.getBusRating() == 100.0);		
		assertTrue(data.getRatedVolt() == 1.0);		
		assertTrue(data.getPFactor() == 0.8);		
		assertTrue(data.getEff() == 95.0);	
		assertTrue(data.getLoading() == 90.0);	
		assertTrue(data.getPFactorUnit().equals("PU"));
		assertTrue(data.getBusRatingUnit().equals("HP"));
		assertTrue(data.getRatedVoltUnit().equals("PU"));		
		TestUI_UtilFunc.checkBusZ_XR_3Points(data);
		TestUI_UtilFunc.checkSolidGrounding(data);	
		TestUI_UtilFunc.checkBusZ_XR_3Points(data);
		TestUI_UtilFunc.checkSolidGrounding(data);
		
		System.out.println("TestSynMotorBusEditorCase testSynMotorCase end");
	}
}

