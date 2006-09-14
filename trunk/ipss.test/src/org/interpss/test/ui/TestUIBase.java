 /*
  * @(#)TestUIBase.java   
  *
  * Copyright (C) 2006 www.interpss.org
  *
  * This program is free software; you can redistribute it and/or
  * modify it under the terms of the GNU LESSER GENERAL PUBLIC LICENSE
  * as published by the Free Software Foundation; either version 2.1
  * of the License, or (at your option) any later version.
  *
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  *
  * @Author Mike Zhou
  * @Version 1.0
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.test.ui;

import org.interpss.editor.SimuAppSpringAppContext;
import org.interpss.editor.app.AppSimuContextImpl;
import org.interpss.test.TestConstants;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.TestHelper;

import com.interpss.common.SpringAppContext;
import org.interpss.editor.EditorSpringAppContext;
import org.interpss.editor.jgraph.GraphSpringAppContext;
import org.interpss.editor.jgraph.ui.form.IGFormContainer;

public class TestUIBase extends JFCTestCase {
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
		
		// inital project file path
		appSimuCtx.getProjData().setFilepath("c:/tmp/workspace/myproject.ipss");

		netContainer = GraphSpringAppContext.getEditorFormContainer();
	}

	protected void tearDown( ) throws Exception {
	    TestHelper.cleanUp( this );
	    super.tearDown( );
	}
}

