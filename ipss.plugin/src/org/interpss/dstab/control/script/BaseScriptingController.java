/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * An implementation of the Simple excitor model
 *
 * $Id$
 */
package org.interpss.dstab.control.script;

import java.util.Hashtable;

import javax.script.Invocable;
import javax.script.ScriptEngine;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.net.Network;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.controller.AbstractController;
import com.interpss.dstab.mach.ControllerType;
import com.interpss.simu.SimuObjectFactory;
import com.interpss.simu.script.ScriptingUtil;

public abstract class BaseScriptingController extends AbstractController {
	Invocable invoker = null;
	Object controller = null;
	IPSSMsgHub message = null;
	
	public BaseScriptingController() {
		this("controllerId", "ScriptingController", "InterPSS", null); 
	}
	
	public BaseScriptingController(final String id, final String name, final String caty, final ControllerType type) {
		super(id, name, caty, type);
	}	

	/**
	 *  Init the controller states
	 *  
	 *  @param msg the SessionMsg object
	 */
	@Override
	public boolean initStates(final IPSSMsgHub msg) {
		try {
			this.message = msg;
			ScriptEngine engine = SimuObjectFactory.createScriptEngine();
			engine.eval(getScripts());
			controller = ScriptingUtil.getScritingObject(engine, msg);
			invoker = (Invocable)engine;
			invoker.invokeMethod(controller, "initStates", getMachine());
		} catch (Exception e) {
			msg.sendErrorMsg("ScriptingController.initStates(), " + e.toString());
			return false;
		}
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
		try {
			invoker.invokeMethod(controller, "nextStep", getMachine(), dt, method, net);
			return true;
		} catch (Exception e) {
			msg.sendErrorMsg("ScriptingController.nextStep(), " + e.toString());
			return false;
		}
	}
	
	/**
	 * Get the controller output
	 * 
	 * @return the output
	 */
	@Override
	public double getOutput() {
		try {
			return ((Double)invoker.invokeMethod(controller, "getOutput", getMachine())).doubleValue();
		} catch (Exception e) {
			message.sendErrorMsg("ScriptingController.getOutput(), " + e.toString());
		}
		return 0.0;
	}

	/**
	 * Get controller states for display purpose
	 * 
	 * @param ref, a reference object for output. May not be used
	 * @return hashtable of the states
	 */
	@Override
	public Hashtable getStates(Object ref) {
		final Hashtable<String,Double> table = new Hashtable<String,Double>();
		try {
			invoker.invokeMethod(controller, "getStates", getMachine(), table);
		} catch (Exception e) {
			message.sendErrorMsg("ScriptingController.getStates(), "  + e.toString());
		}
		return table;
	}

	public void setRefPoint(double x) {
		try {
			invoker.invokeMethod(controller, "setRefPoint", x);
		} catch (Exception e) {
			message.sendErrorMsg("ScriptingController.setRefPoint(), "  + e.toString());
		}
	}
} 

