 /*
  * @(#)NBCaseInfoDialog.java   
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

import org.interpss.editor.SimuAppSpringAppContext;
import org.interpss.editor.app.AppSimuContextImpl;
import org.interpss.editor.data.proj.CaseData;
import org.interpss.editor.data.proj.ProjData;
import org.interpss.editor.jgraph.GraphSpringAppContext;
import org.interpss.editor.jgraph.ui.IGraphicEditor;
import org.interpss.editor.runAct.DStabRunForm;
import org.interpss.editor.ui.ICaseInfoDialog;

import com.interpss.common.SpringAppContext;
import com.interpss.common.ui.SwingInputVerifyUtil;
import com.interpss.common.ui.WinUtilities;
import com.interpss.common.util.IpssLogger;
import com.interpss.simu.SimuContext;

public class NBCaseInfoDialog extends javax.swing.JDialog implements ICaseInfoDialog {
	private static final long serialVersionUID = 1;

	private boolean  _returnOK = false;

	// case type of the current case being edited, defined in CaseData (CaseType_Aclf, CaseType_Acsc, CaseType_DStab)
	private String      _caseType = "";

	// holding the case data being edited
	private CaseData _caseData = null;
	
	// ref to the AppInfo where the current project data are hold
	private AppSimuContextImpl _appSimuCtx = null;
	 
    private NBAclfCasePanel  _aclfCaseInfoPanel = null;
    private NBAcscCasePanel  _acscCaseInfoPanel = null;
    private NBDStabCasePanel _dstabCaseInfoPanel = null;
    private NBScriptingCasePanel _scrptsCaseInfoPanel = null;
    
    public NBCaseInfoDialog(java.awt.Frame parent) {
        super(parent, "Run AC Loadflow Analysis", true);
        initComponents();
        WinUtilities.center(this);

        // disable add and delete case 5/3/06 Mike
        addCaseButton.setEnabled(false);
        deleteCaseButton.setEnabled(false);
        
        _aclfCaseInfoPanel = new NBAclfCasePanel(this);
        _acscCaseInfoPanel = new NBAcscCasePanel(this);
        _dstabCaseInfoPanel = new NBDStabCasePanel(this);
        _scrptsCaseInfoPanel = new NBScriptingCasePanel(this);

        DataVerifier verifier = new DataVerifier();
		this.casenameComboBox.setInputVerifier(verifier);
	}

	public NBCaseInfoDialog(IGraphicEditor parent) {
        this(parent.getFrame());
    }
	
	public void init(Object netContainer, Object appCtx) {
		IpssLogger.getLogger().info("NBCaseInfoDialog init() called");
		_appSimuCtx = (AppSimuContextImpl)appCtx;
        
		caseDataPanel.removeAll();
		if (_caseType == CaseData.CaseType_Aclf) {
			this.setTitle("Run Aclf Loadflow Analysis");
			caseDataPanel.add(_aclfCaseInfoPanel);
			_aclfCaseInfoPanel.init(netContainer, _appSimuCtx.getSimuCtx(), true);
			((SimuContext)_appSimuCtx.getSimuCtx()).getMsgHub().addMsgListener(_aclfCaseInfoPanel);
		}
		else if (_caseType == CaseData.CaseType_Acsc) {
			this.setTitle("Run Acsc Short Circuit Analysis");
			caseDataPanel.add(_acscCaseInfoPanel);
			_acscCaseInfoPanel.init(netContainer, _appSimuCtx);
		}	
		else if (_caseType == CaseData.CaseType_DStab) {
			this.setTitle("Run Transient Stability Simulation");
			caseDataPanel.add(_dstabCaseInfoPanel);
			_dstabCaseInfoPanel.init(netContainer, _appSimuCtx.getSimuCtx());
		}	
		else if (_caseType == CaseData.CaseType_Scripts) {
			this.setTitle("Custom Scripting Run Case");
			caseDataPanel.add(_scrptsCaseInfoPanel);
			_scrptsCaseInfoPanel.init(netContainer, _appSimuCtx);
		}	
		
        _returnOK = false;
        setForm2Editor();
        pack();
        WinUtilities.center(this);
        setVisible(true);
	}
    
	/**
	 * When the Run button clicked, return true to perform the run case
	 * 
	 * @return if the Run button was clicked
	 */
    public boolean isReturnOk() {
        return _returnOK;
    }

    /**
     * Set the type for the current case being edited
     * 
     * @param type case type
     */
    public void setCaseType(String type) {
        _caseType = type;
    }
    
    public void setDStabOutputScriptFilename(String filename) {
    	_dstabCaseInfoPanel.setDStabOutputScriptFilename(filename);    
    }

	/**
	*	Set form data to the editor
	*
	* @return false if there is any problem
	*/
	public boolean setForm2Editor() {
		IpssLogger.getLogger().info("NBCaseInfoDialog setForm2Editor() called");

		// build the case info combo list
		this.casenameComboBox.setModel(new javax.swing.DefaultComboBoxModel(_appSimuCtx.getCasenameArray(_caseType)));
		IpssLogger.getLogger().info("Casename Array size: " + _appSimuCtx.getCasenameArray(_caseType).length);
		
		// find the last edited casename, which is hold by the projData, which will be persisted to
		// project file
		String casename = null; 
		ProjData projData = (ProjData)_appSimuCtx.getProjData();
		if (_caseType == CaseData.CaseType_Aclf && projData.getAclfCaseName() != null) {
			casename = projData.getAclfCaseName();
			this.casenameComboBox.setSelectedItem(casename); 
		}
		else if (_caseType == CaseData.CaseType_Acsc && projData.getAcscCaseName() != null) {
			casename = projData.getAcscCaseName();
			this.casenameComboBox.setSelectedItem(casename); 
		}
		else if (_caseType == CaseData.CaseType_DStab && projData.getDStabCaseName() != null) {
			casename = projData.getDStabCaseName();
			this.casenameComboBox.setSelectedItem(casename); 
		}
		else if (_caseType == CaseData.CaseType_Scripts && projData.getScriptsCaseName() != null) {
			casename = projData.getScriptsCaseName();
			this.casenameComboBox.setSelectedItem(casename); 
		}
		else {
			// in this case, the projData.<*>Casename is null, a new case
			IpssLogger.getLogger().info("casenameComboBox.getSelectedItem() -> " + this.casenameComboBox.getSelectedItem());
			this.casenameComboBox.setSelectedIndex(0);
			casename = (String)this.casenameComboBox.getSelectedItem(); 
		}
		
		// retrieve the case data from appCtx.projData.caseList
		_caseData = _appSimuCtx.getCaseData(casename, _caseType);
		if ( _caseData == null)
			// new case situation, create a new case
			_caseData = _appSimuCtx.createCaseData(casename, _caseType);
		
		this.descTextArea.setText(_caseData.getDescription());

		if (_caseType == CaseData.CaseType_Aclf) {
			// update projData with the current casename
			projData.setAclfCaseName(casename);
			// update the AclfRunForm object, which actually run the case
			SimuAppSpringAppContext.getAclfRunForm().setAclfCaseData(_caseData.getAclfCaseData());
			// set the case data to the actual data editing panel
			_aclfCaseInfoPanel.setCaseData(_caseData.getAclfCaseData());
			// set the case data to the actual data editing panel
			_aclfCaseInfoPanel.setForm2Editor();
		}
		else if (_caseType == CaseData.CaseType_Acsc) {
			projData.setAcscCaseName(casename);
			SimuAppSpringAppContext.getAcscRunForm().setAcscCaseData(_caseData.getAcscCaseData());
			_acscCaseInfoPanel.setCaseData(_caseData.getAcscCaseData());
			_acscCaseInfoPanel.setForm2Editor();
		}
		else if (_caseType == CaseData.CaseType_DStab) {
			projData.setDStabCaseName(casename);
			DStabRunForm dsatbRunForm = (DStabRunForm)_appSimuCtx.getDStabRunForm();
			dsatbRunForm.setDStabCaseData(_caseData.getDStabCaseData());
			dsatbRunForm.setAclfCaseData(_caseData.getAclfCaseData());
			_dstabCaseInfoPanel.setCaseData(_caseData);
			_dstabCaseInfoPanel.setForm2Editor();
		}
		else if (_caseType == CaseData.CaseType_Scripts) {
			projData.setScriptsCaseName(casename);
			_scrptsCaseInfoPanel.setCaseData(_caseData);
			_scrptsCaseInfoPanel.setForm2Editor();
		}
		
        return true;
	}
    
	/**
	*	Save editor screen data to the form
	*
	* @param errMsg error messages during the saving process.
	* @return false if there is any problem
	*/
    public boolean saveEditor2Form(Vector<String> errMsg) throws Exception {
		IpssLogger.getLogger().info("NBCaseInfoDialog saveEditor2Form() called");

		if (SwingInputVerifyUtil.isEmptyStr(this.casenameComboBox)) {
			errMsg.add("Casename is empty");
			return false;
		}
		String casename = (String)this.casenameComboBox.getSelectedItem();
		_caseData.setCaseName(casename);
		_caseData.setDescription(this.descTextArea.getText());

		ProjData projData = (ProjData)_appSimuCtx.getProjData();
		if (_caseType == CaseData.CaseType_Aclf) {
			projData.setAclfCaseName(casename);
			_aclfCaseInfoPanel.saveEditor2Form(errMsg);
		}
		else if (_caseType == CaseData.CaseType_Acsc) {
			projData.setAcscCaseName(casename);
			_acscCaseInfoPanel.saveEditor2Form(errMsg);
		}
		else if (_caseType == CaseData.CaseType_DStab) {
			projData.setDStabCaseName(casename);
			_dstabCaseInfoPanel.saveEditor2Form(errMsg);
		}
		else if (_caseType == CaseData.CaseType_Scripts) {
			projData.setScriptsCaseName(casename);
			_scrptsCaseInfoPanel.saveEditor2Form(errMsg);
		}
		
        return errMsg.size() == 0;
	}
    
    /** Creates new form NBAclfCalDialog */
    public NBCaseInfoDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        caseInfoPanel = new javax.swing.JPanel();
        casenameLabel = new javax.swing.JLabel();
        casenameComboBox = new javax.swing.JComboBox();
        descLabel = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        descTextArea = new javax.swing.JTextArea();
        caseDataPanel = new javax.swing.JPanel();
        controlPanel = new javax.swing.JPanel();
        runButton = new javax.swing.JButton();
        addCaseButton = new javax.swing.JButton();
        deleteCaseButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setModal(true);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        caseInfoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Study Case", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10)));
        caseInfoPanel.setLayout(new java.awt.GridBagLayout());

        casenameLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        casenameLabel.setText("Casename");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 10);
        caseInfoPanel.add(casenameLabel, gridBagConstraints);

        casenameComboBox.setEditable(true);
        casenameComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        casenameComboBox.setName("casenameComboBox"); // NOI18N
        casenameComboBox.setPreferredSize(new java.awt.Dimension(250, 21));
        casenameComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casenameComboBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 10);
        caseInfoPanel.add(casenameComboBox, gridBagConstraints);

        descLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        descLabel.setText("Description");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 10);
        caseInfoPanel.add(descLabel, gridBagConstraints);

        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        descTextArea.setColumns(30);
        descTextArea.setFont(new java.awt.Font("Dialog", 0, 12));
        descTextArea.setRows(2);
        descTextArea.setName("descTextArea"); // NOI18N
        scrollPane.setViewportView(descTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 10);
        caseInfoPanel.add(scrollPane, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 20);
        getContentPane().add(caseInfoPanel, gridBagConstraints);

        caseDataPanel.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 20);
        getContentPane().add(caseDataPanel, gridBagConstraints);

        runButton.setFont(new java.awt.Font("Dialog", 0, 12));
        runButton.setText("Run");
        runButton.setToolTipText("Run the current case");
        runButton.setName("runButton"); // NOI18N
        runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });
        controlPanel.add(runButton);

        addCaseButton.setFont(new java.awt.Font("Dialog", 0, 12));
        addCaseButton.setText("AddCase");
        addCaseButton.setToolTipText("Add a new study case");
        addCaseButton.setName("addCaseButton"); // NOI18N
        addCaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCaseButtonActionPerformed(evt);
            }
        });
        controlPanel.add(addCaseButton);

        deleteCaseButton.setFont(new java.awt.Font("Dialog", 0, 12));
        deleteCaseButton.setText("DeleteCase");
        deleteCaseButton.setToolTipText("Delete the current study case");
        deleteCaseButton.setName("deleteCaseButton"); // NOI18N
        deleteCaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCaseButtonActionPerformed(evt);
            }
        });
        controlPanel.add(deleteCaseButton);

        cancelButton.setFont(new java.awt.Font("Dialog", 0, 12));
        cancelButton.setText("Cancel");
        cancelButton.setToolTipText("Cancel and close the case dialog");
        cancelButton.setName("cancelButton"); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        controlPanel.add(cancelButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 30, 20, 30);
        getContentPane().add(controlPanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
		_returnOK = false;
		if (_caseType == CaseData.CaseType_Aclf)
			((SimuContext)_appSimuCtx.getSimuCtx()).getMsgHub().removeMsgListener(_aclfCaseInfoPanel);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void deleteCaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCaseButtonActionPerformed
		if (this.casenameComboBox.getItemCount() > 1) {
			String casename = (String)this.casenameComboBox.getSelectedItem();
			_appSimuCtx.deleteCaseData(casename, _caseType);
			this.casenameComboBox.setModel(new javax.swing.DefaultComboBoxModel(_appSimuCtx.getCasenameArray(_caseType)));

			this.casenameComboBox.setSelectedIndex(0);
		    casenameComboBoxActionPerformed(null);   // to refresh the edit screen
		}
		else {
			SpringAppContext.getEditorDialogUtil().showMsgDialog("Warnning", "The project has to have minimum one case.");
		}
    }//GEN-LAST:event_deleteCaseButtonActionPerformed

    private void addCaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCaseButtonActionPerformed
		IpssLogger.getLogger().info("NBCaseInfoPanel addCaseButtonActionPerformed() called");
		String casename = (String)this.casenameComboBox.getSelectedItem();	 
		if (casename == null || casename.trim() == "")
			casename = "A New Case";
		if (_appSimuCtx.getCaseData(casename, _caseType) != null) 
			casename = "A New Case";
		_caseData = _appSimuCtx.createCaseData(casename, _caseType);
	    casenameComboBoxActionPerformed(null);   // to refresh the edit screen
    }//GEN-LAST:event_addCaseButtonActionPerformed

    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed
		Vector<String> errMsg = new Vector<String>();
		try {
        	if (!saveEditor2Form(errMsg)) {
        		SpringAppContext.getEditorDialogUtil().showMsgDialog(this, "Input Data Error", errMsg);
				return;
        	}
        } catch (Exception e) {
        	IpssLogger.logErr(e);
        	SpringAppContext.getEditorDialogUtil().showMsgDialog(this, "Input Data Error", e.toString());
			return;
        }	
		_returnOK = true;
		_appSimuCtx.getProjData().setDirty(true);
		if (_caseType == CaseData.CaseType_Aclf)
			((SimuContext)_appSimuCtx.getSimuCtx()).getMsgHub().removeMsgListener(_aclfCaseInfoPanel);
		GraphSpringAppContext.getIpssGraphicEditor().refreshCurrentDocumentEditorPanel();        
        setVisible(false);
        dispose();
    }//GEN-LAST:event_runButtonActionPerformed

    private void casenameComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casenameComboBoxActionPerformed
		IpssLogger.getLogger().info("NBCaseInfoPanel casenameComboBoxActionPerformed called");
		// at least two ways can trig this action: 1) Case List section 2) Change Case name
		String casename = (String)this.casenameComboBox.getSelectedItem();
		if (_appSimuCtx.getCaseData(casename, _caseType) != null) {  
			// make sure it is case selection event. if it is change case name event, the case won't be
			// in the projData.caseList
			ProjData projData = (ProjData)_appSimuCtx.getProjData();
			if (_caseType == CaseData.CaseType_Aclf) 
				// update current projData.casename, which controls the case being displayed and edited
				projData.setAclfCaseName(casename);
			else if (_caseType == CaseData.CaseType_Acsc) 
				projData.setAcscCaseName(casename);
			else if (_caseType == CaseData.CaseType_DStab) 
				projData.setDStabCaseName(casename);
			else if (_caseType == CaseData.CaseType_Scripts) 
				projData.setScriptsCaseName(casename);
			// refresh the screen data
			setForm2Editor();
		}
    }//GEN-LAST:event_casenameComboBoxActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCaseButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel caseDataPanel;
    private javax.swing.JPanel caseInfoPanel;
    private javax.swing.JComboBox casenameComboBox;
    private javax.swing.JLabel casenameLabel;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JButton deleteCaseButton;
    private javax.swing.JLabel descLabel;
    private javax.swing.JTextArea descTextArea;
    private javax.swing.JButton runButton;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables

    class DataVerifier extends javax.swing.InputVerifier {
    	public boolean verify(javax.swing.JComponent input) {
			if (input == null)
				return false;
       		try {
				if (input == casenameComboBox )
					return !SwingInputVerifyUtil.isEmptyStr((javax.swing.JComboBox)input);
 	       	} catch (Exception e) {
 	    		return false;
 	       	}		
			return true;
        }
    }
}
