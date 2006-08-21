package com.interpss.report.bean.aclf;

import com.interpss.report.bean.RptBaseBean;

public class RptPSXfrPControlBean extends RptBaseBean {
	private String branchId = null;
	private String pact = null;
	private String pspec = null;
	private String angle = null;
	private String angMax = null;
	private String angMin = null;
	private String status = null;

	public RptPSXfrPControlBean() {
	}

	/**
	 * @return the angle
	 */
	public String getAngle() {
		return angle;
	}

	/**
	 * @param angle the angle to set
	 */
	public void setAngle(String angle) {
		this.angle = angle;
	}

	/**
	 * @return the angMax
	 */
	public String getAngMax() {
		return angMax;
	}

	/**
	 * @param angMax the angMax to set
	 */
	public void setAngMax(String angMax) {
		this.angMax = angMax;
	}

	/**
	 * @return the angMin
	 */
	public String getAngMin() {
		return angMin;
	}

	/**
	 * @param angMin the angMin to set
	 */
	public void setAngMin(String angMin) {
		this.angMin = angMin;
	}

	/**
	 * @return the branchId
	 */
	public String getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	/**
	 * @return the pact
	 */
	public String getPact() {
		return pact;
	}

	/**
	 * @param pact the pact to set
	 */
	public void setPact(String pact) {
		this.pact = pact;
	}

	/**
	 * @return the pspec
	 */
	public String getPspec() {
		return pspec;
	}

	/**
	 * @param pspec the pspec to set
	 */
	public void setPspec(String pspec) {
		this.pspec = pspec;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}