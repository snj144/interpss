package com.interpss.test.ui.editor.branch;

import com.interpss.common.SpringAppContext;
import com.interpss.editor.EditorSpringAppContext;
import com.interpss.editor.GEditor;
import com.interpss.editor.form.GFormContainer;
import com.interpss.editor.jgraph.GraphSpringAppContext;
import com.interpss.editor.jgraph.IpssGraph;
import com.interpss.editor.jgraph.IpssModel;

import junit.extensions.jfcunit.*;

public class TestBranchEditorBase extends JFCTestCase {
	protected GFormContainer netContainer = null;
	protected GEditor editor = null; 

    protected void setUp( ) throws Exception {
        super.setUp( );        // Choose the text Helper
		
        setHelper( new JFCTestHelper( ) ); // Uses the AWT Event Queue.
        //setHelper( new RobotTestHelper( ) ); // Uses the OS Event Queue.        
        
        if (SpringAppContext.SpringAppCtx == null) {
			SpringAppContext.SpringAppCtxConfigXmlFile = "properties/geditor/applicationContext.xml";
			EditorSpringAppContext.springAppContextSetup();			
        }

		editor = (GEditor)GraphSpringAppContext.getIpssGraphicEditor(); 
		
        IpssGraph graph = editor.getIpssGraph();
        IpssModel model = graph.getIpssModel();
		if (model.getProjIdLabel() == null)
			model.insertProjIdLabel(graph);
		graph.setSelectionCell(model.getProjIdLabel());
		netContainer = (GFormContainer)model.getGFormContainer();
	}

	protected void tearDown( ) throws Exception {
		editor.getRootFrame().dispose();
	    TestHelper.cleanUp( this );
	    super.tearDown( );
	}
}

