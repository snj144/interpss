package org.interpss.editor.data.dstab;

import com.interpss.common.util.NetUtilFunc;

public class DStabLoadChangeData extends DStabControllerData {
	private String busNameId;
	private double changeFactor;  // in %
	/**
	 * @return Returns the busId.
	 */
	public String getBusNameId() {
		return busNameId;
	}
	public String getBusId() {
		return NetUtilFunc.getBusIdFromDisplayNameId(getBusNameId());
	}
	/**
	 * @param busId The busId to set.
	 */
	public void setBusNameId(String busId) {
		this.busNameId = busId;
	}
	/**
	 * @return Returns the changeFactor.
	 */
	public double getChangeFactor() {
		return changeFactor;
	}
	/**
	 * @param changeFactor The changeFactor to set.
	 */
	public void setChangeFactor(double changeFactor) {
		this.changeFactor = changeFactor;
	}
}
