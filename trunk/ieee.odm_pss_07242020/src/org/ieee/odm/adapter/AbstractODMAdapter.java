/*
 * @(#)UCTE_DEFAdapter.java   
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
 * @Date 02/11/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.ieee.odm.adapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.ieee.odm.model.IODMModelParser;

public abstract class AbstractODMAdapter implements IODMPSSAdapter {
	private boolean status;
	private Logger logger;
	private List<String> errMsgList;
	private IODMModelParser parser;
	
	public AbstractODMAdapter() {
	}
	
	public AbstractODMAdapter(Logger logger) {
		this.logger = logger;
		this.status = true;                        
		this.errMsgList = new ArrayList<String>();
	}
	
	public String errMessage() {
		return errMsgList.toString();
	}

	public boolean parseInputStream(InputStream stream) {
		try {
			final BufferedReader din = new BufferedReader(new InputStreamReader(stream));
			this.parser = parseInputFile(din);
		} catch (Exception e) {
			logger.severe(e.toString());
			this.errMsgList.add(e.toString());
			e.printStackTrace();
			return false;
		}
		return status;
	}
	
	public boolean parseInputFile(String filename) {
		try {
			final File file = new File(filename);
			final InputStream stream = new FileInputStream(file);
			return parseInputStream(stream);
		} catch (Exception e) {
			logger.severe(e.toString());
			this.errMsgList.add(e.toString());
			e.printStackTrace();
			return false;
		}
	}

	public boolean parseFileContent(String fileContent){
		try {
			final String[] strList = fileContent.split("\n");
			parseInputFile( new IFileReader() {
				private int cnt = 0;
				public String readLine() throws Exception {
					if (cnt < strList.length)
						return strList[cnt++];
					else
						return null;
				}
			});
		} catch (Exception e) {
			logger.severe(e.toString());
			this.errMsgList.add(e.toString());
			e.printStackTrace();
			return false;
		}
		return status;
	}
	
	public IODMModelParser getModel() {
		return this.parser;
	}
	
	protected IODMModelParser parseInputFile(
			final java.io.BufferedReader din) throws Exception {
		return parseInputFile( new IFileReader() {
			public String readLine() throws Exception {
				return din.readLine();
			}
		});
	}	

	abstract protected IODMModelParser parseInputFile(IFileReader din) throws Exception;
	
	public void logErr(String msg) {
		this.status = false;
		logger.severe(msg);
		this.errMsgList.add(msg);
	}
	
	public Logger getLogger() {
		return this.logger;
	}
}