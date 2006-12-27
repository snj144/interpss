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

package custom.dstab.exc.PIDchopper;

import java.util.Vector;

import com.interpss.common.ui.IControllerEditor;
import com.interpss.common.util.Num2Str;
import com.interpss.common.ui.SwingInputVerifyUtil;

public class NBPIDchopperEditPanel extends javax.swing.JPanel implements IControllerEditor {
    /**
     *	Set form data to the editor
     *
     * @return false if there is any problem
     */
    public boolean setData2Editor() {
        kpTextField.setText(Num2Str.toStr(controllerData.getKp(), "#0.000"));
        kiTextField.setText(Num2Str.toStr(controllerData.getKi(), "#0.000"));
        kpTextField.setText(Num2Str.toStr(controllerData.getKp(), "#0.000"));
        tbTextField.setText(Num2Str.toStr(controllerData.getTb(), "#0.000"));
        taTextField.setText(Num2Str.toStr(controllerData.getTa(), "#0.000"));
        trTextField.setText(Num2Str.toStr(controllerData.getTr(), "#0.000"));
        vrmaxTextField.setText(Num2Str.toStr(controllerData.getVrmax(), "#0.00"));
        vrminTextField.setText(Num2Str.toStr(controllerData.getVrmin(), "#0.00"));
        
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

        if (SwingInputVerifyUtil.within(this.kpTextField, 0.1, 1000.0, errMsg,
                "KP is out of the range [0.1, 1000]"))
            controllerData.setKp(SwingInputVerifyUtil.getDouble(kpTextField));
        
        if (SwingInputVerifyUtil.within(this.kiTextField, 0.001, 800.0, errMsg,
                "KI is out of the range [0.001, 800]"))
            controllerData.setKi(SwingInputVerifyUtil.getDouble(kiTextField));
        
        if (SwingInputVerifyUtil.within(this.kbTextField, 0.001, 1000.0, errMsg,
                "KB is out of the range [0.001, 1000]"))
            controllerData.setKb(SwingInputVerifyUtil.getDouble(kbTextField));
        
        if (SwingInputVerifyUtil.within(this.tbTextField, 0.0, 60.0, errMsg,
                "TB is out of the range [0.0, 60]"))
            controllerData.setTb(SwingInputVerifyUtil.getDouble(tbTextField));
        
        if (SwingInputVerifyUtil.within(this.taTextField, 1.0, 60.0, errMsg,
                "Ta is out of the range [1.0, 60.0]"))
            controllerData.setTa(SwingInputVerifyUtil.getDouble(taTextField));
        
        
        if (SwingInputVerifyUtil.within(this.trTextField, 0.0, 10.0, errMsg,
                "TR is out of the range [0.0, 10]"))
            controllerData.setTr(SwingInputVerifyUtil.getDouble(trTextField));
        
        if (SwingInputVerifyUtil.within(this.vrmaxTextField, 0.0, 20.0, errMsg,
                "Vrmax is out of the range [0.0, 20.0]"))
            controllerData.setVrmax(SwingInputVerifyUtil.getDouble(vrmaxTextField));
        
        if (SwingInputVerifyUtil.within(this.vrminTextField, -20.0, 0.0d, errMsg,
                "Vrmin is out of the range [-20.0, 0.0]"))
            controllerData.setVrmin(SwingInputVerifyUtil.getDouble(vrminTextField));
        
        return errMsg.size() == 0;
    }
    
    public NBPIDchopperEditPanel() {
        initComponents();
        
        // Add field-level data verification
        DataVerifier verifier = new DataVerifier();
        kpTextField.setInputVerifier(verifier);
        kiTextField.setInputVerifier(verifier);
        kbTextField.setInputVerifier(verifier);
        taTextField.setInputVerifier(verifier);
        tbTextField.setInputVerifier(verifier);
        trTextField.setInputVerifier(verifier);
        vrmaxTextField.setInputVerifier(verifier);
        vrminTextField.setInputVerifier(verifier);
    }
    
