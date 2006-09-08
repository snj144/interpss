package org.interpss.test.ui.run.dstab;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import org.interpss.editor.SimuAppSpringAppContext;
import org.interpss.editor.SimuAppSpringAppCtxUtil;
import org.interpss.editor.data.proj.CaseData;
import org.interpss.editor.data.proj.DStabCaseData;
import org.interpss.editor.data.proj.ProjData;
import org.interpss.editor.form.GFormContainer;
import org.interpss.editor.runAct.DStabRunForm;
import org.interpss.editor.ui.run.NBCaseInfoDialog;
import org.interpss.test.ui.TestUI_UtilFunc;
import org.interpss.test.ui.run.TestCaseInfoBase;

import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.NamedComponentFinder;


public class TestDStabCaseInfoCase extends TestCaseInfoBase {

	public void testSimpleRunCase() {
		System.out.println("TestDStabCaseInfoCase testSimpleRunCase begin");

		TestUI_UtilFunc.createTestingDStabGNetForm((GFormContainer)netContainer);

		NBCaseInfoDialog caseDialog = (NBCaseInfoDialog)SimuAppSpringAppCtxUtil.getCaseInfoDialog(
				CaseData.CaseType_DStab, netContainer, appSimuCtx, false);

		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "casenameComboBox" );
		JComboBox casenameComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		casenameComboBox.setSelectedIndex(0); // at this point, a case "Transient Stability Case" has been created
	
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
		
		// 2: through the current case hold by the AclfRunForm object
		DStabRunForm runForm = SimuAppSpringAppContext.getDStabRunForm();
		dstabCaseData = runForm.getDStabCaseData();    
		assertNotNull(dstabCaseData);
	    
		System.out.println("TestDStabCaseInfoCase testSimpleRunCase end");
	}
	
	public void testTypicalRunCase() {
		System.out.println("TestDStabCaseInfoCase testTypicalRunCase begin");

		TestUI_UtilFunc.createTestingDStabGNetForm((GFormContainer)netContainer);
		
		NBCaseInfoDialog caseDialog = (NBCaseInfoDialog)SimuAppSpringAppCtxUtil.getCaseInfoDialog(
				CaseData.CaseType_DStab, netContainer, appSimuCtx, false);

		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "casenameComboBox" );
		JComboBox casenameComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		casenameComboBox.setSelectedIndex(0); // at this point, a case "Transient Stability Case" has been created
	
		JComboBox methodComboBox = TestUI_UtilFunc.findComboBox(finder, caseDialog, "methodComboBox");
		methodComboBox.setSelectedIndex(0);
	
	    TestUI_UtilFunc.setTextField(finder, caseDialog, "simuStepTextField", "0.06");
	    TestUI_UtilFunc.setTextField(finder, caseDialog, "totalTimeTextField", "20.0");
	    
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
		assertTrue(dstabCaseData.getSimuMethod().equals(DStabCaseData.Method_ModifiedEuler));
		assertTrue(dstabCaseData.getTotalSimuTime() == 20.0);
		assertTrue(dstabCaseData.getSimuStep() == 0.06);
		
		// 2: through the current case hold by the AclfRunForm object
		DStabRunForm runForm = SimuAppSpringAppContext.getDStabRunForm();
		dstabCaseData = runForm.getDStabCaseData();    
		assertNotNull(dstabCaseData);
		assertTrue(dstabCaseData.getSimuMethod().equals(DStabCaseData.Method_ModifiedEuler));
		assertTrue(dstabCaseData.getTotalSimuTime() == 20.0);
		assertTrue(dstabCaseData.getSimuStep() == 0.06);

/* There is a bug in the following section
		// launch the editor again
		caseDialog = (NBCaseInfoDialog)SimuAppSpringAppCtxUtil.getCaseInfoDialog(
				CaseData.CaseType_DStab, netContainer, appSimuCtx, false);

		finder.setName("runButton");		
	    runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );

		assertTrue(projData.getDStabCaseName().equals("Transient Stability Case"));
		caseData = appSimuCtx.getCaseData("Transient Stability Case", CaseData.CaseType_DStab);
		assertNotNull(caseData);
		dstabCaseData = caseData.getDStabCaseData();
		assertNotNull(dstabCaseData);
		assertTrue(dstabCaseData.getSimuMethod().equals(DStabCaseData.Method_ModifiedEuler));
		assertTrue(dstabCaseData.getTotalSimuTime() == 20.0);
		assertTrue(dstabCaseData.getSimuStep() == 0.06);		
*/
		System.out.println("TestDStabCaseInfoCase testTypicalRunCase end");
	}
}

