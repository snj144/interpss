package com.interpss.test.ui;

import java.io.File;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.jgraph.JGraph;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.finder.NamedComponentFinder;

import com.interpss.common.datatype.ScGroundType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.editor.data.dist.DistBusData;
import com.interpss.editor.form.GBranchForm;
import com.interpss.editor.form.GBusForm;
import com.interpss.editor.form.GFormContainer;
import com.interpss.editor.form.GNetForm;
import com.interpss.editor.form.InitDataUtil;
import com.interpss.editor.jgraph.ui.form.IGBranchForm;
import com.interpss.editor.jgraph.ui.form.IGNetForm;
import com.interpss.editor.util.IOUtilFunc;

public class TestUI_UtilFunc extends JFCTestCase {
	public static String JGraphEditorTestFilePath = "C:/eclipse/GEditor/projects/unittest/";
	
	public static void radioButtonStatus(NamedComponentFinder finder, JDialog dialog,
							String rButtonName,  boolean enabled) {
	    finder.setName(rButtonName);
	    JRadioButton radioButton = ( JRadioButton ) finder.find( dialog, 0 );
	    assertNotNull(radioButton);
	    if (enabled)
	    	assertTrue(radioButton.isEnabled());
	    else 
	    	assertTrue(!radioButton.isEnabled());
	}
	
	public static void radioButtonAction(NamedComponentFinder finder, JDialog dialog,
							String rButtonName) {
	    finder.setName(rButtonName);
	    JRadioButton radioButton = ( JRadioButton ) finder.find( dialog, 0 );
	    assertNotNull(radioButton);
    	radioButton.doClick();
	}
	
	public static void selectTabbedPane(NamedComponentFinder finder, JDialog dialog, 
						String paneName, int index) {
		finder.setName(paneName);
		JTabbedPane tabbedPane = ( JTabbedPane ) finder.find( dialog, 0);
	    assertNotNull(tabbedPane);
		assertTrue(index < tabbedPane.getTabCount());
		tabbedPane.setSelectedIndex(index);		
	}
	
	public static JTextField setTextField(NamedComponentFinder finder, JDialog dialog, 
						String fieldName, String fieldText) {
	    finder.setName(fieldName);
	    JTextField textField = ( JTextField ) finder.find( dialog, 0 );
	    assertNotNull(textField);
	    assertTrue(textField.isEnabled());
	    textField.setText(fieldText);
	    return textField;
	}

	public static void checkTextFieldStatus(NamedComponentFinder finder, JDialog dialog, 
						String fieldName, boolean enabled) {
		finder.setName(fieldName);
		JTextField textField = ( JTextField ) finder.find( dialog, 0 );
		assertNotNull(textField);
		if (enabled)
			assertTrue(textField.isEnabled());
		else
			assertTrue(!textField.isEnabled());
	}
	
	public static void setTextFieldStatus(NamedComponentFinder finder, JDialog dialog, 
			String fieldName, boolean enabled) {
		finder.setName(fieldName);
		JTextField textField = ( JTextField ) finder.find( dialog, 0 );
		assertNotNull(textField);
		textField.setEnabled(enabled);
	}

	public static void setTextArea(NamedComponentFinder finder, JDialog dialog, String comName, String text) {
	    finder.setName(comName);
	    JTextArea textArea = ( JTextArea ) finder.find( dialog, 0 );
		assertNotNull(textArea);
	    textArea.setText(text);	
	}
	
	public static void checkBoxAction(NamedComponentFinder finder, JDialog dialog, 
							String checkBoxName, boolean select) {
	    finder.setName(checkBoxName);
	    JCheckBox checkBox = ( JCheckBox ) finder.find( dialog, 0 );
	    assertNotNull(checkBox);
	    assertTrue(checkBox.isEnabled());
	    checkBox.setSelected(select);		
	}
	
	public static void checkBoxStatus(NamedComponentFinder finder, JDialog dialog, 
			String checkBoxName, boolean enabled) {
		finder.setName(checkBoxName);
		JCheckBox checkBox = ( JCheckBox ) finder.find( dialog, 0 );
		assertNotNull(checkBox);
		if (enabled)
			assertTrue(checkBox.isEnabled());
		else
			assertTrue(!checkBox.isEnabled());
	}
	
	public static JComboBox findComboBox(NamedComponentFinder finder, JDialog dialog, String boxName) {
		finder.setName(boxName);
		JComboBox comboBox = ( JComboBox ) finder.find( dialog, 0);
		assertNotNull(comboBox);
		return comboBox;
	}
	
	public static void checkComboBoxSelection(JComboBox comboBox, String item) {
		assertTrue(item.equals(comboBox.getSelectedItem()));
	}

	public static void comboBoxHasItem(JComboBox comboBox, String item) {
		comboBox.setSelectedItem(item);
		assertTrue(item.equals(comboBox.getSelectedItem()));
	}
	
