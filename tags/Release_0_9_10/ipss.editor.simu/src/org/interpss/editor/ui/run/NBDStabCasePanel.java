package org.interpss.editor.ui.run;

import java.util.Vector;

import org.interpss.editor.data.proj.AclfCaseData;
import org.interpss.editor.data.proj.CaseData;
import org.interpss.editor.data.proj.DStabCaseData;
import org.interpss.editor.form.GFormContainer;
import org.interpss.editor.ui.run.common.NBDynaEventPanel;

import com.interpss.common.ui.VerifyUtil;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.Num2Str;
import com.interpss.editor.jgraph.ui.edit.IFormDataPanel;

public class NBDStabCasePanel extends javax.swing.JPanel implements IFormDataPanel {
	private static final long serialVersionUID = 1;

	private NBDynaEventPanel dynaEventPanel = new NBDynaEventPanel();
	private NBAclfCasePanel aclfCasePanel = new NBAclfCasePanel();

	private AclfCaseData    aclfCaseData = null;  // current case data
	private DStabCaseData   dstabCaseData = null;  // current case data
	private String machIdLargestInertia = "";

    /** Creates new form NBCaseInfoDialog */
    public NBDStabCasePanel() {
        initComponents();

        dynamicEventPanel.add(dynaEventPanel);
        loadflowPanel.add(aclfCasePanel);
        //otherInfoPanel
        
        DataVerifier verifier = new DataVerifier();
        totalTimeTextField.setInputVerifier(verifier);
        simuStepTextField.setInputVerifier(verifier);
        staticLoadSwitchVoltTextField.setInputVerifier(verifier);
    }
    
    public void init(Object netContainer, Object _null) {
		IpssLogger.getLogger().info("NBDStabCasePanel init() called");

        refMachComboBox.setModel(new javax.swing.DefaultComboBoxModel(
        		((GFormContainer)netContainer).getMachIdArray()));
        machIdLargestInertia = ((GFormContainer)netContainer).getMachIdLargestInertia();
        dynaEventPanel.init(netContainer, null);
    }

    public void setCaseData(CaseData caseData) {
    	dstabCaseData = caseData.getDStabCaseData();
    	if (caseData.getAclfCaseData() == null)
    		caseData.setAclfCaseData(new AclfCaseData());
    	aclfCaseData = caseData.getAclfCaseData();
    	dynaEventPanel.setCaseData(dstabCaseData);
    	aclfCasePanel.setCaseData(aclfCaseData);
    }
    
    /**
	*	Set form data to the editor
	*
	* @return false if there is any problem
	*/
	public boolean setForm2Editor() {
		IpssLogger.getLogger().info("NBDStabCasePanel setForm2Editor() called");

		// set Aclf panel 
		aclfCasePanel.setForm2Editor();
		
        methodComboBox.setSelectedItem(dstabCaseData.getSimuMethod());
        totalTimeTextField.setText(Num2Str.toStr(dstabCaseData.getTotalSimuTime(), "#0.00"));
        simuStepTextField.setText(Num2Str.toStr(dstabCaseData.getSimuStep(), "#0.00#"));
        disableEventCheckBox.setSelected(dstabCaseData.getDisableDynamicEvent());
        
        if (dstabCaseData.isAbsoluteMachValue()) {
            absMachCheckBox.setSelected(true);
            absMachCheckBoxActionPerformed(null);
        }
        else {
        	if (dstabCaseData.getRefMachId().equals("")) {
        		// select machine with the largest inertia
        		dstabCaseData.setRefMachId(machIdLargestInertia);
        	}
       		refMachComboBox.setSelectedItem(dstabCaseData.getRefMachId());
        }
        
        if (dstabCaseData.getStaticLoadType().equals(DStabCaseData.StaticLoad_Const_Z)) {
            staticLoadCZRadioButton.setSelected(true);
            setStaticLoadCPStatus(false);
        }
        else {
            staticLoadCPRadioButton.setSelected(true);
            setStaticLoadCPStatus(true);
            staticLoadSwitchVoltTextField.setText(Num2Str.toStr(dstabCaseData.getStaticLoadSwitchVolt(), "#0.00"));
            staticLoadSwitchDeadZoneTextField.setText(Num2Str.toStr(dstabCaseData.getStaticLoadSwitchDeadZone(), "#0.00"));
        }
        
        if(!dstabCaseData.getDisableDynamicEvent()) {
        	disableEventCheckBox.setSelected(false);
        	dynaEventPanel.setForm2Editor();
        }
        else {
        	disableEventCheckBox.setSelected(true);
        }
        disableEventCheckBoxActionPerformed(null);

		return true;
	}
    
