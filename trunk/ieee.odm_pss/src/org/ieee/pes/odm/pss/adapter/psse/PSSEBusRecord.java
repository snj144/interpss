/*
 * @(#)PSSEBusRecord.java   
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
 * @Author Stephen Hau, Mike Zhou
 * @Version 1.0
 * @Date 02/11/2008
 * 
 *   Revision History
 *   ================
 *
 */
package org.ieee.pes.odm.pss.adapter.psse;

import java.util.StringTokenizer;
import java.util.logging.Logger;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBusDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ReactivePowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.SwitchedShuntDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageUnitType;
import org.ieee.pes.odm.pss.model.DataSetter;
import org.ieee.pes.odm.pss.model.ODMModelParser;
import org.ieee.pes.odm.pss.model.StringUtil;

public class PSSEBusRecord {
	public static  void processSwitchedShuntData(final String str,final ODMModelParser parser, Logger logger) {
		/*
		I,    MODSW,VSWHI, VSWLO,  SWREM,   BINIT,    N1,      B1,   N2,        B2...N8,B8
		34606,0,    1.1000,0.9000,     0,-190.800,     1, -47.700,     1, -47.700,     1, -47.700,     1, -47.700,    
			I - Bus number
			MODSW - Mode 0 - fixed 1 - discrete 2 - continuous
			VSWHI - Desired voltage upper limit, per unit
			VSWLO - Desired voltage lower limit, per unit
			SWREM - Number of remote bus to control. 0 to control own bus.
			BINIT - Initial switched shunt admittance, MVAR at 1.0 per unit volts
			N1 - Number of steps for block 1, first 0 is end of blocks
			B1 - Admittance increment of block 1 in MVAR at 1.0 per unit volts.
			N2, B2, etc, as N1, B1
		 */		
		// parse the input data line
	    final String[] strAry = getSwitchedShuntDataFields(str);
		final String busId = ODMModelParser.BusIdPreFix+strAry[0];
		// get the responding-bus data with busId
		BusRecordXmlType busRec = parser.getBusRecord(busId);
		if (busRec==null){
			logger.severe("Error: Bus not found in the network, bus number: " + busId);
        	return;
        }
				
	    LoadflowBusDataXmlType lfData = busRec.getLoadflowData();
	    if (lfData == null)
	    	lfData = busRec.addNewLoadflowData();
	    if (lfData.getSwitchedShuntData() == null) {  // there may be multiple contribute switched shunt records on a bus
	    	lfData.addNewSwitchedShuntData().addNewContributeQList();
	    }
	    SwitchedShuntDataXmlType shunt = lfData.getSwitchedShuntData().getContributeQList().addNewSwitchedShunt();
		
		// genId is used to distinguish multiple generations at one bus		
		int mode = StringUtil.getInt(strAry[1], 0);
		shunt.setMode(mode ==0? SwitchedShuntDataXmlType.Mode.FIXED :
						mode ==1? SwitchedShuntDataXmlType.Mode.DISCRETE : 
							SwitchedShuntDataXmlType.Mode.CONTINUOUS);
		
		//VSWHI - Desired voltage upper limit, per unit
		//VSWLO - Desired voltage lower limit, per unit
		final double vmax = StringUtil.getDouble(strAry[2], 1.0);
		final double vmin = StringUtil.getDouble(strAry[3], 1.0);
		DataSetter.setVoltageLimitData(shunt.addNewDesiredVoltageRange(), vmax, vmin, VoltageUnitType.PU);
		
		//SWREM - Number of remote bus to control. 0 to control own bus.
		int busNo = StringUtil.getInt(strAry[4], 0);
		if (busNo != 0) {
			shunt.addNewRemoteControlledBus().setIdRef(ODMModelParser.BusIdPreFix+strAry[4]);
		}
		
		//BINIT - Initial switched shunt admittance, MVAR at 1.0 per unit volts
		final double binit = StringUtil.getDouble(strAry[5], 0.0);
		shunt.setBInit(binit);
		
		double equiQ = 0.0;
		if (lfData.getSwitchedShuntData().getEquivQ() != null)
			equiQ = lfData.getSwitchedShuntData().getEquivQ().getValue();
		DataSetter.setReactivePower(lfData.getSwitchedShuntData().addNewEquivQ(), equiQ+binit, ReactivePowerUnitType.MVAR);
		
		//N1 - Number of steps for block 1, first 0 is end of blocks
		//B1 - Admittance increment of block 1 in MVAR at 1.0 per unit volts. N2, B2, etc, as N1, B1
		for (int i = 0; i < 8; i++) {
	  		String nStr = strAry[6+i*2];
	  		String bStr = strAry[7+i*2];
	  		if (nStr != null) {
	  			int n = StringUtil.getInt(nStr, 0);
	  			double b = StringUtil.getDouble(bStr, 0.0);
	  			SwitchedShuntDataXmlType.Block block = shunt.addNewBlock();
	  			block.setSteps(n);
	  			DataSetter.setReactivePower(block.addNewIncrementB(), b, ReactivePowerUnitType.MVAR);
	  		}
		}
	}

	private static String[] getSwitchedShuntDataFields(final String lineStr) {
		// I,    MODSW,VSWHI, VSWLO,  SWREM,   BINIT,    N1,      B1,   N2,        B2...N8,B8
		final String[] strAry = new String[22];		
  		StringTokenizer st = new StringTokenizer(lineStr, ",");
  		for ( int i = 0; i < 6; i++) 
  	  		strAry[i]=st.nextToken().trim();
  		
  		for ( int i = 0; i < 8; i++) {
  			if (st.hasMoreTokens()) {
  		  		String str = st.nextToken().trim();
  		  		if (!str.trim().equals("")) {
  		  			strAry[6+i*2]=str;
  	  		  		strAry[7+i*2]=st.nextToken().trim();
  		  		}
  			}
  			else {
		  		strAry[6+i*2]=null;
  	  		  	strAry[7+i*2]=null;
  			}
  		}
		return strAry;
	}
}
