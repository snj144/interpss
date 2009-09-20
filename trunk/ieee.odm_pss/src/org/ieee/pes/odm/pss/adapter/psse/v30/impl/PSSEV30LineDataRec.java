package org.ieee.pes.odm.pss.adapter.psse.v30.impl;

import java.util.StringTokenizer;
import java.util.logging.Logger;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ApparentPowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BaseBranchDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BranchRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LFBranchCodeEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBranchDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.YUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZUnitType;
import org.ieee.pes.odm.pss.adapter.psse.PsseVersion;
import org.ieee.pes.odm.pss.adapter.psse.v30.PSSEV30Adapter;
import org.ieee.pes.odm.pss.model.DataSetter;
import org.ieee.pes.odm.pss.model.ODMModelParser;
import org.ieee.pes.odm.pss.model.ParserHelper;
import org.ieee.pes.odm.pss.model.StringUtil;

public class PSSEV30LineDataRec {
	
	/*
	 * BranchData
	 * I,J,CKT,R,X,B,RATEA,RATEB,RATEC,GI,BI,GJ,BJ,ST,LEN,O1,F1,...,O4,F4
	 */

	public static void procLine(String lineStr, PsseVersion version, ODMModelParser parser, Logger logger) {
		int i, j, status;
		String ckt;
		double r, x, b, ratea, rateb, ratec, gi, bi, gj, bj, len; 
		int o1 = 0, o2 = 0, o3 = 0, o4 = 0;
		double f1 = 0.0, f2 = 0.0, f3 = 0.0, f4 = 0.0;

		StringTokenizer st;

		st = new StringTokenizer(lineStr, ",");

		i = new Integer(st.nextToken().trim()).intValue();
		j = new Integer(st.nextToken().trim()).intValue();
		ckt = PSSEV30Adapter.trimQuote(st.nextToken()).trim();
		r = new Double(st.nextToken().trim()).doubleValue();
		x = new Double(st.nextToken().trim()).doubleValue();
		b = new Double(st.nextToken().trim()).doubleValue();
		ratea = new Double(st.nextToken().trim()).doubleValue();
		rateb = new Double(st.nextToken().trim()).doubleValue();
		ratec = new Double(st.nextToken().trim()).doubleValue();
		gi = new Double(st.nextToken().trim()).doubleValue();
		bi = new Double(st.nextToken().trim()).doubleValue();
		gj = new Double(st.nextToken().trim()).doubleValue();
		bj = new Double(st.nextToken().trim()).doubleValue();
		status = new Integer(st.nextToken().trim()).intValue();
		len = new Double(st.nextToken().trim()).doubleValue();

		if (st.hasMoreTokens())
			o1 = new Integer(st.nextToken().trim()).intValue();
		if (st.hasMoreTokens())
			f1 = new Double(st.nextToken().trim()).doubleValue();
		if (st.hasMoreTokens())
			o2 = new Integer(st.nextToken().trim()).intValue();
		if (st.hasMoreTokens())
			f2 = new Double(st.nextToken().trim()).doubleValue();
		if (st.hasMoreTokens())
			o3 = new Integer(st.nextToken().trim()).intValue();
		if (st.hasMoreTokens())
			f3 = new Double(st.nextToken().trim()).doubleValue();
		if (st.hasMoreTokens())
			o4 = new Integer(st.nextToken().trim()).intValue();
		if (st.hasMoreTokens())
			f4 = new Double(st.nextToken().trim()).doubleValue();

/*
		I,J,CKT,R,X,B,RATEA,RATEB,RATEC,GI,BI,GJ,BJ,ST,LEN,O1,F1,...,O4,F4
		
		ST Initial branch status where 1 designates in-service and 0 designates out-of-service. ST = 1 by default.
*/
		boolean fromMetered = true;
		if (j < 0) {
			fromMetered = false;
			j = -j;
		}
      	
		final String fid = ODMModelParser.BusIdPreFix+i;
		final String tid = ODMModelParser.BusIdPreFix+j;
		String branchId = StringUtil.formBranchId(fid, tid, ckt);

		BranchRecordXmlType branchRec;
		try {
			branchRec = parser.addNewBaseCaseBranch(branchId);
		} catch (Exception e) {
			logger.severe(e.toString());
			return;
		}		
		branchRec.addNewFromBus().setIdRef(fid);
		branchRec.addNewToBus().setIdRef(tid);	
		branchRec.setCircuitId(ckt);
		
		branchRec.setOffLine(status != 1);
		
		LoadflowBranchDataXmlType branchData = branchRec.addNewLoadflowData();	
		branchData.setCode(LFBranchCodeEnumType.LINE);
		
		branchData.setMeterLocation( fromMetered ? BaseBranchDataXmlType.MeterLocation.FROM_SIDE :
										BaseBranchDataXmlType.MeterLocation.TO_SIDE);
      	
		DataSetter.setLineData(branchData, r, x, ZUnitType.PU, 0.0, b, YUnitType.PU);

		DataSetter.setBranchRatingLimitData(branchData,
    				ratea, rateb, ratec, ApparentPowerUnitType.MVA);
        
       if ( gi != 0.0 || bi != 0.0)
    	   DataSetter.setYData(branchData.addNewFromShuntY(), gi, bi, YUnitType.PU);
       if ( gj != 0.0 || bj != 0.0)
    	   DataSetter.setYData(branchData.addNewFromShuntY(), gj, bj, YUnitType.PU);
      
    	ParserHelper.addOwner(branchRec, 
    			new Integer(o1).toString(), f1, 
    			new Integer(o2).toString(), o2==0?0.0:f2, 
    			new Integer(o3).toString(), o3==0?0.0:f3, 
    			new Integer(o4).toString(), o4==0?0.0:f4);
	}		
}
