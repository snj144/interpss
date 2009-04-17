package org.interpss.editor.app;

import java.util.ArrayList;

import org.interpss.editor.doc.IpssProject;



public class AppContext {
	private String workspaceDir = "";
	
	private ArrayList<IpssProject> projList = new ArrayList<IpssProject>();

	public AppContext() {
		super();
	}

	public void setWorkspaceDir(String workspaceDir) {
		this.workspaceDir = workspaceDir;
	}

	public String getWorkspaceDir() {
		return workspaceDir;
	}

	public IpssProject[] getAllProjects() {

		if (projList != null && projList.size() > 0) {
			 return projList.toArray(new IpssProject[projList.size()]);
//			return (IpssProject[]) projList.toArray();
		}
		return null;
	}

	public int getProjectCount() {
		return projList.size();
	}
	
	public void addProject(IpssProject p) {
		projList.add(p);
	}

	public void removeProject(IpssProject p) {
		projList.remove(p);
	}
}
