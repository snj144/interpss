package org.interpss.test.ui.run.dstab;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import org.interpss.editor.SimuAppSpringAppContext;
import org.interpss.editor.SimuAppSpringAppCtxUtil;
import org.interpss.editor.data.acsc.AcscFaultData;
import org.interpss.editor.data.dstab.DStabDEventData;
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

import com.interpss.common.util.IpssLogger;

public class TestDStabDEventCaseInfoCase extends TestCaseInfoBase {

	public void testSimpleRunCase() {
		System.out.println("TestDStabDEventCaseInfoCase testSimpleRunCase begin");

		TestUI_UtilFunc.createTestingDStabGNetForm((GFormContainer)netContainer);

		NBCaseInfoDialog caseDialog = (NBCaseInfoDialog)SimuAppSpringAppCtxUtil.getCaseInfoDialog(
				CaseData.CaseType_DStab, netContainer, appSimuCtx, false);

		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "casenameComboBox" );
		JComboBox casenameComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		casenameComboBox.setSelectedIndex(0); // at this point, a case "Transient Stability Case" has been created
	
	    TestUI_UtilFunc.setTextField(finder, caseDialog, "simuStepTextField", "0.05");
	    TestUI_UtilFunc.setTextField(finder, caseDialog, "totalTimeTextField", "10.0");
	    
		TestUI_UtilFunc.selectTabbedPane(finder, caseDialog, "detailInfoTabbedPane", 1);
		IpssLogger.getLogger().info("The Dynamic Events Panel selected");
		
		// At this point, a "A Dynamic Event" created
		finder.setName("eventListComboBox");
		JComboBox eventListComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		IpssLogger.getLogger().info("Current Dynamic Events: " + eventListComboBox.getSelectedItem());
		assertTrue(((String)eventListComboBox.getSelectedItem()).equals("<Not Defined>"));
		
		// change event name to "My ..."
		eventListComboBox.setSelectedItem("My First Event Case");
		assertTrue(eventListComboBox.getItemCount() == 1);
		
	    finder.setName( "stratTimeTextField" );
	    JTextField stratTimeTextField = ( JTextField ) finder.find( caseDialog, 0 );
	    stratTimeTextField.setText("0.0");	
	    
	    finder.setName( "durationTextField" );
	    JTextField durationTextField = ( JTextField ) finder.find( caseDialog, 0 );
	    durationTextField.setText("0.1");	
	    
	    finder.setName( "permanetCheckBox" );
	    JCheckBox permanetCheckBox = ( JCheckBox ) finder.find( caseDialog, 0 );
	    permanetCheckBox.setSelected(true);
	    
		// click the Cancel button
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
		DStabDEventData event = dstabCaseData.getDEventData("My First Event Case");
		assertNotNull(event);
		assertTrue(event.getStartTime() == 0.0);
		assertTrue(event.getDuration() == 0.0);  // for permanent fault duration = 0.0
		assertTrue(event.isPermanent());
		
