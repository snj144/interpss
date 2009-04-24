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
package org.ieee.pes.odm.pss.adapter.psse;

import java.util.logging.Logger;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AnalysisCategoryEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NetworkCategoryEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.StudyCaseXmlType;
import org.ieee.pes.odm.pss.adapter.AbstractODMAdapter;
import org.ieee.pes.odm.pss.model.IEEEODMPSSModelParser;

public class PSSEV26Adapter extends AbstractODMAdapter{
	public final static String Token_CaseDesc = "Case Description";     
	public final static String Token_CaseId = "Case ID";				

	public static final String Token_Id = "No";
	
	public PSSEV26Adapter(Logger logger) {
		super(logger);
	}
	protected IEEEODMPSSModelParser parseInputFile(
			final java.io.BufferedReader din) throws Exception {
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

		PSSNetworkXmlType baseCaseNet = parser.getBaseCase();
		// no space is allowed for ID field
		baseCaseNet.setId("Base_Case_from_PSS_E_format");

		//read header info
		int i=0; 
		String sAry[]= new String[5];
		do {			
			String str = din.readLine();
			sAry[++i]= str;				
		} while (i<3);
		//processHeaderData(sAry[1],sAry[2],sAry[3],baseCaseNet);	

        String str ;         
        int j=1, type=1,  n=0;
        do{
        	str = din.readLine();
        	if (str != null){
        		try {	         	 
        			if (str.startsWith("0")){
        				type =++j;
        			}else {
        				if (type==1){
        					//PSSEBusRecord.processBusData(str, parser.addNewBaseCaseBus(), this);
        				}
        				else if(type==2){
        					//PSSEBusRecord.processLoadData(str, baseCaseNet, this);
        				}
        				else if(type==3){
        					//PSSEBusRecord.processGenData(str, baseCaseNet, this);        			 
        				}
        				else if(type==4){
        					//PSSEBranchRecord.processLineData(str, parser.addNewBaseCaseBranch(), this); 
        				}
        				else if(type==5){        			   
        					do{         			    	 
        						sAry[++n]=str;
        						if (n<4)
        							str=din.readLine();
        					}while (n<4);
        					n=0;
        					//PSSEBranchRecord.processXformerData(sAry[1],sAry[2],sAry[3],sAry[4],
        			    	//	 parser.addNewBaseCaseBranch(),baseCaseNet, this);
        			   
        				} else if(type==6){
        					//processAreaInterchangeData(str,baseCaseNet); 
        				}else if(type==13){
        					//processZoneData(str,baseCaseNet); 
        				}else if(type==14){
        					//processInterAreaTransferData(str,baseCaseNet); 
        				}else if(type==15){
        					//processOwnerData(str,baseCaseNet); 
        				}
        			}
        		}catch (final Exception e){
					this.logErr(e.toString());
        		}
             }
        }	while (str != null);
                 
   	   return parser;
	}
}
