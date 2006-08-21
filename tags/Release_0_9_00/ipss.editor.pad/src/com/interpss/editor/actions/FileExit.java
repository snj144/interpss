/*
 * @(#)FileExit.java	1.2 30.01.2003
 *
 * Copyright (C) 2001-2004 Gaudenz Alder
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 *
 */
package com.interpss.editor.actions;

import java.awt.event.ActionEvent;

import com.interpss.editor.EditorSpringAppContext;
import com.interpss.editor.coreframework.IpssAbstractActionDefault;
import com.interpss.editor.coreframework.IpssEditorDocument;
import com.interpss.editor.doc.IpssProject;
import com.interpss.editor.doc.IpssProjectItem;

public class FileExit extends IpssAbstractActionDefault {

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		getGraphpad().expendTree2Object(graphpad.getCurrentDocument());
		IpssProjectItem aitem = graphpad.getCurrentProjectItem();

		IpssProjectItem[] items = graphpad.getAllOpenProjectItem();

		graphpad.getCommand("FileCloseAllOpenItem").actionPerformed(e);

		if ((items != null) && (items.length > 0))
			for (int i = 0; i < items.length; i++) {
				if (items[i].equals(aitem))
					items[i].setInit_Status(IpssProjectItem.STATUS_ACTIVE);
				else
					items[i].setInit_Status(IpssProjectItem.STATUS_OPEN);
			}
		// Save projects
		IpssProject[] projects = EditorSpringAppContext.getAppContext()
				.getAllProjects();
		if ((projects != null) && (projects.length > 0))
			for (int i = 0; i < projects.length; i++)
				graphpad.saveProject(projects[i]);

		graphpad.exit();
	}

	/**
	 * Empty implementation. This Action should be available each time.
	 */
	public void update() {
	};
}
