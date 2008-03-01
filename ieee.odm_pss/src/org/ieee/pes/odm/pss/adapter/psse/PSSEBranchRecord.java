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
package org.ieee.pes.odm.pss.adapter.psse;

import java.util.StringTokenizer;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AdjustmentDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AngleXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BranchRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBranchDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PhaseShiftXfrDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TransformerDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.YXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZXmlType;
import org.ieee.pes.odm.pss.model.ODMData2XmlHelper;

public class PSSEBranchRecord {
	public static  void processLineData(final String str, final BranchRecordXmlType branchRec, PSSEAdapter adapter) {
		//I,J,CKT,R,X,B,RATEA,RATEB,RATEC,GI,BI,GJ,BJ,ST,LEN,O1,F1,...,O4,F4
		
		// parse the input data line	
		final String[] strAry = getLineDataFields(str);		
		final String fid = PSSEAdapter.Token_Id+strAry[0];
		final String tid = PSSEAdapter.Token_Id+strAry[1];
		adapter.getLogger().fine("Branch data loaded, from-id, to-id: " + fid + ", " + tid);
		branchRec.addNewFromBus().setIdRef(fid);
		branchRec.addNewToBus().setIdRef(tid);	
		
		final String cirId = strAry[2];
		branchRec.setCircuitId(cirId);
		branchRec.setId(ODMData2XmlHelper.formBranchId(fid, tid, cirId));
		
		LoadflowBranchDataXmlType branchData=branchRec.addNewLoadflowBranchData();	
		
        //      Branch resistance R, per unit  *
		//      Branch reactance X, per unit  * No zero impedance lines
		//    	Line charging B, per unit  * (total line charging, +B), Xfr B is negative
		final double rpu = new Double(strAry[3]).doubleValue();
		final double xpu = new Double(strAry[4]).doubleValue();
		final double bpu = new Double(strAry[5]).doubleValue();
		
		// TODO: BJ,ST,LEN,O1,F1,...,O4,F4 are missing
		
		ODMData2XmlHelper.setLineData(branchData, rpu, xpu,	ZXmlType.Unit.PU, 0.0, bpu, YXmlType.Unit.PU);
		
		//      Line MVA rating No 1 
		//    	Line MVA rating No 2 
		//      Line MVA rating No 3
		final double rating1Mvar = new Double(strAry[6]).doubleValue();
		final double rating2Mvar = new Double(strAry[7]).doubleValue();
		final double rating3Mvar = new Double(strAry[8]).doubleValue();
		
		ODMData2XmlHelper.setBranchRatingLimitData(branchData,
				rating1Mvar, rating2Mvar, rating3Mvar,
				LoadflowBranchDataXmlType.RatingLimit.MvaRatingUnit.MVA, 0.0,
				null);
		
		//From side shuntY
		final double GI= new Double(strAry[9]).doubleValue();
		final double BI= new Double(strAry[10]).doubleValue();
        if(GI!=0.0 || BI!=0.0 )  { 
        	ODMData2XmlHelper.setYData(branchData.getLineData().addNewFromShuntY(),
        				GI, BI, YXmlType.Unit.PU);
        }

	    //To side shuntY
		final double GJ= new Double(strAry[11]).doubleValue();
		final double BJ= new Double(strAry[12]).doubleValue();
	    if(GJ!=0.0 || BJ!=0.0)  {
        	ODMData2XmlHelper.setYData(branchData.getLineData().addNewToShuntY(),
    				GJ, BJ, YXmlType.Unit.PU);
	    }
	}
   
