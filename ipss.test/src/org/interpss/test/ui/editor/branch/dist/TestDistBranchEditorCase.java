package org.interpss.test.ui.editor.branch.dist;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import org.interpss.editor.data.dist.DistBranchData;
import org.interpss.editor.form.GBranchForm;
import org.interpss.editor.ui.SimuAppSpringAppCtxUtil;
import org.interpss.editor.ui.edit.NBBranchEditDialog;
import org.interpss.test.ui.TestUI_UtilFunc;
import org.interpss.test.ui.editor.branch.TestBranchEditorBase;

import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.NamedComponentFinder;

import com.interpss.editor.jgraph.ui.form.IGBranchForm;

public class TestDistBranchEditorCase extends TestBranchEditorBase {
	public void testBreakerCase() {
		System.out.println("TestDistBranchEditorCase testBreakerCase begin");
			
		TestUI_UtilFunc.createTestingDistGNetForm(netContainer);
		
		GBranchForm form = (GBranchForm)netContainer.getGBranchForm("0001->0002");
		NBBranchEditDialog branchEditor = (NBBranchEditDialog)SimuAppSpringAppCtxUtil.getBranchDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");
		
		TestUI_UtilFunc.radioButtonAction(finder, branchEditor, "breakerRadioButton");

		JComboBox nameComboBox = TestUI_UtilFunc.findComboBox(finder, branchEditor, "nameComboBox");
		nameComboBox.setSelectedItem("My Breaker"); 

		TestUI_UtilFunc.setTextField(finder, branchEditor, "rTextField", "1.0");
		
		finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
			
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
		
		TestUI_UtilFunc.radioButtonAction(finder, branchEditor, "feederRadioButton");

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
		assertTrue(editor.getIpssGraph().isGraphDirty());
			
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
		
		TestUI_UtilFunc.radioButtonAction(finder, branchEditor, "xfrRadioButton");

		JComboBox nameComboBox = TestUI_UtilFunc.findComboBox(finder, branchEditor, "xfrNameComboBox");
		nameComboBox.setSelectedItem("My Xfr"); 

		finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
			
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

