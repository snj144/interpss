package org.interpss.editor.actions;

import java.awt.event.ActionEvent;

import org.interpss.editor.coreframework.GPDocument;
import org.interpss.editor.coreframework.IpssAbstractActionDefault;
import org.interpss.editor.coreframework.IpssCustomDocument;
import org.interpss.editor.coreframework.IpssEditorDocument;
import org.interpss.editor.io.CustomFileUtility;
import org.interpss.editor.ui.EditorActionAdapter;
import org.interpss.editor.util.DocumentUtilFunc;

import com.interpss.common.SpringAppContext;
import com.interpss.simu.SimuContext;

public class RunAclf extends IpssAbstractActionDefault {
	private static final long serialVersionUID = 1;

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		if (graphpad.isBGProcessingBusy()) {
    		SpringAppContext.getEditorDialogUtil().showWarnMsgDialog("Simulation Thread Busy", 
				"The run-simulation thread is busy. Please wait for its finishing before starting another one.");
			return;
		}	

		IpssEditorDocument doc = getCurrentDocument();
		if (doc instanceof GPDocument) {
			EditorActionAdapter.menu_run_aclf(true, graphpad.getCurrentGraph(), doc);
		} 
		else if (doc instanceof IpssCustomDocument) {
			if (((IpssCustomDocument)doc).getDocFile().isModified()) {
				String filepath = graphpad.getCurrentProject().getProjectPath() + "/" + 
				((IpssCustomDocument)doc).getFileName();
				SimuContext simuCtx = (SimuContext)doc.getSimuAppContext().getSimuCtx();
				if (CustomFileUtility.loadCustomFile(filepath, simuCtx)) {
					EditorActionAdapter.menu_run_aclf(false, null, doc);
					doc.getSimuAppContext().setSimuNetDataDirty(false);
				}	
				else {
					SpringAppContext.getIpssMsgHub().sendWarnMsg("Custom data file loading error, filename: " + filepath);
				}
			} 
			else {
				EditorActionAdapter.menu_run_aclf(false, null, doc);
			}
		}
		// After a run, some menuitems may need to be enabled
		graphpad.update();
	}

	@Override
	public void update() {
		IpssEditorDocument doc = getCurrentDocument();
		setEnabled(DocumentUtilFunc.isAclfDocument(doc) || DocumentUtilFunc.isDStabDocument(doc));
	}
}
