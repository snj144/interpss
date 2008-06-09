 /*
  * @(#)GEFormat_in.java   
  *
  * Copyright (C) 2006-2008 www.interpss.org
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
  * @Date 05/01/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.custom.exchange.impl;

import org.interpss.custom.exchange.ge.BranchSecDataRec;
import org.interpss.custom.exchange.ge.BusDataRec;
import org.interpss.custom.exchange.ge.GEDataRec;
import org.interpss.custom.exchange.ge.GenDataRec;
import org.interpss.custom.exchange.ge.LoadDataRec;
import org.interpss.custom.exchange.ge.ShuntDataRec;
import org.interpss.custom.exchange.ge.XformerDataRec;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.ext.ExtensionObjectFactory;
import com.interpss.ext.ge.aclf.GeAclfBus;
import com.interpss.ext.ge.aclf.GeAclfNetwork;

public class GEFormat_in {
	public static final String Token_CommentLine1 = "!";
	public static final String Token_CommentLine2 = "!";
	public static final String Token_Title = "title";
	public static final String Token_Comments = "comments";
	public static final String Token_SolutionParameters = "solution parameters";
	public static final String Token_BusData = "bus data";
	public static final String Token_BranchSectionData = "branch data";
	public static final String Token_TransformerData = "transformer data";
	public static final String Token_GeneratorData = "generator data";
	public static final String Token_LoadData = "load data";
	public static final String Token_ShuntData = "shunt data";
	public static final String Token_ControlledShuntData = "svd data";
	public static final String Token_AreaData = "area data";
	public static final String Token_ZoneData = "zone data";
	public static final String Token_Interfacedata = "interface data";
	public static final String Token_InterfaceBranchData = "interface branch data";
	public static final String Token_DCBusData = "dc bus data";
	public static final String Token_DCLineData = "dc line data";
	public static final String Token_DCConverterData = "dc converter data";
	public static final String Token_TransformerImpedanceAdjustmentData = "z table data";
	public static final String Token_UPFCData  = "gcd data";
	public static final String Token_TransactionData = "transaction data";
	public static final String Token_OwnerData = "owner data";
	public static final String Token_InductionMotorData = "motor data";
	public static final String Token_LineData = "line data";
	public static final String Token_GeneratorReactiveCapabilityCurves = "qtable data";
	public static final String Token_End = "end";
		
	public static enum RecType {Title, Comments, SolutionParameters,
				BusData, BranchSecData, XfrData, GenData,
				LoadData, ShuntData, ConShuntData,
				AreaData, ZoneData, InterfaceData, InterfaceBranchData,
				DCBusData, DCLineData, DCConverterData,
				XfrZAdjData, UPFCData, TransactionData,
				OwnerData, InductMotorData, LineData, GenQCurves,
				End, NotDefined};

	public static GeAclfNetwork loadFile(java.io.BufferedReader din, String filename, 
						GEDataRec.VersionNo version, IPSSMsgHub msg) throws Exception {
		GeAclfNetwork  adjNet = ExtensionObjectFactory.createGeAclfNetwork();
    	adjNet.setAllowParallelBranch(true);

		GEDataRec.TitleRec titleRec = new GEDataRec.TitleRec();
		GEDataRec.CommentsRec commentRec = new GEDataRec.CommentsRec();
		GEDataRec.SolutionParamRec solParamRec = new GEDataRec.SolutionParamRec();

		RecType recType = RecType.NotDefined; 
  		String lineStr = null;
  		int lineNo = 0;
  		try {
      		do {
      			lineStr = din.readLine();
  				lineNo++;
      			if (lineStr != null && !lineStr.startsWith(Token_CommentLine1) && !lineStr.startsWith(Token_CommentLine2)) {
      				while (lineStr.endsWith("/")) {
      					lineStr = lineStr.substring(0, lineStr.indexOf("/")) + din.readLine();
      	  				lineNo++;
      				}
      				//System.out.println(lineStr);
      				
      				if (lineStr.startsWith(Token_Title)) {
      					recType = RecType.Title;
      				}
      				else if (lineStr.startsWith(Token_Comments)) {
      					recType = RecType.Comments;
      				}
      				else if (lineStr.startsWith(Token_SolutionParameters)) {
      					recType = RecType.SolutionParameters;
      				}
      				else if (lineStr.startsWith(Token_BusData)) {
      					recType = RecType.BusData;
      				}
      				else if (lineStr.startsWith(Token_BranchSectionData)) {
      					recType = RecType.BranchSecData;
      				}
      				else if (lineStr.startsWith(Token_TransformerData)) {
      					recType = RecType.XfrData;
      				}
      				else if (lineStr.startsWith(Token_GeneratorData)) {
      					recType = RecType.GenData;
      				}
      				else if (lineStr.startsWith(Token_LoadData)) {
      					recType = RecType.LoadData;
      				}
      				else if (lineStr.startsWith(Token_ShuntData)) {
      					recType = RecType.ShuntData;
      				}
      				else if (lineStr.startsWith(Token_ControlledShuntData)) {
      					recType = RecType.ConShuntData;
      				}
      				else if (lineStr.startsWith(Token_AreaData)) {
      					recType = RecType.AreaData;
      				}
      				else if (lineStr.startsWith(Token_ZoneData)) {
      					recType = RecType.ZoneData;
      				}
      				else if (lineStr.startsWith(Token_Interfacedata)) {
      					recType = RecType.InterfaceData;
      				}
      				else if (lineStr.startsWith(Token_InterfaceBranchData)) {
      					recType = RecType.InterfaceBranchData;
      				}
      				else if (lineStr.startsWith(Token_DCBusData)) {
      					recType = RecType.DCBusData;
      				}
      				else if (lineStr.startsWith(Token_DCLineData)) {
      					recType = RecType.DCLineData;
      				}
      				else if (lineStr.startsWith(Token_DCConverterData)) {
      					recType = RecType.DCConverterData;
      				}
      				else if (lineStr.startsWith(Token_TransformerImpedanceAdjustmentData)) {
      					recType = RecType.XfrZAdjData;
      				}
      				else if (lineStr.startsWith(Token_UPFCData)) {
      					recType = RecType.UPFCData; 
      				}
      				else if (lineStr.startsWith(Token_TransactionData)) {
      					recType = RecType.TransactionData;
      				}
      				else if (lineStr.startsWith(Token_OwnerData)) {
      					recType = RecType.OwnerData;
      				}
      				else if (lineStr.startsWith(Token_InductionMotorData)) {
      					recType = RecType.InductMotorData; 
      				}
      				else if (lineStr.startsWith(Token_LineData)) {
      					recType = RecType.LineData;
      				}
      				else if (lineStr.startsWith(Token_GeneratorReactiveCapabilityCurves)) {
      					recType = RecType.GenQCurves;
      				}
      				else if (lineStr.startsWith(Token_End)) {
      					recType = RecType.End;
      				}
      				else {
      					if (recType == RecType.Title) {
      						titleRec.processLineStr(lineStr, version);
      					}
      					else if (recType == RecType.Comments) {
      						commentRec.processLineStr(lineStr, version);
      					}
      					else if (recType == RecType.SolutionParameters) {
      						solParamRec.processLineStr(lineStr, version);
      					}
      					else if (recType == RecType.BusData) {
      						// process BusData
      						BusDataRec rec = new BusDataRec(lineStr, version);
      						//System.out.println(rec);
      						GeAclfBus  bus = ExtensionObjectFactory.createGeAclfBus();
      						rec.setAclfBus(bus);
      						adjNet.addBus(bus, bus.getGeAreaNo(), bus.getGeZoneNo(), new Integer(bus.getGeOwnerNo()).toString());
      					}
      					else if (recType == RecType.BranchSecData) {
      						// process Branch section Data
      						BranchSecDataRec rec = new BranchSecDataRec(lineStr, version);
      						//System.out.println(rec);
      						rec.setBranchSection(adjNet, msg);
      					}
      					else if (recType == RecType.XfrData) {
      						// process Xfr Data
      						XformerDataRec rec = new XformerDataRec(lineStr, version);
      						rec.setXfrData(adjNet, msg);
      					}
      					else if (recType == RecType.GenData) {
      						// process Gen Data
      						GenDataRec rec = new GenDataRec(lineStr, version);
      						rec.setGen(adjNet, msg);
      					}
      					else if (recType == RecType.LoadData) {
      						// process Line Data
      						LoadDataRec rec = new LoadDataRec(lineStr, version);
      						rec.setLoad(adjNet, msg);
      					}
      					else if (recType == RecType.ShuntData) {
      						// process Shunt Data
      						ShuntDataRec rec = new ShuntDataRec(lineStr, version);
      					}
      					else if (recType == RecType.ConShuntData) {
      						// process Controlled Data
      						System.out.println("ControlledShuntData:" + lineStr);
      					}
      					else if (recType == RecType.AreaData) {
      						// process Area Data
      						GEDataRec.AreaRec rec = new GEDataRec.AreaRec(lineStr, version);
      						rec.setAreaData(adjNet);
      					}
      					else if (recType == RecType.ZoneData) {
      						// process Zone Data
      						GEDataRec.ZoneRec rec = new GEDataRec.ZoneRec(lineStr, version);
      						rec.setZoneData(adjNet);
      					}
      					else if (recType == RecType.InterfaceData) {
      						// process Interface Data
      						GEDataRec.InterfaceRec rec = new GEDataRec.InterfaceRec(lineStr, version);
      						rec.setInterfaceData(adjNet);
      					}
      					else if (recType == RecType.InterfaceBranchData) {
      						// process Interface Branch Data
      						GEDataRec.InterfaceBranchRec rec = new GEDataRec.InterfaceBranchRec(lineStr, version);
      						rec.setInterfaceBranchData(adjNet, msg);
      					}
      					else if (recType == RecType.DCBusData) {
      						// process DCBus Data
      						System.out.println("DCBusData:" + lineStr);
      					}
      					else if (recType == RecType.DCLineData) {
      						// process DCLine Data
      						System.out.println("DCLineData:" + lineStr);
      					}
      					else if (recType == RecType.DCConverterData) {
      						// process DCCon Data
      						System.out.println("DCConData:" + lineStr);
      					}
      					else if (recType == RecType.XfrZAdjData) {
      						// process XfrZAdj Data
      						System.out.println("XfrZAdjData:" + lineStr);
      					}
      					else if (recType == RecType.UPFCData) {
      						// process UPF Data
      						System.out.println("UPFData:" + lineStr);
      					} 
      					else if (recType == RecType.TransactionData) {
      						// process Transaction Data
      						System.out.println("TranData:" + lineStr);
      					}
      					else if (recType == RecType.OwnerData) {
      						// process Owner Data
      						GEDataRec.OwnerRec rec = new GEDataRec.OwnerRec(lineStr, version);
      						rec.setOwnerData(adjNet);
      					}
      					else if (recType == RecType.InductMotorData) {
      						// process InductMotor Data
      						System.out.println("IndMotorData:" + lineStr);
      					} 
      					else if (recType == RecType.LineData) {
      						// process Line Data
      						System.out.println("LineData:" + lineStr);
      					}
      					else if (recType == RecType.GenQCurves) {
      						// process GenQCurve Data
      						System.out.println("GenQCurveData:" + lineStr);
      					}
      					else if (recType == RecType.End) {
      						// date after end, doing nothing
      					}
      				}
      			}
    		} while (lineStr != null);
  		} catch (Exception e) {
    		throw new Exception("GE data input error, line no " + lineNo + ", " + e.toString());
  		}

  		//System.out.println(titleRec);
  		//System.out.println(commentRec);
  		
  		adjNet.setId("GELoadFlowData"+version);
  		adjNet.setName(titleRec.title);
  		adjNet.setDesc(commentRec.comments);
  		
  		//System.out.println(solParamRec);
  		solParamRec.setAclfNet(adjNet);
  		
  		return adjNet;
    }
}
