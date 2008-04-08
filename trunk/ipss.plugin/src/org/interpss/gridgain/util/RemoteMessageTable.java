 /*
  * @(#)RemoteMessageTable.java   
  *
  * Copyright (C) 2008 www.interpss.org
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
  * @Date 03/15/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.gridgain.util;

import java.io.Serializable;
import java.util.Hashtable;

public class RemoteMessageTable extends Hashtable<String, Serializable> {
	private static final long serialVersionUID = 1;

	public RemoteMessageTable() {
		put(RemoteMessageTable.KEY_ReturnStatus, Boolean.TRUE);
	}
	
	public static String KEY_RemoteNodeId = "RemoteNodeId";	
	public static String KEY_StudyCaseId = "StudyCaseId";	
	public static String KEY_ReturnStatus = "ReturnStatus";
	public static String KEY_ReturnMessage = "ReturnMessage";
	public static String KEY_StudyCaseNetworkModel = "StudyCaseNetworModel";	
	public static String KEY_StudyCaseModification = "StudyCaseModification";	
	
	public String getStudyCaseId() {
		return (String)get(RemoteMessageTable.KEY_StudyCaseId);
	}

	public String getRemoteNodeId() {
		return (String)get(RemoteMessageTable.KEY_RemoteNodeId);
	}

	public boolean getReturnStatus() {
		return getBoolean(RemoteMessageTable.KEY_ReturnStatus);
	}
	
	public String getReturnMessage() {
		return (String)get(RemoteMessageTable.KEY_ReturnMessage);
	}

	public String getStudyCaseNetworkModel() {
		return (String)get(RemoteMessageTable.KEY_StudyCaseNetworkModel);
	}

	public String getStudyCaseModification() {
		return (String)get(RemoteMessageTable.KEY_StudyCaseModification);
	}

	//
	// Aclf result related fields
	// ==========================

	public static String KEY_SerializedAclfNet = "SerializedAclfNet";	
	public static String KEY_AclfConverged = "AclfConvergeStatus";	
	public static String KEY_BranchMvar1LimintViolationIndex = "BranchMvar1LimintViolationIndex";	
	public static String KEY_BranchMvar2LimintViolationIndex = "BranchMvar2LimintViolationIndex";	
	public static String KEY_BranchMvar3LimintViolationIndex = "BranchMvar3LimintViolationIndex";	
	public static String KEY_BranchAmpsLimintViolationIndex = "BranchAmpsLimintViolationIndex";	
	public static String KEY_BusVoltageLimintViolationIndex = "BusVoltageLimintViolationIndex";	

	public String getSerializedAclfNet() {
		return (String)get(RemoteMessageTable.KEY_SerializedAclfNet);
	}

	public boolean getAclfConvergeStatus() {
		return getBoolean(RemoteMessageTable.KEY_AclfConverged);
	}

	public double getBranchMvar1LimintViolationIndex() {
		return getDouble(RemoteMessageTable.KEY_BranchMvar1LimintViolationIndex);
	}

	public double getBranchMvar2LimintViolationIndex() {
		return getDouble(RemoteMessageTable.KEY_BranchMvar2LimintViolationIndex);
	}

	public double getBranchMvar3LimintViolationIndex() {
		return getDouble(RemoteMessageTable.KEY_BranchMvar3LimintViolationIndex);
	}
	
	public double getBranchAmpsLimintViolationIndex() {
		return getDouble(RemoteMessageTable.KEY_BranchAmpsLimintViolationIndex);
	}
	
	public double getBusVoltageLimintViolationIndex() {
		return getDouble(RemoteMessageTable.KEY_BusVoltageLimintViolationIndex);
	}
	
	//
	// DStab result related fields
	// ===========================
	



	private boolean getBoolean(String key) {
		if (get(key) == null)
			return false;
		return ((Boolean)get(key)).booleanValue();
	}

	private double getDouble(String key) {
		if (get(key) == null)
			return 0.0;
		return ((Double)get(key)).doubleValue();
	}
}
