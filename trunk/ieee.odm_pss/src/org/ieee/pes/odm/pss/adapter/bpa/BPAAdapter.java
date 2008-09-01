/*
 * @(#)IeeeCDFAdapter.java   
 *
 * Copyright (C) 2006 www.interpss.org
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
 * @Author Stephen Hou
 * @Version 1.0
 * @Date 08/11/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.ieee.pes.odm.pss.adapter.bpa;

import java.util.StringTokenizer;
import java.util.logging.Logger;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NameValuePairListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PowerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.StudyCaseXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TransientSimulationXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageXmlType;
import org.ieee.pes.odm.pss.adapter.AbstractODMAdapter;
import org.ieee.pes.odm.pss.model.IEEEODMPSSModelParser;
import org.ieee.pes.odm.pss.model.ODMData2XmlHelper;
import org.ieee.pes.odm.pss.model.StringUtil;


public class BPAAdapter  extends AbstractODMAdapter {
	public final static String Token_CaseType = "Type";
	public final static String Token_ProjectName = "Original Project Name";
	public final static String Token_CaseId = "Case Identification";
	public final static String Token_BN="Bus Name";
	private static final String Token_Id = "No";
	
	
	public BPAAdapter(Logger logger) {
		super(logger);
	}
	 
	protected IEEEODMPSSModelParser parseInputFile(
			final java.io.BufferedReader din) throws Exception {
		
		String str="";
		// first line, as a sign to run power flow data or transient data
		str=din.readLine();
		
		IEEEODMPSSModelParser parser = new IEEEODMPSSModelParser();

		parser.getStudyCase().setOriginalFormat(
				StudyCaseXmlType.OriginalFormat.BPA);
		parser.getStudyCase().setAdapterProviderName("www.interpss.org");
		parser.getStudyCase().setAdapterProviderVersion("1.00");
		parser.getStudyCase().setNetworkCategory(
				StudyCaseXmlType.NetworkCategory.TRANSMISSION);
		
		PSSNetworkXmlType baseCaseNet = parser.getBaseCase();
		
		
		if(str.equals("loadflow")){
			parser.getStudyCase().setAnalysisCategory(
					StudyCaseXmlType.AnalysisCategory.LOADFLOW);
			baseCaseNet.setId("Base_Case_from_BPA_loadflow_format");			
		}else if(str.equals("transient")){
			parser.getStudyCase().setAnalysisCategory(
					StudyCaseXmlType.AnalysisCategory.TRANSIENT_STABILITY);
			baseCaseNet.setId("Base_Case_from_BPA_transient_format");
		}
		
		NameValuePairListXmlType nvList = baseCaseNet.addNewNvPairList();		
		
		// read both power flow and transient data
		if(parser.getStudyCase().getAnalysisCategory().
				equals(StudyCaseXmlType.AnalysisCategory.TRANSIENT_STABILITY)){
			TransientSimulationXmlType tranSimu= parser.getTransientSimlation();
			do{
				str = din.readLine();
				if(!str.trim().equals("(END)")){
					try{
						if(str.startsWith(".")||str.startsWith("C")){
							
							getLogger().fine("load comment");
							
						}else if(str.startsWith("(POWERFLOW")||str.startsWith("/")
								||str.startsWith(">")){
							getLogger().fine("load header data");
							processNetData(str,nvList,baseCaseNet);
						}else if(str.startsWith("A")||str.trim().startsWith("I")){
							processAreaData(str, parser,	baseCaseNet, this);
							
						}else if((str.trim().startsWith("B")||str.trim().startsWith("+")
								||str.trim().startsWith("X"))
								&&!str.trim().startsWith("BD")&&!str.trim().startsWith("BM")){
							getLogger().fine("load AC bus data");						
							BPABusRecord.processBusData(str,parser.addNewBaseCaseBus(),this);
						}else if(str.trim().startsWith("BD")||str.trim().startsWith("BM")){
							getLogger().fine("load DCLine bus data");						
							BPABusRecord.processDCLineBusData(str, parser.addNewBaseCaseDCLineBus(),this);
						}
						
						else if( (str.trim().startsWith("L")||str.trim().startsWith("E"))
								&&!str.trim().startsWith("LD")&&!str.trim().startsWith("LM")){
							getLogger().fine("load AC line data");
							BPABranchRecord.processBranchData(str, parser.addNewBaseCaseBranch(), 
									parser,baseCaseNet, this);
						}else if( str.trim().startsWith("T")){
							getLogger().fine("load transformer data");
							BPABranchRecord.processXfrData(str, parser.addNewBaseCaseBranch(), 
									parser,baseCaseNet, this);
						}else if(str.trim().startsWith("R")){
							getLogger().fine("load transformer adjustment data");
							BPABranchRecord.processXfrAdjustData(str, baseCaseNet, this);
						}
						else if( str.trim().startsWith("LD")||str.trim().startsWith("LM")){
							getLogger().fine("load DC Line data");
							BPABranchRecord.processDCLineBranchData(str, parser.addNewBaseCaseDCLineBranch(),
									parser,baseCaseNet, this);
						}else{
							processReadComment(str, baseCaseNet,this);
						}						
					}catch (final Exception e) {
						e.printStackTrace();
					}					
				}else if(str.startsWith("(END)"))	{						
					BPADynamicRecord.processDynamicData(str, tranSimu,din,
							parser,this);
					break;							
				}				
			}while(!str.trim().equals("(END)"));
	    // read power flow data only
		}else if(parser.getStudyCase().getAnalysisCategory().
				equals(StudyCaseXmlType.AnalysisCategory.LOADFLOW)){
			do{
				str = din.readLine();					
				if(!str.trim().equals("(END)")&&!str.trim().equals("(STOP)")){
					try{
						if(str.startsWith(".")||str.startsWith("C")){
							
							getLogger().fine("load comment");
							
						}else if(str.startsWith("(POWERFLOW")||str.startsWith("/")
								||str.startsWith(">")){
							getLogger().fine("load header data");
							processNetData(str,nvList,baseCaseNet);
						}else if(str.startsWith("A")||str.trim().startsWith("I")){
							processAreaData(str, parser,	baseCaseNet, this);
							
						}else if((str.trim().startsWith("B")||str.trim().startsWith("+")
								||str.trim().startsWith("X"))
								&&!str.trim().startsWith("BD")&&!str.trim().startsWith("BM")){
							getLogger().fine("load AC bus data");						
							BPABusRecord.processBusData(str,parser.addNewBaseCaseBus(),this);
						}else if(str.trim().startsWith("BD")||str.trim().startsWith("BM")){
							getLogger().fine("load DCLine bus data");						
							BPABusRecord.processDCLineBusData(str, parser.addNewBaseCaseDCLineBus(),this);
						}
						
						else if( (str.trim().startsWith("L")||str.trim().startsWith("E"))
								&&!str.trim().startsWith("LD")&&!str.trim().startsWith("LM")){
							getLogger().fine("load AC line data");
							BPABranchRecord.processBranchData(str, parser.addNewBaseCaseBranch(), 
									parser,baseCaseNet, this);
						}else if( str.trim().startsWith("T")){
							getLogger().fine("load transformer data");
							BPABranchRecord.processXfrData(str, parser.addNewBaseCaseBranch(), 
									parser,baseCaseNet, this);
						}else if(str.trim().startsWith("R")){
							getLogger().fine("load transformer adjustment data");
							BPABranchRecord.processXfrAdjustData(str, baseCaseNet, this);
						}
						else if( str.trim().startsWith("LD")||str.trim().startsWith("LM")){
							getLogger().fine("load DC Line data");
							BPABranchRecord.processDCLineBranchData(str, parser.addNewBaseCaseDCLineBranch(),
									parser,baseCaseNet, this);
						}else{
							processReadComment(str, baseCaseNet,this);
						}						
					}catch (final Exception e) {
						e.printStackTrace();
					}					
				}
			}while(!str.trim().equals("(END)")&&!str.trim().equals("(STOP)"));
		}
		
		return parser;
	}

	/*
	 *   Network data
	 *   ============ 
	 */
	private void processReadComment(final String str, final PSSNetworkXmlType baseCaseNet
			,BPAAdapter adapter){
		
		adapter.logErr("This line is not processed:  "+str);
		// to do in future
		
	}

	private void processNetData(final String str,final NameValuePairListXmlType nvList,
			final PSSNetworkXmlType baseCaseNet) {
			// parse the input data line
			final String[] strAry = getNetDataFields(str);			
	        //read powerflow, caseID,projectName, 			
			if (strAry[0]!= null ){
				ODMData2XmlHelper.addNVPair(nvList, strAry[0], strAry[1]);
				getLogger().fine(strAry[0] +": " + strAry[1]);
			}
			
			if (strAry[2]!= null ){
				ODMData2XmlHelper.addNVPair(nvList, strAry[2], strAry[4]);
				getLogger().fine(strAry[2]+": " + strAry[4] );
			}			
			// more name-vale could be added in future 
			
			// read MVA Base 
			final double baseMva; 
			
			if(strAry[5]!= null){
				baseMva = new Double(strAry[5]).doubleValue(); // in MVA
			}else {baseMva = 100;}
			getLogger().fine("BaseKva: " + baseMva);
			baseCaseNet.setBasePower(baseMva);
			baseCaseNet.setBasePowerUnit(PSSNetworkXmlType.BasePowerUnit.MVA);;
	}

	/*
	 *   area data
	 *   ================ 
	 */

	private void processAreaData(final String str,final IEEEODMPSSModelParser parser ,
			final PSSNetworkXmlType baseCaseNet,BPAAdapter adapter	) {
		
		final String[] strAry = getAreaDataFields(str, adapter);
	
		if(str.trim().startsWith("A")||str.trim().startsWith("AC")){	
			PSSNetworkXmlType.AreaList.Area area=parser.addNewBaseCaseArea();
			
			final String areaType=strAry[0];			
			if(!strAry[1].equals("")){
				final String modCode=strAry[1];				
			}
			String areaName="";
			if(!strAry[2].equals("")){
				areaName=strAry[2];
				area.setAreaName(areaName);					
			}
			String slackBusId;
			double ratedVoltage;
			if(!strAry[3].equals("")){
				slackBusId=strAry[3];
				area.addNewSwingBusId().setName(slackBusId);
			}
            if(!strAry[4].equals("")){
				ratedVoltage =new Double(strAry[4]).doubleValue();
				area.addNewRatedVoltage().setVoltage(ratedVoltage);
				area.getRatedVoltage().setUnit(VoltageXmlType.Unit.KV);
			}
            double exchangeMW=0.0;
            if(!strAry[5].equals("")){            	
            	ODMData2XmlHelper.setPowerData(area.addNewTotalExchangePower(),
            			           exchangeMW, 0, PowerXmlType.Unit.MVA);            	
            }            
            if(!strAry[6].trim().equals("")){
            	area.addNewZoneList();
            	int Str6length=strAry[6].length();
            	
            	final String[] s= new String[20];
            	int cnt=0, i=0;            	
           while((!strAry[6].substring(i, i+2).equals(""))&& i+2<=Str6length){            		
            		s[cnt]=strAry[6].trim().substring(i, i+2);            		
            		PSSNetworkXmlType.AreaList.Area.ZoneList.Zone zone= area.getZoneList().addNewZone();
            		zone.setZoneName(s[cnt]);
            		if(i+2==Str6length){
            			break;
            		}
            		i=i+3;
            		cnt=cnt+1;            		
            	}            	
            }
		}else if(str.trim().startsWith("AO")){
			final String dataType=strAry[0];
			
			if(!strAry[1].equals("")){
				final String modCode= strAry[1];
			}
			if(!strAry[2].trim().equals("")){
				String areaName=strAry[2];
				PSSNetworkXmlType.AreaList.Area area=ODMData2XmlHelper.
				                                 getAreaRecordByAreaName(areaName, baseCaseNet);
				if(area==null){
					area.setAreaName(areaName);
				}
			}
			if(!strAry[3].trim().equals("")){
				// suppose there is a maximum of 40 areas
            	final String s[]= new String[40];
            	int cnt=0, i=0;            	
            }
		  
			
		}else if(str.trim().startsWith("I")){
			final String dataType=strAry[0];
			if(!strAry[1].equals("")){
				final String modCode= strAry[1];
			}
			String fBus="";
			if(!strAry[2].equals("")){
			    fBus= strAry[2];			    
			}
			String tBus="";
			if(!strAry[3].equals("")){
			    tBus= strAry[3];
			}
			double exchangePower=0.0;
			if(!strAry[4].equals("")){
				exchangePower= new Double(strAry[4]).doubleValue();				
			}			
			if(!fBus.equals("")&& exchangePower!=0){				
				PSSNetworkXmlType.AreaList.Area area=ODMData2XmlHelper.
				getAreaRecordByAreaName(fBus, baseCaseNet);	
				PSSNetworkXmlType.AreaList.Area.ExchangePower exchange=area.addNewExchangePower();
				exchange.setToArea(tBus);
				ODMData2XmlHelper.setPowerData(exchange.addNewExchangePower(),
     			    exchangePower, 0, PowerXmlType.Unit.MVA);				
			}			
		}		
	}
	
	private String[] getNetDataFields(final String str) {
		final String[] strAry = new String[7];
		//the first line data
		if(str.startsWith("(POWERFLOW")){
		     String s1[]= new String[3];		     
		     final StringTokenizer st= new StringTokenizer(str, ",");
		     s1[0]=st.nextToken();
		     s1[1]=st.nextToken();
		     s1[2]=st.nextToken();		     
		     final StringTokenizer st1= new StringTokenizer(s1[1], "=");	 
		     strAry[0]=st1.nextToken();
		     strAry[1]=st1.nextToken();
		     final StringTokenizer st2= new StringTokenizer(s1[2], "=");
		     strAry[2]=st2.nextToken();
		     strAry[3]=st2.nextToken();
		     int length= strAry[3].length();
		     strAry[4]=strAry[3].substring(0, length-1);
			}
		// select certain concerned data to added
		//strAry[4]= baseMVA
		if(str.startsWith("/MVA_BASE")){			
			strAry[5]=str.substring(10, str.length()-1);			
		}		
	   return strAry;
	}
	private String[] getAreaDataFields(final String str, BPAAdapter adapter) {
		final String[] strAry = new String[7];
		
		try{
			if (str.trim().startsWith("A")||str.trim().startsWith("AC")){			

				strAry[0] = StringUtil.getStringReturnEmptyString(str, 1, 2);
				strAry[1] = StringUtil.getStringReturnEmptyString(str, 3, 3);
				strAry[2] = StringUtil.getStringReturnEmptyString(str, 4, 13);
				strAry[3] = StringUtil.getStringReturnEmptyString(str, 14, 21);
				strAry[4] = StringUtil.getStringReturnEmptyString(str, 22, 25);
				strAry[5] = StringUtil.getStringReturnEmptyString(str, 26, 34);
				// zones within area
				int strlength=str.trim().length();
				
				strAry[6] = StringUtil.getStringReturnEmptyString(str,36, strlength);;
				
				
			  }else if(str.trim().startsWith("AO")){ 
				    strAry[0] = StringUtil.getStringReturnEmptyString(str,1, 2).trim();
					strAry[1] = StringUtil.getStringReturnEmptyString(str,3, 3).trim();
					// area name
					strAry[2] = StringUtil.getStringReturnEmptyString(str,4, 13).trim();
					// zones within the area
					int strlength=str.length();
					strAry[3] = StringUtil.getStringReturnEmptyString(str,15, strlength).trim();				
				  
			  }else if(str.trim().startsWith("I")){
				    strAry[0] = StringUtil.getStringReturnEmptyString(str, 1, 1);
					strAry[1] = StringUtil.getStringReturnEmptyString(str, 3, 3);
					strAry[2] = StringUtil.getStringReturnEmptyString(str, 4, 13);
					strAry[3] = StringUtil.getStringReturnEmptyString(str, 15, 24);
					strAry[4] = StringUtil.getStringReturnEmptyString(str, 27, 34);		
			  }	
		}catch (Exception e){
			adapter.logErr("error there is");
			adapter.logErr(e.toString());
		}
		
		
		return strAry;
	}
}