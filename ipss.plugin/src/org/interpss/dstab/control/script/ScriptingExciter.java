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
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.controller.AbstractController;
import com.interpss.dstab.mach.ControllerType;

public class ScriptingExciter extends AbstractController {
	public String ExciterScriptingObject = "exciter";
	
	ScriptEngine engine = null;
	Invocable invoker = null;
	Object exciter = null;
	
	// define UI Editor panel for editing the controller data
	private static final NBControllerScriptsEditPanel _editPanel = new NBControllerScriptsEditPanel();

	
	public ScriptingExciter() {
		this("excId", "ScriptingExciter", "InterPSS", null); 
	}
	
	/**
	 * Constructor
	 * 
	 * @param id excitor id
	 * @param name excitor name
	 */
	public ScriptingExciter(final String id, final String name, final String caty, ScriptEngine engine) {
		super(id, name, caty, ControllerType.EXCITER_LITERAL);
		this.engine = engine;
	}
	
	/**
	 * Set controller data from an xml string
	 * 
	 * @param xmlString controller parameter xml string
	 */
	@Override
	public void setDataXmlString(final String xmlString) {
	}
	
	/**
	 *  Init the controller states
	 *  
	 *  @param msg the SessionMsg object
	 */
	@Override
	public boolean initStates(final IPSSMsgHub msg) {
		try {
			engine.eval(getScripts());
			invoker = (Invocable)engine;
			exciter = engine.get(ExciterScriptingObject);
			if (exciter == null) {
				msg.sendErrorMsg("The exciter scripting object not found, name");
				return false;
			}
			invoker.invokeMethod(exciter, "initStates", getMachine());
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
			invoker.invokeMethod(exciter, "nextStep", getMachine(), dt, method, baseFreq);
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
			return ((Double)invoker.invokeMethod(exciter, "getOutput", getMachine())).doubleValue();
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
			invoker.invokeMethod(exciter, "getStates", getMachine(), table);
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
			invoker.invokeMethod(exciter, "setRefPoint", x);
		} catch (Exception e) {
			IpssLogger.logErr(e);
		}
	}
} 

