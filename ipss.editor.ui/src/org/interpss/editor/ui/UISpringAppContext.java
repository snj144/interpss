package org.interpss.editor.ui;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Constants;
import com.interpss.editor.jgraph.ui.edit.IFormDataDialog;

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
