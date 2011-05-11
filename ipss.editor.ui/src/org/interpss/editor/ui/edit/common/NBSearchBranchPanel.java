 /*
  * @(#)NBSearchBranchPanel.java   
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

package org.interpss.editor.ui.edit.common;

import org.interpss.editor.form.GBranchForm;
import org.interpss.editor.form.GFormContainer;
import org.interpss.editor.jgraph.ui.form.IGBranchForm;
import org.interpss.editor.jgraph.ui.form.IGNetForm;


public class NBSearchBranchPanel extends javax.swing.JPanel {
	private static final long serialVersionUID = 1;

	private GFormContainer _netContainer = null;

    public void init(GFormContainer netContainer) {
        _netContainer = netContainer;
        
        branchComboBox.setModel(new javax.swing.DefaultComboBoxModel(_netContainer.getBranchBusNameArray()));
        branchNoComboBox.setModel(new javax.swing.DefaultComboBoxModel(_netContainer.getBranchNoArray()));
        branchIdComboBox.setModel(new javax.swing.DefaultComboBoxModel(_netContainer.getBranchIdArray()));

        branchTypePanel.removeAll();
        branchTypePanel.setLayout(new java.awt.GridLayout(1, 0));
        if (netContainer.getGNetForm().getAppType().equals(IGNetForm.AppType_Distribution)) {
            branchTypePanel.add(distBranchTypePanel);
	        allDistRadioButton.setSelected(true);
        }
        else if (netContainer.getGNetForm().getAppType().equals(IGNetForm.AppType_Transmission)) {
            branchTypePanel.add(transBranchTypePanel);
	        allTransRadioButton.setSelected(true);
        }
        
        
        this.branchComboBox.setSelectedIndex(0);
        this.branchNoComboBox.setSelectedIndex(0);
        this.branchIdComboBox.setSelectedIndex(0);
   }
    
    public GBranchForm getSelectedObj() {
        String id = (String)this.branchIdComboBox.getSelectedItem();
        return (GBranchForm)_netContainer.getGBranchForm(id);
    }
    
    /** Creates new form NBFindBranchPanel */
    public NBSearchBranchPanel() {
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

        distBranchTypeButtonGroup = new javax.swing.ButtonGroup();
        transBranchTypeButtonGroup = new javax.swing.ButtonGroup();
        branchTypePanel = new javax.swing.JPanel();
        distBranchTypePanel = new javax.swing.JPanel();
        allDistRadioButton = new javax.swing.JRadioButton();
        feederRadioButton = new javax.swing.JRadioButton();
        xfrRadioButton = new javax.swing.JRadioButton();
        breakerRadioButton = new javax.swing.JRadioButton();
        xfr3WRadioButton = new javax.swing.JRadioButton();
        transBranchTypePanel = new javax.swing.JPanel();
        allTransRadioButton = new javax.swing.JRadioButton();
        lineRadioButton = new javax.swing.JRadioButton();
        xfrTransRadioButton = new javax.swing.JRadioButton();
        psXfrRadioButton = new javax.swing.JRadioButton();
        areaZonePanel = new javax.swing.JPanel();
        areaLabel = new javax.swing.JLabel();
        areaComboBox = new javax.swing.JComboBox();
        zoneLabel = new javax.swing.JLabel();
        zoneComboBox = new javax.swing.JComboBox();
        selectPanel = new javax.swing.JPanel();
        branchLabel = new javax.swing.JLabel();
        branchComboBox = new javax.swing.JComboBox();
        branchNoLabel = new javax.swing.JLabel();
        branchNoComboBox = new javax.swing.JComboBox();
        branchIdLabel = new javax.swing.JLabel();
        branchIdComboBox = new javax.swing.JComboBox();

        setLayout(new java.awt.BorderLayout());

        setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(10, 10, 1, 10)));
        branchTypePanel.setLayout(new java.awt.GridBagLayout());

        branchTypePanel.setBorder(new javax.swing.border.TitledBorder(null, "Distribution Branch Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("MS Sans Serif", 0, 10)));
        distBranchTypeButtonGroup.add(allDistRadioButton);
        allDistRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        allDistRadioButton.setSelected(true);
        allDistRadioButton.setText("All");
        allDistRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allDistRadioButtonActionPerformed(evt);
            }
        });

        distBranchTypePanel.add(allDistRadioButton);

        distBranchTypeButtonGroup.add(feederRadioButton);
        feederRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        feederRadioButton.setText("Feeder");
        feederRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feederRadioButtonActionPerformed(evt);
            }
        });

        distBranchTypePanel.add(feederRadioButton);

        distBranchTypeButtonGroup.add(xfrRadioButton);
        xfrRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        xfrRadioButton.setText("Transformer");
        xfrRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xfrRadioButtonActionPerformed(evt);
            }
        });

        distBranchTypePanel.add(xfrRadioButton);

        distBranchTypeButtonGroup.add(breakerRadioButton);
        breakerRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        breakerRadioButton.setText("Breaker");
        breakerRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                breakerRadioButtonActionPerformed(evt);
            }
        });

        distBranchTypePanel.add(breakerRadioButton);

        distBranchTypeButtonGroup.add(xfr3WRadioButton);
        xfr3WRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        xfr3WRadioButton.setText("3W-Transformer");
        xfr3WRadioButton.setEnabled(false);
        xfr3WRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xfr3WRadioButtonActionPerformed(evt);
            }
        });

        distBranchTypePanel.add(xfr3WRadioButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        branchTypePanel.add(distBranchTypePanel, gridBagConstraints);

        transBranchTypeButtonGroup.add(allTransRadioButton);
        allTransRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        allTransRadioButton.setSelected(true);
        allTransRadioButton.setText("All");
        allTransRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allTransRadioButtonActionPerformed(evt);
            }
        });

        transBranchTypePanel.add(allTransRadioButton);

        transBranchTypeButtonGroup.add(lineRadioButton);
        lineRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        lineRadioButton.setText("Line");
        lineRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineRadioButtonActionPerformed(evt);
            }
        });

        transBranchTypePanel.add(lineRadioButton);

        transBranchTypeButtonGroup.add(xfrTransRadioButton);
        xfrTransRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        xfrTransRadioButton.setText("Transformer");
        xfrTransRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xfrTransRadioButtonActionPerformed(evt);
            }
        });

        transBranchTypePanel.add(xfrTransRadioButton);

        transBranchTypeButtonGroup.add(psXfrRadioButton);
        psXfrRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        psXfrRadioButton.setText("PhaseShift-Transformer");
        psXfrRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psXfrRadioButtonActionPerformed(evt);
            }
        });

        transBranchTypePanel.add(psXfrRadioButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        branchTypePanel.add(transBranchTypePanel, gridBagConstraints);

        add(branchTypePanel, java.awt.BorderLayout.NORTH);

        areaZonePanel.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(10, 1, 1, 1)));
        areaLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        areaLabel.setText("Area");
        areaZonePanel.add(areaLabel);

        areaComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        areaComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));
        areaComboBox.setPreferredSize(new java.awt.Dimension(50, 21));
        areaComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaComboBoxActionPerformed(evt);
            }
        });

        areaZonePanel.add(areaComboBox);

        zoneLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        zoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        zoneLabel.setText("Zone");
        zoneLabel.setPreferredSize(new java.awt.Dimension(75, 16));
        areaZonePanel.add(zoneLabel);

        zoneComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        zoneComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));
        zoneComboBox.setPreferredSize(new java.awt.Dimension(50, 21));
        zoneComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoneComboBoxActionPerformed(evt);
            }
        });

        areaZonePanel.add(zoneComboBox);

        add(areaZonePanel, java.awt.BorderLayout.CENTER);

        selectPanel.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(10, 1, 10, 1)));
        branchLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        branchLabel.setText("Branch");
        selectPanel.add(branchLabel);

        branchComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        branchComboBox.setPreferredSize(new java.awt.Dimension(150, 21));
        branchComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchComboBoxActionPerformed(evt);
            }
        });

        selectPanel.add(branchComboBox);

        branchNoLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        branchNoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        branchNoLabel.setText("Branch Number");
        branchNoLabel.setPreferredSize(new java.awt.Dimension(110, 16));
        selectPanel.add(branchNoLabel);

        branchNoComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        branchNoComboBox.setPreferredSize(new java.awt.Dimension(75, 19));
        branchNoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchNoComboBoxActionPerformed(evt);
            }
        });

        selectPanel.add(branchNoComboBox);

        branchIdLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        branchIdLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        branchIdLabel.setText("Branch Id");
        branchIdLabel.setPreferredSize(new java.awt.Dimension(80, 16));
        selectPanel.add(branchIdLabel);

        branchIdComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        branchIdComboBox.setPreferredSize(new java.awt.Dimension(100, 21));
        branchIdComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchIdComboBoxActionPerformed(evt);
            }
        });

        selectPanel.add(branchIdComboBox);

        add(selectPanel, java.awt.BorderLayout.SOUTH);

    }
    // </editor-fold>//GEN-END:initComponents

    private void psXfrRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psXfrRadioButtonActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_psXfrRadioButtonActionPerformed

    private void xfrTransRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xfrTransRadioButtonActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_xfrTransRadioButtonActionPerformed

    private void lineRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineRadioButtonActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_lineRadioButtonActionPerformed

    private void allTransRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allTransRadioButtonActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_allTransRadioButtonActionPerformed

    private void branchNoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchNoComboBoxActionPerformed
		if (this.branchNoComboBox.getSelectedIndex()>=0) {
			this.branchIdComboBox.setSelectedIndex(this.branchNoComboBox.getSelectedIndex());
      }   
    }//GEN-LAST:event_branchNoComboBoxActionPerformed

    private void branchIdComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchIdComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_branchIdComboBoxActionPerformed

    private void branchComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchComboBoxActionPerformed
		if (this.branchComboBox.getSelectedIndex()>=0) {
			this.branchNoComboBox.setSelectedIndex(this.branchComboBox.getSelectedIndex());
			this.branchIdComboBox.setSelectedIndex(this.branchComboBox.getSelectedIndex());
      }   
    }//GEN-LAST:event_branchComboBoxActionPerformed

    private void xfr3WRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xfr3WRadioButtonActionPerformed
        this.branchComboBox.setModel(
                new javax.swing.DefaultComboBoxModel(_netContainer.getDistBranchIdArray(IGBranchForm.DistBranchCode_3WXfr)));
        this.branchComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_xfr3WRadioButtonActionPerformed

    private void breakerRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_breakerRadioButtonActionPerformed
        this.branchComboBox.setModel(
                new javax.swing.DefaultComboBoxModel(_netContainer.getDistBranchIdArray(IGBranchForm.DistBranchCode_Breaker)));
        this.branchComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_breakerRadioButtonActionPerformed

    private void xfrRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xfrRadioButtonActionPerformed
        this.branchComboBox.setModel(
                new javax.swing.DefaultComboBoxModel(_netContainer.getDistBranchIdArray(IGBranchForm.DistBranchCode_Xfr)));
        this.branchComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_xfrRadioButtonActionPerformed

    private void feederRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feederRadioButtonActionPerformed
        this.branchComboBox.setModel(
                new javax.swing.DefaultComboBoxModel(_netContainer.getDistBranchIdArray(IGBranchForm.DistBranchCode_Feeder)));
        this.branchComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_feederRadioButtonActionPerformed

    private void allDistRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allDistRadioButtonActionPerformed
        this.branchComboBox.setModel(
                new javax.swing.DefaultComboBoxModel(_netContainer.getDistBranchIdArray(IGBranchForm.DistBranchCode_AllBranch)));
        this.branchComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_allDistRadioButtonActionPerformed

    private void zoneComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoneComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_zoneComboBoxActionPerformed

    private void areaComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_areaComboBoxActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton allDistRadioButton;
    private javax.swing.JRadioButton allTransRadioButton;
    private javax.swing.JComboBox areaComboBox;
    private javax.swing.JLabel areaLabel;
    private javax.swing.JPanel areaZonePanel;
    private javax.swing.JComboBox branchComboBox;
    private javax.swing.JComboBox branchIdComboBox;
    private javax.swing.JLabel branchIdLabel;
    private javax.swing.JLabel branchLabel;
    private javax.swing.JComboBox branchNoComboBox;
    private javax.swing.JLabel branchNoLabel;
    private javax.swing.JPanel branchTypePanel;
    private javax.swing.JRadioButton breakerRadioButton;
    private javax.swing.ButtonGroup distBranchTypeButtonGroup;
    private javax.swing.JPanel distBranchTypePanel;
    private javax.swing.JRadioButton feederRadioButton;
    private javax.swing.JRadioButton lineRadioButton;
    private javax.swing.JRadioButton psXfrRadioButton;
    private javax.swing.JPanel selectPanel;
    private javax.swing.ButtonGroup transBranchTypeButtonGroup;
    private javax.swing.JPanel transBranchTypePanel;
    private javax.swing.JRadioButton xfr3WRadioButton;
    private javax.swing.JRadioButton xfrRadioButton;
    private javax.swing.JRadioButton xfrTransRadioButton;
    private javax.swing.JComboBox zoneComboBox;
    private javax.swing.JLabel zoneLabel;
    // End of variables declaration//GEN-END:variables
    
}