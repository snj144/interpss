package org.interpss.editor.jgraph.ui.form;

public interface IGFormContainer {
	void reset();
	
	void removeBusForm(String id);
    IGBusForm getGBusForm(String id);
	
	void removeBranchForm(String id);
    IGBranchForm getGBranchForm(String id);
	
	IGNetForm getGNetForm();
	void setGNetForm(IGNetForm form);
	
	IGBranchForm createGBranchForm();
	IGBranchForm createGBranchForm(IGBranchForm form);
	IGBranchForm addGBranchForm(IGBranchForm form);
	boolean deleteGBranchForm(IGBranchForm form);	
	boolean deleteGBranchForm(String branchid);
		
	IGBusForm createGBusForm();
	IGBusForm createGBusForm(IGBusForm form);
	IGBusForm addGBusForm(IGBusForm form);
	boolean deleteGBusForm(IGBusForm form);
	boolean deleteGBusForm(String busid);
	
	void setDataDirty(boolean b);
	void rebuildRelation();
	
	boolean isDataDirty();
	
	Object xml2Object(String xmlStr, Class klass);
}