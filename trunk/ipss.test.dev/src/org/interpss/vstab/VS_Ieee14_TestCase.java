package org.interpss.vstab;

import org.ieee.odm.adapter.IODMPSSAdapter;
import org.ieee.odm.adapter.ieeecdf.IeeeCDFAdapter;
import org.ieee.odm.model.aclf.AclfModelParser;
import org.interpss.BaseTestSetup;
import org.interpss.PluginSpringCtx;
import org.interpss.vstab.eigen.EigenAnalysis;
import org.interpss.vstab.eigen.impl.EigenAnalysisImpl;
import org.junit.Test;

import com.interpss.common.util.IpssLogger;
import com.interpss.core.aclf.AclfNetwork;

public class VS_Ieee14_TestCase extends BaseTestSetup {
	@Test 
	public void testCase1() throws Exception {
		IODMPSSAdapter adapter = new IeeeCDFAdapter(IpssLogger.getLogger());
		adapter.parseInputFile("testdata/ieee_cdf/Ieee14.ieee");
		
		AclfNetwork net = PluginSpringCtx
				.getOdm2AclfMapper()
				.map2Model((AclfModelParser)adapter.getModel())
				.getAclfNet();
//  		System.out.println(net.net2String());
		
		// VStab analysis and test
		EigenAnalysis ea=new EigenAnalysisImpl(net, msg);
		ea.runEigenStrAnalysis();
		System.out.print(ea.getESAResult().getMinEigenValue());
	}
}
