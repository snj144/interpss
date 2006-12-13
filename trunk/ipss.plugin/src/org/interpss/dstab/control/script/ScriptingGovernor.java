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

import com.interpss.dstab.mach.ControllerType;

public class ScriptingGovernor extends BaseScriptingController {
	/**
	 * Constructor 
	 */
	public ScriptingGovernor() {
		super("govId", "govName", "govCaty", ControllerType.GOVERNOR_LITERAL);
	}
	
	/**
	 * Constructor
	 * 
	 * @param id governor id
	 * @param name governor name
	 */
	public ScriptingGovernor(final String id, final String name, final String caty) {
		super(id, name, caty, ControllerType.GOVERNOR_LITERAL);
	}
} 

