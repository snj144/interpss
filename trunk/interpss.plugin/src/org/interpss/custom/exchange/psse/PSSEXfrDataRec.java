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

package org.interpss.custom.exchange.psse;

import java.util.StringTokenizer;

import org.apache.commons.math.complex.Complex;
import org.interpss.custom.exchange.psse.PSSEDataRec.VersionNo;

import com.interpss.common.datatype.Constants;
import com.interpss.common.datatype.LimitType;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclf.AclfBranchCode;
import com.interpss.core.aclf.PSXfrAdapter;
import com.interpss.core.aclf.XfrAdapter;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.ext.ExtensionObjectFactory;
import com.interpss.ext.psse.aclf.PSSEAclfXformer;

public class PSSEXfrDataRec {
	/*
	 * XfrData For 2W Xfr:
	 * I,J,K,CKT,CW,CZ,CM,MAG1,MAG2,NMETR,’NAME’,STAT,O1,F1,...,O4,F4
	 * R1-2,X1-2,SBASE1-2
	 * WINDV1,NOMV1,ANG1,RATA1,RATB1,RATC1,COD,CONT,RMA,RMI,VMA,VMI,NTP,TAB,CR,CX
	 * WINDV2,NOMV2
	 * 
	 * Three-winding:
	 * I,J,K,CKT,CW,CZ,CM,MAG1,MAG2,NMETR,’NAME’,STAT,O1,F1,...,O4,F4
	 * R1-2,X1-2,SBASE1-2,R2-3,X2-3,SBASE2-3,R3-1,X3-1,SBASE3-1,VMSTAR,ANSTAR
	 * WINDV1,NOMV1,ANG1,RATA1,RATB1,RATC1,COD,CONT,RMA,RMI,VMA,VMI,NTP,TAB,CR,CX
	 * WINDV2,NOMV2,ANG2,RATA2,RATB2,RATC2 WINDV3,NOMV3,ANG3,RATA3,RATB3,RATC3
	 */
		private int i, j, k, cw, cz, cm, stat, nmetr;
		private String ckt, name;
		private double mag1, mag2;
		private int o1 = 0, o2 = 0, o3 = 0, o4 = 0;
		private double f1 = 0.0, f2 = 0.0, f3 = 0.0, f4 = 0.0;
		private double r1_2, x1_2, sbase1_2;
		private int cod, cont, ntp, tab;
		private double windv1, nomv1, ang1, rata1, ratb1, ratc1, rma, rmi, vma, vmi, cr, cx, windv2, nomv2;

	public PSSEXfrDataRec(String lineStr1, String lineStr2, String lineStr3,
				String lineStr4, VersionNo version) {
		if (version == VersionNo.Old) {
			/*
			 * 	I,J,CKT,ICONT,RMA,RMI,VMA,VMI,STEP,TABLE 
			 * 		I - From bus number 
			 * 		J - To bus number 
			 * 		CKT - Circuit number 
			 * 		ICONT - Number of bus to control. If different from I or J, sign of ICONT determines
			 * 				control. Positive sign, close to impedance (untapped) bus of
			 * 				transformer. Negative sign, opposite. 
			 * 		RMA - Upper limit of turns ratio or phase shift 
			 * 		RMI - Lower limit of turns ratio or phase shift 
			 * 		VMA - Upper limit of controlled volts, MW or MVAR 
			 * 		VMI - Lower limit of controlled volts, MW or MVAR 
			 * 		STEP - Turns ratio step increment 
			 * 		TABLE - Zero, or number of a transformer impedance correction table 1-5
			 */
			StringTokenizer st = new StringTokenizer(PSSE2IpssUtilFunc.removeTailComment(lineStr1));
			i = new Integer(st.nextToken().trim()).intValue();
			j = new Integer(st.nextToken().trim()).intValue();
			ckt = PSSE2IpssUtilFunc.trimQuote(st.nextToken()).trim();
			cont = new Integer(st.nextToken().trim()).intValue();
			rma = new Double(st.nextToken().trim()).doubleValue();
			rmi = new Double(st.nextToken().trim()).doubleValue();
			vma = new Double(st.nextToken().trim()).doubleValue();
			vmi = new Double(st.nextToken().trim()).doubleValue();

		} else {
			StringTokenizer st = new StringTokenizer(lineStr1, ",");
			i = new Integer(st.nextToken().trim()).intValue();
			j = new Integer(st.nextToken().trim()).intValue();
			k = new Integer(st.nextToken().trim()).intValue();
			ckt = PSSE2IpssUtilFunc.trimQuote(st.nextToken()).trim();
			cw = new Integer(st.nextToken().trim()).intValue();
			cz = new Integer(st.nextToken().trim()).intValue();
			cm = new Integer(st.nextToken().trim()).intValue();
			mag1 = new Double(st.nextToken().trim()).doubleValue();
			mag2 = new Double(st.nextToken().trim()).doubleValue();
			nmetr = new Integer(st.nextToken().trim()).intValue();
			name = st.nextToken().trim();
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
		}
	}

