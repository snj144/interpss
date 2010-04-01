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

package org.ieee.odm.adapter.bpa;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ApparentPowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BranchFaultXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusFaultXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.CurrentUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.DcLineFaultXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.FaultCategoryEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.FaultTypeEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.FaultXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.GenChangeDynamicEventXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadChangeDynamicEventXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TimePeriodUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TransientSimulationXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZUnitType;
import org.ieee.odm.model.DataSetter;
import org.ieee.odm.model.ParserHelper;
import org.ieee.odm.model.StringUtil;

public class BPADynamicFaultOperationRecord {
	
public static void processFaultOperationData(String str,TransientSimulationXmlType tranSimu
		            ,BPAAdapter adapter){ 
    	
    	int mode =new Integer(str.substring(35, 37).trim()).intValue();
    	final String strAry[] = getFaultOperationDataFields(str, mode,adapter);
    	
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
    		double operationTime=0.0;
    		if(!strAry[9].equals("")){
    			operationTime=new Double(strAry[9]);
    		}    		
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
    			FaultXmlType fault=
					ParserHelper.getFaultRecord(tranSimu, FaultTypeEnumType.BUS_FAULT,
							bus1, bus2);
    			//FaultListXmlType.Fault.BusFault busFault=fault.addNewBusFault();
    			
    			BusFaultXmlType busFault=
	    		 ParserHelper.getBusFaultRecord(tranSimu, bus1, bus2);
    			
    			fault.setFaultType(FaultTypeEnumType.BUS_FAULT);
				busFault.setFaultCategory(FaultCategoryEnumType.FAULT_3_PHASE);
				// not permanent bus fault;
               if(mode==1||mode==-1){            	   
	    			
	    			if(breaker1Opened==false&&breaker2Opened==false){	    				
	    				
	    				DataSetter.setTimePeriodData(busFault.addNewFaultStartTime(), 
	    						operationTime, TimePeriodUnitType.CYCLE);  
	    				
	        			busFault.addNewFaultedBus().setName(bus1);
	        			DataSetter.setVoltageData(busFault.addNewFaultedBusRatedV(),
	        					bus1RatedV, VoltageUnitType.KV);
	        			busFault.addNewRemoteEndBus().setName(bus2);
	        			DataSetter.setVoltageData(busFault.addNewRemoteEndBusRatedV(),
	        					bus2RatedV, VoltageUnitType.KV);        			
	        			
	    			}else if(breaker1Opened==true&&breaker2Opened==false){	    				
	    				if(busFault!=null){
	    					DataSetter.setTimePeriodData(busFault.addNewFirstOperationTime(),
	        						operationTime, TimePeriodUnitType.CYCLE);
	    					busFault.setPermanentFault(true);
	            			if(mode==-1){
	            				double duration= busFault.getFirstOperationTime().getValue()-
	            				        busFault.getFaultStartTime().getValue();
	            				DataSetter.setTimePeriodData(busFault.addNewFaultDurationTime(), 
	            						duration, TimePeriodUnitType.CYCLE);
	            				busFault.setPermanentFault(false);
	            			} 
	    				}
	    				
	    			}else if(breaker1Opened==true&&breaker2Opened==true){
	    				if(busFault!=null){
	    					busFault.setPermanentFault(true);
	    					DataSetter.setTimePeriodData(busFault.addNewSecondOperationTime(),
	        						operationTime, TimePeriodUnitType.CYCLE);
	        				if(mode==-1){	        					
	            				double duration= busFault.getSecondOperationTime().getValue()-
	            				        busFault.getFaultStartTime().getValue();
	            				DataSetter.setTimePeriodData(busFault.addNewFaultDurationTime(), 
	            						duration, TimePeriodUnitType.CYCLE);
	            				busFault.setPermanentFault(false);
	            			}	            			
	    				}
	    			}
	    			// permanent bus fault
	    		}else if(mode==2||mode==-2){
	    			if(mode==2){	                    
	    				DataSetter.setTimePeriodData(busFault.addNewFaultStartTime(), 
	    						operationTime, TimePeriodUnitType.CYCLE);  
	    				busFault.setFaultCategory(FaultCategoryEnumType.FAULT_3_PHASE);
	        			busFault.addNewFaultedBus().setName(bus1);
	        			DataSetter.setVoltageData(busFault.addNewFaultedBusRatedV(),
	        					bus1RatedV, VoltageUnitType.KV);
	        			busFault.addNewRemoteEndBus().setName(bus2);
	        			DataSetter.setVoltageData(busFault.addNewRemoteEndBusRatedV(),
	        					bus2RatedV, VoltageUnitType.KV);    
	        			busFault.setPermanentFault(true);
	        			
	    			}else{	
	    				if(busFault!=null){
	    					DataSetter.setTimePeriodData(busFault.addNewFirstOperationTime(),
	        						operationTime, TimePeriodUnitType.CYCLE);
	    					double duration= busFault.getFirstOperationTime().getValue()-
					        busFault.getFaultStartTime().getValue();
					        DataSetter.setTimePeriodData(busFault.addNewFaultDurationTime(), 
							duration, TimePeriodUnitType.CYCLE);
					        busFault.setPermanentFault(false);
	            			}
	    				}
	    			}
				if(r!=0.0||x!=0.0){
	    				DataSetter.setZValue(busFault.addNewFaultZ(), r, x, ZUnitType.PU);
	    		}
				// branch fault
    		}else if(mode==3||mode==-3){
    			FaultXmlType fault=
					ParserHelper.getFaultRecord(tranSimu, FaultTypeEnumType.BRANCH_FAULT,
							bus1, bus2);
    			BranchFaultXmlType braFault=
	    			ParserHelper.getBranchFaultRecord(tranSimu, bus1, bus2);				
				fault.setFaultType(FaultTypeEnumType.BRANCH_FAULT);
				braFault.setFaultCategory(FaultCategoryEnumType.FAULT_3_PHASE);
				
				if(breaker1Opened==false&&breaker2Opened==false){    				
        			braFault.addNewFromBus().setName(bus1);
        			DataSetter.setVoltageData(braFault.addNewFromBusRatedV(), 
        					bus1RatedV, VoltageUnitType.KV);
        			braFault.addNewFromBus().setName(bus2);
        			DataSetter.setVoltageData(braFault.addNewToBusRatedV(), 
        					bus2RatedV, VoltageUnitType.KV);
        			DataSetter.setTimePeriodData(braFault.addNewFaultStartTime(), 
    						operationTime, TimePeriodUnitType.CYCLE);
        			braFault.setFaultLocationFromFromSide(faultLocation);
        			braFault.setPermanentFault(true);
    			}else if((breaker1Opened==true&&breaker2Opened==false)||
    					 (breaker1Opened==false&&breaker2Opened==true)){    				
    				if(braFault!=null){
    					DataSetter.setTimePeriodData(braFault.addNewFirstOperationTime(),
        						operationTime, TimePeriodUnitType.CYCLE);
    					braFault.setPermanentFault(true);
            			if(mode==-3){
            				double duration= braFault.getFirstOperationTime().getValue()-
            				        braFault.getFaultStartTime().getValue();
            				DataSetter.setTimePeriodData(braFault.addNewFaultDurationTime(), 
            						duration, TimePeriodUnitType.CYCLE);
            				braFault.setPermanentFault(false);
            			}
    				}    				
    			}else if(breaker1Opened==true&&breaker2Opened==true){    				
    				if(braFault!=null){
    					braFault.setPermanentFault(true);
    					DataSetter.setTimePeriodData(braFault.addNewSecondOperationTime(),
        						operationTime, TimePeriodUnitType.CYCLE);
        				if(mode==-3){
        					braFault.setPermanentFault(false);
            				double duration= braFault.getSecondOperationTime().getValue()-
            				        braFault.getFaultStartTime().getValue();
            				DataSetter.setTimePeriodData(braFault.addNewFaultDurationTime(), 
            						duration, TimePeriodUnitType.CYCLE);
            			}            			
            		}
    			}
				if(r!=0.0||x!=0.0){
    				DataSetter.setZValue(braFault.addNewFaultZ(), r, x, ZUnitType.PU);
    			} 
    		}

    	}else if(mode==4||mode==-4){
    		// load change
    		if(strAry[12].equals("")){
    			LoadChangeDynamicEventXmlType loadChange= tranSimu.getDynamicDataList()
 		       .getFaultList().addNewFault().addNewLoadChange(); 
     		
     		   String busId=strAry[1];
     		   loadChange.addNewBus().setName(busId);
     		
     		   double busRatedVoltage=0.0;
     		   if(!strAry[2].equals("")){
     			   busRatedVoltage=new Double(strAry[2]).doubleValue();
     			   DataSetter.setVoltageData(loadChange.addNewBusRatedVoltage(),
 		                   busRatedVoltage, VoltageUnitType.KV);
     		   }
     		   double operationTime=0.0;
     		  if(!strAry[5].equals("")){
        			operationTime=new Double(strAry[5]).doubleValue();
        			DataSetter.setTimePeriodData(loadChange.addNewOperationTime(),
        					operationTime, TimePeriodUnitType.CYCLE);
        		}
     		  double pp=0.0, qp=0.0, pc=0.0,qc=0.0,pz=0.0,qz=0.0;
     		  if(!strAry[6].equals("")){
     			 pp=new Double(strAry[6]).doubleValue();    			
     		  }     		 
     		  if(!strAry[7].equals("")){
       			 qp=new Double(strAry[7]).doubleValue();
       		  }
       		  if(pp!=0.0||qp!=0.0){
       			 DataSetter.setPowerData(loadChange.addNewConstantPChange(),
       					pp, qp, ApparentPowerUnitType.MVA);
       		  }
       		  if(!strAry[8].equals("")){
       			 pc=new Double(strAry[8]).doubleValue();
       		  }    		
       		  if(!strAry[9].equals("")){
       			qc=new Double(strAry[9]).doubleValue();
       		  }
       		  if(pc!=0.0||qc!=0.0){
       			 DataSetter.setPowerData(loadChange.addNewConstantIChange(),
       					pc, qc, ApparentPowerUnitType.MVA);
       		  }
       		  if(!strAry[10].equals("")){
       			 pz=new Double(strAry[10]).doubleValue();
       		  }
       		  if(!strAry[11].equals("")){
       			 qz=new Double(strAry[11]).doubleValue();
       		  }
       		  if(pz!=0.0||qz!=0.0){
       			 DataSetter.setPowerData(loadChange.addNewConstantZChange(),
       					pz, qz, ApparentPowerUnitType.MVA);
       		  }
    		}else {
    			GenChangeDynamicEventXmlType genChange= tranSimu.getDynamicDataList()
 		       .getFaultList().addNewFault().addNewGenChange(); 
     		
     		String busId=strAry[1];
     		genChange.addNewBus().setName(busId);
     		
     		double busRatedVoltage=0.0;
     		if(!strAry[2].equals("")){
     			busRatedVoltage=new Double(strAry[2]).doubleValue();
     			DataSetter.setVoltageData(genChange.addNewBusRatedVoltage(),
 		                  busRatedVoltage, VoltageUnitType.KV);
     		}
     		String genId="";
     		if(!strAry[3].equals("")){
     			genId=strAry[3];
     			genChange.setGeneratorId(genId);
     		}
     		double operationTime=0.0;
     		if(!strAry[5].equals("")){
     			operationTime=new Double(strAry[5]).doubleValue();
     			DataSetter.setTimePeriodData(genChange.addNewOperationTime(),
     					operationTime, TimePeriodUnitType.CYCLE);
     		} 
     		double pg=0.0;
     		if(new Double(strAry[12]).doubleValue()<90000){
 				pg=new Double(strAry[12]).doubleValue();
 				DataSetter.setPowerData(genChange.addNewGenChange(),
     					pg, 0.0, ApparentPowerUnitType.MVA);
 			}else{
 				genChange.setGenOutage(true);
 			}	
     	 }
    		// dc line fault
      }else if(mode==5){
    	  int sign=new Integer(str.substring(31, 33).trim()).intValue();
    	  if(sign>0){
    		  DcLineFaultXmlType dcFault= tranSimu.getDynamicDataList().
	           getFaultList().addNewFault().addNewDcLineFault();
    		  dcFault.setPermanentFault(true);
	          String bus1=strAry[1];
	          dcFault.addNewFromACBus().setName(bus1);
	          double bus1Vol=0.0;
	          if(!strAry[2].equals("")){
	    		  bus1Vol= new Double(strAry[2]).doubleValue();
	    		  DataSetter.setVoltageData(dcFault.addNewFromACRatedVol(),
	       			  bus1Vol, VoltageUnitType.KV);    	 
	    	  }
	          String bus2=strAry[3];
	    	  dcFault.addNewToACBus().setName(bus2);
	    	  double bus2Vol=0.0;
	    	  if(!strAry[4].equals("")){
	    		  bus2Vol= new Double(strAry[4]).doubleValue();
	    		  DataSetter.setVoltageData(dcFault.addNewToACRatedVol(),
	       			  bus2Vol, VoltageUnitType.KV);    	 
	    	  }
	    	  int faultType= new Integer(strAry[5]).intValue();
	    	  if(faultType==1){
	    		  dcFault.setFaultType(DcLineFaultXmlType.FaultType.FROM_BUS_BIPOLE_SHORT_CIRCUIT);
	    	  }
	    	  if(faultType==2){
	    		  dcFault.setFaultType(DcLineFaultXmlType.FaultType.TO_BUS_BIPOLE_SHORT_CIRCUIT);
	    	  }
	    	  double faultLocation=0.0;
	    	  if(!strAry[10].equals("")){
	    		  faultLocation= new Double(strAry[10]).doubleValue();
	    	  }
	    	  if(faultType==3){
	    		  dcFault.setFaultType(DcLineFaultXmlType.FaultType.FAULT_ON_LINE);
	    		  dcFault.setFaultLocationFromFromSide(faultLocation);
	    	  }
	    	  if(faultType==4){
	    		  dcFault.setFaultType(DcLineFaultXmlType.FaultType.POWER_BLOCKED);
	    	  }
	    	  if(faultType==5){
	    		  dcFault.setFaultType(DcLineFaultXmlType.FaultType.POWER_REVERSED);
	    	  }
	    	  double changedScale=0.0;
	    	  if(!strAry[9].equals("")){
	    		  changedScale= new Double(strAry[9]).doubleValue();
	    	  }
	    	  if(faultType==7){
	    		  dcFault.setFaultType(DcLineFaultXmlType.FaultType.POWER_CHANGE_BY_SPECIFICATION);
	    		  DataSetter.setPowerData(dcFault.addNewChangedPower(), 
	    				  changedScale, 0.0, ApparentPowerUnitType.MVA);    		  
	    	  }
	    	  if(faultType==8){
	    		  dcFault.setFaultType(DcLineFaultXmlType.FaultType.CURRENT_CHANGE_BY_SPECIFICATION);
	    		  DataSetter.setCurrentData(dcFault.addNewChangedCurrent(), 
	    				  changedScale, CurrentUnitType.KA);    		  
	    	  }
	    	  double startTime=0.0;
	    	  if(!strAry[7].equals("")){
	    		  startTime= new Double(strAry[7]).doubleValue();
	    		  DataSetter.setTimePeriodData(dcFault.addNewStartTime(), 
	    				  startTime, TimePeriodUnitType.CYCLE);
	    		  
	    	  }
	    	  double faultR=0.0;
	    	  if(!strAry[8].equals("")){
	    		  faultR= new Double(strAry[8]).doubleValue();
	    		  DataSetter.setZValue(dcFault.addNewFaultZ(), faultR, 0.0, ZUnitType.PU);
	    		  
	    	  }   		  
    	  }else{
    		  String bus1=strAry[1];
    		  String bus2=strAry[3];
    		  DcLineFaultXmlType dcFault=
    			  ParserHelper.getDCFaultRecord(tranSimu, bus1, bus2);
    		 dcFault.setPermanentFault(false);
    		 
    		 double clearedTime= new Double(strAry[7]).doubleValue();
    		 double durationTime=clearedTime-dcFault.getStartTime().getValue();
    		 DataSetter.setTimePeriodData(dcFault.addNewDurationTime(),
    				 durationTime, TimePeriodUnitType.CYCLE); 
    	  }
      }
    }

