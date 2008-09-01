

/*
 * @(#)BPABusRecord.java   
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
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.CurrentXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.DCLineBusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.GenDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBusDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PowerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.YXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZXmlType;
import org.ieee.pes.odm.pss.model.ODMData2XmlHelper;
import org.ieee.pes.odm.pss.model.StringUtil;

public class BPABusRecord {
	
	public static void processBusData(final String str,final BusRecordXmlType busRec, 
			BPAAdapter adapter) {		

		// parse the input data line
		final String[] strAry = getBusDataFields(str, adapter);
		
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
		
		if(strAry[13].equals(".")){
			System.out.println(str+"str 13 is .");
		}
		
		double qGenMin=0.0;
		if(!strAry[13].equals("")){
			qGenMin= new Double(strAry[13]).doubleValue();
		}
		
		if(strAry[14].equals(".")){
			System.out.println(str+"str 14 is .");
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
				||vMinOrAngDeg!=0.0||pGenMax!=0.0){
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
					
					
					if(busData.getGenData().getGen()
							.getPGenLimit()==null){
						busData.getGenData().getGen().addNewPGenLimit();
					}
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
					
					if(busData.getGenData()==null){
						busData.addNewGenData().addNewGen().addNewVGenLimit();
					}else if(busData.getGenData().getGen()==null){
						busData.getGenData().addNewGen().addNewVGenLimit();
					}else if(busData.getGenData().getGen().getVGenLimit()==null){
						busData.getGenData().getGen().addNewVGenLimit();
					}
					busData.getGenData().getGen().getVGenLimit();
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
					if(busData.getGenData().getGen()
							.getPGenLimit()==null){
						busData.getGenData().getGen()
						.addNewPGenLimit();
					}
					ODMData2XmlHelper.setLimitData(busData.getGenData().getGen()
							.getPGenLimit().addNewPLimit(), pGenMax, 0);
				}	
				
			}
				
				//for BG and BX, controlled bus name and voltage
				// desired bus voltage is specified in strAry[14], equals to vpu
			final String controlledBus= strAry[16];
			double controlledBusRatedVol=0.0;
			if(!strAry[17].equals("")){
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
	
	public static void processDCLineBusData(final String str,final DCLineBusRecordXmlType dcBus,  
			BPAAdapter adapter) {
		final String[] strAry= getDCLineBusDataFields(str,adapter);
		
		final String dataType= strAry[0];
		final String modCode=  strAry[1];
		final String owner = strAry[2];
		final String converterBus =strAry[3];
		double converterACSideVoltage =0.0;
		if(!strAry[4].equals("")){
			converterACSideVoltage = new Double(strAry[4]).doubleValue();
		}
		String zone="";
		if(!strAry[5].equals("")){
			zone = strAry[5];
		}
		int brdgsPerBrckt=0;
		if(!strAry[6].equals("")){
			brdgsPerBrckt = new Integer(strAry[6]).intValue();
		}
		double smoothInductance=0.0;
		if(!strAry[7].equals("")){
			smoothInductance =new Double(strAry[7]).doubleValue();
		}
		// suppose the frequence is 50 Hz;
		double smoothReactance=2*3.14*0.02*smoothInductance*0.001;
		double converterMinFiringAngle=0.0;
		if(!strAry[8].equals("")){
			converterMinFiringAngle= new Double(strAry[8]).doubleValue();
		}
		double inverterMaxFiringAngle=0.0;
		if(!strAry[9].equals("")){
			inverterMaxFiringAngle= new Double(strAry[9]).doubleValue();
		}
		double valveDropVoltage=0.0;   // in v
		if(!strAry[10].equals("")){
			valveDropVoltage= new Double(strAry[10]).doubleValue();
		}
		double brdgesCurrentRating=0.0;   // in amps
		if(!strAry[11].equals("")){
			brdgesCurrentRating= new Double(strAry[11]).doubleValue();
		}
		String commutatingBus="";
		double commutatingBusDCSideVol =0.0;
		if(!strAry[12].equals("")){
			commutatingBus =strAry[12];
		}
		if(!strAry[13].equals("")){
			commutatingBusDCSideVol= new Double(strAry[13]).doubleValue();
		}
		
		DCLineBusRecordXmlType.Converter converter= dcBus.addNewConverter();
		// set converter bus id
		converter.addNewBusId().setName(converterBus);
		converter.setZone(zone);
		// set converter ac side voltage
		ODMData2XmlHelper.setVoltageData(converter.addNewAcSideRatedVoltage(), 
				converterACSideVoltage, VoltageXmlType.Unit.KV);
		// bridges
		converter.setNumberofBridges(brdgsPerBrckt);
		// set smooth reactor
		ODMData2XmlHelper.setZValue(converter.addNewSmoothingReactor(),
				0.0, smoothReactance, ZXmlType.Unit.OHM);
		//set min firing angle as a converter
		ODMData2XmlHelper.setAngleData(converter.addNewRectifierMinFiringAngle(),
				converterMinFiringAngle, AngleXmlType.Unit.DEG);
		//set max firing angle as a inverter
		ODMData2XmlHelper.setAngleData(converter.addNewInverterMaxFiringAngle(),
				inverterMaxFiringAngle, AngleXmlType.Unit.DEG);
		// set valve voltage drop
		ODMData2XmlHelper.setVoltageData(converter.addNewValveDropVoltage(), 
				valveDropVoltage, VoltageXmlType.Unit.VOLT);
		// set current rating
		ODMData2XmlHelper.setCurrentData(converter.addNewBridgeRatedCurrent(), 
				brdgesCurrentRating, CurrentXmlType.Unit.AMP);
		// set commutating station bus and DC side voltage
		converter.addNewConmmutationStationBus().setName(commutatingBus);
	    ODMData2XmlHelper.setVoltageData(converter.addNewDcSdieRatedV(),
	    		commutatingBusDCSideVol, VoltageXmlType.Unit.KV);
	}
	
	private static String[] getBusDataFields(final String str,BPAAdapter adapter) {
		final String[] strAry = new String[19];
		
		try{
			//Columns  1- 2   Bus type
		    strAry[0] = StringUtil.getStringReturnEmptyString(str,1, 2);			
			//Columns  3 code for modification			
			strAry[1] = StringUtil.getStringReturnEmptyString(str,3, 3).trim();
			//Columns 3-5   owner code
			//Columns 6-13 busName  14-17 rated voltage
			strAry[2] = StringUtil.getStringReturnEmptyString(str,4, 6).trim();
			strAry[3] = StringUtil.getStringReturnEmptyString(str,7, 14).trim();
			strAry[4] = StringUtil.getStringReturnEmptyString(str,15, 18).trim();
			//Columns 18-19   zone name
			strAry[5] = StringUtil.getStringReturnEmptyString(str,19, 20).trim();

			//Columns 20-24   Load MW [F] *
			//Columns 25-29   Load MVAR [F] *
			strAry[6] = StringUtil.getStringReturnEmptyString(str,21, 25).trim();
			
			
			strAry[7] = StringUtil.getStringReturnEmptyString(str,26, 30).trim();			
			//Columns 30-33   shunt MW [F] *
			//Columns 34-39   shunt MVAR [F] *
			strAry[8] = StringUtil.getStringReturnEmptyString(str,31, 34).trim();
			strAry[9] = StringUtil.getStringReturnEmptyString(str,35, 38).trim();	
			
			// Columns 38-41 pmax
			// Columns 42-46 pmax
			strAry[10] = StringUtil.getStringReturnEmptyString(str,39, 42).trim();
			strAry[11] = StringUtil.getStringReturnEmptyString(str,43, 47).trim();			
			//Qmax Qmin
			strAry[12]= StringUtil.getStringReturnEmptyString(str,48, 52).trim();
			strAry[13]= StringUtil.getStringReturnEmptyString(str,53, 57).trim();			
			//scheduled V or Vmax, Vmin
			strAry[14]= StringUtil.getStringReturnEmptyString(str,58, 61).trim();			
			strAry[15]=StringUtil.getStringReturnEmptyString(str,62, 65).trim();
			
			//remoted busName, rated voltage
			strAry[16]= StringUtil.getStringReturnEmptyString(str,66, 73).trim();
			strAry[17]= StringUtil.getStringReturnEmptyString(str,74, 77).trim();
			// used in remoted bus control, var fraction
			strAry[18]= StringUtil.getStringReturnEmptyString(str,78, 80).trim();
			
		}catch(Exception e){
			adapter.logErr(e.toString());
		}		
		return strAry;
	}
	
	private static String[] getDCLineBusDataFields(final String str,BPAAdapter adapter) {
		final String[] strAry = new String[14];
		
		try{
			//Columns  1- 2   Bus type
		    strAry[0] = StringUtil.getStringReturnEmptyString(str,1, 2);			
			//Columns  3 code for modification			
			strAry[1] = StringUtil.getStringReturnEmptyString(str,3, 3).trim();
			//Columns 3-5   owner code
			strAry[2] = StringUtil.getStringReturnEmptyString(str,4, 6).trim();
			
			//Columns 6-13 busName  14-17 rated voltage			
			strAry[3] = StringUtil.getStringReturnEmptyString(str,7, 14).trim();
			strAry[4] = StringUtil.getStringReturnEmptyString(str,15, 18).trim();
			//Columns 18-19   zone name
			strAry[5] = StringUtil.getStringReturnEmptyString(str,19, 20).trim();

			//bridge per brckt
			strAry[6] = StringUtil.getStringReturnEmptyString(str,24, 25).trim();
			//smooth reactor
			strAry[7] = StringUtil.getStringReturnEmptyString(str,26, 30).trim();			
			
			strAry[8] =StringUtil.getStringReturnEmptyString(str,31, 35).trim();
			
			strAry[9] = StringUtil.getStringReturnEmptyString(str,36, 40).trim();			
			// Columns 38-41 pmax
			// Columns 42-46 pmax
			strAry[10] = StringUtil.getStringReturnEmptyString(str,41, 45).trim();
			strAry[11] = StringUtil.getStringReturnEmptyString(str,46, 50).trim();		
			//Qmax Qmin
			strAry[12]= StringUtil.getStringReturnEmptyString(str,51, 58).trim();
			strAry[13]= StringUtil.getStringReturnEmptyString(str,59, 62).trim();
			
		}catch (Exception e){
			adapter.logErr("This DCLine bus data is not filled completely:   "+str);
		}		
		return strAry;
	}	
	
}
	
	
