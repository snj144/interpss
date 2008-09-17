 /*
  * @(#)NBAclfCasePanel.java   
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

import org.interpss.editor.data.proj.DclfCaseData;
import org.interpss.editor.form.GFormContainer;
import org.interpss.editor.jgraph.ui.edit.IFormDataPanel;
import org.interpss.editor.ui.RunUIUtilFunc;
import org.interpss.schema.BranchRecXmlType;
import org.interpss.schema.DclfPowerTransferDistFactorXmlType;
import org.interpss.xml.IpssXmlUtilFunc;

import com.interpss.common.exp.InvalidOperationException;
import com.interpss.common.msg.IpssMessage;
import com.interpss.common.msg.IpssMsgListener;
import com.interpss.common.msg.SimuMessage;
import com.interpss.common.util.IpssLogger;
import com.interpss.simu.SimuContext;

public class NBDclfCasePanel extends javax.swing.JPanel implements IFormDataPanel, IpssMsgListener {
	private static final long serialVersionUID = 1;
    private GFormContainer _netContainer = null;
    private SimuContext _simuCtx = null;

    // holds the current case data being edited
    private DclfCaseData _caseData = null;
    private DclfPowerTransferDistFactorXmlType tdFactor = null;
    
    /** Creates new form NBAclfCasePanel */
    public NBDclfCasePanel(JDialog parent) {
    	initComponents();

        DataVerifier verifier = new DataVerifier();
    }
    
    /**
     * Implementation of the onMsgEvent method.
  	* 
  	* @param msg the msg object
     */
     public void onMsgEvent(IpssMessage msg) {
    	 if (msg instanceof SimuMessage) {
    	 }
     }

     public boolean onMsgEventStatus(IpssMessage msg) {
  	   throw new InvalidOperationException("Method not implemented");
     }
     
    public void init(Object netContainer, Object simuCtx) {
    	// for non-graphic file, netContainer == null
		IpssLogger.getLogger().info("NBAclfCasePanel init() called");
	    _netContainer = (GFormContainer)netContainer;
	    _simuCtx = (SimuContext)simuCtx;

		this.injectBusComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				RunUIUtilFunc.getIdArray(_simuCtx.getAclfNet(), RunUIUtilFunc.NetIdTypeEnum.GenBus).toArray()));

		this.withdrawBusComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				RunUIUtilFunc.getIdArray(_simuCtx.getAclfNet(), RunUIUtilFunc.NetIdTypeEnum.LoadBus).toArray()));

		this.branchListComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				RunUIUtilFunc.getIdArray(_simuCtx.getAclfNet(), RunUIUtilFunc.NetIdTypeEnum.AllBranch).toArray()));
	}

    public void setCaseData(DclfCaseData data) {
    	_caseData = data;
    }
    
	/**
	*	Set form data to the editor
	*
	* @return false if there is any problem
	*/
	public boolean setForm2Editor() {
		IpssLogger.getLogger().info("NBAclfCasePanel setForm2Editor() called");
		
		if (_caseData.getXmlPTDFactor() != null) {
			try {
				tdFactor = DclfPowerTransferDistFactorXmlType.Factory.parse(_caseData.getXmlPTDFactor());
				
				injectBusComboBox.setSelectedItem(tdFactor.getInjectBusId());
				
				if (tdFactor.getWithdrawBusId() != null && !tdFactor.getWithdrawBusId().equals("")) {
					withSingleBusRadioButton.setSelected(true);
					withSingleBusRadioButtonActionPerformed(null);
			    	withdarwBusList.setModel(new javax.swing.DefaultComboBoxModel( new String[] {}));
				}
				else {
					withMultiBusRadioButton.setSelected(true);
				    withMultiBusRadioButtonActionPerformed(null);
			    	withdarwBusList.setModel(new javax.swing.DefaultComboBoxModel(
			    			IpssXmlUtilFunc.getWithdrawItemList(tdFactor.getWithdrawBusList().getWithdrawBusArray())));
				}
					
		    	measBranchList.setModel(new javax.swing.DefaultComboBoxModel(
		    			IpssXmlUtilFunc.getBranchIdAry(tdFactor.getBranchArray())));
			} catch (Exception e) {
				IpssLogger.getLogger().severe(e.toString() + ", " + _caseData.getXmlPTDFactor());
			}
		}
		else 
			tdFactor = DclfPowerTransferDistFactorXmlType.Factory.newInstance();

		return true;
	}
    
	/**
	*	Save editor screen data to the form
	*
	* @param errMsg error messages during the saving process.
	* @return false if there is any problem
	*/
	public boolean saveEditor2Form(Vector<String> errMsg) throws Exception {
		IpssLogger.getLogger().info("NBAclfCasePanel saveEditor2Form() called");

		tdFactor.setInjectBusId((String)injectBusComboBox.getSelectedItem());
		
		if (withSingleBusRadioButton.isSelected())
			tdFactor.setWithdrawBusId((String)withdrawBusComboBox.getSelectedItem());
		else	
			tdFactor.setWithdrawBusId("");
			
		_caseData.setXmlPTDFactor(tdFactor.toString());
		
		return errMsg.size() == 0;
	}
    

    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        injectionBusButtonGroup = new javax.swing.ButtonGroup();
        withdrawBusButtonGroup = new javax.swing.ButtonGroup();
        withdrawButtonGroup = new javax.swing.ButtonGroup();
        runDclfTabbedPane = new javax.swing.JTabbedPane();
        ptdfPanel = new javax.swing.JPanel();
        injectionPanel = new javax.swing.JPanel();
        injectBusComboBox = new javax.swing.JComboBox();
        injectGenBudRadioButton = new javax.swing.JRadioButton();
        injectAllBusRadioButton = new javax.swing.JRadioButton();
        withdrawPanel = new javax.swing.JPanel();
        singleMultiBusPanel = new javax.swing.JPanel();
        withSingleBusRadioButton = new javax.swing.JRadioButton();
        withMultiBusRadioButton = new javax.swing.JRadioButton();
        withBusSelectPanel = new javax.swing.JPanel();
        withdrawBusComboBox = new javax.swing.JComboBox();
        withLoadBusRadioButton = new javax.swing.JRadioButton();
        withAllBusRadioButton = new javax.swing.JRadioButton();
        withMultiBusPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        withdarwBusList = new javax.swing.JList();
        loadDistFactorLabel = new javax.swing.JLabel();
        distFactorTextField = new javax.swing.JTextField();
        percentLabel = new javax.swing.JLabel();
        addWithBusButton = new javax.swing.JButton();
        removeWithBusButton = new javax.swing.JButton();
        genWithBusButton = new javax.swing.JButton();
        measBranchPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        measBranchList = new javax.swing.JList();
        branchListComboBox = new javax.swing.JComboBox();
        addBranchButton = new javax.swing.JButton();
        removeBranchButton = new javax.swing.JButton();
        violationPanel = new javax.swing.JPanel();

        runDclfTabbedPane.setFont(new java.awt.Font("Dialog", 0, 12));
        runDclfTabbedPane.setMinimumSize(new java.awt.Dimension(80, 48));
        runDclfTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                panelSelectionChanged(evt);
            }
        });

        ptdfPanel.setLayout(new java.awt.GridBagLayout());

        injectionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Injection Bus", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12)));
        injectionPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        injectBusComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        injectBusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        injectionPanel.add(injectBusComboBox);

        injectionBusButtonGroup.add(injectGenBudRadioButton);
        injectGenBudRadioButton.setFont(new java.awt.Font("Dialog", 0, 10));
        injectGenBudRadioButton.setSelected(true);
        injectGenBudRadioButton.setText("Generator");
        injectGenBudRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                injectGenBudRadioButtonActionPerformed(evt);
            }
        });
        injectionPanel.add(injectGenBudRadioButton);

        injectionBusButtonGroup.add(injectAllBusRadioButton);
        injectAllBusRadioButton.setFont(new java.awt.Font("Dialog", 0, 10));
        injectAllBusRadioButton.setText("All Buses");
        injectAllBusRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                injectAllBusRadioButtonActionPerformed(evt);
            }
        });
        injectionPanel.add(injectAllBusRadioButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ptdfPanel.add(injectionPanel, gridBagConstraints);

        withdrawPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "WithdrawBus(es)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12)));
        withdrawPanel.setLayout(new java.awt.GridBagLayout());

        withdrawButtonGroup.add(withSingleBusRadioButton);
        withSingleBusRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        withSingleBusRadioButton.setSelected(true);
        withSingleBusRadioButton.setText("Single Bus");
        withSingleBusRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withSingleBusRadioButtonActionPerformed(evt);
            }
        });
        singleMultiBusPanel.add(withSingleBusRadioButton);

        withdrawButtonGroup.add(withMultiBusRadioButton);
        withMultiBusRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        withMultiBusRadioButton.setText("Multi-Buses");
        withMultiBusRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withMultiBusRadioButtonActionPerformed(evt);
            }
        });
        singleMultiBusPanel.add(withMultiBusRadioButton);

        withdrawPanel.add(singleMultiBusPanel, new java.awt.GridBagConstraints());

        withdrawBusComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        withdrawBusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        withBusSelectPanel.add(withdrawBusComboBox);

        withdrawBusButtonGroup.add(withLoadBusRadioButton);
        withLoadBusRadioButton.setFont(new java.awt.Font("Dialog", 0, 10));
        withLoadBusRadioButton.setSelected(true);
        withLoadBusRadioButton.setText("Load ");
        withLoadBusRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withLoadBusRadioButtonActionPerformed(evt);
            }
        });
        withBusSelectPanel.add(withLoadBusRadioButton);

        withdrawBusButtonGroup.add(withAllBusRadioButton);
        withAllBusRadioButton.setFont(new java.awt.Font("Dialog", 0, 10));
        withAllBusRadioButton.setText("All Buses");
        withAllBusRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withAllBusRadioButtonActionPerformed(evt);
            }
        });
        withBusSelectPanel.add(withAllBusRadioButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        withdrawPanel.add(withBusSelectPanel, gridBagConstraints);

        withdarwBusList.setFont(new java.awt.Font("Dialog", 0, 12));
        withdarwBusList.setEnabled(false);
        jScrollPane2.setViewportView(withdarwBusList);

        loadDistFactorLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        loadDistFactorLabel.setText("Load Disttribution Factor");
        loadDistFactorLabel.setEnabled(false);

        distFactorTextField.setText("100.0");
        distFactorTextField.setEnabled(false);

        percentLabel.setText("%");
        percentLabel.setEnabled(false);

        addWithBusButton.setFont(new java.awt.Font("Dialog", 0, 10));
        addWithBusButton.setText("Add");
        addWithBusButton.setEnabled(false);
        addWithBusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWithBusButtonActionPerformed(evt);
            }
        });

        removeWithBusButton.setFont(new java.awt.Font("Dialog", 0, 10));
        removeWithBusButton.setText("Remove");
        removeWithBusButton.setEnabled(false);
        removeWithBusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeWithBusButtonActionPerformed(evt);
            }
        });

        genWithBusButton.setFont(new java.awt.Font("Dialog", 0, 10));
        genWithBusButton.setText("Generate");
        genWithBusButton.setEnabled(false);
        genWithBusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genWithBusButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout withMultiBusPanelLayout = new org.jdesktop.layout.GroupLayout(withMultiBusPanel);
        withMultiBusPanel.setLayout(withMultiBusPanelLayout);
        withMultiBusPanelLayout.setHorizontalGroup(
            withMultiBusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(withMultiBusPanelLayout.createSequentialGroup()
                .add(withMultiBusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(withMultiBusPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(loadDistFactorLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(distFactorTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(percentLabel))
                    .add(withMultiBusPanelLayout.createSequentialGroup()
                        .add(32, 32, 32)
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 133, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(withMultiBusPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(addWithBusButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(removeWithBusButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(genWithBusButton)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        withMultiBusPanelLayout.setVerticalGroup(
            withMultiBusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(withMultiBusPanelLayout.createSequentialGroup()
                .add(withMultiBusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(loadDistFactorLabel)
                    .add(distFactorTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(percentLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(withMultiBusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(addWithBusButton)
                    .add(removeWithBusButton)
                    .add(genWithBusButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        withdrawPanel.add(withMultiBusPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        ptdfPanel.add(withdrawPanel, gridBagConstraints);

        measBranchPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Measurement Branches", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12)));

        measBranchList.setFont(new java.awt.Font("Dialog", 0, 12));
        jScrollPane1.setViewportView(measBranchList);

        branchListComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        branchListComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        addBranchButton.setFont(new java.awt.Font("Dialog", 0, 10));
        addBranchButton.setText("Add");
        addBranchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBranchButtonActionPerformed(evt);
            }
        });

        removeBranchButton.setFont(new java.awt.Font("Dialog", 0, 10));
        removeBranchButton.setText("Remove");
        removeBranchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBranchButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout measBranchPanelLayout = new org.jdesktop.layout.GroupLayout(measBranchPanel);
        measBranchPanel.setLayout(measBranchPanelLayout);
        measBranchPanelLayout.setHorizontalGroup(
            measBranchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(measBranchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(measBranchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(branchListComboBox, 0, 138, Short.MAX_VALUE)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 138, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(measBranchPanelLayout.createSequentialGroup()
                        .add(addBranchButton)
                        .add(9, 9, 9)
                        .add(removeBranchButton)))
                .addContainerGap())
        );
        measBranchPanelLayout.setVerticalGroup(
            measBranchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(measBranchPanelLayout.createSequentialGroup()
                .add(branchListComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(measBranchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(addBranchButton)
                    .add(removeBranchButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 140, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        ptdfPanel.add(measBranchPanel, gridBagConstraints);

        runDclfTabbedPane.addTab("PTDF Calculation", ptdfPanel);

        violationPanel.setEnabled(false);

        org.jdesktop.layout.GroupLayout violationPanelLayout = new org.jdesktop.layout.GroupLayout(violationPanel);
        violationPanel.setLayout(violationPanelLayout);
        violationPanelLayout.setHorizontalGroup(
            violationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 485, Short.MAX_VALUE)
        );
        violationPanelLayout.setVerticalGroup(
            violationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 369, Short.MAX_VALUE)
        );

        runDclfTabbedPane.addTab("Violation Analysis", violationPanel);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(12, 12, 12)
                .add(runDclfTabbedPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(runDclfTabbedPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
 
    private void panelSelectionChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_panelSelectionChanged
    	if ( runDclfTabbedPane.getSelectedIndex() == 0 )
        	IpssLogger.getLogger().info("Panel selection changed - Main Panel");
    	else if ( runDclfTabbedPane.getSelectedIndex() == 1 ) {
        	IpssLogger.getLogger().info("Panel selection changed - Advanced Panel");
    	}	
    }//GEN-LAST:event_panelSelectionChanged

    private void withSingleBusRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withSingleBusRadioButtonActionPerformed
    	setMultiBusWithdrawStatus(false);
    	tdFactor.setWithdrawBusId((String)withdrawBusComboBox.getSelectedItem());
}//GEN-LAST:event_withSingleBusRadioButtonActionPerformed

    private void removeBranchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBranchButtonActionPerformed
    	tdFactor.removeBranch(measBranchList.getSelectedIndex());
    	measBranchList.setModel(new javax.swing.DefaultComboBoxModel(
    			IpssXmlUtilFunc.getBranchIdAry(tdFactor.getBranchArray())));
}//GEN-LAST:event_removeBranchButtonActionPerformed

    private void injectGenBudRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_injectGenBudRadioButtonActionPerformed
		this.injectBusComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				RunUIUtilFunc.getIdArray(_simuCtx.getAclfNet(), RunUIUtilFunc.NetIdTypeEnum.GenBus).toArray()));
}//GEN-LAST:event_injectGenBudRadioButtonActionPerformed

    private void injectAllBusRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_injectAllBusRadioButtonActionPerformed
		this.injectBusComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				RunUIUtilFunc.getIdArray(_simuCtx.getAclfNet(), RunUIUtilFunc.NetIdTypeEnum.AllBus).toArray()));
}//GEN-LAST:event_injectAllBusRadioButtonActionPerformed

    private void withMultiBusRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withMultiBusRadioButtonActionPerformed
    	setMultiBusWithdrawStatus(true);
    	tdFactor.setWithdrawBusId("");
    	if (tdFactor.getWithdrawBusList() == null)
    		tdFactor.addNewWithdrawBusList();
    }//GEN-LAST:event_withMultiBusRadioButtonActionPerformed

    private void withAllBusRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withAllBusRadioButtonActionPerformed
		this.withdrawBusComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				RunUIUtilFunc.getIdArray(_simuCtx.getAclfNet(), RunUIUtilFunc.NetIdTypeEnum.AllBus).toArray()));
    }//GEN-LAST:event_withAllBusRadioButtonActionPerformed

    private void withLoadBusRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withLoadBusRadioButtonActionPerformed
		this.withdrawBusComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				RunUIUtilFunc.getIdArray(_simuCtx.getAclfNet(), RunUIUtilFunc.NetIdTypeEnum.LoadBus).toArray()));
    }//GEN-LAST:event_withLoadBusRadioButtonActionPerformed

    private void removeWithBusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeWithBusButtonActionPerformed
    	tdFactor.getWithdrawBusList().removeWithdrawBus(withdarwBusList.getSelectedIndex());
    	withdarwBusList.setModel(new javax.swing.DefaultComboBoxModel(
    			IpssXmlUtilFunc.getWithdrawItemList(tdFactor.getWithdrawBusList().getWithdrawBusArray())));
}//GEN-LAST:event_removeWithBusButtonActionPerformed

    private void genWithBusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genWithBusButtonActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_genWithBusButtonActionPerformed

    private void addWithBusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWithBusButtonActionPerformed
    	String id = (String)withdrawBusComboBox.getSelectedItem();
    	double percent = new Double(this.distFactorTextField.getText()).doubleValue();
    	DclfPowerTransferDistFactorXmlType.WithdrawBusList.WithdrawBus bus = tdFactor.getWithdrawBusList().addNewWithdrawBus();
    	bus.setBusId(id);
    	bus.setPercent(percent);
    	withdarwBusList.setModel(new javax.swing.DefaultComboBoxModel(
    			IpssXmlUtilFunc.getWithdrawItemList(tdFactor.getWithdrawBusList().getWithdrawBusArray())));
    }//GEN-LAST:event_addWithBusButtonActionPerformed

    private void addBranchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBranchButtonActionPerformed
    	String id = (String)branchListComboBox.getSelectedItem();
    	BranchRecXmlType braRec = tdFactor.addNewBranch();
    	IpssXmlUtilFunc.setBranchRec(braRec, id);
    	measBranchList.setModel(new javax.swing.DefaultComboBoxModel(
    			IpssXmlUtilFunc.getBranchIdAry(tdFactor.getBranchArray())));
    }//GEN-LAST:event_addBranchButtonActionPerformed
    
    private void setMultiBusWithdrawStatus(boolean b) {
        this.withdarwBusList.setEnabled(b);
        this.addWithBusButton.setEnabled(b);
        this.removeWithBusButton.setEnabled(b);
        this.genWithBusButton.setEnabled(b);
        this.loadDistFactorLabel.setEnabled(b);
        this.percentLabel.setEnabled(b);
        this.distFactorTextField.setEnabled(b);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBranchButton;
    private javax.swing.JButton addWithBusButton;
    private javax.swing.JComboBox branchListComboBox;
    private javax.swing.JTextField distFactorTextField;
    private javax.swing.JButton genWithBusButton;
    private javax.swing.JRadioButton injectAllBusRadioButton;
    private javax.swing.JComboBox injectBusComboBox;
    private javax.swing.JRadioButton injectGenBudRadioButton;
    private javax.swing.ButtonGroup injectionBusButtonGroup;
    private javax.swing.JPanel injectionPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel loadDistFactorLabel;
    private javax.swing.JList measBranchList;
    private javax.swing.JPanel measBranchPanel;
    private javax.swing.JLabel percentLabel;
    private javax.swing.JPanel ptdfPanel;
    private javax.swing.JButton removeBranchButton;
    private javax.swing.JButton removeWithBusButton;
    private javax.swing.JTabbedPane runDclfTabbedPane;
    private javax.swing.JPanel singleMultiBusPanel;
    private javax.swing.JPanel violationPanel;
    private javax.swing.JRadioButton withAllBusRadioButton;
    private javax.swing.JPanel withBusSelectPanel;
    private javax.swing.JRadioButton withLoadBusRadioButton;
    private javax.swing.JPanel withMultiBusPanel;
    private javax.swing.JRadioButton withMultiBusRadioButton;
    private javax.swing.JRadioButton withSingleBusRadioButton;
    private javax.swing.JList withdarwBusList;
    private javax.swing.ButtonGroup withdrawBusButtonGroup;
    private javax.swing.JComboBox withdrawBusComboBox;
    private javax.swing.ButtonGroup withdrawButtonGroup;
    private javax.swing.JPanel withdrawPanel;
    // End of variables declaration//GEN-END:variables
    
	class DataVerifier extends javax.swing.InputVerifier {
		public boolean verify(javax.swing.JComponent input) {
			if (input == null)
				return false;
			return true;
		}
	}
}
