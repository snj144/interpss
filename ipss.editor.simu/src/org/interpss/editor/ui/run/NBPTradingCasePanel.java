 /*
  * @(#)NBPTradingCasePanel.java   
  *
  * Copyright (C) 2006-2011 www.interpss.org
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

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JFileChooser;

import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.ieee.odm.schema.PTradingAnalysisXmlType;
import org.ieee.odm.schema.PtAclfAnalysisXmlType;
import org.ieee.odm.schema.PtAclfOutputXmlType;
import org.ieee.odm.schema.PtCaseDataXmlType;
import org.interpss.editor.jgraph.GraphSpringFactory;
import org.interpss.editor.jgraph.ui.app.IAppStatus;
import org.interpss.editor.jgraph.ui.edit.IFormDataPanel;
import org.interpss.editor.ui.util.IpssFileFilter;
import org.interpss.numeric.util.Number2String;
import org.interpss.spring.BasePluginSpringFactory;
import org.interpss.spring.UISpringFactory;
import org.interpss.ui.SwingInputVerifyUtil;

import com.interpss.CoreObjectFactory;
import com.interpss.algo.aclf.AclfDslODMRunner;
import com.interpss.common.datatype.Constants;
import com.interpss.common.exp.InterpssException;
import com.interpss.common.exp.InterpssRuntimeException;
import com.interpss.common.msg.IpssMessage;
import com.interpss.common.msg.IpssMsgListener;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.StringUtil;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.net.Bus;
import com.interpss.core.net.Zone;
import com.interpss.core.util.CoreUtilFunc;
import com.interpss.datatype.DblBusValue;
import com.interpss.pssl.simu.impl.PTradingOutput;
import com.interpss.simu.SimuContext;

public class NBPTradingCasePanel extends javax.swing.JPanel implements IFormDataPanel, IpssMsgListener {
	private static final long serialVersionUID = 1;
	private JDialog parent;
	
    // private GFormContainer _netContainer = null;
    private SimuContext _simuCtx = null;
    private PTradingAnalysisXmlType _ptXml = null;
    
    private List<DblBusValue> genPVSwingBusVoltCacheList = null;

    /** Creates new form NBAclfCasePanel */
    public NBPTradingCasePanel(JDialog parent) {
    	initComponents();
    	this.parent = parent;
    	
    	initInputVerifier(new DataVerifier());
    }
    
    /**
     * Implementation of the onMsgEvent method.
  	* 
  	* @param msg the msg object
     */
     public void onMsgEvent(IpssMessage msg) {
    	 // do nothing
     }

     public boolean onMsgEventStatus(IpssMessage msg) {
  	   throw new InterpssRuntimeException("Method not implemented");
     }
     
    public void init(Object netContainer, Object simuCtx) {
    	// for non-graphic file, netContainer == null
		IpssLogger.getLogger().info("NBPTradingCasePanel init() called");
	    //_netContainer = (GFormContainer)netContainer;
	    _simuCtx = (SimuContext)simuCtx;
	    
	    // populate the Swing alloc zone
	    AclfNetwork net = _simuCtx.getAclfNet();
	    try {
	    	AclfBus swingBus = net.getAclfBus(CoreObjectFactory
	    			.createAclfNetHelper(net)
	    			.getSwingBusId());
	    	Zone zone = swingBus.getZone();
	    	// get the neighboring zones of the swing bus
	    	List<String> list = StringUtil.convertLongAry2StrList(CoreUtilFunc.getZoneNumberAry(net.neighborZones(zone)));
	    	// add swing bus zone to the list
	    	list.add(new Long(zone.getNumber()).toString());
		    this.swingAllocZoneComboBox.setModel(new javax.swing.DefaultComboBoxModel(list.toArray()));
	    } catch (InterpssException e) {
		    this.swingAllocZoneComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Error"}));
	    }
	    
	    this.genPVSwingBusVoltCacheList = new ArrayList<DblBusValue>();
		this.useCachedVoltCheckBox.setSelected(false);
	}
    
    public void setXmlCaseData(PTradingAnalysisXmlType pt) {
    	this._ptXml = pt;
    }
	/**
	*	Set form data to the editor
	*
	* @return false if there is any problem
	*/
	public boolean setForm2Editor() {
		IpssLogger.getLogger().info("NBPTradingCasePanel setForm2Editor() called");
		
		// Case Data Panel
		PtCaseDataXmlType casedata = this._ptXml.getCaseData();
		edFileTextField.setText(casedata.getEdFile().getFilename());
		
		edGenPFacorTextField.setText(Number2String.toStr(casedata.getEdFile().getGenPFactor(), "#0.00"));
		edLossPercentTextField.setText(Number2String.toStr(casedata.getEdFile().getLossPercent(), "#0.00"));
		edLoadPFacorTextField.setText(Number2String.toStr(casedata.getEdFile().getLoadPFactor(), "#0.00"));
		
		interfaceFileTextField.setText(casedata.getInterfaceFile().getInterfaceFilename());
		interfaceLimitTextField.setText(casedata.getInterfaceFile().getLimitFilename());
		
		// Aclf Analysis
		PtAclfAnalysisXmlType aclfXml = this._ptXml.getAclfAnalysis();

		edHourComboBox.setSelectedItem(aclfXml.getHour() == null? "12:00" : aclfXml.getHour());

		if (aclfXml.getTolerance() != null)
			this.lfToleranceTextField.setText(Number2String.toStr(aclfXml.getTolerance(), "0.0000"));
		
		aclfXml.setGenQAdjustment(true);
		if (aclfXml.isGenQAdjustment()) {
			lfAssistGenQAdjStespTextField.setText(
					new Integer(aclfXml.getGenQAdjOption().getNoRunsLfAssist()).toString());
			lfAssistGenFileTextField.setText(aclfXml.getGenQAdjOption().getLfAssistGenFilename());
			if (aclfXml.getGenQAdjOption().getLfAssistAdjTolerance() != null)
				this.lfAssistGenQAdjToleranceTextField.setText(
						aclfXml.getGenQAdjOption().getLfAssistAdjTolerance().toString());
		}
		
		swingAllocCheckBox.setSelected(aclfXml.isSwingBusPQAlloc());
		if (aclfXml.isSwingBusPQAlloc()) {
			String n = new Long(aclfXml.getGenSwingAllocOption().getZoneNumber()).toString();
			this.swingAllocZoneComboBox.setSelectedItem(n);
			swingAllocMaxStepsTextField.setText(
					new Integer(aclfXml.getGenSwingAllocOption().getSteps()).toString());
			swingAllocAccFactorTextField.setText(
					new Double(aclfXml.getGenSwingAllocOption().getAccFactor()).toString());
			if(aclfXml.getGenSwingAllocOption().getAllocTolerance() != null)
				this.swingAllocToleranceTextField.setText(
					new Double(aclfXml.getGenSwingAllocOption().getAllocTolerance()).toString());
		}
		
		// output panel
		PtAclfOutputXmlType outOpt = this._ptXml.getAclfAnalysis().getOutputOption();
		largeGSFPointsTextField.setText(
					new Integer(outOpt.getLargeGSFPoints()).toString());
		this.outVoltViolationCheckBox.setSelected(outOpt.isBusVoltageViolation());
		this.voltUpperLimitTextField.setText(
				new Double(outOpt.getBusVoltageUpperLimitPU()).toString());
		this.voltLowerLimitTextField.setText(
				new Double(outOpt.getBusVoltageLowerLimitPU()).toString());
		this.outBranchViolationCheckBox.setSelected(outOpt.isBranchLimitViolation());
		this.outInterfaceViolationCheckBox.setSelected(outOpt.isInterfaceLimitViolation());
		this.outZoneSummaryCheckBox.setSelected(outOpt.isZoneSummary());
		this.outAreaSummaryCheckBox.setSelected(outOpt.isAreaSummary());
		this.outMustRunSummaryCheckBox.setSelected(outOpt.isLfAssistGenSummary());

		return true;
	}

	/**
	*	Save editor screen data to the form
	*
	* @param errMsg error messages during the saving process.
	* @return false if there is any problem
	*/
	public boolean saveEditor2Form(Vector<String> errMsg) throws Exception {
		IpssLogger.getLogger().info("NBPTradingCasePanel saveEditor2Form() called");
		
		saveCaseData(errMsg);
		saveAclfAnalysis(errMsg);
		saveLineOutage(errMsg);
		saveOutputConfig(errMsg);

		return errMsg.size() == 0;
	}

	public boolean saveCaseData(Vector<String> errMsg) {
		boolean noError = true;
		PtCaseDataXmlType casedata = this._ptXml.getCaseData();
		
		casedata.getEdFile().setFilename(
				edFileTextField.getText());
		casedata.getEdFile().setGenPFactor(
				new Double(edGenPFacorTextField.getText()).doubleValue());
		casedata.getEdFile().setLossPercent(
				new Double(edLossPercentTextField.getText()).doubleValue());
		casedata.getEdFile().setLoadPFactor(
				new Double(edLoadPFacorTextField.getText()).doubleValue());
		
		casedata.getInterfaceFile().setInterfaceFilename(
				interfaceFileTextField.getText());
		casedata.getInterfaceFile().setLimitFilename(
				interfaceLimitTextField.getText());

		PtAclfAnalysisXmlType aclfXml = this._ptXml.getAclfAnalysis();

		aclfXml.setGenQAdjustment(true);
		if (aclfXml.isGenQAdjustment()) {
			aclfXml.getGenQAdjOption().setNoRunsLfAssist(
					new Integer(lfAssistGenQAdjStespTextField.getText()).intValue());
			aclfXml.getGenQAdjOption().setLfAssistGenFilename(lfAssistGenFileTextField.getText());
			aclfXml.getGenQAdjOption().setLfAssistAdjTolerance(
					new Double(this.lfAssistGenQAdjToleranceTextField.getText()).doubleValue());
		}
		
		return noError;
	}

	public boolean saveAclfAnalysis(Vector<String> errMsg) {
		PtAclfAnalysisXmlType aclfXml = this._ptXml.getAclfAnalysis();
		
		aclfXml.setHour(this.edHourComboBox.getSelectedItem().toString());
		
		aclfXml.setTolerance(new Double(this.lfToleranceTextField.getText()).doubleValue());
		
		aclfXml.setSwingBusPQAlloc(swingAllocCheckBox.isSelected());
		if (aclfXml.isSwingBusPQAlloc()) {
			String n = (String)this.swingAllocZoneComboBox.getSelectedItem();
			aclfXml.getGenSwingAllocOption().setZoneNumber(
					new Long(n).longValue());
			aclfXml.getGenSwingAllocOption().setSteps(
					new Integer(swingAllocMaxStepsTextField.getText()).intValue());
			aclfXml.getGenSwingAllocOption().setAccFactor(
					new Double(swingAllocAccFactorTextField.getText()).doubleValue());
		}
		
		boolean noError = true;
		return noError;
	}

	public boolean saveLineOutage(Vector<String> errMsg) {
		boolean noError = true;
		
		return noError;
	}

	public boolean saveOutputConfig(Vector<String> errMsg) {
		boolean noError = true;

		PtAclfOutputXmlType outOpt = this._ptXml.getAclfAnalysis().getOutputOption();
		outOpt.setLargeGSFPoints(
					new Integer(largeGSFPointsTextField.getText()).intValue());
		outOpt.setBusVoltageViolation(this.outVoltViolationCheckBox.isSelected());
		outOpt.setBusVoltageUpperLimitPU(
				new Double(this.voltUpperLimitTextField.getText()).doubleValue());
		outOpt.setBusVoltageLowerLimitPU(
				new Double(this.voltLowerLimitTextField.getText()).doubleValue());
		outOpt.setBranchLimitViolation(this.outBranchViolationCheckBox.isSelected());
		outOpt.setInterfaceLimitViolation(this.outInterfaceViolationCheckBox.isSelected());
		outOpt.setZoneSummary(this.outZoneSummaryCheckBox.isSelected());
		outOpt.setAreaSummary(this.outAreaSummaryCheckBox.isSelected());
		outOpt.setLfAssistGenSummary(this.outMustRunSummaryCheckBox.isSelected());

		return noError;
	}

	/** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pTradingAnalysisTabbedPane = new javax.swing.JTabbedPane();
        caseDataPanel = new javax.swing.JPanel();
        edFilePanel = new javax.swing.JPanel();
        edFileLabel = new javax.swing.JLabel();
        edFileTextField = new javax.swing.JTextField();
        selectEdFileButton = new javax.swing.JButton();
        edGenPFacorTextField = new javax.swing.JTextField();
        edGenPFactorLabel = new javax.swing.JLabel();
        edLoadPFacorTextField = new javax.swing.JTextField();
        edLoadPFactorLabel = new javax.swing.JLabel();
        edLossPercentTextField = new javax.swing.JTextField();
        edLossPercentLabel = new javax.swing.JLabel();
        interfaceFilePanel = new javax.swing.JPanel();
        interfaceFileLabel = new javax.swing.JLabel();
        interfaceFileTextField = new javax.swing.JTextField();
        selectInterfaceFileButton = new javax.swing.JButton();
        interfaceLimitLabel = new javax.swing.JLabel();
        interfaceLimitTextField = new javax.swing.JTextField();
        selectInterfaceLimitButton = new javax.swing.JButton();
        lfAssistGenPanel = new javax.swing.JPanel();
        lfAssistGenFileLabel = new javax.swing.JLabel();
        lfAssistGenFileTextField = new javax.swing.JTextField();
        lfAssistGenFileSelectButton = new javax.swing.JButton();
        lfAssistGenQAdjStepsLabel = new javax.swing.JLabel();
        lfAssistGenQAdjStespTextField = new javax.swing.JTextField();
        lfAssistGenQAdjToleranceLabel = new javax.swing.JLabel();
        lfAssistGenQAdjToleranceTextField = new javax.swing.JTextField();
        aclfAnalysisPanel = new javax.swing.JPanel();
        edHourLabel = new javax.swing.JLabel();
        edHourComboBox = new javax.swing.JComboBox();
        lfToleranceLabel = new javax.swing.JLabel();
        lfToleranceTextField = new javax.swing.JTextField();
        useCachedVoltCheckBox = new javax.swing.JCheckBox();
        swingAllocCheckBox = new javax.swing.JCheckBox();
        swingAllocZoneLabel = new javax.swing.JLabel();
        swingAllocZoneComboBox = new javax.swing.JComboBox();
        swingAllocMaxStepsLabel = new javax.swing.JLabel();
        swingAllocMaxStepsTextField = new javax.swing.JTextField();
        swingAllocAccFactorLabel = new javax.swing.JLabel();
        swingAllocAccFactorTextField = new javax.swing.JTextField();
        swingAllocToleraceLabel = new javax.swing.JLabel();
        swingAllocToleranceTextField = new javax.swing.JTextField();
        runAclfAnalysisButton = new javax.swing.JButton();
        lineOutagePanel = new javax.swing.JPanel();
        runLineOutgageButton = new javax.swing.JButton();
        outputConfigPanel = new javax.swing.JPanel();
        outVoltViolationCheckBox = new javax.swing.JCheckBox();
        voltUpperLimitLabel = new javax.swing.JLabel();
        voltUpperLimitTextField = new javax.swing.JTextField();
        voltLowerLimitLabel = new javax.swing.JLabel();
        voltLowerLimitTextField = new javax.swing.JTextField();
        outBranchViolationCheckBox = new javax.swing.JCheckBox();
        outInterfaceViolationCheckBox = new javax.swing.JCheckBox();
        outZoneSummaryCheckBox = new javax.swing.JCheckBox();
        outAreaSummaryCheckBox = new javax.swing.JCheckBox();
        outMustRunSummaryCheckBox = new javax.swing.JCheckBox();
        largeGSFPointsLabel = new javax.swing.JLabel();
        largeGSFPointsTextField = new javax.swing.JTextField();

        pTradingAnalysisTabbedPane.setFont(new java.awt.Font("Dialog", 0, 12));
        pTradingAnalysisTabbedPane.setMinimumSize(new java.awt.Dimension(80, 48));
        pTradingAnalysisTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                panelSelectionChanged(evt);
            }
        });

        edFilePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EDispatch Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10))); // NOI18N

        edFileLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        edFileLabel.setText("Daily ED File");

        edFileTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        edFileTextField.setText("ED file");

        selectEdFileButton.setFont(new java.awt.Font("Dialog", 0, 10));
        selectEdFileButton.setText("Select ...");
        selectEdFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectEdFileButtonActionPerformed(evt);
            }
        });

        edGenPFacorTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        edGenPFacorTextField.setText("0.90");

        edGenPFactorLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        edGenPFactorLabel.setText("Gen PFator (PU)");

        edLoadPFacorTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        edLoadPFacorTextField.setText("0.98");

        edLoadPFactorLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        edLoadPFactorLabel.setText("Load PFator (PU)");

        edLossPercentTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        edLossPercentTextField.setText("2.5");

        edLossPercentLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        edLossPercentLabel.setText("Network Loss %");

        org.jdesktop.layout.GroupLayout edFilePanelLayout = new org.jdesktop.layout.GroupLayout(edFilePanel);
        edFilePanel.setLayout(edFilePanelLayout);
        edFilePanelLayout.setHorizontalGroup(
            edFilePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(edFilePanelLayout.createSequentialGroup()
                .add(18, 18, 18)
                .add(edFilePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(edFilePanelLayout.createSequentialGroup()
                        .add(edFilePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(edFileLabel)
                            .add(edFilePanelLayout.createSequentialGroup()
                                .add(89, 89, 89)
                                .add(edFileTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)))
                        .add(18, 18, 18)
                        .add(selectEdFileButton))
                    .add(edFilePanelLayout.createSequentialGroup()
                        .add(edFilePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(edFilePanelLayout.createSequentialGroup()
                                .add(edLoadPFactorLabel)
                                .add(18, 18, 18)
                                .add(edLoadPFacorTextField))
                            .add(org.jdesktop.layout.GroupLayout.LEADING, edFilePanelLayout.createSequentialGroup()
                                .add(edGenPFactorLabel)
                                .add(22, 22, 22)
                                .add(edGenPFacorTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 52, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(45, 45, 45)
                        .add(edLossPercentLabel)
                        .add(18, 18, 18)
                        .add(edLossPercentTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(36, 36, 36))
        );
        edFilePanelLayout.setVerticalGroup(
            edFilePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(edFilePanelLayout.createSequentialGroup()
                .add(edFilePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(edFileLabel)
                    .add(edFileTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(selectEdFileButton))
                .add(10, 10, 10)
                .add(edFilePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(edGenPFactorLabel)
                    .add(edGenPFacorTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(edLossPercentLabel)
                    .add(edLossPercentTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(edFilePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(edLoadPFactorLabel)
                    .add(edLoadPFacorTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        interfaceFilePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Interface Defintion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10))); // NOI18N

        interfaceFileLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        interfaceFileLabel.setText("Interface File");

        interfaceFileTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        interfaceFileTextField.setText("Interface File");

        selectInterfaceFileButton.setFont(new java.awt.Font("Dialog", 0, 10));
        selectInterfaceFileButton.setText("Select ...");
        selectInterfaceFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectInterfaceFileButtonActionPerformed(evt);
            }
        });

        interfaceLimitLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        interfaceLimitLabel.setText("Limit File");

        interfaceLimitTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        interfaceLimitTextField.setText("Interface Limit file");

        selectInterfaceLimitButton.setFont(new java.awt.Font("Dialog", 0, 10));
        selectInterfaceLimitButton.setText("Select ...");
        selectInterfaceLimitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectInterfaceLimitButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout interfaceFilePanelLayout = new org.jdesktop.layout.GroupLayout(interfaceFilePanel);
        interfaceFilePanel.setLayout(interfaceFilePanelLayout);
        interfaceFilePanelLayout.setHorizontalGroup(
            interfaceFilePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(interfaceFilePanelLayout.createSequentialGroup()
                .add(19, 19, 19)
                .add(interfaceFilePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(interfaceFileLabel)
                    .add(interfaceLimitLabel))
                .add(18, 18, 18)
                .add(interfaceFilePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(interfaceLimitTextField)
                    .add(interfaceFileTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 230, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(interfaceFilePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(selectInterfaceFileButton)
                    .add(selectInterfaceLimitButton))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        interfaceFilePanelLayout.setVerticalGroup(
            interfaceFilePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(interfaceFilePanelLayout.createSequentialGroup()
                .add(interfaceFilePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(interfaceFilePanelLayout.createSequentialGroup()
                        .add(selectInterfaceFileButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(selectInterfaceLimitButton))
                    .add(interfaceFilePanelLayout.createSequentialGroup()
                        .add(interfaceFilePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(interfaceFileTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(interfaceFileLabel))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(interfaceFilePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(interfaceLimitLabel)
                            .add(interfaceLimitTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        lfAssistGenPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lf Assistance Generator", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10))); // NOI18N

        lfAssistGenFileLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        lfAssistGenFileLabel.setText("LF Assist File");

        lfAssistGenFileTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        lfAssistGenFileTextField.setText("LF Assistance Gen File");

        lfAssistGenFileSelectButton.setFont(new java.awt.Font("Dialog", 0, 10));
        lfAssistGenFileSelectButton.setText("Select ...");
        lfAssistGenFileSelectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lfAssistGenFileSelectButtonActionPerformed(evt);
            }
        });

        lfAssistGenQAdjStepsLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        lfAssistGenQAdjStepsLabel.setText("Q Adj Run Steps");

        lfAssistGenQAdjStespTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        lfAssistGenQAdjStespTextField.setText("3");

        lfAssistGenQAdjToleranceLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        lfAssistGenQAdjToleranceLabel.setText("Q Adj Tolerance");

        lfAssistGenQAdjToleranceTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        lfAssistGenQAdjToleranceTextField.setText("0.1");

        org.jdesktop.layout.GroupLayout lfAssistGenPanelLayout = new org.jdesktop.layout.GroupLayout(lfAssistGenPanel);
        lfAssistGenPanel.setLayout(lfAssistGenPanelLayout);
        lfAssistGenPanelLayout.setHorizontalGroup(
            lfAssistGenPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(lfAssistGenPanelLayout.createSequentialGroup()
                .add(18, 18, 18)
                .add(lfAssistGenPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lfAssistGenPanelLayout.createSequentialGroup()
                        .add(lfAssistGenQAdjStepsLabel)
                        .add(42, 42, 42)
                        .add(lfAssistGenQAdjStespTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(35, 35, 35)
                        .add(lfAssistGenQAdjToleranceLabel)
                        .add(33, 33, 33)
                        .add(lfAssistGenQAdjToleranceTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(lfAssistGenPanelLayout.createSequentialGroup()
                        .add(lfAssistGenFileLabel)
                        .add(18, 18, 18)
                        .add(lfAssistGenFileTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 222, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(lfAssistGenFileSelectButton)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        lfAssistGenPanelLayout.setVerticalGroup(
            lfAssistGenPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, lfAssistGenPanelLayout.createSequentialGroup()
                .add(lfAssistGenPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lfAssistGenFileLabel)
                    .add(lfAssistGenFileTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lfAssistGenFileSelectButton))
                .add(18, 18, 18)
                .add(lfAssistGenPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lfAssistGenQAdjStespTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lfAssistGenQAdjToleranceLabel)
                    .add(lfAssistGenQAdjToleranceTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lfAssistGenQAdjStepsLabel))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout caseDataPanelLayout = new org.jdesktop.layout.GroupLayout(caseDataPanel);
        caseDataPanel.setLayout(caseDataPanelLayout);
        caseDataPanelLayout.setHorizontalGroup(
            caseDataPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, caseDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(caseDataPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, lfAssistGenPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, edFilePanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(interfaceFilePanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        caseDataPanelLayout.setVerticalGroup(
            caseDataPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(caseDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(edFilePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 126, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(interfaceFilePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(lfAssistGenPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pTradingAnalysisTabbedPane.addTab("Case Data", caseDataPanel);

        edHourLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        edHourLabel.setText("ED Hour");

        edHourComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        edHourComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0:00", "1:00", "2:00", "3:00", "4:00", "5:00", "6:00", "7:00", "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", " " }));

        lfToleranceLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        lfToleranceLabel.setText("Lf Tolerance");

        lfToleranceTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        lfToleranceTextField.setText("0.0001");

        useCachedVoltCheckBox.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        useCachedVoltCheckBox.setText("Use Previous Run PV Voltage");

        swingAllocCheckBox.setFont(new java.awt.Font("Dialog", 0, 12));
        swingAllocCheckBox.setSelected(true);
        swingAllocCheckBox.setText("Swing Bus P&Q Allocation");

        swingAllocZoneLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        swingAllocZoneLabel.setText("Alloc Zone");

        swingAllocZoneComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        swingAllocZoneComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3" }));

        swingAllocMaxStepsLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        swingAllocMaxStepsLabel.setText("Max Steps");

        swingAllocMaxStepsTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        swingAllocMaxStepsTextField.setText("3");

        swingAllocAccFactorLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        swingAllocAccFactorLabel.setText("Acc Factor");

        swingAllocAccFactorTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        swingAllocAccFactorTextField.setText("1.5");

        swingAllocToleraceLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        swingAllocToleraceLabel.setText("Alloc Tolerance");

        swingAllocToleranceTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        swingAllocToleranceTextField.setText("0.2");

        runAclfAnalysisButton.setFont(new java.awt.Font("Dialog", 0, 12));
        runAclfAnalysisButton.setText("Run Analysis");
        runAclfAnalysisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runAclfAnalysisButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout aclfAnalysisPanelLayout = new org.jdesktop.layout.GroupLayout(aclfAnalysisPanel);
        aclfAnalysisPanel.setLayout(aclfAnalysisPanelLayout);
        aclfAnalysisPanelLayout.setHorizontalGroup(
            aclfAnalysisPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(aclfAnalysisPanelLayout.createSequentialGroup()
                .add(aclfAnalysisPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(aclfAnalysisPanelLayout.createSequentialGroup()
                        .add(26, 26, 26)
                        .add(aclfAnalysisPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(swingAllocCheckBox)
                            .add(aclfAnalysisPanelLayout.createSequentialGroup()
                                .add(32, 32, 32)
                                .add(aclfAnalysisPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(swingAllocZoneLabel)
                                    .add(swingAllocMaxStepsLabel)
                                    .add(swingAllocToleraceLabel))
                                .add(29, 29, 29)
                                .add(aclfAnalysisPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(swingAllocZoneComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 71, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(aclfAnalysisPanelLayout.createSequentialGroup()
                                        .add(aclfAnalysisPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                            .add(swingAllocMaxStepsTextField)
                                            .add(swingAllocToleranceTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                                        .add(33, 33, 33)
                                        .add(swingAllocAccFactorLabel)
                                        .add(18, 18, 18)
                                        .add(swingAllocAccFactorTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))))
                    .add(aclfAnalysisPanelLayout.createSequentialGroup()
                        .add(184, 184, 184)
                        .add(runAclfAnalysisButton))
                    .add(aclfAnalysisPanelLayout.createSequentialGroup()
                        .add(aclfAnalysisPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(aclfAnalysisPanelLayout.createSequentialGroup()
                                .add(154, 154, 154)
                                .add(edHourLabel))
                            .add(aclfAnalysisPanelLayout.createSequentialGroup()
                                .add(58, 58, 58)
                                .add(lfToleranceLabel)
                                .add(29, 29, 29)
                                .add(lfToleranceTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 59, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(26, 26, 26)
                        .add(aclfAnalysisPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(useCachedVoltCheckBox)
                            .add(edHourComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 77, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        aclfAnalysisPanelLayout.setVerticalGroup(
            aclfAnalysisPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, aclfAnalysisPanelLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .add(aclfAnalysisPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(edHourComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(edHourLabel))
                .add(18, 18, 18)
                .add(aclfAnalysisPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lfToleranceTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lfToleranceLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(useCachedVoltCheckBox))
                .add(18, 18, 18)
                .add(swingAllocCheckBox)
                .add(aclfAnalysisPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(aclfAnalysisPanelLayout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(swingAllocZoneComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(aclfAnalysisPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(swingAllocMaxStepsTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(swingAllocMaxStepsLabel)
                            .add(swingAllocAccFactorLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(swingAllocAccFactorTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(aclfAnalysisPanelLayout.createSequentialGroup()
                        .add(13, 13, 13)
                        .add(swingAllocZoneLabel)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(aclfAnalysisPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(aclfAnalysisPanelLayout.createSequentialGroup()
                        .add(149, 149, 149)
                        .add(runAclfAnalysisButton))
                    .add(aclfAnalysisPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(swingAllocToleranceTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(swingAllocToleraceLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(23, 23, 23))
        );

        pTradingAnalysisTabbedPane.addTab("Aclf Analysis", aclfAnalysisPanel);

        runLineOutgageButton.setFont(new java.awt.Font("Dialog", 0, 10));
        runLineOutgageButton.setText("Run");
        runLineOutgageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runLineOutgageButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout lineOutagePanelLayout = new org.jdesktop.layout.GroupLayout(lineOutagePanel);
        lineOutagePanel.setLayout(lineOutagePanelLayout);
        lineOutagePanelLayout.setHorizontalGroup(
            lineOutagePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(lineOutagePanelLayout.createSequentialGroup()
                .add(220, 220, 220)
                .add(runLineOutgageButton)
                .addContainerGap(225, Short.MAX_VALUE))
        );
        lineOutagePanelLayout.setVerticalGroup(
            lineOutagePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, lineOutagePanelLayout.createSequentialGroup()
                .addContainerGap(334, Short.MAX_VALUE)
                .add(runLineOutgageButton)
                .add(36, 36, 36))
        );

        pTradingAnalysisTabbedPane.addTab("Line Outage", lineOutagePanel);

        outVoltViolationCheckBox.setFont(new java.awt.Font("Dialog", 0, 12));
        outVoltViolationCheckBox.setSelected(true);
        outVoltViolationCheckBox.setText("Bus Voltage Violation Report");

        voltUpperLimitLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        voltUpperLimitLabel.setText("Upper Limit");

        voltUpperLimitTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        voltUpperLimitTextField.setText("1.15");

        voltLowerLimitLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        voltLowerLimitLabel.setText("Lower Limit");

        voltLowerLimitTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        voltLowerLimitTextField.setText("0.85");

        outBranchViolationCheckBox.setFont(new java.awt.Font("Dialog", 0, 12));
        outBranchViolationCheckBox.setSelected(true);
        outBranchViolationCheckBox.setText("Branch Limit Violation Report");

        outInterfaceViolationCheckBox.setFont(new java.awt.Font("Dialog", 0, 12));
        outInterfaceViolationCheckBox.setSelected(true);
        outInterfaceViolationCheckBox.setText("Interface Limit Violation Report");

        outZoneSummaryCheckBox.setFont(new java.awt.Font("Dialog", 0, 12));
        outZoneSummaryCheckBox.setSelected(true);
        outZoneSummaryCheckBox.setText("Zone Summary");

        outAreaSummaryCheckBox.setFont(new java.awt.Font("Dialog", 0, 12));
        outAreaSummaryCheckBox.setSelected(true);
        outAreaSummaryCheckBox.setText("Area Summary");

        outMustRunSummaryCheckBox.setFont(new java.awt.Font("Dialog", 0, 12));
        outMustRunSummaryCheckBox.setText("LF Assist Generator Summary");

        largeGSFPointsLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        largeGSFPointsLabel.setText("Large GSF Points");

        largeGSFPointsTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        largeGSFPointsTextField.setText("5");

        org.jdesktop.layout.GroupLayout outputConfigPanelLayout = new org.jdesktop.layout.GroupLayout(outputConfigPanel);
        outputConfigPanel.setLayout(outputConfigPanelLayout);
        outputConfigPanelLayout.setHorizontalGroup(
            outputConfigPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(outputConfigPanelLayout.createSequentialGroup()
                .add(outputConfigPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(outputConfigPanelLayout.createSequentialGroup()
                        .add(34, 34, 34)
                        .add(outputConfigPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(outBranchViolationCheckBox)
                            .add(outInterfaceViolationCheckBox)
                            .add(outZoneSummaryCheckBox)
                            .add(outAreaSummaryCheckBox)
                            .add(outMustRunSummaryCheckBox)
                            .add(outputConfigPanelLayout.createSequentialGroup()
                                .add(218, 218, 218)
                                .add(voltLowerLimitLabel)
                                .add(18, 18, 18)
                                .add(voltLowerLimitTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(outputConfigPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(outputConfigPanelLayout.createSequentialGroup()
                                    .add(voltUpperLimitLabel)
                                    .add(18, 18, 18)
                                    .add(voltUpperLimitTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(outVoltViolationCheckBox))))
                    .add(outputConfigPanelLayout.createSequentialGroup()
                        .add(59, 59, 59)
                        .add(largeGSFPointsLabel)
                        .add(18, 18, 18)
                        .add(largeGSFPointsTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        outputConfigPanelLayout.setVerticalGroup(
            outputConfigPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(outputConfigPanelLayout.createSequentialGroup()
                .add(20, 20, 20)
                .add(outVoltViolationCheckBox)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(outputConfigPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(voltUpperLimitLabel)
                    .add(voltUpperLimitTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(voltLowerLimitLabel)
                    .add(voltLowerLimitTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(11, 11, 11)
                .add(outBranchViolationCheckBox)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(outInterfaceViolationCheckBox)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(outZoneSummaryCheckBox)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(outAreaSummaryCheckBox)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(outMustRunSummaryCheckBox)
                .add(31, 31, 31)
                .add(outputConfigPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(largeGSFPointsLabel)
                    .add(largeGSFPointsTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(123, Short.MAX_VALUE))
        );

        pTradingAnalysisTabbedPane.addTab("Output Config", outputConfigPanel);

        pTradingAnalysisTabbedPane.setSelectedIndex(1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(pTradingAnalysisTabbedPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(pTradingAnalysisTabbedPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 423, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
 
    private void panelSelectionChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_panelSelectionChanged
    	if ( pTradingAnalysisTabbedPane.getSelectedIndex() == 0 )
        	IpssLogger.getLogger().info("Panel selection changed - Case Data Panel");
    	else if ( pTradingAnalysisTabbedPane.getSelectedIndex() == 1 ) {
        	IpssLogger.getLogger().info("Panel selection changed - Aclf Analysis Panel");
    	}	
    	else if ( pTradingAnalysisTabbedPane.getSelectedIndex() == 2 ) {
        	IpssLogger.getLogger().info("Panel selection changed - Line Outage Analysis Panel");
    	}	
    	else if ( pTradingAnalysisTabbedPane.getSelectedIndex() == 3 ) {
        	IpssLogger.getLogger().info("Panel selection changed - Output Config Panel");
    	}	
    }//GEN-LAST:event_panelSelectionChanged

private boolean saveInputData() {
	Vector<String> errMsg = new Vector<String>();
	try {
    	if (!saveEditor2Form(errMsg)) {
    		BasePluginSpringFactory.getEditorDialogUtil().showMsgDialog(this.parent, "Input Data Error", errMsg);
			return false;
    	}
    	
    	if (!this.useCachedVoltCheckBox.isSelected() ) {
    		this.genPVSwingBusVoltCacheList.clear();
    	}
    } catch (Exception e) {
    	IpssLogger.logErr(e);
    	BasePluginSpringFactory.getEditorDialogUtil().showMsgDialog(this.parent, "Input Data Error", e.toString());
		return false;
    }
    return true;
}

private void runAclfAnalysisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runAclfAnalysisButtonActionPerformed
	IpssLogger.getLogger().info("Aclf analysis button selected");
	
	this.parent.setAlwaysOnTop(false);

	if (!saveInputData())
		return;

	// running the analysis in a separate thread, so that it won't block
	// the main UI window
	final JDialog parent = this.parent;
	final AclfNetwork net = this._simuCtx.getAclfNet();
	final PTradingAnalysisXmlType ptXml = this._ptXml;
	final List<DblBusValue> genPVSwingBusList = this.genPVSwingBusVoltCacheList;
    final javax.swing.JCheckBox _useCachedVoltCheckBox = this.useCachedVoltCheckBox;
    
	new Thread() {
		public void run() {
			IAppStatus appStatus = GraphSpringFactory.getIpssGraphicEditor().getAppStatus();
			appStatus.busyStart(Constants.StatusBusyIndicatorPeriod,
					"Run PowerTrading Aclf Analysis ...", "Run PTraing");
			// Book marked the AclfNetwork object
			ChangeRecorder recorderBaseNet = new ChangeRecorder(net);	
			try {
				AclfDslODMRunner runner = new AclfDslODMRunner(net);
				runner.runPTradingAnalysis(ptXml, genPVSwingBusList);
				UISpringFactory.getOutputTextDialog("BaseCase Aclf Analysis Results")
					.display(PTradingOutput.outHourLoaflowResult(net, ptXml, 
							runner.getHrLoadflow().getLfAssitGenList()));
			} catch (InterpssException e) {
				BasePluginSpringFactory.getEditorDialogUtil().showMsgDialog(parent, "Analysis Error", e.toString());
				recorderBaseNet.endRecording().apply();	
				return;
			}
			// cache PV/Swing bus voltage
			genPVSwingBusList.clear();
			for (Bus b : net.getBusList()) {
				AclfBus bus = (AclfBus)b;
				if (b.isActive() && ( bus.isGenPV() || bus.isSwing()))  {
						genPVSwingBusVoltCacheList.add(new DblBusValue(bus.getId(), bus.getVoltageMag()));
				}
			}
			_useCachedVoltCheckBox.setSelected(true);
			// roll-back AclfNet to the bookmarked point
			recorderBaseNet.endRecording().apply();	
			appStatus.busyStop("Run PowerTrading Aclf Analysis finished");			
		}
	}.start();
}//GEN-LAST:event_runAclfAnalysisButtonActionPerformed

private void runLineOutgageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runLineOutgageButtonActionPerformed
	IpssLogger.getLogger().info("Line outage analysis button selected");
	
	this.parent.setAlwaysOnTop(false);

	if (!saveInputData())
		return;
   	
}//GEN-LAST:event_runLineOutgageButtonActionPerformed

private void selectEdFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectEdFileButtonActionPerformed
	JFileChooser fc = getExcelFileChooser();
	if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
		File file = fc.getSelectedFile();
		edFileTextField.setText(file.getAbsolutePath());
	}
}//GEN-LAST:event_selectEdFileButtonActionPerformed

private void selectInterfaceFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectInterfaceFileButtonActionPerformed
	JFileChooser fc = getExcelFileChooser();
	if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
		File file = fc.getSelectedFile();
		interfaceFileTextField.setText(file.getAbsolutePath());
	}
}//GEN-LAST:event_selectInterfaceFileButtonActionPerformed

private void selectInterfaceLimitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectInterfaceLimitButtonActionPerformed
	JFileChooser fc = getExcelFileChooser();
	if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
		File file = fc.getSelectedFile();
		interfaceLimitTextField.setText(file.getAbsolutePath());
	}
}//GEN-LAST:event_selectInterfaceLimitButtonActionPerformed

private void lfAssistGenFileSelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lfAssistGenFileSelectButtonActionPerformed
	JFileChooser fc = getExcelFileChooser();
	if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
		File file = fc.getSelectedFile();
		lfAssistGenFileTextField.setText(file.getAbsolutePath());
	}
}//GEN-LAST:event_lfAssistGenFileSelectButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aclfAnalysisPanel;
    private javax.swing.JPanel caseDataPanel;
    private javax.swing.JLabel edFileLabel;
    private javax.swing.JPanel edFilePanel;
    private javax.swing.JTextField edFileTextField;
    private javax.swing.JTextField edGenPFacorTextField;
    private javax.swing.JLabel edGenPFactorLabel;
    private javax.swing.JComboBox edHourComboBox;
    private javax.swing.JLabel edHourLabel;
    private javax.swing.JTextField edLoadPFacorTextField;
    private javax.swing.JLabel edLoadPFactorLabel;
    private javax.swing.JLabel edLossPercentLabel;
    private javax.swing.JTextField edLossPercentTextField;
    private javax.swing.JLabel interfaceFileLabel;
    private javax.swing.JPanel interfaceFilePanel;
    private javax.swing.JTextField interfaceFileTextField;
    private javax.swing.JLabel interfaceLimitLabel;
    private javax.swing.JTextField interfaceLimitTextField;
    private javax.swing.JLabel largeGSFPointsLabel;
    private javax.swing.JTextField largeGSFPointsTextField;
    private javax.swing.JLabel lfAssistGenFileLabel;
    private javax.swing.JButton lfAssistGenFileSelectButton;
    private javax.swing.JTextField lfAssistGenFileTextField;
    private javax.swing.JPanel lfAssistGenPanel;
    private javax.swing.JLabel lfAssistGenQAdjStepsLabel;
    private javax.swing.JTextField lfAssistGenQAdjStespTextField;
    private javax.swing.JLabel lfAssistGenQAdjToleranceLabel;
    private javax.swing.JTextField lfAssistGenQAdjToleranceTextField;
    private javax.swing.JLabel lfToleranceLabel;
    private javax.swing.JTextField lfToleranceTextField;
    private javax.swing.JPanel lineOutagePanel;
    private javax.swing.JCheckBox outAreaSummaryCheckBox;
    private javax.swing.JCheckBox outBranchViolationCheckBox;
    private javax.swing.JCheckBox outInterfaceViolationCheckBox;
    private javax.swing.JCheckBox outMustRunSummaryCheckBox;
    private javax.swing.JCheckBox outVoltViolationCheckBox;
    private javax.swing.JCheckBox outZoneSummaryCheckBox;
    private javax.swing.JPanel outputConfigPanel;
    private javax.swing.JTabbedPane pTradingAnalysisTabbedPane;
    private javax.swing.JButton runAclfAnalysisButton;
    private javax.swing.JButton runLineOutgageButton;
    private javax.swing.JButton selectEdFileButton;
    private javax.swing.JButton selectInterfaceFileButton;
    private javax.swing.JButton selectInterfaceLimitButton;
    private javax.swing.JLabel swingAllocAccFactorLabel;
    private javax.swing.JTextField swingAllocAccFactorTextField;
    private javax.swing.JCheckBox swingAllocCheckBox;
    private javax.swing.JLabel swingAllocMaxStepsLabel;
    private javax.swing.JTextField swingAllocMaxStepsTextField;
    private javax.swing.JLabel swingAllocToleraceLabel;
    private javax.swing.JTextField swingAllocToleranceTextField;
    private javax.swing.JComboBox swingAllocZoneComboBox;
    private javax.swing.JLabel swingAllocZoneLabel;
    private javax.swing.JCheckBox useCachedVoltCheckBox;
    private javax.swing.JLabel voltLowerLimitLabel;
    private javax.swing.JTextField voltLowerLimitTextField;
    private javax.swing.JLabel voltUpperLimitLabel;
    private javax.swing.JTextField voltUpperLimitTextField;
    // End of variables declaration//GEN-END:variables
    
	private static JFileChooser excelFileChooser = null;	
	private JFileChooser getExcelFileChooser() {
		if (excelFileChooser == null) {
			excelFileChooser = new JFileChooser();
			excelFileChooser.addChoosableFileFilter(new IpssFileFilter("xlsx", "MS Excel file"));
		}
		return excelFileChooser;
	}

	
	private void initInputVerifier(DataVerifier v) {
		edGenPFacorTextField.setInputVerifier(v);
		edLossPercentTextField.setInputVerifier(v);
		edLoadPFacorTextField.setInputVerifier(v);
		edHourComboBox.setInputVerifier(v);
		lfAssistGenQAdjStespTextField.setInputVerifier(v);
		swingAllocZoneComboBox.setInputVerifier(v);
		swingAllocMaxStepsTextField.setInputVerifier(v);
		swingAllocAccFactorTextField.setInputVerifier(v);
		largeGSFPointsTextField.setInputVerifier(v);
		this.voltUpperLimitTextField.setInputVerifier(v);
		this.voltLowerLimitTextField.setInputVerifier(v);
	}
	
	class DataVerifier extends javax.swing.InputVerifier {
		public boolean verify(javax.swing.JComponent input) {
			if (input == null)
				return false;
       		try {
				if (input == edGenPFacorTextField)
					return SwingInputVerifyUtil.getDouble((javax.swing.JTextField)input) > 0.0 && 
							SwingInputVerifyUtil.getDouble((javax.swing.JTextField)input) <= 1.0;
				else if (input == edLossPercentTextField)
					return SwingInputVerifyUtil.getDouble((javax.swing.JTextField)input) > 0.0 && 
					       SwingInputVerifyUtil.getDouble((javax.swing.JTextField)input) <= 100.0;
				else if (input == edLoadPFacorTextField)
					return SwingInputVerifyUtil.getDouble((javax.swing.JTextField)input) > 0.0 && 
						   SwingInputVerifyUtil.getDouble((javax.swing.JTextField)input) <= 1.0;

				else if (input == edHourComboBox )
					return !SwingInputVerifyUtil.isEmptyStr((javax.swing.JComboBox)input);
				else if (input == lfAssistGenQAdjStespTextField)
					return SwingInputVerifyUtil.getInt((javax.swing.JTextField)input) > 0;
				else if (input == swingAllocZoneComboBox )
					return !SwingInputVerifyUtil.isEmptyStr((javax.swing.JComboBox)input);
				else if (input == swingAllocMaxStepsTextField)
					return SwingInputVerifyUtil.getInt((javax.swing.JTextField)input) > 0;
				else if (input == swingAllocAccFactorTextField)
					return SwingInputVerifyUtil.getDouble((javax.swing.JTextField)input) > 0.0;
					
				else if (input == largeGSFPointsTextField)
					return SwingInputVerifyUtil.getInt((javax.swing.JTextField)input) > 0;
				else if (input == voltUpperLimitTextField)
					return SwingInputVerifyUtil.getDouble((javax.swing.JTextField)input) > 0.0;
				else if (input == voltLowerLimitTextField)
					return SwingInputVerifyUtil.getDouble((javax.swing.JTextField)input) > 0.0;
 	       	} catch (Exception e) {
 	    		return false;
 	       	}				
			return true;
		}
	}
}
