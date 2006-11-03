 /*
  * @(#)NBIeeeST1GovernorEditPanel.java   
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

package org.interpss.dstab.control.gov.ieee.ieeeST1;

import java.util.Vector;

import com.interpss.common.ui.IControllerEditor;
import com.interpss.common.ui.SwingInputVerifyUtil;
import com.interpss.common.util.Num2Str;
import com.interpss.dstab.controller.AbstractGovernor;


public class NBIeeeST1GovernorEditPanel extends javax.swing.JPanel implements IControllerEditor {
	private static final long serialVersionUID = 1;
	
	IeeeST1GovernorData _data;

    /** Creates new form FaultLocDataPanel */
    public NBIeeeST1GovernorEditPanel() {
        initComponents();

  		DataVerifier verifier = new DataVerifier();
  	    rTextField.setInputVerifier(verifier);
  	    fpTextField.setInputVerifier(verifier);
  	    t1TextField.setInputVerifier(verifier);
  	    t2TextField.setInputVerifier(verifier);
  	    t3TextField.setInputVerifier(verifier);
  	    t4TextField.setInputVerifier(verifier);
  	    pmaxTextField.setInputVerifier(verifier);
  	    pminTextField.setInputVerifier(verifier);
  	}
    
	public void init(Object controller) {
		_data = ((IeeeST1Governor)controller).getData();
	}
	
	/**
	*	Set form data to the editor
	*
	* @return false if there is any problem
	*/
    public boolean setData2Editor() {
    	if (_data.getOptMode() == AbstractGovernor.DroopMode) 
    	    droopRadioButton.setSelected(true);
    	else
    	    isochRadioButton.setSelected(true);
  	    rTextField.setText(Num2Str.toStr(_data.getR(), "#0.00"));
  	    fpTextField.setText(Num2Str.toStr(_data.getFp(), "#0.00"));
  	    t1TextField.setText(Num2Str.toStr(_data.getT1(), "#0.00"));
  	    t2TextField.setText(Num2Str.toStr(_data.getT2(), "#0.00"));
  	    t3TextField.setText(Num2Str.toStr(_data.getT3(), "#0.00"));
  	    t4TextField.setText(Num2Str.toStr(_data.getT4(), "#0.00"));
  	    pmaxTextField.setText(Num2Str.toStr(_data.getPmax(), "#0.00"));
  	    pminTextField.setText(Num2Str.toStr(_data.getPmin(), "#0.00"));
  	    
        return true;
	}
    
	/**
	*	Save editor screen data to the form
	*
	* @param errMsg error messages during the saving process.
	* @return false if there is any problem
	*/
    public boolean saveEditorData(Vector errMsg) throws Exception {
		boolean ok = true;
		
    	_data.setOptMode(droopRadioButton.isSelected()? AbstractGovernor.DroopMode : AbstractGovernor.IsochMode); 

    	if (!SwingInputVerifyUtil.largeThan(this.rTextField, 0.0d)) {
			errMsg.add("R <= 0.0");
			ok = false;
		}
		_data.setR(SwingInputVerifyUtil.getDouble(rTextField));
    	
		if (!SwingInputVerifyUtil.largeThan(this.fpTextField, 0.0d)) {
			errMsg.add("Fp <= 0.0");
			ok = false;
		}
		_data.setFp(SwingInputVerifyUtil.getDouble(fpTextField));

		if (!SwingInputVerifyUtil.largeThan(this.t1TextField, 0.0d)) {
			errMsg.add("T1 <= 0.0");
			ok = false;
		}		
		_data.setT1(SwingInputVerifyUtil.getDouble(t1TextField));
    	
		if (!SwingInputVerifyUtil.largeThan(this.t2TextField, 0.0d)) {
			errMsg.add("T2 <= 0.0");
			ok = false;
		}		
		_data.setT2(SwingInputVerifyUtil.getDouble(t1TextField));

		if (!SwingInputVerifyUtil.largeThan(this.t3TextField, 0.0d)) {
			errMsg.add("T3 <= 0.0");
			ok = false;
		}		
		_data.setT3(SwingInputVerifyUtil.getDouble(t3TextField));

		if (!SwingInputVerifyUtil.largeThan(this.t4TextField, 0.0d)) {
			errMsg.add("T4 <= 0.0");
			ok = false;
		}		
		_data.setT4(SwingInputVerifyUtil.getDouble(t4TextField));

		if (!SwingInputVerifyUtil.largeThan(this.pmaxTextField, 0.0d)) {
			errMsg.add("Pmax <= 0.0");
			ok = false;
		}
		_data.setPmax(SwingInputVerifyUtil.getDouble(pmaxTextField));
    	
		if (!SwingInputVerifyUtil.largeEqualThan(this.pminTextField, 0.0d)) {
			errMsg.add("Pmin <= 0.0");
			ok = false;
		}
		_data.setPmin(SwingInputVerifyUtil.getDouble(pminTextField));
    	
		if (_data.getPmax() <= _data.getPmin()) {
			errMsg.add("Pmax <= Pmin");
			ok = false;
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
        optModeButtonGroup = new javax.swing.ButtonGroup();
        optModePanel = new javax.swing.JPanel();
        droopRadioButton = new javax.swing.JRadioButton();
        isochRadioButton = new javax.swing.JRadioButton();
        rLabel = new javax.swing.JLabel();
        rTextField = new javax.swing.JTextField();
        fpLabel = new javax.swing.JLabel();
        fpTextField = new javax.swing.JTextField();
        pmaxLabel = new javax.swing.JLabel();
        pmaxTextField = new javax.swing.JTextField();
        pminLabel = new javax.swing.JLabel();
        pminTextField = new javax.swing.JTextField();
        t1Label = new javax.swing.JLabel();
        t1TextField = new javax.swing.JTextField();
        t2Label = new javax.swing.JLabel();
        t2TextField = new javax.swing.JTextField();
        t3Label = new javax.swing.JLabel();
        t3TextField = new javax.swing.JTextField();
        t4Label = new javax.swing.JLabel();
        t4TextField = new javax.swing.JTextField();

        optModePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Operation Mode", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10)));
        optModeButtonGroup.add(droopRadioButton);
        droopRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        droopRadioButton.setSelected(true);
        droopRadioButton.setText("Droop     ");
        droopRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        droopRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        optModePanel.add(droopRadioButton);

        optModeButtonGroup.add(isochRadioButton);
        isochRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        isochRadioButton.setText("Isoch");
        isochRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        isochRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        optModePanel.add(isochRadioButton);

        rLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        rLabel.setText("R(%)");

        rTextField.setColumns(5);
        rTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        rTextField.setText("5");

        fpLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        fpLabel.setText("Fp(pu)");

        fpTextField.setColumns(5);
        fpTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        fpTextField.setText("0.7");

        pmaxLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        pmaxLabel.setText("Pmax(pu)");

        pmaxTextField.setColumns(5);
        pmaxTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        pmaxTextField.setText("1.1");

        pminLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        pminLabel.setText("Pmin(pu)");

        pminTextField.setColumns(5);
        pminTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        pminTextField.setText("0.0");

        t1Label.setFont(new java.awt.Font("Dialog", 0, 12));
        t1Label.setText("T1(s)");

        t1TextField.setColumns(5);
        t1TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        t1TextField.setText("0.1");

        t2Label.setFont(new java.awt.Font("Dialog", 0, 12));
        t2Label.setText("T2(s)");

        t2TextField.setColumns(5);
        t2TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        t2TextField.setText("0.1");

        t3Label.setFont(new java.awt.Font("Dialog", 0, 12));
        t3Label.setText("T3(s)");

        t3TextField.setColumns(5);
        t3TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        t3TextField.setText("0.15");

        t4Label.setFont(new java.awt.Font("Dialog", 0, 12));
        t4Label.setText("T4(s)");

        t4TextField.setColumns(5);
        t4TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        t4TextField.setText("5.0");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(49, 49, 49)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(124, 124, 124)
                        .add(optModePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 179, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(rLabel)
                        .add(43, 43, 43)
                        .add(rTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(30, 30, 30)
                        .add(fpLabel)
                        .add(20, 20, 20)
                        .add(fpTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(30, 30, 30)
                        .add(pmaxLabel)
                        .add(20, 20, 20)
                        .add(pmaxTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(pminLabel)
                        .add(20, 20, 20)
                        .add(pminTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(30, 30, 30)
                        .add(t1Label)
                        .add(27, 27, 27)
                        .add(t1TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(30, 30, 30)
                        .add(t2Label)
                        .add(44, 44, 44)
                        .add(t2TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(t3Label)
                        .add(42, 42, 42)
                        .add(t3TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(30, 30, 30)
                        .add(t4Label)
                        .add(27, 27, 27)
                        .add(t4TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(optModePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(15, 15, 15)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(rLabel))
                    .add(rTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(fpLabel))
                    .add(fpTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(pmaxLabel))
                    .add(pmaxTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(10, 10, 10)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(pminLabel))
                    .add(pminTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(t1Label))
                    .add(t1TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(t2Label))
                    .add(t2TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(10, 10, 10)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(t3Label))
                    .add(t3TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(t4Label))
                    .add(t4TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton droopRadioButton;
    private javax.swing.JLabel fpLabel;
    private javax.swing.JTextField fpTextField;
    private javax.swing.JRadioButton isochRadioButton;
    private javax.swing.ButtonGroup optModeButtonGroup;
    private javax.swing.JPanel optModePanel;
    private javax.swing.JLabel pmaxLabel;
    private javax.swing.JTextField pmaxTextField;
    private javax.swing.JLabel pminLabel;
    private javax.swing.JTextField pminTextField;
    private javax.swing.JLabel rLabel;
    private javax.swing.JTextField rTextField;
    private javax.swing.JLabel t1Label;
    private javax.swing.JTextField t1TextField;
    private javax.swing.JLabel t2Label;
    private javax.swing.JTextField t2TextField;
    private javax.swing.JLabel t3Label;
    private javax.swing.JTextField t3TextField;
    private javax.swing.JLabel t4Label;
    private javax.swing.JTextField t4TextField;
    // End of variables declaration//GEN-END:variables

	class DataVerifier extends javax.swing.InputVerifier {
    	public boolean verify(javax.swing.JComponent input) {
			if (input == null)
				return false;
       		try {
    			if ( input == rTextField ||
                	 input == fpTextField ||
                	 input == t1TextField ||
                	 input == t2TextField ||
                	 input == t3TextField ||
                	 input == t4TextField ||
                	 input == pmaxTextField ||
                	 input == pminTextField )
       	       		return SwingInputVerifyUtil.getDouble((javax.swing.JTextField)input) >= 0.0;
       	    } catch (Exception e) {
 	    		return false;
 	       	}		
			return true;
        }
    }
}
