 /*
  * @(#)PSSEFormat_in.java   
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

package org.interpss.custom.exchange.impl;

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

import org.interpss.custom.exchange.IpssFileAdapterBase;
import org.interpss.custom.exchange.psse.PSSEBranchDataProcessor;
import org.interpss.custom.exchange.psse.PSSEBusDataProcessor;
import org.interpss.custom.exchange.psse.PSSEDCLintDataProcessor;
import org.interpss.custom.exchange.psse.PSSEDataRec;
import org.interpss.custom.exchange.psse.PSSENetDataProcessor;
import org.interpss.custom.exchange.psse.PSSESwitchedShuntDataProcessor;
import org.interpss.custom.exchange.psse.PSSE2IpssUtilFunc;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.ext.ExtensionObjectFactory;
import com.interpss.ext.psse.aclf.PSSEAclfNetwork;


public class PSSEFormat_in extends IpssFileAdapterBase {
	/** 
	 * First input data into the PSSEAclfNetwork object and then transfer the data into InterPSS model
	 *
	 * @param din input file stream
	 * @param msg the message hub object
	 */
	public static PSSEAclfNetwork loadFile(
				java.io.BufferedReader din, 
				IPSSMsgHub msg,
				PSSEDataRec.VersionNo version) throws Exception {
		PSSEAclfNetwork adjNet = ExtensionObjectFactory.createPSSEAclfNetwork();
  		adjNet.setAllowParallelBranch(true);
  		String lineStr = null;
  		int lineNo = 0;
  		try {
      		boolean headerProcessed = false;
      		boolean busProcessed = false;
      		boolean loadProcessed = false;
      		boolean genProcessed = false;
      		boolean lineProcessed = false;
      		boolean xfrProcessed = false;
      		boolean areaInterProcessed = false;
      		boolean dcLine2TProcessed = false;
      		boolean vscDcLineProcessed = false;
      		boolean switchedShuntProcessed = false;
      		boolean xfrZCorrectionProcessed = false;
      		boolean dcLineMTProcessed = false;
      		boolean multiSectionLineGroupProcessed = false;
      		boolean zoneProcessed = false;
      		boolean interareaTransferProcessed = false;
      		boolean ownerProcessed = false;
      		boolean factsProcessed = false;
      		do {
      			lineStr = din.readLine();
      			if (lineStr != null) {
      				lineNo++;
      				if (!headerProcessed) {
      					if (lineNo == 1 && version == PSSEDataRec.VersionNo.NotDefined) {
      						// check version number
      						if (lineStr.contains("PSS/E-30"))
      							version = PSSEDataRec.VersionNo.PSS_E_30;
      						else if (lineStr.contains("PSS/E-29"))
      							version = PSSEDataRec.VersionNo.PSS_E_29;
      						else {
      							msg.sendWarnMsg("Unsupported PSS/E verion, " + lineStr);
      							version = PSSEDataRec.VersionNo.Old;
      						}
      					}
						if (lineNo == 3) 
      						headerProcessed = true;
						PSSENetDataProcessor.processHeader(adjNet, lineStr, lineNo, version, msg);
      				}
      				else if (!busProcessed) {
						if (PSSE2IpssUtilFunc.isEndRecLine(lineStr)) {
							 busProcessed = true;
							 IpssLogger.getLogger().info("PSS/E Bus record processed");
						}	 
						else {
							PSSEBusDataProcessor.processBus(adjNet, lineStr, lineNo, version, msg);
						}	 
      				}
      				else if (!loadProcessed) {
						if (PSSE2IpssUtilFunc.isEndRecLine(lineStr)) {
							 loadProcessed = true;
							 IpssLogger.getLogger().info("PSS/E Load record processed");
						}
						else {
							PSSEBusDataProcessor.processLoad(adjNet, lineStr, lineNo, version, msg);
						}	 
      				}
      				else if (!genProcessed) {
						if (PSSE2IpssUtilFunc.isEndRecLine(lineStr)) {
							 genProcessed = true;
							 IpssLogger.getLogger().info("PSS/E Gen record processed");
						}
						else {
							PSSEBusDataProcessor.processGen(adjNet, lineStr, lineNo, version, msg);
						}	 
      				}
      				else if (!lineProcessed) {
						if (PSSE2IpssUtilFunc.isEndRecLine(lineStr)) {
							 lineProcessed = true;
							 IpssLogger.getLogger().info("PSS/E Line record processed");
						}
						else {
							PSSEBranchDataProcessor.processLine(adjNet, lineStr, lineNo, version, msg);
						}	 
      				}
      				else if (!xfrProcessed) {
						if (PSSE2IpssUtilFunc.isEndRecLine(lineStr)) {
							 xfrProcessed = true;
							 IpssLogger.getLogger().info("PSS/E Xfr record processed");
						}
						else {
							int n = lineNo;
      						String lineStr2 = din.readLine();
      						String lineStr3 = din.readLine();
      						String lineStr4 = din.readLine();
      						lineNo++; lineNo++; lineNo++;
      						String lineStr5 = "";
      						if (PSSE2IpssUtilFunc.is3WXfr(lineStr)) {
          						lineStr4 = din.readLine();
          						lineNo++;
      						}
							PSSEBranchDataProcessor.processXfr(adjNet, lineStr, lineStr2, lineStr3, lineStr4, lineStr5, n, version, msg);
						}	 
      				}
      				else if (!areaInterProcessed) {
						if (PSSE2IpssUtilFunc.isEndRecLine(lineStr)) {
							 areaInterProcessed = true;
							 IpssLogger.getLogger().info("PSS/E AreaInterchange record processed");
						}
						else {
							PSSENetDataProcessor.processAreaInterchange(adjNet, lineStr, lineNo, version, msg);
						}	 
      				}
      				else if (!dcLine2TProcessed) {
						if (PSSE2IpssUtilFunc.isEndRecLine(lineStr)) {
							 dcLine2TProcessed = true;
							 IpssLogger.getLogger().info("PSS/E DC line record processed");
						}
						else {
      						String lineStr2 = din.readLine();
      						String lineStr3 = din.readLine();
      						lineNo++; lineNo++;
      						PSSEDCLintDataProcessor.processDCLine(adjNet, lineStr, lineStr2, lineStr3, lineNo, msg);
						}	 
      				}
      				else if (!vscDcLineProcessed) {
						if (PSSE2IpssUtilFunc.isEndRecLine(lineStr)) {
							vscDcLineProcessed = true;
							 IpssLogger.getLogger().info("PSS/E vscDcLine record processed");
						}
						else {
      						PSSEDCLintDataProcessor.processVscDCLine(adjNet, lineStr, lineNo, msg);
						}	 
      				}
      				else if (!switchedShuntProcessed) {
						if (PSSE2IpssUtilFunc.isEndRecLine(lineStr)) {
							 switchedShuntProcessed = true;
							 IpssLogger.getLogger().info("PSS/E switched shunt record processed");
						}
						else {
							PSSESwitchedShuntDataProcessor.processSwitchedShunt(adjNet, lineStr, lineNo, version, msg);
						}	 
      				}
      				else if (!xfrZCorrectionProcessed) {
						if (PSSE2IpssUtilFunc.isEndRecLine(lineStr)) {
							xfrZCorrectionProcessed = true;
							IpssLogger.getLogger().info("PSS/E Xfr table record processed");
						}
						else {
							PSSEBranchDataProcessor.processXfrZCorrectionTable(adjNet, lineStr, lineNo, msg);
						}	 
      				}
      				else if (!dcLineMTProcessed) {
						if (PSSE2IpssUtilFunc.isEndRecLine(lineStr)) {
							dcLineMTProcessed = true;
							 IpssLogger.getLogger().info("PSS/E multi terminal DC Line record processed");
						}
						else {
							PSSEDCLintDataProcessor.processMultiTerminalDCLine(adjNet, lineStr, lineNo, msg);
						}	 
      				}
      				else if (!multiSectionLineGroupProcessed) {
						if (PSSE2IpssUtilFunc.isEndRecLine(lineStr)) {
							multiSectionLineGroupProcessed = true;
							 IpssLogger.getLogger().info("PSS/E multi section Line Group record processed");
						}
						else {
							PSSEBranchDataProcessor.processMultiSecLineGroup(adjNet, lineStr, lineNo, version, msg);
						}	 
      				}
      				else if (!zoneProcessed) {
						if (PSSE2IpssUtilFunc.isEndRecLine(lineStr)) {
							zoneProcessed = true;
							 IpssLogger.getLogger().info("PSS/E Zone record processed");
						}
						else {
							PSSENetDataProcessor.processZone(adjNet, lineStr, lineNo, version, msg);
						}	 
      				}
      				else if (!interareaTransferProcessed) {
						if (PSSE2IpssUtilFunc.isEndRecLine(lineStr)) {
							interareaTransferProcessed = true;
							 IpssLogger.getLogger().info("PSS/E Interarea Transfer record processed");
						}
						else {
							PSSENetDataProcessor.processInterareaTransfer(adjNet, lineStr, lineNo, version, msg);
						}	 
      				}
      				else if (!ownerProcessed) {
						if (PSSE2IpssUtilFunc.isEndRecLine(lineStr)) {
							ownerProcessed = true;
							 IpssLogger.getLogger().info("PSS/E Owner record processed");
						}
						else {
							PSSENetDataProcessor.processOwner(adjNet, lineStr, lineNo, version, msg);
						}	 
      				}
      				else if (!factsProcessed) {
						if (PSSE2IpssUtilFunc.isEndRecLine(lineStr)) {
							factsProcessed = true;
							 IpssLogger.getLogger().info("PSS/E FACTS record processed");
						}
						else {
							PSSESwitchedShuntDataProcessor.processFACTS(adjNet, lineStr, lineNo, msg);
						}	 
      				}
      				
      			}
    		} while (lineStr != null);
  		} catch (Exception e) {
    		throw new Exception("PSSE data input error, line no " + lineNo + ", " + e.toString());
  		}
  		
  		if (PSSE2IpssUtilFunc.transferData(adjNet, msg))
  			return adjNet;
  		else
  			return null;
	}
}