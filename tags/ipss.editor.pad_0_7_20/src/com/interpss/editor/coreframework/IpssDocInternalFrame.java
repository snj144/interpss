/*
 * Copyright (C) 2001-2004 Gaudenz Alder
 * 
 * 6/01/2006: I, Raphpael Valyi, changed back the header of this file to LGPL
 * because nobody changed the file significantly since the last
 * 3.0 version of GPGraphpad that was LGPL. By significantly, I mean: 
 *  - less than 3 instructions changes could honnestly have been done from an old fork,
 *  - license or copyright changes in the header don't count
 *  - automaticaly updating imports don't count,
 *  - updating systematically 2 instructions to a library specification update don't count.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 *
 */
package com.interpss.editor.coreframework;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

import javax.swing.JInternalFrame;
import javax.swing.border.EmptyBorder;


import com.interpss.editor.project.IpssIconFactory;
import com.interpss.editor.resources.LocaleChangeAdapter;
import com.interpss.editor.util.PositionManager;


/**
 * The graphpad internal frame is a container for one GPDocument.
 * There is a split between a document and
 * the joint internal frame, so that you can use
 * the document without using internal frames.
 */
public class IpssDocInternalFrame extends com.interpss.editor.util.InternalFrame{

	/** A link to the Graphpad Document of this frame
	 */
	IpssEditorDocument document;

	/**
	 * Constructor for GPDocFrame.
	 */
	public IpssDocInternalFrame(IpssEditorDocument document) {
		super(document.getFrameTitle(), true, true, true, true);
		this.setFrameIcon(IpssIconFactory.getIconbyClass(document));
		this.document = document;
		this.document.setInternalFrame(this);
		this.getContentPane().add(document);
		this.addVetoableChangeListener(new GPVetoableListner(document));
		
		((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		this.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE); 
		this.setBorder(new EmptyBorder(0, 0, 0, 0));
	}

	/**
	 * Returns the document.
	 * @return GPDocument
	 */
	public IpssEditorDocument getDocument() {
		return document;
	}

	/**
	 * Sets the document.
	 * @param document The document to set
	 */
	public void setDocument(IpssEditorDocument document) {
		this.remove(this.document);
		this.document = document;
		this.add(this.document);
	}
	
	/**
	 * 
	 * Cleans up references that cause memory leaks
	 * Maintainance fix, rather than proper fix
	 */
	public void cleanUp(){
		this.document = null;
		LocaleChangeAdapter.removeContainer(this);
		PositionManager.removeComponent(this);
	}
	

}


class GPVetoableListner implements VetoableChangeListener {

	IpssEditorDocument document;

	GPVetoableListner(IpssEditorDocument doc) {
		this.document = doc;
	}

	public void vetoableChange(PropertyChangeEvent evt)
		throws PropertyVetoException {
		if (evt.getPropertyName() != JInternalFrame.IS_CLOSED_PROPERTY)
			return;

		if (((Boolean)evt.getNewValue()).booleanValue() && document.close(true)){
				document.getGraphpad().removeDocument(document);
		} else {
			throw new PropertyVetoException("Can't close the Internal Frame", evt) ;
		}
	}

}
