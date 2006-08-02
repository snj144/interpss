package com.interpss.editor.data.user;

import com.interpss.common.rec.BaseDataBean;

public class UserPrefData extends BaseDataBean {
	private boolean autoSave = true;
	public boolean isAutoSave() { return this.autoSave; }
	public void setAutoSave(boolean b) { this.autoSave = b;}
	
	private int autoSaveInterval = 10;  // in min
	public int getAutoSaveInterval() { return this.autoSaveInterval; }
	public void setAutoSaveInterval(int n) { this.autoSaveInterval = n;}
}