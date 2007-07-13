 /*
  * @(#)SparseEqnDoubleTest.java   
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

package com.interpss.core.sparse;

import static org.junit.Assert.*;
import org.junit.*;

import com.interpss.common.SpringAppContext;
import com.interpss.core.BaseTestSetup;
import com.interpss.core.sparse.SparseEqnDouble;
import com.interpss.core.sparse.impl.SparseEqnDoubleImpl;

/**
 * @author mzhou
 *
 */
public class SparseEqnDoubleTest extends BaseTestSetup {
	@Test
	public void testAddToAij() {
		SparseEqnDouble eqn = createSampleEqn();
		eqn.addToAij( 1.1, 2, 1 );
		assertTrue(eqn.getTotalElements()==10);
	}

	@Test
	public void testLuMatrixAndSolveEqn() {
		SparseEqnDouble eqn = createSampleEqn();
		eqn.luMatrixAndSolveEqn(1.0e-20, SpringAppContext.getIpssMsgHub());
		checkResult(eqn);
	}

	@Test
	public void testSetToZero() {
		SparseEqnDouble eqn = createSampleEqn();
		eqn.setToZero();
		assertTrue((eqn.getBi(1)-0.0) < 0.00001);
		assertTrue((eqn.getBi(4)-0.0) < 0.00001);
	}

	@Test
	public void testSetB2Unit() {
		SparseEqnDouble eqn = createSampleEqn();
		eqn.setB2Unit(1);
		assertTrue((eqn.getBi(1)-1.0) < 0.00001);
	}

	@Test
	public void testSetBi() {
		SparseEqnDouble eqn = createSampleEqn();
		eqn.setBi( 10.0, 1 );
		assertTrue((eqn.getBi(1)-10.0) < 0.00001);
	}

	@Test
	public void testReset() {
		SparseEqnDouble eqn = createSampleEqn();
		eqn.reset();
		assertTrue(eqn.getTotalElements()==4);
	}

	@Test
	public void testSolveEqn() {
		SparseEqnDouble eqn = createSampleEqn();
		eqn.luMatrix(1.0e-20, SpringAppContext.getIpssMsgHub());
		eqn.solveEqn(SpringAppContext.getIpssMsgHub());
		checkResult(eqn);
	}

	@Test
	public void testTotalElements() {
		SparseEqnDouble eqn = createSampleEqn();
		//System.out.println("total elements: " + eqn.totalElements());
		assertTrue(eqn.getTotalElements()==9);
	}

	public SparseEqnDouble createSampleEqn() {
		SparseEqnDouble eqn = new SparseEqnDoubleImpl(4);
		eqn.reset();

		eqn.addToAij( 1.0, 1, 1 );
		eqn.addToAij( 2.0, 2, 2 );
		eqn.addToAij( 3.0, 3, 3 );
		eqn.addToAij( 4.0, 4, 4 );

		eqn.addToAij( 1.1, 1, 2 );
		eqn.addToAij( 2.1, 3, 2 );
		eqn.addToAij( 3.1, 2, 3 );
		eqn.addToAij( 4.1, 2, 4 );
		eqn.addToAij( 1.9, 4, 1 );

		eqn.setBi( 1.0, 1 );
		eqn.setBi( 2.0, 2 );
		eqn.setBi( 3.0, 3 );
		eqn.setBi( 4.0, 4 );
		return eqn;
	}

	private void checkResult(SparseEqnDouble eqn) {
		double e1 = 1.0*eqn.getBi(1) + 1.1*eqn.getBi(2)                    - 1.0,
               e2 = 2.0*eqn.getBi(2) + 3.1*eqn.getBi(3) + 4.1*eqn.getBi(4) - 2.0,
               e3 = 2.1*eqn.getBi(2) + 3.0*eqn.getBi(3)                    - 3.0,
               e4 = 1.9*eqn.getBi(1) + 4.0*eqn.getBi(4)                    - 4.0;

        assertEquals(true, (Math.abs(e1)+Math.abs(e2)+Math.abs(e3)+Math.abs(e4)) < 0.0001 );
	}    
}
