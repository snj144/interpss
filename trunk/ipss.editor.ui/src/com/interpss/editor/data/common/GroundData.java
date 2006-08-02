package com.interpss.editor.data.common;

import com.interpss.common.datatype.ScGroundType;
import com.interpss.common.rec.BaseDataBean;

/**
*	GroundForm JavaBean for storing grounding data.
*/

public class GroundData  extends BaseDataBean {
    private String code = ScGroundType.GType_Ungrounded; 
    private double r = 0d;
    private double x = 0d;
    private String unit = "Ohm";

    public String getCode() { return this.code; }
    public void setCode(String n) { this.code = n; }        

    public double getR() { return this.r; }
    public void setR(double r) {this.r = r;}

    public double getX() { return this.x; }
    public void setX(double x) {this.x = x;}

    public String getUnit() { return this.unit; }
    public void setUnit(String n) { this.unit = n; }        
}