package org.interpss.acsc.odm;

import static org.junit.Assert.assertTrue;
import java.io.File;
import java.io.FileInputStream;


import org.ieee.odm.ODMObjectFactory;
import org.ieee.odm.model.acsc.AcscModelParser;
import org.interpss.BaseTestSetup;
import org.interpss.mapper.odm.IEEEODMMapper;
import org.junit.Test;

import com.interpss.core.acsc.AcscBus;
import com.interpss.core.acsc.AcscNetwork;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class Acsc_5BusTest extends BaseTestSetup { 
	@Test
	public void testCase() throws Exception {
		File file = new File("testdata/ieee_odm/SC_5bus.xml");
		AcscModelParser parser = ODMObjectFactory.createAcscModelParser();
		if (parser.parse(new FileInputStream(file))) {
			//System.out.println(parser.toXmlDoc(false));
			
			IEEEODMMapper mapper = new IEEEODMMapper();
			SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACSC_FAULT_NET, msg);
			if (!mapper.mapping(parser, simuCtx, SimuContext.class)) {
	  	  		System.out.println("Error: ODM model to InterPSS SimuCtx mapping error, please contact support@interpss.com");
	  	  		return;
			}	
			
			AcscNetwork acscNet = simuCtx.getAcscNet();
			System.out.println(acscNet.net2String());			
					
			AcscBus acscBus4=acscNet.getAcscBus("Bus-4");
			assertTrue(Math.abs(acscBus4.getZ2().getImaginary()-0.02)<=0);
			assertTrue(Math.abs(acscBus4.getZ1().getImaginary()-0.02)<=0);
			assertTrue(acscBus4.getGrounding().getCode().getName().equals("SOLID_GROUNDED"));

			// perform loadflow and test the results
			/*LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(dstabNet, msg);
		  	algo.loadflow();*/
		  	
		  	//System.out.println(AclfOutFunc.loadFlowSummary(dstabNet));
		    /*assertTrue(Math.abs(dstabNet.getDStabBus("Bus-1").getVoltageMag() - 0.86011) < 0.0001);
		    assertTrue(Math.abs(dstabNet.getDStabBus("Bus-1").getVoltageAng(UnitType.Deg) + 4.8) < 0.1);*/
		}
	}
}

