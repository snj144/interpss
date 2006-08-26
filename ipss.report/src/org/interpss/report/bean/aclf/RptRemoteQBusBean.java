package org.interpss.report.bean.aclf;

import org.interpss.report.bean.RptBaseBean;

public class RptRemoteQBusBean extends RptBaseBean {
	private String vcBusId = null;
	private String type = null;
	private String reQBusBranch = null;
	private String actual = null;
	private String spec = null;
	private String q = null;
	private String qmax = null;
	private String qmin = null;
	private String status = null;

	public RptRemoteQBusBean() {
	}

	/**
	 * @return the actual
	 */
	public String getActual() {
		return actual;
	}

	/**
	 * @param actual the actual to set
	 */
	public void setActual(String actual) {
		this.actual = actual;
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
	 * @return the reQBusBranch
	 */
	public String getReQBusBranch() {
		return reQBusBranch;
	}

	/**
	 * @param reQBusBranch the reQBusBranch to set
	 */
	public void setReQBusBranch(String reQBusBranch) {
		this.reQBusBranch = reQBusBranch;
	}

	/**
	 * @return the spec
	 */
	public String getSpec() {
		return spec;
	}

	/**
	 * @param spec the spec to set
	 */
	public void setSpec(String spec) {
		this.spec = spec;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the vcBusId
	 */
	public String getVcBusId() {
		return vcBusId;
	}

	/**
	 * @param vcBusId the vcBusId to set
	 */
	public void setVcBusId(String vcBusId) {
		this.vcBusId = vcBusId;
	}
}