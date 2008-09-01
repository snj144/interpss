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
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PerUnitXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TimeXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TransientSimulationXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TurbineGovernorModelListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TurbineGovernorXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TurbineXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageXmlType;
import org.ieee.pes.odm.pss.model.IEEEODMPSSModelParser;
import org.ieee.pes.odm.pss.model.ODMData2XmlHelper;
import org.ieee.pes.odm.pss.model.StringUtil;


public class BPADynamicTurbineGovernorRecord {
	
	public static void processTurbineGovernorData(String str,TransientSimulationXmlType tranSimu,
    		IEEEODMPSSModelParser parser,BPAAdapter adapter){
    	
    	
    	final String strAry[]=getTGDataFields(str,adapter);
    	if(strAry[0].equals("GG")){ 
    		TurbineGovernorXmlType tg=parser.addNewTurbineGovernor();
    		tg.setTurbineGovernorType(TurbineGovernorXmlType.TurbineGovernorType.HYDRO_STREAM_GENERAL_MODEL);
    		TurbineGovernorModelListXmlType.HydroStreamGeneralModel gg=
    			tg.addNewTurbineGovernorModel().addNewHydroStreamGeneralModel();
    		//busId
    		String busId=strAry[1];
    		tg.addNewLocatedBus().setName(busId);			
			//bus Voltage
    		double v= new Double(strAry[2]).doubleValue();    		
    		ODMData2XmlHelper.setVoltageData(tg.addNewBusRatedVoltage(), v,
    				VoltageXmlType.Unit.KV);			
			//excId
    		String tgId;
    		if(!strAry[3].equals("")){
    			tgId=strAry[3];
    			tg.addNewTgId().setName(tgId);
    		}			
			//PMAX 
    		double pmax=new Double(strAry[4]).doubleValue();
    		ODMData2XmlHelper.setPUData(gg.addNewPMAX(), pmax, PerUnitXmlType.Unit.PU);
			//R
    		double r=new Double(strAry[5]).doubleValue();
    		ODMData2XmlHelper.setPUData(gg.addNewR(), r, PerUnitXmlType.Unit.PU);
			
			//T1
    		double T1=new Double(strAry[6]).doubleValue();
    		ODMData2XmlHelper.setTimeData(gg.addNewT1(), 
    					T1, TimeXmlType.Unit.SEC);
			//T2
    	    double T2=new Double(strAry[7]).doubleValue();
		    ODMData2XmlHelper.setTimeData(gg.addNewT2(), 
					       T2, TimeXmlType.Unit.SEC);		   
			//T3
		    double T3=new Double(strAry[8]).doubleValue();
		    ODMData2XmlHelper.setTimeData(gg.addNewT3(), 
					       T3, TimeXmlType.Unit.SEC);			
			// T4
		    double T4=new Double(strAry[9]).doubleValue();
		    ODMData2XmlHelper.setTimeData(gg.addNewT4(), 
					       T4, TimeXmlType.Unit.SEC);			
			//T5
		    double T5=new Double(strAry[10]).doubleValue();
		    ODMData2XmlHelper.setTimeData(gg.addNewT5(), 
					       T5, TimeXmlType.Unit.SEC);
			
			//F
		    double f=new Double(strAry[11]).doubleValue();
    		ODMData2XmlHelper.setPUData(gg.addNewF(), f, PerUnitXmlType.Unit.PU);
			
    	}else if(strAry[0].equals("GH")){
    		TurbineGovernorXmlType tg=parser.addNewTurbineGovernor();
    		tg.setTurbineGovernorType(TurbineGovernorXmlType.TurbineGovernorType.HYDRO_GOVERNER_AND_TURBINE);
    		TurbineGovernorModelListXmlType.HydroGovernerAndTurbine gh=
    			tg.addNewTurbineGovernorModel().addNewHydroGovernerAndTurbine();
    		//busId
    		String busId=strAry[1];
    		tg.addNewLocatedBus().setName(busId);			
			//bus Voltage
    		double v= new Double(strAry[2]).doubleValue();    		
    		ODMData2XmlHelper.setVoltageData(tg.addNewBusRatedVoltage(), v,
    				VoltageXmlType.Unit.KV);			
			//excId
    		String tgId;
    		if(!strAry[3].equals("")){
    			tgId=strAry[3];
    			tg.addNewTgId().setName(tgId);
    		}			
			//PMAX 
    		double pmax=new Double(strAry[4]).doubleValue();
    		ODMData2XmlHelper.setPUData(gh.addNewPMAX(), pmax, PerUnitXmlType.Unit.PU);
    		//R
    		double r=new Double(strAry[5]).doubleValue();
    		ODMData2XmlHelper.setPUData(gh.addNewR(), r, PerUnitXmlType.Unit.PU);
			//TG
    		double Tg=new Double(strAry[6]).doubleValue();
		    ODMData2XmlHelper.setTimeData(gh.addNewTG(), 
					       Tg, TimeXmlType.Unit.SEC);			
			//TP
		    double Tp=new Double(strAry[7]).doubleValue();
		    ODMData2XmlHelper.setTimeData(gh.addNewTP(), 
					       Tp, TimeXmlType.Unit.SEC);		
			//TD
		    double Td= new Double(strAry[8]).doubleValue();
		    ODMData2XmlHelper.setTimeData(gh.addNewTD(), 
				       Td, TimeXmlType.Unit.SEC);			
			// TW/2
		    double Tw= new Double(strAry[9]).doubleValue();
		    ODMData2XmlHelper.setTimeData(gh.addNewTWhalf(), 
				       Tw, TimeXmlType.Unit.SEC);			
			//VELCLOSE
		    double Uc=new Double(strAry[10]).doubleValue();
    		ODMData2XmlHelper.setPUData(gh.addNewUc(), Uc, PerUnitXmlType.Unit.PU);
			
			//FVELOPEN
    		double Uo=new Double(strAry[11]).doubleValue();
    		ODMData2XmlHelper.setPUData(gh.addNewUo(), Uo, PerUnitXmlType.Unit.PU);
			
			//Dd
    		double Dd=0.0;
    		if(!strAry[12].equals("")){
    			Dd=new Double(strAry[12]).doubleValue();
    		}    	
    		ODMData2XmlHelper.setPUData(gh.addNewD4(), Dd, PerUnitXmlType.Unit.PU);		
			
    		
    	}else if(strAry[0].equals("GS")){
    		TurbineGovernorXmlType tg=parser.addNewTurbineGovernor();
    		tg.setTurbineGovernorType(TurbineGovernorXmlType.TurbineGovernorType.HYDRO_GOVERNER);
    		TurbineGovernorModelListXmlType.HydroGoverner gs=
    			tg.addNewTurbineGovernorModel().addNewHydroGoverner();
    		//busId
    		String busId=strAry[1];
    		tg.addNewLocatedBus().setName(busId);
    		//bus Voltage
    		double v= new Double(strAry[2]).doubleValue();    		
    		ODMData2XmlHelper.setVoltageData(tg.addNewBusRatedVoltage(), v,
    				VoltageXmlType.Unit.KV);			
			//excId
    		String tgId;
    		if(!strAry[3].equals("")){
    			tgId=strAry[3];
    			tg.addNewTgId().setName(tgId);
    		}			
			//PMAX 
    		double pmax=new Double(strAry[4]).doubleValue();
    		ODMData2XmlHelper.setPUData(gs.addNewPMAX(), pmax, PerUnitXmlType.Unit.PU);
    		//PMIN
    		double pmin=0.0;
    		if(!strAry[5].equals("")){
    			pmin=new Double(strAry[5]).doubleValue();
        		ODMData2XmlHelper.setPUData(gs.addNewPMIN(), pmin, PerUnitXmlType.Unit.PU);	
    		}	
    		//R
    		double r=new Double(strAry[6]).doubleValue();
    		ODMData2XmlHelper.setPUData(gs.addNewR(), r, PerUnitXmlType.Unit.PU);
			//T1
    		double T1=0.0;
    		if(!strAry[7].equals("")){
    			T1= new Double(strAry[7]).doubleValue();
    		    ODMData2XmlHelper.setTimeData(gs.addNewT1(), 
    				       T1, TimeXmlType.Unit.SEC);
    		}
    					
			//T2
    		double T2=0.0;
    		if(!strAry[8].equals("")){
    			T2= new Double(strAry[8]).doubleValue();
    		    ODMData2XmlHelper.setTimeData(gs.addNewT2(), 
    				       T2, TimeXmlType.Unit.SEC);
    		}		    		
			// T3
		    double T3= new Double(strAry[9]).doubleValue();
		    ODMData2XmlHelper.setTimeData(gs.addNewT3(), 
				       T3, TimeXmlType.Unit.SEC);			
			//VELOPEN
		    double Uo=new Double(strAry[10]).doubleValue();
    		ODMData2XmlHelper.setPUData(gs.addNewU0(), Uo, PerUnitXmlType.Unit.PU);			
			//FVELCLOSE
    		double Uc=new Double(strAry[10]).doubleValue();
    		ODMData2XmlHelper.setPUData(gs.addNewUC(), Uc, PerUnitXmlType.Unit.PU);
    	}else if(strAry[0].equals("TA")){
    		//busId
    		String busId=strAry[1];    		
    		String tgId="";
    		if(!strAry[3].equals("")){
    			tgId=strAry[3];    			
    		}
    		TurbineGovernorXmlType tgOld=ODMData2XmlHelper.getTGRecord(tranSimu, busId, tgId);
    		if(tgOld.getTurbineGovernorType().equals
    				(TurbineGovernorXmlType.TurbineGovernorType.HYDRO_GOVERNER)){
    			TurbineXmlType tur=tgOld.getTurbineGovernorModel().getHydroGoverner().addNewTurbine();
    			TurbineXmlType.SteamTurbine steamTur=tur.addNewSteamTurbine();
    			//TCH
    			double TCH= new Double(strAry[4]).doubleValue();
    		    ODMData2XmlHelper.setTimeData(steamTur.addNewTCH(),
    		    		TCH, TimeXmlType.Unit.SEC);	    			
    			//k1
    		    double k1=new Double(strAry[5]).doubleValue();
    		    steamTur.setK(k1);
    		}
    		
    	}else if(strAry[0].equals("TB")){
    		//busId
    		String busId=strAry[1];    		
    		String tgId="";
    		if(!strAry[3].equals("")){
    			tgId=strAry[3];    			
    		}
    		TurbineGovernorXmlType tgOld=ODMData2XmlHelper.getTGRecord(tranSimu, busId, tgId);
    		if(tgOld.getTurbineGovernorType().equals
    				(TurbineGovernorXmlType.TurbineGovernorType.HYDRO_GOVERNER)){
    			TurbineXmlType tur=tgOld.getTurbineGovernorModel().getHydroGoverner().addNewTurbine();
    			
    			TurbineXmlType.SteamTurbine steamTur=tur.addNewSteamTurbine();
    			
    			//TCH
    			double TCH= new Double(strAry[4]).doubleValue();
    		    ODMData2XmlHelper.setTimeData(steamTur.addNewTCH(),
    		    		TCH, TimeXmlType.Unit.SEC);	  
    			//FHP
    		    double FHP= new Double(strAry[5]).doubleValue();
    			steamTur.setFHP(FHP);
    			//TRH
    		    double TRH= new Double(strAry[6]).doubleValue();
    		    ODMData2XmlHelper.setTimeData(steamTur.addNewTRH(),
    		    		TRH, TimeXmlType.Unit.SEC);	    			
    			//FIP
    		    double FIP= new Double(strAry[7]).doubleValue();
    		    steamTur.setFIP(FIP);    			
    			//TCO
    		    double TCO=0.0;
    		    if(!strAry[8].equals("")){
    		    	TCO= new Double(strAry[8]).doubleValue();
        		    ODMData2XmlHelper.setTimeData(steamTur.addNewTCO(),
        		    		TCO, TimeXmlType.Unit.SEC);
    		    }
    		    	    			
    			// FLP
    		    double FLP=0.0;
    		    if(!strAry[9].equals("")){
    		    	FLP= new Double(strAry[9]).doubleValue();
        		    steamTur.setFLP(FLP);
    		    }    		        			
    		}    
    	}
    	
    }
	
