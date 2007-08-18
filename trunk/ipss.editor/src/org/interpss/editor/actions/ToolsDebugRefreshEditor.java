package org.interpss.editor.actions;

import java.awt.event.ActionEvent;

import org.interpss.editor.GEditor;
import org.interpss.editor.coreframework.IpssAbstractActionDefault;
import org.interpss.editor.resources.BasicProperLoader;

import com.interpss.common.util.IpssLogger;

public class ToolsDebugRefreshEditor extends IpssAbstractActionDefault {
	private static final long serialVersionUID = 1;
    
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		IpssLogger.getLogger().info("Tools | Degug | Refresh Edtitor");

		GEditor.getGraphPad().getSmartFrame().setVisible(false);
		GEditor.getGraphPad().getSmartFrame().dispose();

		if (BasicProperLoader.getUserPty(GEditor.Pty_CurrentWorkspace).equals(GEditor.Pty_UserWorkspace))
			BasicProperLoader.setUserPty(GEditor.Pty_CurrentWorkspace, GEditor.Pty_SampleWorkspace);
		else
			BasicProperLoader.setUserPty(GEditor.Pty_CurrentWorkspace, GEditor.Pty_UserWorkspace);
		GEditor.main(new String[] {});
	}
}
