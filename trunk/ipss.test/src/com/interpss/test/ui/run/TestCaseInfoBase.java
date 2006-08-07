package com.interpss.test.ui.run;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.TestHelper;

import com.interpss.common.SpringAppContext;
import com.interpss.editor.EditorSpringAppContext;
import com.interpss.editor.SimuAppSpringAppContext;
import com.interpss.editor.app.AppSimuContextImpl;
import com.interpss.editor.jgraph.GraphSpringAppContext;
import com.interpss.editor.jgraph.ui.form.IGFormContainer;
import com.interpss.test.TestConstants;

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
        netContainer = GraphSpringAppContext.getEditorFormContainer();
	}

	protected void tearDown( ) throws Exception {
	    TestHelper.cleanUp( this );
	    super.tearDown( );
	}
}