	public static  void processXformerData(final String str,final String str2,final String str3,
			final String str4,final BranchRecordXmlType branchRec, PSSNetworkXmlType baseCaseNet, PSSEAdapter adapter) {
		 final String[] strAry = getXformerDataFields(str,str2,str3,str4);
/*
	The five record transformer data block for three-winding transformers has the following format:
		I,J,K,CKT,CW,CZ,CM,MAG1,MAG2,NMETR,’NAME’,STAT,O1,F1,...,O4,F4
		R1-2,X1-2,SBASE1-2,R2-3,X2-3,SBASE2-3,R3-1,X3-1,SBASE3-1,VMSTAR,ANSTAR
		WINDV1,NOMV1,ANG1,RATA1,RATB1,RATC1,COD,CONT,RMA,RMI,VMA,VMI,NTP,TAB,CR,CX
		WINDV2,NOMV2,ANG2,RATA2,RATB2,RATC2
		WINDV3,NOMV3,ANG3,RATA3,RATB3,RATC3

	The four-record transformer data block for two-winding transformers is a subset of the data required
	for three-winding transformers and has the following format:

		I,J,K,CKT,CW,CZ,CM,MAG1,MAG2,NMETR,’NAME’,STAT,O1,F1,...,O4,F4
		R1-2,X1-2,SBASE1-2
		WINDV1,NOMV1,ANG1,RATA1,RATB1,RATC1,COD,CONT,RMA,RMI,VMA,VMI,NTP,TAB,CR,CX
		WINDV2,NOMV2
*/
		 
		 //from ID ,to ID		
		final String fid = strAry[0];
		final String tid = strAry[1];
		adapter.getLogger().fine("Branch data loaded, from-id, to-id: " + fid + ", " + tid);
		branchRec.addNewFromBus().setIdRef(fid);
		branchRec.addNewToBus().setIdRef(tid);
		final String cirId = "1";
		branchRec.setCircuitId(cirId);		
		
		branchRec.setId(ODMData2XmlHelper.formBranchId(fid, tid, cirId));
		branchRec.addNewLoadflowBranchData();
		
		//get r x b
		final int CZ = new Integer(strAry[5]).intValue();	
		
		double rpu1_2 = new Double(strAry[20]).doubleValue();
	    double xpu1_2 = new Double(strAry[21]).doubleValue();
	   
		final double SBASE1_2 = new Double(strAry[22]).doubleValue();

		//r x value in p.u based on system base quantities

		//r x value in P.U based on a specified base and winding bus base voltage
		/* CZ=3 for transformer load loss in watts and impedance magnitude 
		in pu on a specified base MVA and winding bus base	voltage.	
            */	
		//CM=1  for complex admittance in pu on system base quantities
		double factor = baseCaseNet.getBasePower() / SBASE1_2 / 1000.0;
		double rpu = 0.0;
		double xpu = 0.0;
		if(CZ==1){
			rpu = rpu1_2;
			xpu = xpu1_2;
		}else if(CZ==2){
			rpu = rpu1_2*factor;
			xpu = xpu1_2*factor;
		}else {
			adapter.logErr("CZ=3 needs to be implemented");
			return;
		}
		
	 	final int CM =new Integer(strAry[6]).intValue();
        final double MAG1 = new Double(strAry[7]).doubleValue();
        final double MAG2 = new Double(strAry[8]).doubleValue();	
        double gpu =0.0, bpu= 0.0;
        
       if (CM ==1){
    	   gpu = MAG1;
    	   bpu = MAG2;
       }else {
    	   adapter.logErr("MAG1 AND MAG2 NEEDS TO BE IMPLEMENTED WHEN CM!=1");
    	   return;
       }	
		//SET XFORMER R X G B 
       ODMData2XmlHelper.setXformerData(branchRec.getLoadflowBranchData(),
			       rpu, xpu, ZXmlType.Unit.PU, gpu, bpu, 0.0, 0.0,	YXmlType.Unit.PU);		
		
		int CW = new Integer(strAry[4]).intValue();
		double WINDV1 = new Double(strAry[23]).doubleValue();
		double WINDV2 = new Double(strAry[38]).doubleValue();
        //from side ratio and to bus side ratio
		double f_ratio = 1.0, t_ratio=1.0;
		BusRecordXmlType fromBusRec = ODMData2XmlHelper.getBusRecord(fid, baseCaseNet);
		BusRecordXmlType toBusRec = ODMData2XmlHelper.getBusRecord(tid, baseCaseNet);	
		// The winding one off-nominal turns ratio in pu of winding one bus base voltage when CW is 1;
		if (CW==1){
        	f_ratio = WINDV1;
        	t_ratio = WINDV2;
		}
		//WINDV1 is the actual winding one 	voltage in kV when CW is 2
		if (CW==2){
		   final double systemBaseV =fromBusRec.getBaseVoltage().getVoltage();
			f_ratio = WINDV1*1000.0 / systemBaseV;
       		t_ratio = WINDV2*1000.0 /systemBaseV;
		}
		branchRec.getLoadflowBranchData().getXformerData()
		.setFromTurnRatio(f_ratio);
		branchRec.getLoadflowBranchData().getXformerData()
		.setFromTurnRatio(t_ratio);
		
		//     MVA rating No 1 
		//    MVA rating No 2
		//    	  Line MVA rating No 3 
		final double rating1Mvar = new Double(strAry[26]).doubleValue();
		final double rating2Mvar = new Double(strAry[27]).doubleValue();
		final double rating3Mvar = new Double(strAry[28]).doubleValue();
		ODMData2XmlHelper.setBranchRatingLimitData(branchRec.getLoadflowBranchData(),
				rating1Mvar, rating2Mvar, rating3Mvar,
				LoadflowBranchDataXmlType.RatingLimit.MvaRatingUnit.MVA, 0.0,
				null);
		
		final double NOMV1 = new Double(strAry[23]).doubleValue();
		final double NOMV2 = new Double(strAry[38]).doubleValue();

		//set rating limit data
		double fromRatedV,toRatedV;		
		if (NOMV1==0){
			fromRatedV =fromBusRec.getBaseVoltage().getVoltage();
		}
		else {	fromRatedV = NOMV1;		}
		if (NOMV2==0){
			toRatedV =toBusRec.getBaseVoltage().getVoltage();
		}
		else { toRatedV = NOMV2;     	}
		
		VoltageXmlType.Unit.Enum vUnit =fromBusRec.getBaseVoltage().getUnit();
		if(NOMV1==0 && NOMV2==0){vUnit=VoltageXmlType.Unit.KV;}
		ODMData2XmlHelper.setXfrRatingData(branchRec.getLoadflowBranchData().getXformerData(),
				fromRatedV, toRatedV, vUnit);	
		
		
		
		double ANG1 = new Double(strAry[25]).intValue();
		final int COD = new Integer(strAry[29]).intValue();
		
		int CONT = new Integer(strAry[30]).intValue();
		double RMA = new Double(strAry[31]).intValue();
  		double RMI = new Double(strAry[32]).intValue();
  		double VMA = new Double(strAry[33]).intValue();
  		double VMI = new Double(strAry[34]).intValue();
  		int NTP = new Integer(strAry[35]).intValue();
  		//int TAB = new Integer(strAry[36]).intValue();
     	//	double CR = new Double(strAry[37]).intValue();
  		//double CX = new Double(strAry[38]).intValue();
  		
  		if (ANG1 != 0.0 || COD == 3 || COD == -3){
   			ODMData2XmlHelper.setPhaseShiftXfrData(branchRec
					.getLoadflowBranchData(), rpu, xpu, ZXmlType.Unit.PU,
					0.0, bpu, 0.0, 0.0, YXmlType.Unit.PU);
			branchRec.getLoadflowBranchData().getPhaseShiftXfrData()
					.setFromTurnRatio(f_ratio);
			ODMData2XmlHelper.setAngleData(branchRec.getLoadflowBranchData()
					.getPhaseShiftXfrData().addNewFromAngle(), ANG1,
					AngleXmlType.Unit.DEG);
  			 }
  		
  		//COD=1,voltage control
		String controlBusId = "";
		boolean controlSide =false;
		boolean onFromSide = false;
		double stepSize = 0.0, maxTapAng = 0.0, minTapAng = 0.0, maxVoltPQ = 0.0, minVoltPQ = 0.0;
		
		if (Math.abs(COD) >0 && Math.abs(COD) <4){
			/*
			If CONT is entered as a positive number, or a quoted extended bus name, the ratio is
			adjusted as if bus CONT is on the winding two or winding three side of the
			transformer; if CONT is entered as a negative number, or a quoted extended
			bus name with a minus sign preceding the first character, the ratio is adjusted
			as if bus |CONT| is on the winding one side of the transformer.
	      	 */
          	 
          	if (CONT <0) {
          		CONT = -CONT;
          		onFromSide = true;
          	}
			controlBusId = new Integer(CONT).toString();

          	controlSide = onFromSide;

			//       Step size 
			stepSize = NTP;
            
			/*Off-nominal turns ratio in pu of winding one bus base voltage when |COD|
             is 1 or 2 and CW is 1; RMA = 1.1 and RMI = 0.9 by default.
               Actual winding one voltage in kV when |COD| is 1 or 2 and CW is 2. No
               default is allowed.
               Phase shift angle in degrees when |COD| is 3. No default is allowed.
			*/
			maxTapAng = RMA;
			minTapAng = RMI;
			/*
			 Voltage at the controlled bus (bus |CONT|) in pu when |COD| is 1.
                 Reactive power flow into the transformer at the winding one bus end in
                 Mvar when |COD| is 2. No default is allowed.
                 Active power flow into the transformer at the winding one bus end in MW
               when |COD| is 3. No default is allowed.
			*/

			maxVoltPQ = VMA;
			minVoltPQ = VMI;
		}
		

  		if (Math.abs(COD) ==1 || Math.abs(COD)==2 ) {	
			TransformerDataXmlType.TapAdjustment tapAdj = branchRec.getLoadflowBranchData().getXformerData()
						.addNewTapAdjustment();
	        ODMData2XmlHelper.setLimitData(tapAdj.addNewTapLimit(), maxTapAng,
			minTapAng);
	        tapAdj.setTapAdjStepSize(stepSize);
	        tapAdj.setTapAdjOnFromSide(onFromSide);
  			//voltage control
	        if (Math.abs(COD) ==1){
	    		TransformerDataXmlType.TapAdjustment.VoltageAdjData voltTapAdj = tapAdj.addNewVoltageAdjData();
	    		voltTapAdj.addNewAdjVoltageBus().setIdRef(controlBusId);
	    		voltTapAdj.setAdjBusLocation(controlSide == false ? 
	    				TransformerDataXmlType.TapAdjustment.VoltageAdjData.AdjBusLocation.NEAR_TO_BUS
	    					:  TransformerDataXmlType.TapAdjustment.VoltageAdjData.AdjBusLocation.NEAR_FROM_BUS );
		
	    		voltTapAdj.setMode(AdjustmentDataXmlType.Mode.RANGE_ADJUSTMENT);
	    		ODMData2XmlHelper.setLimitData(voltTapAdj.addNewDesiredRange(),
	    										maxVoltPQ, minVoltPQ);
	        	
	        }
	        //MVAR control
  		    if (Math.abs(COD)  == 2){
				TransformerDataXmlType.TapAdjustment.MvarFlowAdjData mvarTapAdj = tapAdj.addNewMvarFlowAdjData();
				ODMData2XmlHelper.setLimitData(mvarTapAdj.addNewDesiredRange(),
									maxVoltPQ, minVoltPQ);
				mvarTapAdj.setMode(AdjustmentDataXmlType.Mode.RANGE_ADJUSTMENT);
				mvarTapAdj.setMvarMeasuredOnFormSide(onFromSide);
  		    }
  		}
  		    // MW control      phase shifter
  		else if (Math.abs(COD)  == 3){
  			PhaseShiftXfrDataXmlType.AngleAdjustment angAdj = branchRec
				.getLoadflowBranchData().getPhaseShiftXfrData()
				.addNewAngleAdjustment();
  			ODMData2XmlHelper.setLimitData(angAdj.addNewAngleDegLimit(), maxTapAng,
				minTapAng);
  			ODMData2XmlHelper.setLimitData(angAdj.addNewDesiredRange(), maxVoltPQ,
				minVoltPQ);
  			angAdj.setMode(AdjustmentDataXmlType.Mode.RANGE_ADJUSTMENT);
  			angAdj.setDesiredMeasuredOnFromSide(onFromSide);
  		}
	}
	
