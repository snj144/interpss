 /*
  * @(#)FileAdapter_PTIFormat.java   
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

package org.interpss.custom.exchange;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.ieee.odm.adapter.IODMPSSAdapter;
import org.ieee.odm.adapter.v07.psse.v26.PSSEV26Adapter;
import org.ieee.odm.adapter.v07.psse.v30.PSSEV30Adapter;
import org.interpss.custom.exchange.impl.PSSEFormat_in;
import org.interpss.custom.exchange.psse.PSSEDataRec;
import org.interpss.mapper.odm.IEEEODMMapper;

import com.interpss.common.exp.InvalidOperationException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.PerformanceTimer;
import com.interpss.ext.psse.aclf.PSSEAclfNetwork;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;


public class FileAdapter_PTIFormat extends IpssFileAdapterBase {
	private PSSEDataRec.VersionNo version = PSSEDataRec.VersionNo.NotDefined;
	
	public FileAdapter_PTIFormat(PSSEDataRec.VersionNo version, IPSSMsgHub msgHub) {
		super(msgHub);
		this.version = version;
	}

	public FileAdapter_PTIFormat(IPSSMsgHub msgHub) {
		super(msgHub);
	}	
	
	/**
	 * Load the data in the data file, specified by the filepath, into the SimuContext object. An AclfAdjNetwork
	 * object will be created to hold the data for loadflow analysis.
	 * 
	 * @param simuCtx the SimuContext object
	 * @param filepath full path path of the input file
	 * @param msg the SessionMsg object
	 */
	@Override
	public void load(final SimuContext simuCtx, final String filepath) throws Exception{
		if (this.version == PSSEDataRec.VersionNo.PSS_E_26 ||
				this.version == PSSEDataRec.VersionNo.PSS_E_30) {
			PerformanceTimer timer = new PerformanceTimer();
			IODMPSSAdapter adapter = this.version == PSSEDataRec.VersionNo.PSS_E_26?
					new PSSEV26Adapter(IpssLogger.getLogger()) :
					new PSSEV30Adapter(IpssLogger.getLogger());
			boolean ok = adapter.parseInputFile(filepath);
			String str = timer.log("Load PSSE data time: ");
			msgHub.sendStatusMsg(str);

	  		if (ok) {
	  			timer.start();
				IEEEODMMapper mapper = new IEEEODMMapper();
				mapper.mapping(adapter.getModel(), simuCtx, SimuContext.class);
				str = timer.log("Map ODM model to SimuCtx tiem: ");			
				msgHub.sendStatusMsg(str);
	  		}
		}
		else {
			if (this.getVersionSelected() != null && !this.getVersionSelected().equals("")) {
				IpssLogger.getLogger().info("PSS/E version: " + this.getVersionSelected());
				if (this.getVersionSelected().contains("30"))
					this.version = PSSEDataRec.VersionNo.PSS_E_30;
				else if (this.getVersionSelected().contains("29"))
					this.version = PSSEDataRec.VersionNo.PSS_E_29;
			}
				
			final File file = new File(filepath);
			final InputStream stream = new FileInputStream(file);
			final BufferedReader din = new BufferedReader(new InputStreamReader(stream));
			
			// load the loadflow data into the AclfAdjNetwork object
			final PSSEAclfNetwork adjNet = PSSEFormat_in.loadFile(din, msgHub, this.version);
			if (adjNet == null)
				return;
	  		// System.out.println(adjNet.net2String());

			// set the simuContext object
	  		simuCtx.setNetType(SimuCtxType.ACLF_ADJ_NETWORK);
	  		simuCtx.setAclfAdjNet(adjNet);
	  		simuCtx.setName(filepath.substring(filepath.lastIndexOf(File.separatorChar)+1));
	  		simuCtx.setDesc("This project is created by input file " + filepath);
		}
	}
	
	/**
	 * Create a SimuContext object and Load the data in the data file, specified by the filepath, into the object. 
	 * An AclfAdjNetwork object will be created to hold the data for loadflow analysis.
	 * 
	 * @param filepath full path path of the input file
	 * @param msg the SessionMsg object
	 * @return the created SimuContext object.
	 */
	@Override
	public SimuContext load(final String filepath) throws Exception{
  		final SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.NOT_DEFINED, msgHub);
  		load(simuCtx, filepath);
  		return simuCtx;
	}
	
	/**
	 * This method is currently not implemented, since the loadflow results are not going to write
	 * back to a data file.
	 */
	@Override
	public boolean save(final String filepath, final SimuContext net) throws Exception{
		throw new InvalidOperationException("FileAdapter_PTIFormat.save not implemented");
	}
}