  /*
  * @(#)CalculationException.java   
  *
  * Copyright (C) 2006 www.interpss.com
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
  * @Author Ron Oosterwijk
  * @Version 1.0
  * @Date Dec 2006
  * 
  *   Revision History
  *   ================
  *
  */

package custom.dstab.exc.ieee.st5b;

import java.util.Vector;

import com.interpss.common.ui.IControllerEditor;
import com.interpss.common.util.Num2Str;
import com.interpss.common.ui.SwingInputVerifyUtil;

public class NBst5bExciterEditPanel extends javax.swing.JPanel implements IControllerEditor {
    /**
     *	Set form data to the editor
     *
     * @return false if there is any problem
     */
    public boolean setData2Editor() {
        tb1TextField.setText(Num2Str.toStr(controllerData.getTb1(), "#0.000"));
        tc1TextField.setText(Num2Str.toStr(controllerData.getTc1(), "#0.000"));
        tc2TextField.setText(Num2Str.toStr(controllerData.getTc2(), "#0.000"));
        tb2TextField.setText(Num2Str.toStr(controllerData.getTb2(), "#0.000"));
        krTextField.setText(Num2Str.toStr(controllerData.getKr(), "#0.0"));
        vrmaxTextField.setText(Num2Str.toStr(controllerData.getVrmax(), "#0.00"));
        
        tub1TextField.setText(Num2Str.toStr(controllerData.getTub1(), "#0.000"));
        tuc1TextField.setText(Num2Str.toStr(controllerData.getTuc1(), "#0.000"));
        tuc2TextField.setText(Num2Str.toStr(controllerData.getTuc2(), "#0.000"));
        tub2TextField.setText(Num2Str.toStr(controllerData.getTub2(), "#0.000"));
        t1TextField.setText(Num2Str.toStr(controllerData.getT1(), "#0.000"));
        vrminTextField.setText(Num2Str.toStr(controllerData.getVrmin(), "#0.00"));
        
        tob1TextField.setText(Num2Str.toStr(controllerData.getTob1(), "#0.000"));
        toc1TextField.setText(Num2Str.toStr(controllerData.getToc1(), "#0.000"));
        toc2TextField.setText(Num2Str.toStr(controllerData.getToc2(), "#0.000"));
        tob2TextField.setText(Num2Str.toStr(controllerData.getTob2(), "#0.000"));
        kcTextField.setText(Num2Str.toStr(controllerData.getKc(), "#0.000"));
        
        return true;
    }
    
