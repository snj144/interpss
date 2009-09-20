/*
 * @(#)PSSEV30Adapter.java   
 *
 * Copyright (C) 2006-2009 www.interpss.org
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
 * @Date 02/11/2008
 * 
 *   Revision History
 *   ================
 *
 */
package org.ieee.pes.odm.pss.adapter.psse.v30;

import java.util.StringTokenizer;
import java.util.logging.Logger;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.StudyCaseXmlType;
import org.ieee.pes.odm.pss.adapter.AbstractODMAdapter;
import org.ieee.pes.odm.pss.adapter.IFileReader;
import org.ieee.pes.odm.pss.adapter.ge.GE_PSLF_Adapter.VersionNo;
import org.ieee.pes.odm.pss.adapter.psse.PsseVersion;
import org.ieee.pes.odm.pss.adapter.psse.v30.impl.PSSEV30BusDataRec;
import org.ieee.pes.odm.pss.adapter.psse.v30.impl.PSSEV30GenDataRec;
import org.ieee.pes.odm.pss.adapter.psse.v30.impl.PSSEV30LineDataRec;
import org.ieee.pes.odm.pss.adapter.psse.v30.impl.PSSEV30LoadDataRec;
import org.ieee.pes.odm.pss.adapter.psse.v30.impl.PSSEV30NetDataRec;
import org.ieee.pes.odm.pss.adapter.psse.v30.impl.PSSEV30XfrDataRec;
import org.ieee.pes.odm.pss.model.ODMModelParser;
import org.ieee.pes.odm.pss.model.ParserHelper;

public class PSSEV30Adapter extends AbstractODMAdapter{
	public final static String Token_CaseDesc = "Case Description";     
	public final static String Token_CaseId = "Case ID";				

	public PSSEV30Adapter(Logger logger) {
		super(logger);
	}
	
