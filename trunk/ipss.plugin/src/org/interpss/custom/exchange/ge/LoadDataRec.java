package org.interpss.custom.exchange.ge;

public class LoadDataRec {
	public int bus;
	public String name, id, longId; 
	public double bkv, st, p, q, ip, iq, g, b;
	public double ar, z, d_in, d_out, projId, nst, owner;
			
	public LoadDataRec(String lineStr, GEDataRec.VersionNo version) {
		System.out.println("load data->" + lineStr);
	}
}
