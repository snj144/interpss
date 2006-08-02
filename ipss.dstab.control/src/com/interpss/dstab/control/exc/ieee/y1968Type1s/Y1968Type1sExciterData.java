/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * A JavaBean to store data for the Simple excitor model
 *
 * $Id$
 */

package com.interpss.dstab.control.exc.ieee.y1968Type1s;

public class Y1968Type1sExciterData {
	public Y1968Type1sExciterData() {}

	// We need to put the default values here, so that the controller could be 
	// properly initialized
	private double ka = 10.0;
	private double ta = 0.05;
	private double kp = 10.0;
	private double vrmin = 0.0;
	private double kf = 10.0;
	private double tf = 0.05;
	/**
	 * @return the ka
	 */
	public double getKa() {
		return ka;
	}
	/**
	 * @param ka the ka to set
	 */
	public void setKa(double ka) {
		this.ka = ka;
	}
	/**
	 * @return the kf
	 */
	public double getKf() {
		return kf;
	}
	/**
	 * @param kf the kf to set
	 */
	public void setKf(double kf) {
		this.kf = kf;
	}
	/**
	 * @return the kp
	 */
	public double getKp() {
		return kp;
	}
	/**
	 * @param kp the kp to set
	 */
	public void setKp(double kp) {
		this.kp = kp;
	}
	/**
	 * @return the ta
	 */
	public double getTa() {
		return ta;
	}
	/**
	 * @param ta the ta to set
	 */
	public void setTa(double ta) {
		this.ta = ta;
	}
	/**
	 * @return the tf
	 */
	public double getTf() {
		return tf;
	}
	/**
	 * @param tf the tf to set
	 */
	public void setTf(double tf) {
		this.tf = tf;
	}
	/**
	 * @return the vrmin
	 */
	public double getVrmin() {
		return vrmin;
	}
	/**
	 * @param vrmin the vrmin to set
	 */
	public void setVrmin(double vrmin) {
		this.vrmin = vrmin;
	}
}

