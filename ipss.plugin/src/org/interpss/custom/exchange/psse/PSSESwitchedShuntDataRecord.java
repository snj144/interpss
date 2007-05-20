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
 * The following records are implemented
 * 
 * 		Case Identification
		Bus Data
		Gnerator Data
		Nontransformer Branch Data
		Transformer Data
		Area Interchange Data
 */

import java.util.StringTokenizer;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.aclfadj.AclfAdjNetwork;


public class PSSESwitchedShuntDataRecord  {
	public static void processSwitchedShunt(
				AclfAdjNetwork adjNet, 
				String lineStr,
				int lineNo, 
				IPSSMsgHub msg) throws Exception {
		msg.sendWarnMsg("Swithced Shunt data record has not been implemented");

		/*
		I,MODSW,VSWHI,VSWLO,SWREM,BINIT,N1,B1,N2,B2...N8,B8
*/				
  		StringTokenizer st = new StringTokenizer(lineStr);

		int I = new Integer(st.nextToken()).intValue();
		int MODSW = new Integer(st.nextToken()).intValue();
		double VSWHI = new Double(st.nextToken()).doubleValue();
		double VSWLO = new Double(st.nextToken()).doubleValue();
		int SWREM  = new Integer(st.nextToken()).intValue();
		double VDES = new Double(st.nextToken()).doubleValue();
		double BINIT = new Double(st.nextToken()).doubleValue();
		int N1     = new Integer(st.nextToken()).intValue();
		double B1  = new Double(st.nextToken()).doubleValue();
		int N2     = st.hasMoreTokens()? new Integer(st.nextToken()).intValue() : 0;
		double B2  = st.hasMoreTokens()? new Double(st.nextToken()).doubleValue() : 0.0;
		int N3     = st.hasMoreTokens()? new Integer(st.nextToken()).intValue() : 0;
		double B3  = st.hasMoreTokens()? new Double(st.nextToken()).doubleValue() : 0.0;
		int N4     = st.hasMoreTokens()? new Integer(st.nextToken()).intValue() : 0;
		double B4  = st.hasMoreTokens()? new Double(st.nextToken()).doubleValue() : 0.0;
		int N5     = st.hasMoreTokens()? new Integer(st.nextToken()).intValue() : 0;
		double B5  = st.hasMoreTokens()? new Double(st.nextToken()).doubleValue() : 0.0;
		int N6     = st.hasMoreTokens()? new Integer(st.nextToken()).intValue() : 0;
		double B6  = st.hasMoreTokens()? new Double(st.nextToken()).doubleValue() : 0.0;
		int N7     = st.hasMoreTokens()? new Integer(st.nextToken()).intValue() : 0;
		double B7  = st.hasMoreTokens()? new Double(st.nextToken()).doubleValue() : 0.0;
		int N8     = st.hasMoreTokens()? new Integer(st.nextToken()).intValue() : 0;
		double B8  = st.hasMoreTokens()? new Double(st.nextToken()).doubleValue() : 0.0;

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