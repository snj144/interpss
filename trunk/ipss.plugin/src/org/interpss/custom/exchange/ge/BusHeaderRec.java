package org.interpss.custom.exchange.ge;

import java.util.StringTokenizer;

public class BusHeaderRec {
	public int number, ar, z;
	public String name, id = "", longId = ""; 
	public double bkv;
	public String d_in, d_out, projId;
	
	public void setHeaderData(String dataStr) {
		StringTokenizer st = new StringTokenizer(dataStr, "\"");
		
		// format: <number> <"name"> <kV>
        //         <bus> <"name"> <bkv> <"id"> <"long id">		           
		this.number = new Integer(st.nextToken().trim()).intValue();
		this.name = st.nextToken();
		this.bkv = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.id = st.nextToken();
		if (st.hasMoreElements())
			this.longId = st.nextToken();
	}
	
	public String toString() {
		String str = "";
		str += "number, name, ar, z, id, longId,  bkv: " + number + ", " + name + ", " 
		       + ar + ", " + z + ", " + id + ", " + longId + ", " + bkv + "\n";
		str += "d_in, d_out, projId: " + d_in + ", " + d_out + ", " + projId + "\n";
		return str;
	}
	
}
