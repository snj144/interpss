/*
 * @(#)EditPaste.java	1.2 02.02.2003
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
package com.interpss.editor.coreframework.actions;

import java.awt.event.ActionEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.TransferHandler;

import org.jgraph.graph.AttributeMap;
import org.jgraph.graph.GraphConstants;

import com.interpss.editor.coreframework.IpssAbstractGraphAction;
import com.interpss.editor.jgraph.cells.AnnotateLabelCell;
import com.interpss.editor.jgraph.cells.BusCell;
import com.interpss.editor.jgraph.cells.LabelCell;
import com.interpss.editor.plugins.gpgraph.GPGraph;

public class EditPaste extends IpssAbstractGraphAction {

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		
		TransferHandler.getPasteAction().actionPerformed(
				new ActionEvent(getCurrentGraph(), e.getID(), e
						.getActionCommand()));
		
		Object[] cells = getCurrentGraph().getSelectionCells();
		for (int i = 0; i < cells.length; i++) {
			if (cells[i] instanceof BusCell){
				BusCell buscell = (BusCell)cells[i];
				buscell.set_labelAnnotate(new AnnotateLabelCell(buscell,buscell.getUserObject()));
				buscell.setLabel(new LabelCell(buscell,buscell.getUserObject()));

				Rectangle2D bounds = GraphConstants.getBounds(buscell.getAttributes());
				
				buscell.insertLabel(getCurrentGraph(), bounds);
				buscell.insertLabelAnnotate(getCurrentGraph(), bounds);
			}
		}
//		getCurrentGraph().startEditingAtCell(getCurrentGraph().getSelectionCell());
	}
}
