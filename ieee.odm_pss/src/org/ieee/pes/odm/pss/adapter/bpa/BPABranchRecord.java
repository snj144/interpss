

/*
 * @(#)BPABranchRecord.java   
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

import java.text.NumberFormat;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AdjustmentDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.AngleXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BranchRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.CurrentXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.DCLineBranchRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.DCLineBusRecordXmlType;
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
import org.ieee.pes.odm.pss.model.IEEEODMPSSModelParser;
import org.ieee.pes.odm.pss.model.ODMData2XmlHelper;

public class BPABranchRecord {
	public static void processBranchData(final String str, final BranchRecordXmlType branchRec,
			IEEEODMPSSModelParser parser,
			final PSSNetworkXmlType baseCaseNet,BPAAdapter adapter) {		
		// symmetry line data
		if(str.startsWith("L")){
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
			// measure location for power interchange, 1--from side, 2- to side
			//set transfer power measured location in tie line data 
			int measureLocation=0;
			if(!strAry[5].equals("")){
				measureLocation= new Integer(strAry[5]).intValue();
				try{
					if(measureLocation==1){
						PSSNetworkXmlType.TieLineList.Tieline tieLine=parser.addNewBaseCaseTieline();
						// set tieline data
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
						PSSNetworkXmlType.TieLineList.Tieline tieLine=parser.addNewBaseCaseTieline();

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
					}
				}catch (final Exception e){
					e.printStackTrace();
				}
				
			}
			
			// set cirId, if not specified, set to 1
			String cirId="";
			if(!strAry[8].equals("")){
				cirId = strAry[8];
				
			}else{
				cirId="1";
			}			
			branchRec.setCircuitId(cirId);
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
				if(rpu>10.0){
					rpu=rpu/100000;
				}
			}
			if(!strAry[13].equals("")){
				xpu = new Double(strAry[13]).doubleValue();
				if(xpu>10.0){
					xpu=xpu/100000;
				}
			}
			if(!strAry[14].equals("")){
				halfGpu = new Double(strAry[14]).doubleValue();
				if(halfGpu>10.0){
					halfGpu=halfGpu/100000;
				}
			}
			if(!strAry[15].equals("")){
				halfBpu = new Double(strAry[15]).doubleValue();
				if(halfBpu>10.0){
					halfBpu=halfBpu/100000;
				}
			}
			if(rpu!=0.0||xpu!=0.0||halfGpu!=0.0||halfBpu!=0.0){
				ODMData2XmlHelper.setLineData(branchRec.getLoadflowBranchData(), rpu, xpu,
						ZXmlType.Unit.PU, 2*halfGpu, 2*halfBpu, YXmlType.Unit.PU);
			}
			
   		    
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
			
            
		}else if(str.startsWith("E")){
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
			// measure location for power interchange, 1--from side, 2- to side
			//set transfer power measured location in tie line data 
			int measureLocation=0;
			if(!strAry[5].equals("")){
				measureLocation= new Integer(strAry[5]).intValue();
				try{
					if(measureLocation==1){
						PSSNetworkXmlType.TieLineList.Tieline tieLine=parser.addNewBaseCaseTieline();

						// set tieline data
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
						PSSNetworkXmlType.TieLineList.Tieline tieLine=parser.addNewBaseCaseTieline();

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
					}
				}catch (final Exception e){
					e.printStackTrace();
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
			IEEEODMPSSModelParser parser,
			final PSSNetworkXmlType baseCaseNet,BPAAdapter adapter){
		
		final int transformer=1;
		final int phaseShiftXfr=2;
		final int transformerAndPhaseShiftXfr=3;
		
		int dataType=0;	    	
		
		final String[] strAry = getXformerDataFields(str);			
			
		if(strAry[0].startsWith("T ")){
			dataType=transformer;
		}else if(strAry[0].startsWith("TP")){
			dataType=phaseShiftXfr;
		}		
		
		branchRec.addNewLoadflowBranchData();			
			
		if(dataType==transformer){				
			branchRec.getLoadflowBranchData().setCode(LoadflowBranchDataXmlType.Code.TRANSFORMER);
			branchRec.getLoadflowBranchData().addNewXformerData();
		}else {				
			branchRec.getLoadflowBranchData().setCode(LoadflowBranchDataXmlType.Code.PHASE_SHIFT_XFORMER);
			branchRec.getLoadflowBranchData().addNewPhaseShiftXfrData();
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
			
			
		//  set tieline data, measure location for power interchange, 1--from side, 2- to side
		int measureLocation=0;
		if(!strAry[5].equals("")){				
			measureLocation= new Integer(strAry[5]).intValue();
			try{
				if(measureLocation==1){	
					PSSNetworkXmlType.TieLineList.Tieline tieLine=parser.addNewBaseCaseTieline();

					tieLine.addNewMeteredBus().setName(fid);
					tieLine.addNewNonMeteredBus().setName(tid);	
						
					BusRecordXmlType busRecFrom=ODMData2XmlHelper.getBusRecord(fid, baseCaseNet);						
					PSSNetworkXmlType.AreaList.Area areaFrom=ODMData2XmlHelper.
						 getAreaRecordByZone(busRecFrom.getZone(), baseCaseNet);
					tieLine.setMeteredArea(areaFrom.getAreaName());
						
					BusRecordXmlType busRecTo=ODMData2XmlHelper.getBusRecord(tid, baseCaseNet);						
					PSSNetworkXmlType.AreaList.Area areaTo=ODMData2XmlHelper.
						 getAreaRecordByZone(busRecTo.getZone(), baseCaseNet);
					tieLine.setNonMeteredArea(areaTo.getAreaName());					
				}else{
					PSSNetworkXmlType.TieLineList.Tieline tieLine=parser.addNewBaseCaseTieline();

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
				}					
			}catch (final Exception e) {
					e.printStackTrace();
			}				
		}
			
		String cirId="1";
		if(!strAry[8].equals("")){
			cirId = strAry[8];
		}
			
		branchRec.setCircuitId(cirId);			
		branchRec.setId(ODMData2XmlHelper.formBranchId(fid, tid, cirId));
			
		final String multiSectionId = strAry[9];
		//set rated current
		double MwRating=0.0;
		if(!strAry[11].equals("")){
			MwRating = new Integer(strAry[11]).intValue();
		}
			
		// set xfr rating data
		if(dataType==transformer){
			ODMData2XmlHelper.setXfrRatingData(branchRec.getLoadflowBranchData().getXformerData(), 
					fVol, tVol,VoltageXmlType.Unit.KV, MwRating, PowerXmlType.Unit.MVA);
		}else {
			ODMData2XmlHelper.setXfrRatingData(branchRec.getLoadflowBranchData().getPhaseShiftXfrData(), 
					fVol, tVol,VoltageXmlType.Unit.KV, MwRating, PowerXmlType.Unit.MVA);
		}
			

		double rpu=0.0, xpu=0.0001, Gpu=0.0, Bpu=0.0;
		if(!strAry[12].equals("")){
			rpu = new Double(strAry[12]).doubleValue();
			if(rpu>10.0){
				rpu=rpu/100000;
			}
		}
		if(!strAry[13].equals("")){
			xpu = new Double(strAry[13]).doubleValue();
			if(xpu>10.0){
				xpu=xpu/100000;
			}
		}
		if(!strAry[14].equals("")){
			Gpu = new Double(strAry[14]).doubleValue();
			if(Gpu>10.0){
				Gpu=Gpu/100000;
			}
		}
		if(!strAry[15].equals("")){
			Bpu = new Double(strAry[15]).doubleValue();
			if(Bpu>10.0){
				Bpu=Bpu/100000;
			}
		}
		// set r x
		if(rpu!=0.0||xpu!=0.0){
			if(dataType==transformer){
				ODMData2XmlHelper.setZValue(branchRec.getLoadflowBranchData().getXformerData().addNewZ(),
						                 rpu, xpu, ZXmlType.Unit.PU);
			}else{					
				ODMData2XmlHelper.setZValue(branchRec.getLoadflowBranchData().getPhaseShiftXfrData().addNewZ(),
						                 rpu, xpu, ZXmlType.Unit.PU);
			}
		}
		//set g b, g, b---> from side
		if(Gpu!=0.0||Bpu!=0.0){
			if(dataType==transformer){
					ODMData2XmlHelper.setYData(branchRec.getLoadflowBranchData().getXformerData().addNewFromShuntY(),
						                 Gpu, Bpu, YXmlType.Unit.PU);
			}else{
				ODMData2XmlHelper.setYData(branchRec.getLoadflowBranchData().getPhaseShiftXfrData().addNewFromShuntY(),
							                 Gpu, Bpu, YXmlType.Unit.PU);
			}
		}
		// tap1 tap2 or angle for phase shift
		double fromTurnRatedVolOrAngDeg=0.0, toTurnRatedVolOrZero=0.0;
		if(!strAry[16].equals("")){
			fromTurnRatedVolOrAngDeg = new Double(strAry[16]).doubleValue();				
		}
		if(!strAry[17].equals("")){
			toTurnRatedVolOrZero = new Double(strAry[17]).doubleValue();				 
		}
		double fRatio=1.0, tRatio=1.0;			
        
		// set transformer ratio and phaseshiftxfr angle
		if (dataType==transformer){					
			//to see what is the input data format, specified or not.
			if(fromTurnRatedVolOrAngDeg>=2*fVol){
				fromTurnRatedVolOrAngDeg=fromTurnRatedVolOrAngDeg/100;
				fRatio=fromTurnRatedVolOrAngDeg/fVol;
			}				
			branchRec.getLoadflowBranchData().getXformerData()
			.setFromTurnRatio(fRatio);
			
			if(toTurnRatedVolOrZero>=2*tVol){
				toTurnRatedVolOrZero=toTurnRatedVolOrZero/100;
				tRatio=toTurnRatedVolOrZero/tVol;
			}
	        branchRec.getLoadflowBranchData().getXformerData()
	        .setToTurnRatio(tRatio);				
		}else {			
			ODMData2XmlHelper.setAngleData(branchRec.getLoadflowBranchData().getPhaseShiftXfrData().
					addNewFromAngle(), fromTurnRatedVolOrAngDeg, AngleXmlType.Unit.DEG);
			ODMData2XmlHelper.setAngleData(branchRec.getLoadflowBranchData().getPhaseShiftXfrData().
					addNewToAngle(), 0, AngleXmlType.Unit.DEG);						
		}			
	}			
	
	
	public static void processXfrAdjustData(final String str, 
			final PSSNetworkXmlType baseCaseNet,BPAAdapter adapter){
		
		final String[] strAry = getXfrAdjustDataFields(str);
		
		int dataType=0;
		int angleAdjustment=1;
		int tapAdjustment=2;
		
		int adjustType=3;
		int tapVoltageAdjustment=4;
		int tapVarAdjustment=5;
		int pAngleAdjustment=6;
		int mAngleAdjustment=7;
		
		if(strAry[0].equals("RP")||strAry[0].equals("RM")){			
			dataType=angleAdjustment;
			if(strAry[0].equals("RP")){
				adjustType=pAngleAdjustment;
			}else{
				adjustType=mAngleAdjustment;
			}
		}else{
			dataType=tapAdjustment;
			if(strAry[0].equals("R")||strAry[0].equals("RV")){
				adjustType=tapVoltageAdjustment;
			}else {
				adjustType=tapVarAdjustment;
			}
		}			
		//adjustType: R or RV---remote bus control			
		final String modCode = strAry[1];
		final String owner = strAry[2];
		final String fromBus =strAry[3];
		final double fromTurnRatedV = new Double(strAry[4]).doubleValue();
		final String toBus = strAry[6];
		final double toTurnRatedV = new Double(strAry[7]).doubleValue();			
		
		BranchRecordXmlType branchRec_old= ODMData2XmlHelper.getXfrBranchRecord(fromBus, 
				toBus,  baseCaseNet);	
		
		String controlBusId = "";		
		
		final String adjBus =strAry[8];
		final String adjVol =strAry[9];	
		// set tapAdjSide
		int tapAdjSide = 0;
		if(!strAry[5].equals("")){
			tapAdjSide=new Integer(strAry[5]).intValue();				
		}
		
		double   stepSize=0.0,maxVoltPQ = 0.0, minVoltPQ = 0.0, totalTap=0.0;
		double max=0.0, min=0.0;
		// Minimum  MVAR or MW limit [F]
		// Maximum  MVAR or MW limit [F]			
		
		
		if(!strAry[10].equals("")){
			max = new Double(strAry[10]).doubleValue();				
		}
		if(!strAry[11].equals("")){
			min = new Double(strAry[11]).doubleValue();				
		}
		if(!strAry[12].equals("")){
			totalTap = new Double(strAry[12]).doubleValue();
		}
		if(!strAry[13].equals("")){
			maxVoltPQ = new Double(strAry[13]).doubleValue();
		}
		if(!strAry[14].equals("")){
			minVoltPQ = new Double(strAry[14]).doubleValue();
		}			
		// calculate stepsize
		if (totalTap!=0.0){
			stepSize =(max-min)/totalTap;
		}
		
		// scheduled Q for RQ 			
		double scheduleQ=0.0;
		if(!strAry[13].equals("")){
			scheduleQ = new Double(strAry[13]).doubleValue();
		}	
		
		if(dataType==tapAdjustment){			
			
			TransformerDataXmlType.TapAdjustment tapAdj = branchRec_old.getLoadflowBranchData().
            getXformerData().addNewTapAdjustment();
			
            if(tapAdjSide==1){
				tapAdj.setTapAdjOnFromSide(true);
				if(max>=2*fromTurnRatedV){
					max=max/100;
				}
				max=max/fromTurnRatedV;
				if(min>=2*fromTurnRatedV){
					min=min/100;
				}
				min=min/fromTurnRatedV;
			}else{
				tapAdj.setTapAdjOnFromSide(false);
				if(max>=2*toTurnRatedV){
					max=max/100;
				}
				max=max/toTurnRatedV;
				if(min>=2*toTurnRatedV){
					min=min/100;
				}
				min=min/toTurnRatedV;
			}
            // save result to two digits after .
            NumberFormat ddf1=NumberFormat.getNumberInstance() ;
            ddf1.setMaximumFractionDigits(2);
            max= new Double(ddf1.format(max)).doubleValue() ; 
            min= new Double(ddf1.format(min)).doubleValue() ; 
            
            
			
			if(tapAdjSide==2){
				tapAdj.setTapAdjOnFromSide(false);
				controlBusId=toBus;
			}else{
				tapAdj.setTapAdjOnFromSide(true);
				controlBusId=fromBus;
			}
			
			
			ODMData2XmlHelper.setLimitData(tapAdj.addNewTapLimit(), max,
					min);
			tapAdj.setTapAdjStepSize(stepSize);
			if (adjustType==tapVoltageAdjustment ){// voltage control					
				
				TransformerDataXmlType.TapAdjustment.VoltageAdjData voltTapAdj = tapAdj
						.addNewVoltageAdjData();
				voltTapAdj.addNewAdjVoltageBus().setIdRef(controlBusId);
				voltTapAdj
						.setAdjBusLocation((adjBus == toBus ? TransformerDataXmlType.TapAdjustment.VoltageAdjData.AdjBusLocation.NEAR_TO_BUS
										: TransformerDataXmlType.TapAdjustment.VoltageAdjData.AdjBusLocation.NEAR_FROM_BUS));
				voltTapAdj.setMode(AdjustmentDataXmlType.Mode.RANGE_ADJUSTMENT);
				
				if(maxVoltPQ!=0.0||minVoltPQ!=0.0){
					ODMData2XmlHelper.setLimitData(voltTapAdj.addNewDesiredRange(),
							maxVoltPQ, minVoltPQ);
				}
				
				
			} else if (adjustType==tapVarAdjustment) {// var control						
				
				TransformerDataXmlType.TapAdjustment.MvarFlowAdjData mvarTapAdj = tapAdj
						.addNewMvarFlowAdjData();
				ODMData2XmlHelper.setLimitData(mvarTapAdj.addNewDesiredRange(),
						maxVoltPQ, minVoltPQ);
				mvarTapAdj.setMode(AdjustmentDataXmlType.Mode.RANGE_ADJUSTMENT);
				mvarTapAdj.setMvarMeasuredOnFormSide(true);
			}
		} else if(dataType==angleAdjustment){
			PhaseShiftXfrDataXmlType.AngleAdjustment angAdj = branchRec_old.getLoadflowBranchData().
            getPhaseShiftXfrData().addNewAngleAdjustment();
			
			ODMData2XmlHelper.setLimitData(angAdj.addNewAngleDegLimit(), max,
					min);
			ODMData2XmlHelper.setLimitData(angAdj.addNewDesiredRange(), maxVoltPQ,
					minVoltPQ);
			angAdj.setMode(AdjustmentDataXmlType.Mode.RANGE_ADJUSTMENT);
			angAdj.setDesiredMeasuredOnFromSide(true);
		}
		
	}
	public static void processDCLineBranchData(final String str, 
			final DCLineBranchRecordXmlType dcBranch, 
			IEEEODMPSSModelParser parser,
			final PSSNetworkXmlType baseCaseNet,BPAAdapter adapter){
		final String strAry[] = getDCLineBranchDataFields(str);	
		
		final String dataType= strAry[0];
		final String modCode= strAry[1];
		final String owner = strAry[2];
		final String rectifierBus = strAry[3];
		double rectifierRatedVoltage = 0.0;
		if(!strAry[4].equals("")){
			rectifierRatedVoltage= new Double(strAry[4]).doubleValue();			
		}
		dcBranch.setRectifierBus(rectifierBus);
		
		
		final String inverterBus = strAry[6];
		double inverterRatedVoltage = 0.0;
		if(!strAry[7].equals("")){
			inverterRatedVoltage= new Double(strAry[7]).doubleValue();			
		}
		dcBranch.setInverterBus(inverterBus);
		
		int measureLocation=0;
		if(!strAry[5].equals("")){
			measureLocation = new Integer(strAry[5]).intValue();
			// add to tieline data
			try{
				if(measureLocation==1){
					// set tieline data
					PSSNetworkXmlType.TieLineList.Tieline tieLine=parser.addNewBaseCaseTieline();

					tieLine.addNewMeteredBus().setName(rectifierBus);
					tieLine.addNewNonMeteredBus().setName(inverterBus);	
					
					BusRecordXmlType busRecFrom=ODMData2XmlHelper.getBusRecord(rectifierBus, baseCaseNet);					
					PSSNetworkXmlType.AreaList.Area areaFrom=ODMData2XmlHelper.
					  getAreaRecordByZone(busRecFrom.getZone(), baseCaseNet);
					tieLine.setMeteredArea(areaFrom.getAreaName());
					
					BusRecordXmlType busRecTo=ODMData2XmlHelper.getBusRecord(inverterBus, baseCaseNet);
					busRecTo.getZone();
					PSSNetworkXmlType.AreaList.Area areaTo=ODMData2XmlHelper.
					  getAreaRecordByZone(busRecTo.getZone(), baseCaseNet);
					tieLine.setNonMeteredArea(areaTo.getAreaName());
					// to do: set area number
					
				}else{
					PSSNetworkXmlType.TieLineList.Tieline tieLine=parser.addNewBaseCaseTieline();

					tieLine.addNewMeteredBus().setName(inverterBus);
					tieLine.addNewNonMeteredBus().setName(rectifierBus);					
					ODMData2XmlHelper.getBusRecord(rectifierBus, baseCaseNet).getZone();
					
					BusRecordXmlType busRecFrom=ODMData2XmlHelper.getBusRecord(inverterBus, baseCaseNet);
					busRecFrom.getZone();
					PSSNetworkXmlType.AreaList.Area areaFrom=ODMData2XmlHelper.
					  getAreaRecordByZone(busRecFrom.getZone(), baseCaseNet);
					tieLine.setMeteredArea(areaFrom.getAreaName());
					
					BusRecordXmlType busRecTo=ODMData2XmlHelper.getBusRecord(inverterBus, baseCaseNet);
					busRecTo.getZone();
					PSSNetworkXmlType.AreaList.Area areaTo=ODMData2XmlHelper.
					  getAreaRecordByZone(busRecTo.getZone(), baseCaseNet);
					tieLine.setNonMeteredArea(areaTo.getAreaName());						
				}
			}catch (final Exception e){
				e.printStackTrace();
			}
		}
		
		
		double lineRatingCurrent=0.0;
		if(!strAry[8].equals("")){
			lineRatingCurrent = new Double(strAry[8]).doubleValue();
			ODMData2XmlHelper.setCurrentData(dcBranch.addNewMaxCurrent(),
					lineRatingCurrent, CurrentXmlType.Unit.AMP);
		}
		double r=0.0, l=0.0,c=0.0;
		double x=0;
		final double w= 2*3.14*0.02;
		if(!strAry[9].equals("")){
			r = new Double(strAry[9]).doubleValue();
		}
		if(!strAry[10].equals("")){
			l = new Double(strAry[10]).doubleValue();
		}
		if(!strAry[11].equals("")){
			c = new Double(strAry[11]).doubleValue();
		}
		// line reactance  x=XL-XC=2*pi*f*l-1/(2*Pi*f*c)
		if(x!=0.0&&c==0.0){
			x= w*l*0.001;
		}else if(c!=0.0){
			x= w*l*0.001-1/(w*c*0.000001);
		}		
		
		if(r!=0.0||x!=0.0){
			ODMData2XmlHelper.setZValue(dcBranch.addNewLineZ(), r, x, ZXmlType.Unit.OHM);
		}
		String mwControlSide="";
		if(!strAry[12].equals("")){
			mwControlSide =strAry[12];
			if(mwControlSide.equals("R")){				
				dcBranch.setControlOnRectifierSide(true);
			}else{				
				dcBranch.setControlOnRectifierSide(false);
				}
		}		
		// DC power control mode, and control power
		double scheduledMw=0.0;
		if(!strAry[13].equals("")){
			scheduledMw =new Double(strAry[13]).doubleValue();
			dcBranch.setControlMode(DCLineBranchRecordXmlType.ControlMode.POWER);
			ODMData2XmlHelper.setPowerData(dcBranch.addNewPowerDemand(), 
					scheduledMw, 0.0, PowerXmlType.Unit.MVA);
		}
		
		double dcLineRatedVoltage=0.0;
		if(!strAry[14].equals("")){
			dcLineRatedVoltage = new Double(strAry[14]).doubleValue();
			ODMData2XmlHelper.setVoltageData(dcBranch.addNewRatedDVol(),
					dcLineRatedVoltage, VoltageXmlType.Unit.KV);			
		}
		double recOperFiringAngle=0.0, invStopFiringAngle=0.0;
		if(!strAry[15].equals("")){
			recOperFiringAngle= new Double(strAry[15]).doubleValue();
			ODMData2XmlHelper.setAngleData(ODMData2XmlHelper.getConverterRecord(rectifierBus,
					baseCaseNet).addNewRectifierOperAngle(), recOperFiringAngle, AngleXmlType.Unit.DEG);
			ODMData2XmlHelper.getConverterRecord(rectifierBus,baseCaseNet).
			        setType(DCLineBusRecordXmlType.Converter.Type.RECTIFIER);
		}
		if(!strAry[16].equals("")){
			invStopFiringAngle= new Double(strAry[16]).doubleValue();
			ODMData2XmlHelper.setAngleData(ODMData2XmlHelper.getConverterRecord(inverterBus,
					baseCaseNet).addNewInverterStopAgnle(), invStopFiringAngle, AngleXmlType.Unit.DEG);
			ODMData2XmlHelper.getConverterRecord(rectifierBus,baseCaseNet).
	        setType(DCLineBusRecordXmlType.Converter.Type.INVERTER);
		}
		double length=0.0;
		if(!strAry[17].equals("")){
			length= new Double(strAry[17]).doubleValue();
			dcBranch.addNewLength().setLength(length);
			dcBranch.getLength().setUnit(LengthXmlType.Unit.MILE);
		}
		
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
		
            strAry[0] = str.substring(0, 2);
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
			
			strAry[17] ="";
			//strAry[17] = str.substring(67, 72).trim();
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
	
	private static String[] getDCLineBranchDataFields(final String str) {
		final String[] strAry = new String[20];
		
            strAry[0] = str.substring(0, 2);
            strAry[1] = str.substring(2, 3).trim();
			strAry[2] = str.substring(3, 6).trim();
			
			strAry[3] = str.substring(6, 14).trim();
			strAry[4] = str.substring(14, 18).trim();
			strAry[5] = str.substring(18, 19).trim();
			strAry[6] = str.substring(19, 27).trim();

			strAry[7] = str.substring(27, 31).trim();
			strAry[8] = str.substring(33, 37).trim();
			strAry[9] = str.substring(37, 43).trim();
			strAry[10] = str.substring(43, 49).trim();
			strAry[11] = str.substring(49, 55).trim();
			strAry[12] = str.substring(55, 56).trim();
			strAry[13] = str.substring(56, 61).trim();
			strAry[14] = str.substring(61, 66).trim();
			strAry[15] = str.substring(66, 70).trim();
			strAry[16] = str.substring(70, 74).trim();
			
			strAry[17] = str.substring(74, 78).trim();
			
		return strAry;
    }
	
	
}

