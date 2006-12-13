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

public class ScriptingExciter extends BaseScriptingController {
	public String ExciterScriptingObject = "exciter";
	
	/**
	 * Constructor
	 * 
	 * @param id excitor id
	 * @param name excitor name
	 */
	public ScriptingExciter() {
		super("excId", "excName", "excCaty", ControllerType.EXCITER_LITERAL);
	}
	
	/**
	 * Constructor
	 * 
	 * @param id excitor id
	 * @param name excitor name
	 */
	public ScriptingExciter(final String id, final String name, final String caty) {
		super(id, name, caty, ControllerType.EXCITER_LITERAL);
	}
} 

