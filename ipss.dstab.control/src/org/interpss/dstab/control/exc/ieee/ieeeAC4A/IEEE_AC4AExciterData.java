/*
 * Created on Aug 23, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.interpss.dstab.control.exc.ieee.ieeeAC4A;

/**
 * @author di xiao
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class IEEE_AC4AExciterData {
	public IEEE_AC4AExciterData() {}
	// We need to put the default values here, so that the controller could be 
	// properly initialized
	private double kc 	 = 0.001;
	private double ka 	 = 200.0;
	private double tr 	 = 0.001;
	private double tc 	 = 1.0;
	private double tb 	 = 10.0;
	private double ta 	 = 0.015;
	private double vrmax = 5.64;
	private double vrmin = -4.53;
	private double vimax = 10.0;
	private double vimin = -10.0;
	private double voel  = 15.0;
	private double vuel  = -15.00;
	private int ctrBusID = 0;	//default for gen terminal bus

	/**
	 * @return Returns the kc.
	 */
	public double getKc() {
		return kc;
	}
	/**
	 * @param kc The kc to set.
	 */
	public void setKc(final double kc) {
		this.kc = kc;
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
	 * @return Returns the tb.
	 */
	public double getTb() {
		return tb;
	}
	/**
	 * @param tb The tb to set.
	 */
	public void setTb(final double tb) {
		this.tb = tb;
	}
	/**
	 * @return Returns the tc.
	 */
	public double getTc() {
		return tc;
	}
	/**
	 * @param tc The tc to set.
	 */
	public void setTc(final double tc) {
		this.tc = tc;
	}
	/**
	 * @return Returns the tr.
	 */
	public double getTr() {
		return tr;
	}
	/**
	 * @param tr The tr to set.
	 */
	public void setTr(final double tr) {
		this.tr = tr;
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
	 * @param vrmax The vrmax to set.
	 */
	public void setVrmin(final double vrmin) {
		this.vrmin = vrmin;
	}
	/**
	 * @return Returns the vrmin.
	 */
	public double getVimax() {
		return vimax;
	}
	/**
	 * @param vimax The vimax to set.
	 */
	public void setVimax(final double vimax) {
		this.vimax = vimax;
	}
	/**
	 * @return Returns the vrmin.
	 */
	public double getVimin() {
		return vimin;
	}
	/**
	 * @param vimin The vimin to set.
	 */
	public void setVimin(final double vimin) {
		this.vimin = vimin;
	}
	/**
	 * @return Returns the voel.
	 */
	public double getVoel() {
		return voel;
	}
	/**
	 * @param voel The voel to set.
	 */
	public void setVoel(final double voel) {
		this.voel = voel;
	}
	/**
	 * @return Returns the vuel.
	 */
	public double getVuel() {
		return vuel;
	}
	/**
	 * @param vuel The vuel to set.
	 */
	public void setVuel(final double vuel) {
		this.vuel = vuel;
	}
	/**
	 * @return Returns the ctrBusID.
	 */
	public int getCtrBusID() {
		return ctrBusID;
	}
	/**
	 * @param ctrBusID The ctrBusID to set.
	 */
	public void setCtrBusID(final int ctrBusID) {
		this.ctrBusID = ctrBusID;
	}
	
}
