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

public class BPADynamicRecord {	
	
	static int dataType=0;
	final static int header=1;
	final static int faultOperation=2;
	final static int generatorData=3;
	final static int exciterData=4;
	final static int pssData=5;
	final static int turbine_governorData=6;
	final static int loadData=7;
	final static int sequenceData=8;
	
	
	public static int getDataType(String str){		 
		 if (str.startsWith("CASE")||str.startsWith("SOL")){
				dataType=header;
			}else if(str.startsWith("LS")){
				dataType=faultOperation;
			}else if(str.substring(0, 2).trim().equals("M")||
					str.substring(0, 2).trim().equals("MF")||
					str.substring(0, 2).trim().equals("MC")||
					str.substring(0, 2).trim().equals("LN")){
				dataType=generatorData;
			}else if (str.substring(0, 2).trim().equals("FA")||
					str.substring(0, 2).trim().equals("FB")||str.substring(0, 2).trim().equals("FC")
					||str.substring(0, 2).trim().equals("FD")||str.substring(0, 2).trim().equals("FE")||
					str.substring(0, 2).trim().equals("FF")||str.substring(0, 2).trim().equals("FG")
					||str.substring(0, 2).trim().equals("FH")||str.substring(0, 2).trim().equals("FJ")
					||str.substring(0, 2).trim().equals("FK")||str.substring(0, 2).trim().equals("FL")
					||str.substring(0, 2).trim().equals("FQ")||str.substring(0, 2).trim().equals("FV")
					||str.substring(0, 1).trim().equals("E")||
					str.substring(0, 2).trim().equals("FZ")||str.substring(0, 2).trim().equals("F+")){
				dataType=exciterData;
			}else if(str.substring(0, 2).trim().equals("SS")||
					str.substring(0, 2).trim().equals("SP")||str.substring(0, 2).trim().equals("SG")
					||str.substring(0, 2).trim().equals("SI")||str.substring(0, 3).trim().equals("SI+")){
				dataType=pssData;
			}else if(str.substring(0, 2).trim().equals("GS")||
					str.substring(0, 2).trim().equals("TA")||str.substring(0, 2).trim().equals("TB")
					||str.substring(0, 2).trim().equals("GH")||str.substring(0, 2).trim().equals("GG")){
				dataType=turbine_governorData;
			}else if(str.substring(0, 2).trim().equals("LA")||
					str.substring(0, 2).trim().equals("LB")||str.substring(0, 2).trim().equals("MI")){
				dataType=loadData;				
			}else if(str.substring(0, 2).trim().equals("LO")||str.substring(0, 2).trim().equals("XO")
					||str.substring(0, 2).trim().equals("LM")){
				dataType=sequenceData;
			}else if(str.startsWith(".")){
				dataType=0;
			}else {
				System.out.println("this line is not processed"+str);
			}		 
		 return dataType;
	}
	
	public static void processDynamicData(String str, TransientSimulationXmlType tranSimu, 
			final java.io.BufferedReader din,
			IEEEODMPSSModelParser parser ,BPAAdapter adapter) throws Exception{
		PSSNetworkXmlType baseCaseNet=parser.getBaseCase();
		do{
			str= din.readLine();
			getDataType(str);
			if(!str.startsWith("90")){
				try{
					if(dataType==header){
						processHeaderData(str, tranSimu);
					}else if(dataType==faultOperation){
						BPADynamicFaultOperationRecord.processFaultOperationData(str, tranSimu);
					}else if(dataType==generatorData){
						BPADynamicGeneratorRecord.processGeneratorData(str, tranSimu, baseCaseNet);
					}else if(dataType==exciterData){
						BPADynamicExciterRecord.processExciterData(str, tranSimu, parser);
					}else if(dataType==turbine_governorData){
						BPADynamicTurbineGovernorRecord.processTurbineGovernorData(str, tranSimu, parser);
					}else if(dataType==pssData){
						BPADynamicPSSRecord.processPSSData(str, tranSimu, parser);
					}else if(dataType==loadData){
						BPADynamicLoadCharacteristicRecord.processLoadCharacteristicData(str, tranSimu, parser.addNewLoad());
					}else if(dataType==sequenceData){
						BPADynamicSequenceRecord.processSequenceData(str, tranSimu, parser);
					}
					
				}catch (final Exception e){
					e.printStackTrace();
				}				
			}			
		}while (!str.startsWith("90"));
		// when all the data is converted, calculate negative sequence data
		BPADynamicSequenceRecord.processNegativeData(parser, tranSimu);		
	}
	
	public static void processHeaderData(String str,TransientSimulationXmlType tranSimu){
		final String strAry[]= getHeaderDataFields(str);
		
		TransientSimulationXmlType.PowerFlowInitialization pfInitial=
			tranSimu.getPowerFlowInitialization();
		
		// network solution card--SOL
		if(str.startsWith("SOL")){			
			String powerFlowMethod="PQ";
			if(!strAry[2].equals("")){
				if(new Integer(strAry[2]).intValue()==1){
					powerFlowMethod="NR";
					pfInitial.setPowerFlowMethod(TransientSimulationXmlType.
							PowerFlowInitialization.PowerFlowMethod.NR);
				}
			}else{
				pfInitial.setPowerFlowMethod(TransientSimulationXmlType.
						PowerFlowInitialization.PowerFlowMethod.PQ);
			}			
		}
		// CASE card
		if(str.startsWith("CASE")){
			//TransientSimulationXmlType.SimulationSetting simuSet= tranSimu.getSimulationSetting();
			
			String pfCase= strAry[1];
			pfInitial.setPowerFlowCase(pfCase);
		}		
	}
    private static String[] getHeaderDataFields ( final String str) {
		final String[] strAry = new String[16];
		// for SOL card
		if(str.startsWith("SOL")){
			strAry[0]=str.substring(0, 3);
			strAry[1]=str.substring(5, 6);
			strAry[2]=str.substring(8, 9);
			strAry[3]=str.substring(11, 12);
		}		
		// for Case card
		else if(str.startsWith("CASE")){
			strAry[0]=str.substring(0, 4);
			strAry[1]=str.substring(5, 15);
			strAry[2]=str.substring(16, 17);
			strAry[3]=str.substring(19, 20);
			strAry[4]=str.substring(21, 22);
			strAry[5]=str.substring(22, 23);
			strAry[6]=str.substring(23, 24);
			strAry[7]=str.substring(24, 34);
			strAry[8]=str.substring(34, 44);
			strAry[9]=str.substring(44, 49);
			strAry[10]=str.substring(49, 54);
			strAry[11]=str.substring(54, 59);
			strAry[12]=str.substring(59, 64);
			strAry[13]=str.substring(64, 69);
			strAry[14]=str.substring(69, 74);
			strAry[15]=str.substring(74, 80);
		}
		return strAry;
    }

}
