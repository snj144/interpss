/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * A JavaBean to store data for the Simple governor model
 *
 * $Id$
 */

package com.interpss.dstab.control.gov.ieee.ieeeST1;

import com.interpss.dstab.control.gov.AbstractGovernor;

public class IeeeST1GovernorData {
	public IeeeST1GovernorData() {}
	
	private int    optMode = AbstractGovernor.DroopMode;
	private double r = 5.0;
	private double fp = 0.7;
	private double pmax = 1.1;
	private double pmin = 0.0;
	private double t1 = 0.1;
	private double t2 = 0.1;
	private double t3 = 0.15;
	private double t4 = 5.0;
	/**
	 * @return the fp
	 */
	public double getFp() {
		return fp;
	}
	/**
	 * @param fp the fp to set
	 */
	public void setFp(double fp) {
		this.fp = fp;
	}
	/**
	 * @return the optMode
	 */
	public int getOptMode() {
		return optMode;
	}
	/**
	 * @param optMode the optMode to set
	 */
	public void setOptMode(int optMode) {
		this.optMode = optMode;
	}
	/**
	 * @return the pmax
	 */
	public double getPmax() {
		return pmax;
	}
	/**
	 * @param pmax the pmax to set
	 */
	public void setPmax(double pmax) {
		this.pmax = pmax;
	}
	/**
	 * @return the pmin
	 */
	public double getPmin() {
		return pmin;
	}
	/**
	 * @param pmin the pmin to set
	 */
	public void setPmin(double pmin) {
		this.pmin = pmin;
	}
	/**
	 * @return the r
	 */
	public double getR() {
		return r;
	}
	/**
	 * @param r the r to set
	 */
	public void setR(double r) {
		this.r = r;
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
} // SimpleExcAdapter