    /**
     *	Save editor screen data to the form
     *
     * @param errMsg error messages during the saving process.
     * @return false if there is any problem
     */
    public boolean saveEditorData(Vector errMsg) throws Exception  {
        errMsg.clear();

        if (SwingInputVerifyUtil.within(this.tb1TextField, 0.0, 100.0, errMsg,
                "TB1 is out of the range [0.0, 100]"))
            controllerData.setTb1(SwingInputVerifyUtil.getDouble(tb1TextField));
        
        if (SwingInputVerifyUtil.within(this.tc1TextField, 0.001, 10.0, errMsg,
                "TC1 is out of the range [0.001, 10]"))
            controllerData.setTc1(SwingInputVerifyUtil.getDouble(tc1TextField));
        
        if (SwingInputVerifyUtil.within(this.tc2TextField, 0.001, 10.0, errMsg,
                "TC2 is out of the range [0.001, 10]"))
            controllerData.setTc2(SwingInputVerifyUtil.getDouble(tc2TextField));
        
        if (SwingInputVerifyUtil.within(this.tb2TextField, 0.0, 10.0, errMsg,
                "TB2 is out of the range [0.0, 10]"))
            controllerData.setTb2(SwingInputVerifyUtil.getDouble(tb2TextField));
        
        if (SwingInputVerifyUtil.within(this.krTextField, 1.0, 1000.0, errMsg,
                "KR is out of the range [1.0, 1000.0]"))
            controllerData.setKr(SwingInputVerifyUtil.getDouble(krTextField));
        
        
        if (SwingInputVerifyUtil.within(this.tub1TextField, 0.0, 100.0, errMsg,
                "TUB1 is out of the range [0.0, 100]"))
            controllerData.setTub1(SwingInputVerifyUtil.getDouble(tub1TextField));
        
        if (SwingInputVerifyUtil.within(this.tuc1TextField, 0.001, 10.0, errMsg,
                "TUC1 is out of the range [0.001, 10]"))
            controllerData.setTuc1(SwingInputVerifyUtil.getDouble(tuc1TextField));
        
        if (SwingInputVerifyUtil.within(this.tuc2TextField, 0.001, 10.0, errMsg,
                "TUC2 is out of the range [0.001, 10]"))
            controllerData.setTuc2(SwingInputVerifyUtil.getDouble(tuc2TextField));
        
        if (SwingInputVerifyUtil.within(this.tub2TextField, 0.0, 10.0, errMsg,
                "TUB2 is out of the range [0.0, 10]"))
            controllerData.setTub2(SwingInputVerifyUtil.getDouble(tub2TextField));
        
        if (SwingInputVerifyUtil.within(this.t1TextField, 0.0, 10.0, errMsg,
                "T1 is out of the range [0.0, 1000.0]"))
            controllerData.setT1(SwingInputVerifyUtil.getDouble(t1TextField));
        
        
        if (SwingInputVerifyUtil.within(this.tob1TextField, 0.0, 100.0, errMsg,
                "TOB1 is out of the range [0.0, 100]"))
            controllerData.setTob1(SwingInputVerifyUtil.getDouble(tob1TextField));
        
        if (SwingInputVerifyUtil.within(this.toc1TextField, 0.001, 10.0, errMsg,
                "TOC1 is out of the range [0.001, 10]"))
            controllerData.setToc1(SwingInputVerifyUtil.getDouble(toc1TextField));
        
        if (SwingInputVerifyUtil.within(this.toc2TextField, 0.001, 10.0, errMsg,
                "TOC2 is out of the range [0.001, 10]"))
            controllerData.setToc2(SwingInputVerifyUtil.getDouble(toc2TextField));
        
        if (SwingInputVerifyUtil.within(this.tob2TextField, 0.0, 10.0, errMsg,
                "TOB2 is out of the range [0.0, 10]"))
            controllerData.setTob2(SwingInputVerifyUtil.getDouble(tob2TextField));
        
        if (SwingInputVerifyUtil.within(this.kcTextField, 0.0, 10.0, errMsg,
                "KC is out of the range [0.0, 10.0]"))
            controllerData.setKc(SwingInputVerifyUtil.getDouble(kcTextField));
        

        if (SwingInputVerifyUtil.within(this.vrmaxTextField, 0.0, 20.0, errMsg,
                "Vrmax is out of the range [0.0, 20.0]"))
            controllerData.setVrmax(SwingInputVerifyUtil.getDouble(vrmaxTextField));
        
        if (SwingInputVerifyUtil.within(this.vrminTextField, -20.0, 0.0d, errMsg,
                "Vrmin is out of the range [-20.0, 0.0]"))
            controllerData.setVrmin(SwingInputVerifyUtil.getDouble(vrminTextField));
        
        return errMsg.size() == 0;
    }
    
    public NBst5bExciterEditPanel() {
        initComponents();
        
        // Add field-level data verification
        DataVerifier verifier = new DataVerifier();
        tb1TextField.setInputVerifier(verifier);
        tc1TextField.setInputVerifier(verifier);
        tc2TextField.setInputVerifier(verifier);
        tb2TextField.setInputVerifier(verifier);
        krTextField.setInputVerifier(verifier);
        
        tub1TextField.setInputVerifier(verifier);
        tuc1TextField.setInputVerifier(verifier);
        tuc2TextField.setInputVerifier(verifier);
        tub2TextField.setInputVerifier(verifier);
        t1TextField.setInputVerifier(verifier);

        tob1TextField.setInputVerifier(verifier);
        toc1TextField.setInputVerifier(verifier);
        toc2TextField.setInputVerifier(verifier);
        tob2TextField.setInputVerifier(verifier);
        kcTextField.setInputVerifier(verifier);

        vrmaxTextField.setInputVerifier(verifier);
        vrminTextField.setInputVerifier(verifier);
    }
    
