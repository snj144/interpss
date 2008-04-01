package org.interpss.gridgain;

import java.io.Serializable;
import java.util.Hashtable;

public class RmoteGridNodeResult extends Hashtable<String, Serializable> {
	private static final long serialVersionUID = 1;

	public static String KEY_RemoteNodeId = "RemoteNodeId";	
	public static String KEY_StudyCaseId = "StudyCaseId";	
	public static String KEY_SerializedAclfNet = "SerializedAclfNet";	
	public static String KEY_BooleanStatus = "BooleanStatus";
	
	public Boolean getBooleanStatus() {
		return (Boolean)get(RmoteGridNodeResult.KEY_BooleanStatus);
	}

	public String getSerializedAclfNet() {
		return (String)get(RmoteGridNodeResult.KEY_SerializedAclfNet);
	}
}
