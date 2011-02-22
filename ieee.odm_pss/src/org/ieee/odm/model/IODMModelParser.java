/*
 * @(#)IODMModelParser.java   
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

import java.io.File;
import java.io.InputStream;

import org.ieee.odm.schema.StudyCaseXmlType;

/**
 * A Xml parser for the IEEE DOM schema. 
 */

public interface IODMModelParser {
	boolean parse(File xmlFile);
	
	boolean parse(String xmlString);
	
	boolean parse(InputStream in);
	
	String toXmlDoc(boolean addXsi);
	
	StudyCaseXmlType getStudyCase();
}
