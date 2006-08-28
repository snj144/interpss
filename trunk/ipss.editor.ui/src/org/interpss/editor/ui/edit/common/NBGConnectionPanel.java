package org.interpss.editor.ui.edit.common;

import java.util.Vector;

import javax.swing.JDialog;

import org.interpss.editor.data.common.XfrConnectData;
import org.interpss.editor.jgraph.ui.edit.IFormDataPanel;


public class NBGConnectionPanel extends javax.swing.JPanel  implements IFormDataPanel {
	private static final long serialVersionUID = 1;
	private JDialog parent = null;

	private XfrConnectData  _data = null;
	
    private NBGroundInputPanel 
    			groundInputPanel = new NBGroundInputPanel();

	public void initPanel(JDialog aParent, String title) {
		parent = aParent;
		
        javax.swing.border.TitledBorder border = 
        	(javax.swing.border.TitledBorder)connectPanel.getBorder();
        border.setTitle(title);	

        deltaRadioButton.setName(title+deltaRadioButton.getName());
		wyeRadioButton.setName(title+wyeRadioButton.getName());
        
        groundInputPanel.initPanel();
    }
    
	public void init(Object netContainer, Object form) {
		_data = (XfrConnectData)form;
		groundInputPanel.init(netContainer, _data.getGrounding());
	}
	
    public boolean setForm2Editor() {
    	if (_data.getCode().equals(XfrConnectData.Code_Wye) ) {
    		this.wyeRadioButton.setSelected(true);
        	groundPanel.add(groundInputPanel, java.awt.BorderLayout.CENTER);
    	}	
    	else {
    		this.deltaRadioButton.setSelected(true);
        	groundPanel.removeAll();
    	}
		parent.pack();

    	groundInputPanel.setForm2Editor();
    	return true;
	}
    
    public boolean saveEditor2Form(Vector errMsg) throws Exception {
		boolean ok = true;
   		if ( this.deltaRadioButton.isSelected() )
   		 	_data.setCode(XfrConnectData.Code_Delta);
   		else
   		 	_data.setCode(XfrConnectData.Code_Wye);

		if (!((IFormDataPanel)groundInputPanel).saveEditor2Form(errMsg))
			ok = false;
    	
		return ok;
    }
    
	// The following code is controlled by NetBean IDE
	// ===============================================
    
    /** Creates new form NBGConnectionPanel */
    public NBGConnectionPanel() {
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

        connectButtonGroup = new javax.swing.ButtonGroup();
        connectPanel = new javax.swing.JPanel();
        deltaRadioButton = new javax.swing.JRadioButton();
        wyeRadioButton = new javax.swing.JRadioButton();
        groundPanel = new javax.swing.JPanel();

        setLayout(new java.awt.GridBagLayout());

        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        connectPanel.setBorder(new javax.swing.border.TitledBorder(null, "title", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 10)));
        connectButtonGroup.add(deltaRadioButton);
        deltaRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        deltaRadioButton.setSelected(true);
        deltaRadioButton.setText("Delta Connection");
        deltaRadioButton.setName("deltaRadioButton");
        deltaRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deltaConnectionActionHandler(evt);
            }
        });

        connectPanel.add(deltaRadioButton);

        connectButtonGroup.add(wyeRadioButton);
        wyeRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        wyeRadioButton.setText("Wye Connection");
        wyeRadioButton.setName("wyeRadioButton");
        wyeRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wyeConnectionActionHandler(evt);
            }
        });

        connectPanel.add(wyeRadioButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        add(connectPanel, gridBagConstraints);

        groundPanel.setLayout(new java.awt.BorderLayout());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        add(groundPanel, gridBagConstraints);

    }
    // </editor-fold>//GEN-END:initComponents

    private void wyeConnectionActionHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wyeConnectionActionHandler
        groundPanel.add(groundInputPanel, java.awt.BorderLayout.CENTER);
		parent.pack();
	}//GEN-LAST:event_wyeConnectionActionHandler

    private void deltaConnectionActionHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deltaConnectionActionHandler
        groundPanel.removeAll();
        parent.pack();
    }//GEN-LAST:event_deltaConnectionActionHandler
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup connectButtonGroup;
    private javax.swing.JPanel connectPanel;
    private javax.swing.JRadioButton deltaRadioButton;
    private javax.swing.JPanel groundPanel;
    private javax.swing.JRadioButton wyeRadioButton;
    // End of variables declaration//GEN-END:variables
    
}
