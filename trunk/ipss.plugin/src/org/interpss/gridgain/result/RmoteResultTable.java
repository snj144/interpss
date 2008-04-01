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
	public static String KEY_SerializedAclfNet = "SerializedAclfNet";	
	public static String KEY_BooleanStatus = "BooleanStatus";
	
	public Boolean getBooleanStatus() {
		return (Boolean)get(RmoteResultTable.KEY_BooleanStatus);
	}

	public String getSerializedAclfNet() {
		return (String)get(RmoteResultTable.KEY_SerializedAclfNet);
	}
}
