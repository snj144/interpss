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
package org.ieee.odm.adapter.xbean.psse.v26.impl;

import java.util.StringTokenizer;
import java.util.logging.Logger;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ActivePowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NameValuePairListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PowerInterchangeXmlType;
import org.ieee.odm.model.ModelStringUtil;
import org.ieee.odm.model.xbean.XBeanDataSetter;
import org.ieee.odm.model.xbean.XBeanParserHelper;

public class XBeanPSSEV26NetRecord {
	public final static String Token_CaseDesc = "Case Description";     
	public final static String Token_CaseId = "Case ID";	
	
	public static boolean processHeaderData(final String str1,final String str2,final String str3,
			final PSSNetworkXmlType baseCaseNet, Logger logger) throws Exception {
		//line 1 at here we have "0, 100.00 " or some times "0 100.00 "		
		final String[] strAry = getHeaderDataFields(str1,str2,str3, logger);
		if (strAry == null)
			return false;
		
		final double baseMva = ModelStringUtil.getDouble(strAry[1], 100.0);
	    logger.fine("BaseKva: "  + baseMva);
	    XBeanDataSetter.setPowerMva(baseCaseNet.addNewBasePower(), baseMva);   

		NameValuePairListXmlType nvList = baseCaseNet.addNewNvPairList();
		
		final String desc = strAry[2];// The 2nd line is treated as description
		XBeanParserHelper.addNVPair(nvList, Token_CaseDesc, desc);     
	   
	    // the 3rd line is treated as the network id and network name		
		final String caseId= strAry[3];
		XBeanParserHelper.addNVPair(nvList, Token_CaseId, caseId);				
		logger.fine("Case Description, caseId: " + desc + ", "+ caseId);		
		
        return true;
	}
        
	public static  void processAreaInterchangeData(final String str,
			final PSSNetworkXmlType baseCaseNet) {
		final String[] strAry = getAreaInterchangeDataFields(str);
		
		//     Area number , no zeros! *
		final int no = ModelStringUtil.getInt(strAry[0], 0);
		
		//       swing bus name [A]
		final String swingBusName = strAry[1];

		//        Area interchange export, MW [F] (+ = out) *
		//        Area interchange tolerance, MW [F] *
		final double mw = ModelStringUtil.getDouble(strAry[2], 0.0);
		final double err = ModelStringUtil.getDouble(strAry[3], 0.0);
    
		PowerInterchangeXmlType interchange = baseCaseNet.addNewInterchangeList().addNewInterchange().addNewPowerEx();
	
		interchange.setAreaNumber(no);

		interchange.addNewSwingBus().setIdRef(swingBusName);
		XBeanDataSetter.setActivePower(interchange.addNewDesiredExPower(), mw, ActivePowerUnitType.MW);
		XBeanDataSetter.setActivePower(interchange.addNewExErrTolerance(), err, ActivePowerUnitType.MW);
	}
	
	public static  void processInterAreaTransferData(final String str,
			final PSSNetworkXmlType baseCaseNet) {
		final String[] strAry = getInterAreaTransferDataFields(str);
		
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
	
	private static  String[] getInterAreaTransferDataFields(final String lineStr) {
		final String[] strAry = new String[4];	
  		StringTokenizer st = new StringTokenizer(lineStr, ",");
  		for (int i = 0; i < 4; i++)
  			strAry[i]=st.nextToken().trim();
  		return strAry;

       }
}