	 private static String[] getTGDataFields ( final String str,BPAAdapter adapter) {
		   	
	    	final String[] strAry = new String[19];
	    	
	    	try{
	    		if(str.substring(0, 2).trim().equals("GG")){
		    		strAry[0]=StringUtil.getStringReturnEmptyString(str,1, 2).trim();
					//busId
					strAry[1]=StringUtil.getStringReturnEmptyString(str,4, 11).trim();
					//bus Voltage
					strAry[2]=StringUtil.getStringReturnEmptyString(str,12, 15).trim();
					//excId
					strAry[3]=StringUtil.getStringReturnEmptyString(str,16, 16).trim();
					//PMAX 
					strAry[4]=StringUtil.getStringReturnEmptyString(str,17, 22).trim();
					//R
					strAry[5]=StringUtil.getStringReturnEmptyString(str,23, 27).trim();
					//T1
					strAry[6]=StringUtil.getStringReturnEmptyString(str,28, 32).trim();
					//T2
					strAry[7]=StringUtil.getStringReturnEmptyString(str,33, 37).trim();
					//T3
					strAry[8]=StringUtil.getStringReturnEmptyString(str,38, 42).trim();
					// T4
					strAry[9]=StringUtil.getStringReturnEmptyString(str,43, 47).trim();
					//T5
					strAry[10]=StringUtil.getStringReturnEmptyString(str,48, 52).trim();
					//F
					strAry[11]=StringUtil.getStringReturnEmptyString(str,53, 57).trim();
					
		    		
		    	}else if(str.substring(0, 2).trim().equals("GH")){
		    		strAry[0]=StringUtil.getStringReturnEmptyString(str,1, 2).trim();
					//busId
					strAry[1]=StringUtil.getStringReturnEmptyString(str,4, 11).trim();
					//bus Voltage
					strAry[2]=StringUtil.getStringReturnEmptyString(str,12, 15).trim();
					//excId
					strAry[3]=StringUtil.getStringReturnEmptyString(str,16, 16).trim();
					//PMAX 
					strAry[4]=StringUtil.getStringReturnEmptyString(str,17, 22).trim();
					//R
					strAry[5]=StringUtil.getStringReturnEmptyString(str,23, 27).trim();
					//TG
					strAry[6]=StringUtil.getStringReturnEmptyString(str,28, 32).trim();
					//TP
					strAry[7]=StringUtil.getStringReturnEmptyString(str,33, 37).trim();
					//TD
					strAry[8]=StringUtil.getStringReturnEmptyString(str,38, 42).trim();
					// TW/2
					strAry[9]=StringUtil.getStringReturnEmptyString(str,43, 47).trim();
					//VELCLOSE
					strAry[10]=StringUtil.getStringReturnEmptyString(str,48, 52).trim();
					//FVELOPEN
					strAry[11]=StringUtil.getStringReturnEmptyString(str,53, 57).trim();
					//Dd
					strAry[12]=StringUtil.getStringReturnEmptyString(str,58, 62).trim();
					
		    		
		    	}
		    	else if(str.substring(0, 2).trim().equals("GS")){
		    		strAry[0]=StringUtil.getStringReturnEmptyString(str,1, 2).trim();
					//busId
					strAry[1]=StringUtil.getStringReturnEmptyString(str,4, 11).trim();
					//bus Voltage
					strAry[2]=StringUtil.getStringReturnEmptyString(str,12, 15).trim();
					//excId
					strAry[3]=StringUtil.getStringReturnEmptyString(str,16, 16).trim();
					//PMAX 
					strAry[4]=StringUtil.getStringReturnEmptyString(str,17, 22).trim();
					//PMIN
					strAry[5]=StringUtil.getStringReturnEmptyString(str,23, 28).trim();
					//R
					strAry[6]=StringUtil.getStringReturnEmptyString(str,29, 33).trim();
					//T1
					strAry[7]=StringUtil.getStringReturnEmptyString(str,34, 38).trim();
					//T2
					strAry[8]=StringUtil.getStringReturnEmptyString(str,39, 43).trim();
					// T3
					strAry[9]=StringUtil.getStringReturnEmptyString(str,44, 48).trim();
					//VELOPEN
					strAry[10]=StringUtil.getStringReturnEmptyString(str,49, 54).trim();
					//FVELCLOSE
					strAry[11]=StringUtil.getStringReturnEmptyString(str,55, 60).trim();			
		    		
		    	}else if(str.substring(0, 2).trim().equals("TA")){
		    		strAry[0]=StringUtil.getStringReturnEmptyString(str,1, 2).trim();
					//busId
					strAry[1]=StringUtil.getStringReturnEmptyString(str,4, 11).trim();
					//bus Voltage
					strAry[2]=StringUtil.getStringReturnEmptyString(str,12, 15).trim();
					//excId
					strAry[3]=StringUtil.getStringReturnEmptyString(str,16, 16).trim();
					//TCH
					strAry[4]=StringUtil.getStringReturnEmptyString(str,17, 21).trim();
					//k1
					strAry[5]=StringUtil.getStringReturnEmptyString(str,23, 26).trim();
		    	}else if(str.substring(0, 2).trim().equals("TB")){
		    		strAry[0]=StringUtil.getStringReturnEmptyString(str,1, 2).trim();
					//busId
					strAry[1]=StringUtil.getStringReturnEmptyString(str,4, 11).trim();
					//bus Voltage
					strAry[2]=StringUtil.getStringReturnEmptyString(str,12, 15).trim();
					//excId
					strAry[3]=StringUtil.getStringReturnEmptyString(str,14, 16).trim();
					//tch
					strAry[4]=StringUtil.getStringReturnEmptyString(str,17, 21).trim();
					//FHP
					strAry[5]=StringUtil.getStringReturnEmptyString(str,22, 26).trim();
					//TRH
					strAry[6]=StringUtil.getStringReturnEmptyString(str,32, 36).trim();
					//FIP
					strAry[7]=StringUtil.getStringReturnEmptyString(str,37, 41).trim();
					//TCO
					strAry[8]=StringUtil.getStringReturnEmptyString(str,47, 51).trim();
					// FLP
					strAry[9]=StringUtil.getStringReturnEmptyString(str,52, 56).trim();
					
		    	}
	    	}catch(Exception e){
	    		adapter.logErr(e.toString());
	    	}
	    	return strAry;
		
	    }

}
