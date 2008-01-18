 /*
  * @(#)CommonFuncTest.java   
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
  * @Date 07/15/2007
  * 
  *   Revision History
  *   ================
  *
  */
package com.interpss.common;

import static org.junit.Assert.*;
import org.junit.*;

import com.interpss.common.func.ExpCalculator;
import com.interpss.common.func.ILookupTable;
import com.interpss.common.util.LookupTableImpl;


public class CommonFuncTest {
	private String   exp;
	private double[] dAry; 
	private double   result;
	
	@Test
	public void expCalculatorTest() {
		try {
			exp = "-a+b/c-d*e";
			dAry = new double[]{1.0, 2.0, 3.0, 4.0, 5.0}; 
			result = 20.33333;
			ExpCalculator calc = new ExpCalculator(exp);
			assertTrue(Math.abs(calc.eval(dAry)+result) < 0.00001);

			exp = "-a+b*c*d-e";
			dAry = new double[]{1.0, 2.0, 3.0, 4.0, 5.0}; 
			result = -18.0;
			calc = new ExpCalculator(exp);
			assertTrue(Math.abs(calc.eval(dAry)+result) < 0.00001);

			exp = "a+b*c*d-e";
			dAry = new double[]{1.0, 2.0, 3.0, 4.0, 5.0}; 
			result = -20.0;
			calc = new ExpCalculator(exp);
			assertTrue(Math.abs(calc.eval(dAry)+result) < 0.00001);

			exp = "a-b-c+d-e";
			dAry = new double[]{1.0, 2.0, 3.0, 4.0, 5.0}; 
			result = 5.0;
			calc = new ExpCalculator(exp);
			assertTrue(Math.abs(calc.eval(dAry)+result) < 0.00001);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void lookupTableTest() {
		LookupTableImpl ltable = new LookupTableImpl(ILookupTable.Type.LinearLine);
		ltable.addPoint(new ILookupTable.Point(1.0, 1.0));
		ltable.addPoint(new ILookupTable.Point(3.0, 3.0));
		ltable.addPoint(new ILookupTable.Point(5.0, 4.0));
		ltable.addPoint(new ILookupTable.Point(7.0, 3.0));
		
		assertTrue(Math.abs(ltable.getY(0.0)-0.0) < 0.0001);
		assertTrue(Math.abs(ltable.getY(2.0)-2.0) < 0.0001);
		assertTrue(Math.abs(ltable.getY(4.0)-3.5) < 0.0001);
		assertTrue(Math.abs(ltable.getY(8.0)-2.5) < 0.0001);
  	}	
}
