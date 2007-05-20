 /*
  * @(#)UISpringAppContext.java   
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

package org.interpss.editor.ui;

import org.interpss.editor.jgraph.ui.edit.IFormDataDialog;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Constants;

public class UISpringAppContext extends SpringAppContext {
	public static int BrowserDialog_TextRows = 30;
	public static int BrowserDialog_TextColumns = 130;
	
	/**
	 * Get the OutputTextDialog(singleton) from the SpringAppContext.
	 *  
	 * @return the OutputTextDialog object
	 */	
	public static IOutputTextDialog getOutputTextDialog(String title) {
		IOutputTextDialog dialog = (IOutputTextDialog)SpringAppCtx.getBean(Constants.SID_OutputTextDialog);
		dialog.setTitle(title);
		return dialog;
	}
	
	/**
	 * Get the ServiceScheduleDialog(singleton) from the SpringAppContext.
	 *  
	 * @return the ServiceScheduleDialog object
	 */	
	public static IFormDataDialog getServiceScheduleDialog() {
		return (IFormDataDialog)SpringAppCtx.getBean(Constants.SID_ServiceScheduleDialog);
	}	
	
	/**
	 * Get the LoadScheduleDialog(singleton) from the SpringAppContext.
	 *  
	 * @return the LoadScheduleDialog object
	 */	
	public static IFormDataDialog getLoadScheduleDialog() {
		return (IFormDataDialog)SpringAppCtx.getBean(Constants.SID_LoadScheduleDialog);
	}	
}
