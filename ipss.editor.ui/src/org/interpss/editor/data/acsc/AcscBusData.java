 /*
  * @(#)AcscBusData.java   
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

package org.interpss.editor.data.acsc;

import org.interpss.editor.data.aclf.AclfAdjBusData;
import org.interpss.editor.data.common.GroundData;

/**
*	AcscBusForm class for storing acsc bus data.
*/

public class AcscBusData extends AclfAdjBusData {
	private static final long serialVersionUID = 1;

	public static String 
			ScCode_Contribute = "Contribute",
			ScCode_NonContribute = "Non-Contribute",
			ScCode_BusScripting = "Scripting";
	
    private String  scCode = "Non-Contribute";        //  Contribute | Non-Contribute
    private double  z0X = 0d;
    private double  z0R = 0d;
    private double  z1X = 0d;
    private double  z1R = 0d;
    private double  z2X = 0d;
    private double  z2R = 0d;
    private String  zUnit = "PU";              // all Z share the same Unit, PU | Percent | Ohm | milliOhm
    private GroundData ground = new GroundData();

    public GroundData getGround() { return this.ground; }
    public void setGround(GroundData n) { this.ground = n; }        

    public String getScCode() { return this.scCode; }
    public void setScCode(String scCode) { this.scCode = scCode;  }

    public double getZ0X() { return this.z0X;}
    public void setZ0X(double z0X) { this.z0X = z0X;}

    public double getZ0R() {  return this.z0R; }
    public void setZ0R(double z0R) { this.z0R = z0R; }

    public double getZ1X() { return this.z1X;}
    public void setZ1X(double z1X) { this.z1X = z1X;}

    public double getZ1R() { return this.z1R; }
    public void setZ1R(double z1R) { this.z1R = z1R; }

    public double getZ2X() { return this.z2X;}
    public void setZ2X(double z2X) { this.z2X = z2X; }

    public double getZ2R() { return this.z2R; }
    public void setZ2R(double z2R) { this.z2R = z2R;}

    public void setZUnit(String zUnit) { this.zUnit = zUnit; }
    public String getZUnit() { return this.zUnit; }
}