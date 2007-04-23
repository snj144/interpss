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

package org.interpss.dstab.control.gov.ieee.steamTCSR;

import org.interpss.dstab.control.base.BaseControllerData;

public class IeeeSteamTCSRGovernorData extends BaseControllerData {
	private double k = 1.0;
	private double t1 = 2.0;
	private double t2 = 2.0;
	private double t3 = 2.0;
	private double pmax = 3.0;
	private double pmin = 4.0;
	private double pup = 0.0;
	private double pdown = 0.0;
	private double tch = 0.0;
	private double trh = 0.0;
	private double tco = 0.0;
	private double fch = 0.0;
	private double fip = 0.0;
	private double flp = 0.0;
	
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
		{"tch",		"-1000.0", 	"1000.0"}, 
		{"trh", 	"-1000.0", 	"1000.0"}, 
		{"tco", 	"-1000.0", 	"1000.0"}, 
		{"fch", 	"-1000.0", 	"1000.0"}, 
		{"fip", 	"-1000.0", 	"1000.0"}, 
		{"flp",		"-1000.0", 	"1000.0"} 
	};

	public IeeeSteamTCSRGovernorData() {
		setParameters(controllerParameters);
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
		else if (name.equals("trh"))
			this.trh = value;
		else if (name.equals("tco"))
			this.tco = value;
		else if (name.equals("fch"))
			this.fch = value;
		else if (name.equals("fip"))
			this.fip = value;
		else if (name.equals("flp"))
			this.flp = value;
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

	public double getFch() {
		return fch;
	}

	public void setFch(double fch) {
		this.fch = fch;
	}

	public double getFip() {
		return fip;
	}

	public void setFip(double fip) {
		this.fip = fip;
	}

	public double getFlp() {
		return flp;
	}

	public void setFlp(double flp) {
		this.flp = flp;
	}

	public double getTco() {
		return tco;
	}

	public void setTco(double tco) {
		this.tco = tco;
	}

	public double getTrh() {
		return trh;
	}

	public void setTrh(double trh) {
		this.trh = trh;
	}
} 
