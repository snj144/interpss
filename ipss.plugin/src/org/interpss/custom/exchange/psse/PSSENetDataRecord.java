 /*
  * @(#)NetDataRecord.java   
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

import com.interpss.common.datatype.UnitType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.aclfadj.AreaInterchangeController;
import com.interpss.core.net.Owner;
import com.interpss.core.net.Zone;

public class PSSENetDataRecord {
	/** 
	 * Process the first three header line records
	 *
	 * @param adjNet the AclfAdjNetwork object
	 * @param lineStr a input line string
	 * @param lineNo the line number
	 * @param msgHub the message hub object
	 */
	public static boolean processHeader(
				AclfAdjNetwork adjNet, 
				String lineStr,
				int lineNo, 
				PSSEDataRec.VersionNo version,
				IPSSMsgHub msg) throws Exception {
		IpssLogger.getLogger().fine("Header data Line:" + lineNo + " " + lineStr);
		if (lineNo == 1) {
			PSSEDataRec.HeaderRec hrec = new PSSEDataRec.HeaderRec(lineStr, version);
			
			double baseMva = new Double(hrec.baseMva).doubleValue();
    		adjNet.setBaseKva(baseMva*1000.0);
			
			// PSS/E do not have ground branch concept
			adjNet.setAllowGroundBranch(false);
			
			// PSS/E allow parallel branches
			adjNet.setAllowParallelBranch(true);
			
			// We check if there is any Bus number or branch duplication. Branch dupblication defined as
			// branches with same circuit id connected between the same from bus and to bus.
			adjNet.setCheckElementDuplication(true);

			// Base Frequency is not used in loadflow calculation, dedined as 60.0 Hz
			adjNet.setFrequency(60.0);
		}
		else if (lineNo == 2) {
			// The 2nd line is treated as description
			adjNet.setDesc(lineStr);
		}
		else {
			// the 3rd line is treated as the network id and network name
			adjNet.setId(lineStr);
			adjNet.setName(lineStr);
		}
		return true;
	}			
	/** 
	 * Process area interchange record lines
	 *
	 * @param adjNet the AclfAdjNetwork object
	 * @param lineStr a input line string
	 * @param lineNo the line number
	 * @param msgHub the message hub object
	 */
	public static void processAreaInterchange(
				AclfAdjNetwork adjNet, 
				String lineStr,
				int lineNo, 
				PSSEDataRec.VersionNo version,
				IPSSMsgHub msgHub) throws Exception {
/*
		I,ISW,PDES,PTOL,'ARNAM'
*/
		PSSEDataRec.AreaInterchangeRec rec = new PSSEDataRec.AreaInterchangeRec(lineStr, version);

		int I = new Integer(rec.i).intValue();
		int ISW = new Integer(rec.isw).intValue();
		double PDES = new Double(rec.pdes).doubleValue();
		double PTOL = new Double(rec.ptol).doubleValue();
		String ARNAM = PSSEUtilFunc.trimQuote(rec.arnam);

		IpssLogger.getLogger().fine("Area interchange data Line:" + lineNo + "-->" + lineStr);
		IpssLogger.getLogger().fine("Area number, Swing Bus Number:" + I + ", " + ISW);
		IpssLogger.getLogger().fine("Pspec, Perror, Name:" + PDES + ", " + PTOL + ", "  + ARNAM);
		
		AreaInterchangeController controller = CoreObjectFactory.createAreaInterchangeController(I, ARNAM, adjNet);
		AclfBus bus = adjNet.getAclfBus(new Integer(ISW).toString());
		if (bus == null) {
			throw new Exception("Area interchange poewr controller, Swing bus not found, ISW: " + ISW);
		}
		controller.setAclfBus(bus);
		controller.setPSpecOut(PDES, UnitType.mW, adjNet.getBaseKva());
		controller.setTolerance(PTOL, UnitType.mW, adjNet.getBaseKva());
	}		
	
	public static void processZone(
			AclfAdjNetwork adjNet, 
			String lineStr,
			int lineNo, 
			PSSEDataRec.VersionNo version,
			IPSSMsgHub msg) throws Exception {
		/*
		 * Format: I, ’ZONAME’
		 */
		PSSEDataRec.ZoneRec rec = new PSSEDataRec.ZoneRec(lineStr, version);

		int I = new Integer(rec.i).intValue();
		String NAME = PSSEUtilFunc.trimQuote(rec.name);
		
		IpssLogger.getLogger().fine("Zone data Line:" + lineNo + "-->" + lineStr);
		IpssLogger.getLogger().fine("Zone number, name:" + I + ", " + NAME);
		
      	Zone zone = CoreObjectFactory.createZone(I, adjNet);
		zone.setName(NAME);
	}	

	public static void processInterareaTransfer(
			AclfAdjNetwork adjNet, 
			String lineStr,
			int lineNo, 
			PSSEDataRec.VersionNo version,
			IPSSMsgHub msg) throws Exception {
		/*
		 * format: ARFROM, ARTO, TRID, PTRAN
		 */
		PSSEDataRec.InterareaTransferRec rec = new PSSEDataRec.InterareaTransferRec(lineStr, version);

		int ARFROM = new Integer(rec.arfrom).intValue();
		int ARTO = new Integer(rec.arto).intValue();
		String TRID = PSSEUtilFunc.trimQuote(rec.trid);
		double PTRAN = new Double(rec.ptran).doubleValue();
		
		IpssLogger.getLogger().fine("Interarea transfer data Line:" + lineNo + "-->" + lineStr);
		IpssLogger.getLogger().fine("From area number, From area number, id, value:" 
				+ ARFROM + ", " + ARTO  + ", " + TRID  + ", " + PTRAN);
		// TODO: data error checking to be implemeted
	}	

	public static void processOwner(
			AclfAdjNetwork adjNet, 
			String lineStr,
			int lineNo, 
			PSSEDataRec.VersionNo version,
			IPSSMsgHub msg) throws Exception {
		/*
		 * format : I, ’OWNAME’
		 */
		PSSEDataRec.OwnerRec rec = new PSSEDataRec.OwnerRec(lineStr, version);

		int I = new Integer(rec.i).intValue();
		String NAME = PSSEUtilFunc.trimQuote(rec.name);
		
		IpssLogger.getLogger().fine("Owner data Line:" + lineNo + "-->" + lineStr);
		IpssLogger.getLogger().fine("Owner number, name:" + I + ", " + NAME);
		
      	Owner owner = CoreObjectFactory.createOwner(new Integer(I).toString(), adjNet);
		owner.setName(NAME);
	}
	

	public static void processMultiSectionLineGroup(
			AclfAdjNetwork adjNet, 
			String lineStr,
			int lineNo, 
			PSSEDataRec.VersionNo version,
			IPSSMsgHub msg) throws Exception {
		/*
		 * format: I, J, ID, DUM1, DUM2, ... DUM9
		 * 
		 * J is entered as a negative number or with a minus sign before the
		 * first character of the extended bus name to designate it as the metered end; otherwise,
		 * bus I is assumed to be the metered end.
		 */
		PSSEDataRec.MultiSectionLineGroupRec rec = new PSSEDataRec.MultiSectionLineGroupRec(lineStr, version);

		int I = new Integer(rec.i).intValue();
		int J = new Integer(rec.j).intValue();
		String ID = PSSEUtilFunc.trimQuote(rec.i);
		
		IpssLogger.getLogger().fine("Multi-Section Line Group data Line:" + lineNo + "-->" + lineStr);
		IpssLogger.getLogger().fine("From area number, From area number, id:" + I + ", " + J  + ", " + ID);		
		
		// TODO: needs implemented
	}	
}