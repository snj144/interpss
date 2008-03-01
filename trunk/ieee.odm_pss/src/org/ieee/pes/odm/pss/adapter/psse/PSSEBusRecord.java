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

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AngleXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.GenDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBusDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PowerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.YXmlType;
import org.ieee.pes.odm.pss.model.ODMData2XmlHelper;

public class PSSEBusRecord {
	public static void processBusData(final String str,final BusRecordXmlType busRec, PSSEAdapter adapter) {
		// parse the input data line
		final String[] strAry = getBusDataFields(str);	    
		//Format: I, NAME BASKV, IDE, GL, BL, AREA, ZONE, VM, VA, OWNER
		
		final String busId = PSSEAdapter.Token_Id+strAry[0];
			// XML requires id start with a char
		adapter.getLogger().fine("Bus data loaded, id: " + busId);
		busRec.setId(busId);	
		
		final String busName = strAry[1];
		busRec.setName(busName);
		double baseKv = new Double(strAry[2]).doubleValue();
		if (baseKv == 0.0) {
			adapter.logErr("Error: base kv = 0.0");
			baseKv = 1.0;
		}
		
		final String owner=strAry[10];
		ODMData2XmlHelper.addOwner(busRec, owner, 1.0);
		
		ODMData2XmlHelper.setVoltageData(busRec.addNewBaseVoltage(), baseKv, VoltageXmlType.Unit.KV);

		LoadflowBusDataXmlType busData = busRec.addNewLoadflowBusData();
	
		// bus type identifier IDE
		final int IDE = new Integer(strAry[3]).intValue();
		if (IDE ==3){//Swing bus
			busData.addNewGenData().setCode(LoadflowBusDataXmlType.GenData.Code.SWING);
		}
		else if (IDE==2){// PV bus
			busData.addNewGenData().setCode(LoadflowBusDataXmlType.GenData.Code.PV);
		}else if (IDE==1){//Non-Gen Load Bus
			busData.addNewLoadData().setCode(LoadflowBusDataXmlType.LoadData.Code.CONST_P);

		}else // Isolated bus
		     {
			adapter.logErr("bus"+busId+"is an isolated bus ");
		}
		
		//GL BL
		final double gPU = new Double(strAry[4]).doubleValue();
		final double bPU = new Double(strAry[5]).doubleValue();
		if (gPU != 0.0 || bPU != 0.0) {
			ODMData2XmlHelper.setYData(busData.addNewShuntY(), gPU, bPU,
					YXmlType.Unit.PU);
		}
		//area zone	
		final int areaNo = new Integer(strAry[6]).intValue();
		final int zoneNo = new Integer(strAry[7]).intValue();
		busRec.setArea(areaNo);
		busRec.setZone(zoneNo);		

		// vm voltage, p.u. [F] *
		//va angle, degrees [F] *
		final double vpu = new Double(strAry[8]).doubleValue();
		final double angDeg = new Double(strAry[9]).doubleValue();
		ODMData2XmlHelper.setVoltageData(busData.addNewVoltage(), vpu,
				VoltageXmlType.Unit.PU);

		ODMData2XmlHelper.setAngleData(busData.addNewAngle(), angDeg,
				AngleXmlType.Unit.DEG);				
	}
			
		
	public static  void processLoadData(final String str,final PSSNetworkXmlType baseCaseNet, PSSEAdapter adapter) {
		// I, ID, STATUS, AREA, ZONE, PL, QL, IP, IQ, YP, YQ, OWNER
		final String[] strAry = getLoadDataFields(str);

	    final String busId = PSSEAdapter.Token_Id+strAry[0];
	    //to test if there is a responding bus in the bus data record
		BusRecordXmlType busRec = ODMData2XmlHelper.getBusRecord(busId, baseCaseNet);
	    if (busRec == null){
	    	adapter.logErr("Bus"+ busId+ "is not found in the network");
	    	return;
	    }

	    LoadflowBusDataXmlType lfData = busRec.getLoadflowBusData();
	    if (lfData.getLoadData() == null) {  // there may be multiple load records on a bus
	    	lfData.addNewLoadData();
	    	lfData.getLoadData().setCode(LoadflowBusDataXmlType.LoadData.Code.FUNCTION_LOAD);
	    	lfData.getLoadData().addNewFuncLoadList();
	    }
	    
	    LoadflowBusDataXmlType.LoadData.FuncLoadList.FuncLoad funcLoad = lfData.getLoadData().getFuncLoadList().addNewFuncLoad(); 
	    //loadId is used to distinguish multiple loads at one bus
	    final String loadId =strAry[1];
		funcLoad.setId(loadId);
		
		// TODO: STATUS is missing
		
		//set owner and it's factor
		final String owner =strAry[11];
		ODMData2XmlHelper.addOwner(funcLoad, owner, 1.0);
		    
	    //Constant-P load
		final double CPloadMw = new Double(strAry[5]).doubleValue();
		final double CQloadMvar = new Double(strAry[6]).doubleValue();
		//Constant-I load
		final double CIloadMw = new Double(strAry[7]).doubleValue();
		final double CIloadMvar = new Double(strAry[8]).doubleValue();
		//Constant-Y load
		final double CYloadMw = new Double(strAry[9]).doubleValue();
		final double CYloadMvar = new Double(strAry[10]).doubleValue();

		if (CPloadMw!=0.0 || CQloadMvar!=0.0 )
	    	ODMData2XmlHelper.setPowerData(funcLoad.addNewConstPLoad(),
	    			CPloadMw, CQloadMvar, PowerXmlType.Unit.MVA);

	    if (CIloadMw!=0.0 || CIloadMvar!=0.0)
	    	ODMData2XmlHelper.setPowerData(funcLoad.addNewConstILoad(),
	    			CIloadMw, CIloadMvar, PowerXmlType.Unit.MVA);
	   
	    if (CYloadMw!=0.0 || CYloadMvar!=0.0)
	    	ODMData2XmlHelper.setPowerData(funcLoad.addNewConstZLoad(),
	    			CYloadMw, CYloadMvar, PowerXmlType.Unit.MVA);
	}
	
