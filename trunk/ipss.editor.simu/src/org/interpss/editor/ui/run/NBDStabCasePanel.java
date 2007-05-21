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
import org.interpss.editor.ui.util.GUIFileUtil;

import com.interpss.common.datatype.Constants;
import com.interpss.common.ui.SwingInputVerifyUtil;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.Number2String;
import com.interpss.simu.SimuContext;
import com.interpss.simu.util.SimuCtxUtilFunc;

public class NBDStabCasePanel extends javax.swing.JPanel implements IFormDataPanel {
	public static String OutpuScriptTemplateFilename = "template/DStabOutputScriptTemplate.txt";

	private static final long serialVersionUID = 1;

	private NBDynaEventPanel dynaEventPanel = null;
	private NBAclfCasePanel aclfCasePanel = null;

	private GFormContainer netContainer = null;
	private SimuContext simuCtx = null;
	
	private String dstabOutputScriptFilename;
	
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
	    this.simuCtx = (SimuContext)simuCtx;	
    	if (this.netContainer != null) {
            refMachComboBox.setModel(new javax.swing.DefaultComboBoxModel(this.netContainer.getMachIdArray()));
            setPointMachineComboBox.setModel(new javax.swing.DefaultComboBoxModel(this.netContainer.getMachIdArray()));
            machIdLargestInertia = this.netContainer.getMachIdLargestInertia();
    	}
    	else {
            refMachComboBox.setModel(new javax.swing.DefaultComboBoxModel(SimuCtxUtilFunc.getMachIdArray(this.simuCtx)));
            setPointMachineComboBox.setModel(new javax.swing.DefaultComboBoxModel(SimuCtxUtilFunc.getMachIdArray(this.simuCtx)));
            machIdLargestInertia = SimuCtxUtilFunc.getMachIdLargestInertia(this.simuCtx);
    	}
         
        setControllerList();
        
        setOutputFilterPanel(false);
        setOutputScriptingPanel(false);
        
        dynaEventPanel.init(this.netContainer, simuCtx);
        aclfCasePanel.init(this.netContainer, simuCtx);

