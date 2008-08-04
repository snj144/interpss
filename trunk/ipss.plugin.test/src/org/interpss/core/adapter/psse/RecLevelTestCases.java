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

import static org.junit.Assert.assertTrue;

import org.interpss.BaseTestSetup;
import org.interpss.custom.exchange.psse.PSSEDataRec;
import org.interpss.custom.exchange.psse.PSSESwitchedShuntDataRec;
import org.junit.Test;

public class RecLevelTestCases extends BaseTestSetup {
	@Test
	public void switchedShuntDataPSSE30TestCase() throws Exception {
/*
 * SWITCHED SHUNT DATA
	I,     MODSW, VSWHI,   VSWLO,       SWREM, RMIDNT,                    BINIT, N1,   B1,  N2,   B2, ... N8, B8
	   621,1,     1.05000, 0.95000,     0,     100.0,  '            ',    3.00,  1,   1.20, 1,   1.80";
*/		
		PSSEDataRec.VersionNo version = PSSEDataRec.VersionNo.PSS_E_30;
		String lineStr = "   621,1,1.05000,0.95000,     0,  100.0,'            ',    3.00, 1,   1.20, 1,   1.80";
		PSSESwitchedShuntDataRec rec = new PSSESwitchedShuntDataRec(lineStr, version);
		assertTrue(rec.binit == 3.0);
		
		lineStr = "   640,1,1.05000,0.95000,     0,  100.0,'            ',   16.00, 1,  16.00";
		rec = new PSSESwitchedShuntDataRec(lineStr, version);
		assertTrue(rec.binit == 16.0);
		
		
		lineStr = "   645,1,1.05000,0.95000,     0,  100.0,'            ',  100.00, 1,  25.00, 1,  25.00, 1,  25.00, 1,  25.00";
		rec = new PSSESwitchedShuntDataRec(lineStr, version);
		assertTrue(rec.binit == 100.0);

		/* NEIOS data
	   	40, 1, 1.05, 1.02, 22, '         ', 67.0,  1, 67.0
	   	52, 0, 0,    0,    0,  '         ', -40.0, 1, -40.0
	   	60, 1, 1.06, 1.03, 0,  '         ', 73.0,  2, 36.0
		 */

		lineStr = "   40, 1, 1.05, 1.02, 22, '         ', 67.0,  1, 67.0";
		rec = new PSSESwitchedShuntDataRec(lineStr, version);
		assertTrue(rec.nAry[0] == 1);
		assertTrue(rec.bAry[0] == 67.0);

		lineStr = "   52, 0, 0,    0,    0,  '         ', -40.0, 1, -40.0";
		rec = new PSSESwitchedShuntDataRec(lineStr, version);
		assertTrue(rec.nAry[0] == 1);
		assertTrue(rec.bAry[0] == -40.0);
		
		lineStr = "   60, 1, 1.06, 1.03, 0,  '         ', 73.0,  2, 36.0";
		rec = new PSSESwitchedShuntDataRec(lineStr, version);
		assertTrue(rec.nAry[0] == 2);
		assertTrue(rec.bAry[0] == 36.0);
	}

	@Test
	public void switchedShuntDataPSSEOldTestCase() throws Exception {
//80017 0  1.000  1.000     0       0.00   2   19.84                                                                                       /* [SHEPPARD] */
//80024 0  1.000  1.000     0       0.00   1   18.94  1   19.76  1   21.60   

		PSSEDataRec.VersionNo version = PSSEDataRec.VersionNo.Old;
		String lineStr = "80017 0  1.000  1.000     0       0.00   2   19.84                                                                                       /* [SHEPPARD] */";
		PSSESwitchedShuntDataRec rec = new PSSESwitchedShuntDataRec(lineStr, version);
		assertTrue(rec.binit == 0.0);

		lineStr = "80024 0  1.000  1.000     0       0.00   1   18.94  1   19.76  1   21.60";
		rec = new PSSESwitchedShuntDataRec(lineStr, version);
		assertTrue(rec.binit == 0.0);
		
	}
	
	@Test
	public void versionNoTestCase() throws Exception {
		assertTrue(PSSEDataRec.getVersion(" 0,    100.00, 30, 0, 0, 60.00       / July 29, 2008 15:37:47", msg)
						== PSSEDataRec.VersionNo.PSS_E_30);
		assertTrue(PSSEDataRec.getVersion("0,   100.00          / PSS/E-30.0    TUE, FEB 26 2008   9:19", msg)
						== PSSEDataRec.VersionNo.PSS_E_30);
		assertTrue(PSSEDataRec.getVersion(" 0,    100.00, 29, 0, 0, 60.00       / July 29, 2008 15:38:08", msg)
						== PSSEDataRec.VersionNo.PSS_E_29);
	}
	
}

