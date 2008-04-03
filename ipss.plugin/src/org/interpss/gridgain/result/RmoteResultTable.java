 /*
  * @(#)RmoteResultTable.java   
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

package org.interpss.gridgain.result;

import java.io.Serializable;
import java.util.Hashtable;

public class RmoteResultTable extends Hashtable<String, Serializable> {
	private static final long serialVersionUID = 1;

	public static String KEY_RemoteNodeId = "RemoteNodeId";	
	public static String KEY_StudyCaseId = "StudyCaseId";	
	
	public String getStudyCaseId() {
		return (String)get(RmoteResultTable.KEY_StudyCaseId);
	}

	public String getRemoteNodeId() {
		return (String)get(RmoteResultTable.KEY_RemoteNodeId);
	}

	//
	// Aclf related fields
	// ===================

	public static String KEY_SerializedAclfNet = "SerializedAclfNet";	
	public static String KEY_AclfConverged = "AclfConvergeStatus";	
	public static String KEY_BranchMvar1LimintViolationIndex = "BranchMvar1LimintViolationIndex";	
	public static String KEY_BranchMvar2LimintViolationIndex = "BranchMvar2LimintViolationIndex";	
	public static String KEY_BranchMvar3LimintViolationIndex = "BranchMvar3LimintViolationIndex";	
	public static String KEY_BranchAmpsLimintViolationIndex = "BranchAmpsLimintViolationIndex";	
	public static String KEY_BusVoltageLimintViolationIndex = "BusVoltageLimintViolationIndex";	

	public String getSerializedAclfNet() {
		return (String)get(RmoteResultTable.KEY_SerializedAclfNet);
	}

	public boolean getAclfConvergeStatus() {
		return ((Boolean)get(RmoteResultTable.KEY_AclfConverged)).booleanValue();
	}

	public double getBranchMvar1LimintViolationIndex() {
		return ((Double)get(RmoteResultTable.KEY_BranchMvar1LimintViolationIndex)).doubleValue();
	}

	public double getBranchMvar2LimintViolationIndex() {
		return ((Double)get(RmoteResultTable.KEY_BranchMvar2LimintViolationIndex)).doubleValue();
	}

	public double getBranchMvar3LimintViolationIndex() {
		return ((Double)get(RmoteResultTable.KEY_BranchMvar3LimintViolationIndex)).doubleValue();
	}
	
	public double getBranchAmpsLimintViolationIndex() {
		return ((Double)get(RmoteResultTable.KEY_BranchAmpsLimintViolationIndex)).doubleValue();
	}
	
	public double getBusVoltageLimintViolationIndex() {
		return ((Double)get(RmoteResultTable.KEY_BusVoltageLimintViolationIndex)).doubleValue();
	}
	
	//
	// DStab related fields
	// ====================
	public static String KEY_DStabRunStatus = "DStabRunStatus";

	public boolean getDStabRunStatus() {
		return ((Boolean)get(RmoteResultTable.KEY_DStabRunStatus)).booleanValue();
	}

}
