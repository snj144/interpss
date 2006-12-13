/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * An implementation of the Simple excitor model
 *
 * $Id$
 */
package org.interpss.dstab.control.script;

import javax.script.ScriptEngine;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.dstab.mach.ControllerType;

public class ScriptingGovernor extends BaseScriptingController {
	public String GovernorScriptingObject = "governor";
	
	/**
	 * Constructor
	 * 
	 * @param id governor id
	 * @param name excitor name
	 */
	public ScriptingGovernor() {
		super("id", "name", "caty", ControllerType.GOVERNOR_LITERAL);
	}
	
	/**
	 * Constructor
	 * 
	 * @param id governor id
	 * @param name excitor name
	 */
	public ScriptingGovernor(final String id, final String name, final String caty, ScriptEngine engine) {
		super(id, name, caty, ControllerType.GOVERNOR_LITERAL);
		this.engine = engine;
	}
	
	/**
	 *  Init the controller states
	 *  
	 *  @param msg the SessionMsg object
	 */
	@Override
	public boolean initStates(final IPSSMsgHub msg) {
		return initController(GovernorScriptingObject, msg);
	}
} 

