 /*
  * @(#)IpssFileAdapterBase.java   
  *
  * Copyright (C) 2006-2007 www.interpss.org
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
  * @Date 09/15/2007
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.custom.exchange;

import java.io.File;

import org.ieee.pes.odm.pss.adapter.IODMPSSAdapter;
import org.interpss.mapper.IEEEODMMapper;

import com.interpss.common.exp.InvalidOperationException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.simu.SimuContext;
import com.interpss.simu.io.IpssFileAdapter;

public class IpssFileAdapterBase implements IpssFileAdapter{
	private String name;
	private String[] versionList = null;
	private String extension;
	private String description;
	private String fileFilterString;
	private String versionSelected;
	
	protected void loadByODMTransformation(final IODMPSSAdapter adapter, final SimuContext simuCtx, final String filepath, final IPSSMsgHub msg)  throws Exception{
		adapter.parseXmlFile(filepath);
		//System.out.println(adapter.getModel().toString());
		
		IEEEODMMapper mapper = new IEEEODMMapper();
		if (mapper.mapping(adapter.getModel(), simuCtx, SimuContext.class)) {
  	  		simuCtx.setName(filepath.substring(filepath.lastIndexOf(File.separatorChar)+1));
  	  		simuCtx.setDesc("This project is created by input file " + filepath);
		}
		else {
  			msg.sendErrorMsg("Error to load file: " + filepath);
  			IpssLogger.getLogger().severe("Error to load file: " + filepath);
		}
	}
	
	/**
	 * @return the fileFilterString
	 */
	public String getFileFilterString() {
		return fileFilterString;
	}

	/**
	 * @param fileFilterString the fileFilterString to set
	 */
	public void setFileFilterString(String fileFilterString) {
		this.fileFilterString = fileFilterString;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the versionList
	 */
	public String[] getVersionList() {
		return versionList;
	}

	/**
	 * @param versionList the versionList to set
	 */
	public void setVersionList(String[] versionList) {
		this.versionList = versionList;
	}

	public String getExtension() {
		return extension;
	}
	
	public void setExtension(String s) {
		extension = s;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String s) {
		description = s;
	}

	public void load(SimuContext simuCtx, String filepath, IPSSMsgHub msg) throws Exception {
		throw new InvalidOperationException("Load need to implemented");
	}

	public SimuContext load(String filepath, IPSSMsgHub msg) throws Exception {
		throw new InvalidOperationException("Load need to implemented");
	}

	public boolean save(String filepath, SimuContext net, IPSSMsgHub msg) throws Exception {
		throw new InvalidOperationException("Save need to implemented");
	}

	/**
	 * @return the versionSelected
	 */
	public String getVersionSelected() {
		return versionSelected;
	}

	/**
	 * @param versionSelected the versionSelected to set
	 */
	public void setVersionSelected(String versionSelected) {
		this.versionSelected = versionSelected;
	}
}