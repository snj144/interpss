package org.interpss.custom.exchange.ge;

import java.util.StringTokenizer;

public class BaseBranchDataRec {
	public int f_bus, t_bus, sec;
	public String f_name, t_name, ck, long_id;
	public double f_bkv, t_bkv;

	/*
       <f bus> <"f name"> <f bkv> <t bus> <"t name"> <t bkv> <"ck"> <sec> <"long id">
	 */
	public void setHeaderData(String headerStr) {
		StringTokenizer st = new StringTokenizer(headerStr, "\"");
		// 1 "P-1     " 380.00       2 "P-2     " 380.00 "1 "  1 "        "
		this.f_bus = new Integer(st.nextToken().trim()).intValue();
		this.f_name = st.nextToken();
		
		String s = st.nextToken();
		StringTokenizer st1 = new StringTokenizer(s);
		this.f_bkv = new Double(st1.nextToken()).doubleValue();
		this.t_bus = new Integer(st1.nextToken().trim()).intValue();
		
		this.t_name = st.nextToken();
		this.t_bkv = new Double(st.nextToken()).doubleValue();
		this.ck = st.nextToken();
		if (st.hasMoreElements()) {
			String s1 = st.nextToken().trim();
			if (!s1.equals(""))
				this.sec = new Integer(s1).intValue();
		}
		if (st.hasMoreElements()) {
			this.long_id = st.nextToken();
		}
			
	}
	
	public String toString() {
		String str = "";
		str += "f_bus, t_bus, sec: " + f_bus + ", " + t_bus + ", " + sec + "\n";
		str += "f_name, t_name, ck, long_id: " + f_name + ", " + t_name + ", " + ck + ", " + long_id + "\n";
		str += "f_bkv, t_bkv: " + f_bkv + ", " + t_bkv + "\n";
		return str;
	}	
}
