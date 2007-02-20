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

package org.interpss.dstab.control.script.cml;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.mach.ControllerType;
import com.interpss.dstab.mach.Machine;

public class CMLScriptingStabilizer extends BaseCMLScriptingController {
	/**
	 * Constructor
	 */
	public CMLScriptingStabilizer() {
		super("pssId", "pssName", "pssCaty", ControllerType.STABILIZER_LITERAL);
	}
	
	/**
	 * Constructor
	 * 
	 * @param id stabilizer id
	 * @param name stabilizer name
	 */
	public CMLScriptingStabilizer(final String id, final String name, final String caty) {
		super(id, name, caty, ControllerType.STABILIZER_LITERAL);
	}
	
	/**
	 *  Init the controller states
	 *  
	 *  @param msg the SessionMsg object
	 */
	@Override
	public boolean initStates(DStabBus abus, Machine mach, final IPSSMsgHub msg) {
		setId(mach.getId() + "_Pss");
		return super.initStates(abus, mach, msg);
	}	
	
	public void generateJavaCode() {
		generateJavaCode("AnnotateStabilizer");
	}
	
	public boolean checkJavaCode() {
		return checkJavaCode("AnnotateStabilizer");
	}	
} 

