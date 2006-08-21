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

package com.interpss.dstab.control.exc.psat.psatType1;

import java.util.Vector;

import com.interpss.common.ui.IControllerEditor;
import com.interpss.common.ui.VerifyUtil;
import com.interpss.common.util.Num2Str;
import com.interpss.dstab.control.common.ui.InputVerifyUtil;

public class NBType1_psatAvrEditPanel extends javax.swing.JPanel implements IControllerEditor {
	private static final long serialVersionUID = 1;

	// define data to be edited
	Type1_psatAvrData _data;

    /** Creates new form FaultLocDataPanel */
    public NBType1_psatAvrEditPanel() {
        initComponents();

        // associate the editing fields with the verifier class defined at the end of this calss
  		DataVerifier verifier = new DataVerifier();
  	    aeTextField.setInputVerifier(verifier);
  	    beTextField.setInputVerifier(verifier);
  	    mu0TextField.setInputVerifier(verifier);
  	    t1TextField.setInputVerifier(verifier);
  	    t2TextField.setInputVerifier(verifier);
  	    t3TextField.setInputVerifier(verifier);
  	    t4TextField.setInputVerifier(verifier);
  	    teTextField.setInputVerifier(verifier);
  	    trTextField.setInputVerifier(verifier);
  	    vrmaxTextField.setInputVerifier(verifier);
  	    vrminTextField.setInputVerifier(verifier);
    }
    
    /**
     * Init the editor panel, which will be called from its parent editor
     */
	public void init(Object controller) {
		// init the data object from the bus object being edited
		_data = ((Type1_psatAvr)controller).getData();
	}
	
	/**
	*	Set controller data to the editor
	*
	* @return false if there is any problem
	*/
    public boolean setData2Editor() {
  	    vrmaxTextField.setText(Num2Str.toStr(_data.getVrmax(), "#0.00"));
  	    vrminTextField.setText(Num2Str.toStr(_data.getVrmin(), "#0.00"));
  	    mu0TextField.setText(Num2Str.toStr(_data.getMu0(), "#0.00"));
  	    t1TextField.setText(Num2Str.toStr(_data.getT1(), "#0.000"));
  	    t2TextField.setText(Num2Str.toStr(_data.getT2(), "#0.000"));
  	    t3TextField.setText(Num2Str.toStr(_data.getT3(), "#0.000"));
  	    t4TextField.setText(Num2Str.toStr(_data.getT4(), "#0.000"));
  	    teTextField.setText(Num2Str.toStr(_data.getTe(), "#0.000"));
  	    trTextField.setText(Num2Str.toStr(_data.getTr(), "#0.000"));
  	    aeTextField.setText(Num2Str.toStr(_data.getAe(), "#0.000"));
  	    beTextField.setText(Num2Str.toStr(_data.getBe(), "#0.000"));
        return true;
	}
    
	/**
	*	Save editor screen data to the controller data object
	*
	* @param errMsg error messages during the saving process.
	* @return false if there is any problem
	*/
    public boolean saveEditorData(Vector errMsg) throws Exception {
		boolean ok = true;

		if (!VerifyUtil.largeThan(this.vrmaxTextField, 0.0d)) {
			errMsg.add("Vrmax <= 0.0");
			ok = false;
		}
    	_data.setVrmax(InputVerifyUtil.getDouble(vrmaxTextField));

    	if (!VerifyUtil.largeEqualThan(this.vrminTextField, 0.0d)) {
			errMsg.add("Vrmin < 0.0");
			ok = false;
		}
    	_data.setVrmin(InputVerifyUtil.getDouble(vrminTextField));
		
    	if (_data.getVrmax() <= _data.getVrmin()) {
			errMsg.add("Vrmax <= Vrmin");
			ok = false;
		}

		if (!VerifyUtil.largeThan(this.mu0TextField, 0.0d)) {
			errMsg.add("mu0 <= 0.0");
			ok = false;
		}
    	_data.setMu0(InputVerifyUtil.getDouble(mu0TextField));

		if (!VerifyUtil.largeThan(this.t1TextField, 0.0d)) {
			errMsg.add("T1 <= 0.0");
			ok = false;
		}
    	_data.setT1(InputVerifyUtil.getDouble(t1TextField));

		if (!VerifyUtil.largeThan(this.t2TextField, 0.0d)) {
			errMsg.add("T2 <= 0.0");
			ok = false;
		}
    	_data.setT2(InputVerifyUtil.getDouble(t2TextField));

		if (!VerifyUtil.largeThan(this.t3TextField, 0.0d)) {
			errMsg.add("T3 <= 0.0");
			ok = false;
		}
    	_data.setT4(InputVerifyUtil.getDouble(t3TextField));

		if (!VerifyUtil.largeThan(this.t4TextField, 0.0d)) {
			errMsg.add("T4 <= 0.0");
			ok = false;
		}
    	_data.setT4(InputVerifyUtil.getDouble(t4TextField));
    	
		if (!VerifyUtil.largeThan(this.teTextField, 0.0d)) {
			errMsg.add("Te <= 0.0");
			ok = false;
		}
    	_data.setTe(InputVerifyUtil.getDouble(teTextField));

		if (!VerifyUtil.largeThan(this.trTextField, 0.0d)) {
			errMsg.add("Tr <= 0.0");
			ok = false;
		}
    	_data.setTr(InputVerifyUtil.getDouble(trTextField));

		if (!VerifyUtil.largeThan(this.aeTextField, 0.0d)) {
			errMsg.add("Ae <= 0.0");
			ok = false;
		}
    	_data.setAe(InputVerifyUtil.getDouble(aeTextField));

		if (!VerifyUtil.largeThan(this.beTextField, 0.0d)) {
			errMsg.add("Be <= 0.0");
			ok = false;
		}
    	_data.setBe(InputVerifyUtil.getDouble(beTextField));
    	return ok;
	}
    
