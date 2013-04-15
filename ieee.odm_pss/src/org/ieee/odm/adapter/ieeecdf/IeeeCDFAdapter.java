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

import org.ieee.odm.adapter.AbstractODMAdapter;
import org.ieee.odm.adapter.IFileReader;
import org.ieee.odm.adapter.IODMAdapter;
import org.ieee.odm.adapter.InputLineStringParser;
import org.ieee.odm.common.ODMException;
import org.ieee.odm.common.ODMLogger;
import org.ieee.odm.model.AbstractModelParser;
import org.ieee.odm.model.IODMModelParser;
import org.ieee.odm.model.aclf.AclfDataSetter;
import org.ieee.odm.model.aclf.AclfModelParser;
import org.ieee.odm.model.base.BaseDataSetter;
import org.ieee.odm.model.base.BaseJaxbHelper;
import org.ieee.odm.model.base.ModelStringUtil;
import org.ieee.odm.schema.ActivePowerUnitType;
import org.ieee.odm.schema.AdjustmentModeEnumType;
import org.ieee.odm.schema.AngleAdjustmentXmlType;
import org.ieee.odm.schema.AngleUnitType;
import org.ieee.odm.schema.ApparentPowerUnitType;
import org.ieee.odm.schema.BranchXmlType;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.InterchangeXmlType;
import org.ieee.odm.schema.LFGenCodeEnumType;
import org.ieee.odm.schema.LFLoadCodeEnumType;
import org.ieee.odm.schema.LimitXmlType;
import org.ieee.odm.schema.LineBranchXmlType;
import org.ieee.odm.schema.LoadflowBusXmlType;
import org.ieee.odm.schema.LoadflowGenXmlType;
import org.ieee.odm.schema.LoadflowNetXmlType;
import org.ieee.odm.schema.MvarFlowAdjustmentDataXmlType;
import org.ieee.odm.schema.NetZoneXmlType;
import org.ieee.odm.schema.ObjectFactory;
import org.ieee.odm.schema.OriginalDataFormatEnumType;
import org.ieee.odm.schema.PSXfrBranchXmlType;
import org.ieee.odm.schema.PowerInterchangeXmlType;
import org.ieee.odm.schema.ReactivePowerUnitType;
import org.ieee.odm.schema.TapAdjustBusLocationEnumType;
import org.ieee.odm.schema.TapAdjustmentXmlType;
import org.ieee.odm.schema.TielineXmlType;
import org.ieee.odm.schema.VoltageAdjustmentDataXmlType;
import org.ieee.odm.schema.VoltageUnitType;
import org.ieee.odm.schema.XfrBranchXmlType;
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

	public IeeeCDFAdapter() {
		super();
		this.factory = new ObjectFactory();		
	}
	 
	@Override
	protected AclfModelParser parseInputFile(
			final IFileReader din, String encoding) throws Exception {
		AclfModelParser parser = new AclfModelParser(encoding);
		parser.setLFTransInfo(OriginalDataFormatEnumType.IEEE_CDF);

		LoadflowNetXmlType baseCaseNet = parser.getAclfNet();
		baseCaseNet.setId("Base_Case_from_IEEECDF_format");

		String str = din.readLine();
		processNetData(str, baseCaseNet);

		int dataType = 0;
		do {
			str = din.readLine(); //kvaBase
			//NOTE: Some data miss the "END OF DATA" string at the end of the file, which may cause a problem
			if(str!=null){
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
						ODMLogger.getLogger().fine("load bus data");
					} else if ((str.length() > 6)
							&& str.substring(0, 6).equals("BRANCH")) {
						dataType = BranchData;
						ODMLogger.getLogger().fine("load branch data");
					} else if ((str.length() > 4)
							&& str.substring(0, 4).equals("LOSS")) {
						dataType = LossZone;
						//baseCaseNet.addNewLossZoneList();
						ODMLogger.getLogger().fine("load loss zone data");
					} else if ((str.length() > 11)
							&& str.substring(0, 11).equals("INTERCHANGE")) {
						dataType = InterchangeData;
						//baseCaseNet.addNewInterchangeList();
						ODMLogger.getLogger().fine("load interchange data");
					} else if ((str.length() > 3)
							&& str.substring(0, 3).equals("TIE")) {
						dataType = TielineData;
						//baseCaseNet.addNewTieLineList();
						ODMLogger.getLogger().fine("load tieline data");
					}
				} catch (final Exception e) {
					ODMLogger.getLogger().severe(e.toString() + "\n" + str);
					e.printStackTrace();
				}
			}
		  }else{
			  ODMLogger.getLogger().severe("No 'END OF DATA' is defined at the end of the input IEEE-CDF file!");
			  break;//end of the file, break the loop;
		  }
			  
		} while (!str.trim().equals("END OF DATA"));

		return parser;
	}

	protected IODMModelParser parseInputFile(IODMAdapter.NetType type, final IFileReader[] din, String encoding) throws Exception {
		throw new ODMException("not implemented yet");
	}
	
	/*
	 *   Network data
	 *   ============ 
	 */
	private IeeeCDFNetDataParser netDataParser = new IeeeCDFNetDataParser();
	private void processNetData(final String str, 
			final LoadflowNetXmlType baseCaseNet) throws ODMException {
		// parse the input data line {"Date", "Originator", "MVA", "Year", "Season", "CaseId"}
		netDataParser.parseFields(str);
		InputLineStringParser dataParser = this.busDataParser.getDataParser();

		//NameValuePairListXmlType nvList = this.factory.createNameValuePairListXmlType();
		//baseCaseNet.setNvPairList(nvList);

		//[0] Columns  2- 9   Date, in format DD/MM/YY with leading zeros.  If no date provided, use 0b/0b/0b where b is blank.
		if (dataParser.exist("Date")) {
			final String date = dataParser.getString("Date");
			BaseJaxbHelper.addNVPair(baseCaseNet, Token_Date, date);
		}
		
		//[1] Columns 11-30   Originator's name [A]
		if (dataParser.exist("Originator")) {
			final String orgName = dataParser.getString("Originator");
			BaseJaxbHelper.addNVPair(baseCaseNet, Token_OrgName, orgName);
		}

		//[3] Columns 39-42   Year [I]
		if (dataParser.equals("Year")) {
			final String year = dataParser.getString("Year");
			BaseJaxbHelper.addNVPair(baseCaseNet, Token_Year, year);
		}
		
		//[4] Column  44      Season (S - Summer, W - Winter)
		if (dataParser.exist("Season")) {
			final String season = dataParser.getString("Season");
			BaseJaxbHelper.addNVPair(baseCaseNet, Token_Season, season);
		}
		
		//[5] Column  46-73   Case identification [A]
		if (netDataParser.getDataParser().exist("CaseId")) {
			final String caseId = dataParser.getString("CaseId");
			if (caseId != null)
				BaseJaxbHelper.addNVPair(baseCaseNet, Token_CaseId, caseId);
			//ODMLogger.getLogger().fine("date, orgName, year, season, caseId: " + date + ", "
			//		+ orgName + ", " + year + ", " + season + ", " + caseId);
		}

		//[2] Columns 32-37   MVA Base [F] *
		double baseMva = 100.0;
		if (dataParser.equals("MVA")) {
			baseMva = dataParser.getDouble("MVA"); // in MVA
			ODMLogger.getLogger().fine("BaseKva: " + baseMva);
		}
		baseCaseNet.setBasePower(BaseDataSetter.createPowerMvaValue(baseMva));
	}

	/*
	 *   Bus data
	 *   ======== 
	 */
	private IeeeCDFBusDataParser busDataParser = new IeeeCDFBusDataParser();
	private  void processBusData(final String str, AclfModelParser parser) throws ODMException {
		// parse the input data line
		//final String[] strAry = IeeeCDFDataParser.getBusDataFields(str);
		busDataParser.parseFields(str);
		InputLineStringParser dataParser = this.busDataParser.getDataParser();

		//Columns  1- 4   Bus number [I] *
		final String busId = AbstractModelParser.BusIdPreFix + dataParser.getString("BusNumber");
		ODMLogger.getLogger().fine("Bus data loaded, id: " + busId);
		LoadflowBusXmlType aclfBus = null;
		try {
			aclfBus = parser.createAclfBus(busId);
		} catch (Exception e) {
			this.logErr(e.toString());
			return;
		}
		aclfBus.setNumber(dataParser.getLong("BusNumber"));

		//Columns  6-17   Name [A] (left justify) *
		final String busName = dataParser.getString("BusName");
		aclfBus.setName(busName);

		//Columns 19-20   Load flow area number [I].  Don't use zero! *
		//Columns 21-23   Loss zone number [I]
		final int areaNo = dataParser.getInt("Area");
		final int zoneNo = dataParser.getInt("Zone");
		aclfBus.setAreaNumber(areaNo);
		aclfBus.setZoneNumber(zoneNo);

		//Columns 77-83   Base kV [F]
		double baseKv =  dataParser.getDouble("BaseKV");
		if (baseKv == 0.0) {
			baseKv = 1.0;
		}
		aclfBus.setBaseVoltage(BaseDataSetter.createVoltageValue(baseKv, VoltageUnitType.KV));

		//aclfBus.setLoadflowData(this.factory.createLoadflowBusDataXmlType());
		//LoadflowBusDataXmlType busData = aclfBus.getLoadflowData();
		//Columns 25-26   Type [I] *
		//		0 - Unregulated (load, PQ)
		//		1 - Hold MVAR generation within voltage limits, (gen, PQ)
		//		2 - Hold voltage within VAR limits (gen, PV)
		//		3 - Hold voltage and angle (swing, V-Theta; must always have one)
		// it might empty, if empty, type = 0;
		int type = 0;
		if (!dataParser.getString("Type").trim().equals(""))
			type = dataParser.getInt("Type");

		//Columns 28-33   Final voltage, p.u. [F] *
		//Columns 34-40   Final angle, degrees [F] *
		final double vpu = dataParser.getDouble("VMag");
		final double angDeg = dataParser.getDouble("VAng");
		aclfBus.setVoltage(BaseDataSetter.createVoltageValue(vpu, VoltageUnitType.PU));

		aclfBus.setAngle(BaseDataSetter.createAngleValue(angDeg, AngleUnitType.DEG));

		//Columns 41-49   Load MW [F] *
		//Columns 50-59   Load MVAR [F] *
		final double loadMw = dataParser.getDouble("LoadP");
		final double loadMvar = dataParser.getDouble("LoadQ");
		if (loadMw != 0.0 || loadMvar != 0.0) {
			AclfDataSetter.setLoadData(aclfBus,
					LFLoadCodeEnumType.CONST_P, loadMw,
					loadMvar, ApparentPowerUnitType.MVA);
		}

		//Columns 60-67   Generation MW [F] *
		//Columns 68-75   Generation MVAR [F] *
		final double genMw = dataParser.getDouble("GenP");
		final double genMvar = dataParser.getDouble("GenQ");

		LFGenCodeEnumType genType = type == 3? LFGenCodeEnumType.SWING :
				( type == 2? LFGenCodeEnumType.PV : LFGenCodeEnumType.PQ );
		AclfDataSetter.setGenData(
				aclfBus, genType, vpu, VoltageUnitType.PU, angDeg, AngleUnitType.DEG, 
				genMw, genMvar,	ApparentPowerUnitType.MVA);

		//Columns 107-114 Shunt conductance G (per unit) [F] *
		//Columns 115-122 Shunt susceptance B (per unit) [F] *
		final double gPU = dataParser.getDouble("ShuntG");
		final double bPU = dataParser.getDouble("ShuntB");
		if (gPU != 0.0 || bPU != 0.0) {
			aclfBus.setShuntY(BaseDataSetter.createYValue(gPU, bPU, YUnitType.PU));
		}

		//Columns 85-90   Desired volts (pu) [F] (This is desired remote voltage if this bus is controlling another bus.)
		final double vSpecPu = dataParser.getDouble("DesiredV");

		//Columns 91-98   Maximum MVAR or voltage limit [F]
		//Columns 99-106  Minimum MVAR or voltage limit [F]
		final double max = dataParser.getDouble("MaxVarVolt");
		final double min = dataParser.getDouble("MinVarVolt");

		//Columns 124-127 Remote controlled bus number
		final String reBusId = dataParser.getString("RemoteBusNumber");

		if (max != 0.0 || min != 0.0) {
			LoadflowGenXmlType equivGen = aclfBus.getGenData().getEquivGen();
			if (type == 1) {
				equivGen.setVoltageLimit(BaseDataSetter.createVoltageLimit(max, min, VoltageUnitType.PU));
			} else if (type == 2) {
				aclfBus.getGenData().getEquivGen().setQLimit(BaseDataSetter.createReactivePowerLimit(max, min, ReactivePowerUnitType.MVAR));
				if (reBusId != null && !reBusId.equals("0")
						&& !reBusId.equals(busId)) {
					equivGen.setDesiredVoltage(BaseDataSetter.createVoltageValue(vSpecPu, VoltageUnitType.PU));
					equivGen.setRemoteVoltageControlBus(parser.createBusRef(reBusId));
				}
			}
		}
	}

	/*
	 *   Branch data
	 *   =========== 
	 */

	private void processBranchData(final String str, AclfModelParser parser) {
		// parse the input data line
		final String[] strAry = IeeeCDFDataParser.getBranchDataFields(str);

		//    	Columns  1- 4   Tap bus number [I] *
		//      	For transformers or phase shifters, the side of the model the non-unity tap is on.
		//		Columns  6- 9   Z bus number [I] *
		//      	For transformers and phase shifters, the side of the model the device impedance is on.
		//    	Columns 11-12   Load flow area [I]
		//    	Columns 13-15   Loss zone [I]
		//    	Column  17      Circuit [I] * (Use 1 for single lines)
		//    	Column  19      Type [I] *
		//      0 - Transmission line
		//      1 - Fixed tap
		//      2 - Variable tap for voltage control (TCUL, LTC)
		//      3 - Variable tap (turns ratio) for MVAR control
		//      4 - Variable phase angle for MW control (phase shifter)
		final String fid = AbstractModelParser.BusIdPreFix + strAry[0];
		final String tid = AbstractModelParser.BusIdPreFix + strAry[1];
		final String areaNo = strAry[2];
		final String zoneNo = strAry[3];
		String cirId = strAry[4];
		if(cirId.equals(""))cirId="1";//if empty,set cirId to 1 by default
		int branchType = 0;
		if (!strAry[5].trim().equals(""))
			branchType = new Integer(strAry[5]).intValue();
		//String branchId = ModelStringUtil.formBranchId(fid, tid, cirId);
		BranchXmlType branch = null;
		try {
			branch = branchType == 0?
					parser.createLineBranch(fid, tid, cirId) :
						((branchType == 1 || branchType == 2 || branchType == 3)?
								parser.createXfrBranch(fid, tid, cirId) : parser.createPSXfrBranch(fid, tid, cirId));
		} catch (Exception e) {
			this.logErr("branch data error, " + e.toString());
		}
		/*
		getLogger().fine("Branch data loaded, from-id, to-id: " + fid + ", " + tid);
		try {
			branch.setFromBus(parser.createBusRef(fid));
			branch.setToBus(parser.createBusRef(tid));
		} catch (Exception e) {
			this.logErr("branch is not connected properly, " + e.toString());
		}
		*/
		int an = 0, zn = 0;
		if (!areaNo.trim().equals(""))
			an = new Integer(areaNo).intValue();
		if (!zoneNo.trim().equals(""))
			zn = new Integer(zoneNo).intValue();
		branch.setAreaNumber(new Integer(an).intValue());
		branch.setZoneNumber(new Integer(zn).intValue());
		branch.setCircuitId(cirId);

		branch.setId(ModelStringUtil.formBranchId(fid, tid, cirId));

		//LoadflowBranchDataXmlType branchData = this.factory.createLoadflowBranchDataXmlType(); 
		//branch.getLoadflowData().add(branchData);


		//    	Columns 20-29   Branch resistance R, per unit [F] *
		//    	Columns 30-40   Branch reactance X, per unit [F] * No zero impedance lines
		//    	Columns 41-50   Line charging B, per unit [F] * (total line charging, +B), Xfr B is negative
		final double rpu = new Double(strAry[6]).doubleValue();
		final double xpu = new Double(strAry[7]).doubleValue();
		final double bpu = new Double(strAry[8]).doubleValue();
		if (branchType == 0) {
			LineBranchXmlType line = (LineBranchXmlType)branch;
			AclfDataSetter.setLineData(line, rpu, xpu,
					ZUnitType.PU, 0.0, bpu, YUnitType.PU);
		}

		// assume ratio and angle are defined at to side
		//    	Columns 77-82   Transformer final turns ratio [F]
		//    	Columns 84-90   Transformer (phase shifter) final angle [F]
		final double ratio = new Double(strAry[14]).doubleValue();
		final double angle = new Double(strAry[15]).doubleValue();
		if (branchType > 0) {
			if (angle == 0.0) {
				XfrBranchXmlType xfrBranch = (XfrBranchXmlType)branch;
				AclfDataSetter.createXformerData(xfrBranch,
						rpu, xpu, ZUnitType.PU, ratio, 1.0, 
						0.0, bpu, YUnitType.PU);
				BusXmlType fromBusRec = parser.getBus(fid);
				BusXmlType toBusRec = parser.getBus(tid);
				if (fromBusRec != null && toBusRec != null) {
					AclfDataSetter.setXfrRatingData(xfrBranch,
							fromBusRec.getBaseVoltage().getValue(), 
							toBusRec.getBaseVoltage().getValue(), 
							fromBusRec.getBaseVoltage().getUnit());				
				}
				else {
					logErr("Error: fromBusRecord and/or toBusRecord cannot be found, fromId, toId: " + fid + ", " + tid);
				}
			} else {
				PSXfrBranchXmlType psXfrBranch = (PSXfrBranchXmlType)branch;
				AclfDataSetter.createPhaseShiftXfrData(psXfrBranch, rpu, xpu, ZUnitType.PU,
						ratio, 1.0, angle, 0.0, AngleUnitType.DEG,
						0.0, bpu, YUnitType.PU);
				BusXmlType fromBusRec = parser.getBus(fid);
				BusXmlType toBusRec = parser.getBus(tid);
				if (fromBusRec != null && toBusRec != null) {
					AclfDataSetter.setXfrRatingData(psXfrBranch,
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
		double rating1Mvar = 0.0, rating2Mvar = 0.0, rating3Mvar = 0.0;
		if (!strAry[9].trim().equals(""))
			rating1Mvar = new Double(strAry[9]).doubleValue();
		if (!strAry[10].trim().equals(""))
			rating2Mvar = new Double(strAry[10]).doubleValue();
		if (!strAry[11].trim().equals(""))
			rating3Mvar = new Double(strAry[11]).doubleValue();
		branch.setRatingLimit(this.factory.createBranchRatingLimitXmlType());
		AclfDataSetter.setBranchRatingLimitData(branch.getRatingLimit(),
				rating1Mvar, rating2Mvar, rating3Mvar, ApparentPowerUnitType.MVA);

		String controlBusId = "";
		int controlSide = 0;
		double stepSize = 0.0, maxTapAng = 0.0, minTapAng = 0.0, maxVoltPQ = 0.0, minVoltPQ = 0.0;
		if (branchType > 1) {
			//    		Columns 69-72   Control bus number
			controlBusId = AbstractModelParser.BusIdPreFix + strAry[12];

			//        	Column  74      Side [I]
			//          	0 - Controlled bus is one of the terminals
			//          	1 - Controlled bus is near the tap side
			//          	2 - Controlled bus is near the impedance side (Z bus)
			controlSide = 0;
			if (!strAry[13].trim().equals(""))
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

		if (branchType == 2 || branchType == 3) {
			XfrBranchXmlType xfrBranch = (XfrBranchXmlType)branch;
			TapAdjustmentXmlType tapAdj = this.factory.createTapAdjustmentXmlType();
			xfrBranch.setTapAdjustment(tapAdj);
			tapAdj.setTapLimit(BaseDataSetter.createTapLimit(maxTapAng, minTapAng));
			tapAdj.setTapAdjStepSize(stepSize);
			tapAdj.setTapAdjOnFromSide(true);
			if (branchType == 2) {
				VoltageAdjustmentDataXmlType voltTapAdj = this.factory.createVoltageAdjustmentDataXmlType();
				tapAdj.setVoltageAdjData(voltTapAdj);
				try {
					voltTapAdj.setAdjVoltageBus(parser.createBusRef(controlBusId));
				} catch (Exception e) {
					this.logErr("Xfr control bus not defined properly, " + e.toString());
				}
					
				voltTapAdj.setAdjBusLocation(controlSide == 0 ? TapAdjustBusLocationEnumType.TERMINAL_BUS
								: (controlSide == 1 ? TapAdjustBusLocationEnumType.NEAR_FROM_BUS
										: TapAdjustBusLocationEnumType.NEAR_TO_BUS));
				voltTapAdj.setMode(AdjustmentModeEnumType.RANGE_ADJUSTMENT);
				
				if(voltTapAdj.getRange()==null)voltTapAdj.setRange(new LimitXmlType());
				BaseDataSetter.setLimit(voltTapAdj.getRange(), maxVoltPQ, minVoltPQ);
				
			} else if (branchType == 3) {
				MvarFlowAdjustmentDataXmlType mvarTapAdj = this.factory.createMvarFlowAdjustmentDataXmlType();
				tapAdj.setMvarFlowAdjData(mvarTapAdj);
				
				if(mvarTapAdj.getRange()==null)mvarTapAdj.setRange(new LimitXmlType());
				BaseDataSetter.setLimit(mvarTapAdj.getRange(), maxVoltPQ, minVoltPQ);
				
				mvarTapAdj.setMode(AdjustmentModeEnumType.RANGE_ADJUSTMENT);
				mvarTapAdj.setMvarMeasuredOnFormSide(true);
			}
		} else if (branchType == 4) {
			PSXfrBranchXmlType psXfrBranch = (PSXfrBranchXmlType)branch;
			AngleAdjustmentXmlType angAdj = this.factory.createAngleAdjustmentXmlType();
			psXfrBranch.setAngleAdjustment(angAdj);
			angAdj.setAngleLimit(this.factory.createAngleLimitXmlType());
			BaseDataSetter.setLimit(angAdj.getAngleLimit(), maxTapAng, minTapAng);
			BaseDataSetter.setLimit(angAdj.getRange(), maxVoltPQ, minVoltPQ);
			angAdj.setMode(AdjustmentModeEnumType.RANGE_ADJUSTMENT);
			angAdj.setDesiredMeasuredOnFromSide(true);
		}
	}

	/*
	 *   Loss Zone data
	 *   ============== 
	 */

	private void processLossZoneData(final String str,	final NetZoneXmlType lossZone) {
		final String[] strAry = IeeeCDFDataParser.getLossZoneDataFields(str);

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
			final PowerInterchangeXmlType interchange, AclfModelParser parser) {
		final String[] strAry = IeeeCDFDataParser.getInterchangeDataFields(str);

		//    	Columns  1- 2   Area number [I], no zeros! *
		final int no = new Integer(strAry[0]).intValue();

		//    	Columns  4- 7   Interchange slack bus number [I] *
		//      Columns  9-20   Alternate swing bus name [A]
		final String slackBusId = AbstractModelParser.BusIdPreFix + strAry[1];
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
		
		int slackBusNumber = new Integer(strAry[1]).intValue();
		if (slackBusNumber > 0)
			try {
				interchange.setSwingBus(parser.createBusRef(slackBusId));
				interchange.setAlternateSwingBusName(alSwingBusName);
			} catch (Exception e) {
				this.logErr("Interchange data error, " + e.toString());
			}
		
		interchange.setDesiredExPower(BaseDataSetter.createActivePowerValue(mw, ActivePowerUnitType.MW));
		interchange.setExErrTolerance(BaseDataSetter.createActivePowerValue(err, ActivePowerUnitType.MW));

		interchange.setAreaCode(code);
		interchange.setAreaName(name);
	}

	/*
	 *   Tieline data
	 *   ============ 
	 */

	private void processTielineData(final String str,
			final TielineXmlType tieLine, AclfModelParser parser) {
		final String[] strAry = IeeeCDFDataParser.getTielineDataFields(str);

		//    	Columns  1- 4   Metered bus number [I] *
		//    	Columns  7-8    Metered area number [I] *
		final String meteredBusId = AbstractModelParser.BusIdPreFix + strAry[0];
		final String meteredAreaNo = strAry[1];

		//      Columns  11-14  Non-metered bus number [I] *
		//      Columns  17-18  Non-metered area number [I] *
		final String nonMeteredBusId = AbstractModelParser.BusIdPreFix + strAry[2];
		final String nonMeteredAreaNo = strAry[3];

		//      Column   21     Circuit number
		int cirNo = 0;
		if (!strAry[4].trim().equals(""))
			cirNo = new Integer(strAry[4]).intValue();

		try {
			tieLine.setMeteredBus(parser.createBusRef(meteredBusId));
			tieLine.setNonMeteredBus(parser.createBusRef(nonMeteredBusId));
		} catch (Exception e) {
			this.logErr("Tieline monitor/nonmonitored bus data error, " + e.toString());
		}

		tieLine.setMeteredArea(meteredAreaNo);
		tieLine.setNonMeteredArea(nonMeteredAreaNo);
		tieLine.setCirId(new Integer(cirNo).toString());
	}
}