 /*
  * @(#)NBProjectEditDialog.java   
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

package org.interpss.editor.ui.edit;

import java.util.Vector;

import org.interpss.editor.data.proj.ProjData;
import org.interpss.editor.form.GFormContainer;
import org.interpss.editor.form.GNetForm;
import org.interpss.editor.form.InitDataUtil;
import org.interpss.editor.jgraph.ui.IGraphicEditor;
import org.interpss.editor.jgraph.ui.edit.IFormDataDialog;
import org.interpss.editor.jgraph.ui.edit.IFormDataPanel;
import org.interpss.editor.jgraph.ui.form.IGNetForm;
import org.interpss.editor.ui.edit.dist.NBDistProjEditPanel;
import org.interpss.editor.ui.edit.trans.NBAclfTransProjPanel;
import org.interpss.editor.ui.edit.trans.NBAcscTransProjPanel;
import org.interpss.editor.ui.edit.trans.NBDStabTransProjPanel;

import com.interpss.common.SpringAppContext;
import com.interpss.common.msg.DataChangeMessage;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.ui.SwingInputVerifyUtil;
import com.interpss.common.ui.WinUtilities;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.Number2String;
  
 
public class NBProjectEditDialog extends javax.swing.JDialog implements IFormDataDialog {
	private static final long serialVersionUID = 1;

	private IPSSMsgHub msgHub = null;
	private GFormContainer _netContainer = null;
	private ProjData _projInfo = null;
    
    private NBAclfTransProjPanel   _aclfTransEditPanel = new NBAclfTransProjPanel();
    private NBDistProjEditPanel  _distriEditPanel = new NBDistProjEditPanel();
    private NBAcscTransProjPanel   _acscTransEditPanel = new NBAcscTransProjPanel();
    private NBDStabTransProjPanel  _dstabTransEditPanel = new NBDStabTransProjPanel();
    
    private boolean returnOk = false;
    
	/**
	 * @return Returns the returnOk.
	 */
	public boolean isReturnOk() {
		return returnOk;
	}

	/**
	 * @param returnOk The returnOk to set.
	 */
	private void setReturnOk(boolean returnOk) {
		this.returnOk = returnOk;
	}

	/**
	*	Constructor
	*
	* @parem parent the parent Frame object	
	*/
	public NBProjectEditDialog(java.awt.Frame parent, IPSSMsgHub aMsgHub) {
        super(parent, "Project Data Editor", true);
        initComponents();
        WinUtilities.center(this);

        this.msgHub = aMsgHub;

        DataVerifier verifier = new DataVerifier();
    	this.baseKvaField.setInputVerifier(verifier);
    	this.baseFreqField.setInputVerifier(verifier);

		_aclfTransEditPanel.initPanel();
		_distriEditPanel.initPanel(this);
		_acscTransEditPanel.initPanel();
		_dstabTransEditPanel.initPanel();
    }

    public NBProjectEditDialog(IGraphicEditor parent, IPSSMsgHub aMsg) {
        this(parent.getFrame(), aMsg);
    }
	
	/**
	*	For performance reason, editor objects are static member of the 
	*   CellEditorFactory. This method is for init the editor for the form
	* 	object to be edtied
	*
	* @param netContainer the NetContainer object
	* @param obj the ProjectSelect object
	*/    
	public void init(Object netContainer, Object obj) {
		IpssLogger.getLogger().info("NBProjectEditDialog.init() called");

	    distriAppRadioButton.setEnabled(true);
	    transAppRadioButton.setEnabled(true);
		
		_netContainer = (GFormContainer)netContainer;
		_projInfo = (ProjData)obj;
		GNetForm form = (GNetForm)((GFormContainer)netContainer).getGNetForm();
		if (form.isNewState()) {
			_netContainer.initGNetForm(IGNetForm.NetType_AcscNetwork, IGNetForm.AppType_Distribution);
			_projInfo.setProjectName("InterPSS Project");
			_projInfo.setDescription("An InterPSS project created be InterPSS OneLine Draw");
		}	
    		
		// set radio buttons and the input editing panel
		setNetAppType(form);
		
		// copy data from the form to the editor input panels, including 
		// child panels 
    	setForm2Editor();
		
		// pack the form and display
		pack();
        WinUtilities.center(this);
        setVisible(true);
		this.returnOk = false;
	}

	/**
	*	Set form data to the editor
	*
	* @return false if there is any problem
	*/	
    public boolean setForm2Editor() {
		IpssLogger.getLogger().info("NBProjectEditDialog.setForm2Editor() called");
		GNetForm form = (GNetForm)_netContainer.getGNetForm();
    	this.filenameLabel.setText(_projInfo.getFilename());
    	this.descTextArea.setText(_projInfo.getDescription());

		this.baseKvaField.setText(Number2String.toStr(form.getBaseKVA(), "#.0"));
    	this.baseFreqField.setText(Number2String.toStr(form.getFreqHZ(), "#.0"));
    	
        if (_netContainer.getGNetForm().getAppType().equals(IGNetForm.AppType_Distribution)) {
    		_distriEditPanel.setForm2Editor();
        }	
        else {
            if (_netContainer.getGNetForm().getNetType().equals(IGNetForm.NetType_AcscNetwork))
            	_acscTransEditPanel.setForm2Editor();
            else if (_netContainer.getGNetForm().getNetType().equals(IGNetForm.NetType_DStabilityNet))
            	_dstabTransEditPanel.setForm2Editor();
            else
            	_aclfTransEditPanel.setForm2Editor();
        }

		pack();
		return true;
    }
    
	/**
	*	Save editor screen data to the form
	*
	* @param errMsg error messages during the saving process.
	* @return false if there is any problem
	*/
	public boolean saveEditor2Form(Vector errMsg) throws Exception {
		IpssLogger.getLogger().info("NBProjectEditDialog.saveEditor2Form() called");
		GNetForm form = (GNetForm)_netContainer.getGNetForm();
		errMsg.clear();
		boolean ok = true;

    	_projInfo.setDescription(this.descTextArea.getText());

		if (!SwingInputVerifyUtil.largeThan(this.baseKvaField, 0.0d)) {
			errMsg.add("Base KVA <= 0.0");
			ok = false;
		}
    	form.setBaseKVA(SwingInputVerifyUtil.getDouble(this.baseKvaField));

		if (!SwingInputVerifyUtil.largeThan(this.baseFreqField, 0.0d)) {
			errMsg.add("Base Freq <= 0.0");
			ok = false;
		}
    	form.setFreqHZ(SwingInputVerifyUtil.getDouble(this.baseFreqField));
    	
		if (this.distriAppRadioButton.isSelected()) {
			form.setAppType(IGNetForm.AppType_Distribution);
			form.setNetType(IGNetForm.NetType_AcscNetwork);
			if (!_distriEditPanel.saveEditor2Form(errMsg))
				ok = false;
		}	
		else {
			form.setAppType(IGNetForm.AppType_Transmission);
			if (this.aclfNetRadioButton.isSelected()) {
				if (!_aclfTransEditPanel.saveEditor2Form(errMsg))
					ok = false;
			}	
			else if (this.dstabNetRadioButton.isSelected()) {
				if (!_dstabTransEditPanel.saveEditor2Form(errMsg))
					ok = false;
			}	
			else { 
				if (!_acscTransEditPanel.saveEditor2Form(errMsg))
					ok = false;
			}	
		}	

		return ok;
    }
    
	private void setNetAppType( GNetForm form ) {
		setNetAppType(form.getNetType(), form.getAppType());
		if (!form.isNewState()) {
    		this.distriAppRadioButton.setEnabled(false);
    		this.transAppRadioButton.setEnabled(false);
			this.aclfNetRadioButton.setEnabled(false);
    		this.acscNetRadioButton.setEnabled(false);
    		this.dstabNetRadioButton.setEnabled(false);

    		if (form.getNetType().equals(IGNetForm.NetType_AclfNetwork) || form.getNetType().equals(IGNetForm.NetType_AclfAdjNetwork)) {
    	    	this.acscNetRadioButton.setEnabled(true);
    	    	this.dstabNetRadioButton.setEnabled(true);
    		}
    		else if (form.getNetType().equals(IGNetForm.NetType_AcscNetwork)) {
    	    	this.acscNetRadioButton.setEnabled(true);
    		}
		}
	}
	
	private void setNetAppType(String netType, String appType) {
		IpssLogger.getLogger().info("NBProjectEditDialog.setNetAppType(String netType, String appType) called");
		if ( appType.equals(IGNetForm.AppType_Distribution)) {
    		this.distriAppRadioButton.setEnabled(true);
    		this.distriAppRadioButton.setSelected(true);
    		//this.transAppRadioButton.setEnabled(false);
			this.aclfNetRadioButton.setEnabled(false);
    		this.acscNetRadioButton.setEnabled(false);
			this.acscNetRadioButton.setSelected(true);
			this.dstabNetRadioButton.setEnabled(false);
		}
		else {
    		this.transAppRadioButton.setEnabled(true);
    		this.transAppRadioButton.setSelected(true);
			this.aclfNetRadioButton.setEnabled(true);
    		this.acscNetRadioButton.setEnabled(true);
    		this.dstabNetRadioButton.setEnabled(true);
		}

		if (appType.equals(IGNetForm.AppType_Distribution) ) {
        	this.editPanel.removeAll();
        	this.editPanel.add(_distriEditPanel, java.awt.BorderLayout.CENTER);
			((IFormDataPanel)_distriEditPanel).init(_netContainer, null);
			IpssLogger.getLogger().info("Insert AcscDistriEditPanel");
		}
		else if (netType.equals(IGNetForm.NetType_AclfNetwork) || netType.equals(IGNetForm.NetType_AclfAdjNetwork)) {
			this.aclfNetRadioButton.setSelected(true);
        	this.editPanel.removeAll();
        	this.editPanel.add(_aclfTransEditPanel, java.awt.BorderLayout.CENTER);
			((IFormDataPanel)_aclfTransEditPanel).init(_netContainer, null);
			IpssLogger.getLogger().info("Insert AclfTransEditPanel");
		}
		else if (netType.equals(IGNetForm.NetType_DStabilityNet)) {
			this.dstabNetRadioButton.setSelected(true);
        	this.editPanel.removeAll();
        	this.editPanel.add(_dstabTransEditPanel, java.awt.BorderLayout.CENTER);
			((IFormDataPanel)_dstabTransEditPanel).init(_netContainer, null);
			IpssLogger.getLogger().info("Insert DStabTransEditPanel");
		}
		else {
			this.acscNetRadioButton.setSelected(true);
        	this.editPanel.removeAll();
        	this.editPanel.add(_acscTransEditPanel, java.awt.BorderLayout.CENTER);
			((IFormDataPanel)_acscTransEditPanel).init(_netContainer, null);
			IpssLogger.getLogger().info("Insert AcscTransEditPanel");
		}
	}
	
	// The following code is controlled by NetBean IDE
	// ===============================================
	
    /** Creates new form NBNetEditDialog */
    public NBProjectEditDialog(java.awt.Frame parent, boolean modal) {
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

        appTypeButtonGroup = new javax.swing.ButtonGroup();
        netTypeButtonGroup = new javax.swing.ButtonGroup();
        netCfgButtonGroup = new javax.swing.ButtonGroup();
        inputPanel = new javax.swing.JPanel();
        selectionPanel = new javax.swing.JPanel();
        projFileLabel = new javax.swing.JLabel();
        filenameLabel = new javax.swing.JLabel();
        descLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descTextArea = new javax.swing.JTextArea();
        kvaPanel = new javax.swing.JPanel();
        baseKvaLabel = new javax.swing.JLabel();
        baseKvaField = new javax.swing.JTextField();
        kvaUnitLabel = new javax.swing.JLabel();
        baseFreqLabel = new javax.swing.JLabel();
        baseFreqField = new javax.swing.JTextField();
        fUnitLabel = new javax.swing.JLabel();
        typeSelectPanel = new javax.swing.JPanel();
        appTypePanel = new javax.swing.JPanel();
        transAppRadioButton = new javax.swing.JRadioButton();
        distriAppRadioButton = new javax.swing.JRadioButton();
        netTypePanel = new javax.swing.JPanel();
        aclfNetRadioButton = new javax.swing.JRadioButton();
        acscNetRadioButton = new javax.swing.JRadioButton();
        dstabNetRadioButton = new javax.swing.JRadioButton();
        configInfoTabbedPane = new javax.swing.JTabbedPane();
        editContainerPanel = new javax.swing.JPanel();
        editPanel = new javax.swing.JPanel();
        netConfigPanel = new javax.swing.JPanel();
        netCfgSelectPanel = new javax.swing.JPanel();
        leftEncloseLabel = new javax.swing.JLabel();
        interfaceNetConfigRadioButton = new javax.swing.JRadioButton();
        areaNetConfigRadioButton = new javax.swing.JRadioButton();
        zoneNetConfigRadioButton = new javax.swing.JRadioButton();
        rightEncloseLabel = new javax.swing.JLabel();
        netCfgInfoPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        netCfgItemList = new javax.swing.JList();
        netCfgEditPanel = new javax.swing.JPanel();
        netCfgNumberLabel = new javax.swing.JLabel();
        netCfgNameLabel = new javax.swing.JLabel();
        netCfgDescLabel = new javax.swing.JLabel();
        netCfgNumberTextField = new javax.swing.JTextField();
        netCfgNameTextField = new javax.swing.JTextField();
        netCfgDescTextField = new javax.swing.JTextField();
        netCfgEditButton = new javax.swing.JButton();
        netCfgAddButton = new javax.swing.JButton();
        netCfgUpdateButton = new javax.swing.JButton();
        controlPanel = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setAlwaysOnTop(true);
        setModal(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        getContentPane().setLayout(new java.awt.BorderLayout(10, 10));

        inputPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 1, 20));
        inputPanel.setLayout(new java.awt.BorderLayout(5, 5));

        selectionPanel.setLayout(new java.awt.GridBagLayout());

        projFileLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        projFileLabel.setText("Project File    ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        selectionPanel.add(projFileLabel, gridBagConstraints);

        filenameLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        filenameLabel.setText("Filename");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        selectionPanel.add(filenameLabel, gridBagConstraints);

        descLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        descLabel.setText("Description    ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        selectionPanel.add(descLabel, gridBagConstraints);

        descTextArea.setColumns(40);
        descTextArea.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        descTextArea.setLineWrap(true);
        descTextArea.setRows(2);
        descTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        descTextArea.setName("descTextArea"); // NOI18N
        jScrollPane1.setViewportView(descTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        selectionPanel.add(jScrollPane1, gridBagConstraints);

        baseKvaLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        baseKvaLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        baseKvaLabel.setText("BaseKVA   ");
        kvaPanel.add(baseKvaLabel);

        baseKvaField.setColumns(8);
        baseKvaField.setText("100000.0");
        baseKvaField.setName("baseKvaTextField"); // NOI18N
        kvaPanel.add(baseKvaField);

        kvaUnitLabel.setFont(new java.awt.Font("Dialog", 0, 10));
        kvaUnitLabel.setText("(kva)");
        kvaPanel.add(kvaUnitLabel);

        baseFreqLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        baseFreqLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        baseFreqLabel.setText("               BaseFreq");
        kvaPanel.add(baseFreqLabel);

        baseFreqField.setColumns(4);
        baseFreqField.setText("60.0");
        baseFreqField.setName("baseFreqTextField"); // NOI18N
        kvaPanel.add(baseFreqField);

        fUnitLabel.setFont(new java.awt.Font("Dialog", 0, 10));
        fUnitLabel.setText("(hz)");
        kvaPanel.add(fUnitLabel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        selectionPanel.add(kvaPanel, gridBagConstraints);

        typeSelectPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        appTypePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Application Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10))); // NOI18N
        appTypePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        appTypeButtonGroup.add(transAppRadioButton);
        transAppRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        transAppRadioButton.setSelected(true);
        transAppRadioButton.setText("Transmission");
        transAppRadioButton.setName("transAppRadioButton"); // NOI18N
        transAppRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transAppTypeActionHandler(evt);
            }
        });
        appTypePanel.add(transAppRadioButton);

        appTypeButtonGroup.add(distriAppRadioButton);
        distriAppRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        distriAppRadioButton.setText("Distribution");
        distriAppRadioButton.setName("distriAppRadioButton"); // NOI18N
        distriAppRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distriAppTypeActionHandler(evt);
            }
        });
        appTypePanel.add(distriAppRadioButton);

        typeSelectPanel.add(appTypePanel);

        netTypePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Network Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10))); // NOI18N
        netTypePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        netTypeButtonGroup.add(aclfNetRadioButton);
        aclfNetRadioButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        aclfNetRadioButton.setSelected(true);
        aclfNetRadioButton.setText("ACLF");
        aclfNetRadioButton.setName("aclfNetRadioButton"); // NOI18N
        aclfNetRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aclfNetTypeActionHandler(evt);
            }
        });
        netTypePanel.add(aclfNetRadioButton);

        netTypeButtonGroup.add(acscNetRadioButton);
        acscNetRadioButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        acscNetRadioButton.setText("ACSC");
        acscNetRadioButton.setName("acscNetRadioButton"); // NOI18N
        acscNetRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acscNetTypeActionHandler(evt);
            }
        });
        netTypePanel.add(acscNetRadioButton);

        netTypeButtonGroup.add(dstabNetRadioButton);
        dstabNetRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        dstabNetRadioButton.setSelected(true);
        dstabNetRadioButton.setText("TranStability");
        dstabNetRadioButton.setName("dstabNetRadioButton"); // NOI18N
        dstabNetRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dstabNetRadioButtonActionPerformed(evt);
            }
        });
        netTypePanel.add(dstabNetRadioButton);

        typeSelectPanel.add(netTypePanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        selectionPanel.add(typeSelectPanel, gridBagConstraints);

        inputPanel.add(selectionPanel, java.awt.BorderLayout.NORTH);

        configInfoTabbedPane.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        editContainerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        editContainerPanel.setLayout(new java.awt.BorderLayout());

        editPanel.setLayout(new java.awt.BorderLayout());
        editContainerPanel.add(editPanel, java.awt.BorderLayout.CENTER);

        configInfoTabbedPane.addTab("Project Config", editContainerPanel);

        leftEncloseLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        leftEncloseLabel.setText("[");
        netCfgSelectPanel.add(leftEncloseLabel);

        netCfgButtonGroup.add(interfaceNetConfigRadioButton);
        interfaceNetConfigRadioButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        interfaceNetConfigRadioButton.setSelected(true);
        interfaceNetConfigRadioButton.setText("Interface");
        interfaceNetConfigRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interfaceNetConfigRadioButtonActionPerformed(evt);
            }
        });
        netCfgSelectPanel.add(interfaceNetConfigRadioButton);

        netCfgButtonGroup.add(areaNetConfigRadioButton);
        areaNetConfigRadioButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        areaNetConfigRadioButton.setText("Area");
        areaNetConfigRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaNetConfigRadioButtonActionPerformed(evt);
            }
        });
        netCfgSelectPanel.add(areaNetConfigRadioButton);

        netCfgButtonGroup.add(zoneNetConfigRadioButton);
        zoneNetConfigRadioButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        zoneNetConfigRadioButton.setText("Zone");
        zoneNetConfigRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoneNetConfigRadioButtonActionPerformed(evt);
            }
        });
        netCfgSelectPanel.add(zoneNetConfigRadioButton);

        rightEncloseLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        rightEncloseLabel.setText("]");
        netCfgSelectPanel.add(rightEncloseLabel);

        netCfgItemList.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        netCfgItemList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(netCfgItemList);

        netCfgEditPanel.setLayout(new java.awt.GridBagLayout());

        netCfgNumberLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        netCfgNumberLabel.setText("Number");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        netCfgEditPanel.add(netCfgNumberLabel, gridBagConstraints);

        netCfgNameLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        netCfgNameLabel.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        netCfgEditPanel.add(netCfgNameLabel, gridBagConstraints);

        netCfgDescLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        netCfgDescLabel.setText("Desc");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        netCfgEditPanel.add(netCfgDescLabel, gridBagConstraints);

        netCfgNumberTextField.setColumns(3);
        netCfgNumberTextField.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        netCfgNumberTextField.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 0);
        netCfgEditPanel.add(netCfgNumberTextField, gridBagConstraints);

        netCfgNameTextField.setColumns(5);
        netCfgNameTextField.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        netCfgNameTextField.setText("name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 0);
        netCfgEditPanel.add(netCfgNameTextField, gridBagConstraints);

        netCfgDescTextField.setColumns(10);
        netCfgDescTextField.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        netCfgDescTextField.setText("desc");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 0);
        netCfgEditPanel.add(netCfgDescTextField, gridBagConstraints);

        netCfgEditButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        netCfgEditButton.setText("Edit");
        netCfgEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                netCfgEditButtonActionPerformed(evt);
            }
        });

        netCfgAddButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        netCfgAddButton.setText("Add");
        netCfgAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                netCfgAddButtonActionPerformed(evt);
            }
        });

        netCfgUpdateButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        netCfgUpdateButton.setText("Update");
        netCfgUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                netCfgUpdateButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout netCfgInfoPanelLayout = new org.jdesktop.layout.GroupLayout(netCfgInfoPanel);
        netCfgInfoPanel.setLayout(netCfgInfoPanelLayout);
        netCfgInfoPanelLayout.setHorizontalGroup(
            netCfgInfoPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(netCfgInfoPanelLayout.createSequentialGroup()
                .add(42, 42, 42)
                .add(netCfgEditButton)
                .add(12, 12, 12)
                .add(netCfgAddButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(netCfgUpdateButton)
                .addContainerGap(87, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, netCfgInfoPanelLayout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .add(netCfgEditPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 206, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(22, 22, 22))
            .add(netCfgInfoPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(netCfgInfoPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 82, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(234, Short.MAX_VALUE)))
        );
        netCfgInfoPanelLayout.setVerticalGroup(
            netCfgInfoPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(netCfgInfoPanelLayout.createSequentialGroup()
                .add(6, 6, 6)
                .add(netCfgEditPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 86, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(netCfgInfoPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(netCfgEditButton)
                    .add(netCfgUpdateButton)
                    .add(netCfgAddButton))
                .add(13, 13, 13))
            .add(netCfgInfoPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(netCfgInfoPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 78, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(52, Short.MAX_VALUE)))
        );

        org.jdesktop.layout.GroupLayout netConfigPanelLayout = new org.jdesktop.layout.GroupLayout(netConfigPanel);
        netConfigPanel.setLayout(netConfigPanelLayout);
        netConfigPanelLayout.setHorizontalGroup(
            netConfigPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, netConfigPanelLayout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .add(netConfigPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(netCfgSelectPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 297, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(netCfgInfoPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(100, 100, 100))
        );
        netConfigPanelLayout.setVerticalGroup(
            netConfigPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, netConfigPanelLayout.createSequentialGroup()
                .add(netCfgSelectPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(netCfgInfoPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 141, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(109, 109, 109))
        );

        configInfoTabbedPane.addTab("Network Config", netConfigPanel);

        inputPanel.add(configInfoTabbedPane, java.awt.BorderLayout.CENTER);

        getContentPane().add(inputPanel, java.awt.BorderLayout.CENTER);

        controlPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));

        saveButton.setFont(new java.awt.Font("Dialog", 0, 12));
        saveButton.setText("Save");
        saveButton.setName("SaveButton"); // NOI18N
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionHandler(evt);
            }
        });
        controlPanel.add(saveButton);

        cancelButton.setFont(new java.awt.Font("Dialog", 0, 12));
        cancelButton.setText("Cancel");
        cancelButton.setName("CancelButton"); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionHandler(evt);
            }
        });
        controlPanel.add(cancelButton);

        getContentPane().add(controlPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dstabNetRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dstabNetRadioButtonActionPerformed
		setNetAppType(IGNetForm.NetType_DStabilityNet, IGNetForm.AppType_Transmission);
		InitDataUtil.initScData_DStabNet((GNetForm)_netContainer.getGNetForm());
		pack();
    }//GEN-LAST:event_dstabNetRadioButtonActionPerformed

    private void transAppTypeActionHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transAppTypeActionHandler
		setNetAppType(IGNetForm.NetType_AcscNetwork, IGNetForm.AppType_Transmission);
		((GNetForm)_netContainer.getGNetForm()).setAppType(IGNetForm.AppType_Transmission);
		InitDataUtil.initScData_AcscNet((GNetForm)_netContainer.getGNetForm());
		setForm2Editor();
		pack();
    }//GEN-LAST:event_transAppTypeActionHandler

    private void distriAppTypeActionHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distriAppTypeActionHandler
		setNetAppType(IGNetForm.NetType_AcscNetwork, IGNetForm.AppType_Distribution);
		((GNetForm)_netContainer.getGNetForm()).setAppType(IGNetForm.AppType_Distribution);
		((GNetForm)_netContainer.getGNetForm()).setNetType(IGNetForm.NetType_AcscNetwork);
		InitDataUtil.initScData_DistNet((GNetForm)_netContainer.getGNetForm());
		setForm2Editor();
		pack();
    }//GEN-LAST:event_distriAppTypeActionHandler

    private void acscNetTypeActionHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acscNetTypeActionHandler
		if (this.transAppRadioButton.isSelected()) {
			setNetAppType(IGNetForm.NetType_AcscNetwork, IGNetForm.AppType_Transmission);
			pack();
		}
    }//GEN-LAST:event_acscNetTypeActionHandler

    private void aclfNetTypeActionHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aclfNetTypeActionHandler
		if (this.transAppRadioButton.isSelected()) {
			setNetAppType(IGNetForm.NetType_AclfNetwork, IGNetForm.AppType_Transmission);
			pack();
		}
    }//GEN-LAST:event_aclfNetTypeActionHandler

    private void cancelActionHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionHandler
		setReturnOk(false);
        setVisible(false);
    }//GEN-LAST:event_cancelActionHandler

    private void saveActionHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionHandler
		Vector errMsg = new Vector();
		try {
        	if (!saveEditor2Form(errMsg)) {
        		SpringAppContext.getEditorDialogUtil().showMsgDialog(this, "Network Input Data Error", errMsg);
				return;
        	}
        } catch (Exception e) {
      		IpssLogger.logErr(e);
      		SpringAppContext.getEditorDialogUtil().showMsgDialog(this, "Network Input Data Error", e.toString());
			return;
        }	
        _netContainer.getGNetForm().setNewState(false);
        msgHub.sendMsg(new DataChangeMessage(DataChangeMessage.DataChangeMsg, 
        				"Project Info Updated, projName:" + _projInfo.getProjectName()));
        _netContainer.setDataDirty(true);
        _projInfo.setDirty(true);
        
		setReturnOk(true);
        setVisible(false);
    }//GEN-LAST:event_saveActionHandler
    
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
		setReturnOk(false);
        setVisible(false);
    }//GEN-LAST:event_closeDialog

