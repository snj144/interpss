package com.interpss.editor.coreframework.actions.celltoolboxes;

import java.awt.geom.Rectangle2D;

import org.jgraph.graph.AttributeMap;
import org.jgraph.graph.GraphCell;
import org.jgraph.graph.GraphConstants;

import com.interpss.editor.coreframework.GPDocument;
import com.interpss.editor.form.base.IUserData;
import com.interpss.editor.jgraph.cells.NetLabelCell;
import com.interpss.editor.jgraph.ui.form.IGNetForm;

public class ToolBoxNetLabel extends AbstractDefaultVertexnPortsCreator {
	
	public GraphCell createCell() {
		GPDocument doc = getCurrentDocument();
		IGNetForm data = doc.getGFormContainer().getGNetForm();
		return new NetLabelCell(null, data);
	}

	public String getCellLabel() {
		return getCurrentDocument().getGFormContainer().getGNetForm().getLabel(IUserData.NET_LABEL);
	}
	/**
	 * You can override how the view attributes of the cell are created
	 * 
	 * @param cell
	 * @param bounds
	 * @return a new attribute map with the defined bounds
	 */
	public AttributeMap getAttributeMap(GraphCell cell,	Rectangle2D bounds) {
		AttributeMap attributeMap = new AttributeMap();
		double scale = graphpad.getCurrentGraph().getScale();
		bounds.setRect(bounds.getX()/scale, bounds.getY()/scale, bounds.getWidth()/scale, bounds.getHeight()/scale);
		bounds = reSize(bounds); // thus we can constraint the bounding box
									// size
		GraphConstants.setBounds(attributeMap, bounds);
		GraphConstants.setOpaque(attributeMap, true);
		GraphConstants.setInset(attributeMap, 40);
	//	GraphConstants.setBorderColor(attributeMap, Color.black);
		GraphConstants.setFont(attributeMap, ((NetLabelCell)cell).getFont());
		return attributeMap;
	}
}
