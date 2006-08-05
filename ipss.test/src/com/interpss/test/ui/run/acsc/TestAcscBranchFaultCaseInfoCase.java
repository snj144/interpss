package com.interpss.test.ui.run.acsc;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.interpss.editor.app.AppSimuContextImpl;
import com.interpss.editor.data.acsc.AcscFaultData;
import com.interpss.editor.data.proj.AcscCaseData;
import com.interpss.editor.data.proj.CaseData;
import com.interpss.editor.data.proj.ProjData;
import com.interpss.editor.runAct.AcscRunForm;
import com.interpss.editor.ui.SimuAppSpringAppContext;
import com.interpss.editor.ui.SimuAppSpringAppCtxUtil;
import com.interpss.editor.ui.run.NBCaseInfoDialog;
import com.interpss.test.ui.TestUI_UtilFunc;
import com.interpss.test.ui.run.TestCaseInfoBase;

import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.*;

public class TestAcscBranchFaultCaseInfoCase extends TestCaseInfoBase {
	public void testBranchFault3PCase() {
		System.out.println("TestAcscBranchFaultCaseInfoCase testBranchFault3PCase begin");

		TestUI_UtilFunc.createTestingAcscGNetForm(netContainer);
		
	    AppSimuContextImpl appSimuCtx = (AppSimuContextImpl)editor.getAppSimuContext();
	    
	    NBCaseInfoDialog caseDialog = (NBCaseInfoDialog)SimuAppSpringAppCtxUtil.getCaseInfoDialog(
				CaseData.CaseType_Acsc, netContainer, appSimuCtx, false);

		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "casenameComboBox" );
		JComboBox casenameComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		casenameComboBox.setSelectedIndex(0); // at this point, a case "Acsc Analysis Case" has been created
		
	    TestUI_UtilFunc.radioButtonAction(finder, caseDialog, "branchFaultRadioButton");
	    TestUI_UtilFunc.setTextField(finder, caseDialog, "distanceTextField", "50.0");
	    
		// click the Run button
		finder.setName("runButton");		
	    JButton runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
	    assertTrue(caseDialog.isReturnOk());

		ProjData projData = (ProjData)appSimuCtx.getProjData();
		assertTrue(projData.getAcscCaseName().equals("Acsc Analysis Case"));
		
		// At this point, we have two ways to access the AclfCaseData
		// 1: From the projData.caseList
		CaseData caseData = appSimuCtx.getCaseData("Acsc Analysis Case", CaseData.CaseType_Acsc);
		assertNotNull(caseData);
		AcscCaseData acscCaseData = caseData.getAcscCaseData();
		assertNotNull(acscCaseData);
		assertTrue(acscCaseData.getFaultData().getType().equals(AcscFaultData.FaultType_Branch));
		assertTrue(acscCaseData.getFaultData().getBusId().equals("0001->0002"));
		assertTrue(acscCaseData.getFaultData().getDistance() == 50.0);
		
		// 2: through the current case hold by the AclfRunForm object
		AcscRunForm runForm = SimuAppSpringAppContext.getAcscRunForm();
		acscCaseData = runForm.getAcscCaseData();    
			// ref the current case data, which is the same as the one
			// hold by CaaseData
		assertNotNull(acscCaseData);
		assertTrue(acscCaseData.getFaultData().getType().equals(AcscFaultData.FaultType_Branch));
		assertTrue(acscCaseData.getFaultData().getBusId().equals("0001->0002"));
		assertTrue(acscCaseData.getFaultData().getDistance() == 50.0);

