package org.interpss.test.odm.dstab;

import static org.junit.Assert.assertTrue;

import org.ieee.odm.adapter.IODMAdapter;
import org.ieee.odm.adapter.bpa.BPAAdapter;
import org.ieee.odm.model.dstab.DStabModelParser;
import org.interpss.mapper.odm.ODMDStabDataMapper;
import org.interpss.test.DevTestSetup;
import org.junit.Test;

import com.interpss.SimuObjectFactory;
import com.interpss.core.algo.LoadflowAlgorithm;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.algo.DynamicSimuAlgorithm;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;

public class ODMMaper_IEEE9BusTest  extends DevTestSetup{
	@Test
	public void testCase() throws Exception {
		IODMAdapter adapter = new BPAAdapter();
		assertTrue(adapter.parseInputFile(IODMAdapter.NetType.DStabNet,
				new String[] { "testdata/bpa/IEEE9.dat", 
				               "testdata/bpa/IEEE9-dyn.swi"}));
		
		DStabModelParser parser = (DStabModelParser)adapter.getModel();
		
		parser.stdout();
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.DSTABILITY_NET);
		if (!new ODMDStabDataMapper(msg)
					.map2Model(parser, simuCtx)) {
			System.out.println("Error: ODM model to InterPSS SimuCtx mapping error, please contact support@interpss.com");
			return;
		}	

		DynamicSimuAlgorithm dstabAlgo = simuCtx.getDynSimuAlgorithm();
		DStabilityNetwork dstabNet = simuCtx.getDStabilityNet();

		LoadflowAlgorithm lfAlgo = dstabAlgo.getAclfAlgorithm();
		lfAlgo.loadflow();
		assertTrue(dstabNet.isLfConverged());
		//System.out.println(
		//assertTrue(Math.abs(dstabNet.getDStabBus("Bus-1").getVoltageMag() - 0.86011) < 0.0001);
		//assertTrue(Math.abs(dstabNet.getDStabBus("Bus-1").getVoltageAng(UnitType.Deg) + 4.8) < 0.1);
	}

}
