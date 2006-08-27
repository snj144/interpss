package org.interpss.test.ui.editor.branch.aclf;

import javax.swing.JButton;
import javax.swing.JComponent;

import org.interpss.editor.data.acsc.AcscBranchData;
import org.interpss.editor.form.GBranchForm;
import org.interpss.editor.ui.SimuAppSpringAppCtxUtil;
import org.interpss.editor.ui.edit.NBBranchEditDialog;
import org.interpss.test.ui.TestUI_UtilFunc;
import org.interpss.test.ui.editor.branch.TestBranchEditorBase;

import com.interpss.editor.jgraph.ui.form.IGBranchForm;

import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.*;

public class TestAclfBranchEditorCase extends TestBranchEditorBase {
	public void testBranchDataCase() {
		System.out.println("TestAclfBranchEditorCase testBranchDataCase begin");
		
		TestUI_UtilFunc.createTestingAclfGNetForm(netContainer);
		
		GBranchForm form = (GBranchForm)netContainer.getGBranchForm("0001->0002");
		NBBranchEditDialog branchEditor = (NBBranchEditDialog)SimuAppSpringAppCtxUtil.getBranchDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");
		
	    TestUI_UtilFunc.radioButtonAction(finder, branchEditor, "lineRadioButton");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "rTextField", "0.1");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "xTextField", "0.5");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "hBTextField", "0.05");
		TestUI_UtilFunc.checkTextFieldStatus(finder, branchEditor, "fromTapTextField", false);
		TestUI_UtilFunc.checkTextFieldStatus(finder, branchEditor, "toTapTextField", false);
		
		finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
		
		AcscBranchData data = form.getAcscBranchData();
		assertTrue(data.getLfCode().equals(IGBranchForm.TransBranchLfCode_Line));
		assertTrue(data.getZR() == 0.1);
		assertTrue(data.getZX() == 0.5);
		assertTrue(data.getHalfShuntB() == 0.05);
	    
		// launch the dialog again
		branchEditor.init(netContainer, form);
		finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		
		data = form.getAcscBranchData();
		assertTrue(data.getLfCode().equals(IGBranchForm.TransBranchLfCode_Line));
		assertTrue(data.getZR() == 0.1);
		assertTrue(data.getZX() == 0.5);
		assertTrue(data.getHalfShuntB() == 0.05);
		
		System.out.println("TestAclfBranchEditorCase testBranchDataCase end");
	}

	public void testXfrBranchDataCase() {
		System.out.println("TestAclfBranchEditorCase testXfrBranchDataCase begin");
		
		TestUI_UtilFunc.createTestingAclfGNetForm(netContainer);
		
		GBranchForm form = (GBranchForm)netContainer.getGBranchForm("0001->0002");
		NBBranchEditDialog branchEditor = (NBBranchEditDialog)SimuAppSpringAppCtxUtil.getBranchDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");
		
	    TestUI_UtilFunc.radioButtonAction(finder, branchEditor, "xfrRadioButton");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "rTextField", "0.1");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "xTextField", "0.5");
		TestUI_UtilFunc.checkTextFieldStatus(finder, branchEditor, "hBTextField", false);
		TestUI_UtilFunc.setTextField(finder, branchEditor, "fromTapTextField", "1.05");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "toTapTextField", "0.95");
		
		finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
		
		AcscBranchData data = form.getAcscBranchData();
		assertTrue(data.getLfCode().equals(IGBranchForm.TransBranchLfCode_Xfr));
		assertTrue(data.getZR() == 0.1);
		assertTrue(data.getZX() == 0.5);
		assertTrue(data.getXfrTapFromSideTap() == 1.05);
		assertTrue(data.getXfrTapToSideTap() == 0.95);

		// launch the dialog again
		branchEditor.init(netContainer, form);
		finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		data = form.getAcscBranchData();
		assertTrue(data.getLfCode().equals(IGBranchForm.TransBranchLfCode_Xfr));
		assertTrue(data.getZR() == 0.1);
		assertTrue(data.getZX() == 0.5);
		assertTrue(data.getXfrTapFromSideTap() == 1.05);
		assertTrue(data.getXfrTapToSideTap() == 0.95);
		
		System.out.println("TestAclfBranchEditorCase testXfrBranchDataCase end");
	}

	public void testPsXfrBranchDataCase() {
		System.out.println("TestAclfBranchEditorCase testPsXfrBranchDataCase begin");
		
		TestUI_UtilFunc.createTestingAclfGNetForm(netContainer);
		
		GBranchForm form = (GBranchForm)netContainer.getGBranchForm("0001->0002");
		NBBranchEditDialog branchEditor = (NBBranchEditDialog)SimuAppSpringAppCtxUtil.getBranchDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");

	    TestUI_UtilFunc.radioButtonAction(finder, branchEditor, "psXfrRadioButton");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "rTextField", "0.1");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "xTextField", "0.5");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "hBTextField", "5.0");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "fromTapTextField", "1.05");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "toTapTextField", "0.95");
		
		finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
		
		AcscBranchData data = form.getAcscBranchData();
		assertTrue(data.getLfCode().equals(IGBranchForm.TransBranchLfCode_PsXfr));
		assertTrue(data.getZR() == 0.1);
		assertTrue(data.getZX() == 0.5);
		assertTrue(data.getPhaseShiftAngle() == 5.0);
		assertTrue(data.getXfrTapFromSideTap() == 1.05);
		assertTrue(data.getXfrTapToSideTap() == 0.95);	

		// launch the dialog again
		branchEditor.init(netContainer, form);
		finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		
		data = form.getAcscBranchData();
		assertTrue(data.getLfCode().equals(IGBranchForm.TransBranchLfCode_PsXfr));
		assertTrue(data.getZR() == 0.1);
		assertTrue(data.getZX() == 0.5);
		assertTrue(data.getPhaseShiftAngle() == 5.0);
		assertTrue(data.getXfrTapFromSideTap() == 1.05);
		assertTrue(data.getXfrTapToSideTap() == 0.95);
		
		System.out.println("TestAclfBranchEditorCase testPsXfrBranchDataCase end");
	}
}

