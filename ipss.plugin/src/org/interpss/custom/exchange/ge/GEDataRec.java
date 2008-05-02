package org.interpss.custom.exchange.ge;

public class GEDataRec {
	public static enum VersionNo {PSLF15};
	
	static private class BaseRec {
		public String d_in, d_out;   // yymmdd
		public String projid_info;
	}
	
	static public class BusRec extends BaseRec {
			public int number;
			public String name;
			public double base_kV, vs_pu, vt_pu, an_deg, vma, vmi;
			public int ty, ar, z, owner;
			public String d_in, d_out;   // yymmdd
			public String projid_info;
			public int level_info;
			public int stisol_future;
			public double latitude_info, longitude_info;
			public int islnum_future;

		public BusRec(String lineStr, VersionNo version) {
		}
	}
	
	static public class BranchSectionRec extends BaseRec {
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

		public BranchSectionRec(String lineStr, VersionNo version) {
		}
	}	
}