	/**
	*	Save editor screen data to the form
	*
	* @param errMsg error messages during the saving process.
	* @return false if there is any problem
	*/
	public boolean saveEditor2Form(Vector errMsg) throws Exception {
		IpssLogger.getLogger().info("NBDStabCasePanel saveEditor2Form() called");

		boolean ok = true;
		
		// save aclf panel data
		ok = aclfCasePanel.saveEditor2Form(errMsg);
		
		dstabCaseData.setSimuMethod((String)methodComboBox.getSelectedItem());

        if (!VerifyUtil.largeThan(totalTimeTextField, 0.0d)) {
			errMsg.add("Total Simulation time < 0.0");
			ok = false;
		}
        dstabCaseData.setTotalSimuTime(VerifyUtil.getDouble(totalTimeTextField));
        
        if (!VerifyUtil.largeThan(simuStepTextField, 0.0d)) {
			errMsg.add("Simulation step < 0.0");
			ok = false;
		}
        dstabCaseData.setSimuStep(VerifyUtil.getDouble(simuStepTextField));
        
        if (dstabCaseData.getTotalSimuTime() < dstabCaseData.getSimuStep()) {
			errMsg.add("Total simu time < simulation step");
			ok = false;
        }
        
        if (absMachCheckBox.isSelected()) {
        	dstabCaseData.setAbsoluteMachValue(true);
        }
        else {
        	dstabCaseData.setAbsoluteMachValue(false);
       		dstabCaseData.setRefMachId((String)refMachComboBox.getSelectedItem());
        }

        if (!VerifyUtil.largeThan(netEqnItrNoEventTextField, 0)) {
			errMsg.add("Network equation solution iteration count (no event) <= 0");
			ok = false;
		}
        dstabCaseData.setNetEqnItrNoEvent(VerifyUtil.getInt(netEqnItrNoEventTextField));
        
        if (!VerifyUtil.largeThan(netEqnItrWithEventTextField, 0)) {
			errMsg.add("Network equation solution iteration count (with event) <= 0");
			ok = false;
		}
        dstabCaseData.setNetEqnItrWithEvent(VerifyUtil.getInt(netEqnItrWithEventTextField));
        

        if (staticLoadCZRadioButton.isSelected()) {
        	dstabCaseData.setStaticLoadType(DStabCaseData.StaticLoad_Const_Z);
        }
        else {
        	dstabCaseData.setStaticLoadType(DStabCaseData.StaticLoad_Const_P);
            if (!VerifyUtil.largeEqualThan(staticLoadSwitchVoltTextField, 0.4d)) {
    			errMsg.add("Static load model switching voltage < 0.4 pu");
    			ok = false;
    		}
            dstabCaseData.setStaticLoadSwitchVolt(VerifyUtil.getDouble(staticLoadSwitchVoltTextField));

            if (!VerifyUtil.largeEqualThan(staticLoadSwitchDeadZoneTextField, 0.0d)) {
    			errMsg.add("Static load model switching voltage dead zone< 0.0 pu");
    			ok = false;
    		}
            dstabCaseData.setStaticLoadSwitchDeadZone(VerifyUtil.getDouble(staticLoadSwitchDeadZoneTextField));
        }

        dstabCaseData.setDisableDynamicEvent(disableEventCheckBox.isSelected());
        if(!dstabCaseData.getDisableDynamicEvent()) {
        	if (!dynaEventPanel.saveEditor2Form(errMsg))
        		ok = false;
        }
        IpssLogger.getLogger().info("" + dstabCaseData);
		return ok;
	}
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        staticLoadButtonGroup = new javax.swing.ButtonGroup();
        detailInfoTabbedPane = new javax.swing.JTabbedPane();
        simulationPanel = new javax.swing.JPanel();
        methodLabel = new javax.swing.JLabel();
        methodComboBox = new javax.swing.JComboBox();
        disableEventCheckBox = new javax.swing.JCheckBox();
        totalTImeLabel = new javax.swing.JLabel();
        totalTimeTextField = new javax.swing.JTextField();
        simuStepLabel = new javax.swing.JLabel();
        simuStepTextField = new javax.swing.JTextField();
        refMachinejPanel = new javax.swing.JPanel();
        refMachLabel = new javax.swing.JLabel();
        refMachComboBox = new javax.swing.JComboBox();
        absMachCheckBox = new javax.swing.JCheckBox();
        netEqnItrPanel = new javax.swing.JPanel();
        netEqnItrLabel = new javax.swing.JLabel();
        netEqnItrNoEventTextField = new javax.swing.JTextField();
        netEqnItrNoEventLabel = new javax.swing.JLabel();
        netEqnItrWithEventTextField = new javax.swing.JTextField();
        netEqnItrWithEventLabel = new javax.swing.JLabel();
        staticLoadPanel = new javax.swing.JPanel();
        staticLoadCZRadioButton = new javax.swing.JRadioButton();
        staticLoadCPRadioButton = new javax.swing.JRadioButton();
        staticLoadSwitchVoltLabel = new javax.swing.JLabel();
        staticLoadSwitchVoltTextField = new javax.swing.JTextField();
        staticLoadSwitchDeadZoneLabel = new javax.swing.JLabel();
        staticLoadSwitchDeadZoneTextField = new javax.swing.JTextField();
        dynamicEventPanel = new javax.swing.JPanel();
        initializationPanel = new javax.swing.JPanel();
        loadflowPanel = new javax.swing.JPanel();
        otherInfoPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        detailInfoTabbedPane.setName("detailInfoTabbedPane");
        simulationPanel.setLayout(new java.awt.GridBagLayout());

