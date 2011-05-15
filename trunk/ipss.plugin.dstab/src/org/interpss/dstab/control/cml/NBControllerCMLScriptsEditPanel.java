 /*
  * @(#)NBControllerScriptsEditPanel.java   
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
  * @Date 05/01/2007
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.dstab.control.cml;

import java.util.Vector;

import org.interpss.editor.ui.util.GUIFileUtil;
import org.interpss.ui.ICustomPluginEditor;

import com.interpss.dstab.controller.ICMLScriptingController;

public class NBControllerCMLScriptsEditPanel extends javax.swing.JPanel implements ICustomPluginEditor {
	private static final long serialVersionUID = 1;

	private AbstractCMLScriptingController controller = null;
	
    /** Creates new form FaultLocDataPanel */
    public NBControllerCMLScriptsEditPanel() {
        initComponents();
    }
    
    /**
     * Init the editor panel, which will be called from its parent editor
     */
	public void init(Object cntler) {
		this.controller = (AbstractCMLScriptingController)cntler;
    	if (controller.getScripts() == null || controller.getScripts().trim().equals(""))
    		loadTemplate2Textarea();
	}
	
	/**
	*	Set controller data to the editor
	*
	* @return false if there is any problem
	*/
    public boolean setData2Editor(String desc) {
    	if (controller.getScripts() == null || controller.getScripts().trim().equals(""))
    		loadTemplate2Textarea();
    	else
    		scriptsTextArea.setText(controller.getScripts());
        return true;
	}
    
    private void loadTemplate2Textarea() {
		String filename = ICMLScriptingController.ExciterTemplateFilename;
		if (controller instanceof CMLScriptingGovernor)
    		filename = ICMLScriptingController.GovernorTemplateFilename;
		else if (controller instanceof CMLScriptingStabilizer)
    		filename = ICMLScriptingController.StabilizerTemplateFilename;
		GUIFileUtil.readFile2TextareaRativePath(filename, scriptsTextArea);
    }
    
	/**
	*	Save editor screen data to the controller data object
	*
	* @param errMsg error messages during the saving process.
	* @return false if there is any problem
	*/
    public boolean saveEditorData(Vector<String> errMsg) throws Exception {
    	errMsg.clear();
    	//IpssLogger.getLogger().info(scriptsTextArea.getText());
    	controller.setScripts(scriptsTextArea.getText());
    	// we compile the JavaCode here to make sure that there is no syntax error.
    	if (!controller.checkJavaCode()) {
        	errMsg.add(new String("Java compile error"));
    		return false;
    	}	
    	return true;
	}
    
	/** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        testAreaScrollPane = new javax.swing.JScrollPane();
        scriptsTextArea = new javax.swing.JTextArea();

        scriptsTextArea.setColumns(80);
        scriptsTextArea.setFont(new java.awt.Font("Courier New", 0, 12));
        scriptsTextArea.setRows(25);
        scriptsTextArea.setTabSize(3);
        testAreaScrollPane.setViewportView(scriptsTextArea);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(testAreaScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(testAreaScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea scriptsTextArea;
    private javax.swing.JScrollPane testAreaScrollPane;
    // End of variables declaration//GEN-END:variables
}
