/*
 * Created on 05.02.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.interpss.editor.coreframework.jgraphsubclassers;

import java.util.List;

import org.jgraph.graph.AttributeMap;
import org.jgraph.graph.DefaultGraphModel;

import com.interpss.common.util.IpssLogger;
import com.interpss.editor.coreframework.GPUserObject;
import com.interpss.editor.jgraph.ui.IIpssGraphModel;
import com.interpss.editor.jgraph.ui.form.IGBranchForm;
import com.interpss.editor.jgraph.ui.form.IGBusForm;
import com.interpss.editor.jgraph.ui.form.IGFormContainer;
import com.interpss.editor.util.ICellBuisnessObject;


/**
 * The base class JGraph graph model subclassers for GPGraphpad. To use a
 * custom GraphModel subcalsser register your subclass in the graph model
 * factory. As part of the non copyrihted online documentation of JGraph (FAQ
 * section), this file is released here under the LGPL license as stated by the
 * Free Software Fundation.
 * 
 * @see com.interpss.editor.coreframework.GPGraphpadModel
 */
public class GPGraphModel extends DefaultGraphModel implements IIpssGraphModel {

	private IGFormContainer _netContainer = null;

	/* not used any more
	private ProjData projData = null;
	*/
	public GPGraphModel(IGFormContainer container) {
		super();
        this.setGFormContainer(container);
		IpssLogger.getLogger().info("IpssModel object constructed");
	}

	// required for serialization
	public GPGraphModel(List roots, AttributeMap attributes) {
		super(roots, attributes);
	}

	protected Object cloneUserObject(Object userObject) {
		if (userObject instanceof ICellBuisnessObject)
			return ((ICellBuisnessObject) userObject).clone();
		else if (userObject instanceof IGBusForm) {
			return _netContainer.createGBusForm((IGBusForm)userObject);
		}
		else if (userObject instanceof IGBranchForm) {
			return _netContainer.createGBranchForm((IGBranchForm)userObject);
		}
		return super.cloneUserObject(userObject);
	}

	public Object valueForCellChanged(Object cell, Object newValue) {
		Object userObject = getValue(cell);
		if (userObject instanceof GPUserObject && newValue instanceof String) {
			ICellBuisnessObject user = (ICellBuisnessObject) userObject;
			Object oldLabel = String.valueOf(user);
			user.setValue(newValue);
			return oldLabel;
		}

		return super.valueForCellChanged(cell, newValue);
	}

	public void setGFormContainer(IGFormContainer _netContainer) {
		this._netContainer = _netContainer;
	}

	public IGFormContainer getGFormContainer() {
		return _netContainer;
	}

	/* not used anymore
	public ProjData getProjData() { return this.projData; }
	public void setProjData(ProjData info) {
		this.projData = info;
	}
	*/
}

