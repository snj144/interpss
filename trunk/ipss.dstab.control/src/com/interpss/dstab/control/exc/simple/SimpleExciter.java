/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * An implementation of the Simple excitor model
 *
 * $Id$
 */
package com.interpss.dstab.control.exc.simple;

import com.interpss.common.datatype.LimitType;
import com.interpss.common.exp.InvalidInputException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.XmlUtil;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.control.exc.AbstractExciter;
import com.interpss.dstab.mach.Machine;
import com.interpss.dstab.util.DStabOutFunc;

public class SimpleExciter extends AbstractExciter {
	// define state vriables
	private double stateVref = 0.0, stateX1 = 0.0;
	private LimitType limit = null; 
	
	// define UI Editor panel for editing the controller data
	private static final NBSimpleExciterEditPanel _editPanel = new NBSimpleExciterEditPanel();
	
	/**
	 * Default Constructor
	 *
	 */
	public SimpleExciter() {
		this("excId", "SimpleExciter"); 
	}
	
	/**
	 * Constructor
	 * 
	 * @param id excitor id
	 * @param name excitor name
	 */
	public SimpleExciter(final String id, final String name) {
		super(id, name);
		// _data is defined in the parent class. However we must be reference to an actual object
		_data = new SimpleExciterData();
	}
	
	/**
	 * Get the excitor data object
	 * 
	 * @return the data object
	 */
	public SimpleExciterData getData() {
		return (SimpleExciterData)_data;
	}
	
	/**
	 * Set controller data from an xml string
	 * 
	 * @param xmlString controller parameter xml string
	 */
	@Override
	public void setDataXmlString(final String xmlString) {
		super.setDataXmlString(xmlString);
		// transfer the xml string to a data object
		_data = XmlUtil.toObject(xmlString, SimpleExciterData.class);
	}
	
	/**
	 *  Init the controller states
	 *  
	 *  @param msg the SessionMsg object
	 */
	@Override
	public boolean initStates(final IPSSMsgHub msg) {
		limit = new LimitType(getData().getVrmax(), getData().getVrmin()); 
		final Machine mach = getMachine();
		stateX1 = mach.getEfd();
		final double vt = mach.getBus().getVoltage().abs() / mach.getVMultiFactor();
		stateVref = (stateX1 + getData().getKa()*vt) / getData().getKa();
		return true;
	}
	
	/**
	 * Perform one step d-eqn calculation
	 *  
	 * @param dt simulation time interval
	 * @param method d-eqn solution method
	 * @param baseFreq base frequency
	 * @param msg the SessionMsg object
	 */
	@Override
	public void nextStep(final double dt, final DynamicSimuMethods method, final double baseFreq, final IPSSMsgHub msg) {
		if (method == DynamicSimuMethods.MODIFIED_EULER_LITERAL) {
			 //     Step-1 : x(1) = x(0) + dx_dt(1) * dt
			final double dX1_dt = cal_dX1_dt(stateX1);
			final double x1 = stateX1 + dX1_dt * dt;
			//System.out.println("dX1_dt, X1: " + dX1_dt + ", " + X1);

			 //     Step-2 : x(2) = x(0) + 0.5 * (dx_dt(2) + dx_dt(1)) * dt
			stateX1 = stateX1 + 0.5 * ( cal_dX1_dt(x1) + dX1_dt ) * dt;
		}
		else if (method == DynamicSimuMethods.RUNGE_KUTTA_LITERAL) {
			// TODO: TBImpl
		} else {
			throw new InvalidInputException("SimpleExciter.nextStep(), invalid method");
		}
	}

	private double cal_dX1_dt(final double x1) {
		final Machine mach = getMachine();
		final double vt = mach.getBus().getVoltage().abs() / mach.getVMultiFactor();
		final double vpss = mach.hasStabilizer()? mach.getStabilizer().getOutput() : 0.0;
		return ( getData().getKa() * ( stateVref + vpss - vt ) - x1) / getData().getTa();
	}
	
	/**
	 * Get the controller state symbol list for display. This list has to be implemented in the
	 * getStates() method
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
		return limit.limit(stateX1);
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
	 * Get the ref voltage Vref, for testing purpose.
	 * 
	 * @return Returns the vref.
	 */
	public double getStateVref() {
		return stateVref;
	}

	/**
	 * Get state variable X1, for testing purpose.
	 * 
	 * @return Returns the x1.
	 */
	public double getStateX1() {
		return stateX1;
	}
} // SimpleExcAdapter

