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

package org.ieee.pes.odm.pss.adapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Logger;

import org.ieee.pes.odm.pss.model.IEEEODMPSSModelParser;

public abstract class AbstractODMAdapter implements IODMPSSAdapter {
	protected boolean status;
	protected Logger logger;
	protected List<String> errMsgList;
	private IEEEODMPSSModelParser parser;
	
	public AbstractODMAdapter() {
	}
	
	@Override
	public List<String> errMessages() {
		return errMsgList;
	}

	@Override
	public boolean parseXmlFile(String filename) {
		try {
			final File file = new File(filename);
			final InputStream stream = new FileInputStream(file);
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

	@Override
	public IEEEODMPSSModelParser getModel() {
		return this.parser;
	}
	
	abstract protected IEEEODMPSSModelParser parseInputFile(
				final java.io.BufferedReader din)
				throws Exception;
}