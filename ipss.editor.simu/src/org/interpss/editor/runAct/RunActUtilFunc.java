package org.interpss.editor.runAct;

import java.util.ArrayList;
import java.util.List;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.aclfadj.PVBusLimit;

public class RunActUtilFunc {
	public static String AllControlDevices = "All Control Devices";
	
	public static Object[] getFunctionLoadList(AclfAdjNetwork adjNet, IPSSMsgHub msg) {
		List<String> list = new ArrayList<String>();
		list.add(AllControlDevices);
		return list.toArray();
	}

	public static Object[] getPVBusLimitList(AclfAdjNetwork adjNet, IPSSMsgHub msg) {
		List<String> list = new ArrayList<String>();
		list.add(AllControlDevices);
		for (int i = 0; i < adjNet.getPvBusLimitList().size(); i++) {
			PVBusLimit pvLimit = (PVBusLimit)adjNet.getPvBusLimitList().get(i);
			if (pvLimit.needAdjust(0.0, adjNet.getBaseKva(), msg))
				list.add( pvLimit.getId() + " at " + pvLimit.getBus().getName() +
					"(" + (pvLimit.isActive()?"on":"off") + ")");
		}
		return list.toArray();	
	}

	public static Object[] getPQBusLimitList(AclfAdjNetwork adjNet, IPSSMsgHub msg) {
		List<String> list = new ArrayList<String>();
		list.add(AllControlDevices);
		return list.toArray();	
	}

	public static Object[] getRemoteQBusList(AclfAdjNetwork adjNet, IPSSMsgHub msg) {
		List<String> list = new ArrayList<String>();
		list.add(AllControlDevices);
		return list.toArray();
	}

	public static Object[] getXfrTapControlList(AclfAdjNetwork adjNet, IPSSMsgHub msg) {
		List<String> list = new ArrayList<String>();
		list.add(AllControlDevices);
		return list.toArray();	
	}

	public static Object[] getPSXfrPControlList(AclfAdjNetwork adjNet, IPSSMsgHub msg) {
		List<String> list = new ArrayList<String>();
		list.add(AllControlDevices);
		return list.toArray();	
	}

	public static Object[] getInterareaPControlList(AclfAdjNetwork adjNet, IPSSMsgHub msg) {
		List<String> list = new ArrayList<String>();
		list.add(AllControlDevices);
		return list.toArray();	
	}
}
