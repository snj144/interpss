package com.interpss.editor.actions;

import java.awt.event.ActionEvent;

import com.interpss.editor.coreframework.IpssAbstractGraphAction;

public class FileProjectOpenItem extends IpssAbstractGraphAction {
	
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		graphpad.OpenCurrentProjectItem();
		graphpad.update();
	}

	public void update() {
		if (graphpad.getCurrentProjectItem() == null)
			setEnabled(false);
		else
			setEnabled(true);
	}
}
