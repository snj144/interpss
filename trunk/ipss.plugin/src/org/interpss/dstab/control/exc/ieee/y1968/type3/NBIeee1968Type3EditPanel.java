/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * A JPanel for editing the model's data. It implements the IControllerEditor interface, which will be called from
 * the parent editor dialog.
 * 
 * @author  mzhou
 */

package org.interpss.dstab.control.exc.ieee.y1968.type3;

import java.util.Vector;

import org.interpss.dstab.control.base.EditUtilFunct;

import com.interpss.common.ui.IControllerEditor;

public class NBIeee1968Type3EditPanel extends javax.swing.JPanel implements IControllerEditor {
	private static final long serialVersionUID = 1;

	// define data to be edited
	Ieee1968Type3ExciterData _data;

    /** Creates new form FaultLocDataPanel */
    public NBIeee1968Type3EditPanel() {
        initComponents();
        // init the field to the default values
        _data = new Ieee1968Type3ExciterData();
        setData2Editor();
        
        // associate the editing fields with the verifier class defined at the end of this calss
  		DataVerifier verifier = new DataVerifier();
  	    kaTextField.setInputVerifier(verifier);
  	    taTextField.setInputVerifier(verifier);
  	    vrmaxTextField.setInputVerifier(verifier);
  	    vrminTextField.setInputVerifier(verifier);
  	    keTextField.setInputVerifier(verifier);
  	    teTextField.setInputVerifier(verifier);
  	    kpTextField.setInputVerifier(verifier);
  	    kiTextField.setInputVerifier(verifier);
  	    vbmaxTextField.setInputVerifier(verifier);
  	    kfTextField.setInputVerifier(verifier);
  	    tfTextField.setInputVerifier(verifier);
    }
    
    /**
     * Init the editor panel, which will be called from its parent editor
     */
	public void init(Object controller) {
		// init the data object from the bus object being edited
		_data = ((Ieee1968Type3Exciter)controller).getData();
	}
	
	/**
	*	Set controller data to the editor
	*
	* @return false if there is any problem
	*/
    public boolean setData2Editor() {
    	EditUtilFunct.setDblTextFiled(kaTextField, 	_data.getKa(), "#0.00");
    	EditUtilFunct.setDblTextFiled(taTextField, 	_data.getTa(), "#0.000");
    	EditUtilFunct.setDblTextFiled(vrmaxTextField, 	_data.getVrmax(), "#0.00");
    	EditUtilFunct.setDblTextFiled(vrminTextField, 	_data.getVrmin(), "#0.00");
    	EditUtilFunct.setDblTextFiled(keTextField, 	_data.getKe(), "#0.00");
    	EditUtilFunct.setDblTextFiled(teTextField, 	_data.getTe(), "#0.000");
    	EditUtilFunct.setDblTextFiled(kpTextField, 	_data.getKp(), "#0.000");
    	EditUtilFunct.setDblTextFiled(kiTextField, 	_data.getKi(), "#0.000");
    	EditUtilFunct.setDblTextFiled(vbmaxTextField, 	_data.getVbmax(), "#0.000");
    	EditUtilFunct.setDblTextFiled(kfTextField, 	_data.getKf(), "#0.00");
    	EditUtilFunct.setDblTextFiled(tfTextField, 	_data.getTf(), "#0.000");

    	return true;
	}
    
	/**
	*	Save editor screen data to the controller data object
	*
	* @param errMsg error messages during the saving process.
	* @return false if there is any problem
	*/
    public boolean saveEditorData(Vector errMsg) throws Exception {
    	errMsg.clear();
    	
    	EditUtilFunct.saveDblTextField(_data, kaTextField, "ka", errMsg);
    	EditUtilFunct.saveDblTextField(_data, taTextField, "ta", errMsg);
    	EditUtilFunct.saveDblTextField(_data, vrmaxTextField, "vrmax", errMsg);
    	EditUtilFunct.saveDblTextField(_data, vrminTextField, "vrmin", errMsg);
    	EditUtilFunct.saveDblTextField(_data, keTextField, "ke", errMsg);
    	EditUtilFunct.saveDblTextField(_data, teTextField, "te", errMsg);
    	EditUtilFunct.saveDblTextField(_data, kpTextField, "kp", errMsg);
    	EditUtilFunct.saveDblTextField(_data, kiTextField, "ki", errMsg);
    	EditUtilFunct.saveDblTextField(_data, vbmaxTextField, "vbmax", errMsg);
    	EditUtilFunct.saveDblTextField(_data, kfTextField, "kf", errMsg);
    	EditUtilFunct.saveDblTextField(_data, tfTextField, "tf", errMsg);

    	return errMsg.size() == 0;
	}
    
