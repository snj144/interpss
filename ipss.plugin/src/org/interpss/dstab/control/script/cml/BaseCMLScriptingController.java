 /*
  * @(#)BaseScriptingController.java   
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

import java.util.Hashtable;

import org.interpss.editor.ui.util.GUIFileUtil;
import org.interpss.editor.ui.util.CMLJavaCompiler;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.net.Network;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.controller.AbstractController;
import com.interpss.dstab.controller.annotate.AbstractAnnotateController;
import com.interpss.dstab.mach.ControllerType;
import com.interpss.dstab.mach.Machine;

public abstract class BaseCMLScriptingController extends AbstractController {
	AbstractAnnotateController controller = null;
	String classname = "";
	IPSSMsgHub message = null;
	
	public BaseCMLScriptingController() {
		this("controllerId", "ScriptingController", "InterPSS", null); 
	}
	
	public BaseCMLScriptingController(final String id, final String name, final String caty, final ControllerType type) {
		super(id, name, caty, type);
	}	

	/**
	 *  Init the controller states
	 *  
	 *  @param msg the SessionMsg object
	 */
	@Override
	public boolean initStates(DStabBus abus, Machine mach, final IPSSMsgHub msg) {
    	generateJavaCode();
    	compileJavaCode();
    	
    	controller = CMLJavaCompiler.createObject(this.classname);
    	controller.initStates(abus, mach, msg);
		return true;
	}
	
	/**
	 * Perform one step d-eqn calculation
	 *  
	 * @param dt simulation time interval
	 * @param method d-eqn solution method
	 * @param baseFreq base frequency
	 * @param msg the SessionMsg object
	 */
	@Override
	public boolean nextStep(final double dt, final DynamicSimuMethods method, DStabBus abus, Machine mach, final Network net, final IPSSMsgHub msg) {
		return controller.nextStep(dt, method, abus, mach, net, msg);
	}
	
	/**
	 * Get the controller output
	 * 
	 * @return the output
	 */
	@Override
	public double getOutput(DStabBus abus, Machine mach) {
		return controller.getOutput(abus, mach);
	}

	/**
	 * Get controller states for display purpose
	 * 
	 * @param ref, a reference object for output. May not be used
	 * @return hashtable of the states
	 */
	@Override
	public Hashtable getStates(DStabBus abus, Machine mach, Object ref) {
		return controller.getStates(abus, mach, ref);
	}

	public void setRefPoint(double x) {
		controller.setRefPoint(x);
	}

	abstract public void generateJavaCode();
	abstract public boolean checkJavaCode();

	public void generateJavaCode(String baseClassname) {
		this.classname = CMLJavaCompiler.createClassName(getId());
		String javacode = CMLJavaCompiler.parseTag(getScripts(), this.classname, baseClassname);
		String filename = CMLJavaCompiler.createJavaFilename(this.classname);
		GUIFileUtil.writeText2FileAbsolutePath(filename, javacode);	
	}
	
	public void compileJavaCode() {
		String filename = CMLJavaCompiler.createJavaFilename(this.classname);
		CMLJavaCompiler.compileJavaCode(filename);
	}
	
	public boolean checkJavaCode(String baseClassname) {
		String javacode = CMLJavaCompiler.parseTag(getScripts(), "CheckCode", baseClassname);
		String filename = CMLJavaCompiler.createJavaFilename("CheckCode");
		GUIFileUtil.writeText2FileAbsolutePath(filename, javacode);	
		return CMLJavaCompiler.compileJavaCode(filename);
	}
} 

