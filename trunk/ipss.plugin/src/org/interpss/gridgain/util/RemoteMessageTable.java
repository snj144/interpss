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
import java.util.List;

public class RemoteMessageTable extends Hashtable<String, Serializable> {
	private static final long serialVersionUID = 1;

	public RemoteMessageTable() {
		put(RemoteMessageTable.KEY_bOut_ReturnStatus, Boolean.TRUE);
	}
	
	public static String KEY_sInOut_RemoteNodeId = "RemoteNodeId";	
	public static String KEY_sInOut_StudyCaseId = "StudyCaseId";	
	public static String KEY_bOut_ReturnStatus = "ReturnStatus";
	public static String KEY_sOut_ReturnMessage = "ReturnMessage";
	public static String KEY_sIn_StudyCaseNetworkModel = "StudyCaseNetworModel";	
	public static String KEY_sIn_StudyCaseModification = "StudyCaseModification";	
	public static String KEY_sIn_AclfAlgorithm = "AclfAlgorithm";	
	public static String KEY_sIn_DStabAlgorithm = "DStabAlgorithm";	
	
	public String getStudyCaseId() {
		return (String)get(RemoteMessageTable.KEY_sInOut_StudyCaseId);
	}

	public String getRemoteNodeId() {
		return (String)get(RemoteMessageTable.KEY_sInOut_RemoteNodeId);
	}

	public boolean getReturnStatus() {
		return getBoolean(RemoteMessageTable.KEY_bOut_ReturnStatus);
	}
	
	public String getReturnMessage() {
		return (String)get(RemoteMessageTable.KEY_sOut_ReturnMessage);
	}

	public void addReturnMessage(String msg) {
		String s = (String)get(RemoteMessageTable.KEY_sOut_ReturnMessage);
		s = s!=null? s+"/n" : "";
		put(RemoteMessageTable.KEY_sOut_ReturnMessage, s+msg);
	}

	public void addReturnMessage(List<Object> msgList) {
		if (msgList.size() > 0) {
			String s = "";
			for (Object msg : msgList)
				s += msg + "\n"; 
			addReturnMessage(s);
		}
	}

	public String getStudyCaseNetworkModel() {
		return (String)get(RemoteMessageTable.KEY_sIn_StudyCaseNetworkModel);
	}

	public String getStudyCaseModification() {
		return (String)get(RemoteMessageTable.KEY_sIn_StudyCaseModification);
	}

	public String getAclfAlgorithm() {
		return (String)get(RemoteMessageTable.KEY_sIn_AclfAlgorithm);
	}

	public String getDStabAlgorithm() {
		return (String)get(RemoteMessageTable.KEY_sIn_DStabAlgorithm);
	}
	
	//
	// Aclf result related fields
	// ==========================

	public static int Const_ReturnAllStudyCase = 1;	
	public static int Const_ReturnDivergedCase = 2;	
	public static int Const_ReturnNoStudyCase = 3;	

	public static String KEY_sOut_SerializedAclfNet = "SerializedAclfNet";	
	public static String KEY_bOut_AclfConverged = "AclfConvergeStatus";	

	public String getSerializedAclfNet() {
		return (String)get(RemoteMessageTable.KEY_sOut_SerializedAclfNet);
	}

	public boolean getAclfConvergeStatus() {
		return getBoolean(RemoteMessageTable.KEY_bOut_AclfConverged);
	}
	
	//
	// DStab result related fields
	// ===========================
	
	private boolean getBoolean(String key) {
		if (get(key) == null)
			return false;
		return ((Boolean)get(key)).booleanValue();
	}
}
