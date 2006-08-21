package com.interpss.editor.jgraph.ui.form;

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