	protected ODMModelParser parseInputFile(
			final IFileReader din) throws Exception {
		ODMModelParser parser = new ODMModelParser();
		ParserHelper.setLFTransInfo(parser, StudyCaseXmlType.ContentInfo.OriginalDataFormat.PSS_E);
		parser.getStudyCase().getContentInfo().setOriginalFormatVersion("PSSEV30");

		PSSNetworkXmlType baseCaseNet = parser.getBaseCase();
		// no space is allowed for ID field
		baseCaseNet.setId("Base_Case_from_PSS_E_format");

		PsseVersion version = PsseVersion.PSSE_30;
		
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
      		
      		int busCnt = 0, loadCnt = 0, genCnt = 0, lineCnt = 0, xfrCnt = 0, xfrZTableCnt = 0,
      		    areaInterCnt = 0, dcLineCnt = 0, vscDcLineCnt = 0, mtDcLineCnt = 0, factsCnt = 0,
      		    switchedShuntCnt = 0, ownerCnt = 0, interTransCnt = 0, zoneCnt = 0, multiSecCnt = 0;
      		
      		do {
      			lineStr = din.readLine();
      			if (lineStr != null) {
      				lineNo++;
      				if (!headerProcessed) {
						if (lineNo == 3) 
      						headerProcessed = true;
						PSSEV30NetDataRec.HeaderRec.procLine(lineStr, lineNo, version, baseCaseNet);
      				}
      				else if (!busProcessed) {
						if (isEndRecLine(lineStr)) {
							 busProcessed = true;
							 getLogger().info("PSS/E Bus record processed");
						}	 
						else {
							PSSEV30BusDataRec.procLine(lineStr, version, parser, this.getLogger());
							busCnt++;
						}	 
      				}
      				else if (!loadProcessed) {
						if (isEndRecLine(lineStr)) {
							 loadProcessed = true;
							 getLogger().info("PSS/E Load record processed");
						}
						else {
							PSSEV30LoadDataRec.procLine(lineStr, version, parser, this.getLogger());
							loadCnt++;
						}	 
      				}
      				else if (!genProcessed) {
						if (isEndRecLine(lineStr)) {
							 genProcessed = true;
							 getLogger().info("PSS/E Gen record processed");
						}
						else {
							PSSEV30GenDataRec.procLine(lineStr, version, parser, this.getLogger());
							genCnt++;
						}	 
      				}
      				else if (!lineProcessed) {
						if (isEndRecLine(lineStr)) {
							 lineProcessed = true;
							 getLogger().info("PSS/E Line record processed");

							 /*
							 // because PSS/E allows zero bus base voltage, we need to fix the issue here
							 for (Branch branch : adjNet.getBranchList()) {
								 AclfBranch aclfBra = (AclfBranch)branch;
								 if (aclfBra.getFromBus().getBaseVoltage() <= 0.0 && aclfBra.getToAclfBus().getBaseVoltage() > 0.0) {
									 aclfBra.getFromBus().setBaseVoltage(aclfBra.getToBus().getBaseVoltage());
									 getLogger().warning("Bus base voltage set to :" + aclfBra.getToBus().getBaseVoltage() 
											 + " @" + aclfBra.getFromBus().getId());
								 }
								 else if (aclfBra.getToAclfBus().getBaseVoltage() <= 0.0 && aclfBra.getFromBus().getBaseVoltage() > 0.0) {
									 aclfBra.getToBus().setBaseVoltage(aclfBra.getFromBus().getBaseVoltage());
									 getLogger().warning("Bus base voltage set to :" + aclfBra.getFromBus().getBaseVoltage() 
											 + " @" + aclfBra.getToBus().getId());
								 }
							 }
							 */
						}
						else {
							PSSEV30LineDataRec.procLine(lineStr, version, parser, this.getLogger());
							lineCnt++;
						}	 
      				}
      				else if (!xfrProcessed) {
						if (isEndRecLine(lineStr)) {
							 xfrProcessed = true;
							 getLogger().info("PSS/E Xfr record processed");
						}
						else {
      						String lineStr2 = din.readLine();
      						String lineStr3 = din.readLine();
      						String lineStr4 = din.readLine();
      						lineNo++; lineNo++; lineNo++;
      						String lineStr5 = "";
      						if (is3WXfr(lineStr)) {
          						lineStr5 = din.readLine();
          						lineNo++;
      						}
							
      						PSSEV30XfrDataRec.procLine(lineStr, lineStr2, lineStr3, lineStr4, lineStr5, version, parser, this.getLogger());
							xfrCnt++;
						}	 
      				}
      				else if (!areaInterProcessed) {
						if (isEndRecLine(lineStr)) {
							 areaInterProcessed = true;
							 getLogger().info("PSS/E AreaInterchange record processed");
						}
						else {
							PSSEV30NetDataRec.processAreaRec(lineStr, baseCaseNet);
							areaInterCnt++;
						}	 
      				}
      				else if (!dcLine2TProcessed) {
						if (isEndRecLine(lineStr)) {
							 dcLine2TProcessed = true;
							 getLogger().info("PSS/E DC line record processed");
						}
						else {
      						String lineStr2 = din.readLine();
      						String lineStr3 = din.readLine();
      						lineNo++; lineNo++;
							//	PSSEDCLineDataRec rec = new PSSEDCLineDataRec(lineStr, lineStr2, lineStr3, version);
							//	rec.processDCLine(adjNet, msg);
							dcLineCnt++;
						}	 
      				}
      				else if (!vscDcLineProcessed) {
						if (isEndRecLine(lineStr)) {
							vscDcLineProcessed = true;
							getLogger().info("PSS/E vscDcLine record processed");
						}
						else {
							//	PSSEVscDCLineDataRec rec = new PSSEVscDCLineDataRec(lineStr, version);
							//	rec.processVscDCLine(adjNet, msg);
							vscDcLineCnt++;
						}	 
      				}
      				else if (!switchedShuntProcessed) {
						if (isEndRecLine(lineStr)) {
							 switchedShuntProcessed = true;
							 getLogger().info("PSS/E switched shunt record processed");
						}
						else {
							//PSSESwitchedShuntDataRec rec = new PSSESwitchedShuntDataRec(lineStr, version);
							//rec.processSwitchedShunt(adjNet, msg);
							switchedShuntCnt++;
						}	 
      				}
      				else if (!xfrZCorrectionProcessed) {
						if (isEndRecLine(lineStr)) {
							xfrZCorrectionProcessed = true;
							getLogger().info("PSS/E Xfr table record processed");
						}
						else {
							//PSSEDataRec.processXfrZCorrectionTable(adjNet, lineStr, lineNo, msg);
							xfrZTableCnt++;
						}	 
      				}
      				else if (!dcLineMTProcessed) {
						if (isEndRecLine(lineStr)) {
							dcLineMTProcessed = true;
							getLogger().info("PSS/E multi terminal DC Line record processed");
						}
						else {
							//	PSSEMultiTermDCLineDataRec rec = new PSSEMultiTermDCLineDataRec(lineStr, version);
							//	rec.processMultiTerminalDCLine(adjNet, msg);
							mtDcLineCnt++;
						}	 
      				}
      				else if (!multiSectionLineGroupProcessed) {
						if (isEndRecLine(lineStr)) {
							multiSectionLineGroupProcessed = true;
							getLogger().info("PSS/E multi section Line Group record processed");
						}
						else {
							//PSSEMultiSecLineDataRec rec = new PSSEMultiSecLineDataRec(lineStr, version);
							//rec.processMultiSecLine(adjNet, msg);
							multiSecCnt++;
						}	 
      				}
      				else if (!zoneProcessed) {
						if (isEndRecLine(lineStr)) {
							zoneProcessed = true;
							getLogger().info("PSS/E Zone record processed");
						}
						else {
							PSSEV30NetDataRec.processZoneRec(lineStr, baseCaseNet);
							//rec.processZone(adjNet, msg);
							zoneCnt++;
						}	 
      				}
      				else if (!interareaTransferProcessed) {
						if (isEndRecLine(lineStr)) {
							interareaTransferProcessed = true;
							getLogger().info("PSS/E Interarea Transfer record processed");
						}
						else {
							PSSEV30NetDataRec.processInterareaTransferRec(lineStr, baseCaseNet);
							interTransCnt++;
						}	 
      				}
      				else if (!ownerProcessed) {
						if (isEndRecLine(lineStr)) {
							ownerProcessed = true;
							getLogger().info("PSS/E Owner record processed");
						}
						else {
							PSSEV30NetDataRec.processOwnerRec(lineStr, baseCaseNet);
							ownerCnt++;
						}	 
      				}
      				else if (!factsProcessed) {
						if (isEndRecLine(lineStr)) {
							factsProcessed = true;
							getLogger().info("PSS/E FACTS record processed");
						}
						else { 
							//PSSEFACTSDataRec rec = new PSSEFACTSDataRec(lineStr, version);
							//rec.processFACTS(adjNet, msg);
							factsCnt++;
						}	 
      				}
      				
      			}
    		} while (lineStr != null);
  		} catch (Exception e) {
  			e.printStackTrace();
    		throw new Exception("PSSE data input error, line no " + lineNo + ", " + e.toString());
  		}
             
  		ParserHelper.createBusEquivData(baseCaseNet, this.getLogger());
  		
   	   	return parser;
	}
	
	/**
	 * PTI use 0 to indicate end of a data set, Bus Data for example. This function checks
	 * if the input line is the end of record line
	 *
	 * @param str a input data line string
	 */
	public static boolean isEndRecLine(String str) {
		return str.startsWith("0") || str.startsWith("/") || str.startsWith("Q");
	}	
	
	public static String trimQuote(String str) {
		return str.substring(1, str.length()-1);
	}
	
	public static boolean is3WXfr(String str) {
		// for 2W xfr, line1, K = 0
  		StringTokenizer st = new StringTokenizer(str, ",");
		st.nextToken();
		st.nextToken();
		int K = new Integer(st.nextToken().trim()).intValue();
		return K != 0;
	}
	
	public static String removeTailComment(String s) {
		if (s.indexOf("/*") > 0)
			return s.substring(0, s.indexOf("/*"));
		else
			return s;
	}	
}