private void zoneNetConfigRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoneNetConfigRadioButtonActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_zoneNetConfigRadioButtonActionPerformed

private void netCfgEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_netCfgEditButtonActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_netCfgEditButtonActionPerformed

private void netCfgAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_netCfgAddButtonActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_netCfgAddButtonActionPerformed

private void netCfgUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_netCfgUpdateButtonActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_netCfgUpdateButtonActionPerformed

private void interfaceNetConfigRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interfaceNetConfigRadioButtonActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_interfaceNetConfigRadioButtonActionPerformed

private void areaNetConfigRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaNetConfigRadioButtonActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_areaNetConfigRadioButtonActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new NBProjectEditDialog(new javax.swing.JFrame(), true).show();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton aclfNetRadioButton;
    private javax.swing.JRadioButton acscNetRadioButton;
    private javax.swing.ButtonGroup appTypeButtonGroup;
    private javax.swing.JPanel appTypePanel;
    private javax.swing.JRadioButton areaNetConfigRadioButton;
    private javax.swing.JTextField baseFreqField;
    private javax.swing.JLabel baseFreqLabel;
    private javax.swing.JTextField baseKvaField;
    private javax.swing.JLabel baseKvaLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTabbedPane configInfoTabbedPane;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JLabel descLabel;
    private javax.swing.JTextArea descTextArea;
    private javax.swing.JRadioButton distriAppRadioButton;
    private javax.swing.JRadioButton dstabNetRadioButton;
    private javax.swing.JPanel editContainerPanel;
    private javax.swing.JPanel editPanel;
    private javax.swing.JLabel fUnitLabel;
    private javax.swing.JLabel filenameLabel;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JRadioButton interfaceNetConfigRadioButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel kvaPanel;
    private javax.swing.JLabel kvaUnitLabel;
    private javax.swing.JLabel leftEncloseLabel;
    private javax.swing.JButton netCfgAddButton;
    private javax.swing.ButtonGroup netCfgButtonGroup;
    private javax.swing.JLabel netCfgDescLabel;
    private javax.swing.JTextField netCfgDescTextField;
    private javax.swing.JButton netCfgEditButton;
    private javax.swing.JPanel netCfgEditPanel;
    private javax.swing.JPanel netCfgInfoPanel;
    private javax.swing.JList netCfgItemList;
    private javax.swing.JLabel netCfgNameLabel;
    private javax.swing.JTextField netCfgNameTextField;
    private javax.swing.JLabel netCfgNumberLabel;
    private javax.swing.JTextField netCfgNumberTextField;
    private javax.swing.JPanel netCfgSelectPanel;
    private javax.swing.JButton netCfgUpdateButton;
    private javax.swing.JPanel netConfigPanel;
    private javax.swing.ButtonGroup netTypeButtonGroup;
    private javax.swing.JPanel netTypePanel;
    private javax.swing.JLabel projFileLabel;
    private javax.swing.JLabel rightEncloseLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JPanel selectionPanel;
    private javax.swing.JRadioButton transAppRadioButton;
    private javax.swing.JPanel typeSelectPanel;
    private javax.swing.JRadioButton zoneNetConfigRadioButton;
    // End of variables declaration//GEN-END:variables

	class DataVerifier extends javax.swing.InputVerifier {
    	public boolean verify(javax.swing.JComponent input) {
			try {
				if (input == null)
					return false;
				if (input == baseKvaField ||
		   		   	input == baseFreqField)
		    		return SwingInputVerifyUtil.largeThan((javax.swing.JTextField)input, 0.0d);
 	       	} catch (Exception e) {
				return false;
 	       	}				
			return true;
        }
    }
}
