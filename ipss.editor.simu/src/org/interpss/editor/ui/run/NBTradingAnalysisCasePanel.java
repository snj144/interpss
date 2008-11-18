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
import org.interpss.schema.AreaTransferAnalysisXmlType;
import org.interpss.schema.BranchRecXmlType;
import org.interpss.schema.DclfStudyCaseXmlType;
import org.interpss.schema.SenAnalysisBusRecXmlType;
import org.interpss.xml.IpssXmlUtilFunc;
import org.interpss.xml.StudyCaseHanlder;

import com.interpss.common.exp.InvalidOperationException;
import com.interpss.common.msg.IpssMessage;
import com.interpss.common.msg.IpssMsgListener;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.dclf.DclfAlgorithm;
import com.interpss.simu.SimuContext;

public class NBTradingAnalysisCasePanel extends javax.swing.JPanel implements IFormDataPanel, IpssMsgListener {
	private static final long serialVersionUID = 1;
	private JDialog parent;
	
    // private GFormContainer _netContainer = null;
    private SimuContext _simuCtx = null;

    // holds the current case data being edited
	private AreaTransferAnalysisXmlType areaTransfer = null;;
    
    /** Creates new form NBAclfCasePanel */
    public NBTradingAnalysisCasePanel(JDialog parent) {
    	initComponents();
    	this.parent = parent;

        //DataVerifier verifier = new DataVerifier();
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
		
		if (!setAreaTransfer2Editor())
			return false;
		
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

		if (this.areaTransfer.getDeratingFactor() != 0.0)
			atDeratingFactorTextField.setText(String.format("%4.2f", this.areaTransfer.getDeratingFactor()));
		else
			atDeratingFactorTextField.setText("1.00");
			
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

    	atFromDFactorEditTextField.setEnabled(false);
    	atFromAreaUpdateButton.setEnabled(false);
    	atToDFactorEditTextField.setEnabled(false);
    	atToAreaUpdateButton.setEnabled(false);

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
		saveEditor2AreaTransfer();
		return errMsg.size() == 0;
	}

	public boolean saveEditor2AreaTransfer() {
		double amt = new Double(this.atTransAmtTextField.getText()).doubleValue();
		this.areaTransfer.setTransderAmountMW(((String)this.atTransAmtUnitComboBox.getSelectedItem()).equals("MW")?
							amt : amt * _simuCtx.getNetwork().getBaseKva()/1000.0);

		String no = (String)this.atFromAreaComboBox.getSelectedItem();
		this.areaTransfer.getFromArea().setAreaNo(new Integer(no).intValue());
			
		no = (String)this.atToAreaComboBox.getSelectedItem();
		this.areaTransfer.getToArea().setAreaNo(new Integer(no).intValue());

		this.areaTransfer.setDeratingFactor(
				new Double(atDeratingFactorTextField.getText()).doubleValue());

		saveFromAreaBusList2AreaTransfer();
		saveToAreaBusList2AreaTransfer();

		return true;
	}

	private void saveFromAreaBusList2AreaTransfer() {
		areaTransfer.setInjectBusList(null);
		areaTransfer.addNewInjectBusList();
		for(int i = 0; i < atFromAreaBusList.getModel().getSize(); i++) {
			SenAnalysisBusRecXmlType busRec = areaTransfer.getInjectBusList().addNewInjectBus();
			String elem = (String)atFromAreaBusList.getModel().getElementAt(i);
			busRec.setBusId(RunUIUtilFunc.getId_IdPercent(elem));
			busRec.setPercent(RunUIUtilFunc.getPercent_IdPercent(elem));
		}
	}
	
