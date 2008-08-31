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

public class BPADynamicLoadCharacteristicRecord {
	
public static void processLoadCharacteristicData(String str,TransientSimulationXmlType tranSimu,
	        LoadCharacteristicXmlType load){
	final String[] strAry= getLoadDataFields(str ); 	

	//busId
	String busId="";
	if(!strAry[1].equals("")){
		busId=strAry[1];
		load.setLocation(LoadCharacteristicXmlType.Location.AT_BUS);
		load.addNewLocationId().setName(busId);
	}		
	//zone name
	String zoneId="";
	if(!strAry[3].equals("")){
		zoneId=strAry[3];
		load.setLocation(LoadCharacteristicXmlType.Location.AT_ZONE);
		load.addNewLocationId().setName(zoneId);
     }
	//area name
	String areaId="";
	if(!strAry[4].equals("")){
		areaId=strAry[4];
		load.setLocation(LoadCharacteristicXmlType.Location.AT_AREA);
		load.addNewLocationId().setName(areaId);
	}
	if(strAry[0].equals("LA")||strAry[0].equals("LB")){
		load.setLoadXmlType(LoadCharacteristicXmlType.LoadXmlType.IEEE_STATIC_LOAD);
		LoadCharacteristicModelListXmlType.IEEEStaticLoad staLoad=
			 load.addNewLoadModel().addNewIEEEStaticLoad();
		//pz
		double a1=0.0;
		if(!strAry[5].equals("")){
			a1= new Double(strAry[5]).doubleValue();
			staLoad.setA1(a1);
			staLoad.setN1(2);
		}
		//qz
		double a4=0.0;
		if(!strAry[6].equals("")){
			a4= new Double(strAry[6]).doubleValue();
			staLoad.setA4(a4);
			staLoad.setN4(2);
		}			
		//pi
		double a2=0.0;
		if(!strAry[7].equals("")){
			a2= new Double(strAry[7]).doubleValue();
			staLoad.setA2(a2);
			staLoad.setN2(1);
		}
		//qi
		double a5=0.0;
		if(!strAry[8].equals("")){
			a5= new Double(strAry[8]).doubleValue();
			staLoad.setA5(a5);
			staLoad.setN5(1);
		}
		// pp
		double a3=0.0;
		if(!strAry[9].equals("")){
			a3= new Double(strAry[9]).doubleValue();
			staLoad.setA3(a3);
			staLoad.setN3(0);
		}
		//qp
		double a6=0.0;
		if(!strAry[10].equals("")){
			a6= new Double(strAry[10]).doubleValue();
			staLoad.setA6(a6);
			staLoad.setN6(0);
		}			
		//pf
		double a9=0.0;
		if(!strAry[11].equals("")){
			a9= new Double(strAry[11]).doubleValue();
			staLoad.setA9(a9);				
		}
		// qf
		double a10=0.0;
		if(!strAry[12].equals("")){
			a10= new Double(strAry[12]).doubleValue();
			staLoad.setA10(a10);				
		}
		//Ldp
		double a7=0.0;
		if(!strAry[13].equals("")){
			a7= new Double(strAry[13]).doubleValue();
			staLoad.setA7(a7);				
		}		
		//Ldq
		double a8=0.0;
		if(!strAry[14].equals("")){
			a8= new Double(strAry[14]).doubleValue();
			staLoad.setA8(a8);				
		}			
		
	}else if(strAry[0].equals("MI")){
	// to do	
	}
}
private static String[] getLoadDataFields(String str){
	final String[] strAry= new String[19];
	if(str.substring(0, 2).trim().equals("LA")||str.substring(0, 2).trim().equals("LB")){
		strAry[0]=str.substring(0, 2).trim();
		//busId
		strAry[1]=str.substring(3, 11).trim();
		//bus Voltage
		strAry[2]=str.substring(11, 15).trim();
		//zone name
		strAry[3]=str.substring(15, 17).trim();
		//area name
		strAry[4]=str.substring(17, 27).trim();
		//pz
		strAry[5]=str.substring(27, 32).trim();
		//qz
		strAry[6]=str.substring(32, 37).trim();
		//pi
		strAry[7]=str.substring(37, 42).trim();
		//qi
		strAry[8]=str.substring(42, 47).trim();
		// pp
		strAry[9]=str.substring(47, 52).trim();
		//qp
		strAry[10]=str.substring(52, 57).trim();
		//pf
		strAry[11]=str.substring(57, 62).trim();
		// qf
		strAry[12]=str.substring(62, 67).trim();
		//Ldp
		strAry[13]=str.substring(67, 72).trim();
		//Ldq
		strAry[14]=str.substring(72, 77).trim();
		
		
	}else if(str.substring(0, 2).trim().equals("MI")){
		
	}
	
	
	
	
	return strAry;
}
	
}
