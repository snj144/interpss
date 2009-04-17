package org.interpss.editor.jgraph.ui.form;

import java.io.Serializable;

/**
*	UserData interface for the getUserObject() method of a graph cell
*/

public interface IUserData extends Serializable {
	public static final String NET_LABEL           = "NetLabel";
	public static final String NET_ANNOTATE_LABEL  = "NetAnnotateLabel";
	public static final String BUS_LABEL           = "BusLabel";
	public static final String BUS_ANNOTATE_LABEL  = "BusAnnotateLabel";
	public static final String BRANCH_LABEL        = "BranchLabel";
	public static final String BRANCH_SOURCE_LABEL = "BranchSourceLabel";
	public static final String BRANCH_TARGET_LABEL = "BranchTargetLabel";
	/**
	*	Get a string for cell display purpose
	*/
	public String getLabel(String type);
	
	/**
	*	Check if the object is newly created
	*/
	public boolean isNewState();
	
	/**
	 * Each UserData object has an unique Id, Get the element Id
	 * 
	 * @return
	 */
	String getId();
	
	/**
	 * Set element id
	 * 
	 * @param id
	 */
	void setId(String id);
	
	/**
	/**
	 * Get UserData object name
	 * 
	 * @param name
	 */
	String getName();
	
	/**
	 * Set UserData object name
	 * 
	 * @param name
	 */
	void setName(String name);
	
	/**
	 * Clone this object and return the cloned object
	 * 
	 * @return the cloned object
	 */
	Object clone();	
}