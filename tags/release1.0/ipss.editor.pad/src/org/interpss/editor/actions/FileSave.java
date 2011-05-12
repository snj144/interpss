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
package org.interpss.editor.actions;

import java.awt.event.ActionEvent;
import java.io.FileOutputStream;

import org.interpss.editor.coreframework.GPDocument;
import org.interpss.editor.coreframework.IpssAbstractActionDefault;
import org.interpss.editor.coreframework.IpssCustomDocument;
import org.interpss.editor.coreframework.IpssTextDocument;
import org.interpss.editor.coreframework.actions.IpssAbstractGraphActionFile;
import org.interpss.editor.data.proj.ProjData;
import org.interpss.editor.io.ProjectDataDBManager;
import org.interpss.editor.jgraph.GraphSpringAppContext;
import org.interpss.editor.jgraph.ui.app.IAppSimuContext;
import org.interpss.editor.project.IpssCustomDataCodec;
import org.interpss.editor.project.IpssGraphCodec;
import org.interpss.editor.project.IpssTextCodec;

import com.interpss.common.SpringAppContext;
import com.interpss.common.io.DBManager;
import com.interpss.common.io.IProjectDataManager;

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

					// added by Mike
					((GPDocument)getCurrentDocument()).getGFormContainer().setDataDirty(false);
					getCurrentDocument().setModified(false);
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