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

import com.interpss.common.datatype.ComplexFunc;
import com.interpss.common.datatype.LimitType;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.aclf.AclfBranchCode;
import com.interpss.core.aclf.PSXfrAdapter;
import com.interpss.core.aclf.XfrAdapter;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.ext.ExtensionObjectFactory;
import com.interpss.ext.psse.aclf.PSSEAclf3WXfr;
import com.interpss.ext.psse.aclf.PSSEAclfXformer;

public class PSSEXfrDataRec {
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
		private int i, j, k, cw, cz, cm, stat, nmetr;
		private String ckt, name;
		private double mag1, mag2;
		private int o1 = 0, o2 = 0, o3 = 0, o4 = 0;
		private double f1 = 0.0, f2 = 0.0, f3 = 0.0, f4 = 0.0;
		private double r1_2, x1_2, sbase1_2, r2_3, x2_3, sbase2_3, r3_1, x3_1, sbase3_1, vmstar, anstar;
		private int cod, cont, ntp, tab;
		private double windv1, nomv1, windv2, nomv2, windv3, nomv3;
		private double rma, rmi, vma, vmi, cr, cx;
		private double ang1, rata1, ratb1, ratc1, ang2, rata2, ratb2, ratc2, ang3, rata3, ratb3, ratc3;

