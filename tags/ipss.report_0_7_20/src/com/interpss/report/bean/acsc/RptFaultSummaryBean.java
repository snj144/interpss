package com.interpss.report.bean.acsc;

import com.interpss.report.bean.RptBaseBean;

public class RptFaultSummaryBean extends RptBaseBean {
	private int    type = 1;    // 1: busFault, 2: branchFault
	private String busId = null;
	private String busName = null;
	private String faultType = null;
	private String faultAmpspu = null;
	private String faultAmps = null;
	private String faultDistance = null;
	
	/**
	 * @return the busId
	 */
	public String getBusId() {
		return busId;
	}

	/**
	 * @param busId the busId to set
	 */
	public void setBusId(String busId) {
		this.busId = busId;
	}

	/**
	 * @return the busName
	 */
	public String getBusName() {
		return busName;
	}

	/**
	 * @param busName the busName to set
	 */
	public void setBusName(String busName) {
		this.busName = busName;
	}

	/**
	 * @return the faultAmps
	 */
	public String getFaultAmps() {
		return faultAmps;
	}

	/**
	 * @param faultAmps the faultAmps to set
	 */
	public void setFaultAmps(String faultAmps) {
		this.faultAmps = faultAmps;
	}

	/**
	 * @return the faultAmpspu
	 */
	public String getFaultAmpspu() {
		return faultAmpspu;
	}

	/**
	 * @param faultAmpspu the faultAmpspu to set
	 */
	public void setFaultAmpspu(String faultAmpspu) {
		this.faultAmpspu = faultAmpspu;
	}

	/**
	 * @return the faultType
	 */
	public String getFaultType() {
		return faultType;
	}

	/**
	 * @param faultType the faultType to set
	 */
	public void setFaultType(String faultType) {
		this.faultType = faultType;
	}

	public RptFaultSummaryBean() {
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the faultDistance
	 */
	public String getFaultDistance() {
		return faultDistance;
	}

	/**
	 * @param faultDistance the faultDistance to set
	 */
	public void setFaultDistance(String faultDistance) {
		this.faultDistance = faultDistance;
	}
}