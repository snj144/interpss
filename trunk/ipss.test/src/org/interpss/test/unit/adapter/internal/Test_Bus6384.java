package org.interpss.test.unit.adapter.internal;

import org.interpss.editor.SimuAppSpringAppCtxUtil;
import org.interpss.test.unit.TestBaseAppCtx;

import com.interpss.common.SpringAppContext;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;
import com.interpss.simu.io.IpssFileAdapter;

public class Test_Bus6384 extends TestBaseAppCtx {
	public void testCase1() throws Exception {
  		System.out.println("Test_Bus6384 testCase1 begins ...");
		
  		System.out.println("Start loading data ...");
		IpssFileAdapter adapter = SimuAppSpringAppCtxUtil.getCustomFileAdapter("ipssdat");
		SimuContext simuCtx = adapter.load("testData/ipssdata/BUS6384.ipssdat", SpringAppContext.getIpssMsgHub());
  		System.out.println("End loading data ...");

		AclfNetwork net = simuCtx.getAclfNet();
  		//System.out.println(net.net2String());
  		assertEquals(true, (net.getBusList().size() == 6384));

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.setLfMethod(AclfMethod.PQ_LITERAL);
	  	algo.loadflow(SpringAppContext.getIpssMsgHub());
  		//System.out.println(net.net2String());
	  	
  		assertEquals(true, net.isLfConverged());		
  		
  		System.out.println("Test_Bus6384 testCase1 ends");
	}
}