	public static void setZTable_XR_5Points(NamedComponentFinder finder, JDialog dialog, String boxName) {
	    finder.setName("zTable");
		JTable zTable = ( JTable ) finder.find( dialog, 0);
		assertNotNull(zTable);
		DefaultTableModel dataModel = (DefaultTableModel)zTable.getModel();
		dataModel.setValueAt(new Double(1.0), 0, 1);
		dataModel.setValueAt(new Double(2.0), 0, 2);
		dataModel.setValueAt(new Double(3.0), 1, 1);
		dataModel.setValueAt(new Double(4.0), 1, 2);
		dataModel.setValueAt(new Double(5.0), 2, 1);
		dataModel.setValueAt(new Double(6.0), 2, 2);
		dataModel.setValueAt(new Double(7.0), 3, 1);    // Z2
		dataModel.setValueAt(new Double(8.0), 3, 2);
		dataModel.setValueAt(new Double(9.0), 4, 1);    // Z0
		dataModel.setValueAt(new Double(10.0), 4, 2);
	}
	
	public static void setZTable_XoverR_5Points(NamedComponentFinder finder, JDialog dialog, String boxName) {
	    finder.setName("zTable");
		JTable zTable = ( JTable ) finder.find( dialog, 0);
		assertNotNull(zTable);
		DefaultTableModel dataModel = (DefaultTableModel)zTable.getModel();
		dataModel.setValueAt(new Double(1.0), 0, 1);
		dataModel.setValueAt(new Double(2.0), 0, 3);
		dataModel.setValueAt(new Double(3.0), 1, 1);
		dataModel.setValueAt(new Double(4.0), 1, 3);
		dataModel.setValueAt(new Double(5.0), 2, 1);
		dataModel.setValueAt(new Double(6.0), 2, 3);
		dataModel.setValueAt(new Double(7.0), 3, 1);    // Z2
		dataModel.setValueAt(new Double(8.0), 3, 2);
		dataModel.setValueAt(new Double(9.0), 4, 1);    // Z0
		dataModel.setValueAt(new Double(10.0), 4, 2);
	}
	
	public static void checkBusZ_XR_5Points(DistBusData data) {
		assertTrue(data.getZ1(0).getR() == 2.0);
		assertTrue(data.getZ1(0).getX() == 1.0);
		assertTrue(data.getZ1(1).getR() == 4.0);
		assertTrue(data.getZ1(1).getX() == 3.0);
		assertTrue(data.getZ1(2).getR() == 6.0);
		assertTrue(data.getZ1(2).getX() == 5.0);
		assertTrue(data.getZ2R() == 8.0);
		assertTrue(data.getZ2X() == 7.0);
		assertTrue(data.getZ0R() == 10.0);
		assertTrue(data.getZ0X() == 9.0);
	}
	
	public static void checkBusZ_XoverR_5Points(DistBusData data) {
		assertTrue(data.getZ1(0).getX_R() == 2.0);
		assertTrue(data.getZ1(0).getX() == 1.0);
		assertTrue(data.getZ1(1).getX_R() == 4.0);
		assertTrue(data.getZ1(1).getX() == 3.0);
		assertTrue(Math.abs(data.getZ1(2).getX_R()-6.0) < 0.00001);
		assertTrue(data.getZ1(2).getX() == 5.0);
		assertTrue(data.getZ2R() == 8.0);
		assertTrue(data.getZ2X() == 7.0);
		assertTrue(data.getZ0R() == 10.0);
		assertTrue(data.getZ0X() == 9.0);
	}

	public static void setSolidGrounding(NamedComponentFinder finder, JDialog dialog) {
	    TestUI_UtilFunc.radioButtonAction(finder, dialog, "solidGRadioButton");
	    TestUI_UtilFunc.checkTextFieldStatus(finder, dialog, "gRTextField", false);
	    TestUI_UtilFunc.checkTextFieldStatus(finder, dialog, "gXTextField", false);
	}
	
	public static void setUnGrounding(NamedComponentFinder finder, JDialog dialog) {
	    TestUI_UtilFunc.radioButtonAction(finder, dialog, "unGRadioButton");
	    TestUI_UtilFunc.checkTextFieldStatus(finder, dialog, "gRTextField", false);
	    TestUI_UtilFunc.checkTextFieldStatus(finder, dialog, "gXTextField", false);
	}

	public static void setZGrounding(NamedComponentFinder finder, JDialog dialog) {
	    TestUI_UtilFunc.radioButtonAction(finder, dialog, "zGRadioButton");
	    TestUI_UtilFunc.setTextField(finder, dialog, "gRTextField", "1.0");
	    TestUI_UtilFunc.setTextField(finder, dialog, "gXTextField", "2.0");
	}

	public static void checkSolidGrounding(DistBusData data) {
		assertTrue(data.getGround().getCode().equals(ScGroundType.GType_SolidGrounded));
	}

	public static void checkUnGrounding(DistBusData data) {
		assertTrue(data.getGround().getCode().equals(ScGroundType.GType_Ungrounded));
	}

	public static void checkZGrounding(DistBusData data) {
		assertTrue(data.getGround().getCode().equals(ScGroundType.GType_ZGrounded));
		assertTrue(data.getGround().getR() == 1.0);
		assertTrue(data.getGround().getX() == 2.0);
	}
	
	// Create testing network
	// ======================
	
