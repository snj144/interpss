package org.interpss.test.ui.run.acsc;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;

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


public class TestAcscBusFaultCaseInfoCase extends TestCaseInfoBase {
	public void testBusFault3PCase() {
		System.out.println("TesAcscBusFaultCaseInfoCase testBusFault3PCase begin");

		TestUI_UtilFunc.createTestingAcscGNetForm(netContainer);
		
	    NBCaseInfoDialog caseDialog = (NBCaseInfoDialog)SimuAppSpringAppCtxUtil.getCaseInfoDialog(
				CaseData.CaseType_Acsc, netContainer, appSimuCtx, false);

		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");

		JComboBox casenameComboBox = TestUI_UtilFunc.findComboBox(finder, caseDialog, "casenameComboBox");
		casenameComboBox.setSelectedIndex(0); // at this point, a case "Acsc Analysis Case" has been created
		
	    TestUI_UtilFunc.radioButtonClickAction(finder, caseDialog, "busFaultRadioButton");
	    
	    JComboBox faultBusComboBox = TestUI_UtilFunc.findComboBox(finder, caseDialog, "faultBusComboBox");
		faultBusComboBox.setSelectedIndex(1); 
	    //System.out.println(faultBusComboBox.getSelectedItem());
	    
	    TestUI_UtilFunc.radioButtonClickAction(finder, caseDialog, "type3PRadioButton");
	    TestUI_UtilFunc.setTextField(finder, caseDialog, "rLGTextField", "0.1");
	    TestUI_UtilFunc.setTextField(finder, caseDialog, "xLGTextField", "0.2");
	    TestUI_UtilFunc.radioButtonClickAction(finder, caseDialog, "fixedVoltRadioButton");
	    TestUI_UtilFunc.setTextField(finder, caseDialog, "mFactorTextField", "90.0");
		
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
		assertTrue(acscCaseData.getBusInitVolt().equals(AcscCaseData.ScBusVolt_UnitVolt));
		assertTrue(acscCaseData.getMFactor() == 90.0);
		assertTrue(acscCaseData.getFaultData().getType().equals(AcscFaultData.FaultType_Bus));
		assertTrue(acscCaseData.getFaultData().getBusId().equals("0002"));
		assertTrue(acscCaseData.getFaultData().getCategory().equals(AcscFaultData.FaultCaty_3P));
		assertTrue(acscCaseData.getFaultData().getLG_R() == 0.1);
		assertTrue(acscCaseData.getFaultData().getLG_X() == 0.2);
		
		// 2: through the current case hold by the AclfRunForm object
		AcscRunForm runForm = SimuAppSpringAppContext.getAcscRunForm();
		acscCaseData = runForm.getAcscCaseData();    
			// ref the current case data, which is the same as the one
			// hold by CaaseData
		assertNotNull(acscCaseData);
		assertTrue(acscCaseData.getBusInitVolt().equals(AcscCaseData.ScBusVolt_UnitVolt));
		assertTrue(acscCaseData.getMFactor() == 90.0);
		assertTrue(acscCaseData.getFaultData().getType().equals(AcscFaultData.FaultType_Bus));
		assertTrue(acscCaseData.getFaultData().getBusId().equals("0002"));
		assertTrue(acscCaseData.getFaultData().getCategory().equals(AcscFaultData.FaultCaty_3P));
		assertTrue(acscCaseData.getFaultData().getLG_R() == 0.1);
		assertTrue(acscCaseData.getFaultData().getLG_X() == 0.2);
		
		// launch the editor again
		caseDialog.init(netContainer, appSimuCtx);
		finder.setName("runButton");		
	    runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );		
	    
