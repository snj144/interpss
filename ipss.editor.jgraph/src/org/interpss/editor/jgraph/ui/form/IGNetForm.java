 /*
  * @(#)IGNetForm.java   
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
 * Network form interface. A network form object is a placeholder for network data
 */

import java.util.TreeSet;

public interface IGNetForm extends IUserData {
	public static String AppType_Distribution = "Distribution";
	public static String AppType_Transmission  = "Transmission";
	
	public static String NetType_AclfNetwork    = "AclfNetwork";
	public static String NetType_AclfAdjNetwork = "AclfAdjNetwork";
	public static String NetType_AcscNetwork    = "AcscNetwork";
	public static String NetType_DistributeNet  = "DistributeNet";
	public static String NetType_DStabilityNet  = "DStabilityNet";	
	
	/**
	 * Set network new status
	 * 
	 * @param b
	 */
	void setNewState(boolean b);
	
	/**
	 * Get the available bus number
	 * 
	 * @return
	 */
	int getNextBusNumber();
	
	/**
	 * Set the starting point for the next available bus number. 
	 * @param n
	 */
	void setNextBusNumber(int n);

	/**
	 * Get the available branch number
	 * 
	 * @return
	 */
	int getNextBranchNumber();

	/**
	 * Set the starting point for the next available branch number. 
	 * @param n
	 */
	void setNextBranchNumber(int n);

	/**
	 * Get the system base voltage list
	 * 
	 * @return
	 */
	TreeSet getBaseVoltList();	

	/**
	 * rebuild the network bus/branch relationship.
	 *
	 */
	void rebuildRelation();
	
	/**
	 * Get the network AppType
	 * 
	 * @return
	 */
	String getAppType();
	
	/**
	 * Get the network NetType
	 * @return
	 */
	String getNetType();
}