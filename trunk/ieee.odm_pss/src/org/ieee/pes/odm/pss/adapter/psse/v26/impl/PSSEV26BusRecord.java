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
package org.ieee.pes.odm.pss.adapter.psse.v26.impl;

import java.util.StringTokenizer;
import java.util.logging.Logger;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AngleUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ApparentPowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LFGenCodeEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LFLoadCodeEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBusDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowGenDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowLoadDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ReactivePowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.SwitchedShuntDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.YUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZUnitType;
import org.ieee.pes.odm.pss.model.DataSetter;
import org.ieee.pes.odm.pss.model.ODMModelParser;
import org.ieee.pes.odm.pss.model.ParserHelper;
import org.ieee.pes.odm.pss.model.StringUtil;

public class PSSEV26BusRecord {
	public static void processBusData(final String str, final ODMModelParser parser, Logger logger) {
		// parse the input data line
		final String[] strAry = getBusDataFields(str);	    

		// I,    NAME        BASKV, IDE,  GL,      BL, AREA, ZONE, VM,      VA,      OWNER
		// 31212,'ADLIN  1', 115.00,1,    0.00,    0.00,  1,  1,   1.01273, -10.5533,1 

		final String busId = ODMModelParser.BusIdPreFix+strAry[0];
			// XML requires id start with a char
		logger.fine("Bus data loaded, id: " + busId);
		BusRecordXmlType busRec;
		try {
			busRec = parser.addNewBaseCaseBus(busId);
		} catch (Exception e) {
			logger.severe(e.toString());
			return;
		}
		
		busRec.setNumber(StringUtil.getInt(strAry[0], 0));
		
		final String busName = StringUtil.removeSingleQuote(strAry[1]);
		busRec.setName(busName);
		double baseKv = StringUtil.getDouble(strAry[2], 0.0);
		if (baseKv == 0.0) {
			logger.severe("Error: base kv = 0.0");
			baseKv = 1.0;
		}
		
		final String owner=strAry[10];
		ParserHelper.addOwner(busRec, owner, 1.0);
		
		DataSetter.setVoltageData(busRec.addNewBaseVoltage(), baseKv, VoltageUnitType.KV);

		LoadflowBusDataXmlType busData = busRec.addNewLoadflowData();
	
		// vm voltage, p.u. [F] *
		//va angle, degrees [F] *
		final double vpu = StringUtil.getDouble(strAry[8], 1.0);
		final double angDeg = StringUtil.getDouble(strAry[9], 0.0);
		DataSetter.setVoltageData(busData.addNewVoltage(), vpu,
				VoltageUnitType.PU);

		DataSetter.setAngleData(busData.addNewAngle(), angDeg,
				AngleUnitType.DEG);				

		/* bus type identifier IDE
			1 - load bus (no generator boundary condition)
			2 - generator or plant bus (either voltage regulating or fixed Mvar)
			3 - swing bus
			4 - disconnected (isolated) bus
			IDE = 1 by default.
		*/			
		final int IDE = StringUtil.getInt(strAry[3], 1);
		if (IDE ==3){//Swing bus
			busData.addNewGenData();;
			LoadflowGenDataXmlType equivGen = busData.getGenData().addNewEquivGen();
			equivGen.setCode(LFGenCodeEnumType.SWING);
			DataSetter.setVoltageData(equivGen.addNewDesiredVoltage(), vpu, VoltageUnitType.PU);
			DataSetter.setAngleData(equivGen.addNewDesiredAngle(), angDeg, AngleUnitType.DEG);
		}
		else if (IDE==2){// generator bus. At this point we do not know if it is a PQ or PV bus
			// by default, Gen is a PV bus
			busData.addNewGenData().addNewEquivGen();
			busData.getGenData().getEquivGen().setCode(LFGenCodeEnumType.PV);
		} else if (IDE==4){// Isolated bus
			// should be no gen and load defined
			busRec.setOffLine(true);
		}
		else { //Non-Gen Load Bus
			busData.addNewLoadData().addNewEquivLoad();
		}
		
		//GL BL
		final double gPU = StringUtil.getDouble(strAry[4], 0.0);
		final double bPU = StringUtil.getDouble(strAry[5], 0.0);
		if (gPU != 0.0 || bPU != 0.0) {
			DataSetter.setYData(busData.addNewShuntY(), gPU, bPU, YUnitType.PU);
		}
		//area zone	
		final String areaNo = strAry[6];
		final String zoneNo = strAry[7];
		busRec.setAreaNumber(StringUtil.getInt(areaNo, 0));
		busRec.setZoneNumber(StringUtil.getInt(zoneNo, 0));		
	}
		
