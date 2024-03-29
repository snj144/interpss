/*
 * @(#)ToolsShowOverview.java	1.2 01.02.2003
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
package org.interpss.editor.coreframework.actions;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.MissingResourceException;

import javax.swing.JDialog;
import javax.swing.JPanel;

import org.interpss.editor.coreframework.IpssAbstractGraphAction;
import org.interpss.editor.plugins.util.GPOverviewPanel;
import org.interpss.editor.resources.Translator;



public class ToolsShowOverview extends IpssAbstractGraphAction {

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		JDialog overviewDlg = getCurrentDocument().getOverviewDialog();
		//TODO: restore this!
		if (overviewDlg == null) {
			// Create a dialog containing an instance of
			// LibraryPanel.
			try {
				String title = Translator.getString("OverviewFrameTitle");
				overviewDlg = new JDialog(graphpad.getFrame(), title, false);
			} catch (MissingResourceException mre) {
				overviewDlg = new JDialog(graphpad.getFrame(), "Overview", false);
			}

			Container fContentPane = overviewDlg.getContentPane();

			fContentPane.setLayout(new BorderLayout());
			JPanel overviewPanel = GPOverviewPanel.createOverviewPanel(graphpad,graphpad.getCurrentGraph(), getCurrentDocument());
			fContentPane.add(overviewPanel);
			overviewDlg.setSize(new Dimension(180, 180));
			overviewDlg.setLocationRelativeTo(graphpad.getFrame());
			overviewPanel.revalidate();
			getCurrentDocument().setOverviewDialog(overviewDlg);
		}
		overviewDlg.setVisible(true);
	}

}
