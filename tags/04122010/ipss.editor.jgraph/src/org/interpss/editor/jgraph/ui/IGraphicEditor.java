 /*
  * @(#)IGraphicEditor.java   
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

package org.interpss.editor.jgraph.ui;

import java.awt.Frame;

import org.interpss.editor.jgraph.ui.app.IAppSimuContext;
import org.interpss.editor.jgraph.ui.app.IAppStatus;


public interface IGraphicEditor {
	/**
	 * Get the current appSimuContext object object
	 * 
	 * @return the ProjData object
	 */
	IAppSimuContext getCurrentAppSimuContext() throws Exception;

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

	/**
	 * get installation root directory
	 */
	String getRootDir();
	
	/**
	 * get workspace absolute path
	 */
	String getWorkspace();

	/**
	 * get current project folder name
	 */
	String getCurrentProjectFolder();

	/**
	 * get current project name
	 */
	String getCurrentProjectName();
}