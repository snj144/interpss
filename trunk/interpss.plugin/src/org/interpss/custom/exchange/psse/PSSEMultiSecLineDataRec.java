package org.interpss.custom.exchange.psse;

import java.util.StringTokenizer;

import org.interpss.custom.exchange.psse.PSSEDataRec.VersionNo;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.ext.psse.aclf.PSSEAclfLine;

public class PSSEMultiSecLineDataRec {
	/*
	 * MultiSectionLineGroup format: I, J, ID, DUM1, DUM2, ... DUM9
	 * 
	 * J is entered as a negative number or with a minus sign before the first
	 * character of the extended bus name to designate it as the metered end;
	 * otherwise, bus I is assumed to be the metered end.
	 * 
	 * Bus numbers, or extended bus names enclosed in single quotes (see Section 4.1.2),
		of the "dummy buses" connected by the branches that comprise this multisection
		line grouping. No defaults allowed.
	 */
	private int i, j;
	private String id;
	private String[] dumBusIdAry = new String[9] /*dumBusNameAry = new String[9]*/;

	public PSSEMultiSecLineDataRec(String lineStr, VersionNo version) {
		StringTokenizer st = new StringTokenizer(lineStr, ",");
		i = new Integer(st.nextToken().trim()).intValue();
		j = new Integer(st.nextToken().trim()).intValue();
		id = PSSE2IpssUtilFunc.trimQuote(st.nextToken()).trim();
		if (st.hasMoreTokens())
			dumBusIdAry[0] = st.nextToken().trim();
		if (st.hasMoreTokens())
			dumBusIdAry[1] = st.nextToken().trim();
		if (st.hasMoreTokens())
			dumBusIdAry[2] = st.nextToken().trim();
		if (st.hasMoreTokens())
			dumBusIdAry[3] = st.nextToken().trim();
		if (st.hasMoreTokens())
			dumBusIdAry[4] = st.nextToken().trim();
		if (st.hasMoreTokens())
			dumBusIdAry[5] = st.nextToken().trim();
		if (st.hasMoreTokens())
			dumBusIdAry[6] = st.nextToken().trim();
		if (st.hasMoreTokens())
			dumBusIdAry[7] = st.nextToken().trim();
		if (st.hasMoreTokens())
			dumBusIdAry[8] = st.nextToken().trim();
	}
	
	public void processMultiSecLine(AclfAdjNetwork adjNet, IPSSMsgHub msg) throws Exception {
		/*
		 * format: I, J, ID, DUM1, DUM2, ... DUM9
		 * 
		 * J is entered as a negative number or with a minus sign before the
		 * first character of the extended bus name to designate it as the metered end; otherwise,
		 * bus I is assumed to be the metered end.
		 */
		if (this.id.startsWith("&"))
			this.id = this.id.substring(1);
		
		String iStr = new Integer(this.i).toString();
		if (this.j < 0) 
			this.j = -this.j;
		String jStr = new Integer(this.j).toString();
		
		PSSEAclfLine branch = (PSSEAclfLine)adjNet.getBranch(iStr, jStr, this.id);
		if (branch == null) {
			throw new Exception ("Branch not found in the network, I, J, ID: " + iStr + ", " + jStr + ", '" + this.id + "'");
		}
		
		for (String str : this.dumBusIdAry) {
			if (str != null)
				branch.addDummyBus(str, "");
		}
	}	
	
	public String toString() {
		String str = "";
		str += "From area number, From area number, id:" + i + ", " + j  + ", " + id + "\n";		
		
		return str;
	}	
}
