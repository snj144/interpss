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
	public void expCalculatorText() {
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
