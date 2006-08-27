package org.interpss.test.ui.run.aclf;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

import org.interpss.editor.SimuAppSpringAppContext;
import org.interpss.editor.SimuAppSpringAppCtxUtil;
import org.interpss.editor.data.proj.AclfCaseData;
import org.interpss.editor.data.proj.CaseData;
import org.interpss.editor.data.proj.ProjData;
import org.interpss.editor.runAct.AclfRunForm;
import org.interpss.editor.ui.run.NBCaseInfoDialog;
import org.interpss.test.ui.TestUI_UtilFunc;
import org.interpss.test.ui.run.TestCaseInfoBase;

import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.NamedComponentFinder;


public class TestAclfCaseInfoCase extends TestCaseInfoBase {
	public void testNRCase() {
		System.out.println("TesAclfCaseInfoCase testNRCase begin");

	    NBCaseInfoDialog caseDialog = (NBCaseInfoDialog)SimuAppSpringAppCtxUtil.getCaseInfoDialog(
				CaseData.CaseType_Aclf, netContainer, appSimuCtx, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "casenameComboBox" );
		JComboBox casenameComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		casenameComboBox.setSelectedIndex(0); // at this point, a case "Aclf Analysis Case" has been created
		
	    TestUI_UtilFunc.setTextArea(finder, caseDialog, "descTextArea", "My Case Desc Name");
	    TestUI_UtilFunc.radioButtonAction(finder, caseDialog, "nrRadioButton");
	    TestUI_UtilFunc.setTextField(finder, caseDialog, "errPUTextField", "0.0001");
	    TestUI_UtilFunc.setTextField(finder, caseDialog, "maxItrTextField", "20");
	    TestUI_UtilFunc.checkBoxAction(finder, caseDialog, "initVoltCheckBox", true);
	    TestUI_UtilFunc.checkBoxAction(finder, caseDialog, "lfSummaryCheckBox", true);
	    
	    finder.setName( "runButton" );
	    JButton runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );
		assertTrue(appSimuCtx.getProjData().isDirty());
		assertTrue(caseDialog.isReturnOk());
		
		ProjData projData = (ProjData)appSimuCtx.getProjData();
		assertTrue(projData.getAclfCaseName().equals("Aclf Analysis Case"));
		CaseData caseData = appSimuCtx.getCaseData("Aclf Analysis Case", CaseData.CaseType_Aclf);
		assertNotNull(caseData);
		AclfCaseData aclfCaseData = caseData.getAclfCaseData();
		assertNotNull(aclfCaseData);
		assertTrue(aclfCaseData.getMethod().equals(AclfCaseData.Method_NR));
		assertTrue(aclfCaseData.getTolerance() == 0.0001);
		assertTrue(aclfCaseData.getMaxIteration() == 20);
		assertTrue(aclfCaseData.getShowSummary());
		assertTrue(aclfCaseData.getInitBusVolt());
		
		AclfRunForm runForm = SimuAppSpringAppContext.getAclfRunForm();
		aclfCaseData = runForm.getAclfCaseData();    
			// ref the current case data, which is the same as the one
			// hold by CaaseData
		assertNotNull(aclfCaseData);
		assertTrue(aclfCaseData.getMethod().equals(AclfCaseData.Method_NR));
		assertTrue(aclfCaseData.getTolerance() == 0.0001);
		assertTrue(aclfCaseData.getMaxIteration() == 20);
		assertTrue(aclfCaseData.getShowSummary());
		assertTrue(aclfCaseData.getInitBusVolt());
	
		// launch the editor again
		caseDialog.init(netContainer, appSimuCtx);

