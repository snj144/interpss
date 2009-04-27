/*
 * @(#)PSSEAdapter.java   
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
package org.ieee.pes.odm.pss.adapter.psse.v26;

import java.util.logging.Logger;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AnalysisCategoryEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NetworkCategoryEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.StudyCaseXmlType;
import org.ieee.pes.odm.pss.adapter.AbstractODMAdapter;
import org.ieee.pes.odm.pss.model.IEEEODMPSSModelParser;

public class PSSEV26Adapter extends AbstractODMAdapter{
	private final int 
		BusData = 1,
		LoadData = 2,
		GenData = 3,
		BranchData = 4,
		XfrAdjData = 5,
		InterchangeData = 6,
		//DcLine2TData = 7,
		SwitchedShuntData = 8,
		//XfrDataTableData = 9,
		//DcLineMTData = 10,
		//MultiSecLineData = 11,
		ZoneData = 12,
		InterAreaTransferData = 13,
		OwnerData = 14;
		//FactsData = 15;
		
	public static final String Token_Id = "No";
	
	public PSSEV26Adapter(Logger logger) {
		super(logger);
	}
	protected IEEEODMPSSModelParser parseInputFile(
			final java.io.BufferedReader din) throws Exception {
		IEEEODMPSSModelParser parser = createParser();
		PSSNetworkXmlType baseCaseNet = parser.getBaseCase();
		// no space is allowed for ID field
		baseCaseNet.setId("Base_Case_from_PSS_E_format");

		//read header info
		String sAry[]= new String[5];
		for (int i = 0; i < 3; i++ ) {			
			String str = din.readLine();
			sAry[i]= str;				
		} 
		PSSEV26NetRecord.processHeaderData(sAry[0],sAry[1],sAry[2],baseCaseNet, this.getLogger());	

        String str ;         
        int type=BusData;
        do{
        	str = din.readLine();

        	if (str != null){
            	//  a line string in version 26 has the following format
            	// 31212,'ADLIN  1', 115.00,1,    0.00,    0.00,  1,  1,1.01273, -10.5533,1,    /* [31212_MPE     _115_B1] */
            	// we need to get rid of the tailing comment part
            	int pos = str.indexOf("/*");
            	if (pos > 0)
            		str = str.substring(0, str.indexOf("/*"));
        		try {	         	 
        			if (str.startsWith("0 /")){
        				type++;
        			}
        			else {
        				if (type==BusData){
        					//System.out.println("BusData: " + str);
        					PSSEV26BusRecord.processBusData(str, parser, this.getLogger());
        				}
        				else if(type==LoadData){
        					//System.out.println("LoadData: " + str);
        					PSSEV26BusRecord.processLoadData(str, parser, this.getLogger());
        				}
        				else if(type==GenData){
        					//System.out.println("GenData: " + str);
        					PSSEV26BusRecord.processGenData(str, parser, this.getLogger());        			 
        				}
        				else if(type==BranchData){
        					//System.out.println("LineData: " + str);
        					PSSEV26BranchRecord.processBranchData(str, parser, this.getLogger()); 
        				}
        				else if(type==XfrAdjData){        			   
        					//System.out.println("XfrData: " + str);
        					//PSSEBranchRecord.processXformerData(sAry[1],sAry[2],sAry[3],sAry[4],
        			    	//	 parser.addNewBaseCaseBranch(),baseCaseNet, this);
        				} 
        				else if(type==SwitchedShuntData){        			   
        					//System.out.println("ShuntData: " + str);
        					PSSEV26BusRecord.processSwitchedShuntData(str, parser, this.getLogger());
        			    	//	 parser.addNewBaseCaseBranch(),baseCaseNet, this);
        				} 
        				else if(type==InterchangeData){
        					//System.out.println("InterData: " + str);
        					PSSEV26NetRecord.processAreaInterchangeData(str,baseCaseNet); 
        				}
        				else if(type==ZoneData){
        					//System.out.println("ZoneData: " + str);
        					PSSEV26NetRecord.processZoneData(str,baseCaseNet); 
        				}
        				else if(type==InterAreaTransferData){
        					//processInterAreaTransferData(str,baseCaseNet); 
        				}
        				else if(type==OwnerData){
        					//System.out.println("OwnerData: " + str);
        					PSSEV26NetRecord.processOwnerData(str,baseCaseNet); 
        				}
        			}
        		}catch (final Exception e){
        			System.out.println(str);
					this.logErr(e.toString());
					e.printStackTrace();
        		}
             }
        }	while (str != null);
                 
   	   return parser;
	}
	
	
	private IEEEODMPSSModelParser createParser() {
		IEEEODMPSSModelParser parser = new IEEEODMPSSModelParser();
		parser.getStudyCase().setSchemaVersion(
				StudyCaseXmlType.SchemaVersion.V_1_00_DEV);
		
		StudyCaseXmlType.ContentInfo info = parser.getStudyCase().addNewContentInfo();
		info.setOriginalDataFormat(	StudyCaseXmlType.ContentInfo.OriginalDataFormat.PSS_E);
		info.setOriginalFormatVersion("V26");
		info.setAdapterProviderName("www.interpss.org");
		info.setAdapterProviderVersion("1.00");

		parser.getStudyCase().getBaseCase().setAnalysisCategory(
				AnalysisCategoryEnumType.LOADFLOW);
		parser.getStudyCase().getBaseCase().setNetworkCategory(
				NetworkCategoryEnumType.TRANSMISSION);
		return parser;
	}	
}
