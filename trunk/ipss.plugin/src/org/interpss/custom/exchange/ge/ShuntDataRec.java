package org.interpss.custom.exchange.ge;

public class ShuntDataRec {
	public int fbus; 
	public String fname, id, tname, ck, longId, rname; 
	public double fbkv, tbus, tbkv, sec;
	public double st, ar, z, g, b, d_in, d_out, projId, nst;
	public double o1, p1, o2, p2, o3, p3, o4, p4, regBus, rkv;
			
	public ShuntDataRec(String lineStr, GEDataRec.VersionNo version) {
		System.out.println("shunt data->" + lineStr);
	}
}
