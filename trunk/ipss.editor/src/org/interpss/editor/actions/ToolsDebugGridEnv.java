package org.interpss.editor.actions;

import java.awt.event.ActionEvent;

import org.interpss.core.grid.gridgain.IpssGridGainUtil;
import org.interpss.editor.coreframework.IpssAbstractActionDefault;

import com.interpss.common.SpringAppContext;
import com.interpss.common.util.IpssLogger;

public class ToolsDebugGridEnv extends IpssAbstractActionDefault {
	private static final long serialVersionUID = 1;
    
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		IpssLogger.getLogger().info("Tools | Degug | Grid Environment");
		
		try {
			if (IpssGridGainUtil.isGridLibLoaded()) {
				IpssLogger.getLogger().info("Grid Computing env has been setup properly");
				IpssLogger.getLogger().info("Number of grid nodes: " + IpssGridGainUtil.gridNodeNameList().length);
				SpringAppContext.getEditorDialogUtil().showMsgDialog("Info", "Grid Computing env has been setup properly");
			}
			else {
				IpssLogger.getLogger().info("Grid Computing env has not been set up properly");
				SpringAppContext.getEditorDialogUtil().showWarnMsgDialog("Warnnig", "Cannot start Grid computation environment");
			}
        } catch (NoClassDefFoundError ex) {
        	IpssLogger.getLogger().severe(ex.toString());
			SpringAppContext.getEditorDialogUtil().showWarnMsgDialog("Warnnig", "Grid Computing env has not been set up properly, Please include GridGain library");
		}
	}
}
