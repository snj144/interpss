/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * A JavaBean to store data for the Simple excitor model
 *
 * $Id$
 */

package com.interpss.dstab.control.exc.ieee.y1968Type2;

public class Y1968Type2ExciterData {
	public Y1968Type2ExciterData() {}

	// We need to put the default values here, so that the controller could be 
	// properly initialized
	private double ka = 10.0;
	private double ta = 0.05;
	private double vrmax = 10.0;
	private double vrmin = 0.0;
	private double ke = 10.0;
	private double te = 0.05;
	private double se1_0 = 10.0;
	private double se0_75 = 0.0;
	private double kf = 10.0;
	private double tf1 = 0.05;
	private double tf2 = 0.05;
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
	 * @return the se0_75
	 */
	public double getSe0_75() {
		return se0_75;
	}
	/**
	 * @param se0_75 the se0_75 to set
	 */
	public void setSe0_75(double se0_75) {
		this.se0_75 = se0_75;
	}
	/**
	 * @return the se1_0
	 */
	public double getSe1_0() {
		return se1_0;
	}
	/**
	 * @param se1_0 the se1_0 to set
	 */
	public void setSe1_0(double se1_0) {
		this.se1_0 = se1_0;
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
	 * @return the tf1
	 */
	public double getTf1() {
		return tf1;
	}
	/**
	 * @param tf1 the tf1 to set
	 */
	public void setTf1(double tf1) {
		this.tf1 = tf1;
	}
	/**
	 * @return the tf2
	 */
	public double getTf2() {
		return tf2;
	}
	/**
	 * @param tf2 the tf2 to set
	 */
	public void setTf2(double tf2) {
		this.tf2 = tf2;
	}
}

