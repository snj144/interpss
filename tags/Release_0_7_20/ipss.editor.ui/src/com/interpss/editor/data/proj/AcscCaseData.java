package com.interpss.editor.data.proj;

import com.interpss.common.rec.BaseDataBean;
import com.interpss.editor.data.acsc.AcscFaultData;

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