package org.interpss.editor.ui.edit.trans.branch;
  
/**
 *
 */
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;

import org.interpss.editor.data.aclf.AclfAdjBranchData;
import org.interpss.editor.data.acsc.AcscBranchData;
import org.interpss.editor.form.GBranchForm;
import org.interpss.editor.form.GBusForm;
import org.interpss.editor.form.GFormContainer;
import org.interpss.editor.form.GNetForm;
import org.interpss.editor.jgraph.ui.edit.IFormDataPanel;
import org.interpss.editor.jgraph.ui.form.IGBranchForm;

import com.interpss.common.ui.VerifyUtil;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.Num2Str;
 
 
public class NBBranchPositivePanel extends javax.swing.JPanel implements IFormDataPanel {
	private static final long serialVersionUID = 1;
	private JDialog parent = null;
	
    private GFormContainer _netContainer = null;
    private AcscBranchData  _data = null;
    private GBranchForm  _form = null;
    
	public void initPanel(JDialog aParent) {
		parent = aParent;
		
		DataVerifier verifier = new DataVerifier();
	    rTextField.setInputVerifier(verifier);
	    xTextField.setInputVerifier(verifier);
	    hBTextField.setInputVerifier(verifier);
	    toTapTextField.setInputVerifier(verifier);
	    fromTapTextField.setInputVerifier(verifier);

	    vSpecTextField.setInputVerifier(verifier);
	    controlTapMaxTextField.setInputVerifier(verifier);
	    controlTapMinTextField.setInputVerifier(verifier);
	    controlTapStepTextField.setInputVerifier(verifier);

	    pSpecTextField.setInputVerifier(verifier);
	    angleMaxTextField.setInputVerifier(verifier);
	    angleMinTextField.setInputVerifier(verifier);
	}
    
	public void init(Object netContainer, Object form) {
		IpssLogger.getLogger().info("NBBranchPositivePanel init() called");
		_netContainer = (GFormContainer)netContainer;
		_form = (GBranchForm)form;
		_data = _form.getAcscBranchData();
		
		if (_form.isNewState()) {
		     GBusForm fromBusForm = (GBusForm)((GFormContainer)netContainer).getGBusForm(_form.getFromId());
		     GBusForm toBusForm = (GBusForm)((GFormContainer)netContainer).getGBusForm(_form.getToId());
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
	         if (fromBaseV != toBaseV)
	             _data.setLfCode(IGBranchForm.TransBranchLfCode_Xfr);
		}
		   
		remove(tapVControlPanel);
        remove(psXfrPControlPanel);
	}
	
    public boolean setForm2Editor() {
		IpssLogger.getLogger().info("NBBranchPositivePanel setForm2Editor() called");

		if (_data.getLfCode().equals(IGBranchForm.TransBranchLfCode_Line))
			lineRadioButton.setSelected(true);
		else if (_data.getLfCode().equals(IGBranchForm.TransBranchLfCode_Xfr))
			xfrRadioButton.setSelected(true);
		else 
	   		psXfrRadioButton.setSelected(true);

		rTextField.setText(Num2Str.toStr(_data.getZR(), "#0.0####"));
	    xTextField.setText(Num2Str.toStr(_data.getZX(), "#0.0####"));
	    
    	if (_data.getLfCode().equals(IGBranchForm.TransBranchLfCode_Line)) {
    	    setBranchLabelText(true, false);
    	    hBTextField.setText(Num2Str.toStr(_data.getHalfShuntB(), "#0.0####"));

       	    remove(tapVControlPanel);
            remove(psXfrPControlPanel);
    	}
    	else if (_data.getLfCode().equals(IGBranchForm.TransBranchLfCode_Xfr)) {
    	    setBranchLabelText(false, false);
    	    fromTapTextField.setText(Num2Str.toStr(_data.getXfrTapFromSideTap(), "#0.0####"));
    	    toTapTextField.setText(Num2Str.toStr(_data.getXfrTapToSideTap(), "#0.0####"));
    	    
    		if (((GNetForm)_netContainer.getGNetForm()).getAcscNetData().isHasAdjustment()) {
        		remove(psXfrPControlPanel);
    			add(tapVControlPanel);
    	    	if (_data.isHasTapVControl()) {
					tapVControlCheckBox.setSelected(true);
					voltageRadioButton.setEnabled(true);
					mvaFlowRadioButton.setEnabled(true);
    			    setTapVControlPanel();
    	    	}
    			else { 
					tapVControlCheckBox.setSelected(false);
					voltageRadioButton.setEnabled(false);
					mvaFlowRadioButton.setEnabled(false);
    				tapVControlPanel.remove(tapVControlEditPanel);
    			}	
    	    }
    	}
    	else if (_data.getLfCode().equals(IGBranchForm.TransBranchLfCode_PsXfr)) {
    	    setBranchLabelText(false, true);
    	    hBTextField.setText(Num2Str.toStr(_data.getPhaseShiftAngle(), "#0.0####"));
    	    fromTapTextField.setText(Num2Str.toStr(_data.getXfrTapFromSideTap(), "#0.0####"));
    	    toTapTextField.setText(Num2Str.toStr(_data.getXfrTapToSideTap(), "#0.0####"));
    	    
    		if (((GNetForm)_netContainer.getGNetForm()).getAcscNetData().isHasAdjustment()) {
        		remove(tapVControlPanel);
    	        add(psXfrPControlPanel);
    	    	if (_data.isHasPSXfrPControl()) {
    	        	psXfrPowerCheckBox.setSelected(true);
    	            setPsXfrPControlPanel();
    	    	}
    	    	else {
    	        	psXfrPowerCheckBox.setSelected(false);
    		        psXfrPControlPanel.remove(psXfrPControlEditPanel);
    	    	}    		
    	    }
    	}
    	parent.pack();
    	
    	return true;
	}