	private static String[] getLineDataFields(final String lineStr) {
		final String[] strAry = new String[23];

  		StringTokenizer st = new StringTokenizer(lineStr, ",");
		/*
		I,J,CKT,R,X,B,RATEA,RATEB,RATEC,GI,BI,GJ,BJ,ST,LEN,O1,F1,...,O4,F4
        */

  		strAry[0]=st.nextToken().trim();
  		strAry[1]=st.nextToken().trim();
  		strAry[2]=st.nextToken().trim();
  		strAry[3]=st.nextToken().trim();
  		strAry[4]=st.nextToken().trim();
  		strAry[5]=st.nextToken().trim();
  		strAry[6]=st.nextToken().trim();
  		strAry[7]=st.nextToken().trim();
  		strAry[8]=st.nextToken().trim();
  		strAry[9]=st.nextToken().trim();
  		strAry[10]=st.nextToken().trim();
  		strAry[11]=st.nextToken().trim();
  		strAry[12]=st.nextToken().trim();
  		strAry[13]=st.nextToken().trim();
  		strAry[14]=st.nextToken().trim();

        //O1,F1,...,O4,F4
  		
		// O1 = 0, O2 = 0, O3 = 0, O4 = 0;
		// F1 = 0.0, F2 = 0.0, F3 = 0.0, F4 = 0.0;
		strAry[15]="0";
  		strAry[16]="0";
  		strAry[17]="0";
  		strAry[18]="0";
		strAry[19]="0";
  		strAry[20]="0";
		strAry[21]="0";
  		strAry[22]="0";
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
	
	private static String[] getXformerDataFields(final String lineStr,final String lineStr2,
			final String lineStr3,final String lineStr4 ) {
		/*
		For 2W and 3W Xfr: I,J,K,CKT,CW,CZ,CM,MAG1,MAG2,NMETR,Name STAT,O1,F1,...,O4,F4
		 */
		
		final String[] strAry = new String[40];
		StringTokenizer st = new StringTokenizer(lineStr, ",");
 		strAry[0]=st.nextToken().trim();
  		strAry[1]=st.nextToken().trim();
  		strAry[2]=st.nextToken().trim();
  		strAry[3]=st.nextToken().trim();
  		strAry[4]=st.nextToken().trim();
  		strAry[5]=st.nextToken().trim();
  		strAry[6]=st.nextToken().trim();
  		strAry[7]=st.nextToken().trim();
  		strAry[8]=st.nextToken().trim();
  		strAry[9]=st.nextToken().trim();
  		strAry[10]=st.nextToken().trim();
  		strAry[11]=st.nextToken().trim();
  		
  		
        //O1,F1,...,O4,F4
  		
		// O1 = 0, O2 = 0, O3 = 0, O4 = 0;
		// F1 = 0.0, F2 = 0.0, F3 = 0.0, F4 = 0.0;
		strAry[12]="0";
  		strAry[13]="0";
  		strAry[14]="0";
  		strAry[15]="0";
		strAry[16]="0";
  		strAry[17]="0";
		strAry[18]="0";
  		strAry[19]="0";
		if (st.hasMoreTokens()) {
			strAry[12]=st.nextToken().trim();
	  		strAry[13]=st.nextToken().trim();
		}
		if (st.hasMoreTokens()) {
			strAry[14]=st.nextToken().trim();
	  		strAry[15]=st.nextToken().trim();
		}
		if (st.hasMoreTokens()) {
			strAry[16]=st.nextToken().trim();
	  		strAry[17]=st.nextToken().trim();
		}
		if (st.hasMoreTokens()) {
			strAry[18]=st.nextToken().trim();
	  		strAry[19]=st.nextToken().trim();
		}
		
    	/*
   		format : R1-2,X1-2,SBASE1-2
	    */
		StringTokenizer st2 = new StringTokenizer(lineStr2, ",");
  		strAry[20]=st2.nextToken().trim();
  		strAry[21]=st2.nextToken().trim();
  		strAry[22]=st2.nextToken().trim();
		
    	/*
		format : WINDV1,NOMV1,ANG1,RATA1,RATB1,RATC1,COD,CONT,RMA,RMI,VMA,VMI,NTP,TAB,CR,CX
    	 */
  		StringTokenizer st3 = new StringTokenizer(lineStr3, ",");
  		strAry[23]=st3.nextToken().trim();
  		strAry[24]=st3.nextToken().trim();
  		strAry[25]=st3.nextToken().trim();
  		strAry[26]=st3.nextToken().trim();
  		strAry[27]=st3.nextToken().trim();
  		strAry[28]=st3.nextToken().trim();
  		strAry[29]=st3.nextToken().trim();
  		strAry[30]=st3.nextToken().trim();
  		strAry[31]=st3.nextToken().trim();
  		strAry[32]=st3.nextToken().trim();
  		strAry[33]=st3.nextToken().trim();
  		strAry[34]=st3.nextToken().trim();
  		strAry[35]=st3.nextToken().trim();
  		strAry[36]=st3.nextToken().trim();
  		strAry[37]=st3.nextToken().trim();
  		
  		/*
		format : WINDV2,NOMV2
  		 */
  		StringTokenizer st4 = new StringTokenizer(lineStr4, ",");
  		strAry[38]=st4.nextToken().trim();
  		strAry[39]=st4.nextToken().trim();
  		
		
		return strAry;
	}
}
