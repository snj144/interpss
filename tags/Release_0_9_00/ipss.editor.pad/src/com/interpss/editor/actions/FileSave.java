/*
 * Copyright (C) 2001-2004 Gaudenz Alder
 *
 * GPGraphpad is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * GPGraphpad is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with GPGraphpad; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 *
 */
package com.interpss.editor.actions;

import java.awt.event.ActionEvent;
import java.io.FileOutputStream;

import com.interpss.common.SpringAppContext;
import com.interpss.common.io.DBManager;
import com.interpss.common.io.IProjectDataManager;
import com.interpss.editor.coreframework.GPDocument;
import com.interpss.editor.coreframework.IpssAbstractActionDefault;
import com.interpss.editor.coreframework.IpssCustomDocument;
import com.interpss.editor.coreframework.IpssTextDocument;
import com.interpss.editor.coreframework.actions.IpssAbstractGraphActionFile;
import com.interpss.editor.data.proj.ProjData;
import com.interpss.editor.io.ProjectDataDBManager;
import com.interpss.editor.jgraph.GraphSpringAppContext;
import com.interpss.editor.jgraph.ui.app.IAppSimuContext;
import com.interpss.editor.project.IpssCustomDataCodec;
import com.interpss.editor.project.IpssGraphCodec;
import com.interpss.editor.project.IpssTextCodec;

/**
 * Action opens a dialog to select the file. After that the action saves the
 * current graph to the selected file.
 */
public class FileSave extends IpssAbstractActionDefault {

	public void actionPerformed(ActionEvent e) {
		{
			String fileName = getCurrentDocument().getName();
			if (fileName == null) {
				// graphpad.getCommand("FileSaveAs").actionPerformed(e);
				return;
			}
			try {
				if (graphpad.getCurrentDocument() instanceof GPDocument) {
					IpssGraphCodec.getInstance(graphpad).write(
							new FileOutputStream(fileName),
							(GPDocument)getCurrentDocument());
					getCurrentDocument().setModified(false);
					// added by Mike
					((GPDocument)getCurrentDocument()).getGFormContainer().setDataDirty(false);

					IAppSimuContext appSimuCtx = GraphSpringAppContext
							.getIpssGraphicEditor().getCurrentAppSimuContext();
					if (appSimuCtx.getProjData().isDirty()) {
                        /* following modefied by Mike 07/31/06 */
						IProjectDataManager projManager = SpringAppContext
								.getProjectDataDBManager();
						projManager.saveProjectDataToDB(getCurrentDocument().getProjData());
						// added by Mike
						getCurrentDocument().getProjData().setDirty(false);
					}
				}
				else if (graphpad.getCurrentDocument() instanceof IpssCustomDocument)
				{
					// Richard, we should allow user modified Custom doc and save

					IpssCustomDataCodec.getInstance(graphpad).write(
							new FileOutputStream(fileName),
							(IpssCustomDocument)getCurrentDocument());
					getCurrentDocument().setModified(false);

					
					IAppSimuContext appSimuCtx = GraphSpringAppContext
							.getIpssGraphicEditor().getCurrentAppSimuContext();
					if (appSimuCtx.getProjData().isDirty()) {
						IProjectDataManager projManager = SpringAppContext
							.getProjectDataDBManager();
						projManager.saveProjectDataToDB(getCurrentDocument().getProjData());
						getCurrentDocument().getProjData().setDirty(false);
					}
				}
				else if (graphpad.getCurrentDocument() instanceof IpssTextDocument)
				{
					IpssTextCodec.getInstance(graphpad).write(
							new FileOutputStream(fileName),
							(IpssTextDocument)getCurrentDocument());
					getCurrentDocument().setModified(false);
				}
				graphpad.saveProject(getCurrentDocument().getProject());

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public void update() {
		if (graphpad.getCurrentDocument() == null)
			setEnabled(false);
		else if (graphpad.getCurrentDocument() instanceof GPDocument)
			setEnabled(true);
		else if (graphpad.getCurrentDocument() instanceof IpssCustomDocument)
			setEnabled(true);
		else if (graphpad.getCurrentDocument() instanceof IpssTextDocument)
			setEnabled(true);
		else
			setEnabled(false);
	}
}