    // define data validation rules
    class DataVerifier extends javax.swing.InputVerifier {
        public boolean verify(javax.swing.JComponent input) {
            if (input == null)
                return false;
            try {
                
                if ( input == tb1TextField )
                    return SwingInputVerifyUtil.within((javax.swing.JTextField)input, 0.001, 100.0);
                if ( input == tc1TextField )
                    return SwingInputVerifyUtil.within((javax.swing.JTextField)input, 0.001, 10.0);
                if ( input == tc2TextField )
                    return SwingInputVerifyUtil.within((javax.swing.JTextField)input, 0.001, 10.0);
                if ( input == tb2TextField )
                    return SwingInputVerifyUtil.within((javax.swing.JTextField)input, 0.0, 10.0);
                if ( input == krTextField )
                    return SwingInputVerifyUtil.within((javax.swing.JTextField)input, 1.0, 1000.0);
                
                if ( input == tub1TextField )
                    return SwingInputVerifyUtil.within((javax.swing.JTextField)input, 0.001, 100.0);
                if ( input == tuc1TextField )
                    return SwingInputVerifyUtil.within((javax.swing.JTextField)input, 0.001, 10.0);
                if ( input == tuc2TextField )
                    return SwingInputVerifyUtil.within((javax.swing.JTextField)input, 0.001, 10.0);
                if ( input == tub2TextField )
                    return SwingInputVerifyUtil.within((javax.swing.JTextField)input, 0.0, 10.0);
                if ( input == t1TextField )
                    return SwingInputVerifyUtil.within((javax.swing.JTextField)input, 1.0, 1000.0);
                
                if ( input == tob1TextField )
                    return SwingInputVerifyUtil.within((javax.swing.JTextField)input, 0.001, 100.0);
                if ( input == toc1TextField )
                    return SwingInputVerifyUtil.within((javax.swing.JTextField)input, 0.001, 10.0);
                if ( input == toc2TextField )
                    return SwingInputVerifyUtil.within((javax.swing.JTextField)input, 0.001, 10.0);
                if ( input == tob2TextField )
                    return SwingInputVerifyUtil.within((javax.swing.JTextField)input, 0.0, 10.0);
                if ( input == kcTextField )
                    return SwingInputVerifyUtil.within((javax.swing.JTextField)input, 1.0, 1000.0);
        
                if ( input == vrmaxTextField )
                    return SwingInputVerifyUtil.within((javax.swing.JTextField)input, 0.0, 20.0);
                if ( input == vrminTextField )
                    return SwingInputVerifyUtil.within((javax.swing.JTextField)input, -20.0, 0.0);
            } catch (Exception e) {
                return false;
            }
            return true;
        }
    }
    
    /*
     *  There is no need to make any change beyond this point
     */
    
    private static final long serialVersionUID = 1;
    st5bExciterData controllerData;
    
