 /*
  * @(#)FileAdapter_UCTEFormat.java   
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
  * @Date 02/01/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.custom.dep.ieee_odm;

import java.io.File;

import org.ieee.odm.model.dep.xbean.XBeanODMModelParser;
import org.interpss.custom.dep.exchange.IpssFileAdapterBase;
import org.interpss.mapper.odm.dep.IEEEODMMapper;

import com.interpss.common.exp.InvalidOperationException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class FileAdapter_IEEEODM_Xml extends IpssFileAdapterBase {
	public FileAdapter_IEEEODM_Xml(IPSSMsgHub msgHub) {
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
		final File xmlFile = new File(filepath);
		XBeanODMModelParser parser = new XBeanODMModelParser();
		parser.parse(xmlFile);
		IEEEODMMapper<XBeanODMModelParser> mapper = new IEEEODMMapper<XBeanODMModelParser>(msgHub);
		if (mapper.map2Model(parser, simuCtx)) {
  	  		simuCtx.setName(filepath.substring(filepath.lastIndexOf(File.separatorChar)+1));
  	  		simuCtx.setDesc("This project is created by input file " + filepath);
		}
		else {
			this.msgHub.sendErrorMsg("Error to load file: " + filepath);
  			IpssLogger.getLogger().severe("Error to load file: " + filepath);
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
  		final SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.NOT_DEFINED, this.msgHub);
  		load(simuCtx, filepath);
  		return simuCtx;
	}
	
	/**
	 * This method is currently not implemented, since the loadflow results are not going to write
	 * back to a data file.
	 */
	@Override
	public boolean save(final String filepath, final SimuContext net) throws Exception{
		throw new InvalidOperationException("FileAdapter_UCTEFormat.save not implemented");
	}
}
