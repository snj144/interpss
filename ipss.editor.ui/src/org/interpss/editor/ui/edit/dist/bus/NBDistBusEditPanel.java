package org.interpss.editor.ui.edit.dist.bus;
  
/**
 *
 */
import java.util.Vector;

import javax.swing.JDialog;

import org.interpss.editor.data.dist.DistBusData;
import org.interpss.editor.data.dist.DistNetData;
import org.interpss.editor.form.GBusForm;
import org.interpss.editor.form.GFormContainer;
import org.interpss.editor.form.GNetForm;
import org.interpss.editor.ui.edit.common.NBGroundInputPanel;

import com.interpss.common.util.IpssLogger;
import com.interpss.editor.jgraph.ui.edit.IFormDataPanel;
 
 
public class NBDistBusEditPanel extends javax.swing.JPanel implements IFormDataPanel {
	private static final long serialVersionUID = 1;
	private JDialog _parent = null;
	
    private GBusForm _form = null;
    private DistBusData _dataDist = null;

    private NBUtilityInputPanel _utilityPanel = new NBUtilityInputPanel();
    private NBGroundInputPanel _groundPanel = new NBGroundInputPanel();
    private NBGenInputPanel _genPanel = new NBGenInputPanel();
    private NBMotorInputPanel _motorPanel = new NBMotorInputPanel();
    private NBMixedLoadInputPanel _mixedLoadPanel = new NBMixedLoadInputPanel();
    private NBZInputPanel _zPanel = new NBZInputPanel();
    private NBNonContributePanel _nonContributePanel = new NBNonContributePanel();
    
    
    public void initPanel(JDialog parent) {
    	this._parent = parent;
		_utilityPanel.initPanel();
    	_genPanel.initPanel();
    	_motorPanel.initPanel();
    	_mixedLoadPanel.initPanel();
//  		_zPanel.setScPointTableModelListener();
    	_groundPanel.initPanel();
    }
    
	public void init(Object netContainer, Object form) {
		IpssLogger.getLogger().info("NBDistBusEditPanel init() called");

		_form = (GBusForm)form;
    	_dataDist = _form.getDistBusData();

		_utilityPanel.init(netContainer, form);
    	_genPanel.init(netContainer, form);
    	_motorPanel.init(netContainer, form);
    	_mixedLoadPanel.init(netContainer, form);
      
    	int rows = 7;
    	if (((GNetForm)((GFormContainer)netContainer).getGNetForm()).getDistNetData().getScStd().equals(DistNetData.ScStd_ANSI))
    		rows = 5;
    	else if (((GNetForm)((GFormContainer)netContainer).getGNetForm()).getDistNetData().getScStd().equals(DistNetData.ScStd_Generic))
    		rows = 3;
    	_zPanel = new NBZInputPanel(rows);

    	_zPanel.init(netContainer, form);
    	_groundPanel.init(netContainer, _form.getDistBusData().getGround());
	}
	
    public boolean setForm2Editor() {
		IpssLogger.getLogger().info("NBDistBusEditPanel setForm2Editor() called");

		this.editPanel.removeAll();
		if (_dataDist.getBusCode().equals(DistBusData.BusCode_Utility)) {
    		this.utilityRadioButton.setSelected(true);
        	this.editPanel.add(_utilityPanel, java.awt.BorderLayout.NORTH);
        	this.editPanel.add(_groundPanel, java.awt.BorderLayout.SOUTH);
        	_utilityPanel.setForm2Editor();
        	_groundPanel.setForm2Editor();
		}    
		else if (_dataDist.getBusCode().equals(DistBusData.BusCode_Generator)) {
    		this.generatorRadioButton.setSelected(true);
        	this.editPanel.add(_genPanel, java.awt.BorderLayout.NORTH);
        	this.editPanel.add(_zPanel, java.awt.BorderLayout.CENTER);
        	this.editPanel.add(_groundPanel, java.awt.BorderLayout.SOUTH);
        	_genPanel.setForm2Editor();
        	_zPanel.setForm2Editor();
        	_groundPanel.setForm2Editor();
		}    
		else if (_dataDist.getBusCode().equals(DistBusData.BusCode_SynMotor) ||
                 _dataDist.getBusCode().equals(DistBusData.BusCode_IndMotor)) {
			if (_dataDist.getBusCode().equals(DistBusData.BusCode_SynMotor))
	    		this.synMotorRadioButton.setSelected(true);
			else
				this.indMotorRadioButton.setSelected(true);
        	this.editPanel.add(_motorPanel, java.awt.BorderLayout.NORTH);
        	this.editPanel.add(_zPanel, java.awt.BorderLayout.CENTER);
        	this.editPanel.add(_groundPanel, java.awt.BorderLayout.SOUTH);
        	_motorPanel.setForm2Editor();
        	_zPanel.setForm2Editor();
        	_groundPanel.setForm2Editor();
		}    
		else if (_dataDist.getBusCode().equals(DistBusData.BusCode_MixedLoad)) {
    		this.mixedLoadRadioButton.setSelected(true);
        	this.editPanel.add(_mixedLoadPanel, java.awt.BorderLayout.NORTH);
        	this.editPanel.add(_zPanel, java.awt.BorderLayout.CENTER);
        	this.editPanel.add(_groundPanel, java.awt.BorderLayout.SOUTH);
        	_mixedLoadPanel.setForm2Editor();
        	_zPanel.setForm2Editor();
        	_groundPanel.setForm2Editor();
		}    
		else if (_dataDist.getBusCode().equals(DistBusData.BusCode_NonContribute)) {
    		this.nonContributeRadioButton.setSelected(true);
        	this.editPanel.add(_nonContributePanel, java.awt.BorderLayout.CENTER);
		}
		_parent.pack();
    	return true;
	}
    
