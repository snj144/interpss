package org.interpss.acsc.odm;

import static org.junit.Assert.assertTrue;
import java.io.File;
import java.io.FileInputStream;


import org.ieee.odm.ODMObjectFactory;
import org.ieee.odm.model.acsc.AcscModelParser;
import org.interpss.BaseTestSetup;
import org.interpss.display.AcscOutFunc;
import org.interpss.mapper.odm.IEEEODMMapper;
import org.junit.Test;

import com.interpss.core.CoreObjectFactory;
import com.interpss.core.acsc.AcscBranch;
import com.interpss.core.acsc.AcscBus;
import com.interpss.core.acsc.AcscBusFault;
import com.interpss.core.acsc.AcscNetwork;
import com.interpss.core.acsc.SimpleFaultNetwork;
import com.interpss.core.acsc.SimpleFaultType;
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
			SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACSC_NET, msg);
			if (!mapper.mapping(parser, simuCtx, SimuContext.class)) {
	  	  		System.out.println("Error: ODM model to InterPSS SimuCtx mapping error, please contact support@interpss.com");
	  	  		return;
			}	
			
			AcscNetwork acscNet = simuCtx.getAcscNet();
			//System.out.println(acscNet.net2String());			
					
			AcscBus acscBus4=acscNet.getAcscBus("Bus-4");			
			assertTrue(acscBus4.getScCode().getName().equals("Contribute"));			
			assertTrue(Math.abs(acscBus4.getBaseVoltage()-1000)<=0);
			assertTrue(Math.abs(acscBus4.getZ2().getImaginary()-0.02)<=0);
			assertTrue(Math.abs(acscBus4.getZ1().getImaginary()-0.02)<=0);			
			assertTrue(acscBus4.getGrounding().getCode().getName().equals("SolidGrounded"));
			
			AcscBranch bra23 =acscNet.getAcscBranch("Bus-2->Bus-3(1)");
			assertTrue(Math.abs(bra23.getZ().getImaginary()-0.3)<=0);
			assertTrue(Math.abs(bra23.getZ0().getImaginary()-0.75)<=0);
			
			AcscBranch xfr42 = acscNet.getAcscBranch("Bus-4->Bus-2(1)");
			assertTrue(Math.abs(xfr42.getZ().getImaginary()-0.015)<=0);
			assertTrue(Math.abs(xfr42.getFromTurnRatio()-1)<=0);			
			assertTrue(xfr42.getXfrFromConnectCode().getName().equals("WyeUngrounded"));
			assertTrue(Math.abs(xfr42.getZ0().getImaginary()-0.003)<=0);
			
			// test fault network
			AcscBusFault busFault = simuCtx.getAcscFaultNet().getFault("Bus-1_Ground_3P_Bus fault at Bus-1");
			assertTrue(busFault.getBus().getId().equals("Bus-1"));
			assertTrue(busFault.getFaultType().equals(SimpleFaultType.BUS_FAULT));
			assertTrue(Math.abs(busFault.getZLGFault().getImaginary()-0)==0);
			
			SimpleFaultNetwork faultNet = simuCtx.getAcscFaultNet();
			SimpleFaultAlgorithm acscAnalysis = CoreObjectFactory.createSimpleFaultAlgorithm(faultNet, msg);
			acscAnalysis.calculateBusFault(busFault);
			System.out.println(AcscOutFunc.faultResult2String(faultNet));

			
		  	
		  	//System.out.println(AclfOutFunc.loadFlowSummary(dstabNet));
		    /*assertTrue(Math.abs(dstabNet.getDStabBus("Bus-1").getVoltageMag() - 0.86011) < 0.0001);
		    assertTrue(Math.abs(dstabNet.getDStabBus("Bus-1").getVoltageAng(UnitType.Deg) + 4.8) < 0.1);*/
		}
	}
}

