package org.interpss.custom.exchange.psse;

import java.util.StringTokenizer;

import org.interpss.custom.exchange.psse.PSSEDataRec.VersionNo;

public class PSSEShuntDataRec {
	/* 
	 * PSS/E 29
	 *    ShuntData I,MODSW,VSWHI,VSWLO,SWREM,RMINIT, BINIT,N1,B1,N2,B2...N8,B8

	 * PSS/E 30
	 *    ShuntData I,MODSW,VSWHI,VSWLO,SWREM,RMINIT,NAME,BINIT,N1,B1,N2,B2...N8,B8
	 */
	public String i, modsw, vswhi, vswlo, swrem, rminit, name, binit;
	public String[] b = { "0.0", "0.0", "0.0", "0.0", "0.0", "0.0", "0.0",
				"0.0" }, n = { "0", "0", "0", "0", "0", "0", "0", "0" };

	public PSSEShuntDataRec(String lineStr, VersionNo version) {
		StringTokenizer st;
		if (version == VersionNo.Old) {
			// 99214 0 1.000 1.000 0 0.00 1 4.20 1 6.00 1 8.40
			st = new StringTokenizer(PSSE2IpssUtilFunc.removeTailComment(lineStr));
		} else {
			st = new StringTokenizer(PSSE2IpssUtilFunc.removeTailComment(lineStr), ",");
		}

		i = st.nextToken().trim();
		modsw = st.nextToken().trim();
		vswhi = st.nextToken().trim();
		vswlo = st.nextToken().trim();
		swrem = st.nextToken().trim();
		if (version != VersionNo.Old)
			rminit = st.nextToken().trim();
		if (version == VersionNo.PSS_E_30)
			name = st.nextToken().trim();
		binit = st.nextToken().trim();
		if (st.hasMoreTokens())
			n[0] = st.nextToken().trim();
		if (st.hasMoreTokens())
			b[0] = st.nextToken().trim();
		if (st.hasMoreTokens())
			n[1] = st.nextToken().trim();
		if (st.hasMoreTokens())
			b[1] = st.nextToken().trim();
		if (st.hasMoreTokens())
			n[2] = st.nextToken().trim();
		if (st.hasMoreTokens())
			b[2] = st.nextToken().trim();
		if (st.hasMoreTokens())
			n[3] = st.nextToken().trim();
		if (st.hasMoreTokens())
			b[3] = st.nextToken().trim();
		if (st.hasMoreTokens())
			n[4] = st.nextToken().trim();
		if (st.hasMoreTokens())
			b[4] = st.nextToken().trim();
		if (st.hasMoreTokens())
			n[5] = st.nextToken().trim();
		if (st.hasMoreTokens())
			b[5] = st.nextToken().trim();
		if (st.hasMoreTokens())
			n[6] = st.nextToken().trim();
		if (st.hasMoreTokens())
			b[6] = st.nextToken().trim();
		if (st.hasMoreTokens())
			n[7] = st.nextToken().trim();
		if (st.hasMoreTokens())
			b[7] = st.nextToken().trim();
	}
}
