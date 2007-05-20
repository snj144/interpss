 /*
  * @(#)NBDynaEventPanel.java   
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

import javax.swing.JDialog;

import org.interpss.editor.SimuAppSpringAppContext;
import org.interpss.editor.data.acsc.AcscFaultData;
import org.interpss.editor.data.dstab.DStabDEventData;
import org.interpss.editor.data.proj.DStabCaseData;
import org.interpss.editor.jgraph.ui.edit.IFormDataPanel;

import com.interpss.common.SpringAppContext;
import com.interpss.common.ui.SwingInputVerifyUtil;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.Number2String;

public class NBDynaEventPanel extends javax.swing.JPanel implements IFormDataPanel {
	private static final long serialVersionUID = 1;

	private NBFaultLocDataPanel    _faultLocDataPanel = new NBFaultLocDataPanel();
	private NBDStabLoadChangePanel _loadChangePanel = new NBDStabLoadChangePanel();

	private DStabCaseData   _caseData = null;   // current case data
	private DStabDEventData _eventData = null;  // current cevent data
	
	private JDialog parentDialog = null;

    /** Creates new form NBCaseInfoDialog */
    public NBDynaEventPanel(JDialog parent) {
    	parentDialog = parent;
        initComponents();

        eventInputPanel.add(_faultLocDataPanel);
        
        DataVerifier verifier = new DataVerifier();
        stratTimeTextField.setInputVerifier(verifier);
        durationTextField.setInputVerifier(verifier);
    }
    
    public void init(Object netContainer, Object simuCtx) {
		IpssLogger.getLogger().info("NBDStabCasePanel init() called");
	    _faultLocDataPanel.init(netContainer, simuCtx);
	    _loadChangePanel.init(netContainer, simuCtx);
    }

    public void setCaseData(DStabCaseData data) {
    	_caseData = data;
    	// This panel does not remember the event name lastly edited, it starts with
    	// the first event in the list. The getAnyEventData method creates a new event if no exiting event
   		_eventData = _caseData.getAnyEventData();
    	// update the combox for event name list
   		this.eventListComboBox.setModel(new javax.swing.DefaultComboBoxModel(_caseData.getEventNameArray()));
	    setCurrentEventData(_eventData);
    }
    
    private void setCurrentEventData(DStabDEventData eventData) {
		// update the event data editing screen
	    _loadChangePanel.setLoadChangeData(eventData.getLoadChangeData());
    	_faultLocDataPanel.setFaultData(eventData.getFaultData());
        eventInputPanel.removeAll();
        if (eventData.getType().equals(DStabDEventData.DEventType_LoadChange)) {
            eventInputPanel.add(_loadChangePanel);
        }
        else {
            eventInputPanel.add(_faultLocDataPanel);
        }
    }
    
    /**
	*	Set form data to the editor
	*
	* @return false if there is any problem
	*/
	public boolean setForm2Editor() {
		IpssLogger.getLogger().info("NBDynaEventPanel setForm2Editor() called");

	    setCurrentEventData(_eventData);
		
        if (_eventData.getEventName() != null && !_eventData.getEventName().equals(""))
        	eventListComboBox.setSelectedItem(_eventData.getEventName());
        
        stratTimeTextField.setText(Number2String.toStr(_eventData.getStartTime(), "#0.0#"));

        if (_eventData.isPermanent()) {
        	permanetCheckBox.setSelected(true);
        }
        else {
        	permanetCheckBox.setSelected(false);
            durationTextField.setText(Number2String.toStr(_eventData.getDuration(), "#0.00#"));
        }
        permanetCheckBoxActionPerformed(null);

        if (_eventData.getType().equals(DStabDEventData.DEventType_LoadChange)) {
            loadChangeRadioButton.setSelected(true);        	
        	_loadChangePanel.setForm2Editor();
        }
        else {
        	if (_eventData.getType().equals(DStabDEventData.DEventType_BranchFault)) {
        		branchFaultRadioButton.setSelected(true);
        	}
        	else {
        		busFaultRadioButton.setSelected(true);
        	}
        	_faultLocDataPanel.setForm2Editor();
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
		IpssLogger.getLogger().info("NBDynaEventPanel saveEditor2Form() called");

		boolean ok = true;

		String eventName = (String)eventListComboBox.getSelectedItem();
    	if (eventName.equals(DStabDEventData.NewEventName) || eventName.trim().equals("")) {
    		// no data defined
			return ok;
    	}
    	_eventData.setEventName(eventName);

    	if (!SwingInputVerifyUtil.largeEqualThan(stratTimeTextField, 0.0d)) {
			errMsg.add("Dynamic event start time < 0.0");
			ok = false;
		}
    	_eventData.setStartTime(SwingInputVerifyUtil.getDouble(stratTimeTextField));


        _eventData.setPermanent(permanetCheckBox.isSelected());

        if (!permanetCheckBox.isSelected()) {
            if (!SwingInputVerifyUtil.largeThan(durationTextField, 0.0d)) {
    			errMsg.add("Dynamic event duration  <= 0.0");
    			ok = false;
    		}
            _eventData.setDuration(SwingInputVerifyUtil.getDouble(durationTextField));
        }
        
        if (_eventData.getType().equals(DStabDEventData.DEventType_LoadChange)) {
            if (!_loadChangePanel.saveEditor2Form(errMsg))
            	ok = false;
        }
        else {
            if (!_faultLocDataPanel.saveEditor2Form(errMsg))
            	ok = false;
        }

		if (_eventData.getFaultData().getType().equals(AcscFaultData.FaultType_Branch) && !_eventData.isPermanent()) {
			if (_eventData.getFaultData().isBranchReclosure()) {
				if (_eventData.getFaultData().getReclosureTime() <= (_eventData.getStartTime()+_eventData.getDuration())) {
	    			errMsg.add("Branch reclosure at time <= start+duration");
	    			ok = false;
				}
			}
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
        java.awt.GridBagConstraints gridBagConstraints;

        eventTypeButtonGroup = new javax.swing.ButtonGroup();
        dynamicEventPanel = new javax.swing.JPanel();
        eventListPanel = new javax.swing.JPanel();
        durationLabel = new javax.swing.JLabel();
        eventListLabel = new javax.swing.JLabel();
        permanetCheckBox = new javax.swing.JCheckBox();
        eventListComboBox = new javax.swing.JComboBox();
        durationTextField = new javax.swing.JTextField();
        stratTimeTextField = new javax.swing.JTextField();
        startTimeLabel = new javax.swing.JLabel();
        eventTypePanel = new javax.swing.JPanel();
        busFaultRadioButton = new javax.swing.JRadioButton();
        branchFaultRadioButton = new javax.swing.JRadioButton();
        loadChangeRadioButton = new javax.swing.JRadioButton();
        eventInputPanel = new javax.swing.JPanel();
        controlPanel = new javax.swing.JPanel();
        saveEventButton = new javax.swing.JButton();
        addEventButton = new javax.swing.JButton();
        deleteEventButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        dynamicEventPanel.setLayout(new java.awt.GridBagLayout());

        durationLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        durationLabel.setText("          Duration(sec)   ");

        eventListLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        eventListLabel.setText("Dynamic Event List     ");

        permanetCheckBox.setFont(new java.awt.Font("Dialog", 0, 12));
        permanetCheckBox.setText("Permanent");
        permanetCheckBox.setToolTipText("A permanent fault is clear by disconnecting all associated branches");
        permanetCheckBox.setName("permanetCheckBox");
        permanetCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permanetCheckBoxActionPerformed(evt);
            }
        });

        eventListComboBox.setEditable(true);
        eventListComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        eventListComboBox.setName("eventListComboBox");
        eventListComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventListComboBoxActionPerformed(evt);
            }
        });

        durationTextField.setColumns(4);
        durationTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        durationTextField.setText("0.1");
        durationTextField.setName("durationTextField");

        stratTimeTextField.setColumns(4);
        stratTimeTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        stratTimeTextField.setText("0.0");
        stratTimeTextField.setDragEnabled(true);
        stratTimeTextField.setName("stratTimeTextField");

        startTimeLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        startTimeLabel.setText("          Start Time(sec)   ");

        org.jdesktop.layout.GroupLayout eventListPanelLayout = new org.jdesktop.layout.GroupLayout(eventListPanel);
        eventListPanel.setLayout(eventListPanelLayout);
        eventListPanelLayout.setHorizontalGroup(
            eventListPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(eventListPanelLayout.createSequentialGroup()
                .add(eventListPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(eventListPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(startTimeLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(stratTimeTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(14, 14, 14)
                        .add(durationLabel)
                        .add(18, 18, 18)
                        .add(durationTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(31, 31, 31)
                        .add(permanetCheckBox))
                    .add(eventListPanelLayout.createSequentialGroup()
                        .add(142, 142, 142)
                        .add(eventListLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(eventListComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(61, 61, 61))
        );
        eventListPanelLayout.setVerticalGroup(
            eventListPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(eventListPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(eventListPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(eventListLabel)
                    .add(eventListComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(10, 10, 10)
                .add(eventListPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(durationTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(durationLabel)
                    .add(stratTimeTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(startTimeLabel)
                    .add(permanetCheckBox))
                .addContainerGap())
        );
        dynamicEventPanel.add(eventListPanel, new java.awt.GridBagConstraints());

        eventTypePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Event Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10), new java.awt.Color(0, 0, 0)));
        eventTypeButtonGroup.add(busFaultRadioButton);
        busFaultRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        busFaultRadioButton.setSelected(true);
        busFaultRadioButton.setText("Bus Fault");
        busFaultRadioButton.setName("busFaultRadioButton");
        busFaultRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busFaultRadioButtonActionPerformed(evt);
            }
        });

        eventTypePanel.add(busFaultRadioButton);

        eventTypeButtonGroup.add(branchFaultRadioButton);
        branchFaultRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        branchFaultRadioButton.setText("Branch Fault");
        branchFaultRadioButton.setName("branchFaultRadioButton");
        branchFaultRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchFaultRadioButtonActionPerformed(evt);
            }
        });

        eventTypePanel.add(branchFaultRadioButton);

        eventTypeButtonGroup.add(loadChangeRadioButton);
        loadChangeRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        loadChangeRadioButton.setText("Load Change");
        loadChangeRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        loadChangeRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        loadChangeRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadChangeRadioButtonActionPerformed(evt);
            }
        });

        eventTypePanel.add(loadChangeRadioButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 15, 0);
        dynamicEventPanel.add(eventTypePanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        dynamicEventPanel.add(eventInputPanel, gridBagConstraints);

        saveEventButton.setFont(new java.awt.Font("Dialog", 0, 12));
        saveEventButton.setText("SaveEvent");
        saveEventButton.setName("saveEventButton");
        saveEventButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveEventButtonActionPerformed(evt);
            }
        });

        controlPanel.add(saveEventButton);

        addEventButton.setFont(new java.awt.Font("Dialog", 0, 12));
        addEventButton.setText("AddEvent");
        addEventButton.setName("addEventButton");
        addEventButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEventButtonActionPerformed(evt);
            }
        });

        controlPanel.add(addEventButton);

        deleteEventButton.setFont(new java.awt.Font("Dialog", 0, 12));
        deleteEventButton.setText("DeleteEvent");
        deleteEventButton.setName("deleteEventButton");
        deleteEventButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEventButtonActionPerformed(evt);
            }
        });

        controlPanel.add(deleteEventButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 15, 0);
        dynamicEventPanel.add(controlPanel, gridBagConstraints);

        add(dynamicEventPanel, java.awt.BorderLayout.CENTER);

    }// </editor-fold>//GEN-END:initComponents

    private void permanetCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_permanetCheckBoxActionPerformed
   	    durationLabel.setEnabled(!permanetCheckBox.isSelected());
   	    durationTextField.setEnabled(!permanetCheckBox.isSelected());
   	    _faultLocDataPanel.setBranchReclosureStatus(!permanetCheckBox.isSelected());
    }//GEN-LAST:event_permanetCheckBoxActionPerformed

    private void deleteEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEventButtonActionPerformed
		_caseData.removeDEventData(_eventData);
		// if no event left, a new event will be created by the getAnyEventData() call
		_eventData = _caseData.getAnyEventData();
		// update the event name list combo box
		this.eventListComboBox.setModel(new javax.swing.DefaultComboBoxModel(_caseData.getEventNameArray()));
		// update the event data screen
		setForm2Editor();
    }//GEN-LAST:event_deleteEventButtonActionPerformed

    private void addEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEventButtonActionPerformed
		_eventData = new DStabDEventData();
		_eventData.setEventName(DStabDEventData.NewEventName);
		_caseData.addDEventData(_eventData);
		// update the event name list combo box
		this.eventListComboBox.setModel(new javax.swing.DefaultComboBoxModel(_caseData.getEventNameArray()));
		this.eventListComboBox.setSelectedItem(_eventData.getEventName());
	    busFaultRadioButtonActionPerformed(null);
	    // set fault or load change editor panel pointing to the current eventData object
	    setCurrentEventData(_eventData);
    }//GEN-LAST:event_addEventButtonActionPerformed

    private void saveEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveEventButtonActionPerformed
		Vector errMsg = new Vector();
		try {
			if (!saveEditor2Form(errMsg)) {
				SpringAppContext.getEditorDialogUtil().showMsgDialog(parentDialog, "Input Data Error", errMsg);
        		return;
			}
		} catch (Exception e) {
			IpssLogger.logErr(e);
			SpringAppContext.getEditorDialogUtil().showMsgDialog(parentDialog, "Input Data Error", e.toString());
       		return;
		}
		// event name may be modified, refresh the event list
		this.eventListComboBox.setModel(new javax.swing.DefaultComboBoxModel(_caseData.getEventNameArray()));
		this.eventListComboBox.setSelectedItem(_eventData.getEventName());
		// selected event may have been changed, refresh the screen
		eventListComboBoxActionPerformed(null);
    }//GEN-LAST:event_saveEventButtonActionPerformed

    private void eventListComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventListComboBoxActionPerformed
		String eventName = (String)this.eventListComboBox.getSelectedItem();
    	DStabDEventData event = _caseData.getDEventData(eventName);
    	if (event != null)        // event list selection changed
    		_eventData = event;       
    	else {                    // event name changed
    		IpssLogger.getLogger().info("Event name changed to " + eventName);
    		_eventData.setEventName(eventName);   
    	}
        setForm2Editor();
    	SimuAppSpringAppContext.getCaseInfoDialog().pack();
    }//GEN-LAST:event_eventListComboBoxActionPerformed

    private void branchFaultRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchFaultRadioButtonActionPerformed
		_eventData.setType(DStabDEventData.DEventType_BranchFault);
    	_eventData.getFaultData().setType(AcscFaultData.FaultType_Branch);
    	IpssLogger.getLogger().info("Branch fault event :" + _eventData.getEventName());
    	// refresh the fault data editing screen, which is depending on the caseData.faulData object
        refreshEditorPanel();
    }//GEN-LAST:event_branchFaultRadioButtonActionPerformed

    private void busFaultRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busFaultRadioButtonActionPerformed
		_eventData.setType(DStabDEventData.DEventType_BusFault);
		_eventData.getFaultData().setType(AcscFaultData.FaultType_Bus);
    	IpssLogger.getLogger().info("Bus fault event :" + _eventData.getEventName());
    	// refresh the fault data editing screen, which is depending on the caseData.faulData object
        refreshEditorPanel();
    }//GEN-LAST:event_busFaultRadioButtonActionPerformed
    
    private void loadChangeRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadChangeRadioButtonActionPerformed
		_eventData.setType(DStabDEventData.DEventType_LoadChange);
    	IpssLogger.getLogger().info("LoadChange event :" + _eventData.getEventName());
    	// refresh the fault data editing screen, which is depending on the object
        refreshEditorPanel();
    }//GEN-LAST:event_loadChangeRadioButtonActionPerformed

    private void refreshEditorPanel() {
        eventInputPanel.removeAll();
		if (_eventData.getType().equals(DStabDEventData.DEventType_LoadChange)) {
			eventInputPanel.add(_loadChangePanel);
		}
		else {
	        eventInputPanel.add(_faultLocDataPanel);
    		_faultLocDataPanel.setBusBranchFaultPanel();
		}
    	SimuAppSpringAppContext.getCaseInfoDialog().pack();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEventButton;
    private javax.swing.JRadioButton branchFaultRadioButton;
    private javax.swing.JRadioButton busFaultRadioButton;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JButton deleteEventButton;
    private javax.swing.JLabel durationLabel;
    private javax.swing.JTextField durationTextField;
    private javax.swing.JPanel dynamicEventPanel;
    private javax.swing.JPanel eventInputPanel;
    private javax.swing.JComboBox eventListComboBox;
    private javax.swing.JLabel eventListLabel;
    private javax.swing.JPanel eventListPanel;
    private javax.swing.ButtonGroup eventTypeButtonGroup;
    private javax.swing.JPanel eventTypePanel;
    private javax.swing.JRadioButton loadChangeRadioButton;
    private javax.swing.JCheckBox permanetCheckBox;
    private javax.swing.JButton saveEventButton;
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
