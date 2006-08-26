package com.interpss.editor.actions;

import java.awt.event.ActionEvent;

import org.interpss.editor.ui.SimuActionAdapter;

import com.interpss.editor.coreframework.IpssAbstractActionDefault;

public class ToolsDebugRefData extends IpssAbstractActionDefault {
    
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		SimuActionAdapter.menu_tools_debug_refData();
	}

	public void update() {
		
	}
	
}