	public PSSEXfrDataRec(String lineStr1, String lineStr2, String lineStr3, String lineStr4, String lineStr5, VersionNo version) {
		try {
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
			}
		} catch (Exception e) {
			IpssLogger.getLogger().severe(lineStr1 + "\n" + lineStr2 + "\n" + lineStr3 + "\n" + lineStr4);
			e.printStackTrace();
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
    		final XfrAdapter xfr = (XfrAdapter)bra.getAdapter(XfrAdapter.class);
    		
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
	       		double zpu = this.x1_2 * this.sbase1_2 * 1000.0 / adjNet.getBaseKva() ;
	       		double rpu = this.r1_2 / 1000.0 / adjNet.getBaseKva();  
	       		xfr.getAclfBranch().setZ(new Complex(rpu, Math.sqrt(zpu*zpu - rpu*rpu)), msg);
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
        	bra.setToRatedVoltage(this.nomv2*1000.0);

        	if (this.ang1 != 0.0 || this.cod == 3 || this.cod == -3) {
        		// PhaseShifting transformer branch
        	 	bra.setBranchCode(AclfBranchCode.PS_XFORMER);
        		final PSXfrAdapter psXfr = (PSXfrAdapter)bra.getAdapter(PSXfrAdapter.class);
        		psXfr.setFromAngle(Math.toRadians(this.ang1));
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
			//IpssLogger.getLogger().warning("*****3W-Xfr->" + toString());
			/*
			Three-winding:
			I,J,K,CKT,CW,CZ,CM,MAG1,MAG2,NMETR,’NAME’,STAT,O1,F1,...,O4,F4
			R1-2,X1-2,SBASE1-2,R2-3,X2-3,SBASE2-3,R3-1,X3-1,SBASE3-1,VMSTAR,ANSTAR
			WINDV1,NOMV1,ANG1,RATA1,RATB1,RATC1,COD,CONT,RMA,RMI,VMA,VMI,NTP,TAB,CR,CX
			WINDV2,NOMV2,ANG2,RATA2,RATB2,RATC2
			WINDV3,NOMV3,ANG3,RATA3,RATB3,RATC3
			 */
	      	final PSSEAclf3WXfr bra = ExtensionObjectFactory.createPSSEAclf3WXfr(this.ckt);
	      	bra.setName(this.name);
	      	bra.setStatus(this.stat ==1);
	      	bra.setFromMetered(this.nmetr==1);
	      	
			String iStr = new Integer(this.i).toString();
			String jStr = new Integer(this.j).toString();
			String kStr = new Integer(this.k).toString();
	      	adjNet.add3WXfrBranch(bra, iStr, jStr, kStr);
    	 	bra.setBranchCode(AclfBranchCode.W3_XFORMER);
    	 	
	    	bra.setFlagWinding(this.cw);
	    	bra.setFlagZ(this.cz);
	    	bra.setFlagMagnetizing(this.cm);
	    	bra.setMagG(this.mag1);
	    	bra.setMagB(this.mag2);
	      	
			bra.getOwnerList().add(ExtensionObjectFactory.createPSSEOwner(this.o1, this.f1));
			bra.getOwnerList().add(ExtensionObjectFactory.createPSSEOwner(this.o2, this.f2));
			bra.getOwnerList().add(ExtensionObjectFactory.createPSSEOwner(this.o3, this.f3));
			bra.getOwnerList().add(ExtensionObjectFactory.createPSSEOwner(this.o4, this.f4));    	 	
    	 	
	       	bra.setMvaRating1_2(this.sbase1_2);
	       	bra.setMvaRating2_3(this.sbase2_3);
	       	bra.setMvaRating3_1(this.sbase3_1);

	       	bra.create2WBranches();
    		final XfrAdapter xfr1 = (XfrAdapter)bra.getFromBranch().getAdapter(XfrAdapter.class);
    		final XfrAdapter xfr2 = (XfrAdapter)bra.getToBranch().getAdapter(XfrAdapter.class);
    		final XfrAdapter xfr3 = (XfrAdapter)bra.getTertiaryBranch().getAdapter(XfrAdapter.class);

        	double rpu1_2=0.0, xpu1_2=0.0;
        	double rpu2_3=0.0, xpu2_3=0.0;
        	double rpu3_1=0.0, xpu3_1=0.0;
	       	if (bra.getFlagZ() == 1) {
	       		// When CZ is 1, they are the resistance and reactance, respectively, in pu on 
	       		// system base quantities; 
	        	rpu1_2 = this.r1_2;   xpu1_2 = this.x1_2;
	        	rpu2_3 = this.r2_3;   xpu1_2 = this.x2_3;
	        	rpu3_1 = this.r3_1;   xpu1_2 = this.x3_1;
	       	}
	       	else if (bra.getFlagZ() == 2) {
	       		// when CZ is 2, they are the resistance and reactance, respectively, in pu on 
	       		// winding one to two base MVA (SBASE1-2) and winding one bus base voltage; 
	       		double factor1_2 = adjNet.getBaseKva() / this.sbase1_2 / 1000.0;
	       		double factor2_3 = adjNet.getBaseKva() / this.sbase2_3 / 1000.0;
	       		double factor3_1 = adjNet.getBaseKva() / this.sbase3_1 / 1000.0;
	        	rpu1_2 = this.r1_2*factor1_2;   xpu1_2 = this.x1_2*factor1_2;
	        	rpu2_3 = this.r2_3*factor3_1;   xpu1_2 = this.x2_3*factor3_1;
	        	rpu3_1 = this.r3_1*factor2_3;   xpu1_2 = this.x3_1*factor2_3;
	       	}
	       	else if (bra.getFlagZ() == 3) {
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
	  		if (bra.getFlagWinding() == 1) {
	       		// The winding one off-nominal turns ratio in pu of winding one bus base voltage
	       		// when CW is 1; WINDV1 is 1.0 by default. 
	        	f_ratio = this.windv1;
	        	t_ratio = this.windv2;
	        	tert_ratio = this.windv3;
	       	}
	       	else if (bra.getFlagWinding() == 2) {
	       		// WINDV1 is the actual winding one voltage in kV when CW is 2; 
	       		f_ratio = this.windv1*1000.0 / bra.getFromBus().getBaseVoltage();
	       		t_ratio = this.windv2*1000.0 / bra.getToBus().getBaseVoltage();
	       		tert_ratio = this.windv2*1000.0 / bra.getTertiaryBus().getBaseVoltage();
	       	}
	       	bra.setFromTurnRatio(f_ratio);
	       	bra.setToTurnRatio(t_ratio); 	       	
	       	bra.setTertTurnRatio(tert_ratio); 	       	
		}
	}	
	
	public String toString() {
		String str = "";
		str += "I, J, K, Circuit id:" + i + ", " + j + ", "  + k + ", " + ckt + "\n";
		str += "CW, CZ, CM, MAG1, MAG2, NMETR, NAME, STAT:" + cw + ", " + cz + ", " 
				+ cm + ", " + mag1 + ", " + mag2 + ", " + nmetr + ", " + name + ", " + stat + "\n";
		str += "O1, F1, O2, F2, O3, F3, O4, F4:" + 
				o1 + ", " + f1 + ", " + o2 + ", " + f2  + ", " + o3 + ", " + f3 + ", " + o4 + ", " + f4 + "\n";
		str += "r1_2, x1_2, sbase1_2, r2_3, x2_3, sbase2_3, r3_1, x3_1, sbase3_1, vmstar, anstar: " +
				r1_2 + ", " + x1_2 + ", " + sbase1_2 + ", " + r2_3 + ", " + 
				x2_3 + ", " + sbase2_3 + ", " + r3_1 + ", " + x3_1 + ", " + sbase3_1 + ", " + vmstar + ", " + anstar + "\n";
		str += "cod, cont, ntp, tab: " + cod + ", " + cont + ", " + ntp + ", " + tab + "\n";
		str += "windv1, nomv1, windv2, nomv2, windv3, nomv3: " + 
				windv1 + ", " + nomv1 + ", " + windv2 + ", " + nomv2 + ", " + windv3 + ", " + nomv3 + "\n";
		str += "rma, rmi, vma, vmi, cr, cx: " + rma + ", " + rmi + ", " + vma + ", " + vmi + ", " + cr + ", " + cx + "\n";
		str += "ang1, rata1, ratb1, ratc1, ang2, rata2, ratb2, ratc2, ang3, rata3, ratb3, ratc3: " +
				ang1 + ", " + rata1 + ", " + ratb1 + ", " + ratc1 + ", " + ang2 + ", " + 
				rata2 + ", " + ratb2 + ", " + ratc2 + ", " + ang3 + ", " + rata3 + ", " + ratb3 + ", " + ratc3 + "\n";
		
		return str;
	}	
}
