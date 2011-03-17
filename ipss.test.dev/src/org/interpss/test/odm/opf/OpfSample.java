 /*
  * @(#)IEEECDF_ODMTest.java   
  *
  * Copyright (C) 2008 www.interpss.org
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
  * @Date 02/01/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.test.odm.opf;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;

import org.ieee.odm.ODMObjectFactory;
import org.ieee.odm.model.opf.OpfModelParser;
import org.interpss.display.AclfOutFunc;
import org.interpss.mapper.odm.ODMOpfDataMapper;
import org.interpss.opf.dc.OpfNetworkHelper;
import org.interpss.opf.dc.QuadProgCalculator;
import org.interpss.opf.dc.util.OpfOutFunc;
import org.interpss.test.DevTestSetup;
import org.junit.Test;

import com.interpss.core.CoreObjectFactory;
import com.interpss.core.algo.LoadflowAlgorithm;
import com.interpss.opf.OpfNetwork;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class OpfSample  extends DevTestSetup { 
	@Test
	public void test3BusCase() throws Exception {
		File file = new File("testdata/opf/opf_3bus_test.xml");
		OpfModelParser parser = ODMObjectFactory.createOpfModelParser();
		if (parser.parse(new FileInputStream(file))) {
			//System.out.println(parser.toXmlDoc(false));
			
			SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.OPF_NET, msg);
			if (!new ODMOpfDataMapper(msg)
						.map2Model(parser, simuCtx)) {
	  	  		System.out.println("Error: ODM model to InterPSS SimuCtx mapping error, please contact support@interpss.com");
	  	  		return;
			}	
			
			OpfNetwork opfNet = simuCtx.getOpfNet();
//			System.out.println(opfNet.net2String());

			QuadProgCalculator opfAlgo=new QuadProgCalculator(opfNet);
			opfAlgo.runDCOPF();
			
			System.out.println(OpfOutFunc.opfResultSummary(opfNet));
			
/*
			Minimun Total Variable Cost: 26.215
			Minimun Total Cost: 506.106
 */
		  	assertTrue(Math.abs(opfNet.getMinTotalVariableCost() - 26.215) < 0.01);			
		  	assertTrue(Math.abs(opfNet.getTotalFixedCost() - (506.106-26.215)) < 0.01);			
		}
	}
	@Test
	public void testIEEE30BusCase() throws Exception {
		/*
		 * Note:
		 * 1.Origin Data source: Modified IEEE 30-Bus System, p.477-478
		 * Shahidehpour et al. 2002, "Market Operations in Electric Power Systems"
		 * 
		 * 2.the load data keep unchanged as the IEEE 30 Bus, 
		 * the same as LP-16 load in the IEEE30FixedDemand case of DC-OPFJ,
		 * for detailed,refer to http://www.econ.iastate.edu/tesfatsi/DCOPFJHome.htm
		 * 
		 */
		File file = new File("testdata/opf/ieee30ODM.xml");
		OpfModelParser parser = ODMObjectFactory.createOpfModelParser();
		if (parser.parse(new FileInputStream(file))) {
			//System.out.println(parser.toXmlDoc(false));
			
			SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.OPF_NET, msg);
			if (!new ODMOpfDataMapper(msg)
						.map2Model(parser, simuCtx)) {
	  	  		System.out.println("Error: ODM model to InterPSS SimuCtx mapping error, please contact support@interpss.com");
	  	  		return;
			}	
			
			OpfNetwork opfNet = simuCtx.getOpfNet();
//			System.out.println(opfNet.net2String());
			
//			OpfNetworkHelper opfHelper =new OpfNetworkHelper(opfNet);
//			System.out.println(opfHelper.formU());
//            LoadflowAlgorithm lfAlgo= CoreObjectFactory.createLoadflowAlgorithm(opfNet);
//            lfAlgo.loadflow();
//            System.out.println(AclfOutFunc.loadFlowSummary(opfNet));
			QuadProgCalculator opfAlgo=new QuadProgCalculator(opfNet);
			opfAlgo.runDCOPF();
//			
			System.out.println(OpfOutFunc.opfResultSummary(opfNet));
			
/*
			Minimun Total Variable Cost: 26.215
			Minimun Total Cost: 506.106
 */
//		  	assertTrue(Math.abs(opfNet.getMinTotalVariableCost() - 26.215) < 0.01);			
//		  	assertTrue(Math.abs(opfNet.getTotalFixedCost() - (506.106-26.215)) < 0.01);			
		}
	}
}

