/*
 * @(#)PSSEBranchRecord.java   
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

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AngleUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ApparentPowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BranchRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LFBranchCodeEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBranchDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.YUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.YXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZUnitType;
import org.ieee.pes.odm.pss.adapter.psse.PSSEAdapter;
import org.ieee.pes.odm.pss.model.IEEEODMPSSModelParser;
import org.ieee.pes.odm.pss.model.ODMData2XmlHelper;
import org.ieee.pes.odm.pss.model.StringUtil;

public class PSSEV26BranchRecord {
	public static  void processBranchData(final String str, final IEEEODMPSSModelParser parser, Logger logger) {
		/*
		I,    J,    CKT, R,      X,        B,     RATEA,RATEB,RATEC,RATIO,ANGLE,GI,BI,GJ,BJ,ST  LEN,O1,F1,...,O4,F4
		31962,32156,' 1',0,      0.444445, 0,     30,   30,   0,    1,    0,    0, 0, 0, 0, 1,  0,  1, 1, 0,0,0,0,0,0, [Transformer_798]
		32218,32219,' 1',0.0005, 0.0005,   0,     100,  100,  0,    0,    0,    0, 0, 0, 0, 1,  0,  1, 1, 0,0,0,0,0,0,[Compensator_125] 
		32062,32058,' 1',0.03359,0.01968,  0,     21,   24,   0,    0,    0,    0, 0, 0, 0, 1,  0,  1, 1, 0,0,0,0,0,0, [Conductor_406]  

		I - From bus number
		J - To bus number
		CKT - Circuit identifier (two character) not clear if integer or alpha
		R - Resistance, per unit
		X - Reactance, per unit
		B - Total line charging, per unit
		RATEA, RATEB, RATEC - Higher MVA ratings
		RATIO - Transformer off nominal turns ratio
		ANGLE - Transformer phase shift angle
		 */
		// parse the input data line	
		final String[] strAry = getLineDataFields(str);		
		final String fid = PSSEAdapter.Token_Id+strAry[0];
		final String tid = PSSEAdapter.Token_Id+strAry[1];
		final String cirId = strAry[2];
		String branchId = ODMData2XmlHelper.formBranchId(fid, tid, cirId);
		logger.fine("Branch data loaded, from-id, to-id: " + fid + ", " + tid);
		
		BranchRecordXmlType branchRec = parser.addNewBaseCaseBranch(branchId);
		branchRec.addNewFromBus().setIdRef(fid);
		branchRec.addNewToBus().setIdRef(tid);	
		branchRec.setCircuitId(cirId);
		
		int status = StringUtil.getInt(strAry[15], 0);
		branchRec.setOffLine(status == 0);
		
		LoadflowBranchDataXmlType branchData=branchRec.addNewLoadflowData();	
		
        //      Branch resistance R, per unit  *
		//      Branch reactance X, per unit  * No zero impedance lines
		//    	Line charging B, per unit  * (total line charging, +B), Xfr B is negative
		final double rpu = new Double(strAry[3]).doubleValue();
		final double xpu = new Double(strAry[4]).doubleValue();
		final double bpu = new Double(strAry[5]).doubleValue();
		
		final double ratio = StringUtil.getDouble(strAry[9], 0.0);
		final double angle = StringUtil.getDouble(strAry[10], 0.0);;

		final double fromTap = ratio, toTap = 1.0;
		final double fromAng = angle, toAng = 0.0;
		
		if (ratio == 0.0) {
			ODMData2XmlHelper.setLineData(branchData, rpu, xpu,	ZUnitType.PU, 0.0, bpu, YUnitType.PU);
		}
		else if (angle == 0.0) {
			ODMData2XmlHelper.createXformerData(branchRec.getLoadflowData(),
				       rpu, xpu, ZUnitType.PU, fromTap, toTap);		
		}
		else {
   			ODMData2XmlHelper.createPhaseShiftXfrData(branchRec
					.getLoadflowData(), rpu, xpu, ZUnitType.PU, fromTap, toTap, fromAng, toAng, AngleUnitType.DEG);			
		}
		
		final double rating1Mvar = new Double(strAry[6]).doubleValue();
		final double rating2Mvar = new Double(strAry[7]).doubleValue();
		final double rating3Mvar = new Double(strAry[8]).doubleValue();
		
		ODMData2XmlHelper.setBranchRatingLimitData(branchData,
				rating1Mvar, rating2Mvar, rating3Mvar,
				ApparentPowerUnitType.MVA, 0.0,
				null);
		
		//From side shuntY
		final double GI= new Double(strAry[11]).doubleValue();
		final double BI= new Double(strAry[12]).doubleValue();
        if(GI!=0.0 || BI!=0.0 )  {
        	YXmlType y;
        	if (branchData.getCode() == LFBranchCodeEnumType.LINE)
        		y = branchData.getLineData().addNewFromShuntY();
        	else if (branchData.getCode() == LFBranchCodeEnumType.TRANSFORMER)
        		y = branchData.getXformerData().addNewFromShuntY();
        	else
        		y = branchData.getPhaseShiftXfrData().addNewFromShuntY();
        	ODMData2XmlHelper.setYData(y, GI, BI, YUnitType.PU);
        }

	    //To side shuntY
		final double GJ= new Double(strAry[13]).doubleValue();
		final double BJ= new Double(strAry[14]).doubleValue();
	    if(GJ!=0.0 || BJ!=0.0)  {
        	YXmlType y;
        	if (branchData.getCode() == LFBranchCodeEnumType.LINE)
        		y = branchData.getLineData().addNewToShuntY();
        	else if (branchData.getCode() == LFBranchCodeEnumType.TRANSFORMER)
        		y = branchData.getXformerData().addNewToShuntY();
        	else
        		y = branchData.getPhaseShiftXfrData().addNewToShuntY();
        	ODMData2XmlHelper.setYData(y, GJ, BJ, YUnitType.PU);
	    }
	}
   
	private static String[] getLineDataFields(final String lineStr) {
		final String[] strAry = new String[23];

  		StringTokenizer st = new StringTokenizer(lineStr, ",");
		/*
		I,J,CKT,R,X,B,RATEA,RATEB,RATEC,GI,BI,GJ,BJ,ST,LEN,O1,F1,...,O4,F4
        */

  		for (int i = 0; i < 15; i++)
  			strAry[i]=st.nextToken().trim();

        //O1,F1,...,O4,F4
  		
		// O1 = 0, O2 = 0, O3 = 0, O4 = 0;
		// F1 = 0.0, F2 = 0.0, F3 = 0.0, F4 = 0.0;
  		for (int i = 15; i < 23; i++)
  			strAry[i]="0";

		if (st.hasMoreTokens()) {
			strAry[15]=st.nextToken().trim();
	  		strAry[16]=st.nextToken().trim();
		}
		if (st.hasMoreTokens()) {
			strAry[17]=st.nextToken().trim();
	  		strAry[18]=st.nextToken().trim();
		}
		if (st.hasMoreTokens()) {
			strAry[19]=st.nextToken().trim();
	  		strAry[20]=st.nextToken().trim();
		}
		if (st.hasMoreTokens()) {
			strAry[21]=st.nextToken().trim();
	  		strAry[22]=st.nextToken().trim();
		}
				
		return strAry;
	
	}
}
