/*
 * @(#)GEAreaDataParser.java   
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

package org.ieee.odm.adapter.ge.parser;

import org.ieee.odm.common.ODMException;

/**
 * Class for processing IEEE CDF bus data line string
 * 
 * @author mzhou
 *
 */
public class GEInterfaceDataParser extends BaseGEDataParser {
	@Override public String[] getMetadata() {
		/*
		 * V15
		 * 
		 * 		<ifno> <"name"> <pnet> <qnet> <r1> <r2> <r3> <r4> <r5> <r6> <r7> <r8>
		 */
		return new String[] {
		   //  0----------1----------2----------3----------4
		     "arnum",   "arnam",   "swing",  "pnetdes",  "pnettol", 
		   //  5          6   
		     "pnet",    "qnet" 
		};
	}
	
	@Override public void parseFields(final String str) throws ODMException {
	}
}