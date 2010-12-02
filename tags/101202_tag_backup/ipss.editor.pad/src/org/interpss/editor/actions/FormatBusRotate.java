package org.interpss.editor.actions;

import java.awt.event.ActionEvent;

import org.interpss.editor.coreframework.IpssAbstractGraphAction;


public class FormatBusRotate extends IpssAbstractGraphAction{
	
	public void actionPerformed(ActionEvent e) {
		if (getCurrentGraph().getSelectionCount() > 0) {
			rotateBusForSelection();
		}

	}

}
