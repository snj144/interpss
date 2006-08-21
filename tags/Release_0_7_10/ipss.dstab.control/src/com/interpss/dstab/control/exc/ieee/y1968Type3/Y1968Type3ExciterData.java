/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * A JavaBean to store data for the Simple excitor model
 *
 * $Id$
 */

package com.interpss.dstab.control.exc.ieee.y1968Type3;

public class Y1968Type3ExciterData {
	public Y1968Type3ExciterData() {}

	// We need to put the default values here, so that the controller could be 
	// properly initialized
	private double ka = 10.0;
	private double ta = 0.05;
	private double vrmax = 10.0;
	private double vrmin = 0.0;
	private double ke = 10.0;
	private double te = 0.05;
	private double vbmax = 0.0;
	private double kf = 10.0;
	private double tf = 0.05;
	private double kp = 10.0;
	private double ki = 0.05;
	/**
	 * @return the ke
	 */
	public double getKe() {
		return ke;
	}
	/**
	 * @param ke the ke to set
	 */
	public void setKe(double ke) {
		this.ke = ke;
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
	 * @return the ki
	 */
	public double getKi() {
		return ki;
	}
	/**
	 * @param ki the ki to set
	 */
	public void setKi(double ki) {
		this.ki = ki;
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
	 * @return the te
	 */
	public double getTe() {
		return te;
	}
	/**
	 * @param te the te to set
	 */
	public void setTe(double te) {
		this.te = te;
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
	 * @return the vbmax
	 */
	public double getVbmax() {
		return vbmax;
	}
	/**
	 * @param vbmax the vbmax to set
	 */
	public void setVbmax(double vbmax) {
		this.vbmax = vbmax;
	}
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

