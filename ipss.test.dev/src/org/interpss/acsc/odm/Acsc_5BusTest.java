package org.interpss.acsc.odm;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;

import org.ieee.odm.ODMObjectFactory;
import org.ieee.odm.model.acsc.AcscModelParser;
import org.interpss.BaseTestSetup;
import org.interpss.mapper.odm.IEEEODMMapper;
import org.junit.Test;

import com.interpss.common.util.TestUtilFunc;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.acsc.AcscBusFault;
import com.interpss.core.acsc.SimpleFaultNetwork;
import com.interpss.core.algorithm.SimpleFaultAlgorithm;
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
			
			// test fault network
			AcscBusFault busFault = simuCtx.getAcscFaultNet().getFault("Bus-1_Ground_3P_Bus fault at Bus-1");
			//assertTrue(busFault.getBus().getId().equals("Bus-1"));
			//assertTrue(busFault.getFaultType().equals(SimpleFaultType.BUS_FAULT));
			//assertTrue(Math.abs(busFault.getZLGFault().getImaginary()-0)==0);
			
			SimpleFaultNetwork faultNet = simuCtx.getAcscFaultNet();
			SimpleFaultAlgorithm acscAnalysis = CoreObjectFactory.createSimpleFaultAlgorithm(faultNet, msg);
			acscAnalysis.calculateBusFault(busFault);
			//System.out.println(AcscOutFunc.faultResult2String(faultNet));
			
	  		//System.out.println(busFault.toString(
	  		//		busFault.getAcscBus().getBaseVoltage(), faultNet));
			/*
			 fault amps(1): (  0.0000 + j  6.008784773163099) pu
			 fault amps(2): (  0.0000 + j  0.0000) pu
			 fault amps(0): (  0.0000 + j  0.0000) pu
			 */
		  	assertTrue(TestUtilFunc.compare(busFault.getFaultResult().getSCCurrent_012(), 
		  			0.0, 0.0, 0.0, 6.008784773163099, 0.0, 0.0) );			
		}
	}
}