	public static  void processLoadData(final String str,final ODMModelParser parser, Logger logger) {
		// I,    ID,  STATUS, AREA, ZONE, PL,   QL,   IP,   IQ,   YP,    YQ,  OWNER
		// 33547,' 1',1,      1,    1,    3.00, 9.54, 0.00, 0.00, 0.00,  0.00,1,   /* [EnergyConsumer_1704] */
		
		final String[] strAry = getLoadDataFields(str);

	    final String busId = ODMModelParser.BusIdPreFix+strAry[0];
	    //to test if there is a responding bus in the bus data record
		BusRecordXmlType busRec = parser.getBusRecord(busId);
	    if (busRec == null){
	    	logger.severe("Bus "+ busId+ " not found in the network");
	    	return;
	    }

	    // ODM allows one equiv load has many contribute loads, but here, we assume there is only one contribute load.

		LoadflowBusDataXmlType.LoadData loadData = busRec.getLoadflowData().getLoadData();
		if (loadData == null) { 
			loadData = busRec.getLoadflowData().addNewLoadData();
			loadData.addNewEquivLoad();
		}
		if (loadData.getContributeLoadList() == null) 
			loadData.addNewContributeLoadList();
	    LoadflowLoadDataXmlType contribLoad = loadData.getContributeLoadList().addNewContributeLoad(); 
		
	    // processing contributing load data

	    //loadId is used to distinguish multiple loads at one bus
	    final String loadId =strAry[1];
		contribLoad.setId(loadId);
		
		// STATUS - Initial load status of one for in-service and zero for out-of-service. STATUS = 1 by default
		int status = StringUtil.getInt(strAry[1], 1);
		int area = StringUtil.getInt(strAry[2], 1);
		int zone = StringUtil.getInt(strAry[3], 1);
		contribLoad.setOffLine(status != 1);
		contribLoad.setAreaNumber(area);
		contribLoad.setZoneNumber(zone);
		
		//set owner and it's factor
		final String owner =strAry[11];
		ParserHelper.addOwner(contribLoad, owner, 1.0);
		    
	    //Constant-P load
		final double CPloadMw = StringUtil.getDouble(strAry[5], 0.0);
		final double CQloadMvar = StringUtil.getDouble(strAry[6], 0.0);
		//Constant-I load
		final double CIloadMw = StringUtil.getDouble(strAry[7], 0.0);
		final double CIloadMvar = StringUtil.getDouble(strAry[8], 0.0);
		//Constant-Y load
		final double CYloadMw = StringUtil.getDouble(strAry[9], 0.0);
		final double CYloadMvar = StringUtil.getDouble(strAry[10], 0.0);

		if (CPloadMw!=0.0 || CQloadMvar!=0.0 )
			DataSetter.setPowerData(contribLoad.addNewConstPLoad(),
	    			CPloadMw, CQloadMvar, ApparentPowerUnitType.MVA);

	    if (CIloadMw!=0.0 || CIloadMvar!=0.0)
	    	DataSetter.setPowerData(contribLoad.addNewConstILoad(),
	    			CIloadMw, CIloadMvar, ApparentPowerUnitType.MVA);
	   
	    if (CYloadMw!=0.0 || CYloadMvar!=0.0)
	    	DataSetter.setPowerData(contribLoad.addNewConstZLoad(),
	    			CYloadMw, CYloadMvar, ApparentPowerUnitType.MVA);
	    
	    // processing equiv load data
	    loadData.getEquivLoad().setCode(LFLoadCodeEnumType.CONST_P);
	    LoadflowBusDataXmlType.LoadData.EquivLoad load = loadData.getEquivLoad();
	    if (load == null) {
	    	load = loadData.addNewEquivLoad();
	    	load.addNewConstPLoad();
	    }
	    if(load.getConstPLoad() == null)
	    	load.addNewConstPLoad();
	    double tp = CPloadMw + CIloadMw + CYloadMw + load.getConstPLoad().getRe();
	    double tq = CQloadMvar + CIloadMvar + CYloadMvar  + load.getConstPLoad().getIm();;
	    DataSetter.setPowerData(load.getConstPLoad(), tp, tq, ApparentPowerUnitType.MVA);
	}
	
