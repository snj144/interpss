/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * An abstrat class for implementation all controllers. All the methods has to be implemented in order to plug-in the
 * controller into the transient stability simulation program.
 *
 * $Id$
 */
package org.interpss.dstab.control.common; 

import java.util.Hashtable;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.mach.ControllerType;
import com.interpss.dstab.mach.impl.ControllerImpl;

public abstract class AbstractController extends ControllerImpl {
	/**
	 * Constructor
	 * 
	 * @param id controller id
	 * @param name controller name
	 * @param type controller type
	 */	
	public AbstractController(final String id, final String name, final String caty, final ControllerType type) {
		setId(id);
		setName(name);
		setCategory(caty);
		this.setStatus(true);
		setType(type);
	}
	
	/**
	 *  Init the controller states
	 *  
	 *  @param msg the SessionMsg object
	 */
	@Override
	abstract public boolean initStates(IPSSMsgHub msg);
	
	/**
	 * Perform one step d-eqn calculation
	 *  
	 * @param dt simulation time interval
	 * @param method d-eqn solution method
	 *  @param msg the SessionMsg object
	 */
	@Override
	abstract public void nextStep(double dt, DynamicSimuMethods method, double baseFreq, IPSSMsgHub msg);
	/**
	 * Get controller states for display purpose
	 * 
	 * @return hashtable of the states
	 */
	@Override
	abstract public Hashtable getStates(Object ref);
	
	/**
	 * Get the controller output
	 * 
	 * @return the output
	 */
	@Override
	abstract public double getOutput();

	/**
	 * Get the editor panel for controller data editing
	 * 
	 * @return the editor panel object
	 */
	@Override
	abstract public Object getEditPanel();
} 

