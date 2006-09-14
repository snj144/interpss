 /*
  * @(#)TestSimpleStabilizerCase.java   
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

package org.interpss.test.simu.dstab.controller.pss;

import org.interpss.test.simu.dstab.controller.TestSetupBase;

import com.interpss.dstab.DynamicSimuMethods;
import org.interpss.dstab.control.exc.simple.SimpleExciter;
import org.interpss.dstab.control.pss.simple.SimpleStabilizer;
import com.interpss.dstab.mach.Machine;

public class TestSimpleStabilizerCase extends TestSetupBase {

	public void test_Case1() {
		System.out.println("\nBegin TestSimpleStabilizerCase Case1");

		Machine mach = createMachine();

		SimpleExciter exc = new SimpleExciter("ExcId", "ExcName", "InterPSS");
		exc.getData().setKa(50.0);
		exc.getData().setTa(0.05);
		exc.getData().setVrmax(10.0);
		exc.getData().setVrmin(0.0);
		mach.addExciter(exc);

		SimpleStabilizer pss = new SimpleStabilizer("PssId", "PssName", "InterPSS");
		pss.getData().setKs(1.0);
		pss.getData().setT1(0.05);
		pss.getData().setT2(0.5);
		pss.getData().setT3(0.05);
		pss.getData().setT4(0.25);
		pss.getData().setVsmax(0.2);
		pss.getData().setVsmin(-0.2);
		mach.addStabilizer(pss);
		
		
		mach.setSpeed(1.0);
		pss.initStates(this.msg);
		assertTrue(Math.abs(pss.getStateX1()) < 0.0001);
		assertTrue(Math.abs(pss.getStateX2()) < 0.0001);
	
		// calculate a step, the state should remain the same
		pss.nextStep(0.01, DynamicSimuMethods.MODIFIED_EULER_LITERAL, 60.0, msg);
		assertTrue(Math.abs(pss.getStateX1()) < 0.0001);
		assertTrue(Math.abs(pss.getStateX2()) < 0.0001);
		
		// calculate more steps, the state should remain the same also
		pss.nextStep(0.01, DynamicSimuMethods.MODIFIED_EULER_LITERAL, 60.0, msg);
		pss.nextStep(0.01, DynamicSimuMethods.MODIFIED_EULER_LITERAL, 60.0, msg);
		pss.nextStep(0.01, DynamicSimuMethods.MODIFIED_EULER_LITERAL, 60.0, msg);
		pss.nextStep(0.01, DynamicSimuMethods.MODIFIED_EULER_LITERAL, 60.0, msg);
		pss.nextStep(0.01, DynamicSimuMethods.MODIFIED_EULER_LITERAL, 60.0, msg);
		assertTrue(Math.abs(pss.getStateX1()) < 0.0001);
		assertTrue(Math.abs(pss.getStateX2()) < 0.0001);
		
		/*
		 * dw = 0.1, X1(0) = 0.0, X2(0) = 0.0
		 * 1.0 - T1/T2 = 0.9, T3/T4 = 0.2
		 * dX1dt = 2.0*[0.9*1.0*dw - 0.0] = 0.18
		 * dX2dt = 4.0*[0.8*(0.1*dw + 0.0 ) - 0.0] = 0.032
		 * X1(1) = 0.0 + 0.18*0.01 = 0.0018
		 * X2(1) = 0.0 + 0.032*0.01 = 0.00032
		 * dX1dt = 2.0*[0.9*1.0*dw - 0.0018] = 0.1746
		 * dX2dt = 4.0*[0.8*(0.1*dw + 0.0018 ) - 0.00032] = 0.03646
		 * X1 = 0.0 + 0.5*(0.18 + 0.1764) = 0.001782
		 * X2 = 0.0 + 0.5*(0.032 + 0.03646) = 0.0003423
		 */
		mach.setSpeed(1.1);
		pss.nextStep(0.01, DynamicSimuMethods.MODIFIED_EULER_LITERAL, 60.0, msg);
		//System.out.println("X1, X2: " + pss._X1 + ", " + pss._X2);
		assertTrue(Math.abs(pss.getStateX1()-0.001782) < 0.0001);
		assertTrue(Math.abs(pss.getStateX2()-0.0003423) < 0.0001);

		System.out.println("\nEnd TestSimpleStabilizerCase Case1");
	}
}
