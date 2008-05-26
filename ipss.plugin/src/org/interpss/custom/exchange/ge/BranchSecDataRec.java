package org.interpss.custom.exchange.ge;


public class BranchSecDataRec {
	public int f_bus, t_bus;
	public String f_name, t_name;
	public double f_bkv, t_bkv;
	public String ck, long_id;
	public int sec, st;
	public double r_pu, x_pu, b_pu;
	public double r1_mva, r2_mva, r3_mva, r4_mva, r5_mva, r6_mva, r7_mva, r8_mva;
	public double al, l_info;
	public int ar, z;
	public double gi, tf, tt;
	public int nst, type;
	public int o1, o2, o3, o4, o5, o6, o7, o8;
	public double p1, p2, p3, p4, p5, p6, p7, p8;
	public int ohms;

	public BranchSecDataRec(String lineStr, GEDataRec.VersionNo version) {
		System.out.println("branch sec->" + lineStr);
	}
}
