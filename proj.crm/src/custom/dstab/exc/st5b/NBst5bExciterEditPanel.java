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

package custom.dstab.exc.st5b;

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
        trTextField.setText(Num2Str.toStr(controllerData.getTr(), "#0.000"));
        kirTextField.setText(Num2Str.toStr(controllerData.getKir(), "#0.000"));
        kiaTextField.setText(Num2Str.toStr(controllerData.getKia(), "#0.000"));
        k3TextField.setText(Num2Str.toStr(controllerData.getK3(), "#0.000"));
        k4TextField.setText(Num2Str.toStr(controllerData.getK4(), "#0.000"));
        t3TextField.setText(Num2Str.toStr(controllerData.getT3(), "#0.000"));
        t4TextField.setText(Num2Str.toStr(controllerData.getT4(), "#0.000"));
        kvfTextField.setText(Num2Str.toStr(controllerData.getKvf(), "#0.000"));
        kifTextField.setText(Num2Str.toStr(controllerData.getKif(), "#0.000"));
        v3maxTextField.setText(Num2Str.toStr(controllerData.getV3max(), "#0.000"));
        v3minTextField.setText(Num2Str.toStr(controllerData.getV3min(), "#0.000"));
        vfdmaxTextField.setText(Num2Str.toStr(controllerData.getVfdmax(), "#0.000"));
        vfdminTextField.setText(Num2Str.toStr(controllerData.getVfdmin(), "#0.000"));
        
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
        
        if (SwingInputVerifyUtil.within(this.trTextField, 0.001, 10.0, errMsg,
                "TR is out of the range [0.001, 10.0]"))
            controllerData.setTr(SwingInputVerifyUtil.getDouble(trTextField));
        
        if (SwingInputVerifyUtil.within(this.kirTextField, -2.0, 2.0, errMsg,
                "KIR is out of the range [-2.0, 2.0]"))
            controllerData.setKir(SwingInputVerifyUtil.getDouble(kirTextField));
        
        if (SwingInputVerifyUtil.within(this.kiaTextField, -2.0, 2.0, errMsg,
                "KIA is out of the range [-2.0, 2.0]"))
            controllerData.setKia(SwingInputVerifyUtil.getDouble(kiaTextField));
        
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
        trTextField.setInputVerifier(verifier);
        kirTextField.setInputVerifier(verifier);
        kiaTextField.setInputVerifier(verifier);

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
                if ( input == trTextField )
                    return SwingInputVerifyUtil.within((javax.swing.JTextField)input, 0.001, 10.0);
                if ( input == kirTextField )
                    return SwingInputVerifyUtil.within((javax.swing.JTextField)input, -2.0, 2.0);
                if ( input == kiaTextField )
                    return SwingInputVerifyUtil.within((javax.swing.JTextField)input, -2.0, 2.0);

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
        trTextField = new javax.swing.JTextField();
        trLabel = new javax.swing.JLabel();
        kirTextField = new javax.swing.JTextField();
        kirLabel = new javax.swing.JLabel();
        kiaTextField = new javax.swing.JTextField();
        kiaLabel = new javax.swing.JLabel();
        k3TextField = new javax.swing.JTextField();
        k3Label = new javax.swing.JLabel();
        t3TextField = new javax.swing.JTextField();
        t3Label = new javax.swing.JLabel();
        k4TextField = new javax.swing.JTextField();
        k4Label = new javax.swing.JLabel();
        t4TextField = new javax.swing.JTextField();
        t4Label = new javax.swing.JLabel();
        kvfLabel = new javax.swing.JLabel();
        kvfTextField = new javax.swing.JTextField();
        kifLabel = new javax.swing.JLabel();
        kifTextField = new javax.swing.JTextField();
        v3maxLabel = new javax.swing.JLabel();
        v3maxTextField = new javax.swing.JTextField();
        v3minLabel = new javax.swing.JLabel();
        v3minTextField = new javax.swing.JTextField();
        vfdmaxLabel = new javax.swing.JLabel();
        vfdmaxTextField = new javax.swing.JTextField();
        vfdminLabel = new javax.swing.JLabel();
        vfdminTextField = new javax.swing.JTextField();

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

        trTextField.setColumns(5);
        trTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        trTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        trTextField.setText("0.020");

        trLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        trLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trLabel.setText("TR (s)");

        kirTextField.setColumns(5);
        kirTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        kirTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        kirTextField.setText("-0.050");

        kirLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        kirLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kirLabel.setText("KIR (pu)");

        kiaTextField.setColumns(5);
        kiaTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        kiaTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        kiaTextField.setText("0.000");

        kiaLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        kiaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kiaLabel.setText("KIA (pu)");

        k3TextField.setColumns(5);
        k3TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        k3TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        k3TextField.setText("4.000");

        k3Label.setFont(new java.awt.Font("Dialog", 0, 12));
        k3Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        k3Label.setText("K3 (pu)");

        t3TextField.setColumns(5);
        t3TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        t3TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t3TextField.setText("0.011");

        t3Label.setFont(new java.awt.Font("Dialog", 0, 12));
        t3Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t3Label.setText("T3 (s)");

        k4TextField.setColumns(5);
        k4TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        k4TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        k4TextField.setText("2.900");

        k4Label.setFont(new java.awt.Font("Dialog", 0, 12));
        k4Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        k4Label.setText("K4 (pu)");

        t4TextField.setColumns(5);
        t4TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        t4TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t4TextField.setText("0.900");

        t4Label.setFont(new java.awt.Font("Dialog", 0, 12));
        t4Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t4Label.setText("T4 (s)");

        kvfLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        kvfLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kvfLabel.setText("KVF (pu)");

        kvfTextField.setColumns(5);
        kvfTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        kvfTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        kvfTextField.setText("0.750");

        kifLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        kifLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kifLabel.setText("KIF (pu)");

        kifTextField.setColumns(5);
        kifTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        kifTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        kifTextField.setText("1.900");

        v3maxLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        v3maxLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        v3maxLabel.setText("V3max(pu)");

        v3maxTextField.setColumns(5);
        v3maxTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        v3maxTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        v3maxTextField.setText("12.000");

        v3minLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        v3minLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        v3minLabel.setText("V3min(pu)");

        v3minTextField.setColumns(5);
        v3minTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        v3minTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        v3minTextField.setText("-6.000");

        vfdmaxLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        vfdmaxLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vfdmaxLabel.setText("Vfdmax(pu)");

        vfdmaxTextField.setColumns(5);
        vfdmaxTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        vfdmaxTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        vfdmaxTextField.setText("12.000");

        vfdminLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        vfdminLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vfdminLabel.setText("Vfdmin(pu)");

        vfdminTextField.setColumns(5);
        vfdminTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        vfdminTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        vfdminTextField.setText("0.000");

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
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                        .add(t1Label)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 33, Short.MAX_VALUE)
                                        .add(t1TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                            .add(tuc2Label)
                                            .add(tub2Label)
                                            .add(tuc1Label)
                                            .add(tub1Label))
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 15, Short.MAX_VALUE)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(org.jdesktop.layout.GroupLayout.TRAILING, tub2TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(org.jdesktop.layout.GroupLayout.TRAILING, tuc2TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                            .add(kiaLabel)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .add(kiaTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                            .add(vrminLabel)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                            .add(vrminTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(k4Label)
                                        .add(t4Label)
                                        .add(layout.createSequentialGroup()
                                            .add(v3minLabel)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .add(v3minTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))))
                    .add(tc1Label)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(layout.createSequentialGroup()
                                .add(vrmaxLabel)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(vrmaxTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(kirLabel)
                                    .add(k3Label)
                                    .add(t3Label))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 15, Short.MAX_VALUE)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, kirTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, k3TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, t3TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, v3maxTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 81, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(k4TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(t4TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(layout.createSequentialGroup()
                        .add(v3maxLabel)
                        .add(204, 204, 204)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(12, 12, 12)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(tob2Label)
                            .add(toc2Label)
                            .add(kcLabel)
                            .add(trLabel)
                            .add(kvfLabel)
                            .add(kifLabel)
                            .add(vfdmaxLabel)
                            .add(vfdminLabel)
                            .add(toc1Label)
                            .add(tob1Label))
                        .add(12, 12, 12)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(tob1TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(toc1TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(toc2TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(tob2TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(kcTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(kvfTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(kifTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(vfdmaxTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, trTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, vfdminTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(24, 24, 24))
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
                    .add(tob1TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(tob1Label))
                .add(6, 6, 6)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(tc1Label)
                    .add(tuc1TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(tuc1Label)
                    .add(tc1TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(toc1TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(toc1Label))
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
                    .add(tob2TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(tob2Label))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(krLabel)
                    .add(t1TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(t1Label)
                    .add(krTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(kcTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(kcLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(vrmaxLabel)
                    .add(vrmaxTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(vrminLabel)
                    .add(vrminTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(trTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(trLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(kiaTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(kirTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(kirLabel)
                    .add(kiaLabel)
                    .add(kvfTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(kvfLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(k3TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(k3Label)
                    .add(k4TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(k4Label)
                    .add(kifTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(kifLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(t3TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(t3Label)
                    .add(t4TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(t4Label)
                    .add(vfdmaxTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(vfdmaxLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(v3maxLabel)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(v3maxTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(v3minLabel)
                        .add(v3minTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(vfdminTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(vfdminLabel)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel k3Label;
    private javax.swing.JTextField k3TextField;
    private javax.swing.JLabel k4Label;
    private javax.swing.JTextField k4TextField;
    private javax.swing.JLabel kcLabel;
    private javax.swing.JTextField kcTextField;
    private javax.swing.JLabel kiaLabel;
    private javax.swing.JTextField kiaTextField;
    private javax.swing.JLabel kifLabel;
    private javax.swing.JTextField kifTextField;
    private javax.swing.JLabel kirLabel;
    private javax.swing.JTextField kirTextField;
    private javax.swing.JLabel krLabel;
    private javax.swing.JTextField krTextField;
    private javax.swing.JLabel kvfLabel;
    private javax.swing.JTextField kvfTextField;
    private javax.swing.JLabel t1Label;
    private javax.swing.JTextField t1TextField;
    private javax.swing.JLabel t3Label;
    private javax.swing.JTextField t3TextField;
    private javax.swing.JLabel t4Label;
    private javax.swing.JTextField t4TextField;
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
    private javax.swing.JLabel trLabel;
    private javax.swing.JTextField trTextField;
    private javax.swing.JLabel tub1Label;
    private javax.swing.JTextField tub1TextField;
    private javax.swing.JLabel tub2Label;
    private javax.swing.JTextField tub2TextField;
    private javax.swing.JLabel tuc1Label;
    private javax.swing.JTextField tuc1TextField;
    private javax.swing.JLabel tuc2Label;
    private javax.swing.JTextField tuc2TextField;
    private javax.swing.JLabel v3maxLabel;
    private javax.swing.JTextField v3maxTextField;
    private javax.swing.JLabel v3minLabel;
    private javax.swing.JTextField v3minTextField;
    private javax.swing.JLabel vfdmaxLabel;
    private javax.swing.JTextField vfdmaxTextField;
    private javax.swing.JLabel vfdminLabel;
    private javax.swing.JTextField vfdminTextField;
    private javax.swing.JLabel vrmaxLabel;
    private javax.swing.JTextField vrmaxTextField;
    private javax.swing.JLabel vrminLabel;
    private javax.swing.JTextField vrminTextField;
    // End of variables declaration//GEN-END:variables
}
