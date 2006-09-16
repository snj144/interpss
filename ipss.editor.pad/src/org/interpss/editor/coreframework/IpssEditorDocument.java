package org.interpss.editor.coreframework;

import org.interpss.editor.doc.IpssDocument;

public abstract class IpssEditorDocument extends IpssDocument{

	/**
	 * A reference to the top level component
	 */
	protected GPGraphpad graphpad;
	/**
	 * a reference to the internal Frame
	 */
	protected IpssDocInternalFrame internalFrame;
	
	/**
	 * Returns the graphpad.
	 * 
	 * @return GPGraphpad
	 */
	public GPGraphpad getGraphpad() {
		return graphpad;
	}

	/**
	 * Sets the graphpad.
	 * 
	 * @param graphpad
	 *            The graphpad to set
	 */
	public void setGraphpad(GPGraphpad graphpad) {
		this.graphpad = graphpad;
	}
	/**
	 * Returns the internalFrame.
	 * 
	 * @return GPDocFrame
	 */
	public IpssDocInternalFrame getInternalFrame() {
		return internalFrame;
	}

	/**
	 * Sets the internalFrame.
	 * 
	 * @param internalFrame
	 *            The internalFrame to set
	 */
	protected void setInternalFrame(IpssDocInternalFrame internalFrame) {
		this.internalFrame = internalFrame;
	}

	protected void updateFrameTitle() {
		if (this.internalFrame != null) {
			this.internalFrame.setTitle(getFrameTitle());
		}
	}
	
	public String getFrameTitle() {
		return (isModified() ? "*" : "")+this.getName() ;
	}

	public String getTabTitle() {
		return (this.isModified() ? "*" : "") + this.getFileName();
	}
	
	public abstract boolean close(boolean showConfirmDialog);
}