	    finder.setName( "runButton" );
	    runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );
	
		assertTrue(projData.getAclfCaseName().equals("Aclf Analysis Case"));
		caseData = appSimuCtx.getCaseData("Aclf Analysis Case", CaseData.CaseType_Aclf);
		assertNotNull(caseData);
		aclfCaseData = caseData.getAclfCaseData();
		assertNotNull(aclfCaseData);
		assertTrue(aclfCaseData.getMethod().equals(AclfCaseData.Method_PQ));
		assertTrue(aclfCaseData.getTolerance() == 0.0001);
		assertTrue(aclfCaseData.getMaxIteration() == 20);
		assertTrue(aclfCaseData.getShowSummary());
		assertTrue(aclfCaseData.getInitBusVolt());
		
		System.out.println("TesAclfCaseInfoCase testNRCase end");
	}

	public void testPQCase() {
		System.out.println("TesAclfCaseInfoCase testPQCase begin");

		NBCaseInfoDialog caseDialog = (NBCaseInfoDialog)SimuAppSpringAppCtxUtil.getCaseInfoDialog(
				CaseData.CaseType_Aclf, netContainer, appSimuCtx, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "casenameComboBox" );
		JComboBox casenameComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		casenameComboBox.setSelectedIndex(0); // at this point, a case "Aclf Analysis Case" has been created
		
	    TestUI_UtilFunc.radioButtonAction(finder, caseDialog, "pqRadioButton");
	    TestUI_UtilFunc.checkBoxAction(finder, caseDialog, "initVoltCheckBox", false);
	    TestUI_UtilFunc.checkBoxAction(finder, caseDialog, "lfSummaryCheckBox", false);
	    
	    finder.setName( "runButton" );
	    JButton runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );
		assertTrue(appSimuCtx.getProjData().isDirty());
		assertTrue(caseDialog.isReturnOk());
		
		ProjData projData = (ProjData)appSimuCtx.getProjData();
		assertTrue(projData.getAclfCaseName().equals("Aclf Analysis Case"));
		CaseData caseData = appSimuCtx.getCaseData("Aclf Analysis Case", CaseData.CaseType_Aclf);
		assertNotNull(caseData);
		AclfCaseData aclfCaseData = caseData.getAclfCaseData();
		assertNotNull(aclfCaseData);
		assertTrue(aclfCaseData.getMethod().equals(AclfCaseData.Method_PQ));
		assertTrue(!aclfCaseData.getShowSummary());
		assertTrue(!aclfCaseData.getInitBusVolt());
		
		AclfRunForm runForm = SimuAppSpringAppContext.getAclfRunForm();
		aclfCaseData = runForm.getAclfCaseData();    
			// ref the current case data, which is the same as the one
			// hold by CaaseData
		assertNotNull(aclfCaseData);
		assertTrue(aclfCaseData.getMethod().equals(AclfCaseData.Method_PQ));
		assertTrue(!aclfCaseData.getShowSummary());
		assertTrue(!aclfCaseData.getInitBusVolt());

		// launch the editor again
		caseDialog.init(netContainer, appSimuCtx);

	    finder.setName( "runButton" );
	    runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );
	    
		assertTrue(projData.getAclfCaseName().equals("Aclf Analysis Case"));
		caseData = appSimuCtx.getCaseData("Aclf Analysis Case", CaseData.CaseType_Aclf);
		assertNotNull(caseData);
		aclfCaseData = caseData.getAclfCaseData();
		assertNotNull(aclfCaseData);
		assertTrue(aclfCaseData.getMethod().equals(AclfCaseData.Method_PQ));
		assertTrue(!aclfCaseData.getShowSummary());
		assertTrue(!aclfCaseData.getInitBusVolt());
		
		System.out.println("TesAclfCaseInfoCase testPQCase end");
	}

	public void testGSCase() {
		System.out.println("TesAclfCaseInfoCase testGSCase begin");

		NBCaseInfoDialog caseDialog = (NBCaseInfoDialog)SimuAppSpringAppCtxUtil.getCaseInfoDialog(
				CaseData.CaseType_Aclf, netContainer, appSimuCtx, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "casenameComboBox" );
		JComboBox casenameComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		casenameComboBox.setSelectedIndex(0); // at this point, a case "Aclf Analysis Case" has been created
		
	    TestUI_UtilFunc.radioButtonAction(finder, caseDialog, "gsRadioButton");

	    finder.setName( "accFactorTextField" );
	    JTextField accFactorTextField = ( JTextField ) finder.find( caseDialog, 0 );
	    accFactorTextField.setEnabled(true);
	    accFactorTextField.setText("2.0");
	    
	    finder.setName( "runButton" );
	    JButton runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );
		assertTrue(appSimuCtx.getProjData().isDirty());
		assertTrue(caseDialog.isReturnOk());
		
		ProjData projData = (ProjData)appSimuCtx.getProjData();
		assertTrue(projData.getAclfCaseName().equals("Aclf Analysis Case"));
		CaseData caseData = appSimuCtx.getCaseData("Aclf Analysis Case", CaseData.CaseType_Aclf);
		assertNotNull(caseData);
		AclfCaseData aclfCaseData = caseData.getAclfCaseData();
		assertNotNull(aclfCaseData);
		assertTrue(aclfCaseData.getMethod().equals(AclfCaseData.Method_GS));
		assertTrue(aclfCaseData.getAccFactor() == 2.0);
		
		AclfRunForm runForm = SimuAppSpringAppContext.getAclfRunForm();
		aclfCaseData = runForm.getAclfCaseData();    
			// ref the current case data, which is the same as the one
			// hold by CaaseData
		assertNotNull(aclfCaseData);
		assertTrue(aclfCaseData.getMethod().equals(AclfCaseData.Method_GS));
		assertTrue(aclfCaseData.getAccFactor() == 2.0);

		// launch the editor again
		caseDialog.init(netContainer, appSimuCtx);

	    finder.setName( "runButton" );
	    runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );

		assertTrue(projData.getAclfCaseName().equals("Aclf Analysis Case"));
		caseData = appSimuCtx.getCaseData("Aclf Analysis Case", CaseData.CaseType_Aclf);
		assertNotNull(caseData);
		aclfCaseData = caseData.getAclfCaseData();
		assertNotNull(aclfCaseData);
		assertTrue(aclfCaseData.getMethod().equals(AclfCaseData.Method_PQ));
		assertTrue(aclfCaseData.getAccFactor() == 2.0);
		
		System.out.println("TesAclfCaseInfoCase testGSCase end");
	}
}

