/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * An implementation of the Simple stabilizer model
 *
 * $Id$
 */

package com.interpss.dstab.control.pss.psat.psatType1;

import java.util.Hashtable;

import com.interpss.common.datatype.LimitType;
import com.interpss.common.exp.InvalidInputException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.XmlUtil;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.control.pss.AbstractStabilizer;
import com.interpss.dstab.util.DStabOutFunc;

public class Type1_psatPss extends AbstractStabilizer {
	// state variables
	private double 	x1 = 0.0, x2 = 0.0;
	private LimitType limit = null;

	// UI Editor panel
	private static final NBType1_psatPssEditPanel _editPanel = new NBType1_psatPssEditPanel();
	
	public Type1_psatPss() {
		this("pssId", "SimpleStabilizer");
	}
	
	/**
	 * Constructor
	 * 
	 * @param id pss id
	 * @param name pss name
	 */	
	public Type1_psatPss(final String id, final String name) {
		super(id, name);
		// _data is defined in the parent class. However init it here is a MUST
		_data = new Type1_psatPssData();
	}
	
	/**
	 * Get the PSS data 
	 * 
	 * @return the data object
	 */
	public Type1_psatPssData getData() {
		return (Type1_psatPssData)_data;
	}
	
	/**
	 * Set controller parameters
	 * 
	 * @param xmlString controller parameter xml string
	 */
	@Override
	public void setDataXmlString(final String xmlString) {
		super.setDataXmlString(xmlString);
		_data = XmlUtil.toObject(xmlString, Type1_psatPssData.class);
	}
	
	/**
	 *  Init the controller states
	 *  
	 *  @param msg the SessionMsg object
	 */
	@Override
	public void initStates(final IPSSMsgHub msg) {
		limit = new LimitType(getData().getVsmax(), getData().getVsmin());
		x1 = 0.0;
		x2 = 0.0;
	}

	private double cal_dX1_dt(final double X1) {
		final double a = ( 1.0 - getData().getT1()/getData().getT2() );
		final double dw = getMachine().getSpeed() - 1.0;
		final double x = getData().getKs() * a * dw - X1;
		return x / getData().getT2();
	}

	private double cal_dX2_dt(final double X1, final double X2) {
		final double a = ( 1.0 - getData().getT3()/getData().getT4() );
		final double dw = getMachine().getSpeed() - 1.0;
		final double x = a * ( getData().getKs() * dw * getData().getT1() / getData().getT2() + X1 ) - X2;
		return x / getData().getT4();
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
			// Step-1 : x(1) = x(0) + dx_dt(1) * dt
			final double _dX1_dt = cal_dX1_dt(x1);
			final double _dX2_dt = cal_dX2_dt(x1, x2);
			final double X1_1 = x1 + _dX1_dt * dt;
			final double X2_1 = x2 + _dX2_dt * dt;

			// Step-2 : x(2) = x(1) + (dx_dt(2) - dx_dt(1)) * dt
			x1 = x1 + 0.5 * (cal_dX1_dt(X1_1) + _dX1_dt) * dt;
			x2 = x2 + 0.5 * (cal_dX2_dt(X1_1, X2_1) + _dX2_dt) * dt;
		}
		else if (method == DynamicSimuMethods.RUNGE_KUTTA_LITERAL) {
			// TODO: TBImpl
		} else {
			throw new InvalidInputException("SimplePSS.nextStep(), invalid method");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String[] getStateSymbolList() {
		final String[] list = {DStabOutFunc.OUT_SYMBOL_PSS_VS};
		return list;
	}
	
	/**
	 * Get the controller output
	 * 
	 * @return the output
	 */	
	@Override
	public double getOutput() {
		final double a = getData().getT3()/getData().getT4();
		final double dw = getMachine().getSpeed() - 1.0;
		return limit.limit(getData().getKs()*dw*a*getData().getT1()/getData().getT2() + a*x1 + x2);
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
