 /*
  * @(#)BranchDataProcessor.java   
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
import com.interpss.ext.ExtensionObjectFactory;
import com.interpss.ext.psse.aclf.PSSEAclfLine;
import com.interpss.ext.psse.aclf.PSSEAclfXformer;

public class PSSEBranchDataProcessor {
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
				PSSEDataRec.VersionNo version,
				IPSSMsgHub msg) throws Exception {
/*
		I,J,CKT,R,X,B,RATEA,RATEB,RATEC,GI,BI,GJ,BJ,ST,LEN,O1,F1,...,O4,F4
*/
		PSSEDataRec.BranchRec rec = new PSSEDataRec.BranchRec(lineStr, version);
		
		int I  = new Integer(rec.i).intValue();
		int J  = new Integer(rec.j).intValue();
		String CKT  = PSSEUtilFunc.trimQuote(rec.ckt).trim();
		double R = new Double(rec.r).doubleValue();
		double X = new Double(rec.x).doubleValue();
		double B = new Double(rec.b).doubleValue();
		double RATEA = new Double(rec.rateA).doubleValue();
		double RATEB = new Double(rec.rateB).doubleValue();
		double RATEC = new Double(rec.rateC).doubleValue();
		double GI = new Double(rec.gi).doubleValue();
		double BI = new Double(rec.bi).doubleValue();
		double GJ = new Double(rec.gj).doubleValue();
		double BJ = new Double(rec.bj).doubleValue();
		int ST  = new Integer(rec.status).intValue();
		double LEN = new Double(rec.len).doubleValue();

		int O1 = new Integer(rec.o1).intValue();
		double F1 = new Double(rec.f1).doubleValue();
		int O2 = new Integer(rec.o2).intValue();
		double F2 = new Double(rec.f2).doubleValue();
		int O3 = new Integer(rec.o3).intValue();
		double F3 = new Double(rec.f3).doubleValue();
		int O4 = new Integer(rec.o4).intValue();
		double F4 = new Double(rec.f4).doubleValue();

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
      	final PSSEAclfLine bra = ExtensionObjectFactory.createPSSEAclfLine(CKT);
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
  
		bra.getOwnerList().add(ExtensionObjectFactory.createPSSEOwner(O1, F1));
		bra.getOwnerList().add(ExtensionObjectFactory.createPSSEOwner(O2, F2));
		bra.getOwnerList().add(ExtensionObjectFactory.createPSSEOwner(O3, F3));
		bra.getOwnerList().add(ExtensionObjectFactory.createPSSEOwner(O4, F4));
      	
       	bra.setBranchCode(AclfBranchCode.LINE);
   		final LineAdapter line = (LineAdapter)bra.adapt(LineAdapter.class);
       	line.getAclfBranch().setZ(new Complex(R,X), msg);
       	// Unit is PU, no need to enter baseV
       	line.setHShuntY(new Complex(0.0,0.5*B), UnitType.PU, 1.0, adjNet.getBaseKva()); 
	}			

	public static void processMultiSecLineGroup(
			AclfAdjNetwork adjNet, 
			String lineStr,
			int lineNo, 
			PSSEDataRec.VersionNo version,
			IPSSMsgHub msg) throws Exception {
		/*
		 * format: I, J, ID, DUM1, DUM2, ... DUM9
		 * 
		 * J is entered as a negative number or with a minus sign before the
		 * first character of the extended bus name to designate it as the metered end; otherwise,
		 * bus I is assumed to be the metered end.
		 */
		PSSEDataRec.MultiSecLineGroupRec rec = new PSSEDataRec.MultiSecLineGroupRec(lineStr, version);

		int I = new Integer(rec.i).intValue();
		int J = new Integer(rec.j).intValue();
		String ID = PSSEUtilFunc.trimQuote(rec.id);
		if (ID.startsWith("&"))
			ID = ID.substring(1);
		
		IpssLogger.getLogger().fine("Multi-Section Line Group data Line:" + lineNo + "-->" + lineStr);
		IpssLogger.getLogger().fine("From area number, From area number, id:" + I + ", " + J  + ", " + ID);		
		
		String iStr = new Integer(I).toString();
		if (J < 0) 
			J = -J;
		String jStr = new Integer(J).toString();
		
		PSSEAclfLine branch = (PSSEAclfLine)adjNet.getBranch(iStr, jStr, ID);
		if (branch == null) {
			throw new Exception ("Branch not found in the network, I, J, ID: " + I + ", " + J + ", " + ID);
		}
		
		for (String str : rec.dumBusId) {
			if (str != null)
				branch.addDummyBus(str, "");
		}
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
				PSSEDataRec.VersionNo version,
				IPSSMsgHub msg) throws Exception {
/*
	For 2W and 3W Xfr: I,J,K,CKT,CW,CZ,CM,MAG1,MAG2,NMETR,’NAME’,STAT,O1,F1,...,O4,F4
*/
		PSSEDataRec.Xfr2WRec rec = new PSSEDataRec.Xfr2WRec(lineStr, lineStr2, lineStr3, lineStr4, version);
		
		int I = new Integer(rec.i).intValue();
		int J = new Integer(rec.j).intValue();
		int K = new Integer(rec.k).intValue();
		String CKT  = PSSEUtilFunc.trimQuote(rec.ckt).trim();
		int CW = new Integer(rec.cw).intValue();
		int CZ = new Integer(rec.cz).intValue();
		int CM = new Integer(rec.cm).intValue();
		double MAG1 = new Double(rec.mag1).doubleValue();
		double MAG2 = new Double(rec.mag2).doubleValue();
		int NMETR = new Integer(rec.nmetr).intValue();
		String NAME = PSSEUtilFunc.trimQuote(rec.name);
		int STAT = new Integer(rec.stat).intValue();

		int O1 = new Integer(rec.o1).intValue();
		double F1 = new Double(rec.f1).doubleValue();
		int O2 = new Integer(rec.o2).intValue();
		double F2 = new Double(rec.f2).doubleValue();
		int O3 = new Integer(rec.o3).intValue();
		double F3 = new Double(rec.f3).doubleValue();
		int O4 = new Integer(rec.o4).intValue();
		double F4 = new Double(rec.f4).doubleValue();
		
		IpssLogger.getLogger().fine("Xfr data Line:" + lineNo + "-->" + lineStr);
		IpssLogger.getLogger().fine("I, J, K, Circuit id:" + I + ", " + J + ", "  + K + ", " + CKT);
		IpssLogger.getLogger().fine("CW, CZ, CM, MAG1, MAG2, NMETR, NAME, STAT:" + CW + ", " + CZ + ", " 
				+ CM + ", " + MAG1 + ", " + MAG2 + ", " + NMETR + ", " + NAME + ", " + STAT);
		IpssLogger.getLogger().fine("O1, F1, O2, F2, O3, F3, O4, F4:" + O1 + ", " + F1 + ", " + O2 + ", " + F2  + ", " + O3 + ", " + F3 + ", " + O4 + ", " + F4);
		
		if (K == 0) {
	      	final PSSEAclfXformer bra = ExtensionObjectFactory.createPSSEAclfXformer(CKT);
	      	bra.setName(NAME);
	      	bra.setStatus(STAT ==1);
	      	bra.setFromMetered(NMETR==1);
	      	
			String iStr = new Integer(I).toString();
			String jStr = new Integer(J).toString();
	      	adjNet.addBranch(bra, iStr, jStr);
    	 	bra.setBranchCode(AclfBranchCode.XFORMER);
    		final XfrAdapter xfr = (XfrAdapter)bra.adapt(XfrAdapter.class);
    		
	    	bra.setFlagWinding(CW);
	    	bra.setFlagZ(CZ);
	    	bra.setFlagMagnetizing(CM);
	    	bra.setMagG(MAG1);
	    	bra.setMagB(MAG2);
	      	
			bra.getOwnerList().add(ExtensionObjectFactory.createPSSEOwner(O1, F1));
			bra.getOwnerList().add(ExtensionObjectFactory.createPSSEOwner(O2, F2));
			bra.getOwnerList().add(ExtensionObjectFactory.createPSSEOwner(O3, F3));
			bra.getOwnerList().add(ExtensionObjectFactory.createPSSEOwner(O4, F4));
	       	
	    	/*
	       		format : R1-2,X1-2,SBASE1-2
	    	*/
	       	double R1_2 = new Double(rec.r1_2).doubleValue();
	       	double X1_2 = new Double(rec.x1_2).doubleValue();
	       	double SBASE1_2 = new Double(rec.sbase1_2).doubleValue();
	       	
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
	  		double WINDV1 = new Double(rec.windv1).doubleValue();
	  		double NOMV1 = new Double(rec.nomv1).doubleValue();
	  		double ANG1 = new Double(rec.ang1).doubleValue();
	  		double RATA1 = new Double(rec.rata1).doubleValue();
	  		double RATB1 = new Double(rec.ratb1).doubleValue();
	  		double RATC1 = new Double(rec.ratc1).doubleValue();
	  		int COD = new Integer(rec.cod).intValue();
	  		int CONT = new Integer(rec.cont).intValue();
	  		double RMA = new Double(rec.rma).doubleValue();
	  		double RMI = new Double(rec.rmi).doubleValue();
	  		double VMA = new Double(rec.vma).doubleValue();
	  		double VMI = new Double(rec.vmi).doubleValue();
	  		int NTP = new Integer(rec.ntp).intValue();
	  		int TAB = new Integer(rec.tab).intValue();
	  		double CR = new Double(rec.cr).doubleValue();
	  		double CX = new Double(rec.cx).doubleValue();
	  		
	  		/*
			format : WINDV2,NOMV2
	  		 */
	  		double WINDV2 = new Double(rec.windv2).doubleValue();
	  		double NOMV2 = new Double(rec.nomv2).doubleValue();
	  		
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
        	 	bra.setBranchCode(AclfBranchCode.PS_XFORMER);
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