	/** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        vrmaxLabel = new javax.swing.JLabel();
        vrmaxTextField = new javax.swing.JTextField();
        vrminLabel = new javax.swing.JLabel();
        vrminTextField = new javax.swing.JTextField();
        mu0Label = new javax.swing.JLabel();
        mu0TextField = new javax.swing.JTextField();
        t1Label = new javax.swing.JLabel();
        t1TextField = new javax.swing.JTextField();
        t2Label = new javax.swing.JLabel();
        t2TextField = new javax.swing.JTextField();
        t3Label = new javax.swing.JLabel();
        t3TextField = new javax.swing.JTextField();
        t4Label = new javax.swing.JLabel();
        t4TextField = new javax.swing.JTextField();
        teLabel = new javax.swing.JLabel();
        teTextField = new javax.swing.JTextField();
        trLabel = new javax.swing.JLabel();
        trTextField = new javax.swing.JTextField();
        aeLabel = new javax.swing.JLabel();
        aeTextField = new javax.swing.JTextField();
        beLabel = new javax.swing.JLabel();
        beTextField = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        vrmaxLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        vrmaxLabel.setText("Vrmax(pu)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 20);
        add(vrmaxLabel, gridBagConstraints);

        vrmaxTextField.setColumns(5);
        vrmaxTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        vrmaxTextField.setText("-10.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(vrmaxTextField, gridBagConstraints);

        vrminLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        vrminLabel.setText("Vrmin(pu)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 20);
        add(vrminLabel, gridBagConstraints);

        vrminTextField.setColumns(5);
        vrminTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        vrminTextField.setText("0.05");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(vrminTextField, gridBagConstraints);

        mu0Label.setFont(new java.awt.Font("Dialog", 0, 12));
        mu0Label.setText("Mu0(pu)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 20);
        add(mu0Label, gridBagConstraints);

        mu0TextField.setColumns(5);
        mu0TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        mu0TextField.setText("20.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(mu0TextField, gridBagConstraints);

        t1Label.setFont(new java.awt.Font("Dialog", 0, 12));
        t1Label.setText("T1(s)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 20);
        add(t1Label, gridBagConstraints);

        t1TextField.setColumns(5);
        t1TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        t1TextField.setText("0.05");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(t1TextField, gridBagConstraints);

        t2Label.setFont(new java.awt.Font("Dialog", 0, 12));
        t2Label.setText("T2(s)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 20);
        add(t2Label, gridBagConstraints);

        t2TextField.setColumns(5);
        t2TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        t2TextField.setText("0.15");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(t2TextField, gridBagConstraints);

        t3Label.setFont(new java.awt.Font("Dialog", 0, 12));
        t3Label.setText("T3(s)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 20);
        add(t3Label, gridBagConstraints);

        t3TextField.setColumns(5);
        t3TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        t3TextField.setText("0.05");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(t3TextField, gridBagConstraints);

        t4Label.setFont(new java.awt.Font("Dialog", 0, 12));
        t4Label.setText("T4(s)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 20);
        add(t4Label, gridBagConstraints);

        t4TextField.setColumns(5);
        t4TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        t4TextField.setText("0.2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(t4TextField, gridBagConstraints);

        teLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        teLabel.setText("Te(s)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 20);
        add(teLabel, gridBagConstraints);

        teTextField.setColumns(5);
        teTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        teTextField.setText("0.05");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(teTextField, gridBagConstraints);

        trLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        trLabel.setText("Tr(s)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 20);
        add(trLabel, gridBagConstraints);

        trTextField.setColumns(5);
        trTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        trTextField.setText("0.1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(trTextField, gridBagConstraints);

        aeLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        aeLabel.setText("Ae");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 20);
        add(aeLabel, gridBagConstraints);

        aeTextField.setColumns(5);
        aeTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        aeTextField.setText("1.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(aeTextField, gridBagConstraints);

        beLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        beLabel.setText("Be");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 20);
        add(beLabel, gridBagConstraints);

        beTextField.setColumns(5);
        beTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        beTextField.setText("1.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(beTextField, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aeLabel;
    private javax.swing.JTextField aeTextField;
    private javax.swing.JLabel beLabel;
    private javax.swing.JTextField beTextField;
    private javax.swing.JLabel mu0Label;
    private javax.swing.JTextField mu0TextField;
    private javax.swing.JLabel t1Label;
    private javax.swing.JTextField t1TextField;
    private javax.swing.JLabel t2Label;
    private javax.swing.JTextField t2TextField;
    private javax.swing.JLabel t3Label;
    private javax.swing.JTextField t3TextField;
    private javax.swing.JLabel t4Label;
    private javax.swing.JTextField t4TextField;
    private javax.swing.JLabel teLabel;
    private javax.swing.JTextField teTextField;
    private javax.swing.JLabel trLabel;
    private javax.swing.JTextField trTextField;
    private javax.swing.JLabel vrmaxLabel;
    private javax.swing.JTextField vrmaxTextField;
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
    			if ( input == mu0TextField ||
    	    		 input == t1TextField ||
             		 input == t2TextField ||
             		 input == t3TextField ||
             		 input == t4TextField ||
             		 input == teTextField ||
             		 input == trTextField ||
             		 input == aeTextField ||
             		 input == beTextField ||
             		 input == vrmaxTextField ||
             		 input == vrminTextField )
    	       		return InputVerifyUtil.getDouble((javax.swing.JTextField)input) >= 0.0;
 	       	} catch (Exception e) {
 	    		return false;
 	       	}		
			return true;
        }
    }
}
