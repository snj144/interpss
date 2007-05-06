package org.interpss.editor.ui;

import java.util.Hashtable;
import java.util.List;

public interface IScriptTool {
	/**
	 * 
	 * 
	 * @param textDialog
	 * @param nameList
	 * @param valueList
	 */
	public void outDStabResult2TextDialog(			   
			IOutputTextDialog textDialog,   // out text dialog
			List<String> nameList,          // variable name list
			List<Hashtable<String, String>> valueList);  // var value list);
}