	/** 
	 * Process xformer adjustment record lines
	 *
	 * @param adjNet the AclfAdjNetwork object
	 * @param msgHub the message hub object
	 */
	public void processXfr(
				AclfAdjNetwork adjNet, 
				IPSSMsgHub msg) throws Exception {
/*
	For 2W and 3W Xfr: I,J,K,CKT,CW,CZ,CM,MAG1,MAG2,NMETR,’NAME’,STAT,O1,F1,...,O4,F4
*/
		if (this.k == 0) {
	      	final PSSEAclfXformer bra = ExtensionObjectFactory.createPSSEAclfXformer(this.ckt);
	      	bra.setName(this.name);
	      	bra.setStatus(this.stat ==1);
	      	bra.setFromMetered(this.nmetr==1);
	      	
			String iStr = new Integer(this.i).toString();
			String jStr = new Integer(this.j).toString();
	      	adjNet.addBranch(bra, iStr, jStr);
    	 	bra.setBranchCode(AclfBranchCode.XFORMER);
    		final XfrAdapter xfr = (XfrAdapter)bra.adapt(XfrAdapter.class);
    		
	    	bra.setFlagWinding(this.cw);
	    	bra.setFlagZ(this.cz);
	    	bra.setFlagMagnetizing(this.cm);
	    	bra.setMagG(this.mag1);
	    	bra.setMagB(this.mag2);
	      	
			bra.getOwnerList().add(ExtensionObjectFactory.createPSSEOwner(this.o1, this.f1));
			bra.getOwnerList().add(ExtensionObjectFactory.createPSSEOwner(this.o2, this.f2));
			bra.getOwnerList().add(ExtensionObjectFactory.createPSSEOwner(this.o3, this.f3));
			bra.getOwnerList().add(ExtensionObjectFactory.createPSSEOwner(this.o4, this.f4));
			
	    	/*
	       		format : R1-2,X1-2,SBASE1-2
	    	*/
	       	bra.setMvaRating(this.sbase1_2);
	       	if (bra.getFlagZ() == 1) {
	       		// When CZ is 1, they are the resistance and reactance, respectively, in pu on 
	       		// system base quantities; 
	        	xfr.getAclfBranch().setZ(new Complex(this.r1_2,this.x1_2), msg);
	       	}
	       	else if (bra.getFlagZ() == 2) {
	       		// when CZ is 2, they are the resistance and reactance, respectively, in pu on 
	       		// winding one to two base MVA (SBASE1-2) and winding one bus base voltage; 
	       		double factor = adjNet.getBaseKva() / this.sbase1_2 / 1000.0;
	       		xfr.getAclfBranch().setZ(new Complex(this.r1_2*factor,this.x1_2*factor), msg);
	       	}
	       	else if (bra.getFlagZ() == 3) {
	       		// when CZ is 3, R1-2 is the load loss in watts, and X1-2 is the impedance magnitude 
	       		// in pu on winding one to two base MVA (SBASE1-2) and winding one bus base voltage.
	       		// TODO: need implementation
          		msg.sendWarnMsg("Xfr " + this.i + "->" + "J flagZ = 3, needs more implementation");
	       	}
	      	
	    	/*
    		format : WINDV1,NOMV1,ANG1,RATA1,RATB1,RATC1,COD,CONT,RMA,RMI,VMA,VMI,NTP,TAB,CR,CX
	    	 */
	  		
	  		/*
			format : WINDV2,NOMV2
	  		 */
	       	double f_ratio = 1.0, t_ratio = 1.0;
	  		if (bra.getFlagWinding() == 1) {
	       		// The winding one off-nominal turns ratio in pu of winding one bus base voltage
	       		// when CW is 1; WINDV1 is 1.0 by default. 
	        	f_ratio = this.windv1;
	        	t_ratio = this.windv2;
	       	}
	       	else if (bra.getFlagWinding() == 2) {
	       		// WINDV1 is the actual winding one voltage in kV when CW is 2; 
	       		f_ratio = this.windv1*1000.0 / bra.getFromAclfBus().getBaseVoltage();
	       		t_ratio = this.windv2*1000.0 / bra.getToAclfBus().getBaseVoltage();
	       	}
	       	xfr.setFromTurnRatio(f_ratio, UnitType.PU);
	       	xfr.setToTurnRatio(t_ratio, UnitType.PU); 

        	bra.setFromRatedVoltage(this.nomv1*1000.0);
        	bra.setFromRatedVoltage(this.nomv2*1000.0);

        	if (this.ang1 != 0.0 || this.cod == 3 || this.cod == -3) {
        		// PhaseShifting transformer branch
        	 	bra.setBranchCode(AclfBranchCode.PS_XFORMER);
        		final PSXfrAdapter psXfr = (PSXfrAdapter)bra.adapt(PSXfrAdapter.class);
        		psXfr.setFromAngle(this.ang1*Constants.DtoR);
        		psXfr.setToAngle(0.0);
        	}
	      	
          	bra.setRatingMva1(this.rata1);
          	bra.setRatingMva2(this.ratb1);
          	bra.setRatingMva3(this.ratc1);
        	
          	bra.setControlMode(this.cod);
          	
          	/*
			If CONT is entered as a positive number, or a quoted extended bus name, the ratio is
			adjusted as if bus CONT is on the winding two or winding three side of the
			transformer; if CONT is entered as a negative number, or a quoted extended
			bus name with a minus sign preceding the first character, the ratio is adjusted
			as if bus |CONT| is on the winding one side of the transformer.
          	 */
          	boolean onFromSide = false;
          	if (this.cont < 0) {
          		this.cont = -this.cont;
          		onFromSide = true;
          	}
          	bra.setContBusId(new Integer(this.cont).toString());
          	bra.setControlOnFromSide(onFromSide);
          	
          	bra.setRmLimit(new LimitType(this.rma, this.rmi)); 
          	bra.setVmLimit(new LimitType(this.vma, this.vmi)); 
          	bra.setAdjSteps(this.ntp);
          	bra.setLoadDropCZ(new Complex(this.cr,this.cx));
          	
          	bra.setXfrTableIdNumber(this.tab);
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
	
	public String toString() {
		String str = "";
		str += "I, J, K, Circuit id:" + i + ", " + j + ", "  + k + ", " + ckt + "\n";
		str += "CW, CZ, CM, MAG1, MAG2, NMETR, NAME, STAT:" + cw + ", " + cz + ", " 
				+ cm + ", " + mag1 + ", " + mag2 + ", " + nmetr + ", " + name + ", " + stat + "\n";
		str += "O1, F1, O2, F2, O3, F3, O4, F4:" + 
				o1 + ", " + f1 + ", " + o2 + ", " + f2  + ", " + o3 + ", " + f3 + ", " + o4 + ", " + f4 + "\n";
		return str;
	}	
}
