 /*
  * @(#)AppContext.java   
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
  * @Date 05/01/2007
  * 
  *   Revision History
  *   ================
  *
  */

/**
 * AppContext class holds the workspace dir and a list of opened project
 */

package org.interpss.editor.app;

import java.util.ArrayList;

import org.interpss.editor.doc.IpssProject;

import com.interpss.common.util.IpssLogger;

public class AppContext {
	private String workspaceDir = "";
	private ArrayList<IpssProject> projList = new ArrayList<IpssProject>();

	public AppContext() {
		super();
	}

	public void setWorkspaceDir(String workspaceDir) {
		IpssLogger.getLogger().info("Workspace set to: " + workspaceDir);
		this.workspaceDir = workspaceDir;
	}

	public String getWorkspaceDir() {
		return workspaceDir;
	}

	public IpssProject[] getAllProjects() {
		if (projList != null && projList.size() > 0) {
			 return projList.toArray(new IpssProject[projList.size()]);
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
