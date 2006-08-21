package com.interpss.editor.ui.edit.trans.bus;
  
/**
 *
 */
import java.util.Vector;

import javax.swing.JDialog;

import com.interpss.common.ui.VerifyUtil;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.Num2Str;
import com.interpss.editor.data.acsc.AcscBusData;
import com.interpss.editor.form.GBusForm;
import com.interpss.editor.form.GFormContainer;
import com.interpss.editor.form.GNetForm;
import com.interpss.editor.jgraph.ui.edit.IFormDataPanel;
import com.interpss.editor.ui.edit.common.NBGroundInputPanel;
 
 
public class NBAcscTransBusEditPanel extends javax.swing.JPanel implements IFormDataPanel {
	private static final long serialVersionUID = 1;
	private JDialog parent = null;

    private GFormContainer _netContainer = null;
    private GBusForm _form = null;
    private AcscBusData _data = null;
    
    private NBAclfTransBusEditPanel _aclfTransBusEditPanel = new NBAclfTransBusEditPanel();
    private NBGroundInputPanel _groundPanel = new NBGroundInputPanel();

	public void initPanel(JDialog aParent) {
		parent = aParent;
		
		_aclfTransBusEditPanel.initPanel(aParent);
		_groundPanel.initPanel();
		
		DataVerifier verifier = new DataVerifier();
	    r0TextField.setInputVerifier(verifier);
	    r1TextField.setInputVerifier(verifier);
	    r2TextField.setInputVerifier(verifier);
	    x0TextField.setInputVerifier(verifier);
	    x1TextField.setInputVerifier(verifier);
	    x2TextField.setInputVerifier(verifier);
	}
    
	public void init(Object netContainer, Object form) {
		IpssLogger.getLogger().info("NBAcscTransBusEditPanel init() called");
		_netContainer = (GFormContainer)netContainer;
		_form = (GBusForm)form;
		_data = _form.getAcscBusData();
		
	    if (((GNetForm)((GFormContainer)netContainer).getGNetForm()).getAcscNetData().isHasAclfData()) {
	    	acscTabbedPane.setEnabledAt(0, true);
	    	aclfInfoEditPanel.add(_aclfTransBusEditPanel);
		    _aclfTransBusEditPanel.init(_netContainer, _form);
	    }
	    else {
	    	acscTabbedPane.setEnabledAt(0, false);
	    }
	    
		_groundPanel.init(_netContainer, _data.getGround());
	}
	
    public boolean setForm2Editor() {
		IpssLogger.getLogger().info("NBAcscTransBusEditPanel setForm2Editor() called");
	    if (((GNetForm)_netContainer.getGNetForm()).getAcscNetData().isHasAclfData()) {
	    	_aclfTransBusEditPanel.setForm2Editor();
	    }

	    if (_data.getScCode().equals(AcscBusData.ScCode_Contribute)) {
	        contributeRadioButton.setSelected(true);

	        setRXLabelText(true);

		    r1TextField.setText(Num2Str.toStr(_data.getZ1R(), "#0.0####"));
		    x1TextField.setText(Num2Str.toStr(_data.getZ1X(), "#0.0####"));

		    r0TextField.setText(Num2Str.toStr(_data.getZ0R(), "#0.0####"));
		    x0TextField.setText(Num2Str.toStr(_data.getZ0X(), "#0.0####"));

		    r2TextField.setText(Num2Str.toStr(_data.getZ2R(), "#0.0####"));
		    x2TextField.setText(Num2Str.toStr(_data.getZ2X(), "#0.0####"));

		    groundingPanel.add(_groundPanel);
		    _groundPanel.setForm2Editor();
	    }
	    else {
	        nonContributeRadioButton.setSelected(true);
	        setRXLabelText(false);
	    	groundingPanel.remove(_groundPanel);
	    }
	    parent.pack();
	    return true;
	}
    
