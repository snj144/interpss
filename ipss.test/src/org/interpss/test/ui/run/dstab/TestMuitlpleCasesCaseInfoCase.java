package org.interpss.test.ui.run.dstab;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextArea;

import org.interpss.editor.SimuAppSpringAppCtxUtil;
import org.interpss.editor.data.proj.CaseData;
import org.interpss.editor.form.GFormContainer;
import org.interpss.editor.ui.run.NBCaseInfoDialog;
import org.interpss.test.ui.TestUI_UtilFunc;
import org.interpss.test.ui.run.TestCaseInfoBase;

import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.NamedComponentFinder;


public class TestMuitlpleCasesCaseInfoCase extends TestCaseInfoBase {

	public void testAddDeleteCaseCase() {
		System.out.println("TestMuitlpleEventsCaseInfoCase testAddDeleteCaseCase begin");

		TestUI_UtilFunc.createTestingDStabGNetForm((GFormContainer)netContainer);

		NBCaseInfoDialog caseDialog = (NBCaseInfoDialog)SimuAppSpringAppCtxUtil.getCaseInfoDialog(
				CaseData.CaseType_DStab, netContainer, appSimuCtx, false);

		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "casenameComboBox" );
		JComboBox casenameComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		casenameComboBox.setSelectedIndex(0); // at this point, a case "Transient Stability Case" has been created

	    finder.setName( "descTextArea" );
	    JTextArea descTextArea = ( JTextArea ) finder.find( caseDialog, 0 );
	    descTextArea.setText("My 1st Case Desc Name");
	    
		// click the Run button
		finder.setName("runButton");		
	    JButton runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );
	    
	    // launch the dialog again
		caseDialog.init(netContainer, appSimuCtx);

		// click the AddCase button
	    finder.setName( "addCaseButton" );
	    JButton addCaseButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, addCaseButton ) );

	    // we should have 2 cases
		assertTrue(casenameComboBox.getItemCount() == 2); 
	    
		casenameComboBox.setSelectedIndex(0);
		casenameComboBox.setSelectedItem("My 2nd Case");
		System.out.println("1st case: " + casenameComboBox.getSelectedItem());

	    finder.setName( "descTextArea" );
	    descTextArea = ( JTextArea ) finder.find( caseDialog, 0 );
	    descTextArea.setText("My 2nd Case Desc Name");
	    
		// click the Run button
		finder.setName("runButton");		
	    runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );
	    
		CaseData caseData = appSimuCtx.getCaseData("Transient Stability Case", CaseData.CaseType_DStab);
		assertNotNull(caseData);
		assertTrue(caseData.getDescription().equals("My 1st Case Desc Name"));
		
		caseData = appSimuCtx.getCaseData("My 2nd Case", CaseData.CaseType_DStab);
		assertNotNull(caseData);
		assertTrue(caseData.getDescription().equals("My 2nd Case Desc Name"));

		System.out.println("TestMuitlpleEventsCaseInfoCase testAddDeleteCaseCase end");
	}
}

