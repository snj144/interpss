 /*
  * @(#)AcscCaseData.java   
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

package org.interpss.editor.data.proj;

import org.interpss.editor.data.acsc.AcscFaultData;

import com.interpss.common.rec.BaseDataBean;

public class AcscCaseData extends BaseDataBean {
	public static final String ScBusVolt_UnitVolt = "UnitV";
	public static final String ScBusVolt_LFVolt = "LFVolt";
	
  	protected AcscFaultData faultData = null;
  	public AcscFaultData getFaultData() {
  		if (this.faultData == null)
  			this.faultData = new AcscFaultData();
  		return this.faultData; 
  	}
  	public void setFaultData(AcscFaultData data) { this.faultData = data; }

  	protected String busInitVolt = ScBusVolt_UnitVolt;    // UnitV | LFVolt
  	public String getBusInitVolt() { return this.busInitVolt; }
  	public void setBusInitVolt(String busInitVolt) { this.busInitVolt = busInitVolt; }

	protected double mFactor = 100.0;   // in %
	public double getMFactor() { return this.mFactor; }
	public void setMFactor(double m) { this.mFactor = m; }
}