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
 * @Author Mike Zhou
 * @Version 1.0
 * @Date 02/11/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.ieee.odm.adapter.ieeecdf;

import java.util.StringTokenizer;
import java.util.logging.Logger;

import org.ieee.odm.adapter.AbstractODMAdapter;
import org.ieee.odm.adapter.IFileReader;
import org.ieee.odm.model.JaxbDataSetter;
import org.ieee.odm.model.JaxbODMModelParser;
import org.ieee.odm.model.JaxbParserHelper;
import org.ieee.odm.model.ModelStringUtil;
import org.ieee.odm.schema.ActivePowerUnitType;
import org.ieee.odm.schema.AdjustmentModeEnumType;
import org.ieee.odm.schema.AngleAdjustmentXmlType;
import org.ieee.odm.schema.AngleUnitType;
import org.ieee.odm.schema.ApparentPowerUnitType;
import org.ieee.odm.schema.BranchRecordXmlType;
import org.ieee.odm.schema.BusRecordXmlType;
import org.ieee.odm.schema.InterchangeXmlType;
import org.ieee.odm.schema.LFGenCodeEnumType;
import org.ieee.odm.schema.LFLoadCodeEnumType;
import org.ieee.odm.schema.LoadflowBranchDataXmlType;
import org.ieee.odm.schema.LoadflowBusDataXmlType;
import org.ieee.odm.schema.LoadflowGenDataXmlType;
import org.ieee.odm.schema.NameValuePairListXmlType;
import org.ieee.odm.schema.NetZoneXmlType;
import org.ieee.odm.schema.ObjectFactory;
import org.ieee.odm.schema.OriginalDataFormatEnumType;
import org.ieee.odm.schema.PSSNetworkXmlType;
import org.ieee.odm.schema.PowerInterchangeXmlType;
import org.ieee.odm.schema.ReactivePowerUnitType;
import org.ieee.odm.schema.TapAdjustBusLocationEnumType;
import org.ieee.odm.schema.TapAdjustmentXmlType;
import org.ieee.odm.schema.TielineXmlType;
import org.ieee.odm.schema.VoltageUnitType;
import org.ieee.odm.schema.YUnitType;
import org.ieee.odm.schema.ZUnitType;

public class IeeeCDFAdapter  extends AbstractODMAdapter {
	public final static String Token_Date = "Date";
	public final static String Token_OrgName = "Originator Name";
	public final static String Token_Year = "Year";
	public final static String Token_Season = "Season";
	public final static String Token_CaseId = "Case Identification";

	private static final int BusData = 1;
	private static final int BranchData = 2;
	private static final int LossZone = 3;
	private static final int InterchangeData = 4;
	private static final int TielineData = 5;

	private ObjectFactory factory = null;

	public IeeeCDFAdapter(Logger logger) {
		super(logger);
		this.factory = new ObjectFactory();		
	}
	 
