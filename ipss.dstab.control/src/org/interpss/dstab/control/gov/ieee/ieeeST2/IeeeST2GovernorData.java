/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * A JavaBean to store data for the Simple governor model
 *
 * $Id$
 */

package org.interpss.dstab.control.gov.ieee.ieeeST2;

import org.interpss.dstab.control.gov.AbstractGovernor;

public class IeeeST2GovernorData {
	public IeeeST2GovernorData() {}
	
	private int    optMode = AbstractGovernor.DroopMode;
	private double r = 5.0;
	private double fp1 = 0.3;
	private double fp2 = 0.4;
	private double fp3 = 0.3;
	private double pmax = 1.1;
	private double pmin = 0.0;
	private double t1 = 0.1;
	private double t2 = 0.1;
	private double t3 = 0.15;
	private double t4 = 4.0;
	private double t5 = 0.3;
	/**
	 * @return the fp1
	 */
	public double getFp1() {
		return fp1;
	}
	/**
	 * @param fp1 the fp1 to set
	 */
	public void setFp1(double fp1) {
		this.fp1 = fp1;
	}
	/**
	 * @return the fp2
	 */
	public double getFp2() {
		return fp2;
	}
	/**
	 * @param fp2 the fp2 to set
	 */
	public void setFp2(double fp2) {
		this.fp2 = fp2;
	}
	/**
	 * @return the fp3
	 */
	public double getFp3() {
		return fp3;
	}
	/**
	 * @param fp3 the fp3 to set
	 */
	public void setFp3(double fp3) {
		this.fp3 = fp3;
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
	/**
	 * @return the t5
	 */
	public double getT5() {
		return t5;
	}
	/**
	 * @param t5 the t5 to set
	 */
	public void setT5(double t5) {
		this.t5 = t5;
	}
} // SimpleExcAdapter
