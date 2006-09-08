package org.interpss.test.ui.editor.bus.acsc;

import javax.swing.JButton;
import javax.swing.JComponent;

import org.interpss.editor.SimuAppSpringAppCtxUtil;
import org.interpss.editor.data.acsc.AcscBusData;
import org.interpss.editor.form.GBusForm;
import org.interpss.editor.ui.edit.NBBusEditDialog;
import org.interpss.test.ui.TestUIBase;
import org.interpss.test.ui.TestUI_UtilFunc;

import com.interpss.common.datatype.ScGroundType;

import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.*;

public class TestAcscBusEditorCase extends TestUIBase {
	public void testNonContribCase() {
		System.out.println("TestAclfBusEditorCase testNonContribCase begin");
		
		TestUI_UtilFunc.createTestingAcscGNetForm(netContainer);
		GBusForm form = (GBusForm)netContainer.getGBusForm("0001");
		NBBusEditDialog busEditor = (NBBusEditDialog)SimuAppSpringAppCtxUtil.getBusDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");
		
		TestUI_UtilFunc.selectTabbedPane(finder, busEditor, "acscTabbedPane", 1);
		
	    TestUI_UtilFunc.radioButtonAction(finder, busEditor, "nonContributeRadioButton");
		
		finder.setName("saveButton" );
		JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(netContainer.isDataDirty());
	    
		AcscBusData data = form.getAcscBusData();
		assertTrue(data.getScCode().equals(AcscBusData.ScCode_NonContribute));
		
		// launch the editor again
		busEditor.init(netContainer, form);
		finder.setName("saveButton" );
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		data = form.getAcscBusData();
		assertTrue(data.getScCode().equals(AcscBusData.ScCode_NonContribute));

		System.out.println("TestAclfBusEditorCase testNonContribCase end");
	}

	public void testContribSolidGroundCase() {
		System.out.println("TestAclfBusEditorCase testContribSolidGroundCase begin");
		
		TestUI_UtilFunc.createTestingAcscGNetForm(netContainer);
		GBusForm form = (GBusForm)netContainer.getGBusForm("0001");
		NBBusEditDialog busEditor = (NBBusEditDialog)SimuAppSpringAppCtxUtil.getBusDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");
		
		TestUI_UtilFunc.selectTabbedPane(finder, busEditor, "acscTabbedPane", 1);
		
	    TestUI_UtilFunc.radioButtonAction(finder, busEditor, "contributeRadioButton");

		TestUI_UtilFunc.setTextField(finder, busEditor, "r1TextField", "1.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "x1TextField", "2.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "r2TextField", "3.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "x2TextField", "4.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "r0TextField", "5.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "x0TextField", "6.0");
		
	    TestUI_UtilFunc.radioButtonAction(finder, busEditor, "solidGRadioButton");
	    TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "gRTextField", false);
	    TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "gXTextField", false);
		
		finder.setName("saveButton" );
		JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(netContainer.isDataDirty());
	    
		AcscBusData data = form.getAcscBusData();
		assertTrue(data.getScCode().equals(AcscBusData.ScCode_Contribute));
		assertTrue(data.getZ1R() == 1.0);
		assertTrue(data.getZ1X() == 2.0);
		assertTrue(data.getZ2R() == 3.0);
		assertTrue(data.getZ2X() == 4.0);
		assertTrue(data.getZ0R() == 5.0);
		assertTrue(data.getZ0X() == 6.0);
		assertTrue(data.getGround().getCode().equals(ScGroundType.GType_SolidGrounded));
		
		// launch the editor again
		busEditor.init(netContainer, form);
		finder.setName("saveButton" );
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		data = form.getAcscBusData();
		assertTrue(data.getScCode().equals(AcscBusData.ScCode_Contribute));
		assertTrue(data.getZ1R() == 1.0);
		assertTrue(data.getZ1X() == 2.0);
		assertTrue(data.getZ2R() == 3.0);
		assertTrue(data.getZ2X() == 4.0);
		assertTrue(data.getZ0R() == 5.0);
		assertTrue(data.getZ0X() == 6.0);
		assertTrue(data.getGround().getCode().equals(ScGroundType.GType_SolidGrounded));

