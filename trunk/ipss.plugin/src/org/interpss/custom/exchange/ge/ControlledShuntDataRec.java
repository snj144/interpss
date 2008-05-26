package org.interpss.custom.exchange.ge;

public class ControlledShuntDataRec {
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

	public ControlledShuntDataRec(String lineStr, GEDataRec.VersionNo version) {
	}
}
