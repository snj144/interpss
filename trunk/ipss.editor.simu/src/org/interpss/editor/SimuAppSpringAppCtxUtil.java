 /*
  * @(#)SimuAppSpringAppCtxUtil.java   
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

package org.interpss.editor;

import java.util.List;

import javax.swing.JDialog;

import org.interpss.editor.app.AppSimuContextImpl;
import org.interpss.editor.jgraph.GraphSpringAppContext;
import org.interpss.editor.jgraph.ui.app.IAppSimuContext;
import org.interpss.editor.jgraph.ui.data.IProjectData;
import org.interpss.editor.jgraph.ui.edit.IFormDataDialog;
import org.interpss.editor.jgraph.ui.form.IGBranchForm;
import org.interpss.editor.jgraph.ui.form.IGBusForm;
import org.interpss.editor.jgraph.ui.form.IGFormContainer;
import org.interpss.editor.ui.ICaseInfoDialog;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Constants;
import com.interpss.simu.io.IpssFileAdapter;

public class SimuAppSpringAppCtxUtil {
	/**
	 * Get the CaseInfoDialog(singleton) from the SpringAppContext.
	 *  
	 * @return the CaseInfoDialog object
	 */	
	public static ICaseInfoDialog getCaseInfoDialog(String caseType, IGFormContainer netContainer, IAppSimuContext appSimuCtx) {
		ICaseInfoDialog caseInfoDialog = (ICaseInfoDialog)SpringAppContext.SpringAppCtx.getBean(Constants.SID_CaseInfoDialog);
		caseInfoDialog.setCaseType(caseType);
		caseInfoDialog.init(netContainer, appSimuCtx);
		return caseInfoDialog;
	}	

	/**
	 * Get the CaseInfoDialog(singleton) from the SpringAppContext.
	 *  
	 * @return the CaseInfoDialog object
	 */	
	public static ICaseInfoDialog getCaseInfoDialog(String caseType, IGFormContainer netContainer, AppSimuContextImpl appCtx, boolean model) {
		ICaseInfoDialog caseInfoDialog = (ICaseInfoDialog)SpringAppContext.SpringAppCtx.getBean(Constants.SID_CaseInfoDialog);
		((JDialog)caseInfoDialog).setModal(model);
		caseInfoDialog.setCaseType(caseType);
		caseInfoDialog.init(netContainer, appCtx);
		return caseInfoDialog;
	}
	
	/**
	 * Get a CustomFileAdapter(prototype) object from the SpringAppContext.
	 *  
	 * @return the CustomFileAdapter object
	 */	
	public static IpssFileAdapter getCustomFileAdapter(String ext) {
		List adapterList = 	SimuAppSpringAppContext.getCustomFileAdapterList();
		for (int i = 0; i < adapterList.size(); i++) {
			IpssFileAdapter adapter = (IpssFileAdapter)adapterList.get(i);
			if (ext.equals(adapter.getExtension()))
				return adapter;
		}
		return null;
	}
	
	/**
	 * Get the Project Date editor
	 *  
	 * @return the editor object
	 */
	public static IFormDataDialog getProjectDataEditor(IGFormContainer netContainer, IProjectData projData, boolean modal) {
		IFormDataDialog editor = GraphSpringAppContext.getProjectDataEditor();
		((JDialog)editor).setModal(false);
        editor.init(netContainer, projData);
		return editor;
	}	
	
	/**
	 * Get the Bus Date editor
	 *  
	 * @return the editor object
	 */
	public static IFormDataDialog getBusDataEditor(IGFormContainer netContainer, IGBusForm form, boolean modal) {
		IFormDataDialog editor = GraphSpringAppContext.getBusDataEditor();
		((JDialog)editor).setModal(false);
		editor.init(netContainer, form);
		return editor;
	}		
	/**
	 * Get the Branch Date editor
	 *  
	 * @return the editor object
	 */
	public static IFormDataDialog getBranchDataEditor(IGFormContainer netContainer, IGBranchForm form, boolean modal) {
		IFormDataDialog editor = GraphSpringAppContext.getBranchDataEditor();
		((JDialog)editor).setModal(false);
		editor.init(netContainer, form);
		return editor;
	}
}
