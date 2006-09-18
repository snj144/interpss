 /*
  * @(#)IEEE_DC1AExciter.java   
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

package org.interpss.dstab.control.exc.ieee.ieeeDC1A;

import java.util.Hashtable;

import com.interpss.common.exp.InvalidInputException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.XmlUtil;
import com.interpss.dstab.DynamicSimuMethods;
import org.interpss.dstab.control.exc.AbstractExciter;

public class IEEE_DC1AExciter extends AbstractExciter {
	// state vriables
	// TODO
	
	// UI Editor panel
	private static final NBIEEE_DC1AExciterEditPanel _editPanel = new NBIEEE_DC1AExciterEditPanel();
	
	/**
	 * Default Constructor
	 *
	 */
	public IEEE_DC1AExciter() {
		this("excId", "excName", "IEEE-Exciter"); 
	}
	
	/**
	 * Constructor
	 * 
	 * @param id excitor id
	 * @param name excitor name
	 */
	public IEEE_DC1AExciter(final String id, final String name, final String caty) {
		super(id, name, caty);
		// _data is defined in the parent class. However init it here is a MUST
		_data = new IEEE_DC1AExciterData();
	}
	
	/**
	 * Get the excitor data 
	 * 
	 * @return the data object
	 */
	public IEEE_DC1AExciterData getData() {
		return (IEEE_DC1AExciterData)_data;
	}
	
	/**
	 * Set controller parameters
	 * 
	 * @param xmlString controller parameter xml string
	 */
	@Override
	public void setDataXmlString(final String xmlString) {
		super.setDataXmlString(xmlString);
		_data = XmlUtil.toObject(xmlString, IEEE_DC1AExciterData.class);
	}
	
	/**
	 *  Init the controller states
	 *  
	 *  @param msg the SessionMsg object
	 */
	@Override
	public boolean initStates(final IPSSMsgHub msg) {
		// TODO: 
		return true;
	}
	
	/**
	 * Perform one step d-eqn calculation
	 *  
	 * @param dt simulation time interval
	 * @param method d-eqn solution method
	 * @param msg the SessionMsg object
	 */
	@Override
	public void nextStep(final double dt, final DynamicSimuMethods method, final double baseFreq,  final IPSSMsgHub msg) {
		if (method == DynamicSimuMethods.MODIFIED_EULER_LITERAL) {
			 //     Step-1 : x(1) = x(0) + dx_dt(1) * dt
			// TODO: 
		}
		else if (method == DynamicSimuMethods.RUNGE_KUTTA_LITERAL) {
			// TODO: TBImpl
		} else {
			throw new InvalidInputException("IEEE_DC1AExciter.nextStep(), invalid method");
		}
	}

	/**
	 * Get controller states for display purpose
	 * 
	 * @return hashtable of the states
	 */
	@Override
	public Hashtable getStates(Object ref) {
		final Hashtable table = new Hashtable();
		// TODO: 
		return table;
	}
	
	/**
	 * Get the controller output
	 * 
	 * @return the output
	 */
	@Override
	public double getOutput() {
		// TODO: 
		return 0.0;
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
} // IEEE_DC1AExcAdapter

