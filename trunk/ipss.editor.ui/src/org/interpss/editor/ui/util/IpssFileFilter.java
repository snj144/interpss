 /*
  * @(#)FileChooserConfig.java   
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

package org.interpss.editor.ui.util;

import java.io.File;

public class IpssFileFilter extends javax.swing.filechooser.FileFilter {
	public static String OUTPUT_DEFAULT_DIR = ".";
	
	private String fileExt = "";
	private String extDesc = "";

	public IpssFileFilter(String ext, String desc) {
		this.fileExt = ext;
		this.extDesc = desc;
	}
	
	public boolean accept(File f) {
    	if (f.isDirectory()) {
        	return true;
    	}

    	String extension = getExtension(f);
    	if (extension != null) {
        	if (extension.toLowerCase().equals(this.fileExt)) {
            	return true;
        	} else {
            	return false;
        	}
    	}
    	return false;
	}

	private static String getExtension(File f) {
    	String ext = null;
    	String s = f.getName();
    	int i = s.lastIndexOf('.');
    	if (i > 0 &&  i < s.length() - 1) {
        	ext = s.substring(i+1).toLowerCase();
    	}
    	return ext;
	}
	
	public String getDescription() {
		String desc = "";
		if (extDesc!=null && !extDesc.equals(""))
			desc = extDesc;
		return desc + "(" + "*." + this.fileExt + ")";
	}
}