		// 2: through the current case hold by the AclfRunForm object
		DStabRunForm runForm = SimuAppSpringAppContext.getDStabRunForm();
		dstabCaseData = runForm.getDStabCaseData();    
		assertNotNull(dstabCaseData);
		event = dstabCaseData.getDEventData("My First Event Case");
		assertNotNull(event);
		assertTrue(event.getStartTime() == 0.0);
		assertTrue(event.getDuration() == 0.0);
		assertTrue(event.isPermanent());

/* There is a bug in the following section
		// lauch the dialog again
		assertTrue(appSimuCtx.getProjData().isDirty());
		finder.setName("runButton");		
	    runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );

		assertTrue(projData.getDStabCaseName().equals("Transient Stability Case"));
		caseData = appSimuCtx.getCaseData("Transient Stability Case", CaseData.CaseType_DStab);
		assertNotNull(caseData);
		dstabCaseData = caseData.getDStabCaseData();
		assertNotNull(dstabCaseData);
		event = dstabCaseData.getDEventData("My First Event Case");
		assertNotNull(event);
		assertTrue(event.getStartTime() == 0.0);
		assertTrue(event.getDuration() == 0.1);
		assertTrue(event.isPermanent());
*/		
		System.out.println("TestDStabDEventCaseInfoCase testSimpleRunCase end");
	}
	
	public void testBusFaultEventCase() {
		System.out.println("TestDStabDEventCaseInfoCase testBusFaultEventCase begin");

		TestUI_UtilFunc.createTestingDStabGNetForm((GFormContainer)netContainer);

		NBCaseInfoDialog caseDialog = (NBCaseInfoDialog)SimuAppSpringAppCtxUtil.getCaseInfoDialog(
				CaseData.CaseType_DStab, netContainer, appSimuCtx, false);

		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "casenameComboBox" );
		JComboBox casenameComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		casenameComboBox.setSelectedIndex(0); // at this point, a case "Transient Stability Case" has been created
	
		finder.setName("detailInfoTabbedPane");
		JTabbedPane detailInfoTabbedPane = ( JTabbedPane ) finder.find( caseDialog, 0);

	    detailInfoTabbedPane.setSelectedIndex(0);
		TestUI_UtilFunc.setTextField(finder, caseDialog, "simuStepTextField", "0.05");
	    TestUI_UtilFunc.setTextField(finder, caseDialog, "totalTimeTextField", "10.0");

	    detailInfoTabbedPane.setSelectedIndex(1);
		IpssLogger.getLogger().info("The Dynamic Events Panel selected");
	    
		// At this point, a "A Dynamic Event" created
		finder.setName("eventListComboBox");
		JComboBox eventListComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		eventListComboBox.setSelectedIndex(0);
		// change event name to "My ..."
		eventListComboBox.setSelectedItem("My First Event Case");
		
	    finder.setName( "durationTextField" );
	    JTextField durationTextField = ( JTextField ) finder.find( caseDialog, 0 );
	    durationTextField.setText("0.1");	

	    finder.setName( "busFaultRadioButton" );
	    JRadioButton busFaultRadioButton = ( JRadioButton ) finder.find( caseDialog, 0 );
	    busFaultRadioButton.doClick();
	    
	    finder.setName( "faultBusComboBox" );
		JComboBox faultBusComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		faultBusComboBox.setSelectedIndex(1); 
	    System.out.println(faultBusComboBox.getSelectedItem());
	    
	    finder.setName( "type3PRadioButton" );
	    JRadioButton type3PRadioButton = ( JRadioButton ) finder.find( caseDialog, 0 );
	    type3PRadioButton.doClick(); 
	    
	    finder.setName( "rLGTextField" );
	    JTextField rLGTextField = ( JTextField ) finder.find( caseDialog, 0 );
	    rLGTextField.setText("0.1");
	    
	    finder.setName( "xLGTextField" );
	    JTextField xLGTextField = ( JTextField ) finder.find( caseDialog, 0 );
	    xLGTextField.setText("0.2");
	    
	    // click the Cancel button
		finder.setName("runButton");		
	    JButton runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );

		CaseData caseData = appSimuCtx.getCaseData("Transient Stability Case", CaseData.CaseType_DStab);
		assertNotNull(caseData);
		DStabCaseData dstabCaseData = caseData.getDStabCaseData();
		assertNotNull(dstabCaseData);
		DStabDEventData event = dstabCaseData.getDEventData("My First Event Case");
		assertNotNull(event);
		assertTrue(event.getFaultData().getType().equals(AcscFaultData.FaultType_Bus));
		assertTrue(event.getFaultData().getBusId().equals("0002"));
		assertTrue(event.getFaultData().getCategory().equals(AcscFaultData.FaultCaty_3P));
		assertTrue(event.getFaultData().getLG_R() == 0.1);
		assertTrue(event.getFaultData().getLG_X() == 0.2);

