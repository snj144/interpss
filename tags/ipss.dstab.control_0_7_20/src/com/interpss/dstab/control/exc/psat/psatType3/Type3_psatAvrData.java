/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * A JavaBean to store data for the Simple excitor model
 *
 * $Id$
 */

package com.interpss.dstab.control.exc.psat.psatType3;

public class Type3_psatAvrData {
	public Type3_psatAvrData() {}

	// We need to put the default values here, so that the controller could be 
	// properly initialized
	private double vfmax = 10.0;
	private double vfmin = 0.0;
	private double mu0 = 1.0;
	private double t1 = 0.05;
	private double t2 = 0.15;
	private double tr = 0.05;
	private double v0 = 0.15;
	private double vf0 = 0.01;
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
	 * @return the v0
	 */
	public double getV0() {
		return v0;
	}
	/**
	 * @param v0 the v0 to set
	 */
	public void setV0(double v0) {
		this.v0 = v0;
	}
	/**
	 * @return the vf0
	 */
	public double getVf0() {
		return vf0;
	}
	/**
	 * @param vf0 the vf0 to set
	 */
	public void setVf0(double vf0) {
		this.vf0 = vf0;
	}
	/**
	 * @return the vfmax
	 */
	public double getVfmax() {
		return vfmax;
	}
	/**
	 * @param vfmax the vfmax to set
	 */
	public void setVfmax(double vfmax) {
		this.vfmax = vfmax;
	}
	/**
	 * @return the vfmin
	 */
	public double getVfmin() {
		return vfmin;
	}
	/**
	 * @param vfmin the vfmin to set
	 */
	public void setVfmin(double vfmin) {
		this.vfmin = vfmin;
	}
}
