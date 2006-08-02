/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * A JavaBean to store data for the Simple excitor model
 *
 * $Id$
 */

package com.interpss.dstab.control.exc.psat.psatType2;

public class Type2_psatAvrData {
	public Type2_psatAvrData() {}

	// We need to put the default values here, so that the controller could be 
	// properly initialized
	private double vrmax = 10.0;
	private double vrmin = 0.0;
	private double mu0 = 1.0;
	private double t1 = 0.05;
	private double t2 = 0.15;
	private double t3 = 0.05;
	private double t4 = 0.15;
	private double te = 0.01;
	private double tr = 0.01;
	private double ae = 1.0;
	private double be = 1.0;
	/**
	 * @return the ae
	 */
	public double getAe() {
		return ae;
	}
	/**
	 * @param ae the ae to set
	 */
	public void setAe(double ae) {
		this.ae = ae;
	}
	/**
	 * @return the be
	 */
	public double getBe() {
		return be;
	}
	/**
	 * @param be the be to set
	 */
	public void setBe(double be) {
		this.be = be;
	}
	/**
	 * @return the mu0
	 */
	public double getMu0() {
		return mu0;
	}
	/**
	 * @param mu0 the mu0 to set
	 */
	public void setMu0(double mu0) {
		this.mu0 = mu0;
	}
	/**
	 * @return the t1
	 */
	public double getT1() {
		return t1;
	}
	/**
	 * @param t1 the t1 to set
	 */
	public void setT1(double t1) {
		this.t1 = t1;
	}
	/**
	 * @return the t2
	 */
	public double getT2() {
		return t2;
	}
	/**
	 * @param t2 the t2 to set
	 */
	public void setT2(double t2) {
		this.t2 = t2;
	}
	/**
	 * @return the t3
	 */
	public double getT3() {
		return t3;
	}
	/**
	 * @param t3 the t3 to set
	 */
	public void setT3(double t3) {
		this.t3 = t3;
	}
	/**
	 * @return the t4
	 */
	public double getT4() {
		return t4;
	}
	/**
	 * @param t4 the t4 to set
	 */
	public void setT4(double t4) {
		this.t4 = t4;
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
	 * @return the tr
	 */
	public double getTr() {
		return tr;
	}
	/**
	 * @param tr the tr to set
	 */
	public void setTr(double tr) {
		this.tr = tr;
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
