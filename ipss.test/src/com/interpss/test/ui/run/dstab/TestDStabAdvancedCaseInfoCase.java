package com.interpss.test.ui.run.dstab;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import com.interpss.common.util.IpssLogger;
import com.interpss.editor.app.AppSimuContextImpl;
import com.interpss.editor.data.proj.CaseData;
import com.interpss.editor.data.proj.DStabCaseData;
import com.interpss.editor.data.proj.ProjData;
import com.interpss.editor.ui.SimuAppSpringAppCtxUtil;
import com.interpss.editor.ui.run.NBCaseInfoDialog;
import com.interpss.test.ui.TestUI_UtilFunc;
import com.interpss.test.ui.run.TestCaseInfoBase;

import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.*;

public class TestDStabAdvancedCaseInfoCase extends TestCaseInfoBase {

	public void testRunCase() {
		System.out.println("TestDStabAdvancedCaseInfoCase testRunCase begin");

		TestUI_UtilFunc.createTestingDStabGNetForm(netContainer);
		
	    AppSimuContextImpl appSimuCtx = (AppSimuContextImpl)editor.getAppSimuContext();
	    
		NBCaseInfoDialog caseDialog = (NBCaseInfoDialog)SimuAppSpringAppCtxUtil.getCaseInfoDialog(
				CaseData.CaseType_DStab, netContainer, appSimuCtx, false);

		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "casenameComboBox" );
		JComboBox casenameComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		casenameComboBox.setSelectedIndex(0); // at this point, a case "Transient Stability Case" has been created
	
		TestUI_UtilFunc.selectTabbedPane(finder, caseDialog, "detailInfoTabbedPane", 1);
		IpssLogger.getLogger().info("The Advanced Panel selected");

	    TestUI_UtilFunc.radioButtonAction(finder, caseDialog, "staticLoadCPRadioButton");
	    TestUI_UtilFunc.setTextField(finder, caseDialog, "staticLoadSwitchVoltTextField", "0.85");
	    
		// click the Run button
		finder.setName("runButton");		
	    JButton runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
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

		// launch the Dialog again
		caseDialog.init(netContainer, editor.getAppCtx());
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
		caseDialog.init(netContainer, editor.getAppCtx());

		TestUI_UtilFunc.selectTabbedPane(finder, caseDialog, "detailInfoTabbedPane", 1);
	    TestUI_UtilFunc.radioButtonAction(finder, caseDialog, "staticLoadCZRadioButton");
		
		finder.setName("runButton");		
	    runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );
		assertTrue(editor.getIpssGraph().isGraphDirty());
	    assertTrue(caseDialog.isReturnOk());
	    
		caseData = appSimuCtx.getCaseData("Transient Stability Case", CaseData.CaseType_DStab);
		assertNotNull(caseData);
		dstabCaseData = caseData.getDStabCaseData();
		assertNotNull(dstabCaseData);
		assertTrue(dstabCaseData.getStaticLoadType().equals(DStabCaseData.StaticLoad_Const_Z));

		// launch the Dialog again
		caseDialog.init(netContainer, editor.getAppCtx());
		finder.setName("runButton");		
	    runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );

		caseData = appSimuCtx.getCaseData("Transient Stability Case", CaseData.CaseType_DStab);
		assertNotNull(caseData);
		dstabCaseData = caseData.getDStabCaseData();
		assertNotNull(dstabCaseData);
		assertTrue(dstabCaseData.getStaticLoadType().equals(DStabCaseData.StaticLoad_Const_Z));
	    
		System.out.println("TestDStabAdvancedCaseInfoCase testRunCase end");
	}
}

