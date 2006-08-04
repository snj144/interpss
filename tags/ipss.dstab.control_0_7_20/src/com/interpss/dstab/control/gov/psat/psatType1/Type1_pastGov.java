/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * An implementation of the Simple governor model
 *
 * $Id$
 */

package com.interpss.dstab.control.gov.psat.psatType1;

import java.util.Hashtable;

import com.interpss.common.datatype.LimitType;
import com.interpss.common.exp.InvalidInputException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.XmlUtil;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.control.gov.AbstractGovernor;
import com.interpss.dstab.util.DStabOutFunc;

public class Type1_pastGov extends AbstractGovernor {
	// state variables
	private double pm0 = 0.0, x1 = 0.0;
	private LimitType limit = null;
	
	// UI Editor panel
	private static final NBType1_pastGovEditPanel _editPanel = new NBType1_pastGovEditPanel();

	/**
	 * Default Constructor
	 *
	 */
	public Type1_pastGov() {
		this("govId", "SimpleGovernor");
	}
	
	/**
	 * Constructor
	 * 
	 * @param id governor id
	 * @param name governor name
	 */	
	public Type1_pastGov(final String id, final String name) {
		super(id, name);
		// _data is defined in the parent class. However init it here is a MUST
		_data = new Type1_pastGovData();
	}
	
	/**
	 * Get the governor data 
	 * 
	 * @return the data object
	 */
	public Type1_pastGovData getData() {
		return (Type1_pastGovData)_data;
	}
	
	/**
	 * Set controller parameters
	 * 
	 * @param xmlString controller parameter xml string
	 */
	@Override
	public void setDataXmlString(final String xmlString) {
		super.setDataXmlString(xmlString);
		_data = XmlUtil.toObject(xmlString, Type1_pastGovData.class);
	}
	
	/**
	 *  Init the controller states
	 *  
	 *  @param msg the SessionMsg object
	 */
	@Override
	public void initStates(final IPSSMsgHub msg) {
		limit = new LimitType(getData().getPmax(), getData().getPmin());
		pm0 = getMachine().getPm();
		x1 = 0.0;
		IpssLogger.getLogger().fine("Governor Limit:      " + limit);
	}

	private double cal_dX1_dt(final double X1) {
		IpssLogger.getLogger().fine("dW: " + (getMachine().getSpeed()-1.0));
		return ( getData().getK() * (getMachine().getSpeed() - 1.0) - X1 ) / getData().getT1();
	}
	
	/**
	 * Perform one step d-eqn calculation
	 *  
	 * @param dt simulation time interval
	 * @param method d-eqn solution method
	 *  @param msg the SessionMsg object
	 */	
	@Override
	public void nextStep(final double dt, final DynamicSimuMethods method, final double baseFreq, final IPSSMsgHub msg) {
		if (method == DynamicSimuMethods.MODIFIED_EULER_LITERAL) {
			/*
			 *     Step-1 : x(1) = x(0) + dx_dt(1) * dt
			 *     Step-2 : x(2) = x(0) + 0.5 * (dx_dt(2) +- dx_dt(1)) * dt
			 */
			final double dX1_dt = cal_dX1_dt(x1);
			IpssLogger.getLogger().fine("SimpleGovernor dX1_dt: " + dX1_dt);
			final double X1_1 = x1 + dX1_dt * dt;

			x1 = x1 + 0.5 * (cal_dX1_dt(X1_1) + dX1_dt) * dt;
		}
		else if (method == DynamicSimuMethods.RUNGE_KUTTA_LITERAL) {
			// TODO: TBImpl
		} else {
			throw new InvalidInputException("SimpleGovernor.nextStep(), invalid method");
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
		table.put(DStabOutFunc.OUT_SYMBOL_GOV_PM, new Double(getOutput()));
		return table;
	}
	
	/**
	 * Get the controller output
	 * 
	 * @return the output
	 */	
	@Override
	public double getOutput() {
		IpssLogger.getLogger().fine("Governor _Pm0 - _X1: " + (pm0 - x1));
		return limit.limit(pm0 - x1);
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
	public double getX1() {
		return x1;
	}
} // SimpleExcAdapter
