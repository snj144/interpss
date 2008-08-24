

/*
 * @(#)PSSEBranchRecord.java   
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
 * @Author Stephen Hau, Mike Zhou
 * @Version 1.0
 * @Date 02/11/2008
 * 
 *   Revision History
 *   ================
 *
 */
package org.ieee.pes.odm.pss.adapter.bpa;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AdjustmentDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AngleXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BranchRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LengthXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBranchDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NameValuePairXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PhaseShiftXfrDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PowerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TransformerDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.YXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZXmlType;
import org.ieee.pes.odm.pss.model.ODMData2XmlHelper;

public class BPABranchRecord {
	public static void processBranchData(final String str, final BranchRecordXmlType branchRec, 
			final PSSNetworkXmlType baseCaseNet,BPAAdapter adapter) {		
		// symmetry line data
		if(str.startsWith("L ")){
			final String[] strAry = getBranchDataFields(str);
			// symetry  branch
			final String branchType=strAry[0];

			final String modCode =strAry[1];
			final String owner=strAry[2];
			
			final String fid =  strAry[3];
			final String tid =  strAry[6];
			adapter.getLogger().fine("Branch data loaded, from-Bus, to-Bus: " + fid + ", " + tid);
			if(!fid.equals("")){
				branchRec.addNewFromBus().setIdRef(fid);
			}
			if(!tid.equals("")){
				branchRec.addNewToBus().setIdRef(tid);
			}
			
			double fVol=0.0;
			double tVol=0.0;
			if(!strAry[4].equals("")){
				fVol= new Double(strAry[4]).doubleValue();
			}
			if(!strAry[7].equals("")){
				tVol= new Double(strAry[4]).doubleValue();
			}	
			
			//*****************set fromside and toside voltage if necessary
			
			
			// measure location for power interchange, 1--from side, 2- to side
			//set transfer power measured location in tie line data 
			int measureLocation=0;
			if(!strAry[5].equals("")){
				measureLocation= new Integer(strAry[5]).intValue();
				if(measureLocation==1){
					// set tieline data
					PSSNetworkXmlType.TieLineList.Tieline tieLine=baseCaseNet.getTieLineList().addNewTieline();
					tieLine.addNewMeteredBus().setName(fid);
					tieLine.addNewNonMeteredBus().setName(tid);	
					
					BusRecordXmlType busRecFrom=ODMData2XmlHelper.getBusRecord(fid, baseCaseNet);
					busRecFrom.getZone();
					PSSNetworkXmlType.AreaList.Area areaFrom=ODMData2XmlHelper.
					  getAreaRecordByZone(busRecFrom.getZone(), baseCaseNet);
					tieLine.setMeteredArea(areaFrom.getAreaName());
					
					BusRecordXmlType busRecTo=ODMData2XmlHelper.getBusRecord(tid, baseCaseNet);
					busRecTo.getZone();
					PSSNetworkXmlType.AreaList.Area areaTo=ODMData2XmlHelper.
					  getAreaRecordByZone(busRecTo.getZone(), baseCaseNet);
					tieLine.setNonMeteredArea(areaTo.getAreaName());
					// to do: set area number
					
				}else{
					PSSNetworkXmlType.TieLineList.Tieline tieLine=baseCaseNet.getTieLineList().addNewTieline();
					tieLine.addNewMeteredBus().setName(tid);
					tieLine.addNewNonMeteredBus().setName(fid);					
					ODMData2XmlHelper.getBusRecord(fid, baseCaseNet).getZone();
					
					BusRecordXmlType busRecFrom=ODMData2XmlHelper.getBusRecord(tid, baseCaseNet);
					busRecFrom.getZone();
					PSSNetworkXmlType.AreaList.Area areaFrom=ODMData2XmlHelper.
					  getAreaRecordByZone(busRecFrom.getZone(), baseCaseNet);
					tieLine.setMeteredArea(areaFrom.getAreaName());
					
					BusRecordXmlType busRecTo=ODMData2XmlHelper.getBusRecord(fid, baseCaseNet);
					busRecTo.getZone();
					PSSNetworkXmlType.AreaList.Area areaTo=ODMData2XmlHelper.
					  getAreaRecordByZone(busRecTo.getZone(), baseCaseNet);
					tieLine.setNonMeteredArea(areaTo.getAreaName());
					// to do: set area number
				}
			}
			
			// set cirId, if not specified, set to 1
			String cirId="";
			if(!strAry[8].equals("")){
				cirId = strAry[8];
				branchRec.setCircuitId(cirId);
			}else{
				branchRec.setCircuitId("1");
			}			
			
			branchRec.addNewLoadflowBranchData();
			branchRec.setId(ODMData2XmlHelper.formBranchId(fid, tid, cirId));			
			branchRec.getLoadflowBranchData().setCode(LoadflowBranchDataXmlType.Code.LINE);
			
			String multiSectionId="";
			if(!strAry[9].equals("")){
				multiSectionId = strAry[9];
				//set multiSection data if necessary
			}			
			//if currentRating!=0.0,set rated current
			double currentRating=0.0;
			if(!strAry[10].equals("")){
				currentRating = new Double(strAry[10]).doubleValue();
				ODMData2XmlHelper.setBranchRatingLimitData(branchRec.getLoadflowBranchData(), 
						currentRating, LoadflowBranchDataXmlType.RatingLimit.CurrentRatingUnit.AMP);
			}			 
			double rpu=0.0, xpu=0.0001, halfGpu=0.0, halfBpu=0.0;
			if(!strAry[12].equals("")){
				rpu = new Double(strAry[12]).doubleValue();
			}
			if(!strAry[13].equals("")){
				xpu = new Double(strAry[13]).doubleValue();
			}
			if(!strAry[14].equals("")){
				halfGpu = new Double(strAry[14]).doubleValue();
			}
			if(!strAry[15].equals("")){
				halfBpu = new Double(strAry[15]).doubleValue();
			} 
			ODMData2XmlHelper.setLineData(branchRec.getLoadflowBranchData(), rpu, xpu,
					ZXmlType.Unit.PU, 2*halfGpu, 2*halfBpu, YXmlType.Unit.PU);
   		    
			//branch length
			double length=0.0;
			if(!strAry[16].equals("")){
				
			branchRec.getLoadflowBranchData().getLineData().
			                         addNewLength().setLength(length);
			branchRec.getLoadflowBranchData().getLineData().
			                         getLength().setUnit(LengthXmlType.Unit.MILE);
			}			
			// if there is a description, set
			String desc= "";
			if(!strAry[17].equals("")){
				desc= strAry[17];
				NameValuePairXmlType nvPair = branchRec.getLoadflowBranchData().getLineData().
                addNewNvPairList().addNewNvPair();
                nvPair.setName("branch description");
                nvPair.setValue(desc);
			}			
			
            
		}else if(str.startsWith("E ")){
			final String[] strAry = getBranchDataFields(str);
			// symetry  branch
			final String branchType=strAry[0];

			final String modCode =strAry[1];
			final String owner=strAry[2];
			
			final String fid = strAry[3];
			final String tid = strAry[6];
			adapter.getLogger().fine("Branch data loaded, from-Bus, to-Bus: " + fid + ", " + tid);
			if(!fid.equals("")){
				branchRec.addNewFromBus().setIdRef(fid);
			}
			if(!tid.equals("")){
				branchRec.addNewToBus().setIdRef(tid);
			}
			
			double fVol=0.0;
			double tVol=0.0;
			if(!strAry[4].equals("")){
				fVol= new Double(strAry[4]).doubleValue();
			}
			if(!strAry[7].equals("")){
				tVol= new Double(strAry[4]).doubleValue();
			}	
			
			//*****************set fromside and toside voltage if necessary
			
			
			// measure location for power interchange, 1--from side, 2- to side
			//set transfer power measured location in tie line data 
			int measureLocation=0;
			if(!strAry[5].equals("")){
				measureLocation= new Integer(strAry[5]).intValue();
				if(measureLocation==1){
					// set tieline data
					PSSNetworkXmlType.TieLineList.Tieline tieLine=baseCaseNet.getTieLineList().addNewTieline();
					tieLine.addNewMeteredBus().setName(fid);
					tieLine.addNewNonMeteredBus().setName(tid);	
					
					BusRecordXmlType busRecFrom=ODMData2XmlHelper.getBusRecord(fid, baseCaseNet);
					busRecFrom.getZone();
					PSSNetworkXmlType.AreaList.Area areaFrom=ODMData2XmlHelper.
					  getAreaRecordByZone(busRecFrom.getZone(), baseCaseNet);
					tieLine.setMeteredArea(areaFrom.getAreaName());
					
					BusRecordXmlType busRecTo=ODMData2XmlHelper.getBusRecord(tid, baseCaseNet);
					busRecTo.getZone();
					PSSNetworkXmlType.AreaList.Area areaTo=ODMData2XmlHelper.
					  getAreaRecordByZone(busRecTo.getZone(), baseCaseNet);
					tieLine.setNonMeteredArea(areaTo.getAreaName());
					// to do: set area number
					
				}else{
					PSSNetworkXmlType.TieLineList.Tieline tieLine=baseCaseNet.getTieLineList().addNewTieline();
					tieLine.addNewMeteredBus().setName(tid);
					tieLine.addNewNonMeteredBus().setName(fid);					
					ODMData2XmlHelper.getBusRecord(fid, baseCaseNet).getZone();
					
					BusRecordXmlType busRecFrom=ODMData2XmlHelper.getBusRecord(tid, baseCaseNet);
					busRecFrom.getZone();
					PSSNetworkXmlType.AreaList.Area areaFrom=ODMData2XmlHelper.
					  getAreaRecordByZone(busRecFrom.getZone(), baseCaseNet);
					tieLine.setMeteredArea(areaFrom.getAreaName());
					
					BusRecordXmlType busRecTo=ODMData2XmlHelper.getBusRecord(fid, baseCaseNet);
					busRecTo.getZone();
					PSSNetworkXmlType.AreaList.Area areaTo=ODMData2XmlHelper.
					  getAreaRecordByZone(busRecTo.getZone(), baseCaseNet);
					tieLine.setNonMeteredArea(areaTo.getAreaName());
					// to do: set area number
				}
			}
			// set cirId, if not specified, set to 1
			String cirId="";
			if(!strAry[8].equals("")){
				cirId = strAry[8];
				branchRec.setCircuitId(cirId);
			}else{
				branchRec.setCircuitId("1");
			}			
			
			branchRec.addNewLoadflowBranchData();
			branchRec.setId(ODMData2XmlHelper.formBranchId(fid, tid, cirId));			
			branchRec.getLoadflowBranchData().setCode(LoadflowBranchDataXmlType.Code.LINE);
			branchRec.getLoadflowBranchData().addNewLineData();
			
			String multiSectionId="";
			if(!strAry[9].equals("")){
				multiSectionId = strAry[9];
				//set multiSection data if necessary
			}
			
			
			//if currentRating!=0.0,set rated current
			double currentRating=0.0;
			if(!strAry[10].equals("")){
				currentRating = new Double(strAry[10]).doubleValue();
				ODMData2XmlHelper.setBranchRatingLimitData(branchRec.getLoadflowBranchData(), 
						currentRating, LoadflowBranchDataXmlType.RatingLimit.CurrentRatingUnit.AMP);
			}			 
			double rpu=0.0, xpu=0.0001, G1pu=0.0, B1pu=0.0, G2pu=0.0, B2pu=0.0;
			if(!strAry[12].equals("")){
				rpu = new Double(strAry[12]).doubleValue();
			}
			if(!strAry[13].equals("")){
				xpu = new Double(strAry[13]).doubleValue();
			}
			if(!strAry[14].equals("")){
				G1pu = new Double(strAry[14]).doubleValue();
			}
			if(!strAry[15].equals("")){
				B1pu = new Double(strAry[15]).doubleValue();
			}
			if(!strAry[16].equals("")){
				G2pu = new Double(strAry[16]).doubleValue();
			}
			if(!strAry[17].equals("")){
				B2pu = new Double(strAry[17]).doubleValue();
			}
			ZXmlType z= branchRec.getLoadflowBranchData().getLineData().addNewZ();
			ODMData2XmlHelper.setZValue(z, rpu, xpu, ZXmlType.Unit.PU);
			YXmlType y1 =branchRec.getLoadflowBranchData().getLineData().addNewFromShuntY();
			YXmlType y2 =branchRec.getLoadflowBranchData().getLineData().addNewToShuntY();
			ODMData2XmlHelper.setYData(y1, G1pu, B1pu, YXmlType.Unit.PU);
			ODMData2XmlHelper.setYData(y2, G2pu, B2pu, YXmlType.Unit.PU);   

			
		}
				
		
	}	
	
