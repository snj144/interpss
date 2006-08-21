package com.interpss.editor.coreframework.actions.celltoolboxes;

import org.jgraph.graph.GraphCell;

import com.interpss.editor.coreframework.GPDocument;
import com.interpss.editor.jgraph.cells.BranchEdge;
import com.interpss.editor.jgraph.ui.form.IGBranchForm;


public class ToolBranchEdge extends AbstractDefaultEdgeCreator {

//	public AttributeMap adaptAttributeMap(GraphCell cell,
//			AttributeMap attributeMap) {
//		GraphConstants.setRouting(attributeMap, GraphConstants.ROUTING_SIMPLE);
//		return attributeMap;
//	}

	public GraphCell createCell() {
		
		GPDocument doc = getCurrentDocument();

		IGBranchForm braForm = doc.getGFormContainer().createGBranchForm();
		return new BranchEdge(braForm);
		
	}

}