package org.interpss.editor.actions;

import java.awt.event.ActionEvent;

import org.interpss.editor.coreframework.IpssAbstractActionDefault;
import org.interpss.gridgain.util.IpssGridGainUtil;

import com.interpss.common.SpringAppContext;
import com.interpss.common.util.IpssLogger;

public class ToolsDebugGridEnv extends IpssAbstractActionDefault {
	private static final long serialVersionUID = 1;
    
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		IpssLogger.getLogger().info("Tools | Degug | Grid Environment");
		
		if (IpssGridGainUtil.isGridEnabled()) {
			SpringAppContext.getEditorDialogUtil().showMsgDialog("Info", "Grid Computing env has been setup properly");
		}
		else {
			IpssLogger.getLogger().info("Grid Computing env has not been set up properly");
			SpringAppContext.getEditorDialogUtil().showWarnMsgDialog("Warnnig", "Cannot start Grid computation environment");
		}
	}
}
