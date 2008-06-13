package org.interpss.custom.exchange.psse;

import java.util.StringTokenizer;

import org.interpss.custom.exchange.psse.PSSEDataRec.VersionNo;

public class PSSELoadDataRec {
	public String i, id, status, area = "1", zone = "1", pl = "0.0",
		ql = "0.0", ip = "0.0", iq = "0.0", yp = "0.0", yq = "0.0",
		owner = "1";

	/*
	 * LoadData I, ID, STATUS, AREA, ZONE, PL, QL, IP, IQ, YP, YQ, OWNER
	 */	
	public PSSELoadDataRec(String lineStr, VersionNo version) {
		StringTokenizer st;
		if (version == VersionNo.Old) {
			// 74611 '99' 1 702 181 1.106 0.258 0.000 0.000 0.000 0.000 1 /*
			// [STA_204 999 ] */
			st = new StringTokenizer(PSSE2IpssUtilFunc.removeTailComment(lineStr), "'");
			i = st.nextToken().trim();
			id = st.nextToken().trim();
			st = new StringTokenizer(st.nextToken());
		} else {
			st = new StringTokenizer(lineStr, ",");
			i = st.nextToken().trim();
			id = st.nextToken().trim();
		}
		status = st.nextToken().trim();
		area = st.nextToken().trim();
		zone = st.nextToken().trim();
		pl = st.nextToken().trim();
		ql = st.nextToken().trim();
		ip = st.nextToken().trim();
		iq = st.nextToken().trim();
		yp = st.nextToken().trim();
		yq = st.nextToken().trim();
		owner = st.nextToken().trim();
	}
}
