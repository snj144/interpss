package org.interpss.editor.ui.edit.trans.dstab;
  
/**
 *
 */
import java.awt.Component;
import java.util.Vector;

import javax.swing.JDialog;

import org.interpss.editor.data.dstab.DStabBusData;
import org.interpss.editor.data.dstab.DStabGovData;
import org.interpss.editor.data.dstab.DStabMachData;
import org.interpss.editor.form.InitDataUtil;

import com.interpss.common.ui.IControllerEditor;
import com.interpss.common.util.IpssLogger;
import com.interpss.dstab.mach.Controller;
import com.interpss.editor.jgraph.ui.edit.IFormDataPanel;
import com.interpss.simu.util.SimuSpringAppCtxUtil;
 
public class NBGovernorPanel extends javax.swing.JPanel implements IFormDataPanel {
	private static final long serialVersionUID = 1;
	private JDialog parent = null;

    private DStabMachData machData = null;
	private Controller controller = null;
    
	public void initPanel(JDialog aParent) {
		parent = aParent;
	}
    
	public void init(Object netContainer, Object busData) {
		IpssLogger.getLogger().info("NBGovernorPanel init() called");
		machData = ((DStabBusData)busData).getMachData();
	    catyListComboBox.setModel(new javax.swing.DefaultComboBoxModel(
	    		SimuSpringAppCtxUtil.getGovernorCategoryList()));	
	    typeListComboBox.setModel(new javax.swing.DefaultComboBoxModel(
	    		SimuSpringAppCtxUtil.getGovernorNameList()));	
		if (machData.getHasGov()) {
			controller = SimuSpringAppCtxUtil.getGovernor(machData.getGovData().getTypeName());
		}	    
	}
	
	private void setEditPanel(String typeName) {
		Controller aController = SimuSpringAppCtxUtil.getGovernor(typeName);
   		if (controller == null || aController.getClass() != controller.getClass()) {
   			IpssLogger.getLogger().info("NBGovernorPanel create a new controller class, " + aController.getName());
   			controller = aController;
   		  	InitDataUtil.initDStabControllerData(machData.getGovData(), typeName, controller);
   		}	
   		controller.setData(machData.getGovData().getDataXmlStr(), controller.getDataClass());
		dataPanel.removeAll();
		dataPanel.add((Component)controller.getEditPanel());
	}
	
    public boolean setForm2Editor() {
		IpssLogger.getLogger().info("NBGovernorPanel setForm2Editor() called");

		DStabGovData data = machData.getGovData();

		String typeName = data.getTypeName();
		//System.out.println("----->curent gov type name: " + typeName);
		if (typeName != null && !typeName.trim().equals("")) {
			// TODO: we need check typename collision here
	    	typeListComboBox.setSelectedItem(typeName);
		}
		else 
			typeListComboBox.setSelectedIndex(0);
		
		typeName = (String)typeListComboBox.getSelectedItem();
    	setEditPanel(typeName);  // a new controller instance is always created

    	((IControllerEditor)controller.getEditPanel()).setData2Editor();

    	return true;
	}
    
    public boolean saveEditor2Form(Vector errMsg) throws Exception {
		IpssLogger.getLogger().info("NBGovernorPanel saveEditor2Form() called");

		boolean ok = true;
		
   		machData.getGovData().setTypeName((String)typeListComboBox.getSelectedItem());
		
    	if (!((IControllerEditor)controller.getEditPanel()).saveEditorData(errMsg)) {
    		ok = false;
    	}
    	machData.getGovData().setDataXmlStr(controller.getDataXmlString());

		return ok;
    }
    
    /** Creates new form AclfEditPanel */
    public NBGovernorPanel() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        selectPanel = new javax.swing.JPanel();
        catyLabel = new javax.swing.JLabel();
        catyListComboBox = new javax.swing.JComboBox();
        typeLabel = new javax.swing.JLabel();
        typeListComboBox = new javax.swing.JComboBox();
        dataPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        selectPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 20));

        catyLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        catyLabel.setText("Category");
        selectPanel.add(catyLabel);

        catyListComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        catyListComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));
        catyListComboBox.setName("typeListComboBox");
        catyListComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catyListComboBoxActionPerformed(evt);
            }
        });

        selectPanel.add(catyListComboBox);

        typeLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        typeLabel.setText("     Type");
        selectPanel.add(typeLabel);

        typeListComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        typeListComboBox.setName("typeListComboBox");
        typeListComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeListComboBoxActionPerformed(evt);
            }
        });

        selectPanel.add(typeListComboBox);

        add(selectPanel, java.awt.BorderLayout.NORTH);

        add(dataPanel, java.awt.BorderLayout.CENTER);

    }// </editor-fold>//GEN-END:initComponents

    private void catyListComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catyListComboBoxActionPerformed
    	String catyName = (String)catyListComboBox.getSelectedItem();
	    if (catyName.equals("All")) {
	    	typeListComboBox.setModel(new javax.swing.DefaultComboBoxModel(
		    		SimuSpringAppCtxUtil.getGovernorNameList()));	
	    }
	    else {
	    	typeListComboBox.setModel(new javax.swing.DefaultComboBoxModel(
		    		SimuSpringAppCtxUtil.getGovernorNameList(catyName)));	
	    }
	    parent.pack();
    }//GEN-LAST:event_catyListComboBoxActionPerformed

    private void typeListComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeListComboBoxActionPerformed
    	String typeName = (String)typeListComboBox.getSelectedItem();
    	setEditPanel(typeName);
    	parent.pack();
    }//GEN-LAST:event_typeListComboBoxActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel catyLabel;
    private javax.swing.JComboBox catyListComboBox;
    private javax.swing.JPanel dataPanel;
    private javax.swing.JPanel selectPanel;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JComboBox typeListComboBox;
    // End of variables declaration//GEN-END:variables
}
