

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
package org.ieee.pes.odm.pss.adapter.bpa;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AngleXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.GenDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBusDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PowerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.YXmlType;
import org.ieee.pes.odm.pss.model.ODMData2XmlHelper;

public class BPABusRecord {
	
	public static void processBusData(final String str,final BusRecordXmlType busRec, 
			BPAAdapter adapter) {		

		// parse the input data line
		final String[] strAry = getBusDataFields(str);
		
		int busType=0;
		
		final int swingBus=1;
		final int pqBus=2;
		final int pvBus=3;		
        //busType		
		if(strAry[0].equals("B ")||strAry[0].equals("BC")||strAry[0].equals("BT")||
				strAry[0].equals("BV")){
			busType=pqBus;
		}else if(strAry[0].equals("BE")||strAry[0].equals("BQ")||strAry[0].equals("BG")||
				strAry[0].equals("BF")){
			busType=pvBus;
		}else if(strAry[0].equals("BS")){
			busType=swingBus;
		}
		
		
		// modification code
		final String modCode=strAry[1];
		//owner code
		final String ownerName=strAry[2];
		//Name
		final String busName = strAry[3];
		final String busId =  strAry[3];
		adapter.getLogger().fine("Bus data loaded, busName: " + busId);
		busRec.setId(busId);		
		busRec.setName(busName);

		//basekv
		double baseKv=100.0;
		if(!strAry[4].equals("")){
			baseKv= new Double(strAry[4]).doubleValue();
		}
		ODMData2XmlHelper.setVoltageData(busRec.addNewBaseVoltage(), baseKv, VoltageXmlType.Unit.KV);
		
		
		//zone name
		final String zoneName= strAry[5];
		busRec.setZone(zoneName);
		
		//****************busRec.setZone(arg0)
		
		//load mw and mvar
		double loadMw=0.0;
		double loadMvar=0.0;
		if(!strAry[6].equals("")){
			loadMw = new Double(strAry[6]).doubleValue();			
		}
		if(!strAry[7].equals("")){			
			loadMvar = new Double(strAry[7]).doubleValue();
		}
		
		
		//Shunt mw--> G 
		//Shunt var B -->B
		double shuntMw=0.0;
		double shuntVar=0.0;
		if(!strAry[8].equals("")){
			shuntMw= new Double(strAry[8]).doubleValue();
		}
		if(!strAry[9].equals("")){
			shuntVar= new Double(strAry[9]).doubleValue();
		}		       
		final double g = shuntMw/(baseKv*baseKv);
		final double b = shuntVar/(baseKv*baseKv);
			
		// set pGenMax
		double pGenMax=0.0;
		if(!strAry[10].equals("")){
			pGenMax= new Double(strAry[10]).doubleValue();
		}		
		
		double pGen=0.0;
		if(!strAry[11].equals("")){
			pGen= new Double(strAry[11]).doubleValue();
		}		
		// qGen for PQ bus, qGenMax for PV bus
		double qGenOrQGenMax=0.0;
		if(!strAry[12].equals("")){
			qGenOrQGenMax=new Double(strAry[12]).doubleValue();
		}		 				
		double qGenMin=0.0;
		if(!strAry[13].equals("")){
			qGenMin= new Double(strAry[13]).doubleValue();
		}		
		double vpu=0.0;
		if(!strAry[14].equals("")){
			vpu = new Double(strAry[14]).doubleValue();			
		}		
		//for swing bus, this value is angle(degrees), for others it is vmin.
		double vMinOrAngDeg=0.0;
		if(!strAry[15].equals("")){
			vMinOrAngDeg= new Double(strAry[15]).doubleValue();			
		}	
		
		double varSupplied=0.0;
		if(!strAry[18].equals("")){
			varSupplied= new Double(strAry[18]).doubleValue();
		}	
		
		if(loadMw != 0.0 || loadMvar != 0.0||pGen!=0.0||qGenOrQGenMax!=0.0
				||vMinOrAngDeg!=0.0){
			LoadflowBusDataXmlType busData = busRec.addNewLoadflowBusData();
			// set G B
			if (g != 0.0 || b != 0.0) {
				ODMData2XmlHelper.setYData(busData.addNewShuntY(), g, b,
						YXmlType.Unit.MHO);
			}	
			// set load
			if (loadMw != 0.0 || loadMvar != 0.0) {
				ODMData2XmlHelper.setLoadData(busData,
						LoadflowBusDataXmlType.LoadData.Code.CONST_P, loadMw,
						loadMvar, PowerXmlType.Unit.MVA);
			}
			
			if(busType==swingBus){
				// set bus voltage
				if(vpu!=0.0){
					if(vpu>10){
						vpu=vpu/1000;
					}
					ODMData2XmlHelper.setVoltageData(busData.addNewVoltage(), vpu,
							VoltageXmlType.Unit.PU);
				}
				// set bus angle
				ODMData2XmlHelper.setAngleData(busData.addNewAngle(), vMinOrAngDeg,
						AngleXmlType.Unit.DEG);
				//set gen data
				if(pGen!=0.0||qGenOrQGenMax!=0.0){				
					ODMData2XmlHelper.setGenData(busData,
							LoadflowBusDataXmlType.GenData.Code.SWING, pGen, 0.0,
							PowerXmlType.Unit.MVA);
				}
				// set Q limit
				if(qGenOrQGenMax!=0.0||qGenMin!=0.0){
					ODMData2XmlHelper.setGenQLimitData(busData.getGenData(), 
							qGenOrQGenMax, qGenMin, GenDataXmlType.QGenLimit.QLimitUnit.MVAR);				
				}
				// set P limit
				if(pGenMax!=0.0){				
					ODMData2XmlHelper.setLimitData(busData.getGenData().getGen()
							.getPGenLimit().addNewPLimit(), pGenMax, 0);
				}	
			}else if(busType==pqBus){			
				if(pGen!=0.0||qGenOrQGenMax!=0.0){
					ODMData2XmlHelper.setGenData(busData,
							LoadflowBusDataXmlType.GenData.Code.PQ, pGen, qGenOrQGenMax,
							PowerXmlType.Unit.MVA);
				}
				// set V limit
				if(vpu!=0 ||vMinOrAngDeg!=0){
					busData.getGenData().getGen().addNewVGenLimit();
				    ODMData2XmlHelper.setLimitData(busData.getGenData().getGen().getVGenLimit()
						.addNewVLimit(), vpu, vMinOrAngDeg);
				    }			
			}else if(busType==pvBus){
				// set bus voltage
				if(vpu!=0.0){
					if(vpu>10){
						vpu=vpu/1000;
					}
					ODMData2XmlHelper.setVoltageData(busData.addNewVoltage(), vpu,
							VoltageXmlType.Unit.PU);
				}
				// set gen data
				if(pGen!=0.0||qGenOrQGenMax!=0.0){
					ODMData2XmlHelper.setGenData(busData,
							LoadflowBusDataXmlType.GenData.Code.PV, pGen, 0.0,
							PowerXmlType.Unit.MVA);
				}
				// set Q limit
				if(qGenOrQGenMax!=0.0||qGenMin!=0.0){
					ODMData2XmlHelper.setGenQLimitData(busData.getGenData(), 
							qGenOrQGenMax, qGenMin, GenDataXmlType.QGenLimit.QLimitUnit.MVAR);				
				}
				// set P limit
				if(pGenMax!=0.0){				
					ODMData2XmlHelper.setLimitData(busData.getGenData().getGen()
							.getPGenLimit().addNewPLimit(), pGenMax, 0);
				}	
				
			}
				
				//for BG and BX, controlled bus name and voltage
				// desired bus voltage is specified in strAry[14], equals to vpu
			final String controlledBus= strAry[16];
			double controlledBusRatedVol=0.0;
			if(!strAry[17].endsWith("")){
				controlledBusRatedVol= new Double(strAry[17]).doubleValue();			
			}
			if(strAry[0].equals("BG")||strAry[0].equals("BX")){
				if(!controlledBus.equals("")){			
				    busData.getGenData().getGen().addNewDesiredRemoteVoltage();
					busData.getGenData().getGen().getDesiredRemoteVoltage().
						getRemoteBus().setIdRef(controlledBus);
						ODMData2XmlHelper.setVoltageData(busData.getGenData().getGen()
								.getDesiredRemoteVoltage().addNewDesiredVoltage(),
								vpu, VoltageXmlType.Unit.PU);
					}
				}
		}
						
	}
	
