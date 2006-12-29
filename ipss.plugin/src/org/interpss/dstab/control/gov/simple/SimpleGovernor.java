 /*
  * @(#)SimpleGovernor.java   
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

package org.interpss.dstab.control.gov.simple;

import com.interpss.common.datatype.LimitType;
import com.interpss.common.exp.InvalidInputException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.XmlUtil;
import com.interpss.core.net.Network;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.controller.AbstractGovernor;

public class SimpleGovernor extends AbstractGovernor {
	// state variables
	private double pm0 = 0.0, stateX1 = 0.0;
	private LimitType limit = null;
	
	// UI Editor panel
	private static final NBSimpleGovernorEditPanel _editPanel = new NBSimpleGovernorEditPanel();

	/**
	 * Default Constructor
	 *
	 */
	public SimpleGovernor() {
		this("govId", "SimpleGovernor", "InterPSS");
	}
	
	/**
	 * Constructor
	 * 
	 * @param id governor id
	 * @param name governor name
	 */	
	public SimpleGovernor(final String id, final String name, final String caty) {
		super(id, name, caty);
		// _data is defined in the parent class. However init it here is a MUST
		_data = new SimpleGovernorData();
	}
	
	/**
	 * Get the governor data 
	 * 
	 * @return the data object
	 */
	public SimpleGovernorData getData() {
		return (SimpleGovernorData)_data;
	}
	
	/**
	 * Set controller parameters
	 * 
	 * @param xmlString controller parameter xml string
	 */
	@Override
	public void setDataXmlString(final String xmlString) {
		super.setDataXmlString(xmlString);
		_data = XmlUtil.toObject(xmlString, SimpleGovernorData.class);
	}
	
	/**
	 *  Init the controller states
	 *  
	 *  @param msg the SessionMsg object
	 */
	@Override
	public boolean initStates(DStabBus abus, final IPSSMsgHub msg) {
		limit = new LimitType(getData().getPmax(), getData().getPmin());
		pm0 = getMachine().getPm();
		stateX1 = 0.0;
		IpssLogger.getLogger().fine("Governor Limit:      " + limit);
		return true;
	}

	private double cal_dX1_dt(final double x1) {
		IpssLogger.getLogger().fine("dW: " + (getMachine().getSpeed()-1.0));
		return ( getData().getK() * (getMachine().getSpeed() - 1.0) - x1 ) / getData().getT1();
	}
	
	/**
	 * Perform one step d-eqn calculation
	 *  
	 * @param dt simulation time interval
	 * @param method d-eqn solution method
	 *  @param msg the SessionMsg object
	 */	
	@Override
	public boolean nextStep(final double dt, final DynamicSimuMethods method, final Network net, final IPSSMsgHub msg) {
		if (method == DynamicSimuMethods.MODIFIED_EULER_LITERAL) {
			/*
			 *     Step-1 : x(1) = x(0) + dx_dt(1) * dt
			 *     Step-2 : x(2) = x(0) + 0.5 * (dx_dt(2) +- dx_dt(1)) * dt
			 */
			final double dX1_dt = cal_dX1_dt(stateX1);
			IpssLogger.getLogger().fine("SimpleGovernor dX1_dt: " + dX1_dt);
			final double x1_1 = stateX1 + dX1_dt * dt;

			stateX1 = stateX1 + 0.5 * (cal_dX1_dt(x1_1) + dX1_dt) * dt;
			return true;
		}
		else if (method == DynamicSimuMethods.RUNGE_KUTTA_LITERAL) {
			// TODO: TBImpl
			return false;
		} else {
			throw new InvalidInputException("SimpleGovernor.nextStep(), invalid method");
		}
	}	
	
	/**
	 * Get the controller output
	 * 
	 * @return the output
	 */	
	@Override
	public double getOutput() {
		IpssLogger.getLogger().fine("Governor _Pm0 - _X1: " + (pm0 - stateX1));
		return limit.limit(pm0 - stateX1);
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

	/**
	 * @return Returns the limit.
	 */
	public LimitType getLimit() {
		return limit;
	}

	/**
	 * @return Returns the pm0.
	 */
	public double getPm0() {
		return pm0;
	}

	/**
	 * @return Returns the x1.
	 */
	public double getStateX1() {
		return stateX1;
	}
	
	public void setRefPoint(double x) {
		pm0 = x;
	}	
} // SimpleExcAdapter
