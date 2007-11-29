 /*
  * @(#)NBAcscTransBranchEditPanel.java   
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

package org.interpss.editor.ui.edit.trans.branch;
  
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.interpss.editor.data.acsc.AcscBranchData;
import org.interpss.editor.form.GBranchForm;
import org.interpss.editor.form.GFormContainer;
import org.interpss.editor.form.GNetForm;
import org.interpss.editor.jgraph.ui.edit.IFormDataPanel;
import org.interpss.editor.jgraph.ui.form.IGBranchForm;
import org.interpss.editor.ui.edit.common.NBCustomScriptEditPanel;

import com.interpss.common.util.IpssLogger;
 
public class NBAcscTransBranchEditPanel extends javax.swing.JPanel implements IFormDataPanel {
	private static final long serialVersionUID = 1;
	private JDialog parent = null;

    private GFormContainer _netContainer = null;
    private AcscBranchData  _data = null;
    
    private NBBranchPositivePanel _positiveEditPanel = new NBBranchPositivePanel();
    private NBBranchScDataPanel   _scEditPanel = new NBBranchScDataPanel();
    private NBCustomScriptEditPanel customScriptEditPanel = new NBCustomScriptEditPanel();
    
	public void initPanel(JDialog aParent) {
		parent = aParent;

		customScriptEditPanel.initPanel(aParent);
		this.scriptPanel.add(customScriptEditPanel);
		
		_positiveEditPanel.initPanel(parent);
		_positiveEditPanel.disableScripting();
		_scEditPanel.initPanel(parent, this);
    	scInfoEditPanel.add(_scEditPanel);
	    
	    branchInfoEditTabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (branchInfoEditTabbedPane.getSelectedIndex() == 0) {
					IpssLogger.getLogger().info("Loadflow Info Tab selected");
					try {
						Vector<String> errMsg = new Vector<String>();
						_scEditPanel.saveEditor2Form(errMsg);
					} catch (Exception exc) {}	
				    _positiveEditPanel.setForm2Editor();
				}
				else if (branchInfoEditTabbedPane.getSelectedIndex() == 1) {
					IpssLogger.getLogger().info("Short Circut Info Tab selected");
					try {
						Vector<String> errMsg = new Vector<String>();
						_positiveEditPanel.saveEditor2Form(errMsg);
					} catch (Exception exc) {}	
				    _scEditPanel.setForm2Editor();
				}
			}});
	}
    
	public void init(Object netContainer, Object form) {
		IpssLogger.getLogger().info("AcscTransBranchEditPanel init() called");
		_netContainer = (GFormContainer)netContainer;
		_data = ((GBranchForm)form).getAcscBranchData();
		
		customScriptEditPanel.init(_data, NBCustomScriptEditPanel.Type.AcscBranch);

		if (((GNetForm)((GFormContainer)netContainer).getGNetForm()).getAcscNetData().isHasAclfData()) {
	    	branchInfoEditTabbedPane.setEnabledAt(0, true);
	    	lfInfoEditPanel.add(_positiveEditPanel);
		    _positiveEditPanel.init(netContainer, form);
	    }
	    else {
	    	branchInfoEditTabbedPane.setEnabledAt(0, false);
	    }
    	
	    _scEditPanel.init(netContainer, form);
        branchInfoEditTabbedPane.setSelectedIndex(1);
    	setScriptPanelStatus(false);
	}
	
	public void setScriptPanelStatus(boolean b) {
        branchInfoEditTabbedPane.setEnabledAt(2, b);
        if (b) {
    		if (_data.getLfCode().equals(IGBranchForm.TransBranchCode_Scripting)) {
    			this.customScriptEditPanel.setForm2Editor();
    		}	
        }
	}
	
    public boolean setForm2Editor() {
		IpssLogger.getLogger().info("AcscTransBranchEditPanel setForm2Editor() called");
	    
		_scEditPanel.setForm2Editor();
		if (_data.getLfCode().equals(IGBranchForm.TransBranchCode_Scripting)) {
			this.customScriptEditPanel.setForm2Editor();
		}	
		
	    if (((GNetForm)_netContainer.getGNetForm()).getAcscNetData().isHasAclfData() ) {
	    	_positiveEditPanel.setForm2Editor();
	    }
		return true;
	}
    
    public boolean saveEditor2Form(Vector<String> errMsg) throws Exception {
		IpssLogger.getLogger().info("AcscTransBranchEditPanel saveEditor2Form() called");
	    if (((GNetForm)_netContainer.getGNetForm()).getAcscNetData().isHasAclfData() ) {
		    _positiveEditPanel.saveEditor2Form(errMsg);
	    }

	    _scEditPanel.saveEditor2Form(errMsg);
		if (_data.getLfCode().equals(IGBranchForm.TransBranchCode_Scripting)) {
    		this.customScriptEditPanel.saveEditor2Form(errMsg);
		}	

	    return errMsg.size() == 0;
    }
    
    /** Creates new form AclfEditPanel */
    public NBAcscTransBranchEditPanel() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        branchInfoEditTabbedPane = new javax.swing.JTabbedPane();
        lfInfoEditPanel = new javax.swing.JPanel();
        scInfoEditPanel = new javax.swing.JPanel();
        scriptPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        branchInfoEditTabbedPane.setFont(new java.awt.Font("Dialog", 0, 12));
        branchInfoEditTabbedPane.setName("branchInfoEditTabbedPane"); // NOI18N
        branchInfoEditTabbedPane.addTab("Loadflow", lfInfoEditPanel);
        branchInfoEditTabbedPane.addTab("Short Circuit", scInfoEditPanel);
        branchInfoEditTabbedPane.addTab("SC Branch Scripting", scriptPanel);

        branchInfoEditTabbedPane.setSelectedIndex(1);

        add(branchInfoEditTabbedPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane branchInfoEditTabbedPane;
    private javax.swing.JPanel lfInfoEditPanel;
    private javax.swing.JPanel scInfoEditPanel;
    private javax.swing.JPanel scriptPanel;
    // End of variables declaration//GEN-END:variables
}	