    private void setTapVControlPanel() {
		java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
		tapVControlPanel.add(tapVControlEditPanel, gridBagConstraints);
		
	    controlTapMaxTextField.setText(Num2Str.toStr(_data.getVcTapMax(), "#0.0##"));
	    controlTapMinTextField.setText(Num2Str.toStr(_data.getVcTapMin(), "#0.0##"));
	    controlTapStepTextField.setText(Num2Str.toStr(_data.getVcStep(),  "#0.00#"));
	    if (_data.isVCTapOnFromSide())
    		controlTapOnFromSideRadioButton.setSelected(true);
    	else
    		controlTapOnToSideRadioButton.setSelected(true);    	
	    
	    if (_data.getTapVControlType() == AclfAdjBranchData.TapControlType_Voltage) {
	    	voltageRadioButton.setSelected(true);
	    	vSpecLabel.setText("          Vspec(pu)  ");
	        vcBusSidePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "VC Bus On", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10)));
		    vcBusFromSideRadioButton.setText("From Side   ");
		    vcBusToSideRadioButton.setText("To Side");
			vSpecTextField.setText(Num2Str.toStr(_data.getVcVSpec(), "#0.0####"));

	        vcBusLabel.setText("Target VC Bus  ");
	        vcBusComboBox.setModel(new DefaultComboBoxModel(_netContainer.getTargetVCBusNameIdArray()));
			if (_data.getVcBusId() != null && !_data.getVcBusId().equals("")) {
		    	vcBusComboBox.setSelectedItem(_data.getVcBusId());
		    }
			
		    if (_data.isVCBusOnFromSide()) 
		    	vcBusFromSideRadioButton.setSelected(true);
		    else
		    	vcBusToSideRadioButton.setSelected(true);
		}
	    else {
	    	mvaFlowRadioButton.setSelected(true);
	    	vSpecLabel.setText("          MvaSpec(pu)  ");
	        vcBusSidePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mva Flow Direction", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10)));
		    vcBusFromSideRadioButton.setText("From->To   ");
		    vcBusToSideRadioButton.setText("To->From");	    	
			vSpecTextField.setText(Num2Str.toStr(_data.getMvarFlowSpec(), "#0.0####"));

	        vcBusLabel.setText("Mvar Spec On  ");
	        vcBusComboBox.setModel(new DefaultComboBoxModel(new String[] {"From Side", "To Side"}));
	    	vcBusComboBox.setSelectedIndex(_data.isMvarSpecOnFromSide()?0:1);

			if (_data.isFlowFrom2To()) {
				vcBusFromSideRadioButton.setSelected(true);
		    }
		    else {
		    	vcBusToSideRadioButton.setSelected(true);
		    }	
	    }
    }
    
    private void setPsXfrPControlPanel() {
		java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        psXfrPControlPanel.add(psXfrPControlEditPanel, gridBagConstraints);
        
        pSpecTextField.setText(Num2Str.toStr(_data.getPcPSpec(), "#0.0####"));
        angleMaxTextField.setText(Num2Str.toStr(_data.getPcAngMax(), "#0.0#"));
        angleMinTextField.setText(Num2Str.toStr(_data.getPcAngMin(), "#0.0#"));
        if (_data.isPcOnFromSide())
        	pControlFromSideRadioButton.setSelected(true);
        else
        	pControlToSideRadioButton.setSelected(true);  
        if (_data.isFlowFrom2To())
        	from2ToRadioButton.setSelected(true);
        else
        	to2FromRadioButton.setSelected(true);  
    }
    
    private void setBranchLabelText(boolean isLine, boolean isPsXfr) {
        hBLabel.setEnabled(isLine || isPsXfr);
        hBTextField.setEnabled(isLine || isPsXfr);    
        if (!hBTextField.isEnabled())
            hBTextField.setText("0.0");    
        fromTapLabel.setEnabled(!isLine);
        fromTapTextField.setEnabled(!isLine);
        toTapLabel.setEnabled(!isLine);
        toTapTextField.setEnabled(!isLine);
        if (isLine) {
            fromTapTextField.setText("0.0");
            toTapTextField.setText("0.0");
        }
        if (isPsXfr) {
            hBLabel.setText("Shift Angle(deg)  ");
        }
        else {
            hBLabel.setText("1/2 B(pu)  ");
        }
    }
    
    public boolean saveEditor2Form(Vector errMsg) throws Exception {
		IpssLogger.getLogger().info("NBBranchPositivePanel saveEditor2Form() called");
		
    	if (lineRadioButton.isSelected())
    		_data.setLfCode(IGBranchForm.TransBranchLfCode_Line);
    	else if (xfrRadioButton.isSelected())
    		_data.setLfCode(IGBranchForm.TransBranchLfCode_Xfr);
    	else
    		_data.setLfCode(IGBranchForm.TransBranchLfCode_PsXfr);
    	
		boolean ok = true;
		
		_data.setZR(VerifyUtil.getDouble(rTextField));
	    
		_data.setZX(VerifyUtil.getDouble(xTextField));

	    if (_data.getLfCode().equals(IGBranchForm.TransBranchLfCode_Line)) {
	    	_data.setHalfShuntB(VerifyUtil.getDouble(hBTextField));
    	}
    	else  {
    		_data.setXfrTapFromSideTap(VerifyUtil.getDouble(fromTapTextField));
    		_data.setXfrTapToSideTap(VerifyUtil.getDouble(toTapTextField));
        	if (_data.getLfCode().equals(IGBranchForm.TransBranchLfCode_PsXfr)) {
        		_data.setPhaseShiftAngle(VerifyUtil.getDouble(hBTextField));
        		_data.setPhaseShiftAngleUnit("Deg");
        	}
        	
    		if (((GNetForm)_netContainer.getGNetForm()).getAcscNetData().isHasAdjustment()) {
	    		_data.setHasTapVControl(false);
	    		_data.setHasPSXfrPControl(false);
    	    	if (_data.getLfCode().equals(IGBranchForm.TransBranchLfCode_Xfr) && tapVControlCheckBox.isSelected()) {
    	    		_data.setHasTapVControl(true);
    	    		_data.setVcTapMax(VerifyUtil.getDouble(controlTapMaxTextField));
    	    		_data.setVcTapMin(VerifyUtil.getDouble(controlTapMinTextField));
    	    		_data.setVcStep(VerifyUtil.getDouble(controlTapStepTextField));
    			    _data.setVCTapOnFromSide(controlTapOnFromSideRadioButton.isSelected());

    			    if (voltageRadioButton.isSelected()) {
    			    	_data.setTapVControlType(AclfAdjBranchData.TapControlType_Voltage);
    			    	_data.setVcBusId((String)vcBusComboBox.getSelectedItem());
    			    	_data.setVcVSpec(VerifyUtil.getDouble(vSpecTextField));
    			    	_data.setVCBusOnFromSide(vcBusFromSideRadioButton.isSelected());
    			    }
    			    else {
    			    	_data.setTapVControlType(AclfAdjBranchData.TapControlType_MvarFlow);
    			    	_data.setMvarFlowSpec(VerifyUtil.getDouble(vSpecTextField));
    			    	_data.setFlowFrom2To(vcBusFromSideRadioButton.isSelected());
    			    	_data.setMvarSpecOnFromSide(vcBusComboBox.getSelectedIndex()==0);
    			    }
    	    	}
    	    	else if (_data.getLfCode().equals(IGBranchForm.TransBranchLfCode_PsXfr) && psXfrPowerCheckBox.isSelected()) {
    	    		_data.setHasPSXfrPControl(true);
    	    		_data.setPcPSpec(VerifyUtil.getDouble(pSpecTextField));
    	    		_data.setPcAngMax(VerifyUtil.getDouble(angleMaxTextField));
    	    		_data.setPcAngMin(VerifyUtil.getDouble(angleMinTextField));
    	            _data.setPcOnFromSide(pControlFromSideRadioButton.isSelected());
    	            _data.setFlowFrom2To(from2ToRadioButton.isSelected());
    	    	}
    	    }
        	
    	}
		return ok;
    }
    
    /** Creates new form AclfEditPanel */
    public NBBranchPositivePanel() {
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

        vcBusOnButtonGroup = new javax.swing.ButtonGroup();
        controlTapOnButtonGroup = new javax.swing.ButtonGroup();
        pControlSideButtonGroup = new javax.swing.ButtonGroup();
        branchTypeButtonGroup = new javax.swing.ButtonGroup();
        flowDirectionButtonGroup = new javax.swing.ButtonGroup();
        tapControlTypeButtonGroup = new javax.swing.ButtonGroup();
        branchDataPanel = new javax.swing.JPanel();
        branchTypePanel = new javax.swing.JPanel();
        lineRadioButton = new javax.swing.JRadioButton();
        xfrRadioButton = new javax.swing.JRadioButton();
        psXfrRadioButton = new javax.swing.JRadioButton();
        rLabel = new javax.swing.JLabel();
        rTextField = new javax.swing.JTextField();
        xLabel = new javax.swing.JLabel();
        xTextField = new javax.swing.JTextField();
        hBLabel = new javax.swing.JLabel();
        hBTextField = new javax.swing.JTextField();
        fromTapLabel = new javax.swing.JLabel();
        fromTapTextField = new javax.swing.JTextField();
        toTapLabel = new javax.swing.JLabel();
        toTapTextField = new javax.swing.JTextField();
        psXfrPControlPanel = new javax.swing.JPanel();
        psXfrPowerCheckBox = new javax.swing.JCheckBox();
        psXfrPControlEditPanel = new javax.swing.JPanel();
        pSepcLabel = new javax.swing.JLabel();
        pSpecTextField = new javax.swing.JTextField();
        pControlSidePanel = new javax.swing.JPanel();
        pControlFromSideRadioButton = new javax.swing.JRadioButton();
        pControlToSideRadioButton = new javax.swing.JRadioButton();
        angleMaxLabel = new javax.swing.JLabel();
        angleMaxTextField = new javax.swing.JTextField();
        angleMinLabel = new javax.swing.JLabel();
        angleMinTextField = new javax.swing.JTextField();
        flowDirectionPanel = new javax.swing.JPanel();
        from2ToRadioButton = new javax.swing.JRadioButton();
        to2FromRadioButton = new javax.swing.JRadioButton();
        tapVControlPanel = new javax.swing.JPanel();
        tapControlPanel = new javax.swing.JPanel();
        tapVControlCheckBox = new javax.swing.JCheckBox();
        leftLabel = new javax.swing.JLabel();
        voltageRadioButton = new javax.swing.JRadioButton();
        mvaFlowRadioButton = new javax.swing.JRadioButton();
        rightLabel = new javax.swing.JLabel();
        tapVControlEditPanel = new javax.swing.JPanel();
        vcBusLabel = new javax.swing.JLabel();
        vcBusComboBox = new javax.swing.JComboBox();
        vSpecLabel = new javax.swing.JLabel();
        vSpecTextField = new javax.swing.JTextField();
        vcBusSidePanel = new javax.swing.JPanel();
        vcBusFromSideRadioButton = new javax.swing.JRadioButton();
        vcBusToSideRadioButton = new javax.swing.JRadioButton();
        controlTapSidePanel = new javax.swing.JPanel();
        controlTapOnFromSideRadioButton = new javax.swing.JRadioButton();
        controlTapOnToSideRadioButton = new javax.swing.JRadioButton();
        controlTapLimitPanel = new javax.swing.JPanel();
        controlTapMaxLabel = new javax.swing.JLabel();
        controlTapMaxTextField = new javax.swing.JTextField();
        controlTapMinLabel = new javax.swing.JLabel();
        controlTapMinTextField = new javax.swing.JTextField();
        controlTapStepsLabel = new javax.swing.JLabel();
        controlTapStepTextField = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        branchDataPanel.setLayout(new java.awt.GridBagLayout());

        branchTypePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Branch Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10)));
        branchTypeButtonGroup.add(lineRadioButton);
        lineRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        lineRadioButton.setSelected(true);
        lineRadioButton.setText("Line     ");
        lineRadioButton.setName("lineRadioButton");
        lineRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineRadioButtonActionPerformed(evt);
            }
        });

        branchTypePanel.add(lineRadioButton);

        branchTypeButtonGroup.add(xfrRadioButton);
        xfrRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        xfrRadioButton.setText("XFormer");
        xfrRadioButton.setName("xfrRadioButton");
        xfrRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xfrRadioButtonActionPerformed(evt);
            }
        });

        branchTypePanel.add(xfrRadioButton);

        branchTypeButtonGroup.add(psXfrRadioButton);
        psXfrRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        psXfrRadioButton.setText("PhaseShift-Xfr");
        psXfrRadioButton.setName("psXfrRadioButton");
        psXfrRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psXfrRadioButtonActionPerformed(evt);
            }
        });

        branchTypePanel.add(psXfrRadioButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 30, 0);
        branchDataPanel.add(branchTypePanel, gridBagConstraints);

        rLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        rLabel.setText("R(pu)  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        branchDataPanel.add(rLabel, gridBagConstraints);

        rTextField.setColumns(8);
        rTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        rTextField.setText("0.0");
        rTextField.setName("rTextField");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        branchDataPanel.add(rTextField, gridBagConstraints);

        xLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        xLabel.setText("          X(pu)  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        branchDataPanel.add(xLabel, gridBagConstraints);

        xTextField.setColumns(8);
        xTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        xTextField.setText("0.0");
        xTextField.setName("xTextField");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        branchDataPanel.add(xTextField, gridBagConstraints);

        hBLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        hBLabel.setText("1/2 B(pu)  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        branchDataPanel.add(hBLabel, gridBagConstraints);

        hBTextField.setColumns(8);
        hBTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        hBTextField.setText("0.0");
        hBTextField.setName("hBTextField");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        branchDataPanel.add(hBTextField, gridBagConstraints);

        fromTapLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        fromTapLabel.setText("From TurnRatio(pu)  ");
        fromTapLabel.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 30, 0);
        branchDataPanel.add(fromTapLabel, gridBagConstraints);

        fromTapTextField.setColumns(8);
        fromTapTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        fromTapTextField.setText("0.0");
        fromTapTextField.setToolTipText("FromBus o----fromTap:1------z------1:toTap----o toBus");
        fromTapTextField.setEnabled(false);
        fromTapTextField.setName("fromTapTextField");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 30, 0);
        branchDataPanel.add(fromTapTextField, gridBagConstraints);

        toTapLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        toTapLabel.setText("          To TurnRatio(pu)  ");
        toTapLabel.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 30, 0);
        branchDataPanel.add(toTapLabel, gridBagConstraints);

        toTapTextField.setColumns(8);
        toTapTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        toTapTextField.setText("0.0");
        toTapTextField.setToolTipText("FromBus o----fromTap:1------z------1:toTap----o toBus");
        toTapTextField.setAutoscrolls(false);
        toTapTextField.setEnabled(false);
        toTapTextField.setName("toTapTextField");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 30, 0);
        branchDataPanel.add(toTapTextField, gridBagConstraints);

        add(branchDataPanel, java.awt.BorderLayout.NORTH);

        psXfrPControlPanel.setLayout(new java.awt.GridBagLayout());

        psXfrPowerCheckBox.setFont(new java.awt.Font("Dialog", 0, 12));
        psXfrPowerCheckBox.setText("PSXfr Power Control");
        psXfrPowerCheckBox.setName("psXfrPowerCheckBox");
        psXfrPowerCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psXfrPowerCheckBoxActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        psXfrPControlPanel.add(psXfrPowerCheckBox, gridBagConstraints);

        psXfrPControlEditPanel.setLayout(new java.awt.GridBagLayout());

        pSepcLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        pSepcLabel.setText("Pspec(pu)  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        psXfrPControlEditPanel.add(pSepcLabel, gridBagConstraints);

        pSpecTextField.setColumns(4);
        pSpecTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        pSpecTextField.setText("0.0");
        pSpecTextField.setName("pSpecTextField");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        psXfrPControlEditPanel.add(pSpecTextField, gridBagConstraints);

        pControlSidePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "P-Control On", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10)));
        pControlSideButtonGroup.add(pControlFromSideRadioButton);
        pControlFromSideRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        pControlFromSideRadioButton.setSelected(true);
        pControlFromSideRadioButton.setText("From Side   ");
        pControlFromSideRadioButton.setName("pControlFromSideRadioButton");
        pControlSidePanel.add(pControlFromSideRadioButton);

        pControlSideButtonGroup.add(pControlToSideRadioButton);
        pControlToSideRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        pControlToSideRadioButton.setText("To Side");
        pControlToSideRadioButton.setName("pControlToSideRadioButton");
        pControlSidePanel.add(pControlToSideRadioButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 0);
        psXfrPControlEditPanel.add(pControlSidePanel, gridBagConstraints);

        angleMaxLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        angleMaxLabel.setText("AngleMax(deg)  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        psXfrPControlEditPanel.add(angleMaxLabel, gridBagConstraints);

        angleMaxTextField.setColumns(4);
        angleMaxTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        angleMaxTextField.setText("15.0");
        angleMaxTextField.setName("angleMaxTextField");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        psXfrPControlEditPanel.add(angleMaxTextField, gridBagConstraints);

        angleMinLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        angleMinLabel.setText("AngleMin(deg)  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        psXfrPControlEditPanel.add(angleMinLabel, gridBagConstraints);

        angleMinTextField.setColumns(4);
        angleMinTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        angleMinTextField.setText("-15.0");
        angleMinTextField.setName("angleMinTextField");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        psXfrPControlEditPanel.add(angleMinTextField, gridBagConstraints);

        flowDirectionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "P-Flow Direction", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10)));
        flowDirectionButtonGroup.add(from2ToRadioButton);
        from2ToRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        from2ToRadioButton.setSelected(true);
        from2ToRadioButton.setText("From->To   ");
        from2ToRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        from2ToRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        flowDirectionPanel.add(from2ToRadioButton);

        flowDirectionButtonGroup.add(to2FromRadioButton);
        to2FromRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        to2FromRadioButton.setText("To->From   ");
        to2FromRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        to2FromRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        flowDirectionPanel.add(to2FromRadioButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 20, 0);
        psXfrPControlEditPanel.add(flowDirectionPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        psXfrPControlPanel.add(psXfrPControlEditPanel, gridBagConstraints);

        add(psXfrPControlPanel, java.awt.BorderLayout.CENTER);

        tapVControlPanel.setLayout(new java.awt.GridBagLayout());

        tapVControlCheckBox.setFont(new java.awt.Font("Dialog", 0, 12));
        tapVControlCheckBox.setText("Tap Voltage Control               ");
        tapVControlCheckBox.setName("tapVControlCheckBox");
        tapVControlCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tapVControlCheckBoxActionPerformed(evt);
            }
        });

        tapControlPanel.add(tapVControlCheckBox);

        leftLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        leftLabel.setText("[");
        tapControlPanel.add(leftLabel);

        tapControlTypeButtonGroup.add(voltageRadioButton);
        voltageRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        voltageRadioButton.setSelected(true);
        voltageRadioButton.setText("Voltage   ");
        voltageRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        voltageRadioButton.setEnabled(false);
        voltageRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        voltageRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltageButtonActionPerformed(evt);
            }
        });

        tapControlPanel.add(voltageRadioButton);

        tapControlTypeButtonGroup.add(mvaFlowRadioButton);
        mvaFlowRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        mvaFlowRadioButton.setText("Mvar Flow   ");
        mvaFlowRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        mvaFlowRadioButton.setEnabled(false);
        mvaFlowRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        mvaFlowRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mvaFlowButtonActionPerformed(evt);
            }
        });

        tapControlPanel.add(mvaFlowRadioButton);

        rightLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        rightLabel.setText("]");
        tapControlPanel.add(rightLabel);

        tapVControlPanel.add(tapControlPanel, new java.awt.GridBagConstraints());

        tapVControlEditPanel.setLayout(new java.awt.GridBagLayout());

        vcBusLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        vcBusLabel.setText("Target VC Bus  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        tapVControlEditPanel.add(vcBusLabel, gridBagConstraints);

        vcBusComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        vcBusComboBox.setName("vcBusComboBox");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        tapVControlEditPanel.add(vcBusComboBox, gridBagConstraints);

        vSpecLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        vSpecLabel.setText("          Vspec(pu)  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        tapVControlEditPanel.add(vSpecLabel, gridBagConstraints);

        vSpecTextField.setColumns(5);
        vSpecTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        vSpecTextField.setText("1.0");
        vSpecTextField.setName("vSpecTextField");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        tapVControlEditPanel.add(vSpecTextField, gridBagConstraints);

        vcBusSidePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "VC Bus On", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10)));
        vcBusOnButtonGroup.add(vcBusFromSideRadioButton);
        vcBusFromSideRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        vcBusFromSideRadioButton.setSelected(true);
        vcBusFromSideRadioButton.setText("From Side   ");
        vcBusFromSideRadioButton.setName("vcBusFromSideRadioButton");
        vcBusSidePanel.add(vcBusFromSideRadioButton);

        vcBusOnButtonGroup.add(vcBusToSideRadioButton);
        vcBusToSideRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        vcBusToSideRadioButton.setText("To Side");
        vcBusToSideRadioButton.setName("vcBusToSideRadioButton");
        vcBusSidePanel.add(vcBusToSideRadioButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        tapVControlEditPanel.add(vcBusSidePanel, gridBagConstraints);

        controlTapSidePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Control Tap On", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10)));
        controlTapOnButtonGroup.add(controlTapOnFromSideRadioButton);
        controlTapOnFromSideRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        controlTapOnFromSideRadioButton.setSelected(true);
        controlTapOnFromSideRadioButton.setText("From Side   ");
        controlTapOnFromSideRadioButton.setName("controlTapOnFromSideRadioButton");
        controlTapSidePanel.add(controlTapOnFromSideRadioButton);

        controlTapOnButtonGroup.add(controlTapOnToSideRadioButton);
        controlTapOnToSideRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        controlTapOnToSideRadioButton.setText("To Side");
        controlTapOnToSideRadioButton.setName("controlTapOnToSideRadioButton");
        controlTapSidePanel.add(controlTapOnToSideRadioButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 0);
        tapVControlEditPanel.add(controlTapSidePanel, gridBagConstraints);

        controlTapMaxLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        controlTapMaxLabel.setText("TapMax(pu)  ");
        controlTapLimitPanel.add(controlTapMaxLabel);

        controlTapMaxTextField.setColumns(4);
        controlTapMaxTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        controlTapMaxTextField.setText("0.1");
        controlTapMaxTextField.setName("controlTapMaxTextField");
        controlTapLimitPanel.add(controlTapMaxTextField);

        controlTapMinLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        controlTapMinLabel.setText("         TapMin(pu)  ");
        controlTapLimitPanel.add(controlTapMinLabel);

        controlTapMinTextField.setColumns(4);
        controlTapMinTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        controlTapMinTextField.setText("-0.1");
        controlTapMinTextField.setName("controlTapMinTextField");
        controlTapLimitPanel.add(controlTapMinTextField);

        controlTapStepsLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        controlTapStepsLabel.setText("          Step  ");
        controlTapLimitPanel.add(controlTapStepsLabel);

        controlTapStepTextField.setColumns(4);
        controlTapStepTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        controlTapStepTextField.setText("0.0");
        controlTapStepTextField.setName("controlTapStepTextField");
        controlTapLimitPanel.add(controlTapStepTextField);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        tapVControlEditPanel.add(controlTapLimitPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        tapVControlPanel.add(tapVControlEditPanel, gridBagConstraints);

        add(tapVControlPanel, java.awt.BorderLayout.SOUTH);

    }// </editor-fold>//GEN-END:initComponents

    private void mvaFlowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvaFlowButtonActionPerformed
        vcBusLabel.setText("Mvar Spec On  ");
        vcBusComboBox.setModel(new DefaultComboBoxModel(new String[] {"From Side", "To Side"}));
    	vSpecLabel.setText("          MvaSpec(pu)  ");
        vcBusSidePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mva Flow Direction", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10)));
	    vcBusFromSideRadioButton.setText("From->To   ");
	    vcBusToSideRadioButton.setText("To->From");
    }//GEN-LAST:event_mvaFlowButtonActionPerformed

    private void voltageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltageButtonActionPerformed
        vcBusLabel.setText("Target VC Bus  ");
        vcBusComboBox.setModel(new DefaultComboBoxModel(_netContainer.getTargetVCBusNameIdArray()));
    	vSpecLabel.setText("          Vspec(pu)  ");
        vcBusSidePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "VC Bus On", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10)));
	    vcBusFromSideRadioButton.setText("From Side   ");
	    vcBusToSideRadioButton.setText("To Side");
    }//GEN-LAST:event_voltageButtonActionPerformed

    private void psXfrRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psXfrRadioButtonActionPerformed
    	_data.setLfCode(IGBranchForm.TransBranchLfCode_PsXfr);
    	setForm2Editor();
    }//GEN-LAST:event_psXfrRadioButtonActionPerformed

    private void lineRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineRadioButtonActionPerformed
    	_data.setLfCode(IGBranchForm.TransBranchLfCode_Line);
    	setForm2Editor();
    }//GEN-LAST:event_lineRadioButtonActionPerformed

    private void xfrRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
    	_data.setLfCode(IGBranchForm.TransBranchLfCode_Xfr);
    	setForm2Editor();
    }                                              

    private void tapVControlCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tapVControlCheckBoxActionPerformed
    	if (tapVControlCheckBox.isSelected()) {
    		voltageRadioButton.setEnabled(true);
    		mvaFlowRadioButton.setEnabled(true);
            setTapVControlPanel();
    	}
		else { 
			voltageRadioButton.setEnabled(false);
			mvaFlowRadioButton.setEnabled(false);
			tapVControlPanel.remove(tapVControlEditPanel);
		}	
    	parent.pack();
    }//GEN-LAST:event_tapVControlCheckBoxActionPerformed

    private void psXfrPowerCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psXfrPowerCheckBoxActionPerformed
    	if (psXfrPowerCheckBox.isSelected()) {
            setPsXfrPControlPanel();
    	}
    	else {
	        psXfrPControlPanel.remove(psXfrPControlEditPanel);
    	}
    	parent.pack();
    }//GEN-LAST:event_psXfrPowerCheckBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel angleMaxLabel;
    private javax.swing.JTextField angleMaxTextField;
    private javax.swing.JLabel angleMinLabel;
    private javax.swing.JTextField angleMinTextField;
    private javax.swing.JPanel branchDataPanel;
    private javax.swing.ButtonGroup branchTypeButtonGroup;
    private javax.swing.JPanel branchTypePanel;
    private javax.swing.JPanel controlTapLimitPanel;
    private javax.swing.JLabel controlTapMaxLabel;
    private javax.swing.JTextField controlTapMaxTextField;
    private javax.swing.JLabel controlTapMinLabel;
    private javax.swing.JTextField controlTapMinTextField;
    private javax.swing.ButtonGroup controlTapOnButtonGroup;
    private javax.swing.JRadioButton controlTapOnFromSideRadioButton;
    private javax.swing.JRadioButton controlTapOnToSideRadioButton;
    private javax.swing.JPanel controlTapSidePanel;
    private javax.swing.JTextField controlTapStepTextField;
    private javax.swing.JLabel controlTapStepsLabel;
    private javax.swing.ButtonGroup flowDirectionButtonGroup;
    private javax.swing.JPanel flowDirectionPanel;
    private javax.swing.JRadioButton from2ToRadioButton;
    private javax.swing.JLabel fromTapLabel;
    private javax.swing.JTextField fromTapTextField;
    private javax.swing.JLabel hBLabel;
    private javax.swing.JTextField hBTextField;
    private javax.swing.JLabel leftLabel;
    private javax.swing.JRadioButton lineRadioButton;
    private javax.swing.JRadioButton mvaFlowRadioButton;
    private javax.swing.JRadioButton pControlFromSideRadioButton;
    private javax.swing.ButtonGroup pControlSideButtonGroup;
    private javax.swing.JPanel pControlSidePanel;
    private javax.swing.JRadioButton pControlToSideRadioButton;
    private javax.swing.JLabel pSepcLabel;
    private javax.swing.JTextField pSpecTextField;
    private javax.swing.JPanel psXfrPControlEditPanel;
    private javax.swing.JPanel psXfrPControlPanel;
    private javax.swing.JCheckBox psXfrPowerCheckBox;
    private javax.swing.JRadioButton psXfrRadioButton;
    private javax.swing.JLabel rLabel;
    private javax.swing.JTextField rTextField;
    private javax.swing.JLabel rightLabel;
    private javax.swing.JPanel tapControlPanel;
    private javax.swing.ButtonGroup tapControlTypeButtonGroup;
    private javax.swing.JCheckBox tapVControlCheckBox;
    private javax.swing.JPanel tapVControlEditPanel;
    private javax.swing.JPanel tapVControlPanel;
    private javax.swing.JRadioButton to2FromRadioButton;
    private javax.swing.JLabel toTapLabel;
    private javax.swing.JTextField toTapTextField;
    private javax.swing.JLabel vSpecLabel;
    private javax.swing.JTextField vSpecTextField;
    private javax.swing.JComboBox vcBusComboBox;
    private javax.swing.JRadioButton vcBusFromSideRadioButton;
    private javax.swing.JLabel vcBusLabel;
    private javax.swing.ButtonGroup vcBusOnButtonGroup;
    private javax.swing.JPanel vcBusSidePanel;
    private javax.swing.JRadioButton vcBusToSideRadioButton;
    private javax.swing.JRadioButton voltageRadioButton;
    private javax.swing.JLabel xLabel;
    private javax.swing.JTextField xTextField;
    private javax.swing.JRadioButton xfrRadioButton;
    // End of variables declaration//GEN-END:variables

    
	class DataVerifier extends javax.swing.InputVerifier {
    	public boolean verify(javax.swing.JComponent input) {
			if (input == null)
				return false;
       		try {
       			/*
	    rTextField.setInputVerifier(verifier);
	    xTextField.setInputVerifier(verifier);
	    hBTextField.setInputVerifier(verifier);
	    toTapTextField.setInputVerifier(verifier);
	    fromTapTextField.setInputVerifier(verifier);

	    vSpecTextField.setInputVerifier(verifier);
	    controlTapMaxTextField.setInputVerifier(verifier);
	    controlTapMinTextField.setInputVerifier(verifier);
	    controlTapStepTextField.setInputVerifier(verifier);

	    pSpecTextField.setInputVerifier(verifier);
	    angleMaxTextField.setInputVerifier(verifier);
	    angleMinTextField.setInputVerifier(verifier);
       			 */
               if ( input == toTapTextField ||
          		         input == fromTapTextField )
 	       			return VerifyUtil.getDouble((javax.swing.JTextField)input) >= 0.0;
 	       	} catch (Exception e) {
 	    		return false;
 	       	}		
			return true;
        }
    }
}
