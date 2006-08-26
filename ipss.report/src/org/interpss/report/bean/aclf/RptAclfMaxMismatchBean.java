package org.interpss.report.bean.aclf;

import org.interpss.report.bean.RptBaseBean;

public class RptAclfMaxMismatchBean extends RptBaseBean {
	private String pMaxBusId = null;
	private String pMaxPu = null;
	private String pMaxKva = null;
	private String qMaxBusId = null;
	private String qMaxPu = null;
	private String qMaxKva = null;

	public RptAclfMaxMismatchBean() {
	}

	/**
	 * @return Returns the pMaxKva.
	 */
	public String getPMaxKva() {
		return pMaxKva;
	}

	/**
	 * @param maxKva The pMaxKva to set.
	 */
	public void setPMaxKva(String maxKva) {
		pMaxKva = maxKva;
	}

	/**
	 * @return Returns the pMaxPu.
	 */
	public String getPMaxPu() {
		return pMaxPu;
	}

	/**
	 * @param maxPu The pMaxPu to set.
	 */
	public void setPMaxPu(String maxPu) {
		pMaxPu = maxPu;
	}

	/**
	 * @return Returns the pMmaxBusId.
	 */
	public String getPMaxBusId() {
		return pMaxBusId;
	}

	/**
	 * @param mmaxBusId The pMmaxBusId to set.
	 */
	public void setPMaxBusId(String maxBusId) {
		pMaxBusId = maxBusId;
	}

	/**
	 * @return Returns the qMaxBusId.
	 */
	public String getQMaxBusId() {
		return qMaxBusId;
	}

	/**
	 * @param maxBusId The qMaxBusId to set.
	 */
	public void setQMaxBusId(String maxBusId) {
		qMaxBusId = maxBusId;
	}

	/**
	 * @return Returns the qMaxKva.
	 */
	public String getQMaxKva() {
		return qMaxKva;
	}

	/**
	 * @param maxKva The qMaxKva to set.
	 */
	public void setQMaxKva(String maxKva) {
		qMaxKva = maxKva;
	}

	/**
	 * @return Returns the qMaxPu.
	 */
	public String getQMaxPu() {
		return qMaxPu;
	}

	/**
	 * @param maxPu The qMaxPu to set.
	 */
	public void setQMaxPu(String maxPu) {
		qMaxPu = maxPu;
	}

}