    public boolean saveEditor2Form(Vector errMsg) throws Exception {
		IpssLogger.getLogger().info("NBAcscTransBusEditPanel saveEditor2Form() called");
		boolean ok = true;
		
	    if (((GNetForm)_netContainer.getGNetForm()).getAcscNetData().isHasAclfData()) {
	    	if (!_aclfTransBusEditPanel.saveEditor2Form(errMsg))
	    		ok = false;
	    }

	    if (_data.getScCode().equals(AcscBusData.ScCode_Contribute)) {
			if (!VerifyUtil.largeEqualThan(r1TextField, 0.0d)) {
				errMsg.add("Xfr R1 < 0.0");
				ok = false;
			}
			_data.setZ1R(VerifyUtil.getDouble(r1TextField));

			if (!VerifyUtil.largeThan(x1TextField, 0.0d)) {
				errMsg.add("Xfr X1 <= 0.0");
				ok = false;
			}
			_data.setZ1X(VerifyUtil.getDouble(x1TextField));

			if (!VerifyUtil.largeEqualThan(r0TextField, 0.0d)) {
				errMsg.add("Xfr R0 < 0.0");
				ok = false;
			}
			_data.setZ0R(VerifyUtil.getDouble(r0TextField));

			if (!VerifyUtil.largeThan(x0TextField, 0.0d)) {
				errMsg.add("Xfr X1 <= 0.0");
				ok = false;
			}
			_data.setZ0X(VerifyUtil.getDouble(x0TextField));

			if (!VerifyUtil.largeEqualThan(r2TextField, 0.0d)) {
				errMsg.add("Xfr R2 < 0.0");
				ok = false;
			}
			_data.setZ2R(VerifyUtil.getDouble(r2TextField));

			if (!VerifyUtil.largeThan(x2TextField, 0.0d)) {
				errMsg.add("Xfr X2 <= 0.0");
				ok = false;
			}
			_data.setZ2X(VerifyUtil.getDouble(x2TextField));

			if (!_groundPanel.saveEditor2Form(errMsg))
		    	ok = false;
	    }

	    return ok;
    }
    
    /** Creates new form AclfEditPanel */
    public NBAcscTransBusEditPanel() {
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

        scBusTypeButtonGroup = new javax.swing.ButtonGroup();
        acscTabbedPane = new javax.swing.JTabbedPane();
        aclfInfoEditPanel = new javax.swing.JPanel();
        acscInfoEditPanel = new javax.swing.JPanel();
        scBusTypePanel = new javax.swing.JPanel();
        contributeRadioButton = new javax.swing.JRadioButton();
        nonContributeRadioButton = new javax.swing.JRadioButton();
        scBusInfojPanel = new javax.swing.JPanel();
        r1Label = new javax.swing.JLabel();
        r1TextField = new javax.swing.JTextField();
        x1Label = new javax.swing.JLabel();
        x1TextField = new javax.swing.JTextField();
        r2Label = new javax.swing.JLabel();
        r2TextField = new javax.swing.JTextField();
        x2Label = new javax.swing.JLabel();
        x2TextField = new javax.swing.JTextField();
        r0Label = new javax.swing.JLabel();
        r0TextField = new javax.swing.JTextField();
        x0Label = new javax.swing.JLabel();
        x0TextField = new javax.swing.JTextField();
        groundingPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        acscTabbedPane.setName("acscTabbedPane");
        aclfInfoEditPanel.setLayout(new java.awt.BorderLayout());

        acscTabbedPane.addTab("Loadflow", aclfInfoEditPanel);

        acscInfoEditPanel.setLayout(new java.awt.GridBagLayout());

        scBusTypePanel.setBorder(new javax.swing.border.TitledBorder(null, "Sc Bus Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10)));
        scBusTypeButtonGroup.add(contributeRadioButton);
        contributeRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        contributeRadioButton.setText("Contribute     ");
        contributeRadioButton.setName("contributeRadioButton");
        contributeRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contributeRadioButtonActionPerformed(evt);
            }
        });

        scBusTypePanel.add(contributeRadioButton);

