/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * A JavaBean to store data for the Simple excitor model
 *
 * $Id$
 */

package com.interpss.dstab.control.exc.ieee.y1968Type1;

public class Y1968Type1ExciterData {
	public Y1968Type1ExciterData() {}

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
	 * @return the vrmax
	 */
	public double getVrmax() {
		return vrmax;
	}
	/**
	 * @param vrmax the vrmax to set
	 */
	public void setVrmax(double vrmax) {
		this.vrmax = vrmax;
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
