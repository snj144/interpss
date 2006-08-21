package com.interpss.editor.jgraph.ui;

/**
 *  The Editor's MainWindow Editor has to implement the following methods to make this UI package plugable. 
 */

import java.awt.Frame;

import com.interpss.editor.jgraph.ui.app.IAppSimuContext;
import com.interpss.editor.jgraph.ui.app.IAppStatus;

public interface IGraphicEditor {
	/**
	 * Get the current appSimuContext object object
	 * 
	 * @return the ProjData object
	 */
	IAppSimuContext getCurrentAppSimuContext();

	/**
	 * 
	 * Get the current IAppStatus object
	 */
	IAppStatus getAppStatus();

	/**
	 * Find the hosting frame.
	 */
	Frame getFrame();	

	/**
	 * Get the editor version.
	 */
	String getVersion();

	/**
	 * refresh the current document editor panel to reflect data change
	 */
	void refreshCurrentDocumentEditorPanel();
}