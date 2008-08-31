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

public class BPADynamicExciterRecord {
	
	public static void processExciterData(String str, TransientSimulationXmlType tranSimu,
    		IEEEODMPSSModelParser parser   ){
    	final String strAry[]=getExciterDataFields(str);
    	
    	int type=0;
    	int EA=1;
    	int EC=2;
    	int EK=3;
    	int FJ=4;
    	int FK=5;
    	int FQ=6;
    	int FV=7;
    	
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
    	}
    	
    	if(type==EA||type==EC||type==EK){
    		ExciterXmlType exc=parser.addNewExciter();
    		exc.setExciterType(ExciterXmlType.ExciterType.IEEE_1968_TYPE_1);
    		ExciterModelListXmlType.IEEE1968Type1 type1968= exc.
    		                       addNewExciterModel().addNewIEEE1968Type1();
    		//busId
    		String busId=strAry[1];
    		exc.addNewLocatedBus().setName(busId);    		
    		//bus Voltage
    		double voltage;
    		if(!strAry[2].equals("")){
    			voltage= new Double(strAry[2]).doubleValue();
    			ODMData2XmlHelper.setVoltageData(exc.addNewBusRatedVoltage(), 
    					voltage, VoltageXmlType.Unit.KV);
    		}    		
    		//excId
    		String excId="";
    		if(!strAry[3].equals("")){
    			exc.addNewExcId().setName(excId);
    		}    		
    		//TR
    		double Tr=0.0;
    		if(!strAry[4].equals("")){
    			Tr=new Double(strAry[4]).doubleValue();
    			ODMData2XmlHelper.setTimeData(type1968.addNewTR(), Tr, TimeXmlType.Unit.SEC);
    		}    		
    		//KA for all, KV for EE
    		double Ka=0.0;
    		if(!strAry[5].equals("")){
    			Ka=new Double(strAry[5]).doubleValue();
    			ODMData2XmlHelper.setPUData(type1968.addNewKA(), Ka, PerUnitXmlType.Unit.PU);
    		}    		
    		//TA for all, TRH for EE
    		double Ta=0.0;
    		if(!strAry[6].equals("")){
    			Ta=new Double(strAry[6]).doubleValue();
    			ODMData2XmlHelper.setTimeData(type1968.addNewTA(), Ta, TimeXmlType.Unit.SEC);
    		}
    		//VRminMult, VRmax*multi=Vrmin. VRmin for ED EJ
    		double multi=0.0;
    		if(!strAry[8].equals("")){
    			multi= new Double(strAry[8]).doubleValue();
    		}    		
    		// KE
    		double Ke=0.0;
    		if(!strAry[9].equals("")){
    			Ke= new Double(strAry[9]).doubleValue();
    			ODMData2XmlHelper.setPUData(type1968.addNewKE(), Ke, PerUnitXmlType.Unit.PU);
    		}    		
    		//TE
    		double Te= new Double(strAry[10]).doubleValue();
    		ODMData2XmlHelper.setTimeData(type1968.addNewTE(), Te, TimeXmlType.Unit.SEC);
    		
    		//SE0.75MAX for all, KI for DD
    		type1968.setE1(0.75);
    		double SE1= new Double(strAry[11]).doubleValue();
    		type1968.setSE1(SE1);    		
    		
    		//EFDMin
    		double Efdmin=new Double(strAry[13]).doubleValue();
    		ODMData2XmlHelper.setPUData(type1968.addNewEFDMIN(),
    				        Efdmin, PerUnitXmlType.Unit.PU);
    		
    		//EFDMax for all, VNmax for ED
    		double Efdmax=new Double(strAry[14]).doubleValue();    		
    		// SEmax for all, Kp for DD
    		type1968.setE2(Efdmax);
    		double SE2= new Double(strAry[12]).doubleValue();
    		type1968.setSE2(SE2);    		
    		//KF
    		double Kf= new Double(strAry[15]).doubleValue();
    		ODMData2XmlHelper.setPUData(type1968.addNewKF(), Kf, PerUnitXmlType.Unit.PU);
    		    		
    		//TF    		
    		double Tf= new Double(strAry[16]).doubleValue();
    		ODMData2XmlHelper.setTimeData(type1968.addNewTF(), Tf, TimeXmlType.Unit.SEC);    		
    		//VRmax=(SE2+Ke)*EFDmax,Vrmin
    		
    		double VRmax=(SE2+Ke)*Efdmax;
    		double VRmin=VRmax*multi;
    		ODMData2XmlHelper.setPUData(type1968.addNewVRMAX(), VRmax, PerUnitXmlType.Unit.PU);
    		ODMData2XmlHelper.setPUData(type1968.addNewVRMIN(), VRmin, PerUnitXmlType.Unit.PU);
    		
    		// IEEE 1981 ST1
    	}else if(type==FK){
    		ExciterXmlType exc=parser.addNewExciter();
    		exc.setExciterType(ExciterXmlType.ExciterType.IEEE_1981_ST_1);
    		ExciterModelListXmlType.IEEE1981ST1 exc_st1= exc.addNewExciterModel().addNewIEEE1981ST1();
			//busId
    		String busId=strAry[1];
			exc.addNewLocatedBus().setName(busId);		
			
			//bus Voltage
			double voltage= new Double(strAry[2]).doubleValue();
			ODMData2XmlHelper.setVoltageData(exc.addNewBusRatedVoltage(), voltage, VoltageXmlType.Unit.KV);
			//excId
			String excId="";
			if(!strAry[3].equals("")){
				excId=strAry[3];
				exc.addNewExcId().setName(excId);
			}	
			//TR
			
			double Tr= new Double(strAry[6]).doubleValue();
			ODMData2XmlHelper.setTimeData(exc_st1.addNewTR(), Tr, TimeXmlType.Unit.SEC);
			
			//VIMax for G K L,VAmax for FF
			double Vimax= new Double(strAry[7]).doubleValue();
			ODMData2XmlHelper.setPUData(exc_st1.addNewVIMAX(), Vimax, PerUnitXmlType.Unit.PU);
			
			//VIMin for G K L,VAmin for FF
			//VIMax for G K L,VAmax for FF
			double Vimin= new Double(strAry[8]).doubleValue();
			ODMData2XmlHelper.setPUData(exc_st1.addNewVIMIN(), Vimin, PerUnitXmlType.Unit.PU);
			// TB
			double Tb= new Double(strAry[9]).doubleValue();
			ODMData2XmlHelper.setTimeData(exc_st1.addNewTB(), Tb, TimeXmlType.Unit.SEC);
			
			//TC
			double Tc= new Double(strAry[10]).doubleValue();
			ODMData2XmlHelper.setTimeData(exc_st1.addNewTC(), Tc, TimeXmlType.Unit.SEC);
			
			//KA, KV for FE
			double Ka= new Double(strAry[11]).doubleValue();
			ODMData2XmlHelper.setPUData(exc_st1.addNewKA(), Ka, PerUnitXmlType.Unit.PU);			
			// TA, TRH for FE
			double Ta= new Double(strAry[12]).doubleValue();
			ODMData2XmlHelper.setTimeData(exc_st1.addNewTA(), Ta, TimeXmlType.Unit.SEC);
			
			//VRmax, Vamax for FH
			double Vrmax= new Double(strAry[13]).doubleValue();
			ODMData2XmlHelper.setPUData(exc_st1.addNewVRMAX(), Vrmax, PerUnitXmlType.Unit.PU);
			
			//VRmin, Vamin
			double Vrmin= new Double(strAry[14]).doubleValue();
			ODMData2XmlHelper.setPUData(exc_st1.addNewVRMIN(), Vrmin, PerUnitXmlType.Unit.PU);
			   		
			
			
    	}else if(type==FJ){
    		ExciterXmlType exc=parser.addNewExciter();
    		exc.setExciterType(ExciterXmlType.ExciterType.BPAFJ);
    		ExciterModelListXmlType.BPAFJ BPAFJ= exc.addNewExciterModel().addNewBPAFJ();
			//busId
    		String busId=strAry[1];
			exc.addNewLocatedBus().setName(busId);		
			
			//bus Voltage
			double voltage= new Double(strAry[2]).doubleValue();
			ODMData2XmlHelper.setVoltageData(exc.addNewBusRatedVoltage(), voltage, VoltageXmlType.Unit.KV);
			//excId
			String excId="";
			if(!strAry[3].equals("")){
				excId=strAry[3];
				exc.addNewExcId().setName(excId);
			}	
			// TB
			double Tb= new Double(strAry[9]).doubleValue();
			ODMData2XmlHelper.setTimeData(BPAFJ.addNewTB(), Tb, TimeXmlType.Unit.SEC);
			
			//TC
			double Tc= new Double(strAry[10]).doubleValue();
			ODMData2XmlHelper.setTimeData(BPAFJ.addNewTC(), Tc, TimeXmlType.Unit.SEC);
			
			//KA, KV for FE
			double Ka= new Double(strAry[11]).doubleValue();
			ODMData2XmlHelper.setPUData(BPAFJ.addNewKA(), Ka, PerUnitXmlType.Unit.PU);			
			// TA, TRH for FE
			double Ta= new Double(strAry[12]).doubleValue();
			ODMData2XmlHelper.setTimeData(BPAFJ.addNewTA(), Ta, TimeXmlType.Unit.SEC);
			
			//VRmax, Vamax for FH
			double Vrmax= new Double(strAry[13]).doubleValue();
			ODMData2XmlHelper.setPUData(BPAFJ.addNewVRMAX(), Vrmax, PerUnitXmlType.Unit.PU);
			
			//VRmin, Vamin
			double Vrmin= new Double(strAry[14]).doubleValue();
			ODMData2XmlHelper.setPUData(BPAFJ.addNewVRMIN(), Vrmin, PerUnitXmlType.Unit.PU);
    	}else if(type==FQ||type==FV){
    		ExciterXmlType exc=parser.addNewExciter();
    		exc.setExciterType(ExciterXmlType.ExciterType.IEEE_1981_NEW_EXC_SYSTEM);
    		ExciterModelListXmlType.IEEE1981NewExcSystem newExc=exc.addNewExciterModel().addNewIEEE1981NewExcSystem();
    		
			//busId
    		String busId=strAry[1];
			exc.addNewLocatedBus().setName(busId);
			//bus Voltage
			double voltage=new Double(strAry[2]).doubleValue();
			ODMData2XmlHelper.setVoltageData(exc.addNewBusRatedVoltage(), 
					voltage, VoltageXmlType.Unit.KV);			
			//excId
			String excId="";
			if(!strAry[3].equals("")){
				excId=strAry[3];
				exc.addNewExcId().setName(excId);
			}			
			//Rc
			double Rc=0.0;
			if(!strAry[4].equals("")){
				Rc= new Double(strAry[4]).doubleValue();
				ODMData2XmlHelper.setPUData(newExc.addNewRc(), Rc, PerUnitXmlType.Unit.PU);
			}
			
			//Xc
			double Xc=0.0;
			if(!strAry[5].equals("")){
				Xc= new Double(strAry[5]).doubleValue();
				ODMData2XmlHelper.setPUData(newExc.addNewXc(), Xc, PerUnitXmlType.Unit.PU);
			}			
			//TR
			double Tr=0.0;
			if(!strAry[6].equals("")){
				Tr= new Double(strAry[6]).doubleValue();
				ODMData2XmlHelper.setTimeData(newExc.addNewTr(), Tr, TimeXmlType.Unit.SEC);
			}			
			//K
			double k=0.0;
			if(!strAry[7].equals("")){
				k= new Double(strAry[7]).doubleValue();
				ODMData2XmlHelper.setPUData(newExc.addNewK(), k, PerUnitXmlType.Unit.PU);
			}			
			//Kv
			double kv=0.0;
			if(!strAry[8].equals("")){
				kv= new Double(strAry[8]).doubleValue();
				ODMData2XmlHelper.setPUData(newExc.addNewKv(), kv, PerUnitXmlType.Unit.PU);
			}			
			// T1
			double T1=0.0;
			if(!strAry[9].equals("")){
				T1= new Double(strAry[9]).doubleValue();
				ODMData2XmlHelper.setTimeData(newExc.addNewT1(), T1, TimeXmlType.Unit.SEC);
			}
			//T2
			double T2=0.0;
			if(!strAry[10].equals("")){
				T2= new Double(strAry[10]).doubleValue();
				ODMData2XmlHelper.setTimeData(newExc.addNewT2(), T2, TimeXmlType.Unit.SEC);
			}			
			//T3			
			double T3=0.0;
			if(!strAry[11].equals("")){
				T3= new Double(strAry[11]).doubleValue();
				ODMData2XmlHelper.setTimeData(newExc.addNewT3(), T3, TimeXmlType.Unit.SEC);
			}			
			// T4			
			double T4=0.0;
			if(!strAry[12].equals("")){
				T4= new Double(strAry[12]).doubleValue();
				ODMData2XmlHelper.setTimeData(newExc.addNewT4(), T4, TimeXmlType.Unit.SEC);
			}			
			//KA
			double ka=0.0;
			if(!strAry[13].equals("")){
				ka= new Double(strAry[13]).doubleValue();
				ODMData2XmlHelper.setPUData(newExc.addNewKa(), ka, PerUnitXmlType.Unit.PU);
			}			
			//TA
			double Ta=0.0;
			if(!strAry[14].equals("")){
				Ta= new Double(strAry[14]).doubleValue();
				ODMData2XmlHelper.setTimeData(newExc.addNewTa(), Ta, TimeXmlType.Unit.SEC);
			}			
			//KF
			double kf=0.0;
			if(!strAry[15].equals("")){
				kf= new Double(strAry[15]).doubleValue();
				ODMData2XmlHelper.setPUData(newExc.addNewKf(), kf, PerUnitXmlType.Unit.PU);
			}			
			//TF
			double Tf=0.0;
			if(!strAry[16].equals("")){
				Tf= new Double(strAry[16]).doubleValue();
				ODMData2XmlHelper.setTimeData(newExc.addNewTf(), Tf, TimeXmlType.Unit.SEC);
			}			
			//KH
			double kh=0.0;
			if(!strAry[17].equals("")){
				kh= new Double(strAry[17]).doubleValue();
				ODMData2XmlHelper.setPUData(newExc.addNewKh(), kh, PerUnitXmlType.Unit.PU);
			}
			
    	}else if(str.substring(0, 2).trim().equals("FZ")||
    			str.substring(0, 2).trim().equals("F+")){
    		String busId=str.substring(3, 11).trim();
        	String excId="";
        	if(!str.substring(15, 16).trim().equals("")){
        		excId=str.substring(15, 16).trim();
        	}    	
        	ExciterXmlType exc=ODMData2XmlHelper.getExciterRecord(tranSimu, busId, excId);
        	
        	if(str.substring(0, 2).trim().equals("FZ")){
        		if(exc.getExciterType().equals(ExciterXmlType.ExciterType.IEEE_1981_ST_1)){        		
            		//KF
            		double Kf= new Double(strAry[8]).doubleValue();
            		ODMData2XmlHelper.setPUData(exc.getExciterModel().getIEEE1981ST1().addNewKF(), 
            				Kf, PerUnitXmlType.Unit.PU);
            					
        			// TF
            		double TF= new Double(strAry[9]).doubleValue();
        			ODMData2XmlHelper.setTimeData(exc.getExciterModel().getIEEE1981ST1().addNewTF(), 
        					TF, TimeXmlType.Unit.SEC);
        			strAry[9]=str.substring(41, 46).trim();
        			//KC
        			double Kc= new Double(strAry[8]).doubleValue();
            		ODMData2XmlHelper.setPUData(exc.getExciterModel().getIEEE1981ST1().addNewKC(), 
            				Kc, PerUnitXmlType.Unit.PU); 
            	}else if(exc.getExciterType().equals(ExciterXmlType.ExciterType.BPAFJ)){        		
            		//EFDmax
            		double EFDmax= new Double(strAry[7]).doubleValue();
        			ODMData2XmlHelper.setPUData(exc.getExciterModel().getBPAFJ().addNewEFDMAX(), 
        					EFDmax, PerUnitXmlType.Unit.PU);
        			
        			//EFDmin
        			double EFDmin= new Double(strAry[6]).doubleValue();
        			ODMData2XmlHelper.setPUData(exc.getExciterModel().getBPAFJ().addNewEFDMIN(), 
        					EFDmin, PerUnitXmlType.Unit.PU);    		
        			//KF
            		double Kf= new Double(strAry[8]).doubleValue();
            		ODMData2XmlHelper.setPUData(exc.getExciterModel().getBPAFJ().addNewKF(), 
            				Kf, PerUnitXmlType.Unit.PU);
            					
        			// TF
            		double TF= new Double(strAry[9]).doubleValue();
        			ODMData2XmlHelper.setTimeData(exc.getExciterModel().getBPAFJ().addNewTF(), 
        					TF, TimeXmlType.Unit.SEC);
        			
        			//KC
        			double Kc= new Double(strAry[8]).doubleValue();
            		ODMData2XmlHelper.setPUData(exc.getExciterModel().getBPAFJ().addNewKC(), 
            				Kc, PerUnitXmlType.Unit.PU);
            	}
        		
        	}else if(str.substring(0, 2).trim().equals("F+")){
        		
        		ExciterModelListXmlType.IEEE1981NewExcSystem newExc=exc.
        		                   getExciterModel().getIEEE1981NewExcSystem();        		
        		//VAMAX 
        		double Vamax= new Double(strAry[4]).doubleValue();
        		ODMData2XmlHelper.setPUData(newExc.addNewVAmax(), 
        				Vamax, PerUnitXmlType.Unit.PU);    		
    			
    			//VAMIN 
        		double Vamin= new Double(strAry[5]).doubleValue();
        		ODMData2XmlHelper.setPUData(newExc.addNewVAmin(), 
        				Vamin, PerUnitXmlType.Unit.PU);
    			strAry[5]=str.substring(21, 26).trim();
    			//KB
    			double Kb=0.0;
        		if(!strAry[6].equals("")){
        			Kb= new Double(strAry[6]).doubleValue();
            		ODMData2XmlHelper.setPUData(newExc.addNewKb(), 
            				Kb, PerUnitXmlType.Unit.PU);
        		}    		
    			
    			//T5
        		double T5=0.0;
        		if(!strAry[7].equals("")){
        			T5=new Double(strAry[7]).doubleValue();
        			ODMData2XmlHelper.setTimeData(newExc.addNewT5(), 
        					T5, TimeXmlType.Unit.SEC);
        		}			
    			//KE
        		double Ke=0.0;
        		if(!strAry[8].equals("")){
        			Ke= new Double(strAry[8]).doubleValue();
            		ODMData2XmlHelper.setPUData(newExc.addNewKe(), 
            				Ke, PerUnitXmlType.Unit.PU);
        		}		
    			// TE
        		double Te=0.0;
        		if(!strAry[9].equals("")){
        			Te=new Double(strAry[9]).doubleValue();
        			ODMData2XmlHelper.setTimeData(newExc.addNewTe(), 
        					Te, TimeXmlType.Unit.SEC);
        		}			
    			//SE1-0.75
        		double SE1=0.0;
        		if(!strAry[10].equals("")){
        			SE1=new Double(strAry[10]).doubleValue();
        			newExc.setE1(0.75);
        			newExc.setSE1(SE1);
        		}		
    			// VRMAX
    			double Vrmax= new Double(strAry[12]).doubleValue();
        		ODMData2XmlHelper.setPUData(newExc.addNewVRmax(), 
        				Vrmax, PerUnitXmlType.Unit.PU); 			
    			//VRMIN
    			double Vrmin= new Double(strAry[13]).doubleValue();
        		ODMData2XmlHelper.setPUData(newExc.addNewVRmin(), 
        				Vrmin, PerUnitXmlType.Unit.PU);			
    			//KC
        		double KC=0.0;
        		if(!strAry[14].equals("")){
        			KC= new Double(strAry[14]).doubleValue();
            		ODMData2XmlHelper.setPUData(newExc.addNewKc(), 
            				KC, PerUnitXmlType.Unit.PU);
        		}    					
    			//KD
        		double Kd=0.0;
        		if(!strAry[15].equals("")){
        			Kd= new Double(strAry[15]).doubleValue();
            		ODMData2XmlHelper.setPUData(newExc.addNewKd(), 
            				Kd, PerUnitXmlType.Unit.PU);
        		}				
    			//KL1
        		double KL1=0.0;
        		if(!strAry[16].equals("")){
        			KL1= new Double(strAry[16]).doubleValue();
            		ODMData2XmlHelper.setPUData(newExc.addNewKL1(), 
            				KL1, PerUnitXmlType.Unit.PU);
        		}			
    			//VLIR
        		double VLIR=0.0;
        		if(!strAry[17].equals("")){
        			VLIR= new Double(strAry[17]).doubleValue();
            		ODMData2XmlHelper.setPUData(newExc.addNewVL1R(), 
            				VLIR, PerUnitXmlType.Unit.PU);
        		}			
    			//EFDMAX
    			double EFDMAX= new Double(strAry[18]).doubleValue();
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
	
	 private static String[] getExciterDataFields ( final String str) {
			
	    	
	    	final String[] strAry = new String[19];		
			
			if(str.substring(0,1).trim().equals("E")){
				strAry[0]=str.substring(0, 2).trim();
				//busId
				strAry[1]=str.substring(3, 11).trim();
				//bus Voltage
				strAry[2]=str.substring(11, 15).trim();
				//excId
				strAry[3]=str.substring(15, 16).trim();
				//TR
				strAry[4]=str.substring(16, 20).trim();
				//KA for all, KV for EE
				strAry[5]=str.substring(20, 25).trim();
				//TA for all, TRH for EE
				strAry[6]=str.substring(25, 29).trim();
				//TA1
				strAry[7]=str.substring(29, 33).trim();
				//VRminMult, VRmax, VRmin for ED EJ
				strAry[8]=str.substring(33, 37).trim();
				// KE
				strAry[9]=str.substring(37, 41).trim();
				//TE
				strAry[10]=str.substring(41, 45).trim();
				//SE0.75MAX for all, KI for DD
				strAry[11]=str.substring(45, 49).trim();
				// SEmax for all, Kp for DD
				strAry[12]=str.substring(49, 53).trim();
				//EFDMin
				strAry[13]=str.substring(53, 58).trim();
				//EFDMax for all, VNmax for ED
				strAry[14]=str.substring(58, 62).trim();
				//KF
				strAry[15]=str.substring(62, 66).trim();
				//TF
				strAry[16]=str.substring(66, 70).trim();
				// XL for ED
				strAry[17]=str.substring(70, 75).trim();
				//TF1 for ED
				strAry[18]=str.substring(75, 80).trim();
				
			}else if(str.substring(0, 2).trim().equals("FA")||
					str.substring(0, 2).trim().equals("FB")||str.substring(0, 2).trim().equals("FC")
					||str.substring(0, 2).trim().equals("FD")||str.substring(0, 2).trim().equals("FE")||
					str.substring(0, 2).trim().equals("FF")||str.substring(0, 2).trim().equals("FG")
					||str.substring(0, 2).trim().equals("FH")||str.substring(0, 2).trim().equals("FJ")
					||str.substring(0, 2).trim().equals("FK")||str.substring(0, 2).trim().equals("FL")
					){
				
				strAry[0]=str.substring(0, 2).trim();
				//busId
				strAry[1]=str.substring(3, 11).trim();
				//bus Voltage
				strAry[2]=str.substring(11, 15).trim();
				//excId
				strAry[3]=str.substring(15, 16).trim();
				//Rc
				strAry[4]=str.substring(16, 21).trim();
				//Xc
				strAry[5]=str.substring(21, 26).trim();
				//TR
				strAry[6]=str.substring(26, 31).trim();
				//VIMax for G K L,VAmax for FF
				strAry[7]=str.substring(31, 36).trim();
				//VIMin for G K L,VAmin for FF
				strAry[8]=str.substring(36, 41).trim();
				// TB
				strAry[9]=str.substring(41, 46).trim();
				//TC
				strAry[10]=str.substring(46, 51).trim();
				//KA, KV for FE
				strAry[11]=str.substring(51, 56).trim();
				// TA, TRH for FE
				strAry[12]=str.substring(56, 61).trim();
				//VRmax, Vamax for FH
				strAry[13]=str.substring(61, 66).trim();
				//VRmin, Vamin
				strAry[14]=str.substring(66, 71).trim();
				//KE, KJ for FL
				strAry[15]=str.substring(71, 76).trim();
				//TE
				strAry[16]=str.substring(76, 80).trim();
			}else if(str.substring(0, 2).trim().equals("FQ")||str.substring(0, 2).trim().equals("FV")){
				
				strAry[0]=str.substring(0, 2).trim();
				//busId
				strAry[1]=str.substring(3, 11).trim();
				//bus Voltage
				strAry[2]=str.substring(11, 15).trim();
				//excId
				strAry[3]=str.substring(15, 16).trim();
				//Rc
				strAry[4]=str.substring(16, 20).trim();
				//Xc
				strAry[5]=str.substring(20, 24).trim();
				//TR
				strAry[6]=str.substring(24, 29).trim();
				//K
				strAry[7]=str.substring(29, 34).trim();
				//Kv
				strAry[8]=str.substring(34, 37).trim();
				// T1
				strAry[9]=str.substring(37, 42).trim();
				//T2
				strAry[10]=str.substring(42, 47).trim();
				//K3
				strAry[11]=str.substring(47, 52).trim();
				// T4
				strAry[12]=str.substring(52, 57).trim();
				//KA
				strAry[13]=str.substring(57, 62).trim();
				//TA
				strAry[14]=str.substring(62, 67).trim();
				//KF
				strAry[15]=str.substring(67, 72).trim();
				//TF
				strAry[16]=str.substring(72, 76).trim();
				//KH
				strAry[17]=str.substring(76, 80).trim();
			}
			else if(str.substring(0,2).trim().equals("FZ")){
				strAry[0]=str.substring(0, 2).trim();
				//busId
				strAry[1]=str.substring(3, 11).trim();
				//bus Voltage
				strAry[2]=str.substring(11, 15).trim();
				//excId
				strAry[3]=str.substring(15, 16).trim();
				//SE1, 
				strAry[4]=str.substring(16, 21).trim();
				//SE2, 
				strAry[5]=str.substring(21, 26).trim();
				//EFDmin
				strAry[6]=str.substring(26, 31).trim();
				//
				strAry[7]=str.substring(31, 36).trim();
				//KF
				strAry[8]=str.substring(36, 41).trim();
				// TF
				strAry[9]=str.substring(41, 46).trim();
				//KC
				strAry[10]=str.substring(46, 51).trim();
				//KD
				strAry[11]=str.substring(51, 56).trim();
				// 
				strAry[12]=str.substring(56, 61).trim();
				//
				strAry[13]=str.substring(61, 66).trim();
				//
				strAry[14]=str.substring(66, 71).trim();
				//
				strAry[15]=str.substring(71, 76).trim();			
				
			}else if(str.substring(0,2).trim().equals("F+")){
				strAry[0]=str.substring(0, 2).trim();
				//busId
				strAry[1]=str.substring(3, 11).trim();
				//bus Voltage
				strAry[2]=str.substring(11, 15).trim();
				//excId
				strAry[3]=str.substring(15, 16).trim();
				//VAMAX 
				strAry[4]=str.substring(16, 21).trim();
				//VAMIN 
				strAry[5]=str.substring(21, 26).trim();
				//KB
				strAry[6]=str.substring(26, 30).trim();
				//T5
				strAry[7]=str.substring(30, 34).trim();
				//KE
				strAry[8]=str.substring(34, 38).trim();
				// TE
				strAry[9]=str.substring(39, 42).trim();
				//SE1-0.75
				strAry[10]=str.substring(42, 47).trim();
				//SE2--EFDMAX
				strAry[11]=str.substring(47, 52).trim();
				// VRMAX
				strAry[12]=str.substring(52, 56).trim();
				//VRMIN
				strAry[13]=str.substring(56, 60).trim();
				//KC
				strAry[14]=str.substring(60, 64).trim();
				//KD
				strAry[15]=str.substring(64, 68).trim();	
				//KL1
				strAry[16]=str.substring(68, 72).trim();
				//VLIR
				strAry[17]=str.substring(72, 76).trim();
				//EFDMAX
				strAry[18]=str.substring(76, 80).trim();
				
			}
			
	        return strAry;
	        
	    }
	

}
