 /*
  * @(#)IEEE_DC1AExciterData.java   
  *
  * Copyright (C) 2006 www.interpss.org
  *
  * This program is free software; you can redistribute it and/or
  * modify it under the terms of the GNU LESSER GENERAL PUBLIC LICENSE
  * as published by the Free Software Foundation; either version 2.1
  * of the License, or (at your option) any later version.
  *
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  *
  * @Author Mike Zhou
  * @Version 1.0
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.dstab.control.exc.ieee.ieeeDC1A;

public class IEEE_DC1AExciterData {
	public IEEE_DC1AExciterData() {}

	// We need to put the default values here, so that the controller could be 
	// properly initialized
	private double ka = 46.0;
	private double ta = 0.06;
	private double tb = 0.0;
	private double tc = 0.0;
	private double te = 0.46;
	private double kf = 0.1;
	private double tf = 1.0;
	private double se_Efd1 = 0.33;
	private double se_Efd2 = 0.1;
	private double Efd1 = 3.1;
	private double Efd2 = 2.3;
	private double vrmax = 1.0;
	private double vrmin = -0.9;
	/**
	 * @return Returns the efd1.
	 */
	public double getEfd1() {
		return Efd1;
	}
	/**
	 * @param efd1 The efd1 to set.
	 */
	public void setEfd1(final double efd1) {
		Efd1 = efd1;
	}
	/**
	 * @return Returns the efd2.
	 */
	public double getEfd2() {
		return Efd2;
	}
	/**
	 * @param efd2 The efd2 to set.
	 */
	public void setEfd2(final double efd2) {
		Efd2 = efd2;
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
	 * @return Returns the kf.
	 */
	public double getKf() {
		return kf;
	}
	/**
	 * @param kf The kf to set.
	 */
	public void setKf(final double kf) {
		this.kf = kf;
	}
	/**
	 * @return Returns the se_Efd1.
	 */
	public double getSe_Efd1() {
		return se_Efd1;
	}
	/**
	 * @param se_Efd1 The se_Efd1 to set.
	 */
	public void setSe_Efd1(final double se_Efd1) {
		this.se_Efd1 = se_Efd1;
	}
	/**
	 * @return Returns the se_Efd2.
	 */
	public double getSe_Efd2() {
		return se_Efd2;
	}
	/**
	 * @param se_Efd2 The se_Efd2 to set.
	 */
	public void setSe_Efd2(final double se_Efd2) {
		this.se_Efd2 = se_Efd2;
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
	 * @return Returns the te.
	 */
	public double getTe() {
		return te;
	}
	/**
	 * @param te The te to set.
	 */
	public void setTe(final double te) {
		this.te = te;
	}
	/**
	 * @return Returns the tf.
	 */
	public double getTf() {
		return tf;
	}
	/**
	 * @param tf The tf to set.
	 */
	public void setTf(final double tf) {
		this.tf = tf;
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

