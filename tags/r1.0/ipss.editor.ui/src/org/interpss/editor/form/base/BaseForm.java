 /*
  * @(#)BaseForm.java   
  *
  * Copyright (C) 2006 www.interpss.org
  *
  * This program is free software; you can redistribute it and/or
  * modify it under the terms of the GNU LESSER GENERAL PUBLIC LICENSE
  * as published by the Free Software Foundation; either version 2.1
  * of the License, or (at your option) any later version.
  *
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  *
  * @Author Mike Zhou
  * @Version 1.0
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.editor.form.base;

import org.interpss.editor.jgraph.ui.form.IGNetForm;

import com.interpss.common.util.XmlUtil;

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