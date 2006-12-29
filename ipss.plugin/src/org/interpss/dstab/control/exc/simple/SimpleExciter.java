/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * An implementation of the Simple excitor model
 *
 * $Id$
 */
package org.interpss.dstab.control.exc.simple;

import com.interpss.common.exp.InvalidInputException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.XmlUtil;
import com.interpss.core.net.Network;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.controller.AbstractExciter;
import com.interpss.dstab.controller.block.DelayControlBlock;
import com.interpss.dstab.controller.block.IControlBlock;
import com.interpss.dstab.mach.Machine;

public class SimpleExciter extends AbstractExciter {
	// define UI Editor panel for editing the controller data
	private static final NBSimpleExciterEditPanel _editPanel = new NBSimpleExciterEditPanel();
	
	// define state vriables
	private double stateVref = 0.0;
	private DelayControlBlock controlBlock = null;
	
	/**
	 * Default Constructor
	 *
	 */
	public SimpleExciter() {
		this("excId", "SimpleExciter", "InterPSS"); 
	}
	
	/**
	 * Constructor
	 * 
	 * @param id excitor id
	 * @param name excitor name
	 */
	public SimpleExciter(final String id, final String name, final String caty) {
		super(id, name, caty);
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
	public boolean initStates(DStabBus abus, final IPSSMsgHub msg) {
		final Machine mach = getMachine();
		controlBlock = new DelayControlBlock(IControlBlock.Type_Limit,
				getData().getKa(), getData().getTa(), getData().getVrmax(), getData().getVrmin()); 
		controlBlock.initState(mach.getEfd());
		
		final double vt = mach.getMachineBus().getVoltage().abs() / mach.getVMultiFactor();
		stateVref = vt + controlBlock.getU0();
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
	public boolean nextStep(final double dt, final DynamicSimuMethods method, final Network net, final IPSSMsgHub msg) {
		if (method == DynamicSimuMethods.MODIFIED_EULER_LITERAL) {
			final double u = calculateU();

			controlBlock.eulerStep1(u, dt);
			controlBlock.eulerStep2(u, dt);
			return true;
		}
		else if (method == DynamicSimuMethods.RUNGE_KUTTA_LITERAL) {
			// TODO: TBImpl
			return false;
		} else {
			throw new InvalidInputException("SimpleExciter.nextStep(), invalid method");
		}
	}
	
	private double calculateU() {
		final Machine mach = getMachine();
		final double vt = mach.getMachineBus().getVoltage().abs() / mach.getVMultiFactor();
		final double vpss = mach.hasStabilizer()? mach.getStabilizer().getOutput() : 0.0;
		return stateVref + vpss - vt;		
	}
	
	/**
	 * Get the controller output
	 * 
	 * @return the output
	 */
	@Override
	public double getOutput() {
		return controlBlock.getY(calculateU());
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
	 * Get state variable X1, for testing purpose.
	 * 
	 * @return Returns the x1.
	 */
	public double getStateX1() {
		return controlBlock.getStateX();
	}
	
	public void setRefPoint(double x) {
		stateVref = x;
	}
} // SimpleExcAdapter

