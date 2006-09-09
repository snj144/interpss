package org.interpss.test.ui.run.dstab;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.NamedComponentFinder;

import org.interpss.editor.SimuAppSpringAppCtxUtil;
import org.interpss.editor.data.proj.CaseData;
import org.interpss.editor.data.proj.DStabCaseData;
import org.interpss.editor.data.proj.ProjData;
import org.interpss.editor.ui.run.NBCaseInfoDialog;
import org.interpss.test.ui.TestUI_UtilFunc;
import org.interpss.test.ui.run.TestCaseInfoBase;

import com.interpss.common.util.IpssLogger;

public class TestDStabAdvancedCaseInfoCase extends TestCaseInfoBase {

	public void testRunCase() {
		System.out.println("TestDStabAdvancedCaseInfoCase testRunCase begin");

		TestUI_UtilFunc.createTestingDStabGNetForm(netContainer);
		
		NBCaseInfoDialog caseDialog = (NBCaseInfoDialog)SimuAppSpringAppCtxUtil.getCaseInfoDialog(
				CaseData.CaseType_DStab, netContainer, appSimuCtx, false);

		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "casenameComboBox" );
		JComboBox casenameComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		casenameComboBox.setSelectedIndex(0); // at this point, a case "Transient Stability Case" has been created
	
		TestUI_UtilFunc.selectTabbedPane(finder, caseDialog, "detailInfoTabbedPane", 1);
		IpssLogger.getLogger().info("The Advanced Panel selected");

		TestUI_UtilFunc.selectTabbedPane(finder, caseDialog, "detailInfoTabbedPane", 0);
	    TestUI_UtilFunc.radioButtonClickAction(finder, caseDialog, "staticLoadCPRadioButton");
	    TestUI_UtilFunc.setTextField(finder, caseDialog, "staticLoadSwitchVoltTextField", "0.85");
	   
	    TestUI_UtilFunc.setTextField(finder, caseDialog, "simuStepTextField", "0.05");
	    TestUI_UtilFunc.setTextField(finder, caseDialog, "totalTimeTextField", "10.0");
	    
		// click the Run button
		finder.setName("runButton");		
	    JButton runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );
		assertTrue(appSimuCtx.getProjData().isDirty());
	    assertTrue(caseDialog.isReturnOk());

	    ProjData projData = (ProjData)appSimuCtx.getProjData();
		assertTrue(projData.getDStabCaseName().equals("Transient Stability Case"));
		
		// At this point, we have two ways to access the AclfCaseData
		// 1: From the projData.caseList
		CaseData caseData = appSimuCtx.getCaseData("Transient Stability Case", CaseData.CaseType_DStab);
		assertNotNull(caseData);
		DStabCaseData dstabCaseData = caseData.getDStabCaseData();
		assertNotNull(dstabCaseData);
		assertTrue(dstabCaseData.getStaticLoadType().equals(DStabCaseData.StaticLoad_Const_P));
		assertTrue(dstabCaseData.getStaticLoadSwitchVolt() == 0.85);

/* There is a bug in the following section
		// launch the Dialog again
		caseDialog.init(netContainer, appSimuCtx);
		finder.setName("runButton");		
	    runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );
	    
		assertTrue(projData.getDStabCaseName().equals("Transient Stability Case"));
		caseData = appSimuCtx.getCaseData("Transient Stability Case", CaseData.CaseType_DStab);
		assertNotNull(caseData);
		dstabCaseData = caseData.getDStabCaseData();
		assertNotNull(dstabCaseData);
		assertTrue(dstabCaseData.getStaticLoadType().equals(DStabCaseData.StaticLoad_Const_P));
		assertTrue(dstabCaseData.getStaticLoadSwitchVolt() == 0.85);
	    
		
		// launch the Dialog again
		caseDialog.init(netContainer, appSimuCtx);

		TestUI_UtilFunc.selectTabbedPane(finder, caseDialog, "detailInfoTabbedPane", 1);
	    TestUI_UtilFunc.radioButtonAction(finder, caseDialog, "staticLoadCZRadioButton");
		
		finder.setName("runButton");		
	    runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );
		assertTrue(appSimuCtx.getProjData().isDirty());
	    assertTrue(caseDialog.isReturnOk());
	    
		caseData = appSimuCtx.getCaseData("Transient Stability Case", CaseData.CaseType_DStab);
		assertNotNull(caseData);
		dstabCaseData = caseData.getDStabCaseData();
		assertNotNull(dstabCaseData);
		assertTrue(dstabCaseData.getStaticLoadType().equals(DStabCaseData.StaticLoad_Const_Z));

		// launch the Dialog again
		caseDialog.init(netContainer, appSimuCtx);
		finder.setName("runButton");		
	    runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );

		caseData = appSimuCtx.getCaseData("Transient Stability Case", CaseData.CaseType_DStab);
		assertNotNull(caseData);
		dstabCaseData = caseData.getDStabCaseData();
		assertNotNull(dstabCaseData);
		assertTrue(dstabCaseData.getStaticLoadType().equals(DStabCaseData.StaticLoad_Const_Z));
*/	    
		System.out.println("TestDStabAdvancedCaseInfoCase testRunCase end");
	}
}

