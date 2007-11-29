 /*
  * @(#)SampleConstantZData.java   
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

package org.interpss.custom.script.dstab.z;

public class SampleConstantZData {
	public SampleConstantZData() {}

	// We need to put the default values here, so that the controller could be 
	// properly initialized
	private double p = 2.0, 
	               q = 1.0; 

	public double getP() {
		return this.p;
	}

	public void setP(double p) {
		this.p = p;
	}

	public double getQ() {
		return this.q;
	}

	public void setQ(double q) {
		this.q = q;
	}
}

