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
 * @Author Stephen Hau, Mike Zhou
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
	final static int lineZeroData=8;
	final static int xfrZeroData=9;
	final static int shuntLineZeroData=10;
	final static int exciterComplementData=11;
	
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
					||str.substring(0, 1).trim().equals("E")){
				dataType=exciterData;
			}else if(str.substring(0, 2).trim().equals("FZ")||str.substring(0, 2).trim().equals("F+")){
				dataType=exciterComplementData;
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
			}else if(str.substring(0, 2).trim().equals("LO")){
				dataType=lineZeroData;
			}
			else if(str.substring(0, 2).trim().equals("XO")){
				dataType=xfrZeroData;
			}
			else if(str.substring(0, 2).trim().equals("xr")){
				dataType=shuntLineZeroData;
			}else if(str.startsWith(".")){
				dataType=0;
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
			if(!str.startsWith("99")){
				try{
					if(dataType==header){
						processHeaderData(str, tranSimu);
					}else if(dataType==faultOperation){
						processFaultOperationData(str, tranSimu);
					}else if(dataType==generatorData){
						processGeneratorData(str, tranSimu, baseCaseNet);
					}else if(dataType==exciterData){
						processExciterData(str, tranSimu, parser.addNewExciter());
					}else if(dataType==exciterComplementData){
						processExciterComplementData(str, tranSimu);
					}else if(dataType==turbine_governorData){
						processTurbineGovernorData(str, tranSimu, parser);
					}else if(dataType==pssData){
						processPSSData(str, tranSimu, parser);
					}
					
				}catch (final Exception e){
					e.printStackTrace();
				}				
			}			
		}while (!str.startsWith("99"));
		
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
    public static void processFaultOperationData(String str,TransientSimulationXmlType tranSimu){ 
    	
    	int mode =new Integer(str.substring(35, 37).trim()).intValue();
    	final String strAry[] = getFaultOperationDataFields(str, mode);
    	
    	if(mode==1||mode==2||mode==3||mode==-1||mode==-2||mode==-3){    		
    		
    		boolean breaker1Opened=true;    		
    		if(strAry[1].equals("")){
    			breaker1Opened=false;
    		}else{
    			breaker1Opened=true;
    		}
    		String bus1=strAry[2];
    		double bus1RatedV=0.0;    		
    		if(!strAry[3].equals("")){
    			bus1RatedV= new Double(strAry[3]).doubleValue();   			
    		}
    		boolean breaker2Opened=true;
    		if(strAry[4].equals("")){
    			breaker2Opened=false;
    		}else{
    			breaker2Opened=true;
    		}
    		String bus2=strAry[5];
    		double bus2RatedV=0.0;
    		if(!strAry[6].equals("")){
    			bus2RatedV= new Double(strAry[6]).doubleValue();   			
    		}
    		
    		String parId="";
    		if(!strAry[7].equals("")){
    			parId=strAry[7];   			
    		}
    		double operationTime=new Double(strAry[9]);
    		double  r=0.0, x=0.0;
    		if(!strAry[10].equals("")){    			
    			r= new Double(strAry[10]).doubleValue();
    		}
    		if(!strAry[11].equals("")){
    			r= new Double(strAry[11]).doubleValue();
    		}
    		double faultLocation=0.0;
    		if(!strAry[12].trim().equals("")){
    			faultLocation= new Double(strAry[11]).doubleValue();
    		} 
    		// bus fault
    		if(mode==1||mode==-1||mode==2||mode==-2){ 
    			FaultListXmlType.Fault fault=
					ODMData2XmlHelper.getFaultRecord(tranSimu, FaultListXmlType.Fault.FaultType.BUS_FAULT,
							bus1, bus2);
    			//FaultListXmlType.Fault.BusFault busFault=fault.addNewBusFault();
    			
    			FaultListXmlType.Fault.BusFault busFault=
	    		 ODMData2XmlHelper.getBusFaultRecord(tranSimu, bus1, bus2);
    			
    			fault.setFaultType(FaultListXmlType.Fault.FaultType.BUS_FAULT);
				busFault.setFaultCategory(FaultCategoryXmlType.X_3_PHASE);
				// not permanent bus fault;
               if(mode==1||mode==-1){            	   
	    			
	    			if(breaker1Opened==false&&breaker2Opened==false){	    				
	    				
	    				ODMData2XmlHelper.setTimeData(busFault.addNewFaultStartTime(), 
	    						operationTime, TimeXmlType.Unit.CYCLE);  
	    				
	        			busFault.addNewFaultedBus().setName(bus1);
	        			ODMData2XmlHelper.setVoltageData(busFault.addNewFaultedBusRatedV(),
	        					bus1RatedV, VoltageXmlType.Unit.KV);
	        			busFault.addNewRemoteEndBus().setName(bus2);
	        			ODMData2XmlHelper.setVoltageData(busFault.addNewRemoteEndBusRatedV(),
	        					bus2RatedV, VoltageXmlType.Unit.KV);        			
	        			
	    			}else if(breaker1Opened==true&&breaker2Opened==false){	    				
	    				if(busFault!=null){
	    					ODMData2XmlHelper.setTimeData(busFault.addNewFirstOperationTime(),
	        						operationTime, TimeXmlType.Unit.CYCLE);
	    					busFault.setPermanentFault(true);
	            			if(mode==-1){
	            				double duration= busFault.getFirstOperationTime().getValue()-
	            				        busFault.getFaultStartTime().getValue();
	            				ODMData2XmlHelper.setTimeData(busFault.addNewFaultDurationTime(), 
	            						duration, TimeXmlType.Unit.CYCLE);
	            				busFault.setPermanentFault(false);
	            			} 
	    				}
	    				
	    			}else if(breaker1Opened==true&&breaker2Opened==true){
	    				if(busFault!=null){
	    					busFault.setPermanentFault(true);
	    					ODMData2XmlHelper.setTimeData(busFault.addNewSecondOperationTime(),
	        						operationTime, TimeXmlType.Unit.CYCLE);
	        				if(mode==-1){	        					
	            				double duration= busFault.getSecondOperationTime().getValue()-
	            				        busFault.getFaultStartTime().getValue();
	            				ODMData2XmlHelper.setTimeData(busFault.addNewFaultDurationTime(), 
	            						duration, TimeXmlType.Unit.CYCLE);
	            				busFault.setPermanentFault(false);
	            			}	            			
	    				}
	    			}
	    			// permanent bus fault
	    		}else if(mode==2||mode==-2){
	    			if(mode==2){	                    
	    				ODMData2XmlHelper.setTimeData(busFault.addNewFaultStartTime(), 
	    						operationTime, TimeXmlType.Unit.CYCLE);  
	    				busFault.setFaultCategory(FaultCategoryXmlType.X_3_PHASE);
	        			busFault.addNewFaultedBus().setName(bus1);
	        			ODMData2XmlHelper.setVoltageData(busFault.addNewFaultedBusRatedV(),
	        					bus1RatedV, VoltageXmlType.Unit.KV);
	        			busFault.addNewRemoteEndBus().setName(bus2);
	        			ODMData2XmlHelper.setVoltageData(busFault.addNewRemoteEndBusRatedV(),
	        					bus2RatedV, VoltageXmlType.Unit.KV);    
	        			busFault.setPermanentFault(true);
	        			
	    			}else{	
	    				if(busFault!=null){
	    					ODMData2XmlHelper.setTimeData(busFault.addNewFirstOperationTime(),
	        						operationTime, TimeXmlType.Unit.CYCLE);
	    					double duration= busFault.getFirstOperationTime().getValue()-
					        busFault.getFaultStartTime().getValue();
					        ODMData2XmlHelper.setTimeData(busFault.addNewFaultDurationTime(), 
							duration, TimeXmlType.Unit.CYCLE);
					        busFault.setPermanentFault(false);
	            			}
	    				}
	    			}
				if(r!=0.0||x!=0.0){
	    				ODMData2XmlHelper.setZValue(busFault.addNewFaultZ(), r, x, ZXmlType.Unit.PU);
	    		}
				// branch fault
    		}else if(mode==3||mode==-3){
    			FaultListXmlType.Fault fault=
					ODMData2XmlHelper.getFaultRecord(tranSimu, FaultListXmlType.Fault.FaultType.BRANCH_FAULT,
							bus1, bus2);
    			FaultListXmlType.Fault.BranchFault braFault=
	    			ODMData2XmlHelper.getBranchFaultRecord(tranSimu, bus1, bus2);				
				fault.setFaultType(FaultListXmlType.Fault.FaultType.BRANCH_FAULT);
				braFault.setFaultCategory(FaultCategoryXmlType.X_3_PHASE);
				
				if(breaker1Opened==false&&breaker2Opened==false){    				
        			braFault.addNewFromBus().setName(bus1);
        			ODMData2XmlHelper.setVoltageData(braFault.addNewFromBusRatedV(), 
        					bus1RatedV, VoltageXmlType.Unit.KV);
        			braFault.addNewFromBus().setName(bus2);
        			ODMData2XmlHelper.setVoltageData(braFault.addNewToBusRatedV(), 
        					bus2RatedV, VoltageXmlType.Unit.KV);
        			ODMData2XmlHelper.setTimeData(braFault.addNewFaultStartTime(), 
    						operationTime, TimeXmlType.Unit.CYCLE);
        			braFault.addNewFaultLocationFromFromSide().setValue(faultLocation);
        			braFault.getFaultLocationFromFromSide().setUnit(PercentXmlType.Unit.PERCENT);
        			braFault.setPermanentFault(true);
    			}else if((breaker1Opened==true&&breaker2Opened==false)||
    					 (breaker1Opened==false&&breaker2Opened==true)){    				
    				if(braFault!=null){
    					ODMData2XmlHelper.setTimeData(braFault.addNewFirstOperationTime(),
        						operationTime, TimeXmlType.Unit.CYCLE);
    					braFault.setPermanentFault(true);
            			if(mode==-3){
            				double duration= braFault.getFirstOperationTime().getValue()-
            				        braFault.getFaultStartTime().getValue();
            				ODMData2XmlHelper.setTimeData(braFault.addNewFaultDurationTime(), 
            						duration, TimeXmlType.Unit.CYCLE);
            				braFault.setPermanentFault(false);
            			}
    				}    				
    			}else if(breaker1Opened==true&&breaker2Opened==true){    				
    				if(braFault!=null){
    					braFault.setPermanentFault(true);
    					ODMData2XmlHelper.setTimeData(braFault.addNewSecondOperationTime(),
        						operationTime, TimeXmlType.Unit.CYCLE);
        				if(mode==-3){
        					braFault.setPermanentFault(false);
            				double duration= braFault.getSecondOperationTime().getValue()-
            				        braFault.getFaultStartTime().getValue();
            				ODMData2XmlHelper.setTimeData(braFault.addNewFaultDurationTime(), 
            						duration, TimeXmlType.Unit.CYCLE);
            			}            			
            		}
    			}
				if(r!=0.0||x!=0.0){
    				ODMData2XmlHelper.setZValue(braFault.addNewFaultZ(), r, x, ZXmlType.Unit.PU);
    			} 
    		}

    	}else if(mode==4||mode==-4){
    		// load change
    		if(strAry[12].equals("")){
    			FaultListXmlType.Fault.LoadChange loadChange= tranSimu.getDynamicDataList()
 		       .getFaultList().addNewFault().addNewLoadChange(); 
     		
     		   String busId=strAry[1];
     		   loadChange.addNewBusId().setName(busId);
     		
     		   double busRatedVoltage=0.0;
     		   if(!strAry[2].equals("")){
     			   busRatedVoltage=new Double(strAry[2]).doubleValue();
     			   ODMData2XmlHelper.setVoltageData(loadChange.addNewBusRatedVoltage(),
 		                   busRatedVoltage, VoltageXmlType.Unit.KV);
     		   }
     		   double operationTime=0.0;
     		  if(!strAry[5].equals("")){
        			operationTime=new Double(strAry[5]).doubleValue();
        			ODMData2XmlHelper.setTimeData(loadChange.addNewOperationTime(),
        					operationTime, TimeXmlType.Unit.CYCLE);
        		}
     		  double pp=0.0, qp=0.0, pc=0.0,qc=0.0,pz=0.0,qz=0.0;
     		  if(!strAry[6].equals("")){
     			 pp=new Double(strAry[6]).doubleValue();    			
     		  }     		 
     		  if(!strAry[7].equals("")){
       			 qp=new Double(strAry[7]).doubleValue();
       		  }
       		  if(pp!=0.0||qp!=0.0){
       			 ODMData2XmlHelper.setPowerData(loadChange.addNewConstantPChange(),
       					pp, qp, PowerXmlType.Unit.MVA);
       		  }
       		  if(!strAry[8].equals("")){
       			 pc=new Double(strAry[8]).doubleValue();
       		  }    		
       		  if(!strAry[9].equals("")){
       			qc=new Double(strAry[9]).doubleValue();
       		  }
       		  if(pc!=0.0||qc!=0.0){
       			 ODMData2XmlHelper.setPowerData(loadChange.addNewConstantIChange(),
       					pc, qc, PowerXmlType.Unit.MVA);
       		  }
       		  if(!strAry[10].equals("")){
       			 pz=new Double(strAry[10]).doubleValue();
       		  }
       		  if(!strAry[11].equals("")){
       			 qz=new Double(strAry[11]).doubleValue();
       		  }
       		  if(pz!=0.0||qz!=0.0){
       			 ODMData2XmlHelper.setPowerData(loadChange.addNewConstantZChange(),
       					pz, qz, PowerXmlType.Unit.MVA);
       		  }
    		}else {
    			FaultListXmlType.Fault.GenChange genChange= tranSimu.getDynamicDataList()
 		       .getFaultList().addNewFault().addNewGenChange(); 
     		
     		String busId=strAry[1];
     		genChange.addNewBusId().setName(busId);
     		
     		double busRatedVoltage=0.0;
     		if(!strAry[2].equals("")){
     			busRatedVoltage=new Double(strAry[2]).doubleValue();
     			ODMData2XmlHelper.setVoltageData(genChange.addNewBusRatedVoltage(),
 		                  busRatedVoltage, VoltageXmlType.Unit.KV);
     		}
     		String genId="";
     		if(!strAry[3].equals("")){
     			genId=strAry[3];
     			genChange.setGeneratorId(genId);
     		}
     		double operationTime=0.0;
     		if(!strAry[5].equals("")){
     			operationTime=new Double(strAry[5]).doubleValue();
     			ODMData2XmlHelper.setTimeData(genChange.addNewOperationTime(),
     					operationTime, TimeXmlType.Unit.CYCLE);
     		} 
     		double pg=0.0;
     		if(new Double(strAry[12]).doubleValue()<90000){
 				pg=new Double(strAry[12]).doubleValue();
 				ODMData2XmlHelper.setPowerData(genChange.addNewGenChange(),
     					pg, 0.0, PowerXmlType.Unit.MVA);
 			}else{
 				genChange.setGenOutage(true);
 			}	
     	 }
    		// dc line fault
      }else if(mode==5){
    	  int sign=new Integer(str.substring(31, 33).trim()).intValue();
    	  if(sign>0){
    		  FaultListXmlType.Fault.DcLineFault dcFault= tranSimu.getDynamicDataList().
	           getFaultList().addNewFault().addNewDcLineFault();
    		  dcFault.setPermanentFault(true);
	          String bus1=strAry[1];
	          dcFault.addNewFromACBusId().setName(bus1);
	          double bus1Vol=0.0;
	          if(!strAry[2].equals("")){
	    		  bus1Vol= new Double(strAry[2]).doubleValue();
	    		  ODMData2XmlHelper.setVoltageData(dcFault.addNewFromACRatedVol(),
	       			  bus1Vol, VoltageXmlType.Unit.KV);    	 
	    	  }
	          String bus2=strAry[3];
	    	  dcFault.addNewToACBusId().setName(bus2);
	    	  double bus2Vol=0.0;
	    	  if(!strAry[4].equals("")){
	    		  bus2Vol= new Double(strAry[4]).doubleValue();
	    		  ODMData2XmlHelper.setVoltageData(dcFault.addNewToACRatedVol(),
	       			  bus2Vol, VoltageXmlType.Unit.KV);    	 
	    	  }
	    	  int faultType= new Integer(strAry[5]).intValue();
	    	  if(faultType==1){
	    		  dcFault.setFaultType(FaultListXmlType.Fault.
	    				  DcLineFault.FaultType.FROM_BUS_BIPOLE_SHORT_CIRCUIT);
	    	  }
	    	  if(faultType==2){
	    		  dcFault.setFaultType(FaultListXmlType.Fault.
	    				  DcLineFault.FaultType.TO_BUS_BIPOLE_SHORT_CIRCUIT);
	    	  }
	    	  double faultLocation=0.0;
	    	  if(!strAry[10].equals("")){
	    		  faultLocation= new Double(strAry[10]).doubleValue();
	    	  }
	    	  if(faultType==3){
	    		  dcFault.setFaultType(FaultListXmlType.Fault.
	    				  DcLineFault.FaultType.FAULT_ON_LINE);
	    		  dcFault.addNewFaultLocationFromFromSide().setValue(faultLocation);
	    		  dcFault.getFaultLocationFromFromSide().setUnit(PercentXmlType.Unit.PERCENT);
	    	  }
	    	  if(faultType==4){
	    		  dcFault.setFaultType(FaultListXmlType.Fault.
	    				  DcLineFault.FaultType.POWER_BLOCKED);
	    	  }
	    	  if(faultType==5){
	    		  dcFault.setFaultType(FaultListXmlType.Fault.
	    				  DcLineFault.FaultType.POWER_REVERSED);
	    	  }
	    	  double changedScale=0.0;
	    	  if(!strAry[9].equals("")){
	    		  changedScale= new Double(strAry[9]).doubleValue();
	    	  }
	    	  if(faultType==7){
	    		  dcFault.setFaultType(FaultListXmlType.Fault.
	    				  DcLineFault.FaultType.POWER_CHANGE_BY_SPECIFICATION);
	    		  ODMData2XmlHelper.setPowerData(dcFault.addNewChangedPower(), 
	    				  changedScale, 0.0, PowerXmlType.Unit.MVA);    		  
	    	  }
	    	  if(faultType==8){
	    		  dcFault.setFaultType(FaultListXmlType.Fault.
	    				  DcLineFault.FaultType.CURRENT_CHANGE_BY_SPECIFICATION);
	    		  ODMData2XmlHelper.setCurrentData(dcFault.addNewChangedCurrent(), 
	    				  changedScale, CurrentXmlType.Unit.KA);    		  
	    	  }
	    	  double startTime=0.0;
	    	  if(!strAry[7].equals("")){
	    		  startTime= new Double(strAry[7]).doubleValue();
	    		  ODMData2XmlHelper.setTimeData(dcFault.addNewStartTime(), 
	    				  startTime, TimeXmlType.Unit.CYCLE);
	    		  
	    	  }
	    	  double faultR=0.0;
	    	  if(!strAry[8].equals("")){
	    		  faultR= new Double(strAry[8]).doubleValue();
	    		  ODMData2XmlHelper.setZValue(dcFault.addNewFaultZ(), faultR, 0.0, ZXmlType.Unit.PU);
	    		  
	    	  }   		  
    	  }else{
    		  String bus1=strAry[1];
    		  String bus2=strAry[3];
    		  FaultListXmlType.Fault.DcLineFault dcFault=
    			  ODMData2XmlHelper.getDCFaultRecord(tranSimu, bus1, bus2);
    		 dcFault.setPermanentFault(false);
    		 
    		 double clearedTime= new Double(strAry[7]).doubleValue();
    		 double durationTime=clearedTime-dcFault.getStartTime().getValue();
    		 ODMData2XmlHelper.setTimeData(dcFault.addNewDurationTime(),
    				 durationTime, TimeXmlType.Unit.CYCLE); 
    	  }
      }
    }    		
    		
	
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
    public static void processExciterData(String str, TransientSimulationXmlType tranSimu,
    		                   ExciterXmlType exc){
    	final String strAry[]=getExciterDataFields(str,0);
    	
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
			
    	}
		
	}
    
    public static void processExciterComplementData(String str,TransientSimulationXmlType tranSimu){
    	
    	String busId=str.substring(3, 11).trim();
    	String excId="";
    	if(!str.substring(15, 16).trim().equals("")){
    		excId=str.substring(15, 16).trim();
    	}    	
    	ExciterXmlType exc=ODMData2XmlHelper.getExciterRecord(tranSimu, busId, excId);
    	
    	if(exc.getExciterType().equals(ExciterXmlType.ExciterType.IEEE_1981_ST_1)){
    		final String strAry[]=getExciterDataFields(str,1);
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
    		final String strAry[]=getExciterDataFields(str,1);
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
    	}else if(exc.getExciterType().equals(ExciterXmlType.
    			             ExciterType.IEEE_1981_NEW_EXC_SYSTEM)){
    		
    		ExciterModelListXmlType.IEEE1981NewExcSystem newExc=exc.
    		                   getExciterModel().getIEEE1981NewExcSystem();
    		final String strAry[]=getExciterDataFields(str,2);
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
    public static void processTurbineGovernorData(String str,TransientSimulationXmlType tranSimu,
    		IEEEODMPSSModelParser parser){
    	
    	
    	final String strAry[]=getTGDataFields(str);
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
    		double Dd=new Double(strAry[12]).doubleValue();
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
    
    private static String[] getFaultOperationDataFields ( final String str, int mode) {
		final String[] strAry = new String[13];		
		
		if(mode==1||mode==2||mode==3||mode==-1||mode==-2||mode==-3){
			strAry[0]=str.substring(0, 2).trim();
			strAry[1]=str.substring(3, 4).trim();
			strAry[2]=str.substring(4, 12).trim();
			strAry[3]=str.substring(12, 16).trim();
			strAry[4]=str.substring(17, 18).trim();
			strAry[5]=str.substring(18, 26).trim();
			strAry[6]=str.substring(26, 30).trim();
			strAry[7]=str.substring(31, 32).trim();
			strAry[8]=str.substring(35, 37).trim();			
			strAry[9]=str.substring(39, 45).trim();
			strAry[10]=str.substring(45, 51).trim();
			strAry[11]=str.substring(51, 57).trim();
			strAry[12]=str.substring(57, 63).trim();
		}else if(mode==4){
			strAry[0]=str.substring(0, 2).trim();
			strAry[1]=str.substring(4, 12).trim();
			strAry[2]=str.substring(12, 16).trim();
			strAry[3]=str.substring(16, 17).trim();
			strAry[4]=str.substring(36, 37).trim();
			strAry[5]=str.substring(39, 45).trim();
			strAry[6]=str.substring(45, 50).trim();
			strAry[7]=str.substring(50, 55).trim();
			strAry[8]=str.substring(55, 60).trim();
			strAry[9]=str.substring(60, 65).trim();
			strAry[10]=str.substring(65, 70).trim();
			strAry[11]=str.substring(71, 75).trim();
			strAry[12]=str.substring(75, 80).trim();
		}else if(mode==5){
			strAry[0]=str.substring(0, 2).trim();
			strAry[1]=str.substring(4, 12).trim();
			strAry[2]=str.substring(12, 16).trim();
			strAry[3]=str.substring(18, 26).trim();
			strAry[4]=str.substring(26, 30).trim();
			strAry[5]=str.substring(31, 33).trim();
			strAry[6]=str.substring(36, 37).trim();
			strAry[7]=str.substring(39, 45).trim();
			strAry[8]=str.substring(45, 51).trim();
			strAry[9]=str.substring(51, 57).trim();
			strAry[10]=str.substring(57, 63).trim();			
		}
		return strAry;
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
    
    private static String[] getExciterDataFields ( final String str, final int subType) {
		// use subType to read FZ data under different type of type "F" excitation
    	// 1 --F A~L
    	//2 ---F M~V
    	
    	final String[] strAry = new String[19];		
		
		if(str.substring(0,1).trim().equals("E")&& subType==0){
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
			
		}else if(((str.substring(0, 2).trim().equals("FA")||
				str.substring(0, 2).trim().equals("FB")||str.substring(0, 2).trim().equals("FC")
				||str.substring(0, 2).trim().equals("FD")||str.substring(0, 2).trim().equals("FE")||
				str.substring(0, 2).trim().equals("FF")||str.substring(0, 2).trim().equals("FG")
				||str.substring(0, 2).trim().equals("FH")||str.substring(0, 2).trim().equals("FJ")
				||str.substring(0, 2).trim().equals("FK")||str.substring(0, 2).trim().equals("FL"))
				)&& subType==0){
			
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
		}else if((str.substring(0, 2).trim().equals("FQ")||str.substring(0, 2).trim().equals("FV"))
				&& subType==0){
			
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
		else if((str.substring(0,2).trim().equals("FZ"))&& subType==1){
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
			
		}else if(((str.substring(0,2).trim().equals("F+"))||str.substring(0,2).trim().equals("FZ"))
			&& subType==2){
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
    
    private static String[] getTGDataFields ( final String str) {
		   	
    	final String[] strAry = new String[19];
    	if(str.substring(0, 2).trim().equals("GG")){
    		strAry[0]=str.substring(0, 2).trim();
			//busId
			strAry[1]=str.substring(3, 11).trim();
			//bus Voltage
			strAry[2]=str.substring(11, 15).trim();
			//excId
			strAry[3]=str.substring(15, 16).trim();
			//PMAX 
			strAry[4]=str.substring(16, 22).trim();
			//R
			strAry[5]=str.substring(22, 27).trim();
			//T1
			strAry[6]=str.substring(27, 32).trim();
			//T2
			strAry[7]=str.substring(32, 37).trim();
			//T3
			strAry[8]=str.substring(37, 42).trim();
			// T4
			strAry[9]=str.substring(42, 47).trim();
			//T5
			strAry[10]=str.substring(47, 52).trim();
			//F
			strAry[11]=str.substring(52, 57).trim();
			
    		
    	}else if(str.substring(0, 2).trim().equals("GH")){
    		strAry[0]=str.substring(0, 2).trim();
			//busId
			strAry[1]=str.substring(3, 11).trim();
			//bus Voltage
			strAry[2]=str.substring(11, 15).trim();
			//excId
			strAry[3]=str.substring(15, 16).trim();
			//PMAX 
			strAry[4]=str.substring(16, 22).trim();
			//R
			strAry[5]=str.substring(22, 27).trim();
			//TG
			strAry[6]=str.substring(27, 32).trim();
			//TP
			strAry[7]=str.substring(32, 37).trim();
			//TD
			strAry[8]=str.substring(37, 42).trim();
			// TW/2
			strAry[9]=str.substring(42, 47).trim();
			//VELCLOSE
			strAry[10]=str.substring(47, 52).trim();
			//FVELOPEN
			strAry[11]=str.substring(52, 57).trim();
			//Dd
			strAry[12]=str.substring(57, 62).trim();
			
    		
    	}
    	else if(str.substring(0, 2).trim().equals("GS")){
    		strAry[0]=str.substring(0, 2).trim();
			//busId
			strAry[1]=str.substring(3, 11).trim();
			//bus Voltage
			strAry[2]=str.substring(11, 15).trim();
			//excId
			strAry[3]=str.substring(15, 16).trim();
			//PMAX 
			strAry[4]=str.substring(16, 22).trim();
			//PMIN
			strAry[5]=str.substring(22, 28).trim();
			//R
			strAry[6]=str.substring(28, 33).trim();
			//T1
			strAry[7]=str.substring(33, 38).trim();
			//T2
			strAry[8]=str.substring(38, 43).trim();
			// T3
			strAry[9]=str.substring(43, 48).trim();
			//VELOPEN
			strAry[10]=str.substring(48, 54).trim();
			//FVELCLOSE
			strAry[11]=str.substring(54, 60).trim();			
    		
    	}else if(str.substring(0, 2).trim().equals("TA")){
    		strAry[0]=str.substring(0, 2).trim();
			//busId
			strAry[1]=str.substring(3, 11).trim();
			//bus Voltage
			strAry[2]=str.substring(11, 15).trim();
			//excId
			strAry[3]=str.substring(15, 16).trim();
			//TCH
			strAry[4]=str.substring(16, 21).trim();
			//k1
			strAry[5]=str.substring(22, 26).trim();
    	}else if(str.substring(0, 2).trim().equals("TB")){
    		strAry[0]=str.substring(0, 2).trim();
			//busId
			strAry[1]=str.substring(3, 11).trim();
			//bus Voltage
			strAry[2]=str.substring(11, 15).trim();
			//excId
			strAry[3]=str.substring(15, 16).trim();
			//tch
			strAry[4]=str.substring(16, 21).trim();
			//FHP
			strAry[5]=str.substring(22, 26).trim();
			//TRH
			strAry[6]=str.substring(31, 36).trim();
			//FIP
			strAry[7]=str.substring(36, 41).trim();
			//TCO
			strAry[8]=str.substring(46, 51).trim();
			// FLP
			strAry[9]=str.substring(51, 56).trim();
			
    	}
    	
    	
    	return strAry;
	
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
