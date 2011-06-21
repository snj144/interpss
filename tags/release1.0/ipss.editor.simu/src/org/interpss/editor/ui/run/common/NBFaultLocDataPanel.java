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

import com.interpss.common.ui.VerifyUtil;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.Num2Str;

public class NBFaultLocDataPanel extends javax.swing.JPanel implements IFormDataPanel{
	private static final long serialVersionUID = 1;

	private GFormContainer _netContainer = null;
	private AcscFaultData _faultData = null;
	
    /** Creates new form FaultLocDataPanel */
    public NBFaultLocDataPanel() {
        initComponents();

  		DataVerifier verifier = new DataVerifier();
      	this.distanceTextField.setInputVerifier(verifier);
      	this.rLGTextField.setInputVerifier(verifier);
      	this.xLGTextField.setInputVerifier(verifier);
      	this.rLLTextField.setInputVerifier(verifier);
      	this.xLLTextField.setInputVerifier(verifier);
    }
    
	public void init(Object netContainer, Object _null) {
		IpssLogger.getLogger().info("NBFaultLocDataPanel init() called");

		_netContainer = (GFormContainer)netContainer;
      
    	this.faultBusComboBox.setModel(new javax.swing.DefaultComboBoxModel(_netContainer.getBusNameIdArray()));

    	Object[] branchNameId = _netContainer.getBranchNameIdArrayNoXfr(_netContainer.getGNetForm().getAppType());
    	if (branchNameId.length > 0)
    		this.faultBranchComboBox.setModel(new javax.swing.DefaultComboBoxModel(branchNameId));
    	
	}
	
	public void setFaultData(AcscFaultData data) {
		_faultData = data;
        setBusBranchFaultPanel();
	}
	
