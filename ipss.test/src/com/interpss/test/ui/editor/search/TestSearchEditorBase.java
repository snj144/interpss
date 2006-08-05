package com.interpss.test.ui.editor.search;

import com.interpss.common.SpringAppContext;
import com.interpss.editor.EditorSpringAppContext;
import com.interpss.editor.GEditor;
import com.interpss.editor.form.GFormContainer;
import com.interpss.editor.jgraph.GraphSpringAppContext;
import com.interpss.editor.jgraph.IpssGraph;
import com.interpss.editor.jgraph.IpssModel;
import com.interpss.editor.ui.SimuAppSpringAppCtxUtil;
import com.interpss.editor.ui.edit.NBProjectEditDialog;

import junit.extensions.jfcunit.*;

public class TestSearchEditorBase extends JFCTestCase {
	NBProjectEditDialog projDialog = null;
	GFormContainer netContainer = null;
	GEditor editor = null; 

    protected void setUp( ) throws Exception {
        super.setUp( );        // Choose the text Helper
        
        setHelper( new JFCTestHelper( ) ); // Uses the AWT Event Queue.
        //setHelper( new RobotTestHelper( ) ); // Uses the OS Event Queue.        

        if (SpringAppContext.SpringAppCtx == null) {
			SpringAppContext.SpringAppCtxConfigXmlFile = "properties/geditor/applicationContext.xml";
			EditorSpringAppContext.springAppContextSetup();
        }
 		
		editor = (GEditor)GraphSpringAppContext.getIpssGraphicEditor(); 

		projDialog = (NBProjectEditDialog)SimuAppSpringAppCtxUtil.getProjectDataEditor(
				netContainer, editor.getAppSimuContext().getProjData(), false);

        IpssGraph graph = editor.getIpssGraph();
        IpssModel model = graph.getIpssModel();
		if (model.getProjIdLabel() == null)
			model.insertProjIdLabel(graph);
		graph.setSelectionCell(model.getProjIdLabel());
		netContainer = (GFormContainer)model.getGFormContainer();
	}

	protected void tearDown( ) throws Exception {
	    projDialog = null;
		editor.getRootFrame().dispose();
	    TestHelper.cleanUp( this );
	    super.tearDown( );
	}
}

