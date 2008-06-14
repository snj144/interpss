package org.interpss.custom.exchange.psse;

import java.util.StringTokenizer;

import org.interpss.custom.exchange.psse.PSSEDataRec.VersionNo;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclfadj.AclfAdjNetwork;

public class PSSESwitchedShuntDataRec {
	/* 
	 * PSS/E 29
	 *    ShuntData I,MODSW,VSWHI,VSWLO,SWREM,RMINIT, BINIT,N1,B1,N2,B2...N8,B8

	 * PSS/E 30
	 *    ShuntData I,MODSW,VSWHI,VSWLO,SWREM,RMINIT,NAME,BINIT,N1,B1,N2,B2...N8,B8
	 */
	public String i, modsw, vswhi, vswlo, swrem, rminit, name, binit;
	public String[] b = { "0.0", "0.0", "0.0", "0.0", "0.0", "0.0", "0.0",
				"0.0" }, n = { "0", "0", "0", "0", "0", "0", "0", "0" };

	public PSSESwitchedShuntDataRec(String lineStr, VersionNo version) {
		StringTokenizer st;
		if (version == VersionNo.Old) {
			// 99214 0 1.000 1.000 0 0.00 1 4.20 1 6.00 1 8.40
			st = new StringTokenizer(PSSE2IpssUtilFunc.removeTailComment(lineStr));
		} else {
			st = new StringTokenizer(PSSE2IpssUtilFunc.removeTailComment(lineStr), ",");
		}

		i = st.nextToken().trim();
		modsw = st.nextToken().trim();
		vswhi = st.nextToken().trim();
		vswlo = st.nextToken().trim();
		swrem = st.nextToken().trim();
		if (version != VersionNo.Old)
			rminit = st.nextToken().trim();
		if (version == VersionNo.PSS_E_30)
			name = st.nextToken().trim();
		binit = st.nextToken().trim();
		if (st.hasMoreTokens())
			n[0] = st.nextToken().trim();
		if (st.hasMoreTokens())
			b[0] = st.nextToken().trim();
		if (st.hasMoreTokens())
			n[1] = st.nextToken().trim();
		if (st.hasMoreTokens())
			b[1] = st.nextToken().trim();
		if (st.hasMoreTokens())
			n[2] = st.nextToken().trim();
		if (st.hasMoreTokens())
			b[2] = st.nextToken().trim();
		if (st.hasMoreTokens())
			n[3] = st.nextToken().trim();
		if (st.hasMoreTokens())
			b[3] = st.nextToken().trim();
		if (st.hasMoreTokens())
			n[4] = st.nextToken().trim();
		if (st.hasMoreTokens())
			b[4] = st.nextToken().trim();
		if (st.hasMoreTokens())
			n[5] = st.nextToken().trim();
		if (st.hasMoreTokens())
			b[5] = st.nextToken().trim();
		if (st.hasMoreTokens())
			n[6] = st.nextToken().trim();
		if (st.hasMoreTokens())
			b[6] = st.nextToken().trim();
		if (st.hasMoreTokens())
			n[7] = st.nextToken().trim();
		if (st.hasMoreTokens())
			b[7] = st.nextToken().trim();
	}
	
	public void processSwitchedShunt(
			AclfAdjNetwork adjNet, 
			IPSSMsgHub msg) throws Exception {
		msg.sendWarnMsg("Swithced Shunt data record has not been implemented");

		/*
			I,MODSW,VSWHI,VSWLO,SWREM,RMINIT,NAME(PSS/E30),BINIT,N1,B1,N2,B2...N8,B8
				I - Bus number
				MODSW - Mode 0 - fixed 1 - discrete 2 - continuous
				VSWHI - Desired voltage upper limit, per unit
				VSWLO - Desired voltage lower limit, per unit
				SWREM - Number of remote bus to control. 0 to control own bus.
				VDES - Desired voltage setpoint, per unit
				BINIT - Initial switched shunt admittance, MVAR at 1.0 per unit volts
				N1 - Number of steps for block 1, first 0 is end of blocks
				B1 - Admittance increment of block 1 in MVAR at 1.0 per unit volts.
				N2, B2, etc, as N1, B1
		 */	
/*		
		int I = new Integer(rec.i).intValue();
		int MODSW = new Integer(rec.modsw).intValue();
		double VSWHI = new Double(rec.vswhi).doubleValue();
		double VSWLO = new Double(rec.vswlo).doubleValue();
		int SWREM  = new Integer(rec.swrem).intValue();
		double RMINIT = new Double(rec.rminit).doubleValue();
		String name = rec.name;
		double BINIT = new Double(rec.binit).doubleValue();
		int N1     = new Integer(rec.n[0]).intValue();
		double B1  = new Double(rec.b[0]).doubleValue();
		int N2     = new Integer(rec.n[1]).intValue();
		double B2  = new Double(rec.b[1]).doubleValue();
		int N3     = new Integer(rec.n[2]).intValue();
		double B3  = new Double(rec.b[2]).doubleValue();
		int N4     = new Integer(rec.n[3]).intValue();
		double B4  = new Double(rec.b[3]).doubleValue();
		int N5     = new Integer(rec.n[4]).intValue();
		double B5  = new Double(rec.b[4]).doubleValue();
		int N6     = new Integer(rec.n[5]).intValue();
		double B6  = new Double(rec.b[5]).doubleValue();
		int N7     = new Integer(rec.n[6]).intValue();
		double B7  = new Double(rec.b[6]).doubleValue();
		int N8     = new Integer(rec.n[7]).intValue();
		double B8  = new Double(rec.b[7]).doubleValue();
*/
	}	
	
}
