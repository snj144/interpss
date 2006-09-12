package org.interpss.editor.coreframework;



public abstract class IpssAbstractProjectAction extends IpssAbstractActionDefault {

	public void update() {
		if (graphpad.getCurrentProject() == null)
			setEnabled(false);
		else
			setEnabled(true);
	}
}

