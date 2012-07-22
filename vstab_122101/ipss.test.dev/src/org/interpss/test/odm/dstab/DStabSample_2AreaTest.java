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

package org.interpss.test.odm.dstab;

import java.io.File;
import java.io.FileInputStream;

import org.ieee.odm.ODMObjectFactory;
import org.ieee.odm.model.dstab.DStabModelParser;
import org.interpss.display.AclfOutFunc;
import org.interpss.mapper.odm.ODMDStabDataMapper;
import org.interpss.test.DevTestSetup;
import org.junit.Test;

import com.interpss.core.CoreObjectFactory;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class DStabSample_2AreaTest extends DevTestSetup { 
	@Test
	public void testCase() throws Exception {
		File file = new File("testdata/ieee_odm/Tran_2Area.xml");
		DStabModelParser parser = ODMObjectFactory.createDStabModelParser();
		if (parser.parse(new FileInputStream(file))) {
			//System.out.println(parser.toXmlDoc(false));
			
			SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.DSTABILITY_NET, msg);
			if (!new ODMDStabDataMapper(msg)
						.map2Model(parser, simuCtx)) {
	  	  		System.out.println("Error: ODM model to InterPSS SimuCtx mapping error, please contact support@interpss.com");
	  	  		return;
			}	
			
			DStabilityNetwork dstabNet = simuCtx.getDStabilityNet();
			System.out.println(dstabNet.net2String());

			LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(dstabNet);
		  	algo.loadflow();
		  	
		  	System.out.println(AclfOutFunc.loadFlowSummary(dstabNet));
		}
	}
}

