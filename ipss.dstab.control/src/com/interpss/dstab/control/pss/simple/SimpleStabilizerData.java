/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * A JavaBean to store data for the Simple stabilizer model
 *
 * $Id$
 */

package com.interpss.dstab.control.pss.simple;

public class SimpleStabilizerData {
	public SimpleStabilizerData() {}

	private double ks = 1.0;
	private double t1 = 0.05;
	private double t2 = 0.5;
	private double t3 = 0.05;
	private double t4 = 0.25;
	private double vsmax = 0.2;
	private double vsmin = -0.2;
	/**
	 * @return Returns the ks.
	 */
	public double getKs() {
		return ks;
	}
	/**
	 * @param ks The ks to set.
	 */
	public void setKs(final double ks) {
		this.ks = ks;
	}
	/**
	 * @return Returns the t1.
	 */
	public double getT1() {
		return t1;
	}
	/**
	 * @param t1 The t1 to set.
	 */
	public void setT1(final double t1) {
		this.t1 = t1;
	}
	/**
	 * @return Returns the t2.
	 */
	public double getT2() {
		return t2;
	}
	/**
	 * @param t2 The t2 to set.
	 */
	public void setT2(final double t2) {
		this.t2 = t2;
	}
	/**
	 * @return Returns the t3.
	 */
	public double getT3() {
		return t3;
	}
	/**
	 * @param t3 The t3 to set.
	 */
	public void setT3(final double t3) {
		this.t3 = t3;
	}
	/**
	 * @return Returns the t4.
	 */
	public double getT4() {
		return t4;
	}
	/**
	 * @param t4 The t4 to set.
	 */
	public void setT4(final double t4) {
		this.t4 = t4;
	}
	/**
	 * @return Returns the vsmax.
	 */
	public double getVsmax() {
		return vsmax;
	}
	/**
	 * @param vsmax The vsmax to set.
	 */
	public void setVsmax(final double vsmax) {
		this.vsmax = vsmax;
	}
	/**
	 * @return Returns the vsmin.
	 */
	public double getVsmin() {
		return vsmin;
	}
	/**
	 * @param vsmin The vsmin to set.
	 */
	public void setVsmin(final double vsmin) {
		this.vsmin = vsmin;
	}
} 
