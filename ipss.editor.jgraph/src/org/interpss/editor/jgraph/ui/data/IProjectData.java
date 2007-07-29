 /*
  * @(#)IProjectData.java   
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

package org.interpss.editor.jgraph.ui.data;

import java.util.List;

public interface IProjectData {
	/**
	 * Get project name
	 * @return
	 */
	int getProjectDbId();
	
	/**
	 * Set the project name
	 * @param str
	 */
	void setProjectDbId(int db);
	
	/**
	 * Get project name
	 * @return
	 */
	String getProjectName();
	
	/**
	 * Set the project name
	 * @param str
	 */
	void setProjectName(String str);

	/**
	 * Get project description
	 * @return
	 */
	String getDescription();
	
	/**
	 * Set project description
	 * @param str
	 */
	void setDescription(String str);

	/**
	 * Get project file path
	 * @return
	 */
	String getFilepath();
	
	/**
	 * Get project file name
	 * @return
	 */
	String getFilename();
	
	/**
	 * Set project file path
	 * @param str
	 */
	void setWorkspacePath(String str);

	/**
	 * Set project file path
	 * @param str
	 */
	void setFilepath(String str);

	/**
	 * Check if project data is dirty
	 * @return
	 */
	boolean isDirty();
	
	/**
	 * Set project data dirty
	 * @param b
	 */
	void setDirty(boolean b);

	/**
	 * Get project case info list
	 * @return
	 */
	List<?> getCaseList();
	
	/**
	 * Set project case info list
	 * @param list
	 */
	void setCaseList(List<?> list);

	/**
	 * Check if project is a new project
	 * @return
	 */
	boolean isNewProject();
	
	/**
	 * Set project new status to true 
	 *
	 */
	public void setToNewProject();
	
	/**
	 * get Ipss DB Schema version 
	 *
	 */
	public String getDbSchemaVersion();
	
	/**
	 * set Ipss DB Schema version 
	 *
	 */
	public void setDbSchemaVersion(String dbSchemaVersion);

	
	/**
	 * Get prject scripts, which is a XML string of the scripts bean
	 * 
	 * @return
	 */
	public String getScripts();

	/**
     * Set project scripts
	 * 
	 * @param scripts
	 */
	public void setScripts(String scripts);
	
	/**
	 * Convert this object to an Xml string for persistence
	 * 
	 * @return
	 */
	
	public String getScriptsCaseName();
	
	String toString();
}