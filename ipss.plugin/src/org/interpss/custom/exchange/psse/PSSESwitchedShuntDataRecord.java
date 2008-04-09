 /*
  * @(#)SwitchedShuntDataRecord.java   
  *
  * Copyright (C) 2006 www.interpss.org
  *
  * This program is free software; you can redistribute it and/or
  * modify it under the terms of the GNU LESSER GENERAL PUBLIC LICENSE
  * as published by the Free Software Foundation; either version 2.1
  * of the License, or (at your option) any later version.
  *
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  *
  * @Author Mike Zhou
  * @Version 1.0
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.custom.exchange.psse;

/*
 * PTI PSS/E File input adapter. The implementation is Based on 
 * PSS/E 29, published Oct 2002.
 * 
 */

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.aclfadj.AclfAdjNetwork;


public class PSSESwitchedShuntDataRecord  {
	public static void processSwitchedShunt(
				AclfAdjNetwork adjNet, 
				String lineStr,
				int lineNo, 
				PSSEDataRec.VersionNo version,
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
		PSSEDataRec.ShuntRec rec = new PSSEDataRec.ShuntRec(lineStr, version);

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

		IpssLogger.getLogger().info("Switched shunt data Line:" + lineNo + " " + lineStr);	
	}	
	
	
	public static void processFACTS(
			AclfAdjNetwork adjNet, 
			String lineStr1,
			int lineNo, 
			IPSSMsgHub msg) throws Exception {
		msg.sendWarnMsg("FACTS data record has not been implemented");	
	}	
}