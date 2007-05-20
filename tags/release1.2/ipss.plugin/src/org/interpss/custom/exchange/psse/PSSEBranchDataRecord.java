 /*
  * @(#)BranchDataRecord.java   
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

package org.interpss.custom.exchange.psse;

import org.interpss.custom.exchange.psse.aclf.PSSELine;
import org.interpss.custom.exchange.psse.aclf.PSSEXformer;

import java.util.StringTokenizer;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.datatype.Constants;
import com.interpss.common.datatype.LimitType;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.aclf.AclfBranchCode;
import com.interpss.core.aclf.LineAdapter;
import com.interpss.core.aclf.PSXfrAdapter;
import com.interpss.core.aclf.XfrAdapter;
import com.interpss.core.aclfadj.AclfAdjNetwork;

public class PSSEBranchDataRecord {
	/** 
	 * Process branch record lines
	 *
	 * @param adjNet the AclfAdjNetwork object
	 * @param lineStr a input line string
	 * @param lineNo the line number
	 * @param msgHub the message hub object
	 */
	public static void processLine(
				AclfAdjNetwork adjNet, 
				String lineStr,
				int lineNo, 
				IPSSMsgHub msg) throws Exception {
/*
		I,J,CKT,R,X,B,RATEA,RATEB,RATEC,GI,BI,GJ,BJ,ST,LEN,O1,F1,...,O4,F4
*/
  		StringTokenizer st = new StringTokenizer(lineStr, ",");
		int I  = new Integer(st.nextToken().trim()).intValue();
		int J  = new Integer(st.nextToken().trim()).intValue();
		String CKT  = PSSEUtilFunc.trimQuote(st.nextToken());
		double R = new Double(st.nextToken().trim()).doubleValue();
		double X = new Double(st.nextToken().trim()).doubleValue();
		double B = new Double(st.nextToken().trim()).doubleValue();
		double RATEA = new Double(st.nextToken().trim()).doubleValue();
		double RATEB = new Double(st.nextToken().trim()).doubleValue();
		double RATEC = new Double(st.nextToken().trim()).doubleValue();
		double GI = new Double(st.nextToken().trim()).doubleValue();
		double BI = new Double(st.nextToken().trim()).doubleValue();
		double GJ = new Double(st.nextToken().trim()).doubleValue();
		double BJ = new Double(st.nextToken().trim()).doubleValue();
		int ST  = new Integer(st.nextToken().trim()).intValue();
		double LEN = new Double(st.nextToken().trim()).doubleValue();

		int    O1 = 0, O2 = 0, O3 = 0, O4 = 0;
		double F1 = 0.0, F2 = 0.0, F3 = 0.0, F4 = 0.0;

		if (st.hasMoreTokens()) {
			O1 = new Integer(st.nextToken().trim()).intValue();
			F1 = new Double(st.nextToken().trim()).doubleValue();
		}
		if (st.hasMoreTokens()) {
			O2 = new Integer(st.nextToken().trim()).intValue();
			F2 = new Double(st.nextToken().trim()).doubleValue();
		}
		if (st.hasMoreTokens()) {
			O3 = new Integer(st.nextToken().trim()).intValue();
			F3 = new Double(st.nextToken().trim()).doubleValue();
		}
		if (st.hasMoreTokens()) {
			O4 = new Integer(st.nextToken().trim()).intValue();
			F4 = new Double(st.nextToken().trim()).doubleValue();
		}

		IpssLogger.getLogger().fine("Branch data Line:" + lineNo + "-->" + lineStr);
		IpssLogger.getLogger().fine("From Bus number, To Bus Number, Circuit id:" + I + ", " + J + ", " + CKT);
		IpssLogger.getLogger().fine("R, X, B:" + R + ", " + X + ", " + B);
		IpssLogger.getLogger().fine("RATEA, RATEB, RATEC:" + RATEA + ", " + RATEB + ", " + RATEC);
		IpssLogger.getLogger().fine("GI, BI, GJ, BJ, ST, LEN:" + GI + ", " + BI + ", " + GJ + ", " + BJ + ", " + ST+ ", " + LEN);
		IpssLogger.getLogger().fine("O1, F1, O2, F2, O3, F3, O4, F4:" + O1 + ", " + F1 + ", " + O2 + ", " + F2  + ", " + O3 + ", " + F3 + ", " + O4 + ", " + F4);

		boolean fromMetered = true;
		if (J < 0) {
			fromMetered = false;
			J = -J;
		}
    	// create an AclfBranch object
      	final PSSELine bra = new PSSELine(CKT);
		String iStr = new Integer(I).toString();
		String jStr = new Integer(J).toString();
      	adjNet.addBranch(bra, iStr, jStr);

      	bra.setFromMetered(fromMetered);
      	bra.setStatus(ST==1);
      	bra.setRatingMva1(RATEA);
      	bra.setRatingMva2(RATEB);
      	bra.setRatingMva3(RATEC);
      	bra.setFromShuntY(new Complex(GI,BI));
      	bra.setToShuntY(new Complex(GJ,BJ));
  
       	bra.getOwnerRec(0).setOwnerNumber(O1);
       	bra.getOwnerRec(0).setOwnershipFactor(F1);
       	bra.getOwnerRec(1).setOwnerNumber(O2);
       	bra.getOwnerRec(1).setOwnershipFactor(F2);
       	bra.getOwnerRec(2).setOwnerNumber(O3);
       	bra.getOwnerRec(2).setOwnershipFactor(F3);
       	bra.getOwnerRec(3).setOwnerNumber(O4);
       	bra.getOwnerRec(3).setOwnershipFactor(F4);
      	
       	bra.setBranchCode(AclfBranchCode.LINE_LITERAL);
   		final LineAdapter line = (LineAdapter)bra.adapt(LineAdapter.class);
       	line.getAclfBranch().setZ(new Complex(R,X), msg);
       	// Unit is PU, no need to enter baseV
       	line.setHShuntY(new Complex(0.0,0.5*B), UnitType.PU, 1.0, adjNet.getBaseKva()); 
	}			

	/** 
	 * Process xformer adjustment record lines
	 *
	 * @param adjNet the AclfAdjNetwork object
	 * @param lineStr a input line string
	 * @param lineNo the line number
	 * @param msgHub the message hub object
	 */
	public static void processXfr(
				AclfAdjNetwork adjNet, 
				String lineStr,
				String lineStr2,
				String lineStr3,
				String lineStr4,
				String lineStr5,
				int lineNo, 
				IPSSMsgHub msg) throws Exception {
/*
	For 2W and 3W Xfr: I,J,K,CKT,CW,CZ,CM,MAG1,MAG2,NMETR,’NAME’,STAT,O1,F1,...,O4,F4
*/
  		StringTokenizer st = new StringTokenizer(lineStr, ",");

		int I = new Integer(st.nextToken().trim()).intValue();
		int J = new Integer(st.nextToken().trim()).intValue();
		int K = new Integer(st.nextToken().trim()).intValue();
		String CKT  = PSSEUtilFunc.trimQuote(st.nextToken());
		int CW = new Integer(st.nextToken().trim()).intValue();
		int CZ = new Integer(st.nextToken().trim()).intValue();
		int CM = new Integer(st.nextToken().trim()).intValue();
		double MAG1 = new Double(st.nextToken()).doubleValue();
		double MAG2 = new Double(st.nextToken()).doubleValue();
		int NMETR = new Integer(st.nextToken().trim()).intValue();
		String NAME = PSSEUtilFunc.trimQuote(st.nextToken());
		int STAT = new Integer(st.nextToken().trim()).intValue();

		int    O1 = 0, O2 = 0, O3 = 0, O4 = 0;
		double F1 = 0.0, F2 = 0.0, F3 = 0.0, F4 = 0.0;

		if (st.hasMoreTokens()) {
			O1 = new Integer(st.nextToken().trim()).intValue();
			F1 = new Double(st.nextToken().trim()).doubleValue();
		}
		if (st.hasMoreTokens()) {
			O2 = new Integer(st.nextToken().trim()).intValue();
			F2 = new Double(st.nextToken().trim()).doubleValue();
		}
		if (st.hasMoreTokens()) {
			O3 = new Integer(st.nextToken().trim()).intValue();
			F3 = new Double(st.nextToken().trim()).doubleValue();
		}
		if (st.hasMoreTokens()) {
			O4 = new Integer(st.nextToken().trim()).intValue();
			F4 = new Double(st.nextToken().trim()).doubleValue();
		}
		
		IpssLogger.getLogger().fine("Xfr data Line:" + lineNo + "-->" + lineStr);
		IpssLogger.getLogger().fine("I, J, K, Circuit id:" + I + ", " + J + ", "  + K + ", " + CKT);
		IpssLogger.getLogger().fine("CW, CZ, CM, MAG1, MAG2, NMETR, NAME, STAT:" + CW + ", " + CZ + ", " 
				+ CM + ", " + MAG1 + ", " + MAG2 + ", " + NMETR + ", " + NAME + ", " + STAT);
		IpssLogger.getLogger().fine("O1, F1, O2, F2, O3, F3, O4, F4:" + O1 + ", " + F1 + ", " + O2 + ", " + F2  + ", " + O3 + ", " + F3 + ", " + O4 + ", " + F4);
		
		if (K == 0) {
	      	final PSSEXformer bra = new PSSEXformer(CKT);
	      	bra.setName(NAME);
	      	bra.setStatus(STAT ==1);
	      	bra.setFromMetered(NMETR==1);
	      	
			String iStr = new Integer(I).toString();
			String jStr = new Integer(J).toString();
	      	adjNet.addBranch(bra, iStr, jStr);
    	 	bra.setBranchCode(AclfBranchCode.XFORMER_LITERAL);
    		final XfrAdapter xfr = (XfrAdapter)bra.adapt(XfrAdapter.class);
    		
	    	bra.setFlagWinding(CW);
	    	bra.setFlagZ(CZ);
	    	bra.setFlagMagnetizing(CM);
	    	bra.setMagG(MAG1);
	    	bra.setMagB(MAG2);
	      	
	       	bra.getOwnerRec(0).setOwnerNumber(O1);
	       	bra.getOwnerRec(0).setOwnershipFactor(F1);
	       	bra.getOwnerRec(1).setOwnerNumber(O2);
	       	bra.getOwnerRec(1).setOwnershipFactor(F2);
	       	bra.getOwnerRec(2).setOwnerNumber(O3);
	       	bra.getOwnerRec(2).setOwnershipFactor(F3);
	       	bra.getOwnerRec(3).setOwnerNumber(O4);
	       	bra.getOwnerRec(3).setOwnershipFactor(F4);	  
	       	
	    	/*
	       		format : R1-2,X1-2,SBASE1-2
	    	*/
	  		StringTokenizer st2 = new StringTokenizer(lineStr2, ",");
	       	double R1_2 = new Double(st2.nextToken()).doubleValue();
	       	double X1_2 = new Double(st2.nextToken()).doubleValue();
	       	double SBASE1_2 = new Double(st2.nextToken()).doubleValue();
	       	
	       	bra.setMvaRating(SBASE1_2);
	       	if (bra.getFlagZ() == 1) {
	       		// When CZ is 1, they are the resistance and reactance, respectively, in pu on 
	       		// system base quantities; 
	        	xfr.getAclfBranch().setZ(new Complex(R1_2,X1_2), msg);
	       	}
	       	else if (bra.getFlagZ() == 2) {
	       		// when CZ is 2, they are the resistance and reactance, respectively, in pu on 
	       		// winding one to two base MVA (SBASE1-2) and winding one bus base voltage; 
	       		double factor = adjNet.getBaseKva() / SBASE1_2 / 1000.0;
	       		xfr.getAclfBranch().setZ(new Complex(R1_2*factor,X1_2*factor), msg);
	       	}
	       	else if (bra.getFlagZ() == 3) {
	       		// when CZ is 3, R1-2 is the load loss in watts, and X1-2 is the impedance magnitude 
	       		// in pu on winding one to two base MVA (SBASE1-2) and winding one bus base voltage.
	       		// TODO: need implementation
          		msg.sendWarnMsg("Xfr " + I + "->" + "J flagZ = 3, needs more implementation");
	       	}
	      	
	    	/*
    		format : WINDV1,NOMV1,ANG1,RATA1,RATB1,RATC1,COD,CONT,RMA,RMI,VMA,VMI,NTP,TAB,CR,CX
	    	 */
	  		StringTokenizer st3 = new StringTokenizer(lineStr3, ",");
	  		double WINDV1 = new Double(st3.nextToken()).doubleValue();
	  		double NOMV1 = new Double(st3.nextToken()).doubleValue();
	  		double ANG1 = new Double(st3.nextToken()).doubleValue();
	  		double RATA1 = new Double(st3.nextToken()).doubleValue();
	  		double RATB1 = new Double(st3.nextToken()).doubleValue();
	  		double RATC1 = new Double(st3.nextToken()).doubleValue();
	  		int COD = new Integer(st3.nextToken().trim()).intValue();
	  		int CONT = new Integer(st3.nextToken().trim()).intValue();
	  		double RMA = new Double(st3.nextToken()).doubleValue();
	  		double RMI = new Double(st3.nextToken()).doubleValue();
	  		double VMA = new Double(st3.nextToken()).doubleValue();
	  		double VMI = new Double(st3.nextToken()).doubleValue();
	  		int NTP = new Integer(st3.nextToken().trim()).intValue();
	  		int TAB = new Integer(st3.nextToken().trim()).intValue();
	  		double CR = new Double(st3.nextToken()).doubleValue();
	  		double CX = new Double(st3.nextToken()).doubleValue();
	  		
	  		/*
			format : WINDV2,NOMV2
	  		 */
	  		StringTokenizer st4 = new StringTokenizer(lineStr4, ",");
	  		double WINDV2 = new Double(st4.nextToken()).doubleValue();
	  		double NOMV2 = new Double(st4.nextToken()).doubleValue();
	  		
	       	double f_ratio = 1.0, t_ratio = 1.0;
	  		if (bra.getFlagWinding() == 1) {
	       		// The winding one off-nominal turns ratio in pu of winding one bus base voltage
	       		// when CW is 1; WINDV1 is 1.0 by default. 
	        	f_ratio = WINDV1;
	        	t_ratio = WINDV2;
	       	}
	       	else if (bra.getFlagWinding() == 2) {
	       		// WINDV1 is the actual winding one voltage in kV when CW is 2; 
	       		f_ratio = WINDV1*1000.0 / bra.getFromAclfBus().getBaseVoltage();
	       		t_ratio = WINDV2*1000.0 / bra.getToAclfBus().getBaseVoltage();
	       	}
	       	xfr.setFromTurnRatio(f_ratio, UnitType.PU);
	       	xfr.setToTurnRatio(t_ratio, UnitType.PU); 

        	bra.setFromRatedVoltage(NOMV1*1000.0);
        	bra.setFromRatedVoltage(NOMV2*1000.0);

        	if (ANG1 != 0.0 || COD == 3 || COD == -3) {
        		// PhaseShifting transformer branch
        	 	bra.setBranchCode(AclfBranchCode.PS_XFORMER_LITERAL);
        		final PSXfrAdapter psXfr = (PSXfrAdapter)bra.adapt(PSXfrAdapter.class);
        		psXfr.setFromAngle(ANG1*Constants.DtoR);
        		psXfr.setToAngle(0.0);
        	}
	      	
          	bra.setRatingMva1(RATA1);
          	bra.setRatingMva2(RATB1);
          	bra.setRatingMva3(RATC1);
        	
          	bra.setControlMode(COD);
          	
          	/*
			If CONT is entered as a positive number, or a quoted extended bus name, the ratio is
			adjusted as if bus CONT is on the winding two or winding three side of the
			transformer; if CONT is entered as a negative number, or a quoted extended
			bus name with a minus sign preceding the first character, the ratio is adjusted
			as if bus |CONT| is on the winding one side of the transformer.
          	 */
          	boolean onFromSide = false;
          	if (CONT < 0) {
          		CONT = -CONT;
          		onFromSide = true;
          	}
          	bra.setContBusId(new Integer(CONT).toString());
          	bra.setControlOnFromSide(onFromSide);
          	
          	bra.setRmLimit(new LimitType(RMA, RMI)); 
          	bra.setVmLimit(new LimitType(VMA, VMI)); 
          	bra.setAdjSteps(NTP);
          	bra.setLoadDropCZ(new Complex(CR,CX));
          	
          	bra.setXfrTableIdNumber(TAB);
		}
		else {
			/*
			Three-winding:
			I,J,K,CKT,CW,CZ,CM,MAG1,MAG2,NMETR,’NAME’,STAT,O1,F1,...,O4,F4
			R1-2,X1-2,SBASE1-2,R2-3,X2-3,SBASE2-3,R3-1,X3-1,SBASE3-1,VMSTAR,ANSTAR
			WINDV1,NOMV1,ANG1,RATA1,RATB1,RATC1,COD,CONT,RMA,RMI,VMA,VMI,NTP,TAB,CR,CX
			WINDV2,NOMV2,ANG2,RATA2,RATB2,RATC2
			WINDV3,NOMV3,ANG3,RATA3,RATB3,RATC3
			 */
		}
	}
	
	public static void processXfrZCorrectionTable(
			AclfAdjNetwork adjNet, 
			String lineStr1,
			int lineNo, 
			IPSSMsgHub msg) throws Exception {
		msg.sendWarnMsg("Transformer Z correction table record has not been implemented");	
	}	
}