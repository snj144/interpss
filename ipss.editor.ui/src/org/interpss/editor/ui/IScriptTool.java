 /*
  * @(#)IScriptTool.java   
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
package org.interpss.editor.ui;

import java.util.Hashtable;
import java.util.List;

public interface IScriptTool {
	/**
	 * Interface to output DStab results a TextBroswer
	 * 
	 * @param textDialog
	 * @param nameList
	 * @param valueList
	 */
	public void outDStabResult2TextDialog(			   
			IOutputTextDialog textDialog,   // out text dialog
			List<String> nameList,          // variable name list
			List<Hashtable<String, String>> valueList);  // var value list);
}
