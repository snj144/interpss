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

import java.util.StringTokenizer;
import java.util.logging.Logger;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NameValuePairListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PowerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.StudyCaseXmlType;
import org.ieee.pes.odm.pss.adapter.AbstractODMAdapter;
import org.ieee.pes.odm.pss.model.IEEEODMPSSModelParser;
import org.ieee.pes.odm.pss.model.ODMData2XmlHelper;

public class PSSEAdapter extends AbstractODMAdapter{
	public final static String Token_CaseDesc = "Case Description";     
	public final static String Token_CaseId = "Case ID";				

	public static final String Token_Id = "No";
	
	public PSSEAdapter(Logger logger) {
		super(logger);
	}
	protected IEEEODMPSSModelParser parseInputFile(
			final java.io.BufferedReader din) throws Exception {
		IEEEODMPSSModelParser parser = new IEEEODMPSSModelParser();
		parser.getStudyCase().setSchemaVersion(
				StudyCaseXmlType.SchemaVersion.V_1_00_DEV);
		parser.getStudyCase().setOriginalFormat(
				StudyCaseXmlType.OriginalFormat.PSS_E);
		parser.getStudyCase().setAdapterProviderName("www.interpss.org");
		parser.getStudyCase().setAdapterProviderVersion("1.00");

		parser.getStudyCase().setAnalysisCategory(
				StudyCaseXmlType.AnalysisCategory.LOADFLOW);
		parser.getStudyCase().setNetworkCategory(
				StudyCaseXmlType.NetworkCategory.TRANSMISSION);

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
		processHeaderData(sAry[1],sAry[2],sAry[3],baseCaseNet);	

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
        					PSSEBusRecord.processBusData(str, parser.addNewBaseCaseBus(), this);
        				}
        				else if(type==2){
        					PSSEBusRecord.processLoadData(str, baseCaseNet, this);
        				}
        				else if(type==3){
        					PSSEBusRecord.processGenData(str, baseCaseNet, this);        			 
        				}
        				else if(type==4){
        					PSSEBranchRecord.processLineData(str, parser.addNewBaseCaseBranch(), this); 
        				}
        				else if(type==5){        			   
        					do{         			    	 
        						sAry[++n]=str;
        						if (n<4)
        							str=din.readLine();
        					}while (n<4);
        					n=0;
        					PSSEBranchRecord.processXformerData(sAry[1],sAry[2],sAry[3],sAry[4],
        			    		 parser.addNewBaseCaseBranch(),baseCaseNet, this);
        			   
        				} else if(type==6){
        					processAreaInterchangeData(str,baseCaseNet); 
        				}else if(type==13){
        					processZoneData(str,baseCaseNet); 
        				}else if(type==14){
        					processInterAreaTransferData(str,baseCaseNet); 
        				}else if(type==15){
        					processOwnerData(str,baseCaseNet); 
        				}
        			}
        		}catch (final Exception e){
					this.logErr(e.toString());
        		}
             }
        }	while (str != null);
                 
   	   return parser;
	}
	
	
	private  boolean processHeaderData(final String str,final String str2,final String str3,
			final PSSNetworkXmlType baseCaseNet) throws Exception {
		// parse the input data line
		//line 1 at here we have "0, 100.00 "		
		/*
		 * String[0] indicator
		 * String[1] baseKav
		 * String[2] comments
		 * String[3] comments
		 */
		final String[] strAry = getHeaderDataFields(str,str2,str3);
		if (strAry == null)
			return false;
		
		final double baseMva = new Double(strAry[1]).doubleValue();
	    getLogger().fine("BaseKva: "  + baseMva);
	    baseCaseNet.setBasePower(baseMva);
		baseCaseNet.setBasePowerUnit(PSSNetworkXmlType.BasePowerUnit.MVA);	
		
		NameValuePairListXmlType nvList = baseCaseNet.addNewNvPairList();
		
		final String desc = strAry[2];// The 2nd line is treated as description
		ODMData2XmlHelper.addNVPair(nvList, Token_CaseDesc, desc);     
	   
	    // the 3rd line is treated as the network id and network name		
		final String caseId= strAry[3];
		ODMData2XmlHelper.addNVPair(nvList, Token_CaseId, caseId);				
		getLogger().fine("Case Description, caseId: " + desc + ", "+ caseId);		
		
        return true;
	}
        
	private  void processAreaInterchangeData(final String str,
			final PSSNetworkXmlType baseCaseNet) {
		final String[] strAry = getInterAreaTransferDataFields(str);
		//     Area number , no zeros! *
		final int no = new Integer(strAry[0]).intValue();
		//       Alternate swing bus name [A]
		final String alSwingBusName = strAry[1];

		//        Area interchange export, MW [F] (+ = out) *
		//        Area interchange tolerance, MW [F] *
		final double mw = new Double(strAry[2]).doubleValue();
		final double err = new Double(strAry[3]).doubleValue();
    
		PSSNetworkXmlType.InterchangeList.Interchange.IeeeCDFInterchange interchange =
		baseCaseNet.addNewInterchangeList().addNewInterchange().addNewIeeeCDFInterchange();
	
		interchange.setAreaNumber(no);

		interchange.setAlternateSwingBusName(alSwingBusName);
		ODMData2XmlHelper.setPowerData(interchange.addNewInterchangePower(), mw, 0.0, PowerXmlType.Unit.MVA);
		interchange.setInterchangeErrTolerance(err);
	
	}
	
	private  void processZoneData(final String str,
			final PSSNetworkXmlType baseCaseNet){
		final String[] strAry =getZoneDataFields(str);
		final String zoneId = strAry[0];
		final String zoneName = strAry[1];
		NameValuePairListXmlType nvList = baseCaseNet.getNvPairList();
		ODMData2XmlHelper.addNVPair(nvList, "zoneId", zoneId);
		ODMData2XmlHelper.addNVPair(nvList, "zoneName", zoneName);		
	}
	
	
	private  void processInterAreaTransferData(final String str,
			final PSSNetworkXmlType baseCaseNet) {
		final String[] strAry = getInterAreaTransferDataFields(str);
		
	}
	
	private  void processOwnerData(final String str,
			final PSSNetworkXmlType baseCaseNet) {
		final String[] strAry = getOwnerDataFields(str);
		final String ownerId = strAry[0];
		final String ownerName = strAry[1];
		NameValuePairListXmlType nvList = baseCaseNet.getNvPairList();
		ODMData2XmlHelper.addNVPair(nvList, "ownerName", ownerName);
		ODMData2XmlHelper.addNVPair(nvList, "ownerId", ownerId);
	}
		
	/*
	 * String[0] indicator
	 * String[1] baseKav
	 * String[2] comments
	 * String[3] comments
	 */
	private  String[] getHeaderDataFields(final String lineStr, final String lineStr2,
							final String lineStr3)	throws Exception{
		final String[] strAry = new String[4];	
		StringTokenizer st = new StringTokenizer(lineStr, ",");
		
		strAry[0] = st.nextToken();  			   
		int indicator = new Integer(strAry[0]).intValue();
		if (indicator !=0){
			this.logErr("Error: Only base case can be process");
			return null;
		}

		strAry[1]=st.nextToken().trim();  			   
		
		if (lineStr2!= null){
			strAry[2] = lineStr2;
		}else {strAry[2] =""; }
		if (lineStr3!= null){
			strAry[3] = lineStr3;
		}else {strAry[3] =""; }
  				
		return strAry;
	}
	
	private  String[] getAreaInterchangeDataFields(final String lineStr) {
		final String[] strAry = new String[5];
		/*
		I,ISW,PDES,PTOL,'ARNAM'
        */
  		StringTokenizer st = new StringTokenizer(lineStr, ",");
 		strAry[0]=st.nextToken().trim();
  		strAry[1]=st.nextToken().trim();
  		strAry[2]=st.nextToken().trim();
  		strAry[3]=st.nextToken().trim();
  		strAry[4]=st.nextToken().trim();
  		
  		return strAry;
	}
	
	//private static String[] getTwoTerminalDCLineDataFields(final String lineStr) {
		//final String[] strAry = new String[5];	
		//It will be implemented in the future
     // }
	//private static String[] getVSCDCLineDataFields(final String lineStr) {
		//final String[] strAry = new String[5];	
		//It will be implemented in the future
     //  }
	
	//private static String[] getSwitchedShuntDATAFields(final String lineStr) {
		//final String[] strAry = new String[5];	
		//It will be implemented in the future
     //  }
	//private static String[] getImpedenceCorrectionDATAFields(final String lineStr) {
		//final String[] strAry = new String[5];	
		//It will be implemented in the future
    //   }
	/*private static String[] getMultiTerminalDATAFields(final String lineStr) {
		//final String[] strAry = new String[5];	
		//It will be implemented in the future
       }
	private static String[] getMultiSectionLineDATAFields(final String lineStr) {
		//final String[] strAry = new String[5];	
		//It will be implemented in the future
      }*/ 
	private  String[] getZoneDataFields(final String lineStr) {
		final String[] strAry = new String[2];	
		/*
		 * Format: I, Name
		 */
  		StringTokenizer st = new StringTokenizer(lineStr, ",");
  		strAry[0]=st.nextToken().trim();
  		strAry[1]=st.nextToken().trim();
  		return strAry;
       }
	private  String[] getInterAreaTransferDataFields(final String lineStr) {
		final String[] strAry = new String[5];	
		/*
		 * format: ARFROM, ARTO, TRID, PTRAN
		 */
  		StringTokenizer st = new StringTokenizer(lineStr, ",");
  		strAry[0]=st.nextToken().trim();
  		strAry[1]=st.nextToken().trim();
  		strAry[3]=st.nextToken().trim();
  		strAry[4]=st.nextToken().trim();
  		return strAry;

       }
	private  String[] getOwnerDataFields(final String lineStr) {
		final String[] strAry = new String[2];	
		/*
		 * format : I, Name
		 */
  		StringTokenizer st = new StringTokenizer(lineStr, ",");
  		strAry[0]=st.nextToken().trim();
  		strAry[1]=st.nextToken().trim();
  		return strAry;
	}
	//private  String[] getFactsDeviceDATAFields(final String lineStr) {
		//final String[] strAry = new String[5];	
		//It will be implemented in the future
      // 	}
}
