 /*
  * @(#)NBFaultLocDataPanel.java   
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

package org.interpss.editor.ui.run.common;

import java.util.Vector;

import org.interpss.editor.data.acsc.AcscFaultData;
import org.interpss.editor.form.GFormContainer;
import org.interpss.editor.jgraph.ui.edit.IFormDataPanel;

import com.interpss.common.ui.SwingInputVerifyUtil;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.Number2String;
import com.interpss.simu.SimuContext;
import com.interpss.simu.util.SimuCtxUtilFunc;

public class NBFaultLocDataPanel extends javax.swing.JPanel implements IFormDataPanel{
	private static final long serialVersionUID = 1;

	private GFormContainer _netContainer = null;
    private SimuContext _simuCtx = null;	
	private AcscFaultData _faultData = null;  // current event data
	
    /** Creates new form FaultLocDataPanel */
    public NBFaultLocDataPanel() {
        initComponents();

  		DataVerifier verifier = new DataVerifier();
      	this.distanceTextField.setInputVerifier(verifier);
      	this.atReclosureTimeTextField.setInputVerifier(verifier);
      	this.rLGTextField.setInputVerifier(verifier);
      	this.xLGTextField.setInputVerifier(verifier);
      	this.rLLTextField.setInputVerifier(verifier);
      	this.xLLTextField.setInputVerifier(verifier);
    }
    
	public void init(Object netContainer, Object simuCtx) {
		// for non-graph file, netContainer = null
		IpssLogger.getLogger().info("NBFaultLocDataPanel init() called");

		_netContainer = (GFormContainer)netContainer;
	    _simuCtx = (SimuContext)simuCtx;
      
    	if (_netContainer != null) {
    		this.faultBusComboBox.setModel(new javax.swing.DefaultComboBoxModel(_netContainer.getBusNameIdArray()));
    		Object[] branchNameId = _netContainer.getBranchNameIdArrayNoXfr(_netContainer.getGNetForm().getAppType());
    		if (branchNameId.length > 0)
    			this.faultBranchComboBox.setModel(new javax.swing.DefaultComboBoxModel(branchNameId));
    	}
    	else {
    		this.faultBusComboBox.setModel(new javax.swing.DefaultComboBoxModel(SimuCtxUtilFunc.getBusNameIdArray(_simuCtx)));
    		Object[] branchNameId = SimuCtxUtilFunc.getBranchNameIdArrayNoXfr(_simuCtx);
    		if (branchNameId.length > 0)
    			this.faultBranchComboBox.setModel(new javax.swing.DefaultComboBoxModel(branchNameId));
    	}
	}
	
	public void setFaultData(AcscFaultData data) {
		_faultData = data;
        setBusBranchFaultPanel();
	}
	
	public void setBranchReclosureStatus(boolean status) {
        reclosureCheckBox.setEnabled(status);
        if (!status) {
            reclosureCheckBox.setSelected(status);
            branchReclosureCheckboxActionPerformed(null);
        }
	}
	
    public void setBusBranchFaultPanel() {
        faultLocPanel.remove(busFaultPanel);
        faultLocPanel.remove(branchFaultPanel);
        if (_faultData.getType().equals(AcscFaultData.FaultType_BusFault)) {
            faultLocPanel.add(busFaultPanel);
            if (_faultData.getBusBranchNameId().equals("")) {
                IpssLogger.getLogger().info("faultBusComboBox.getSelectedItem() -> " + this.faultBusComboBox.getSelectedItem());
                if (this.faultBusComboBox.getSelectedItem() != null)
                	this.faultBusComboBox.setSelectedIndex(0);
            }    
            else
                this.faultBusComboBox.setSelectedItem(_faultData.getBusBranchNameId());
            this.distanceTextField.setEnabled(false);
            IpssLogger.getLogger().info("Bus Fault input panel added");
        }	
        else{
            faultLocPanel.add(branchFaultPanel);
           if (_faultData.getBusBranchNameId().equals("")) {
               IpssLogger.getLogger().info("faultBranchComboBox.getSelectedItem() -> " + this.faultBranchComboBox.getSelectedItem());
               this.faultBranchComboBox.setSelectedIndex(0);
           }    
           else
                this.faultBranchComboBox.setSelectedItem(_faultData.getBusBranchNameId());
           this.distanceTextField.setEnabled(true);
           IpssLogger.getLogger().info("Branch Fault input panel added");
        }
    }
    
	/**
	*	Set form data to the editor
	*
	* @return false if there is any problem
	*/
    public boolean setForm2Editor() {
	    reclosureCheckBox.setSelected(_faultData.isBranchReclosure());		
        branchReclosureCheckboxActionPerformed(null);
	    atReclosureTimeTextField.setText(Number2String.toStr(_faultData.getReclosureTime(), "0.00"));

	    if (this.distanceTextField.isEnabled())
        	this.distanceTextField.setText(Number2String.toStr(_faultData.getDistance(), "#0.##"));

        if (_faultData.getCategory().equals(AcscFaultData.FaultCaty_Fault_3P)) 
            this.type3PRadioButton.setSelected(true);
        else if (_faultData.getCategory().equals(AcscFaultData.FaultCaty_Fault_LG)) 
            this.typeLGRadioButton.setSelected(true);
        else if (_faultData.getCategory().equals(AcscFaultData.FaultCaty_Fault_LL)) 
            this.typeLLRadioButton.setSelected(true);
        else if (_faultData.getCategory().equals(AcscFaultData.FaultCaty_Fault_LLG)) 
            this.typeLLGRadioButton.setSelected(true);
        else 
            this.typeAllRadioButton.setSelected(true);

        setLabelText();
		
		if (this.rLGTextField.isEnabled())
			this.rLGTextField.setText(Number2String.toStr(_faultData.getLG_R(), "#0.0000"));
        if (this.xLGTextField.isEnabled())
        	this.xLGTextField.setText(Number2String.toStr(_faultData.getLG_X(), "#0.0000"));
        if (this.rLLTextField.isEnabled())
        	this.rLLTextField.setText(Number2String.toStr(_faultData.getLL_R(), "#0.0000"));
        if (this.xLLTextField.isEnabled())
        	this.xLLTextField.setText(Number2String.toStr(_faultData.getLL_X(), "#0.0000"));

        return true;
	}
    
	/**
	*	Save editor screen data to the form
	*
	* @param errMsg error messages during the saving process.
	* @return false if there is any problem
	*/
    public boolean saveEditor2Form(Vector<String> errMsg) throws Exception {
		IpssLogger.getLogger().info("NBFaultLocDataPanel saveEditor2Form() called");

		boolean ok = true;
    	
    	IpssLogger.getLogger().info("NBFaultLocDataPanel setForm2Editor() called");

        if (_faultData.getType().equals(AcscFaultData.FaultType_BusFault))
        	_faultData.setBusBranchNameId((String)this.faultBusComboBox.getSelectedItem());
		else 
			_faultData.setBusBranchNameId((String)this.faultBranchComboBox.getSelectedItem());
		
		if (this.type3PRadioButton.isSelected())
			_faultData.setCategory(AcscFaultData.FaultCaty_Fault_3P);
		else if (this.typeLGRadioButton.isSelected())
			_faultData.setCategory(AcscFaultData.FaultCaty_Fault_LG);
		else if (this.typeLLRadioButton.isSelected())
			_faultData.setCategory(AcscFaultData.FaultCaty_Fault_LL);
		else if (this.typeLLGRadioButton.isSelected())
			_faultData.setCategory(AcscFaultData.FaultCaty_Fault_LLG);
		else
			_faultData.setCategory(AcscFaultData.FaultCaty_Fault_All);

		_faultData.setBranchReclosure(reclosureCheckBox.isSelected());		
		if (reclosureCheckBox.isSelected()) {
			if (!SwingInputVerifyUtil.largeThan(this.atReclosureTimeTextField, 0.0d)) {
				errMsg.add("Branch reclosure at Time <= 0.0");
				ok = false;
			}
			_faultData.setReclosureTime(SwingInputVerifyUtil.getDouble(this.atReclosureTimeTextField));
		}

	    if (this.distanceTextField.isEnabled()) {
			if (!SwingInputVerifyUtil.largeEqualThan(this.distanceTextField, 0.0d)) {
				errMsg.add("Branch fault distance < 0.0");
				ok = false;
			}
			_faultData.setDistance(SwingInputVerifyUtil.getDouble(this.distanceTextField));
		}

		if (this.rLGTextField.isEnabled()) {
			if (!SwingInputVerifyUtil.largeEqualThan(this.rLGTextField, 0.0d)) {
				errMsg.add("Fault L-G R < 0.0");
				ok = false;
			}
			_faultData.setLG_R(SwingInputVerifyUtil.getDouble(this.rLGTextField));
		}

		if (this.xLGTextField.isEnabled()) {
			if (!SwingInputVerifyUtil.largeEqualThan(this.xLGTextField, 0.0d)) {
				errMsg.add("Fault L-G X < 0.0");
				ok = false;
			}
			_faultData.setLG_X(SwingInputVerifyUtil.getDouble(this.xLGTextField));
		}

		if (this.rLLTextField.isEnabled()) {
			if (!SwingInputVerifyUtil.largeEqualThan(this.rLLTextField, 0.0d)) {
				errMsg.add("Fault L-L R < 0.0");
				ok = false;
			}
			_faultData.setLL_R(SwingInputVerifyUtil.getDouble(this.rLLTextField));
		}

		if (this.xLLTextField.isEnabled()) {
			if (!SwingInputVerifyUtil.largeEqualThan(this.xLLTextField, 0.0d)) {
				errMsg.add("Fault L-L X < 0.0");
				ok = false;
			}
			_faultData.setLL_X(SwingInputVerifyUtil.getDouble(this.xLLTextField));
		}

		return ok;
	}
	
    private void setLabelText() {
		if (this.typeLLGRadioButton.isSelected() || this.typeAllRadioButton.isSelected()) {
			zLGLabel.setEnabled(true);
			rLGTextField.setEnabled(true);
			xLGTextField.setEnabled(true);
			rLLTextField.setEnabled(true);
			xLLTextField.setEnabled(true);
			zLLLabel.setEnabled(true);
		}	
		else if (this.type3PRadioButton.isSelected() ||
				this.typeLGRadioButton.isSelected() ||
				this.typeAllRadioButton.isSelected()) {
			zLGLabel.setEnabled(true);
			rLGTextField.setEnabled(true);
			xLGTextField.setEnabled(true);
			rLLTextField.setEnabled(false);
			xLLTextField.setEnabled(false);
			zLLLabel.setEnabled(false);
		}	
		else if (this.typeLLRadioButton.isSelected()) {
			zLGLabel.setEnabled(false);
			rLGTextField.setEnabled(false);
			xLGTextField.setEnabled(false);
			rLLTextField.setEnabled(true);
			xLLTextField.setEnabled(true);
			zLLLabel.setEnabled(true);
		}	
    }
    
	/** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        faultTypeButtonGroup = new javax.swing.ButtonGroup();
        faultLocPanel = new javax.swing.JPanel();
        busFaultPanel = new javax.swing.JPanel();
        faultBusLabel = new javax.swing.JLabel();
        faultBusComboBox = new javax.swing.JComboBox();
        branchFaultPanel = new javax.swing.JPanel();
        faultBranchLabel = new javax.swing.JLabel();
        faultBranchComboBox = new javax.swing.JComboBox();
        distanceLabel = new javax.swing.JLabel();
        distanceTextField = new javax.swing.JTextField();
        disUnitLabel = new javax.swing.JLabel();
        reclosureCheckBox = new javax.swing.JCheckBox();
        atReclosureTimeLabel = new javax.swing.JLabel();
        atReclosureTimeTextField = new javax.swing.JTextField();
        faultTypePanel = new javax.swing.JPanel();
        typePanel = new javax.swing.JPanel();
        type3PRadioButton = new javax.swing.JRadioButton();
        typeLGRadioButton = new javax.swing.JRadioButton();
        typeLLRadioButton = new javax.swing.JRadioButton();
        typeLLGRadioButton = new javax.swing.JRadioButton();
        typeAllRadioButton = new javax.swing.JRadioButton();
        faultZPanel = new javax.swing.JPanel();
        zLGLabel = new javax.swing.JLabel();
        rLGTextField = new javax.swing.JTextField();
        xLGTextField = new javax.swing.JTextField();
        zLGUnitLabel = new javax.swing.JLabel();
        zLLLabel = new javax.swing.JLabel();
        rLLTextField = new javax.swing.JTextField();
        xLLTextField = new javax.swing.JTextField();
        zLLUnitLabel = new javax.swing.JLabel();

        faultBusLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        faultBusLabel.setText("Fault Bus   ");
        faultBusLabel.setPreferredSize(new java.awt.Dimension(70, 25));

        faultBusComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        faultBusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bus id list" }));
        faultBusComboBox.setName("faultBusComboBox"); // NOI18N

        org.jdesktop.layout.GroupLayout busFaultPanelLayout = new org.jdesktop.layout.GroupLayout(busFaultPanel);
        busFaultPanel.setLayout(busFaultPanelLayout);
        busFaultPanelLayout.setHorizontalGroup(
            busFaultPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(busFaultPanelLayout.createSequentialGroup()
                .add(164, 164, 164)
                .add(faultBusLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(41, 41, 41)
                .add(faultBusComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );
        busFaultPanelLayout.setVerticalGroup(
            busFaultPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, busFaultPanelLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(busFaultPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(faultBusLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(faultBusComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        faultBranchLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        faultBranchLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        faultBranchLabel.setText("Fault Branch     ");
        faultBranchLabel.setPreferredSize(new java.awt.Dimension(90, 25));

        faultBranchComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        faultBranchComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Branch id list" }));
        faultBranchComboBox.setName("faultBranchComboBox"); // NOI18N

        distanceLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        distanceLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        distanceLabel.setText("Fault Distance     ");
        distanceLabel.setPreferredSize(new java.awt.Dimension(100, 25));

        distanceTextField.setColumns(5);
        distanceTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        distanceTextField.setText("0.0");
        distanceTextField.setName("distanceTextField"); // NOI18N

        disUnitLabel.setFont(new java.awt.Font("Dialog", 0, 10));
        disUnitLabel.setText("(% from FromSide)");

        reclosureCheckBox.setFont(new java.awt.Font("Dialog", 0, 12));
        reclosureCheckBox.setText("Branch Reclosure");
        reclosureCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        reclosureCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        reclosureCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchReclosureCheckboxActionPerformed(evt);
            }
        });

        atReclosureTimeLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        atReclosureTimeLabel.setText("at(sec)");
        atReclosureTimeLabel.setEnabled(false);

        atReclosureTimeTextField.setColumns(3);
        atReclosureTimeTextField.setText("0.0");
        atReclosureTimeTextField.setEnabled(false);

        org.jdesktop.layout.GroupLayout branchFaultPanelLayout = new org.jdesktop.layout.GroupLayout(branchFaultPanel);
        branchFaultPanel.setLayout(branchFaultPanelLayout);
        branchFaultPanelLayout.setHorizontalGroup(
            branchFaultPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(branchFaultPanelLayout.createSequentialGroup()
                .add(38, 38, 38)
                .add(branchFaultPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(branchFaultPanelLayout.createSequentialGroup()
                        .add(110, 110, 110)
                        .add(distanceLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(distanceTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(branchFaultPanelLayout.createSequentialGroup()
                        .add(faultBranchLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(faultBranchComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(10, 10, 10)
                .add(branchFaultPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(branchFaultPanelLayout.createSequentialGroup()
                        .add(19, 19, 19)
                        .add(reclosureCheckBox)
                        .add(12, 12, 12)
                        .add(atReclosureTimeLabel)
                        .add(4, 4, 4)
                        .add(atReclosureTimeTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(disUnitLabel))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        branchFaultPanelLayout.setVerticalGroup(
            branchFaultPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, branchFaultPanelLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(branchFaultPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(faultBranchLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(faultBranchComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(reclosureCheckBox)
                    .add(atReclosureTimeLabel)
                    .add(atReclosureTimeTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(10, 10, 10)
                .add(branchFaultPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(distanceLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(branchFaultPanelLayout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(distanceTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(branchFaultPanelLayout.createSequentialGroup()
                        .add(5, 5, 5)
                        .add(disUnitLabel))))
        );

        org.jdesktop.layout.GroupLayout faultLocPanelLayout = new org.jdesktop.layout.GroupLayout(faultLocPanel);
        faultLocPanel.setLayout(faultLocPanelLayout);
        faultLocPanelLayout.setHorizontalGroup(
            faultLocPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, faultLocPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(faultLocPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, busFaultPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, branchFaultPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(40, 40, 40))
        );
        faultLocPanelLayout.setVerticalGroup(
            faultLocPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(faultLocPanelLayout.createSequentialGroup()
                .add(busFaultPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(branchFaultPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        faultTypeButtonGroup.add(type3PRadioButton);
        type3PRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        type3PRadioButton.setSelected(true);
        type3PRadioButton.setText("3P");
        type3PRadioButton.setName("type3PRadioButton"); // NOI18N
        type3PRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type3PRadioButtonActionPerformed(evt);
            }
        });

        faultTypeButtonGroup.add(typeLGRadioButton);
        typeLGRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        typeLGRadioButton.setText("L-G");
        typeLGRadioButton.setName("typeLGRadioButton"); // NOI18N
        typeLGRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeLGRadioButtonActionPerformed(evt);
            }
        });

        faultTypeButtonGroup.add(typeLLRadioButton);
        typeLLRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        typeLLRadioButton.setText("L-L");
        typeLLRadioButton.setName("typeLLRadioButton"); // NOI18N
        typeLLRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeLLRadioButtonActionPerformed(evt);
            }
        });

        faultTypeButtonGroup.add(typeLLGRadioButton);
        typeLLGRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        typeLLGRadioButton.setText("LL-G");
        typeLLGRadioButton.setName("typeLLGRadioButton"); // NOI18N
        typeLLGRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeLLGRadioButtonActionPerformed(evt);
            }
        });

        faultTypeButtonGroup.add(typeAllRadioButton);
        typeAllRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        typeAllRadioButton.setText("All");
        typeAllRadioButton.setEnabled(false);
        typeAllRadioButton.setName("typeAllRadioButton"); // NOI18N
        typeAllRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeAllRadioButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout typePanelLayout = new org.jdesktop.layout.GroupLayout(typePanel);
        typePanel.setLayout(typePanelLayout);
        typePanelLayout.setHorizontalGroup(
            typePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(typePanelLayout.createSequentialGroup()
                .add(20, 20, 20)
                .add(type3PRadioButton)
                .add(20, 20, 20)
                .add(typeLGRadioButton)
                .add(20, 20, 20)
                .add(typeLLRadioButton)
                .add(20, 20, 20)
                .add(typeLLGRadioButton)
                .add(20, 20, 20)
                .add(typeAllRadioButton))
        );
        typePanelLayout.setVerticalGroup(
            typePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(typePanelLayout.createSequentialGroup()
                .add(5, 5, 5)
                .add(typePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(type3PRadioButton)
                    .add(typeLGRadioButton)
                    .add(typeLLRadioButton)
                    .add(typeLLGRadioButton)
                    .add(typeAllRadioButton)))
        );

        zLGLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        zLGLabel.setText("L-G(r+jx)     ");

        rLGTextField.setColumns(8);
        rLGTextField.setText("0.0");
        rLGTextField.setName("rLGTextField"); // NOI18N

        xLGTextField.setColumns(8);
        xLGTextField.setText("0.0");
        xLGTextField.setName("xLGTextField"); // NOI18N

        zLGUnitLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        zLGUnitLabel.setText("     (Ohms)");

        zLLLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        zLLLabel.setText("L-L(r+jx)     ");
        zLLLabel.setEnabled(false);

        rLLTextField.setColumns(8);
        rLLTextField.setText("0.0");
        rLLTextField.setEnabled(false);
        rLLTextField.setName("rLLTextField"); // NOI18N

        xLLTextField.setColumns(8);
        xLLTextField.setText("0.0");
        xLLTextField.setEnabled(false);
        xLLTextField.setName("xLLTextField"); // NOI18N

        zLLUnitLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        zLLUnitLabel.setText("     (Ohms)");
        zLLUnitLabel.setEnabled(false);

        org.jdesktop.layout.GroupLayout faultZPanelLayout = new org.jdesktop.layout.GroupLayout(faultZPanel);
        faultZPanel.setLayout(faultZPanelLayout);
        faultZPanelLayout.setHorizontalGroup(
            faultZPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(faultZPanelLayout.createSequentialGroup()
                .add(zLGLabel)
                .add(rLGTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(20, 20, 20)
                .add(xLGTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(zLGUnitLabel))
            .add(faultZPanelLayout.createSequentialGroup()
                .add(1, 1, 1)
                .add(zLLLabel)
                .add(1, 1, 1)
                .add(rLLTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(20, 20, 20)
                .add(xLLTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(zLLUnitLabel))
        );
        faultZPanelLayout.setVerticalGroup(
            faultZPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(faultZPanelLayout.createSequentialGroup()
                .add(9, 9, 9)
                .add(faultZPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(zLGLabel)
                    .add(faultZPanelLayout.createSequentialGroup()
                        .add(1, 1, 1)
                        .add(rLGTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(faultZPanelLayout.createSequentialGroup()
                        .add(1, 1, 1)
                        .add(xLGTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(zLGUnitLabel))
                .add(5, 5, 5)
                .add(faultZPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(faultZPanelLayout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(zLLLabel))
                    .add(rLLTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(xLLTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(faultZPanelLayout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(zLLUnitLabel))))
        );

        org.jdesktop.layout.GroupLayout faultTypePanelLayout = new org.jdesktop.layout.GroupLayout(faultTypePanel);
        faultTypePanel.setLayout(faultTypePanelLayout);
        faultTypePanelLayout.setHorizontalGroup(
            faultTypePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(faultTypePanelLayout.createSequentialGroup()
                .add(30, 30, 30)
                .add(typePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(faultTypePanelLayout.createSequentialGroup()
                .add(51, 51, 51)
                .add(faultZPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        faultTypePanelLayout.setVerticalGroup(
            faultTypePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(faultTypePanelLayout.createSequentialGroup()
                .add(typePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(10, 10, 10)
                .add(faultZPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(149, 149, 149)
                .add(faultTypePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(faultLocPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(faultLocPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(faultTypePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void branchReclosureCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchReclosureCheckboxActionPerformed
        if (reclosureCheckBox.isSelected()) {
        	atReclosureTimeLabel.setEnabled(true);
        	atReclosureTimeTextField.setEnabled(true);
        }
        else {
        	atReclosureTimeLabel.setEnabled(false);
        	atReclosureTimeTextField.setEnabled(false);
        }
    }//GEN-LAST:event_branchReclosureCheckboxActionPerformed

    private void typeAllRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeAllRadioButtonActionPerformed
        setLabelText();
    }//GEN-LAST:event_typeAllRadioButtonActionPerformed

    private void typeLLGRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeLLGRadioButtonActionPerformed
        setLabelText();
    }//GEN-LAST:event_typeLLGRadioButtonActionPerformed

    private void typeLLRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeLLRadioButtonActionPerformed
        setLabelText();
    }//GEN-LAST:event_typeLLRadioButtonActionPerformed

    private void typeLGRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeLGRadioButtonActionPerformed
        setLabelText();
    }//GEN-LAST:event_typeLGRadioButtonActionPerformed

    private void type3PRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type3PRadioButtonActionPerformed
        setLabelText();
    }//GEN-LAST:event_type3PRadioButtonActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel atReclosureTimeLabel;
    private javax.swing.JTextField atReclosureTimeTextField;
    private javax.swing.JPanel branchFaultPanel;
    private javax.swing.JPanel busFaultPanel;
    private javax.swing.JLabel disUnitLabel;
    private javax.swing.JLabel distanceLabel;
    private javax.swing.JTextField distanceTextField;
    private javax.swing.JComboBox faultBranchComboBox;
    private javax.swing.JLabel faultBranchLabel;
    private javax.swing.JComboBox faultBusComboBox;
    private javax.swing.JLabel faultBusLabel;
    private javax.swing.JPanel faultLocPanel;
    private javax.swing.ButtonGroup faultTypeButtonGroup;
    private javax.swing.JPanel faultTypePanel;
    private javax.swing.JPanel faultZPanel;
    private javax.swing.JTextField rLGTextField;
    private javax.swing.JTextField rLLTextField;
    private javax.swing.JCheckBox reclosureCheckBox;
    private javax.swing.JRadioButton type3PRadioButton;
    private javax.swing.JRadioButton typeAllRadioButton;
    private javax.swing.JRadioButton typeLGRadioButton;
    private javax.swing.JRadioButton typeLLGRadioButton;
    private javax.swing.JRadioButton typeLLRadioButton;
    private javax.swing.JPanel typePanel;
    private javax.swing.JTextField xLGTextField;
    private javax.swing.JTextField xLLTextField;
    private javax.swing.JLabel zLGLabel;
    private javax.swing.JLabel zLGUnitLabel;
    private javax.swing.JLabel zLLLabel;
    private javax.swing.JLabel zLLUnitLabel;
    // End of variables declaration//GEN-END:variables

	class DataVerifier extends javax.swing.InputVerifier {
    	public boolean verify(javax.swing.JComponent input) {
			if (input == null)
				return false;
       		try {
       			if (input == distanceTextField ||
       			    input == rLGTextField ||
       			    input == xLGTextField ||
       			    input == rLLTextField ||
       			    input == xLLTextField )
 	       			return SwingInputVerifyUtil.getDouble((javax.swing.JTextField)input) >= 0.0;
 	       		else if (input == atReclosureTimeTextField)
   	       			return SwingInputVerifyUtil.getDouble((javax.swing.JTextField)input) > 0.0;
 	       	} catch (Exception e) {
 	    		return false;
 	       	}		
			return true;
        }
    }
}
