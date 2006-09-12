 /*
  * @(#)AbstractController.java   
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
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.dstab.control.common; 

import java.util.Hashtable;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.mach.ControllerType;
import com.interpss.dstab.mach.impl.ControllerImpl;

public abstract class AbstractController extends ControllerImpl {
	/**
	 * Constructor
	 * 
	 * @param id controller id
	 * @param name controller name
	 * @param type controller type
	 */	
	public AbstractController(final String id, final String name, final String caty, final ControllerType type) {
		setId(id);
		setName(name);
		setCategory(caty);
		this.setStatus(true);
		setType(type);
	}
	
	/**
	 *  Init the controller states
	 *  
	 *  @param msg the SessionMsg object
	 */
	@Override
	abstract public boolean initStates(IPSSMsgHub msg);
	
	/**
	 * Perform one step d-eqn calculation
	 *  
	 * @param dt simulation time interval
	 * @param method d-eqn solution method
	 *  @param msg the SessionMsg object
	 */
	@Override
	abstract public void nextStep(double dt, DynamicSimuMethods method, double baseFreq, IPSSMsgHub msg);
	/**
	 * Get controller states for display purpose
	 * 
	 * @return hashtable of the states
	 */
	@Override
	abstract public Hashtable getStates(Object ref);
	
	/**
	 * Get the controller output
	 * 
	 * @return the output
	 */
	@Override
	abstract public double getOutput();

	/**
	 * Get the editor panel for controller data editing
	 * 
	 * @return the editor panel object
	 */
	@Override
	abstract public Object getEditPanel();
} 

