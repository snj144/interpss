 /*
  * @(#)OdmXml_Test.java   
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

package org.ieee.odm.ofp;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;

import org.ieee.odm.model.ModelStringUtil;
import org.ieee.odm.model.ODMModelParser;
import org.ieee.odm.model.opf.OpfModelParser;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.LoadflowBusXmlType;
import org.ieee.odm.schema.OpfGenBusXmlType;
import org.junit.Test;

public class ProcessOPFData_Test { 
	@Test
	public void testCase() throws Exception {
/*
<!-- 
    from a aclf network, change to a opf network
    
      1) change <aclfNet -> <opfNet
      2) change analysisCategory to OPF
      3) add <anglePenaltyFactor>1</anglePenaltyFactor> at the end
      4) change some aclfBus to opfGenBus, using sample code here
 -->
 */
		
		File file = new File("testdata/ieee_odm/Ieee14Bus_opf.xml");
		ODMModelParser parser = new ODMModelParser();
		parser.parse(new FileInputStream(file));
		//System.out.println(parser.toXmlDoc(false));
		
		OpfModelParser opfParser = parser.toOpfModelParser();
		//System.out.println(aclfParser.toXmlDoc(false));
		assertTrue(opfParser.getAclfNet().getBasePower().getValue() == 100.0);
		assertTrue(opfParser.getAclfNet().getBusList().getBus().size() == 14);
		
		BusXmlType aclfBus = opfParser.getBus("Bus2");
		assertTrue(aclfBus instanceof LoadflowBusXmlType);
		
		OpfGenBusXmlType opfGenBus = (OpfGenBusXmlType)ModelStringUtil.casting(aclfBus, "aclfBus", "opfGenBus");
		opfGenBus.setCoeffA(1.0);
		opfGenBus.setCoeffB(0.5);
		opfParser.replaceBus("Bus2", opfGenBus);

		aclfBus = opfParser.getBus("Bus2");
		assertTrue(aclfBus instanceof OpfGenBusXmlType);
		//System.out.println(opfParser.toXmlDoc(false));
	}
}

