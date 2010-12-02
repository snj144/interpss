package org.interpss.editor.coreframework;

public class IpssTextFile {
	private String filePathName;
	protected boolean modified = false;
	
	public IpssTextFile(String filePathName) {
		setFilePathName(filePathName);
		setModified(false);
	}

	public void setFilePathName(String filePathName) {
		this.filePathName = filePathName;
	}

	public String getFilePathName() {
		return filePathName;
	}

	/**
	 * @return the dirty
	 */
	public boolean isModified() {
		return modified;
	}

	/**
	 * @param dirty the dirty to set
	 */
	public void setModified(boolean dirty) {
		this.modified = dirty;
	}
	
}