    public void setBusBranchFaultPanel() {
        faultLocPanel.remove(busFaultPanel);
        faultLocPanel.remove(branchFaultPanel);
        if (_faultData.getType().equals(AcscFaultData.FaultType_Bus)) {
            faultLocPanel.add(busFaultPanel, java.awt.BorderLayout.NORTH);
            if (_faultData.getBusBranchNameId().equals("")) {
                IpssLogger.getLogger().info("faultBusComboBox.getSelectedItem() -> " + this.faultBusComboBox.getSelectedItem());
                this.faultBusComboBox.setSelectedIndex(0);
            }    
            else
                this.faultBusComboBox.setSelectedItem(_faultData.getBusBranchNameId());
            this.distanceTextField.setEnabled(false);
            IpssLogger.getLogger().info("Bus Fault input panel added");
        }	
        else{
            faultLocPanel.add(branchFaultPanel, java.awt.BorderLayout.NORTH);
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
		IpssLogger.getLogger().info("NBFaultLocDataPanel setForm2Editor() called");

		if (this.distanceTextField.isEnabled())
        	this.distanceTextField.setText(Num2Str.toStr(_faultData.getDistance(), "#0.##"));

        if (_faultData.getCategory().equals(AcscFaultData.FaultCaty_3P)) 
            this.type3PRadioButton.setSelected(true);
        else if (_faultData.getCategory().equals(AcscFaultData.FaultCaty_LG)) 
            this.typeLGRadioButton.setSelected(true);
        else if (_faultData.getCategory().equals(AcscFaultData.FaultCaty_LL)) 
            this.typeLLRadioButton.setSelected(true);
        else if (_faultData.getCategory().equals(AcscFaultData.FaultCaty_LLG)) 
            this.typeLLGRadioButton.setSelected(true);
        else 
            this.typeAllRadioButton.setSelected(true);

        setLabelText();
		
		if (this.rLGTextField.isEnabled())
			this.rLGTextField.setText(Num2Str.toStr(_faultData.getLG_R(), "#0.0000"));
        if (this.xLGTextField.isEnabled())
        	this.xLGTextField.setText(Num2Str.toStr(_faultData.getLG_X(), "#0.0000"));
        if (this.rLLTextField.isEnabled())
        	this.rLLTextField.setText(Num2Str.toStr(_faultData.getLL_R(), "#0.0000"));
        if (this.xLLTextField.isEnabled())
        	this.xLLTextField.setText(Num2Str.toStr(_faultData.getLL_X(), "#0.0000"));

        return true;
	}
    
	/**
	*	Save editor screen data to the form
	*
	* @param errMsg error messages during the saving process.
	* @return false if there is any problem
	*/
    public boolean saveEditor2Form(Vector errMsg) throws Exception {
		IpssLogger.getLogger().info("NBFaultLocDataPanel saveEditor2Form() called");

		boolean ok = true;

		if (_faultData.getType().equals(AcscFaultData.FaultType_Bus))
			_faultData.setBusBranchNameId((String)this.faultBusComboBox.getSelectedItem());
		else 
			_faultData.setBusBranchNameId((String)this.faultBranchComboBox.getSelectedItem());
		
		if (this.type3PRadioButton.isSelected())
			_faultData.setCategory(AcscFaultData.FaultCaty_3P);
		else if (this.typeLGRadioButton.isSelected())
			_faultData.setCategory(AcscFaultData.FaultCaty_LG);
		else if (this.typeLLRadioButton.isSelected())
			_faultData.setCategory(AcscFaultData.FaultCaty_LL);
		else if (this.typeLLGRadioButton.isSelected())
			_faultData.setCategory(AcscFaultData.FaultCaty_LLG);
		else
			_faultData.setCategory(AcscFaultData.FaultCaty_All);

		if (this.distanceTextField.isEnabled()) {
			if (!VerifyUtil.largeEqualThan(this.distanceTextField, 0.0d)) {
				errMsg.add("Branch fault distance < 0.0");
				ok = false;
			}
			_faultData.setDistance(VerifyUtil.getDouble(this.distanceTextField));
		}

		if (this.rLGTextField.isEnabled()) {
			if (!VerifyUtil.largeEqualThan(this.rLGTextField, 0.0d)) {
				errMsg.add("Fault L-G R < 0.0");
				ok = false;
			}
			_faultData.setLG_R(VerifyUtil.getDouble(this.rLGTextField));
		}

		if (this.xLGTextField.isEnabled()) {
			if (!VerifyUtil.largeEqualThan(this.xLGTextField, 0.0d)) {
				errMsg.add("Fault L-G X < 0.0");
				ok = false;
			}
			_faultData.setLG_X(VerifyUtil.getDouble(this.xLGTextField));
		}

		if (this.rLLTextField.isEnabled()) {
			if (!VerifyUtil.largeEqualThan(this.rLLTextField, 0.0d)) {
				errMsg.add("Fault L-L R < 0.0");
				ok = false;
			}
			_faultData.setLL_R(VerifyUtil.getDouble(this.rLLTextField));
		}

		if (this.xLLTextField.isEnabled()) {
			if (!VerifyUtil.largeEqualThan(this.xLLTextField, 0.0d)) {
				errMsg.add("Fault L-L X < 0.0");
				ok = false;
			}
			_faultData.setLL_X(VerifyUtil.getDouble(this.xLLTextField));
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
        java.awt.GridBagConstraints gridBagConstraints;

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

        setLayout(new java.awt.BorderLayout());

        faultLocPanel.setLayout(new java.awt.BorderLayout());

        faultBusLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        faultBusLabel.setText("Fault Bus   ");
        faultBusLabel.setPreferredSize(new java.awt.Dimension(70, 25));
        busFaultPanel.add(faultBusLabel);

        faultBusComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        faultBusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bus id list" }));
        faultBusComboBox.setName("faultBusComboBox");
        busFaultPanel.add(faultBusComboBox);

        faultLocPanel.add(busFaultPanel, java.awt.BorderLayout.NORTH);

        branchFaultPanel.setLayout(new java.awt.GridBagLayout());

        faultBranchLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        faultBranchLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        faultBranchLabel.setText("Fault Branch     ");
        faultBranchLabel.setPreferredSize(new java.awt.Dimension(90, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 0);
        branchFaultPanel.add(faultBranchLabel, gridBagConstraints);

        faultBranchComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        faultBranchComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Branch id list" }));
        faultBranchComboBox.setName("faultBranchComboBox");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        branchFaultPanel.add(faultBranchComboBox, gridBagConstraints);

        distanceLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        distanceLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        distanceLabel.setText("Fault Distance     ");
        distanceLabel.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 0);
        branchFaultPanel.add(distanceLabel, gridBagConstraints);

        distanceTextField.setColumns(5);
        distanceTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        distanceTextField.setText("0.0");
        distanceTextField.setName("distanceTextField");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 10, 0);
        branchFaultPanel.add(distanceTextField, gridBagConstraints);

        disUnitLabel.setFont(new java.awt.Font("Dialog", 0, 10));
        disUnitLabel.setText("(% from FromSide)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 0);
        branchFaultPanel.add(disUnitLabel, gridBagConstraints);

        faultLocPanel.add(branchFaultPanel, java.awt.BorderLayout.SOUTH);

        add(faultLocPanel, java.awt.BorderLayout.NORTH);

        faultTypePanel.setLayout(new java.awt.GridBagLayout());

        typePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        typePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fault Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10)));
        faultTypeButtonGroup.add(type3PRadioButton);
        type3PRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        type3PRadioButton.setSelected(true);
        type3PRadioButton.setText("3P");
        type3PRadioButton.setName("type3PRadioButton");
        type3PRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type3PRadioButtonActionPerformed(evt);
            }
        });

        typePanel.add(type3PRadioButton);

        faultTypeButtonGroup.add(typeLGRadioButton);
        typeLGRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        typeLGRadioButton.setText("L-G");
        typeLGRadioButton.setName("typeLGRadioButton");
        typeLGRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeLGRadioButtonActionPerformed(evt);
            }
        });

        typePanel.add(typeLGRadioButton);

        faultTypeButtonGroup.add(typeLLRadioButton);
        typeLLRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        typeLLRadioButton.setText("L-L");
        typeLLRadioButton.setName("typeLLRadioButton");
        typeLLRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeLLRadioButtonActionPerformed(evt);
            }
        });

        typePanel.add(typeLLRadioButton);

        faultTypeButtonGroup.add(typeLLGRadioButton);
        typeLLGRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        typeLLGRadioButton.setText("LL-G");
        typeLLGRadioButton.setName("typeLLGRadioButton");
        typeLLGRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeLLGRadioButtonActionPerformed(evt);
            }
        });

        typePanel.add(typeLLGRadioButton);

        faultTypeButtonGroup.add(typeAllRadioButton);
        typeAllRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        typeAllRadioButton.setText("All");
        typeAllRadioButton.setEnabled(false);
        typeAllRadioButton.setName("typeAllRadioButton");
        typeAllRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeAllRadioButtonActionPerformed(evt);
            }
        });

        typePanel.add(typeAllRadioButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 30);
        faultTypePanel.add(typePanel, gridBagConstraints);

        faultZPanel.setLayout(new java.awt.GridBagLayout());

        zLGLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        zLGLabel.setText("L-G(r+jx)     ");
        faultZPanel.add(zLGLabel, new java.awt.GridBagConstraints());

        rLGTextField.setColumns(8);
        rLGTextField.setText("0.0");
        rLGTextField.setName("rLGTextField");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 0);
        faultZPanel.add(rLGTextField, gridBagConstraints);

        xLGTextField.setColumns(8);
        xLGTextField.setText("0.0");
        xLGTextField.setName("xLGTextField");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 5, 0);
        faultZPanel.add(xLGTextField, gridBagConstraints);

        zLGUnitLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        zLGUnitLabel.setText("     (Ohms)");
        faultZPanel.add(zLGUnitLabel, new java.awt.GridBagConstraints());

        zLLLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        zLLLabel.setText("L-L(r+jx)     ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        faultZPanel.add(zLLLabel, gridBagConstraints);

        rLLTextField.setColumns(8);
        rLLTextField.setText("0.0");
        rLLTextField.setName("rLLTextField");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        faultZPanel.add(rLLTextField, gridBagConstraints);

        xLLTextField.setColumns(8);
        xLLTextField.setText("0.0");
        xLLTextField.setName("xLLTextField");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        faultZPanel.add(xLLTextField, gridBagConstraints);

        zLLUnitLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        zLLUnitLabel.setText("     (Ohms)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        faultZPanel.add(zLLUnitLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        faultTypePanel.add(faultZPanel, gridBagConstraints);

        add(faultTypePanel, java.awt.BorderLayout.SOUTH);

    }// </editor-fold>//GEN-END:initComponents

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
 	       			return VerifyUtil.getDouble((javax.swing.JTextField)input) >= 0.0;
 	       	} catch (Exception e) {
 	    		return false;
 	       	}		
			return true;
        }
    }
}