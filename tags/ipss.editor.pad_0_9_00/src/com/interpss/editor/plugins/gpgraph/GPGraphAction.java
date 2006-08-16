package com.interpss.editor.plugins.gpgraph;

import com.interpss.editor.coreframework.IpssAbstractGraphAction;

public abstract class GPGraphAction extends IpssAbstractGraphAction {

	public GPGraph getCurrentGPGraph() {
		try {
			return (GPGraph) getCurrentGraph();
		} catch (Exception ex) {
			System.err.print("Your graph base class isn't a GPGraph!");
			ex.printStackTrace();
			return null;
		}
	}

}
