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
		assertTrue(new Double(rec.binit).doubleValue() == 3.0);
		
		lineStr = "   640,1,1.05000,0.95000,     0,  100.0,'            ',   16.00, 1,  16.00";
		rec = new PSSESwitchedShuntDataRec(lineStr, version);
		assertTrue(new Double(rec.binit).doubleValue() == 16.0);
		
		
		lineStr = "   645,1,1.05000,0.95000,     0,  100.0,'            ',  100.00, 1,  25.00, 1,  25.00, 1,  25.00, 1,  25.00";
		rec = new PSSESwitchedShuntDataRec(lineStr, version);
		assertTrue(new Double(rec.binit).doubleValue() == 100.0);
	}

	@Test
	public void switchedShuntDataPSSEOldTestCase() throws Exception {
//80017 0  1.000  1.000     0       0.00   2   19.84                                                                                       /* [SHEPPARD] */
//80024 0  1.000  1.000     0       0.00   1   18.94  1   19.76  1   21.60   

		PSSEDataRec.VersionNo version = PSSEDataRec.VersionNo.Old;
		String lineStr = "80017 0  1.000  1.000     0       0.00   2   19.84                                                                                       /* [SHEPPARD] */";
		PSSESwitchedShuntDataRec rec = new PSSESwitchedShuntDataRec(lineStr, version);
		assertTrue(new Double(rec.binit).doubleValue() == 0.0);

		lineStr = "80024 0  1.000  1.000     0       0.00   1   18.94  1   19.76  1   21.60";
		rec = new PSSESwitchedShuntDataRec(lineStr, version);
		assertTrue(new Double(rec.binit).doubleValue() == 0.0);
	}
}

