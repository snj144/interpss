package org.interpss.test.ui.run;

import org.interpss.editor.EditorSpringAppContext;
import org.interpss.editor.SimuAppSpringAppContext;
import org.interpss.editor.app.AppSimuContextImpl;
import org.interpss.editor.jgraph.GraphSpringAppContext;
import org.interpss.editor.jgraph.ui.form.IGFormContainer;
import org.interpss.test.TestConstants;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.TestHelper;

import com.interpss.common.SpringAppContext;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.util.sample.SampleCases;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuSpringAppContext;

public class TestCaseInfoBase extends JFCTestCase {
	protected IGFormContainer netContainer = null;
	protected AppSimuContextImpl appSimuCtx = null;

    protected void setUp( ) throws Exception {
        super.setUp( );        // Choose the text Helper
        
        setHelper( new JFCTestHelper( ) ); // Uses the AWT Event Queue.
        //setHelper( new RobotTestHelper( ) ); // Uses the OS Event Queue.        

		if (SpringAppContext.SpringAppCtx == null) {
			SpringAppContext.SpringAppCtxConfigXmlFile = TestConstants.SpringConfigXmlFile;
			EditorSpringAppContext.springAppContextSetup();
		}	
		
		appSimuCtx = (AppSimuContextImpl)SimuAppSpringAppContext.getAppSimuContext(); 
		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		SampleCases.load_LF_5BusSystem(net, SpringAppContext.getIpssMsgHub());
		SimuContext simuCtx = (SimuContext)appSimuCtx.getSimuCtx();
		simuCtx.setNetType(SimuCtxType.ACLF_NETWORK_LITERAL);
		simuCtx.setAclfNet(net);
		simuCtx.setLoadflowAlgorithm(SimuSpringAppContext.getLoadflowAlgorithm());
		
        netContainer = GraphSpringAppContext.getEditorFormContainer();
	}

	protected void tearDown( ) throws Exception {
	    TestHelper.cleanUp( this );
	    super.tearDown( );
	}
}

