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

import java.text.NumberFormat;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.CurrentXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ExciterModelListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ExciterXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.FaultCategoryXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.FaultListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.GeneratorModelListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.GeneratorXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadCharacteristicModelListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadCharacteristicXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PerUnitXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PercentXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PowerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.StabilizerModelListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.StabilizerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TimeXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TransientSimulationXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TurbineGovernorModelListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TurbineGovernorXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TurbineXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZXmlType;
import org.ieee.pes.odm.pss.model.IEEEODMPSSModelParser;
import org.ieee.pes.odm.pss.model.ODMData2XmlHelper;


public class BPADynamicPSSRecord {
	
	public static void processPSSData(String str,TransientSimulationXmlType tranSimu,
    		IEEEODMPSSModelParser parser){
    	final String[] strAry= getPSSDataFields(str);
    	
    	if(str.substring(0, 3).trim().equals("SS")||str.substring(0, 3).trim().equals("SP")
    			||str.substring(0, 3).trim().equals("SG")){
    		StabilizerXmlType pss=parser.addNewStablilizerGovernor();
    		pss.setStabilizerType(StabilizerXmlType.StabilizerType.IEE_2_ST);
    		StabilizerModelListXmlType.IEE2ST tstpss=pss.
    		                     addNewStabilizerModel().addNewIEE2ST();
    		
    		if(str.substring(0, 3).trim().equals("SS")){
    			tstpss.setFirstInputSignal(StabilizerModelListXmlType.IEE2ST.FirstInputSignal
    					.ROTOR_SPEED_DEVIATION);    			                 
    		}else if(str.substring(0, 3).trim().equals("SP")){
    			tstpss.setFirstInputSignal(StabilizerModelListXmlType.IEE2ST.FirstInputSignal
    					.GENERATOR_ACCELERATING_POWER);
    		}else{
    			tstpss.setFirstInputSignal(StabilizerModelListXmlType.IEE2ST.FirstInputSignal
    					.GENERATOR_ELECTRICAL_POWER);
    		}
    		//busId
    		String busId=strAry[1];
    		pss.addNewLocatedBus().setName(busId);
    		//bus Voltage
    		double v=new Double(strAry[2]).doubleValue();
    		ODMData2XmlHelper.setVoltageData(pss.addNewBusRatedVoltage(), v, VoltageXmlType.Unit.KV);
    		    		
    		//excId
    		String macId="";
    		if(!strAry[3].equals("")){
    			macId=strAry[3];
    			pss.addNewMacId().setName(macId);
    		}    		
    		//KQV 
    		double KQV=0.0;
    		if(!strAry[4].equals("")){
    			KQV= new Double(strAry[4]).doubleValue();
        		tstpss.setK1(KQV);
    		}    		
    		//TQV
    		double TQV=0.0;
    		if(!strAry[5].equals("")){
    			TQV= new Double(strAry[5]).doubleValue();
    			ODMData2XmlHelper.setTimeData(tstpss.addNewT1(), TQV, TimeXmlType.Unit.SEC);
    		}		
    		
    		//KQS
    		double KQS= new Double(strAry[6]).doubleValue();
    		tstpss.setK2(KQS);
    		
    		//TQS
    		double TQS= new Double(strAry[7]).doubleValue();
    		ODMData2XmlHelper.setTimeData(tstpss.addNewT2(), TQS, TimeXmlType.Unit.SEC);
    		
    		//TQ
    		double TQ= new Double(strAry[8]).doubleValue();
    		ODMData2XmlHelper.setTimeData(tstpss.addNewT3(), TQ, TimeXmlType.Unit.SEC);
    		ODMData2XmlHelper.setTimeData(tstpss.addNewT4(), TQ, TimeXmlType.Unit.SEC);
    		// TQ1
    		double TQ1= new Double(strAry[9]).doubleValue();
    		ODMData2XmlHelper.setTimeData(tstpss.addNewT6(), TQS, TimeXmlType.Unit.SEC);
    		
    		
    		//TQ11
    		double TQ11= new Double(strAry[10]).doubleValue();
    		ODMData2XmlHelper.setTimeData(tstpss.addNewT5(), TQ11, TimeXmlType.Unit.SEC);
    		
    		//TQ2
    		double TQ2= new Double(strAry[11]).doubleValue();
    		ODMData2XmlHelper.setTimeData(tstpss.addNewT8(), TQ2, TimeXmlType.Unit.SEC);
    		
    		// TQ21
    		double TQ21= new Double(strAry[12]).doubleValue();
    		ODMData2XmlHelper.setTimeData(tstpss.addNewT7(), TQ21, TimeXmlType.Unit.SEC);
    		   		
    		
    		//TQ31
    		double TQ31=0.0;
    		if(!strAry[14].equals("")){
    			TQ31= new Double(strAry[14]).doubleValue();
    			ODMData2XmlHelper.setTimeData(tstpss.addNewT9(), TQ31, TimeXmlType.Unit.SEC);
    		}    		
    		  		
    		//TQ3
    		double TQ3=0.0;
    		if(!strAry[13].equals("")){
    			TQ3= new Double(strAry[13]).doubleValue();
    			ODMData2XmlHelper.setTimeData(tstpss.addNewT10(), TQ3, TimeXmlType.Unit.SEC);
    		}		
    		
    		//VSMAX
    		double vsmax= new Double(strAry[15]).doubleValue();
    		ODMData2XmlHelper.setPUData(tstpss.addNewVSMAX(), vsmax, PerUnitXmlType.Unit.PU);
    			
    		//VCUTOFF
    		double vcut=0.0;
    		if(!strAry[16].equals("")){
    			vcut= new Double(strAry[16]).doubleValue();
        		ODMData2XmlHelper.setPUData(tstpss.addNewVCUTOFF(), vcut, PerUnitXmlType.Unit.PU);
    		}    		
    		//VSLOW
    		double vsmin=0.0;
    		double Vslow=0.0;
    		if(!strAry[17].equals("")){
    			Vslow= new Double(strAry[17]).doubleValue();
    		}
    		
    		if(Vslow<=0){
    			vsmin=-vsmax;
    		}else {
    			vsmin=-Vslow;
    		}
    		ODMData2XmlHelper.setPUData(tstpss.addNewVSMIN(), vsmin, PerUnitXmlType.Unit.PU);
			    		
    		//KQS MVAbase for SP SG
    		double kqsMvaBase=0.0;
    		if(!strAry[19].equals("")){
    			kqsMvaBase=new Double(strAry[19]).doubleValue();
    		}    		
    		
    		
    	}else if(str.substring(0, 3).trim().equals("SI")){
    		StabilizerXmlType pss=parser.addNewStablilizerGovernor();
    		pss.setStabilizerType(StabilizerXmlType.StabilizerType.IEEE_DUAL_INPUT);
    		StabilizerModelListXmlType.IEEEDualInput dualInputPss=pss.
    		                     addNewStabilizerModel().addNewIEEEDualInput();
    		
    		
    		//busId
    		String busId=strAry[1];
    		pss.addNewLocatedBus().setName(busId);
    		//bus Voltage
    		double v=new Double(strAry[2]).doubleValue();
    		ODMData2XmlHelper.setVoltageData(pss.addNewBusRatedVoltage(), v, VoltageXmlType.Unit.KV);
    		    		
    		//excId
    		String macId="";
    		if(!strAry[3].equals("")){
    			macId=strAry[3];
    			pss.addNewMacId().setName(macId);
    		}    		
    		//TRW
    		double  trw=new Double(strAry[4]).doubleValue();
    		ODMData2XmlHelper.setTimeData(dualInputPss.addNewTrw(), trw, TimeXmlType.Unit.SEC);
    		
    		//T5
    		double  t5=new Double(strAry[5]).doubleValue();
    		ODMData2XmlHelper.setTimeData(dualInputPss.addNewT5(), t5, TimeXmlType.Unit.SEC);
    		//T6
    		double  t6=new Double(strAry[6]).doubleValue();
    		ODMData2XmlHelper.setTimeData(dualInputPss.addNewT6(), t6, TimeXmlType.Unit.SEC);
    		
    		//T7
    		double  t7=new Double(strAry[7]).doubleValue();
    		ODMData2XmlHelper.setTimeData(dualInputPss.addNewT7(), t7, TimeXmlType.Unit.SEC);
    		
    		//KR
    		double kr= new Double(strAry[8]).doubleValue();
    		dualInputPss.setKr(kr);    		
    		// TRP
    		double  trp=new Double(strAry[9]).doubleValue();
    		ODMData2XmlHelper.setTimeData(dualInputPss.addNewTrp(), trp, TimeXmlType.Unit.SEC);
    		
    		//TW
    		double  tw=new Double(strAry[10]).doubleValue();
    		ODMData2XmlHelper.setTimeData(dualInputPss.addNewTW(), tw, TimeXmlType.Unit.SEC);
    		
    		//TW1
    		double  tw1=new Double(strAry[11]).doubleValue();
    		ODMData2XmlHelper.setTimeData(dualInputPss.addNewTW1(), tw1, TimeXmlType.Unit.SEC);
    		
    		// TW2
    		double  tw2=new Double(strAry[12]).doubleValue();
    		ODMData2XmlHelper.setTimeData(dualInputPss.addNewTW2(), tw2, TimeXmlType.Unit.SEC);
    		
    		//KS
    		double ks= new Double(strAry[13]).doubleValue();
    		dualInputPss.setKS(ks);    	
    		//T9
    		double  t9=new Double(strAry[14]).doubleValue();
    		ODMData2XmlHelper.setTimeData(dualInputPss.addNewT9(), t9, TimeXmlType.Unit.SEC);
    		
    		//T10
    		double  t10=new Double(strAry[15]).doubleValue();
    		ODMData2XmlHelper.setTimeData(dualInputPss.addNewT10(), t10, TimeXmlType.Unit.SEC);
    		
    		//T12
    		double  t12=new Double(strAry[16]).doubleValue();
    		ODMData2XmlHelper.setTimeData(dualInputPss.addNewT12(), t12, TimeXmlType.Unit.SEC);
    	
    		//INP input signal:0for w and Pg, 1 for w, 2for pg
    		int INP=0;
    		if(!strAry[17].equals("")){
    			INP= new Integer(strAry[17]).intValue();
    		}
    		
    		if(INP==0){
    			dualInputPss.setFirstInputSignal(StabilizerModelListXmlType.IEEEDualInput
    					.FirstInputSignal.ROTOR_SPEED_DEVIATION );
    			dualInputPss.setSecondInputSignal(StabilizerModelListXmlType.IEEEDualInput
    					.SecondInputSignal.GENERATOR_ACCELERATING_POWER);
    		}else if(INP==1){
    			dualInputPss.setFirstInputSignal(StabilizerModelListXmlType.IEEEDualInput
    					.FirstInputSignal.ROTOR_SPEED_DEVIATION );
    		}else if(INP==2){
    			dualInputPss.setSecondInputSignal(StabilizerModelListXmlType.IEEEDualInput
    					.SecondInputSignal.GENERATOR_ACCELERATING_POWER);
    		}
    		
    		
    	}else if(str.substring(0, 3).trim().equals("SI+")){
    		
    		String busId=strAry[1];    		
    		//bus Voltage    		   		    		
    		//excId
    		String macId="";
    		if(!strAry[3].equals("")){
    			macId=strAry[3];
    		}    		
    		StabilizerXmlType pss=ODMData2XmlHelper.getPSSRecord(tranSimu, busId, macId);
    		StabilizerModelListXmlType.IEEEDualInput dualInputPss=pss
                      .getStabilizerModel().getIEEEDualInput();
    		
    		
    		//KP
    		double kp= new Double(strAry[4]).doubleValue();    		
    		//T1
    		double  t1=new Double(strAry[5]).doubleValue();
    		ODMData2XmlHelper.setTimeData(dualInputPss.addNewT1(), t1, TimeXmlType.Unit.SEC);    		
    		//T2
    		double  t2=new Double(strAry[6]).doubleValue();
    		ODMData2XmlHelper.setTimeData(dualInputPss.addNewT2(), t2, TimeXmlType.Unit.SEC);
    		
    		//T13
    		double  t13=new Double(strAry[7]).doubleValue();
    		ODMData2XmlHelper.setTimeData(dualInputPss.addNewT13(), t13, TimeXmlType.Unit.SEC);
    	
    		//T14
    		double  t14=new Double(strAry[8]).doubleValue();
    		ODMData2XmlHelper.setTimeData(dualInputPss.addNewT14(), t14, TimeXmlType.Unit.SEC);
    		
    		// T3
    		double  t3=new Double(strAry[9]).doubleValue();
    		ODMData2XmlHelper.setTimeData(dualInputPss.addNewT3(), t3, TimeXmlType.Unit.SEC);
    		
    		//T4
    		double  t4=new Double(strAry[10]).doubleValue();
    		ODMData2XmlHelper.setTimeData(dualInputPss.addNewT4(), t4, TimeXmlType.Unit.SEC);
    		
    		//VSMAX
    		double vsmax= new Double(strAry[11]).doubleValue();
    		ODMData2XmlHelper.setPUData(dualInputPss.addNewVSMAX(), vsmax, PerUnitXmlType.Unit.PU);
    		
    		// VSMIN
    		double vsmin= new Double(strAry[12]).doubleValue();
    		ODMData2XmlHelper.setPUData(dualInputPss.addNewVSMIN(), vsmin, PerUnitXmlType.Unit.PU);
    		   		
    	}
    	
    }
	
