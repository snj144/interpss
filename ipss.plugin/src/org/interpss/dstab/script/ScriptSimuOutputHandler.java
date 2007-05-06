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

import javax.swing.JTextArea;

import org.interpss.editor.ui.IScriptTool;
import org.interpss.editor.ui.util.GUIFileUtil;
import org.interpss.editor.ui.util.ScriptJavacUtilFunc;

import com.interpss.common.SpringAppContext;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.msg.IpssMessage;
import com.interpss.common.util.MemoryJavaCompiler;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.datatype.DStabSimuAction;
import com.interpss.dstab.util.SimuOutputHandlerAdapter;

public class ScriptSimuOutputHandler extends SimuOutputHandlerAdapter {
	private IPSSMsgHub msg = null;
	private DStabilityNetwork net = null;
	private IScriptTool tool = null;
	
	public ScriptSimuOutputHandler() {
	}

	@Override
	public boolean init(String scriptFilename, DStabilityNetwork net) {
		this.msg = SpringAppContext.getIpssMsgHub();
		this.net = net;

		JTextArea textarea = new JTextArea();
		GUIFileUtil.readFile2TextareaAbsolutePath(scriptFilename, textarea);
		//System.out.println(textarea.getText());
		
		String javacode = textarea.getText();
		this.tool = (IScriptTool)MemoryJavaCompiler.javac(
   					ScriptJavacUtilFunc.DStabOutputScriptingClassName, javacode);
		try {
			tool.initDStabOutputScripting(net);
		} catch (Exception e) {
			msg.sendErrorMsg("Error in the init() section: " + e.toString());
			return false;
		}
		return true;
	}

	@Override
	public boolean onMsgEventStatus(IpssMessage event) {
		DStabSimuAction e = (DStabSimuAction)event;
		if (e.getType() == DStabSimuAction.TimeStepMachineStates) {
		   	Hashtable machStates = e.getHashtableData();
			if (!this.tool.machStatesDStabOutputScripting(net, machStates))
				return false;
		}

		if (e.getType() == DStabSimuAction.TimeStepBusStates) {
		   	Hashtable busStates = e.getHashtableData();
			if (!this.tool.busVariablesDStabOutputScripting(net, busStates))
				return false;
		}

		if (e.getType() == DStabSimuAction.TimeStepScriptDynamicBusDeviceStates) {
		   	Hashtable busDeviceStates = e.getHashtableData();
			if (!this.tool.busDeviceStatesDStabOutputScripting(net, busDeviceStates))
				return false;
		}

		if (e.getType() == DStabSimuAction.EndOfSimuStep) {
			try {
				this.tool.endOfSimuStepDStabOutputScripting();
			} catch (Exception ex) {
				msg.sendErrorMsg("Error in processEndOfSimuStep section, " + ex.toString());
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean close() {
		try {
			this.tool.closeDStabOutputScripting();
		} catch (Exception ex) {
			msg.sendErrorMsg("ScriptSimuOutputHandler.close(), " + ex.toString());
			return false;
		}
		return true;
	}
}