		// launch the editor again
		caseDialog.init(netContainer, appSimuCtx);
		finder.setName("runButton");		
	    runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );
	    
		assertTrue(projData.getAcscCaseName().equals("Acsc Analysis Case"));
		caseData = appSimuCtx.getCaseData("Acsc Analysis Case", CaseData.CaseType_Acsc);
		assertNotNull(caseData);
		acscCaseData = caseData.getAcscCaseData();
		assertNotNull(acscCaseData);
		assertTrue(acscCaseData.getFaultData().getType().equals(AcscFaultData.FaultType_Branch));
		assertTrue(acscCaseData.getFaultData().getBusId().equals("0001->0002"));
		assertTrue(acscCaseData.getFaultData().getDistance() == 50.0);	    
	    
		System.out.println("TestAcscBranchFaultCaseInfoCase testBranchFault3PCase end");
	}
	
	public void testMuitiCase() {
		System.out.println("TestAcscBranchFaultCaseInfoCase testMuitiCase begin");

		TestUI_UtilFunc.createTestingAcscGNetForm(netContainer);
		
	    AppSimuContextImpl appSimuCtx = (AppSimuContextImpl)editor.getAppSimuContext();
	    
	    NBCaseInfoDialog caseDialog = (NBCaseInfoDialog)SimuAppSpringAppCtxUtil.getCaseInfoDialog(
				CaseData.CaseType_Acsc, netContainer, appSimuCtx, false);

		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "casenameComboBox" );
		JComboBox casenameComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		casenameComboBox.setSelectedIndex(0); // at this point, a case "Acsc Analysis Case" has been created
		
		// first case is a BusFault case
	    finder.setName( "busFaultRadioButton" );
	    JRadioButton busFaultRadioButton = ( JRadioButton ) finder.find( caseDialog, 0 );
	    busFaultRadioButton.doClick();

	    finder.setName( "typeLLRadioButton" );
	    JRadioButton typeLLRadioButton = ( JRadioButton ) finder.find( caseDialog, 0 );
	    typeLLRadioButton.doClick(); 
	    
		// click the Cancel button
		finder.setName("runButton");		
	    JButton runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
	    assertTrue(caseDialog.isReturnOk());

		ProjData projData = (ProjData)appSimuCtx.getProjData();
		assertTrue(projData.getAcscCaseName().equals("Acsc Analysis Case"));

		CaseData caseData = appSimuCtx.getCaseData("Acsc Analysis Case", CaseData.CaseType_Acsc);
		assertNotNull(caseData);
		AcscCaseData acscCaseData = caseData.getAcscCaseData();
		assertNotNull(acscCaseData);
		assertTrue(acscCaseData.getFaultData().getType().equals(AcscFaultData.FaultType_Bus));
		
		// launch the dialog again
		caseDialog.init(netContainer, appSimuCtx);
		
		// 2nd case: "A New Case", PQ method
		finder = new NamedComponentFinder(JComponent.class, "casenameComboBox" );
		casenameComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		casenameComboBox.addItem("A New Acsc Case"); 
		casenameComboBox.setSelectedItem("A New Acsc Case"); 
		
		// click the AddCase button
	    finder.setName( "addCaseButton" );
	    JButton addCaseButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, addCaseButton ) );
	    
	    // we should have 2 cases now
	    assertTrue(appSimuCtx.getProjData().getCaseList().size() == 2);

		// first case is a BranchFault case
	    finder.setName( "branchFaultRadioButton" );
	    JRadioButton branchFaultRadioButton = ( JRadioButton ) finder.find( caseDialog, 0 );
	    branchFaultRadioButton.doClick();

	    finder.setName( "typeLGRadioButton" );
	    JRadioButton typeLGRadioButton = ( JRadioButton ) finder.find( caseDialog, 0 );
	    typeLGRadioButton.doClick(); 
	    
	    finder.setName( "distanceTextField" );
	    JTextField distanceTextField = ( JTextField ) finder.find( caseDialog, 0 );
	    distanceTextField.setText("50.0");
	    
	    // save the 2nd case
	    finder.setName( "runButton" );
	    runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
		assertTrue(caseDialog.isReturnOk());
		
		// check current case name
		assertTrue(projData.getAcscCaseName().equals("A New Acsc Case"));
		
		// check current case data
		AcscRunForm runForm = SimuAppSpringAppContext.getAcscRunForm();
		acscCaseData = runForm.getAcscCaseData();    
		assertNotNull(acscCaseData);
		assertTrue(acscCaseData.getFaultData().getType().equals(AcscFaultData.FaultType_Branch));

		// new we should have two cases in the projData.caseList
		// this is a BusFault, LL
		caseData = appSimuCtx.getCaseData("Acsc Analysis Case", CaseData.CaseType_Acsc);
		assertNotNull(caseData);
		acscCaseData = caseData.getAcscCaseData();
		assertNotNull(acscCaseData);
		assertTrue(acscCaseData.getFaultData().getType().equals(AcscFaultData.FaultType_Bus));
		assertTrue(acscCaseData.getFaultData().getCategory().equals(AcscFaultData.FaultCaty_LL));
		
		// this is a BranchFault, LG, distance 50%
		caseData = appSimuCtx.getCaseData("A New Acsc Case", CaseData.CaseType_Acsc);
		assertNotNull(caseData);
		acscCaseData = caseData.getAcscCaseData();
		assertNotNull(acscCaseData);
		assertTrue(acscCaseData.getFaultData().getType().equals(AcscFaultData.FaultType_Branch));
		assertTrue(acscCaseData.getFaultData().getCategory().equals(AcscFaultData.FaultCaty_LG));
		assertTrue(acscCaseData.getFaultData().getDistance() == 50.0);

		System.out.println("TestAcscBranchFaultCaseInfoCase testMuitiCase end");
	}
}

