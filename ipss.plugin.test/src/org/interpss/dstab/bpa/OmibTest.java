package org.interpss.dstab.bpa;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.commons.math.complex.Complex;
import org.ieee.odm.ODMObjectFactory;
import org.ieee.odm.adapter.IODMAdapter;
import org.ieee.odm.adapter.bpa.BPAAdapter;
import org.ieee.odm.model.dstab.DStabModelParser;
import org.interpss.display.AclfOutFunc;
import org.interpss.dstab.ieeeModel.DStabTestSetupBase;
import org.interpss.dstab.output.TextSimuOutputHandler;
import org.interpss.mapper.odm.ODMDStabDataMapper;
import org.interpss.numeric.NumericConstant;
import org.interpss.numeric.util.Number2String;
import org.junit.Test;

import com.interpss.core.CoreObjectFactory;
import com.interpss.core.acsc.fault.AcscBusFault;
import com.interpss.core.acsc.fault.SimpleFaultCode;
import com.interpss.core.algo.LoadflowAlgorithm;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.algo.DynamicSimuAlgorithm;
import com.interpss.dstab.algo.DynamicSimuMethod;
import com.interpss.dstab.cache.StateVariableRecorder;
import com.interpss.dstab.cache.StateVariableRecorder.Record;
import com.interpss.dstab.common.DStabOutSymbol;
import com.interpss.dstab.devent.DynamicEvent;
import com.interpss.dstab.devent.DynamicEventType;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class OmibTest extends DStabTestSetupBase{
	@Test
	public void OMIBTestCase() throws Exception {
		IODMAdapter adapter = new BPAAdapter();
		assertTrue(adapter.parseInputFile(IODMAdapter.NetType.DStabNet,
				new String[] { "testdata/bpa/EQG007_omib.dat", 
				               "testdata/bpa/EQG007_omib.swi"}));//"testdata/bpa/07c_onlyMach.swi"
		//assertTrue(adapter.parseInputFile("testdata/bpa/07c.dat" ));
		
		DStabModelParser parser=(DStabModelParser) adapter.getModel();

		
		//parser.stdout();
		String xml=parser.toXmlDoc(false);
		FileOutputStream out=new FileOutputStream(new File("testdata/ieee_odm/EQG007_OMIB.xml"));
		out.write(xml.getBytes());
		out.flush();
		out.close();

		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.DSTABILITY_NET, msg);
		if (!new ODMDStabDataMapper(msg)
					.map2Model(parser, simuCtx)) {
			System.out.println("Error: ODM model to InterPSS SimuCtx mapping error, please contact support@interpss.com");
			return;
		}	
		
		DynamicSimuAlgorithm dstabAlgo = simuCtx.getDynSimuAlgorithm();
		DStabilityNetwork net = simuCtx.getDStabilityNet();
		// run load flow test case
		LoadflowAlgorithm aclfAlgo = dstabAlgo.getAclfAlgorithm();
		assertTrue(aclfAlgo.loadflow());
		System.out.println(AclfOutFunc.lfResultsBusStyle(net));
		
		dstabAlgo.setSimuMethod(DynamicSimuMethod.MODIFIED_EULER);
		dstabAlgo.setSimuStepSec(0.001);
		dstabAlgo.setTotalSimuTimeSec(30);
		dstabAlgo.setRefMachine(net.getMachine("Bus3-mach1"));
		
		// create fault
		create3PFaultEvent(net, "Bus1", "Bus1",0.2,0.1);
		
		StateVariableRecorder ssRecorder = new StateVariableRecorder(0.0001);
		ssRecorder.addCacheRecords("Bus2-mach1",      // mach id 
				StateVariableRecorder.RecType.Machine,    // record type
				DStabOutSymbol.OUT_SYMBOL_MACH_ANG,       // state variable name
				0.1,                                      // time steps for recording 
				300);                                      // total points to record 
		// set the output handler
		dstabAlgo.setSimuOutputHandler(ssRecorder);
		
		//dstabAlgo.setSimuOutputHandler(new TextSimuOutputHandler());
		if (dstabAlgo.getSolver().initialization()) {
			System.out.println("Running DStab simulation ...");
			dstabAlgo.performSimulation(msg);
		}
		
		// output recorded simulation results
		List<StateVariableRecorder.Record> list = ssRecorder.getMachineRecords(
				"Bus2-mach1", StateVariableRecorder.RecType.Machine, DStabOutSymbol.OUT_SYMBOL_MACH_ANG);
		System.out.println("\n\n Bus1 Machine Anagle");
		for (Record rec : list) {
			System.out.println(Number2String.toStr(rec.t) + ", " + Number2String.toStr(rec.variableValue));
		}
				
	}
	//@Test
	public void XmlDstabtestCase() throws Exception {
			
			File file = new File("testData/ieee_odm/OMIB.xml");
			DStabModelParser parser = ODMObjectFactory.createDStabModelParser();
			if (parser.parse(new FileInputStream(file))) {
				//System.out.println(parser.toXmlDoc(false));

				SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.DSTABILITY_NET, msg);
				if (!new ODMDStabDataMapper(msg)
							.map2Model(parser, simuCtx)) {
					System.out.println("Error: ODM model to InterPSS SimuCtx mapping error, please contact support@interpss.com");
					return;
				}
				DStabilityNetwork net = simuCtx.getDStabilityNet();
				DynamicSimuAlgorithm dstabAlgo = simuCtx.getDynSimuAlgorithm();
				
				// run load flow test case
				LoadflowAlgorithm aclfAlgo = dstabAlgo.getAclfAlgorithm();
				assertTrue(aclfAlgo.loadflow());
				
				dstabAlgo.setSimuMethod(DynamicSimuMethod.MODIFIED_EULER);
				dstabAlgo.setSimuStepSec(0.01);
				dstabAlgo.setTotalSimuTimeSec(0.40);

				
				// create fault
				create3PFaultEvent(net, "Bus2", "infinitBus",0.2,0.1);
				
				StateVariableRecorder ssRecorder = new StateVariableRecorder(0.0001);
				ssRecorder.addCacheRecords("Bus1-mach1",      // mach id 
						StateVariableRecorder.RecType.Machine,    // record type
						DStabOutSymbol.OUT_SYMBOL_MACH_ANG,       // state variable name
						0.1,                                      // time steps for recording 
						300);                                      // total points to record 
				// set the output handler
				dstabAlgo.setSimuOutputHandler(ssRecorder);
				
				dstabAlgo.setSimuOutputHandler(new TextSimuOutputHandler());
				if (dstabAlgo.getSolver().initialization()) {
					System.out.println("Running DStab simulation ...");
					dstabAlgo.performSimulation(msg);
				}
				
				// output recorded simulation results
				List<StateVariableRecorder.Record> list = ssRecorder.getMachineRecords(
						"Bus1-mach1", StateVariableRecorder.RecType.Machine, DStabOutSymbol.OUT_SYMBOL_MACH_ANG);
				System.out.println("\n\n Bus1 Machine Anagle");
				for (Record rec : list) {
					System.out.println(Number2String.toStr(rec.t) + ", " + Number2String.toStr(rec.variableValue));
				}
				
				
			}
				
				
		}		
		
	
	private void create3PFaultEvent(DStabilityNetwork net, String busId, 
			String busName, double startTime,double duration) {
		// define a bus fault event
		DynamicEvent event1 = DStabObjectFactory.createDEvent(
				"BusFault3P@"+busId, "Bus Fault 3P @"+busName, 
				DynamicEventType.BUS_FAULT, net);
		event1.setStartTimeSec(startTime);
		event1.setDurationSec(duration);
		
		// define a 3P fault
		DStabBus faultBus = net.getDStabBus(busId);
		AcscBusFault fault = CoreObjectFactory.createAcscBusFault("Bus Fault 3P@"+busId, net);
  		fault.setAcscBus(faultBus);
		fault.setFaultCode(SimpleFaultCode.GROUND_3P);
		fault.setZLGFault(NumericConstant.SmallScZ);
		fault.setZLLFault(new Complex(0.0, 0.0));
		
		// add the fault to the event
		event1.setBusFault(fault);		
	}


}
