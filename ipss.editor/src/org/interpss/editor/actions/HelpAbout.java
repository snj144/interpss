/*
 * @(#)HelpAbout.java	1.2 01.02.2003
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
package org.interpss.editor.actions;

import java.awt.event.ActionEvent;
import java.util.MissingResourceException;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import org.interpss.editor.coreframework.IpssAbstractGraphAction;
import org.interpss.editor.plugins.util.GPAboutDialog;
import org.interpss.editor.resources.ImageLoader;
import org.interpss.editor.resources.Translator;



public class HelpAbout extends IpssAbstractGraphAction {
	private static final long serialVersionUID = 1;

	/** The about dialog for GPGraphpad
	 */
	protected JDialog aboutDlg;

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		if (aboutDlg == null) {
			// Create a frame containing an instance of
			// LibraryPanel.

			String iconName = Translator.getString("Logo");
			ImageIcon logoIcon = ImageLoader.getImageIcon(iconName);

			try {
				String title = Translator.getString("AboutFrameTitle");

				aboutDlg = new GPAboutDialog(graphpad.getFrame(), title, logoIcon);
			} catch (MissingResourceException mre) {
				aboutDlg =
					new GPAboutDialog(
						graphpad.getFrame(),
						"About InterPSS Editor",
						logoIcon);
			}
		}
		aboutDlg.setVisible(true);
	}
	/** Empty implementation.
	 *  This Action should be available
	 *  each time.
	 */
	public void update(){}

}
