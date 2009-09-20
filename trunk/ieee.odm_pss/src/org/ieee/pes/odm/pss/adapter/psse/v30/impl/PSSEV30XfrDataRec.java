 /*
  * @(#)PSSEGenDataRec.java   
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
  * @Author Mike Zhou
  * @Version 1.0
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.ieee.pes.odm.pss.adapter.psse.v30.impl;

import java.util.StringTokenizer;
import java.util.logging.Logger;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AdjustmentDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AngleAdjustmentXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AngleUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ApparentPowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BaseBranchDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BranchRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LFBranchCodeEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBranchDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TapAdjustmentXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.YUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TapAdjustmentXmlType.AdjustmentType;
import org.ieee.pes.odm.pss.adapter.psse.v30.PSSEV30Adapter.VersionNo;
import org.ieee.pes.odm.pss.model.DataSetter;
import org.ieee.pes.odm.pss.model.ODMModelParser;
import org.ieee.pes.odm.pss.model.ParserHelper;
import org.ieee.pes.odm.pss.model.StringUtil;

public class PSSEV30XfrDataRec {
	/*
	 * XfrData For 2W Xfr:
	 * 		I,J,K,CKT,CW,CZ,CM,MAG1,MAG2,NMETR,’NAME’,STAT,O1,F1,...,O4,F4
	 * 		R1-2,X1-2,SBASE1-2
	 * 		WINDV1,NOMV1,ANG1,RATA1,RATB1,RATC1,COD,CONT,RMA,RMI,VMA,VMI,NTP,TAB,CR,CX
	 * 		WINDV2,NOMV2
	 * 
	 * Three-winding:
			I,J,K,CKT,CW,CZ,CM,MAG1,MAG2,NMETR,’NAME’,STAT,O1,F1,...,O4,F4
			R1-2,X1-2,SBASE1-2,R2-3,X2-3,SBASE2-3,R3-1,X3-1,SBASE3-1,VMSTAR,ANSTAR
			WINDV1,NOMV1,ANG1,RATA1,RATB1,RATC1,COD,CONT,RMA,RMI,VMA,VMI,NTP,TAB,CR,CX
			WINDV2,NOMV2,ANG2,RATA2,RATB2,RATC2
			WINDV3,NOMV3,ANG3,RATA3,RATB3,RATC3
	 */

	public static void procLine(String lineStr1, String lineStr2, String lineStr3, String lineStr4, String lineStr5, 
									VersionNo version, ODMModelParser parser, Logger logger) {
		int i, j, k, cw, cz, cm, stat, nmetr;
		String ckt, name;
		double mag1, mag2;
		int o1 = 0, o2 = 0, o3 = 0, o4 = 0;
		double f1 = 0.0, f2 = 0.0, f3 = 0.0, f4 = 0.0;
		double r1_2, x1_2, sbase1_2, r2_3, x2_3, sbase2_3, r3_1, x3_1, sbase3_1, vmstar, anstar;
		int cod, cont, ntp, tab;
		double windv1, nomv1, windv2, nomv2, windv3, nomv3;
		double rma, rmi, vma, vmi, cr, cx;
		double ang1, rata1, ratb1, ratc1, ang2, rata2, ratb2, ratc2, ang3, rata3, ratb3, ratc3;

		// 324558,324023,     0,'1 ',2,2,1,   0.00036,  -0.00197,1,'HFL- 1,2    ',1,   1,1.0000
		// The name field might have ','
		StringTokenizer st = new StringTokenizer(lineStr1, "'");
		String s1 = st.nextToken();  // 324558,324023,     0, 
		String s2 = st.nextToken();  // 1 
		String s3 = st.nextToken();  // ,2,2,1,   0.00036,  -0.00197,1, 
		String s4 = st.nextToken();  // HFL- 1,2    
		String s5 = st.nextToken();  // ,1,   1,1.0000 
		
		st = new StringTokenizer(s1, ",");
		i = new Integer(st.nextToken().trim()).intValue();
		j = new Integer(st.nextToken().trim()).intValue();
		k = new Integer(st.nextToken().trim()).intValue();

		ckt = s2.trim();

		st = new StringTokenizer(s3, ",");
		cw = new Integer(st.nextToken().trim()).intValue();
		cz = new Integer(st.nextToken().trim()).intValue();
		cm = new Integer(st.nextToken().trim()).intValue();
		mag1 = new Double(st.nextToken().trim()).doubleValue();
		mag2 = new Double(st.nextToken().trim()).doubleValue();
		nmetr = new Integer(st.nextToken().trim()).intValue();

		name = s4;

		st = new StringTokenizer(s5, ",");
		stat = new Integer(st.nextToken().trim()).intValue();

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

		st = new StringTokenizer(lineStr2, ",");
		r1_2 = new Double(st.nextToken().trim()).doubleValue();
		x1_2 = new Double(st.nextToken().trim()).doubleValue();
		sbase1_2 = new Double(st.nextToken().trim()).doubleValue();
		if (k != 0) {
			r2_3 = new Double(st.nextToken().trim()).doubleValue();
			x2_3 = new Double(st.nextToken().trim()).doubleValue();
			sbase2_3 = new Double(st.nextToken().trim()).doubleValue();
			r3_1 = new Double(st.nextToken().trim()).doubleValue();
			x3_1 = new Double(st.nextToken().trim()).doubleValue();
			sbase3_1 = new Double(st.nextToken().trim()).doubleValue();
			vmstar = new Double(st.nextToken().trim()).doubleValue();
			anstar  = new Double(st.nextToken().trim()).doubleValue();
		}

		st = new StringTokenizer(lineStr3, ",");
		windv1 = new Double(st.nextToken().trim()).doubleValue();
		nomv1 = new Double(st.nextToken().trim()).doubleValue();
		ang1 = new Double(st.nextToken().trim()).doubleValue();
		rata1 = new Double(st.nextToken().trim()).doubleValue();
		ratb1 = new Double(st.nextToken().trim()).doubleValue();
		ratc1 = new Double(st.nextToken().trim()).doubleValue();
		cod = new Integer(st.nextToken().trim()).intValue();
		cont = new Integer(st.nextToken().trim()).intValue();
		rma = new Double(st.nextToken().trim()).doubleValue();
		rmi = new Double(st.nextToken().trim()).doubleValue();
		vma = new Double(st.nextToken().trim()).doubleValue();
		vmi = new Double(st.nextToken().trim()).doubleValue();
		ntp = new Integer(st.nextToken().trim()).intValue();
		tab = new Integer(st.nextToken().trim()).intValue();
		cr = new Double(st.nextToken().trim()).doubleValue();
		cx = new Double(st.nextToken().trim()).doubleValue();

		st = new StringTokenizer(lineStr4, ",");
		windv2 = new Double(st.nextToken().trim()).doubleValue();
		nomv2 = new Double(st.nextToken().trim()).doubleValue();
		if (k != 0) {
			ang2 = new Double(st.nextToken().trim()).doubleValue();
			rata2 = new Double(st.nextToken().trim()).doubleValue();
			ratb2 = new Double(st.nextToken().trim()).doubleValue();
			ratc2 = new Double(st.nextToken().trim()).doubleValue();
		}

		if (k != 0) {
			windv3 = new Double(st.nextToken().trim()).doubleValue();
			nomv3 = new Double(st.nextToken().trim()).doubleValue();
			ang3 = new Double(st.nextToken().trim()).doubleValue();
			rata3 = new Double(st.nextToken().trim()).doubleValue();
			ratb3 = new Double(st.nextToken().trim()).doubleValue();
			ratc3 = new Double(st.nextToken().trim()).doubleValue();
		}
/*
	    Line-1 For 2W and 3W Xfr: I,J,K,CKT,CW,CZ,CM,MAG1,MAG2,NMETR,’NAME’,STAT,O1,F1,...,O4,F4
*/
		if (k == 0) {
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
    		
    		branchRec.setName(name);
    		branchRec.setOffLine(stat != 1);
    		
	      	LoadflowBranchDataXmlType branchData = branchRec.addNewLoadflowData();	
			branchData.setCode(LFBranchCodeEnumType.TRANSFORMER);
			
			branchData.setMeterLocation( nmetr==1 ? BaseBranchDataXmlType.MeterLocation.FROM_SIDE :
				BaseBranchDataXmlType.MeterLocation.TO_SIDE);

			/*
			CM - The magnetizing admittance I/O code that defines the units in which MAG1
				and MAG2 are specified: 1 for complex admittance in pu on system MVA base
				and winding one bus voltage base; 2 for no load loss in watts and exciting current
				in pu on winding one to two base MVA and winding one nominal voltage.
				CM = 1 by default.
			MAG1, MAG2 The magnetizing conductance and susceptance, respectively, in pu on system
				MVA base and winding one bus voltage base when CM is 1; MAG1 is the no
				load loss in watts and MAG2 is the exciting current in pu on winding one to
				two base MVA (SBASE1-2) and winding one nominal voltage (NOMV1)
				when CM is 2. MAG1 = 0.0 and MAG2 = 0.0 by default. For three-phase transformers
				or three-phase banks of single phase transformers, the three-phase noload
				loss should be entered.
				When CM is 1 and a non-zero MAG2 is specified, MAG2 should be entered as
				a negative quantity; when CM is 2 and a non-zero MAG2 is specified, MAG2
				should always be entered as a positive quantity.
	    	 */
		
		
	    	if (cm == 1) {
	    		if (mag1 != 0.0 || mag2 != 0.0)
	    			DataSetter.setYData(branchData.addNewFromShuntY(), mag1, mag2, YUnitType.PU);
	    	}
	    	else {
	    		logger.severe("PEES Xfr cm != 1, not implemented");
	    	}
	      	
	    	// sample data 1,1.0000,   0,1.0000,   0,1.0000,   0,1.0000
	    	// owner id = 0.0, no contribution
	    	ParserHelper.addOwner(branchRec, 
	    			new Integer(o1).toString(), f1, 
	    			new Integer(o2).toString(), o2==0?0.0:f2, 
	    			new Integer(o3).toString(), o3==0?0.0:f3, 
	    			new Integer(o4).toString(), o4==0?0.0:f4);
		
	    	/*
	       		Line-2 format : R1-2,X1-2,SBASE1-2
	    	*/

	       	LoadflowBranchDataXmlType.XfrInfo xfrInfo = branchData.addNewXfrInfo();
	       	
	       	DataSetter.setPowerMva(xfrInfo.addNewRatedPower(), sbase1_2);
	       	
	       	if (cz == 1) {
	       		// When CZ is 1, they are the resistance and reactance, respectively, in pu on 
	       		// system base quantities; 
	        	DataSetter.setZValue(branchData.addNewZ(), r1_2, x1_2, ZUnitType.PU);
	        	xfrInfo.setDataOnSystemBase(true);
	       	}
	       	else if (cz == 2) {
	       		// when CZ is 2, they are the resistance and reactance, respectively, in pu on 
	       		// winding one to two base MVA (SBASE1-2) and winding one bus base voltage; 
	        	DataSetter.setZValue(branchData.addNewZ(), r1_2, x1_2, ZUnitType.PU);
	        	xfrInfo.setDataOnSystemBase(false);
	       	}
	       	else if (cz == 3) {
	       		// when CZ is 3, R1-2 is the load loss in watts, and X1-2 is the impedance magnitude 
	       		// in pu on winding one to two base MVA (SBASE1-2) and winding one bus base voltage.
	       		double zpu = x1_2;
	       		double rpu = r1_2 / sbase1_2;  
	        	DataSetter.setZValue(branchData.addNewZ(), rpu, Math.sqrt(zpu*zpu - rpu*rpu), ZUnitType.PU);
	        	xfrInfo.setDataOnSystemBase(true);
	       	}
			      	
	    	/*
    		 Line -3 format : WINDV1,NOMV1,ANG1,RATA1,RATB1,RATC1,COD,CONT,RMA,RMI,VMA,VMI,NTP,TAB,CR,CX
	    	 */
	  		
	  		if (cw == 1) {
	       		// The winding one off-nominal turns ratio in pu of winding one bus base voltage
	       		// when CW is 1; WINDV1 is 1.0 by default. 
	        	xfrInfo.setDataOnSystemBase(true);
	       	}
	       	else if (cw == 2) {
	       		// WINDV1 is the actual winding one voltage in kV when CW is 2; 
	        	xfrInfo.setDataOnSystemBase(false);
	       	}
	  		
	       	DataSetter.setTapPU(branchData.addNewFromTap(), windv1);
		
        	if ( ang1 != 0.0 || cod == 3 || cod == -3) {
        		// PhaseShifting transformer branch
    			branchData.setCode(LFBranchCodeEnumType.PHASE_SHIFT_XFORMER);
        		DataSetter.setAngleData(branchData.addNewFromAngle(), ang1, AngleUnitType.DEG);
        	}
	      	
    		DataSetter.setBranchRatingLimitData(branchData, rata1, ratb1, ratc1, ApparentPowerUnitType.MVA);
			
    		/*
    		 * The transformer control mode for automatic adjustments of the winding one
				tap or phase shift angle during power flow solutions: 0 for no control (fixed tap
				and phase shift); 
				±1 for voltage control; 
				±2 for reactive power flow control; 
				±3 for active power flow control; 
				±4 for control of a dc line quantity (+4 is valid only for two-winding transformers). 
				
				If the control mode is entered as a positive
				number, automatic adjustment of this transformer winding is enabled when the
				corresponding adjustment is activated during power flow solutions;
				 
				a negative control mode suppresses the automatic adjustment of this transformer winding.
				COD1 = 0 by default.

			If CONT is entered as a positive number, or a quoted extended bus name, the ratio is
				adjusted as if bus CONT is on the winding two or winding three side of the
				transformer; if CONT is entered as a negative number, or a quoted extended
				bus name with a minus sign preceding the first character, the ratio is adjusted
				as if bus |CONT| is on the winding one side of the transformer.
          	 */
		
          	boolean onFromSide = false;
          	if (cont < 0) {
          		cont = -cont;
          		onFromSide = true;
          	}
          	
          	String reBusId = ODMModelParser.BusIdPreFix+cont;
          	
    		// COD1,CONT1,RMA,RMI,VMA,VMI,NTP,TAB, 
    		//Sample data : 1,    31, 1.10000, 0.90000, 1.09255, 1.04255, 33, 0, 0.00000, 0.00000
          	/*
            RMA1, RMI1 The upper and lower limits, respectively, of either:
					• Off-nominal turns ratio in pu of winding one bus base voltage when
						|COD1| is 1 or 2 and CW is 1; RMA1 = 1.1 and RMI1 = 0.9 by default.
					• Actual winding one voltage in kV when |COD1| is 1 or 2 and CW is 2. No
						default is allowed.
					• Phase shift angle in degrees when |COD1| is 3. No default is allowed.
					• Not used when |COD1| is 0 or 4; RMA1 = 1.1 and RMI1 = 0.9 by default.
			VMA1, VMI1 The upper and lower limits, respectively, of either:
					• Voltage at the controlled bus (bus |CONT1|) in pu when |COD1| is 1.
						VMA1 = 1.1 and VMI1 = 0.9 by default.
					• Reactive power flow into the transformer at the winding one bus end in
						Mvar when |COD1| is 2. No default is allowed.
					• Active power flow into the transformer at the winding one bus end in MW
						when |COD1| is 3. No default is allowed.
					• Not used when |COD1| is 0 or 4; VMA1 = 1.1 and VMI1 = 0.9 by default.
			NTP1 The number of tap positions available; used when COD1 is 1 or 2. NTP1 must be
					between 2 and 9999. NTP1 = 33 by default.
          	 */
          	if (cod > 0) {
              	if (branchData.getCode() == LFBranchCodeEnumType.TRANSFORMER) {
               		TapAdjustmentXmlType tapAdj = branchData.addNewTapAdjustment();
               		tapAdj.setOffLine(cod < 0);
               		tapAdj.setTapAdjOnFromSide(onFromSide);
        	    	DataSetter.setTapLimitData(tapAdj.addNewTapLimit(), rma, rmi);
               		tapAdj.setTapAdjStep(ntp);
               		if (Math.abs(cod) == 1) {
                   		tapAdj.setAdjustmentType(AdjustmentType.VOLTAGE);
            	    	TapAdjustmentXmlType.VoltageAdjData vAdjData = tapAdj.addNewVoltageAdjData();
            	    	vAdjData.setMode(AdjustmentDataXmlType.Mode.RANGE_ADJUSTMENT);
            	    	vAdjData.setMax(vma);
            	    	vAdjData.setMin(vmi);       
            	    }
               		else {
                     	tapAdj.setAdjustmentType(AdjustmentType.M_VAR_FLOW);
            	    	TapAdjustmentXmlType.MvarFlowAdjData mvaAdjData = tapAdj.addNewMvarFlowAdjData();
            	    	mvaAdjData.setMode(AdjustmentDataXmlType.Mode.RANGE_ADJUSTMENT);
            	    	mvaAdjData.setMax(vma);
            	    	mvaAdjData.setMin(vmi);               		
               		}
              	}
        	    else if (branchData.getCode() == LFBranchCodeEnumType.PHASE_SHIFT_XFORMER) {
        	    	AngleAdjustmentXmlType angAdj = branchData.addNewAngleAdjustment();
        	    	DataSetter.setAngleLimitData(angAdj.addNewAngleLimit(), rma, rmi, AngleUnitType.DEG);
        	    	angAdj.setMax(vma);
        	    	angAdj.setMin(vmi);
        	    	angAdj.setMode(AdjustmentDataXmlType.Mode.RANGE_ADJUSTMENT);
        	    	angAdj.setDesiredMeasuredOnFromSide(onFromSide);
        	    }              	
          	}
          	
          	/*
          	 * CR1, CX1 - The load drop compensation impedance for voltage controlling transformers
							entered in pu on system base quantities; used when COD1 is 1.
							CR1 + j CX1 = 0.0 by default
          	 */
          	if (cr != 0.0 || cx != 0.0) {
          		if (branchData.getNvPairList() == null)
          			branchData.addNewNvPairList();
          		ParserHelper.addNVPair(branchData.getNvPairList(), "Xfr LoadDropCZ", new Double(cr).toString() + "," + new Double(cx).toString());
          	}

          	/*
          	 	TAB1 The number of a transformer impedance correction table if this transformer
					winding’s impedance is to be a function of either off-nominal turns ratio or
					phase shift angle (see Section 4.1.1.11), or 0 if no transformer impedance correction
					is to be applied to this transformer winding. TAB1 = 0 by default.					

          	 */
          	if (tab > 0)
          		xfrInfo.setZTableNumber(tab);
          	
	  		/*
			Line-4 format : WINDV2,NOMV2
				WINDV2 The winding two off-nominal turns ratio in pu of winding two bus base voltage
						when CW is 1; WINDV2 = 1.0 by default. WINDV2 is the actual winding two
						voltage in kV when CW is 2; WINDV2 is equal to the base voltage of bus J by
						default.	
				NOMV2 The nominal (rated) winding two voltage in kV, or zero to indicate that nominal
						winding two voltage is to be taken as the base voltage of bus J. NOMV2
						is present for information purposes only; it is not used in any of the calculations
						for modeling the transformer. NOMV2 = 0.0 by default.								
	  		 */
	       	DataSetter.setTapPU(branchData.addNewToTap(), windv2);
		}
/*  3W Xfr
		else {
			//IpssLogger.getLogger().warning("*****3W-Xfr->" + toString());
			/*
			Three-winding:
			I,J,K,CKT,CW,CZ,CM,MAG1,MAG2,NMETR,’NAME’,STAT,O1,F1,...,O4,F4
			R1-2,X1-2,SBASE1-2,R2-3,X2-3,SBASE2-3,R3-1,X3-1,SBASE3-1,VMSTAR,ANSTAR
			WINDV1,NOMV1,ANG1,RATA1,RATB1,RATC1,COD,CONT,RMA,RMI,VMA,VMI,NTP,TAB,CR,CX
			WINDV2,NOMV2,ANG2,RATA2,RATB2,RATC2
			WINDV3,NOMV3,ANG3,RATA3,RATB3,RATC3
			 */
		
		/*
	      	final PSSEAclf3WXfr bra = ExtensionObjectFactory.createPSSEAclf3WXfr(this.ckt);
	      	bra.setName(this.name);
	      	bra.setStatus(this.stat ==1);
	      	bra.setFromMetered(this.nmetr==1);
	      	
			String iStr = new Integer(this.i).toString();
			String jStr = new Integer(this.j).toString();
			String kStr = new Integer(this.k).toString();
	      	adjNet.add3WXfrBranch(bra, iStr, jStr, kStr);
    	 	bra.setBranchCode(AclfBranchCode.W3_XFORMER);
    	 	
			bra.getOwnerList().add(ExtensionObjectFactory.createPSSEOwner(this.o1, this.f1));
			bra.getOwnerList().add(ExtensionObjectFactory.createPSSEOwner(this.o2, this.f2));
			bra.getOwnerList().add(ExtensionObjectFactory.createPSSEOwner(this.o3, this.f3));
			bra.getOwnerList().add(ExtensionObjectFactory.createPSSEOwner(this.o4, this.f4));    	 	
    	 	
	       	bra.setMvaRating1_2(this.sbase1_2);
	       	bra.setMvaRating2_3(this.sbase2_3);
	       	bra.setMvaRating3_1(this.sbase3_1);

	       	bra.create2WBranches();
	       	XfrAdapter fromXfr = (XfrAdapter)bra.getFromBranch().getAdapter(XfrAdapter.class);
	    	if (this.cm == 1) {
	    		fromXfr.setFromShuntY(new Complex(this.mag1, this.mag2), UnitType.PU, adjNet.getBaseKva());
	    	}
	    	else {
	    		IpssLogger.getLogger().severe("PEES Xfr cm != 1, not implemented");
	    	}

        	double rpu1_2=0.0, xpu1_2=0.0;
        	double rpu2_3=0.0, xpu2_3=0.0;
        	double rpu3_1=0.0, xpu3_1=0.0;
	       	if (this.cz == 1) {
	       		// When CZ is 1, they are the resistance and reactance, respectively, in pu on 
	       		// system base quantities; 
	        	rpu1_2 = this.r1_2;   xpu1_2 = this.x1_2;
	        	rpu2_3 = this.r2_3;   xpu2_3 = this.x2_3;
	        	rpu3_1 = this.r3_1;   xpu3_1 = this.x3_1;
	       	}
	       	else if (this.cz == 2) {
	       		// when CZ is 2, they are the resistance and reactance, respectively, in pu on 
	       		// winding one to two base MVA (SBASE1-2) and winding one bus base voltage; 
	       		double factor1_2 = adjNet.getBaseKva() / this.sbase1_2 / 1000.0;
	       		double factor2_3 = adjNet.getBaseKva() / this.sbase2_3 / 1000.0;
	       		double factor3_1 = adjNet.getBaseKva() / this.sbase3_1 / 1000.0;
	        	rpu1_2 = this.r1_2*factor1_2;   xpu1_2 = this.x1_2*factor1_2;
	        	rpu2_3 = this.r2_3*factor3_1;   xpu2_3 = this.x2_3*factor3_1;
	        	rpu3_1 = this.r3_1*factor2_3;   xpu3_1 = this.x3_1*factor2_3;
	       	}
	       	else if (this.cz == 3) {
	       		// when CZ is 3, R1-2 is the load loss in watts, and X1-2 is the impedance magnitude 
	       		// in pu on winding one to two base MVA (SBASE1-2) and winding one bus base voltage.
	       		double zpu = this.x1_2 * this.sbase1_2 * 1000.0 / adjNet.getBaseKva() ;
	       		rpu1_2 = this.r1_2 / 1000.0 / adjNet.getBaseKva();  
	       		xpu1_2 = Math.sqrt(zpu*zpu - rpu1_2*rpu1_2);  

	       		zpu = this.x2_3 * this.sbase1_2 * 1000.0 / adjNet.getBaseKva() ;
	       		rpu2_3 = this.r2_3 / 1000.0 / adjNet.getBaseKva();  
	       		xpu2_3 = Math.sqrt(zpu*zpu - rpu2_3*rpu2_3);  

	       		zpu = this.x3_1 * this.sbase1_2 * 1000.0 / adjNet.getBaseKva() ;
	       		rpu3_1 = this.r3_1 / 1000.0 / adjNet.getBaseKva();  
	       		xpu3_1 = Math.sqrt(zpu*zpu - rpu3_1*rpu3_1);  
	       	}
	       	
	       	bra.setZ(new Complex(rpu3_1, xpu3_1), new Complex(rpu1_2, xpu1_2), new Complex(rpu2_3, xpu2_3));
	       	
	       	double f_ratio = 1.0, t_ratio = 1.0, tert_ratio = 1.0;
	  		if (this.cw == 1) {
	       		// The winding one off-nominal turns ratio in pu of winding one bus base voltage
	       		// when CW is 1; WINDV1 is 1.0 by default. 
	        	f_ratio = this.windv1;
	        	t_ratio = this.windv2;
	        	tert_ratio = this.windv3;
	       	}
	       	else if (this.cw == 2) {
	       		// WINDV1 is the actual winding one voltage in kV when CW is 2; 
	       		f_ratio = this.windv1 * bra.getFromBus().getBaseVoltage() / (this.nomv1*1000.0);
	       		t_ratio = this.windv2 * bra.getToBus().getBaseVoltage() / (this.nomv2*1000.0);
	       		tert_ratio = this.windv3 == 0.0? 1.0 : this.windv3 * bra.getTertiaryBus().getBaseVoltage() / (this.nomv3*1000.0);
	       	}
	       	bra.setFromTap(f_ratio);
	       	bra.setToTap(t_ratio); 	       	
	       	bra.setTertTap(tert_ratio); 	       	

	       	bra.setFromRatedVoltage(this.nomv1*1000.0);
        	bra.setToRatedVoltage(this.nomv2*1000.0);
        	bra.setTertRatedVoltage(this.nomv3*1000.0);
		
        	if (this.ang1 != 0.0 || this.cod == 3 || this.cod == -3) {
        		// PhaseShifting transformer branch
        	 	bra.setBranchCode(AclfBranchCode.PS_XFORMER);
        		final PSXfrAdapter psXfr = (PSXfrAdapter)bra.getFromBranch().getAdapter(PSXfrAdapter.class);
        		psXfr.setFromAngle(Math.toRadians(this.ang1));
        		psXfr.setToAngle(0.0);
        	}
	      	
          	bra.getFromBranch().setRatingMva1(this.rata1);
          	bra.getFromBranch().setRatingMva2(this.ratb1);
          	bra.getFromBranch().setRatingMva3(this.ratc1);
        	
        	if (this.ang2 != 0.0 || this.cod == 3 || this.cod == -3) {
        		// PhaseShifting transformer branch
        	 	bra.setBranchCode(AclfBranchCode.PS_XFORMER);
        		final PSXfrAdapter psXfr = (PSXfrAdapter)bra.getToBranch().getAdapter(PSXfrAdapter.class);
        		psXfr.setToAngle(Math.toRadians(this.ang2));
        		psXfr.setFromAngle(0.0);
        	}
	      	
          	bra.getToBranch().setRatingMva1(this.rata2);
          	bra.getToBranch().setRatingMva2(this.ratb2);
          	bra.getToBranch().setRatingMva3(this.ratc2);
          	
        	if (this.ang3 != 0.0 || this.cod == 3 || this.cod == -3) {
        		// PhaseShifting transformer branch
        	 	bra.setBranchCode(AclfBranchCode.PS_XFORMER);
        		final PSXfrAdapter psXfr = (PSXfrAdapter)bra.getTertiaryBranch().getAdapter(PSXfrAdapter.class);
        		psXfr.setToAngle(Math.toRadians(this.ang3));
        		psXfr.setFromAngle(0.0);
        	}
	      	
          	bra.getTertiaryBranch().setRatingMva1(this.rata3);
          	bra.getTertiaryBranch().setRatingMva2(this.ratb3);
          	bra.getTertiaryBranch().setRatingMva3(this.ratc3);

          	bra.setControlMode(this.cod);

          	
          	/*
			If CONT is entered as a positive number, or a quoted extended bus name, the ratio is
			adjusted as if bus CONT is on the winding two or winding three side of the
			transformer; if CONT is entered as a negative number, or a quoted extended
			bus name with a minus sign preceding the first character, the ratio is adjusted
			as if bus |CONT| is on the winding one side of the transformer.
          	 */
		/*
          	boolean onFromSide = false;
          	if (this.cont < 0) {
          		this.cont = -this.cont;
          		onFromSide = true;
          	}
          	bra.setContBusId(new Integer(this.cont).toString());
          	bra.setControlOnFromSide(onFromSide);
          	
          	// tap adjust is always at the from side
          	double factor = 1.0;
	       	if (this.cz == 2 && this.nomv1 > 0)
	       		factor = bra.getFromBus().getBaseVoltage() / (this.nomv1*1000.0);
          	bra.setRmLimit(new LimitType(this.rma*factor, this.rmi*factor)); 
          	bra.setVmLimit(new LimitType(this.vma*factor, this.vmi*factor)); 
          	bra.setAdjSteps(this.ntp);
          	
          	bra.setLoadDropCZ(new Complex(this.cr,this.cx));
          	
          	bra.setXfrTableIdNumber(this.tab);
		}
	*/
	}	
}
