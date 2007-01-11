 /*
  * @(#)DefaultScriptingDBusDevice.java   
  *
  * Copyright (C) 2006 www.interpss.org
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
  * @Date 05/01/2007
  * 
  *   Revision History
  *   ================
  *
  */

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
