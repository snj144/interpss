/*
 * @(#)ODMModelParser.java   
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
 * @Date 02/01/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.ieee.odm.model;

/**
 * A Xml parser for the IEEE DOM schema. 
 */

import java.util.Hashtable;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.IDRecordXmlType;

public class ODMModelParser {
	// add "No" to the bus number to create Bus Id
	public static final String BusIdPreFix = "Bus";
	
	public static final String Token_nsPrefix = "pss";
	public static final String Token_nsUrl = "http://www.ieee.org/cmte/psace/oss/odm/pss/Schema/v1";
	
	// bus and branch object cache for fast lookup. 
	protected Hashtable<String,IDRecordXmlType> objectCache = null;
}
