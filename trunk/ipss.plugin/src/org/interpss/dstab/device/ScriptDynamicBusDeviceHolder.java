 /*
  * @(#)BaseCMLDynamicBusDevice.java   
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

package org.interpss.dstab.device;

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
import com.interpss.dstab.device.ScriptDynamicBusDevice;
import com.interpss.dstab.device.impl.ScriptDynamicBusDeviceImpl;

/**
 * This is place holder for a ScriptDynamicBusDevice implementation. The work will be delegated 
 * to the device object to perform. The original java code is stored in the object. the code
 * will be compiled to create the device object.
 * 
 * @author mzhou
 *
 */
public class ScriptDynamicBusDeviceHolder extends ScriptDynamicBusDeviceImpl {
	private ScriptDynamicBusDevice device = null;
	private String classname = "";
	
	
	/**
	 * Generate Java code, compile code, load compile class and then delegate init to the 
	 * created device object
	 * 
	 * @param abus the bus object
	 * @param net the network object
	 * @param msg the MessageHub object
	 * @return false if there is anything wrong 
	 */
	public boolean initStates(DStabBus abus, Network net, IPSSMsgHub msg) {
   		createDeviceObject();
   		if (device != null)
   			return device.initStates(abus, net, msg);
   		else 
   			return false;
	}

	/**
	 * Solve a step of ODE of the device object
	 * 
	 * @param dt time step
	 * @param method ODE solution method
	 * @param abus the bus object
	 * @param net the network object
	 * @param msg the MessageHub object
	 * @return false if there is anything wrong 
	 */
	public boolean nextStep(double dt, DynamicSimuMethods method, DStabBus abus, Network net, IPSSMsgHub msg) {
		return device.nextStep(dt, method, abus, net, msg);
	}

	/**
	 * Get the device output object, normally the inject cuerrent into the network 
	 * 
	 * @param abus the bus object
	 */
	public Object getOutputObject(DStabBus abus) {
		return device.getOutputObject(abus);
	}

	/**
	 * Get the device states 
	 * 
	 * @param abus the bus object
	 * @refMach the ref machine object
	 */
	public Hashtable getStates(DStabBus abus, Object refMach) {
		return device.getStates(abus, refMach);
	}

	/**
	 * update device attributes
	 * 
	 * @param abus the bus object
	 * @param netChange if there is any network change event
	 * @return false if there is any problem
	 */
	public boolean updateAttributes(DStabBus abus, boolean netChange)  {
		return device.updateAttributes(abus, netChange);
	}
	
	private void createDeviceObject() {
    	IGraphicEditor editor = GraphSpringAppContext.getIpssGraphicEditor();
		this.classname = IpssJavaCompiler.createClassName(getId(), 
							editor.getCurrentProjectFolder(), editor.getCurrentProjectName());
		String javacode = getScripts().replaceFirst(ScriptJavacUtilFunc.Tag_Classname, this.classname);
		device = (ScriptDynamicBusDevice)MemoryJavaCompiler.javac( 
				ScriptJavacUtilFunc.CMLControllerPackageName+this.classname, javacode);
	}
	
/*
	private boolean generateJavaCode() {
    	IGraphicEditor editor = GraphSpringAppContext.getIpssGraphicEditor();
		this.classname = IpssJavaCompiler.createClassName(getId(), 
							editor.getCurrentProjectFolder(), editor.getCurrentProjectName());
		String javacode = getScripts().replaceFirst(ScriptJavacUtilFunc.Tag_Classname, this.classname);
		String filename = IpssJavaCompiler.createJavaFilename(this.classname, 
								ScriptJavacUtilFunc.CMLDynamicBusControllerPackageName, editor.getRootDir());
		GUIFileUtil.writeText2FileAbsolutePath(filename, javacode);			
		return true;
	}
	
	private boolean compileJavaCode() {
    	IGraphicEditor editor = GraphSpringAppContext.getIpssGraphicEditor();
		String filename = IpssJavaCompiler.createJavaFilename(this.classname, 
								ScriptJavacUtilFunc.CMLDynamicBusControllerPackageName, editor.getRootDir());
		if (IpssJavaCompiler.javac(filename))
			device = ScriptJavacUtilFunc.createCMLDynamicBusDeviceObject(this.classname);		
		return true;
	}
*/	
}
