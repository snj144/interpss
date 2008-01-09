 /*
  * @(#)NBOutputTextDialog.java   
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

package org.interpss.display;

import java.awt.Frame;
import java.io.File;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JFileChooser;

import org.interpss.editor.jgraph.ui.IGraphicEditor;
import org.interpss.editor.ui.IOutputTextDialog;
import org.interpss.editor.ui.UISpringAppContext;
import org.interpss.editor.ui.util.GUIFileUtil;
import org.interpss.editor.ui.util.IpssFileFilter;

import com.interpss.common.exp.InvalidOperationException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.msg.IpssMessage;
import com.interpss.common.msg.SimuMessage;
import com.interpss.common.ui.WinUtilities;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.common.util.StringUtil;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.ms_case.MultiStudyCase;
import com.interpss.core.ms_case.StudyCase;
import com.interpss.dist.DistNetwork;
import com.interpss.dstab.DynamicSimuAlgorithm;
import com.interpss.dstab.util.DStabSimuDBRecord;

public class NBOutputTextDialog extends javax.swing.JDialog implements IOutputTextDialog {
	private static final long serialVersionUID = 1;
	
	private IPSSMsgHub msg = null;
	private AclfAdjNetwork aclfAdjNet = null;
	private Object data = null;

	private static JFileChooser saveTextFileChooser = null;

	/**
	*	Constructor for browser dialog
	*/		
    public NBOutputTextDialog(Frame parent, IPSSMsgHub aMsg) {
        super(parent, "", true);
        initDialog("");
        this.msg = aMsg;
    }
    
    public NBOutputTextDialog(IGraphicEditor parent, IPSSMsgHub aMsg) {
        this(parent.getFrame(), aMsg);
    }
    
    public void display(Object aData) {
    	this.data = aData;
        showDialog();
    }
	
    public void showDialog() {
        if (data instanceof DistNetwork) {
        	DistNetwork distNet = (DistNetwork)data;
        	textArea.setText(DistOutFunc.lfSummary(distNet, msg));
        }
        else if (data instanceof DynamicSimuAlgorithm) {
        	DynamicSimuAlgorithm algo = (DynamicSimuAlgorithm)data;
        	textArea.setText(DStabOutFunc.initConditionSummary(algo));
            busStyleRadioButton.setEnabled(false);
            summaryRadioButton.setEnabled(false);
        }
        else if (data instanceof AclfAdjNetwork) {
        	aclfAdjNet = (AclfAdjNetwork)data;
        	textArea.setText(AclfOutFunc.loadFlowSummary(aclfAdjNet));
            busStyleRadioButton.setEnabled(true);
            summaryRadioButton.setEnabled(true);
            summaryRadioButton.setSelected(true);
        }
        else if (data instanceof MultiStudyCase) {
        	MultiStudyCase mcase = (MultiStudyCase)data;
        	textArea.setText("");
        	for (StudyCase scase : mcase.getStudyCaseList()) {
        		aclfAdjNet = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(scase.getNetModelString());
        		textArea.append(AclfOutFunc.loadFlowSummary(aclfAdjNet));
        	}
            busStyleRadioButton.setEnabled(false);
            summaryRadioButton.setEnabled(false);
        }
        // for DStab machine state output
        else if (data instanceof List) {
			appendText(DStabOutFunc.getStateTitleStr()+"\n");
    		List machRecList = (List)data;
        	for (int i = 0; i < machRecList.size(); i++) {
    			DStabSimuDBRecord machRec = (DStabSimuDBRecord)machRecList.get(i);
    			Hashtable machStates = StringUtil.parseStr2Hashtable(machRec.getSimuRec());
            	try {
    				appendText(DStabOutFunc.getStateStr(machStates));
    				IpssLogger.getLogger().fine(DStabOutFunc.getStateStr(machStates));
    			} catch (Exception ex) {
    				IpssLogger.logErr(ex);
    			}
        	}
		}
        else {
        	if (data != null)
        		textArea.setText(data.toString());
        }
        pack();
        setVisible(true);	
    }

    public void onMsgEvent(IpssMessage event) {
   		if (event instanceof SimuMessage) {
   			if (event.getType() == SimuMessage.TYPE_CONSOLE_MSG) {
   				appendText(((SimuMessage)event).getStringData()+"\n"); 
   			}	
   		}    	
    }

    public boolean onMsgEventStatus(IpssMessage aMsg) {
 	   throw new InvalidOperationException("Method not implemented");
    }    

    public NBOutputTextDialog(Frame parent, String title, boolean model) {
        super(parent, title, model);
        initDialog(title);
        pack();
        setVisible(true);	
	}
    
    private void initDialog(String title) {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
        WinUtilities.center(this);
        textArea.setRows(UISpringAppContext.BrowserDialog_TextRows);
        textArea.setColumns(UISpringAppContext.BrowserDialog_TextColumns);
        busStyleRadioButton.setEnabled(false);
        summaryRadioButton.setEnabled(false);
        setTitle(title);

	}

    public void appendText(String text) {
		textArea.append(text);
	}

    public void clearTextArea() {
    	this.data = null;  // when clear the text area text, we assume that more text will writen to the area
		textArea.setText("");
	}

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        lfFormatButtonGroup = new javax.swing.ButtonGroup();
        textAreaPanel = new javax.swing.JPanel();
        textAreaScrollPane = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        controlPanel = new javax.swing.JPanel();
        lfFormatPanel = new javax.swing.JPanel();
        summaryRadioButton = new javax.swing.JRadioButton();
        busStyleRadioButton = new javax.swing.JRadioButton();
        saveAsButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.BorderLayout(5, 5));

        setTitle("");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        textAreaPanel.setLayout(new java.awt.BorderLayout(5, 5));

        textAreaPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 20, 0, 20));
        textArea.setColumns(120);
        textArea.setEditable(false);
        textArea.setFont(new java.awt.Font("Courier New", 0, 12));
        textArea.setRows(30);
        textAreaScrollPane.setViewportView(textArea);

        textAreaPanel.add(textAreaScrollPane, java.awt.BorderLayout.EAST);

        getContentPane().add(textAreaPanel, java.awt.BorderLayout.CENTER);

        controlPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 10));

        controlPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        lfFormatPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        lfFormatPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lfFormatButtonGroup.add(summaryRadioButton);
        summaryRadioButton.setFont(new java.awt.Font("Dialog", 0, 10));
        summaryRadioButton.setSelected(true);
        summaryRadioButton.setText("LF Summay");
        summaryRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        summaryRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        summaryRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                summaryRadioButtonActionPerformed(evt);
            }
        });

        lfFormatPanel.add(summaryRadioButton);

        lfFormatButtonGroup.add(busStyleRadioButton);
        busStyleRadioButton.setFont(new java.awt.Font("Dialog", 0, 10));
        busStyleRadioButton.setText("Bus Style");
        busStyleRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        busStyleRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        busStyleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busStyleRadioButtonActionPerformed(evt);
            }
        });

        lfFormatPanel.add(busStyleRadioButton);

        controlPanel.add(lfFormatPanel);

        saveAsButton.setFont(new java.awt.Font("Dialog", 0, 12));
        saveAsButton.setText("SaveAs...");
        saveAsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsButtonActionPerformed(evt);
            }
        });

        controlPanel.add(saveAsButton);

        closeButton.setFont(new java.awt.Font("Dialog", 0, 12));
        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        controlPanel.add(closeButton);

        getContentPane().add(controlPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveAsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsButtonActionPerformed
    	//IpssLogger.getLogger().info(textArea.getText());
    	JFileChooser fChooser = getSaveTextFileChooser();
    	int retValue = fChooser.showSaveDialog(this);
		if (retValue == JFileChooser.APPROVE_OPTION) {
			File file = fChooser.getSelectedFile();
			String filename = file.getPath();
			if (!filename.endsWith(".txt"))
				filename += ".txt";
		    IpssLogger.getLogger().info("Textarea text saved to file: " + filename);
		    GUIFileUtil.writeTextarea2FileAbsolutePath(filename, textArea);
		}    
	}//GEN-LAST:event_saveAsButtonActionPerformed
	
	private JFileChooser getSaveTextFileChooser() {
		if (saveTextFileChooser == null) {
			saveTextFileChooser = new JFileChooser();
			saveTextFileChooser.addChoosableFileFilter(new IpssFileFilter("txt", "Text File"));
			saveTextFileChooser.setCurrentDirectory(new File(IpssFileFilter.OUTPUT_DEFAULT_DIR));
		}
    	return saveTextFileChooser;
	}	
	
    private void busStyleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busStyleRadioButtonActionPerformed
    	textArea.setText(AclfOutFunc.lfResultsBusStyle(aclfAdjNet));
    }//GEN-LAST:event_busStyleRadioButtonActionPerformed

    private void summaryRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_summaryRadioButtonActionPerformed
    	textArea.setText(AclfOutFunc.loadFlowSummary(aclfAdjNet));
    }//GEN-LAST:event_summaryRadioButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_closeButtonActionPerformed
     
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
    }//GEN-LAST:event_closeDialog
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton busStyleRadioButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JPanel controlPanel;
    private javax.swing.ButtonGroup lfFormatButtonGroup;
    private javax.swing.JPanel lfFormatPanel;
    private javax.swing.JButton saveAsButton;
    private javax.swing.JRadioButton summaryRadioButton;
    private javax.swing.JTextArea textArea;
    private javax.swing.JPanel textAreaPanel;
    private javax.swing.JScrollPane textAreaScrollPane;
    // End of variables declaration//GEN-END:variables

}
