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

import org.interpss.display.DclfOutFunc;
import org.interpss.editor.jgraph.ui.edit.IFormDataPanel;
import org.interpss.editor.runAct.xml.XmlScriptDclfRun;
import org.interpss.editor.ui.IOutputTextDialog;
import org.interpss.editor.ui.RunUIUtilFunc;
import org.interpss.editor.ui.UISpringAppContext;
import org.interpss.schema.AreaRecXmlType;
import org.interpss.schema.BranchRecXmlType;
import org.interpss.schema.BusRecXmlType;
import org.interpss.schema.DclfBranchSensitivityXmlType;
import org.interpss.schema.DclfStudyCaseXmlType;
import org.interpss.schema.SenAnalysisBusRecXmlType;
import org.interpss.schema.SenBusAnalysisDataType;
import org.interpss.schema.DclfStudyCaseXmlType.AreaTransferAnalysis;
import org.interpss.xml.IpssXmlUtilFunc;
import org.interpss.xml.StudyCaseHanlder;

import com.interpss.common.exp.InvalidOperationException;
import com.interpss.common.msg.IpssMessage;
import com.interpss.common.msg.IpssMsgListener;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.dclf.DclfAlgorithm;
import com.interpss.simu.SimuContext;

public class NBDclfCasePanel extends javax.swing.JPanel implements IFormDataPanel, IpssMsgListener {
	private static final long serialVersionUID = 1;
	private JDialog parent;
	
    // private GFormContainer _netContainer = null;
    private SimuContext _simuCtx = null;

    // holds the current case data being edited
    private DclfBranchSensitivityXmlType tdFactor = null;
	private AreaTransferAnalysis areaTransfer = null;;
    
    /** Creates new form NBAclfCasePanel */
    public NBDclfCasePanel(JDialog parent) {
    	initComponents();
    	this.parent = parent;

        DataVerifier verifier = new DataVerifier();
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
  	   throw new InvalidOperationException("Method not implemented");
     }
     
    public void init(Object netContainer, Object simuCtx) {
    	// for non-graphic file, netContainer == null
		IpssLogger.getLogger().info("NBAclfCasePanel init() called");
	    //_netContainer = (GFormContainer)netContainer;
	    _simuCtx = (SimuContext)simuCtx;

		this.ptdfInjectBusComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				RunUIUtilFunc.getIdArray(_simuCtx.getAclfNet(), RunUIUtilFunc.NetIdType.GenBus).toArray()));
		this.ptdfWithdrawBusComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				RunUIUtilFunc.getIdArray(_simuCtx.getAclfNet(), RunUIUtilFunc.NetIdType.LoadBus).toArray()));
		this.ptdfBranchListComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				RunUIUtilFunc.getIdArray(_simuCtx.getAclfNet(), RunUIUtilFunc.NetIdType.AllBranch).toArray()));
		
		this.atFromAreaComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				RunUIUtilFunc.getIdArray(_simuCtx.getAclfNet(), RunUIUtilFunc.NetIdType.AreaNo).toArray()));
		this.atToAreaComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				RunUIUtilFunc.getIdArray(_simuCtx.getAclfNet(), RunUIUtilFunc.NetIdType.AreaNo).toArray()));
		this.atBranchListComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				RunUIUtilFunc.getIdArray(_simuCtx.getAclfNet(), RunUIUtilFunc.NetIdType.AllBranch).toArray()));
	}