	protected JaxbODMModelParser parseInputFile(
			final IFileReader din) throws Exception {
		JaxbODMModelParser parser = new JaxbODMModelParser();
		JaxbParserHelper.setLFTransInfo(parser, OriginalDataFormatEnumType.IEEE_CDF);

		PSSNetworkXmlType baseCaseNet = parser.getBaseCase();
		baseCaseNet.setId("Base_Case_from_IEEECDF_format");

		String str = din.readLine();
		processNetData(str, baseCaseNet);

		int dataType = 0;
		do {
			str = din.readLine(); //kvaBase
			if (!str.trim().equals("END OF DATA")) {
				try {
					// process the data
					if (str.startsWith("-999") || str.startsWith("-99")
							|| str.startsWith("-9")) {
						dataType = 0;
					} else if (dataType == BusData) {
						processBusData(str, parser);
					} else if (dataType == BranchData) {
						processBranchData(str, parser);
					} else if (dataType == LossZone) {
						processLossZoneData(str, parser.createNetworkLossZone());
					} else if (dataType == InterchangeData) {
						InterchangeXmlType interchange = parser.createInterchange();
						PowerInterchangeXmlType p = this.factory.createPowerInterchangeXmlType();
						processInterchangeData(str, p, parser);
						interchange.setPowerEx(p);
					} else if (dataType == TielineData) {
						processTielineData(str, parser.createTieline(), parser);
					} else if ((str.length() > 3)
							&& str.substring(0, 3).equals("BUS")) {
						dataType = BusData;
						
						getLogger().fine("load bus data");
					} else if ((str.length() > 6)
							&& str.substring(0, 6).equals("BRANCH")) {
						dataType = BranchData;
						getLogger().fine("load branch data");
					} else if ((str.length() > 4)
							&& str.substring(0, 4).equals("LOSS")) {
						dataType = LossZone;
						//baseCaseNet.addNewLossZoneList();
						getLogger().fine("load loss zone data");
					} else if ((str.length() > 11)
							&& str.substring(0, 11).equals("INTERCHANGE")) {
						dataType = InterchangeData;
						//baseCaseNet.addNewInterchangeList();
						getLogger().fine("load interchange data");
					} else if ((str.length() > 3)
							&& str.substring(0, 3).equals("TIE")) {
						dataType = TielineData;
						//baseCaseNet.addNewTieLineList();
						getLogger().fine("load tieline data");
					}
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}
		} while (!str.trim().equals("END OF DATA"));

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

		NameValuePairListXmlType nvList = this.factory.createNameValuePairListXmlType();
		baseCaseNet.setNvPairList(nvList);

		//[0] Columns  2- 9   Date, in format DD/MM/YY with leading zeros.  If no date provided, use 0b/0b/0b where b is blank.
		final String date = strAry[0];
		if (date != null) 
			JaxbParserHelper.addNVPair(nvList, Token_Date, date);

		//[1] Columns 11-30   Originator's name [A]
		final String orgName = strAry[1];
		if (orgName != null)
			JaxbParserHelper.addNVPair(nvList, Token_OrgName, orgName);

		//[3] Columns 39-42   Year [I]
		final String year = strAry[3];
		if (year != null)
			JaxbParserHelper.addNVPair(nvList, Token_Year, year);

		//[4] Column  44      Season (S - Summer, W - Winter)
		final String season = strAry[4];
		if (season != null)
			JaxbParserHelper.addNVPair(nvList, Token_Season, season);

		//[5] Column  46-73   Case identification [A]
		final String caseId = strAry[5];
		if (caseId != null)
			JaxbParserHelper.addNVPair(nvList, Token_CaseId, caseId);

		getLogger().fine("date, orgName, year, season, caseId: " + date + ", "
				+ orgName + ", " + year + ", " + season + ", " + caseId);

		//[2] Columns 32-37   MVA Base [F] *
		final double baseMva = new Double(strAry[2]).doubleValue(); // in MVA
		getLogger().fine("BaseKva: " + baseMva);
		baseCaseNet.setBasePower(JaxbDataSetter.createPowerMva(baseMva));
	}

	/*
	 *   Bus data
	 *   ======== 
	 */

	private  void processBusData(final String str, JaxbODMModelParser parser) {
		// parse the input data line
		final String[] strAry = getBusDataFields(str);

		//Columns  1- 4   Bus number [I] *
		final String busId = JaxbODMModelParser.BusIdPreFix + strAry[0];
		getLogger().fine("Bus data loaded, id: " + busId);
		BusRecordXmlType busRec = null;
		try {
			busRec = parser.createBusRecord(busId);
		} catch (Exception e) {
			this.logErr(e.toString());
			return;
		}
		busRec.setNumber(new Long(strAry[0]));

		//Columns  6-17   Name [A] (left justify) *
		final String busName = strAry[1];
		busRec.setName(busName);

		//Columns 19-20   Load flow area number [I].  Don't use zero! *
		//Columns 21-23   Loss zone number [I]
		final String areaNo = strAry[2];
		final String zoneNo = strAry[3];
		busRec.setAreaNumber(new Integer(areaNo).intValue());
		busRec.setZoneNumber(new Integer(zoneNo).intValue());

		//Columns 77-83   Base kV [F]
		double baseKv = new Double(strAry[11]).doubleValue();
		if (baseKv == 0.0) {
			baseKv = 1.0;
		}
		busRec.setBaseVoltage(JaxbDataSetter.createVoltageData(baseKv, VoltageUnitType.KV));

		busRec.setLoadflowData(this.factory.createLoadflowBusDataXmlType());
		LoadflowBusDataXmlType busData = busRec.getLoadflowData();
		//Columns 25-26   Type [I] *
		//		0 - Unregulated (load, PQ)
		//		1 - Hold MVAR generation within voltage limits, (gen, PQ)
		//		2 - Hold voltage within VAR limits (gen, PV)
		//		3 - Hold voltage and angle (swing, V-Theta; must always have one)
		final int type = new Integer(strAry[4]).intValue();

		//Columns 28-33   Final voltage, p.u. [F] *
		//Columns 34-40   Final angle, degrees [F] *
		final double vpu = new Double(strAry[5]).doubleValue();
		final double angDeg = new Double(strAry[6]).doubleValue();
		busData.setVoltage(JaxbDataSetter.createVoltageData(vpu, VoltageUnitType.PU));

		busData.setAngle(JaxbDataSetter.createAngleData(angDeg, AngleUnitType.DEG));

		//Columns 41-49   Load MW [F] *
		//Columns 50-59   Load MVAR [F] *
		final double loadMw = new Double(strAry[7]).doubleValue();
		final double loadMvar = new Double(strAry[8]).doubleValue();
		if (loadMw != 0.0 || loadMvar != 0.0) {
			JaxbDataSetter.setLoadData(busData,
					LFLoadCodeEnumType.CONST_P, loadMw,
					loadMvar, ApparentPowerUnitType.MVA,
					this.factory);
		}

		//Columns 60-67   Generation MW [F] *
		//Columns 68-75   Generation MVAR [F] *
		final double genMw = new Double(strAry[9]).doubleValue();
		final double genMvar = new Double(strAry[10]).doubleValue();

		LFGenCodeEnumType genType = type == 3? LFGenCodeEnumType.SWING :
				( type == 2? LFGenCodeEnumType.PV : LFGenCodeEnumType.PQ );
		JaxbDataSetter.setGenData(
				busData, genType, vpu, VoltageUnitType.PU, angDeg, AngleUnitType.DEG, 
				genMw, genMvar,	ApparentPowerUnitType.MVA);

		//Columns 107-114 Shunt conductance G (per unit) [F] *
		//Columns 115-122 Shunt susceptance B (per unit) [F] *
		final double gPU = new Double(strAry[15]).doubleValue();
		final double bPU = new Double(strAry[16]).doubleValue();
		if (gPU != 0.0 || bPU != 0.0) {
			busData.setShuntY(JaxbDataSetter.createYData(gPU, bPU, YUnitType.PU));
		}

		//Columns 85-90   Desired volts (pu) [F] (This is desired remote voltage if this bus is controlling another bus.)
		final double vSpecPu = new Double(strAry[12]).doubleValue();

		//Columns 91-98   Maximum MVAR or voltage limit [F]
		//Columns 99-106  Minimum MVAR or voltage limit [F]
		final double max = new Double(strAry[13]).doubleValue();
		final double min = new Double(strAry[14]).doubleValue();

		//Columns 124-127 Remote controlled bus number
		final String reBusId = strAry[17];

		if (max != 0.0 || min != 0.0) {
			LoadflowGenDataXmlType equivGen = busData.getGenData().getEquivGen();
			if (type == 1) {
				equivGen.setVoltageLimit(JaxbDataSetter.createVoltageLimitData(max, min, VoltageUnitType.PU));
			} else if (type == 2) {
				busData.getGenData().getEquivGen().setQLimit(JaxbDataSetter.createReactivePowerLimitData(max, min, ReactivePowerUnitType.MVAR));
				if (reBusId != null && !reBusId.equals("0")
						&& !reBusId.equals(busId)) {
					equivGen.setDesiredVoltage(JaxbDataSetter.createVoltageData(vSpecPu, VoltageUnitType.PU));
					equivGen.setRemoteVoltageControlBus(JaxbDataSetter.createIdRef(reBusId));
				}
			}
		}
	}

	/*
	 *   Branch data
	 *   =========== 
	 */

	private void processBranchData(final String str, JaxbODMModelParser parser) {
		// parse the input data line
		final String[] strAry = getBranchDataFields(str);

		//    	Columns  1- 4   Tap bus number [I] *
		//      	For transformers or phase shifters, the side of the model the non-unity tap is on.
		//		Columns  6- 9   Z bus number [I] *
		//      	For transformers and phase shifters, the side of the model the device impedance is on.
		//    	Columns 11-12   Load flow area [I]
		//    	Columns 13-15   Loss zone [I]
		//    	Column  17      Circuit [I] * (Use 1 for single lines)
		final String fid = JaxbODMModelParser.BusIdPreFix + strAry[0];
		final String tid = JaxbODMModelParser.BusIdPreFix + strAry[1];
		final String areaNo = strAry[2];
		final String zoneNo = strAry[3];
		final String cirId = strAry[4];
		BranchRecordXmlType branchRec = null;
		try {
			branchRec = parser.createBranchRecord(ModelStringUtil.formBranchId(fid, tid, cirId));
		} catch (Exception e) {
			this.logErr("branch data error, " + e.toString());
		}
		
		getLogger().fine("Branch data loaded, from-id, to-id: " + fid + ", " + tid);
		try {
			branchRec.setFromBus(parser.createBusRecRef(fid));
			branchRec.setToBus(parser.createBusRecRef(tid));
		} catch (Exception e) {
			this.logErr("branch is not connected properly, " + e.toString());
		}

		branchRec.setAreaNumber(new Integer(areaNo).intValue());
		branchRec.setZoneNumber(new Integer(zoneNo).intValue());
		branchRec.setCircuitId(cirId);

		branchRec.setId(ModelStringUtil.formBranchId(fid, tid, cirId));

		LoadflowBranchDataXmlType branchData = this.factory.createLoadflowBranchDataXmlType(); 
		branchRec.getLoadflowData().add(branchData);

		//    	Column  19      Type [I] *
		//      0 - Transmission line
		//      1 - Fixed tap
		//      2 - Variable tap for voltage control (TCUL, LTC)
		//      3 - Variable tap (turns ratio) for MVAR control
		//      4 - Variable phase angle for MW control (phase shifter)
		final int type = new Integer(strAry[5]).intValue();

		//    	Columns 20-29   Branch resistance R, per unit [F] *
		//    	Columns 30-40   Branch reactance X, per unit [F] * No zero impedance lines
		//    	Columns 41-50   Line charging B, per unit [F] * (total line charging, +B), Xfr B is negative
		final double rpu = new Double(strAry[6]).doubleValue();
		final double xpu = new Double(strAry[7]).doubleValue();
		final double bpu = new Double(strAry[8]).doubleValue();
		if (type == 0) {
			JaxbDataSetter.setLineData(branchData, rpu, xpu,
					ZUnitType.PU, 0.0, bpu, YUnitType.PU);
		}

		// assume ratio and angle are defined at to side
		//    	Columns 77-82   Transformer final turns ratio [F]
		//    	Columns 84-90   Transformer (phase shifter) final angle [F]
		final double ratio = new Double(strAry[14]).doubleValue();
		final double angle = new Double(strAry[15]).doubleValue();
		if (type > 0) {
			branchData.setXfrInfo(this.factory.createLoadflowBranchDataXmlTypeXfrInfo());
			branchData.getXfrInfo().setDataOnSystemBase(true);

			if (angle == 0.0) {
				JaxbDataSetter.createXformerData(branchData,
						rpu, xpu, ZUnitType.PU, ratio, 1.0, 
						0.0, bpu, 0.0, 0.0, YUnitType.PU);
				BusRecordXmlType fromBusRec = parser.getBusRecord(fid);
				BusRecordXmlType toBusRec = parser.getBusRecord(tid);
				if (fromBusRec != null && toBusRec != null) {
					JaxbDataSetter.setXfrRatingData(branchData,
							fromBusRec.getBaseVoltage().getValue(), 
							toBusRec.getBaseVoltage().getValue(), 
							fromBusRec.getBaseVoltage().getUnit());				
				}
				else {
					logErr("Error: fromBusRecord and/or toBusRecord cannot be found, fromId, toId: " + fid + ", " + tid);
				}
			} else {
				JaxbDataSetter.createPhaseShiftXfrData(branchData, rpu, xpu, ZUnitType.PU,
						ratio, 1.0, angle, 0.0, AngleUnitType.DEG,
						0.0, bpu, 0.0, 0.0, YUnitType.PU);
				BusRecordXmlType fromBusRec = parser.getBusRecord(fid);
				BusRecordXmlType toBusRec = parser.getBusRecord(tid);
				if (fromBusRec != null && toBusRec != null) {
					JaxbDataSetter.setXfrRatingData(branchData,
							fromBusRec.getBaseVoltage().getValue(), 
							toBusRec.getBaseVoltage().getValue(), 
							fromBusRec.getBaseVoltage().getUnit());				
				}
				else {
					logErr("Error: fromBusRecord and/or toBusRecord cannot be found, fromId, toId: " + fid + ", " + tid);
				}
			}
		}

		//    	Columns 51-55   Line MVA rating No 1 [I] Left justify!
		//    	Columns 57-61   Line MVA rating No 2 [I] Left justify!
		//    	Columns 63-67   Line MVA rating No 3 [I] Left justify!
		final double rating1Mvar = new Integer(strAry[9]).intValue();
		final double rating2Mvar = new Integer(strAry[10]).intValue();
		final double rating3Mvar = new Integer(strAry[11]).intValue();
		branchData.setBranchRatingLimit(this.factory.createBranchRatingLimitXmlType());
		JaxbDataSetter.setBranchRatingLimitData(branchData.getBranchRatingLimit(),
				rating1Mvar, rating2Mvar, rating3Mvar, ApparentPowerUnitType.MVA);

		String controlBusId = "";
		int controlSide = 0;
		double stepSize = 0.0, maxTapAng = 0.0, minTapAng = 0.0, maxVoltPQ = 0.0, minVoltPQ = 0.0;
		if (type > 1) {
			//    		Columns 69-72   Control bus number
			controlBusId = JaxbODMModelParser.BusIdPreFix + strAry[12];

			//        	Column  74      Side [I]
			//          	0 - Controlled bus is one of the terminals
			//          	1 - Controlled bus is near the tap side
			//          	2 - Controlled bus is near the impedance side (Z bus)
			controlSide = new Integer(strAry[13]).intValue();

			//        	Columns 106-111 Step size [F]
			stepSize = new Double(strAry[18]).doubleValue();

			//        	Columns 91-97   Minimum tap or phase shift [F]
			//        	Columns 98-104  Maximum tap or phase shift [F]
			minTapAng = new Double(strAry[16]).doubleValue();
			maxTapAng = new Double(strAry[17]).doubleValue();

			//        	Columns 113-119 Minimum voltage, MVAR or MW limit [F]
			//        	Columns 120-126 Maximum voltage, MVAR or MW limit [F]
			maxVoltPQ = new Double(strAry[19]).doubleValue();
			minVoltPQ = new Double(strAry[20]).doubleValue();
		}

		if (type == 2 || type == 3) {
			TapAdjustmentXmlType tapAdj = this.factory.createTapAdjustmentXmlType();
			branchData.getXfrInfo().setTapAdjustment(tapAdj);
			tapAdj.setTapLimit(JaxbDataSetter.createTapLimitData(maxTapAng, minTapAng));
			tapAdj.setTapAdjStepSize(stepSize);
			tapAdj.setTapAdjOnFromSide(true);
			if (type == 2) {
				TapAdjustmentXmlType.VoltageAdjData voltTapAdj = this.factory.createTapAdjustmentXmlTypeVoltageAdjData();
				tapAdj.setVoltageAdjData(voltTapAdj);
				try {
					voltTapAdj.setAdjVoltageBus(parser.createBusRecRef(controlBusId));
				} catch (Exception e) {
					this.logErr("Xfr control bus not defined properly, " + e.toString());
				}
					
				voltTapAdj.setAdjBusLocation(controlSide == 0 ? TapAdjustBusLocationEnumType.TERMINAL_BUS
								: (controlSide == 1 ? TapAdjustBusLocationEnumType.NEAR_FROM_BUS
										: TapAdjustBusLocationEnumType.NEAR_TO_BUS));
				voltTapAdj.setMode(AdjustmentModeEnumType.RANGE_ADJUSTMENT);
				JaxbDataSetter.setLimitData(voltTapAdj, maxVoltPQ, minVoltPQ);
			} else if (type == 3) {
				TapAdjustmentXmlType.MvarFlowAdjData mvarTapAdj = this.factory.createTapAdjustmentXmlTypeMvarFlowAdjData();
				tapAdj.setMvarFlowAdjData(mvarTapAdj);
				JaxbDataSetter.setLimitData(mvarTapAdj, maxVoltPQ, minVoltPQ);
				mvarTapAdj.setMode(AdjustmentModeEnumType.RANGE_ADJUSTMENT);
				mvarTapAdj.setMvarMeasuredOnFormSide(true);
			}
		} else if (type == 4) {
			AngleAdjustmentXmlType angAdj = this.factory.createAngleAdjustmentXmlType();
			branchData.getXfrInfo().setAngleAdjustment(angAdj);
			angAdj.setAngleLimit(this.factory.createAngleLimitXmlType());
			JaxbDataSetter.setLimitData(angAdj.getAngleLimit(), maxTapAng, minTapAng);
			JaxbDataSetter.setLimitData(angAdj, maxVoltPQ, minVoltPQ);
			angAdj.setMode(AdjustmentModeEnumType.RANGE_ADJUSTMENT);
			angAdj.setDesiredMeasuredOnFromSide(true);
		}
	}

	/*
	 *   Loss Zone data
	 *   ============== 
	 */

	private void processLossZoneData(final String str,	final NetZoneXmlType lossZone) {
		final String[] strAry = getLossZoneDataFields(str);

		//    	Columns  1- 3   Loss zone number [I] *
		//    	Columns  5-16   Loss zone name [A] 
		final int no = new Integer(strAry[0]).intValue();
		final String name = strAry[1];
		lossZone.setNumber(no);
		lossZone.setName(name);
	}

	/*
	 *   Interchange data
	 *   ================ 
	 */

	private void processInterchangeData(final String str,
			final PowerInterchangeXmlType interchange, JaxbODMModelParser parser) {
		final String[] strAry = getInterchangeDataFields(str);

		//    	Columns  1- 2   Area number [I], no zeros! *
		final int no = new Integer(strAry[0]).intValue();

		//    	Columns  4- 7   Interchange slack bus number [I] *
		//      Columns  9-20   Alternate swing bus name [A]
		final String slackBusId = JaxbODMModelParser.BusIdPreFix + strAry[1];
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
		
		try {
			interchange.setSwingBus(parser.createBusRecRef(slackBusId));
			interchange.setAlternateSwingBusName(alSwingBusName);
		} catch (Exception e) {
			this.logErr("Interchange data error, " + e.toString());
		}
		
		interchange.setDesiredExPower(JaxbDataSetter.createActivePower(mw, ActivePowerUnitType.MW));
		interchange.setExErrTolerance(JaxbDataSetter.createActivePower(err, ActivePowerUnitType.MW));

		interchange.setAreaCode(code);
		interchange.setAreaName(name);
	}

	/*
	 *   Tieline data
	 *   ============ 
	 */

	private void processTielineData(final String str,
			final TielineXmlType tieLine, JaxbODMModelParser parser) {
		final String[] strAry = getTielineDataFields(str);

		//    	Columns  1- 4   Metered bus number [I] *
		//    	Columns  7-8    Metered area number [I] *
		final String meteredBusId = JaxbODMModelParser.BusIdPreFix + strAry[0];
		final String meteredAreaNo = strAry[1];

		//      Columns  11-14  Non-metered bus number [I] *
		//      Columns  17-18  Non-metered area number [I] *
		final String nonMeteredBusId = JaxbODMModelParser.BusIdPreFix + strAry[2];
		final String nonMeteredAreaNo = strAry[3];

		//      Column   21     Circuit number
		int cirNo = 0;
		if (!strAry[4].trim().equals(""))
			cirNo = new Integer(strAry[4]).intValue();

		try {
			tieLine.setMeteredBus(parser.createBusRecRef(meteredBusId));
			tieLine.setNonMeteredBus(parser.createBusRecRef(nonMeteredBusId));
		} catch (Exception e) {
			this.logErr("Tieline monitor/nonmonitored bus data error, " + e.toString());
		}

		tieLine.setMeteredArea(meteredAreaNo);
		tieLine.setNonMeteredArea(nonMeteredAreaNo);
		tieLine.setCirId(new Integer(cirNo).toString());
	}

	/*
	 * util functions
	 */
	private String[] getNetDataFields(final String str) {
		final String[] strAry = new String[6];

		if (str.indexOf(',') >= 0) {
			final StringTokenizer st = new StringTokenizer(str, ",");
			int cnt = 0;
			while (st.hasMoreTokens()) {
				strAry[cnt++] = st.nextToken().trim();
			}
		} else {
			try {
				//Columns  2- 9   Date, in format DD/MM/YY with leading zeros.  If no date provided, use 0b/0b/0b where b is blank.
				strAry[0] = str.substring(1, 9);
				//Columns 11-30   Originator's name [A]
				strAry[1] = str.substring(10, 30);
				//Columns 32-37   MVA Base [F] *
				strAry[2] = str.substring(31, 37); // in MVA
				//Columns 39-42   Year [I]
				strAry[3] = ModelStringUtil.getString(str, 38, 42);
				//Column  44      Season (S - Summer, W - Winter)
				strAry[4] = ModelStringUtil.getString(str, 43, 44);
				//Column  46-73   Case identification [A]
				strAry[5] = ModelStringUtil.getString(str, 46, 73);
			} catch (Exception e) {
				this.logErr("Error: Network data line has problem, " + str);
				this.logErr(e.toString());
			}
		}
		return strAry;
	}

	private String[] getBusDataFields(final String str) {
		final String[] strAry = new String[18];

		if (str.indexOf(',') >= 0) {
			final StringTokenizer st = new StringTokenizer(str, ",");
			int cnt = 0;
			while (st.hasMoreTokens()) {
				strAry[cnt++] = st.nextToken().trim();
			}
		} else {
			//Columns  1- 4   Bus number [I] *
			strAry[0] = str.substring(0, 4).trim();

			//Columns  6-17   Name [A] (left justify) *
			strAry[1] = str.substring(5, 17).trim();

			//Columns 19-20   Load flow area number [I].  Don't use zero! *
			//Columns 21-23   Loss zone number [I]
			strAry[2] = str.substring(18, 20).trim();
			strAry[3] = str.substring(20, 23).trim();

			//Columns 77-83   Base kV [F]
			strAry[11] = str.substring(76, 83);

			//Columns 25-26   Type [I] *
			//		0 - Unregulated (load, PQ)
			//		1 - Hold MVAR generation within voltage limits, (gen, PQ)
			//		2 - Hold voltage within VAR limits (gen, PV)
			//		3 - Hold voltage and angle (swing, V-Theta; must always have one)
			strAry[4] = str.substring(24, 26).trim();

			//Columns 28-33   Final voltage, p.u. [F] *
			//Columns 34-40   Final angle, degrees [F] *
			strAry[5] = str.substring(27, 33);
			strAry[6] = str.substring(33, 40);

			//Columns 41-49   Load MW [F] *
			//Columns 50-59   Load MVAR [F] *
			strAry[7] = str.substring(40, 49);
			strAry[8] = str.substring(49, 59);

			//Columns 60-67   Generation MW [F] *
			//Columns 68-75   Generation MVAR [F] *
			strAry[9] = str.substring(59, 67);
			strAry[10] = str.substring(67, 75);

			//Columns 107-114 Shunt conductance G (per unit) [F] *
			//Columns 115-122 Shunt susceptance B (per unit) [F] *
			strAry[15] = ModelStringUtil.getString(str,107, 114);
			strAry[16] = ModelStringUtil.getString(str,115, 122);

			//Columns 85-90   Desired volts (pu) [F] (This is desired remote voltage if this bus is controlling another bus.)
			strAry[12] = ModelStringUtil.getString(str,85, 90);

			//Columns 91-98   Minimum MVAR or voltage limit [F]
			//Columns 99-106  Maximum MVAR or voltage limit [F]
			strAry[13] = ModelStringUtil.getString(str,91, 98);
			strAry[14] = ModelStringUtil.getString(str,99, 106);

			//Columns 124-127 Remote controlled bus number
			strAry[17] = ModelStringUtil.getString(str,123, 127).trim();
		}
		return strAry;
	}

	private String[] getBranchDataFields(final String str) {
		final String[] strAry = new String[21];

		if (str.indexOf(',') >= 0) {
			final StringTokenizer st = new StringTokenizer(str, ",");
			int cnt = 0;
			while (st.hasMoreTokens()) {
				strAry[cnt++] = st.nextToken().trim();
			}
		} else {
			//        	Columns  1- 4   Tap bus number [I] *
			//      	For transformers or phase shifters, the side of the model the non-unity tap is on.
			//			Columns  6- 9   Z bus number [I] *
			//      	For transformers and phase shifters, the side of the model the device impedance is on.
			strAry[0] = str.substring(0, 4).trim();
			strAry[1] = str.substring(5, 9).trim();
			//    		IpssLogger.getLogger().fine("Branch data loaded, from-id, to-id: " + strAry[0] + ", " + strAry[1]);

			//    		Columns 11-12   Load flow area [I]
			//    		Columns 13-15   Loss zone [I]
			//    		Column  17      Circuit [I] * (Use 1 for single lines)
			strAry[2] = str.substring(10, 12).trim();
			strAry[3] = str.substring(12, 15).trim();
			strAry[4] = str.substring(16, 17).trim();

			//    		Column  19      Type [I] *
			strAry[5] = str.substring(18, 19).trim();

			//    		Columns 20-29   Branch resistance R, per unit [F] *
			//    		Columns 30-40   Branch reactance X, per unit [F] * No zero impedance lines
			//    		Columns 41-50   Line charging B, per unit [F] * (total line charging, +B)
			strAry[6] = str.substring(19, 29);
			strAry[7] = str.substring(29, 40);
			strAry[8] = str.substring(40, 50);

			//    		Columns 77-82   Transformer final turns ratio [F]
			//    		Columns 84-90   Transformer (phase shifter) final angle [F]
			strAry[14] = str.substring(76, 82);
			strAry[15] = str.substring(83, 90);

			//    		Columns 51-55   Line MVA rating No 1 [I] Left justify!
			//    		Columns 57-61   Line MVA rating No 2 [I] Left justify!
			//    		Columns 63-67   Line MVA rating No 3 [I] Left justify!
			strAry[9] = str.substring(50, 55).trim();
			strAry[10] = str.substring(56, 61).trim();
			strAry[11] = str.substring(62, 67).trim();

			if (new Integer(strAry[5]).intValue() > 1) {
				//    			Columns 69-72   Control bus number
				strAry[12] = str.substring(68, 72).trim();

				//        		Column  74      Side [I]
				strAry[13] = str.substring(73, 74).trim();

				//        		Columns 106-111 Step size [F]
				strAry[18] = str.substring(105, 111);

				//        		Columns 91-97   Maximum tap or phase shift [F]
				//        		Columns 98-104  Minimum tap or phase shift [F]
				strAry[16] = str.substring(90, 97);
				strAry[17] = str.substring(97, 104);

				//        		Columns 113-119 Minimum voltage, MVAR or MW limit [F]
				//        		Columns 120-126 Maximum voltage, MVAR or MW limit [F]
				strAry[19] = str.substring(112, 119);
				strAry[20] = str.substring(119, 126);
			}
		}
		return strAry;
	}

	private String[] getLossZoneDataFields(final String str) {
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