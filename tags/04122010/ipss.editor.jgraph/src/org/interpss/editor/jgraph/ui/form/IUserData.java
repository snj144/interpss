 /*
  * @(#)IUserData.java   
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