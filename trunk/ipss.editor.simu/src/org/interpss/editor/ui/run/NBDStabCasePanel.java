 /*
  * @(#)NBDStabCasePanel.java   
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

package org.interpss.editor.ui.run;

import java.util.Vector;

import javax.swing.JDialog;

import org.interpss.editor.data.proj.AclfCaseData;
import org.interpss.editor.data.proj.CaseData;
import org.interpss.editor.data.proj.DStabCaseData;
import org.interpss.editor.form.GFormContainer;
import org.interpss.editor.jgraph.ui.edit.IFormDataPanel;
import org.interpss.editor.ui.run.common.NBDynaEventPanel;

import com.interpss.common.ui.SwingInputVerifyUtil;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.Num2Str;

public class NBDStabCasePanel extends javax.swing.JPanel implements IFormDataPanel {
	private static final long serialVersionUID = 1;

	private NBDynaEventPanel dynaEventPanel = null;
	private NBAclfCasePanel aclfCasePanel = null;

	private GFormContainer netContainer = null;
	
	private AclfCaseData    aclfCaseData = null;  // current case data
	private DStabCaseData   dstabCaseData = null;  // current case data
	private String machIdLargestInertia = "";

    /** Creates new form NBCaseInfoDialog */
    public NBDStabCasePanel(JDialog parent) {
        initComponents();

        dynaEventPanel = new NBDynaEventPanel(parent);
    	aclfCasePanel = new NBAclfCasePanel(parent);

        dynamicEventPanel.add(dynaEventPanel);
        loadflowPanel.add(aclfCasePanel);
        //otherInfoPanel
        
        DataVerifier verifier = new DataVerifier();
        totalTimeTextField.setInputVerifier(verifier);
        simuStepTextField.setInputVerifier(verifier);
        staticLoadSwitchVoltTextField.setInputVerifier(verifier);
    }
    
    public void init(Object netCtr, Object simuCtx) {
		IpssLogger.getLogger().info("NBDStabCasePanel init() called");

		this.netContainer = (GFormContainer)netCtr;
		
        refMachComboBox.setModel(new javax.swing.DefaultComboBoxModel(
        		this.netContainer.getMachIdArray()));
        
        setPointMachineComboBox.setModel(new javax.swing.DefaultComboBoxModel(
        		this.netContainer.getMachIdArray()));
        setControllerList();

        machIdLargestInertia = this.netContainer.getMachIdLargestInertia();
        dynaEventPanel.init(this.netContainer, simuCtx);
        aclfCasePanel.init(this.netContainer, simuCtx);
    }

    private void setControllerList() {
    	String machId = (String)setPointMachineComboBox.getSelectedItem();
    	setPointControllerComboBox.setModel(new javax.swing.DefaultComboBoxModel(
    			this.netContainer.getMachContrllerList(machId)));
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
        
    		setPointCheckBox.setSelected(dstabCaseData.isSetPointChange());
        	if (setPointCheckBox.isSelected()) {
                setPointMachineComboBox.setSelectedItem(dstabCaseData.getSetPointChangeMachId());
            	setPointControllerComboBox.setSelectedItem(dstabCaseData.getSelectedController());
                setPointValueTextField.setText(Num2Str.toStr(dstabCaseData.getSetPointValueChange(), "#0.00"));
                setPointAbsoluteRadioButton.setSelected(dstabCaseData.isSetPointChangeAbsolute());
        	}
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
		
		String method = (String)methodComboBox.getSelectedItem();
		if (method.equals(DStabCaseData.Method_ModifiedEuler)) {
			dstabCaseData.setSimuMethod((String)methodComboBox.getSelectedItem());
		}
		else {
			errMsg.add("Differential Eqn solution method: " + method + " has not implemented yet");
			ok = false;
		}

        if (!SwingInputVerifyUtil.largeThan(totalTimeTextField, 0.0d)) {
			errMsg.add("Total Simulation time < 0.0");
			ok = false;
		}
        dstabCaseData.setTotalSimuTime(SwingInputVerifyUtil.getDouble(totalTimeTextField));
        
        if (!SwingInputVerifyUtil.largeThan(simuStepTextField, 0.0d)) {
			errMsg.add("Simulation step < 0.0");
			ok = false;
		}
        dstabCaseData.setSimuStep(SwingInputVerifyUtil.getDouble(simuStepTextField));
        
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

        if (!SwingInputVerifyUtil.largeThan(netEqnItrNoEventTextField, 0)) {
			errMsg.add("Network equation solution iteration count (no event) <= 0");
			ok = false;
		}
        dstabCaseData.setNetEqnItrNoEvent(SwingInputVerifyUtil.getInt(netEqnItrNoEventTextField));
        
        if (!SwingInputVerifyUtil.largeThan(netEqnItrWithEventTextField, 0)) {
			errMsg.add("Network equation solution iteration count (with event) <= 0");
			ok = false;
		}
        dstabCaseData.setNetEqnItrWithEvent(SwingInputVerifyUtil.getInt(netEqnItrWithEventTextField));
        

        if (staticLoadCZRadioButton.isSelected()) {
        	dstabCaseData.setStaticLoadType(DStabCaseData.StaticLoad_Const_Z);
        }
        else {
        	dstabCaseData.setStaticLoadType(DStabCaseData.StaticLoad_Const_P);
            if (!SwingInputVerifyUtil.largeEqualThan(staticLoadSwitchVoltTextField, 0.4d)) {
    			errMsg.add("Static load model switching voltage < 0.4 pu");
    			ok = false;
    		}
            dstabCaseData.setStaticLoadSwitchVolt(SwingInputVerifyUtil.getDouble(staticLoadSwitchVoltTextField));

            if (!SwingInputVerifyUtil.largeEqualThan(staticLoadSwitchDeadZoneTextField, 0.0d)) {
    			errMsg.add("Static load model switching voltage dead zone< 0.0 pu");
    			ok = false;
    		}
            dstabCaseData.setStaticLoadSwitchDeadZone(SwingInputVerifyUtil.getDouble(staticLoadSwitchDeadZoneTextField));
        }

        dstabCaseData.setDisableDynamicEvent(disableEventCheckBox.isSelected());
        if(!dstabCaseData.getDisableDynamicEvent()) {
        	if (!dynaEventPanel.saveEditor2Form(errMsg))
        		ok = false;
        }
        else {
        	dstabCaseData.setSetPointChange(setPointCheckBox.isSelected());
        	if (setPointCheckBox.isSelected()) {
        		dstabCaseData.setSetPointChangeMachId((String)setPointMachineComboBox.getSelectedItem());
        		dstabCaseData.setSelectedController((String)setPointControllerComboBox.getSelectedItem());
        		dstabCaseData.setSetPointValueChange(SwingInputVerifyUtil.getDouble(setPointValueTextField));
        		dstabCaseData.setSetPointChangeAbsolute(setPointAbsoluteRadioButton.isSelected());
        	}        	
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
        setPointChangeButtonGroup = new javax.swing.ButtonGroup();
        detailInfoTabbedPane = new javax.swing.JTabbedPane();
        simulationPanel = new javax.swing.JPanel();
        simuMathodPanel = new javax.swing.JPanel();
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
        setPointChangePanel = new javax.swing.JPanel();
        setPointCheckBox = new javax.swing.JCheckBox();
        setPointMachineLabel = new javax.swing.JLabel();
        setPointMachineComboBox = new javax.swing.JComboBox();
        setPointControllerLabel = new javax.swing.JLabel();
        setPointControllerComboBox = new javax.swing.JComboBox();
        setPointValueLabel = new javax.swing.JLabel();
        setPointValueTextField = new javax.swing.JTextField();
        setPointAbsoluteRadioButton = new javax.swing.JRadioButton();
        setPointDeltaRadioButton = new javax.swing.JRadioButton();
        dynamicEventPanel = new javax.swing.JPanel();
        loadflowPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        detailInfoTabbedPane.setFont(new java.awt.Font("Dialog", 0, 12));
        detailInfoTabbedPane.setName("detailInfoTabbedPane");
        simulationPanel.setName("advancedPanel");
        methodLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        methodLabel.setText("Simulation Method       ");

        methodComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        methodComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Modified Euler", "Runge Kutta" }));
        methodComboBox.setName("methodComboBox");

        disableEventCheckBox.setFont(new java.awt.Font("Dialog", 0, 12));
        disableEventCheckBox.setText("Disable Dynamic Events");
        disableEventCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        disableEventCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        disableEventCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disableEventCheckBoxActionPerformed(evt);
            }
        });

        totalTImeLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        totalTImeLabel.setText("Total Time(sec)   ");

        totalTimeTextField.setColumns(5);
        totalTimeTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        totalTimeTextField.setText("10.0");
        totalTimeTextField.setName("totalTimeTextField");

        simuStepLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        simuStepLabel.setText("Simu Step(sec)   ");

        simuStepTextField.setColumns(4);
        simuStepTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        simuStepTextField.setText("0.05");
        simuStepTextField.setName("simuStepTextField");

        org.jdesktop.layout.GroupLayout simuMathodPanelLayout = new org.jdesktop.layout.GroupLayout(simuMathodPanel);
        simuMathodPanel.setLayout(simuMathodPanelLayout);
        simuMathodPanelLayout.setHorizontalGroup(
            simuMathodPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(simuMathodPanelLayout.createSequentialGroup()
                .add(38, 38, 38)
                .add(simuMathodPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(methodLabel)
                    .add(totalTImeLabel))
                .add(28, 28, 28)
                .add(simuMathodPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(methodComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(totalTimeTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(simuMathodPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(simuMathodPanelLayout.createSequentialGroup()
                        .add(12, 12, 12)
                        .add(simuStepLabel)
                        .add(25, 25, 25)
                        .add(simuStepTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(simuMathodPanelLayout.createSequentialGroup()
                        .add(51, 51, 51)
                        .add(disableEventCheckBox)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        simuMathodPanelLayout.setVerticalGroup(
            simuMathodPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(simuMathodPanelLayout.createSequentialGroup()
                .add(simuMathodPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(methodLabel)
                    .add(methodComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(disableEventCheckBox))
                .add(18, 18, 18)
                .add(simuMathodPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(totalTImeLabel)
                    .add(totalTimeTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(simuStepLabel)
                    .add(simuStepTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        refMachinejPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        refMachLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        refMachLabel.setText("Ref Machine     ");
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

        netEqnItrLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        netEqnItrLabel.setText("Net Eqn Iterations      ");
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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        staticLoadPanel.add(staticLoadCZRadioButton, gridBagConstraints);

        staticLoadButtonGroup.add(staticLoadCPRadioButton);
        staticLoadCPRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        staticLoadCPRadioButton.setText("Const-P");
        staticLoadCPRadioButton.setName("staticLoadCPRadioButton");
        staticLoadCPRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staticLoadCPRadioButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        staticLoadPanel.add(staticLoadCPRadioButton, gridBagConstraints);

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
        staticLoadSwitchDeadZoneLabel.setText("     DeadZone(pu)   ");
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

        setPointChangePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "SetPoint Change Event", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10), new java.awt.Color(0, 0, 0)));
        setPointChangePanel.setEnabled(false);
        setPointCheckBox.setFont(new java.awt.Font("Dialog", 0, 12));
        setPointCheckBox.setText("SetPoint Change");
        setPointCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        setPointCheckBox.setEnabled(false);
        setPointCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        setPointCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setPointCheckBoxActionPerformed(evt);
            }
        });

        setPointMachineLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        setPointMachineLabel.setText("Machine");
        setPointMachineLabel.setEnabled(false);

        setPointMachineComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        setPointMachineComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        setPointMachineComboBox.setEnabled(false);
        setPointMachineComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setPointMachineListActionPerformed(evt);
            }
        });

        setPointControllerLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        setPointControllerLabel.setText("Controller");
        setPointControllerLabel.setEnabled(false);

        setPointControllerComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        setPointControllerComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        setPointControllerComboBox.setEnabled(false);

        setPointValueLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        setPointValueLabel.setText("SetPoint Value Change(pu)");
        setPointValueLabel.setEnabled(false);

        setPointValueTextField.setColumns(3);
        setPointValueTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        setPointValueTextField.setText("0.0");
        setPointValueTextField.setEnabled(false);

        setPointChangeButtonGroup.add(setPointAbsoluteRadioButton);
        setPointAbsoluteRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        setPointAbsoluteRadioButton.setText("Absolute");
        setPointAbsoluteRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        setPointAbsoluteRadioButton.setEnabled(false);
        setPointAbsoluteRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        setPointChangeButtonGroup.add(setPointDeltaRadioButton);
        setPointDeltaRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        setPointDeltaRadioButton.setSelected(true);
        setPointDeltaRadioButton.setText("Delta");
        setPointDeltaRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        setPointDeltaRadioButton.setEnabled(false);
        setPointDeltaRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        org.jdesktop.layout.GroupLayout setPointChangePanelLayout = new org.jdesktop.layout.GroupLayout(setPointChangePanel);
        setPointChangePanel.setLayout(setPointChangePanelLayout);
        setPointChangePanelLayout.setHorizontalGroup(
            setPointChangePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(setPointChangePanelLayout.createSequentialGroup()
                .add(30, 30, 30)
                .add(setPointChangePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(setPointChangePanelLayout.createSequentialGroup()
                        .add(setPointCheckBox)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 62, Short.MAX_VALUE)
                        .add(setPointMachineLabel)
                        .add(26, 26, 26))
                    .add(setPointChangePanelLayout.createSequentialGroup()
                        .add(setPointValueLabel)
                        .add(40, 40, 40)
                        .add(setPointValueTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(12, 12, 12)))
                .add(setPointChangePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(setPointMachineComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(setPointChangePanelLayout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(setPointAbsoluteRadioButton)))
                .add(35, 35, 35)
                .add(setPointChangePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(setPointChangePanelLayout.createSequentialGroup()
                        .add(setPointControllerLabel)
                        .add(23, 23, 23)
                        .add(setPointControllerComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(setPointDeltaRadioButton))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        setPointChangePanelLayout.setVerticalGroup(
            setPointChangePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(setPointChangePanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(setPointChangePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(setPointCheckBox)
                    .add(setPointControllerComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(setPointControllerLabel)
                    .add(setPointMachineLabel)
                    .add(setPointMachineComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(setPointChangePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(setPointValueLabel)
                    .add(setPointValueTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(setPointDeltaRadioButton)
                    .add(setPointAbsoluteRadioButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout simulationPanelLayout = new org.jdesktop.layout.GroupLayout(simulationPanel);
        simulationPanel.setLayout(simulationPanelLayout);
        simulationPanelLayout.setHorizontalGroup(
            simulationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(simulationPanelLayout.createSequentialGroup()
                .add(simulationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(simulationPanelLayout.createSequentialGroup()
                        .add(100, 100, 100)
                        .add(staticLoadPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 423, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(simulationPanelLayout.createSequentialGroup()
                        .add(35, 35, 35)
                        .add(simulationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(refMachinejPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(netEqnItrPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                            .add(simuMathodPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(setPointChangePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        simulationPanelLayout.setVerticalGroup(
            simulationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(simulationPanelLayout.createSequentialGroup()
                .add(23, 23, 23)
                .add(simuMathodPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(refMachinejPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(netEqnItrPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(21, 21, 21)
                .add(staticLoadPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 94, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(26, 26, 26)
                .add(setPointChangePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        detailInfoTabbedPane.addTab("Simulation", simulationPanel);

        dynamicEventPanel.setName("dynamicEventPanel");
        detailInfoTabbedPane.addTab("Dynamic Events", dynamicEventPanel);

        detailInfoTabbedPane.addTab("Initialization", loadflowPanel);

        add(detailInfoTabbedPane, java.awt.BorderLayout.PAGE_START);

    }// </editor-fold>//GEN-END:initComponents

    private void setPointCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setPointCheckBoxActionPerformed
       	setSetpointPanel(setPointCheckBox.isSelected());
    }//GEN-LAST:event_setPointCheckBoxActionPerformed

    private void setPointMachineListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setPointMachineListActionPerformed
    	setControllerList();
    }//GEN-LAST:event_setPointMachineListActionPerformed

    private void absMachCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_absMachCheckBoxActionPerformed
        refMachLabel.setEnabled(!absMachCheckBox.isSelected());
        refMachComboBox.setEnabled(!absMachCheckBox.isSelected());
    }//GEN-LAST:event_absMachCheckBoxActionPerformed

    private void disableEventCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disableEventCheckBoxActionPerformed
        if(disableEventCheckBox.isSelected()) {
        	detailInfoTabbedPane.setEnabledAt(1, false);
            setPointCheckBox.setEnabled(true);
            if (setPointCheckBox.isSelected())
            	setSetpointPanel(true);
        }	
        else { 
        	detailInfoTabbedPane.setEnabledAt(1, true);
            setPointCheckBox.setEnabled(false);
            setSetpointPanel(false);
        }
    }//GEN-LAST:event_disableEventCheckBoxActionPerformed

    private void staticLoadCPRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staticLoadCPRadioButtonActionPerformed
        setStaticLoadCPStatus(true);
    }//GEN-LAST:event_staticLoadCPRadioButtonActionPerformed

    private void staticLoadCZRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staticLoadCZRadioButtonActionPerformed
        setStaticLoadCPStatus(false);
    }//GEN-LAST:event_staticLoadCZRadioButtonActionPerformed
    
    private void setSetpointPanel(boolean status) {
        setPointAbsoluteRadioButton.setEnabled(status);
        setPointControllerComboBox.setEnabled(status);
        setPointControllerLabel.setEnabled(status);
        setPointDeltaRadioButton.setEnabled(status);
        setPointMachineComboBox.setEnabled(status);
        setPointMachineLabel.setEnabled(status);
        setPointValueLabel.setEnabled(status);
        setPointValueTextField.setEnabled(status);
    }
    
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
    private javax.swing.JPanel loadflowPanel;
    private javax.swing.JComboBox methodComboBox;
    private javax.swing.JLabel methodLabel;
    private javax.swing.JLabel netEqnItrLabel;
    private javax.swing.JLabel netEqnItrNoEventLabel;
    private javax.swing.JTextField netEqnItrNoEventTextField;
    private javax.swing.JPanel netEqnItrPanel;
    private javax.swing.JLabel netEqnItrWithEventLabel;
    private javax.swing.JTextField netEqnItrWithEventTextField;
    private javax.swing.JComboBox refMachComboBox;
    private javax.swing.JLabel refMachLabel;
    private javax.swing.JPanel refMachinejPanel;
    private javax.swing.JRadioButton setPointAbsoluteRadioButton;
    private javax.swing.ButtonGroup setPointChangeButtonGroup;
    private javax.swing.JPanel setPointChangePanel;
    private javax.swing.JCheckBox setPointCheckBox;
    private javax.swing.JComboBox setPointControllerComboBox;
    private javax.swing.JLabel setPointControllerLabel;
    private javax.swing.JRadioButton setPointDeltaRadioButton;
    private javax.swing.JComboBox setPointMachineComboBox;
    private javax.swing.JLabel setPointMachineLabel;
    private javax.swing.JLabel setPointValueLabel;
    private javax.swing.JTextField setPointValueTextField;
    private javax.swing.JPanel simuMathodPanel;
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
     	       			return SwingInputVerifyUtil.getDouble((javax.swing.JTextField)input) > 0.0;
			} catch (Exception e) {
				return false;
			}		
			return true;
		}
	}
}
