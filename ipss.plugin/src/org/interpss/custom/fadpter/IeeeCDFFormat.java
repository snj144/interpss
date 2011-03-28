 /*
  * @(#)IeeeCommonFormat.java   
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

package org.interpss.custom.fadpter;

import org.ieee.odm.ODMFileFormatEnum;
import org.ieee.odm.ODMObjectFactory;
import org.ieee.odm.adapter.IODMAdapter;
import org.interpss.custom.fadpter.impl.IpssFileAdapterBase;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.simu.SimuContext;

/**
 *  Custom input file adapter for IEEE Common Format. It loads a data file in the format and create an
 *  AclfAdjNetwork object. The data fields could be positional or separeted by comma  
 */

public class IeeeCDFFormat extends IpssFileAdapterBase {
	
	public IeeeCDFFormat(IPSSMsgHub msgHub) {
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
	public void load(final SimuContext simuCtx, final String filepath, boolean debug) throws Exception{
		//IODMPSSAdapter adapter = new IeeeCDFAdapter(IpssLogger.getLogger());
		IODMAdapter adapter = ODMObjectFactory.createODMAdapter(ODMFileFormatEnum.IeeeCDF);
		loadByODMTransformation(adapter, simuCtx, filepath, msgHub, debug);
	}
	
	/**
	 * Create a SimuContext object and Load the data in the data file, specified by the filepath, into the object. 
	 * An AclfAdjNetwork object will be created to hold the data for loadflow analysis.
	 * 
	 * @param filepath full path path of the input file
	 * @param msg the SessionMsg object
	 * @return the created SimuContext object.
	 */
//	@Override
//	public SimuContext load(final String filepath) throws Exception{
//  		final SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.NOT_DEFINED, msgHub);
//  		load(simuCtx, filepath);
//  		return simuCtx;
//	}
}