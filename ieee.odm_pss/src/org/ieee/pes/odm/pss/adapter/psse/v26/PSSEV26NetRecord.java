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

import java.util.StringTokenizer;
import java.util.logging.Logger;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ActivePowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BaseRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NameValuePairListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NetZoneXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PowerInterchangeXmlType;
import org.ieee.pes.odm.pss.model.DataSetter;
import org.ieee.pes.odm.pss.model.ContainerHelper;
import org.ieee.pes.odm.pss.model.StringUtil;

public class PSSEV26NetRecord {
	public final static String Token_CaseDesc = "Case Description";     
	public final static String Token_CaseId = "Case ID";	
	
	public static boolean processHeaderData(final String str1,final String str2,final String str3,
			final PSSNetworkXmlType baseCaseNet, Logger logger) throws Exception {
		//line 1 at here we have "0, 100.00 " or some times "0 100.00 "		
		final String[] strAry = getHeaderDataFields(str1,str2,str3, logger);
		if (strAry == null)
			return false;
		
		final double baseMva = StringUtil.getDouble(strAry[1], 100.0);
	    logger.fine("BaseKva: "  + baseMva);
	    DataSetter.setPowerMva(baseCaseNet.addNewBasePower(), baseMva);   

		NameValuePairListXmlType nvList = baseCaseNet.addNewNvPairList();
		
		final String desc = strAry[2];// The 2nd line is treated as description
		ContainerHelper.addNVPair(nvList, Token_CaseDesc, desc);     
	   
	    // the 3rd line is treated as the network id and network name		
		final String caseId= strAry[3];
		ContainerHelper.addNVPair(nvList, Token_CaseId, caseId);				
		logger.fine("Case Description, caseId: " + desc + ", "+ caseId);		
		
        return true;
	}
        
	public static  void processAreaInterchangeData(final String str,
			final PSSNetworkXmlType baseCaseNet) {
		final String[] strAry = getAreaInterchangeDataFields(str);
		
		//     Area number , no zeros! *
		final int no = StringUtil.getInt(strAry[0], 0);
		
		//       swing bus name [A]
		final String swingBusName = strAry[1];

		//        Area interchange export, MW [F] (+ = out) *
		//        Area interchange tolerance, MW [F] *
		final double mw = StringUtil.getDouble(strAry[2], 0.0);
		final double err = StringUtil.getDouble(strAry[3], 0.0);
    
		PowerInterchangeXmlType interchange = baseCaseNet.addNewInterchangeList().addNewInterchange().addNewPowerEx();
	
		interchange.setAreaNumber(no);

		interchange.addNewSwingBus().setIdRef(swingBusName);
		DataSetter.setActivePower(interchange.addNewDesiredExPower(), mw, ActivePowerUnitType.MW);
		DataSetter.setActivePower(interchange.addNewExErrTolerance(), err, ActivePowerUnitType.MW);
	}
	
	public static  void processZoneData(final String str,
			final PSSNetworkXmlType baseCaseNet){
		final String[] strAry =getZoneDataFields(str);
		final String zoneId = strAry[0];
		final String zoneName = strAry[1];
		if (baseCaseNet.getLossZoneList() == null)
			baseCaseNet.addNewLossZoneList();
		NetZoneXmlType zone = baseCaseNet.getLossZoneList().addNewLossZone();
		zone.setId(zoneId);
		zone.setName(zoneName);		
	}
	
	
	public static  void processInterAreaTransferData(final String str,
			final PSSNetworkXmlType baseCaseNet) {
		final String[] strAry = getInterAreaTransferDataFields(str);
		
	}
	
	public static  void processOwnerData(final String str,
			final PSSNetworkXmlType baseCaseNet) {
		final String[] strAry = getOwnerDataFields(str);
		final String ownerId = strAry[0];
		final String ownerName = strAry[1];
		if (baseCaseNet.getOwnerList() == null)
			baseCaseNet.addNewOwnerList();
		BaseRecordXmlType.OwnerList.Owner owner = baseCaseNet.getOwnerList().addNewOwner();
		owner.setName(ownerName);
		owner.setId(ownerId);
	}
		
	/*
	 * String[0] indicator
	 * String[1] baseKav
	 * String[2] comments
	 * String[3] comments
	 */
	private static String[] getHeaderDataFields(final String lineStr, final String lineStr2,
							final String lineStr3, Logger logger)	throws Exception{
		//line 1 at here we have "0, 100.00 " or some times "0 100.00 "		
		final String[] strAry = new String[4];	
		StringTokenizer st = lineStr.contains(",") ?
				new StringTokenizer(lineStr, ",") :
				new StringTokenizer(lineStr);
		
		strAry[0] = st.nextToken();  			   
		int indicator = new Integer(strAry[0]).intValue();
		if (indicator !=0){
			logger.severe("Error: Only base case can be process");
			return null;
		}

		strAry[1]=st.nextToken().trim();  			   
		
		if (lineStr2!= null){
			strAry[2] = lineStr2;
		} else {strAry[2] =""; }
		
		if (lineStr3!= null){
			strAry[3] = lineStr3;
		}else {strAry[3] =""; }
  				
		return strAry;
	}
	
	private static String[] getAreaInterchangeDataFields(final String lineStr) {
		final String[] strAry = new String[5];
  		StringTokenizer st = new StringTokenizer(lineStr, ",");
  		for (int i = 0; i < 5; i++)
  			strAry[i]=st.nextToken().trim();
  		return strAry;
	}
	
	private static  String[] getZoneDataFields(final String lineStr) {
		final String[] strAry = new String[2];	
  		StringTokenizer st = new StringTokenizer(lineStr, ",");
  		for (int i = 0; i < 2; i++)
  			strAry[i]=st.nextToken().trim();
  		return strAry;
       }
	
	private static  String[] getInterAreaTransferDataFields(final String lineStr) {
		final String[] strAry = new String[4];	
  		StringTokenizer st = new StringTokenizer(lineStr, ",");
  		for (int i = 0; i < 4; i++)
  			strAry[i]=st.nextToken().trim();
  		return strAry;

       }
	private static  String[] getOwnerDataFields(final String lineStr) {
		final String[] strAry = new String[2];	
  		StringTokenizer st = new StringTokenizer(lineStr, ",");
  		for (int i = 0; i < 2; i++)
  			strAry[i]=st.nextToken().trim();
  		return strAry;
	}

}
