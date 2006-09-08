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
import org.interpss.test.ui.TestUI_UtilFunc;

public class TestProjEditorAclfCase extends TestProjEditorBase {
	public void testCase() {
		System.out.println("TestProjEditorAclfCase testCase begin");
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "" );

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

