/*
 * @(#)PluginSpringCtx.java   
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

package org.interpss.spring;

import static com.interpss.common.datatype.Constants.SID_ProjectDataManager;
import static com.interpss.common.datatype.Constants.SID_RefDataManager;
import static com.interpss.common.datatype.Constants.SID_SimuRecManager;

import org.interpss.output.ISimuRecManager;
import org.interpss.ui.IProjectDataManager;
import org.interpss.ui.IRefDataManager;

import com.interpss.spring.CoreCommonSpringFactory;

public class BasePluginSpringCtx extends CoreCommonSpringFactory {

//	/**
//	 * Get the IEditorDialogUtil(singleton) from the SpringAppContext.
//	 *  
//	 * @return the EditorDialogUtil object
//	 */
//	public static IDialogUtil getEditorDialogUtil() {
//		// TODO
//		return (IDialogUtil) SpringAppCtx.getBean("editorDialogUtil");
//	}
	
	/**
	 * Get the SimuRecManager(singleton) from the SpringAppContext.
	 *  
	 * @return the RefDataManager object
	 */
	public static ISimuRecManager getSimuRecManager() {
		return (ISimuRecManager) SpringAppCtx.getBean(SID_SimuRecManager);
	}
	

	/**
	 * Get the RefDataManager(singleton) from the SpringAppContext.
	 *  
	 * @return the RefDataManager object
	 */
	public static IRefDataManager getRefDataManager() {
		return (IRefDataManager) SpringAppCtx.getBean(SID_RefDataManager);
	}
	
	/**
	 * Get the SimuRecManager(singleton) from the SpringAppContext.
	 *  
	 * @return the RefDataManager object
	 */
	public static IProjectDataManager getProjectDataDBManager() {
		return (IProjectDataManager) SpringAppCtx
				.getBean(SID_ProjectDataManager);
	}	
}
