/*
 * @(#)IeeeCDFAdapter.java   
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
 * @Author Stephen Hou
 * @Version 1.0
 * @Date 08/11/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.ieee.pes.odm.pss.adapter.bpa;

import java.util.StringTokenizer;
import java.util.logging.Logger;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AdjustmentDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AngleXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BranchRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.GenDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBranchDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBusDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NameValuePairListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NameValuePairXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PhaseShiftXfrDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PowerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.StudyCaseXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TransformerDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.YXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZXmlType;
import org.ieee.pes.odm.pss.adapter.AbstractODMAdapter;
import org.ieee.pes.odm.pss.model.IEEEODMPSSModelParser;
import org.ieee.pes.odm.pss.model.ODMData2XmlHelper;
import org.ieee.pes.odm.pss.model.StringUtil;

public class BPAAdapter  extends AbstractODMAdapter {
	public final static String Token_CaseType = "Type";
	public final static String Token_ProjectName = "Original Project Name";
	public final static String Token_CaseId = "Case Identification";

	private static final String Token_Id = "No";
	
	private static final int NetData = 8;	
	private static final int BusData = 1;
	private static final int BranchData = 2;
	private static final int LossZone = 3;
	private static final int InterchangeData = 4;
	private static final int TielineData = 5;
	private static final int TwoTerminalDCLine = 6;
	private static final int MultiTerminalDCLine = 7;
	
	
	public BPAAdapter(Logger logger) {
		super(logger);
	}
	 
	protected IEEEODMPSSModelParser parseInputFile(
			final java.io.BufferedReader din) throws Exception {
		IEEEODMPSSModelParser parser = new IEEEODMPSSModelParser();

		parser.getStudyCase().setOriginalFormat(
				StudyCaseXmlType.OriginalFormat.IEEE_CDF);
		parser.getStudyCase().setAdapterProviderName("www.interpss.org");
		parser.getStudyCase().setAdapterProviderVersion("1.00");

		parser.getStudyCase().setAnalysisCategory(
				StudyCaseXmlType.AnalysisCategory.LOADFLOW);
		parser.getStudyCase().setNetworkCategory(
				StudyCaseXmlType.NetworkCategory.TRANSMISSION);

		PSSNetworkXmlType baseCaseNet = parser.getBaseCase();
		baseCaseNet.setId("Base_Case_from_BPAloadflow_format");

		
		String str="";

		int dataType = 0;
		do {			
			str = din.readLine(); 
			if (!str.trim().equals("(END)")||!str.trim().equals("(STOP)")) {
				try {
					// process the data
					if (str.startsWith(".")||str.startsWith("-9")) {
						dataType = 0;
					} else if (dataType == BusData) {
						processBusData(str, parser.addNewBaseCaseBus());
					} else if (dataType == BranchData) {
						processBranchData(str, parser.addNewBaseCaseBranch(), baseCaseNet);
					} else if (dataType==NetData){
						processNetData(str,baseCaseNet);
					} 
					//else if (dataType == LossZone) {
						//processLossZoneData(str, baseCaseNet.getLossZoneList()
						//		.addNewLossZone());
					//}// else if (dataType == InterchangeData) {
					//	processInterchangeData(str, baseCaseNet
					//			.getInterchangeList().addNewInterchange().addNewIeeeCDFInterchange());
					//} else if (dataType == TielineData) {
					//	processTielineData(str, baseCaseNet.getTieLineList()
					//			.addNewTieline());
					//}
				     else if(str.startsWith("(POWERFLOW")||str.startsWith("/")
							||str.startsWith(">")){
						dataType=NetData;
						getLogger().fine("load header data");
					}else if(str.substring(0, 2).equals("B ")){
						dataType=BusData;
						getLogger().fine("load bus data");
					}else if (str.substring(0, 2).equals("BD")){
						dataType=TwoTerminalDCLine;
					}else if (str.substring(0, 2).equals("BM")){
						dataType=MultiTerminalDCLine;
					}else if (str.substring(0,2).equals("L ")||str.subSequence(0, 2).equals("E ")
							||str.subSequence(0, 2).equals("T ")||str.subSequence(0, 2).equals("R ")){
						dataType=BranchData;
						getLogger().fine("load branch data");
					}else if(str.subSequence(0, 2).equals("A ")){
						dataType=InterchangeData;
						getLogger().fine("load interchange data");
					}else{
						dataType=0;
					}					
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}
			
		} while (!str.trim().equals("(END)")||!str.trim().equals("(STOP)"));

		return parser;
	}

	/*
	 *   Network data
	 *   ============ 
	 */

	private void processNetData(final String str,
			final PSSNetworkXmlType baseCaseNet) {
		// parse the input data line
		final String[] strAry = getNetDataFields(str);

		NameValuePairListXmlType nvList = baseCaseNet.addNewNvPairList();
        //0~4: powerflow, caseID,projectName, baseMVA
		final String caseId = strAry[1];
		if (caseId != null)
			ODMData2XmlHelper.addNVPair(nvList, Token_CaseId, caseId);
		final String projectName = strAry[2];
		if (caseId != null)
			ODMData2XmlHelper.addNVPair(nvList, Token_ProjectName, projectName);
		// more name-vale could be added in future 
		getLogger().fine("caseID, ProjectName: " + caseId + ", "
				+ projectName );
		//[2] Columns 32-37   MVA Base [F] *
		final double baseMva; 
		if(strAry[3]!= null){
			baseMva = new Double(strAry[3]).doubleValue(); // in MVA
		}else {baseMva = 100;}
		getLogger().fine("BaseKva: " + baseMva);
		baseCaseNet.setBasePower(baseMva);
		baseCaseNet.setBasePowerUnit(PSSNetworkXmlType.BasePowerUnit.MVA);
	}

	/*
	 *   Bus data
	 *   ======== 
	 */

	private  void processBusData(final String str,
			final BusRecordXmlType busRec) {
		// parse the input data line
		final String[] strAry = getBusDataFields(str);
        //busType
		final String busType=strAry[0];
		// modification code
		final String modCode=strAry[1];
		//owner code
		final String ownerName=strAry[2];
		//Name
		final String busName = strAry[3];
		final String busId = Token_Id + strAry[3];
		getLogger().fine("Bus data loaded, id: " + busId);
		busRec.setId(busId);		
		busRec.setName(busName);

		//basekv
		double baseKv= new Double(strAry[4]).doubleValue();
		ODMData2XmlHelper.setVoltageData(busRec.addNewBaseVoltage(), baseKv, VoltageXmlType.Unit.KV);
		LoadflowBusDataXmlType busData = busRec.addNewLoadflowBusData();
		
		//zone name
		final String zoneName= strAry[5];
		//****************busRec.setZone(arg0)
		
		//load mw and mvar
		final double loadMw = new Double(strAry[6]).doubleValue();
		final double loadMvar = new Double(strAry[7]).doubleValue();
		if (loadMw != 0.0 || loadMvar != 0.0) {
			ODMData2XmlHelper.setLoadData(busData,
					LoadflowBusDataXmlType.LoadData.Code.CONST_P, loadMw,
					loadMvar, PowerXmlType.Unit.MVA);
		}
		//Shunt mw--> G 
		//Shunt var B -->B
		final double shuntMw= new Double(strAry[8]).doubleValue();
		final double shuntVar= new Double(strAry[9]).doubleValue();       
		final double g = shuntMw/(baseKv*baseKv);
		final double b = shuntVar/(baseKv*baseKv);
		if (g != 0.0 || b != 0.0) {
			ODMData2XmlHelper.setYData(busData.addNewShuntY(), g, b,
					YXmlType.Unit.MHO);
		}		
		// set pGenMax
		final double pGenMax= new Double(strAry[10]).doubleValue();
		busData.addNewGenData().addNewGen().addNewPGenLimit();
		ODMData2XmlHelper.setLimitData(busData.getGenData().getGen()
				.getPGenLimit().addNewPLimit(), pGenMax, 0);
		
		final double pGen= new Double(strAry[11]).doubleValue();
		// qGen for PQ bus, qGenMax for PV bus
		final double qGenOrqGenMax=new Double(strAry[12]).doubleValue();				
		
		final double qGenMin= new Double(strAry[13]).doubleValue();
		
		final double vpu = new Double(strAry[14]).doubleValue();
		//for swing bus, this value is angle(degrees), for others it is vmin.
		final double vMinOrAngDeg= new Double(strAry[15]).doubleValue();
		
		ODMData2XmlHelper.setVoltageData(busData.addNewVoltage(), vpu,
				VoltageXmlType.Unit.PU);

		ODMData2XmlHelper.setAngleData(busData.addNewAngle(), vMinOrAngDeg,
				AngleXmlType.Unit.DEG);
		
		
		if (busType == "B "||busType=="BC"||busType=="BT"||busType=="BV") {//PQ bus
			ODMData2XmlHelper.setGenData(busData,
					LoadflowBusDataXmlType.GenData.Code.PQ, pGen, qGenOrqGenMax,
					PowerXmlType.Unit.MVA);
		} else if (busType == "BE"||busType=="BQ"||busType=="BG"||busType=="BF") {//PV Bus
			ODMData2XmlHelper.setGenData(busData,
					LoadflowBusDataXmlType.GenData.Code.PV, pGen, 0,
					PowerXmlType.Unit.MVA);
		} else if (busType == "BS") {// swing bus
			ODMData2XmlHelper.setGenData(busData,
					LoadflowBusDataXmlType.GenData.Code.SWING, pGen, 0,
					PowerXmlType.Unit.MVA);
		}		
		//for BG and BX, controlled bus name and voltage
		final String remoteBus= strAry[16];
		double vSpecPu=0.0;
		if(!strAry[17].endsWith("")){
			vSpecPu= new Double(strAry[17]).doubleValue();
			//******************needed
		}
		
		
		final double varSupplied= new Double(strAry[18]).doubleValue();
		//for PQ bus, set V limit
		if (busType == "B "||busType=="BC"||busType=="BT"||busType=="BV") {
				if(vpu!=0 ||vMinOrAngDeg!=0){
					busData.getGenData().getGen().addNewVGenLimit();
				    ODMData2XmlHelper.setLimitData(busData.getGenData().getGen().getVGenLimit()
						.addNewVLimit(), vpu, vMinOrAngDeg);
				    busData.getGenData().getGen().getVGenLimit().setVLimitUnit(
						GenDataXmlType.VGenLimit.VLimitUnit.PU);
		        }
		}
		//for PV bus, set Q limit		
		if (busType == "BE"||busType=="BQ"||busType=="BG"||busType=="BF"
			  &&(qGenOrqGenMax !=0||qGenMin!=0)) {
			  
			ODMData2XmlHelper.setGenQLimitData(busData.getGenData(),  
					qGenOrqGenMax, qGenMin, GenDataXmlType.QGenLimit.QLimitUnit.MVAR);
		 }
		// set remote control bus
		if (remoteBus != null) {
				busData.getGenData().getGen().addNewDesiredRemoteVoltage();
				ODMData2XmlHelper.setVoltageData(busData.getGenData().getGen()
						.getDesiredRemoteVoltage().addNewDesiredVoltage(),
						vSpecPu, VoltageXmlType.Unit.PU);
				busData.getGenData().getGen().getDesiredRemoteVoltage()
						.addNewRemoteBus();
				busData.getGenData().getGen().getDesiredRemoteVoltage()
						.getRemoteBus().setIdRef(remoteBus);
		}		
	}

	/*
	 *   Branch data
	 *   =========== 
	 */

	private void processBranchData(final String str,
			final BranchRecordXmlType branchRec, PSSNetworkXmlType baseCaseNet) {
		// process symetry branch data
		if(str.startsWith("L ")){
			final String[] strAry = getBranchDataFields(str);
			// symetry  branch
			final String branchType=strAry[0];

			final String modCode =strAry[1];
			final String owner=strAry[2];
			
			final String fid = Token_Id + strAry[3];
			final String tid = Token_Id + strAry[6];
			getLogger().fine("Branch data loaded, from-id, to-id: " + fid + ", " + tid);
			branchRec.addNewFromBus().setIdRef(fid);
			branchRec.addNewToBus().setIdRef(tid);
			
			final double fVol= new Double(strAry[4]).doubleValue();
			final double tVol= new Double(strAry[7]).doubleValue();
			
			//*****************set fromside and toside voltage
			
			
			// measure location for power interchange, 1--from side, 2- to side
			if(!strAry[5].equals("")){
				final int measureLocation= new Integer(strAry[5]).intValue();

			}
			final String cirId = strAry[8];
			branchRec.setCircuitId(cirId);
			
			branchRec.setId(ODMData2XmlHelper.formBranchId(fid, tid, cirId));
			branchRec.addNewLoadflowBranchData();
			
			branchRec.getLoadflowBranchData().setCode(LoadflowBranchDataXmlType.Code.LINE);
			
			final String multiSectionId = strAry[9];
			//set rated current
			final double currentRating = new Integer(strAry[10]).intValue();
			ODMData2XmlHelper.setBranchRatingLimitData(branchRec.getLoadflowBranchData(), 
					currentRating, LoadflowBranchDataXmlType.RatingLimit.CurrentRatingUnit.AMP);

			final double rpu = new Double(strAry[12]).doubleValue();
			final double xpu = new Double(strAry[13]).doubleValue();
			final double halfGpu = new Double(strAry[14]).doubleValue();
			final double halfBpu = new Double(strAry[15]).doubleValue();
			ODMData2XmlHelper.setLineData(branchRec.getLoadflowBranchData(), rpu, xpu,
					ZXmlType.Unit.PU, 2*halfGpu, 2*halfBpu, YXmlType.Unit.PU);
   		    
			//branch length
			final double length = new Double(strAry[16]).doubleValue();
			branchRec.getLoadflowBranchData().getLineData().setLength(length);
			//****************************** unit remaining
			
			final String desc= strAry[17];
			NameValuePairXmlType nvPair = branchRec.getLoadflowBranchData().getLineData().
			                              addNewNvPairList().addNewNvPair();
            nvPair.setName("branch description");
            nvPair.setValue(desc);
            
		}else if(str.startsWith("E ")){
			final String[] strAry = getBranchDataFields(str);
			// asymetry branch
			final String branchType=strAry[0];
			branchRec.getLoadflowBranchData().setCode(LoadflowBranchDataXmlType.Code.LINE);

			final String modCode =strAry[1];
			final String owner=strAry[2];
			
			final String fid = Token_Id + strAry[3];
			final String tid = Token_Id + strAry[6];
			getLogger().fine("Branch data loaded, from-id, to-id: " + fid + ", " + tid);
			branchRec.addNewFromBus().setIdRef(fid);
			branchRec.addNewToBus().setIdRef(tid);
			
			final double fVol= new Double(strAry[4]).doubleValue();
			final double tVol= new Double(strAry[7]).doubleValue();
			
			//*****************set fromside and toside voltage
			
			
			// measure location for power interchange, 1--from side, 2- to side
			final int measureLocation= new Integer(strAry[5]).intValue();
			final String cirId = strAry[8];
			branchRec.setCircuitId(cirId);
			
			branchRec.setId(ODMData2XmlHelper.formBranchId(fid, tid, cirId));
			branchRec.addNewLoadflowBranchData();
			
			final String multiSectionId = strAry[9];
			//set rated current
			final double currentRating = new Integer(strAry[10]).intValue();
			ODMData2XmlHelper.setBranchRatingLimitData(branchRec.getLoadflowBranchData(), 
					currentRating, LoadflowBranchDataXmlType.RatingLimit.CurrentRatingUnit.AMP);

			final double rpu = new Double(strAry[12]).doubleValue();
			final double xpu = new Double(strAry[13]).doubleValue();
			final double G1pu = new Double(strAry[14]).doubleValue();
			final double B1pu = new Double(strAry[15]).doubleValue();
			final double G2pu = new Double(strAry[16]).doubleValue();
			final double B2pu = new Double(strAry[17]).doubleValue();
			// set r, x
			ZXmlType z= branchRec.getLoadflowBranchData().getLineData().addNewZ();
			ODMData2XmlHelper.setZValue(z, rpu, xpu, ZXmlType.Unit.PU);
			// set from side Y1 and to side Y2
			YXmlType y1 =branchRec.getLoadflowBranchData().getLineData().addNewFromShuntY();
			YXmlType y2 =branchRec.getLoadflowBranchData().getLineData().addNewToShuntY();
			ODMData2XmlHelper.setYData(y1, G1pu, B1pu, YXmlType.Unit.PU);
			ODMData2XmlHelper.setYData(y2, G2pu, B2pu, YXmlType.Unit.PU);		    

			
		}else if (str.startsWith("T ")){
			final String[] strAry = getXformerDataFields(str);
			
			final String branchType=strAry[0];
			branchRec.addNewLoadflowBranchData();
			
			if(branchType=="T "){
				branchRec.getLoadflowBranchData().setCode(LoadflowBranchDataXmlType.Code.TRANSFORMER);
			}else{
				branchRec.getLoadflowBranchData().setCode(LoadflowBranchDataXmlType.Code.PHASE_SHIFT_XFORMER);

			}

			final String modCode =strAry[1];
			final String owner=strAry[2];
			
			final String fid = Token_Id + strAry[3];
			final String tid = Token_Id + strAry[6];
			getLogger().fine("Branch data loaded, from-id, to-id: " + fid + ", " + tid);
			branchRec.addNewFromBus().setIdRef(fid);
			branchRec.addNewToBus().setIdRef(tid);
			
			final double fVol= new Double(strAry[4]).doubleValue();
			final double tVol= new Double(strAry[7]).doubleValue();		
			
			// measure location for power interchange, 1--from side, 2- to side
			final int measureLocation= new Integer(strAry[5]).intValue();
			final String cirId = strAry[8];
			branchRec.setCircuitId(cirId);
			
			branchRec.setId(ODMData2XmlHelper.formBranchId(fid, tid, cirId));
			branchRec.addNewLoadflowBranchData();
			
			final String multiSectionId = strAry[9];
			//set rated current
			
			final double MwRating = new Integer(strAry[11]).intValue();
			// set xfr rating data
			ODMData2XmlHelper.setXfrRatingData(branchRec.getLoadflowBranchData().getXformerData(), 
					fVol, tVol,VoltageXmlType.Unit.KV, MwRating, PowerXmlType.Unit.MVA);


			final double rpu = new Double(strAry[12]).doubleValue();
			final double xpu = new Double(strAry[13]).doubleValue();
			final double Gpu = new Double(strAry[14]).doubleValue();
			final double Bpu = new Double(strAry[15]).doubleValue();
			// tap1 tap2 or angle for phase shift
			final double fromTurnRatioOrAngDeg = new Double(strAry[16]).doubleValue();
			final double toTurnRatioOrZero = new Double(strAry[17]).doubleValue();
			

	        // set transformer r x g b and ratio
			if (str.startsWith("T ")){
				ODMData2XmlHelper.setXformerData(branchRec.getLoadflowBranchData(),
						rpu, xpu, ZXmlType.Unit.PU, Gpu, Bpu, 0.0, 0.0,
						YXmlType.Unit.PU);
				branchRec.getLoadflowBranchData().getXformerData()
				.setFromTurnRatio(fromTurnRatioOrAngDeg);
		        branchRec.getLoadflowBranchData().getXformerData()
		        .setToTurnRatio(toTurnRatioOrZero);				
			}else {
			// set phase shift xfr r x g b ratio and angle
				ODMData2XmlHelper.setPhaseShiftXfrData(branchRec.getLoadflowBranchData(), 
						rpu, xpu, ZXmlType.Unit.PU, Gpu, Bpu, 0, 0, YXmlType.Unit.PU);
				ODMData2XmlHelper.setAngleData(branchRec.getLoadflowBranchData().getPhaseShiftXfrData().
						addNewFromAngle(), fromTurnRatioOrAngDeg, AngleXmlType.Unit.DEG);
				ODMData2XmlHelper.setAngleData(branchRec.getLoadflowBranchData().getPhaseShiftXfrData().
						addNewToAngle(), 0, AngleXmlType.Unit.DEG);				
				branchRec.getLoadflowBranchData().getXformerData()
				.setFromTurnRatio(fromTurnRatioOrAngDeg);
		        branchRec.getLoadflowBranchData().getXformerData()
		        .setToTurnRatio(toTurnRatioOrZero);	
			}
		}else if (str.startsWith("R ")){
			final String[] strAry = getXfrAdjustDataFields(str);
			//adjustType: R or RV---remote bus control
			final String adjustType = strAry[0];
			final String modCode = strAry[1];
			final String owner = strAry[2];
			final String fromBus =strAry[3];
			final double fromTurnRatedV = new Double(strAry[4]).doubleValue();
			final String toBus = strAry[6];
			final double toTurnRatedV = new Double(strAry[7]).doubleValue();
			
			BranchRecordXmlType branchRec_old= ODMData2XmlHelper.getBranchRecord(fromBus, 
					toBus, " ", baseCaseNet);
			TransformerDataXmlType.TapAdjustment tapAdj = branchRec_old.getLoadflowBranchData().
			                                getXformerData().addNewTapAdjustment();
			PhaseShiftXfrDataXmlType.AngleAdjustment angAdj = branchRec_old.getLoadflowBranchData().
			                                getPhaseShiftXfrData().addNewAngleAdjustment();
			String controlBusId = "";
			// set tapAdjSide
			final int tapAdjSide = new Integer(strAry[5]).intValue();
			if(tapAdjSide==2){
				tapAdj.setTapAdjOnFromSide(false);
				controlBusId=toBus;
			}else{
				tapAdj.setTapAdjOnFromSide(true);
				controlBusId=fromBus;
			}			
			final String adjBus =strAry[8];
			final String adjVol =strAry[9];			
			int controlSide = 0;
			double   stepSize=0.0,maxVoltPQ = 0.0, minVoltPQ = 0.0;
			final double max = new Double(strAry[9]).doubleValue();
			final double min = new Double(strAry[10]).doubleValue();
			final double totalTap =new Double(strAry[11]).doubleValue();
			// calculate stepsize
			if (totalTap!=0.0){
				stepSize =(max-min)/totalTap;
			}
			// scheduled P or Q
			final double schedulePQ = new Double(strAry[12]).doubleValue();
			// Minimum  MVAR or MW limit [F]
			// Maximum  MVAR or MW limit [F]
			maxVoltPQ = new Double(strAry[13]).doubleValue();
			minVoltPQ = new Double(strAry[14]).doubleValue();
			

			if (adjustType.equals("R ")||adjustType.equals("RV")
					||adjustType.equals("RQ")||adjustType.equals("RN")) {// voltage and var control

				ODMData2XmlHelper.setLimitData(tapAdj.addNewTapLimit(), max,
						min);
				tapAdj.setTapAdjStepSize(stepSize);
				if (adjustType.endsWith("R ")||adjustType.equals("RV") ){// voltage control
					TransformerDataXmlType.TapAdjustment.VoltageAdjData voltTapAdj = tapAdj
							.addNewVoltageAdjData();
					voltTapAdj.addNewAdjVoltageBus().setIdRef(controlBusId);
					voltTapAdj
							.setAdjBusLocation((adjBus == toBus ? TransformerDataXmlType.TapAdjustment.VoltageAdjData.AdjBusLocation.NEAR_TO_BUS
											: TransformerDataXmlType.TapAdjustment.VoltageAdjData.AdjBusLocation.NEAR_FROM_BUS));
					voltTapAdj.setMode(AdjustmentDataXmlType.Mode.RANGE_ADJUSTMENT);
					ODMData2XmlHelper.setLimitData(voltTapAdj.addNewDesiredRange(),
							maxVoltPQ, minVoltPQ);
					
				} else if (adjustType.equals("RQ")||adjustType.equals("RN")) {// var control
					TransformerDataXmlType.TapAdjustment.MvarFlowAdjData mvarTapAdj = tapAdj
							.addNewMvarFlowAdjData();
					ODMData2XmlHelper.setLimitData(mvarTapAdj.addNewDesiredRange(),
							maxVoltPQ, minVoltPQ);
					mvarTapAdj.setMode(AdjustmentDataXmlType.Mode.RANGE_ADJUSTMENT);
					mvarTapAdj.setMvarMeasuredOnFormSide(true);
				}
			} else if (adjustType.startsWith("RP")||adjustType.startsWith("RM")) {// mw control
				ODMData2XmlHelper.setLimitData(angAdj.addNewAngleDegLimit(), max,
						min);
				ODMData2XmlHelper.setLimitData(angAdj.addNewDesiredRange(), maxVoltPQ,
						minVoltPQ);
				angAdj.setMode(AdjustmentDataXmlType.Mode.RANGE_ADJUSTMENT);
				angAdj.setDesiredMeasuredOnFromSide(true);
			}			
		}else if (str.startsWith("LD")){
			
		}
		
	}

	/*
	 *   Loss Zone data
	 *   ============== 
	 */
