 /*
  * @(#)NBDStabTransBusEditPanel.java   
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

package org.interpss.editor.ui.edit.trans.bus;
  
import java.util.Vector;

import javax.swing.JDialog;

import org.interpss.editor.data.dstab.DStabMachData;
import org.interpss.editor.form.GBusForm;
import org.interpss.editor.form.GFormContainer;
import org.interpss.editor.jgraph.ui.edit.IFormDataPanel;
import org.interpss.editor.ui.IEditUIEventListener;
import org.interpss.editor.ui.edit.trans.dstab.NBExciterPanel;
import org.interpss.editor.ui.edit.trans.dstab.NBGovernorPanel;
import org.interpss.editor.ui.edit.trans.dstab.NBMachinePanel;
import org.interpss.editor.ui.edit.trans.dstab.NBStabilizerPanel;
import org.interpss.editor.ui.util.ScriptJavacUtilFunc;
import org.interpss.editor.ui.util.EditUIEvent;
import org.interpss.editor.ui.util.GUIFileUtil;
import com.interpss.common.util.IpssLogger;
 
public class NBDStabTransBusEditPanel extends javax.swing.JPanel implements IFormDataPanel, IEditUIEventListener {
	private static final long serialVersionUID = 1;
	private JDialog parent = null;

	public static String DynamicBusDeviceTemplateFilename = "template/DStabCMLDynamicBusDeviceTemplate.txt";;
	
    private GFormContainer _netContainer = null;
    private GBusForm _form = null;
    
    private NBAclfTransBusEditPanel _aclfTransBusEditPanel = new NBAclfTransBusEditPanel();
    private NBMachinePanel          _machPanel = new NBMachinePanel();
    private NBExciterPanel          _excPanel = new NBExciterPanel();
    private NBGovernorPanel         _govPanel = new NBGovernorPanel();
    private NBStabilizerPanel       _pssPanel = new NBStabilizerPanel();

	public void initPanel(JDialog aParent) {
		parent = aParent;
		
		_aclfTransBusEditPanel.initPanel(aParent);
		_aclfTransBusEditPanel.disableScripting();
		_aclfTransBusEditPanel.getEditUIEventContainer().addEditUIEventListener(this);
		
		_machPanel.initPanel(this);
		_excPanel.initPanel(this, parent);
		_govPanel.initPanel(parent);
		_pssPanel.initPanel(parent);
	}
    
	public void init(Object netContainer, Object form) {
		IpssLogger.getLogger().info("DStabTransBusEditPanel init() called");
		_netContainer = (GFormContainer)netContainer;
		_form = (GBusForm)form;
		
	    dstabTabbedPane.setEnabledAt(0, true);
	    aclfInfoEditPanel.add(_aclfTransBusEditPanel);
		_aclfTransBusEditPanel.init(_netContainer, _form);

	    machInfoEditPanel.add(_machPanel);
		_machPanel.init(_netContainer, _form);

	    excInfoEditPanel.add(_excPanel);
		_excPanel.init(_netContainer, _form.getDStabBusData());

	    govInfoEditPanel.add(_govPanel);
		_govPanel.init(_netContainer, _form.getDStabBusData());

	    pssInfoEditPanel.add(_pssPanel);
		_pssPanel.init(_netContainer, _form.getDStabBusData().getMachData());

		setMachTabbedPaneEnabled(false);
		setExcTabbedPaneEnabled(false);
		setGovTabbedPaneEnabled(false);
		setPssTabbedPaneEnabled(false);
		setScriptingTabbedPaneEnabled(false);
	}
	
	public void onEvent(EditUIEvent e) {
		if (e.eventType == EditUIEvent.BusCodeChanged) {
			setTabbedPanel();
		}
	}
	
	private void setTabbedPanel() {
    	if (_form.getDStabBusData().isMachineBus()) {
			if (!dstabTabbedPane.isEnabledAt(1)) {
				setMachTabbedPaneEnabled(true);
		    	if (_machPanel.getDStabBusData().getMachData().getInertia() == 0.0 &&
		    		_machPanel.getDStabBusData().getMachData().getRating() == 0.0) {
		    		_machPanel.getDStabBusData().setMachData(new DStabMachData());
		    	}
			}
	    	_machPanel.setForm2Editor();

    		setExcTabbedPaneEnabled(false);
			setPssTabbedPaneEnabled(false);
    		setGovTabbedPaneEnabled(false);
	    	if (!_form.getDStabBusData().getMachData().getType().equals(DStabMachData.MachType_InfiniteBus) &&
		    	!_form.getDStabBusData().getMachData().getType().equals(DStabMachData.MachType_EConst)	) {
				if (_form.getDStabBusData().getMachData().getHasExc()) { 
		    		setExcTabbedPaneEnabled(true);
		    		// _excPanel.setForm2Editor() enable or disable the PSS panel
		    		/*
			    	if (_form.getDStabBusData().getMachData().getHasPss()) {  
				    	_pssPanel.setForm2Editor();
						setPssTabbedPaneEnabled(true);
			    	}	
			    	*/
		    	}	
		    	
		    	if (_form.getDStabBusData().getMachData().getHasGov()) { 
		    		setGovTabbedPaneEnabled(true);
		    	}
	    	}
	    }
    	else {
			setMachTabbedPaneEnabled(false);
	    	setExcTabbedPaneEnabled(false);
			setPssTabbedPaneEnabled(false);
	    	setGovTabbedPaneEnabled(false);
    	}
	}
	
	public void setMachTabbedPaneEnabled(boolean e) {
	    dstabTabbedPane.setEnabledAt(1, e);
	}

	public void setExcTabbedPaneEnabled(boolean e) {
	    dstabTabbedPane.setEnabledAt(2, e);
		if (e)
			_excPanel.setForm2Editor();
	}
	
	public void setGovTabbedPaneEnabled(boolean e) {
	    dstabTabbedPane.setEnabledAt(3, e);
		if (e)
			_govPanel.setForm2Editor();
	}

	public void setPssTabbedPaneEnabled(boolean e) {
	    dstabTabbedPane.setEnabledAt(4, e);
		if(e)
			_pssPanel.setForm2Editor();
	}

	public void setScriptingTabbedPaneEnabled(boolean e) {
	    dstabTabbedPane.setEnabledAt(5, e);
	    if (e) {
			setMachTabbedPaneEnabled(false);
			setExcTabbedPaneEnabled(false);
			setGovTabbedPaneEnabled(false);
			setPssTabbedPaneEnabled(false);
		}
	    else
	    	setTabbedPanel();
	}

	public boolean setForm2Editor() {
		IpssLogger.getLogger().info("DStabTransBusEditPanel setForm2Editor() called");
    	_aclfTransBusEditPanel.setForm2Editor();
    	
    	scriptingCheckBox.setSelected(_form.getDStabBusData().isDBusScripting());
    	setScriptingTabbedPaneEnabled(_form.getDStabBusData().isDBusScripting());
    	if (_form.getDStabBusData().isDBusScripting()) {
        	if (_form.getDStabBusData().getScripts() == null || _form.getDStabBusData().getScripts().trim().equals("")) {
        		String filename = DynamicBusDeviceTemplateFilename;
        		GUIFileUtil.readFile2TextareaRativePath(filename, scriptTextArea);
        	}
        	else
        		scriptTextArea.setText(_form.getDStabBusData().getScripts());
    	}
    	else {
        	// set the select pane to an enabled pane
        	int selectIndex = dstabTabbedPane.getSelectedIndex();
    	    while (selectIndex > 0 && !dstabTabbedPane.isEnabledAt(selectIndex)) {
    	    	dstabTabbedPane.setSelectedIndex(--selectIndex);
    	    	IpssLogger.getLogger().info("Set selected pane to " + selectIndex);
    	    }
    	}
	    return true;
	}
    
    public boolean saveEditor2Form(Vector<String> errMsg) throws Exception {
		IpssLogger.getLogger().info("DStabTransBusEditPanel saveEditor2Form() called");
    	errMsg.clear();
		boolean ok = true;
		
    	if (!_aclfTransBusEditPanel.saveEditor2Form(errMsg))
    		ok = false;
    	
		_form.getDStabBusData().setDBusScripting(scriptingCheckBox.isSelected());
    	if (scriptingCheckBox.isSelected()) {
        	_form.getDStabBusData().setScripts(scriptTextArea.getText());
        	// we compile the JavaCode here to make sure that there is no syntax error.
    		String javacode = ScriptJavacUtilFunc.parseCMLTag(scriptTextArea.getText(), ScriptJavacUtilFunc.CheckCodeClassname, "");
        	if (!ScriptJavacUtilFunc.checkJavaCode(javacode, ScriptJavacUtilFunc.CMLDynamicBusControllerPackageName)) {
            	errMsg.add(new String("Java compile error"));
        		return false;
        	}
    	}
    	else {
        	if (_form.getDStabBusData().isMachineBus()) {
    	    	if (!_machPanel.saveEditor2Form(errMsg))
    	    		ok = false;

    	    	if (!_form.getDStabBusData().getMachData().getType().equals(DStabMachData.MachType_InfiniteBus) &&
    	    		!_form.getDStabBusData().getMachData().getType().equals(DStabMachData.MachType_EConst)	) {
    	    		if (_form.getDStabBusData().getMachData().getHasExc()) { 
    		    		if (!_excPanel.saveEditor2Form(errMsg))
    		    			ok = false;
    			    	if (_form.getDStabBusData().getMachData().getHasPss())  
    				    	if (!_pssPanel.saveEditor2Form(errMsg))
    				    		ok = false;
    		    	}

    		    	if (_form.getDStabBusData().getMachData().getHasGov()) 
    		    		if (!_govPanel.saveEditor2Form(errMsg))
    		    			ok = false;
    	    	}
    	    }
    	}
    	return ok;
    }
    
    /** Creates new form AclfEditPanel */
    public NBDStabTransBusEditPanel() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        dstabTabbedPane = new javax.swing.JTabbedPane();
        mainEditPanel = new javax.swing.JPanel();
        aclfInfoEditPanel = new javax.swing.JPanel();
        extraInfoEditPanel = new javax.swing.JPanel();
        scriptingCheckBox = new javax.swing.JCheckBox();
        machInfoEditPanel = new javax.swing.JPanel();
        excInfoEditPanel = new javax.swing.JPanel();
        govInfoEditPanel = new javax.swing.JPanel();
        pssInfoEditPanel = new javax.swing.JPanel();
        scriptingEditPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        scriptTextArea = new javax.swing.JTextArea();

        setLayout(new java.awt.BorderLayout());

        dstabTabbedPane.setFont(new java.awt.Font("Dialog", 0, 12));
        dstabTabbedPane.setName("dstabTabbedPane"); // NOI18N

        mainEditPanel.setLayout(new java.awt.BorderLayout(0, 10));
        mainEditPanel.add(aclfInfoEditPanel, java.awt.BorderLayout.NORTH);

        scriptingCheckBox.setFont(new java.awt.Font("Dialog", 0, 12));
        scriptingCheckBox.setText("Dynamic Bus Device Scripting");
        scriptingCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        scriptingCheckBox.setMargin(new java.awt.Insets(10, 0, 10, 0));
        scriptingCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scriptingCheckBoxClicked(evt);
            }
        });
        extraInfoEditPanel.add(scriptingCheckBox);

        mainEditPanel.add(extraInfoEditPanel, java.awt.BorderLayout.SOUTH);

        dstabTabbedPane.addTab("Bus Info", mainEditPanel);

        machInfoEditPanel.setLayout(new java.awt.BorderLayout());
        dstabTabbedPane.addTab("Machin Info", machInfoEditPanel);

        excInfoEditPanel.setLayout(new java.awt.BorderLayout());
        dstabTabbedPane.addTab("Exciter Info", excInfoEditPanel);

        govInfoEditPanel.setLayout(new java.awt.BorderLayout());
        dstabTabbedPane.addTab("Governor Info", govInfoEditPanel);

        pssInfoEditPanel.setLayout(new java.awt.BorderLayout());
        dstabTabbedPane.addTab("PSS Info", pssInfoEditPanel);

        scriptTextArea.setColumns(80);
        scriptTextArea.setFont(new java.awt.Font("Courier New", 0, 12));
        scriptTextArea.setRows(35);
        scriptTextArea.setTabSize(3);
        jScrollPane1.setViewportView(scriptTextArea);

        scriptingEditPanel.add(jScrollPane1);

        dstabTabbedPane.addTab("Bus Device Scripting", scriptingEditPanel);

        add(dstabTabbedPane, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents

    private void scriptingCheckBoxClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scriptingCheckBoxClicked
		setScriptingTabbedPaneEnabled(scriptingCheckBox.isSelected());
    }//GEN-LAST:event_scriptingCheckBoxClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aclfInfoEditPanel;
    private javax.swing.JTabbedPane dstabTabbedPane;
    private javax.swing.JPanel excInfoEditPanel;
    private javax.swing.JPanel extraInfoEditPanel;
    private javax.swing.JPanel govInfoEditPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel machInfoEditPanel;
    private javax.swing.JPanel mainEditPanel;
    private javax.swing.JPanel pssInfoEditPanel;
    private javax.swing.JTextArea scriptTextArea;
    private javax.swing.JCheckBox scriptingCheckBox;
    private javax.swing.JPanel scriptingEditPanel;
    // End of variables declaration//GEN-END:variables
}
