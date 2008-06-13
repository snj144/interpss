package org.interpss.custom.exchange.psse;

import java.util.StringTokenizer;

import org.interpss.custom.exchange.psse.PSSEDataRec.VersionNo;

public class PSSEGenDataRec {
	/*
	 * GenData
	 * I,ID,PG,QG,QT,QB,VS,IREG,MBASE,ZR,ZX,RT,XT,GTAP,STAT,RMPCT,PT,PB,O1,F1,...,O4,F4
	 * 
	 * The standard generator boundary condition is a specification of real
	 * power output at the high-voltage bus, bus k, and of voltage magnitude at
	 * some designated bus, not necessarily bus k.
	 */
	public String i, id, pg, qg, qt, qb, vs, ireg, mbase, zr, zx, rt, xt,
				gtap, stat, rmpact, pt, pb, o1 = "0", f1 = "0.0", o2 = "0",
				f2 = "0.0", o3 = "0", f3 = "0.0", o4 = "0", f4 = "0.0";

	public PSSEGenDataRec(String lineStr, VersionNo version) {
		StringTokenizer st;
		if (version == VersionNo.Old) {
			// 80041 '1 ' 56.78 -8.79 28.000 -14.000 1.0000 0 61.2 0.0 1.0
			// 0.0 0.0 1.0 1 100.0 61.20 -5.60 1 1.00 /* [SMOKY AG1234 ] */
			st = new StringTokenizer(PSSE2IpssUtilFunc.removeTailComment(lineStr), "'");
			i = st.nextToken().trim();
			id = st.nextToken().trim();
			st = new StringTokenizer(st.nextToken());
		} else {
			st = new StringTokenizer(lineStr, ",");
			i = st.nextToken().trim();
			id = st.nextToken().trim();
		}
		pg = st.nextToken().trim();
		qg = st.nextToken().trim();
		qt = st.nextToken().trim();
		qb = st.nextToken().trim();
		vs = st.nextToken().trim();
		ireg = st.nextToken().trim();
		mbase = st.nextToken().trim();
		zr = st.nextToken().trim();
		zx = st.nextToken().trim();
		rt = st.nextToken().trim();
		xt = st.nextToken().trim();
		gtap = st.nextToken().trim();
		stat = st.nextToken().trim();
		rmpact = st.nextToken().trim();
		pt = st.nextToken().trim();
		pb = st.nextToken().trim();

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
