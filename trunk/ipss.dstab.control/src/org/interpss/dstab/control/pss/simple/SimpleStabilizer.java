/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * An implementation of the Simple stabilizer model
 *
 * $Id$
 */

package org.interpss.dstab.control.pss.simple;

import com.interpss.common.datatype.LimitType;
import com.interpss.common.exp.InvalidInputException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.XmlUtil;
import com.interpss.dstab.DynamicSimuMethods;
import org.interpss.dstab.control.pss.AbstractStabilizer;
import com.interpss.dstab.util.DStabOutFunc;

public class SimpleStabilizer extends AbstractStabilizer {
	// state variables
	private double 	stateX1 = 0.0, stateX2 = 0.0;
	private LimitType limit = null;

	// UI Editor panel
	private static final NBSimpleStabilizerEditPanel _editPanel = new NBSimpleStabilizerEditPanel();
	
	public SimpleStabilizer() {
		this("pssId", "SimpleStabilizer", "InterPSS");
	}
	
	/**
	 * Constructor
	 * 
	 * @param id pss id
	 * @param name pss name
	 */	
	public SimpleStabilizer(final String id, final String name, final String caty) {
		super(id, name, caty);
		// _data is defined in the parent class. However init it here is a MUST
		_data = new SimpleStabilizerData();
	}
	
	/**
	 * Get the PSS data 
	 * 
	 * @return the data object
	 */
	public SimpleStabilizerData getData() {
		return (SimpleStabilizerData)_data;
	}
	
	/**
	 * Set controller parameters
	 * 
	 * @param xmlString controller parameter xml string
	 */
	@Override
	public void setDataXmlString(final String xmlString) {
		super.setDataXmlString(xmlString);
		_data = XmlUtil.toObject(xmlString, SimpleStabilizerData.class);
	}
	
	/**
	 *  Init the controller states
	 *  
	 *  @param msg the SessionMsg object
	 */
	@Override
	public boolean initStates(final IPSSMsgHub msg) {
		limit = new LimitType(getData().getVsmax(), getData().getVsmin());
		stateX1 = 0.0;
		stateX2 = 0.0;
		return true;
	}

	private double cal_dX1_dt(final double x1) {
		final double a = ( 1.0 - getData().getT1()/getData().getT2() );
		final double dw = getMachine().getSpeed() - 1.0;
		final double x = getData().getKs() * a * dw - x1;
		return x / getData().getT2();
	}

	private double cal_dX2_dt(final double x1, final double x2) {
		final double a = ( 1.0 - getData().getT3()/getData().getT4() );
		final double dw = getMachine().getSpeed() - 1.0;
		final double x = a * ( getData().getKs() * dw * getData().getT1() / getData().getT2() + x1 ) - x2;
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
			final double _dX1_dt = cal_dX1_dt(stateX1);
			final double _dX2_dt = cal_dX2_dt(stateX1, stateX2);
			final double x1_1 = stateX1 + _dX1_dt * dt;
			final double x2_1 = stateX2 + _dX2_dt * dt;

			// Step-2 : x(2) = x(1) + (dx_dt(2) - dx_dt(1)) * dt
			stateX1 = stateX1 + 0.5 * (cal_dX1_dt(x1_1) + _dX1_dt) * dt;
			stateX2 = stateX2 + 0.5 * (cal_dX2_dt(x1_1, x2_1) + _dX2_dt) * dt;
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
		return limit.limit(getData().getKs()*dw*a*getData().getT1()/getData().getT2() + a*stateX1 + stateX2);
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
	 * @return Returns the x1.
	 */
	public double getStateX1() {
		return stateX1;
	}

	/**
	 * @return Returns the x2.
	 */
	public double getStateX2() {
		return stateX2;
	}
} // SimpleExcAdapter
