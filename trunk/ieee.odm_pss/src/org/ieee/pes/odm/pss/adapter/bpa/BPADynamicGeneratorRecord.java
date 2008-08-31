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

public class BPADynamicGeneratorRecord {
	
	public static void processGeneratorData(String str,TransientSimulationXmlType tranSimu,
    		PSSNetworkXmlType baseCaseNet){
    	
    	final String strAry[]=getGeneratorDataFields(str);
    	
    	if(str.substring(0, 2).trim().equals("M")){
    		GeneratorXmlType gen=tranSimu.getDynamicDataList().getBusDynDataList().
	         getGeneratorDataList().addNewGenerator();
    		String busId=strAry[1];
    		gen.addNewLocatedBus().setName(busId);
    		double ratedVoltage=0.0;
    		if(!strAry[2].equals("")){
    			ratedVoltage= new Double(strAry[2]).doubleValue();
    			ODMData2XmlHelper.setVoltageData(gen.addNewBusRatedVoltage(), 
    					ratedVoltage, VoltageXmlType.Unit.KV);    		
    		}
    		gen.setGeneratorType(GeneratorXmlType.GeneratorType.SUBTRANS_MODEL);
    		GeneratorModelListXmlType.SubTransientModel subTranGen=gen.
    		                    addNewGeneratorModel().addNewSubTransientModel();
    		String genId="";
    		if(!strAry[3].equals("")){
    			genId=strAry[3];
    			gen.addNewGenId().setName(genId);
    		}
    		String owner="";
    		if(!strAry[7].equals("")){
    			owner= strAry[7];
    		}
    		double xd11=0.0,  xq11=0.0  ,td011=0.0, tq011=0.0;
    		if(!strAry[8].equals("")){
    			xd11=new Double(strAry[8]).doubleValue();
    			ODMData2XmlHelper.setPUData(subTranGen.addNewXd11(), 
    					xd11, PerUnitXmlType.Unit.PU);
    		}
    		if(!strAry[9].equals("")){
    			xq11=new Double(strAry[9]).doubleValue();
    			ODMData2XmlHelper.setPUData(subTranGen.addNewXq11(), 
    					xq11, PerUnitXmlType.Unit.PU);
    		}
    		if(!strAry[10].equals("")){
    			td011=new Double(strAry[10]).doubleValue();
    			ODMData2XmlHelper.setTimeData(subTranGen.addNewTd011(), 
    					td011, TimeXmlType.Unit.SEC);
    		}
    		if(!strAry[11].equals("")){
    			tq011=new Double(strAry[11]).doubleValue();
    			ODMData2XmlHelper.setTimeData(subTranGen.addNewTq011(), 
    					tq011, TimeXmlType.Unit.SEC);
    		}
    		
		}else if(str.substring(0, 2).trim().equals("MF")){
			
			String busId=strAry[1];
			String genId="";			
			
    		if(!strAry[3].equals("")){
    			genId=strAry[3];    			
    		}
			GeneratorXmlType gen=ODMData2XmlHelper.getGeneratorRecord(tranSimu, busId, genId);
			// transient model
			if(gen!=null){
				GeneratorModelListXmlType.SubTransientModel subTranGen=gen
                .getGeneratorModel().getSubTransientModel();
				
				double pContri=0.0,qContri=0.0;
				if(!strAry[5].equals("")){
					pContri=new Double(strAry[5]).doubleValue();
					if(pContri<=1.0){
						pContri=pContri*100;
					}
					gen.addNewPContribution().setValue(pContri);
					gen.getPContribution().setUnit(PercentXmlType.Unit.PERCENT);
				}
				if(!strAry[6].equals("")){
					qContri=new Double(strAry[6]).doubleValue();
					if(qContri<=1.0){
						qContri=pContri*100;
					}
					gen.addNewQContribution().setValue(qContri);
					gen.getQContribution().setUnit(PercentXmlType.Unit.PERCENT);
				}
				
				
				double Emws=0.0;
				if(!strAry[4].equals("")){
					Emws=new Double(strAry[4]).doubleValue();
				}
				double MvaBase=0.0;
				if(!strAry[7].equals("")){
					MvaBase=new Double(strAry[7]).doubleValue();
				}else {
					MvaBase=baseCaseNet.getBasePower();
				}
				subTranGen.setBasePower(MvaBase);
				subTranGen.setBasePowerUnit(GeneratorModelListXmlType
						.SubTransientModel.BasePowerUnit.MVA);
				double h=0.0;
				if(Emws!=0.0){
					h=Emws/MvaBase;
					NumberFormat ddf1= NumberFormat.getInstance();
					ddf1.setMaximumFractionDigits(4);
					h= new Double(ddf1.format(h)).doubleValue();
					ODMData2XmlHelper.setPUData(subTranGen.addNewH(), h, PerUnitXmlType.Unit.PU);
				}
				
				double ra=0.0;
				if(!strAry[8].equals("")){
	    			ra=new Double(strAry[8]).doubleValue();
	    			ODMData2XmlHelper.setPUData(subTranGen.addNewRa(), ra, PerUnitXmlType.Unit.PU);	    			
	    		}
				double xd1=0.0;
				if(!strAry[9].equals("")){
					xd1=new Double(strAry[9]).doubleValue();
	    			ODMData2XmlHelper.setPUData(subTranGen.addNewXd1(), xd1, PerUnitXmlType.Unit.PU);	    			
	    		}
				double xq1=0.0;
				if(!strAry[10].equals("")){
					xq1=new Double(strAry[10]).doubleValue();
	    			ODMData2XmlHelper.setPUData(subTranGen.addNewXq1(), xq1, PerUnitXmlType.Unit.PU);	    			
	    		}
				double xd=0.0;
				if(!strAry[11].equals("")){
					xd=new Double(strAry[11]).doubleValue();
	    			ODMData2XmlHelper.setPUData(subTranGen.addNewXd(), xd, PerUnitXmlType.Unit.PU);	    			
	    		}
				double xq=0.0;
				if(!strAry[12].equals("")){
					xq=new Double(strAry[12]).doubleValue();
	    			ODMData2XmlHelper.setPUData(subTranGen.addNewXq(), xq, PerUnitXmlType.Unit.PU);	    			
	    		}
				double td01=0.0;
	    		if(!strAry[13].equals("")){
	    			td01=new Double(strAry[13]).doubleValue();
	    			ODMData2XmlHelper.setTimeData(subTranGen.addNewTdo1(), 
	    					td01, TimeXmlType.Unit.SEC);
	    		}
	    		double tq01=0.0;
	    		if(!strAry[14].equals("")){
	    			tq01=new Double(strAry[14]).doubleValue();
	    			ODMData2XmlHelper.setTimeData(subTranGen.addNewTq01(), 
	    					tq01, TimeXmlType.Unit.SEC);
	    		}
	    		double xl=0.0;
				if(!strAry[15].equals("")){
					xl=new Double(strAry[15]).doubleValue();
	    			ODMData2XmlHelper.setPUData(subTranGen.addNewXr(), xl, PerUnitXmlType.Unit.PU);	    			
	    		}
				double E1=1.0, SE1=0.0;
				if(!strAry[16].equals("")){
					SE1=new Double(strAry[16]).doubleValue();
					subTranGen.setE1(1.0);
					subTranGen.setSE1(SE1);
				}
				double E2=1.2, SE2=0.0;
				if(!strAry[17].equals("")){
					SE2=new Double(strAry[17]).doubleValue();
					subTranGen.setE2(1.2);
					subTranGen.setSE2(SE2);
				}
				
			}else if(gen==null){
				GeneratorXmlType newGen=tranSimu.getDynamicDataList().getBusDynDataList().
		         getGeneratorDataList().addNewGenerator();
				newGen.addNewLocatedBus().setName(busId);
				double ratedVoltage=0.0;
	    		if(!strAry[2].equals("")){
	    			ratedVoltage= new Double(strAry[2]).doubleValue();
	    			ODMData2XmlHelper.setVoltageData(newGen.addNewBusRatedVoltage(), 
	    					ratedVoltage, VoltageXmlType.Unit.KV);    		
	    		}
	    		if(!genId.equals("")){
	    			newGen.addNewGenId().setName(genId);
	    		}
	    		
	    		newGen.setGeneratorType(GeneratorXmlType.GeneratorType.TRANSIENT_MODEL);
	    		GeneratorModelListXmlType.TransModel tranGen= newGen.addNewGeneratorModel().
	    		         addNewTransModel();
	    		
	    		double pContri=0.0,qContri=0.0;
				if(!strAry[5].equals("")){
					pContri=new Double(strAry[5]).doubleValue();
					if(pContri<=1.0){
						pContri=pContri*100;
					}
					newGen.addNewPContribution().setValue(pContri);
					newGen.getPContribution().setUnit(PercentXmlType.Unit.PERCENT);
				}
				if(!strAry[6].equals("")){
					qContri=new Double(strAry[6]).doubleValue();
					if(qContri<=1.0){
						qContri=pContri*100;
					}
					newGen.addNewQContribution().setValue(qContri);
					newGen.getQContribution().setUnit(PercentXmlType.Unit.PERCENT);
				}
				double Emws=0.0;
				if(!strAry[4].equals("")){
					Emws=new Double(strAry[4]).doubleValue();
				}
				double MvaBase=0.0;
				if(!strAry[7].equals("")){
					MvaBase=new Double(strAry[7]).doubleValue();
				}else {
					MvaBase=baseCaseNet.getBasePower();
				}
				tranGen.setBasePower(MvaBase);
				tranGen.setBasePowerUnit(GeneratorModelListXmlType
						.TransModel.BasePowerUnit.MVA);
				double h=0.0;
				if(Emws!=0.0){
					h=Emws/MvaBase;
					NumberFormat ddf1= NumberFormat.getInstance();
					ddf1.setMaximumFractionDigits(4);
					h= new Double(ddf1.format(h)).doubleValue();
					ODMData2XmlHelper.setPUData(tranGen.addNewH(), h, PerUnitXmlType.Unit.PU);
				}
				
				double ra=0.0;
				if(!strAry[8].equals("")){
	    			ra=new Double(strAry[8]).doubleValue();
	    			ODMData2XmlHelper.setPUData(tranGen.addNewRa(), ra, PerUnitXmlType.Unit.PU);	    			
	    		}
				double xd1=0.0;
				if(!strAry[9].equals("")){
					xd1=new Double(strAry[9]).doubleValue();
	    			ODMData2XmlHelper.setPUData(tranGen.addNewXd1(), xd1, PerUnitXmlType.Unit.PU);	    			
	    		}
				double xq1=0.0;
				if(!strAry[10].equals("")){
					xq1=new Double(strAry[10]).doubleValue();
	    			ODMData2XmlHelper.setPUData(tranGen.addNewXq1(), xq1, PerUnitXmlType.Unit.PU);	    			
	    		}
				double xd=0.0;
				if(!strAry[11].equals("")){
					xd=new Double(strAry[11]).doubleValue();
	    			ODMData2XmlHelper.setPUData(tranGen.addNewXd(), xd, PerUnitXmlType.Unit.PU);	    			
	    		}
				double xq=0.0;
				if(!strAry[12].equals("")){
					xq=new Double(strAry[12]).doubleValue();
	    			ODMData2XmlHelper.setPUData(tranGen.addNewXq(), xq, PerUnitXmlType.Unit.PU);	    			
	    		}
				double td01=0.0;
	    		if(!strAry[13].equals("")){
	    			td01=new Double(strAry[13]).doubleValue();
	    			ODMData2XmlHelper.setTimeData(tranGen.addNewTdo1(), 
	    					td01, TimeXmlType.Unit.SEC);
	    		}
	    		double tq01=0.0;
	    		if(!strAry[14].equals("")){
	    			tq01=new Double(strAry[14]).doubleValue();
	    			ODMData2XmlHelper.setTimeData(tranGen.addNewTq01(), 
	    					tq01, TimeXmlType.Unit.SEC);
	    		}	    		
				double E1=1.0, SE1=0.0;
				if(!strAry[16].equals("")){
					SE1=new Double(strAry[16]).doubleValue();
					tranGen.setE1(1.0);
					tranGen.setSE1(SE1);
				}
				double E2=1.2, SE2=0.0;
				if(!strAry[17].equals("")){
					SE2=new Double(strAry[17]).doubleValue();
					tranGen.setE2(1.2);
					tranGen.setSE2(SE2);
				}			
			}			
		// classical model 	
		}else if(str.substring(0,2).trim().equals("MC")){
			
			GeneratorXmlType gen=tranSimu.getDynamicDataList().getBusDynDataList().
	         getGeneratorDataList().addNewGenerator();
			String busId=strAry[1];
	   		gen.addNewLocatedBus().setName(busId);
	   		double ratedVoltage=0.0;
	   		if(!strAry[2].equals("")){
	   			ratedVoltage= new Double(strAry[2]).doubleValue();
	   			ODMData2XmlHelper.setVoltageData(gen.addNewBusRatedVoltage(), 
	   					ratedVoltage, VoltageXmlType.Unit.KV);    		
	   		}
	   		gen.setGeneratorType(GeneratorXmlType.GeneratorType.CLASSICAL_MODEL);
	   		GeneratorModelListXmlType.ClassicalModel claGen=gen.
	   		                    addNewGeneratorModel().addNewClassicalModel();
	   		String genId="";
	   		if(!strAry[3].equals("")){
	   			genId=strAry[3];
	   			gen.addNewGenId().setName(genId);
	   		}
	   		double pContri=0.0,qContri=0.0;
			if(!strAry[5].equals("")){
				pContri=new Double(strAry[5]).doubleValue();
				if(pContri<=1.0){
					pContri=pContri*100;
				}
				gen.addNewPContribution().setValue(pContri);
				gen.getPContribution().setUnit(PercentXmlType.Unit.PERCENT);
			}
			if(!strAry[6].equals("")){
				qContri=new Double(strAry[6]).doubleValue();
				if(qContri<=1.0){
					qContri=pContri*100;
				}
				gen.addNewQContribution().setValue(qContri);
				gen.getQContribution().setUnit(PercentXmlType.Unit.PERCENT);
			}
			double MvaBase=0.0;
			if(!strAry[7].equals("")){
				MvaBase=new Double(strAry[7]).doubleValue();
			}else {
				MvaBase=baseCaseNet.getBasePower();
			}
			claGen.setBasePower(MvaBase);
			claGen.setBasePowerUnit(GeneratorModelListXmlType
					.ClassicalModel.BasePowerUnit.MVA);
			double Emws=0.0;
			if(!strAry[4].equals("")){
				Emws=new Double(strAry[4]).doubleValue();
			}
			double h=0.0;
			if(Emws!=0.0){
				h=Emws/MvaBase;
				NumberFormat ddf1= NumberFormat.getInstance();
				ddf1.setMaximumFractionDigits(4);
				h= new Double(ddf1.format(h)).doubleValue();
				ODMData2XmlHelper.setPUData(claGen.addNewH(), h, PerUnitXmlType.Unit.PU);
			}
			double xd1=0.0;
			if(!strAry[9].equals("")){
				xd1=new Double(strAry[9]).doubleValue();
    			ODMData2XmlHelper.setPUData(claGen.addNewXd1(), xd1, PerUnitXmlType.Unit.PU);	    			
    		}
			double D=0.0;
			if(!strAry[18].equals("")){
				D=new Double(strAry[18]).doubleValue();
    			ODMData2XmlHelper.setPUData(claGen.addNewD(), D, PerUnitXmlType.Unit.PU);
			}   		
   		
		}else if(str.substring(0, 2).trim().equals("LN")){
			
			String bus1="";
			double Vol1=0.0;
			if(!strAry[1].equals("")){
				bus1=strAry[1];
			}
			if(!strAry[2].equals("")){
				Vol1=new Double(strAry[2]).doubleValue();
			}
			if(!bus1.equals("")&&Vol1!=0.0){
				GeneratorXmlType gen=tranSimu.getDynamicDataList().getBusDynDataList()
				.getGeneratorDataList().addNewGenerator();
				gen.addNewLocatedBus().setName(bus1);
				ODMData2XmlHelper.setVoltageData(gen.addNewBusRatedVoltage(),
						Vol1, VoltageXmlType.Unit.KV);
				gen.setGeneratorType(GeneratorXmlType.GeneratorType.EQUI_GEN_UNIT);
				GeneratorModelListXmlType.EquiGenUnit equiGen=gen.addNewGeneratorModel().addNewEquiGenUnit();
				BusRecordXmlType busRec=ODMData2XmlHelper.getBusRecord(bus1, baseCaseNet);
				if(busRec!=null){
					double pGen=busRec.getLoadflowBusData().getGenData().
					              getGen().getPower().getP();
					equiGen.setEquiPgen(pGen);
					equiGen.setPGenUnit(GeneratorModelListXmlType.EquiGenUnit.PGenUnit.MVA);					
				}else{
					equiGen.setDCLineBus(true);
				}
				
				
			}
			String bus2="";
			double Vol2=0.0;
			if(!strAry[3].equals("")){
				bus2=strAry[3];
			}
			if(!strAry[4].equals("")){
				Vol2=new Double(strAry[4]).doubleValue();
			}
			String bus3="";
			double Vol3=0.0;
			if(!strAry[5].equals("")){
				bus3=strAry[5];
			}
			if(!strAry[6].equals("")){
				Vol3=new Double(strAry[6]).doubleValue();
			}
			String bus4="";
			double Vol4=0.0;
			if(!strAry[7].equals("")){
				bus4=strAry[7];
			}
			if(!strAry[8].equals("")){
				Vol4=new Double(strAry[8]).doubleValue();
			}
			String bus5="";
			double Vol5=0.0;
			if(!strAry[9].equals("")){
				bus5=strAry[9];
			}
			if(!strAry[10].equals("")){
				Vol5=new Double(strAry[10]).doubleValue();
			}
		}
    	   	
    	
    }
	