		System.out.println("TestAclfBusEditorCase testContribSolidGroundCase end");
	}

	public void testContribUnGroundCase() {
		System.out.println("TestAclfBusEditorCase testContribUnGroundCase begin");
		
		TestUI_UtilFunc.createTestingAcscGNetForm(netContainer);
		GBusForm form = (GBusForm)netContainer.getGBusForm("0001");
		NBBusEditDialog busEditor = (NBBusEditDialog)SimuAppSpringAppCtxUtil.getBusDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");
		
		TestUI_UtilFunc.selectTabbedPane(finder, busEditor, "acscTabbedPane", 1);
		
	    TestUI_UtilFunc.radioButtonAction(finder, busEditor, "contributeRadioButton");

	    TestUI_UtilFunc.radioButtonAction(finder, busEditor, "unGRadioButton");
	    TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "gRTextField", false);
	    TestUI_UtilFunc.checkTextFieldStatus(finder, busEditor, "gXTextField", false);
		
		finder.setName("saveButton" );
		JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(netContainer.isDataDirty());
	    
		AcscBusData data = form.getAcscBusData();
		assertTrue(data.getScCode().equals(AcscBusData.ScCode_Contribute));
		assertTrue(data.getGround().getCode().equals(ScGroundType.GType_Ungrounded));
		
		// launch the editor again
		busEditor.init(netContainer, form);
		finder.setName("saveButton" );
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		data = form.getAcscBusData();
		assertTrue(data.getScCode().equals(AcscBusData.ScCode_Contribute));
		assertTrue(data.getGround().getCode().equals(ScGroundType.GType_Ungrounded));

		System.out.println("TestAclfBusEditorCase testContribUnGroundCase end");
	}

	public void testContribZGroundCase() {
		System.out.println("TestAclfBusEditorCase testContribZGroundCase begin");
		
		TestUI_UtilFunc.createTestingAcscGNetForm(netContainer);
		GBusForm form = (GBusForm)netContainer.getGBusForm("0001");
		NBBusEditDialog busEditor = (NBBusEditDialog)SimuAppSpringAppCtxUtil.getBusDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");
		
		TestUI_UtilFunc.selectTabbedPane(finder, busEditor, "acscTabbedPane", 1);
		
	    TestUI_UtilFunc.radioButtonAction(finder, busEditor, "contributeRadioButton");

	    TestUI_UtilFunc.radioButtonAction(finder, busEditor, "zGRadioButton");
	    TestUI_UtilFunc.setTextField(finder, busEditor, "gRTextField", "1.0");
	    TestUI_UtilFunc.setTextField(finder, busEditor, "gXTextField", "2.0");
		
		finder.setName("saveButton" );
		JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(netContainer.isDataDirty());
	    
		AcscBusData data = form.getAcscBusData();
		assertTrue(data.getScCode().equals(AcscBusData.ScCode_Contribute));
		assertTrue(data.getGround().getCode().equals(ScGroundType.GType_ZGrounded));
		assertTrue(data.getGround().getR() == 1.0);
		assertTrue(data.getGround().getX() == 2.0);
		
		// launch the editor again
		busEditor.init(netContainer, form);
		finder.setName("saveButton" );
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		data = form.getAcscBusData();
		assertTrue(data.getScCode().equals(AcscBusData.ScCode_Contribute));
		assertTrue(data.getGround().getCode().equals(ScGroundType.GType_ZGrounded));
		assertTrue(data.getGround().getR() == 1.0);
		assertTrue(data.getGround().getX() == 2.0);

		System.out.println("TestAclfBusEditorCase testContribZGroundCase end");
	}
}

