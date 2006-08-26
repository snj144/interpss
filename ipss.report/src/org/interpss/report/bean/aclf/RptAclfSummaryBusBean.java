package org.interpss.report.bean.aclf;

import org.interpss.report.bean.RptBaseBean;

public class RptAclfSummaryBusBean extends RptBaseBean {

	private String busId = null;
	private String busCode = null;
	private String busVolt = null;
	private String busAngle = null;
	private String busP = null;
	private String busQ = null;
	
	public RptAclfSummaryBusBean() {
	}

	public String getBusId() {
		return busId;
	}

	public String getBusCode() {
		return busCode;
	}

	public String getBusVolt() {
		return busVolt;
	}
	
	public String getBusAngle() {
		return busAngle;
	}

	public String getBusP() {
		return busP;
	}

	public String getBusQ() {
		return busQ;
	}

	/**
	 * @param busAngle The busAngle to set.
	 */
	public void setBusAngle(String busAngle) {
		this.busAngle = busAngle;
	}

	/**
	 * @param busCode The busCode to set.
	 */
	public void setBusCode(String busCode) {
		this.busCode = busCode;
	}

	/**
	 * @param busId The busId to set.
	 */
	public void setBusId(String busId) {
		this.busId = busId;
	}

	/**
	 * @param busP The busP to set.
	 */
	public void setBusP(String busP) {
		this.busP = busP;
	}

	/**
	 * @param busQ The busQ to set.
	 */
	public void setBusQ(String busQ) {
		this.busQ = busQ;
	}

	/**
	 * @param busVolt The busVolt to set.
	 */
	public void setBusVolt(String busVolt) {
		this.busVolt = busVolt;
	}
}