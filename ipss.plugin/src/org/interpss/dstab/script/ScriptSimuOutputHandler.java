 /*
  * @(#)ScriptSimuOutputHandler.java   
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
import javax.swing.JTextArea;

import org.interpss.editor.ui.util.GUIFileUtil;

import com.interpss.common.SpringAppContext;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.msg.IpssMessage;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.datatype.DStabSimuAction;
import com.interpss.dstab.util.SimuOutputHandlerAdapter;
import com.interpss.simu.SimuObjectFactory;
import com.interpss.simu.script.ScriptingUtil;

public class ScriptSimuOutputHandler extends SimuOutputHandlerAdapter {
	private Invocable invoker = null;
	private Object scriptObj = null;
	private IPSSMsgHub msg = null;
	private DStabilityNetwork net = null;
	
	public ScriptSimuOutputHandler() {
	}

	@Override
	public void init(String scriptFilename, DStabilityNetwork net) {
		this.msg = SpringAppContext.getIpssMsgHub();
		this.net = net;
		ScriptEngine engine = SimuObjectFactory.createScriptEngine();

		JTextArea textarea = new JTextArea();
		GUIFileUtil.readFile2Textarea(scriptFilename, textarea);
		
		try {
			engine.eval(textarea.getText());
			scriptObj = ScriptingUtil.getScritingObject(engine, msg);
			invoker = (Invocable)engine;
			invoker.invokeMethod(scriptObj, "init", net, msg);
		} catch (Exception e) {
			msg.sendErrorMsg("ScriptSimuOutputHandler.init(), " + e.toString());
		}
	}

	@Override
	public boolean onMsgEventStatus(IpssMessage event) {
		DStabSimuAction e = (DStabSimuAction)event;
		try {
			if (e.getType() == DStabSimuAction.TimeStepMachineStates) {
			   	Hashtable machStates = e.getHashtableData();
				invoker.invokeMethod(scriptObj, "processMachStates", net, machStates, msg);
			}
			else if (e.getType() == DStabSimuAction.TimeStepBusStates) {
			   	Hashtable busStates = e.getHashtableData();
				invoker.invokeMethod(scriptObj, "processBusVariables", net, busStates, msg);
			}
			else if (e.getType() == DStabSimuAction.TimeStepScriptDBusDeviceStates) {
			   	Hashtable busDeviceStates = e.getHashtableData();
				invoker.invokeMethod(scriptObj, "processBusDeviceStates", net, busDeviceStates, msg);
			}
			else if (e.getType() == DStabSimuAction.EndOfSimuStep) {
				invoker.invokeMethod(scriptObj, "processEndOfSimuStep", msg);
			}
		} catch (Exception ex) {
			msg.sendErrorMsg("ScriptSimuOutputHandler.onMsgEventStatus(), " + ex.toString());
			return false;
		}
	   return true;
	}

	@Override
	public boolean close() {
		try {
			invoker.invokeMethod(scriptObj, "close", msg);
		} catch (Exception ex) {
			msg.sendErrorMsg("ScriptSimuOutputHandler.close(), " + ex.toString());
			return false;
		}
		return true;
	}
}