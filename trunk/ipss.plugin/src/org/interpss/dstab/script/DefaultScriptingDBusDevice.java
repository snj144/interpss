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
	Object controller = null;
	IPSSMsgHub message = null;
	
	@Override
	public boolean initStates(DStabBus abus, Network net, IPSSMsgHub msg) {
		try {
			this.message = msg;
			ScriptEngine engine = SimuObjectFactory.createScriptEngine();
			engine.eval(getScripts());
			controller = ScriptingUtil.getScritingObject(engine, msg);
			invoker = (Invocable)engine;
			invoker.invokeMethod(controller, "initStates", getDeviceBus(), net, msg);
		} catch (Exception e) {
			msg.sendErrorMsg("DefaultScriptingDBusDevice.initStates(), " + e.toString());
			return false;
		}
		return true;
	}

	@Override
	public boolean nextStep(double dt, DynamicSimuMethods method, DStabBus abus, Network net, IPSSMsgHub msg) {
		try {
			invoker.invokeMethod(controller, "nextStep", getDeviceBus(), dt, method, net, msg);
			return true;
		} catch (Exception e) {
			msg.sendErrorMsg("DefaultScriptingDBusDevice.nextStep(), " + e.toString());
			return false;
		}
	}

	@Override
	public Object getOutputObject(DStabBus abus) {
		try {
			return invoker.invokeMethod(controller, "getOutput", getDeviceBus());
		} catch (Exception e) {
			message.sendErrorMsg("DefaultScriptingDBusDevice.getOutput(), " + e.toString());
		}
		return null;
	}

	@Override
	public Hashtable getStates(DStabBus abus, Object refMach) {
		final Hashtable<String,Double> table = new Hashtable<String,Double>();
		try {
			invoker.invokeMethod(controller, "getStates", getDeviceBus(), refMach, table);
		} catch (Exception e) {
			message.sendErrorMsg("DefaultScriptingDBusDevice.getStates(), "  + e.toString());
		}
		return table;
	}

}
