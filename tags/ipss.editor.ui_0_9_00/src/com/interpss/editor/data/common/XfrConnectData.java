package com.interpss.editor.data.common;

import com.interpss.common.rec.BaseDataBean;


public class XfrConnectData  extends BaseDataBean {
	public static String 
			Code_Wye = "Wye",
			Code_Delta = "Delta";			
	
    private String  code = "Wye";    // Wye | Delta
    private GroundData grounding = new GroundData();

    public XfrConnectData() { }	
    
    public GroundData getGrounding() { return this.grounding; }
    public void setGrounding(GroundData n) { this.grounding = n; }        

    public String getCode() { return this.code;  }
    public void setCode(String code) {  this.code = code;  }
}