 /*
  * @(#)CustomGovernor.java   
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

package ipss.custom.dstab.gov;

import java.util.Hashtable;

import com.interpss.common.datatype.LimitType;
import com.interpss.common.exp.InvalidInputException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.dstab.DynamicSimuMethods;
import org.interpss.dstab.control.gov.AbstractGovernor;

public class CustomGovernor extends AbstractGovernor {
	// state variables
	double _Pm0 = 0.0, _X1 = 0.0;
	LimitType _Limit = null;
	
	// UI Editor panel
	private static NBCustomGovernorEditPanel _editPanel = new NBCustomGovernorEditPanel();

	/**
	 * Default Constructor
	 *
	 */
	public CustomGovernor() {
		this("govId", "govName", "InterPSS");
	}
	
	/**
	 * Constructor
	 * 
	 * @param id governor id
	 * @param name governor name
	 */	
	public CustomGovernor(String id, String name, String caty) {
		super(id, name, caty);
		// _data is defined in the parent class. However init it here is a MUST
		_data = new CustomGovernorData();
	}
	
	/**
	 * Get the governor data 
	 * 
	 * @return the data object
	 */
	public CustomGovernorData getData() {
		return (CustomGovernorData)_data;
	}
	
	/**
	 *  Init the controller states
	 *  
	 *  @param msg the SessionMsg object
	 */
	public boolean initStates(IPSSMsgHub msg) {
		_Limit = new LimitType(getData().getPmax(), getData().getPmin());
		_Pm0 = getMachine().getPm();
		_X1 = 0.0;
		return true;
	}

	private double cal_dX1_dt(double X1) {
		return ( getData().getK() * (getMachine().getSpeed() - 1.0) - X1 ) / getData().getT1();
	}
	
	/**
	 * Perform one step d-eqn calculation
	 *  
	 * @param dt simulation time interval
	 * @param method d-eqn solution method
	 *  @param msg the SessionMsg object
	 */	
	public void nextStep(double dt, DynamicSimuMethods method, double baseFreq, IPSSMsgHub msg) {
		if (method == DynamicSimuMethods.MODIFIED_EULER_LITERAL) {
			/*
			 *     Step-1 : x(1) = x(0) + dx_dt(1) * dt
			 *     Step-2 : x(2) = x(0) + 0.5 * (dx_dt(2) +- dx_dt(1)) * dt
			 */
			double dX1_dt = cal_dX1_dt(_X1);
			double X1_1 = _X1 + dX1_dt * dt;

			_X1 = _X1 + 0.5 * (cal_dX1_dt(X1_1) + dX1_dt) * dt;
		}
		else if (method == DynamicSimuMethods.RUNGE_KUTTA_LITERAL) {
			// TODO: TBImpl
		}
		else
			throw new InvalidInputException("SimpleGovernor.nextStep(), invalid method");
	}	
	
	/**
	 * Get controller states for display purpose
	 * 
	 * @return hashtable of the states
	 */	
	public Hashtable getStates(Object ref) {
		Hashtable table = new Hashtable();
		return table;
	}
	
	/**
	 * Get the controller output
	 * 
	 * @return the output
	 */	
	public double getOutput() {
		return _Limit.limit(_Pm0 - _X1);
	}

	/**
	 * Get the editor panel for controller data editing
	 * 
	 * @return the editor panel object
	 */	
	public Object getEditPanel() {
		_editPanel.init(this);
		return _editPanel;
	}
} // SimpleExcAdapter