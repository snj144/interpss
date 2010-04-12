package org.interpss.editor.coreframework.actions.celltoolboxes;

import org.interpss.editor.coreframework.GPDocument;
import org.interpss.editor.form.GBusForm;
import org.interpss.editor.jgraph.cells.BusCell;
import org.interpss.editor.jgraph.ui.form.IGBusForm;
import org.jgraph.graph.GraphCell;


public class ToolBoxBus extends AbstractDefaultVertexnPortsCreator {
	
	public byte getBusOrientation(){
		return GBusForm.V_Orientation;
	}
	
	public GraphCell createCell() {
		GPDocument doc = getCurrentDocument();

		IGBusForm busForm = doc.getGFormContainer().createGBusForm();
		busForm.setOrientation(getBusOrientation());
		return new BusCell(busForm);
	}

	public void actionForCell(GraphCell cell) {
		graphpad.getCurrentGraph().startEditingAtCell(cell);
	}
}
