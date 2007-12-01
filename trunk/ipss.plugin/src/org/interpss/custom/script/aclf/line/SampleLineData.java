 /*
  * @(#)InductionGeneratorData.java   
  *
  * Copyright (C) 2006-2007 www.interpss.org
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
  * @Date 11/27/2007
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.custom.script.aclf.line;

/**
 * Plugin data object is a JavaBean. It has to have a default constructor
 * and getter/setter methods 
 */

public class SampleLineData {
	public SampleLineData() {}

	// We need to put the default values here, so that the controller could be 
	// properly initialized
	private double x  = 0.01, 
	               r  = 0.0, 
	               hB = 0.0;

	public double getX() {
		return this.x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getR() {
		return this.r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public double getHB() {
		return this.hB;
	}

	public void setHB(double hb) {
		this.hB = hb;
	}
}

