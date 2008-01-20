/*
 * @(#)DclfSampleTest.java   
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

package com.interpss.core.dclf;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.interpss.BaseTestSetup;
import com.interpss.common.SpringAppContext;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.util.sample.SampleCases;

public class DclfSampleTest extends BaseTestSetup {
	/*
	 * load the 5-bus system
	 */
	@Test
	public void sampleTest() {
		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		SampleCases.load_LF_5BusSystem(net, SpringAppContext.getIpssMsgHub());
		// System.out.println(net.net2String());

		DclfAlgorithm algo = CoreObjectFactory.createDclfAlgorithm(net);
		if (algo.checkCondition(SpringAppContext.getIpssMsgHub()))
			algo.calculateDclf(SpringAppContext.getIpssMsgHub());
/*
		for (Bus bus : net.getBusList()) {
			int n = bus.getSortNumber();
			System.out.println("Bus id, dAng : "
					+ bus.getId()
					+ ", "
					+ Number2String.toStr(algo.getBusAngle(n)
							* Constants.RtoD));
		}
*/
		assertTrue(Math.abs(algo.getBusAngle(1) - 0.41933) < 0.0001);
		assertTrue(Math.abs(algo.getBusAngle(2)) < 0.0001);
		assertTrue(Math.abs(algo.getBusAngle(3) + 0.06122) < 0.0001);
		assertTrue(Math.abs(algo.getBusAngle(4) - 0.34433) < 0.0001);
		assertTrue(Math.abs(algo.getBusAngle(5) + 0.069) < 0.0001);
		
		algo.calculateSensitivity(DclfSensitivityType.PANGLE, "3", SpringAppContext.getIpssMsgHub());
//		System.out.println(algo.getB1PAngleMatrix());
/*
b(1): -0.030000000000000034
b(2): -0.0
b(3): -0.03000000000000002
b(4): -0.030000000000000034
b(5): -0.030000000000000006
 */
/*
		for (int i = 1; i <= 5; i++)
			System.out.println(i + ", " + algo.getBusSensitivity(DclfSensitivityType.PANGLE,i));
*/		
		assertTrue(Math.abs(algo.getBusSensitivity(DclfSensitivityType.PANGLE,1) + 0.03) < 0.0001);
		assertTrue(Math.abs(algo.getBusSensitivity(DclfSensitivityType.PANGLE,2)) < 0.0001);
		assertTrue(Math.abs(algo.getBusSensitivity(DclfSensitivityType.PANGLE,3) + 0.03) < 0.0001);
		assertTrue(Math.abs(algo.getBusSensitivity(DclfSensitivityType.PANGLE,4) + 0.03) < 0.0001);
		assertTrue(Math.abs(algo.getBusSensitivity(DclfSensitivityType.PANGLE,5) + 0.03) < 0.0001);

		algo.calculateSensitivity(DclfSensitivityType.QVOLTAGE, "3", SpringAppContext.getIpssMsgHub());
//		System.out.println(algo.getB11QVoltageMatrix());
		/*
b(1): -0.0
b(2): -0.0
b(3): -0.01311612109013261
b(4): -0.002126974748964943
b(5): -0.02934145973738819
		 */
/*		
		for (int i = 1; i <= 5; i++)
			System.out.println(i + ", " + algo.getBusSensitivity(DclfSensitivityType.QVOLTAGE,i));
*/
		assertTrue(Math.abs(algo.getBusSensitivity(DclfSensitivityType.QVOLTAGE,1)) < 0.0001);
		assertTrue(Math.abs(algo.getBusSensitivity(DclfSensitivityType.QVOLTAGE,2)) < 0.0001);
		assertTrue(Math.abs(algo.getBusSensitivity(DclfSensitivityType.QVOLTAGE,3) + 0.013116) < 0.0001);
		assertTrue(Math.abs(algo.getBusSensitivity(DclfSensitivityType.QVOLTAGE,4) + 0.002127) < 0.0001);
		assertTrue(Math.abs(algo.getBusSensitivity(DclfSensitivityType.QVOLTAGE,5) + 0.029342) < 0.0001);
	}
}
