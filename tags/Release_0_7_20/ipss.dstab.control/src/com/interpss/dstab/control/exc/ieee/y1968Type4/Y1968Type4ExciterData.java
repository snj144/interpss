/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * A JavaBean to store data for the Simple excitor model
 *
 * $Id$
 */

package com.interpss.dstab.control.exc.ieee.y1968Type4;

public class Y1968Type4ExciterData {
	public Y1968Type4ExciterData() {}

	// We need to put the default values here, so that the controller could be 
	// properly initialized
	private double trh = 0.05;
	private double vrmax = 10.0;
	private double vrmin = 0.0;
	private double ke = 10.0;
	private double te = 0.05;
	private double se1_0 = 10.0;
	private double se0_75 = 0.0;
	private double kf = 10.0;
	private double tf = 0.05;
	private double kv = 10.0;
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
	 * @return the kv
	 */
	public double getKv() {
		return kv;
	}
	/**
	 * @param kv the kv to set
	 */
	public void setKv(double kv) {
		this.kv = kv;
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
	 * @return the trh
	 */
	public double getTrh() {
		return trh;
	}
	/**
	 * @param trh the trh to set
	 */
	public void setTrh(double trh) {
		this.trh = trh;
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

