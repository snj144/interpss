package com.interpss.test.ui.run;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.NamedComponentFinder;

import com.interpss.editor.SimuAppSpringAppContext;
import com.interpss.editor.SimuAppSpringAppCtxUtil;
import com.interpss.editor.data.proj.AclfCaseData;
import com.interpss.editor.data.proj.CaseData;
import com.interpss.editor.data.proj.ProjData;
import com.interpss.editor.runAct.AclfRunForm;
import com.interpss.editor.ui.run.NBCaseInfoDialog;

public class TestCaseInfoDialogCase extends TestCaseInfoBase {
	public void testRunCase() {
		System.out.println("TesAddDeleteCaseInfoCase testRunCase begin");
		
		NBCaseInfoDialog caseDialog = (NBCaseInfoDialog)SimuAppSpringAppCtxUtil.getCaseInfoDialog(
				CaseData.CaseType_Aclf, netContainer, appSimuCtx, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "casenameComboBox" );
		JComboBox casenameComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		casenameComboBox.setSelectedIndex(0); // at this point, a case "Acsc Analysis Case" has been created
		
	    finder.setName( "descTextArea" );
	    JTextArea descTextArea = ( JTextArea ) finder.find( caseDialog, 0 );
	    descTextArea.setText("My Case Desc Name");
	    
		// click the run button
		finder.setName("runButton");		
	    JButton runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );
		assertTrue(appSimuCtx.getProjData().isDirty());
	    assertTrue(caseDialog.isReturnOk());

	    ProjData projData = (ProjData)appSimuCtx.getProjData();
		assertTrue(projData.getAclfCaseName().equals("Aclf Analysis Case"));
		
		// At this point, we have two ways to access the AclfCaseData
		// 1: From the projData.caseList
		CaseData caseData = appSimuCtx.getCaseData("Aclf Analysis Case", CaseData.CaseType_Aclf);
		assertNotNull(caseData);
		AclfCaseData aclfCaseData = caseData.getAclfCaseData();
		assertNotNull(aclfCaseData);
		assertTrue(caseData.getDescription().equals("My Case Desc Name"));
		
		// 2: through the current case hold by the AclfRunForm object
		AclfRunForm runForm = SimuAppSpringAppContext.getAclfRunForm();
		aclfCaseData = runForm.getAclfCaseData();    
			// ref the current case data, which is the same as the one
			// hold by CaaseData
		assertNotNull(aclfCaseData);

		// launch the edtior again
		caseDialog.init(netContainer, appSimuCtx);

