/*
 * @(#)BPADynamicRecord.java   
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
 * @Author Stephen Hau
 * @Version 1.0
 * @Date 02/11/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.ieee.pes.odm.pss.adapter.bpa;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ExcBPAFJXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ExcIEEE1968Type1XmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ExcIEEE1981NewExcSystemXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ExcIEEE1981ST1XmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ExcIEEE1981TypeAC2XmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ExcIEEETypeDC2XmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ExciterXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PerUnitXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TimePeriodXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TransientSimulationXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageXmlType;
import org.ieee.pes.odm.pss.model.IEEEODMPSSModelParser;
import org.ieee.pes.odm.pss.model.ODMData2XmlHelper;
import org.ieee.pes.odm.pss.model.StringUtil;
import org.ieee.pes.odm.pss.model.TranStabSimuHelper;

public class BPADynamicExciterRecord {
	
	public static void processExciterData(String str, TransientSimulationXmlType tranSimu,
    		IEEEODMPSSModelParser parser ,BPAAdapter adapter  ){
    	final String strAry[]=getExciterDataFields(str,adapter);
    	
    	int type=0;
    	int EA=1;
    	int EC=2;
    	int EK=3;    	
    	int FJ=4;
    	int FK=5;
    	int FQ=6;
    	int FV=7;
    	int FF=8;
    	int FA=9;
    	
    	if(strAry[0].equals("EA")){
    		type=EA;
    	}else if(strAry[0].equals("EC")){
    		type=EC;
    	}else if(strAry[0].equals("EK")){
    		type=EK;
    	}else if(strAry[0].equals("FJ")){
    		type=FJ;
    	}else if(strAry[0].equals("FK")){
    		type=FK;
    	}else if(strAry[0].equals("FQ")){
    		type=FQ;
    	}else if(strAry[0].equals("FV")){
    		type=FV;
    	}else if(strAry[0].equals("FF")){
    		type=FF;
    	}else if(strAry[0].equals("FA")){
    		type=FA;
    	}
    	
    	if(type==EA||type==EC||type==EK){
    		ExciterXmlType exc=TranStabSimuHelper.addNewExciter(tranSimu);
    		exc.setExciterType(ExciterXmlType.ExciterType.IEEE_1968_TYPE_1);
    		ExcIEEE1968Type1XmlType type1968= exc.
    		                       addNewExciterModel().addNewIEEE1968Type1();
    		//busId
    		String busId=strAry[1];
    		exc.addNewLocatedBus().setName(busId);  
    		//bus Voltage 
    		double voltage=StringUtil.getDouble(strAry[2], 0.0);
    		ODMData2XmlHelper.setVoltageData(exc.addNewBusRatedVoltage(), 
    	    					voltage, VoltageXmlType.Unit.KV);
    		   		    		
    		//excId
    		String excId="1";
    		if(!strAry[3].equals("")){
    			excId=strAry[3];
    		} 
    		exc.addNewExcId().setName(excId);
    		//TR
    		double Tr=StringUtil.getDouble(strAry[4], 0.0);
    		ODMData2XmlHelper.setTimePeriodData(type1968.addNewTR(), Tr, TimePeriodXmlType.Unit.SEC);
    		    		
    		//KA for all, KV for EE
    		double Ka=StringUtil.getDouble(strAry[5], 0.0);
    		ODMData2XmlHelper.setPUData(type1968.addNewKA(), Ka, PerUnitXmlType.Unit.PU);
    		   		
    		//TA for all, TRH for EE
    		double Ta=StringUtil.getDouble(strAry[6], 0.0);
    		ODMData2XmlHelper.setTimePeriodData(type1968.addNewTA(), Ta, TimePeriodXmlType.Unit.SEC);
    		
    		//VRminMult, VRmax*multi=Vrmin. VRmin for ED EJ
    		double multi=StringUtil.getDouble(strAry[8], 0.0);
    		// KE
    		double Ke=StringUtil.getDouble(strAry[9], 0.0);
    		ODMData2XmlHelper.setPUData(type1968.addNewKE(), Ke, PerUnitXmlType.Unit.PU);
    		    		
    		//TE
    		double Te= StringUtil.getDouble(strAry[10], 0.0);
    		ODMData2XmlHelper.setTimePeriodData(type1968.addNewTE(), Te, TimePeriodXmlType.Unit.SEC);
    		
    		//SE0.75MAX for all, KI for DD
    		type1968.setE1(0.75);
    		double SE1= StringUtil.getDouble(strAry[11], 0.0);
    		type1968.setSE1(SE1);    		
    		
    		//EFDMin
    		double Efdmin=StringUtil.getDouble(strAry[13], 0.0);
    		ODMData2XmlHelper.setPUData(type1968.addNewEFDMIN(),
    				        Efdmin, PerUnitXmlType.Unit.PU);
    		
    		//EFDMax for all, VNmax for ED
    		double Efdmax=StringUtil.getDouble(strAry[14], 0.0);  		
    		// SEmax for all, Kp for DD
    		type1968.setE2(Efdmax);
    		double SE2= StringUtil.getDouble(strAry[12], 0.0);
    		type1968.setSE2(SE2);    		
    		//KF
    		double Kf= StringUtil.getDouble(strAry[15], 0.0);
    		ODMData2XmlHelper.setPUData(type1968.addNewKF(), Kf, PerUnitXmlType.Unit.PU);
    		    		
    		//TF    		
    		double Tf= StringUtil.getDouble(strAry[16], 0.0);
    		ODMData2XmlHelper.setTimePeriodData(type1968.addNewTF(), Tf, TimePeriodXmlType.Unit.SEC);    		
    		//VRmax=(SE2+Ke)*EFDmax,Vrmin
    		
    		double VRmax=(SE2+Ke)*Efdmax;
    		double VRmin=VRmax*multi;
    		ODMData2XmlHelper.setPUData(type1968.addNewVRMAX(), VRmax, PerUnitXmlType.Unit.PU);
    		ODMData2XmlHelper.setPUData(type1968.addNewVRMIN(), VRmin, PerUnitXmlType.Unit.PU);
    		
    		//EXDC2
    	}else if(type==FA){
    		ExciterXmlType exc=TranStabSimuHelper.addNewExciter(tranSimu);
    		exc.setExciterType(ExciterXmlType.ExciterType.IEEE_TYPE_DC_2);
    		ExcIEEETypeDC2XmlType exc_dc2= exc.addNewExciterModel().addNewIEEETypeDC2();
			//busId
    		String busId=strAry[1];
			exc.addNewLocatedBus().setName(busId);		
			
			//bus Voltage
			double voltage= StringUtil.getDouble(strAry[2], 0.0);
			ODMData2XmlHelper.setVoltageData(exc.addNewBusRatedVoltage(), voltage, VoltageXmlType.Unit.KV);
			//excId
			String excId="1";
			if(!strAry[3].equals("")){
				excId=strAry[3];				
			}	
			exc.addNewExcId().setName(excId);
			//TR
			
			double Tr= StringUtil.getDouble(strAry[6], 0.0);
			ODMData2XmlHelper.setTimePeriodData(exc_dc2.addNewTR(), Tr, TimePeriodXmlType.Unit.SEC);			
			
			// TB
			double Tb= StringUtil.getDouble(strAry[9], 0.0);
			ODMData2XmlHelper.setTimePeriodData(exc_dc2.addNewTB(), Tb, TimePeriodXmlType.Unit.SEC);
			
			//TC
			double Tc= StringUtil.getDouble(strAry[10], 0.0);
			ODMData2XmlHelper.setTimePeriodData(exc_dc2.addNewTC(), Tc, TimePeriodXmlType.Unit.SEC);
			
			//KA, KV for FE
			double Ka= StringUtil.getDouble(strAry[11], 0.0);
			ODMData2XmlHelper.setPUData(exc_dc2.addNewKA(), Ka, PerUnitXmlType.Unit.PU);			
			// TA, TRH for FE
			double Ta= StringUtil.getDouble(strAry[12], 0.0);
			ODMData2XmlHelper.setTimePeriodData(exc_dc2.addNewTA(), Ta, TimePeriodXmlType.Unit.SEC);
			
			//VRmax, Vamax for FH
			double Vrmax= StringUtil.getDouble(strAry[13], 0.0);
			ODMData2XmlHelper.setPUData(exc_dc2.addNewVRMAX(), Vrmax, PerUnitXmlType.Unit.PU);
			
			//VRmin, Vamin			
			double Vrmin= StringUtil.getDouble(strAry[14], 0.0);	
			
			ODMData2XmlHelper.setPUData(exc_dc2.addNewVRMIN(), Vrmin, PerUnitXmlType.Unit.PU);
			
			//Ke
			double ke=StringUtil.getDouble(strAry[15], 0.0);
			ODMData2XmlHelper.setPUData(exc_dc2.addNewKE(), ke, PerUnitXmlType.Unit.PU);
			
			//Te
			double Te=StringUtil.getDouble(strAry[16], 0.0);
			ODMData2XmlHelper.setTimePeriodData(exc_dc2.addNewTE(), Te, TimePeriodXmlType.Unit.SEC);
			
			// IEEE 1981 ST1
    	}else if(type==FK){
    		ExciterXmlType exc=TranStabSimuHelper.addNewExciter(tranSimu);
    		exc.setExciterType(ExciterXmlType.ExciterType.IEEE_1981_ST_1);
    		ExcIEEE1981ST1XmlType exc_st1= exc.addNewExciterModel().addNewIEEE1981ST1();
			//busId
    		String busId=strAry[1];
			exc.addNewLocatedBus().setName(busId);		
			
			//bus Voltage
			double voltage= StringUtil.getDouble(strAry[2], 0.0);
			ODMData2XmlHelper.setVoltageData(exc.addNewBusRatedVoltage(), voltage, VoltageXmlType.Unit.KV);
			//excId
			String excId="1";
			if(!strAry[3].equals("")){
				excId=strAry[3];
				
			}	
			exc.addNewExcId().setName(excId);
			//TR
			
			double Tr= StringUtil.getDouble(strAry[6], 0.0);
			ODMData2XmlHelper.setTimePeriodData(exc_st1.addNewTR(), Tr, TimePeriodXmlType.Unit.SEC);
			
			//VIMax for G K L,VAmax for FF
			double Vimax= StringUtil.getDouble(strAry[7], 0.0);
			ODMData2XmlHelper.setPUData(exc_st1.addNewVIMAX(), Vimax, PerUnitXmlType.Unit.PU);
			
			//VIMin for G K L,VAmin for FF
			//VIMax for G K L,VAmax for FF
			double Vimin= StringUtil.getDouble(strAry[8], 0.0);
			ODMData2XmlHelper.setPUData(exc_st1.addNewVIMIN(), Vimin, PerUnitXmlType.Unit.PU);
			// TB
			double Tb= StringUtil.getDouble(strAry[9], 0.0);
			ODMData2XmlHelper.setTimePeriodData(exc_st1.addNewTB(), Tb, TimePeriodXmlType.Unit.SEC);
			
			//TC
			double Tc= StringUtil.getDouble(strAry[10], 0.0);
			ODMData2XmlHelper.setTimePeriodData(exc_st1.addNewTC(), Tc, TimePeriodXmlType.Unit.SEC);
			
			//KA, KV for FE
			double Ka= StringUtil.getDouble(strAry[11], 0.0);
			ODMData2XmlHelper.setPUData(exc_st1.addNewKA(), Ka, PerUnitXmlType.Unit.PU);			
			// TA, TRH for FE
			double Ta= StringUtil.getDouble(strAry[12], 0.0);
			ODMData2XmlHelper.setTimePeriodData(exc_st1.addNewTA(), Ta, TimePeriodXmlType.Unit.SEC);
			
			//VRmax, Vamax for FH
			double Vrmax= StringUtil.getDouble(strAry[13], 0.0);
			ODMData2XmlHelper.setPUData(exc_st1.addNewVRMAX(), Vrmax, PerUnitXmlType.Unit.PU);
			
			//VRmin, Vamin			
			double Vrmin= StringUtil.getDouble(strAry[14], 0.0);	
			
			ODMData2XmlHelper.setPUData(exc_st1.addNewVRMIN(), Vrmin, PerUnitXmlType.Unit.PU);
			   		
			
			
    	}else if(type==FJ){
    		ExciterXmlType exc=TranStabSimuHelper.addNewExciter(tranSimu);
    		exc.setExciterType(ExciterXmlType.ExciterType.BPAFJ);
    		ExcBPAFJXmlType BPAFJ= exc.addNewExciterModel().addNewBPAFJ();
			//busId
    		String busId=strAry[1];
			exc.addNewLocatedBus().setName(busId);		
			
			//bus Voltage
			double voltage= StringUtil.getDouble(strAry[2], 0.0);
			ODMData2XmlHelper.setVoltageData(exc.addNewBusRatedVoltage(), voltage, VoltageXmlType.Unit.KV);
			//excId
			String excId="1";
			if(!strAry[3].equals("")){
				excId=strAry[3];				
			}	
			exc.addNewExcId().setName(excId);
			// TB
			double Tb= StringUtil.getDouble(strAry[9], 0.0);
			ODMData2XmlHelper.setTimePeriodData(BPAFJ.addNewTB(), Tb, TimePeriodXmlType.Unit.SEC);
			
			//TC
			double Tc= StringUtil.getDouble(strAry[10], 0.0);
			ODMData2XmlHelper.setTimePeriodData(BPAFJ.addNewTC(), Tc, TimePeriodXmlType.Unit.SEC);
			
			//KA, KV for FE
			double Ka= StringUtil.getDouble(strAry[11], 0.0);
			ODMData2XmlHelper.setPUData(BPAFJ.addNewKA(), Ka, PerUnitXmlType.Unit.PU);			
			// TA, TRH for FE
			double Ta= StringUtil.getDouble(strAry[12], 0.0);
			ODMData2XmlHelper.setTimePeriodData(BPAFJ.addNewTA(), Ta, TimePeriodXmlType.Unit.SEC);
			
			//VRmax, Vamax for FH
			double Vrmax=StringUtil.getDouble(strAry[13], 0.0);
			ODMData2XmlHelper.setPUData(BPAFJ.addNewVRMAX(), Vrmax, PerUnitXmlType.Unit.PU);
			
			//VRmin, Vamin
			double Vrmin= StringUtil.getDouble(strAry[14], 0.0);
			ODMData2XmlHelper.setPUData(BPAFJ.addNewVRMIN(), Vrmin, PerUnitXmlType.Unit.PU);
    	}else if(type==FQ||type==FV){
    		ExciterXmlType exc=TranStabSimuHelper.addNewExciter(tranSimu);
    		exc.setExciterType(ExciterXmlType.ExciterType.IEEE_1981_NEW_EXC_SYSTEM);
    		ExcIEEE1981NewExcSystemXmlType newExc=exc.addNewExciterModel().addNewIEEE1981NewExcSystem();
    		
			//busId
    		String busId=strAry[1];
			exc.addNewLocatedBus().setName(busId);
			//bus Voltage
			double voltage=StringUtil.getDouble(strAry[2], 0.0);
			ODMData2XmlHelper.setVoltageData(exc.addNewBusRatedVoltage(), 
					voltage, VoltageXmlType.Unit.KV);			
			//excId
			String excId="1";
			if(!strAry[3].equals("")){
				excId=strAry[3];				
			}			
			exc.addNewExcId().setName(excId);
			//Rc
			double Rc=StringUtil.getDouble(strAry[4], 0.0);
			ODMData2XmlHelper.setPUData(newExc.addNewRc(), Rc, PerUnitXmlType.Unit.PU);
						
			//Xc
			double Xc=StringUtil.getDouble(strAry[5], 0.0);
			ODMData2XmlHelper.setPUData(newExc.addNewXc(), Xc, PerUnitXmlType.Unit.PU);
						
			//TR
			double Tr=StringUtil.getDouble(strAry[6], 0.0);
			ODMData2XmlHelper.setTimePeriodData(newExc.addNewTr(), Tr, TimePeriodXmlType.Unit.SEC);
						
			//K
			double k=StringUtil.getDouble(strAry[7], 0.0);
			ODMData2XmlHelper.setPUData(newExc.addNewK(), k, PerUnitXmlType.Unit.PU);
						
			//Kv
			double kv=StringUtil.getDouble(strAry[8], 0.0);
			ODMData2XmlHelper.setPUData(newExc.addNewKv(), kv, PerUnitXmlType.Unit.PU);
						
			// T1
			double T1=StringUtil.getDouble(strAry[9], 0.0);
			ODMData2XmlHelper.setTimePeriodData(newExc.addNewT1(), T1, TimePeriodXmlType.Unit.SEC);
			
			//T2
			double T2=StringUtil.getDouble(strAry[10], 0.0);
			ODMData2XmlHelper.setTimePeriodData(newExc.addNewT2(), T2, TimePeriodXmlType.Unit.SEC);
						
			//T3			
			double T3=StringUtil.getDouble(strAry[11], 0.0);
			ODMData2XmlHelper.setTimePeriodData(newExc.addNewT3(), T3, TimePeriodXmlType.Unit.SEC);
						
			// T4			
			double T4=StringUtil.getDouble(strAry[12], 0.0);
			ODMData2XmlHelper.setTimePeriodData(newExc.addNewT4(), T4, TimePeriodXmlType.Unit.SEC);
						
			//KA
			double ka=StringUtil.getDouble(strAry[13], 0.0);
			ODMData2XmlHelper.setPUData(newExc.addNewKa(), ka, PerUnitXmlType.Unit.PU);
					
			//TA
			double Ta=StringUtil.getDouble(strAry[14], 0.0);
			ODMData2XmlHelper.setTimePeriodData(newExc.addNewTa(), Ta, TimePeriodXmlType.Unit.SEC);
						
			//KF
			double kf=StringUtil.getDouble(strAry[15], 0.0);
			ODMData2XmlHelper.setPUData(newExc.addNewKf(), kf, PerUnitXmlType.Unit.PU);
			
			//TF
			double Tf=StringUtil.getDouble(strAry[16], 0.0);
			ODMData2XmlHelper.setTimePeriodData(newExc.addNewTf(), Tf, TimePeriodXmlType.Unit.SEC);
					
			//KH
			double kh=StringUtil.getDouble(strAry[17], 0.0);
			ODMData2XmlHelper.setPUData(newExc.addNewKh(), kh, PerUnitXmlType.Unit.PU);
			
			
    	}else if(type==FF){
    		ExciterXmlType exc=TranStabSimuHelper.addNewExciter(tranSimu);
    		exc.setExciterType(ExciterXmlType.ExciterType.IEEE_1981_TYPE_AC_2);
    		ExcIEEE1981TypeAC2XmlType newExc=exc.addNewExciterModel().addNewIEEE1981TypeAC2();
    		
			//busId
    		String busId=strAry[1];
			exc.addNewLocatedBus().setName(busId);
			//bus Voltage
			double voltage=StringUtil.getDouble(strAry[2], 0.0);
			ODMData2XmlHelper.setVoltageData(exc.addNewBusRatedVoltage(), 
					voltage, VoltageXmlType.Unit.KV);			
			//excId
			String excId="1";
			if(!strAry[3].equals("")){
				excId=strAry[3];				
			}			
			exc.addNewExcId().setName(excId);
			//TR
			double Tr=StringUtil.getDouble(strAry[6], 0.0);
			ODMData2XmlHelper.setTimePeriodData(newExc.addNewTR(), Tr, TimePeriodXmlType.Unit.SEC);
						
			//Vamax
			double Vamax=StringUtil.getDouble(strAry[7], 0.0);
			ODMData2XmlHelper.setPUData(newExc.addNewVAMAX(), Vamax, PerUnitXmlType.Unit.PU);
						
			//Vamin
			double Vamin=StringUtil.getDouble(strAry[8], 0.0);
			ODMData2XmlHelper.setPUData(newExc.addNewVAMIN(), Vamin, PerUnitXmlType.Unit.PU);
						
			// Tb
			double Tb=StringUtil.getDouble(strAry[9], 0.0);
			ODMData2XmlHelper.setTimePeriodData(newExc.addNewTB(), Tb, TimePeriodXmlType.Unit.SEC);
			
			//Tc
			double Tc=StringUtil.getDouble(strAry[10], 0.0);
			ODMData2XmlHelper.setTimePeriodData(newExc.addNewTC(), Tc, TimePeriodXmlType.Unit.SEC);
						
			//Ka			
			double Ka=StringUtil.getDouble(strAry[11], 0.0);
			ODMData2XmlHelper.setPUData(newExc.addNewKA(), Ka, PerUnitXmlType.Unit.PU);
						
			// Ta			
			double Ta=StringUtil.getDouble(strAry[12], 0.0);
			ODMData2XmlHelper.setTimePeriodData(newExc.addNewTA(), Ta, TimePeriodXmlType.Unit.SEC);
			
			//Vrmax
			double Vrmax=StringUtil.getDouble(strAry[13], 0.0);
			ODMData2XmlHelper.setPUData(newExc.addNewVRMAX(), Vrmax, PerUnitXmlType.Unit.PU);
						
			//Vrmin
			double Vrmin=StringUtil.getDouble(strAry[14], 0.0);
			ODMData2XmlHelper.setPUData(newExc.addNewVRMIN(), Vrmin, PerUnitXmlType.Unit.PU);
									
			//Ke
			double ke=StringUtil.getDouble(strAry[15], 0.0);
			ODMData2XmlHelper.setPUData(newExc.addNewKE(), ke, PerUnitXmlType.Unit.PU);
			
			//Te
			double Te=StringUtil.getDouble(strAry[16], 0.0);
			ODMData2XmlHelper.setTimePeriodData(newExc.addNewTE(), Te, TimePeriodXmlType.Unit.SEC);
		  		
    		
    	}else if(str.substring(0, 2).trim().equals("FZ")||
    			str.substring(0, 2).trim().equals("F+")){
    		String busId=str.substring(3, 11).trim();
        	String excId="1";
        	if(!str.substring(15, 16).trim().equals("")){
        		excId=str.substring(15, 16).trim();
        	}    	
        	ExciterXmlType exc=ODMData2XmlHelper.getExciterRecord(tranSimu, busId, excId);
        	if(str.substring(0, 2).trim().equals("FZ")){
        		if(exc.getExciterType().equals(ExciterXmlType.ExciterType.IEEE_1981_ST_1)){        		
            		//KF
            		double Kf= StringUtil.getDouble(strAry[8], 0.0);
            		ODMData2XmlHelper.setPUData(exc.getExciterModel().getIEEE1981ST1().addNewKF(), 
            				Kf, PerUnitXmlType.Unit.PU);
            					
        			// TF
            		double TF= StringUtil.getDouble(strAry[9], 0.0);
        			ODMData2XmlHelper.setTimePeriodData(exc.getExciterModel().getIEEE1981ST1().addNewTF(), 
        					TF, TimePeriodXmlType.Unit.SEC);
        			strAry[9]=str.substring(41, 46).trim();
        			//KC
        			double Kc= StringUtil.getDouble(strAry[10], 0.0);
            		ODMData2XmlHelper.setPUData(exc.getExciterModel().getIEEE1981ST1().addNewKC(), 
            				Kc, PerUnitXmlType.Unit.PU); 
            	}else if(exc.getExciterType().equals(ExciterXmlType.ExciterType.BPAFJ)){        		
            		//EFDmax
            		double EFDmax= StringUtil.getDouble(strAry[7], 0.0);
        			ODMData2XmlHelper.setPUData(exc.getExciterModel().getBPAFJ().addNewEFDMAX(), 
        					EFDmax, PerUnitXmlType.Unit.PU);
        			
        			//EFDmin
        			double EFDmin= StringUtil.getDouble(strAry[6], 0.0);
        			ODMData2XmlHelper.setPUData(exc.getExciterModel().getBPAFJ().addNewEFDMIN(), 
        					EFDmin, PerUnitXmlType.Unit.PU);    		
        			//KF
            		double Kf= StringUtil.getDouble(strAry[8], 0.0);
            		ODMData2XmlHelper.setPUData(exc.getExciterModel().getBPAFJ().addNewKF(), 
            				Kf, PerUnitXmlType.Unit.PU);
            					
        			// TF
            		double TF= StringUtil.getDouble(strAry[9], 0.0);
        			ODMData2XmlHelper.setTimePeriodData(exc.getExciterModel().getBPAFJ().addNewTF(), 
        					TF, TimePeriodXmlType.Unit.SEC);
        			
        			//KC
        			double Kc= StringUtil.getDouble(strAry[10], 0.0);
            		ODMData2XmlHelper.setPUData(exc.getExciterModel().getBPAFJ().addNewKC(), 
            				Kc, PerUnitXmlType.Unit.PU);
            	}else if(exc.getExciterType().equals(ExciterXmlType.ExciterType.IEEE_TYPE_DC_2)){
            		           		
            		//Se1            		
            		double SE1=StringUtil.getDouble(strAry[4], 0.0);  
            		exc.getExciterModel().getIEEETypeDC2().setSE1(SE1);
            		//Se2            		
            		double SE2=StringUtil.getDouble(strAry[5], 0.0);  
            		exc.getExciterModel().getIEEETypeDC2().setSE1(SE2);
            		// e1
            		double E1=StringUtil.getDouble(strAry[7], 0.0);  
            		exc.getExciterModel().getIEEETypeDC2().setE1(E1);
            		// e2
            		double E2=0.75*StringUtil.getDouble(strAry[7], 0.0);  
            		exc.getExciterModel().getIEEETypeDC2().setE1(E2);
            		//Kf
        			double Kf= StringUtil.getDouble(strAry[8], 0.0);
            		ODMData2XmlHelper.setPUData(exc.getExciterModel().getIEEETypeDC2().addNewKF(), 
            				Kf, PerUnitXmlType.Unit.PU);
            		// TF
            		double TF= StringUtil.getDouble(strAry[9], 0.0);
        			ODMData2XmlHelper.setTimePeriodData(exc.getExciterModel().getIEEETypeDC2().addNewTF1(), 
        					TF, TimePeriodXmlType.Unit.SEC);
        			
            	}else if(exc.getExciterType().equals(ExciterXmlType.ExciterType.IEEE_1981_TYPE_AC_2)){
            		           		
            		//Se1            		
            		double SE1=StringUtil.getDouble(strAry[4], 0.0);  
            		exc.getExciterModel().getIEEE1981TypeAC2().setSE1(SE1);
            		//Se2            		
            		double SE2=StringUtil.getDouble(strAry[5], 0.0);  
            		exc.getExciterModel().getIEEE1981TypeAC2().setSE1(SE2);
            		// e1
            		double E1=StringUtil.getDouble(strAry[7], 0.0);  
            		exc.getExciterModel().getIEEE1981TypeAC2().setE1(E1);
            		// e2
            		double E2=0.75*StringUtil.getDouble(strAry[7], 0.0);  
            		exc.getExciterModel().getIEEE1981TypeAC2().setE1(E2);
            		//Kf
        			double Kf= StringUtil.getDouble(strAry[8], 0.0);
            		ODMData2XmlHelper.setPUData(exc.getExciterModel().getIEEE1981TypeAC2().addNewKF(), 
            				Kf, PerUnitXmlType.Unit.PU);
            		// TF
            		double TF= StringUtil.getDouble(strAry[9], 0.0);
        			ODMData2XmlHelper.setTimePeriodData(exc.getExciterModel().getIEEE1981TypeAC2().addNewTF(), 
        					TF, TimePeriodXmlType.Unit.SEC);
        			//Kc
        			double Kc= StringUtil.getDouble(strAry[10], 0.0);
            		ODMData2XmlHelper.setPUData(exc.getExciterModel().getIEEE1981TypeAC2().addNewKC(), 
            				Kc, PerUnitXmlType.Unit.PU);
            		//Kd
        			double Kd= StringUtil.getDouble(strAry[11], 0.0);
            		ODMData2XmlHelper.setPUData(exc.getExciterModel().getIEEE1981TypeAC2().addNewKD(), 
            				Kd, PerUnitXmlType.Unit.PU);
            		//Kb
        			double Kb= StringUtil.getDouble(strAry[12], 0.0);
            		ODMData2XmlHelper.setPUData(exc.getExciterModel().getIEEE1981TypeAC2().addNewKB(), 
            				Kb, PerUnitXmlType.Unit.PU);
            		//Kl
        			double Kl= StringUtil.getDouble(strAry[13], 0.0);
            		ODMData2XmlHelper.setPUData(exc.getExciterModel().getIEEE1981TypeAC2().addNewKL(), 
            				Kl, PerUnitXmlType.Unit.PU);
            		//Kh
        			double Kh= StringUtil.getDouble(strAry[14], 0.0);
            		ODMData2XmlHelper.setPUData(exc.getExciterModel().getIEEE1981TypeAC2().addNewKH(), 
            				Kh, PerUnitXmlType.Unit.PU);
            		//vlr
        			double vlr= StringUtil.getDouble(strAry[15], 0.0);
            		ODMData2XmlHelper.setPUData(exc.getExciterModel().getIEEE1981TypeAC2().addNewVLR(), 
            				vlr, PerUnitXmlType.Unit.PU);
            	}
        		
        	}else if(str.substring(0, 2).trim().equals("F+")){
        		
        		ExcIEEE1981NewExcSystemXmlType newExc=exc.
        		                   getExciterModel().getIEEE1981NewExcSystem();        		
        		//VAMAX 
        		double Vamax= StringUtil.getDouble(strAry[4], 0.0);
        		ODMData2XmlHelper.setPUData(newExc.addNewVAmax(), 
        				Vamax, PerUnitXmlType.Unit.PU);    		
    			
    			//VAMIN 
        		double Vamin= StringUtil.getDouble(strAry[5], 0.0);
        		ODMData2XmlHelper.setPUData(newExc.addNewVAmin(), 
        				Vamin, PerUnitXmlType.Unit.PU);
    			strAry[5]=str.substring(21, 26).trim();
    			//KB
    			double Kb=StringUtil.getDouble(strAry[6], 0.0);
        		ODMData2XmlHelper.setPUData(newExc.addNewKb(), 
            				Kb, PerUnitXmlType.Unit.PU);
        		    			
    			//T5
        		double T5=StringUtil.getDouble(strAry[7], 0.0);
        		ODMData2XmlHelper.setTimePeriodData(newExc.addNewT5(), 
        					T5, TimePeriodXmlType.Unit.SEC);
        					
    			//KE
        		double Ke=StringUtil.getDouble(strAry[8], 0.0);
        		ODMData2XmlHelper.setPUData(newExc.addNewKe(), 
            				Ke, PerUnitXmlType.Unit.PU);
        			
    			// TE
        		double Te=StringUtil.getDouble(strAry[9], 0.0);
        		ODMData2XmlHelper.setTimePeriodData(newExc.addNewTe(), 
        					Te, TimePeriodXmlType.Unit.SEC);
        				
    			//SE1-0.75
        		double SE1=StringUtil.getDouble(strAry[10], 0.0);
        		    newExc.setE1(0.75);
        			newExc.setSE1(SE1);
        				
    			// VRMAX
    			double Vrmax= StringUtil.getDouble(strAry[12], 0.0);
        		ODMData2XmlHelper.setPUData(newExc.addNewVRmax(), 
        				Vrmax, PerUnitXmlType.Unit.PU); 			
    			//VRMIN
    			double Vrmin= StringUtil.getDouble(strAry[13], 0.0);
        		ODMData2XmlHelper.setPUData(newExc.addNewVRmin(), 
        				Vrmin, PerUnitXmlType.Unit.PU);			
    			//KC
        		double KC=StringUtil.getDouble(strAry[14], 0.0);
        		ODMData2XmlHelper.setPUData(newExc.addNewKc(), 
            				KC, PerUnitXmlType.Unit.PU);
        		    					
    			//KD
        		double Kd=StringUtil.getDouble(strAry[15], 0.0);
        		ODMData2XmlHelper.setPUData(newExc.addNewKd(), 
            				Kd, PerUnitXmlType.Unit.PU);
        					
    			//KL1
        		double KL1=StringUtil.getDouble(strAry[16], 0.0);
        		ODMData2XmlHelper.setPUData(newExc.addNewKL1(), 
            				KL1, PerUnitXmlType.Unit.PU);
        				
    			//VLIR
        		double VLIR=StringUtil.getDouble(strAry[17], 0.0);
        		ODMData2XmlHelper.setPUData(newExc.addNewVL1R(), 
            				VLIR, PerUnitXmlType.Unit.PU);
        					
    			//EFDMAX
        		double EFDMAX=StringUtil.getDouble(strAry[18], 0.0);
        		
        		ODMData2XmlHelper.setPUData(newExc.addNewEFDmax(), 
        				EFDMAX, PerUnitXmlType.Unit.PU);
        		//SE2--EFDMAX
        		double SE2=0.0;
        		if(!strAry[11].equals("")){
        			SE2=new Double(strAry[11]).doubleValue();
        			newExc.setE2(EFDMAX);
        			newExc.setSE2(SE2);
        		}    		
        	}    		
    	}		
	}
	
	 private static String[] getExciterDataFields ( final String str
			 ,BPAAdapter adapter  ) {
			
	    	
	    	final String[] strAry = new String[19];	
	    	
	    	try{
	    		if(str.substring(0,1).trim().equals("E")){
					strAry[0]=StringUtil.getStringReturnEmptyString(str,1, 2).trim();
					//busId
					strAry[1]=StringUtil.getStringReturnEmptyString(str,4, 11).trim();
					//bus Voltage
					strAry[2]=StringUtil.getStringReturnEmptyString(str,12, 15).trim();
					//excId
					strAry[3]=StringUtil.getStringReturnEmptyString(str,16, 16).trim();
					//TR
					strAry[4]=StringUtil.getStringReturnEmptyString(str,17, 20).trim();
					//KA for all, KV for EE
					strAry[5]=StringUtil.getStringReturnEmptyString(str,21, 25).trim();
					//TA for all, TRH for EE
					strAry[6]=StringUtil.getStringReturnEmptyString(str,26, 29).trim();
					//TA1
					strAry[7]=StringUtil.getStringReturnEmptyString(str,30, 33).trim();
					//VRminMult, VRmax, VRmin for ED EJ
					strAry[8]=StringUtil.getStringReturnEmptyString(str,34, 37).trim();
					// KE
					strAry[9]=StringUtil.getStringReturnEmptyString(str,38, 41).trim();
					//TE
					strAry[10]=StringUtil.getStringReturnEmptyString(str,42, 45).trim();
					//SE0.75MAX for all, KI for DD
					strAry[11]=StringUtil.getStringReturnEmptyString(str,46, 49).trim();
					// SEmax for all, Kp for DD
					strAry[12]=StringUtil.getStringReturnEmptyString(str,50, 53).trim();
					//EFDMin
					strAry[13]=StringUtil.getStringReturnEmptyString(str,54, 58).trim();
					//EFDMax for all, VNmax for ED
					strAry[14]=StringUtil.getStringReturnEmptyString(str,59, 62).trim();
					//KF
					strAry[15]=StringUtil.getStringReturnEmptyString(str,63, 66).trim();
					//TF
					strAry[16]=StringUtil.getStringReturnEmptyString(str,67, 70).trim();
					// XL for ED
					strAry[17]=StringUtil.getStringReturnEmptyString(str,71, 75).trim();
					//TF1 for ED
					strAry[18]=StringUtil.getStringReturnEmptyString(str,76, 80).trim();
					
				}else if(str.substring(0, 2).trim().equals("FA")||
						str.substring(0, 2).trim().equals("FB")||str.substring(0, 2).trim().equals("FC")
						||str.substring(0, 2).trim().equals("FD")||str.substring(0, 2).trim().equals("FE")||
						str.substring(0, 2).trim().equals("FF")||str.substring(0, 2).trim().equals("FG")
						||str.substring(0, 2).trim().equals("FH")||str.substring(0, 2).trim().equals("FJ")
						||str.substring(0, 2).trim().equals("FK")||str.substring(0, 2).trim().equals("FL")
						){
					
					strAry[0]=StringUtil.getStringReturnEmptyString(str,1, 2).trim();
					//busId
					strAry[1]=StringUtil.getStringReturnEmptyString(str,4, 11).trim();
					//bus Voltage
					strAry[2]=StringUtil.getStringReturnEmptyString(str,12, 15).trim();
					//excId
					strAry[3]=StringUtil.getStringReturnEmptyString(str,16, 16).trim();
					//Rc
					strAry[4]=StringUtil.getStringReturnEmptyString(str,17, 21).trim();
					//Xc
					strAry[5]=StringUtil.getStringReturnEmptyString(str,22, 26).trim();
					//TR
					strAry[6]=StringUtil.getStringReturnEmptyString(str,27, 31).trim();
					//VIMax for G K L,VAmax for FF
					strAry[7]=StringUtil.getStringReturnEmptyString(str,32, 36).trim();
					//VIMin for G K L,VAmin for FF
					strAry[8]=StringUtil.getStringReturnEmptyString(str,37, 41).trim();
					// TB
					strAry[9]=StringUtil.getStringReturnEmptyString(str,42, 46).trim();
					//TC
					strAry[10]=StringUtil.getStringReturnEmptyString(str,47, 51).trim();
					//KA, KV for FE
					strAry[11]=StringUtil.getStringReturnEmptyString(str,52, 56).trim();
					// TA, TRH for FE
					strAry[12]=StringUtil.getStringReturnEmptyString(str,57, 61).trim();
					//VRmax, Vamax for FH
					strAry[13]=StringUtil.getStringReturnEmptyString(str,62, 66).trim();					
					//VRmin, Vamin
					strAry[14]=StringUtil.getStringReturnEmptyString(str,67, 71).trim();
					//KE, KJ for FL
					strAry[15]=StringUtil.getStringReturnEmptyString(str,72, 76).trim();
					//TE
					strAry[16]=StringUtil.getStringReturnEmptyString(str,77, 80).trim();
				}else if(str.substring(0, 2).trim().equals("FQ")||str.substring(0, 2).trim().equals("FV")){
					
					strAry[0]=StringUtil.getStringReturnEmptyString(str,1, 2).trim();
					//busId
					strAry[1]=StringUtil.getStringReturnEmptyString(str,4, 11).trim();
					//bus Voltage
					strAry[2]=StringUtil.getStringReturnEmptyString(str,12, 15).trim();
					//excId
					strAry[3]=StringUtil.getStringReturnEmptyString(str,16, 16).trim();
					//Rc
					strAry[4]=StringUtil.getStringReturnEmptyString(str,17, 20).trim();
					//Xc
					strAry[5]=StringUtil.getStringReturnEmptyString(str,21, 24).trim();
					//TR
					strAry[6]=StringUtil.getStringReturnEmptyString(str,25, 29).trim();
					//K
					strAry[7]=StringUtil.getStringReturnEmptyString(str,30, 34).trim();
					//Kv
					strAry[8]=StringUtil.getStringReturnEmptyString(str,35, 37).trim();
					// T1
					strAry[9]=StringUtil.getStringReturnEmptyString(str,38, 42).trim();
					//T2
					strAry[10]=StringUtil.getStringReturnEmptyString(str,43, 47).trim();
					//K3
					strAry[11]=StringUtil.getStringReturnEmptyString(str,48, 52).trim();
					// T4
					strAry[12]=StringUtil.getStringReturnEmptyString(str,53, 57).trim();
					//KA
					strAry[13]=StringUtil.getStringReturnEmptyString(str,58, 62).trim();
					//TA
					strAry[14]=StringUtil.getStringReturnEmptyString(str,63, 67).trim();
					//KF
					strAry[15]=StringUtil.getStringReturnEmptyString(str,68, 72).trim();
					//TF
					strAry[16]=StringUtil.getStringReturnEmptyString(str,73, 76).trim();
					//KH
					strAry[17]=StringUtil.getStringReturnEmptyString(str,77, 80).trim();
				}
				else if(str.substring(0,2).trim().equals("FZ")){
					strAry[0]=StringUtil.getStringReturnEmptyString(str,1, 2).trim();
					//busId
					strAry[1]=StringUtil.getStringReturnEmptyString(str,4, 11).trim();
					//bus Voltage
					strAry[2]=StringUtil.getStringReturnEmptyString(str,12, 15).trim();
					//excId
					strAry[3]=StringUtil.getStringReturnEmptyString(str,16, 16).trim();
					//SE1, 
					strAry[4]=StringUtil.getStringReturnEmptyString(str,17, 21).trim();
					//SE2, 
					strAry[5]=StringUtil.getStringReturnEmptyString(str,22, 26).trim();
					//EFDmin
					strAry[6]=StringUtil.getStringReturnEmptyString(str,27, 31).trim();
					//
					strAry[7]=StringUtil.getStringReturnEmptyString(str,32, 36).trim();
					//KF
					strAry[8]=StringUtil.getStringReturnEmptyString(str,37, 41).trim();
					// TF
					strAry[9]=StringUtil.getStringReturnEmptyString(str,42, 46).trim();
					//KC
					strAry[10]=StringUtil.getStringReturnEmptyString(str,47, 51).trim();
					//KD
					strAry[11]=StringUtil.getStringReturnEmptyString(str,52, 56).trim();
					// 
					strAry[12]=StringUtil.getStringReturnEmptyString(str,57, 61).trim();
					//
					strAry[13]=StringUtil.getStringReturnEmptyString(str,62, 66).trim();
					//
					strAry[14]=StringUtil.getStringReturnEmptyString(str,67, 71).trim();
					//
					strAry[15]=StringUtil.getStringReturnEmptyString(str,72, 76).trim();			
					
				}else if(str.substring(0,2).trim().equals("F+")){
					strAry[0]=StringUtil.getStringReturnEmptyString(str,1, 2).trim();
					//busId
					strAry[1]=StringUtil.getStringReturnEmptyString(str,4, 11).trim();
					//bus Voltage
					strAry[2]=StringUtil.getStringReturnEmptyString(str,12, 15).trim();
					//excId
					strAry[3]=StringUtil.getStringReturnEmptyString(str,16, 16).trim();
					//VAMAX 
					strAry[4]=StringUtil.getStringReturnEmptyString(str,17, 21).trim();
					//VAMIN 
					strAry[5]=StringUtil.getStringReturnEmptyString(str,22, 26).trim();
					//KB
					strAry[6]=StringUtil.getStringReturnEmptyString(str,27, 30).trim();
					//T5
					strAry[7]=StringUtil.getStringReturnEmptyString(str,31, 34).trim();
					//KE
					strAry[8]=StringUtil.getStringReturnEmptyString(str,35, 38).trim();
					// TE
					strAry[9]=StringUtil.getStringReturnEmptyString(str,40, 42).trim();
					//SE1-0.75
					strAry[10]=StringUtil.getStringReturnEmptyString(str,43, 47).trim();
					//SE2--EFDMAX
					strAry[11]=StringUtil.getStringReturnEmptyString(str,48, 52).trim();
					// VRMAX
					strAry[12]=StringUtil.getStringReturnEmptyString(str,53, 56).trim();
					//VRMIN
					strAry[13]=StringUtil.getStringReturnEmptyString(str,57, 60).trim();
					//KC
					strAry[14]=StringUtil.getStringReturnEmptyString(str,61, 64).trim();
					//KD
					strAry[15]=StringUtil.getStringReturnEmptyString(str,65, 68).trim();	
					//KL1
					strAry[16]=StringUtil.getStringReturnEmptyString(str,69, 72).trim();
					//VLIR
					strAry[17]=StringUtil.getStringReturnEmptyString(str,73, 76).trim();
					//EFDMAX
					strAry[18]=StringUtil.getStringReturnEmptyString(str,77, 80).trim();
					
				}
	    	}catch (Exception e){
	    		adapter.logErr(e.toString());
	    	}
			
			
			
	        return strAry;
	        
	    }
	

}
