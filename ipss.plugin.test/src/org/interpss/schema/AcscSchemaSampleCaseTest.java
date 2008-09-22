 /*
  * @(#)IpssSchemaAcscSampleCaseTest.java   
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

package org.interpss.schema;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.interpss.mapper.IpssXmlMapper;
import org.interpss.schema.RunStudyCaseXmlType.StandardRun.RunAcscStudyCase.AcscStudyCaseList.AcscStudyCaseRec;
import org.interpss.xml.IpssXmlParser;
import org.junit.Test;

import com.interpss.BaseTestSetup;
import com.interpss.common.SpringAppContext;
import com.interpss.common.mapper.IpssMapper;
import com.interpss.common.util.TestUtilFunc;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.acsc.AcscBusFault;
import com.interpss.core.acsc.SimpleFaultNetwork;
import com.interpss.core.algorithm.SimpleFaultAlgorithm;
import com.interpss.core.util.sample.SampleCases;

public class AcscSchemaSampleCaseTest extends BaseTestSetup {
	@Test
	public void sampleTest() throws Exception {
		File xmlFile = new File("testData/xml/RunAcscCase.xml");
  		IpssXmlParser parser = new IpssXmlParser(xmlFile);
  		//System.out.println("----->" + parser.getRootElem().toString());

	  	assertTrue(parser.getRunStudyCase().getAnalysisRunType() == RunStudyCaseXmlType.AnalysisRunType.RUN_ACSC);

	  	SimpleFaultNetwork faultNet = CoreObjectFactory.createSimpleFaultNetwork();
		SampleCases.load_SC_5BusSystem(faultNet, SpringAppContext.getIpssMsgHub());
		//System.out.println(faultNet.net2String());
  		assertTrue((faultNet.getBusList().size() == 5 && faultNet.getBranchList().size() == 5));

  		SimpleFaultAlgorithm algo = CoreObjectFactory.createSimpleFaultAlgorithm(faultNet);
	  	IpssMapper mapper = new IpssXmlMapper();
	  	for ( AcscStudyCaseRec acscRec : parser.getRunAcscStudyCase().getAcscStudyCaseList().getAcscStudyCaseRecArray()) {
	  		mapper.mapping(acscRec, algo, AcscStudyCaseXmlType.class);
	  		AcscBusFault fault = faultNet.getFaultList().get(0);
	  		algo.calculateBusFault((AcscBusFault)fault, SpringAppContext.getIpssMsgHub());
	  			/*
	  			 fault amps(1): (  0.0000 + j 32.57143) pu
	  			 fault amps(2): (  0.0000 + j  0.0000) pu
	  			 fault amps(0): (  0.0000 + j  0.0000) pu
	  			 */
	  		assertTrue(TestUtilFunc.compare(fault.getFaultResult().getSCCurrent_012(), 0.0, 0.0, 0.0, 32.57141796260087, 0.0, 0.0) );
	  	}
	}
}

