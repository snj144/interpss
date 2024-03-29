 /*
  * @(#)NBDistBranchEditPanel.java   
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

package org.interpss.editor.ui.edit.dist.branch;
  
import java.util.Vector;

import javax.swing.JDialog;

import org.interpss.editor.data.dist.DistBranchData;
import org.interpss.editor.form.GBranchForm;
import org.interpss.editor.form.GBusForm;
import org.interpss.editor.jgraph.ui.edit.IFormDataPanel;
import org.interpss.editor.jgraph.ui.form.IGBranchForm;
import org.interpss.editor.jgraph.ui.form.IGFormContainer;

 
public class NBDistBranchEditPanel extends javax.swing.JPanel implements IFormDataPanel {
	private static final long serialVersionUID = 1;
	private JDialog parent = null;
	
    private DistBranchData  _dataDist = null;
    private GBranchForm  _form = null;

    private NBFeederInputPanel  feederPanel = new NBFeederInputPanel();
    private NBXformerInputPanel xformerPanel = new NBXformerInputPanel();
    private NBBreakerInputPanel breakerPanel = new NBBreakerInputPanel();

	public void initPanel(JDialog aparent) {
		this.parent = aparent;
    	feederPanel.initPanel();
    	xformerPanel.initPanel(parent);
    	breakerPanel.initPanel();  
    }
    
	public void init(Object netContainer, Object form) {
		_form = (GBranchForm)form;
		_dataDist = _form.getDistBranchData();
		
	   if (_form.isNewState()) {
	        GBusForm fromBusForm = (GBusForm)(((IGFormContainer)netContainer).getGBusForm(_form.getFromId()));
	        GBusForm toBusForm = (GBusForm)(((IGFormContainer)netContainer).getGBusForm(_form.getToId()));
            double fromBaseV = fromBusForm.getBaseVoltage();
            double toBaseV = toBusForm.getBaseVoltage();
            String vUnit = fromBusForm.getBaseVoltUnit();
            if (!vUnit.equals(toBusForm.getBaseVoltUnit())) {
                vUnit = "Volt";
                if (!vUnit.equals(fromBusForm.getBaseVoltUnit()))  
                    fromBaseV *= 1000.0d;     // fromBaseV in KV, transfer to Volt
                if (!vUnit.equals(toBusForm.getBaseVoltUnit()))
                    toBaseV *= 1000.0d;       // toBaseV in KV, transfer to Volt
            }
            _dataDist.setFromRatedVolt(fromBaseV);
            _dataDist.setToRatedVolt(toBaseV);
            _dataDist.setRatedVoltUnit(vUnit);
            if (fromBaseV != toBaseV)
                _dataDist.setBranchCode(IGBranchForm.DistBranchCode_Xfr);
        }     
		      
        feederPanel.init(netContainer, form);
     	xformerPanel.init(netContainer, form);
     	breakerPanel.init(netContainer, form);
	}
	
    public boolean setForm2Editor() {
       	this.editPanel.removeAll();
    	if (_dataDist.getBranchCode().equals(IGBranchForm.DistBranchCode_Feeder)) {
       		this.feederRadioButton.setSelected(true);
           	this.editPanel.add(feederPanel, java.awt.BorderLayout.CENTER);
   			((IFormDataPanel)feederPanel).setForm2Editor();
       	}	
       	else if (_dataDist.getBranchCode().equals(IGBranchForm.DistBranchCode_Xfr)) {
       		this.xfrRadioButton.setSelected(true);
           	this.editPanel.add(xformerPanel, java.awt.BorderLayout.CENTER);
   			((IFormDataPanel)xformerPanel).setForm2Editor();
       	}	
       	else if (_dataDist.getBranchCode().equals(IGBranchForm.DistBranchCode_Breaker)) {
       		this.breakerRadioButton.setSelected(true);
           	this.editPanel.add(breakerPanel, java.awt.BorderLayout.CENTER);
   			((IFormDataPanel)breakerPanel).setForm2Editor();
       	}	
       	else { 
       	}	
    	return true;
	}
    
    public boolean saveEditor2Form(Vector errMsg) throws Exception {
    	boolean ok = true;
    	if (this.feederRadioButton.isSelected()) {
    		_dataDist.setBranchCode(IGBranchForm.DistBranchCode_Feeder);
			if (!((IFormDataPanel)feederPanel).saveEditor2Form(errMsg))
				ok = false;
    	}	
    	else if (this.xfrRadioButton.isSelected()) {
    		_dataDist.setBranchCode(IGBranchForm.DistBranchCode_Xfr);
			if (!((IFormDataPanel)xformerPanel).saveEditor2Form(errMsg))
				ok = false;
    	}	
    	else if (this.breakerRadioButton.isSelected()) {
    		_dataDist.setBranchCode(IGBranchForm.DistBranchCode_Breaker);
			if (!((IFormDataPanel)breakerPanel).saveEditor2Form(errMsg))
				ok = false;
    	}	
    	else {
    		_dataDist.setBranchCode(IGBranchForm.DistBranchCode_3WXfr);
    	}	
		return ok;
    }
    
    /** Creates new form AclfEditPanel */
    public NBDistBranchEditPanel() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        branchTypeButtonGroup = new javax.swing.ButtonGroup();
        branchTypeSelectPanel = new javax.swing.JPanel();
        feederRadioButton = new javax.swing.JRadioButton();
        xfrRadioButton = new javax.swing.JRadioButton();
        breakerRadioButton = new javax.swing.JRadioButton();
        xfr3WRadioButton = new javax.swing.JRadioButton();
        editPanel = new javax.swing.JPanel();

        setLayout(new java.awt.GridBagLayout());

        branchTypeSelectPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Branch Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10)));
        branchTypeButtonGroup.add(feederRadioButton);
        feederRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        feederRadioButton.setSelected(true);
        feederRadioButton.setText("Feeder");
        feederRadioButton.setName("feederRadioButton");
        feederRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feederRadioButtonActionPerformed(evt);
            }
        });

        branchTypeSelectPanel.add(feederRadioButton);

        branchTypeButtonGroup.add(xfrRadioButton);
        xfrRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        xfrRadioButton.setText("Transformer");
        xfrRadioButton.setName("xfrRadioButton");
        xfrRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xfrButtonClicked(evt);
            }
        });

        branchTypeSelectPanel.add(xfrRadioButton);

        branchTypeButtonGroup.add(breakerRadioButton);
        breakerRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        breakerRadioButton.setText("Breaker");
        breakerRadioButton.setName("breakerRadioButton");
        breakerRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                breakerButtonClicked(evt);
            }
        });

        branchTypeSelectPanel.add(breakerRadioButton);

        branchTypeButtonGroup.add(xfr3WRadioButton);
        xfr3WRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        xfr3WRadioButton.setText("3W-Transformer");
        xfr3WRadioButton.setEnabled(false);
        xfr3WRadioButton.setName("xfr3WRadioButton");
        xfr3WRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xfr3WButtonClicked(evt);
            }
        });

        branchTypeSelectPanel.add(xfr3WRadioButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 10, 0);
        add(branchTypeSelectPanel, gridBagConstraints);

        editPanel.setLayout(new java.awt.BorderLayout());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        add(editPanel, gridBagConstraints);

    }
    // </editor-fold>//GEN-END:initComponents

    private void feederRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feederRadioButtonActionPerformed
    	_dataDist.setBranchCode(IGBranchForm.DistBranchCode_Feeder);
    	((IFormDataPanel)parent).setForm2Editor(); 
    	parent.pack();
    }//GEN-LAST:event_feederRadioButtonActionPerformed

    private void xfr3WButtonClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xfr3WButtonClicked
    	_dataDist.setBranchCode(IGBranchForm.DistBranchCode_3WXfr);
    	((IFormDataPanel)parent).setForm2Editor();  // to update FromName, toName fields
    	parent.pack();
    }//GEN-LAST:event_xfr3WButtonClicked

    private void breakerButtonClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_breakerButtonClicked
    	_dataDist.setBranchCode(IGBranchForm.DistBranchCode_Breaker);
    	((IFormDataPanel)parent).setForm2Editor(); // to update FromName, toName fields
    	parent.pack();
    }//GEN-LAST:event_breakerButtonClicked

    private void xfrButtonClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xfrButtonClicked
    	_dataDist.setBranchCode(IGBranchForm.DistBranchCode_Xfr); // to update FromName, toName fields
    	((IFormDataPanel)parent).setForm2Editor();
    	parent.pack();
    }//GEN-LAST:event_xfrButtonClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup branchTypeButtonGroup;
    private javax.swing.JPanel branchTypeSelectPanel;
    private javax.swing.JRadioButton breakerRadioButton;
    private javax.swing.JPanel editPanel;
    private javax.swing.JRadioButton feederRadioButton;
    private javax.swing.JRadioButton xfr3WRadioButton;
    private javax.swing.JRadioButton xfrRadioButton;
    // End of variables declaration//GEN-END:variables
    
}
