/*
 * Created on Mar 16, 2005
 *
 */
package com.interpss.test.unit.core.sparse;

import com.interpss.common.SpringAppContext;
import com.interpss.core.sparse.SparseEqnDouble;
import com.interpss.core.sparse.impl.SparseEqnDoubleImpl;
import com.interpss.test.unit.TestBaseAppCtx;

/**
 * @author mzhou
 *
 */
public class SparseEqnDoubleTest extends TestBaseAppCtx {

	public void testBegin() {
 		System.out.println("\n\nBegin com.interpss.core.sparse.test.SparseEqnDoubleTest ...");
	}

	public void testAddToAij() {
		SparseEqnDouble eqn = createSampleEqn();
		eqn.addToAij( 1.1, 2, 1 );
		assertTrue(eqn.getTotalElements()==10);
	}

	public void testLuMatrixAndSolveEqn() {
		SparseEqnDouble eqn = createSampleEqn();

		try {
			eqn.luMatrixAndSolveEqn(1.0e-20, SpringAppContext.getIpssMsgHub());
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		checkResult(eqn);
	}

	public void testSetToZero() {
		SparseEqnDouble eqn = createSampleEqn();
		eqn.setToZero();
		assertTrue((eqn.getBi(1)-0.0) < 0.00001);
		assertTrue((eqn.getBi(4)-0.0) < 0.00001);
	}

	public void testSetB2Unit() {
		SparseEqnDouble eqn = createSampleEqn();
		eqn.setB2Unit(1);
		assertTrue((eqn.getBi(1)-1.0) < 0.00001);
	}

	public void testSetBi() {
		SparseEqnDouble eqn = createSampleEqn();
		eqn.setBi( 10.0, 1 );
		assertTrue((eqn.getBi(1)-10.0) < 0.00001);
	}

	public void testReset() {
		SparseEqnDouble eqn = createSampleEqn();
		eqn.reset();
		assertTrue(eqn.getTotalElements()==4);
	}

	public void testSolveEqn() {
		SparseEqnDouble eqn = createSampleEqn();
		try {
			eqn.luMatrix(1.0e-20, SpringAppContext.getIpssMsgHub());
			eqn.solveEqn(SpringAppContext.getIpssMsgHub());
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		checkResult(eqn);
	}

	public void testTotalElements() {
		SparseEqnDouble eqn = createSampleEqn();
		//System.out.println("total elements: " + eqn.totalElements());
		assertTrue(eqn.getTotalElements()==9);
	}

	public void testEnd() {
		System.out.println("End com.interpss.core.sparse.test.SparseEqnDoubleTest");
	}

	public SparseEqnDouble createSampleEqn() {
		SparseEqnDouble eqn = new SparseEqnDoubleImpl();
		eqn.setDimension(4);
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
