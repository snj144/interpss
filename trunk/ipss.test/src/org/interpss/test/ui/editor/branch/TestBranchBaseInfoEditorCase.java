package org.interpss.test.ui.editor.branch;

import javax.swing.JButton;
import javax.swing.JComponent;

import org.interpss.editor.SimuAppSpringAppCtxUtil;
import org.interpss.editor.form.GBranchForm;
import org.interpss.editor.ui.edit.NBBranchEditDialog;
import org.interpss.test.ui.TestUIBase;
import org.interpss.test.ui.TestUI_UtilFunc;


import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.*;

public class TestBranchBaseInfoEditorCase extends TestUIBase {
	public void testSimpleSaveCase() {
		System.out.println("TestAclfBusEditorCase testSimpleSaveCase begin");
		
		TestUI_UtilFunc.createTestingAclfGNetForm(netContainer);
		
		GBranchForm form = (GBranchForm)netContainer.getGBranchForm("0001->0002");
		NBBranchEditDialog branchEditor = (NBBranchEditDialog)SimuAppSpringAppCtxUtil.getBranchDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");

		TestUI_UtilFunc.setTextField(finder, branchEditor, "branchNameTextField", "Branch Name");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "areaTextField", "2");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "zoneTextField", "2");
		TestUI_UtilFunc.checkBoxAction(finder, branchEditor, "inServiceCheckBox", true);
		
		finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(netContainer.isDataDirty());
	    
		assertTrue(form.getName().equals("Branch Name"));
		assertTrue(form.getArea() == 2);
		assertTrue(form.getZone() == 2);
		assertTrue(form.getStatus());
		
		// launch the dialog again
		branchEditor.init(netContainer, form);
		finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(netContainer.isDataDirty());

		assertTrue(form.getName().equals("Branch Name"));
		assertTrue(form.getArea() == 2);
		assertTrue(form.getZone() == 2);
		assertTrue(form.getStatus());
		
		System.out.println("TestAclfBusEditorCase testSimpleSaveCase end");
	}
}