	private static String[] getPSSDataFields(String str){
    	final String[] strAry= new String[20];
    	
    	if(str.substring(0, 3).trim().equals("SS")||str.substring(0, 3).trim().equals("SP")
    			||str.substring(0, 3).trim().equals("SG")){
    		strAry[0]=str.substring(0, 2).trim();
    		//busId
    		strAry[1]=str.substring(3, 11).trim();
    		//bus Voltage
    		strAry[2]=str.substring(11, 15).trim();
    		//excId
    		strAry[3]=str.substring(15, 16).trim();
    		//KQV 
    		strAry[4]=str.substring(16, 20).trim();
    		//TQV
    		strAry[5]=str.substring(20, 23).trim();
    		//KQS
    		strAry[6]=str.substring(23, 27).trim();
    		//TQS
    		strAry[7]=str.substring(27, 30).trim();
    		//TQ
    		strAry[8]=str.substring(30, 34).trim();
    		// TQ1
    		strAry[9]=str.substring(34, 38).trim();
    		//TQ11
    		strAry[10]=str.substring(38, 42).trim();
    		//TQ2
    		strAry[11]=str.substring(42, 46).trim();
    		// TQ21
    		strAry[12]=str.substring(46, 50).trim();
    		//TQ3
    		strAry[13]=str.substring(50, 54).trim();
    		//TQ31
    		strAry[14]=str.substring(54, 58).trim();
    		//VSMAX
    		strAry[15]=str.substring(58, 62).trim();	
    		//VCUTOFF
    		strAry[16]=str.substring(62, 66).trim();
    		//VSLOW
    		strAry[17]=str.substring(66, 68).trim();
    		//REMOTE BUS
    		strAry[18]=str.substring(68, 76).trim();
    		//REMOTE VOLTAGE,  KQS MVAbase for SP SG
    		strAry[19]=str.substring(76, 80).trim();
    		
    	}else if(str.substring(0, 3).trim().equals("SI")){
    		
    		strAry[0]=str.substring(0, 2).trim();
    		//busId
    		strAry[1]=str.substring(3, 11).trim();
    		//bus Voltage
    		strAry[2]=str.substring(11, 15).trim();
    		//excId
    		strAry[3]=str.substring(15, 16).trim();
    		//TRW
    		strAry[4]=str.substring(16, 20).trim();
    		//T5
    		strAry[5]=str.substring(20, 25).trim();
    		//T6
    		strAry[6]=str.substring(25, 30).trim();
    		//T7
    		strAry[7]=str.substring(30, 35).trim();
    		//KR
    		strAry[8]=str.substring(35, 41).trim();
    		// TRP
    		strAry[9]=str.substring(41, 45).trim();
    		//TW
    		strAry[10]=str.substring(45, 50).trim();
    		//TW1
    		strAry[11]=str.substring(50, 55).trim();
    		// TW2
    		strAry[12]=str.substring(55, 60).trim();
    		//KS
    		strAry[13]=str.substring(60, 64).trim();
    		//T9
    		strAry[14]=str.substring(64, 69).trim();
    		//T10
    		strAry[15]=str.substring(69, 74).trim();	
    		//T12
    		strAry[16]=str.substring(74, 79).trim();
    		//INP input signal:0for w and Pg, 1 for w, 2for pg
    		strAry[17]=str.substring(79, 80).trim();
    		
    		
    	}else if(str.substring(0, 3).trim().equals("SI+")){
    		strAry[0]=str.substring(0, 2).trim();
    		//busId
    		strAry[1]=str.substring(3, 11).trim();
    		//bus Voltage
    		strAry[2]=str.substring(11, 15).trim();
    		//excId
    		strAry[3]=str.substring(15, 16).trim();
    		//KP
    		strAry[4]=str.substring(16, 21).trim();
    		//T1
    		strAry[5]=str.substring(21, 26).trim();
    		//T2
    		strAry[6]=str.substring(26, 31).trim();
    		//T13
    		strAry[7]=str.substring(31, 36).trim();
    		//T14
    		strAry[8]=str.substring(36, 41).trim();
    		// T3
    		strAry[9]=str.substring(41, 46).trim();
    		//T4
    		strAry[10]=str.substring(46, 51).trim();
    		//VSMAX
    		strAry[11]=str.substring(51, 57).trim();
    		// VSMIN
    		strAry[12]=str.substring(57, 63).trim();
    		//KMVA, MVAbase for kr in SI 
    		strAry[13]=str.substring(76, 80).trim();
    		
    	}    	
    	return strAry;
    }

}
