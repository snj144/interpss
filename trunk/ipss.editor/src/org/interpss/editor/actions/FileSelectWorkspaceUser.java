package org.interpss.editor.actions;

import java.awt.event.ActionEvent;

import org.interpss.editor.GEditor;
import org.interpss.editor.coreframework.IpssAbstractActionDefault;
import org.interpss.editor.resources.BasicProperLoader;

import com.interpss.common.ui.Workspace;

public class FileSelectWorkspaceUser extends IpssAbstractActionDefault {
	private static final long serialVersionUID = 1;

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		GEditor.getGraphPad().getSmartFrame().setVisible(false);
		GEditor.getGraphPad().getSmartFrame().dispose();

		BasicProperLoader.setUserPty(GEditor.Pty_CurrentWorkspace, GEditor.Pty_UserWorkspace);
		GEditor.main(new String[] {});
	}
	
	public void update() {
		setEnabled(Workspace.getCurrentType() == Workspace.Type.Sample);
	}	
}