    public boolean saveEditor2Form(Vector errMsg) throws Exception {
    	IpssLogger.getLogger().info("NBDistBusEditPanel saveEditor2Form() called");

    	boolean ok = true;
		if (this.utilityRadioButton.isSelected()) {
			_dataDist.setBusCode(DistBusData.BusCode_Utility);
			if (!((IFormDataPanel)_utilityPanel).saveEditor2Form(errMsg))
				ok = false;
			if (!((IFormDataPanel)_groundPanel).saveEditor2Form(errMsg))
				ok = false;
		}	
		else if (this.generatorRadioButton.isSelected()) {
			_dataDist.setBusCode(DistBusData.BusCode_Generator);
			if (!((IFormDataPanel)_genPanel).saveEditor2Form(errMsg))
				ok = false;
			if (!((IFormDataPanel)_zPanel).saveEditor2Form(errMsg))
				ok = false;
			if (!((IFormDataPanel)_groundPanel).saveEditor2Form(errMsg))
				ok = false;
		}	
		else if (this.synMotorRadioButton.isSelected()) {
			_dataDist.setBusCode(DistBusData.BusCode_SynMotor);
			if (!((IFormDataPanel)_motorPanel).saveEditor2Form(errMsg))
				ok = false;
			if (!((IFormDataPanel)_zPanel).saveEditor2Form(errMsg))
				ok = false;
			if (!((IFormDataPanel)_groundPanel).saveEditor2Form(errMsg))
				ok = false;
		}	
		else if (this.indMotorRadioButton.isSelected()) {
			_dataDist.setBusCode(DistBusData.BusCode_IndMotor);
			if (!((IFormDataPanel)_motorPanel).saveEditor2Form(errMsg))
				ok = false;
			if (!((IFormDataPanel)_zPanel).saveEditor2Form(errMsg))
				ok = false;
			if (!((IFormDataPanel)_groundPanel).saveEditor2Form(errMsg))
				ok = false;
		}	
		else if (this.mixedLoadRadioButton.isSelected()) {
			_dataDist.setBusCode(DistBusData.BusCode_MixedLoad);
			if (!((IFormDataPanel)_mixedLoadPanel).saveEditor2Form(errMsg))
				ok = false;
			if (!((IFormDataPanel)_zPanel).saveEditor2Form(errMsg))
				ok = false;
			if (!((IFormDataPanel)_groundPanel).saveEditor2Form(errMsg))
				ok = false;
		}	
		else {
			_dataDist.setBusCode(DistBusData.BusCode_NonContribute);
		}
		
		return ok;
    }
    
