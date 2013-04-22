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
public class GEOwnerDataParser extends BaseGEDataParser {
	@Override public String[] getMetadata() {
		/*
		 * V15
		 * 
		 * 		<owner no> <"oname"> <"s name"> <net_mw> <net_mvar> <sch_mw> <sch_mvar> <ar>
		 */
		return new String[] {
		   //  0----------1----------2----------3----------4
		     "owner_no", "oname",  "s_name",  "net_mw",  "net_mvar",    
		   //  5            6          7
		     "sch_mw",   "sch_mvar",  "ar" 
		};
	}
	
	@Override public void parseFields(final String str) throws ODMException {
	}
}