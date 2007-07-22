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

import org.interpss.editor.data.dstab.DStabDEventData;
import org.interpss.editor.jgraph.ui.edit.IFormDataPanel;

import com.interpss.common.ui.SwingInputVerifyUtil;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.Number2String;

public class NBDStabFaultDataPanel extends javax.swing.JPanel implements IFormDataPanel{
	private static final long serialVersionUID = 1;

	private NBFaultLocDataPanel _faultLocDataPanel = new NBFaultLocDataPanel();

	private DStabDEventData _eventData = null;  // current event data
	
    /** Creates new form FaultLocDataPanel */
    public NBDStabFaultDataPanel() {
        initComponents();
        faultDataPanel.add(_faultLocDataPanel);
        
  		DataVerifier verifier = new DataVerifier();
        stratTimeTextField.setInputVerifier(verifier);
        durationTextField.setInputVerifier(verifier);
    }
    
	public void init(Object netContainer, Object simuCtx) {
		// for non-graph file, netContainer = null
		IpssLogger.getLogger().info("NBFaultLocDataPanel init() called");

		_faultLocDataPanel.init(netContainer, simuCtx);
	}
	
	public void setDStabDEventData(DStabDEventData data) {
		_eventData = data;
		_faultLocDataPanel.setFaultData(data.getFaultData());
	}
	
	public void refresh() {
	    setForm2Editor();
		_faultLocDataPanel.setBusBranchFaultPanel();
	}
	
	/**
	*	Set form data to the editor
	*
	* @return false if there is any problem
	*/
    public boolean setForm2Editor() {
    	stratTimeTextField.setText(Number2String.toStr(_eventData.getStartTime(), "#0.0#"));

       	if (_eventData.isPermanent()) {
           	permanetCheckBox.setSelected(true);
        }
        else {
           	permanetCheckBox.setSelected(false);
            durationTextField.setText(Number2String.toStr(_eventData.getDuration(), "#0.00#"));
        }
        permanetCheckBoxActionPerformed(null);
        
        _faultLocDataPanel.setForm2Editor();
        
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

    	IpssLogger.getLogger().info("NBFaultLocDataPanel setForm2Editor() called");

    	if (!SwingInputVerifyUtil.largeEqualThan(stratTimeTextField, 0.0d, errMsg,
    					"Dynamic event start time < 0.0") )
    		_eventData.setStartTime(SwingInputVerifyUtil.getDouble(stratTimeTextField));

        _eventData.setPermanent(permanetCheckBox.isSelected());

        if (!permanetCheckBox.isSelected()) {
            if (!SwingInputVerifyUtil.largeThan(durationTextField, 0.0d, errMsg,
    			       "Dynamic event duration  <= 0.0") )
            _eventData.setDuration(SwingInputVerifyUtil.getDouble(durationTextField));
        }
        
        _faultLocDataPanel.saveEditor2Form(errMsg);

        return errMsg.size() == 0;
	}
    
	/** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        startTimeLabel = new javax.swing.JLabel();
        stratTimeTextField = new javax.swing.JTextField();
        durationLabel = new javax.swing.JLabel();
        durationTextField = new javax.swing.JTextField();
        permanetCheckBox = new javax.swing.JCheckBox();
        faultDataPanel = new javax.swing.JPanel();

        startTimeLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        startTimeLabel.setText("          Start Time(sec)   ");

        stratTimeTextField.setColumns(4);
        stratTimeTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        stratTimeTextField.setText("0.0");
        stratTimeTextField.setDragEnabled(true);
        stratTimeTextField.setName("stratTimeTextField"); // NOI18N

        durationLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        durationLabel.setText("          Duration(sec)   ");

        durationTextField.setColumns(4);
        durationTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        durationTextField.setText("0.1");
        durationTextField.setName("durationTextField"); // NOI18N

        permanetCheckBox.setFont(new java.awt.Font("Dialog", 0, 12));
        permanetCheckBox.setText("Permanent");
        permanetCheckBox.setToolTipText("A permanent fault is clear by disconnecting all associated branches");
        permanetCheckBox.setName("permanetCheckBox"); // NOI18N
        permanetCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permanetCheckBoxActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .add(startTimeLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(stratTimeTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(14, 14, 14)
                .add(durationLabel)
                .add(18, 18, 18)
                .add(durationTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(31, 31, 31)
                .add(permanetCheckBox)
                .add(69, 69, 69))
            .add(faultDataPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(13, 13, 13)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(durationTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(durationLabel)
                    .add(stratTimeTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(startTimeLabel)
                    .add(permanetCheckBox))
                .add(18, 18, 18)
                .add(faultDataPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void permanetCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_permanetCheckBoxActionPerformed
    durationLabel.setEnabled(!permanetCheckBox.isSelected());
    durationTextField.setEnabled(!permanetCheckBox.isSelected());
//    _faultLocDataPanel.setBranchReclosureStatus(!permanetCheckBox.isSelected());
}//GEN-LAST:event_permanetCheckBoxActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel durationLabel;
    private javax.swing.JTextField durationTextField;
    private javax.swing.JPanel faultDataPanel;
    private javax.swing.JCheckBox permanetCheckBox;
    private javax.swing.JLabel startTimeLabel;
    private javax.swing.JTextField stratTimeTextField;
    // End of variables declaration//GEN-END:variables

	class DataVerifier extends javax.swing.InputVerifier {
    	public boolean verify(javax.swing.JComponent input) {
			if (input == null)
				return false;
       		try {
       			if (input == stratTimeTextField ||
           			input == durationTextField)
   	       			return SwingInputVerifyUtil.getDouble((javax.swing.JTextField)input) >= 0.0;
 	       	} catch (Exception e) {
 	    		return false;
 	       	}		
			return true;
        }
    }
}
