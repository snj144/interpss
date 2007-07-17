 /*
  * @(#)IGBranchForm.java   
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

/**
 * Branch form interface. A branch form object is a placeholder for branch data
 */

public interface IGBranchForm extends IUserData {
	public static final String 
		TransBranchLfCode_Line = "Line",
		TransBranchLfCode_Xfr  = "Xformer",
		TransBranchLfCode_PsXfr = "PSXformer",
	    TransBranchCode_LFScripting = "LFScripting",
    	TransBranchCode_SCScripting = "ScScripting";
	
	public static final String
		DistBranchCode_Feeder = "Feeder",
		DistBranchCode_Breaker = "Breaker",
		DistBranchCode_Xfr = "Transformer",
		DistBranchCode_3WXfr = "3WTransformer",
		DistBranchCode_AllBranch = "AllBranches";
	
	/**
	 * Get branch from bus id, which is a property of this object
	 * 
	 * @return
	 */
	String getFromId();
	
	/**
	 * Get branch to bus id, which is a property of this object
	 * 
	 * @return
	 */
	String getToId();
	
	/**
	 * Set branch from bus id, which is a property of this object
	 * 
	 * @return
	 */
	void setFromId(String id);

	/**
	 * Set branch to bus id, which is a property of this object
	 * 
	 * @return
	 */
	void setToId(String id);
	
	/**
	 * Set branch from bus name, which is a property of this object
	 * 
	 * @return
	 */
	void setFromBusName(String name);

	/**
	 * Set branch to bus name, which is a property of this object
	 * 
	 * @return
	 */
	void setToBusName(String name);
	
	/**
	 * Set branch number, which is a property of this object, which also
	 * serves as brnach id
	 * 
	 * @return
	 */
	void setBranchNumber(String n);
	
	/**
	 * Get branch status (true=closed, false=open)
	 * 
	 * @return
	 */
	boolean getStatus();
	
	/**
	 * Get the network AppType, where this branch is contained
	 * 
	 * @return
	 */
	String getAppType();

	/**
	 * Get branch Transmission AppType branch code
	 * 
	 * @return
	 */
	String getTransBranchLfCode();

	/**
	 * Get branch Distribution AppType branch code
	 * 
	 * @return
	 */
	String getDistBranchCode();
	
	
	/**
	 * Get branch number
	 * 
	 * @return
	 */
    String getBranchNumber();  
}