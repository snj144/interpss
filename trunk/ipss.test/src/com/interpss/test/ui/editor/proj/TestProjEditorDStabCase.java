package com.interpss.test.ui.editor.proj;

import javax.swing.JButton;
import javax.swing.JComponent;

import com.interpss.editor.data.dstab.DStabNetData;
import com.interpss.editor.form.GNetForm;
import com.interpss.editor.jgraph.ui.form.IGNetForm;
import com.interpss.editor.ui.SimuAppSpringAppCtxUtil;
import com.interpss.editor.ui.edit.NBProjectEditDialog;
import com.interpss.test.ui.TestUI_UtilFunc;

import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.*;

public class TestProjEditorDStabCase extends TestProjEditorBase {
	public void testCase() {
		System.out.println("TestProjEditorDStabCase testCase begin");
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");

		NBProjectEditDialog projDialog = (NBProjectEditDialog)SimuAppSpringAppCtxUtil.getProjectDataEditor(
				netContainer,editor.getAppSimuContext().getProjData(), false);
		
		TestUI_UtilFunc.setTextField(finder, projDialog, "projNameTextField", "My Project Name");
		TestUI_UtilFunc.setTextArea(finder, projDialog, "descTextArea", "My Project Desc");
		TestUI_UtilFunc.radioButtonAction(finder, projDialog, "dstabNetRadioButton");
		TestUI_UtilFunc.setTextField(finder, projDialog, "baseKvaTextField", "100000.0");
		TestUI_UtilFunc.setTextField(finder, projDialog, "baseFreqTextField", "50");
		TestUI_UtilFunc.checkBoxAction(finder, projDialog, "allowParalellBranchCheckBox", true);
		TestUI_UtilFunc.checkBoxAction(finder, projDialog, "adjustmentCheckBox", true);
		
		finder.setName("SaveButton");
		JButton saveButton = ( JButton ) finder.find( projDialog, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
		
		assertTrue(editor.getAppSimuContext().getProjData().getProjectName().equals("My Project Name"));
    	assertTrue(netContainer.getGNetForm().getId().equals("My Project Name"));
		assertTrue(editor.getAppSimuContext().getProjData().getDescription().equals("My Project Desc"));
		
		GNetForm form = (GNetForm)netContainer.getGNetForm();
		assertTrue(form.getAppType().equals(IGNetForm.AppType_Transmission));
		assertTrue(form.getNetType().equals(IGNetForm.NetType_DStabilityNet));
		assertTrue(form.getBaseKVA() == 100000.0);
		assertTrue(form.getFreqHZ() == 50.0);
		assertTrue(form.isAllowParallelBranch());

		DStabNetData data = form.getDStabNetData();
		assertTrue(data.getAcscNetData().isHasAdjustment());
		assertTrue(data.getAcscNetData().isHasAclfData());

		// launch the editor again
		projDialog.init(netContainer, editor.getAppSimuContext().getProjData());
		
	    finder.setName("SaveButton");
		saveButton = ( JButton ) finder.find( projDialog, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
	    
		assertTrue(editor.getAppSimuContext().getProjData().getProjectName().equals("My Project Name"));
    	assertTrue(netContainer.getGNetForm().getId().equals("My Project Name"));
		assertTrue(editor.getAppSimuContext().getProjData().getDescription().equals("My Project Desc"));
		
		form = (GNetForm)netContainer.getGNetForm();
		assertTrue(form.getAppType().equals(IGNetForm.AppType_Transmission));
		assertTrue(form.getNetType().equals(IGNetForm.NetType_DStabilityNet));
		assertTrue(form.getBaseKVA() == 100000.0);
		assertTrue(form.getFreqHZ() == 50.0);
		assertTrue(form.isAllowParallelBranch());

		data = form.getDStabNetData();
		assertTrue(data.getAcscNetData().isHasAdjustment());
		assertTrue(data.getAcscNetData().isHasAclfData());
		
		System.out.println("TestProjEditorDStabCase testCase end");
	}
	
}

