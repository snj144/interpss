/*
 * @(#)GPAbstractActionDefault.java	1.2 29.01.2003
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

package org.interpss.editor.coreframework;

import java.util.Map;

import org.jgraph.JGraph;
import org.jgraph.graph.GraphLayoutCache;

/**
 * An abstract GPGraphpad action. The base class for all GPGraphpad actions.
 * Warning: actions to be loaded by GPGraphpad are listed in the settings.xml
 * file. In order you can use it in the GUI, you should also register them in
 * the toolkit propertie file.
 */
public abstract class IpssAbstractGraphAction extends IpssAbstractActionDefault {

	public JGraph getCurrentGraph() {
		return graphpad.getCurrentGraph();
	}

	public GraphLayoutCache getCurrentGraphLayoutCache() {
		return getCurrentDocument().getGraphLayoutCache();
	}

	public void setSelectionAttributes(final Map map) {
		if (graphpad != null && graphpad.getCurrentDocument() != null)
			getCurrentDocument().setSelectionAttributes(map);
	}

	public void setFontSizeForSelection(final float size) {
		if (graphpad != null && graphpad.getCurrentDocument() != null)
			getCurrentDocument().setFontSizeForSelection(size);
	}

	public void setFontStyleForSelection(final int style) {
		if (graphpad != null && graphpad.getCurrentDocument() != null)
			getCurrentDocument().setFontStyleForSelection(style);
	}

	public void setFontNameForSelection(final String fontName) {
		if (graphpad != null && graphpad.getCurrentDocument() != null)
			getCurrentDocument().setFontNameForSelection(fontName);
	}

	public void rotateBusForSelection() {
		if (graphpad != null && graphpad.getCurrentDocument() != null)
			getCurrentDocument().rotateBusForSelection();
	}

	public GPDocument getCurrentDocument() {
		if (graphpad.getCurrentDocument() instanceof GPDocument)
			return (GPDocument) graphpad.getCurrentDocument();
		else
			return null;
	}

	public void update() {
		if (getCurrentDocument() == null)
			setEnabled(false);
		else
			setEnabled(true);
	}
}
