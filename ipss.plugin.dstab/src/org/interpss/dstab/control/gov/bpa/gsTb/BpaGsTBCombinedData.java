package org.interpss.dstab.control.gov.bpa.gsTb;

import org.interpss.dstab.control.gov.bpa.combinedType.BpaTBTurbineData;

public class BpaGsTBCombinedData {
	
	private BpaTBTurbineData tbData=null;
	private BpaGsSpeedGovData gsData=null;
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
