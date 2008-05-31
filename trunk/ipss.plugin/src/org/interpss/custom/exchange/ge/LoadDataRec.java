package org.interpss.custom.exchange.ge;

import java.util.StringTokenizer;

public class LoadDataRec extends BaseBusDataRec {
	public int st, nst, owner;
	public double p, q, ip, iq, g, b;
			
	public LoadDataRec(String lineStr, GEDataRec.VersionNo version) {
		//System.out.println("load data->" + lineStr);
/*
	<bus> <"name"> <bkv> <"id"> <"long id"> : <st> <p> <q> <ip> <iq> <g> <b> /
	<ar> <z> <d_in> <d_out> <proj id> <nst> <owner>

       2 "P-2     " 380.00 "1 " "        "  :  1  868.096    0.000    0.000    0.000    0.000    0.000   1  201   400101   391231   0 0   1
 */		
		String str1 = lineStr.substring(0, lineStr.indexOf(':')),
        	   str2 = lineStr.substring(lineStr.indexOf(':')+1);

		setHeaderData(str1);
		
		StringTokenizer st = new StringTokenizer(str2);
		if (st.hasMoreElements())
			this.st = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.p = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.q = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.ip = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.iq = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.g = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.b = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.ar = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.z = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.d_in = st.nextToken();
		if (st.hasMoreElements())
			this.d_out = st.nextToken();
		if (st.hasMoreElements())
			this.projId = st.nextToken();
		if (st.hasMoreElements())
			this.nst = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.owner = new Integer(st.nextToken()).intValue();
	}
	
	public String toString() {
		String str = super.toString();
		str += "st, nst, owner, d_in, d_out, proj id: " + st + ", " + nst + ", " + owner + ", " + d_in + ", " + d_out + ", " + projId + "\n";
		str += "p, q, ip, iq, g, b: " + p + ", " + q + ", " + ip + ", " + iq + ", " + g + ", " + b + "\n";
		return str;
	}
	
}
