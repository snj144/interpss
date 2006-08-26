package org.interpss.test.ui.editor.branch.aclf;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import org.interpss.editor.SimuAppSpringAppCtxUtil;
import org.interpss.editor.data.acsc.AcscBranchData;
import org.interpss.editor.form.GBranchForm;
import org.interpss.editor.ui.edit.NBBranchEditDialog;
import org.interpss.test.ui.TestUI_UtilFunc;
import org.interpss.test.ui.editor.branch.TestBranchEditorBase;

import com.interpss.editor.jgraph.ui.form.IGBranchForm;

import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.*;

public class TestAclfAdjBranchEditorCase extends TestBranchEditorBase {
	public void testXfrBranchDataCase() {
		System.out.println("TestAclfAdjBranchEditorCase testXfrBranchDataCase begin");
		
		TestUI_UtilFunc.createTestingAclfAdjGNetForm(netContainer);
		
		GBranchForm form = (GBranchForm)netContainer.getGBranchForm("0001->0002");
		NBBranchEditDialog branchEditor = (NBBranchEditDialog)SimuAppSpringAppCtxUtil.getBranchDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");
		
	    TestUI_UtilFunc.radioButtonAction(finder, branchEditor, "xfrRadioButton");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "rTextField", "0.1");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "xTextField", "0.5");
		TestUI_UtilFunc.checkTextFieldStatus(finder, branchEditor, "hBTextField", false);
		TestUI_UtilFunc.setTextField(finder, branchEditor, "fromTapTextField", "1.05");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "toTapTextField", "0.95");
		
		TestUI_UtilFunc.checkBoxStatus(finder, branchEditor, "tapVControlCheckBox", true);
		TestUI_UtilFunc.checkBoxAction(finder, branchEditor, "tapVControlCheckBox", true);
		
		// save to bring the panel up
		finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		branchEditor.init(netContainer, form);

		JComboBox vcBusComboBox = TestUI_UtilFunc.findComboBox(finder, branchEditor, "vcBusComboBox");
		vcBusComboBox.setSelectedIndex(1);
		assertTrue(((String)vcBusComboBox.getSelectedItem()).equals("Bus2(0002)"));
		
		TestUI_UtilFunc.setTextField(finder, branchEditor, "vSpecTextField", "1.1");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "controlTapMaxTextField", "1.1");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "controlTapMinTextField", "0.9");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "controlTapStepTextField", "0");
	    TestUI_UtilFunc.radioButtonAction(finder, branchEditor, "vcBusFromSideRadioButton");
	    TestUI_UtilFunc.radioButtonAction(finder, branchEditor, "controlTapOnFromSideRadioButton");
		
		finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
		
		AcscBranchData data = form.getAcscBranchData();
		assertTrue(data.getLfCode().equals(IGBranchForm.TransBranchLfCode_Xfr));
		assertTrue(data.getZR() == 0.1);
		assertTrue(data.getZX() == 0.5);
		assertTrue(data.getXfrTapFromSideTap() == 1.05);
		assertTrue(data.getXfrTapToSideTap() == 0.95);
		assertTrue(data.isHasTapVControl());	
		assertTrue(data.getVcBusId().equals("Bus2(0002)"));	
		assertTrue(data.isVCBusOnFromSide());	
		assertTrue(data.isVCTapOnFromSide());	
		assertTrue(data.getVcTapMax() == 1.1);
		assertTrue(data.getVcTapMin() == 0.9);	
		assertTrue(data.getVcStep() == 0);	

		// launch the dialog again
		branchEditor.init(netContainer, form);
		finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		data = form.getAcscBranchData();
		assertTrue(data.getLfCode().equals(IGBranchForm.TransBranchLfCode_Xfr));
		assertTrue(data.getZR() == 0.1);
		assertTrue(data.getZX() == 0.5);
		assertTrue(data.getXfrTapFromSideTap() == 1.05);
		assertTrue(data.getXfrTapToSideTap() == 0.95);
		assertTrue(data.isHasTapVControl());	
		assertTrue(data.getVcBusId().equals("Bus2(0002)"));	
		assertTrue(data.isVCBusOnFromSide());	
		assertTrue(data.isVCTapOnFromSide());	
		assertTrue(data.getVcTapMax() == 1.1);
		assertTrue(data.getVcTapMin() == 0.9);	
		assertTrue(data.getVcStep() == 0);	
		
		// launch the dialog again
		branchEditor.init(netContainer, form);

	    TestUI_UtilFunc.radioButtonAction(finder, branchEditor, "vcBusToSideRadioButton");
	    TestUI_UtilFunc.radioButtonAction(finder, branchEditor, "controlTapOnToSideRadioButton");

	    finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		assertTrue(!data.isVCBusOnFromSide());	
		assertTrue(!data.isVCTapOnFromSide());	

		System.out.println("TestAclfAdjBranchEditorCase testXfrBranchDataCase end");
	}

	public void testPsXfrBranchDataCase() {
		System.out.println("TestAclfAdjBranchEditorCase testPsXfrBranchDataCase begin");
		
		TestUI_UtilFunc.createTestingAclfAdjGNetForm(netContainer);
		
		GBranchForm form = (GBranchForm)netContainer.getGBranchForm("0001->0002");
		NBBranchEditDialog branchEditor = (NBBranchEditDialog)SimuAppSpringAppCtxUtil.getBranchDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");

	    TestUI_UtilFunc.radioButtonAction(finder, branchEditor, "psXfrRadioButton");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "rTextField", "0.1");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "xTextField", "0.5");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "hBTextField", "5.0");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "fromTapTextField", "1.05");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "toTapTextField", "0.95");
		
		TestUI_UtilFunc.checkBoxStatus(finder, branchEditor, "psXfrPowerCheckBox", true);
		TestUI_UtilFunc.checkBoxAction(finder, branchEditor, "psXfrPowerCheckBox", true);
		
		// save to bring the panel up
		finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		branchEditor.init(netContainer, form);
	
		TestUI_UtilFunc.setTextField(finder, branchEditor, "pSpecTextField", "1.0");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "angleMaxTextField", "2.0");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "angleMinTextField", "0.0");
	    TestUI_UtilFunc.radioButtonAction(finder, branchEditor, "pControlFromSideRadioButton");
		
		finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
		
		AcscBranchData data = form.getAcscBranchData();
		assertTrue(data.getLfCode().equals(IGBranchForm.TransBranchLfCode_PsXfr));
		assertTrue(data.getZR() == 0.1);
		assertTrue(data.getZX() == 0.5);
		assertTrue(data.getPhaseShiftAngle() == 5.0);
		assertTrue(data.getXfrTapFromSideTap() == 1.05);
		assertTrue(data.getXfrTapToSideTap() == 0.95);	
		assertTrue(data.isHasPSXfrPControl());	
		assertTrue(data.isPcOnFromSide());
		assertTrue(data.getPcPSpec() == 1.0);
		assertTrue(data.getPcAngMax() == 2.0);	
		assertTrue(data.getPcAngMin() == 0.0);	

		// launch the dialog again
		branchEditor.init(netContainer, form);
		finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		
		data = form.getAcscBranchData();
		assertTrue(data.getLfCode().equals(IGBranchForm.TransBranchLfCode_PsXfr));
		assertTrue(data.getZR() == 0.1);
		assertTrue(data.getZX() == 0.5);
		assertTrue(data.getPhaseShiftAngle() == 5.0);
		assertTrue(data.getXfrTapFromSideTap() == 1.05);
		assertTrue(data.getXfrTapToSideTap() == 0.95);
		assertTrue(data.isHasPSXfrPControl());	
		assertTrue(data.isPcOnFromSide());
		assertTrue(data.getPcPSpec() == 1.0);
		assertTrue(data.getPcAngMax() == 2.0);	
		assertTrue(data.getPcAngMin() == 0.0);	
		
		// launch the dialog again
		branchEditor.init(netContainer, form);

	    TestUI_UtilFunc.radioButtonAction(finder, branchEditor, "pControlToSideRadioButton");

		finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		assertTrue(!data.isPcOnFromSide());

		System.out.println("TestAclfAdjBranchEditorCase testPsXfrBranchDataCase end");
	}
}

