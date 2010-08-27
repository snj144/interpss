 /*
  * @(#)TestProjEditorAclfCase.java   
  *
  * Copyright (C) 2006 www.interpss.org
  *
  * This program is free software; you can redistribute it and/or
  * modify it under the terms of the GNU LESSER GENERAL PUBLIC LICENSE
  * as published by the Free Software Foundation; either version 2.1
  * of the License, or (at your option) any later version.
  *
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  *
  * @Author Mike Zhou
  * @Version 1.0
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.test.ui.editor.proj;

import javax.swing.JButton;
import javax.swing.JComponent;

import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.NamedComponentFinder;

import org.interpss.editor.SimuAppSpringAppCtxUtil;
import org.interpss.editor.data.aclf.AclfNetData;
import org.interpss.editor.form.GNetForm;
import org.interpss.editor.jgraph.ui.form.IGNetForm;
import org.interpss.editor.ui.edit.NBProjectEditDialog;
import org.interpss.test.ui.TestUIBase;
import org.interpss.test.ui.TestUI_UtilFunc;

public class TestProjEditorAclfCase extends TestUIBase {
	public void testCase() {
		System.out.println("TestProjEditorAclfCase testCase begin");
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "" );

		netContainer.getGNetForm().setNewState(true);
		NBProjectEditDialog projDialog = (NBProjectEditDialog)SimuAppSpringAppCtxUtil.getProjectDataEditor(
						netContainer, appSimuCtx.getProjData(), false);
		
//		TestUI_UtilFunc.setTextField(finder, projDialog, "projNameTextField", "My Project Name");
		TestUI_UtilFunc.setTextArea(finder, projDialog, "descTextArea", "My Project Desc");
		TestUI_UtilFunc.setTextField(finder, projDialog, "baseKvaTextField", "1000000");
		TestUI_UtilFunc.setTextField(finder, projDialog, "baseFreqTextField", "500");
//		TestUI_UtilFunc.checkBoxAction(finder, projDialog, "allowParalellBranchCheckBox", true); the field has been disabled
		TestUI_UtilFunc.checkBoxAction(finder, projDialog, "adjustmentCheckBox", true);

	    finder.setName("SaveButton");
		JButton saveButton = ( JButton ) finder.find( projDialog, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(appSimuCtx.getProjData().isDirty());
		assertTrue(netContainer.isDataDirty());
	    
//		assertTrue(appSimuCtx.getProjData().getProjectName().equals("My Project Name"));
//    	assertTrue(netContainer.getGNetForm().getId().equals("My Project Name"));
		assertTrue(appSimuCtx.getProjData().getDescription().equals("My Project Desc"));
		
		GNetForm form = (GNetForm)netContainer.getGNetForm();
		assertTrue(form.getAppType().equals(IGNetForm.AppType_Transmission));
		assertTrue(form.getNetType().equals(IGNetForm.NetType_AclfAdjNetwork));
		assertTrue(form.getBaseKVA() == 1000000.0);
		assertTrue(form.getFreqHZ() == 500.0);
//		assertTrue(form.isAllowParallelBranch());

		AclfNetData data = form.getAcscNetData();
		assertTrue(data.isHasAdjustment());
		
		// launch the editor again
		projDialog.init(netContainer, appSimuCtx.getProjData());
		
	    finder.setName("SaveButton");
		saveButton = ( JButton ) finder.find( projDialog, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

//	    assertTrue(appSimuCtx.getProjData().getProjectName().equals("My Project Name"));
//    	assertTrue(netContainer.getGNetForm().getId().equals("My Project Name"));
		assertTrue(appSimuCtx.getProjData().getDescription().equals("My Project Desc"));
		
		form = (GNetForm)netContainer.getGNetForm();
		assertTrue(form.getAppType().equals(IGNetForm.AppType_Transmission));
		assertTrue(form.getNetType().equals(IGNetForm.NetType_AclfAdjNetwork));
		assertTrue(form.getBaseKVA() == 1000000.0);
		assertTrue(form.getFreqHZ() == 500.0);
//		assertTrue(form.isAllowParallelBranch());

		data = form.getAcscNetData();
		assertTrue(data.isHasAdjustment());

		System.out.println("TestProjEditorAclfCase testCase end");
	}
}

