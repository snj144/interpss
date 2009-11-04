 /*
  * @(#)PSSEBusDataRec.java   
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

package org.ieee.pes.odm.pss.adapter.psse.v30.impl;

import java.util.StringTokenizer;
import java.util.logging.Logger;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AngleUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ApparentPowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LFGenCodeEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBusDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.YUnitType;
import org.ieee.pes.odm.pss.adapter.psse.PsseVersion;
import org.ieee.pes.odm.pss.model.DataSetter;
import org.ieee.pes.odm.pss.model.ODMModelParser;

public class PSSEV30BusDataRec {
	private static int i, ide, area = 1, zone = 1, owner = 1;
	private static String name;
	private static double baseKv, gl = 0.0, bl = 0.0, vm = 1.0, va = 0.0;
	
	/*
	 * BusData Format: I, ’NAME’, BASKV, IDE, GL, BL, AREA, ZONE, VM, VA, OWNER
	 *       101743,'TAU 9A,8    ',  13.8000,2,     0.000,     0.000, 101, 101,1.02610, -98.5705,   1

	 */
	public static void procLineString(String lineStr, PsseVersion version, ODMModelParser parser, Logger logger) {
		procFields(lineStr, version);

/*
		Format: I,    ’NAME’,    BASKV, IDE,  GL,      BL,  AREA, ZONE, VM, VA, OWNER
*/
		String iStr = ODMModelParser.BusIdPreFix+i;
		BusRecordXmlType busRec;
		try {
			busRec = parser.addNewBaseCaseBus(iStr, i);
		} catch (Exception e) {
			logger.severe(e.toString());
			return;
		}
		busRec.setNumber(i);
		
		busRec.setAreaNumber(area);
		busRec.setAreaNumber(zone);
		if (owner > 0)
			busRec.addNewOwnerList().addNewOwner().setId(new Integer(owner).toString());
		
		busRec.setName(name);
		DataSetter.setVoltageData(busRec.addNewBaseVoltage(), baseKv, VoltageUnitType.KV);
		
		LoadflowBusDataXmlType busData = busRec.addNewLoadflowData();
		DataSetter.setVoltageData(busData.addNewVoltage(), vm, VoltageUnitType.PU);
		DataSetter.setAngleData(busData.addNewAngle(), va, AngleUnitType.DEG);

    	if (gl != 0.0 || bl != 0.0) {
    		double factor = parser.getBaseCase().getBasePower().getValue();  
    		// for transfer G+jB to PU on system base, gl, bl are entered in MW at one per unit voltage
        	DataSetter.setYData(busData.addNewShuntY(), gl/factor, bl/factor, YUnitType.PU);
    	}
      	
    	// set input data to the bus object
		LFGenCodeEnumType.Enum genType = ide == 3? LFGenCodeEnumType.SWING : 
								( ide == 1? LFGenCodeEnumType.PQ : 
									( ide == 2 ? LFGenCodeEnumType.PV : LFGenCodeEnumType.NONE_GEN ));
		DataSetter.setGenData(busData, genType, vm, VoltageUnitType.PU, va, AngleUnitType.DEG, 
						0.0, 0.0,	ApparentPowerUnitType.MVA);

		if (ide == 1 || ide == 2 || ide == 3) 
			busRec.setOffLine(false);
		else
			busRec.setOffLine(true);
			
	}
	
	private static void procFields(String lineStr, PsseVersion version) {
		StringTokenizer st;

	//	 101743,'TAU 9A,8    ',  13.8000,2,     0.000,     0.000, 101, 101,1.02610, -98.5705,   1
	// -- str1-- ----str2---- -----------str3---------------	
		String str1 = lineStr.substring(0, lineStr.indexOf('\'')),
	           strbuf = lineStr.substring(lineStr.indexOf('\'')+1),
	           str2 = strbuf.substring(0, strbuf.indexOf('\'')),
	           str3 = strbuf.substring(strbuf.indexOf('\'')+1);
	           
		
		st = new StringTokenizer(str1, ",");
		i = new Integer(st.nextToken().trim()).intValue();
		name = str2;

		st = new StringTokenizer(str3, ",");
        String s = st.nextToken().trim();
        if (s.equals(""))   // in case there are spaces between '  ,
            s = st.nextToken().trim();		
		baseKv = new Double(s).doubleValue();
		ide = new Integer(st.nextToken().trim()).intValue();
		if (st.hasMoreTokens())
			gl = new Double(st.nextToken().trim()).doubleValue();
		if (st.hasMoreTokens())
			bl = new Double(st.nextToken().trim()).doubleValue();
		if (st.hasMoreTokens())
			area = new Integer(st.nextToken().trim()).intValue();
		if (st.hasMoreTokens())
			zone = new Integer(st.nextToken().trim()).intValue();
		if (st.hasMoreTokens())
			vm = new Double(st.nextToken().trim()).doubleValue();
		if (st.hasMoreTokens())
			va = new Double(st.nextToken().trim()).doubleValue();
		if (st.hasMoreTokens())
			owner = new Integer(st.nextToken().trim()).intValue();
	}
}
