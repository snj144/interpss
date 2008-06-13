package org.interpss.custom.exchange.psse;

import java.util.StringTokenizer;

import org.interpss.custom.exchange.psse.PSSEDataRec.VersionNo;

public class PSSEBranchDataRec {
	/*
	 * BranchData
	 * I,J,CKT,R,X,B,RATEA,RATEB,RATEC,GI,BI,GJ,BJ,ST,LEN,O1,F1,...,O4,F4
	 */
	public String i, j, ckt, r, x, b, rateA, rateB, rateC, gi, bi, gj, bj,
				status, len, o1 = "0", f1 = "0.0", o2 = "0", f2 = "0.0",
				o3 = "0", f3 = "0.0", o4 = "0", f4 = "0.0";

	public PSSEBranchDataRec(String lineStr, VersionNo version) {
		StringTokenizer st;
		if (version == VersionNo.Old) {
			// 79831 82157 1 0.000200 0.000500 0.00000 0 0 0 0.0000 0.000
			// 0.0 0.0 0.0 0.0 0 0.000 86 1.00 /* [KENORASP_PS2_1 A ] */
			st = new StringTokenizer(PSSE2IpssUtilFunc.removeTailComment(lineStr));
		} else {
			st = new StringTokenizer(lineStr, ",");
		}
		i = st.nextToken().trim();
		j = st.nextToken().trim();
		ckt = st.nextToken().trim();
		r = st.nextToken().trim();
		x = st.nextToken().trim();
		b = st.nextToken().trim();
		rateA = st.nextToken().trim();
		rateB = st.nextToken().trim();
		rateC = st.nextToken().trim();
		gi = st.nextToken().trim();
		bi = st.nextToken().trim();
		gj = st.nextToken().trim();
		bj = st.nextToken().trim();
		status = st.nextToken().trim();
		len = st.nextToken().trim();

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
	}
}
