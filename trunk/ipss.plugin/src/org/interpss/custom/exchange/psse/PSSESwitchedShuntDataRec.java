package org.interpss.custom.exchange.psse;

import java.util.StringTokenizer;

import org.interpss.custom.exchange.psse.PSSEDataRec.VersionNo;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.ext.ExtensionObjectFactory;
import com.interpss.ext.psse.aclf.PSSESwitchedShunt;

public class PSSESwitchedShuntDataRec {
	/* 
	 * PSS/E 29
	 *    ShuntData I,MODSW,VSWHI,VSWLO,SWREM,RMINIT, BINIT,N1,B1,N2,B2...N8,B8

	 * PSS/E 30
	 *    ShuntData I,MODSW,VSWHI,VSWLO,SWREM,RMPCT,'RMINIT',BINIT,N1,B1,N2,B2...N8,B8
	 */
	public int i, modsw, swrem;
	public double vswhi, vswlo, rmpct, binit; 
	public String name, rminit;
	public int[] nAry = new int[8];
	public double[] bAry = new double[8];

	public PSSESwitchedShuntDataRec(String lineStr, VersionNo version) {
		StringTokenizer st;
		if (version == VersionNo.Old) {
			// 99214 0 1.000 1.000 0 0.00 1 4.20 1 6.00 1 8.40
			st = new StringTokenizer(PSSE2IpssUtilFunc.removeTailComment(lineStr));
		} else {
			st = new StringTokenizer(PSSE2IpssUtilFunc.removeTailComment(lineStr), ",");
		}

		this.i = new Integer(st.nextToken().trim()).intValue();
		this.modsw = new Integer(st.nextToken().trim()).intValue();
		this.vswhi = new Double(st.nextToken().trim()).doubleValue();
		this.vswlo = new Double(st.nextToken().trim()).doubleValue();
		this.swrem = new Integer(st.nextToken().trim()).intValue();
		if (version != VersionNo.Old) {
			String str = st.nextToken().trim();
			if (!str.startsWith("'")) {
				this.rmpct = new Double(str).doubleValue();
				str = st.nextToken().trim();
			}
			this.rminit = str;
		}
		this.binit = new Double(st.nextToken().trim()).doubleValue();
		if (st.hasMoreTokens())
			this.nAry[0] = new Integer(st.nextToken().trim()).intValue();;
		if (st.hasMoreTokens())
			this.bAry[0] = new Double(st.nextToken().trim()).doubleValue();
		if (st.hasMoreTokens())
			this.nAry[1] = new Integer(st.nextToken().trim()).intValue();;
		if (st.hasMoreTokens())
			this.bAry[1] = new Double(st.nextToken().trim()).doubleValue();
		if (st.hasMoreTokens())
			this.nAry[2] = new Integer(st.nextToken().trim()).intValue();;
		if (st.hasMoreTokens())
			this.bAry[2] = new Double(st.nextToken().trim()).doubleValue();
		if (st.hasMoreTokens())
			this.nAry[3] = new Integer(st.nextToken().trim()).intValue();;
		if (st.hasMoreTokens())
			this.bAry[3] = new Double(st.nextToken().trim()).doubleValue();
		if (st.hasMoreTokens())
			this.nAry[4] = new Integer(st.nextToken().trim()).intValue();;
		if (st.hasMoreTokens())
			this.bAry[4] = new Double(st.nextToken().trim()).doubleValue();
		if (st.hasMoreTokens())
			this.nAry[5] = new Integer(st.nextToken().trim()).intValue();;
		if (st.hasMoreTokens())
			this.bAry[5] = new Double(st.nextToken().trim()).doubleValue();
		if (st.hasMoreTokens())
			this.nAry[6] = new Integer(st.nextToken().trim()).intValue();;
		if (st.hasMoreTokens())
			this.bAry[6] = new Double(st.nextToken().trim()).doubleValue();
		if (st.hasMoreTokens())
			this.nAry[7] = new Integer(st.nextToken().trim()).intValue();;
		if (st.hasMoreTokens())
			this.bAry[7] = new Double(st.nextToken().trim()).doubleValue();
	}
	
	public void processSwitchedShunt(
			AclfAdjNetwork adjNet, 
			IPSSMsgHub msg) throws Exception {
		/*
			I,MODSW,VSWHI,VSWLO,SWREM,RMINIT,NAME(PSS/E30),BINIT,N1,B1,N2,B2...N8,B8
				I - Bus number
				MODSW - Mode 0 - fixed 1 - discrete 2 - continuous
				VSWHI - Desired voltage upper limit, per unit
				VSWLO - Desired voltage lower limit, per unit
				SWREM - Number of remote bus to control. 0 to control own bus.
				RMPCT - Percent of the total Mvar required to hold the voltage at the bus controlled by bus
                            I that are to be contributed by this switched shunt; RMPCT must be positive.
                NAME -             
				BINIT - Initial switched shunt admittance, MVAR at 1.0 per unit volts
				N1 - Number of steps for block 1, first 0 is end of blocks
				B1 - Admittance increment of block 1 in MVAR at 1.0 per unit volts.
				N2, B2, etc, as N1, B1
		 */
		String iStr = new Integer(this.i).toString();
		AclfBus bus = adjNet.getAclfBus(iStr);
		if (bus == null) {
			throw new Exception ("Bus not found in the network, bus number: " + this.i);
		}		
		
		PSSESwitchedShunt shunt = ExtensionObjectFactory.createPSSESwitchedShunt();
		shunt.setId(iStr);
		shunt.setName("SwitchedShunt@Bus:" + iStr);
		shunt.setDesc("PSSE SwitchedShunt at Bus " + iStr);
		shunt.setStatus(true);		
		shunt.setMode(this.modsw);
		shunt.setVmax(this.vswhi);
		shunt.setVmax(this.vswlo);
		shunt.setRemoteBusNo(this.swrem);
		shunt.setBinit(this.binit);
		shunt.setRmpct(this.rmpct);
		shunt.setRminit(this.rminit);
		
		for (int i = 0; i < 8; i++) {
			if (this.nAry[i] != 0) {
				shunt.getNAry().add(i, this.nAry[i]);
				shunt.getBAry().add(i, this.bAry[i]);
			}
		}
		bus.getRegDeviceList().add(shunt);
	}	
	
	public String toString() {
		String str = "";
		str += "i, modsw, swrem, vswhi, vswlo, rmpct, binit :" + 
				i + ", " + modsw + ", " + swrem + ", " + vswhi + ", " + vswlo + ", " + rmpct + ", " + binit + "\n";
		str += "name, rminit:" 
				+ name + ", " + rminit + "\n";
		for (int i = 0; i < 8; i++) {
			str += this.nAry[i] + ", " + this.bAry[i];
		}
		return str + "\n";
	}
}