/*	There is a bus in the following section	
		
		// lauch the dialog again
		caseDialog.init(netContainer, appSimuCtx);
		finder.setName("runButton");		
	    runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );

		caseData = appSimuCtx.getCaseData("Transient Stability Case", CaseData.CaseType_DStab);
		assertNotNull(caseData);
		dstabCaseData = caseData.getDStabCaseData();
		assertNotNull(dstabCaseData);
		event = dstabCaseData.getDEventData("My First Event Case");
		assertNotNull(event);
		assertTrue(event.getFaultData().getType().equals(AcscFaultData.FaultType_Bus));
		assertTrue(event.getFaultData().getBusId().equals("0002"));
		assertTrue(event.getFaultData().getCategory().equals(AcscFaultData.FaultCaty_3P));
		assertTrue(event.getFaultData().getLG_R() == 0.1);
		assertTrue(event.getFaultData().getLG_X() == 0.2);
*/		
		System.out.println("TestDStabDEventCaseInfoCase testBusFaultEventCase end");
	}

	public void testBranchFaultEventCase() {
		System.out.println("TestDStabDEventCaseInfoCase testBranchFaultEventCase begin");

		TestUI_UtilFunc.createTestingDStabGNetForm((GFormContainer)netContainer);

		NBCaseInfoDialog caseDialog = (NBCaseInfoDialog)SimuAppSpringAppCtxUtil.getCaseInfoDialog(
				CaseData.CaseType_DStab, netContainer, appSimuCtx, false);

		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "casenameComboBox" );
		JComboBox casenameComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		casenameComboBox.setSelectedIndex(0); // at this point, a case "Transient Stability Case" has been created
	
		finder.setName("detailInfoTabbedPane");
		JTabbedPane detailInfoTabbedPane = ( JTabbedPane ) finder.find( caseDialog, 0);

		detailInfoTabbedPane.setSelectedIndex(0);
		TestUI_UtilFunc.setTextField(finder, caseDialog, "simuStepTextField", "0.05");
	    TestUI_UtilFunc.setTextField(finder, caseDialog, "totalTimeTextField", "10.0");

	    detailInfoTabbedPane.setSelectedIndex(1);
		IpssLogger.getLogger().info("The Dynamic Events Panel selected");
		
		// At this point, a "A Dynamic Event" created
		finder.setName("eventListComboBox");
		JComboBox eventListComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		eventListComboBox.setSelectedIndex(0);
		// change event name to "My ..."
		eventListComboBox.setSelectedItem("My First Event Case");
		
	    finder.setName( "durationTextField" );
	    JTextField durationTextField = ( JTextField ) finder.find( caseDialog, 0 );
	    durationTextField.setText("0.1");	

	    finder.setName( "branchFaultRadioButton" );
	    JRadioButton branchFaultRadioButton = ( JRadioButton ) finder.find( caseDialog, 0 );
	    branchFaultRadioButton.doClick();
	    
	    finder.setName( "distanceTextField" );
	    JTextField distanceTextField = ( JTextField ) finder.find( caseDialog, 0 );
	    distanceTextField.setText("50.0");
	    
	    // click the Cancel button
		finder.setName("runButton");		
	    JButton runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );

		CaseData caseData = appSimuCtx.getCaseData("Transient Stability Case", CaseData.CaseType_DStab);
		assertNotNull(caseData);
		DStabCaseData dstabCaseData = caseData.getDStabCaseData();
		assertNotNull(dstabCaseData);
		DStabDEventData event = dstabCaseData.getDEventData("My First Event Case");
		assertNotNull(event);
		assertTrue(event.getFaultData().getType().equals(AcscFaultData.FaultType_Branch));
		assertTrue(event.getFaultData().getBusId().equals("0001->0002"));
		assertTrue(event.getFaultData().getDistance() == 50.0);
		
/*	There is a bus in the following section

		// lauch the dialog again
		caseDialog.init(netContainer, appSimuCtx);
		finder.setName("runButton");		
	    runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );

		caseData = appSimuCtx.getCaseData("Transient Stability Case", CaseData.CaseType_DStab);
		assertNotNull(caseData);
		dstabCaseData = caseData.getDStabCaseData();
		assertNotNull(dstabCaseData);
		event = dstabCaseData.getDEventData("My First Event Case");
		assertNotNull(event);
		assertTrue(event.getFaultData().getType().equals(AcscFaultData.FaultType_Branch));
		assertTrue(event.getFaultData().getBusId().equals("0001->0002"));
		assertTrue(event.getFaultData().getDistance() == 50.0);
*/		
		System.out.println("TestDStabDEventCaseInfoCase testBranchFaultEventCase end");
	}
}

