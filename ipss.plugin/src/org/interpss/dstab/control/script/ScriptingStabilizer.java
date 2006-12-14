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

public class ScriptingStabilizer extends BaseScriptingController {
	// define UI Editor panel for editing the controller data
	private static final NBControllerScriptsEditPanel _editPanel = new NBControllerScriptsEditPanel();

	/**
	 * Constructor
	 */
	public ScriptingStabilizer() {
		super("pssId", "pssName", "pssCaty", ControllerType.STABILIZER_LITERAL);
	}
	
	/**
	 * Constructor
	 * 
	 * @param id stabilizer id
	 * @param name stabilizer name
	 */
	public ScriptingStabilizer(final String id, final String name, final String caty) {
		super(id, name, caty, ControllerType.STABILIZER_LITERAL);
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

