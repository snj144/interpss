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

public class ScriptingStabilizer extends BaseScriptingController {
	/**
	 * Constructor
	 */
	public ScriptingStabilizer() {
		super("pssId", "pssName", "pssCaty", ControllerType.STABILIZER_LITERAL);
	}
	
	/**
	 * Constructor
	 * 
	 * @param id stabilizer id
	 * @param name stabilizer name
	 */
	public ScriptingStabilizer(final String id, final String name, final String caty) {
		super(id, name, caty, ControllerType.STABILIZER_LITERAL);
	}
} 