	private void saveToAreaBusList2AreaTransfer() {
		areaTransfer.setWithdrawBusList(null);
		areaTransfer.addNewWithdrawBusList();
		for(int i = 0; i < atToAreaBusList.getModel().getSize(); i++) {
			SenAnalysisBusRecXmlType busRec = areaTransfer.getWithdrawBusList().addNewWithdrawBus();
			String elem = (String)atToAreaBusList.getModel().getElementAt(i);
			busRec.setBusId(RunUIUtilFunc.getId_IdPercent(elem));
			busRec.setPercent(RunUIUtilFunc.getPercent_IdPercent(elem));
		}
	}
	
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tradingTypeButtonGroup = new javax.swing.ButtonGroup();
        atTradeLabel = new javax.swing.JLabel();
        atTradeComboBox = new javax.swing.JComboBox();
        atTradeAddButton = new javax.swing.JButton();
        atTradeDeleteButton = new javax.swing.JButton();
        zonalRadioButton = new javax.swing.JRadioButton();
        nodalRadioButton = new javax.swing.JRadioButton();
        atInfoEditPanel = new javax.swing.JPanel();
        atTransAmtLabel = new javax.swing.JLabel();
        atTransAmtTextField = new javax.swing.JTextField();
        atTransAmtUnitComboBox = new javax.swing.JComboBox();
        atFromAreaLabel = new javax.swing.JLabel();
        atFromAreaComboBox = new javax.swing.JComboBox();
        atToAreaLabel = new javax.swing.JLabel();
        atToAreaComboBox = new javax.swing.JComboBox();
        atDeratingFactorLabel = new javax.swing.JLabel();
        atDeratingFactorTextField = new javax.swing.JTextField();
        atFromDFPanel = new javax.swing.JPanel();
        atFromAreaScrollPane = new javax.swing.JScrollPane();
        atFromAreaBusList = new javax.swing.JList();
        atFromAreaUpdateButton = new javax.swing.JButton();
        atFromDFactorEditTextField = new javax.swing.JTextField();
        atFromAreaEditButton = new javax.swing.JButton();
        atFromAreaRemoveButton = new javax.swing.JButton();
        atToDFPanel = new javax.swing.JPanel();
        atToAreaScrollPane = new javax.swing.JScrollPane();
        atToAreaBusList = new javax.swing.JList();
        atToAreaEditButton = new javax.swing.JButton();
        atToDFactorEditTextField = new javax.swing.JTextField();
        atToAreaUpdateButton = new javax.swing.JButton();
        atToAreaRemoveButton = new javax.swing.JButton();
        atMeasBranchPanel = new javax.swing.JPanel();
        atBranchListComboBox = new javax.swing.JComboBox();
        atAddBranchButton = new javax.swing.JButton();
        atInterfaceListComboBox = new javax.swing.JComboBox();
        atAddInterfaceButton = new javax.swing.JButton();
        atBranchListScrollPane = new javax.swing.JScrollPane();
        atMeasBranchList = new javax.swing.JList();
        atRemoveBranchButton = new javax.swing.JButton();
        atCalculateButton = new javax.swing.JButton();
        atAclfCalculateButton = new javax.swing.JButton();
        atSeAssessButton = new javax.swing.JButton();

        atTradeLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        atTradeLabel.setText("Trade");

        atTradeComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        atTradeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        atTradeComboBox.setEnabled(false);
        atTradeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atTradeComboBoxActionPerformed(evt);
            }
        });

        atTradeAddButton.setFont(new java.awt.Font("Dialog", 0, 10));
        atTradeAddButton.setText("Add");
        atTradeAddButton.setEnabled(false);
        atTradeAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atTradeAddButtonActionPerformed(evt);
            }
        });

        atTradeDeleteButton.setFont(new java.awt.Font("Dialog", 0, 10));
        atTradeDeleteButton.setText("Delete");
        atTradeDeleteButton.setEnabled(false);
        atTradeDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atTradeDeleteButtonActionPerformed(evt);
            }
        });

        tradingTypeButtonGroup.add(zonalRadioButton);
        zonalRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        zonalRadioButton.setSelected(true);
        zonalRadioButton.setText("Zonal");

        tradingTypeButtonGroup.add(nodalRadioButton);
        nodalRadioButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        nodalRadioButton.setText("Nodal");

        atTransAmtLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        atTransAmtLabel.setText("Transfer Amount");

        atTransAmtTextField.setColumns(5);
        atTransAmtTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        atTransAmtTextField.setText("100.0");

        atTransAmtUnitComboBox.setFont(new java.awt.Font("Dialog", 0, 10));
        atTransAmtUnitComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MW", "PU" }));

        atFromAreaLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        atFromAreaLabel.setText("From Area   ");

        atFromAreaComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        atFromAreaComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1" }));
        atFromAreaComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atFromAreaComboBoxActionPerformed(evt);
            }
        });

        atToAreaLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        atToAreaLabel.setText("To Area   ");

        atToAreaComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        atToAreaComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1" }));
        atToAreaComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atToAreaComboBoxActionPerformed(evt);
            }
        });

        atDeratingFactorLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        atDeratingFactorLabel.setText("Derating Factor");

        atDeratingFactorTextField.setColumns(3);
        atDeratingFactorTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        atDeratingFactorTextField.setText("1.00");

        atFromDFPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "From Area DistFactor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12))); // NOI18N

        atFromAreaBusList.setFont(new java.awt.Font("Dialog", 0, 12));
        atFromAreaScrollPane.setViewportView(atFromAreaBusList);

        atFromAreaUpdateButton.setFont(new java.awt.Font("Dialog", 0, 10));
        atFromAreaUpdateButton.setText("U");
        atFromAreaUpdateButton.setMargin(new java.awt.Insets(2, 4, 2, 4));
        atFromAreaUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atFromAreaUpdateButtonActionPerformed(evt);
            }
        });

        atFromDFactorEditTextField.setColumns(5);
        atFromDFactorEditTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        atFromDFactorEditTextField.setText("100.0");

        atFromAreaEditButton.setFont(new java.awt.Font("Dialog", 0, 10));
        atFromAreaEditButton.setText("Edit");
        atFromAreaEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atFromAreaEditButtonActionPerformed(evt);
            }
        });

        atFromAreaRemoveButton.setFont(new java.awt.Font("Dialog", 0, 10));
        atFromAreaRemoveButton.setText("Remove");
        atFromAreaRemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atFromAreaRemoveButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout atFromDFPanelLayout = new org.jdesktop.layout.GroupLayout(atFromDFPanel);
        atFromDFPanel.setLayout(atFromDFPanelLayout);
        atFromDFPanelLayout.setHorizontalGroup(
            atFromDFPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(atFromDFPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(atFromAreaScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 133, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(atFromDFPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(atFromDFPanelLayout.createSequentialGroup()
                        .add(atFromDFactorEditTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(atFromAreaUpdateButton))
                    .add(atFromAreaRemoveButton)
                    .add(atFromAreaEditButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        atFromDFPanelLayout.setVerticalGroup(
            atFromDFPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(atFromAreaScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(atFromDFPanelLayout.createSequentialGroup()
                .add(atFromDFPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(atFromDFPanelLayout.createSequentialGroup()
                        .add(atFromAreaEditButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(atFromDFactorEditTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(atFromAreaUpdateButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(atFromAreaRemoveButton))
        );

        atToDFPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("To Area DistFactor"));

        atToAreaBusList.setFont(new java.awt.Font("Dialog", 0, 12));
        atToAreaScrollPane.setViewportView(atToAreaBusList);

        atToAreaEditButton.setFont(new java.awt.Font("Dialog", 0, 10));
        atToAreaEditButton.setText("Edit");
        atToAreaEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atToAreaEditButtonActionPerformed(evt);
            }
        });

        atToDFactorEditTextField.setColumns(5);
        atToDFactorEditTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        atToDFactorEditTextField.setText("100.0");

        atToAreaUpdateButton.setFont(new java.awt.Font("Dialog", 0, 10));
        atToAreaUpdateButton.setText("U");
        atToAreaUpdateButton.setMargin(new java.awt.Insets(2, 4, 2, 4));
        atToAreaUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atToAreaUpdateButtonActionPerformed(evt);
            }
        });

        atToAreaRemoveButton.setFont(new java.awt.Font("Dialog", 0, 10));
        atToAreaRemoveButton.setText("Remove");
        atToAreaRemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atToAreaRemoveButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout atToDFPanelLayout = new org.jdesktop.layout.GroupLayout(atToDFPanel);
        atToDFPanel.setLayout(atToDFPanelLayout);
        atToDFPanelLayout.setHorizontalGroup(
            atToDFPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, atToDFPanelLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(atToAreaScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 133, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(atToDFPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(atToAreaEditButton)
                    .add(atToDFPanelLayout.createSequentialGroup()
                        .add(atToDFactorEditTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(atToAreaUpdateButton))
                    .add(atToAreaRemoveButton))
                .addContainerGap())
        );
        atToDFPanelLayout.setVerticalGroup(
            atToDFPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(atToDFPanelLayout.createSequentialGroup()
                .add(atToDFPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(atToAreaScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(atToDFPanelLayout.createSequentialGroup()
                        .add(atToAreaEditButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(atToDFPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(atToDFactorEditTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(atToAreaUpdateButton))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(atToAreaRemoveButton)))
                .addContainerGap())
        );

        atMeasBranchPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Meas Branch/Interface", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12))); // NOI18N

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

        atAddInterfaceButton.setFont(new java.awt.Font("Dialog", 0, 10));
        atAddInterfaceButton.setText("Add Interface");
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
                    .add(atBranchListScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 138, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(atBranchListComboBox, 0, 138, Short.MAX_VALUE)
                    .add(atAddBranchButton)
                    .add(atInterfaceListComboBox, 0, 138, Short.MAX_VALUE)
                    .add(atAddInterfaceButton)
                    .add(atRemoveBranchButton))
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
                .add(atBranchListScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 128, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(atRemoveBranchButton)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout atInfoEditPanelLayout = new org.jdesktop.layout.GroupLayout(atInfoEditPanel);
        atInfoEditPanel.setLayout(atInfoEditPanelLayout);
        atInfoEditPanelLayout.setHorizontalGroup(
            atInfoEditPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(atInfoEditPanelLayout.createSequentialGroup()
                .add(atInfoEditPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(atInfoEditPanelLayout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(atInfoEditPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(atToDFPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(atFromDFPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(atInfoEditPanelLayout.createSequentialGroup()
                        .add(53, 53, 53)
                        .add(atDeratingFactorLabel)
                        .add(29, 29, 29)
                        .add(atDeratingFactorTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(atMeasBranchPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(atInfoEditPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(atTransAmtLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(atTransAmtTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(atTransAmtUnitComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 36, Short.MAX_VALUE)
                .add(atFromAreaLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(atFromAreaComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(atToAreaLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(atToAreaComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(17, 17, 17))
        );
        atInfoEditPanelLayout.setVerticalGroup(
            atInfoEditPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, atInfoEditPanelLayout.createSequentialGroup()
                .add(atInfoEditPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(atTransAmtLabel)
                    .add(atTransAmtTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(atTransAmtUnitComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(atFromAreaLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .add(atFromAreaComboBox)
                    .add(atToAreaLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .add(atToAreaComboBox))
                .add(6, 6, 6)
                .add(atInfoEditPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(atMeasBranchPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(atInfoEditPanelLayout.createSequentialGroup()
                        .add(atInfoEditPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(atDeratingFactorLabel)
                            .add(atDeratingFactorTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(atFromDFPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 129, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(atToDFPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(11, 11, 11))
        );

        atCalculateButton.setFont(new java.awt.Font("Dialog", 0, 10));
        atCalculateButton.setText("Calculate");
        atCalculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atCalculateButtonActionPerformed(evt);
            }
        });

        atAclfCalculateButton.setFont(new java.awt.Font("Dialog", 0, 10));
        atAclfCalculateButton.setText("AC Loadflow");
        atAclfCalculateButton.setEnabled(false);
        atAclfCalculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atAclfCalculateButtonActionPerformed(evt);
            }
        });

        atSeAssessButton.setFont(new java.awt.Font("Dialog", 0, 10));
        atSeAssessButton.setText("Sec Assess");
        atSeAssessButton.setEnabled(false);
        atSeAssessButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atSeAssessButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(31, 31, 31)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(atInfoEditPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(atTradeLabel)
                        .add(18, 18, 18)
                        .add(atTradeComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(atTradeAddButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(atTradeDeleteButton)
                        .add(18, 18, 18)
                        .add(zonalRadioButton)
                        .add(12, 12, 12)
                        .add(nodalRadioButton)))
                .addContainerGap(25, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(143, Short.MAX_VALUE)
                .add(atCalculateButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(atAclfCalculateButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(atSeAssessButton)
                .add(111, 111, 111))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(14, 14, 14)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(nodalRadioButton)
                        .add(atTradeDeleteButton)
                        .add(zonalRadioButton))
                    .add(atTradeLabel)
                    .add(atTradeComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(atTradeAddButton))
                .add(18, 18, 18)
                .add(atInfoEditPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(atSeAssessButton)
                    .add(atAclfCalculateButton)
                    .add(atCalculateButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
 
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
	if (!atMeasBranchList.isSelectionEmpty()) {
		areaTransfer.removeBranch(atMeasBranchList.getSelectedIndex());
		atMeasBranchList.setModel(new javax.swing.DefaultComboBoxModel(
				IpssXmlUtilFunc.getBranchIdAry(areaTransfer.getBranchArray())));
	}
}//GEN-LAST:event_atRemoveBranchButtonActionPerformed

private void atFromAreaRemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atFromAreaRemoveButtonActionPerformed
	if (!atFromAreaBusList.isSelectionEmpty()) {
		areaTransfer.getInjectBusList().removeInjectBus(atFromAreaBusList.getSelectedIndex());
		atFromAreaBusList.setModel(new javax.swing.DefaultComboBoxModel(
				IpssXmlUtilFunc.getSenAnalysisBusItemList(areaTransfer.getInjectBusList().getInjectBusArray())));
	}
}//GEN-LAST:event_atFromAreaRemoveButtonActionPerformed

private void atToAreaRemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atToAreaRemoveButtonActionPerformed
	if (!atToAreaBusList.isSelectionEmpty()) {
		areaTransfer.getWithdrawBusList().removeWithdrawBus(atToAreaBusList.getSelectedIndex());
		atToAreaBusList.setModel(new javax.swing.DefaultComboBoxModel(
				IpssXmlUtilFunc.getSenAnalysisBusItemList(areaTransfer.getWithdrawBusList().getWithdrawBusArray())));
	}
}//GEN-LAST:event_atToAreaRemoveButtonActionPerformed

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

private void atFromAreaEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atFromAreaEditButtonActionPerformed
	if (!atFromAreaBusList.isSelectionEmpty()) {
		atFromDFactorEditTextField.setEnabled(true);
		atFromAreaUpdateButton.setEnabled(true);
		String s = (String)atFromAreaBusList.getSelectedValue();
		atFromDFactorEditTextField.setText(new Double(RunUIUtilFunc.getPercent_IdPercent(s)).toString());
	}
	}//GEN-LAST:event_atFromAreaEditButtonActionPerformed

private void atFromAreaUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atFromAreaUpdateButtonActionPerformed
	if (!atFromAreaBusList.isSelectionEmpty()) {
		// the Bus list might have been changed due to changing the area number
		saveFromAreaBusList2AreaTransfer();
		double percent = new Double(atFromDFactorEditTextField.getText()).doubleValue();
		String s = (String)atFromAreaBusList.getSelectedValue();
		String id = RunUIUtilFunc.getId_IdPercent(s);
		SenAnalysisBusRecXmlType bus = (SenAnalysisBusRecXmlType)IpssXmlUtilFunc.getBusRecord(id, areaTransfer.getInjectBusList().getInjectBusArray());
		bus.setPercent(percent);
		atFromAreaBusList.setModel(new javax.swing.DefaultComboBoxModel(
    			IpssXmlUtilFunc.getSenAnalysisBusItemList(areaTransfer.getInjectBusList().getInjectBusArray())));
		atFromDFactorEditTextField.setEnabled(false);
		atFromAreaUpdateButton.setEnabled(false);
	}
}//GEN-LAST:event_atFromAreaUpdateButtonActionPerformed

private void atToAreaEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atToAreaEditButtonActionPerformed
	if (!atToAreaBusList.isSelectionEmpty()) {
		atToDFactorEditTextField.setEnabled(true);
		atToAreaUpdateButton.setEnabled(true);
		String s = (String)atToAreaBusList.getSelectedValue();
		atToDFactorEditTextField.setText(new Double(RunUIUtilFunc.getPercent_IdPercent(s)).toString());
	}
	}//GEN-LAST:event_atToAreaEditButtonActionPerformed

private void atToAreaUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atToAreaUpdateButtonActionPerformed
	if (!atToAreaBusList.isSelectionEmpty()) {
		// the Bus list might have been changed due to changing the area number
		saveToAreaBusList2AreaTransfer();
		double percent = new Double(atToDFactorEditTextField.getText()).doubleValue();
		String s = (String)atToAreaBusList.getSelectedValue();
		String id = RunUIUtilFunc.getId_IdPercent(s);
		SenAnalysisBusRecXmlType bus = (SenAnalysisBusRecXmlType)IpssXmlUtilFunc.getBusRecord(id, 
						areaTransfer.getWithdrawBusList().getWithdrawBusArray());
		bus.setPercent(percent);
		atToAreaBusList.setModel(new javax.swing.DefaultComboBoxModel(
	    			IpssXmlUtilFunc.getSenAnalysisBusItemList(areaTransfer.getWithdrawBusList().getWithdrawBusArray())));
		atToDFactorEditTextField.setEnabled(false);
		atToAreaUpdateButton.setEnabled(false);
	}
}//GEN-LAST:event_atToAreaUpdateButtonActionPerformed

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

private void atAclfCalculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atAclfCalculateButtonActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_atAclfCalculateButtonActionPerformed

private void atSeAssessButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atSeAssessButtonActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_atSeAssessButtonActionPerformed

private void atTradeAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atTradeAddButtonActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_atTradeAddButtonActionPerformed

private void atTradeDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atTradeDeleteButtonActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_atTradeDeleteButtonActionPerformed

private void atTradeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atTradeComboBoxActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_atTradeComboBoxActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atAclfCalculateButton;
    private javax.swing.JButton atAddBranchButton;
    private javax.swing.JButton atAddInterfaceButton;
    private javax.swing.JComboBox atBranchListComboBox;
    private javax.swing.JScrollPane atBranchListScrollPane;
    private javax.swing.JButton atCalculateButton;
    private javax.swing.JLabel atDeratingFactorLabel;
    private javax.swing.JTextField atDeratingFactorTextField;
    private javax.swing.JList atFromAreaBusList;
    private javax.swing.JComboBox atFromAreaComboBox;
    private javax.swing.JButton atFromAreaEditButton;
    private javax.swing.JLabel atFromAreaLabel;
    private javax.swing.JButton atFromAreaRemoveButton;
    private javax.swing.JScrollPane atFromAreaScrollPane;
    private javax.swing.JButton atFromAreaUpdateButton;
    private javax.swing.JPanel atFromDFPanel;
    private javax.swing.JTextField atFromDFactorEditTextField;
    private javax.swing.JPanel atInfoEditPanel;
    private javax.swing.JComboBox atInterfaceListComboBox;
    private javax.swing.JList atMeasBranchList;
    private javax.swing.JPanel atMeasBranchPanel;
    private javax.swing.JButton atRemoveBranchButton;
    private javax.swing.JButton atSeAssessButton;
    private javax.swing.JList atToAreaBusList;
    private javax.swing.JComboBox atToAreaComboBox;
    private javax.swing.JButton atToAreaEditButton;
    private javax.swing.JLabel atToAreaLabel;
    private javax.swing.JButton atToAreaRemoveButton;
    private javax.swing.JScrollPane atToAreaScrollPane;
    private javax.swing.JButton atToAreaUpdateButton;
    private javax.swing.JPanel atToDFPanel;
    private javax.swing.JTextField atToDFactorEditTextField;
    private javax.swing.JButton atTradeAddButton;
    private javax.swing.JComboBox atTradeComboBox;
    private javax.swing.JButton atTradeDeleteButton;
    private javax.swing.JLabel atTradeLabel;
    private javax.swing.JLabel atTransAmtLabel;
    private javax.swing.JTextField atTransAmtTextField;
    private javax.swing.JComboBox atTransAmtUnitComboBox;
    private javax.swing.JRadioButton nodalRadioButton;
    private javax.swing.ButtonGroup tradingTypeButtonGroup;
    private javax.swing.JRadioButton zonalRadioButton;
    // End of variables declaration//GEN-END:variables
    
	class DataVerifier extends javax.swing.InputVerifier {
		public boolean verify(javax.swing.JComponent input) {
			if (input == null)
				return false;
			return true;
		}
	}
}