/*
	private void processLossZoneData(final String str,
			final PSSNetworkXmlType.LossZoneList.LossZone lossZone) {
		final String[] strAry = getLossZoneDataFields(str);

		//    	Columns  1- 3   Loss zone number [I] *
		//    	Columns  5-16   Loss zone name [A] 
		final int no = new Integer(strAry[0]).intValue();
		final String name = strAry[1];
		lossZone.setZoneNumber(no);
		lossZone.setZoneName(name);
	}

	/*
	 *   Interchange data
	 *   ================ 
	 */

/*	private void processInterchangeData(final String str,
			final PSSNetworkXmlType.InterchangeList.Interchange.IeeeCDFInterchange interchange) {
		final String[] strAry = getInterchangeDataFields(str);

		//    	Columns  1- 2   Area number [I], no zeros! *
		final int no = new Integer(strAry[0]).intValue();

		//    	Columns  4- 7   Interchange slack bus number [I] *
		//      Columns  9-20   Alternate swing bus name [A]
		final String slackBusId = Token_Id + strAry[1];
		final String alSwingBusName = strAry[2];

		//      Columns 21-28   Area interchange export, MW [F] (+ = out) *
		//      Columns 30-35   Area interchange tolerance, MW [F] *
		final double mw = new Double(strAry[3]).doubleValue();
		final double err = new Double(strAry[4]).doubleValue();

		//      Columns 38-43   Area code (abbreviated name) [A] *
		//      Columns 46-75   Area name [A]
		final String code = strAry[5];
		final String name = strAry[6];

		interchange.setAreaNumber(no);
		interchange.addNewSwingBus().setIdRef(slackBusId);
		interchange.setAlternateSwingBusName(alSwingBusName);
		ODMData2XmlHelper.setPowerData(interchange.addNewInterchangePower(), mw, 0.0, PowerXmlType.Unit.MVA);
		interchange.setInterchangeErrTolerance(err);

		interchange.setAreaCode(code);
		interchange.setAreaName(name);
	}

	/*
	 *   Tieline data
	 *   ============ 
	 */