	private static String[] getGeneratorDataFields ( final String str) {
		final String[] strAry = new String[19];
		
		if(str.substring(0, 2).trim().equals("M")){
			
			strAry[0]=str.substring(0, 2).trim();
			strAry[1]=str.substring(3, 11).trim();
			strAry[2]=str.substring(11, 15).trim();
			strAry[3]=str.substring(15, 16).trim();
			strAry[4]=str.substring(16, 21).trim();
			strAry[5]=str.substring(22, 25).trim();
			strAry[6]=str.substring(30, 32).trim();
			strAry[7]=str.substring(33, 36).trim();
			strAry[8]=str.substring(37, 42).trim();
			strAry[9]=str.substring(42, 47).trim();
			strAry[10]=str.substring(47, 51).trim();
			strAry[11]=str.substring(51, 55).trim();			
			
		}else if(str.substring(0, 2).trim().equals("MC")||str.substring(0, 2).trim().equals("MF")){
			
			strAry[0]=str.substring(0, 2).trim();
			strAry[1]=str.substring(3, 11).trim();
			strAry[2]=str.substring(11, 15).trim();
			strAry[3]=str.substring(15, 16).trim();
			strAry[4]=str.substring(16, 22).trim();
			strAry[5]=str.substring(22, 25).trim();
			strAry[6]=str.substring(25, 28).trim();
			strAry[7]=str.substring(28, 32).trim();
			strAry[8]=str.substring(32, 36).trim();
			strAry[9]=str.substring(36, 41).trim();
			strAry[10]=str.substring(41, 46).trim();
			strAry[11]=str.substring(46, 51).trim();
			strAry[12]=str.substring(51, 56).trim();
			strAry[13]=str.substring(56, 60).trim();
			strAry[14]=str.substring(60, 63).trim();
			strAry[15]=str.substring(63, 68).trim();
			strAry[16]=str.substring(68, 73).trim();
			strAry[17]=str.substring(73, 77).trim();
			strAry[18]=str.substring(77, 80).trim();
		}else if(str.substring(0, 2).trim().equals("LN")){
			
			strAry[0]=str.substring(0, 2).trim();
			strAry[1]=str.substring(3, 11).trim();
			strAry[2]=str.substring(11, 15).trim();
			strAry[3]=str.substring(18, 26).trim();
			strAry[4]=str.substring(26, 30).trim();
			strAry[5]=str.substring(33, 41).trim();
			strAry[6]=str.substring(41, 45).trim();
			strAry[7]=str.substring(49, 56).trim();
			strAry[8]=str.substring(56, 60).trim();
			strAry[9]=str.substring(63, 71).trim();
			strAry[10]=str.substring(71, 75).trim();
		}	
		
		return strAry;
    }

}
