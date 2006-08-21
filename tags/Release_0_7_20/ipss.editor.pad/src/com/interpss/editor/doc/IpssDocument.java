package com.interpss.editor.doc;

import javax.swing.JComponent;

import com.interpss.editor.SimuAppSpringAppContext;
import com.interpss.editor.data.proj.ProjData;
import com.interpss.editor.jgraph.ui.app.IAppSimuContext;
import com.interpss.editor.jgraph.ui.data.IProjectData;
import com.interpss.editor.util.Utilities;

public abstract class IpssDocument extends JComponent{
	 
    private IpssProject project;
    
	private IAppSimuContext appsimu = null;

	protected boolean modified = false;
	
	public IpssDocument() {
		super();
		this.appsimu = SimuAppSpringAppContext.getAppSimuContext();
		appsimu.reset();
	}

	public void setProject(IpssProject project) {
		this.project = project;
	}

	public IpssProject getProject() {
		return project;
	}
	
	
    public String getFileName(){
    	return Utilities.getFileName(getName());
    }
    
	public void setSimuAppContext(IAppSimuContext aContext) {
		this.appsimu=aContext;
	}

    public IAppSimuContext getSimuAppContext() {
		return appsimu;
	}

	public IProjectData getProjData() {
		return appsimu.getProjData();
	}
	
	public void setProjData(ProjData info) {
		appsimu.setProjData(info);
	}
	
	public boolean isModified() {
		return modified;
	}
	
	public void setModified(boolean dirty) {
		this.modified = dirty;
	}
   
}