	public static void processXfrData(final String str, final BranchRecordXmlType branchRec, 
			final PSSNetworkXmlType baseCaseNet,BPAAdapter adapter){
		
		if (str.startsWith("T ")){
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
			
			final String fid = strAry[3];
			final String tid = strAry[6];
			adapter.getLogger().fine("Branch data loaded, from-bus, to-bus: " + fid + ", " + tid);
			branchRec.addNewFromBus().setIdRef(fid);
			branchRec.addNewToBus().setIdRef(tid);
			
			final double fVol= new Double(strAry[4]).doubleValue();
			final double tVol= new Double(strAry[7]).doubleValue();		
			
			// measure location for power interchange, 1--from side, 2- to side
			int measureLocation=0;
			if(!strAry[5].equals("")){
				measureLocation= new Integer(strAry[5]).intValue();
			}
			 
			final String cirId = strAry[8];
			branchRec.setCircuitId(cirId);
			
			branchRec.setId(ODMData2XmlHelper.formBranchId(fid, tid, cirId));
			branchRec.addNewLoadflowBranchData();
			
			final String multiSectionId = strAry[9];
			//set rated current
			double MwRating=0.0;
			if(!strAry[11].equals("")){
				MwRating = new Integer(strAry[11]).intValue();
			}			
			// set xfr rating data
			ODMData2XmlHelper.setXfrRatingData(branchRec.getLoadflowBranchData().getXformerData(), 
					fVol, tVol,VoltageXmlType.Unit.KV, MwRating, PowerXmlType.Unit.MVA);


			double rpu=0.0, xpu=0.0001, Gpu=0.0, Bpu=0.0;
			if(!strAry[12].equals("")){
				rpu = new Double(strAry[12]).doubleValue();
			}
			if(!strAry[13].equals("")){
				xpu = new Double(strAry[13]).doubleValue();
			}
			if(!strAry[14].equals("")){
				Gpu = new Double(strAry[14]).doubleValue();
			}
			if(!strAry[15].equals("")){
				Bpu = new Double(strAry[15]).doubleValue();
			} 
			// tap1 tap2 or angle for phase shift
			double fromTurnRatioOrAngDeg=0.0, toTurnRatioOrZero=0.0;
			if(!strAry[16].equals("")){
				fromTurnRatioOrAngDeg = new Double(strAry[16]).doubleValue();
			}
			if(!strAry[17].equals("")){
				toTurnRatioOrZero = new Double(strAry[17]).doubleValue();
			}
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
		}
	}
	public static void processDCLineData(final String str, final BranchRecordXmlType branchRec, 
			final PSSNetworkXmlType baseCaseNet,BPAAdapter adapter){
		
	}
	
   
	
	
	private static String[] getBranchDataFields(final String str) {
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
	private static String[] getXformerDataFields(final String str) {
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
			//strAry[18] = str.substring(74, 77).trim();
			
			//strAry[19] = str.substring(77, 80).trim();
						

		return strAry;
    }
	
	private static String[] getXfrAdjustDataFields(final String str) {
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
	
	
}