/*
    public void setCaseData(DclfCaseData data) {
    	_caseData = data;
    }
 */   
    public void setXmlCaseData(DclfStudyCaseXmlType xmlCaseData) {
    	if (xmlCaseData.getPTransferDistFactorArray().length == 0)
    		StudyCaseHanlder.addNewTDFactor(xmlCaseData);
    	this.tdFactor = xmlCaseData.getPTransferDistFactorArray(0);
    	if (xmlCaseData.getAreaTransferAnalysisArray().length == 0)
    		StudyCaseHanlder.addNewAreaTransfer(xmlCaseData);
    	this.areaTransfer = xmlCaseData.getAreaTransferAnalysisArray(0);
    }    
    
	/**
	*	Set form data to the editor
	*
	* @return false if there is any problem
	*/
	public boolean setForm2Editor() {
		IpssLogger.getLogger().info("NBAclfCasePanel setForm2Editor() called");
		
		if (!setTDFactor2Editor())
			return false;

		if (!setAreaTransfer2Editor())
			return false;
		
		return true;
	}

	public boolean setTDFactor2Editor() {
		if (tdFactor.getInjectBusType() == SenBusAnalysisDataType.SINGLE_BUS) {
		    this.ptdfSingleInjectBusRadioButton.setSelected(true);
			ptdfSingleInjectBusRadioButtonActionPerformed(null);
			String inBusId = tdFactor.getInjectBusList().getInjectBusArray(0).getBusId();
			ptdfInjectBusComboBox.setSelectedItem(inBusId);
		} else {
			this.ptdfMultiInjectBusRadioButton.setSelected(true);
		    ptdfMultiInjectBusRadioButtonActionPerformed(null);
		}
				
		if (tdFactor.getWithdrawBusType() == SenBusAnalysisDataType.SINGLE_BUS) {
			String wdBusId = tdFactor.getWithdrawBusList().getWithdrawBusArray(0).getBusId();
			ptdfWithdrawBusComboBox.setSelectedItem(wdBusId);
			ptdfWithSingleBusRadioButton.setSelected(true);
			ptdfWithSingleBusRadioButtonActionPerformed(null);
	    	ptdfWithdarwBusList.setModel(new javax.swing.DefaultComboBoxModel( new String[] {}));
		}
		else {
			ptdfWithMultiBusRadioButton.setSelected(true);
			ptdfWithMultiBusRadioButtonActionPerformed(null);
	    	ptdfWithdarwBusList.setModel(new javax.swing.DefaultComboBoxModel(
	    			IpssXmlUtilFunc.getSenAnalysisBusItemList(tdFactor.getWithdrawBusList().getWithdrawBusArray())));
		}
					
    	ptdfMeasBranchList.setModel(new javax.swing.DefaultComboBoxModel(
		    			IpssXmlUtilFunc.getBranchIdAry(tdFactor.getBranchArray())));

		return true;
	}

	public boolean setAreaTransfer2Editor() {
		this.atTransAmtTextField.setText(String.format("%4.2f", this.areaTransfer.getTransderAmountMW()));
		this.atTransAmtUnitComboBox.setSelectedItem("MW");
		
		AreaRecXmlType area = this.areaTransfer.getFromArea(); 
		if (area == null) {
			area = this.areaTransfer.addNewFromArea();
			String no = (String)this.atFromAreaComboBox.getSelectedItem();
			area.setAreaNo(new Integer(no).intValue());
		}
		this.atFromAreaComboBox.setSelectedItem(new Integer(area.getAreaNo()).toString());
			
		area = this.areaTransfer.getToArea();
		if (area == null) {
			area = this.areaTransfer.addNewToArea();
			String no = (String)this.atToAreaComboBox.getSelectedItem();
			area.setAreaNo(new Integer(no).intValue());
		}
		this.atToAreaComboBox.setSelectedItem(new Integer(area.getAreaNo()).toString());

		if (this.areaTransfer.getInjectBusList() != null && this.areaTransfer.getInjectBusList().sizeOfInjectBusArray() > 0) {
			atFromAreaBusList.setModel(new javax.swing.DefaultComboBoxModel(
	    			IpssXmlUtilFunc.getSenAnalysisBusItemList(areaTransfer.getInjectBusList().getInjectBusArray())));
		}
		else
			atFromAreaBusList.setModel(new javax.swing.DefaultComboBoxModel(
				RunUIUtilFunc.getIdArray(_simuCtx.getAclfNet(), RunUIUtilFunc.NetIdType.GenInAreaDFactor, 
						this.areaTransfer.getFromArea().getAreaNo()).toArray()));

		if (this.areaTransfer.getWithdrawBusList() != null && this.areaTransfer.getWithdrawBusList().sizeOfWithdrawBusArray() > 0) {
			atToAreaBusList.setModel(new javax.swing.DefaultComboBoxModel(
	    			IpssXmlUtilFunc.getSenAnalysisBusItemList(areaTransfer.getWithdrawBusList().getWithdrawBusArray())));
		}
		else
			atToAreaBusList.setModel(new javax.swing.DefaultComboBoxModel( 				
				RunUIUtilFunc.getIdArray(_simuCtx.getAclfNet(), RunUIUtilFunc.NetIdType.GenInAreaDFactor, 
						this.areaTransfer.getToArea().getAreaNo()).toArray()));
		
    	atMeasBranchList.setModel(new javax.swing.DefaultComboBoxModel(
		    			IpssXmlUtilFunc.getBranchIdAry(areaTransfer.getBranchArray())));

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
		saveEditor2TDFactor();
		saveEditor2AreaTransfer();
		return errMsg.size() == 0;
	}

	public boolean saveEditor2TDFactor() {
		if (tdFactor.getInjectBusList() == null) {  // for converting old version data
			tdFactor.addNewInjectBusList();
			tdFactor.getInjectBusList().addNewInjectBus();
		}
		if ( tdFactor.getInjectBusType() == SenBusAnalysisDataType.SINGLE_BUS) {
			while (tdFactor.getInjectBusList().sizeOfInjectBusArray() > 0)
				tdFactor.getInjectBusList().removeInjectBus(0);
			tdFactor.getInjectBusList().addNewInjectBus();
			tdFactor.getInjectBusList().getInjectBusArray(0).setBusId((String)ptdfInjectBusComboBox.getSelectedItem());
		} 
		else {
			int cnt = ptdfInjectBusComboBox.getItemCount();
			for (int i = 0; i < cnt; i++) {
				BusRecXmlType busRec = tdFactor.getInjectBusList().sizeOfInjectBusArray() > i ?
						tdFactor.getInjectBusList().getInjectBusArray(i) : tdFactor.getInjectBusList().addNewInjectBus();
				busRec.setBusId((String)ptdfInjectBusComboBox.getItemAt(i));
			}
		}
		
		if (ptdfWithSingleBusRadioButton.isSelected()) {
			tdFactor.setWithdrawBusType(SenBusAnalysisDataType.SINGLE_BUS);
			tdFactor.getWithdrawBusList().getWithdrawBusArray(0).setBusId((String)ptdfWithdrawBusComboBox.getSelectedItem());
			tdFactor.getWithdrawBusList().getWithdrawBusArray(0).setPercent(100.0);
		}
		else {	
			tdFactor.setWithdrawBusType(SenBusAnalysisDataType.MULTIPLE_BUS);
		}
		return true;
	}
    
	public boolean saveEditor2AreaTransfer() {
		double amt = new Double(this.atTransAmtTextField.getText()).doubleValue();
		this.areaTransfer.setTransderAmountMW(((String)this.atTransAmtUnitComboBox.getSelectedItem()).equals("MW")?
							amt : amt * _simuCtx.getNetwork().getBaseKva()/1000.0);

		String no = (String)this.atFromAreaComboBox.getSelectedItem();
		this.areaTransfer.getFromArea().setAreaNo(new Integer(no).intValue());
			
		no = (String)this.atToAreaComboBox.getSelectedItem();
		this.areaTransfer.getToArea().setAreaNo(new Integer(no).intValue());

		if (areaTransfer.getInjectBusList() == null)
			 areaTransfer.addNewInjectBusList();
		for(int i = 0; i < atFromAreaBusList.getModel().getSize(); i++) {
			SenAnalysisBusRecXmlType busRec = areaTransfer.getInjectBusList().sizeOfInjectBusArray() > i ?
					areaTransfer.getInjectBusList().getInjectBusArray(i) : areaTransfer.getInjectBusList().addNewInjectBus();
			String elem = (String)atFromAreaBusList.getModel().getElementAt(i);
			busRec.setBusId(RunUIUtilFunc.getId_IdPercent(elem));
			busRec.setPercent(RunUIUtilFunc.getPercent_IdPercent(elem));
		}
		
		if (areaTransfer.getWithdrawBusList() == null)
			 areaTransfer.addNewWithdrawBusList();
		for(int i = 0; i < atToAreaBusList.getModel().getSize(); i++) {
			SenAnalysisBusRecXmlType busRec = areaTransfer.getWithdrawBusList().sizeOfWithdrawBusArray() > i ?
						areaTransfer.getWithdrawBusList().getWithdrawBusArray(i) : areaTransfer.getWithdrawBusList().addNewWithdrawBus();
			String elem = (String)atToAreaBusList.getModel().getElementAt(i);
			busRec.setBusId(RunUIUtilFunc.getId_IdPercent(elem));
			busRec.setPercent(RunUIUtilFunc.getPercent_IdPercent(elem));
		}
		return true;
	}
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        ptdfInjectionBusButtonGroup = new javax.swing.ButtonGroup();
        ptdfInjectButtonGroup = new javax.swing.ButtonGroup();
        ptdfWithdrawBusButtonGroup = new javax.swing.ButtonGroup();
        ptdfWithdrawButtonGroup = new javax.swing.ButtonGroup();
        runDclfTabbedPane = new javax.swing.JTabbedPane();
        ptdfPanel = new javax.swing.JPanel();
        ptdfInjectionPanel = new javax.swing.JPanel();
        ptdfInjBusPanel = new javax.swing.JPanel();
        ptdfSingleInjectBusRadioButton = new javax.swing.JRadioButton();
        ptdfMultiInjectBusRadioButton = new javax.swing.JRadioButton();
        ptdfInjBusSelPanel = new javax.swing.JPanel();
        ptdfInjectBusComboBox = new javax.swing.JComboBox();
        ptdfInjectGenBusRadioButton = new javax.swing.JRadioButton();
        ptdfInjectAllBusRadioButton = new javax.swing.JRadioButton();
        ptdfWithdrawPanel = new javax.swing.JPanel();
        ptdfSingleMultiBusPanel = new javax.swing.JPanel();
        ptdfWithSingleBusRadioButton = new javax.swing.JRadioButton();
        ptdfWithMultiBusRadioButton = new javax.swing.JRadioButton();
        ptdfWithBusSelectPanel = new javax.swing.JPanel();
        ptdfWithdrawBusComboBox = new javax.swing.JComboBox();
        ptdfWithLoadBusRadioButton = new javax.swing.JRadioButton();
        ptdfWithAllBusRadioButton = new javax.swing.JRadioButton();
        ptdfWithMultiBusPanel = new javax.swing.JPanel();
        ptdfWithBusScrollPane = new javax.swing.JScrollPane();
        ptdfWithdarwBusList = new javax.swing.JList();
        ptdfLoadDistFactorLabel = new javax.swing.JLabel();
        ptdfDistFactorTextField = new javax.swing.JTextField();
        ptdfPercentLabel = new javax.swing.JLabel();
        ptdfAddWithBusButton = new javax.swing.JButton();
        ptdfRemoveWithBusButton = new javax.swing.JButton();
        ptdfGenWithBusButton = new javax.swing.JButton();
        ptdfMeasBranchPanel = new javax.swing.JPanel();
        ptdfBranchListComboBox = new javax.swing.JComboBox();
        ptdfAddBranchButton = new javax.swing.JButton();
        ptdfInterfaceListComboBox = new javax.swing.JComboBox();
        ptdfAddInterfaceButton = new javax.swing.JButton();
        ptdfScrollPane = new javax.swing.JScrollPane();
        ptdfMeasBranchList = new javax.swing.JList();
        ptdfRemoveBranchButton = new javax.swing.JButton();
        ptdfCalculateButton = new javax.swing.JButton();
        areaTransPanel = new javax.swing.JPanel();
        atTransAmtLabel = new javax.swing.JLabel();
        atTransAmtTextField = new javax.swing.JTextField();
        atTransAmtUnitComboBox = new javax.swing.JComboBox();
        atFromAreaLabel = new javax.swing.JLabel();
        atFromAreaComboBox = new javax.swing.JComboBox();
        atToAreaLabel = new javax.swing.JLabel();
        atToAreaComboBox = new javax.swing.JComboBox();
        atCalculateButton = new javax.swing.JButton();
        atFromDFPanel = new javax.swing.JPanel();
        atFromAreaScrollPane = new javax.swing.JScrollPane();
        atFromAreaBusList = new javax.swing.JList();
        atFromAreaResetButton = new javax.swing.JButton();
        atFromAreaRemoveButton = new javax.swing.JButton();
        atFromAreaEditButton = new javax.swing.JButton();
        atToDFPanel = new javax.swing.JPanel();
        atToAreaScrollPane = new javax.swing.JScrollPane();
        atToAreaBusList = new javax.swing.JList();
        atToAreaResetButton = new javax.swing.JButton();
        atToAreaRemoveButton = new javax.swing.JButton();
        atToAreaEditButton = new javax.swing.JButton();
        atMeasBranchPanel = new javax.swing.JPanel();
        atBranchListComboBox = new javax.swing.JComboBox();
        atAddBranchButton = new javax.swing.JButton();
        atInterfaceListComboBox = new javax.swing.JComboBox();
        atAddInterfaceButton = new javax.swing.JButton();
        atBranchListScrollPane = new javax.swing.JScrollPane();
        atMeasBranchList = new javax.swing.JList();
        atRemoveBranchButton = new javax.swing.JButton();

        runDclfTabbedPane.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        runDclfTabbedPane.setMinimumSize(new java.awt.Dimension(80, 48));
        runDclfTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                panelSelectionChanged(evt);
            }
        });

        ptdfInjectionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Injection Bus", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12))); // NOI18N
        ptdfInjectionPanel.setLayout(new java.awt.GridBagLayout());

        ptdfInjectButtonGroup.add(ptdfSingleInjectBusRadioButton);
        ptdfSingleInjectBusRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        ptdfSingleInjectBusRadioButton.setSelected(true);
        ptdfSingleInjectBusRadioButton.setText("Single Bus");
        ptdfSingleInjectBusRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptdfSingleInjectBusRadioButtonActionPerformed(evt);
            }
        });
        ptdfInjBusPanel.add(ptdfSingleInjectBusRadioButton);

        ptdfInjectButtonGroup.add(ptdfMultiInjectBusRadioButton);
        ptdfMultiInjectBusRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        ptdfMultiInjectBusRadioButton.setText("All Gen Buses");
        ptdfMultiInjectBusRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptdfMultiInjectBusRadioButtonActionPerformed(evt);
            }
        });
        ptdfInjBusPanel.add(ptdfMultiInjectBusRadioButton);

        ptdfInjectionPanel.add(ptdfInjBusPanel, new java.awt.GridBagConstraints());

        ptdfInjectBusComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        ptdfInjectBusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ptdfInjBusSelPanel.add(ptdfInjectBusComboBox);

        ptdfInjectionBusButtonGroup.add(ptdfInjectGenBusRadioButton);
        ptdfInjectGenBusRadioButton.setFont(new java.awt.Font("Dialog", 0, 10));
        ptdfInjectGenBusRadioButton.setSelected(true);
        ptdfInjectGenBusRadioButton.setText("Gen Buses");
        ptdfInjectGenBusRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptdfInjectGenBusRadioButtonActionPerformed(evt);
            }
        });
        ptdfInjBusSelPanel.add(ptdfInjectGenBusRadioButton);

        ptdfInjectionBusButtonGroup.add(ptdfInjectAllBusRadioButton);
        ptdfInjectAllBusRadioButton.setFont(new java.awt.Font("Dialog", 0, 10));
        ptdfInjectAllBusRadioButton.setText("All Buses");
        ptdfInjectAllBusRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptdfInjectAllBusRadioButtonActionPerformed(evt);
            }
        });
        ptdfInjBusSelPanel.add(ptdfInjectAllBusRadioButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        ptdfInjectionPanel.add(ptdfInjBusSelPanel, gridBagConstraints);

        ptdfWithdrawPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "WithdrawBus(es)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12))); // NOI18N
        ptdfWithdrawPanel.setLayout(new java.awt.GridBagLayout());

        ptdfWithdrawButtonGroup.add(ptdfWithSingleBusRadioButton);
        ptdfWithSingleBusRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        ptdfWithSingleBusRadioButton.setSelected(true);
        ptdfWithSingleBusRadioButton.setText("Single Bus");
        ptdfWithSingleBusRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptdfWithSingleBusRadioButtonActionPerformed(evt);
            }
        });
        ptdfSingleMultiBusPanel.add(ptdfWithSingleBusRadioButton);

        ptdfWithdrawButtonGroup.add(ptdfWithMultiBusRadioButton);
        ptdfWithMultiBusRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        ptdfWithMultiBusRadioButton.setText("Multi-Buses");
        ptdfWithMultiBusRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptdfWithMultiBusRadioButtonActionPerformed(evt);
            }
        });
        ptdfSingleMultiBusPanel.add(ptdfWithMultiBusRadioButton);

        ptdfWithdrawPanel.add(ptdfSingleMultiBusPanel, new java.awt.GridBagConstraints());

        ptdfWithdrawBusComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        ptdfWithdrawBusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ptdfWithBusSelectPanel.add(ptdfWithdrawBusComboBox);

        ptdfWithdrawBusButtonGroup.add(ptdfWithLoadBusRadioButton);
        ptdfWithLoadBusRadioButton.setFont(new java.awt.Font("Dialog", 0, 10));
        ptdfWithLoadBusRadioButton.setSelected(true);
        ptdfWithLoadBusRadioButton.setText("Load ");
        ptdfWithLoadBusRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptdfWithLoadBusRadioButtonActionPerformed(evt);
            }
        });
        ptdfWithBusSelectPanel.add(ptdfWithLoadBusRadioButton);

        ptdfWithdrawBusButtonGroup.add(ptdfWithAllBusRadioButton);
        ptdfWithAllBusRadioButton.setFont(new java.awt.Font("Dialog", 0, 10));
        ptdfWithAllBusRadioButton.setText("All Buses");
        ptdfWithAllBusRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptdfWithAllBusRadioButtonActionPerformed(evt);
            }
        });
        ptdfWithBusSelectPanel.add(ptdfWithAllBusRadioButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        ptdfWithdrawPanel.add(ptdfWithBusSelectPanel, gridBagConstraints);

        ptdfWithdarwBusList.setFont(new java.awt.Font("Dialog", 0, 12));
        ptdfWithdarwBusList.setEnabled(false);
        ptdfWithBusScrollPane.setViewportView(ptdfWithdarwBusList);

        ptdfLoadDistFactorLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        ptdfLoadDistFactorLabel.setText("Load Disttribution Factor");
        ptdfLoadDistFactorLabel.setEnabled(false);

        ptdfDistFactorTextField.setText("100.0");
        ptdfDistFactorTextField.setEnabled(false);

        ptdfPercentLabel.setText("%");
        ptdfPercentLabel.setEnabled(false);

        ptdfAddWithBusButton.setFont(new java.awt.Font("Dialog", 0, 10));
        ptdfAddWithBusButton.setText("Add");
        ptdfAddWithBusButton.setEnabled(false);
        ptdfAddWithBusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptdfAddWithBusButtonActionPerformed(evt);
            }
        });

        ptdfRemoveWithBusButton.setFont(new java.awt.Font("Dialog", 0, 10));
        ptdfRemoveWithBusButton.setText("Remove");
        ptdfRemoveWithBusButton.setEnabled(false);
        ptdfRemoveWithBusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptdfRemoveWithBusButtonActionPerformed(evt);
            }
        });

        ptdfGenWithBusButton.setFont(new java.awt.Font("Dialog", 0, 10));
        ptdfGenWithBusButton.setText("Generate");
        ptdfGenWithBusButton.setEnabled(false);
        ptdfGenWithBusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptdfGenWithBusButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout ptdfWithMultiBusPanelLayout = new org.jdesktop.layout.GroupLayout(ptdfWithMultiBusPanel);
        ptdfWithMultiBusPanel.setLayout(ptdfWithMultiBusPanelLayout);
        ptdfWithMultiBusPanelLayout.setHorizontalGroup(
            ptdfWithMultiBusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(ptdfWithMultiBusPanelLayout.createSequentialGroup()
                .add(ptdfWithMultiBusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(ptdfWithMultiBusPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(ptdfLoadDistFactorLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(ptdfDistFactorTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(ptdfPercentLabel))
                    .add(ptdfWithMultiBusPanelLayout.createSequentialGroup()
                        .add(32, 32, 32)
                        .add(ptdfWithBusScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 133, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(ptdfWithMultiBusPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(ptdfAddWithBusButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(ptdfRemoveWithBusButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(ptdfGenWithBusButton)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ptdfWithMultiBusPanelLayout.setVerticalGroup(
            ptdfWithMultiBusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(ptdfWithMultiBusPanelLayout.createSequentialGroup()
                .add(ptdfWithMultiBusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(ptdfLoadDistFactorLabel)
                    .add(ptdfDistFactorTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(ptdfPercentLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(ptdfWithBusScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(ptdfWithMultiBusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(ptdfAddWithBusButton)
                    .add(ptdfRemoveWithBusButton)
                    .add(ptdfGenWithBusButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        ptdfWithdrawPanel.add(ptdfWithMultiBusPanel, gridBagConstraints);

        ptdfMeasBranchPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Measurement Branches", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12))); // NOI18N

        ptdfBranchListComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        ptdfBranchListComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ptdfAddBranchButton.setFont(new java.awt.Font("Dialog", 0, 10));
        ptdfAddBranchButton.setText("Add Branch");
        ptdfAddBranchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptdfAddBranchButtonActionPerformed(evt);
            }
        });

        ptdfInterfaceListComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        ptdfInterfaceListComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ptdfInterfaceListComboBox.setEnabled(false);

        ptdfAddInterfaceButton.setFont(new java.awt.Font("Dialog", 0, 10));
        ptdfAddInterfaceButton.setText("Add Interface");
        ptdfAddInterfaceButton.setEnabled(false);
        ptdfAddInterfaceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptdfAddInterfaceButtonActionPerformed(evt);
            }
        });

        ptdfMeasBranchList.setFont(new java.awt.Font("Dialog", 0, 12));
        ptdfScrollPane.setViewportView(ptdfMeasBranchList);

        ptdfRemoveBranchButton.setFont(new java.awt.Font("Dialog", 0, 10));
        ptdfRemoveBranchButton.setText("Remove");
        ptdfRemoveBranchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptdfRemoveBranchButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout ptdfMeasBranchPanelLayout = new org.jdesktop.layout.GroupLayout(ptdfMeasBranchPanel);
        ptdfMeasBranchPanel.setLayout(ptdfMeasBranchPanelLayout);
        ptdfMeasBranchPanelLayout.setHorizontalGroup(
            ptdfMeasBranchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(ptdfMeasBranchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(ptdfMeasBranchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(ptdfBranchListComboBox, 0, 138, Short.MAX_VALUE)
                    .add(ptdfScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 138, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(ptdfAddBranchButton)
                    .add(ptdfRemoveBranchButton)
                    .add(ptdfInterfaceListComboBox, 0, 138, Short.MAX_VALUE)
                    .add(ptdfAddInterfaceButton))
                .addContainerGap())
        );
        ptdfMeasBranchPanelLayout.setVerticalGroup(
            ptdfMeasBranchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(ptdfMeasBranchPanelLayout.createSequentialGroup()
                .add(ptdfBranchListComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(ptdfAddBranchButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(ptdfInterfaceListComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(ptdfAddInterfaceButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(ptdfScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 140, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(ptdfRemoveBranchButton)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ptdfCalculateButton.setFont(new java.awt.Font("Dialog", 0, 10));
        ptdfCalculateButton.setText("Calculate");
        ptdfCalculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptdfCalculateButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout ptdfPanelLayout = new org.jdesktop.layout.GroupLayout(ptdfPanel);
        ptdfPanel.setLayout(ptdfPanelLayout);
        ptdfPanelLayout.setHorizontalGroup(
            ptdfPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(ptdfPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(ptdfPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(ptdfWithdrawPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(ptdfInjectionPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(ptdfPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(ptdfPanelLayout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(ptdfMeasBranchPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(ptdfPanelLayout.createSequentialGroup()
                        .add(65, 65, 65)
                        .add(ptdfCalculateButton)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        ptdfPanelLayout.setVerticalGroup(
            ptdfPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(ptdfPanelLayout.createSequentialGroup()
                .add(21, 21, 21)
                .add(ptdfPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(ptdfPanelLayout.createSequentialGroup()
                        .add(ptdfInjectionPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(12, 12, 12)
                        .add(ptdfWithdrawPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(ptdfPanelLayout.createSequentialGroup()
                        .add(ptdfMeasBranchPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(ptdfCalculateButton)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        runDclfTabbedPane.addTab("PTDF Calculation", ptdfPanel);

        areaTransPanel.setEnabled(false);

        atTransAmtLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        atTransAmtLabel.setText("Transfer Amount");

        atTransAmtTextField.setColumns(5);
        atTransAmtTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        atTransAmtTextField.setText("100.0");

        atTransAmtUnitComboBox.setFont(new java.awt.Font("Dialog", 0, 10));
        atTransAmtUnitComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MW", "PU" }));

        atFromAreaLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        atFromAreaLabel.setText("From Area   ");

        atFromAreaComboBox.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        atFromAreaComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        atFromAreaComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atFromAreaComboBoxActionPerformed(evt);
            }
        });

        atToAreaLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        atToAreaLabel.setText("To Area   ");

        atToAreaComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        atToAreaComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        atToAreaComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atToAreaComboBoxActionPerformed(evt);
            }
        });

        atCalculateButton.setFont(new java.awt.Font("Dialog", 0, 10));
        atCalculateButton.setText("Calculate");
        atCalculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atCalculateButtonActionPerformed(evt);
            }
        });

        atFromDFPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "From Area DistFactor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12))); // NOI18N

        atFromAreaBusList.setFont(new java.awt.Font("Dialog", 0, 12));
        atFromAreaScrollPane.setViewportView(atFromAreaBusList);

        atFromAreaResetButton.setFont(new java.awt.Font("Dialog", 0, 10));
        atFromAreaResetButton.setText("Reset");
        atFromAreaResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atFromAreaResetButtonActionPerformed(evt);
            }
        });

        atFromAreaRemoveButton.setFont(new java.awt.Font("Dialog", 0, 10));
        atFromAreaRemoveButton.setText("Remove");
        atFromAreaRemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atFromAreaRemoveButtonActionPerformed(evt);
            }
        });

        atFromAreaEditButton.setFont(new java.awt.Font("Dialog", 0, 10));
        atFromAreaEditButton.setText("Edit");
        atFromAreaEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atFromAreaEditButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout atFromDFPanelLayout = new org.jdesktop.layout.GroupLayout(atFromDFPanel);
        atFromDFPanel.setLayout(atFromDFPanelLayout);
        atFromDFPanelLayout.setHorizontalGroup(
            atFromDFPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(atFromDFPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(atFromAreaScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 133, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(atFromDFPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(atFromAreaRemoveButton)
                    .add(atFromAreaResetButton)
                    .add(atFromAreaEditButton))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        atFromDFPanelLayout.setVerticalGroup(
            atFromDFPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(atFromAreaScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(atFromDFPanelLayout.createSequentialGroup()
                .add(atFromAreaResetButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(atFromAreaRemoveButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(atFromAreaEditButton))
        );

        atToDFPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("To Area DistFactor"));

        atToAreaBusList.setFont(new java.awt.Font("Dialog", 0, 12));
        atToAreaScrollPane.setViewportView(atToAreaBusList);

        atToAreaResetButton.setFont(new java.awt.Font("Dialog", 0, 10));
        atToAreaResetButton.setText("Reset");
        atToAreaResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atToAreaResetButtonActionPerformed(evt);
            }
        });

        atToAreaRemoveButton.setFont(new java.awt.Font("Dialog", 0, 10));
        atToAreaRemoveButton.setText("Remove");
        atToAreaRemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atToAreaRemoveButtonActionPerformed(evt);
            }
        });

        atToAreaEditButton.setFont(new java.awt.Font("Dialog", 0, 10));
        atToAreaEditButton.setText("Edit");
        atToAreaEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atToAreaEditButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout atToDFPanelLayout = new org.jdesktop.layout.GroupLayout(atToDFPanel);
        atToDFPanel.setLayout(atToDFPanelLayout);
        atToDFPanelLayout.setHorizontalGroup(
            atToDFPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, atToDFPanelLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(atToAreaScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 133, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(19, 19, 19)
                .add(atToDFPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(atToAreaRemoveButton)
                    .add(atToAreaResetButton)
                    .add(atToAreaEditButton))
                .addContainerGap())
        );
        atToDFPanelLayout.setVerticalGroup(
            atToDFPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(atToDFPanelLayout.createSequentialGroup()
                .add(atToAreaResetButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(atToAreaRemoveButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(atToAreaEditButton))
            .add(atToAreaScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        atMeasBranchPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Measurement Branches", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12))); // NOI18N

        atBranchListComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        atBranchListComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        atAddBranchButton.setFont(new java.awt.Font("Dialog", 0, 10));
        atAddBranchButton.setText("Add Branch");
        atAddBranchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atAddBranchButtonActionPerformed(evt);
            }
        });

        atInterfaceListComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        atInterfaceListComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        atInterfaceListComboBox.setEnabled(false);

        atAddInterfaceButton.setFont(new java.awt.Font("Dialog", 0, 10));
        atAddInterfaceButton.setText("Add Interface");
        atAddInterfaceButton.setEnabled(false);
        atAddInterfaceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atAddInterfaceButtonActionPerformed(evt);
            }
        });

        atMeasBranchList.setFont(new java.awt.Font("Dialog", 0, 12));
        atBranchListScrollPane.setViewportView(atMeasBranchList);

        atRemoveBranchButton.setFont(new java.awt.Font("Dialog", 0, 10));
        atRemoveBranchButton.setText("Remove");
        atRemoveBranchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atRemoveBranchButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout atMeasBranchPanelLayout = new org.jdesktop.layout.GroupLayout(atMeasBranchPanel);
        atMeasBranchPanel.setLayout(atMeasBranchPanelLayout);
        atMeasBranchPanelLayout.setHorizontalGroup(
            atMeasBranchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(atMeasBranchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(atMeasBranchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(atBranchListComboBox, 0, 138, Short.MAX_VALUE)
                    .add(atBranchListScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 138, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(atAddBranchButton)
                    .add(atRemoveBranchButton)
                    .add(atInterfaceListComboBox, 0, 138, Short.MAX_VALUE)
                    .add(atAddInterfaceButton))
                .addContainerGap())
        );
        atMeasBranchPanelLayout.setVerticalGroup(
            atMeasBranchPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(atMeasBranchPanelLayout.createSequentialGroup()
                .add(atBranchListComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(atAddBranchButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(atInterfaceListComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(atAddInterfaceButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(atBranchListScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 140, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(atRemoveBranchButton)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout areaTransPanelLayout = new org.jdesktop.layout.GroupLayout(areaTransPanel);
        areaTransPanel.setLayout(areaTransPanelLayout);
        areaTransPanelLayout.setHorizontalGroup(
            areaTransPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(areaTransPanelLayout.createSequentialGroup()
                .add(22, 22, 22)
                .add(areaTransPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(areaTransPanelLayout.createSequentialGroup()
                        .add(78, 78, 78)
                        .add(areaTransPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(areaTransPanelLayout.createSequentialGroup()
                                .add(atFromAreaLabel)
                                .add(5, 5, 5)
                                .add(atFromAreaComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(45, 45, 45)
                                .add(atToAreaLabel)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(atToAreaComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(areaTransPanelLayout.createSequentialGroup()
                                .add(atTransAmtLabel)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(atTransAmtTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(atTransAmtUnitComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                    .add(areaTransPanelLayout.createSequentialGroup()
                        .add(areaTransPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(atFromDFPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(atToDFPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(areaTransPanelLayout.createSequentialGroup()
                                .add(90, 90, 90)
                                .add(atCalculateButton)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(atMeasBranchPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        areaTransPanelLayout.setVerticalGroup(
            areaTransPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(areaTransPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(areaTransPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(atTransAmtLabel)
                    .add(atTransAmtTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(atTransAmtUnitComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(areaTransPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(atFromAreaLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .add(atFromAreaComboBox, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .add(atToAreaLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .add(atToAreaComboBox, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
                .add(16, 16, 16)
                .add(areaTransPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(areaTransPanelLayout.createSequentialGroup()
                        .add(atFromDFPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(atToDFPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(26, 26, 26)
                        .add(atCalculateButton))
                    .add(atMeasBranchPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(40, 40, 40))
        );

        runDclfTabbedPane.addTab("Area Transfer Analysis", areaTransPanel);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(runDclfTabbedPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(runDclfTabbedPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
 
    private void panelSelectionChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_panelSelectionChanged
    	if ( runDclfTabbedPane.getSelectedIndex() == 0 )
        	IpssLogger.getLogger().info("Panel selection changed - PTDF Panel");
    	else if ( runDclfTabbedPane.getSelectedIndex() == 1 ) {
        	IpssLogger.getLogger().info("Panel selection changed - Area Transfer Analysis Panel");
    	}	
    }//GEN-LAST:event_panelSelectionChanged

    private void ptdfWithSingleBusRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptdfWithSingleBusRadioButtonActionPerformed
    	setMultiBusWithdrawStatus(false);
    	tdFactor.setWithdrawBusType(SenBusAnalysisDataType.SINGLE_BUS);
    	while (tdFactor.getWithdrawBusList().sizeOfWithdrawBusArray() > 0)
    		tdFactor.getWithdrawBusList().removeWithdrawBus(0);
    	tdFactor.getWithdrawBusList().addNewWithdrawBus();
    	tdFactor.getWithdrawBusList().getWithdrawBusArray(0).setBusId((String)ptdfWithdrawBusComboBox.getSelectedItem());
}//GEN-LAST:event_ptdfWithSingleBusRadioButtonActionPerformed

    private void ptdfRemoveBranchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptdfRemoveBranchButtonActionPerformed
    	tdFactor.removeBranch(ptdfMeasBranchList.getSelectedIndex());
    	ptdfMeasBranchList.setModel(new javax.swing.DefaultComboBoxModel(
    			IpssXmlUtilFunc.getBranchIdAry(tdFactor.getBranchArray())));
}//GEN-LAST:event_ptdfRemoveBranchButtonActionPerformed

    private void ptdfInjectGenBusRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptdfInjectGenBusRadioButtonActionPerformed
		this.ptdfInjectBusComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				RunUIUtilFunc.getIdArray(_simuCtx.getAclfNet(), RunUIUtilFunc.NetIdType.GenBus).toArray()));
}//GEN-LAST:event_ptdfInjectGenBusRadioButtonActionPerformed

    private void ptdfInjectAllBusRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptdfInjectAllBusRadioButtonActionPerformed
		this.ptdfInjectBusComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				RunUIUtilFunc.getIdArray(_simuCtx.getAclfNet(), RunUIUtilFunc.NetIdType.AllBus).toArray()));
}//GEN-LAST:event_ptdfInjectAllBusRadioButtonActionPerformed

    private void ptdfWithMultiBusRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptdfWithMultiBusRadioButtonActionPerformed
    	setMultiBusWithdrawStatus(true);
    	tdFactor.setWithdrawBusType(SenBusAnalysisDataType.MULTIPLE_BUS);
    	if (tdFactor.getWithdrawBusList() == null)
    		tdFactor.addNewWithdrawBusList();
}//GEN-LAST:event_ptdfWithMultiBusRadioButtonActionPerformed

    private void ptdfWithAllBusRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptdfWithAllBusRadioButtonActionPerformed
		this.ptdfWithdrawBusComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				RunUIUtilFunc.getIdArray(_simuCtx.getAclfNet(), RunUIUtilFunc.NetIdType.AllBus).toArray()));
}//GEN-LAST:event_ptdfWithAllBusRadioButtonActionPerformed

    private void ptdfWithLoadBusRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptdfWithLoadBusRadioButtonActionPerformed
		this.ptdfWithdrawBusComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				RunUIUtilFunc.getIdArray(_simuCtx.getAclfNet(), RunUIUtilFunc.NetIdType.LoadBus).toArray()));
}//GEN-LAST:event_ptdfWithLoadBusRadioButtonActionPerformed

    private void ptdfRemoveWithBusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptdfRemoveWithBusButtonActionPerformed
    	tdFactor.getWithdrawBusList().removeWithdrawBus(ptdfWithdarwBusList.getSelectedIndex());
    	ptdfWithdarwBusList.setModel(new javax.swing.DefaultComboBoxModel(
    			IpssXmlUtilFunc.getSenAnalysisBusItemList(tdFactor.getWithdrawBusList().getWithdrawBusArray())));
}//GEN-LAST:event_ptdfRemoveWithBusButtonActionPerformed

    private void ptdfGenWithBusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptdfGenWithBusButtonActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_ptdfGenWithBusButtonActionPerformed

    private void ptdfAddWithBusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptdfAddWithBusButtonActionPerformed
    	String id = (String)ptdfWithdrawBusComboBox.getSelectedItem();
    	double percent = new Double(this.ptdfDistFactorTextField.getText()).doubleValue();
    	SenAnalysisBusRecXmlType bus = tdFactor.getWithdrawBusList().addNewWithdrawBus();
    	bus.setBusId(id);
    	bus.setPercent(percent);
    	ptdfWithdarwBusList.setModel(new javax.swing.DefaultComboBoxModel(
    			IpssXmlUtilFunc.getSenAnalysisBusItemList(tdFactor.getWithdrawBusList().getWithdrawBusArray())));
}//GEN-LAST:event_ptdfAddWithBusButtonActionPerformed

    private void ptdfAddBranchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptdfAddBranchButtonActionPerformed
    	String id = (String)ptdfBranchListComboBox.getSelectedItem();
    	BranchRecXmlType braRec = tdFactor.addNewBranch();
    	IpssXmlUtilFunc.setBranchRec(braRec, id);
    	ptdfMeasBranchList.setModel(new javax.swing.DefaultComboBoxModel(
    			IpssXmlUtilFunc.getBranchIdAry(tdFactor.getBranchArray())));
}//GEN-LAST:event_ptdfAddBranchButtonActionPerformed

    private void ptdfMultiInjectBusRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptdfMultiInjectBusRadioButtonActionPerformed
    	tdFactor.setInjectBusType(SenBusAnalysisDataType.MULTIPLE_BUS);
        ptdfInjectGenBusRadioButtonActionPerformed(null);
    	ptdfInjectAllBusRadioButton.setEnabled(false);
}//GEN-LAST:event_ptdfMultiInjectBusRadioButtonActionPerformed

    private void ptdfSingleInjectBusRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptdfSingleInjectBusRadioButtonActionPerformed
    	tdFactor.setInjectBusType(SenBusAnalysisDataType.SINGLE_BUS);
    	ptdfInjectAllBusRadioButton.setEnabled(true);
}//GEN-LAST:event_ptdfSingleInjectBusRadioButtonActionPerformed

    private void ptdfAddInterfaceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptdfAddInterfaceButtonActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_ptdfAddInterfaceButtonActionPerformed

    private void ptdfCalculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptdfCalculateButtonActionPerformed
    	this.parent.setAlwaysOnTop(false);
    	DclfAlgorithm algo = CoreObjectFactory.createDclfAlgorithm(_simuCtx.getAclfNet());
    	_simuCtx.setDclfAlgorithm(algo);
    	if (!algo.checkCondition(_simuCtx.getMsgHub()))
    		return;
    	if (!saveEditor2TDFactor())
    		return;
    	XmlScriptDclfRun.calPTDistFactor(tdFactor, algo, _simuCtx.getMsgHub());
    	IOutputTextDialog dialog = UISpringAppContext.getOutputTextDialog("Sensitivity Analysis Results");
    	String str = DclfOutFunc.pTransferDistFactorResults(tdFactor, _simuCtx.getDclfAlgorithm(), _simuCtx.getMsgHub());
    	dialog.display(str);
    }//GEN-LAST:event_ptdfCalculateButtonActionPerformed

    private void setMultiBusWithdrawStatus(boolean b) {
        this.ptdfWithdarwBusList.setEnabled(b);
        this.ptdfAddWithBusButton.setEnabled(b);
        this.ptdfRemoveWithBusButton.setEnabled(b);
        this.ptdfGenWithBusButton.setEnabled(b);
        this.ptdfLoadDistFactorLabel.setEnabled(b);
        this.ptdfPercentLabel.setEnabled(b);
        this.ptdfDistFactorTextField.setEnabled(b);
    }

    /*
     * Area Transfer Analysis
     */
    
private void atAddBranchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atAddBranchButtonActionPerformed
	String id = (String)atBranchListComboBox.getSelectedItem();
	BranchRecXmlType braRec = areaTransfer.addNewBranch();
	IpssXmlUtilFunc.setBranchRec(braRec, id);
	atMeasBranchList.setModel(new javax.swing.DefaultComboBoxModel(
			IpssXmlUtilFunc.getBranchIdAry(areaTransfer.getBranchArray())));
}//GEN-LAST:event_atAddBranchButtonActionPerformed

private void atAddInterfaceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atAddInterfaceButtonActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_atAddInterfaceButtonActionPerformed

private void atRemoveBranchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atRemoveBranchButtonActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_atRemoveBranchButtonActionPerformed

private void atFromAreaResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atFromAreaResetButtonActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_atFromAreaResetButtonActionPerformed

private void atFromAreaRemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atFromAreaRemoveButtonActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_atFromAreaRemoveButtonActionPerformed

private void atFromAreaEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atFromAreaEditButtonActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_atFromAreaEditButtonActionPerformed

private void atToAreaResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atToAreaResetButtonActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_atToAreaResetButtonActionPerformed

private void atToAreaRemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atToAreaRemoveButtonActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_atToAreaRemoveButtonActionPerformed

private void atToAreaEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atToAreaEditButtonActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_atToAreaEditButtonActionPerformed

private void atCalculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atCalculateButtonActionPerformed
	this.parent.setAlwaysOnTop(false);
	DclfAlgorithm algo = CoreObjectFactory.createDclfAlgorithm(_simuCtx.getAclfNet());
	_simuCtx.setDclfAlgorithm(algo);
	if (!algo.checkCondition(_simuCtx.getMsgHub()))
		return;
	if (!saveEditor2AreaTransfer())
		return;
	XmlScriptDclfRun.calAreaTransferFactor(areaTransfer, algo, _simuCtx.getMsgHub());
	IOutputTextDialog dialog = UISpringAppContext.getOutputTextDialog("Area Transfer Analysis Results");
	String str = DclfOutFunc.areaTransferAnalysisResults(areaTransfer, _simuCtx.getDclfAlgorithm(), _simuCtx.getMsgHub());
	dialog.display(str);
}//GEN-LAST:event_atCalculateButtonActionPerformed

private void atFromAreaComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atFromAreaComboBoxActionPerformed
	String no = (String)this.atFromAreaComboBox.getSelectedItem();
	this.areaTransfer.getFromArea().setAreaNo(new Integer(no).intValue());
	atFromAreaBusList.setModel(new javax.swing.DefaultComboBoxModel(
			RunUIUtilFunc.getIdArray(_simuCtx.getAclfNet(), RunUIUtilFunc.NetIdType.GenInAreaDFactor, 
					this.areaTransfer.getFromArea().getAreaNo()).toArray()));
}//GEN-LAST:event_atFromAreaComboBoxActionPerformed

private void atToAreaComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atToAreaComboBoxActionPerformed
	String no = (String)this.atToAreaComboBox.getSelectedItem();
	this.areaTransfer.getToArea().setAreaNo(new Integer(no).intValue());
	atToAreaBusList.setModel(new javax.swing.DefaultComboBoxModel(
			RunUIUtilFunc.getIdArray(_simuCtx.getAclfNet(), RunUIUtilFunc.NetIdType.GenInAreaDFactor, 
					this.areaTransfer.getToArea().getAreaNo()).toArray()));
}//GEN-LAST:event_atToAreaComboBoxActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel areaTransPanel;
    private javax.swing.JButton atAddBranchButton;
    private javax.swing.JButton atAddInterfaceButton;
    private javax.swing.JComboBox atBranchListComboBox;
    private javax.swing.JScrollPane atBranchListScrollPane;
    private javax.swing.JButton atCalculateButton;
    private javax.swing.JList atFromAreaBusList;
    private javax.swing.JComboBox atFromAreaComboBox;
    private javax.swing.JButton atFromAreaEditButton;
    private javax.swing.JLabel atFromAreaLabel;
    private javax.swing.JButton atFromAreaRemoveButton;
    private javax.swing.JButton atFromAreaResetButton;
    private javax.swing.JScrollPane atFromAreaScrollPane;
    private javax.swing.JPanel atFromDFPanel;
    private javax.swing.JComboBox atInterfaceListComboBox;
    private javax.swing.JList atMeasBranchList;
    private javax.swing.JPanel atMeasBranchPanel;
    private javax.swing.JButton atRemoveBranchButton;
    private javax.swing.JList atToAreaBusList;
    private javax.swing.JComboBox atToAreaComboBox;
    private javax.swing.JButton atToAreaEditButton;
    private javax.swing.JLabel atToAreaLabel;
    private javax.swing.JButton atToAreaRemoveButton;
    private javax.swing.JButton atToAreaResetButton;
    private javax.swing.JScrollPane atToAreaScrollPane;
    private javax.swing.JPanel atToDFPanel;
    private javax.swing.JLabel atTransAmtLabel;
    private javax.swing.JTextField atTransAmtTextField;
    private javax.swing.JComboBox atTransAmtUnitComboBox;
    private javax.swing.JButton ptdfAddBranchButton;
    private javax.swing.JButton ptdfAddInterfaceButton;
    private javax.swing.JButton ptdfAddWithBusButton;
    private javax.swing.JComboBox ptdfBranchListComboBox;
    private javax.swing.JButton ptdfCalculateButton;
    private javax.swing.JTextField ptdfDistFactorTextField;
    private javax.swing.JButton ptdfGenWithBusButton;
    private javax.swing.JPanel ptdfInjBusPanel;
    private javax.swing.JPanel ptdfInjBusSelPanel;
    private javax.swing.JRadioButton ptdfInjectAllBusRadioButton;
    private javax.swing.JComboBox ptdfInjectBusComboBox;
    private javax.swing.ButtonGroup ptdfInjectButtonGroup;
    private javax.swing.JRadioButton ptdfInjectGenBusRadioButton;
    private javax.swing.ButtonGroup ptdfInjectionBusButtonGroup;
    private javax.swing.JPanel ptdfInjectionPanel;
    private javax.swing.JComboBox ptdfInterfaceListComboBox;
    private javax.swing.JLabel ptdfLoadDistFactorLabel;
    private javax.swing.JList ptdfMeasBranchList;
    private javax.swing.JPanel ptdfMeasBranchPanel;
    private javax.swing.JRadioButton ptdfMultiInjectBusRadioButton;
    private javax.swing.JPanel ptdfPanel;
    private javax.swing.JLabel ptdfPercentLabel;
    private javax.swing.JButton ptdfRemoveBranchButton;
    private javax.swing.JButton ptdfRemoveWithBusButton;
    private javax.swing.JScrollPane ptdfScrollPane;
    private javax.swing.JRadioButton ptdfSingleInjectBusRadioButton;
    private javax.swing.JPanel ptdfSingleMultiBusPanel;
    private javax.swing.JRadioButton ptdfWithAllBusRadioButton;
    private javax.swing.JScrollPane ptdfWithBusScrollPane;
    private javax.swing.JPanel ptdfWithBusSelectPanel;
    private javax.swing.JRadioButton ptdfWithLoadBusRadioButton;
    private javax.swing.JPanel ptdfWithMultiBusPanel;
    private javax.swing.JRadioButton ptdfWithMultiBusRadioButton;
    private javax.swing.JRadioButton ptdfWithSingleBusRadioButton;
    private javax.swing.JList ptdfWithdarwBusList;
    private javax.swing.ButtonGroup ptdfWithdrawBusButtonGroup;
    private javax.swing.JComboBox ptdfWithdrawBusComboBox;
    private javax.swing.ButtonGroup ptdfWithdrawButtonGroup;
    private javax.swing.JPanel ptdfWithdrawPanel;
    private javax.swing.JTabbedPane runDclfTabbedPane;
    // End of variables declaration//GEN-END:variables
    
	class DataVerifier extends javax.swing.InputVerifier {
		public boolean verify(javax.swing.JComponent input) {
			if (input == null)
				return false;
			return true;
		}
	}
}
