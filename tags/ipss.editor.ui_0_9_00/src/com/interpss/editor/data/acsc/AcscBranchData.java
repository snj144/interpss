package com.interpss.editor.data.acsc;

import com.interpss.editor.data.aclf.AclfAdjBranchData;
import com.interpss.editor.data.common.XfrConnectData;

/**
*	AcscBranchForm class for storing acsc branch data.
*/

public class AcscBranchData  extends AclfAdjBranchData {
    private double  z0R = 0d;            
    private double  z0X = 0d;
    private String  z0Unit = "PU";
    private double  halfShuntB0 = 0d;     
    private String  halfShuntB0Unit = "PU";
    private XfrConnectData  fromXfrConnectData = new XfrConnectData();
    private XfrConnectData  toXfrConnectData = new XfrConnectData();

    public XfrConnectData getFromXfrConnectData() { return this.fromXfrConnectData; }
    public void setFromXfrConnectData(XfrConnectData n) { this.fromXfrConnectData = n; }        

    public XfrConnectData getToXfrConnectData() { return this.toXfrConnectData; }
    public void setToXfrConnectData(XfrConnectData n) { this.toXfrConnectData = n; }        

    public double getZ0R() { return this.z0R;}
    public void setZ0R(double r) { this.z0R = r; }

    public double getZ0X() { return this.z0X;}
    public void setZ0X(double x) { this.z0X = x; }

    public String getZ0Unit() { return this.z0Unit; }
    public void setZ0Unit(String unit) { this.z0Unit = unit; }

    public double getHalfShuntB0() { return this.halfShuntB0; }
    public void setHalfShuntB0(double b) { this.halfShuntB0 = b; }

    public String getHalfShuntB0Unit() { return this.halfShuntB0Unit; }
    public void setHalfShuntB0Unit(String unit) {  this.halfShuntB0Unit = unit; }
}