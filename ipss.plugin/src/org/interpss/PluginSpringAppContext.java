/*
 * @(#)SimuAppSpringAppContext.java   
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

package org.interpss;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;

import org.interpss.mapper.IpssXmlMapper;
import org.interpss.output.IOutputSimuResult;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Constants;
import com.interpss.common.mapper.IpssMapper;
import com.interpss.simu.io.IpssFileAdapter;

public class PluginSpringAppContext extends SpringAppContext {
	/**
	 * Get the IpssXmlMapper(singleton) from the SpringAppContext.
	 *  
	 * @return the RunForm2AlgorithmMapper object
	 */
	public static IpssMapper getIpssXmlMapper() {
		if (SpringAppCtx == null) // for grid computing
			return new IpssXmlMapper(SpringAppContext.getIpssMsgHub());
		return (IpssMapper) SpringAppCtx.getBean(Constants.SID_IpssXmlMapper);
	}
	
	/**
	 * Get the RunForm2AlgorithmMapper(singleton) from the SpringAppContext.
	 *  
	 * @return the RunForm2AlgorithmMapper object
	 */
	public static IpssMapper getRunForm2AlgorithmMapper() {
		IpssMapper mapper = (IpssMapper) SpringAppCtx.getBean(Constants.SID_RunForm2AlgorithmMapper);
		return mapper;
	}

	public static JDialog getCaseInfoDialog() {
		return (JDialog) SpringAppCtx.getBean(Constants.SID_CaseInfoDialog);
	}

	/**
	 * Get the CustomFileAdapterList(singleton) from the SpringAppContext.
	 *  
	 * @return the CustomFileAdapterList object
	 */
	public static List<IpssFileAdapter> getCustomFileAdapterList() {
		return (List<IpssFileAdapter>) SpringAppCtx.getBean(Constants.SID_CustomFileAdapterList);
	}

	/**
	 * Get the SimuResultOutput(singleton) from the SpringAppContext.
	 *  
	 * @return the CustomFileAdapterList object
	 */
	public static IOutputSimuResult getSimuResultOutput() {
		return (IOutputSimuResult) SpringAppCtx.getBean(Constants.SID_SimuResultOutput);
	}
	
	/**
	 * This method will be retired. Use getCustomFileAdapterByName instead
	 * 
	 * @return the CustomFileAdapter object
	 */
	public static IpssFileAdapter getCustomFileAdapter(String ext) {
		List<IpssFileAdapter> adapterList = getCustomFileAdapterList();
		for (int i = 0; i < adapterList.size(); i++) {
			IpssFileAdapter adapter = (IpssFileAdapter) adapterList.get(i);
			if (ext.equals(adapter.getExtension()))
				return adapter;
		}
		return null;
	}

	/**
	 * Get a CustomFileAdapter(prototype) name list.
	 * 
	 * @return the CustomFileAdapter name list
	 */
	public static Object[] getCustomFileAdapterNameList() {
		List<String> nameList = new ArrayList<String>();
		List<IpssFileAdapter> adapterList = getCustomFileAdapterList();
		for (int i = 0; i < adapterList.size(); i++) {
			IpssFileAdapter adapter = (IpssFileAdapter) adapterList.get(i);
			nameList.add(adapter.getName());
		}
		return nameList.toArray();
	}

	/**
	 * Get a CustomFileAdapter(prototype) name list.
	 * 
	 * @return the CustomFileAdapter name list
	 */
	public static IpssFileAdapter getCustomFileAdapterByName(String name) {
		List<IpssFileAdapter> adapterList = getCustomFileAdapterList();
		for (int i = 0; i < adapterList.size(); i++) {
			IpssFileAdapter adapter = (IpssFileAdapter) adapterList.get(i);
			if (name.equals(adapter.getName()))
				return adapter;
		}
		return null;
	}
}
