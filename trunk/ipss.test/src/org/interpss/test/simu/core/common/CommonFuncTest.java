 /*
  * @(#)SparseEqnIntegerTest.java   
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

package org.interpss.test.simu.core.common;

import junit.framework.TestCase;

import com.interpss.common.func.ExpCalculator;
import com.interpss.common.func.LookupTable;

/**
 * @author mzhou
 *
 */
public class CommonFuncTest extends TestCase {
	public void testExpCalculator() {
		try {
			ExpCalculator calc = new ExpCalculator("-a+b/c-d*e");
			double[] dAry = {1.0, 2.0, 3.0, 4.0, 5.0}; 
			assertTrue(Math.abs(calc.eval(dAry)+20.33333) < 0.00001);

			calc = new ExpCalculator("-a+b*c*d-e");
			double[] dAry1 = {1.0, 2.0, 3.0, 4.0, 5.0}; 
			assertTrue(Math.abs(calc.eval(dAry1)-18.0) < 0.00001);

			calc = new ExpCalculator("a+b*c*d-e");
			double[] dAry2 = {1.0, 2.0, 3.0, 4.0, 5.0}; 
			assertTrue(Math.abs(calc.eval(dAry2)-20.0) < 0.00001);

			calc = new ExpCalculator("a-b-c+d-e");
			double[] dAry3 = {1.0, 2.0, 3.0, 4.0, 5.0}; 
			assertTrue(Math.abs(calc.eval(dAry3)+5.0) < 0.00001);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testLookupTable() {
		LookupTable ltable = new LookupTable(LookupTable.TypeLinearLine);
		ltable.addPoint(new LookupTable.Point(1.0, 1.0));
		ltable.addPoint(new LookupTable.Point(3.0, 3.0));
		ltable.addPoint(new LookupTable.Point(5.0, 4.0));
		ltable.addPoint(new LookupTable.Point(7.0, 3.0));
		
		//System.out.println(ltable);

		assertTrue(Math.abs(ltable.getY(0.0)-0.0) < 0.0001);
		assertTrue(Math.abs(ltable.getY(2.0)-2.0) < 0.0001);
		assertTrue(Math.abs(ltable.getY(4.0)-3.5) < 0.0001);
		assertTrue(Math.abs(ltable.getY(8.0)-2.5) < 0.0001);
  	}
}
