 /*
  * @(#)SimuAppSpringAppContext.java   
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

import org.interpss.editor.jgraph.ui.app.IAppSimuContext;
import org.interpss.editor.jgraph.ui.data.IProjectData;
import org.interpss.editor.runAct.AclfRunForm;
import org.interpss.editor.runAct.AcscRunForm;
import org.interpss.editor.runAct.DStabRunForm;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Constants;
import com.interpss.common.mapper.IpssMapper;

public class SimuAppSpringAppContext extends SpringAppContext {	
	/**
	 * Get the AppSimuContext from the SpringAppContext.
	 *  
	 * @return the AppSimuContext object
	 */
	public static IAppSimuContext getAppSimuContext() {
		return (IAppSimuContext)SpringAppCtx.getBean(Constants.SID_AppSimuContext);
	}
	
	/**
	 * Get the ProjectData from the SpringAppContext.
	 *  
	 * @return the ProjectData object
	 */
	public static IProjectData getProjectData() {
		return (IProjectData)SpringAppCtx.getBean(Constants.SID_ProjectData);
	}

	
	/**
	 * Get the EditorJGraphDataMapper(singleton) from the SpringAppContext.
	 *  
	 * @return the EditorJGraphDataMapper object
	 */
	public static IpssMapper getEditorJGraphDataMapper() {
		return (IpssMapper)SpringAppCtx.getBean(Constants.SID_EditorJGraphDataMapper);
	}
	
	/**
	 * Get the RunForm2AlgorithmMapper(singleton) from the SpringAppContext.
	 *  
	 * @return the RunForm2AlgorithmMapper object
	 */
	public static IpssMapper getRunForm2AlgorithmMapper() {
		return (IpssMapper)SpringAppCtx.getBean(Constants.SID_RunForm2AlgorithmMapper);
	}
	
	public static JDialog getCaseInfoDialog() {
		return (JDialog)SpringAppCtx.getBean(Constants.SID_CaseInfoDialog);
	}

	/**
	 * Get the AclfRunForm(singleton) from the SpringAppContext.
	 *  
	 * @return the AclfRunForm object
	 */	
	public static AclfRunForm getAclfRunForm() {
		return (AclfRunForm)SpringAppCtx.getBean(Constants.SID_AclfRunForm);
	}

	/**
	 * Get the ProjectData(singleton) from the SpringAppContext.
	 *  
	 * @return the ProjectData object
	 */	
	public static AcscRunForm getAcscRunForm() {
		return (AcscRunForm)SpringAppCtx.getBean(Constants.SID_AcscRunForm);
	}
	
	/**
	 * Get the DStabRunForm(singleton) from the SpringAppContext.
	 *  
	 * @return the DStabRunForm object
	 */	
	public static DStabRunForm getDStabRunForm() {
		return (DStabRunForm)SpringAppCtx.getBean(Constants.SID_DStabRunForm);
	}

	/**
	 * Get the CustomFileAdapterList(singleton) from the SpringAppContext.
	 *  
	 * @return the CustomFileAdapterList object
	 */	
	public static List getCustomFileAdapterList() {
		return (List)SpringAppCtx.getBean(Constants.SID_CustomFileAdapterList);
	}
}
