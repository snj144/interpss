package org.interpss.vstab;

import org.ieee.odm.adapter.IODMPSSAdapter;
import org.ieee.odm.adapter.ieeecdf.IeeeCDFAdapter;
import org.interpss.BaseTestSetup;
import org.interpss.mapper.odm.IEEEODMMapper;
import org.interpss.vstab.impl.EigenAnalysisImpl;
import org.junit.Test;

import com.interpss.common.util.IpssLogger;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class VS_Ieee14_TestCase extends BaseTestSetup {
	@Test 
	public void testCase1() throws Exception {
		IODMPSSAdapter adapter = new IeeeCDFAdapter(IpssLogger.getLogger());
		adapter.parseInputFile("testdata/ieee_cdf/Ieee14.ieee");
		
		IEEEODMMapper mapper = new IEEEODMMapper();
		final SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.NOT_DEFINED, msg);
		if (mapper.mapping(adapter.getModel(), simuCtx, SimuContext.class)) {
  	  		simuCtx.setName("IEEE14");
		}		
		AclfNetwork net = simuCtx.getAclfNet();
  		//System.out.println(net.net2String());
		
		// VStab analysis and test
		EigenAnalysis ea=new EigenAnalysisImpl(net);
		ea.runEigenStrAnalysis();
		System.out.print(ea.getESAResult().getMinEigenValue());
	}
}
