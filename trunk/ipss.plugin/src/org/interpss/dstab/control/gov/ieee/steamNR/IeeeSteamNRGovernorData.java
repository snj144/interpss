 /*
  * @(#)SimpleGovernorData.java   
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

package org.interpss.dstab.control.gov.ieee.steamNR;

import org.interpss.dstab.control.base.BaseControllerData;

public class IeeeSteamNRGovernorData extends BaseControllerData {
	private double k = 10.0;
	private double t1 = 0.5;
	private double t2 = 0.1;
	private double t3 = 1.0;
	private double pmax = 2.0;
	private double pmin = 0.0;
	private double pup = 1.2;
	private double pdown = 0.0;
	private double tch = 1.2;
	
	private static String[][] controllerParameters= { 
		//          min         max
		{"k", 		"-1000.0", 	"1000.0"}, 
		{"t1", 		"-1000.0", 	"1000.0"}, 
		{"t2", 		"-1000.0", 	"1000.0"}, 
		{"t3", 		"-1000.0", 	"1000.0"}, 
		{"pmax", 	"-1000.0", 	"1000.0"}, 
		{"pmin", 	"-1000.0", 	"1000.0"}, 
		{"pup", 	"-1000.0", 	"1000.0"}, 
		{"pdown", 	"-1000.0", 	"1000.0"}, 
		{"tch",		"-1000.0", 	"1000.0"} 
	};

	public IeeeSteamNRGovernorData() {
		setRangeParameters(controllerParameters);
	}

	public void setValue(String name, int value) {
	}

	public void setValue(String name, double value) {
		if (name.equals("k"))
			this.k = value;
		else if (name.equals("t1"))
			this.t1 = value;
		else if (name.equals("t2"))
			this.t2 = value;
		else if (name.equals("t3"))
			this.t3 = value;
		else if (name.equals("pmax"))
			this.pmax = value;
		else if (name.equals("pmin"))
			this.pmin = value;
		else if (name.equals("pup"))
			this.pup = value;
		else if (name.equals("pdown"))
			this.pdown = value;
		else if (name.equals("tch"))
			this.tch = value;
	}

	public double getK() {
		return k;
	}

	public void setK(double k) {
		this.k = k;
	}

	public double getPdown() {
		return pdown;
	}

	public void setPdown(double pdown) {
		this.pdown = pdown;
	}

	public double getPmax() {
		return pmax;
	}

	public void setPmax(double pmax) {
		this.pmax = pmax;
	}

	public double getPmin() {
		return pmin;
	}

	public void setPmin(double pmin) {
		this.pmin = pmin;
	}

	public double getPup() {
		return pup;
	}

	public void setPup(double pup) {
		this.pup = pup;
	}

	public double getT1() {
		return t1;
	}

	public void setT1(double t1) {
		this.t1 = t1;
	}

	public double getT2() {
		return t2;
	}

	public void setT2(double t2) {
		this.t2 = t2;
	}

	public double getT3() {
		return t3;
	}

	public void setT3(double t3) {
		this.t3 = t3;
	}

	public double getTch() {
		return tch;
	}

	public void setTch(double tch) {
		this.tch = tch;
	}
} 
