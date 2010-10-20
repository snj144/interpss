 /*
  * @(#)CR_UserTestCases.java   
  *
  * Copyright (C) 2008 www.interpss.org
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
  * @Date 02/15/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.core.adapter.psse;

import org.interpss.BaseTestSetup;
import org.interpss.custom.exchange.psse.PSSESwitchedShuntDataRec;
import org.interpss.custom.exchange.psse.PSSEDataRec.VersionNo;
import org.junit.Test;

import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.netAdj.AclfAdjNetwork;
import com.interpss.pssl.simu.IpssAclf;

public class SwitchedShuntTestCases extends BaseTestSetup {
	@Test
	public void Xfr3WTestCase() throws Exception {
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
		String l1 = "63010,2,1.02600,1.02600,     0,  100.0,'            ',  -13.76, 1,*******, 1,1216.00";

  		AclfAdjNetwork adjNet = CoreObjectFactory.createAclfAdjNetwork();
  		IpssAclf.addAclfBus("63010", "", adjNet);
  		
  		PSSESwitchedShuntDataRec rec = new PSSESwitchedShuntDataRec(l1, VersionNo.PSS_E_30);
		rec.processSwitchedShunt(adjNet, msg);
		
		System.out.println(adjNet.net2String());
	}
}

