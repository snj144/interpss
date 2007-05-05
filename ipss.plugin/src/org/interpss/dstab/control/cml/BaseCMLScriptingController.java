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

package org.interpss.dstab.control.cml;

import java.util.Hashtable;

import org.interpss.editor.jgraph.GraphSpringAppContext;
import org.interpss.editor.jgraph.ui.IGraphicEditor;
import org.interpss.editor.ui.util.ScriptJavacUtilFunc;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssJavaCompiler;
import com.interpss.common.util.MemoryJavaCompiler;
import com.interpss.core.net.Network;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.controller.annotate.AbstractAnnotateController;
import com.interpss.dstab.mach.ControllerType;
import com.interpss.dstab.mach.Machine;
import com.interpss.dstab.mach.impl.ControllerImpl;

/**
 * A holder class to wrap an Annotation Controller. The java code is stored in the scripts (getScripts()) field.
 * The code is parsed to replace all the tokens (<className> ...) and then compiled. The compiled class is loaded
 * to create the anController object. All the simulation work will be delegated to the anController object.
 * 
 * @author mzhou
 *
 */
public abstract class BaseCMLScriptingController extends ControllerImpl {
	private AbstractAnnotateController anController = null;
	
	/**
	 * default constructor
	 *
	 */
	public BaseCMLScriptingController() {
		this("controllerId", "ScriptingController", "InterPSS", null); 
	}
	
	/**
	 * Contructor
	 * 
	 * @param id controller id
	 * @param name controller name
	 * @param caty controller category
	 * @param type controller type
	 */
	public BaseCMLScriptingController(final String id, final String name, final String caty, final ControllerType type) {
		setId(id);
		setName(name);
		setCategory(caty);
		this.setStatus(true);
		setType(type);
	}	

	/**
	 *  Init the controller states
	 *  
	 *  @param abus the bus object 
	 *  @param mach the machine
	 *  @param msg the SessionMsg object
	 *  @return false if there is any init problem
	 */
	@Override
	public boolean initStates(DStabBus abus, Machine mach, final IPSSMsgHub msg) {
   		createControllerObject();
    	if (anController != null)
    		return anController.initStates(abus, mach, msg);
    	else
    		return false;
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
		return anController.nextStep(dt, method, abus, mach, net, msg);
	}
	
	/**
	 * Get the controller output
	 * 
	 * @param abus the bus object 
	 * @param mach the machine
	 * @return the output
	 */
	@Override
	public double getOutput(DStabBus abus, Machine mach) {
		return anController.getOutput(abus, mach);
	}

	/**
	 * Get controller states for display purpose
	 * 
	 *  @param abus the bus object 
	 *  @param mach the machine
	 * @param ref, a reference object for output. May not be used
	 * @return hashtable of the states
	 */
	@Override
	public Hashtable getStates(DStabBus abus, Machine mach, Object ref) {
		return anController.getStates(abus, mach, ref);
	}

	/**
	 * Set controller set point
	 * 
	 * @param x the set point value
	 */
	public void setRefPoint(double x) {
		anController.setRefPoint(x);
	}

	abstract public boolean checkJavaCode();
	abstract public void createControllerObject();

	/**
	 * Compile the java code and create the controller object
	 * 
	 * @param baseClassname
	 * @throws Exception
	 */
	protected void createControllerObject(String baseClassname) {
    	IGraphicEditor editor = GraphSpringAppContext.getIpssGraphicEditor();
		String	folderName = editor.getCurrentProjectFolder();
		String	projName = editor.getCurrentProjectName();
		String classname = IpssJavaCompiler.createClassName(getId(), folderName, projName); 
		String javacode = ScriptJavacUtilFunc.parseCMLTag(getScripts(), classname, baseClassname);
		anController = (AbstractAnnotateController)MemoryJavaCompiler.javac( 
				ScriptJavacUtilFunc.CMLControllerPackageName+classname, javacode);
	}

	/**
	 * Before saving java code, the code is saved as temp file and compiled to check any syntax error
	 * 
	 * @param baseClassname, base class name (AbstractExciter, AbstractGovernor ...)
	 * @return
	 */
	public boolean checkJavaCode(String baseClassname) {
		return ScriptJavacUtilFunc.checkJavaCode(getScripts(), baseClassname, ScriptJavacUtilFunc.CMLControllerPackageName);
	}
} 

