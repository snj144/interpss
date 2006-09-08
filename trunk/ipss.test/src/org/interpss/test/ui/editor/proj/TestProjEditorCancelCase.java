package org.interpss.test.ui.editor.proj;

import javax.swing.JButton;
import javax.swing.JComponent;

import org.interpss.editor.SimuAppSpringAppCtxUtil;
import org.interpss.editor.ui.edit.NBProjectEditDialog;
import org.interpss.test.ui.TestUIBase;


import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.*;

public class TestProjEditorCancelCase extends TestUIBase {
	public void testCancelCase() {
		System.out.println("TestProjEditorCase testCancelCase begin");
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "CancelButton" );
		
		NBProjectEditDialog projDialog = (NBProjectEditDialog)SimuAppSpringAppCtxUtil.getProjectDataEditor(
				netContainer, appSimuCtx.getProjData(), false);
		
		JButton cancelButton = ( JButton ) finder.find( projDialog, 0);
		assertNotNull( "Could not find the Cancel button", cancelButton );
		
		getHelper().enterClickAndLeave( new MouseEventData( this, cancelButton ) );
		
		System.out.println("TestProjEditorCase testCancelCase end");
	}
}