		// click the run button
		finder.setName("runButton");		
	    runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );
	    
		assertTrue(projData.getAclfCaseName().equals("Aclf Analysis Case"));
		caseData = appSimuCtx.getCaseData("Aclf Analysis Case", CaseData.CaseType_Aclf);
		assertNotNull(caseData);
		aclfCaseData = caseData.getAclfCaseData();
		assertNotNull(aclfCaseData);
		assertTrue(caseData.getDescription().equals("My Case Desc Name"));

		System.out.println("TesAddDeleteCaseInfoCase testRunCase end");
	}
	
	// add case currently has been disabled	
	public void xtestAddCase() {
		System.out.println("TesAddDeleteCaseInfoCase testAddCase begin");
		
	    NBCaseInfoDialog caseDialog = (NBCaseInfoDialog)SimuAppSpringAppCtxUtil.getCaseInfoDialog(
				CaseData.CaseType_Aclf, netContainer, appSimuCtx, false);
		
		// first case: "Aclf Analysis Case", NR method
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "casenameComboBox" );
		JComboBox casenameComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		casenameComboBox.setSelectedIndex(0); // at this point, a case "Aclf Analysis Case" has been created
		
	    finder.setName( "nrRadioButton" );
	    JRadioButton nrRadioButton = ( JRadioButton ) finder.find( caseDialog, 0 );
	    nrRadioButton.doClick();

	    // save the first case
	    finder.setName( "runButton" );
	    JButton runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );
		assertTrue(appSimuCtx.getProjData().isDirty());
		assertTrue(caseDialog.isReturnOk());
		
	    ProjData projData = (ProjData)appSimuCtx.getProjData();
		assertTrue(projData.getAclfCaseName().equals("Aclf Analysis Case"));

		AclfRunForm runForm = SimuAppSpringAppContext.getAclfRunForm();
		AclfCaseData aclfCaseData = runForm.getAclfCaseData();    
		assertTrue(aclfCaseData.getMethod().equals(AclfCaseData.Method_NR));

		// launch the dialog again
		caseDialog.init(netContainer, appSimuCtx);
		
		// 2nd case: "A New Case", PQ method
		finder = new NamedComponentFinder(JComponent.class, "casenameComboBox" );
		casenameComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		casenameComboBox.addItem("A New Case"); 
		casenameComboBox.setSelectedItem("A New Case"); 
		
		// click the AddCase button
	    finder.setName( "addCaseButton" );
	    JButton addCaseButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, addCaseButton ) );
	    
	    // we should have 2 cases now
	    assertTrue(appSimuCtx.getProjData().getCaseList().size() == 2);
		
	    // select the PQ method
	    finder.setName( "pqRadioButton" );
	    JRadioButton pqRadioButton = ( JRadioButton ) finder.find( caseDialog, 0 );
	    pqRadioButton.doClick();
	    
	    // save the 2nd case
	    finder.setName( "runButton" );
	    runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );
		assertTrue(appSimuCtx.getProjData().isDirty());
		assertTrue(caseDialog.isReturnOk());
		
		// check current case name
		assertTrue(projData.getAclfCaseName().equals("A New Case"));
		
		// check current case data
		aclfCaseData = runForm.getAclfCaseData();    
		assertTrue(aclfCaseData.getMethod().equals(AclfCaseData.Method_PQ));

		// Retrieve the first case
		CaseData caseData = appSimuCtx.getCaseData("Aclf Analysis Case", CaseData.CaseType_Aclf);
		assertNotNull(caseData);
		assertTrue(caseData.getAclfCaseData().getMethod().equals(AclfCaseData.Method_NR));

		// Retrive the 2nd case
		caseData = appSimuCtx.getCaseData("A New Case", CaseData.CaseType_Aclf);
		assertNotNull(caseData);
		assertTrue(caseData.getAclfCaseData().getMethod().equals(AclfCaseData.Method_PQ));
		
		System.out.println("TesAddDeleteCaseInfoCase testAddCase end");
	}

	// delete case currently has been disabled
	public void xtestDeleteCase() {
		System.out.println("TesAddDeleteCaseInfoCase testDeleteCase begin");
		
	    NBCaseInfoDialog caseDialog = (NBCaseInfoDialog)SimuAppSpringAppCtxUtil.getCaseInfoDialog(
				CaseData.CaseType_Aclf, netContainer, appSimuCtx, false);

		// first case: "Aclf Analysis Case"
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "casenameComboBox" );
		JComboBox casenameComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		casenameComboBox.setSelectedIndex(0); // at this point, a case "Aclf Analysis Case" has been created
		
		// 2nd case: "A New Case", 
		casenameComboBox.addItem("A New Case-1"); 
		casenameComboBox.setSelectedItem("A New Case-1"); 
		
		// click the AddCase button
	    finder.setName( "addCaseButton" );
	    JButton addCaseButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, addCaseButton ) );
	    
	    // we should have 2 cases now
	    assertTrue(appSimuCtx.getProjData().getCaseList().size() == 2);

		// 2nd case: "A New Case", 
		casenameComboBox.addItem("A New Case-2"); 
		casenameComboBox.setSelectedItem("A New Case-2"); 
		
	    getHelper().enterClickAndLeave( new MouseEventData( this, addCaseButton ) );
	    
	    // we should have 3 cases now
	    assertTrue(appSimuCtx.getProjData().getCaseList().size() == 3);
	    
	    // select the "A New Case-1" case
		casenameComboBox.setSelectedItem("A New Case-1");
		
		// click the DeleteCase button
	    finder.setName( "deleteCaseButton" );
	    JButton deleteCaseButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, deleteCaseButton ) );

	    // we should have 2 cases now
	    assertTrue(appSimuCtx.getProjData().getCaseList().size() == 2);

		CaseData caseData = appSimuCtx.getCaseData("Aclf Analysis Case", CaseData.CaseType_Aclf);
		assertNotNull(caseData);
		
		caseData = appSimuCtx.getCaseData("A New Case-2", CaseData.CaseType_Aclf);
		assertNotNull(caseData);
		
		System.out.println("TesAddDeleteCaseInfoCase testDeleteCase end");
	}

	public void testCancelCase() {
		System.out.println("TesAddDeleteCaseInfoCase testCancelCase begin");
		
	    NBCaseInfoDialog caseDialog = (NBCaseInfoDialog)SimuAppSpringAppCtxUtil.getCaseInfoDialog(
				CaseData.CaseType_Aclf, netContainer, appSimuCtx, false);

		// click the Cancel button
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "cancelButton" );		
	    JButton cancelButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, cancelButton ) );
	    assertTrue(!caseDialog.isReturnOk());
		
		System.out.println("TesAddDeleteCaseInfoCase testCancelCase end");
	}
}