	public static  void processGenData(final String str,final PSSNetworkXmlType baseCaseNet, PSSEAdapter adapter) {
		
		//I,ID,PG,QG,QT,QB,VS,IREG,MBASE,ZR,ZX,RT,XT,GTAP,STAT,RMPCT,PT,PB,O1,F1,...,O4,F4
		
		// parse the input data line
	    final String[] strAry = getGenDataFields(str);
		final String busId = PSSEAdapter.Token_Id+strAry[0];
		// get the responding-bus data with busId
		BusRecordXmlType busRec = ODMData2XmlHelper.getBusRecord(busId, baseCaseNet);
		if (busRec==null){
			adapter.logErr("Error: Bus not found in the network, bus number: " + busId);
        	return;
        }
				
	    if (busRec.getLoadflowBusData().getGenData().getContributeGenList() == null) {  // there may be multiple constribute gen records on a bus
	    	busRec.getLoadflowBusData().getGenData().addNewContributeGenList();
	    }
	    
	    LoadflowBusDataXmlType.GenData genData = busRec.getLoadflowBusData().getGenData(); 
	    LoadflowBusDataXmlType.GenData.ContributeGenList.ContributeGen contriGen = 
	    		genData.getContributeGenList().addNewContributeGen();
		
		// genId is used to distinguish multiple generations at one bus		
		final String genId = strAry[1];
		contriGen.setId(genId);
		
		// TODO: MBASE,ZR,ZX,RT,XT,GTAP,STAT,RMPCT,PT,PB,O1,F1,...,O4,F4

		final double genMw = new Double(strAry[2]).doubleValue();
		final double genMvar = new Double(strAry[3]).doubleValue();
		ODMData2XmlHelper.setPowerData(contriGen.getGen().getPower(), genMw, genMvar, PowerXmlType.Unit.MVA);
		
		// Desired volts (pu) (This is desired remote voltage if this bus is controlling another bus.)
		// Maximum MVAR  
		// Minimum MVAR  
      	final double vSpecPu = new Double(strAry[6]).doubleValue();
		final double max = new Double(strAry[4]).doubleValue();
		final double min = new Double(strAry[5]).doubleValue();
		
		//Remote controlled bus number
		final String reBusId = PSSEAdapter.Token_Id+strAry[7];
		
		if (max != 0.0 || min != 0.0) {
			if ( genData.getCode() == LoadflowBusDataXmlType.GenData.Code.PQ) {
				contriGen.getGen().addNewVGenLimit();
				ODMData2XmlHelper.setLimitData(contriGen.getGen().getVGenLimit()
						.addNewVLimit(), max, min);
				contriGen.getGen().getVGenLimit().setVLimitUnit(
						GenDataXmlType.VGenLimit.VLimitUnit.PU);
			}
			else if (genData.getCode() == LoadflowBusDataXmlType.GenData.Code.PV) {
				contriGen.getGen().addNewQGenLimit();
				ODMData2XmlHelper.setLimitData(contriGen.getGen().getQGenLimit()
						.addNewQLimit(), max, min);
				contriGen.getGen().getQGenLimit().setQLimitUnit(
						GenDataXmlType.QGenLimit.QLimitUnit.MVAR);
				if (reBusId != null && !reBusId.equals("0")
						&& !reBusId.equals(ODMData2XmlHelper.getBusRecord(busId, baseCaseNet).getId())) {
					contriGen.getGen().addNewDesiredRemoteVoltage();
					ODMData2XmlHelper.setVoltageData(contriGen.getGen()
							.getDesiredRemoteVoltage().addNewDesiredVoltage(),
							vSpecPu, VoltageXmlType.Unit.PU);
					contriGen.getGen().getDesiredRemoteVoltage()
							.addNewRemoteBus();
					contriGen.getGen().getDesiredRemoteVoltage()
							.getRemoteBus().setIdRef(reBusId);
				}
			}
		}
    }
	
