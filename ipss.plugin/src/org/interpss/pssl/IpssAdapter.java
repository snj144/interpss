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
package org.interpss.pssl;

import org.interpss.custom.IpssFileAdapter;
import org.interpss.custom.exchange.FileAdapter_GEFormat;
import org.interpss.custom.exchange.FileAdapter_IeeeCommonFormat;
import org.interpss.custom.exchange.FileAdapter_PTIFormat;
import org.interpss.custom.exchange.FileAdapter_UCTEFormat;
import org.interpss.custom.exchange.psse.PSSEDataRec;
import org.interpss.custom.ieee_odm.FileAdapter_IEEEODM_Xml;

import com.interpss.common.util.IpssLogger;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.simu.SimuContext;
import com.interpss.simu.pssl.BaseDSL;

public class IpssAdapter extends BaseDSL {
	
	// ================ public methods =======================
	
	public static enum Format { IEEECommonFormat, PSSE, GE_PSLF, UCTE, IEEE_ODM, BPA };
	public static enum PsseVersion { PSSE_30, PSSE_29 };
	
	public static ImportAclfNetDSL importAclfNet(String filename) {
		return new ImportAclfNetDSL(filename);
	}
	

	// ================ private implementation =======================

	public static class ImportAclfNetDSL {
		private String filename;
		private Format format;
		private PSSEDataRec.VersionNo psseVersion;
		public ImportAclfNetDSL(String filename) {
			this.filename = filename;
		}
		
		public ImportAclfNetDSL setFormat(Format format) { this.format = format; return this; }
		public ImportAclfNetDSL setPsseVersion(PSSEDataRec.VersionNo ver) { this.psseVersion = ver; return this; }

		public AclfNetwork load() { 
			try {
				IpssFileAdapter adapter = null;
				if ( this.format == Format.IEEECommonFormat ) {
					adapter = new FileAdapter_IeeeCommonFormat();
				}
				else if ( this.format == Format.PSSE ) {
					adapter = new FileAdapter_PTIFormat(this.psseVersion);
				}
				else if ( this.format == Format.GE_PSLF ) {
					adapter = new FileAdapter_GEFormat();
				}
				else if ( this.format == Format.UCTE ) {
					adapter = new FileAdapter_UCTEFormat();
				}
				else if ( this.format == Format.IEEE_ODM ) {
					adapter = new FileAdapter_IEEEODM_Xml();
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