        scBusTypeButtonGroup.add(nonContributeRadioButton);
        nonContributeRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        nonContributeRadioButton.setSelected(true);
        nonContributeRadioButton.setText("NonContribute");
        nonContributeRadioButton.setAutoscrolls(true);
        nonContributeRadioButton.setName("nonContributeRadioButton");
        nonContributeRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nonContributeRadioButtonActionPerformed(evt);
            }
        });

        scBusTypePanel.add(nonContributeRadioButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 20, 0);
        acscInfoEditPanel.add(scBusTypePanel, gridBagConstraints);

        scBusInfojPanel.setLayout(new java.awt.GridBagLayout());

        r1Label.setFont(new java.awt.Font("Dialog", 0, 12));
        r1Label.setText("R1(pu)   ");
        scBusInfojPanel.add(r1Label, new java.awt.GridBagConstraints());

        r1TextField.setColumns(8);
        r1TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        r1TextField.setText("0.0");
        r1TextField.setName("r1TextField");
        scBusInfojPanel.add(r1TextField, new java.awt.GridBagConstraints());

        x1Label.setFont(new java.awt.Font("Dialog", 0, 12));
        x1Label.setText("          X1(pu)   ");
        scBusInfojPanel.add(x1Label, new java.awt.GridBagConstraints());

        x1TextField.setColumns(8);
        x1TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        x1TextField.setText("0.0");
        x1TextField.setName("x1TextField");
        scBusInfojPanel.add(x1TextField, new java.awt.GridBagConstraints());

        r2Label.setFont(new java.awt.Font("Dialog", 0, 12));
        r2Label.setText("R2(pu)   ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        scBusInfojPanel.add(r2Label, gridBagConstraints);

        r2TextField.setColumns(8);
        r2TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        r2TextField.setText("0.0");
        r2TextField.setName("r2TextField");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        scBusInfojPanel.add(r2TextField, gridBagConstraints);

        x2Label.setFont(new java.awt.Font("Dialog", 0, 12));
        x2Label.setText("          X2(pu)   ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        scBusInfojPanel.add(x2Label, gridBagConstraints);

        x2TextField.setColumns(8);
        x2TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        x2TextField.setText("0.0");
        x2TextField.setName("x2TextField");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        scBusInfojPanel.add(x2TextField, gridBagConstraints);

        r0Label.setFont(new java.awt.Font("Dialog", 0, 12));
        r0Label.setText("R0(pu)   ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        scBusInfojPanel.add(r0Label, gridBagConstraints);

        r0TextField.setColumns(8);
        r0TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        r0TextField.setText("0.0");
        r0TextField.setName("r0TextField");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        scBusInfojPanel.add(r0TextField, gridBagConstraints);

        x0Label.setFont(new java.awt.Font("Dialog", 0, 12));
        x0Label.setText("          X0(pu)   ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        scBusInfojPanel.add(x0Label, gridBagConstraints);

        x0TextField.setColumns(8);
        x0TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        x0TextField.setText("0.0");
        x0TextField.setName("x0TextField");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        scBusInfojPanel.add(x0TextField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        acscInfoEditPanel.add(scBusInfojPanel, gridBagConstraints);

        groundingPanel.setLayout(new java.awt.BorderLayout());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 20, 0);
        acscInfoEditPanel.add(groundingPanel, gridBagConstraints);

        acscTabbedPane.addTab("Short Circuit", acscInfoEditPanel);

        acscTabbedPane.setSelectedIndex(1);

        add(acscTabbedPane, java.awt.BorderLayout.CENTER);

    }
    // </editor-fold>//GEN-END:initComponents

    private void setRXLabelText(boolean enable) {
        r1Label.setEnabled(enable);
        r1TextField.setEnabled(enable);
        r0Label.setEnabled(enable);
        r0TextField.setEnabled(enable);
        r2Label.setEnabled(enable);
        r2TextField.setEnabled(enable);
        x1Label.setEnabled(enable);
        x1TextField.setEnabled(enable);
        x0Label.setEnabled(enable);
        x0TextField.setEnabled(enable);
        x2Label.setEnabled(enable);
        x2TextField.setEnabled(enable);
        if (!enable) {
            r1TextField.setText("0.0");
            r0TextField.setText("0.0");
            r2TextField.setText("0.0");
            x1TextField.setText("0.0");
            x0TextField.setText("0.0");
            x2TextField.setText("0.0");
        }
    }
    
    private void nonContributeRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nonContributeRadioButtonActionPerformed
    	_data.setScCode(AcscBusData.ScCode_NonContribute);
        setForm2Editor();
    }//GEN-LAST:event_nonContributeRadioButtonActionPerformed

    private void contributeRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contributeRadioButtonActionPerformed
    	_data.setScCode(AcscBusData.ScCode_Contribute);
        setForm2Editor();
    }//GEN-LAST:event_contributeRadioButtonActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aclfInfoEditPanel;
    private javax.swing.JPanel acscInfoEditPanel;
    private javax.swing.JTabbedPane acscTabbedPane;
    private javax.swing.JRadioButton contributeRadioButton;
    private javax.swing.JPanel groundingPanel;
    private javax.swing.JRadioButton nonContributeRadioButton;
    private javax.swing.JLabel r0Label;
    private javax.swing.JTextField r0TextField;
    private javax.swing.JLabel r1Label;
    private javax.swing.JTextField r1TextField;
    private javax.swing.JLabel r2Label;
    private javax.swing.JTextField r2TextField;
    private javax.swing.JPanel scBusInfojPanel;
    private javax.swing.ButtonGroup scBusTypeButtonGroup;
    private javax.swing.JPanel scBusTypePanel;
    private javax.swing.JLabel x0Label;
    private javax.swing.JTextField x0TextField;
    private javax.swing.JLabel x1Label;
    private javax.swing.JTextField x1TextField;
    private javax.swing.JLabel x2Label;
    private javax.swing.JTextField x2TextField;
    // End of variables declaration//GEN-END:variables

	class DataVerifier extends javax.swing.InputVerifier {
    	public boolean verify(javax.swing.JComponent input) {
			if (input == null)
				return false;
       		try {
               if ( input == r1TextField ||
          		    input == r2TextField ||
          		    input == r0TextField )
 	       			return VerifyUtil.getDouble((javax.swing.JTextField)input) >= 0.0;
               if ( input == x1TextField ||
          		    input == x2TextField ||
          		    input == x0TextField )
 	       			return VerifyUtil.getDouble((javax.swing.JTextField)input) > 0.0;
 	       	} catch (Exception e) {
 	    		return false;
 	       	}		
			return true;
        }
    }
}