	public static  void processGenData(final String str,final ODMModelParser parser, Logger logger) {
		//I,    ID,      PG,      QG,     QT,      QB,   VS,        IREG,MBASE, ZR,    ZX,    RT,    XT,    GTAP,  STAT,RMPCT,  PT,         PB,  O1,F1,...,O4,F4
		//31435,' 1',    8.52,    2.51,   10.00,   -6.00,1.0203,    0,   100.00,0.0000,1.0000,0.0000,0.0000,1.0000,1,   100.00, 9999.00,    0.00,1,1.00,0,0.00,0,0.00,0,0.00,   /* [SynchronousMachine_78] */ 
		
		// parse the input data line
	    final String[] strAry = getGenDataFields(str);
		final String busId = ODMModelParser.BusIdPreFix+strAry[0];
		// get the responding-bus data with busId
		BusRecordXmlType busRec = parser.getBusRecord(busId);
		if (busRec==null){
			logger.severe("Error: Bus not found in the network, bus number: " + busId);
        	return;
        }
				
	    // ODM allows one equiv gen has many contribute generators, but here, we assume there is only one contribute gen.

		LoadflowBusDataXmlType.GenData genData = busRec.getLoadflowData().getGenData();
		if (genData == null) {
			genData = busRec.getLoadflowData().addNewGenData();
			genData.addNewEquivGen();
		}
		LoadflowGenDataXmlType equivGen = genData.getEquivGen();
	    LoadflowBusDataXmlType.GenData.ContributeGenList.ContributeGen contriGen = genData.addNewContributeGenList().addNewContributeGen();
		
	    // processing contributing gen data
	    
		// genId is used to distinguish multiple generations at one bus		
		final String genId = strAry[1];
		contriGen.setId(genId);
		
		double mbase = StringUtil.getDouble(strAry[8], 0.0),
		       zr = StringUtil.getDouble(strAry[9], 0.0),
		       zx = StringUtil.getDouble(strAry[10], 0.0),
		       rt = StringUtil.getDouble(strAry[11], 0.0),
		       xt = StringUtil.getDouble(strAry[12], 0.0),
		       gtap = StringUtil.getDouble(strAry[13], 0.0); 
		DataSetter.setPowerMva(contriGen.addNewRatedMva(), mbase);
		if(zr != 0.0 || zx != 0.0)
			DataSetter.setZValue(contriGen.addNewSourceZ(), zr, zx, ZUnitType.PU);
		if(rt != 0.0 || xt != 0.0)
			DataSetter.setZValue(contriGen.addNewXfrZ(), rt, xt, ZUnitType.PU);
		contriGen.setXfrTap(gtap);
		
		// STATUS - Initial load status of one for in-service and zero for out-of-service. STATUS = 1 by default
		int status = StringUtil.getInt(strAry[14], 1);
		contriGen.setOffLine(status != 1);
		
		final double genMw = StringUtil.getDouble(strAry[2], 0.0);
		final double genMvar = StringUtil.getDouble(strAry[3], 0.0);
		DataSetter.setPowerData(contriGen.addNewGenData().addNewPower(), genMw, genMvar, ApparentPowerUnitType.MVA);

		ParserHelper.addOwner(contriGen, 
				strAry[18], StringUtil.getDouble(strAry[19], 0.0), 
				strAry[20], StringUtil.getDouble(strAry[21], 0.0), 
				strAry[22], StringUtil.getDouble(strAry[23], 0.0), 
				strAry[24], StringUtil.getDouble(strAry[25], 0.0));

		// processing Equiv Gen Data
		if (!contriGen.getOffLine()) {
			DataSetter.setPowerData(equivGen.addNewPower(), genMw, genMvar, ApparentPowerUnitType.MVA);

			final double vSpecPu = StringUtil.getDouble(strAry[6], 1.0);
			if (genData.getEquivGen().getCode() == LFGenCodeEnumType.SWING) {
				DataSetter.setVoltageData(equivGen.addNewDesiredVoltage(), vSpecPu, VoltageUnitType.PU);
			}
			else {
				// qmax, gmin in Mvar
				final double max = StringUtil.getDouble(strAry[4], 0.0);
				final double min = StringUtil.getDouble(strAry[5], 0.0);
				DataSetter.setVoltageData(equivGen.addNewDesiredVoltage(), vSpecPu, VoltageUnitType.PU);
				DataSetter.setReactivePowerLimitData(equivGen.addNewQLimit(), max, min, ReactivePowerUnitType.MVAR);

				// Desired volts (pu) (This is desired remote voltage if this bus is controlling another bus.)
				/*  IREG  */
		      	final int iReg = StringUtil.getInt(strAry[7], 0);
				if (iReg > 0) {
					final String reBusId = ODMModelParser.BusIdPreFix+strAry[7];
					equivGen.addNewRemoteVoltageControlBus().setIdRef(reBusId);
				}
			}
		}
		else {
			if (genData.getEquivGen() == null)
				genData.addNewEquivGen();
			genData.getEquivGen().setCode(LFGenCodeEnumType.OFF);
		}
		
		//System.out.println(busRec.toString());
    }

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
	    if (lfData.getShuntQData() == null) {  // there may be multiple contribute switched shunt records on a bus
	    	lfData.addNewShuntQData().addNewContributeQList();
	    }
	    SwitchedShuntDataXmlType shunt = lfData.getShuntQData().getContributeQList().addNewSwitchedShunt();
		
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
		if (lfData.getShuntQData().getEquivQ() != null)
			equiQ = lfData.getShuntQData().getEquivQ().getValue();
		DataSetter.setReactivePower(lfData.getShuntQData().addNewEquivQ(), equiQ+binit, ReactivePowerUnitType.MVAR);
		
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
	
