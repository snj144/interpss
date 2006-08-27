/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * A JavaBean to store data for the Simple governor model
 *
 * $Id$
 */

package org.interpss.dstab.control.gov.simple;

public class SimpleGovernorData {
	public SimpleGovernorData() {}
	
	private double k = 10.0;
	private double t1 = 0.5;
	private double pmax = 1.5;
	private double pmin = 0.0;
	/**
	 * @return Returns the k.
	 */
	public double getK() {
		return k;
	}
	/**
	 * @param k The k to set.
	 */
	public void setK(final double k) {
		this.k = k;
	}
	/**
	 * @return Returns the pmax.
	 */
	public double getPmax() {
		return pmax;
	}
	/**
	 * @param pmax The pmax to set.
	 */
	public void setPmax(final double pmax) {
		this.pmax = pmax;
	}
	/**
	 * @return Returns the pmin.
	 */
	public double getPmin() {
		return pmin;
	}
	/**
	 * @param pmin The pmin to set.
	 */
	public void setPmin(final double pmin) {
		this.pmin = pmin;
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
} // SimpleExcAdapter
