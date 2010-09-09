package edu.scut.test;

import org.ieee.odm.adapter.IODMPSSAdapter;
import org.ieee.odm.adapter.ieeecdf.IeeeCDFAdapter;
import org.interpss.mapper.odm.IEEEODMMapper;
import org.junit.Test;

import com.interpss.common.util.IpssLogger;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class VS_Ieee14_TestCase extends VStabTestBese {
	@Test 
	public void testCase1() throws Exception {
		init();

		IODMPSSAdapter adapter = new IeeeCDFAdapter(IpssLogger.getLogger());
		adapter.parseInputFile("testdata/Ieee14.ieee");
		
		IEEEODMMapper mapper = new IEEEODMMapper();
		final SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.NOT_DEFINED, msg);
		if (mapper.mapping(adapter.getModel(), simuCtx, SimuContext.class)) {
  	  		simuCtx.setName("IEEE14");
		}		
		AclfNetwork net = simuCtx.getAclfNet();
  		//System.out.println(net.net2String());
		
		// Tony - add your VStab analysis and test here
	}
}