        // always set the first tab-panel active
        detailInfoTabbedPane.setSelectedIndex(0);
    }

    
    public void setDStabOutputScriptFilename(String filename) {
    	this.dstabOutputScriptFilename = filename;    
    }
    
    private void setOutputFilterPanel(boolean status) {
    	detailInfoTabbedPane.setEnabledAt(3, status);
    	if (status) {
    	    setOutputVarList();
    	    setMachOutVarList();
    	    setBusOutVarList();
    	    setBranchOutVarList();
    	}
    }
    
    private void setOutputScriptingPanel(boolean status) {
    	detailInfoTabbedPane.setEnabledAt(4, status);
    }

    private void setControllerList() {
    	String machId = (String)setPointMachineComboBox.getSelectedItem();
    	if (this.netContainer != null) {
    		setPointControllerComboBox.setModel(new javax.swing.DefaultComboBoxModel(
    			this.netContainer.getMachContrllerList(machId)));
    	}
    	else {
    		setPointControllerComboBox.setModel(new javax.swing.DefaultComboBoxModel(
    				SimuCtxUtilFunc.getMachContrllerList(machId, this.simuCtx)));
    	}
    }

    private void setOutputVarList() {
    	if (this.netContainer != null) {
    		outputVarList.setModel(new javax.swing.DefaultComboBoxModel(
    			this.dstabCaseData.getOutVarList().toArray()));
    	}
    }

    private void setMachOutVarList() {
    	if (this.netContainer != null) {
    		machOutVarList.setModel(new javax.swing.DefaultComboBoxModel(
    			this.netContainer.getMachIdArray()));
    	}
    }
    
    private void setBusOutVarList() {
    	if (this.netContainer != null) {
    		busOutVarList.setModel(new javax.swing.DefaultComboBoxModel(
    			this.netContainer.getBusIdArray()));
    	}
    }

    private void setBranchOutVarList() {
    	if (this.netContainer != null) {
    		branchOutVarList.setModel(new javax.swing.DefaultComboBoxModel(
    			this.netContainer.getBranchIdArray()));
    	}
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
        totalTimeTextField.setText(Number2String.toStr(dstabCaseData.getTotalSimuTime(), "#0.00"));
        simuStepTextField.setText(Number2String.toStr(dstabCaseData.getSimuStep(), "#0.00#"));
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
            staticLoadSwitchVoltTextField.setText(Number2String.toStr(dstabCaseData.getStaticLoadSwitchVolt(), "#0.00"));
            staticLoadSwitchDeadZoneTextField.setText(Number2String.toStr(dstabCaseData.getStaticLoadSwitchDeadZone(), "#0.00"));
        }
        
        if(!dstabCaseData.getDisableDynamicEvent()) {
        	disableEventCheckBox.setSelected(false);
        	dynaEventPanel.setForm2Editor();
            setSetpointPanel(false);
        }
        else {
        	disableEventCheckBox.setSelected(true);
        
    		setPointCheckBox.setSelected(dstabCaseData.isSetPointChange());
        	if (setPointCheckBox.isSelected()) {
                setPointMachineComboBox.setSelectedItem(dstabCaseData.getSetPointChangeMachId());
            	setPointControllerComboBox.setSelectedItem(dstabCaseData.getSelectedController());
                setPointValueTextField.setText(Number2String.toStr(dstabCaseData.getSetPointValueChange(), "#0.00"));
                setPointAbsoluteRadioButton.setSelected(dstabCaseData.isSetPointChangeAbsolute());
        	}
        }
        disableEventCheckBoxActionPerformed(null);

        outputFilterCheckBox.setSelected(dstabCaseData.isOutputFilter());
        setOutputFilterPanel(outputFilterCheckBox.isSelected());

        outputScriptCheckBox.setSelected(dstabCaseData.isOutputScripting());
        setOutputScriptingPanel(outputScriptCheckBox.isSelected());
        if (outputScriptCheckBox.isSelected()) {
            if (dstabOutputScriptFilename != null) {
            	IpssLogger.getLogger().info("scriptFilename: " + dstabOutputScriptFilename);
            	GUIFileUtil.readFile2TextareaAbsolutePath(dstabOutputScriptFilename, scriptTextArea);
            	if (scriptTextArea.getText().trim().equals(""))
                	GUIFileUtil.readFile2TextareaRativePath(OutpuScriptTemplateFilename, scriptTextArea);
            }         
        }
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
        	if (setPointCheckBox.isSelected()) {
        		String str = (String)setPointControllerComboBox.getSelectedItem();
        		if (!str.equals(Constants.NoControllerToken)) {
        			dstabCaseData.setSetPointChange(setPointCheckBox.isSelected());
        			if (setPointCheckBox.isSelected()) {
            			dstabCaseData.setSetPointChangeMachId((String)setPointMachineComboBox.getSelectedItem());
            			dstabCaseData.setSelectedController((String)setPointControllerComboBox.getSelectedItem());
            			dstabCaseData.setSetPointValueChange(SwingInputVerifyUtil.getDouble(setPointValueTextField));
            			dstabCaseData.setSetPointChangeAbsolute(setPointAbsoluteRadioButton.isSelected());
            		}
            	}        	
        	}
        }
        IpssLogger.getLogger().info("" + dstabCaseData);

        dstabCaseData.setOutputFilter(outputFilterCheckBox.isSelected());
        dstabCaseData.setOutputScripting(outputScriptCheckBox.isSelected());
        if (outputScriptCheckBox.isSelected() && dstabOutputScriptFilename != null) {
        	GUIFileUtil.writeTextarea2FileAbsolutePath(dstabOutputScriptFilename, scriptTextArea);
        	dstabCaseData.setOutputScriptFilename(dstabOutputScriptFilename);
    	}        
        
        return ok;
	}
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
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
        netEqnItrWithEventLabel = new javax.swing.JLabel();
        netEqnItrWithEventTextField = new javax.swing.JTextField();
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
        outputOptPanel = new javax.swing.JPanel();
        outputFilterCheckBox = new javax.swing.JCheckBox();
        outputScriptCheckBox = new javax.swing.JCheckBox();
        dynamicEventPanel = new javax.swing.JPanel();
        loadflowPanel = new javax.swing.JPanel();
        outputFilterPanel = new javax.swing.JPanel();
        outputVarLabel = new javax.swing.JLabel();
        outputVarScrollPane = new javax.swing.JScrollPane();
        outputVarList = new javax.swing.JList();
        machVarLabel = new javax.swing.JLabel();
        machOutVarScrollPane = new javax.swing.JScrollPane();
        machOutVarList = new javax.swing.JList();
        busOutVarLabel = new javax.swing.JLabel();
        busOutVarScrollPane = new javax.swing.JScrollPane();
        busOutVarList = new javax.swing.JList();
        branchOutVarLabel = new javax.swing.JLabel();
        branchVarScrollPane = new javax.swing.JScrollPane();
        branchOutVarList = new javax.swing.JList();
        addOutVarButton = new javax.swing.JButton();
        removeOurVarButton = new javax.swing.JButton();
        addAllOutVarButton = new javax.swing.JButton();
        outScriptingjPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        scriptTextArea = new javax.swing.JTextArea();

        setLayout(new java.awt.BorderLayout());

        detailInfoTabbedPane.setFont(new java.awt.Font("Dialog", 0, 12));
        detailInfoTabbedPane.setName("detailInfoTabbedPane");
        simulationPanel.setFont(new java.awt.Font("Dialog", 0, 12));
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

        refMachLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        refMachLabel.setText("Ref Machine     ");

        refMachComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        refMachComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        absMachCheckBox.setFont(new java.awt.Font("Dialog", 0, 12));
        absMachCheckBox.setText("Absolute Machine Angle");
        absMachCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        absMachCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        absMachCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                absMachCheckBoxActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout refMachinejPanelLayout = new org.jdesktop.layout.GroupLayout(refMachinejPanel);
        refMachinejPanel.setLayout(refMachinejPanelLayout);
        refMachinejPanelLayout.setHorizontalGroup(
            refMachinejPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(refMachinejPanelLayout.createSequentialGroup()
                .add(32, 32, 32)
                .add(refMachLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(refMachComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 125, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 36, Short.MAX_VALUE)
                .add(absMachCheckBox)
                .add(19, 19, 19))
        );
        refMachinejPanelLayout.setVerticalGroup(
            refMachinejPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(refMachinejPanelLayout.createSequentialGroup()
                .add(5, 5, 5)
                .add(refMachinejPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(refMachLabel)
                    .add(absMachCheckBox)
                    .add(refMachComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        netEqnItrLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        netEqnItrLabel.setText("Net Eqn Iterations      ");

        netEqnItrNoEventTextField.setColumns(2);
        netEqnItrNoEventTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        netEqnItrNoEventTextField.setText("3");
        netEqnItrNoEventTextField.setName("totalTimeTextField");

        netEqnItrNoEventLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        netEqnItrNoEventLabel.setText("(No Event)      ");

        netEqnItrWithEventLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        netEqnItrWithEventLabel.setText("(With Event)   ");

        netEqnItrWithEventTextField.setColumns(2);
        netEqnItrWithEventTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        netEqnItrWithEventTextField.setText("5");
        netEqnItrWithEventTextField.setName("simuStepTextField");

        org.jdesktop.layout.GroupLayout netEqnItrPanelLayout = new org.jdesktop.layout.GroupLayout(netEqnItrPanel);
        netEqnItrPanel.setLayout(netEqnItrPanelLayout);
        netEqnItrPanelLayout.setHorizontalGroup(
            netEqnItrPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(netEqnItrPanelLayout.createSequentialGroup()
                .add(22, 22, 22)
                .add(netEqnItrLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(netEqnItrNoEventTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(30, 30, 30)
                .add(netEqnItrNoEventLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(netEqnItrWithEventTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(17, 17, 17)
                .add(netEqnItrWithEventLabel)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        netEqnItrPanelLayout.setVerticalGroup(
            netEqnItrPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(netEqnItrPanelLayout.createSequentialGroup()
                .add(netEqnItrPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, netEqnItrPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(netEqnItrLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(netEqnItrNoEventTextField))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, netEqnItrPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(netEqnItrNoEventLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                        .add(netEqnItrWithEventTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, netEqnItrWithEventLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addContainerGap())
        );

        staticLoadPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "static Load model", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10)));
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

        staticLoadButtonGroup.add(staticLoadCPRadioButton);
        staticLoadCPRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        staticLoadCPRadioButton.setText("Const-P");
        staticLoadCPRadioButton.setName("staticLoadCPRadioButton");
        staticLoadCPRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staticLoadCPRadioButtonActionPerformed(evt);
            }
        });

        staticLoadSwitchVoltLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        staticLoadSwitchVoltLabel.setText("Switch Volt(pu)   ");
        staticLoadSwitchVoltLabel.setToolTipText("Constant-P model will be switched to the Constant-Z model when the voltage is lower than the switch voltage.");
        staticLoadSwitchVoltLabel.setEnabled(false);

        staticLoadSwitchVoltTextField.setColumns(4);
        staticLoadSwitchVoltTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        staticLoadSwitchVoltTextField.setText("0.65");
        staticLoadSwitchVoltTextField.setEnabled(false);
        staticLoadSwitchVoltTextField.setName("staticLoadSwitchVoltTextField");

        staticLoadSwitchDeadZoneLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        staticLoadSwitchDeadZoneLabel.setText("     DeadZone(pu)   ");
        staticLoadSwitchDeadZoneLabel.setToolTipText("Constant-P model will be switched to the Constant-Z model when the voltage is lower than the switch voltage.");
        staticLoadSwitchDeadZoneLabel.setAlignmentY(0.05F);
        staticLoadSwitchDeadZoneLabel.setEnabled(false);

        staticLoadSwitchDeadZoneTextField.setColumns(4);
        staticLoadSwitchDeadZoneTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        staticLoadSwitchDeadZoneTextField.setText("0.05");
        staticLoadSwitchDeadZoneTextField.setAlignmentY(0.05F);
        staticLoadSwitchDeadZoneTextField.setEnabled(false);
        staticLoadSwitchDeadZoneTextField.setName("staticLoadSwitchVoltTextField");

        org.jdesktop.layout.GroupLayout staticLoadPanelLayout = new org.jdesktop.layout.GroupLayout(staticLoadPanel);
        staticLoadPanel.setLayout(staticLoadPanelLayout);
        staticLoadPanelLayout.setHorizontalGroup(
            staticLoadPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(staticLoadPanelLayout.createSequentialGroup()
                .add(104, 104, 104)
                .add(staticLoadCZRadioButton)
                .add(58, 58, 58)
                .add(staticLoadCPRadioButton)
                .addContainerGap(104, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, staticLoadPanelLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .add(staticLoadSwitchVoltLabel)
                .add(24, 24, 24)
                .add(staticLoadSwitchVoltTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(staticLoadSwitchDeadZoneLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(staticLoadSwitchDeadZoneTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(51, 51, 51))
        );
        staticLoadPanelLayout.setVerticalGroup(
            staticLoadPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(staticLoadPanelLayout.createSequentialGroup()
                .add(staticLoadPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(staticLoadCZRadioButton)
                    .add(staticLoadCPRadioButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(staticLoadPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(staticLoadSwitchDeadZoneTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(staticLoadPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(staticLoadSwitchVoltLabel)
                        .add(staticLoadSwitchVoltTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(staticLoadPanelLayout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(staticLoadSwitchDeadZoneLabel)))
                .addContainerGap())
        );

        setPointChangePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controller SetPoint Change", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10)));
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
                .add(setPointCheckBox)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 62, Short.MAX_VALUE)
                .add(setPointMachineLabel)
                .add(26, 26, 26)
                .add(setPointMachineComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(35, 35, 35)
                .add(setPointControllerLabel)
                .add(23, 23, 23)
                .add(setPointControllerComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
            .add(setPointChangePanelLayout.createSequentialGroup()
                .add(57, 57, 57)
                .add(setPointValueLabel)
                .add(40, 40, 40)
                .add(setPointValueTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(22, 22, 22)
                .add(setPointAbsoluteRadioButton)
                .add(35, 35, 35)
                .add(setPointDeltaRadioButton)
                .addContainerGap(89, Short.MAX_VALUE))
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

        outputOptPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Output Options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10)));
        outputFilterCheckBox.setFont(new java.awt.Font("Dialog", 0, 12));
        outputFilterCheckBox.setText("Output state/variable Filter");
        outputFilterCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        outputFilterCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        outputFilterCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputFilterCheckBoxActionPerformed(evt);
            }
        });

        outputScriptCheckBox.setFont(new java.awt.Font("Dialog", 0, 12));
        outputScriptCheckBox.setText("Output Result Scripting");
        outputScriptCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        outputScriptCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        outputScriptCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputScriptCheckBoxActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout outputOptPanelLayout = new org.jdesktop.layout.GroupLayout(outputOptPanel);
        outputOptPanel.setLayout(outputOptPanelLayout);
        outputOptPanelLayout.setHorizontalGroup(
            outputOptPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(outputOptPanelLayout.createSequentialGroup()
                .add(88, 88, 88)
                .add(outputFilterCheckBox)
                .add(68, 68, 68)
                .add(outputScriptCheckBox)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        outputOptPanelLayout.setVerticalGroup(
            outputOptPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(outputOptPanelLayout.createSequentialGroup()
                .add(outputOptPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(outputFilterCheckBox)
                    .add(outputScriptCheckBox))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout simulationPanelLayout = new org.jdesktop.layout.GroupLayout(simulationPanel);
        simulationPanel.setLayout(simulationPanelLayout);
        simulationPanelLayout.setHorizontalGroup(
            simulationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(simulationPanelLayout.createSequentialGroup()
                .add(simulationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(simulationPanelLayout.createSequentialGroup()
                        .add(35, 35, 35)
                        .add(simulationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(simuMathodPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(simulationPanelLayout.createSequentialGroup()
                                .add(48, 48, 48)
                                .add(refMachinejPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(setPointChangePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(simulationPanelLayout.createSequentialGroup()
                                .add(58, 58, 58)
                                .add(netEqnItrPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(simulationPanelLayout.createSequentialGroup()
                                .add(16, 16, 16)
                                .add(outputOptPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                    .add(simulationPanelLayout.createSequentialGroup()
                        .add(107, 107, 107)
                        .add(staticLoadPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
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
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(outputOptPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(staticLoadPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(setPointChangePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(38, 38, 38))
        );
        detailInfoTabbedPane.addTab("Simulation", simulationPanel);

        dynamicEventPanel.setFont(new java.awt.Font("Dialog", 0, 12));
        dynamicEventPanel.setName("dynamicEventPanel");
        detailInfoTabbedPane.addTab("Dynamic Events", dynamicEventPanel);

        loadflowPanel.setFont(new java.awt.Font("Dialog", 0, 12));
        detailInfoTabbedPane.addTab("Initialization", loadflowPanel);

        outputFilterPanel.setEnabled(false);
        outputFilterPanel.setFont(new java.awt.Font("Dialog", 0, 12));
        outputVarLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        outputVarLabel.setText("Output States/Variables");

        outputVarList.setFont(new java.awt.Font("Dialog", 0, 12));
        outputVarList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        outputVarScrollPane.setViewportView(outputVarList);

        machVarLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        machVarLabel.setText("Machine States");

        machOutVarList.setFont(new java.awt.Font("Dialog", 0, 12));
        machOutVarList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        machOutVarScrollPane.setViewportView(machOutVarList);

        busOutVarLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        busOutVarLabel.setText("Bus Variables");

        busOutVarList.setFont(new java.awt.Font("Dialog", 0, 12));
        busOutVarList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        busOutVarScrollPane.setViewportView(busOutVarList);

        branchOutVarLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        branchOutVarLabel.setText("Branch Variables");
        branchOutVarLabel.setEnabled(false);

        branchOutVarList.setFont(new java.awt.Font("Dialog", 0, 12));
        branchOutVarList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        branchOutVarList.setEnabled(false);
        branchVarScrollPane.setViewportView(branchOutVarList);

        addOutVarButton.setFont(new java.awt.Font("Dialog", 0, 12));
        addOutVarButton.setText(">");
        addOutVarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOutVarButtonActionPerformed(evt);
            }
        });

        removeOurVarButton.setFont(new java.awt.Font("Dialog", 0, 12));
        removeOurVarButton.setText("<");
        removeOurVarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeOurVarButtonActionPerformed(evt);
            }
        });

        addAllOutVarButton.setFont(new java.awt.Font("Dialog", 0, 12));
        addAllOutVarButton.setText("All > ");
        addAllOutVarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAllOutVarButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout outputFilterPanelLayout = new org.jdesktop.layout.GroupLayout(outputFilterPanel);
        outputFilterPanel.setLayout(outputFilterPanelLayout);
        outputFilterPanelLayout.setHorizontalGroup(
            outputFilterPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(outputFilterPanelLayout.createSequentialGroup()
                .add(60, 60, 60)
                .add(outputFilterPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(outputFilterPanelLayout.createSequentialGroup()
                        .add(outputFilterPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(branchOutVarLabel)
                            .add(machVarLabel))
                        .add(283, 283, 283))
                    .add(outputFilterPanelLayout.createSequentialGroup()
                        .add(outputFilterPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, branchVarScrollPane)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, busOutVarLabel)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, machOutVarScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, busOutVarScrollPane))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 36, Short.MAX_VALUE)
                        .add(outputFilterPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(addAllOutVarButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(removeOurVarButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(addOutVarButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(87, 87, 87)))
                .add(outputFilterPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(outputVarLabel)
                    .add(outputFilterPanelLayout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(outputVarScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 197, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(58, 58, 58))
        );
        outputFilterPanelLayout.setVerticalGroup(
            outputFilterPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(outputFilterPanelLayout.createSequentialGroup()
                .add(outputFilterPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(outputFilterPanelLayout.createSequentialGroup()
                        .add(21, 21, 21)
                        .add(outputFilterPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(machVarLabel)
                            .add(outputVarLabel))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(outputFilterPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(outputFilterPanelLayout.createSequentialGroup()
                                .add(machOutVarScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 102, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(22, 22, 22)
                                .add(busOutVarLabel)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(busOutVarScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(24, 24, 24)
                                .add(branchOutVarLabel)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(branchVarScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(outputVarScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)))
                    .add(outputFilterPanelLayout.createSequentialGroup()
                        .add(180, 180, 180)
                        .add(addOutVarButton)
                        .add(22, 22, 22)
                        .add(removeOurVarButton)
                        .add(20, 20, 20)
                        .add(addAllOutVarButton)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        detailInfoTabbedPane.addTab("Output Filter", outputFilterPanel);

        outScriptingjPanel.setFont(new java.awt.Font("Dialog", 0, 12));
        scriptTextArea.setColumns(20);
        scriptTextArea.setFont(new java.awt.Font("Courier New", 0, 12));
        scriptTextArea.setRows(5);
        jScrollPane1.setViewportView(scriptTextArea);

        org.jdesktop.layout.GroupLayout outScriptingjPanelLayout = new org.jdesktop.layout.GroupLayout(outScriptingjPanel);
        outScriptingjPanel.setLayout(outScriptingjPanelLayout);
        outScriptingjPanelLayout.setHorizontalGroup(
            outScriptingjPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(outScriptingjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                .addContainerGap())
        );
        outScriptingjPanelLayout.setVerticalGroup(
            outScriptingjPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(outScriptingjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addContainerGap())
        );
        detailInfoTabbedPane.addTab("Output Scripting", outScriptingjPanel);

        add(detailInfoTabbedPane, java.awt.BorderLayout.NORTH);

    }// </editor-fold>//GEN-END:initComponents

    private void addOutVarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOutVarButtonActionPerformed
    	for (Object obj : this.machOutVarList.getSelectedValues()) {
    		String id = "Machine - " + (String)obj;
    		if (!this.dstabCaseData.getOutVarList().contains(id))
    			this.dstabCaseData.getOutVarList().add(id);
    	}
    	for (Object obj : this.busOutVarList.getSelectedValues()) {
    		String id = "Bus - " + (String)obj;
    		if (!this.dstabCaseData.getOutVarList().contains(id))
    			this.dstabCaseData.getOutVarList().add(id);
    	}
    	for (Object obj : this.branchOutVarList.getSelectedValues()) {
    		String id = "Branch - " + (String)obj;
    		if (!this.dstabCaseData.getOutVarList().contains(id))
    			this.dstabCaseData.getOutVarList().add(id);
    	}
    	setOutputVarList();
    }//GEN-LAST:event_addOutVarButtonActionPerformed

    private void removeOurVarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeOurVarButtonActionPerformed
    	for (Object obj : this.outputVarList.getSelectedValues())
   			this.dstabCaseData.getOutVarList().remove((String)obj);
    	setOutputVarList();
    }//GEN-LAST:event_removeOurVarButtonActionPerformed

    private void addAllOutVarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAllOutVarButtonActionPerformed
    	for (Object obj : this.netContainer.getMachIdArray())
    		if (!this.dstabCaseData.getOutVarList().contains(obj))
    			this.dstabCaseData.getOutVarList().add((String)obj);
    	for (Object obj : this.netContainer.getBusIdArray())
    		if (!this.dstabCaseData.getOutVarList().contains(obj))
    			this.dstabCaseData.getOutVarList().add((String)obj);
    	setOutputVarList();
    }//GEN-LAST:event_addAllOutVarButtonActionPerformed

    private void outputScriptCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputScriptCheckBoxActionPerformed
        setOutputScriptingPanel(outputScriptCheckBox.isSelected());
        if (outputScriptCheckBox.isSelected()) {
            if (dstabOutputScriptFilename != null) {
            	IpssLogger.getLogger().info("scriptFilename: " + dstabOutputScriptFilename);
            	GUIFileUtil.readFile2TextareaRativePath(dstabOutputScriptFilename, scriptTextArea);
            	if (scriptTextArea.getText().trim().equals(""))
                	GUIFileUtil.readFile2TextareaRativePath(OutpuScriptTemplateFilename, scriptTextArea);
            }         
        }
    }//GEN-LAST:event_outputScriptCheckBoxActionPerformed

    private void outputFilterCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputFilterCheckBoxActionPerformed
        setOutputFilterPanel(outputFilterCheckBox.isSelected());
    }//GEN-LAST:event_outputFilterCheckBoxActionPerformed

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
    private javax.swing.JButton addAllOutVarButton;
    private javax.swing.JButton addOutVarButton;
    private javax.swing.JLabel branchOutVarLabel;
    private javax.swing.JList branchOutVarList;
    private javax.swing.JScrollPane branchVarScrollPane;
    private javax.swing.JLabel busOutVarLabel;
    private javax.swing.JList busOutVarList;
    private javax.swing.JScrollPane busOutVarScrollPane;
    private javax.swing.JTabbedPane detailInfoTabbedPane;
    private javax.swing.JCheckBox disableEventCheckBox;
    private javax.swing.JPanel dynamicEventPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel loadflowPanel;
    private javax.swing.JList machOutVarList;
    private javax.swing.JScrollPane machOutVarScrollPane;
    private javax.swing.JLabel machVarLabel;
    private javax.swing.JComboBox methodComboBox;
    private javax.swing.JLabel methodLabel;
    private javax.swing.JLabel netEqnItrLabel;
    private javax.swing.JLabel netEqnItrNoEventLabel;
    private javax.swing.JTextField netEqnItrNoEventTextField;
    private javax.swing.JPanel netEqnItrPanel;
    private javax.swing.JLabel netEqnItrWithEventLabel;
    private javax.swing.JTextField netEqnItrWithEventTextField;
    private javax.swing.JPanel outScriptingjPanel;
    private javax.swing.JCheckBox outputFilterCheckBox;
    private javax.swing.JPanel outputFilterPanel;
    private javax.swing.JPanel outputOptPanel;
    private javax.swing.JCheckBox outputScriptCheckBox;
    private javax.swing.JLabel outputVarLabel;
    private javax.swing.JList outputVarList;
    private javax.swing.JScrollPane outputVarScrollPane;
    private javax.swing.JComboBox refMachComboBox;
    private javax.swing.JLabel refMachLabel;
    private javax.swing.JPanel refMachinejPanel;
    private javax.swing.JButton removeOurVarButton;
    private javax.swing.JTextArea scriptTextArea;
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
