/**
 * A Project has a list of Cases, where study case info are stored
 */

package com.interpss.editor.jgraph.ui.app;

import javax.swing.JPopupMenu;

import com.interpss.editor.jgraph.ui.data.IProjectData;

public interface IAppSimuContext {
	void reset();
	void releaseResource();
	
	Object getSimuCtx();
	void setSimuCtx(Object ctx);
	boolean isSimuNetDataDirty();
	void setSimuNetDataDirty(boolean b);
	
	IProjectData getProjData();
	void setProjData(IProjectData info);
	
	boolean isLfConverged();
	void setLfConverged(boolean b);

	boolean isScCalculated();
	void setScCalculated(boolean scCalculated);
   
	String getCurrentCaseName(String caseType);

	int getLastRunType();
	void setLastRunType(int lastRunType);	
	boolean hasLastRun();	
	
	void addPopupMenuAction(JPopupMenu menu, final Object cell);
}