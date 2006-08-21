/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * An implementation of the Simple governor model
 *
 * $Id$
 */

package com.interpss.dstab.control.gov.ieee.ieeeST1;

import com.interpss.common.datatype.LimitType;
import com.interpss.common.exp.InvalidInputException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.XmlUtil;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.control.gov.AbstractGovernor;

public class IeeeST1Governor extends AbstractGovernor {
	// state variables
	private double statePm = 0.0, statePref = 0.0, stateX1 = 0.0, stateX2 = 0.0, statteX3 = 0.0, stateX4 = 0.0;
	private LimitType limit = null;
	
	// UI Editor panel
	private static final NBIeeeST1GovernorEditPanel _editPanel = new NBIeeeST1GovernorEditPanel();

	/**
	 * Default Constructor
	 *
	 */
	public IeeeST1Governor() {
		this("govId", "IeeeST1Governor");
	}
	
	/**
	 * Constructor
	 * 
	 * @param id governor id
	 * @param name governor name
	 */	
	public IeeeST1Governor(final String id, final String name) {
		super(id, name);
		// _data is defined in the parent class. However init it here is a MUST
		_data = new IeeeST1GovernorData();
	}
	
	/**
	 * Get the governor data 
	 * 
	 * @return the data object
	 */
	public IeeeST1GovernorData getData() {
		return (IeeeST1GovernorData)_data;
	}
	
	/**
	 * Set controller parameters
	 * 
	 * @param xmlString controller parameter xml string
	 */
	@Override
	public void setDataXmlString(final String xmlString) {
		super.setDataXmlString(xmlString);
		_data = XmlUtil.toObject(xmlString, IeeeST1GovernorData.class);
	}
	
	/**
	 *  Init the controller states
	 *  
	 *  @param msg the SessionMsg object
	 */
	@Override
	public void initStates(final IPSSMsgHub msg) {
		limit = new LimitType(getData().getPmax(), getData().getPmin());
		statePref = getMachine().getPm();
        if (limit.isViolated(statePref)) {
        	msg.sendErrorMsg("Machine initial mechanical power Pm0 violates its governor power limits, " +
        			"machine id: " + getMachine().getId());
        }
		stateX1 = 0.0;
		stateX2 = statePref;
		statteX3 = stateX2;
		stateX4 = (1.0 - getData().getFp()) * statteX3;
		IpssLogger.getLogger().fine("Governor Limit:      " + limit);
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
			 *     Step-2 : x(2) = x(0) + 0.5 * (dx_dt(2) + dx_dt(1)) * dt
			 */
			final double dX1_dt = cal_dX1_dt(stateX1);
			final double dX2_dt = cal_dX2_dt(stateX1, stateX2);
			final double dX3_dt = cal_dX3_dt(stateX2, statteX3);
			final double dX4_dt = cal_dX4_dt(statteX3, stateX4);
			
			final double X1_1 = stateX1 + dX1_dt * dt;
			final double X2_1 = limit.limit(stateX2 + dX2_dt * dt);
			final double X3_1 = statteX3 + dX3_dt * dt;
			final double X4_1 = stateX4 + dX4_dt * dt;
			stateX1 = stateX1 + 0.5 * (cal_dX1_dt(X1_1) + dX1_dt) * dt;
			stateX2 = limit.limit(stateX2 + 0.5 * (cal_dX2_dt(X1_1,X2_1) + dX2_dt) * dt);
			statteX3 = statteX3 + 0.5 * (cal_dX3_dt(X2_1,X3_1) + dX3_dt) * dt;
			stateX4 = stateX4 + 0.5 * (cal_dX4_dt(X3_1,X4_1) + dX4_dt) * dt;
		}
		else if (method == DynamicSimuMethods.RUNGE_KUTTA_LITERAL) {
			// TODO: TBImpl
		} else {
			throw new InvalidInputException("SimpleGovernor.nextStep(), invalid method");
		}
	}	
	
	private double cal_dX1_dt(final double X1) {
		return ( 100.0*(getMachine().getSpeed() - 1.0)/getData().getR()  - X1 ) / getData().getT1();
	}
	
	private double cal_dX2_dt(final double X1, final double X2) {
		double p = getData().getOptMode() == AbstractGovernor.DroopMode? statePref : statePm;
		return ( p - X1 - X2 ) / getData().getT2();
	}

	private double cal_dX3_dt(final double X2, final double X3) {
		return ( X2 - X3 ) / getData().getT3();
	}

	private double cal_dX4_dt(final double X3, final double X4) {
		return ( X3 * ( 1.0 - getData().getFp()) - X4 ) / getData().getT4();
	}

	/**
	 * Get the controller output
	 * 
	 * @return the output
	 */	
	@Override
	public double getOutput() {
		return statteX3 * getData().getFp() - stateX4;
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
} // SimpleExcAdapter
