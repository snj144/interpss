package org.interpss.report.bean.aclf;

import org.interpss.report.bean.RptBaseBean;

public class RptPVLimitBean extends RptBaseBean {
	private String busId = null;
	private String vact = null;
	private String vspec = null;
	private String q = null;
	private String qmax = null;
	private String qmin = null;
	private String status = null;

	public RptPVLimitBean() {
	}

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
	 * @return the q
	 */
	public String getQ() {
		return q;
	}

	/**
	 * @param q the q to set
	 */
	public void setQ(String q) {
		this.q = q;
	}

	/**
	 * @return the qmax
	 */
	public String getQmax() {
		return qmax;
	}

	/**
	 * @param qmax the qmax to set
	 */
	public void setQmax(String qmax) {
		this.qmax = qmax;
	}

	/**
	 * @return the qmin
	 */
	public String getQmin() {
		return qmin;
	}

	/**
	 * @param qmin the qmin to set
	 */
	public void setQmin(String qmin) {
		this.qmin = qmin;
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

	/**
	 * @return the vact
	 */
	public String getVact() {
		return vact;
	}

	/**
	 * @param vact the vact to set
	 */
	public void setVact(String vact) {
		this.vact = vact;
	}

	/**
	 * @return the vspec
	 */
	public String getVspec() {
		return vspec;
	}

	/**
	 * @param vspec the vspec to set
	 */
	public void setVspec(String vspec) {
		this.vspec = vspec;
	}
}