    public void init(Object controller) {
        controllerData = ((st5bExciter)controller).getData();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        krLabel = new javax.swing.JLabel();
        krTextField = new javax.swing.JTextField();
        vrmaxLabel = new javax.swing.JLabel();
        vrmaxTextField = new javax.swing.JTextField();
        vrminLabel = new javax.swing.JLabel();
        vrminTextField = new javax.swing.JTextField();
        tb1TextField = new javax.swing.JTextField();
        tb1Label = new javax.swing.JLabel();
        tc1TextField = new javax.swing.JTextField();
        tc1Label = new javax.swing.JLabel();
        tc2TextField = new javax.swing.JTextField();
        tc2Label = new javax.swing.JLabel();
        tb2TextField = new javax.swing.JTextField();
        tb2Label = new javax.swing.JLabel();
        t1TextField = new javax.swing.JTextField();
        t1Label = new javax.swing.JLabel();
        tub1Label = new javax.swing.JLabel();
        tuc1Label = new javax.swing.JLabel();
        tuc2Label = new javax.swing.JLabel();
        tub2Label = new javax.swing.JLabel();
        tub1TextField = new javax.swing.JTextField();
        tuc1TextField = new javax.swing.JTextField();
        tuc2TextField = new javax.swing.JTextField();
        tub2TextField = new javax.swing.JTextField();
        tob1Label = new javax.swing.JLabel();
        tob1TextField = new javax.swing.JTextField();
        toc1Label = new javax.swing.JLabel();
        toc1TextField = new javax.swing.JTextField();
        toc2Label = new javax.swing.JLabel();
        toc2TextField = new javax.swing.JTextField();
        tob2Label = new javax.swing.JLabel();
        tob2TextField = new javax.swing.JTextField();
        kcLabel = new javax.swing.JLabel();
        kcTextField = new javax.swing.JTextField();

        krLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        krLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        krLabel.setText("KR (pu)");

        krTextField.setColumns(5);
        krTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        krTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        krTextField.setText("200");

        vrmaxLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        vrmaxLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vrmaxLabel.setText("Vrmax(pu)");

        vrmaxTextField.setColumns(5);
        vrmaxTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        vrmaxTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        vrmaxTextField.setText("7.00");

        vrminLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        vrminLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vrminLabel.setText("Vrmin(pu)");

        vrminTextField.setColumns(5);
        vrminTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        vrminTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        vrminTextField.setText("-6.40");

        tb1TextField.setColumns(5);
        tb1TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        tb1TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tb1TextField.setText("10.000");

        tb1Label.setFont(new java.awt.Font("Dialog", 0, 12));
        tb1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tb1Label.setText("TB1 (s)");

        tc1TextField.setColumns(5);
        tc1TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        tc1TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tc1TextField.setText("1.000");

        tc1Label.setFont(new java.awt.Font("Dialog", 0, 12));
        tc1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tc1Label.setText("TC1 (s)");

        tc2TextField.setColumns(5);
        tc2TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        tc2TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tc2TextField.setText("0.1000");

        tc2Label.setFont(new java.awt.Font("Dialog", 0, 12));
        tc2Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tc2Label.setText("TC2 (s)");

        tb2TextField.setColumns(5);
        tb2TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        tb2TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tb2TextField.setText("0.050");

        tb2Label.setFont(new java.awt.Font("Dialog", 0, 12));
        tb2Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tb2Label.setText("TB2 (s)");

        t1TextField.setColumns(5);
        t1TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        t1TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t1TextField.setText("0.003");

        t1Label.setFont(new java.awt.Font("Dialog", 0, 12));
        t1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t1Label.setText("T1 (s)");

        tub1Label.setFont(new java.awt.Font("Dialog", 0, 12));
        tub1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tub1Label.setText("TUB1 (s)");

        tuc1Label.setFont(new java.awt.Font("Dialog", 0, 12));
        tuc1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tuc1Label.setText("TUC1 (s)");

        tuc2Label.setFont(new java.awt.Font("Dialog", 0, 12));
        tuc2Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tuc2Label.setText("TUC2 (s)");

        tub2Label.setFont(new java.awt.Font("Dialog", 0, 12));
        tub2Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tub2Label.setText("TUB2 (s)");

        tub1TextField.setColumns(5);
        tub1TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        tub1TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tub1TextField.setText("10.000");

        tuc1TextField.setColumns(5);
        tuc1TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        tuc1TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tuc1TextField.setText("1.000");

        tuc2TextField.setColumns(5);
        tuc2TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        tuc2TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tuc2TextField.setText("0.1000");

        tub2TextField.setColumns(5);
        tub2TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        tub2TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tub2TextField.setText("0.050");

        tob1Label.setFont(new java.awt.Font("Dialog", 0, 12));
        tob1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tob1Label.setText("TOB1 (s)");

        tob1TextField.setColumns(5);
        tob1TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        tob1TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tob1TextField.setText("10.000");

        toc1Label.setFont(new java.awt.Font("Dialog", 0, 12));
        toc1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        toc1Label.setText("TOC1 (s)");

        toc1TextField.setColumns(5);
        toc1TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        toc1TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        toc1TextField.setText("1.000");

        toc2Label.setFont(new java.awt.Font("Dialog", 0, 12));
        toc2Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        toc2Label.setText("TOC2 (s)");

        toc2TextField.setColumns(5);
        toc2TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        toc2TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        toc2TextField.setText("0.1000");

        tob2Label.setFont(new java.awt.Font("Dialog", 0, 12));
        tob2Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tob2Label.setText("TOB2 (s)");

        tob2TextField.setColumns(5);
        tob2TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        tob2TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tob2TextField.setText("0.050");

        kcLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        kcLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kcLabel.setText("KC (pu)");

        kcTextField.setColumns(5);
        kcTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        kcTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        kcTextField.setText("0.003");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(tb1Label)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(tc2Label)
                                    .add(krLabel))
                                .add(17, 17, 17)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(tb2TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(krTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(tc2TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(tc1TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(tb1TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(7, 7, 7))
                            .add(org.jdesktop.layout.GroupLayout.LEADING, tb2Label))
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, tuc1TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, tub1TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(10, 10, 10)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                        .add(t1Label)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(t1TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(layout.createSequentialGroup()
                                        .add(vrminLabel)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(vrminTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                            .add(tuc2Label)
                                            .add(tub2Label)
                                            .add(tuc1Label)
                                            .add(tub1Label))
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 9, Short.MAX_VALUE)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(org.jdesktop.layout.GroupLayout.TRAILING, tub2TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(org.jdesktop.layout.GroupLayout.TRAILING, tuc2TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))))
                    .add(tc1Label)
                    .add(layout.createSequentialGroup()
                        .add(vrmaxLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(vrmaxTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 16, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(tob1Label)
                    .add(toc1Label)
                    .add(toc2Label)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(kcLabel)
                        .add(tob2Label)))
                .add(12, 12, 12)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(tob1TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(toc1TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(toc2TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(tob2TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(kcTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(tb1Label)
                    .add(tub1TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(tub1Label)
                    .add(tb1TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(tob1Label)
                    .add(tob1TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(6, 6, 6)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(tc1Label)
                    .add(tuc1TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(tuc1Label)
                    .add(tc1TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(toc1Label)
                    .add(toc1TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(tc2Label)
                    .add(tuc2TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(tuc2Label)
                    .add(tc2TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(toc2Label)
                    .add(toc2TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(tb2Label)
                    .add(tub2TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(tub2Label)
                    .add(tb2TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(tob2Label)
                    .add(tob2TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(krLabel)
                    .add(t1TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(t1Label)
                    .add(krTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(kcLabel)
                    .add(kcTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(vrmaxLabel)
                    .add(vrmaxTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(vrminLabel)
                    .add(vrminTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel kcLabel;
    private javax.swing.JTextField kcTextField;
    private javax.swing.JLabel krLabel;
    private javax.swing.JTextField krTextField;
    private javax.swing.JLabel t1Label;
    private javax.swing.JTextField t1TextField;
    private javax.swing.JLabel tb1Label;
    private javax.swing.JTextField tb1TextField;
    private javax.swing.JLabel tb2Label;
    private javax.swing.JTextField tb2TextField;
    private javax.swing.JLabel tc1Label;
    private javax.swing.JTextField tc1TextField;
    private javax.swing.JLabel tc2Label;
    private javax.swing.JTextField tc2TextField;
    private javax.swing.JLabel tob1Label;
    private javax.swing.JTextField tob1TextField;
    private javax.swing.JLabel tob2Label;
    private javax.swing.JTextField tob2TextField;
    private javax.swing.JLabel toc1Label;
    private javax.swing.JTextField toc1TextField;
    private javax.swing.JLabel toc2Label;
    private javax.swing.JTextField toc2TextField;
    private javax.swing.JLabel tub1Label;
    private javax.swing.JTextField tub1TextField;
    private javax.swing.JLabel tub2Label;
    private javax.swing.JTextField tub2TextField;
    private javax.swing.JLabel tuc1Label;
    private javax.swing.JTextField tuc1TextField;
    private javax.swing.JLabel tuc2Label;
    private javax.swing.JTextField tuc2TextField;
    private javax.swing.JLabel vrmaxLabel;
    private javax.swing.JTextField vrmaxTextField;
    private javax.swing.JLabel vrminLabel;
    private javax.swing.JTextField vrminTextField;
    // End of variables declaration//GEN-END:variables
}
