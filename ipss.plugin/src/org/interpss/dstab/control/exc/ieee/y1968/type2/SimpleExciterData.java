/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * A JavaBean to store data for the Simple excitor model
 *
 * $Id$
 */

package org.interpss.dstab.control.exc.ieee.y1968.type2;

public class SimpleExciterData {
	public SimpleExciterData() {}

	// We need to put the default values here, so that the controller could be 
	// properly initialized
	private double ka = 10.0;
	private double ta = 0.05;
	private double vrmax = 10.0;
	private double vrmin = 0.0;
	/**
	 * @return Returns the ka.
	 */
	public double getKa() {
		return ka;
	}
	/**
	 * @param ka The ka to set.
	 */
	public void setKa(final double ka) {
		this.ka = ka;
	}
	/**
	 * @return Returns the ta.
	 */
	public double getTa() {
		return ta;
	}
	/**
	 * @param ta The ta to set.
	 */
	public void setTa(final double ta) {
		this.ta = ta;
	}
	/**
	 * @return Returns the vrmax.
	 */
	public double getVrmax() {
		return vrmax;
	}
	/**
	 * @param vrmax The vrmax to set.
	 */
	public void setVrmax(final double vrmax) {
		this.vrmax = vrmax;
	}
	/**
	 * @return Returns the vrmin.
	 */
	public double getVrmin() {
		return vrmin;
	}
	/**
	 * @param vrmin The vrmin to set.
	 */
	public void setVrmin(final double vrmin) {
		this.vrmin = vrmin;
	}
}

