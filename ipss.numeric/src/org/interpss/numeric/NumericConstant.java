/*
 * @(#)NumericConstant.java   
 *
 * Copyright (C) 2006 www.interpss.com
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

package org.interpss.numeric;

import org.apache.commons.math.complex.Complex;


/**
 * Constants for ipss numeric package
 */

public class NumericConstant {
	public final static double
			//			Pai       = Math.PI,
			HalfPai = Math.PI * 0.5,
			//RtoD = 180.0 / Math.PI, 
			//DtoR = 1.0 / RtoD, 
			SqrtRoot3 = Math.sqrt(3.0), 
			HPtoKW = 0.746,
			Mile_Ft = 1.0 / 5280.0; // 1 Mile = 5280 Feet
	
	public final static Complex 
			a = new Complex(-0.5, SqrtRoot3 / 2.0),
			a2 = new Complex(-0.5, -SqrtRoot3 / 2.0);
	
	// for define error cases
	public final static double LargeDouble = 1.0e20;
	public final static int LargeNegativeInt = -Integer.MAX_VALUE;

	public final static Complex 
			SmallScZ = new Complex(0.0, 1.0e-8),
			LargeBusZ = new Complex(0.0, 1.0e10), 
			LargeBranchZ = new Complex(0.0, 1.0e20), 
			SmallBranchZ = new Complex(0.0, 1.0e-8);

	public final static double 
			ZMarginInitV = 0.0001, // pu
			SmallDoubleNumber = 0.000001;	
}