		assertTrue(projData.getAcscCaseName().equals("Acsc Analysis Case"));
		caseData =appSimuCtx.getCaseData("Acsc Analysis Case", CaseData.CaseType_Acsc);
		assertNotNull(caseData);
		acscCaseData = caseData.getAcscCaseData();
		assertNotNull(acscCaseData);
		assertTrue(acscCaseData.getBusInitVolt().equals(AcscCaseData.ScBusVolt_UnitVolt));
		assertTrue(acscCaseData.getMFactor() == 90.0);
		assertTrue(acscCaseData.getFaultData().getType().equals(AcscFaultData.FaultType_Bus));
		assertTrue(acscCaseData.getFaultData().getBusId().equals("0002"));
		assertTrue(acscCaseData.getFaultData().getCategory().equals(AcscFaultData.FaultCaty_3P));
		assertTrue(acscCaseData.getFaultData().getLG_R() == 0.1);
		assertTrue(acscCaseData.getFaultData().getLG_X() == 0.2);
		
		System.out.println("TesAcscBusFaultCaseInfoCase testBusFault3PCase end");
	}
	
	public void testBusFaultLLGCase() {
		System.out.println("TesAcscBusFaultCaseInfoCase testBusFaultLLGCase begin");

		TestUI_UtilFunc.createTestingAcscGNetForm(netContainer);
		
	    NBCaseInfoDialog caseDialog = (NBCaseInfoDialog)SimuAppSpringAppCtxUtil.getCaseInfoDialog(
				CaseData.CaseType_Acsc, netContainer, appSimuCtx, false);

		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");

		JComboBox casenameComboBox = TestUI_UtilFunc.findComboBox(finder, caseDialog, "casenameComboBox");
		casenameComboBox.setSelectedIndex(0); // at this point, a case "Acsc Analysis Case" has been created
		
	    TestUI_UtilFunc.radioButtonClickAction(finder, caseDialog, "busFaultRadioButton");
	    
	    JComboBox faultBusComboBox = TestUI_UtilFunc.findComboBox(finder, caseDialog, "faultBusComboBox");
		faultBusComboBox.setSelectedIndex(1); 
	    System.out.println(faultBusComboBox.getSelectedItem());
	    
	    TestUI_UtilFunc.radioButtonClickAction(finder, caseDialog, "typeLLGRadioButton");
	    TestUI_UtilFunc.setTextField(finder, caseDialog, "rLGTextField", "0.1");
	    TestUI_UtilFunc.setTextField(finder, caseDialog, "xLGTextField", "0.2");
	    TestUI_UtilFunc.setTextField(finder, caseDialog, "rLLTextField", "0.3");
	    TestUI_UtilFunc.setTextField(finder, caseDialog, "xLLTextField", "0.4");

	    // click the Cancel button
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
		assertTrue(acscCaseData.getFaultData().getType().equals(AcscFaultData.FaultType_Bus));
		assertTrue(acscCaseData.getFaultData().getCategory().equals(AcscFaultData.FaultCaty_LLG));
		assertTrue(acscCaseData.getFaultData().getLG_R() == 0.1);
		assertTrue(acscCaseData.getFaultData().getLG_X() == 0.2);
		assertTrue(acscCaseData.getFaultData().getLL_R() == 0.3);
		assertTrue(acscCaseData.getFaultData().getLL_X() == 0.4);
		
		// 2: through the current case hold by the AclfRunForm object
		AcscRunForm runForm = SimuAppSpringAppContext.getAcscRunForm();
		acscCaseData = runForm.getAcscCaseData();    
			// ref the current case data, which is the same as the one
			// hold by CaaseData
		assertNotNull(acscCaseData);
		assertTrue(acscCaseData.getFaultData().getType().equals(AcscFaultData.FaultType_Bus));
		assertTrue(acscCaseData.getFaultData().getCategory().equals(AcscFaultData.FaultCaty_LLG));
		assertTrue(acscCaseData.getFaultData().getLG_R() == 0.1);
		assertTrue(acscCaseData.getFaultData().getLG_X() == 0.2);
		assertTrue(acscCaseData.getFaultData().getLL_R() == 0.3);
		assertTrue(acscCaseData.getFaultData().getLL_X() == 0.4);
	    
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
		assertTrue(acscCaseData.getFaultData().getType().equals(AcscFaultData.FaultType_Bus));
		assertTrue(acscCaseData.getFaultData().getCategory().equals(AcscFaultData.FaultCaty_LLG));
		assertTrue(acscCaseData.getFaultData().getLG_R() == 0.1);
		assertTrue(acscCaseData.getFaultData().getLG_X() == 0.2);
		assertTrue(acscCaseData.getFaultData().getLL_R() == 0.3);
		assertTrue(acscCaseData.getFaultData().getLL_X() == 0.4);
		
		System.out.println("TesAcscBusFaultCaseInfoCase testBusFaultLLGCase end");
	}
	
