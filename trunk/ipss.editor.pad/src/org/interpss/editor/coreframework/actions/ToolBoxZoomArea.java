/*
 * @(#)ToolBoxZoomArea.java	1.2 05.02.2003
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

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.JToggleButton;

import org.interpss.editor.coreframework.GPBarFactory;
import org.interpss.editor.coreframework.IpssAbstractGraphAction;


public class ToolBoxZoomArea extends IpssAbstractGraphAction {
    
	private JToggleButton button = new JToggleButton() {
        public float getAlignmentY() {
            return 0.5f;
        }
    };

    public void actionPerformed(ActionEvent e) {
    }

    public Component getToolComponent(String actionCommand) {

        GPBarFactory.fillToolbarButton(button, getName(), actionCommand);
        return button;
    }

    public void update() {
		super.update();
		this.getButton().setEnabled(isEnabled());
    }
    public JToggleButton getButton() {
        return button;
    }
}
