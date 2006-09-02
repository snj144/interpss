package org.interpss.editor.runAct;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.aclfadj.FunctionLoad;
import com.interpss.core.aclfadj.PQBusLimit;
import com.interpss.core.aclfadj.PSXfrPControl;
import com.interpss.core.aclfadj.PVBusLimit;
import com.interpss.core.aclfadj.RemoteQBus;
import com.interpss.core.aclfadj.RemoteQControlType;
import com.interpss.core.aclfadj.TapControl;
import com.interpss.core.net.Area;
import com.interpss.core.net.IRegulationDevice;

public class RunActUtilFunc {
	public static String AllControlDevices = "All Control Devices";
	
	public static Object[] getFunctionLoadList(AclfAdjNetwork adjNet, double tolerance, IPSSMsgHub msg) {
		List<String> list = new ArrayList<String>();
		list.add(AllControlDevices);
		for (int i = 0; i < adjNet.getFunctionLoadList().size(); i++) {
			FunctionLoad load = (FunctionLoad)adjNet.getFunctionLoadList().get(i);
			if (load.needAdjust(tolerance, adjNet.getBaseKva(), msg))
				list.add( load.getId() + " at " + load.getBus().getName());
		}
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
		for (int i = 0; i < adjNet.getPqBusLimitList().size(); i++) {
			PQBusLimit pqLimit = (PQBusLimit)adjNet.getPqBusLimitList().get(i);
			if (pqLimit.needAdjust(0.0, adjNet.getBaseKva(), msg))
				list.add( pqLimit.getId() + " at " + pqLimit.getBus().getName() +
					"(" + (pqLimit.isActive()?"on":"off") + ")");
		}
		return list.toArray();	
	}

	public static Object[] getRemoteQBusList(AclfAdjNetwork adjNet, double tolerance, IPSSMsgHub msg) {
		List<String> list = new ArrayList<String>();
		list.add(AllControlDevices);
		for (int i = 0; i < adjNet.getRemoteQBusList().size(); i++) {
			RemoteQBus reQ = (RemoteQBus)adjNet.getRemoteQBusList().get(i);
			if (reQ.needAdjust(tolerance, adjNet.getBaseKva(), msg)) {
				if (reQ.getControlType() == RemoteQControlType.BUS_VOLTAGE_LITERAL)
					list.add( reQ.getId() + " at " + reQ.getBus().getName() +
							"-> Bus:" + reQ.getRemoteBus().getId());
				else
					list.add( reQ.getId() + " at " + reQ.getBus().getName() +
							"-> Branch:" + reQ.getRemoteBranch().getId());
			}	
		}
		return list.toArray();
	}

	public static Object[] getXfrTapControlList(AclfAdjNetwork adjNet, double tolerance, IPSSMsgHub msg) {
		List<String> list = new ArrayList<String>();
		list.add(AllControlDevices);
		for (int i = 0; i < adjNet.getTapControlList().size(); i++) {
			TapControl xfr = (TapControl)adjNet.getTapControlList().get(i);
			if (xfr.needAdjust(tolerance, adjNet.getBaseKva(), msg)) {
				list.add( xfr.getId() + " at " + xfr.getAclfBranch().getName());
			}	
		}
		return list.toArray();	
	}

	public static Object[] getPSXfrPControlList(AclfAdjNetwork adjNet, double tolerance, IPSSMsgHub msg) {
		List<String> list = new ArrayList<String>();
		list.add(AllControlDevices);
		for (int i = 0; i < adjNet.getPsXfrPControlList().size(); i++) {
			PSXfrPControl psXfr = (PSXfrPControl)adjNet.getPsXfrPControlList().get(i);
			if (psXfr.needAdjust(tolerance, adjNet.getBaseKva(), msg)) {
				list.add( psXfr.getId() + " at " + psXfr.getAclfBranch().getName());
			}	
		}
		return list.toArray();	
	}

	public static Object[] getInterareaPControlList(AclfAdjNetwork adjNet, IPSSMsgHub msg) {
		List<String> list = new ArrayList<String>();
		list.add(AllControlDevices);
		Iterator e = adjNet.getAreaList().iterator();
		while (e.hasNext()) {
			Area a = (Area)e.next();
			if (a.getRegDeviceList().size() > 0) {
				IRegulationDevice regDevice = (IRegulationDevice)a.getRegDeviceList().get(0);
				if (regDevice.needAdjustment(a, adjNet, msg))
					list.add( a.getNumber() + " name: " + a.getName());
			}
		}		
		return list.toArray();	
	}
}
