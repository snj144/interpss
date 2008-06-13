package org.interpss.custom.exchange.psse;

import java.util.StringTokenizer;

import org.interpss.custom.exchange.psse.PSSEDataRec.VersionNo;

public class PSSEBusDataRec {
	public String i, name, baseKv, ide, gl = "0.0", bl = "0.0", area = "1",
			zone = "1", vm = "1.0", va = "0.0", owner = "1";

	/*
	 * BusData Format: I, ’NAME’, BASKV, IDE, GL, BL, AREA, ZONE, VM, VA, OWNER
	 */
	public PSSEBusDataRec(String lineStr, VersionNo version) {
		StringTokenizer st;
		if (version == VersionNo.Old) {
			// old verdion: 80001 'TOMKE ' 220.00 1 0.00 0.00 703 1 1.0784
			// -38.614 1 /* [TOMKENJC A014] */
			st = new StringTokenizer(PSSE2IpssUtilFunc.removeTailComment(lineStr), "'");
			i = st.nextToken().trim();
			name = st.nextToken().trim();
			st = new StringTokenizer(st.nextToken());
		} else {
			st = new StringTokenizer(lineStr, ",");
			i = st.nextToken().trim();
			name = st.nextToken().trim();
		}

		baseKv = st.nextToken().trim();
		ide = st.nextToken().trim();
		if (st.hasMoreTokens())
			gl = st.nextToken().trim();
		if (st.hasMoreTokens())
			bl = st.nextToken().trim();
		if (st.hasMoreTokens())
			area = st.nextToken().trim();
		if (st.hasMoreTokens())
			zone = st.nextToken().trim();
		if (st.hasMoreTokens())
			vm = st.nextToken().trim();
		if (st.hasMoreTokens())
			va = st.nextToken().trim();
		if (st.hasMoreTokens())
			owner = st.nextToken().trim();
	}
}