	private static String[] getBusDataFields(final String lineStr) {
		final String[] strAry = new String[11];

		StringTokenizer st = new StringTokenizer(lineStr,",");
		for (int i = 0; i < 11; i++)
			strAry[i]=st.nextToken().trim();
		return strAry;
	}
	
	private static String[] getLoadDataFields(final String lineStr) {
		final String[] strAry = new String[12];
  		StringTokenizer st = new StringTokenizer(lineStr, ",");
		for (int i = 0; i < 12; i++)
			strAry[i]=st.nextToken().trim();
  		return strAry;
	}	
	
	
	private static String[] getGenDataFields(final String lineStr) {
		final String[] strAry = new String[26];		
		//I,ID,PG,QG,QT,QB,VS,IREG,MBASE,ZR,ZX,RT,XT,GTAP,STAT,RMPCT,PT,PB,
  		StringTokenizer st = new StringTokenizer(lineStr, ",");
		for (int i = 0; i < 18; i++)
			strAry[i]=st.nextToken().trim();

        //O1,F1,...,O4,F4
		for (int i = 18; i < 26; i++)
			strAry[i]="0";
		if (st.hasMoreTokens()) {
			strAry[18]=st.nextToken().trim();
	  		strAry[19]=st.nextToken().trim();
		}
		if (st.hasMoreTokens()) {
			strAry[20]=st.nextToken().trim();
	  		strAry[21]=st.nextToken().trim();
		}
		if (st.hasMoreTokens()) {
			strAry[22]=st.nextToken().trim();
	  		strAry[23]=st.nextToken().trim();
		}
		if (st.hasMoreTokens()) {
			strAry[24]=st.nextToken().trim();
	  		strAry[25]=st.nextToken().trim();
		}
				
		return strAry;
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
