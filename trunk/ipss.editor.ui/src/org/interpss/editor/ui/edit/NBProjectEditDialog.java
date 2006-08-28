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
import com.interpss.common.ui.VerifyUtil;
import com.interpss.common.ui.WinUtilities;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.Num2Str;
  
 
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

		this.baseKvaField.setText(Num2Str.toStr(form.getBaseKVA(), "#.0"));
    	this.baseFreqField.setText(Num2Str.toStr(form.getFreqHZ(), "#.0"));
    	
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

		if (!VerifyUtil.largeThan(this.baseKvaField, 0.0d)) {
			errMsg.add("Base KVA <= 0.0");
			ok = false;
		}
    	form.setBaseKVA(VerifyUtil.getDouble(this.baseKvaField));

		if (!VerifyUtil.largeThan(this.baseFreqField, 0.0d)) {
			errMsg.add("Base Freq <= 0.0");
			ok = false;
		}
    	form.setFreqHZ(VerifyUtil.getDouble(this.baseFreqField));
    	
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
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        appTypeButtonGroup = new javax.swing.ButtonGroup();
        netTypeButtonGroup = new javax.swing.ButtonGroup();
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
        editContainerPanel = new javax.swing.JPanel();
        editPanel = new javax.swing.JPanel();
        westEmptyPanel = new javax.swing.JPanel();
        eastEmptyPanel = new javax.swing.JPanel();
        northEmptyPanel = new javax.swing.JPanel();
        southEmptyPanel = new javax.swing.JPanel();
        controlPanel = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.BorderLayout(10, 10));

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        inputPanel.setLayout(new java.awt.BorderLayout(5, 5));

        inputPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 1, 20));
        selectionPanel.setLayout(new java.awt.GridBagLayout());

        projFileLabel.setFont(new java.awt.Font("Dialog", 0, 12));
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

        descTextArea.setColumns(30);
        descTextArea.setLineWrap(true);
        descTextArea.setRows(3);
        descTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        descTextArea.setName("descTextArea");
        jScrollPane1.setViewportView(descTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        selectionPanel.add(jScrollPane1, gridBagConstraints);

        baseKvaLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        baseKvaLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        baseKvaLabel.setText("BaseKVA   ");
        kvaPanel.add(baseKvaLabel);

        baseKvaField.setColumns(8);
        baseKvaField.setText("100000.0");
        baseKvaField.setName("baseKvaTextField");
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
        baseFreqField.setName("baseFreqTextField");
        kvaPanel.add(baseFreqField);

        fUnitLabel.setFont(new java.awt.Font("Dialog", 0, 10));
        fUnitLabel.setText("(hz)");
        kvaPanel.add(fUnitLabel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        selectionPanel.add(kvaPanel, gridBagConstraints);

        typeSelectPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        appTypePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        appTypePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Application Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10)));
        appTypeButtonGroup.add(transAppRadioButton);
        transAppRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        transAppRadioButton.setSelected(true);
        transAppRadioButton.setText("Transmission");
        transAppRadioButton.setName("transAppRadioButton");
        transAppRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transAppTypeActionHandler(evt);
            }
        });

        appTypePanel.add(transAppRadioButton);

        appTypeButtonGroup.add(distriAppRadioButton);
        distriAppRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        distriAppRadioButton.setText("Distribution");
        distriAppRadioButton.setName("distriAppRadioButton");
        distriAppRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distriAppTypeActionHandler(evt);
            }
        });

        appTypePanel.add(distriAppRadioButton);

        typeSelectPanel.add(appTypePanel);

        netTypePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        netTypePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Network Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10)));
        netTypeButtonGroup.add(aclfNetRadioButton);
        aclfNetRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        aclfNetRadioButton.setSelected(true);
        aclfNetRadioButton.setText("ACLF");
        aclfNetRadioButton.setName("aclfNetRadioButton");
        aclfNetRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aclfNetTypeActionHandler(evt);
            }
        });

        netTypePanel.add(aclfNetRadioButton);

        netTypeButtonGroup.add(acscNetRadioButton);
        acscNetRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        acscNetRadioButton.setText("ACSC");
        acscNetRadioButton.setName("acscNetRadioButton");
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
        dstabNetRadioButton.setName("dstabNetRadioButton");
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
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        selectionPanel.add(typeSelectPanel, gridBagConstraints);

        inputPanel.add(selectionPanel, java.awt.BorderLayout.NORTH);

        editContainerPanel.setLayout(new java.awt.BorderLayout(5, 5));

        editContainerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        editPanel.setLayout(new java.awt.BorderLayout());

        editContainerPanel.add(editPanel, java.awt.BorderLayout.CENTER);

        editContainerPanel.add(westEmptyPanel, java.awt.BorderLayout.WEST);

        editContainerPanel.add(eastEmptyPanel, java.awt.BorderLayout.EAST);

        editContainerPanel.add(northEmptyPanel, java.awt.BorderLayout.NORTH);

        editContainerPanel.add(southEmptyPanel, java.awt.BorderLayout.SOUTH);

        inputPanel.add(editContainerPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(inputPanel, java.awt.BorderLayout.CENTER);

        controlPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        saveButton.setFont(new java.awt.Font("Dialog", 0, 12));
        saveButton.setText("Save");
        saveButton.setName("SaveButton");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionHandler(evt);
            }
        });

        controlPanel.add(saveButton);

        cancelButton.setFont(new java.awt.Font("Dialog", 0, 12));
        cancelButton.setText("Cancel");
        cancelButton.setName("CancelButton");
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
        		SpringAppContext.getEditorDialogUtil().showMsgDialog("Network Input Data Error", errMsg);
				return;
        	}
        } catch (Exception e) {
      		IpssLogger.logErr(e);
      		SpringAppContext.getEditorDialogUtil().showMsgDialog("Network Input Data Error", e.toString());
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
    private javax.swing.JTextField baseFreqField;
    private javax.swing.JLabel baseFreqLabel;
    private javax.swing.JTextField baseKvaField;
    private javax.swing.JLabel baseKvaLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JLabel descLabel;
    private javax.swing.JTextArea descTextArea;
    private javax.swing.JRadioButton distriAppRadioButton;
    private javax.swing.JRadioButton dstabNetRadioButton;
    private javax.swing.JPanel eastEmptyPanel;
    private javax.swing.JPanel editContainerPanel;
    private javax.swing.JPanel editPanel;
    private javax.swing.JLabel fUnitLabel;
    private javax.swing.JLabel filenameLabel;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel kvaPanel;
    private javax.swing.JLabel kvaUnitLabel;
    private javax.swing.ButtonGroup netTypeButtonGroup;
    private javax.swing.JPanel netTypePanel;
    private javax.swing.JPanel northEmptyPanel;
    private javax.swing.JLabel projFileLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JPanel selectionPanel;
    private javax.swing.JPanel southEmptyPanel;
    private javax.swing.JRadioButton transAppRadioButton;
    private javax.swing.JPanel typeSelectPanel;
    private javax.swing.JPanel westEmptyPanel;
    // End of variables declaration//GEN-END:variables

	class DataVerifier extends javax.swing.InputVerifier {
    	public boolean verify(javax.swing.JComponent input) {
			try {
				if (input == null)
					return false;
				if (input == baseKvaField ||
		   		   	input == baseFreqField)
		    		return VerifyUtil.largeThan((javax.swing.JTextField)input, 0.0d);
 	       	} catch (Exception e) {
				return false;
 	       	}				
			return true;
        }
    }
}
