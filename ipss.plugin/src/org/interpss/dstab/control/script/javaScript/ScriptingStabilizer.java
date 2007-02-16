 /*
  * @(#)ScriptingStabilizer.java   
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

package org.interpss.dstab.control.script.javaScript;

import com.interpss.dstab.mach.ControllerType;

public class ScriptingStabilizer extends BaseScriptingController {
	// define UI Editor panel for editing the controller data
	private static final NBControllerScriptsEditPanel _editPanel = new NBControllerScriptsEditPanel();

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
	
	/**
	 * Get the editor panel for controller data editing
	 * 
	 * @return the editor panel object
	 */
	@Override
	public Object getEditPanel() {
		_editPanel.init(this);
		return _editPanel;
	}	
} 

