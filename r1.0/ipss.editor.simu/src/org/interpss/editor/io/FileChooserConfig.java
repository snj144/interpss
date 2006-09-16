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

package org.interpss.editor.io;

import java.io.File;
import java.util.List;

import javax.swing.JFileChooser;

import org.interpss.editor.report.IpssRptViewer;

import com.interpss.simu.io.IpssFileAdapter;

public class FileChooserConfig {
	public static String CurrentProjDir = "C:/eclipse/Interpss/ipss.test/testData/editor.jgraph/";
	
	private static JFileChooser openProjFileChooser = null;
	private static JFileChooser saveProjFileChooser = null;

	private static JFileChooser openRptFileChooser = null;
	private static JFileChooser saveRptFileChooser = null;
	
	public static final String GraphFileExt = "ipss";
	public static final String GraphFileExtDesc = "InterPSS Graphic Format";

	/**
	 * Get a file chooser for open file menu
	 * 
	 * @param adapterList custom adapter list defined in the SpingAppContext
	 * @return the chooser
	 */
	public static JFileChooser getOpenProjFileChooser(List adapterList) {
		if (openProjFileChooser == null) {
			openProjFileChooser = new JFileChooser();
			for (int i = 0; i < adapterList.size(); i++) {
				IpssFileAdapter adapter = (IpssFileAdapter)adapterList.get(i);
				openProjFileChooser.addChoosableFileFilter(
						new FileFilter(adapter.getExtension(), adapter.getDescription()));
			}
			openProjFileChooser.addChoosableFileFilter(new FileFilter(GraphFileExt, GraphFileExtDesc));
		}
		openProjFileChooser.setCurrentDirectory(new File(CurrentProjDir));
    	return openProjFileChooser;
	}	
	
	/**
	 * Get a file chooser for open report file menu
	 * 
	 * @return the chooser
	 */
	public static JFileChooser getOpenReportFileChooser() {
		if (openRptFileChooser == null) {
			openRptFileChooser = new JFileChooser();
			openRptFileChooser.addChoosableFileFilter(new FileFilter(IpssRptViewer.REPORT_EXT, IpssRptViewer.REPORT_DESC));
		}
		openRptFileChooser.setCurrentDirectory(new File(IpssRptViewer.REPORT_DEFAULT_DIR));
    	return openRptFileChooser;
	}	

	/**
	 * Get a file chooser for save file menu
	 * 
	 * @return the chooser
	 */
	public static JFileChooser getSaveProjFileChooser() {
		if (saveProjFileChooser == null) {
			saveProjFileChooser = new JFileChooser();
			saveProjFileChooser.addChoosableFileFilter(new FileFilter(GraphFileExt, GraphFileExtDesc));
		}
		saveProjFileChooser.setCurrentDirectory(new File(CurrentProjDir));
    	return saveProjFileChooser;
	}	
	
	/**
	 * Get a file chooser for save report menu
	 * 
	 * @return the chooser
	 */
	public static JFileChooser getSaveReportFileChooser() {
		if (saveRptFileChooser == null) {
			saveRptFileChooser = new JFileChooser();
			saveRptFileChooser.addChoosableFileFilter(new FileFilter(IpssRptViewer.REPORT_EXT, IpssRptViewer.REPORT_DESC));
		}
		saveRptFileChooser.setCurrentDirectory(new File(IpssRptViewer.REPORT_DEFAULT_DIR));
    	return saveRptFileChooser;
	}	
	
	public static class FileFilter extends javax.swing.filechooser.FileFilter {
		private String fileExt = FileChooserConfig.GraphFileExt;
		private String extDesc = null;

		public FileFilter(String ext, String desc) {
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
}