/*	private void processTielineData(final String str,
			final PSSNetworkXmlType.TieLineList.Tieline tieLine) {
		final String[] strAry = getTielineDataFields(str);

		//    	Columns  1- 4   Metered bus number [I] *
		//    	Columns  7-8    Metered area number [I] *
		final String meteredBusId = Token_Id + strAry[0];
		final int meteredAreaNo = new Integer(strAry[1]).intValue();

		//      Columns  11-14  Non-metered bus number [I] *
		//      Columns  17-18  Non-metered area number [I] *
		final String nonMeteredBusId = Token_Id + strAry[2];
		final int nonMeteredAreaNo = new Integer(strAry[3]).intValue();

		//      Column   21     Circuit number
		int cirNo = 0;
		if (!strAry[4].trim().equals(""))
			cirNo = new Integer(strAry[4]).intValue();

		tieLine.addNewMeteredBus().setIdRef(meteredBusId);
		tieLine.setMeteredAreaNumber(meteredAreaNo);
		tieLine.addNewNonMeteredBus().setIdRef(nonMeteredBusId);
		tieLine.setNonMeteredAreaNumber(nonMeteredAreaNo);
		tieLine.setCirId(new Integer(cirNo).toString());
	}

	/*
	 * util functions
	 */
	private String[] getNetDataFields(final String str) {
		final String[] strAry = new String[6];

		//the first line data
		if(str.startsWith("(POWERFLOW")){
			strAry[0]="POWERFLOW";
			final StringTokenizer st = new StringTokenizer(str, ",");
			int cnt=1;			
			while (st.hasMoreTokens()&&cnt<=2){
				String st2 =st.nextToken().trim();
				final StringTokenizer stInside =new StringTokenizer(st2, "=");
				String st3=stInside.nextToken().trim();
				strAry[cnt++]=st3;
			}			
		}
		// select certain concerned data to added
		//strAry[4]= baseMVA
		if(str.startsWith("/MVA_BASE")){
			final StringTokenizer st = new StringTokenizer(str, "=");
			strAry[3]=st.nextToken().trim();
		}
		
	   return strAry;
	}

	private String[] getBusDataFields(final String str) {
		final String[] strAry = new String[19];

			//Columns  1- 2   Bus type
		    strAry[0] = str.substring(0, 2).trim();
			
			//Columns  3 code for modification			
			strAry[1] = str.substring(2, 3).trim();
			//Columns 3-5   owner code
			//Columns 6-13 busName  14-17 rated voltage
			strAry[2] = str.substring(3, 6).trim();
			strAry[3] = str.substring(6, 14).trim();
			strAry[4] = str.substring(14, 18).trim();
			//Columns 18-19   zone name
			strAry[5] = str.substring(18, 20).trim();

			//Columns 20-24   Load MW [F] *
			//Columns 25-29   Load MVAR [F] *
			strAry[6] = str.substring(20, 25).trim();;
			strAry[7] = str.substring(25, 30).trim();;
			if(strAry[6].equals("")){
				strAry[6]="0";
			}if(strAry[7].equals("")){
				strAry[7]="0";
			}
			
			//Columns 30-33   shunt MW [F] *
			//Columns 34-39   shunt MVAR [F] *
			strAry[8] = str.substring(30, 34).trim();;
			strAry[9] = str.substring(34, 38).trim();;
			if(strAry[8].equals("")){
				strAry[8]="0";
			}if(strAry[9].equals("")){
				strAry[9]="0";
			}
			// Columns 38-41 pmax
			// Columns 42-46 pmax
			strAry[10] = str.substring(38, 42).trim();;
			strAry[11] = str.substring(42, 47).trim();
			if(strAry[10].equals("")){
				strAry[10]="0";
			}if(strAry[11].equals("")){
				strAry[11]="0";
			}
			//Qmax Qmin
			strAry[12]= str.substring(47, 52).trim();
			strAry[13]= str.substring(52, 57).trim();
			if(strAry[12].equals("")){
				strAry[12]="0";
			}if(strAry[13].equals("")){
				strAry[13]="0";
			}
			//scheduled V or Vmax, Vmin
			strAry[14]= str.substring(57, 61).trim();
			strAry[15]= str.substring(61, 65).trim();
			if(strAry[14].equals("")){
				strAry[14]="0";
			}if(strAry[15].equals("")){
				strAry[15]="0";
			}

			//remoted busName, rated voltage
			strAry[16]= str.substring(65, 73).trim();
			strAry[17]= str.substring(73, 77).trim();
			// used in remoted bus control, var fraction
			strAry[18]= str.substring(77, 80).trim();
			
			

		
		return strAry;
	}

	private String[] getBranchDataFields(final String str) {
		final String[] strAry = new String[20];
		strAry[0] = str.substring(0, 2).trim();
        strAry[1] = str.substring(2, 3).trim();
		strAry[2] = str.substring(3, 6).trim();		
		strAry[3] = str.substring(6, 14).trim();
		strAry[4] = str.substring(14, 18).trim();
		strAry[5] = str.substring(18, 19).trim();
		strAry[6] = str.substring(19, 27).trim();
		strAry[7] = str.substring(27, 31).trim();
		strAry[8] = str.substring(31, 32).trim();
		strAry[9] = str.substring(32, 33).trim();
		strAry[10] = str.substring(33, 37).trim();
		strAry[11] = str.substring(37, 38).trim();
		strAry[12] = str.substring(38, 44).trim();
		strAry[13] = str.substring(44, 50).trim();
		strAry[14] = str.substring(50, 56).trim();
		strAry[15] = str.substring(56, 62).trim();
		if(strAry[0]=="L"){
			strAry[16] = str.substring(62, 66).trim();
			strAry[17] = str.substring(66, 74).trim();
		}else{
			strAry[16] = str.substring(62, 67).trim();
			strAry[17] = str.substring(68, 74).trim();
		}		
		strAry[18] = str.substring(74, 77).trim();		
		strAry[19] = str.substring(77, 80).trim();		
            
		return strAry;
    }
	
	private String[] getXformerDataFields(final String str) {
		final String[] strAry = new String[20];
		
            strAry[0] = str.substring(0, 2).trim();
            strAry[1] = str.substring(2, 3).trim();
			strAry[2] = str.substring(3, 6).trim();
			
			strAry[3] = str.substring(6, 14).trim();
			strAry[4] = str.substring(14, 18).trim();
			strAry[5] = str.substring(18, 19).trim();
			strAry[6] = str.substring(19, 27).trim();

			strAry[7] = str.substring(27, 31).trim();
			strAry[8] = str.substring(31, 32).trim();
			strAry[9] = str.substring(32, 33).trim();
			strAry[10] = str.substring(33, 37).trim();
			strAry[11] = str.substring(37, 38).trim();
			strAry[12] = str.substring(38, 44).trim();
			strAry[13] = str.substring(44, 50).trim();
			strAry[14] = str.substring(50, 56).trim();
			strAry[15] = str.substring(56, 62).trim();
			strAry[16] = str.substring(62, 67).trim();
			
			strAry[17] = str.substring(67, 72).trim();
			strAry[18] = str.substring(74, 77).trim();
			
			strAry[19] = str.substring(77, 80).trim();
						

		return strAry;
    }
	
	private String[] getXfrAdjustDataFields(final String str) {
		final String[] strAry = new String[15];
            // type 		
            strAry[0] = str.substring(0, 2).trim();
            strAry[1] = str.substring(2, 3).trim();
			strAry[2] = str.substring(3, 6).trim();
			//from bus name
			strAry[3] = str.substring(6, 14).trim();
			// rated v
			strAry[4] = str.substring(14, 18).trim();
			strAry[5] = str.substring(18, 19).trim();
			//to bus name
			strAry[6] = str.substring(19, 27).trim();
			// to rated v
			strAry[7] = str.substring(27, 31).trim();
			// controlled bus name and rated v
			strAry[8] = str.substring(33, 41).trim();
			strAry[9] = str.substring(41, 45).trim();
			
			//for R RV RQ RN
			//max tap
			strAry[10] = str.substring(45, 50).trim();
			// min tap
			strAry[11] = str.substring(50, 55).trim();
			// total tap
			strAry[12] = str.substring(55, 57).trim();
			
			strAry[13] = str.substring(57, 62).trim();
			strAry[14] = str.substring(62, 67).trim();			
						

		return strAry;
    }



	private String[] getLossZoneDataFields (final String str) {
		final String[] strAry = new String[2];

		if (str.indexOf(',') >= 0) {
			final StringTokenizer st = new StringTokenizer(str, ",");
			int cnt = 0;
			while (st.hasMoreTokens()) {
				strAry[cnt++] = st.nextToken().trim();
			}
		} else {
			strAry[0] = str.substring(0, 3).trim();
			strAry[1] = str.substring(4).trim();
		}
		return strAry;
	}

	private String[] getInterchangeDataFields(final String str) {
		final String[] strAry = new String[7];

		if (str.indexOf(',') >= 0) {
			final StringTokenizer st = new StringTokenizer(str, ",");
			int cnt = 0;
			while (st.hasMoreTokens()) {
				strAry[cnt++] = st.nextToken().trim();
			}
		} else {
			//        	Columns  1- 2   Area number [I], no zeros! *
			strAry[0] = str.substring(0, 2).trim();

			//        	Columns  4- 7   Interchange slack bus number [I] *
			//          Columns  9-20   Alternate swing bus name [A]
			strAry[1] = str.substring(3, 7).trim();
			strAry[2] = str.substring(8, 20).trim();

			//          Columns 21-28   Area interchange export, MW [F] (+ = out) *
			//          Columns 30-35   Area interchange tolerance, MW [F] *
			strAry[3] = str.substring(20, 28);
			strAry[4] = str.substring(29, 35);

			//          Columns 38-43   Area code (abbreviated name) [A] *
			//          Columns 46-75   Area name [A]
			strAry[5] = str.substring(37, 43);
			strAry[6] = str.substring(45).trim();
		}
		return strAry;
	}

	private String[] getTielineDataFields(final String str) {
		final String[] strAry = new String[5];

		if (str.indexOf(',') >= 0) {
			final StringTokenizer st = new StringTokenizer(str, ",");
			int cnt = 0;
			while (st.hasMoreTokens()) {
				strAry[cnt++] = st.nextToken().trim();
			}
		} else {
			//        	Columns  1- 4   Metered bus number [I] *
			//        	Columns  7-8    Metered area number [I] *
			strAry[0] = str.substring(0, 4).trim();
			strAry[1] = str.substring(6, 8).trim();

			//          Columns  11-14  Non-metered bus number [I] *
			//          Columns  17-18  Non-metered area number [I] *
			strAry[2] = str.substring(10, 14).trim();
			strAry[3] = str.substring(16, 18).trim();

			//          Column   21     Circuit number
			strAry[4] = str.substring(20, 21);
		}
		return strAry;
	}
}