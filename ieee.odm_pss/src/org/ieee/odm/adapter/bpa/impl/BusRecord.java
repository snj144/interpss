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
package org.ieee.odm.adapter.bpa.impl;

import org.ieee.odm.common.ODMException;
import org.ieee.odm.common.ODMLogger;
import org.ieee.odm.model.BaseDataSetter;
import org.ieee.odm.model.ModelStringUtil;
import org.ieee.odm.model.aclf.AclfDataSetter;
import org.ieee.odm.model.aclf.AclfModelParser;
import org.ieee.odm.schema.ActivePowerUnitType;
import org.ieee.odm.schema.AngleUnitType;
import org.ieee.odm.schema.ApparentPowerUnitType;
import org.ieee.odm.schema.LFGenCodeEnumType;
import org.ieee.odm.schema.LFLoadCodeEnumType;
import org.ieee.odm.schema.LoadflowBusXmlType;
import org.ieee.odm.schema.ReactivePowerUnitType;
import org.ieee.odm.schema.VoltageUnitType;
import org.ieee.odm.schema.YUnitType;

public class BusRecord {
	static final int swingBus=1;
	static final int pqBus=2;
	static final int pvBus=3;		
	static final int pvBusNoQLimit=4;		
	
	public static void processBusData(final String str, AclfModelParser parser) throws Exception {		
		final double baseMVA = parser.getAclfNet().getBasePower().getValue();

		// parse the input data line
		final String[] strAry = getBusDataFields(str);
		
        //busType	
		int busType=0;
		String stemp = strAry[0];
		if(stemp.equals("B")||stemp.equals("BC")||stemp.equals("BT")||stemp.equals("BV")){
			busType=pqBus;
		}
		else if(stemp.equals("BQ")||stemp.equals("BG")||stemp.equals("BF")){
			busType=pvBus;
		}
		else if(stemp.equals("BE")){
			busType=pvBusNoQLimit;
		}
		else if(stemp.equals("BS")){
			busType=swingBus;
		}
		
		/*
		 * set bus record attributes
		 * =========================
		 */
		
		// modification code
		final String modCode=strAry[1];
		//owner code
		final String ownerName=strAry[2];
		//Name
		final String busName = strAry[3];
		final String busId =  strAry[3];
		ODMLogger.getLogger().fine("Bus data loaded, busName: " + busId);

		LoadflowBusXmlType busRec = null;
		try {
			busRec = parser.createAclfBus(busId);
		} catch (ODMException e) {
			ODMLogger.getLogger().severe(e.toString());
			return;
		}		
		
		busRec.setId(busId);		
		busRec.setName(busName);
		
		// TODO set bus owner

		//basekv
		double baseKv=100.0;
		if(!strAry[4].equals("")){
			baseKv= new Double(strAry[4]).doubleValue();
		}
		busRec.setBaseVoltage(BaseDataSetter.createVoltageValue(baseKv, VoltageUnitType.KV));

		// TODO area name??
		
		//zone name
		final String zoneName= strAry[5];
		busRec.setZoneName(zoneName);
		
		/*
		 * Parse Loadflow data
		 * ===================
		 */
		
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
		final double g=ModelStringUtil.getNumberFormat(shuntMw/baseMVA);
		final double b=ModelStringUtil.getNumberFormat(shuntVar/baseMVA);

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
		
		// TODO - not sure what its meaning
		if(strAry[13].equals(".")){
			ODMLogger.getLogger().info(str+"str 13 is .");
		}
		
		double qGenMin=0.0;
		if(!strAry[13].equals("")){
			qGenMin= new Double(strAry[13]).doubleValue();
		}
		
		// TODO - not sure what its meaning
		if(strAry[14].equals(".")){
			ODMLogger.getLogger().info(str+"str 14 is .");
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
		
		/*
		 * process data and map to the ODM bus record
		 * ==========================================
		 */
		if(loadMw != 0.0 || loadMvar != 0.0 || 
				pGen!=0.0|| qGenOrQGenMax!=0.0 ||
				vMinOrAngDeg!=0.0||pGenMax!=0.0
				||g!=0||b!=0) {
			// set G B
			if (g != 0.0 || b != 0.0) {
				busRec.setShuntY(BaseDataSetter.createYValue(g, b,YUnitType.PU));
			}	
			
			// set load
			if (loadMw != 0.0 || loadMvar != 0.0) {
				AclfDataSetter.setLoadData(busRec,
						LFLoadCodeEnumType.CONST_P, loadMw,
						loadMvar, ApparentPowerUnitType.MVA);
			}
			
			if(busType==swingBus){
				// set bus voltage
				if(vpu!=0.0) {
					if(vpu > 10)
						vpu=vpu/1000;
					busRec.setVoltage(BaseDataSetter.createVoltageValue(vpu, VoltageUnitType.PU));
				}
				
				// set bus angle
				busRec.setAngle(BaseDataSetter.createAngleValue(vMinOrAngDeg, AngleUnitType.DEG));
				
				//set gen data
				if(pGen!=0.0||qGenOrQGenMax!=0.0){				
					AclfDataSetter.setGenData(busRec,
							LFGenCodeEnumType.SWING,
							vpu, VoltageUnitType.PU,
							vMinOrAngDeg, AngleUnitType.DEG,
							pGen, 0.0, ApparentPowerUnitType.MVA);
				}
				
				// set Q limit
				if(qGenOrQGenMax!=0.0||qGenMin!=0.0){
					busRec.getGenData().getEquivGen().setQLimit(BaseDataSetter.createReactivePowerLimit( 
							qGenOrQGenMax, qGenMin, ReactivePowerUnitType.MVAR));				
				}
				
				// set P limit
				if(pGenMax!=0.0){
					busRec.getGenData().getEquivGen().setPLimit(BaseDataSetter.createActivePowerLimit(
							pGenMax, 0, ActivePowerUnitType.MW));
				}	
			}
			else if(busType==pqBus){			
				AclfDataSetter.setGenData(busRec,
						LFGenCodeEnumType.NONE_GEN, 
						1.0, VoltageUnitType.PU, 0.0, AngleUnitType.DEG);
				if(pGen!=0.0||qGenOrQGenMax!=0.0){
					busRec.getGenData().getEquivGen().setCode(LFGenCodeEnumType.PQ);
					busRec.getGenData().getEquivGen()
						.setPower(BaseDataSetter.createPowerValue(
							pGen, qGenOrQGenMax, ApparentPowerUnitType.MVA));
					// set V limit
					if(vpu!=0 ||vMinOrAngDeg!=0){
					    busRec.getGenData().getEquivGen()
					    	.setVoltageLimit(BaseDataSetter.createVoltageLimit(
					    			vpu, vMinOrAngDeg, VoltageUnitType.PU));
					}			
				}
			}
			else if(busType==pvBus || busType==pvBusNoQLimit){
				// set bus voltage
				if(vpu!=0.0){
					if(vpu>10){
						vpu=vpu/1000;
					}
					busRec.setVoltage(BaseDataSetter.createVoltageValue(vpu, VoltageUnitType.PU));
				}
				// set gen data
				AclfDataSetter.setGenData(busRec,
							LFGenCodeEnumType.PV, 
							vpu, VoltageUnitType.PU, 0.0, AngleUnitType.DEG,
							pGen, 0.0, ApparentPowerUnitType.MVA);
				// set Q limit
				if(qGenOrQGenMax!=0.0||qGenMin!=0.0){
					busRec.getGenData().getEquivGen().setQLimit(BaseDataSetter.createReactivePowerLimit( 
							qGenOrQGenMax, qGenMin, ReactivePowerUnitType.MVAR));	
					// for "BE" type the limit if disabled
					if (busType==pvBusNoQLimit)
						busRec.getGenData().getEquivGen().getQLimit().setActive(false);
				}
				// set P limit
				if(pGenMax!=0.0){
					busRec.getGenData().getEquivGen().setPLimit(BaseDataSetter.createActivePowerLimit(
							pGenMax, 0, ActivePowerUnitType.MW));
				}	
				
			}
				
			//for BG and BX, controlled bus name and voltage
			// desired bus voltage is specified in strAry[14], equals to vpu
			final String controlledBus= strAry[16];
			double controlledBusRatedVol=0.0;
			if(!strAry[17].equals("")){
				controlledBusRatedVol = new Double(strAry[17]).doubleValue();			
			}
			
			if(strAry[0].equals("BG")||strAry[0].equals("BX")){
				if(!controlledBus.equals("")) {			
					busRec.getGenData().getEquivGen().getRemoteVoltageControlBus().setIdRef(controlledBus);
					busRec.getGenData().getEquivGen().setDesiredVoltage(BaseDataSetter.createVoltageValue(
							controlledBusRatedVol, VoltageUnitType.PU));
				}
			}
		}						
	}
	
	private static String[] getBusDataFields(final String str) throws Exception {
		final String[] strAry = new String[19];
/* sample data
B     XIANLS= 500.XX305.3 -215.                                                                      
*/
		//Columns  1- 2   Bus type
	    strAry[0] = ModelStringUtil.getStringReturnEmptyString(str,1, 2); 
		//Columns  3 code for modification			
		strAry[1] = ModelStringUtil.getStringReturnEmptyString(str,3, 3).trim();
		//Columns 3-5   owner code
		//Columns 6-13 busName  14-17 rated voltage
		strAry[2] = ModelStringUtil.getStringReturnEmptyString(str,4, 6).trim();
		strAry[3] = ModelStringUtil.getStringReturnEmptyString(str,7, 14).trim();			
		strAry[4] = ModelStringUtil.getStringReturnEmptyString(str,15, 18).trim();
		//Columns 18-19   zone name
		strAry[5] = ModelStringUtil.getStringReturnEmptyString(str,19, 20).trim();
		//Columns 20-24   Load MW [F] *
		//Columns 25-29   Load MVAR [F] *
		strAry[6] = ModelStringUtil.getStringReturnEmptyString(str,21, 25).trim();
		strAry[7] = ModelStringUtil.getStringReturnEmptyString(str,26, 30).trim();			
		//Columns 30-33   shunt MW [F] *
		//Columns 34-39   shunt MVAR [F] *
		strAry[8] = ModelStringUtil.getStringReturnEmptyString(str,31, 34).trim();
		strAry[9] = ModelStringUtil.getStringReturnEmptyString(str,35, 38).trim();	
		// Columns 38-41 pmax
		// Columns 42-46 pmax
		strAry[10] = ModelStringUtil.getStringReturnEmptyString(str,39, 42).trim();			
		strAry[11] = ModelStringUtil.getStringReturnEmptyString(str,43, 47).trim();
		//Qmax Qmin
		strAry[12]= ModelStringUtil.getStringReturnEmptyString(str,48, 52).trim();
		strAry[13]= ModelStringUtil.getStringReturnEmptyString(str,53, 57).trim();			
		//scheduled V or Vmax, Vmin
		strAry[14]= ModelStringUtil.getStringReturnEmptyString(str,58, 61).trim();			
		strAry[15]=ModelStringUtil.getStringReturnEmptyString(str,62, 65).trim();
		//remoted busName, rated voltage
		strAry[16]= ModelStringUtil.getStringReturnEmptyString(str,66, 73).trim();
		strAry[17]= ModelStringUtil.getStringReturnEmptyString(str,74, 77).trim();
		// used in remoted bus control, var fraction
		strAry[18]= ModelStringUtil.getStringReturnEmptyString(str,78, 80).trim();
		return strAry;
	}
}
	
	
