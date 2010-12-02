package org.interpss.editor.coreframework.actions.celltoolboxes;

import org.interpss.editor.coreframework.GPDocument;
import org.interpss.editor.jgraph.cells.BranchEdge;
import org.interpss.editor.jgraph.ui.form.IGBranchForm;
import org.jgraph.graph.GraphCell;



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
	public void actionForCell(GraphCell cell) {
		graphpad.getCurrentGraph().startEditingAtCell(cell);
	}
}