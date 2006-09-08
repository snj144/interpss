package org.interpss.test.ui.run;

import junit.extensions.jfcunit.TestHelper;

import org.interpss.test.ui.TestUIBase;

import com.interpss.common.SpringAppContext;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.util.sample.SampleCases;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuSpringAppContext;

public class TestCaseInfoBase extends TestUIBase {
    protected void setUp( ) throws Exception {
        super.setUp( );        // Choose the text Helper
        
		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		SampleCases.load_LF_5BusSystem(net, SpringAppContext.getIpssMsgHub());
		SimuContext simuCtx = (SimuContext)appSimuCtx.getSimuCtx();
		simuCtx.setNetType(SimuCtxType.ACLF_NETWORK_LITERAL);
		simuCtx.setAclfNet(net);
		simuCtx.setLoadflowAlgorithm(SimuSpringAppContext.getLoadflowAlgorithm());
	}

	protected void tearDown( ) throws Exception {
	    TestHelper.cleanUp( this );
	    super.tearDown( );
	}
}

