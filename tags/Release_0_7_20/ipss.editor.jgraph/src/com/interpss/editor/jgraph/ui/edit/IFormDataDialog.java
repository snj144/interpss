package com.interpss.editor.jgraph.ui.edit;

public interface IFormDataDialog extends IFormDataPanel {
	/**
	 * A FormDataDialog always has to have an OK(Save,Run..) button. When it is 
	 * clicked, returnOk = true 
	 * @return
	 */
	boolean isReturnOk();
	
	/**
	 * Pack or redraw the dialog box
	 */
	void pack();
}