	private static String[] getBusDataFields(final String lineStr) {
		final String[] strAry = new String[11];

		StringTokenizer st = new StringTokenizer(lineStr,",");
		//Format: I, NAME BASKV, IDE, GL, BL, AREA, ZONE, VM, VA, OWNER
        //I
		strAry[0]=st.nextToken().trim();
		//NAME
		strAry[1]=st.nextToken().trim();
		//BASKV
		strAry[2]=st.nextToken().trim();
		//IDE
		strAry[3]=st.nextToken().trim();
		
		strAry[4]=strAry[5]="0";//GL BL double
		strAry[6]=strAry[7]="1";//AREA ZONE 
		strAry[8]="1.0";//VM
		strAry[9]="0.0";//VA
		strAry[10]="1";//OWNER
		
		//GL
        if (st.hasMoreTokens())				
			
		strAry[4]=st.nextToken().trim();
		//BL
		strAry[5]=st.nextToken().trim();
		//AREA
		if (st.hasMoreTokens())				
		
			strAry[6]=st.nextToken().trim();
		//ZONE
		if (st.hasMoreTokens())				
			
			strAry[7]=st.nextToken().trim();
		//VM
		if (st.hasMoreTokens())				
			strAry[8]=st.nextToken().trim();
		//VA
		if (st.hasMoreTokens())				
			strAry[9]=st.nextToken().trim();
		//OWNER
		if (st.hasMoreTokens())				
			strAry[10]=st.nextToken().trim();  			

		return strAry;
	}
	
	private static String[] getLoadDataFields(final String lineStr) {
		final String[] strAry = new String[12];
  		StringTokenizer st = new StringTokenizer(lineStr, ",");
		/*
		I, ID, STATUS, AREA, ZONE, PL, QL, IP, IQ, YP, YQ, OWNER
		 */		
  		strAry[0]=st.nextToken().trim();
  		strAry[1]=st.nextToken().trim();
  		strAry[2]=st.nextToken().trim();
  		strAry[3]=st.nextToken().trim();
  		strAry[4]=st.nextToken().trim();
  		strAry[5]=st.nextToken().trim();
  		strAry[6]=st.nextToken().trim();
  		strAry[7]=st.nextToken().trim();
  		strAry[8]=st.nextToken().trim();
  		strAry[9]=st.nextToken().trim();
  		strAry[10]=st.nextToken().trim();
  		strAry[11]=st.nextToken().trim();

  		return strAry;
	}	
	
	
	private static String[] getGenDataFields(final String lineStr) {
		final String[] strAry = new String[26];		
		/*
		I,ID,PG,QG,QT,QB,VS,IREG,MBASE,ZR,ZX,RT,XT,GTAP,STAT,RMPCT,PT,PB,O1,F1,...,O4,F4

		The standard generator boundary condition is a specification of real power output at the
		high-voltage bus, bus k, and of voltage magnitude at some designated bus, not necessarily bus k.
        */		
		//I,ID,PG,QG,QT,QB,VS,IREG,MBASE,ZR,ZX,RT,XT,GTAP,STAT,RMPCT,PT,PB,
  		StringTokenizer st = new StringTokenizer(lineStr, ",");
  		strAry[0]=st.nextToken().trim();
  		strAry[1]=st.nextToken().trim();
  		strAry[2]=st.nextToken().trim();
  		strAry[3]=st.nextToken().trim();
  		strAry[4]=st.nextToken().trim();
  		strAry[5]=st.nextToken().trim();
  		strAry[6]=st.nextToken().trim();
  		strAry[7]=st.nextToken().trim();
  		strAry[8]=st.nextToken().trim();
  		strAry[9]=st.nextToken().trim();
  		strAry[10]=st.nextToken().trim();
  		strAry[11]=st.nextToken().trim();
  		strAry[12]=st.nextToken().trim();
  		strAry[13]=st.nextToken().trim();
  		strAry[14]=st.nextToken().trim();
  		strAry[15]=st.nextToken().trim();
  		strAry[16]=st.nextToken().trim();
  		strAry[17]=st.nextToken().trim();

        //O1,F1,...,O4,F4
  		
		//   O1 = 0, O2 = 0, O3 = 0, O4 = 0;
		// F1 = 0.0, F2 = 0.0, F3 = 0.0, F4 = 0.0;
		strAry[18]="0";
  		strAry[19]="0";
  		strAry[20]="0";
  		strAry[21]="0";
		strAry[22]="0";
  		strAry[23]="0";
		strAry[24]="0";
  		strAry[25]="0";
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
}
