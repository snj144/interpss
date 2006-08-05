package com.interpss.test.ui.editor.branch.dstab;

import javax.swing.JButton;
import javax.swing.JComponent;

import com.interpss.editor.form.GBranchForm;
import com.interpss.editor.ui.SimuAppSpringAppCtxUtil;
import com.interpss.editor.ui.edit.NBBranchEditDialog;
import com.interpss.test.ui.TestUI_UtilFunc;
import com.interpss.test.ui.editor.branch.TestBranchEditorBase;

import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.*;

public class TestDStabBranchEditorCase extends TestBranchEditorBase {
	public void testSimpleSaveCase() {
		System.out.println("TestAclfBusEditorCase testSimpleSaveCase begin");
		
		TestUI_UtilFunc.createTestingDStabGNetForm(netContainer);
		
		GBranchForm form = (GBranchForm)netContainer.getGBranchForm("0001->0002");
		NBBranchEditDialog branchEditor = (NBBranchEditDialog)SimuAppSpringAppCtxUtil.getBranchDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "saveButton" );
		JButton saveButton = ( JButton ) finder.find( branchEditor, 0);

	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
	    
		System.out.println("TestAclfBusEditorCase testSimpleSaveCase end");
	}
}

