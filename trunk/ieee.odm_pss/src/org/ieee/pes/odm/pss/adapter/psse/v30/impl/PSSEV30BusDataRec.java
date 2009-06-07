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
import org.ieee.pes.odm.pss.adapter.psse.v30.PSSEV30Adapter.VersionNo;
import org.ieee.pes.odm.pss.model.DataSetter;
import org.ieee.pes.odm.pss.model.ODMModelParser;

public class PSSEV30BusDataRec {
	/*
	 * BusData Format: I, ’NAME’, BASKV, IDE, GL, BL, AREA, ZONE, VM, VA, OWNER
	 */
	public static void procLine(String lineStr, VersionNo version, ODMModelParser parser, Logger logger) {
		int i, ide, area = 1, zone = 1, owner = 1;
		String name;
		double baseKv, gl = 0.0, bl = 0.0, vm = 1.0, va = 0.0;

		StringTokenizer st;

		st = new StringTokenizer(lineStr, ",");
		i = new Integer(st.nextToken().trim()).intValue();
		name = st.nextToken().trim();

		baseKv = new Double(st.nextToken().trim()).doubleValue();
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

/*
		Format: I,    ’NAME’,    BASKV, IDE,  GL,      BL,  AREA, ZONE, VM, VA, OWNER
*/
		String iStr = ODMModelParser.BusIdPreFix+i;
		BusRecordXmlType busRec;
		try {
			busRec = parser.addNewBaseCaseBus(iStr);
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
        	DataSetter.setYData(busData.addNewShuntY(), gl*factor, bl*factor, YUnitType.PU);
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
}
