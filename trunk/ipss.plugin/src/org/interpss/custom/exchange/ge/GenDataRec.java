package org.interpss.custom.exchange.ge;

public class GenDataRec {
	public int bus, name, bkv, id, longId, st, igregBus, igregName;
	public int igregBkv, prf, qrf, ar, z, pgen, pmax, pmin, qgen, qmax, qmin;
	public int mbase, rcomp, xcomp, zgenr, zgenx, hBus, hName, hBkv, tBus;
	public int tName, tBkv, dIn, dOut, projid, snt, rtr, xtr, gtap;
	public int o1, p1, o2, p2, o3, p3, o4, p4, o5, p5, o6, p6, o7, p7, o8, p8;
	public int govFlag, agcFlag, dispatchFlag, baseloadFlag, airTemp, turbineType, qtab, pmax2;

	public GenDataRec(String lineStr, GEDataRec.VersionNo version) {
		System.out.println("gen data->" + lineStr);
	}
}
