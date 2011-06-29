package org.interpss.dstab.control.gov.bpa.gsTb;

import org.interpss.dstab.control.gov.turbine.BpaTBTurbineData;

public class BpaGsTbCombineGovernordata {
	
	private BpaTBTurbineData tbData=new BpaTBTurbineData() ;
	private BpaGsSpeedGovData gsData=new BpaGsSpeedGovData();
	/**
	 * @return the tbData
	 */
	public BpaTBTurbineData getTbData() {
		return tbData;
	}
	/**
	 * @return the gsData
	 */
	public BpaGsSpeedGovData getGsData() {
		return gsData;
	}
	/**
	 * @param tbData the tbData to set
	 */
	public void setTbData(BpaTBTurbineData tbData) {
		this.tbData = tbData;
	}
	/**
	 * @param gsData the gsData to set
	 */
	public void setGsData(BpaGsSpeedGovData gsData) {
		this.gsData = gsData;
	}

}
