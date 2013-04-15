/*
 * @(#)BaseDataFieldParser.java   
 *
 * Copyright (C) 2006-2013 www.interpss.org
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
 * @Date 04/11/2013
 * 
 *   Revision History
 *   ================
 *
 */

package org.ieee.odm.adapter;

import org.ieee.odm.common.ODMException;

/**
 * Base class for parsing input data file string line
 * 
 * @author mzhou
 *
 */
public abstract class BaseDataFieldParser {
	/**
	 * data parser 
	 */
	protected InputLineStringParser dataParser = null;
	
	/**
	 * get the data parser object
	 * 
	 * @return the data parser object
	 */
	public InputLineStringParser getDataParser() { return this.dataParser; }
	
	/**
	 * constructor
	 */
	public BaseDataFieldParser() {
		this.dataParser = new InputLineStringParser();
	}
	
	/**
	 * parse a line in the input file
	 * 
	 * @param str line string
	 */
	abstract public void parseFields(final String str) throws ODMException;
}