private static String[] getFaultOperationDataFields ( final String str, int mode,
                                  BPAAdapter adapter) {
	final String[] strAry = new String[13];		
	try{
		if(mode==1||mode==2||mode==3||mode==-1||mode==-2||mode==-3){
			strAry[0]=StringUtil.getStringReturnEmptyString(str,1, 2).trim();
			strAry[1]=StringUtil.getStringReturnEmptyString(str,4, 4).trim();
			strAry[2]=StringUtil.getStringReturnEmptyString(str,5, 12).trim();
			strAry[3]=StringUtil.getStringReturnEmptyString(str,13, 16).trim();
			strAry[4]=StringUtil.getStringReturnEmptyString(str,18, 18).trim();
			strAry[5]=StringUtil.getStringReturnEmptyString(str,19, 26).trim();
			strAry[6]=StringUtil.getStringReturnEmptyString(str,27, 30).trim();
			strAry[7]=StringUtil.getStringReturnEmptyString(str,32, 32).trim();
			strAry[8]=StringUtil.getStringReturnEmptyString(str,36, 37).trim();			
			strAry[9]=StringUtil.getStringReturnEmptyString(str,40, 45).trim();
			strAry[10]=StringUtil.getStringReturnEmptyString(str,46, 51).trim();
			strAry[11]=StringUtil.getStringReturnEmptyString(str,52, 57).trim();
			strAry[12]=StringUtil.getStringReturnEmptyString(str,58, 63).trim();
		}else if(mode==4){
			strAry[0]=StringUtil.getStringReturnEmptyString(str,1, 2).trim();
			strAry[1]=StringUtil.getStringReturnEmptyString(str,5, 12).trim();
			strAry[2]=StringUtil.getStringReturnEmptyString(str,13, 16).trim();
			strAry[3]=StringUtil.getStringReturnEmptyString(str,17, 17).trim();
			strAry[4]=StringUtil.getStringReturnEmptyString(str,37, 37).trim();
			strAry[5]=StringUtil.getStringReturnEmptyString(str,40, 45).trim();
			strAry[6]=StringUtil.getStringReturnEmptyString(str,46, 50).trim();
			strAry[7]=StringUtil.getStringReturnEmptyString(str,51, 55).trim();
			strAry[8]=StringUtil.getStringReturnEmptyString(str,56, 60).trim();
			strAry[9]=StringUtil.getStringReturnEmptyString(str,61, 65).trim();
			strAry[10]=StringUtil.getStringReturnEmptyString(str,66, 70).trim();
			strAry[11]=StringUtil.getStringReturnEmptyString(str,72, 75).trim();
			strAry[12]=StringUtil.getStringReturnEmptyString(str,76, 80).trim();
		}else if(mode==5){
			strAry[0]=StringUtil.getStringReturnEmptyString(str,1, 2).trim();
			strAry[1]=StringUtil.getStringReturnEmptyString(str,5, 12).trim();
			strAry[2]=StringUtil.getStringReturnEmptyString(str,13, 16).trim();
			strAry[3]=StringUtil.getStringReturnEmptyString(str,19, 26).trim();
			strAry[4]=StringUtil.getStringReturnEmptyString(str,27, 30).trim();
			strAry[5]=StringUtil.getStringReturnEmptyString(str,32, 33).trim();
			strAry[6]=StringUtil.getStringReturnEmptyString(str,37, 37).trim();
			strAry[7]=StringUtil.getStringReturnEmptyString(str,40, 45).trim();
			strAry[8]=StringUtil.getStringReturnEmptyString(str,46, 51).trim();
			strAry[9]=StringUtil.getStringReturnEmptyString(str,52, 57).trim();
			strAry[10]=StringUtil.getStringReturnEmptyString(str,58, 63).trim();			
		}
	}catch(Exception e){
		adapter.logErr(e.toString());
	}
	
	
	return strAry;
}



}
