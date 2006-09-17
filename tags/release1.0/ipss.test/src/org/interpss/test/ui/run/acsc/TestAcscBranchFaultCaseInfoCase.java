 /*
  * @(#)TestAcscBranchFaultCaseInfoCase.java   
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

package org.interpss.test.ui.run.acsc;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.NamedComponentFinder;

import org.interpss.editor.SimuAppSpringAppContext;
import org.interpss.editor.SimuAppSpringAppCtxUtil;
import org.interpss.editor.data.acsc.AcscFaultData;
import org.interpss.editor.data.proj.AcscCaseData;
import org.interpss.editor.data.proj.CaseData;
import org.interpss.editor.data.proj.ProjData;
import org.interpss.editor.runAct.AcscRunForm;
import org.interpss.editor.ui.run.NBCaseInfoDialog;
import org.interpss.test.ui.TestUI_UtilFunc;
import org.interpss.test.ui.run.TestCaseInfoBase;


public class TestAcscBranchFaultCaseInfoCase extends TestCaseInfoBase {
	public void testBranchFault3PCase() {
		System.out.println("TestAcscBranchFaultCaseInfoCase testBranchFault3PCase begin");

		TestUI_UtilFunc.createTestingAcscGNetForm(netContainer);
		
	    NBCaseInfoDialog caseDialog = (NBCaseInfoDialog)SimuAppSpringAppCtxUtil.getCaseInfoDialog(
				CaseData.CaseType_Acsc, netContainer, appSimuCtx, false);

		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "casenameComboBox" );
		JComboBox casenameComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		casenameComboBox.setSelectedIndex(0); // at this point, a case "Acsc Analysis Case" has been created
		
	    TestUI_UtilFunc.radioButtonClickAction(finder, caseDialog, "branchFaultRadioButton");
	    TestUI_UtilFunc.setTextField(finder, caseDialog, "distanceTextField", "50.0");
	    
		// click the Run button
		finder.setName("runButton");		
	    JButton runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );
		assertTrue(appSimuCtx.getProjData().isDirty());
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
		assertTrue(appSimuCtx.getProjData().isDirty());
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
	    // Currently, we only allow one case
	    //System.out.println("----->" + appSimuCtx.getProjData().getCaseList().size());
	    assertTrue(appSimuCtx.getProjData().getCaseList().size() == 1);

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
		assertTrue(appSimuCtx.getProjData().isDirty());
		assertTrue(caseDialog.isReturnOk());
		
		// check current case name
	    //System.out.println("----->" + projData.getAcscCaseName());
		assertTrue(projData.getAcscCaseName().equals("Acsc Analysis Case"));
		
		// check current case data
		AcscRunForm runForm = SimuAppSpringAppContext.getAcscRunForm();
		acscCaseData = runForm.getAcscCaseData();    
		assertNotNull(acscCaseData);
		assertTrue(acscCaseData.getFaultData().getType().equals(AcscFaultData.FaultType_Branch));
/*
		// now we should have two cases in the projData.caseList
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
*/
		System.out.println("TestAcscBranchFaultCaseInfoCase testMuitiCase end");
	}
}

