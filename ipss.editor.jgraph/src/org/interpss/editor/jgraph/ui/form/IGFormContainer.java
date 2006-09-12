 /*
  * @(#)IGFormContainer.java   
  *
  * Copyright (C) 2006 www.interpss.org
  *
  * This program is free software; you can redistribute it and/or
  * modify it under the terms of the GNU LESSER GENERAL PUBLIC LICENSE
  * as published by the Free Software Foundation; either version 2.1
  * of the License, or (at your option) any later version.
  *
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  *
  * @Author Mike Zhou
  * @Version 1.0
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

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