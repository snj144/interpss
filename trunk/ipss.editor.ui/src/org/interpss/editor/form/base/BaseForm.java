package org.interpss.editor.form.base;

import com.interpss.common.util.XmlUtil;
import com.interpss.editor.jgraph.ui.form.IGNetForm;

/**
*	BaseForm JavaBean for storing bus/branch common data.
*/

public class BaseForm {
    protected String id = "";    // stored bus number or branchid fBusNo->tBusNo
    private String name = "";
    private boolean status = true;   
    private int area = 0;
    private int zone = 0;
	private String  appType = IGNetForm.AppType_Distribution;  			// Transmision | Distribution 

    public BaseForm() { this(""); }	
    public BaseForm(String id) { setId(id); }	    
    
    public String getId() { return this.id;}
    public void setId(String id) { this.id = id;}        

    public String getName() { return this.name; }
    public void setName(String n) { this.name = n; }        

    public boolean getStatus() { return this.status; }
    public void setStatus(boolean value) { this.status = value; }

    public int getArea() { return this.area; }
    public void setArea(int value) { this.area = value; }

    public int getZone() { return this.zone;}
    public void setZone(int value) { this.zone = value; }

    public String getAppType() { return this.appType; }
	public void setAppType(String str) { this.appType = str; }
	
    public Object clone() {
		String xml = XmlUtil.toXmlString(this);
		return XmlUtil.toObject(xml);
    }
    
    public String getNameIdStr() {
    	return 	getName() + "(" + getId() + ")";
    }
}