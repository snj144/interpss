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
import org.interpss.custom.exchange.FileAdapter_IeeeCommonFormat;

import com.interpss.common.util.IpssLogger;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.simu.SimuContext;
import com.interpss.simu.dsl.BaseDSL;

public class IpssAdapter extends BaseDSL {
	public static enum Format { IEEECommonFormat, PSSE, GE_PSLF, UCTE };
	
	public static ImportAclfNetDSL importAclfNet(String filename) {
		return new ImportAclfNetDSL(filename);
	}
	
	public static class ImportAclfNetDSL {
		private String filename;
		private Format format;
		public ImportAclfNetDSL(String filename) {
			this.filename = filename;
		}
		
		public ImportAclfNetDSL setFormat(Format format) { this.format = format; return this; }

		public AclfNetwork load() { 
			try {
				IpssFileAdapter adapter = null;
				if ( this.format == Format.IEEECommonFormat ) {
					adapter = new FileAdapter_IeeeCommonFormat();
				}
				else if ( this.format == Format.PSSE ) {
					adapter = PluginSpringAppContext.getCustomFileAdapter("psse");
				}
				else if ( this.format == Format.GE_PSLF ) {
					adapter = PluginSpringAppContext.getCustomFileAdapter("ge");
				}
				else if ( this.format == Format.UCTE ) {
					adapter = PluginSpringAppContext.getCustomFileAdapter("uct");
				}
				IpssLogger.getLogger().info("Load file: " + this.filename + " of format " + this.format);
				SimuContext simuCtx = adapter.load(this.filename, IpssAdapter.getMsgHub());
				return simuCtx.getAclfNet();				
			} catch (Exception e) {
				IpssAdapter.getMsgHub().sendErrorMsg(e.toString());
			}
			return null; 
		}
	}
}