    /** Creates new form AclfEditPanel */
    public NBDistBusEditPanel() {
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

        busTypeButtonGroup = new javax.swing.ButtonGroup();
        busTypeSelectPanel = new javax.swing.JPanel();
        utilityRadioButton = new javax.swing.JRadioButton();
        generatorRadioButton = new javax.swing.JRadioButton();
        synMotorRadioButton = new javax.swing.JRadioButton();
        indMotorRadioButton = new javax.swing.JRadioButton();
        mixedLoadRadioButton = new javax.swing.JRadioButton();
        nonContributeRadioButton = new javax.swing.JRadioButton();
        editPanel = new javax.swing.JPanel();

        setLayout(new java.awt.GridBagLayout());

        busTypeSelectPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bus Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10)));
        busTypeButtonGroup.add(utilityRadioButton);
        utilityRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        utilityRadioButton.setText("Utility");
        utilityRadioButton.setName("utilityRadioButton");
        utilityRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utilityButtonClicked(evt);
            }
        });

        busTypeSelectPanel.add(utilityRadioButton);

        busTypeButtonGroup.add(generatorRadioButton);
        generatorRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        generatorRadioButton.setText("Generator");
        generatorRadioButton.setName("generatorRadioButton");
        generatorRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generatorButtonClicked(evt);
            }
        });

        busTypeSelectPanel.add(generatorRadioButton);

        busTypeButtonGroup.add(synMotorRadioButton);
        synMotorRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        synMotorRadioButton.setText("SynMotor");
        synMotorRadioButton.setName("synMotorRadioButton");
        synMotorRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                synMotorButtonClicked(evt);
            }
        });

        busTypeSelectPanel.add(synMotorRadioButton);

        busTypeButtonGroup.add(indMotorRadioButton);
        indMotorRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        indMotorRadioButton.setText("IndMotor");
        indMotorRadioButton.setName("indMotorRadioButton");
        indMotorRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indMotorButtonClicked(evt);
            }
        });

        busTypeSelectPanel.add(indMotorRadioButton);

        busTypeButtonGroup.add(mixedLoadRadioButton);
        mixedLoadRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        mixedLoadRadioButton.setText("MixedLoad");
        mixedLoadRadioButton.setName("mixedLoadRadioButton");
        mixedLoadRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mixedLoadButtonClicked(evt);
            }
        });

        busTypeSelectPanel.add(mixedLoadRadioButton);

        busTypeButtonGroup.add(nonContributeRadioButton);
        nonContributeRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        nonContributeRadioButton.setSelected(true);
        nonContributeRadioButton.setText("NonContribute");
        nonContributeRadioButton.setName("nonContributeRadioButton");
        nonContributeRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nonContributeButtonClicked(evt);
            }
        });

        busTypeSelectPanel.add(nonContributeRadioButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(busTypeSelectPanel, gridBagConstraints);

        editPanel.setLayout(new java.awt.BorderLayout(0, 10));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 20, 0);
        add(editPanel, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void utilityButtonClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_utilityButtonClicked
		_dataDist.setBusCode(DistBusData.BusCode_Utility);
	    setForm2Editor();
    }//GEN-LAST:event_utilityButtonClicked

    private void generatorButtonClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generatorButtonClicked
		_dataDist.setBusCode(DistBusData.BusCode_Generator);
	    setForm2Editor();
    }//GEN-LAST:event_generatorButtonClicked

    private void synMotorButtonClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_synMotorButtonClicked
		_dataDist.setBusCode(DistBusData.BusCode_SynMotor);
	    setForm2Editor();
    }//GEN-LAST:event_synMotorButtonClicked

    private void indMotorButtonClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indMotorButtonClicked
		_dataDist.setBusCode(DistBusData.BusCode_IndMotor);
	    setForm2Editor();
    }//GEN-LAST:event_indMotorButtonClicked

    private void mixedLoadButtonClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mixedLoadButtonClicked
		_dataDist.setBusCode(DistBusData.BusCode_MixedLoad);
	    setForm2Editor();
	}//GEN-LAST:event_mixedLoadButtonClicked

    private void nonContributeButtonClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nonContributeButtonClicked
		_dataDist.setBusCode(DistBusData.BusCode_NonContribute);
	    setForm2Editor();
    }//GEN-LAST:event_nonContributeButtonClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup busTypeButtonGroup;
    private javax.swing.JPanel busTypeSelectPanel;
    private javax.swing.JPanel editPanel;
    private javax.swing.JRadioButton generatorRadioButton;
    private javax.swing.JRadioButton indMotorRadioButton;
    private javax.swing.JRadioButton mixedLoadRadioButton;
    private javax.swing.JRadioButton nonContributeRadioButton;
    private javax.swing.JRadioButton synMotorRadioButton;
    private javax.swing.JRadioButton utilityRadioButton;
    // End of variables declaration//GEN-END:variables
    
}
