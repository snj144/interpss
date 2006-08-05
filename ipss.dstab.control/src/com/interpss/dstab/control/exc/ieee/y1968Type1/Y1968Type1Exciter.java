/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * An implementation of the Simple excitor model
 *
 * $Id$
 */
package com.interpss.dstab.control.exc.ieee.y1968Type1;

import com.interpss.common.datatype.LimitType;
import com.interpss.common.exp.InvalidInputException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.XmlUtil;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.control.exc.AbstractExciter;
import com.interpss.dstab.mach.Machine;
import com.interpss.dstab.util.DStabOutFunc;

public class Y1968Type1Exciter extends AbstractExciter {
	// define state vriables
	private double vref = 0.0, x1 = 0.0;
	private LimitType limit = null; 
	
	// define UI Editor panel for editing the controller data
	private static final NBY1968Type1ExciterEditPanel _editPanel = new NBY1968Type1ExciterEditPanel();
	
	/**
	 * Default Constructor
	 *
	 */
	public Y1968Type1Exciter() {
		this("excId", "SimpleExciter"); 
	}
	
	/**
	 * Constructor
	 * 
	 * @param id excitor id
	 * @param name excitor name
	 */
	public Y1968Type1Exciter(final String id, final String name) {
		super(id, name);
		// _data is defined in the parent class. However we must be reference to an actual object
		_data = new Y1968Type1ExciterData();
	}
	
	/**
	 * Get the excitor data object
	 * 
	 * @return the data object
	 */
	public Y1968Type1ExciterData getData() {
		return (Y1968Type1ExciterData)_data;
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
		_data = XmlUtil.toObject(xmlString, Y1968Type1ExciterData.class);
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
		x1 = mach.getEfd();
		final double vt = mach.getBus().getVoltage().abs() / mach.getVMultiFactor();
		vref = (x1 + getData().getKa()*vt) / getData().getKa();
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
			final double dX1_dt = cal_dX1_dt(x1);
			final double X1 = x1 + dX1_dt * dt;
			//System.out.println("dX1_dt, X1: " + dX1_dt + ", " + X1);

			 //     Step-2 : x(2) = x(0) + 0.5 * (dx_dt(2) + dx_dt(1)) * dt
			x1 = x1 + 0.5 * ( cal_dX1_dt(X1) + dX1_dt ) * dt;
		}
		else if (method == DynamicSimuMethods.RUNGE_KUTTA_LITERAL) {
			// TODO: TBImpl
		} else {
			throw new InvalidInputException("SimpleExciter.nextStep(), invalid method");
		}
	}

	private double cal_dX1_dt(final double X1) {
		final Machine mach = getMachine();
		final double vt = mach.getBus().getVoltage().abs() / mach.getVMultiFactor();
		final double vpss = mach.hasStabilizer()? mach.getStabilizer().getOutput() : 0.0;
		return ( getData().getKa() * ( vref + vpss - vt ) - X1) / getData().getTa();
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
		return limit.limit(x1);
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
	public double getVref() {
		return vref;
	}

	/**
	 * Get state variable X1, for testing purpose.
	 * 
	 * @return Returns the x1.
	 */
	public double getX1() {
		return x1;
	}
} // SimpleExcAdapter

