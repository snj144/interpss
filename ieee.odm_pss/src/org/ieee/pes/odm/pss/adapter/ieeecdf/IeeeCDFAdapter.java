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

package org.ieee.pes.odm.pss.adapter.ieeecdf;


import java.util.StringTokenizer;
import java.util.logging.Logger;

import org.ieee.cmte.psace.oss.odm.pss.schema.AngleXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.BranchRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.LoadflowBranchDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.LoadflowBusDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.NameValuePairListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.PowerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.StudyCaseXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.VoltageXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.YXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.ZXmlType;
import org.ieee.pes.odm.pss.model.IEEEODMPSSModelParser;
import org.ieee.pes.odm.pss.model.ODMXmlUtil;

public class IeeeCDFAdapter {
	private static final int BusData = 1;
	private static final int BranchData = 2;
	private static final int LossZone = 3;
	private static final int InterchangeData = 4;
	private static final int TielineData = 5;
	
	private static Logger logger;

    public static IEEEODMPSSModelParser parseInputFile(final java.io.BufferedReader din, final Logger lgr) throws Exception {
    	logger = lgr;
    	
    	IEEEODMPSSModelParser parser = new IEEEODMPSSModelParser();

    	parser.getStudyCase().setSchemaVersion(StudyCaseXmlType.SchemaVersion.V_1_00_DEV);
    	parser.getStudyCase().setOriginalFormat(StudyCaseXmlType.OriginalFormat.IEEE_CDF);
    	parser.getStudyCase().setAdapterProviderName("www.interpss.org");
    	parser.getStudyCase().setAdapterProviderVersion("1.00");
    	
    	parser.getStudyCase().setAnalysisCategory(StudyCaseXmlType.AnalysisCategory.LOADFLOW);
    	parser.getStudyCase().setNetworkCategory(StudyCaseXmlType.NetworkCategory.TRANSMISSION);

    	PSSNetworkXmlType baseCaseNet = parser.getBaseCase();
    	baseCaseNet.setId("Base Case from IEEE CDF format");
    	
		String str = din.readLine();
        processNetData(str, baseCaseNet);
    	
    	int dataType = 0;
    	do {
          	str = din.readLine();   //kvaBase
        	if (!str.trim().equals("END OF DATA")) {
    			try {
            		// process the data
            		if (str.startsWith("-999") || str.startsWith("-99") || str.startsWith("-9")) {
            			dataType = 0;
            		}
            		else if (dataType == BusData) {
            			processBusData(str, parser.addNewBaseCaseBus());
            		}
            		else if (dataType == BranchData) {
            		    processBranchData(str, parser.addNewBaseCaseBranch());
            		}
            		else if (dataType == LossZone) {
            		    processLossZoneData(str, baseCaseNet);
            		}
            		else if (dataType == InterchangeData) {
            		    processInterchangeData(str, baseCaseNet);
            		}
            		else if (dataType == TielineData) {
            		    processTielineData(str, baseCaseNet);
            		}
            		else if ((str.length() > 3) && str.substring(0,3).equals("BUS")) {
            			dataType = BusData;
                    	logger.info("load bus data");
            		}
            		else if ((str.length() > 6) && str.substring(0,6).equals("BRANCH")) {
            			dataType = BranchData;
            			logger.info("load branch data");
            		}
            		else if ((str.length() > 4) && str.substring(0,4).equals("LOSS")) {
            			dataType = LossZone;
            			logger.info("load loss zone data");
            		}
            		else if ((str.length() > 11) && str.substring(0,11).equals("INTERCHANGE")) {
            			dataType = InterchangeData;
            			logger.info("load interchange data");
            		}
            		else if ((str.length() > 3) && str.substring(0,3).equals("TIE")) {
            			dataType = TielineData;
            			logger.info("load tieline data");
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

    private static void processNetData(final String str, final PSSNetworkXmlType baseCaseNet) {
    	// parse the input data line
    	final String[] strAry = getNetDataFields(str);
    	
    	NameValuePairListXmlType nvList = baseCaseNet.addNewNvPairList();

    	//[0] Columns  2- 9   Date, in format DD/MM/YY with leading zeros.  If no date provided, use 0b/0b/0b where b is blank.
    	final String date = strAry[0];
    	ODMXmlUtil.addNVPair(nvList, "Date", date);
    	
        //[1] Columns 11-30   Originator's name [A]
    	final String orgName = strAry[1];
    	ODMXmlUtil.addNVPair(nvList, "Originator Name", orgName);
    	
        //[3] Columns 39-42   Year [I]
    	final String year = strAry[3];
    	ODMXmlUtil.addNVPair(nvList, "Year", year);
    	
        //[4] Column  44      Season (S - Summer, W - Winter)
    	final String season = strAry[4];
    	ODMXmlUtil.addNVPair(nvList, "Season", season);

    	//[5] Column  46-73   Case identification [A]
    	final String caseId = strAry[5];
    	ODMXmlUtil.addNVPair(nvList, "Case Identification", caseId);

    	logger.info("date, orgName, year, season, caseId: " + date + ", " 
    			+ orgName + ", " + year + ", " + season + ", " + caseId);

    	//[2] Columns 32-37   MVA Base [F] *
    	final double baseMva = new Double(strAry[2]).doubleValue();  // in MVA
    	logger.info("BaseKva: " + baseMva ); 
    	baseCaseNet.setBaseKva(baseMva);
    	baseCaseNet.setBaseKvaUnit(PSSNetworkXmlType.BaseKvaUnit.MVA);
    }
    /*
     *   Bus data
     *   ======== 
     */

    private static void processBusData(final String str, final BusRecordXmlType busRec) {
    	// parse the input data line
    	final String[] strAry = getBusDataFields(str);
    	
    	//Columns  1- 4   Bus number [I] *
    	final String busId = strAry[0];
    	logger.info("Bus data loaded, id: " + busId);
    	busRec.setId(busId);
    	
    	//Columns  6-17   Name [A] (left justify) *
    	final String busName = strAry[1];
    	busRec.setName(busName);
    	
    	//Columns 19-20   Load flow area number [I].  Don't use zero! *
    	//Columns 21-23   Loss zone number [I]
    	final int areaNo = new Integer(strAry[2]).intValue();
    	final int zoneNo = new Integer(strAry[3]).intValue();
    	busRec.setArea(areaNo);
    	busRec.setZone(zoneNo);
    	
    	//Columns 77-83   Base kV [F]
    	double baseKv = new Double(strAry[11]).doubleValue();
    	if (baseKv == 0.0) {
			baseKv = 1.0;
		}
    	busRec.setBaseVoltage(baseKv);
    	busRec.setBaseVoltageUnit(BusRecordXmlType.BaseVoltageUnit.KV);
    	
    	LoadflowBusDataXmlType busData = busRec.addNewLoadflowBusData();
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
    	ODMXmlUtil.setVoltageData(busData.addNewVoltage(), vpu, VoltageXmlType.Unit.PU);
    	
    	ODMXmlUtil.setAngleData(busData.addNewAngle(), angDeg, AngleXmlType.Unit.DEG);

    	//Columns 41-49   Load MW [F] *
    	//Columns 50-59   Load MVAR [F] *
    	final double loadMw = new Double(strAry[7]).doubleValue();
    	final double loadMvar = new Double(strAry[8]).doubleValue();
    	if (loadMw != 0.0 || loadMvar != 0.0) {
    		ODMXmlUtil.setLoadData(busData, LoadflowBusDataXmlType.LoadData.Code.CONST_P, loadMw, loadMvar, PowerXmlType.Unit.MVA);
    	}
    	
    	//Columns 60-67   Generation MW [F] *
    	//Columns 68-75   Generation MVAR [F] *
    	final double genMw = new Double(strAry[9]).doubleValue();
    	final double genMvar = new Double(strAry[10]).doubleValue();

    	if (type == 1) {
    		ODMXmlUtil.setGenData(busData, LoadflowBusDataXmlType.GenData.Code.PQ, genMw, genMvar, PowerXmlType.Unit.MVA);
    	}
    	else if (type == 2) {
    		ODMXmlUtil.setGenData(busData, LoadflowBusDataXmlType.GenData.Code.PV, genMw, genMvar, PowerXmlType.Unit.MVA);
    	}
    	else if (type == 3) {
    		ODMXmlUtil.setGenData(busData, LoadflowBusDataXmlType.GenData.Code.SWING, genMw, genMvar, PowerXmlType.Unit.MVA);
    	}

    	//Columns 107-114 Shunt conductance G (per unit) [F] *
    	//Columns 115-122 Shunt susceptance B (per unit) [F] *
    	final double gPU = new Double(strAry[15]).doubleValue();
    	final double bPU = new Double(strAry[16]).doubleValue();
    	if (gPU != 0.0 || bPU != 0.0) {
    		ODMXmlUtil.setYData(busData.addNewShuntY(), gPU, bPU, YXmlType.Unit.PU);
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
    		if (type == 1) {
    			busData.getGenData().addNewVGenLimit();
    			ODMXmlUtil.setLimitData(busData.getGenData().getVGenLimit().addNewVLimit(), max, min);
    			busData.getGenData().getVGenLimit().setVLimitUnit(LoadflowBusDataXmlType.GenData.VGenLimit.VLimitUnit.PU);
    		}
    		else if (type ==2) {
    			busData.getGenData().addNewQGenLimit();
    			ODMXmlUtil.setLimitData(busData.getGenData().getQGenLimit().addNewQLimit(), max, min);
    			busData.getGenData().getQGenLimit().setQLimitUnit(LoadflowBusDataXmlType.GenData.QGenLimit.QLimitUnit.MVAR);
    			if (reBusId != null && !reBusId.equals("0") && !reBusId.equals(busId)) {
    				busData.getGenData().addNewDesiredRemoteVoltage();
    				ODMXmlUtil.setVoltageData(busData.getGenData().getDesiredRemoteVoltage().addNewDesiredVoltage(), vSpecPu, VoltageXmlType.Unit.PU);
    				busData.getGenData().getDesiredRemoteVoltage().addNewRemoteBus();
    				busData.getGenData().getDesiredRemoteVoltage().getRemoteBus().setIdRef(reBusId);
    			}
    		}
    	}
    }
    
    /*
     *   Branch data
     *   =========== 
     */

    private static void processBranchData(final String str, final BranchRecordXmlType branchRec) {
    	// parse the input data line
    	final String[] strAry = getBranchDataFields(str);

//    	Columns  1- 4   Tap bus number [I] *
//      	For transformers or phase shifters, the side of the model the non-unity tap is on.
//		Columns  6- 9   Z bus number [I] *
//      	For transformers and phase shifters, the side of the model the device impedance is on.
    	final String fid = strAry[0];
    	final String tid = strAry[1];
    	logger.info("Branch data loaded, from-id, to-id: " + fid + ", " + tid);
    	branchRec.addNewFromBus().setIdRef(fid);
    	branchRec.addNewToBus().setIdRef(tid);

//    	Columns 11-12   Load flow area [I]
//    	Columns 13-15   Loss zone [I]
//    	Column  17      Circuit [I] * (Use 1 for single lines)
    	final int areaNo = new Integer(strAry[2]).intValue();
    	final int zoneNo = new Integer(strAry[3]).intValue();
    	final String cirId  = strAry[4];
    	branchRec.setArea(areaNo);
    	branchRec.setZone(zoneNo);
    	branchRec.setCircuitId(cirId);
    	
    	branchRec.setId(ODMXmlUtil.formBranchId(fid, tid, cirId));
    	branchRec.addNewLoadflowBranchData();
    	
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
    		ODMXmlUtil.setLineData(branchRec.getLoadflowBranchData(), rpu, xpu, ZXmlType.Unit.PU, 0.0, bpu, YXmlType.Unit.PU);
    	}
    	
    	// assume ratio and angle are defined at to side
//    	Columns 77-82   Transformer final turns ratio [F]
//    	Columns 84-90   Transformer (phase shifter) final angle [F]
    	final double ratio = new Double(strAry[14]).doubleValue();
    	final double angle = new Double(strAry[15]).doubleValue();
    	if (type > 0) {
    		if (angle == 0.0) {
        		branchRec.getLoadflowBranchData().addNewXformerData();
        		ODMXmlUtil.setZValue(branchRec.getLoadflowBranchData().getXformerData().addNewZ(),
        						rpu, xpu, ZXmlType.Unit.PU);
        		// assume b and ratio are defined at the from bus side
        		if (bpu != 0.0) 
        			ODMXmlUtil.setYData(branchRec.getLoadflowBranchData().getXformerData().addNewFromShuntY(),
        							0.0, bpu, YXmlType.Unit.PU);
        		branchRec.getLoadflowBranchData().getXformerData().setFromTurnRatio(ratio);
    		}
    		else {
        		branchRec.getLoadflowBranchData().addNewPhaseShiftXfrData();
        		ODMXmlUtil.setZValue(branchRec.getLoadflowBranchData().getPhaseShiftXfrData().addNewZ(),
        						rpu, xpu, ZXmlType.Unit.PU);
        		if (bpu != 0.0) {
        			ODMXmlUtil.setYData(branchRec.getLoadflowBranchData().getPhaseShiftXfrData().addNewFromShuntY(),
        							0.0, bpu, YXmlType.Unit.PU);
        		}
        		branchRec.getLoadflowBranchData().getPhaseShiftXfrData().setFromTurnRatio(ratio);
        		ODMXmlUtil.setAngleData(branchRec.getLoadflowBranchData().getPhaseShiftXfrData().addNewFromAngle(), angle, AngleXmlType.Unit.DEG);
    		}
    	}
    	
//    	Columns 51-55   Line MVA rating No 1 [I] Left justify!
//    	Columns 57-61   Line MVA rating No 2 [I] Left justify!
//    	Columns 63-67   Line MVA rating No 3 [I] Left justify!
    	final double rating1Mvar = new Integer(strAry[9]).intValue();
    	final double rating2Mvar = new Integer(strAry[10]).intValue();
    	final double rating3Mvar = new Integer(strAry[11]).intValue();
    	if (rating1Mvar != 0.0 || rating2Mvar != 0.0 || rating3Mvar != 0.0) {
    		branchRec.getLoadflowBranchData().addNewRatingData();
        	branchRec.getLoadflowBranchData().getRatingData().setMvaRating1(rating1Mvar);
        	branchRec.getLoadflowBranchData().getRatingData().setMvaRating2(rating2Mvar);
        	branchRec.getLoadflowBranchData().getRatingData().setMvaRating3(rating3Mvar);
        	branchRec.getLoadflowBranchData().getRatingData().setMvaRatingUnit(LoadflowBranchDataXmlType.RatingData.MvaRatingUnit.MVA);
    	}
    	
    	String controlBusId = "";
    	int controlSide = 0;
    	double stepSize = 0.0, maxTapAng = 0.0, minTapAng = 0.0, maxVoltPQ = 0.0, minVoltPQ = 0.0;
    	if (type > 1) {
//    		Columns 69-72   Control bus number
        	controlBusId = strAry[12];

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
    	
        if (type == 2) {
        	// type 2 - Variable tap for voltage control (TCUL, LTC)
        	/*
          		final TapControl tapv = CoreObjectFactory.createTapVControlBusVoltage(net, bra.getId(), controlBusId, FlowControlType.RANGE_CONTROL);
          		tapv.setTapLimit(new LimitType(maxTapAng, minTapAng));
          		// TODO: volt spec is not defined
          		tapv.setVSpecified(1.0);
          		tapv.setTapStepSize(stepSize);
          		tapv.setControlOnFromSide(getSide(controlSide, controlBusId, bra));
          		net.addTapControl(tapv, controlBusId);
          		*/          		
       	}
        else if (type == 3) {
          		// type 3 - Variable tap (turns ratio) for MVAR control
          		/*
          		final TapControl tapv = CoreObjectFactory.createTapVControlMvarFlow(net, bra.getId(), FlowControlType.RANGE_CONTROL);
          		tapv.setTapLimit(new LimitType(maxVoltPQ, minVoltPQ));
          		// TODO: volt spec is not defined
          		tapv.setVSpecified(1.0);
          		tapv.setTapStepSize(stepSize);
          		tapv.setControlOnFromSide(getSide(controlSide, controlBusId, bra));
          		net.addTapControl(tapv, controlBusId);
          		*/          		
        }
        else if (type == 4) {
          		// type 4 - Variable phase angle for MW control (phase shifter)
          		/*
          		final PSXfrPControl ps = CoreObjectFactory.createPSXfrPControl(net, bra.getId(), FlowControlType.RANGE_CONTROL);
          		// TODO pSpec not defined
          		ps.setPSpecified(0.2);
          		ps.setAngLimit(new LimitType(maxTapAng*Constants.DtoR, minTapAng*Constants.DtoR));
          		ps.setControlOnFromSide(getSide(controlSide, controlBusId, bra));
          		net.addPSXfrPControl(ps, controlBusId);
          		*/          		
        }
    }
    	
    /*
     *   Loss Zone data
     *   ============== 
     */

    private static void processLossZoneData(final String str, final PSSNetworkXmlType baseCaseNet) {
    	final String[] strAry = getLossZoneDataFields(str);

//    	Columns  1- 3   Loss zone number [I] *
//    	Columns  5-16   Loss zone name [A] 
    	final int no = new Integer(strAry[0]).intValue();
    	final String name = strAry[1];
//    	final Zone zone = CoreObjectFactory.createZone(no, net);
//    	zone.setName(name);
    }

    /*
     *   Interchange data
     *   ================ 
     */
    
    private static void processInterchangeData(final String str, final PSSNetworkXmlType baseCaseNet) {
    	final String[] strAry = getInterchangeDataFields(str);
    	
//    	Columns  1- 2   Area number [I], no zeros! *
      	final int no = new Integer(strAry[0]).intValue();
      	
//    	Columns  4- 7   Interchange slack bus number [I] *
//      Columns  9-20   Alternate swing bus name [A]
      	final String slackBusId = strAry[1];
      	final String alSwingBusName = strAry[2];
      	
//      Columns 21-28   Area interchange export, MW [F] (+ = out) *
//      Columns 30-35   Area interchange tolerance, MW [F] *
      	final double mw = new Double(strAry[3]).doubleValue();
      	final double err = new Double(strAry[4]).doubleValue();
      	
//      Columns 38-43   Area code (abbreviated name) [A] *
//      Columns 46-75   Area name [A]
      	final String code = strAry[5];
      	final String name = strAry[6];
    }        
    
    /*
     *   Tieline data
     *   ============ 
     */

    private static void processTielineData(final String str, final PSSNetworkXmlType baseCaseNet) {
    	final String[] strAry = getTielineDataFields(str);
    	
//    	Columns  1- 4   Metered bus number [I] *
//    	Columns  7-8    Metered area number [I] *
      	final String meteredBusId = strAry[0];
      	final int meteredAreaNo = new Integer(strAry[1]).intValue();
      	
//      Columns  11-14  Non-metered bus number [I] *
//      Columns  17-18  Non-metered area number [I] *
      	final String nonMeteredBusId = strAry[2];
      	final int nonMeteredAreaNo = new Integer(strAry[3]).intValue();
      	
//      Column   21     Circuit number
      	final int cirNo = new Integer(strAry[4]).intValue();
    }
        
    /*
     * util functions
     */
    private static String[] getNetDataFields(final String str) {
    	final String[] strAry = new String[6];
    	
    	if (str.indexOf(',') >= 0) {
    		final StringTokenizer st = new StringTokenizer(str, ",");
    		int cnt = 0;
    		while(st.hasMoreTokens()) {
				strAry[cnt++] = st.nextToken().trim();
			}
    	}
    	else {
            //Columns  2- 9   Date, in format DD/MM/YY with leading zeros.  If no date provided, use 0b/0b/0b where b is blank.
        	strAry[0] = str.substring(1,9);
            //Columns 11-30   Originator's name [A]
        	strAry[1] = str.substring(10,30);
            //Columns 32-37   MVA Base [F] *
        	strAry[2] = str.substring(31,37);  // in MVA
        	//Columns 39-42   Year [I]
        	strAry[3] = str.substring(38,42);
            //Column  44      Season (S - Summer, W - Winter)
        	strAry[4] = str.substring(43,44);
            //Column  46-73   Case identification [A]
        	strAry[5] = str.substring(45);
    	}
    	return strAry;
    }

    private static String[] getBusDataFields(final String str) {
    	final String[] strAry = new String[18];
    	
    	if (str.indexOf(',') >= 0) {
    		final StringTokenizer st = new StringTokenizer(str, ",");
    		int cnt = 0;
    		while(st.hasMoreTokens()) {
				strAry[cnt++] = st.nextToken().trim();
			}
    	}
    	else {
        	//Columns  1- 4   Bus number [I] *
        	strAry[0] = str.substring(0,4).trim();
        	
        	//Columns  6-17   Name [A] (left justify) *
        	strAry[1] = str.substring(5, 17).trim();
        	
        	//Columns 19-20   Load flow area number [I].  Don't use zero! *
        	//Columns 21-23   Loss zone number [I]
        	strAry[2] = str.substring(18, 20).trim();
        	strAry[3] = str.substring(20, 23).trim();
        	
        	//Columns 77-83   Base kV [F]
        	strAry[11] = str.substring(76,83);
        	
        	//Columns 25-26   Type [I] *
            //		0 - Unregulated (load, PQ)
            //		1 - Hold MVAR generation within voltage limits, (gen, PQ)
            //		2 - Hold voltage within VAR limits (gen, PV)
            //		3 - Hold voltage and angle (swing, V-Theta; must always have one)
        	strAry[4] = str.substring(24,26).trim();

        	//Columns 28-33   Final voltage, p.u. [F] *
        	//Columns 34-40   Final angle, degrees [F] *
        	strAry[5] = str.substring(27,33);
        	strAry[6] = str.substring(33,40);

        	//Columns 41-49   Load MW [F] *
        	//Columns 50-59   Load MVAR [F] *
        	strAry[7] = str.substring(40,49);
        	strAry[8] = str.substring(49,59);

        	//Columns 60-67   Generation MW [F] *
        	//Columns 68-75   Generation MVAR [F] *
        	strAry[9] = str.substring(59,67);
        	strAry[10] = str.substring(67,75);

        	//Columns 107-114 Shunt conductance G (per unit) [F] *
        	//Columns 115-122 Shunt susceptance B (per unit) [F] *
        	strAry[15] = str.substring(106,114);
        	strAry[16] = str.substring(114,122);
        	

        	//Columns 85-90   Desired volts (pu) [F] (This is desired remote voltage if this bus is controlling another bus.)
        	strAry[12] = str.substring(84,90);

        	//Columns 91-98   Minimum MVAR or voltage limit [F]
        	//Columns 99-106  Maximum MVAR or voltage limit [F]
        	strAry[13] = str.substring(90,98);
        	strAry[14] = str.substring(98,106);

        	//Columns 124-127 Remote controlled bus number
        	strAry[17] = str.substring(123,127).trim();
    	}
    	return strAry;
    }
    
    private static String[] getBranchDataFields(final String str) {
    	final String[] strAry = new String[21];
    	
    	if (str.indexOf(',') >= 0) {
    		final StringTokenizer st = new StringTokenizer(str, ",");
    		int cnt = 0;
    		while(st.hasMoreTokens()) {
				strAry[cnt++] = st.nextToken().trim();
			}
    	}
    	else {
//        	Columns  1- 4   Tap bus number [I] *
//      	For transformers or phase shifters, the side of the model the non-unity tap is on.
//			Columns  6- 9   Z bus number [I] *
//      	For transformers and phase shifters, the side of the model the device impedance is on.
    		strAry[0] = str.substring(0,4).trim();
    		strAry[1] = str.substring(5,9).trim();
//    		IpssLogger.getLogger().fine("Branch data loaded, from-id, to-id: " + strAry[0] + ", " + strAry[1]);

//    		Columns 11-12   Load flow area [I]
//    		Columns 13-15   Loss zone [I]
//    		Column  17      Circuit [I] * (Use 1 for single lines)
    		strAry[2] = str.substring(10, 12).trim();
    		strAry[3] = str.substring(12, 15).trim();
    		strAry[4] = str.substring(16, 17).trim();
    	
//    		Column  19      Type [I] *
    		strAry[5] = str.substring(18,19).trim();
    	
//    		Columns 20-29   Branch resistance R, per unit [F] *
//    		Columns 30-40   Branch reactance X, per unit [F] * No zero impedance lines
//    		Columns 41-50   Line charging B, per unit [F] * (total line charging, +B)
    		strAry[6] = str.substring(19,29);
    		strAry[7] = str.substring(29,40);
    		strAry[8] = str.substring(40,50);

//    		Columns 77-82   Transformer final turns ratio [F]
//    		Columns 84-90   Transformer (phase shifter) final angle [F]
    		strAry[14] = str.substring(76,82);
    		strAry[15] = str.substring(83,90);
    	
//    		Columns 51-55   Line MVA rating No 1 [I] Left justify!
//    		Columns 57-61   Line MVA rating No 2 [I] Left justify!
//    		Columns 63-67   Line MVA rating No 3 [I] Left justify!
    		strAry[9] =  str.substring(50,55).trim();
    		strAry[10] = str.substring(56,61).trim();
    		strAry[11] = str.substring(62,67).trim();

    		if (new Integer(strAry[5]).intValue() > 1) {
//    			Columns 69-72   Control bus number
    			strAry[12] = str.substring(68,72).trim();

//        		Column  74      Side [I]
    			strAry[13] = str.substring(73,74).trim();

//        		Columns 106-111 Step size [F]
    			strAry[18] = str.substring(105,111);
        	
//        		Columns 91-97   Maximum tap or phase shift [F]
//        		Columns 98-104  Minimum tap or phase shift [F]
    			strAry[16] = str.substring(90,97);
    			strAry[17] = str.substring(97,104);

//        		Columns 113-119 Minimum voltage, MVAR or MW limit [F]
//        		Columns 120-126 Maximum voltage, MVAR or MW limit [F]
    			strAry[19] = str.substring(112,119);
    			strAry[20] = str.substring(119,126);
    		}
    	}
    	return strAry;
    }	
    	
    private static String[] getLossZoneDataFields(final String str) {
    	final String[] strAry = new String[2];
    	
    	if (str.indexOf(',') >= 0) {
    		final StringTokenizer st = new StringTokenizer(str, ",");
    		int cnt = 0;
    		while(st.hasMoreTokens()) {
				strAry[cnt++] = st.nextToken().trim();
			}
    	}
    	else {
        	strAry[0] = str.substring(0,3).trim();
        	strAry[1] = str.substring(4).trim();    	
        }
    	return strAry;
    }	

    private static String[] getInterchangeDataFields(final String str) {
    	final String[] strAry = new String[7];
    	
    	if (str.indexOf(',') >= 0) {
    		final StringTokenizer st = new StringTokenizer(str, ",");
    		int cnt = 0;
    		while(st.hasMoreTokens()) {
				strAry[cnt++] = st.nextToken().trim();
			}
    	}
    	else {
//        	Columns  1- 2   Area number [I], no zeros! *
          	strAry[0] = str.substring(0,2).trim();
          	
//        	Columns  4- 7   Interchange slack bus number [I] *
//          Columns  9-20   Alternate swing bus name [A]
          	strAry[1] = str.substring(3,7).trim();
          	strAry[2] = str.substring(8,20).trim();
          	
//          Columns 21-28   Area interchange export, MW [F] (+ = out) *
//          Columns 30-35   Area interchange tolerance, MW [F] *
          	strAry[3] = str.substring(20,28);
          	strAry[4] = str.substring(29,35);
          	
//          Columns 38-43   Area code (abbreviated name) [A] *
//          Columns 46-75   Area name [A]
          	strAry[5] = str.substring(37,43);
          	strAry[6] = str.substring(45).trim();
        }
    	return strAry;
    }	

    private static String[] getTielineDataFields(final String str) {
    	final String[] strAry = new String[5];
    	
    	if (str.indexOf(',') >= 0) {
    		final StringTokenizer st = new StringTokenizer(str, ",");
    		int cnt = 0;
    		while(st.hasMoreTokens()) {
				strAry[cnt++] = st.nextToken().trim();
			}
    	}
    	else {
//        	Columns  1- 4   Metered bus number [I] *
//        	Columns  7-8    Metered area number [I] *
          	strAry[0] = str.substring(0,4).trim();
          	strAry[1] = str.substring(6,8).trim();
          	
//          Columns  11-14  Non-metered bus number [I] *
//          Columns  17-18  Non-metered area number [I] *
          	strAry[2] = str.substring(10,14).trim();
          	strAry[3] = str.substring(16,18).trim();
          	
//          Column   21     Circuit number
          	strAry[4] = str.substring(20,21);
    	}
    	return strAry;
    }	
}