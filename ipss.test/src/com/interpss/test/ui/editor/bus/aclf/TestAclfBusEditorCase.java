package com.interpss.test.ui.editor.bus.aclf;

import javax.swing.JButton;
import javax.swing.JComponent;

import com.interpss.editor.data.aclf.AclfBusData;
import com.interpss.editor.data.acsc.AcscBusData;
import com.interpss.editor.form.GBusForm;
import com.interpss.editor.ui.SimuAppSpringAppCtxUtil;
import com.interpss.editor.ui.edit.NBBusEditDialog;
import com.interpss.test.ui.TestUI_UtilFunc;
import com.interpss.test.ui.editor.bus.TestBusEditorBase;

import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.*;

public class TestAclfBusEditorCase extends TestBusEditorBase {
	public void testSimpleSaveCase() {
		System.out.println("TestAclfBusEditorCase testSimpleSaveCase begin");
		
		TestUI_UtilFunc.createTestingAclfGNetForm(netContainer);
		GBusForm form = (GBusForm)netContainer.getGBusForm("0001");
		NBBusEditDialog busEditor = (NBBusEditDialog)SimuAppSpringAppCtxUtil.getBusDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "" );

	    TestUI_UtilFunc.radioButtonStatus(finder, busEditor, "pqRadioButton", true);
	    TestUI_UtilFunc.radioButtonStatus(finder, busEditor, "pvRadioButton", true);
	    TestUI_UtilFunc.radioButtonStatus(finder, busEditor, "swingRadioButton", true);
	    TestUI_UtilFunc.radioButtonStatus(finder, busEditor, "remoteQRadioButton", false);
	    TestUI_UtilFunc.radioButtonStatus(finder, busEditor, "capRadioButton", true);
	    TestUI_UtilFunc.radioButtonStatus(finder, busEditor, "nonGenRadioButton", true);

	    TestUI_UtilFunc.radioButtonStatus(finder, busEditor, "constPRadioButton", true);
	    TestUI_UtilFunc.radioButtonStatus(finder, busEditor, "constIRadioButton", true);
	    TestUI_UtilFunc.radioButtonStatus(finder, busEditor, "constZRadioButton", true);
	    TestUI_UtilFunc.radioButtonStatus(finder, busEditor, "funcLoadRadioButton", false);
	    TestUI_UtilFunc.radioButtonStatus(finder, busEditor, "nonLoadRadioButton", true);

	    // click the Save Button
	    finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
	    
