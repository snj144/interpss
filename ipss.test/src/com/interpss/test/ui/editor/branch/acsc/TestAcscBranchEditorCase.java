package com.interpss.test.ui.editor.branch.acsc;

import javax.swing.JButton;
import javax.swing.JComponent;

import com.interpss.common.datatype.ScGroundType;
import com.interpss.editor.data.acsc.AcscBranchData;
import com.interpss.editor.data.common.XfrConnectData;
import com.interpss.editor.form.GBranchForm;
import com.interpss.editor.jgraph.ui.form.IGBranchForm;
import com.interpss.editor.ui.SimuAppSpringAppCtxUtil;
import com.interpss.editor.ui.edit.NBBranchEditDialog;
import com.interpss.test.ui.TestUI_UtilFunc;
import com.interpss.test.ui.editor.branch.TestBranchEditorBase;

import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.*;

public class TestAcscBranchEditorCase extends TestBranchEditorBase {
	public void testLineBranchCase() {
		System.out.println("TestAcscBranchEditorCase testLineBranchCase begin");

		TestUI_UtilFunc.createTestingAcscGNetForm(netContainer);
		
		GBranchForm form = (GBranchForm)netContainer.getGBranchForm("0001->0002");
		assertNotNull(form);
		NBBranchEditDialog branchEditor = (NBBranchEditDialog)SimuAppSpringAppCtxUtil.getBranchDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");
		
		TestUI_UtilFunc.radioButtonAction(finder, branchEditor, "lineRadioButton");
		
		TestUI_UtilFunc.setTextField(finder, branchEditor, "r1TextField", "1");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "x1TextField", "2");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "r0TextField", "3");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "x0TextField", "4");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "hB1TextField", "5");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "hB0TextField", "6");
		TestUI_UtilFunc.checkTextFieldStatus(finder, branchEditor, "fromTapTextField", false);
		TestUI_UtilFunc.checkTextFieldStatus(finder, branchEditor, "toTapTextField", false);
		
		finder.setName("saveButton" );
		JButton saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
	    
		AcscBranchData data = form.getAcscBranchData();
		assertTrue(data.getLfCode().equals(IGBranchForm.TransBranchLfCode_Line));
		assertTrue(data.getZR() == 1.0);
		assertTrue(data.getZX() == 2.0);
		assertTrue(data.getHalfShuntB() == 5.0);
		assertTrue(data.getZ0R() == 3.0);
		assertTrue(data.getZ0X() == 4.0);
		assertTrue(data.getHalfShuntB0() == 6.0);
		
		// launch the editor again 
		branchEditor.init(netContainer, form);
		finder.setName("saveButton" );
		saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
	    
		data = form.getAcscBranchData();
		assertTrue(data.getLfCode().equals(IGBranchForm.TransBranchLfCode_Line));
		assertTrue(data.getZR() == 1.0);
		assertTrue(data.getZX() == 2.0);
		assertTrue(data.getHalfShuntB() == 5.0);
		assertTrue(data.getZ0R() == 3.0);
		assertTrue(data.getZ0X() == 4.0);
		assertTrue(data.getHalfShuntB0() == 6.0);

		System.out.println("TestAcscBranchEditorCase testLineBranchCase end");
	}

	public void testXfrBranchCase() {
		System.out.println("TestAcscBranchEditorCase testXfrBranchCase begin");

		TestUI_UtilFunc.createTestingAcscGNetForm(netContainer);
		
		GBranchForm form = (GBranchForm)netContainer.getGBranchForm("0001->0002");
		assertNotNull(form);
		NBBranchEditDialog branchEditor = (NBBranchEditDialog)SimuAppSpringAppCtxUtil.getBranchDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");
		
		TestUI_UtilFunc.radioButtonAction(finder, branchEditor, "xfrRadioButton");
		
		TestUI_UtilFunc.setTextField(finder, branchEditor, "r1TextField", "1");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "x1TextField", "2");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "r0TextField", "3");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "x0TextField", "4");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "fromTapTextField", "1.05");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "toTapTextField", "0.95");
		TestUI_UtilFunc.checkTextFieldStatus(finder, branchEditor, "hB1TextField", false);
		TestUI_UtilFunc.checkTextFieldStatus(finder, branchEditor, "hB0TextField", false);
		
		TestUI_UtilFunc.radioButtonAction(finder, branchEditor, "FromSide Grounding"+"deltaRadioButton");
		TestUI_UtilFunc.radioButtonAction(finder, branchEditor, "ToSide Grounding"+"wyeRadioButton");
	    TestUI_UtilFunc.radioButtonAction(finder, branchEditor, "zGRadioButton");
	    TestUI_UtilFunc.setTextField(finder, branchEditor, "gRTextField", "1.0");
	    TestUI_UtilFunc.setTextField(finder, branchEditor, "gXTextField", "2.0");
		
		finder.setName("saveButton" );
		JButton saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
	    
		AcscBranchData data = form.getAcscBranchData();
		assertTrue(data.getLfCode().equals(IGBranchForm.TransBranchLfCode_Xfr));
		assertTrue(data.getZR() == 1.0);
		assertTrue(data.getZX() == 2.0);
		assertTrue(data.getZ0R() == 3.0);
		assertTrue(data.getZ0X() == 4.0);
		assertTrue(data.getXfrTapFromSideTap() == 1.05);
		assertTrue(data.getXfrTapToSideTap() == 0.95);
		assertTrue(data.getFromXfrConnectData().getCode().equals(XfrConnectData.Code_Delta));
		assertTrue(data.getToXfrConnectData().getCode().equals(XfrConnectData.Code_Wye));
		assertTrue(data.getToXfrConnectData().getGrounding().getCode().equals(ScGroundType.GType_ZGrounded));
		assertTrue(data.getToXfrConnectData().getGrounding().getR() == 1.0);
		assertTrue(data.getToXfrConnectData().getGrounding().getX() == 2.0);
		
		// launch the editor again 
		branchEditor.init(netContainer, form);
		finder.setName("saveButton" );
		saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
	    
		data = form.getAcscBranchData();
		assertTrue(data.getLfCode().equals(IGBranchForm.TransBranchLfCode_Xfr));
		assertTrue(data.getZR() == 1.0);
		assertTrue(data.getZX() == 2.0);
		assertTrue(data.getZ0R() == 3.0);
		assertTrue(data.getZ0X() == 4.0);
		assertTrue(data.getXfrTapFromSideTap() == 1.05);
		assertTrue(data.getXfrTapToSideTap() == 0.95);
		assertTrue(data.getFromXfrConnectData().getCode().equals(XfrConnectData.Code_Delta));
		assertTrue(data.getToXfrConnectData().getCode().equals(XfrConnectData.Code_Wye));
		assertTrue(data.getToXfrConnectData().getGrounding().getCode().equals(ScGroundType.GType_ZGrounded));
		assertTrue(data.getToXfrConnectData().getGrounding().getR() == 1.0);
		assertTrue(data.getToXfrConnectData().getGrounding().getX() == 2.0);

		// launch the editor again 
		branchEditor.init(netContainer, form);

	    TestUI_UtilFunc.radioButtonAction(finder, branchEditor, "solidGRadioButton");

		finder.setName("saveButton" );
		saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		assertTrue(data.getToXfrConnectData().getGrounding().getCode().equals(ScGroundType.GType_SolidGrounded));

		// launch the editor again 
		branchEditor.init(netContainer, form);
		finder.setName("saveButton" );
		saveButton = ( JButton ) finder.find( branchEditor, 0);

		assertTrue(data.getToXfrConnectData().getGrounding().getCode().equals(ScGroundType.GType_SolidGrounded));

		// launch the editor again 
		branchEditor.init(netContainer, form);

	    TestUI_UtilFunc.radioButtonAction(finder, branchEditor, "unGRadioButton");

		finder.setName("saveButton" );
		saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		assertTrue(data.getToXfrConnectData().getGrounding().getCode().equals(ScGroundType.GType_Ungrounded));

		// launch the editor again 
		branchEditor.init(netContainer, form);
		finder.setName("saveButton" );
		saveButton = ( JButton ) finder.find( branchEditor, 0);

		assertTrue(data.getToXfrConnectData().getGrounding().getCode().equals(ScGroundType.GType_Ungrounded));

		System.out.println("TestAcscBranchEditorCase testXfrBranchCase end");
	}

	public void testPsXfrBranchCase() {
		System.out.println("TestAcscBranchEditorCase testPsXfrBranchCase begin");

		TestUI_UtilFunc.createTestingAcscGNetForm(netContainer);
		
		GBranchForm form = (GBranchForm)netContainer.getGBranchForm("0001->0002");
		assertNotNull(form);
		NBBranchEditDialog branchEditor = (NBBranchEditDialog)SimuAppSpringAppCtxUtil.getBranchDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");
		
		TestUI_UtilFunc.radioButtonAction(finder, branchEditor, "psXfrRadioButton");
		
		TestUI_UtilFunc.setTextField(finder, branchEditor, "r1TextField", "1");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "x1TextField", "2");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "r0TextField", "3");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "x0TextField", "4");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "fromTapTextField", "1.05");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "toTapTextField", "0.95");
		TestUI_UtilFunc.setTextField(finder, branchEditor, "hB1TextField", "6.0");
		TestUI_UtilFunc.checkTextFieldStatus(finder, branchEditor, "hB0TextField", false);
		
		finder.setName("saveButton" );
		JButton saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
	    
		AcscBranchData data = form.getAcscBranchData();
		assertTrue(data.getLfCode().equals(IGBranchForm.TransBranchLfCode_PsXfr));
		assertTrue(data.getZR() == 1.0);
		assertTrue(data.getZX() == 2.0);
		assertTrue(data.getZ0R() == 3.0);
		assertTrue(data.getZ0X() == 4.0);
		assertTrue(data.getXfrTapFromSideTap() == 1.05);
		assertTrue(data.getXfrTapToSideTap() == 0.95);
		assertTrue(data.getPhaseShiftAngle() == 6.0);
		
		// launch the editor again 
		branchEditor.init(netContainer, form);
		finder.setName("saveButton" );
		saveButton = ( JButton ) finder.find( branchEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
	    
		data = form.getAcscBranchData();
		assertTrue(data.getLfCode().equals(IGBranchForm.TransBranchLfCode_PsXfr));
		assertTrue(data.getZR() == 1.0);
		assertTrue(data.getZX() == 2.0);
		assertTrue(data.getZ0R() == 3.0);
		assertTrue(data.getZ0X() == 4.0);
		assertTrue(data.getXfrTapFromSideTap() == 1.05);
		assertTrue(data.getXfrTapToSideTap() == 0.95);
		assertTrue(data.getPhaseShiftAngle() == 6.0);

		System.out.println("TestAcscBranchEditorCase testPsXfrBranchCase end");
	}
}

