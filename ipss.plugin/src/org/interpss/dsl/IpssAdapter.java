/*
 * @(#)IpssAdapter.java   
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
 * @Date 05/01/2007
 * 
 *   Revision History
 *   ================
 *
 */
package org.interpss.dsl;

import org.interpss.PluginSpringAppContext;
import org.interpss.custom.IpssFileAdapter;

import com.interpss.simu.SimuContext;
import com.interpss.simu.dsl.BaseDSL;

public class IpssAdapter extends BaseDSL {
	public static enum FileType { IEEECommonFormat, PSSE, GE_PSLF, UCTE };
	
	public static ImportFileDSL importFile(String filename) {
		return new ImportFileDSL(filename);
	}
	
	public static class ImportFileDSL {
		private String filename;
		private FileType fileType;
		public ImportFileDSL(String filename) {
			this.filename = filename;
		}
		
		public ImportFileDSL setFileType(FileType type) { this.fileType = type; return this; }

		public Object load() { 
			try {
				IpssFileAdapter adapter = null;
				if ( this.fileType == FileType.IEEECommonFormat ) {
					adapter = PluginSpringAppContext.getCustomFileAdapter("ieee");
				}
				else if ( this.fileType == FileType.PSSE ) {
					adapter = PluginSpringAppContext.getCustomFileAdapter("psse");
				}
				else if ( this.fileType == FileType.GE_PSLF ) {
					adapter = PluginSpringAppContext.getCustomFileAdapter("ge");
				}
				else if ( this.fileType == FileType.UCTE ) {
					adapter = PluginSpringAppContext.getCustomFileAdapter("uct");
				}
				SimuContext simuCtx = adapter.load(this.filename, IpssAdapter.getMsgHub());
				return simuCtx.getAclfNet();				
			} catch (Exception e) {
				IpssAdapter.getMsgHub().sendErrorMsg(e.toString());
			}
			return null; 
		}
	}
}
