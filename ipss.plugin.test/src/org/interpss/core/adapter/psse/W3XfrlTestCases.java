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
import org.interpss.custom.exchange.psse.PSSEXfrDataRec;
import org.interpss.custom.exchange.psse.PSSEDataRec.VersionNo;
import org.junit.Test;

import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.pssl.simu.IpssAclf;

public class W3XfrlTestCases extends BaseTestSetup {
	@Test
	public void Xfr3WTestCase() throws Exception {
		/*
		Three-winding:
		I,J,K,CKT,CW,CZ,CM,MAG1,MAG2,NMETR,’NAME’,STAT,O1,F1,...,O4,F4
		R1-2,X1-2,SBASE1-2,R2-3,X2-3,SBASE2-3,R3-1,X3-1,SBASE3-1,VMSTAR,ANSTAR
		WINDV1,NOMV1,ANG1,RATA1,RATB1,RATC1,COD,CONT,RMA,RMI,VMA,VMI,NTP,TAB,CR,CX
		WINDV2,NOMV2,ANG2,RATA2,RATB2,RATC2
		WINDV3,NOMV3,ANG3,RATA3,RATB3,RATC3
		 */
		String l1 = "617054,613140,613150,'1 ',2,3,2,     60246,   0.00626,2,'230/69      ',1, 613,1.0000";
		String l2 = "143650,   0.08040,    60.00,     15983,   0.02700,    15.00,     17928,   0.05170,    15.00,0.99101, -30.6977";
		String l3 = "72.0000,  72.000,   0.000,    95.60,   112.00,   112.00, 1,      0,79.20000,64.80000, 1.02790, 1.01040,  33, 0, 0.00000, 0.00000";
		String l4 = "234.000, 240.000,   0.000,   112.00,   140.00,   112.00, 0,      0, 1.10000, 0.90000, 1.10000, 0.90000,  33, 0, 0.00000, 0.00000";
		String l5 = "13.0000,  13.000, -30.000,    28.00,    28.00,    28.00, 0,      0, 1.10000, 0.90000, 1.10000, 0.90000,  33, 0, 0.00000, 0.00000";

  		AclfAdjNetwork adjNet = CoreObjectFactory.createAclfAdjNetwork();
  		IpssAclf.addAclfBus("617054", "", adjNet);
  		IpssAclf.addAclfBus("613140", "", adjNet);
  		IpssAclf.addAclfBus("613150", "", adjNet);
  		
  		
		PSSEXfrDataRec rec = new PSSEXfrDataRec(l1, l2, l3, l4, l5, VersionNo.PSS_E_30);
		rec.processXfr(adjNet, msg);
		
		System.out.println(adjNet.net2String());
	}
}

