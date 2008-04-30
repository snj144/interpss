 /*
  * @(#)FileAdapter_GEFormat.java   
  *
  * Copyright (C) 2006-2008 www.interpss.org
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
  * @Date 05/01/2008
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

import org.interpss.custom.exchange.impl.GEFormat_in;

import com.interpss.common.exp.InvalidOperationException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.StringUtil;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class FileAdapter_GEFormat extends IpssFileAdapterBase {
	/**
	 * Load the data in the data file, specified by the filepath, into the SimuContext object. An AclfAdjNetwork
	 * object will be created to hold the data for loadflow analysis.
	 * 
	 * @param simuCtx the SimuContext object
	 * @param filepath full path path of the input file
	 * @param msg the SessionMsg object
	 */
	@Override
	public void load(final SimuContext simuCtx, final String filepath, final IPSSMsgHub msg) throws Exception{
		loadByAdpter(simuCtx, filepath, msg);
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
	public SimuContext load(final String filepath, final IPSSMsgHub msg) throws Exception{
  		final SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.NOT_DEFINED, msg);
  		load(simuCtx, filepath, msg);
  		return simuCtx;
	}
	
	/**
	 * This method is currently not implemented, since the loadflow results are not going to write
	 * back to a data file.
	 */
	@Override
	public boolean save(final String filepath, final SimuContext net, final IPSSMsgHub msg) throws Exception{
		throw new InvalidOperationException("FileAdapter_UCTEFormat.save not implemented");
	}
	
	
	private void loadByAdpter(final SimuContext simuCtx, final String filepath, final IPSSMsgHub msg)  throws Exception{
		final File file = new File(filepath);
		final InputStream stream = new FileInputStream(file);
		final BufferedReader din = new BufferedReader(new InputStreamReader(stream));
		
		final AclfAdjNetwork adjNet = GEFormat_in.loadFile(din, StringUtil.getFileName(filepath), msg);
  		// System.out.println(adjNet.net2String());
	  		
  		if (adjNet != null) {
  			simuCtx.setNetType(SimuCtxType.ACLF_ADJ_NETWORK);
  	  		simuCtx.setAclfAdjNet(adjNet);
  	  		simuCtx.setName(filepath.substring(filepath.lastIndexOf(File.separatorChar)+1));
  	  		simuCtx.setDesc("This project is created by input file " + filepath);
  		}
  		else { 
  			msg.sendErrorMsg("Error to load file: " + filepath);
  			IpssLogger.getLogger().severe("Error to load file: " + filepath);
  		}		
	}
}