        simulationPanel.setName("advancedPanel");
        methodLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        methodLabel.setText("Simulation Method       ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        simulationPanel.add(methodLabel, gridBagConstraints);

        methodComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        methodComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Modified Euler", "Runge Kutta" }));
        methodComboBox.setName("methodComboBox");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        simulationPanel.add(methodComboBox, gridBagConstraints);

        disableEventCheckBox.setFont(new java.awt.Font("Dialog", 0, 12));
        disableEventCheckBox.setText("Disable Dynamic Events");
        disableEventCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        disableEventCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        disableEventCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disableEventCheckBoxActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        simulationPanel.add(disableEventCheckBox, gridBagConstraints);

        totalTImeLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        totalTImeLabel.setText("         Total Time(sec)   ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 10, 0);
        simulationPanel.add(totalTImeLabel, gridBagConstraints);

        totalTimeTextField.setColumns(5);
        totalTimeTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        totalTimeTextField.setText("10.0");
        totalTimeTextField.setName("totalTimeTextField");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 10, 0);
        simulationPanel.add(totalTimeTextField, gridBagConstraints);

        simuStepLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        simuStepLabel.setText("          Simu Step(sec)   ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 10, 0);
        simulationPanel.add(simuStepLabel, gridBagConstraints);

        simuStepTextField.setColumns(4);
        simuStepTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        simuStepTextField.setText("0.05");
        simuStepTextField.setName("simuStepTextField");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 10, 0);
        simulationPanel.add(simuStepTextField, gridBagConstraints);

        refMachinejPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5));

        refMachLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        refMachLabel.setText("Ref Machine");
        refMachinejPanel.add(refMachLabel);

        refMachComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        refMachComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        refMachinejPanel.add(refMachComboBox);

        absMachCheckBox.setFont(new java.awt.Font("Dialog", 0, 12));
        absMachCheckBox.setText("Absolute Machine Angle");
        absMachCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        absMachCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        absMachCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                absMachCheckBoxActionPerformed(evt);
            }
        });

        refMachinejPanel.add(absMachCheckBox);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        simulationPanel.add(refMachinejPanel, gridBagConstraints);

        netEqnItrLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        netEqnItrLabel.setText("          Net Eqn Iterations      ");
        netEqnItrPanel.add(netEqnItrLabel);

        netEqnItrNoEventTextField.setColumns(2);
        netEqnItrNoEventTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        netEqnItrNoEventTextField.setText("3");
        netEqnItrNoEventTextField.setName("totalTimeTextField");
        netEqnItrPanel.add(netEqnItrNoEventTextField);

        netEqnItrNoEventLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        netEqnItrNoEventLabel.setText("(No Event)      ");
        netEqnItrPanel.add(netEqnItrNoEventLabel);

        netEqnItrWithEventTextField.setColumns(2);
        netEqnItrWithEventTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        netEqnItrWithEventTextField.setText("5");
        netEqnItrWithEventTextField.setName("simuStepTextField");
        netEqnItrPanel.add(netEqnItrWithEventTextField);

        netEqnItrWithEventLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        netEqnItrWithEventLabel.setText("(With Event)   ");
        netEqnItrPanel.add(netEqnItrWithEventLabel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        simulationPanel.add(netEqnItrPanel, gridBagConstraints);

        staticLoadPanel.setLayout(new java.awt.GridBagLayout());

        staticLoadPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Static Load Modeling", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10), new java.awt.Color(0, 0, 0)));
        staticLoadButtonGroup.add(staticLoadCZRadioButton);
        staticLoadCZRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        staticLoadCZRadioButton.setSelected(true);
        staticLoadCZRadioButton.setText("Const-Z");
        staticLoadCZRadioButton.setName("staticLoadCZRadioButton");
        staticLoadCZRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staticLoadCZRadioButtonActionPerformed(evt);
            }
        });

        staticLoadPanel.add(staticLoadCZRadioButton, new java.awt.GridBagConstraints());

        staticLoadButtonGroup.add(staticLoadCPRadioButton);
        staticLoadCPRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        staticLoadCPRadioButton.setText("Const-P");
        staticLoadCPRadioButton.setName("staticLoadCPRadioButton");
        staticLoadCPRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staticLoadCPRadioButtonActionPerformed(evt);
            }
        });

        staticLoadPanel.add(staticLoadCPRadioButton, new java.awt.GridBagConstraints());

        staticLoadSwitchVoltLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        staticLoadSwitchVoltLabel.setText("Switch Volt(pu)   ");
        staticLoadSwitchVoltLabel.setToolTipText("Constant-P model will be switched to the Constant-Z model when the voltage is lower than the switch voltage.");
        staticLoadSwitchVoltLabel.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 0);
        staticLoadPanel.add(staticLoadSwitchVoltLabel, gridBagConstraints);

        staticLoadSwitchVoltTextField.setColumns(4);
        staticLoadSwitchVoltTextField.setText("0.65");
        staticLoadSwitchVoltTextField.setEnabled(false);
        staticLoadSwitchVoltTextField.setName("staticLoadSwitchVoltTextField");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        staticLoadPanel.add(staticLoadSwitchVoltTextField, gridBagConstraints);

        staticLoadSwitchDeadZoneLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        staticLoadSwitchDeadZoneLabel.setText("  DeadZone(pu)   ");
        staticLoadSwitchDeadZoneLabel.setToolTipText("Constant-P model will be switched to the Constant-Z model when the voltage is lower than the switch voltage.");
        staticLoadSwitchDeadZoneLabel.setAlignmentY(0.05F);
        staticLoadSwitchDeadZoneLabel.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        staticLoadPanel.add(staticLoadSwitchDeadZoneLabel, gridBagConstraints);

        staticLoadSwitchDeadZoneTextField.setColumns(4);
        staticLoadSwitchDeadZoneTextField.setText("0.05");
        staticLoadSwitchDeadZoneTextField.setAlignmentY(0.05F);
        staticLoadSwitchDeadZoneTextField.setEnabled(false);
        staticLoadSwitchDeadZoneTextField.setName("staticLoadSwitchVoltTextField");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 20);
        staticLoadPanel.add(staticLoadSwitchDeadZoneTextField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 20);
        simulationPanel.add(staticLoadPanel, gridBagConstraints);

        detailInfoTabbedPane.addTab("Simulation", simulationPanel);

        dynamicEventPanel.setName("dynamicEventPanel");
        detailInfoTabbedPane.addTab("Dynamic Events", dynamicEventPanel);

        initializationPanel.setLayout(new java.awt.BorderLayout());

        initializationPanel.setName("dynamicEventPanel");
        initializationPanel.add(loadflowPanel, java.awt.BorderLayout.NORTH);

        initializationPanel.add(otherInfoPanel, java.awt.BorderLayout.CENTER);

        detailInfoTabbedPane.addTab("Initialization", initializationPanel);

        add(detailInfoTabbedPane, java.awt.BorderLayout.CENTER);

    }// </editor-fold>//GEN-END:initComponents

    private void absMachCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_absMachCheckBoxActionPerformed
        refMachLabel.setEnabled(!absMachCheckBox.isSelected());
        refMachComboBox.setEnabled(!absMachCheckBox.isSelected());
    }//GEN-LAST:event_absMachCheckBoxActionPerformed

    private void disableEventCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disableEventCheckBoxActionPerformed
        if(disableEventCheckBox.isSelected()) 
        	detailInfoTabbedPane.setEnabledAt(1, false);
        else 
        	detailInfoTabbedPane.setEnabledAt(1, true);
    }//GEN-LAST:event_disableEventCheckBoxActionPerformed

    private void staticLoadCPRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staticLoadCPRadioButtonActionPerformed
        setStaticLoadCPStatus(true);
    }//GEN-LAST:event_staticLoadCPRadioButtonActionPerformed

    private void staticLoadCZRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staticLoadCZRadioButtonActionPerformed
        setStaticLoadCPStatus(false);
    }//GEN-LAST:event_staticLoadCZRadioButtonActionPerformed
    
    private void setStaticLoadCPStatus(boolean status) {
        staticLoadSwitchVoltLabel.setEnabled(status);
        staticLoadSwitchVoltTextField.setEnabled(status);
        staticLoadSwitchDeadZoneLabel.setEnabled(status);
        staticLoadSwitchDeadZoneTextField.setEnabled(status);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox absMachCheckBox;
    private javax.swing.JTabbedPane detailInfoTabbedPane;
    private javax.swing.JCheckBox disableEventCheckBox;
    private javax.swing.JPanel dynamicEventPanel;
    private javax.swing.JPanel initializationPanel;
    private javax.swing.JPanel loadflowPanel;
    private javax.swing.JComboBox methodComboBox;
    private javax.swing.JLabel methodLabel;
    private javax.swing.JLabel netEqnItrLabel;
    private javax.swing.JLabel netEqnItrNoEventLabel;
    private javax.swing.JTextField netEqnItrNoEventTextField;
    private javax.swing.JPanel netEqnItrPanel;
    private javax.swing.JLabel netEqnItrWithEventLabel;
    private javax.swing.JTextField netEqnItrWithEventTextField;
    private javax.swing.JPanel otherInfoPanel;
    private javax.swing.JComboBox refMachComboBox;
    private javax.swing.JLabel refMachLabel;
    private javax.swing.JPanel refMachinejPanel;
    private javax.swing.JLabel simuStepLabel;
    private javax.swing.JTextField simuStepTextField;
    private javax.swing.JPanel simulationPanel;
    private javax.swing.ButtonGroup staticLoadButtonGroup;
    private javax.swing.JRadioButton staticLoadCPRadioButton;
    private javax.swing.JRadioButton staticLoadCZRadioButton;
    private javax.swing.JPanel staticLoadPanel;
    private javax.swing.JLabel staticLoadSwitchDeadZoneLabel;
    private javax.swing.JTextField staticLoadSwitchDeadZoneTextField;
    private javax.swing.JLabel staticLoadSwitchVoltLabel;
    private javax.swing.JTextField staticLoadSwitchVoltTextField;
    private javax.swing.JLabel totalTImeLabel;
    private javax.swing.JTextField totalTimeTextField;
    // End of variables declaration//GEN-END:variables
    
	class DataVerifier extends javax.swing.InputVerifier {
		public boolean verify(javax.swing.JComponent input) {
			if (input == null)
				return false;
			try {
       			if (input == totalTimeTextField ||
           			    input == simuStepTextField ||
           			    input == staticLoadSwitchVoltTextField)
     	       			return VerifyUtil.getDouble((javax.swing.JTextField)input) > 0.0;
			} catch (Exception e) {
				return false;
			}		
			return true;
		}
	}
}
