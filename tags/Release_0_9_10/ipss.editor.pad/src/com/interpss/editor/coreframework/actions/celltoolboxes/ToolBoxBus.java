package com.interpss.editor.coreframework.actions.celltoolboxes;

import org.interpss.editor.form.GBusForm;
import org.jgraph.graph.GraphCell;

import com.interpss.editor.coreframework.GPDocument;
import com.interpss.editor.jgraph.cells.BusCell;
import com.interpss.editor.jgraph.ui.form.IGBusForm;

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
