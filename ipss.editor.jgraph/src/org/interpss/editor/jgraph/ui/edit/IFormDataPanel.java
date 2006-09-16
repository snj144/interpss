 /*
  * @(#)IFormDataPanel.java   
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

package org.interpss.editor.jgraph.ui.edit;


/**
*	Common functions for Net, Bus and Branch editor to handle form data
*/

public interface IFormDataPanel {
	/**
	*	For performance reason, editor objects are static member of the 
	*   CellEditorFactory or other factory. This method is for init the editor for the form
	* 	object to be edtied
	*
	* @param container the Container object for the form object
	* @param form the form object to be edited
	*/
	void init(Object container, Object form);
	
	/**
	*	Set form data to the editor
	*
	* @return false if there is any problem
	*/
	boolean setForm2Editor();

	
	/**
	*	Save editor screen data to the form
	*
	* @param errMsg error messages during the saving process.
	* @return false if there is any problem
	*/
	boolean saveEditor2Form(java.util.Vector errMsg) throws Exception;
}