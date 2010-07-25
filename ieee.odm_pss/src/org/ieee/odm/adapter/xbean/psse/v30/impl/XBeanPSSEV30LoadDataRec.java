 /*
  * @(#)PSSEV30LoadDataRec.java   
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

package org.ieee.odm.adapter.xbean.psse.v30.impl;

import java.util.StringTokenizer;
import java.util.logging.Logger;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ApparentPowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowLoadDataXmlType;
import org.ieee.odm.adapter.psse.PsseVersion;
import org.ieee.odm.model.xbean.XBeanDataSetter;
import org.ieee.odm.model.xbean.XBeanParserHelper;
import org.ieee.odm.model.xbean.XBeanODMModelParser;

public class XBeanPSSEV30LoadDataRec {
	private static int i, status, area = 1, zone = 1, owner = 1;
	private static String id;
	private static double pl = 0.0, ql = 0.0, ip = 0.0, iq = 0.0, yp = 0.0, yq = 0.0;
	
	/*
	 * LoadData I, ID, STATUS, AREA, ZONE, PL, QL, IP, IQ, YP, YQ, OWNER
	 */	
	public static void procLineString(String lineStr, PsseVersion version, final XBeanODMModelParser parser, Logger logger) {
		procLineString(lineStr, version, logger);
/*
		I, ID, STATUS, AREA, ZONE, PL, QL, IP, IQ, YP, YQ, OWNER
*/		
	    final String busId = XBeanODMModelParser.BusIdPreFix+i;
		BusRecordXmlType busRec = parser.getBusRecord(busId);
	    if (busRec == null){
	    	logger.severe("Bus "+ busId+ " not found in the network");
	    	return;
	    }
		
	    LoadflowLoadDataXmlType contribLoad = XBeanParserHelper.createContriLoad(busRec); 

	    contribLoad.setId(id);
	    contribLoad.setName("Load:" + id + "(" + i + ")");
	    contribLoad.setDesc("PSSE Load " + id + " at Bus " + i);
	    contribLoad.setOffLine(status!=1);

	    contribLoad.setAreaNumber(area);
	    contribLoad.setZoneNumber(zone);
	    contribLoad.addNewOwnerList().addNewOwner().setId(new Integer(owner).toString());
		
		if (pl != 0.0 || ql != 0.0)
			XBeanDataSetter.setPowerData(contribLoad.addNewConstPLoad(), pl, ql, ApparentPowerUnitType.MVA);
		if (ip != 0.0 || iq != 0.0)
			XBeanDataSetter.setPowerData(contribLoad.addNewConstILoad(), ip, iq, ApparentPowerUnitType.MVA);
		if (yp != 0.0 || yq != 0.0)
			XBeanDataSetter.setPowerData(contribLoad.addNewConstZLoad(), yp, yq, ApparentPowerUnitType.MVA);
	}

	private static void procLineString(String lineStr, PsseVersion version, Logger logger) {
		StringTokenizer st;

		st = new StringTokenizer(lineStr, ",");
		i = new Integer(st.nextToken().trim()).intValue();
		id = st.nextToken();
	
		status = new Integer(st.nextToken().trim()).intValue();
		area = new Integer(st.nextToken().trim()).intValue();
		zone = new Integer(st.nextToken().trim()).intValue();
		pl = new Double(st.nextToken().trim()).doubleValue();
		ql = new Double(st.nextToken().trim()).doubleValue();
		ip = new Double(st.nextToken().trim()).doubleValue();
		iq = new Double(st.nextToken().trim()).doubleValue();
		yp = new Double(st.nextToken().trim()).doubleValue();
		yq = new Double(st.nextToken().trim()).doubleValue();
		owner = new Integer(st.nextToken().trim()).intValue();
	}
}