    // define data validation rules
    class DataVerifier extends javax.swing.InputVerifier {
        public boolean verify(javax.swing.JComponent input) {
            if (input == null)
                return false;
            try {
                
                if ( input == kpTextField )
                    return SwingInputVerifyUtil.within((javax.swing.JTextField)input, 0.1, 1000.0);
                if ( input == kiTextField )
                    return SwingInputVerifyUtil.within((javax.swing.JTextField)input, 0.001, 800.0);
                if ( input == kbTextField )
                    return SwingInputVerifyUtil.within((javax.swing.JTextField)input, 0.001, 800.0);
                if ( input == taTextField )
                    return SwingInputVerifyUtil.within((javax.swing.JTextField)input, 0.001, 60.0);
                if ( input == tbTextField )
                    return SwingInputVerifyUtil.within((javax.swing.JTextField)input, 0.001, 60.0);
                if ( input == trTextField )
                    return SwingInputVerifyUtil.within((javax.swing.JTextField)input, 0.001, 10.0);
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
    PIDchopperData controllerData;
    
    public void init(Object controller) {
        controllerData = ((PIDchopper)controller).getData();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        kbLabel = new javax.swing.JLabel();
        kbTextField = new javax.swing.JTextField();
        vrmaxLabel = new javax.swing.JLabel();
        vrmaxTextField = new javax.swing.JTextField();
        vrminLabel = new javax.swing.JLabel();
        vrminTextField = new javax.swing.JTextField();
        kpTextField = new javax.swing.JTextField();
        kpLabel = new javax.swing.JLabel();
        kiTextField = new javax.swing.JTextField();
        kiLabel = new javax.swing.JLabel();
        taTextField = new javax.swing.JTextField();
        taLabel = new javax.swing.JLabel();
        tbTextField = new javax.swing.JTextField();
        tbLabel = new javax.swing.JLabel();
        trLabel = new javax.swing.JLabel();
        trTextField = new javax.swing.JTextField();

        kbLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        kbLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kbLabel.setText("KB (pu)");

        kbTextField.setColumns(5);
        kbTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        kbTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        kbTextField.setText("2.00");

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

        kpTextField.setColumns(5);
        kpTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        kpTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        kpTextField.setText("20.00");

        kpLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        kpLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kpLabel.setText("KP (pu)");

        kiTextField.setColumns(5);
        kiTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        kiTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        kiTextField.setText("5.00");

        kiLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        kiLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kiLabel.setText("KI (pu)");

        taTextField.setColumns(5);
        taTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        taTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        taTextField.setText("2.000");

        taLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        taLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        taLabel.setText("Ta (s)");

        tbTextField.setColumns(5);
        tbTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        tbTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tbTextField.setText("0.100");

        tbLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        tbLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tbLabel.setText("Tb (s)");

        trLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        trLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trLabel.setText("TR (s)");

        trTextField.setColumns(5);
        trTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        trTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        trTextField.setText("10.000");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(93, 93, 93)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(kpLabel)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(kbLabel)
                                    .add(vrmaxLabel))
                                .add(10, 10, 10)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(vrmaxTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(kbTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(kiTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(kpTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(kiLabel))
                        .add(65, 65, 65)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(tbLabel)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(vrminLabel)
                                    .add(trLabel)
                                    .add(taLabel))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(taTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(trTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(vrminTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(tbTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(293, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(30, 30, 30)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(kpLabel)
                    .add(kpTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(trLabel)
                    .add(trTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(6, 6, 6)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(kiLabel)
                    .add(kiTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(taLabel)
                    .add(taTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(kbLabel)
                    .add(kbTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(tbLabel)
                    .add(tbTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(vrminLabel)
                    .add(vrminTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(vrmaxLabel)
                    .add(vrmaxTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel kbLabel;
    private javax.swing.JTextField kbTextField;
    private javax.swing.JLabel kiLabel;
    private javax.swing.JTextField kiTextField;
    private javax.swing.JLabel kpLabel;
    private javax.swing.JTextField kpTextField;
    private javax.swing.JLabel taLabel;
    private javax.swing.JTextField taTextField;
    private javax.swing.JLabel tbLabel;
    private javax.swing.JTextField tbTextField;
    private javax.swing.JLabel trLabel;
    private javax.swing.JTextField trTextField;
    private javax.swing.JLabel vrmaxLabel;
    private javax.swing.JTextField vrmaxTextField;
    private javax.swing.JLabel vrminLabel;
    private javax.swing.JTextField vrminTextField;
    // End of variables declaration//GEN-END:variables
}
