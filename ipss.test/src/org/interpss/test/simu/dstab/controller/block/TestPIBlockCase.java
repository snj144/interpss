 /*
  * @(#)TestSimpleExcitorCase.java   
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

package org.interpss.test.simu.dstab.controller.block;

import org.interpss.test.simu.dstab.controller.TestSetupBase;

import com.interpss.dstab.controller.block.DelayControlBlock;
import com.interpss.dstab.controller.block.IControlBlock;
import com.interpss.dstab.controller.block.PIControlBlock;

public class TestPIBlockCase extends TestSetupBase {
	public void test_Case1() {
		System.out.println("\nBegin TestPIBlockCase Case1");

		PIControlBlock block = new PIControlBlock(2.0, 1.0);
		
		assertTrue(block.initState(1.0));
		assertTrue(Math.abs(block.getStateX()-1.0) < 0.0001);
		assertTrue(Math.abs(block.getU0()) < 0.0001);
		
		double u = 0.0, dt = 0.01;
		block.eulerStep1(u, dt);
		block.eulerStep2(u, dt);
		
		block.eulerStep1(u, dt);
		block.eulerStep2(u, dt);

		block.eulerStep1(u, dt);
		block.eulerStep2(u, dt);
		
		assertTrue(Math.abs(block.getStateX()-1.0) < 0.0001);

		/* 
		 * u = 2.0, x(0) = 1.0, K = 1.0, dt = 0.01
		 * dXdt1 = Ku = 2.0
		 * X(1) = x(0) + dXdt*dt = 1.0 + 2.0 * 0.01 = 1.02
		 * dXdt2 = 2.0
		 * X1 = x(0) + 0.5*(dXdt1+dXdt2)*dt = 1.0 + 0.5 * (2.0 + 2.0) * 0.01 = 1.02
		 */
		u = 2.0;
		block.eulerStep1(u, dt);
		block.eulerStep2(u, dt);
		assertTrue(Math.abs(block.getStateX()-1.02) < 0.0001);
		assertTrue(Math.abs(block.getY(u)-5.02) < 0.0001);

		for (int i = 0; i < 999; i++) {
			block.eulerStep1(u, dt);
			block.eulerStep2(u, dt);
		}

		u = -2.0;
		for (int i = 0; i < 1000; i++) {
			block.eulerStep1(u, dt);
			block.eulerStep2(u, dt);
		}
		assertTrue(Math.abs(block.getStateX()-1.0) < 0.0001);

		System.out.println("\nEnd TestPIBlockCase Case1");
	}

	public void test_Case2() {
		System.out.println("\nBegin TestPIBlockCase Case2");

		PIControlBlock block = new PIControlBlock(IControlBlock.Type_Limit, 2.0, 1.0, 5.0, -5.0);
		
		assertTrue(!block.initState(6.0));
		assertTrue(!block.initState(-6.0));

		assertTrue(block.initState(0.0));

		double u = 6.0, dt = 0.01;
		for (int i = 0; i < 1000; i++) {
			block.eulerStep1(u, dt);
			block.eulerStep2(u, dt);
		}
		assertTrue(Math.abs(block.getY(u)-5.0) < 0.0001);

		u = -6.0;
		for (int i = 0; i < 1000; i++) {
			block.eulerStep1(u, dt);
			block.eulerStep2(u, dt);
		}
		assertTrue(Math.abs(block.getY(u)+5.0) < 0.0001);

		System.out.println("\nEnd TestPIBlockCase Case3");
	}

	public void test_Case3() {
		System.out.println("\nBegin TestPIBlockCase Case3");

		PIControlBlock block = new PIControlBlock(IControlBlock.Type_NonWindup, 2.0, 1.0, 5.0, -5.0);
		
		assertTrue(!block.initState(6.0));
		assertTrue(!block.initState(-6.0));

		assertTrue(block.initState(0.0));

		double u = 6.0, dt = 0.01;
		for (int i = 0; i < 1000; i++) {
			block.eulerStep1(u, dt);
			block.eulerStep2(u, dt);
		}
		assertTrue(Math.abs(block.getStateX()+block.getKp()*u-5.0) < 0.0001);
		assertTrue(Math.abs(block.getY(u)-5.0) < 0.0001);

		u = -6.0;
		for (int i = 0; i < 1000; i++) {
			block.eulerStep1(u, dt);
			block.eulerStep2(u, dt);
		}
		assertTrue(Math.abs(block.getStateX()+block.getKp()*u+5.0) < 0.0001);
		assertTrue(Math.abs(block.getY(u)+5.0) < 0.0001);

		System.out.println("\nEnd TestPIBlockCase Case3");
	}
}
