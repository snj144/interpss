 /*
  * @(#)AclfSampleTest.java   
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

package com.interpss.pssl.test.dclf;

import static org.junit.Assert.assertTrue;

import org.ieee.odm.model.aclf.AclfModelParser;
import org.interpss.numeric.datatype.Unit.Type;
import org.interpss.numeric.util.NumericUtil;
import org.junit.Test;

import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.dclf.BusSenAnalysisType;
import com.interpss.pssl.plugin.IpssAdapter;
import com.interpss.pssl.simu.IpssPTrading;
import com.interpss.pssl.simu.IpssPTrading.DclfAlgorithmDSL;
import com.interpss.pssl.test.BaseTestSetup;

public class DclfGSF_Test extends BaseTestSetup {
	@Test
	public void gsfXmlTest() {
		AclfNetwork net = IpssAdapter.importAclfNet("testData/aclf/ieee14.ieee")
				.setFormat(IpssAdapter.FileFormat.IEEECommonFormat)
				.load()
				.getAclfNet();	
		
		DclfAlgorithmDSL algoDsl = IpssPTrading.createDclfAlgorithm(net);
		AclfModelParser parser = algoDsl.runAnalysis("testData/aclf/DclfGSFRun.xml");
		System.out.println(parser.toXmlDoc(false));
	}
	
	@Test
	public void gsfTest() {
		AclfNetwork net = IpssAdapter.importAclfNet("testData/aclf/ieee14.ieee")
				.setFormat(IpssAdapter.FileFormat.IEEECommonFormat)
				.load()
				.getAclfNet();		
		
		DclfAlgorithmDSL algoDsl = IpssPTrading.createDclfAlgorithm(net);
		algoDsl.injectionBusId("Bus2")
			   .withdrawBusId("Bus3");
		System.out.println("\nInj - Bus2, withdraw - Bus3");
		
		double f = algoDsl.monitorBranch("Bus2", "Bus3")
		   					.genShiftFactor();
		//System.out.println("monitorBranch - 2->3");
		//System.out.println("GSF: " + f );	
		assertTrue(NumericUtil.equals(f, 0.559376, 0.00001));

		f = algoDsl.monitorBranch("Bus4", "Bus3")
					.genShiftFactor();
		//System.out.println("monitorBranch - 4->3");
		//System.out.println("GSF: " + f );	
		assertTrue(NumericUtil.equals(f,-0.440623, 0.00001));

		algoDsl = IpssPTrading.createDclfAlgorithm(net);
		algoDsl.injectionBusId("Bus2")
			   .setWithdrawBusType(BusSenAnalysisType.MULTIPLE_BUS)
			   .addWithdrawBus("Bus14", 50.0)
			   .addWithdrawBus("Bus13", 50.0);
		System.out.println("\nInj - Bus2, withdraw - Bus14 50%, Bus13 50%");
		
		f = algoDsl.monitorBranch("Bus9", "Bus14")
					.genShiftFactor();
		//System.out.println("monitorBranch - 9->14");
		//System.out.println("GSF: " + f );	
		assertTrue(NumericUtil.equals(f, 0.424185, 0.00001));

		f = algoDsl.monitorBranch("Bus6", "Bus13")
					.genShiftFactor();
		//System.out.println("monitorBranch - 6->13");
		//System.out.println("GSF: " + f );	
		assertTrue(NumericUtil.equals(f, 0.447801, 0.00001));

		f = algoDsl.monitorBranch("Bus12", "Bus13")
					.genShiftFactor();
		//System.out.println("monitorBranch - 12->13");
		//System.out.println("GSF: " + f );
		assertTrue(NumericUtil.equals(f, 0.128015, 0.00001));
		
		algoDsl = IpssPTrading.createDclfAlgorithm(net);
		algoDsl.injectionBusId("Bus2")
			   .setWithdrawBusType(BusSenAnalysisType.MULTIPLE_BUS)
			   .addWithdrawBus("Bus14", 90.0)
			   .addWithdrawBus("Bus13", 10.0);
		System.out.println("\nInj - Bus2, withdraw - Bus14 90%, Bus13 10%");
		
		f = algoDsl.monitorBranch("Bus9", "Bus14")
					.genShiftFactor();
		//System.out.println("monitorBranch - 9->14");
		//System.out.println("GSF: " + f );	
		assertTrue(NumericUtil.equals(f, 0.569027, 0.00001));

		f =	algoDsl.monitorBranch("Bus6", "Bus13")
					.genShiftFactor();
		//System.out.println("monitorBranch - 6->13");
		//System.out.println("GSF: " + f);	
		assertTrue(NumericUtil.equals(f, 0.335159, 0.00001));

		f = algoDsl.monitorBranch("Bus12", "Bus13")
					.genShiftFactor();
		//System.out.println("monitorBranch - 12->13");
		//System.out.println("GSF: " + f );	
		assertTrue(NumericUtil.equals(f, 0.095813, 0.00001));
		
		algoDsl.setRefBus()
				.addLoadWithdrawBus(5.0, Type.mW);		
		f = algoDsl.injectionBusId("Bus2")
						.monitorBranch("Bus9", "Bus14")
						.genShiftFactor();		
		System.out.print("\nGen 2, monitorBranch - 9->14");
		System.out.println(" GSF: " + f );		

		f = algoDsl.monitorBranch("Bus6", "Bus13")
			.genShiftFactor();		
		System.out.print("\nGen 2, monitorBranch - 6->13");
		System.out.println(" GSF: " + f );		
	}
}

