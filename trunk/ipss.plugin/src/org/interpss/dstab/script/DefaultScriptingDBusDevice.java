package org.interpss.dstab.script;

import java.util.Hashtable;

import javax.script.Invocable;
import javax.script.ScriptEngine;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.net.Network;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.device.impl.ScriptingDBusDeviceImpl;
import com.interpss.simu.SimuObjectFactory;
import com.interpss.simu.script.ScriptingUtil;

public class DefaultScriptingDBusDevice extends ScriptingDBusDeviceImpl {
	Invocable invoker = null;
	Object dBusDevice = null;
	IPSSMsgHub message = null;
	
	@Override
	public boolean initStates(DStabBus abus, Network net, IPSSMsgHub msg) {
		try {
			this.message = msg;
			ScriptEngine engine = SimuObjectFactory.createScriptEngine();
			engine.eval(getScripts());
			dBusDevice = ScriptingUtil.getScritingObject(engine, msg);
			invoker = (Invocable)engine;
			invoker.invokeMethod(dBusDevice, "initStates", abus, net, msg);
		} catch (Exception e) {
			msg.sendErrorMsg("DefaultScriptingDBusDevice.initStates(), " + e.toString());
			return false;
		}
		return true;
	}

	@Override
	public boolean nextStep(double dt, DynamicSimuMethods method, DStabBus abus, Network net, IPSSMsgHub msg) {
		try {
			invoker.invokeMethod(dBusDevice, "nextStep", dt, method, abus, net, msg);
			return true;
		} catch (Exception e) {
			msg.sendErrorMsg("DefaultScriptingDBusDevice.nextStep(), " + e.toString());
			return false;
		}
	}

	@Override
	public Object getOutputObject(DStabBus abus) {
		try {
			return invoker.invokeMethod(dBusDevice, "getOutput", abus);
		} catch (Exception e) {
			message.sendErrorMsg("DefaultScriptingDBusDevice.getOutput(), " + e.toString());
		}
		return null;
	}

	@Override
	public Hashtable getStates(DStabBus abus, Object refMach) {
		try {
			return (Hashtable)invoker.invokeMethod(dBusDevice, "getStates", abus, refMach);
		} catch (Exception e) {
			message.sendErrorMsg("DefaultScriptingDBusDevice.getStates(), "  + e.toString());
		}
		return null;
	}

	@Override
	public boolean updateAttributes(DStabBus bus, boolean netChange)  {
		try {
			invoker.invokeMethod(dBusDevice, "updateAttributes", bus, netChange);
			return true;
		} catch (Exception e) {
			message.sendErrorMsg("DefaultScriptingDBusDevice.updateAttributes(), "  + e.toString());
		}
		return false;
	}
}
