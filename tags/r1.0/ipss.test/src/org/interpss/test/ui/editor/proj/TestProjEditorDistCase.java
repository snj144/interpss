 /*
  * @(#)TestProjEditorDistCase.java   
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

import org.interpss.editor.SimuAppSpringAppCtxUtil;
import org.interpss.editor.data.dist.DistNetData;
import org.interpss.editor.form.GNetForm;
import org.interpss.editor.ui.edit.NBProjectEditDialog;
import org.interpss.test.ui.TestUIBase;
import org.interpss.test.ui.TestUI_UtilFunc;

import org.interpss.editor.jgraph.ui.form.IGNetForm;

import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.*;

public class TestProjEditorDistCase extends TestUIBase {
	public void testCase() {
		System.out.println("TestProjEditorDistCase testCase begin");
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "" );

		netContainer.getGNetForm().setNewState(true);
		NBProjectEditDialog projDialog = (NBProjectEditDialog)SimuAppSpringAppCtxUtil.getProjectDataEditor(
				netContainer, appSimuCtx.getProjData(), false);
		
		TestUI_UtilFunc.radioButtonClickAction(finder, projDialog, "distriAppRadioButton");
//		TestUI_UtilFunc.setTextField(finder, projDialog, "projNameTextField", "My Project Name");
		TestUI_UtilFunc.setTextArea(finder, projDialog, "descTextArea", "My Project Desc");
		TestUI_UtilFunc.setTextField(finder, projDialog, "baseKvaTextField", "1000000");
		TestUI_UtilFunc.setTextField(finder, projDialog, "baseFreqTextField", "500");
		TestUI_UtilFunc.radioButtonClickAction(finder, projDialog, "genericStdRadioButton");
//		TestUtilFunc.checkBoxAction(finder, projDialog, "pEnable_3_CheckBox", false);
//		TestUtilFunc.checkBoxAction(finder, projDialog, "pEnable_5_CheckBox", false);
//		TestUtilFunc.setTextField(finder, projDialog, "pName_1_TextField", "ScPointName1");
//		TestUtilFunc.setTextField(finder, projDialog, "pDesc_1_TextField", "ScPointDesc1");
//		TestUtilFunc.setTextField(finder, projDialog, "pName_4_TextField", "ScPointName4");
//		TestUtilFunc.setTextField(finder, projDialog, "pDesc_4_TextField", "ScPointDesc4");

		finder.setName("SaveButton");
		JButton saveButton = ( JButton ) finder.find( projDialog, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(appSimuCtx.getProjData().isDirty());
		
//		assertTrue(appSimuCtx.getProjData().getProjectName().equals("My Project Name"));
		assertTrue(appSimuCtx.getProjData().getDescription().equals("My Project Desc"));
		
		GNetForm form = (GNetForm)netContainer.getGNetForm();
		assertTrue(form.getAppType().equals(IGNetForm.AppType_Distribution));
		assertTrue(form.getNetType().equals(IGNetForm.NetType_AcscNetwork));
		assertTrue(form.getBaseKVA() == 1000000.0);
		assertTrue(form.getFreqHZ() == 500.0);

        assertTrue(form.getDistNetData().getScStd().equals(DistNetData.ScStd_Generic));
//        assertTrue(form.getDistNetData().getScPointList().size() == 5);
//        assertTrue(form.getDistNetData().getActiveScPoints() == 3);

//        ScPointData row = (ScPointData)form.getDistNetData().getScPointList().get(0);
//        assertTrue(row.getName().equals("ScPointName1"));
//        assertTrue(row.getDescription().equals("ScPointDesc1"));
//        assertTrue(row.getEnable());
        
//        row = (ScPointData)form.getDistNetData().getScPointList().get(3);
//        assertTrue(row.getName().equals("ScPointName4"));
//        assertTrue(row.getDescription().equals("ScPointDesc4"));
//        assertTrue(row.getEnable());
        
		// launch the editor again
		projDialog.init(netContainer, appSimuCtx.getProjData());
		
	    finder.setName("SaveButton");
		saveButton = ( JButton ) finder.find( projDialog, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
	    
//		assertTrue(appSimuCtx.getProjData().getProjectName().equals("My Project Name"));
		assertTrue(appSimuCtx.getProjData().getDescription().equals("My Project Desc"));
		
		form = (GNetForm)netContainer.getGNetForm();
		assertTrue(form.getAppType().equals(IGNetForm.AppType_Distribution));
		assertTrue(form.getNetType().equals(IGNetForm.NetType_AcscNetwork));
		assertTrue(form.getBaseKVA() == 1000000.0);
		assertTrue(form.getFreqHZ() == 500.0);

        assertTrue(form.getDistNetData().getScStd().equals(DistNetData.ScStd_Generic));
/*
        assertTrue(form.getDistNetData().getScPointList().size() == 5);
        assertTrue(form.getDistNetData().getActiveScPoints() == 3);

        row = (ScPointData)form.getDistNetData().getScPointList().get(0);
        assertTrue(row.getName().equals("ScPointName1"));
        assertTrue(row.getDescription().equals("ScPointDesc1"));
        assertTrue(row.getEnable());
        
        row = (ScPointData)form.getDistNetData().getScPointList().get(3);
        assertTrue(row.getName().equals("ScPointName4"));
        assertTrue(row.getDescription().equals("ScPointDesc4"));
        assertTrue(row.getEnable());
*/        
        System.out.println("TestProjEditorDistCase testCase end");
	}
	
}

