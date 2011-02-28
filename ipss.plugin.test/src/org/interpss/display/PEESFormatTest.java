package org.interpss.display;

import static org.junit.Assert.assertTrue;

import org.ieee.odm.adapter.IODMAdapter;
import org.ieee.odm.adapter.psse.v30.PSSEV30Adapter;
import org.ieee.odm.model.aclf.AclfModelParser;
import org.interpss.display.impl.AclfOut_PSSE;
import org.interpss.spring.PluginSpringCtx;
import org.junit.Test;

import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algo.AclfMethod;
import com.interpss.core.algo.LoadflowAlgorithm;

public class PEESFormatTest {
	@Test
	public void testCase1() throws Exception {
		IODMAdapter adapter = new PSSEV30Adapter();
		assertTrue(adapter.parseInputFile("testData/psse/PSSE_5Bus_Test.raw"));		
		
		AclfNetwork net = PluginSpringCtx
				.getOdm2AclfMapper()
				.map2Model((AclfModelParser)adapter.getModel())
				.getAclfNet();	
		
	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.setLfMethod(AclfMethod.PQ);
	  	algo.loadflow();
	  	
	  	System.out.println(AclfOutFunc.lfResultsPsseStyle(net, AclfOut_PSSE.Format.GUI));

	  	System.out.println(AclfOutFunc.lfResultsBusStyle(net));
	}
}
