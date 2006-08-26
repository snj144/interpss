package org.interpss.editor.data.common;

import com.interpss.common.rec.BaseDataBean;

/**
*	ScPointForm class for defining SC Point in the Network editor.
*/

public class ScPointData extends BaseDataBean {
    private String  name = "";
	private boolean enable = true;
	private String  description = "";

    public ScPointData() {}
    
    public ScPointData(String name, boolean enable, String desc) {
    	this.name = name;
    	this.enable = enable;
    	this.description = desc;
    }	

    public void setName(String s) { this.name = s; }
    public String getName() { return this.name; }

    public void setEnable(boolean s) { this.enable = s; }
    public boolean getEnable() { return this.enable; }
    
    public void setDescription(String s) { this.description = s; }
    public String getDescription() { return this.description; }
}