		System.out.println("TestAclfBusEditorCase testSimpleSaveCase end");
	}

	public void testGenCase() {
		System.out.println("TestAclfBusEditorCase testGenCase begin");
		
		TestUI_UtilFunc.createTestingAclfGNetForm(netContainer);
		GBusForm form = (GBusForm)netContainer.getGBusForm("0001");
		NBBusEditDialog busEditor = (NBBusEditDialog)SimuAppSpringAppCtxUtil.getBusDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "" );

	    TestUI_UtilFunc.radioButtonAction(finder, busEditor, "swingRadioButton");
		TestUI_UtilFunc.setTextField(finder, busEditor, "pGenTextField", "1.05");
		TestUI_UtilFunc.setTextField(finder, busEditor, "qGenTextField", "0.0");
	    TestUI_UtilFunc.checkBoxStatus(finder, busEditor, "adjustCheckBox", false);

	    // click the Save Button
	    finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
	    
		AcscBusData data = form.getAcscBusData();
		assertTrue(data.getGenCode().equals(AclfBusData.GenCode_Swing));
		assertTrue(data.getVoltageMag() == 1.05);
		assertTrue(data.getVoltageAng() == 0.0);

		// launch the editor again for PV bus
		busEditor.init(netContainer, form);
		
	    TestUI_UtilFunc.radioButtonAction(finder, busEditor, "pvRadioButton");
		TestUI_UtilFunc.setTextField(finder, busEditor, "pGenTextField", "2.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "qGenTextField", "1.05");
	    TestUI_UtilFunc.checkBoxStatus(finder, busEditor, "adjustCheckBox", false);
		
	    // click the Save Button
	    finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
	    
		data = form.getAcscBusData();
		assertTrue(data.getGenCode().equals(AclfBusData.GenCode_PV));
		assertTrue(data.getGenP() == 2.0);
		assertTrue(data.getVoltageMag() == 1.05);

		// launch the editor again for PQ bus
		busEditor.init(netContainer, form);
		
	    TestUI_UtilFunc.radioButtonAction(finder, busEditor, "pqRadioButton");
		TestUI_UtilFunc.setTextField(finder, busEditor, "pGenTextField", "2.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "qGenTextField", "1.0");
	    TestUI_UtilFunc.checkBoxStatus(finder, busEditor, "adjustCheckBox", false);
		
	    // click the Save Button
	    finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
	    
		data = form.getAcscBusData();
		assertTrue(data.getGenCode().equals(AclfBusData.GenCode_PQ));
		assertTrue(data.getGenP() == 2.0);
		assertTrue(data.getGenQ() == 1.0);

		// launch the editor again for Capacitor bus
		busEditor.init(netContainer, form);
		
	    TestUI_UtilFunc.radioButtonAction(finder, busEditor, "capRadioButton");
		TestUI_UtilFunc.setTextField(finder, busEditor, "pGenTextField", "1.0");
		TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "qGenTextField", false);
	    TestUI_UtilFunc.checkBoxStatus(finder, busEditor, "adjustCheckBox", false);
		
	    // click the Save Button
	    finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
	    
		data = form.getAcscBusData();
		assertTrue(data.getGenCode().equals(AclfBusData.GenCode_Capacitor));
		assertTrue(data.getCapQ() == 1.0);
		
		// launch the editor again for NonGen bus
		busEditor.init(netContainer, form);
		
	    TestUI_UtilFunc.radioButtonAction(finder, busEditor, "nonGenRadioButton");
		TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "pGenTextField", false);
		TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "qGenTextField", false);
	    TestUI_UtilFunc.checkBoxStatus(finder, busEditor, "adjustCheckBox", false);
		
	    // click the Save Button
	    finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
	    
		data = form.getAcscBusData();
		assertTrue(data.getGenCode().equals(AclfBusData.GenCode_NonGen));

		System.out.println("TestAclfBusEditorCase testGenCase end");
	}
	
	public void testLoadCase() {
		System.out.println("TestAclfBusEditorCase testLoadCase begin");
		
		TestUI_UtilFunc.createTestingAclfGNetForm(netContainer);
		GBusForm form = (GBusForm)netContainer.getGBusForm("0001");
		NBBusEditDialog busEditor = (NBBusEditDialog)SimuAppSpringAppCtxUtil.getBusDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "" );

	    TestUI_UtilFunc.radioButtonAction(finder, busEditor, "constPRadioButton");
		TestUI_UtilFunc.setTextField(finder, busEditor, "pLoadTextField", "2.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "qLoadTextField", "1.0");
		TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "constI_PTextField", false);
		TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "constP_QTextField", false);
		TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "constP_PTextField", false);
		TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "constI_QTextField", false);
		TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "constZ_PTextField", false);
		TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "constZ_QTextField", false);

		// click the Save Button
	    finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
	    
		AcscBusData data = form.getAcscBusData();
		assertTrue(data.getLoadCode().equals(AclfBusData.LoadCode_ConstP));
		assertTrue(data.getLoadP() == 2.0);
		assertTrue(data.getLoadQ() == 1.0);

		// launch editor again for Const_I load
		busEditor.init(netContainer, form);
		
	    TestUI_UtilFunc.radioButtonAction(finder, busEditor, "constIRadioButton");
		TestUI_UtilFunc.setTextField(finder, busEditor, "pLoadTextField", "2.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "qLoadTextField", "1.0");
		TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "constI_PTextField", false);
		TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "constP_QTextField", false);
		TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "constP_PTextField", false);
		TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "constI_QTextField", false);
		TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "constZ_PTextField", false);
		TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "constZ_QTextField", false);

		// click the Save Button
	    finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
	    
		data = form.getAcscBusData();
		assertTrue(data.getLoadCode().equals(AclfBusData.LoadCode_ConstI));
		assertTrue(data.getLoadP() == 2.0);
		assertTrue(data.getLoadQ() == 1.0);

		// launch editor again for Const_Z load
		busEditor.init(netContainer, form);
		
	    TestUI_UtilFunc.radioButtonAction(finder, busEditor, "constZRadioButton");
		TestUI_UtilFunc.setTextField(finder, busEditor, "pLoadTextField", "2.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "qLoadTextField", "1.0");
		TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "constI_PTextField", false);
		TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "constP_QTextField", false);
		TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "constP_PTextField", false);
		TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "constI_QTextField", false);
		TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "constZ_PTextField", false);
		TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "constZ_QTextField", false);

		// click the Save Button
	    finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
	    
		data = form.getAcscBusData();
		assertTrue(data.getLoadCode().equals(AclfBusData.LoadCode_ConstZ));
		assertTrue(data.getLoadP() == 2.0);
		assertTrue(data.getLoadQ() == 1.0);

		// launch editor again for NonLoad load
		busEditor.init(netContainer, form);
		
	    TestUI_UtilFunc.radioButtonAction(finder, busEditor, "nonLoadRadioButton");
		TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "pLoadTextField", false);
		TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "qLoadTextField", false);
		TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "constI_PTextField", false);
		TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "constP_QTextField", false);
		TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "constP_PTextField", false);
		TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "constI_QTextField", false);
		TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "constZ_PTextField", false);
		TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "constZ_QTextField", false);

		// click the Save Button
	    finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
	    
		data = form.getAcscBusData();
		assertTrue(data.getLoadCode().equals(AclfBusData.LoadCode_NonLoad));

		System.out.println("TestAclfBusEditorCase testLoadCase end");
	}	
}

