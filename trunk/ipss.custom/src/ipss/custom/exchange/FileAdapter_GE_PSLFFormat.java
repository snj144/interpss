 /*
  * @(#)FileAdapter_GE_PSLFFormat.java   
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

package ipss.custom.exchange;

import com.interpss.common.exp.InvalidOperationException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.simu.SimuContext;
import com.interpss.simu.io.IpssFileAdapterBase;

public class FileAdapter_GE_PSLFFormat extends IpssFileAdapterBase {

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
		throw new InvalidOperationException("FileAdapter_IpssInternalFormat.load not implemented");
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
		throw new InvalidOperationException("FileAdapter_IpssInternalFormat.load not implemented");
	}
	
	/**
	 * This method is currently not implemented, since the loadflow results are not going to write
	 * back to a data file.
	 */
	@Override
	public boolean save(final String filepath, final SimuContext net, final IPSSMsgHub msg) throws Exception{
		throw new InvalidOperationException("FileAdapter_IpssInternalFormat.save not implemented");
	}
}
