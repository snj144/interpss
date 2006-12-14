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

import com.interpss.dstab.mach.ControllerType;

public class ScriptingGovernor extends BaseScriptingController {
	// define UI Editor panel for editing the controller data
	private static final NBControllerScriptsEditPanel _editPanel = new NBControllerScriptsEditPanel();

	/**
	 * Constructor 
	 */
	public ScriptingGovernor() {
		super("govId", "govName", "govCaty", ControllerType.GOVERNOR_LITERAL);
	}
	
	/**
	 * Constructor
	 * 
	 * @param id governor id
	 * @param name governor name
	 */
	public ScriptingGovernor(final String id, final String name, final String caty) {
		super(id, name, caty, ControllerType.GOVERNOR_LITERAL);
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
} 

