package org.interpss.dstab.script;

/**
 * Text out dstab simulation action handler for processing dstab output events. This is mainly for 
 * debug purpose 
 */

import java.util.Hashtable;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.swing.JTextArea;

import org.interpss.editor.ui.util.GUIFileUtil;

import com.interpss.common.SpringAppContext;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.msg.IpssMessage;
import com.interpss.common.util.IpssLogger;
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