/*	All fault type is currently disabled
	public void testBusFaultAllCase() {
		System.out.println("TesAcscBusFaultCaseInfoCase testBusFaultAllCase begin");

		TestUI_UtilFunc.createTestingAcscGNetForm((GFormContainer)netContainer);
		
	    NBCaseInfoDialog caseDialog = (NBCaseInfoDialog)SimuAppSpringAppCtxUtil.getCaseInfoDialog(
				CaseData.CaseType_Acsc, netContainer, appSimuCtx, false);

		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");

		JComboBox casenameComboBox = TestUI_UtilFunc.findComboBox(finder, caseDialog, "casenameComboBox");
		casenameComboBox.setSelectedIndex(0); // at this point, a case "Acsc Analysis Case" has been created
		
	    TestUI_UtilFunc.radioButtonAction(finder, caseDialog, "busFaultRadioButton");
	    
	    JComboBox faultBusComboBox = TestUI_UtilFunc.findComboBox(finder, caseDialog, "faultBusComboBox");
		faultBusComboBox.setSelectedIndex(1); 
	    System.out.println(faultBusComboBox.getSelectedItem());
	    
	    TestUI_UtilFunc.radioButtonAction(finder, caseDialog, "typeAllRadioButton");
	    TestUI_UtilFunc.setTextField(finder, caseDialog, "rLGTextField", "0.1");
	    TestUI_UtilFunc.setTextField(finder, caseDialog, "xLGTextField", "0.2");
	    TestUI_UtilFunc.setTextField(finder, caseDialog, "rLLTextField", "0.3");
	    TestUI_UtilFunc.setTextField(finder, caseDialog, "xLLTextField", "0.4");
	    
	    // click the Cancel button
		finder.setName("runButton");		
	    JButton runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );
		assertTrue(appSimuCtx.getProjData().isDirty());
	    assertTrue(caseDialog.isReturnOk());

		ProjData projData = (ProjData)appSimuCtx.getProjData();
		assertTrue(projData.getAcscCaseName().equals("Acsc Analysis Case"));
		
		// At this point, we have two ways to access the AclfCaseData
		// 1: From the projData.caseList
		CaseData caseData =appSimuCtx.getCaseData("Acsc Analysis Case", CaseData.CaseType_Acsc);
		assertNotNull(caseData);
		AcscCaseData acscCaseData = caseData.getAcscCaseData();
		assertNotNull(acscCaseData);
		assertTrue(acscCaseData.getFaultData().getType().equals(AcscFaultData.FaultType_Bus));
		assertTrue(acscCaseData.getFaultData().getCategory().equals(AcscFaultData.FaultCaty_All));
		assertTrue(acscCaseData.getFaultData().getLG_R() == 0.1);
		assertTrue(acscCaseData.getFaultData().getLG_X() == 0.2);
		assertTrue(acscCaseData.getFaultData().getLL_R() == 0.3);
		assertTrue(acscCaseData.getFaultData().getLL_X() == 0.4);
		
		// 2: through the current case hold by the AclfRunForm object
		AcscRunForm runForm = SimuAppSpringAppContext.getAcscRunForm();
		acscCaseData = runForm.getAcscCaseData();    
			// ref the current case data, which is the same as the one
			// hold by CaaseData
		assertNotNull(acscCaseData);
		assertTrue(acscCaseData.getFaultData().getType().equals(AcscFaultData.FaultType_Bus));
		assertTrue(acscCaseData.getFaultData().getCategory().equals(AcscFaultData.FaultCaty_All));
		assertTrue(acscCaseData.getFaultData().getLG_R() == 0.1);
		assertTrue(acscCaseData.getFaultData().getLG_X() == 0.2);
		assertTrue(acscCaseData.getFaultData().getLL_R() == 0.3);
		assertTrue(acscCaseData.getFaultData().getLL_X() == 0.4);
	    
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
		assertTrue(acscCaseData.getFaultData().getType().equals(AcscFaultData.FaultType_Bus));
		assertTrue(acscCaseData.getFaultData().getCategory().equals(AcscFaultData.FaultCaty_All));
		assertTrue(acscCaseData.getFaultData().getLG_R() == 0.1);
		assertTrue(acscCaseData.getFaultData().getLG_X() == 0.2);
		assertTrue(acscCaseData.getFaultData().getLL_R() == 0.3);
		assertTrue(acscCaseData.getFaultData().getLL_X() == 0.4);
		
		System.out.println("TesAcscBusFaultCaseInfoCase testBusFaultAllCase end");
	}
*/
	public void testBusFaultLLCase() {
		System.out.println("TesAcscBusFaultCaseInfoCase testBusFaultLLCase begin");

		TestUI_UtilFunc.createTestingAcscGNetForm(netContainer);
		
	    NBCaseInfoDialog caseDialog = (NBCaseInfoDialog)SimuAppSpringAppCtxUtil.getCaseInfoDialog(
				CaseData.CaseType_Acsc, netContainer, appSimuCtx, false);

		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");

		JComboBox casenameComboBox = TestUI_UtilFunc.findComboBox(finder, caseDialog, "casenameComboBox");
		casenameComboBox.setSelectedIndex(0); // at this point, a case "Acsc Analysis Case" has been created
		
	    TestUI_UtilFunc.radioButtonClickAction(finder, caseDialog, "busFaultRadioButton");
	    
	    JComboBox faultBusComboBox = TestUI_UtilFunc.findComboBox(finder, caseDialog, "faultBusComboBox");
		faultBusComboBox.setSelectedIndex(1); 
	    System.out.println(faultBusComboBox.getSelectedItem());
	    
	    TestUI_UtilFunc.radioButtonClickAction(finder, caseDialog, "typeLLRadioButton");
	    TestUI_UtilFunc.setTextField(finder, caseDialog, "rLLTextField", "0.3");
	    TestUI_UtilFunc.setTextField(finder, caseDialog, "xLLTextField", "0.4");

	    // click the Cancel button
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
		assertTrue(acscCaseData.getFaultData().getType().equals(AcscFaultData.FaultType_Bus));
		assertTrue(acscCaseData.getFaultData().getCategory().equals(AcscFaultData.FaultCaty_LL));
		assertTrue(acscCaseData.getFaultData().getLL_R() == 0.3);
		assertTrue(acscCaseData.getFaultData().getLL_X() == 0.4);
		
		// 2: through the current case hold by the AclfRunForm object
		AcscRunForm runForm = SimuAppSpringAppContext.getAcscRunForm();
		acscCaseData = runForm.getAcscCaseData();    
			// ref the current case data, which is the same as the one
			// hold by CaaseData
		assertNotNull(acscCaseData);
		assertTrue(acscCaseData.getFaultData().getType().equals(AcscFaultData.FaultType_Bus));
		assertTrue(acscCaseData.getFaultData().getCategory().equals(AcscFaultData.FaultCaty_LL));
		assertTrue(acscCaseData.getFaultData().getLL_R() == 0.3);
		assertTrue(acscCaseData.getFaultData().getLL_X() == 0.4);
	    
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
		assertTrue(acscCaseData.getFaultData().getType().equals(AcscFaultData.FaultType_Bus));
		assertTrue(acscCaseData.getFaultData().getCategory().equals(AcscFaultData.FaultCaty_LL));
		assertTrue(acscCaseData.getFaultData().getLL_R() == 0.3);
		assertTrue(acscCaseData.getFaultData().getLL_X() == 0.4);	    
		System.out.println("TesAcscBusFaultCaseInfoCase testBusFaultLLCase end");
	}
}

