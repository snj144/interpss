package org.interpss.editor.ui.run.common;

import java.util.Vector;

import org.interpss.editor.data.dstab.DStabLoadChangeData;
import org.interpss.editor.form.GFormContainer;

import com.interpss.common.ui.VerifyUtil;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.Num2Str;
import com.interpss.editor.jgraph.ui.edit.IFormDataPanel;

/**
 *
 * @author  mzhou
 */

public class NBDStabLoadChangePanel extends javax.swing.JPanel implements IFormDataPanel{
	private static final long serialVersionUID = 1;

	private GFormContainer _netContainer = null;
	private DStabLoadChangeData _loadChangeData = null;
	
    /** Creates new form FaultLocDataPanel */
    public NBDStabLoadChangePanel() {
        initComponents();

  		DataVerifier verifier = new DataVerifier();
      	this.changeFactorTextField.setInputVerifier(verifier);
    }
    
	public void init(Object netContainer, Object _null) {
		IpssLogger.getLogger().info("NBDStabLoadChangePanel init() called");

		_netContainer = (GFormContainer)netContainer;
      
    	Object[] busNameId = _netContainer.getLoadBusNameIdArray();
    	if (busNameId.length > 0)
    		this.loadBusComboBox.setModel(new javax.swing.DefaultComboBoxModel(busNameId));
	}
	
	public void setLoadChangeData(DStabLoadChangeData data) {
		_loadChangeData = data;
	}
	
	/**
	*	Set form data to the editor
	*
	* @return false if there is any problem
	*/
    public boolean setForm2Editor() {
		IpssLogger.getLogger().info("NBDStabLoadChangePanel setForm2Editor() called");

        if (_loadChangeData.getBusNameId().equals("")) {
            IpssLogger.getLogger().info("loadBusComboBox.getSelectedItem() -> " + loadBusComboBox.getSelectedItem());
            this.loadBusComboBox.setSelectedIndex(0);
        }    
        else
             this.loadBusComboBox.setSelectedItem(_loadChangeData.getBusNameId());
        
       	changeFactorTextField.setText(Num2Str.toStr(_loadChangeData.getChangeFactor(), "#0.0"));        

       	return true;
	}
    
	/**
	*	Save editor screen data to the form
	*
	* @param errMsg error messages during the saving process.
	* @return false if there is any problem
	*/
    public boolean saveEditor2Form(Vector errMsg) throws Exception {
		IpssLogger.getLogger().info("NBDStabLoadChangePanel saveEditor2Form() called");

		boolean ok = true;

		_loadChangeData.setBusNameId((String)this.loadBusComboBox.getSelectedItem());
		
		if (this.changeFactorTextField.isEnabled()) {
			if (!VerifyUtil.largeThan(this.changeFactorTextField, 0.0d)) {
				errMsg.add("Branch fault distance < 0.0");
				ok = false;
			}
			_loadChangeData.setChangeFactor(VerifyUtil.getDouble(this.changeFactorTextField));
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
        busLoadChangePanel = new javax.swing.JPanel();
        loadBusLabel = new javax.swing.JLabel();
        loadBusComboBox = new javax.swing.JComboBox();
        loadChangeDataPanel = new javax.swing.JPanel();
        changeFactorGLabel = new javax.swing.JLabel();
        changeFactorTextField = new javax.swing.JTextField();
        changeFactorUnitLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        loadBusLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        loadBusLabel.setText("Load Bus   ");
        loadBusLabel.setPreferredSize(new java.awt.Dimension(70, 25));
        busLoadChangePanel.add(loadBusLabel);

        loadBusComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        loadBusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Load Bus" }));
        loadBusComboBox.setName("faultBusComboBox");
        busLoadChangePanel.add(loadBusComboBox);

        add(busLoadChangePanel, java.awt.BorderLayout.NORTH);

        changeFactorGLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        changeFactorGLabel.setText("Change Factor     ");
        loadChangeDataPanel.add(changeFactorGLabel);

        changeFactorTextField.setColumns(8);
        changeFactorTextField.setText("100.0");
        changeFactorTextField.setName("rLGTextField");
        loadChangeDataPanel.add(changeFactorTextField);

        changeFactorUnitLabel1.setFont(new java.awt.Font("Dialog", 0, 12));
        changeFactorUnitLabel1.setText("%");
        loadChangeDataPanel.add(changeFactorUnitLabel1);

        add(loadChangeDataPanel, java.awt.BorderLayout.SOUTH);

    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel busLoadChangePanel;
    private javax.swing.JLabel changeFactorGLabel;
    private javax.swing.JTextField changeFactorTextField;
    private javax.swing.JLabel changeFactorUnitLabel1;
    private javax.swing.JComboBox loadBusComboBox;
    private javax.swing.JLabel loadBusLabel;
    private javax.swing.JPanel loadChangeDataPanel;
    // End of variables declaration//GEN-END:variables

	class DataVerifier extends javax.swing.InputVerifier {
    	public boolean verify(javax.swing.JComponent input) {
			if (input == null)
				return false;
       		try {
       			if (input == changeFactorTextField )
 	       			return VerifyUtil.getDouble((javax.swing.JTextField)input) > 0.0;
 	       	} catch (Exception e) {
 	    		return false;
 	       	}		
			return true;
        }
    }
}
