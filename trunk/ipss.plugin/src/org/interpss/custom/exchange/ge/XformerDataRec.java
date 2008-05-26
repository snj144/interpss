package org.interpss.custom.exchange.ge;

public class XformerDataRec {
	public int fBus, fName, fBkv, tBus, tName, tBkv, ck, longId;
	public int st, type, kregBus, kregName, kregBkv, zt, iintBus, iintName;
	public int iintBkv, tertBus, tertName, tertBkv, area, zone, tbase, zpsr;
	public int zpsx, zptr, zptx, ztsr, ztsx, vnomp, vnoms, vnomt, anglp, gmag;
	public int bmag, r1, r2, r3, r4, aloss, tmax, tmin, vtmax, vtmin, stepp, tapp, tapfp, tapfs, tapft, date_in, date_out, projid, stn;
	public int r5, r6, r7, r8;
	public int o1, p1, o2, p2, o3, p3, o4, p4, o5, p5, o6, p6, o7, p7, o8, p8; 
	public int ohms, tbasept, tbasets, angls, anglt;
	public int rs1, rs2, rs3, rt1, rt2, rt3, alosss, alosst, rxunits, gbunits, tunits, rcomp, xcomp;

	public XformerDataRec(String lineStr, GEDataRec.VersionNo version) {
		System.out.println("xfr data->" + lineStr);
	}
}
