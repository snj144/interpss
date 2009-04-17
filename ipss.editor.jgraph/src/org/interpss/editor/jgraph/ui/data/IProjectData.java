/**
 * A Project has a list of Cases, where study case info are stored
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
	List getCaseList();
	
	/**
	 * Set project case info list
	 * @param list
	 */
	void setCaseList(List list);

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
	 * Convert this object to an Xml string for persistance
	 * 
	 * @return
	 */
	String toString();
}