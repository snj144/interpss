package com.interpss.editor.ui;

import com.interpss.common.msg.IpssMsgListener;

public interface IOutputTextDialog extends IpssMsgListener {
    
	void setTitle(String title);
	
    void display(Object data);
	
	void appendText(String text);
    
}
