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
package org.ieee.odm.adapter.dep.v07.psse.v26;

import java.util.logging.Logger;

import org.ieee.odm.adapter.AbstractODMAdapter;
import org.ieee.odm.adapter.IFileReader;
import org.ieee.odm.adapter.dep.v07.psse.PSSEBusRecord;
import org.ieee.odm.adapter.dep.v07.psse.PSSENetDataRec;
import org.ieee.odm.adapter.dep.v07.psse.PsseVersion;
import org.ieee.odm.adapter.dep.v07.psse.v26.impl.PSSEV26BranchRecord;
import org.ieee.odm.adapter.dep.v07.psse.v26.impl.PSSEV26BusRecord;
import org.ieee.odm.adapter.dep.v07.psse.v26.impl.PSSEV26NetRecord;
import org.ieee.odm.model.dep.jaxb.JaxbODMModelParser;
import org.ieee.odm.schema.LoadflowNetXmlType;
import org.ieee.odm.schema.ObjectFactory;
import org.ieee.odm.schema.OriginalDataFormatEnumType;

public class PSSEV26Adapter extends AbstractODMAdapter{
	private final int 
		BusData = 1,       // constants in indicating data block positions
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
	
	private ObjectFactory factory = null;	
		
	public PSSEV26Adapter(Logger logger) {
		super(logger);
		this.factory = new ObjectFactory();
	}
	
	@Override
	protected JaxbODMModelParser parseInputFile(
			final IFileReader din) throws Exception {
		JaxbODMModelParser parser = new JaxbODMModelParser();
		parser.setLFTransInfo(OriginalDataFormatEnumType.PSS_E);
		parser.getStudyCase().getContentInfo().setOriginalFormatVersion("PSSEV26");

		LoadflowNetXmlType baseCaseNet = parser.getAclfBaseCase();
		// no space is allowed for ID field
		baseCaseNet.setId("Base_Case_from_PSS_E_format_Ver26");

		//read header info
		String sAry[]= new String[5];
		for (int i = 0; i < 3; i++ ) {			
			String str = din.readLine();
			sAry[i]= str;				
		} 
		PSSEV26NetRecord.processHeaderData(sAry[0],sAry[1],sAry[2],baseCaseNet, this.getLogger(), this.factory);	

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
            	// some time, one might see 9999.0,9999.0,, .... The ,, will cause problem. Therefore, add a space in
            	// between to avoid the issue.
            	str = str.replaceAll(",,", ", ,");
            	
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
        					PSSEV26BranchRecord.processXformerAdjData(str, parser, this.getLogger());
        			    	//	 parser.addNewBaseCaseBranch(),baseCaseNet, this);
        				} 
        				else if(type==SwitchedShuntData){        			   
        					//System.out.println("ShuntData: " + str);
        					PSSEBusRecord.processSwitchedShuntData(str, PsseVersion.PSSE_26, parser, this.getLogger());
        			    	//	 parser.addNewBaseCaseBranch(),baseCaseNet, this);
        				} 
        				else if(type==InterchangeData){
        					//System.out.println("InterData: " + str);
        					PSSEV26NetRecord.processAreaInterchangeData(str,baseCaseNet, parser); 
        				}
        				else if(type==ZoneData){
        					//System.out.println("ZoneData: " + str);
        					PSSENetDataRec.processZoneRec(str, PsseVersion.PSSE_26, baseCaseNet, this.factory); 
        				}
        				else if(type==InterAreaTransferData){
        					//processInterAreaTransferData(str,baseCaseNet); 
        				}
        				else if(type==OwnerData){
        					//System.out.println("OwnerData: " + str);
        					PSSENetDataRec.processOwnerRec(str, PsseVersion.PSSE_26, baseCaseNet, this.factory); 
        				}
        			}
        		}catch (final Exception e){
					this.logErr(e.toString());
					e.printStackTrace();
        		}
             }
        }	while (str != null);
                 
   	   return parser;
	}
}