	public static void createTestingAclfGNetForm(GFormContainer netContainer) {
		GNetForm form = (GNetForm)netContainer.getGNetForm();
		createTestingAcscGNetForm(netContainer);
		form.setNetType(IGNetForm.NetType_AclfNetwork);
		form.getAcscNetData().setHasAdjustment(false);
	}
	
	public static void createTestingAclfAdjGNetForm(GFormContainer netContainer) {
		GNetForm form = (GNetForm)netContainer.getGNetForm();
		createTestingAcscGNetForm(netContainer);
		form.setNetType(IGNetForm.NetType_AclfAdjNetwork);
		form.getAcscNetData().setHasAdjustment(true);
	}

	public static void createTestingAcscGNetForm(GFormContainer netContainer) {
		GNetForm form = (GNetForm)netContainer.getGNetForm();
		
		form.setAppType(IGNetForm.AppType_Transmission);
		form.setNetType(IGNetForm.NetType_AcscNetwork);	
		
		InitDataUtil.initScData_AcscNet(form);
		form.getAcscNetData().setHasAclfData(true);
		
		GBusForm bus1 = new GBusForm("0001", IGNetForm.AppType_Transmission);
		bus1.setName("Bus1");
		InitDataUtil.initScData_AcscBus(form.getAcscNetData(), bus1);
		netContainer.addGBusForm(bus1);

		GBusForm bus2 = new GBusForm("0002", IGNetForm.AppType_Transmission);
		bus2.setName("Bus2");
		InitDataUtil.initScData_AcscBus(form.getAcscNetData(), bus2);
		netContainer.addGBusForm(bus2);

		GBranchForm branch = new GBranchForm("0001->0002", IGNetForm.AppType_Transmission);
		branch.setFromId("0001");
		branch.setToId("0002");
		branch.setFromBusName("Bus1");
		branch.setToBusName("Bus2");
		branch.setName("Branch1");
		branch.getAcscBranchData().setLfCode(IGBranchForm.TransBranchLfCode_Line);
		InitDataUtil.initScData_AcscBranch(branch);
		netContainer.addGBranchForm(branch);
		//System.out.println(branch.toString());
	}
	
	public static void createTestingDStabGNetForm(GFormContainer netContainer) {
		GNetForm form = (GNetForm)netContainer.getGNetForm();
		
		form.setAppType(IGNetForm.AppType_Transmission);
		form.setNetType(IGNetForm.NetType_DStabilityNet);	
		
		InitDataUtil.initScData_DStabNet(form);
		
		GBusForm bus1 = new GBusForm("0001", IGNetForm.AppType_Transmission);
		bus1.setName("Bus1");
		InitDataUtil.initScData_DStabBus(form.getDStabNetData(), bus1);
		netContainer.addGBusForm(bus1);

		GBusForm bus2 = new GBusForm("0002", IGNetForm.AppType_Transmission);
		bus2.setName("Bus2");
		InitDataUtil.initScData_DStabBus(form.getDStabNetData(), bus2);
		netContainer.addGBusForm(bus2);

		GBranchForm branch = new GBranchForm("0001->0002", IGNetForm.AppType_Transmission);
		branch.setFromId("0001");
		branch.setToId("0002");
		branch.setName("Branch1");
		branch.getAcscBranchData().setLfCode(IGBranchForm.TransBranchLfCode_Line);
		InitDataUtil.initScData_DStabBranch(branch);
		netContainer.addGBranchForm(branch);
	}	

	public static void createTestingDistGNetForm(GFormContainer netContainer) {
		GNetForm form = (GNetForm)netContainer.getGNetForm();
		
		form.setAppType(IGNetForm.AppType_Distribution);
		form.setNetType(IGNetForm.NetType_AcscNetwork);	
		
		InitDataUtil.initScData_DistNet(form);
		
		GBusForm bus1 = new GBusForm("0001", IGNetForm.AppType_Distribution);
		bus1.setName("Bus1");
		InitDataUtil.initScData_DistBus(form.getDistNetData(), bus1);
		netContainer.addGBusForm(bus1);

		GBusForm bus2 = new GBusForm("0002", IGNetForm.AppType_Distribution);
		bus2.setName("Bus2");
		InitDataUtil.initScData_DistBus(form.getDistNetData(), bus2);
		netContainer.addGBusForm(bus2);

		GBranchForm branch = new GBranchForm("0001->0002", IGNetForm.AppType_Distribution);
		branch.setFromId("0001");
		branch.setToId("0002");
		branch.setFromBusName("Bus1");
		branch.setToBusName("Bus2");
		branch.setName("Branch1");
		branch.getDistBranchData().setBranchCode(IGBranchForm.DistBranchCode_Feeder);
		InitDataUtil.initScData_DistBranch(form.getDistNetData(), branch);
		netContainer.addGBranchForm(branch);
		//System.out.println(branch.toString());
	}
	
	public static void loadAclf5BusSample(JGraph graph, IPSSMsgHub msg) {
		try {
			String filename = JGraphEditorTestFilePath+"Aclf5Bus.ipss";
			graph = IOUtilFunc.loadIpssGraphFile(filename);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