	public static void processDCLineBusData(final String str,final BusRecordXmlType busRec, 
			BPAAdapter adapter) {
		
	}
	
	private static String[] getBusDataFields(final String str) {
		final String[] strAry = new String[19];
			//Columns  1- 2   Bus type
		    strAry[0] = str.substring(0, 2);			
			//Columns  3 code for modification			
			strAry[1] = str.substring(2, 3).trim();
			//Columns 3-5   owner code
			//Columns 6-13 busName  14-17 rated voltage
			strAry[2] = str.substring(3, 6).trim();
			strAry[3] = str.substring(6, 14).trim();
			strAry[4] = str.substring(14, 18).trim();
			//Columns 18-19   zone name
			strAry[5] = str.substring(18, 20).trim();

			//Columns 20-24   Load MW [F] *
			//Columns 25-29   Load MVAR [F] *
			strAry[6] = str.substring(20, 25).trim();;
			strAry[7] = str.substring(25, 30).trim();;			
			//Columns 30-33   shunt MW [F] *
			//Columns 34-39   shunt MVAR [F] *
			strAry[8] = str.substring(30, 34).trim();;
			strAry[9] = str.substring(34, 38).trim();;			
			// Columns 38-41 pmax
			// Columns 42-46 pmax
			strAry[10] = str.substring(38, 42).trim();;
			strAry[11] = str.substring(42, 47).trim();			
			//Qmax Qmin
			strAry[12]= str.substring(47, 52).trim();
			strAry[13]= str.substring(52, 57).trim();			
			//scheduled V or Vmax, Vmin
			strAry[14]= str.substring(57, 61).trim();
			strAry[15]=str.substring(61, 65).trim();
			
			//remoted busName, rated voltage
			strAry[16]= str.substring(65, 73).trim();
			strAry[17]= str.substring(73, 77).trim();
			// used in remoted bus control, var fraction
			strAry[18]= str.substring(77, 80).trim();

		
		return strAry;
	}
	
	
}
	
	
