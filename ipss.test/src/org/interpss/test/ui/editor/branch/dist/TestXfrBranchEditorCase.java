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

public class TestXfrBranchEditorCase extends TestUIBase {
	public void testXfrCase() {
		System.out.println("TestXfrBranchEditorCase testXfrCase begin");
			
		TestUI_UtilFunc.createTestingDistGNetForm(netContainer);
		
		GBranchForm form = (GBranchForm)netContainer.getGBranchForm("0001->0002");
		NBBranchEditDialog branchEditor = (NBBranchEditDialog)SimuAppSpringAppCtxUtil.getBranchDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");
		
		TestUI_UtilFunc.radioButtonAction(finder, branchEditor, "xfrRadioButton");

		JComboBox nameComboBox = TestUI_UtilFunc.findComboBox(finder, branchEditor, "xfrNameComboBox");
		nameComboBox.setSelectedItem("My Xfr"); 

		TestUI_UtilFunc.setTextField(finder, branchEditor, "xfrRatingTextField", "1.0");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "fromRatedVTextField", "2.0");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "toRatedVTextField", "3.0");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "xTextField", "4.0");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "rTextField", "5.0");
		// TestUtilFunc.setTextField(finder, branchEditor, "x_rTextField", "5.0");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "x0_x1TextField", "1.0");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "r0_r1TextField", "1.0");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "fromTapTextField", "1.05");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "toTapTextField", "0.95");
		
		JComboBox ratingUnitComboBox = TestUI_UtilFunc.findComboBox(finder, branchEditor, "ratingUnitComboBox");
		ratingUnitComboBox.setSelectedIndex(0);
		TestUI_UtilFunc.checkComboBoxSelection(ratingUnitComboBox, "MVA"); // "MVA", "KVA"

		JComboBox tapUnitComboBox = TestUI_UtilFunc.findComboBox(finder, branchEditor, "tapUnitComboBox");
		tapUnitComboBox.setSelectedIndex(0);
		TestUI_UtilFunc.checkComboBoxSelection(tapUnitComboBox, "PU"); // "PU", "%"

		JComboBox voltUnitComboBox = TestUI_UtilFunc.findComboBox(finder, branchEditor, "voltUnitComboBox");
		voltUnitComboBox.setSelectedIndex(0);
		TestUI_UtilFunc.checkComboBoxSelection(voltUnitComboBox, "Volt"); // "Volt", "KV"

		JComboBox zUnitComboBox = TestUI_UtilFunc.findComboBox(finder, branchEditor, "zUnitComboBox");
		zUnitComboBox.setSelectedIndex(0);
		TestUI_UtilFunc.checkComboBoxSelection(zUnitComboBox, "%"); // "%", "PU"
/* TODO:
		TestUtilFunc.radioButtonAction(finder, branchEditor, "Primary Grounding"+"deltaRadioButton");
		TestUtilFunc.radioButtonAction(finder, branchEditor, "Secondary Grounding"+"wyeRadioButton");
	    TestUtilFunc.radioButtonAction(finder, branchEditor, "zGRadioButton");
	    TestUtilFunc.setTextField(finder, branchEditor, "gRTextField", "1.0");
	    TestUtilFunc.setTextField(finder, branchEditor, "gXTextField", "2.0");
*/
	    finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(netContainer.isDataDirty());
			
		DistBranchData data = form.getDistBranchData();
		assertTrue(data.getBranchCode().equals(IGBranchForm.DistBranchCode_Xfr));		
		assertTrue(form.getName().equals("My Xfr"));		
		assertTrue(data.getXfrRatingUnit().equals("MVA"));		
		assertTrue(data.getRatedVoltUnit().equals("Volt"));		
		assertTrue(data.getXfrTapUnit().equals("PU"));		
		assertTrue(data.getZUnit().equals("%"));		
		assertTrue(data.getXfrRating() == 1.0);
		assertTrue(data.getFromRatedVolt() == 2.0);
		assertTrue(data.getZR() == 5.0);
		assertTrue(data.getZX() == 4.0);
		assertTrue(data.getZ0R() == 5.0);
		assertTrue(data.getZ0X() == 4.0);
		assertTrue(data.getXfrTapFromSideTap() == 1.05);
		assertTrue(data.getXfrTapToSideTap() == 0.95);
	    
		// launch the dialog again
		branchEditor.init(netContainer, form);
		finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		assertTrue(data.getBranchCode().equals(IGBranchForm.DistBranchCode_Xfr));		
		assertTrue(form.getName().equals("My Xfr"));		
		assertTrue(data.getXfrRatingUnit().equals("MVA"));		
		assertTrue(data.getRatedVoltUnit().equals("Volt"));		
		assertTrue(data.getXfrTapUnit().equals("PU"));		
		assertTrue(data.getZUnit().equals("%"));		
		assertTrue(data.getXfrRating() == 1.0);
		assertTrue(data.getFromRatedVolt() == 2.0);
		assertTrue(data.getZR() == 5.0);
		assertTrue(data.getZX() == 4.0);
		assertTrue(data.getZ0R() == 5.0);
		assertTrue(data.getZ0X() == 4.0);
		assertTrue(data.getXfrTapFromSideTap() == 1.05);
		assertTrue(data.getXfrTapToSideTap() == 0.95);

		// launch the dialog again
		branchEditor.init(netContainer, form);

		TestUI_UtilFunc.setTextField(finder, branchEditor, "rTextField", "0.0"); 
		TestUI_UtilFunc.setTextField(finder, branchEditor, "x_rTextField", "1.0"); 

		ratingUnitComboBox = TestUI_UtilFunc.findComboBox(finder, branchEditor, "ratingUnitComboBox");
		ratingUnitComboBox.setSelectedIndex(1);
		TestUI_UtilFunc.checkComboBoxSelection(ratingUnitComboBox, "KVA"); // "MVA", "KVA"

		tapUnitComboBox = TestUI_UtilFunc.findComboBox(finder, branchEditor, "tapUnitComboBox");
		tapUnitComboBox.setSelectedIndex(1);
		TestUI_UtilFunc.checkComboBoxSelection(tapUnitComboBox, "%"); // "PU", "%"

		voltUnitComboBox = TestUI_UtilFunc.findComboBox(finder, branchEditor, "voltUnitComboBox");
		voltUnitComboBox.setSelectedIndex(1);
		TestUI_UtilFunc.checkComboBoxSelection(voltUnitComboBox, "KV"); // "Volt", "KV"

		zUnitComboBox = TestUI_UtilFunc.findComboBox(finder, branchEditor, "zUnitComboBox");
		zUnitComboBox.setSelectedIndex(1);
		TestUI_UtilFunc.checkComboBoxSelection(zUnitComboBox, "PU"); // "%", "PU"

		finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
	    
		assertTrue(data.getXfrRatingUnit().equals("KVA"));		
		assertTrue(data.getRatedVoltUnit().equals("KV"));		
		assertTrue(data.getXfrTapUnit().equals("%"));		
		assertTrue(data.getZUnit().equals("PU"));		
		//System.out.println("--->" + data.getZR());
		//System.out.println("--->" + data.getZX());
		//System.out.println("--->" + data.getZ0R());
		//System.out.println("--->" + data.getZ0X());
		/* TODO:
		assertTrue(data.getZR() == 4.0);
		assertTrue(data.getZX() == 4.0);
		assertTrue(data.getZ0R() == 4.0);
		assertTrue(data.getZ0X() == 4.0);
		*/
		System.out.println("TestXfrBranchEditorCase testXfrCase end");
	}
}