	/** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        kaLabel = new javax.swing.JLabel();
        kaTextField = new javax.swing.JTextField();
        taLabel = new javax.swing.JLabel();
        taTextField = new javax.swing.JTextField();
        vrmaxtaLabel = new javax.swing.JLabel();
        vrmaxTextField = new javax.swing.JTextField();
        vrminLabel = new javax.swing.JLabel();
        vrminTextField = new javax.swing.JTextField();
        keLabel = new javax.swing.JLabel();
        keTextField = new javax.swing.JTextField();
        teLabel = new javax.swing.JLabel();
        teTextField = new javax.swing.JTextField();
        kpLabel = new javax.swing.JLabel();
        kpTextField = new javax.swing.JTextField();
        kiLabel = new javax.swing.JLabel();
        kiTextField = new javax.swing.JTextField();
        vbmaxLabel = new javax.swing.JLabel();
        vbmaxTextField = new javax.swing.JTextField();
        kfLabel = new javax.swing.JLabel();
        kfTextField = new javax.swing.JTextField();
        tfLabel = new javax.swing.JLabel();
        tfTextField = new javax.swing.JTextField();

        kaLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        kaLabel.setText("Ka(pu)");

        kaTextField.setColumns(5);
        kaTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        kaTextField.setText("0.0");

        taLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        taLabel.setText("Ta(s)");

        taTextField.setColumns(5);
        taTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        taTextField.setText("0.0");

        vrmaxtaLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        vrmaxtaLabel.setText("Vrmax(pu)");

        vrmaxTextField.setColumns(5);
        vrmaxTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        vrmaxTextField.setText("0.0");

        vrminLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        vrminLabel.setText("Vrmin(pu)");

        vrminTextField.setColumns(5);
        vrminTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        vrminTextField.setText("0.0");

        keLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        keLabel.setText("Ke(pu)");

        keTextField.setColumns(5);
        keTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        keTextField.setText("0.0");

        teLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        teLabel.setText("Te(s)");

        teTextField.setColumns(5);
        teTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        teTextField.setText("0.0");

        kpLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        kpLabel.setText("Kp(pu)");

        kpTextField.setColumns(5);
        kpTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        kpTextField.setText("0.0");

        kiLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        kiLabel.setText("Ki(pu)");

        kiTextField.setColumns(5);
        kiTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        kiTextField.setText("0.0");

        vbmaxLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        vbmaxLabel.setText("Vbmax(pu)");

        vbmaxTextField.setColumns(5);
        vbmaxTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        vbmaxTextField.setText("0.0");

        kfLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        kfLabel.setText("kf(pu)");

        kfTextField.setColumns(5);
        kfTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        kfTextField.setText("0.0");

        tfLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        tfLabel.setText("Ke(pu)");

        tfTextField.setColumns(5);
        tfTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        tfTextField.setText("0.0");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(49, 49, 49)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(kfLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, kpLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, vrminLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, kaLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(kaTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .add(kfTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .add(vrminTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .add(kpTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                .add(41, 41, 41)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(tfLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, taLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, keLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, kiLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(tfTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(keTextField))
                    .add(taTextField)
                    .add(kiTextField))
                .add(51, 51, 51)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(vbmaxLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .add(teLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .add(vrmaxtaLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, vrmaxTextField)
                    .add(teTextField)
                    .add(vbmaxTextField))
                .add(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(vrmaxTextField)
                            .add(vrmaxtaLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(13, 13, 13)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(teTextField)
                            .add(teLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(12, 12, 12)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(vbmaxTextField)
                            .add(vbmaxLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(kaLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(taLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(taTextField)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, kaTextField))
                        .add(13, 13, 13)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(vrminLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(vrminTextField)
                            .add(keLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(keTextField))
                        .add(12, 12, 12)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(kpLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(kpTextField)
                            .add(kiLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(kiTextField))
                        .add(14, 14, 14)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(tfTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(tfLabel))
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(kfTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(kfLabel)))))
                .add(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel kaLabel;
    private javax.swing.JTextField kaTextField;
    private javax.swing.JLabel keLabel;
    private javax.swing.JTextField keTextField;
    private javax.swing.JLabel kfLabel;
    private javax.swing.JTextField kfTextField;
    private javax.swing.JLabel kiLabel;
    private javax.swing.JTextField kiTextField;
    private javax.swing.JLabel kpLabel;
    private javax.swing.JTextField kpTextField;
    private javax.swing.JLabel taLabel;
    private javax.swing.JTextField taTextField;
    private javax.swing.JLabel teLabel;
    private javax.swing.JTextField teTextField;
    private javax.swing.JLabel tfLabel;
    private javax.swing.JTextField tfTextField;
    private javax.swing.JLabel vbmaxLabel;
    private javax.swing.JTextField vbmaxTextField;
    private javax.swing.JTextField vrmaxTextField;
    private javax.swing.JLabel vrmaxtaLabel;
    private javax.swing.JLabel vrminLabel;
    private javax.swing.JTextField vrminTextField;
    // End of variables declaration//GEN-END:variables

    // define data validation rules
	class DataVerifier extends javax.swing.InputVerifier {
    	public boolean verify(javax.swing.JComponent input) {
			if (input == null)
				return false;
       		try {
       			// data field verification rules
    			if ( input == kaTextField)
    				return EditUtilFunct.checkDblDataRange(input, _data, "ka");
    			if ( input == taTextField)
    				return EditUtilFunct.checkDblDataRange(input, _data, "ta");
    			if ( input == vrmaxTextField)
    				return EditUtilFunct.checkDblDataRange(input, _data, "vrmax");
    			if ( input == vrminTextField)
    				return EditUtilFunct.checkDblDataRange(input, _data, "vrmin");
    			if ( input == keTextField)
    				return EditUtilFunct.checkDblDataRange(input, _data, "ke");
    			if ( input == teTextField)
    				return EditUtilFunct.checkDblDataRange(input, _data, "te");
    			if ( input == kpTextField)
    				return EditUtilFunct.checkDblDataRange(input, _data, "kp");
    			if ( input == kiTextField)
    				return EditUtilFunct.checkDblDataRange(input, _data, "ki");
    			if ( input == vbmaxTextField)
    				return EditUtilFunct.checkDblDataRange(input, _data, "vbmax");
    			if ( input == kfTextField)
    				return EditUtilFunct.checkDblDataRange(input, _data, "kf");
    			if ( input == tfTextField)
    				return EditUtilFunct.checkDblDataRange(input, _data, "tf");
    			
 	       	} catch (Exception e) {
 	    		return false;
 	       	}		
			return true;
        }
    }
}
