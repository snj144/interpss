package org.interpss.custom.exchange.psse;

import java.util.StringTokenizer;

import org.interpss.custom.exchange.psse.PSSEDataRec.VersionNo;

public class PSSEXfr2WDataRec {
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
		public String i, j, k, ckt, cw, cz, cm, mag1, mag2, nmetr, name, stat,
				o1 = "0", f1 = "0.0", o2 = "0", f2 = "0.0", o3 = "0",
				f3 = "0.0", o4 = "0", f4 = "0.0";
		public String r1_2, x1_2, sbase1_2;
		public String windv1, nomv1, ang1, rata1, ratb1, ratc1, cod, cont, rma,
				rmi, vma, vmi, ntp, tab, cr, cx;
		public String windv2, nomv2;

	public PSSEXfr2WDataRec(String lineStr1, String lineStr2, String lineStr3,
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
			i = st.nextToken().trim();
			j = st.nextToken().trim();
			ckt = st.nextToken().trim();
			cont = st.nextToken().trim();
			rma = st.nextToken().trim();
			rmi = st.nextToken().trim();
			vma = st.nextToken().trim();
			vmi = st.nextToken().trim();

		} else {
			StringTokenizer st = new StringTokenizer(lineStr1, ",");
			i = st.nextToken().trim();
			j = st.nextToken().trim();
			k = st.nextToken().trim();
			ckt = st.nextToken().trim();
			cw = st.nextToken().trim();
			cz = st.nextToken().trim();
			cm = st.nextToken().trim();
			mag1 = st.nextToken().trim();
			mag2 = st.nextToken().trim();
			nmetr = st.nextToken().trim();
			name = st.nextToken().trim();
			stat = st.nextToken().trim();

			if (st.hasMoreTokens())
				o1 = st.nextToken().trim();
			if (st.hasMoreTokens())
				f1 = st.nextToken().trim();
			if (st.hasMoreTokens())
				o2 = st.nextToken().trim();
			if (st.hasMoreTokens())
				f2 = st.nextToken().trim();
			if (st.hasMoreTokens())
				o3 = st.nextToken().trim();
			if (st.hasMoreTokens())
				f3 = st.nextToken().trim();
			if (st.hasMoreTokens())
				o4 = st.nextToken().trim();
			if (st.hasMoreTokens())
				f4 = st.nextToken().trim();

			st = new StringTokenizer(lineStr2, ",");
			r1_2 = st.nextToken().trim();
			x1_2 = st.nextToken().trim();
			sbase1_2 = st.nextToken().trim();

			st = new StringTokenizer(lineStr3, ",");
			windv1 = st.nextToken().trim();
			nomv1 = st.nextToken().trim();
			ang1 = st.nextToken().trim();
			rata1 = st.nextToken().trim();
			ratb1 = st.nextToken().trim();
			ratc1 = st.nextToken().trim();
			cod = st.nextToken().trim();
			cont = st.nextToken().trim();
			rma = st.nextToken().trim();
			rmi = st.nextToken().trim();
			vma = st.nextToken().trim();
			vmi = st.nextToken().trim();
			ntp = st.nextToken().trim();
			tab = st.nextToken().trim();
			cr = st.nextToken().trim();
			cx = st.nextToken().trim();

			st = new StringTokenizer(lineStr4, ",");
			windv2 = st.nextToken().trim();
			nomv2 = st.nextToken().trim();
		}
	}
}
