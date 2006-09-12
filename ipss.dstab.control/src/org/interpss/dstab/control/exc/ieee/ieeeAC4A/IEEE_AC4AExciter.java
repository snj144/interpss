 /*
  * @(#)IEEE_AC4AExciter.java   
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

package org.interpss.dstab.control.exc.ieee.ieeeAC4A;

import java.util.Hashtable;

import com.interpss.common.datatype.Constants;
import com.interpss.common.exp.InvalidInputException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.XmlUtil;
import com.interpss.dstab.DynamicSimuMethods;
import org.interpss.dstab.control.exc.AbstractExciter;
import com.interpss.dstab.mach.Machine;
import com.interpss.dstab.util.DStabOutFunc;

public class IEEE_AC4AExciter extends AbstractExciter {
	// state vriables
	double _Vref = 0.0, _X1 = 0.0, _X2 = 0.0, _X3 = 0.0, _X4 = 0.0, _X5 = 0.0, _X6 = 0.0;

	// UI Editor panel
	private static final NBIEEE_AC4AExciterEditPanel _editPanel = new NBIEEE_AC4AExciterEditPanel();

	/**
	 * Default Constructor
	 *
	 */
	public IEEE_AC4AExciter() {
		this("excId", "excName", "IEEE-Exciter"); 
	}
	
	/**
	 * Constructor
	 * 
	 * @param id excitor id
	 * @param name excitor name
	 */
	public IEEE_AC4AExciter(final String id, final String name, final String caty) {
		super(id, name, caty);
		 //_data is defined in the parent class. However init it here is a MUST
		_data = new IEEE_AC4AExciterData();
	}
	
	/**
	 * Get the excitor data 
	 * 
	 * @return the data object
	 */
	public IEEE_AC4AExciterData getData() {
		return (IEEE_AC4AExciterData)_data;
	}
	
	/**
	 * Set controller parameters
	 * 
	 * @param xmlString controller parameter xml string
	 */
	@Override
	public void setDataXmlString(final String xmlString) {
		super.setDataXmlString(xmlString);
		_data = XmlUtil.toObject(xmlString, IEEE_AC4AExciterData.class);
	}
	
	/**
	 *  Init the controller states
	 *  
	 *  @param msg the SessionMsg object
	 */
	@Override
	public boolean initStates(final IPSSMsgHub msg) {
		final Machine mach = getMachine();
		_X5 = mach.getEfd();
		//Check Efd limit
		//TODO
		//double ifd = mach.getIfd();
		final double ifd = 0.0;
		if ( (_X5 > getData().getVrmax() - getData().getKc()*ifd ) || (_X5 < getData().getVrmin()) )
		{
			//TODO: throw error MSG " Exciter Initialization Failed "
		}
		_X4 = _X5 / getData().getKa();
		//Check Vuel limit
		if ( _X4 < getData().getVuel() ) {
			//TODO: throw error MSG " Exciter Initialization Failed "
		}
		else {
			_X3 = _X4;
		}
		_X2 = _X3;
		//Check X2 limit
		if ( (_X4 > getData().getVimax() ) || (_X4 < getData().getVimin() ) ) {
			//TODO: throw error MSG " Exciter Initialization Failed "
		}	
		final int ctr_bus_id = getData().getCtrBusID();
		//TODO
		//double vt = mach.getBus(ctr_bus_id).getVoltage().abs() / mach.getVMultiFactor();
		final double vt = mach.getBus().getVoltage().abs() / mach.getVMultiFactor();
		_X1 = vt;
		final double vpss = mach.hasStabilizer()? mach.getStabilizer().getOutput() : 0.0;
		_Vref = _X1 + _X2 - vpss;
		return true;

	}
	
	private double cal_dX1_dt(final double X1) {
		final Machine mach = getMachine();
		final double vt = mach.getBus().getVoltage().abs() / mach.getVMultiFactor();
		return ( vt  - X1) / getData().getTa();
	}
	
	private double cal_dX3_dt(final double X3, final double dX2) {
		return ( _X2  + dX2 * getData().getTc()- X3) / getData().getTb();
	}

	private double cal_dX5_dt(final double X5) {
		return ( _X4 * getData().getKa()- X5) / getData().getTa();
	}

	/**
	 * Perform one step d-eqn calculation
	 *  
	 * @param dt simulation time interval
	 * @param method d-eqn solution method
	 * @param msg the SessionMsg object
	 */
	@Override
	public void nextStep(final double dt, final DynamicSimuMethods method, final double baseFreq, final IPSSMsgHub msg) {
		if (method == DynamicSimuMethods.MODIFIED_EULER_LITERAL) {
			final Machine mach = getMachine();
			//Block 1
			if(getData().getTa() < Constants.SmallDoubleNumber) {
				_X1 = mach.getBus().getVoltage().abs() / mach.getVMultiFactor();
			}
			else {
				//Step-1 : x(1) = x(0) + dx_dt(1) * dt
				final double dX1_dt = cal_dX1_dt(_X1);
				final double X1 = _X1 + dX1_dt * dt;
				//System.out.println("dX1_dt, X1: " + dX1_dt + ", " + X1);
				 //Step-2 : x(2) = x(0) + 0.5 * (dx_dt(2) + dx_dt(1)) * dt
				_X1 = _X1 + 0.5 * ( cal_dX1_dt(X1) + dX1_dt ) * dt;
			}
			//Block 2
			final double _X2_old = _X2;
			final double vpss = mach.hasStabilizer()? mach.getStabilizer().getOutput() : 0.0;
			if( ( _Vref + vpss - _X1 ) > getData().getVimax()) {
				_X2 = getData().getVimax();
			}
			else if ( ( _Vref + vpss - _X1 ) < getData().getVimin()) {
				_X2 = getData().getVimin();
			}
			else {
				_X2 = _Vref + vpss - _X1;
			}
			final double dX2 = ( _X2 - _X2_old )/dt;
			//Block 3
			if(getData().getTb() < Constants.SmallDoubleNumber) {
				_X3 = _X2 + dX2 * getData().getTc();
			}
			else {
				//Step-1 : x(1) = x(0) + dx_dt(1) * dt
				final double dX3_dt = cal_dX3_dt(_X3, dX2);
				final double X3 = _X3 + dX3_dt * dt;
				//System.out.println("dX1_dt, X1: " + dX1_dt + ", " + X1);
				 //Step-2 : x(2) = x(0) + 0.5 * (dx_dt(2) + dx_dt(1)) * dt
				_X3 = _X3 + 0.5 * ( cal_dX3_dt(X3, dX2) + dX3_dt ) * dt;
			}
			//Block 4
			if(_X3 < getData().getVuel()) {
				_X4 = getData().getVuel();
			}
			else {
				_X4 = _X3;
			}
			//Block 5
			if(getData().getTa() < Constants.SmallDoubleNumber) {
				_X5 = _X4 * getData().getKa();
			}
			else {
				//Step-1 : x(1) = x(0) + dx_dt(1) * dt
				final double dX5_dt = cal_dX5_dt(_X5);
				final double X5 = _X5 + dX5_dt * dt;
				//System.out.println("dX1_dt, X1: " + dX1_dt + ", " + X1);
				 //Step-2 : x(2) = x(0) + 0.5 * (dx_dt(2) + dx_dt(1)) * dt
				_X5 = _X5 + 0.5 * ( cal_dX5_dt(X5) + dX5_dt ) * dt;
			}
			//check X5 limit(non-wind up)
			//TODO
			//double ifd = mach.getIfd();
			final double ifd = 0.0;
			if(( cal_dX5_dt(_X5) > 0.0 ) && ( _X5 > getData().getVrmax() - getData().getKc()*ifd )) {
				_X6 = getData().getVrmax() - getData().getKc()*ifd;
			}
			else if( ( cal_dX5_dt(_X5) < 0.0 ) && ( _X5 < getData().getVrmin()) ) {
				_X6 = getData().getVrmin();			
			}
			else {
				_X6 = _X5;
			}
			
		}
		else if (method == DynamicSimuMethods.RUNGE_KUTTA_LITERAL) {
			// TODO: TBImpl
		} else {
			throw new InvalidInputException("IEEE_AC4AExciter.nextStep(), invalid method");
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
		table.put(DStabOutFunc.OUT_SYMBOL_EXC_EFD, new Double(_X5));
		return table;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String[] getStateSymbolList() {
		final String[] list = {DStabOutFunc.OUT_SYMBOL_EXC_EFD};
		return list;
	}
	
	/**
	 * Get the controller output
	 * 
	 * @return the output
	 */
	@Override
	public double getOutput() {
		return _X6;
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
//		return this;
	}

}// IEEE_AC4AExcAdapter
