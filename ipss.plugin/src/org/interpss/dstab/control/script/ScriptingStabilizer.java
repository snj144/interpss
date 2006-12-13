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

public class ScriptingStabilizer extends BaseScriptingController {
	public String StabilizerScriptingObject = "governor";
	
	/**
	 * Constructor
	 * 
	 * @param id stabilizer id
	 * @param name excitor name
	 */
	public ScriptingStabilizer() {
		super("id", "name", "caty", ControllerType.STABILIZER_LITERAL);
	}
	
	/**
	 * Constructor
	 * 
	 * @param id stabilizer id
	 * @param name excitor name
	 */
	public ScriptingStabilizer(final String id, final String name, final String caty, ScriptEngine engine) {
		super(id, name, caty, ControllerType.STABILIZER_LITERAL);
		this.engine = engine;
	}
	
	/**
	 *  Init the controller states
	 *  
	 *  @param msg the SessionMsg object
	 */
	@Override
	public boolean initStates(final IPSSMsgHub msg) {
		return initController(StabilizerScriptingObject, msg);
	}
} 

