package org.interpss.test.ui.editor.branch.dstab;

import javax.swing.JButton;
import javax.swing.JComponent;

import org.interpss.editor.SimuAppSpringAppCtxUtil;
import org.interpss.editor.form.GBranchForm;
import org.interpss.editor.ui.edit.NBBranchEditDialog;
import org.interpss.test.ui.TestUIBase;
import org.interpss.test.ui.TestUI_UtilFunc;


import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.*;

public class TestDStabBranchEditorCase extends TestUIBase {
	public void testSimpleSaveCase() {
		System.out.println("TestAclfBusEditorCase testSimpleSaveCase begin");
		
		TestUI_UtilFunc.createTestingDStabGNetForm(netContainer);
		
		GBranchForm form = (GBranchForm)netContainer.getGBranchForm("0001->0002");
		NBBranchEditDialog branchEditor = (NBBranchEditDialog)SimuAppSpringAppCtxUtil.getBranchDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");
		
		TestUI_UtilFunc.setTextField(finder, branchEditor, "x1TextField", "0.1");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "x0TextField", "0.1");

		finder.setName("saveButton" );
		JButton saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(netContainer.isDataDirty());
	    
		System.out.println("TestAclfBusEditorCase testSimpleSaveCase end");
	}
}

