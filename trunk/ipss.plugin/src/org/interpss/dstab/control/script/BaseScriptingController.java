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
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.controller.AbstractController;
import com.interpss.dstab.controller.AbstractScriptingController;
import com.interpss.dstab.mach.ControllerType;

public abstract class BaseScriptingController extends AbstractController {
	ScriptEngine engine = null;
	Invocable invoker = null;
	Object controller = null;
	
	// define UI Editor panel for editing the controller data
	private static final NBControllerScriptsEditPanel _editPanel = new NBControllerScriptsEditPanel();

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
	public boolean initController(final String controllerName, final IPSSMsgHub msg) {
		try {
			engine = CoreObjectFactory.createScriptEngine();
			engine.eval(getScripts());
			invoker = (Invocable)engine;
			controller = engine.get(controllerName);
			if (controller == null) {
				msg.sendErrorMsg("The exciter scripting object not found, name");
				return false;
			}
			invoker.invokeMethod(controller, "initStates", getMachine());
		} catch (Exception e) {
			msg.sendErrorMsg(e.toString());
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
	public void nextStep(final double dt, final DynamicSimuMethods method, final double baseFreq, final IPSSMsgHub msg) {
		try {
			invoker.invokeMethod(controller, "nextStep", getMachine(), dt, method, baseFreq);
		} catch (Exception e) {
			msg.sendErrorMsg(e.toString());
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
			IpssLogger.logErr(e);
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
			IpssLogger.logErr(e);
		}
		return table;
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

	public void setRefPoint(double x) {
		try {
			invoker.invokeMethod(controller, "setRefPoint", x);
		} catch (Exception e) {
			IpssLogger.logErr(e);
		}
	}
} 

