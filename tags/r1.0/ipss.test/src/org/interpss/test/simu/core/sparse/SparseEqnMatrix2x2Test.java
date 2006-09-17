 /*
  * @(#)SparseEqnMatrix2x2Test.java   
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

package org.interpss.test.simu.core.sparse;

import org.interpss.test.simu.TestBaseAppCtx;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Matrix_xy;
import com.interpss.common.datatype.Vector_xy;
import com.interpss.core.sparse.SparseEqnMatrix2x2;
import com.interpss.core.sparse.impl.SparseEqnMatrix2x2Impl;

/**
 * @author mzhou
 *
 */
public class SparseEqnMatrix2x2Test extends TestBaseAppCtx {
	public void testBegin() {
 		System.out.println("\n\nBegin com.interpss.core.sparse.test.SparseEqnMatrix2x2eTest ...");
	}
	
	public void testSolveEqn() {
		SparseEqnMatrix2x2 eqn = createSampleEqn();

		try {
			eqn.luMatrix(1.0e-20, SpringAppContext.getIpssMsgHub());
			eqn.solveEqn(SpringAppContext.getIpssMsgHub());
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		checkResult(eqn);
	}

	public void testLuMatrixAndSolveEqn() {
		SparseEqnMatrix2x2 eqn = createSampleEqn();

		try {
			eqn.luMatrixAndSolveEqn(1.0e-20, SpringAppContext.getIpssMsgHub());
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		checkResult(eqn);
	}
	
	public void testEnd() {
		System.out.println("End com.interpss.core.sparse.test.SparseEqnMatrix2x2Test");
	}
	
	private SparseEqnMatrix2x2 createSampleEqn() {
		SparseEqnMatrix2x2 eqn = new SparseEqnMatrix2x2Impl();
		eqn.setDimension(2);
		eqn.reset();
		Matrix_xy a11 = new Matrix_xy( 1.0, 1.1, 0.0, 2.0 ),
			        a12 = new Matrix_xy( 0.0, 0.0, 3.1, 4.1 ),
			        a21 = new Matrix_xy( 0.0, 2.1, 1.9, 0.0 ),
			        a22 = new Matrix_xy( 3.0, 0.0, 0.0, 4.0 );
		eqn.addToAij( a11, 1, 1 );
		eqn.addToAij( a12, 1, 2 );
		eqn.addToAij( a21, 2, 1 );
		eqn.addToAij( a22, 2, 2 );

		Vector_xy b1 = new Vector_xy( 1.0, 2.0 ),
			    b2 = new Vector_xy( 3.0, 4.0 );

		eqn.setBi( b1, 1 );
		eqn.setBi( b2, 2 );
		return eqn;
	}

	private void checkResult(SparseEqnMatrix2x2 eqn) {
		double e1 = 1.0*eqn.getBVect_xy(1).x + 1.1*eqn.getBVect_xy(1).y - 1.0,
	           e2 = 2.0*eqn.getBVect_xy(1).y + 3.1*eqn.getBVect_xy(2).x + 4.1*eqn.getBVect_xy(2).y - 2.0,
	           e3 = 2.1*eqn.getBVect_xy(1).y + 3.0*eqn.getBVect_xy(2).x                            - 3.0,
	           e4 = 1.9*eqn.getBVect_xy(1).x + 4.0*eqn.getBVect_xy(2).y                            - 4.0;

		assertEquals(true, (Math.abs(e1)+Math.abs(e2)+Math.abs(e3)+Math.abs(e4)) < 0.0001 );
		
	}
}
