 /*
  * @(#)FileAdapter_GE_PSLFFormat.java   
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

package org.interpss.custom.exchange;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.datatype.Constants;
import com.interpss.common.datatype.LimitType;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.exp.InvalidOperationException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.StringUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBranchCode;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfGenCode;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.LineAdapter;
import com.interpss.core.aclf.PQBusAdapter;
import com.interpss.core.aclf.PSXfrAdapter;
import com.interpss.core.aclf.PVBusAdapter;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.aclf.XfrAdapter;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.aclfadj.PVBusLimit;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;
import com.interpss.simu.io.IpssFileAdapterBase;

public class FileAdapter_UCTEFormat extends IpssFileAdapterBase {
	private static final String Token_CommentBlock 		= "##C";
	private static final String Token_NodeBlock 		= "##N";
	private static final String Token_ISOCountryId 		= "##Z";
	private static final String Token_LineBlock			= "##L";
	private static final String Token_2WXfrBlock		= "##T";
	private static final String Token_2WXfrRegBlock 	= "##R";
	private static final String Token_2WXfrSpeDesc		= "##TT";
	
	private enum RecType {Comment, Node, Line, Xfr2W, Xfr2WReg, Xfr2WDesc, ExPower, NotDefined};

	/**
	 * Load the data in the data file, specified by the filepath, into the SimuContext object. An AclfAdjNetwork
	 * object will be created to hold the data for loadflow analysis.
	 * 
	 * @param simuCtx the SimuContext object
	 * @param filepath full path path of the input file
	 * @param msg the SessionMsg object
	 */
	@Override
	public void load(final SimuContext simuCtx, final String filepath, final IPSSMsgHub msg) throws Exception{
		final File file = new File(filepath);
		final InputStream stream = new FileInputStream(file);
		final BufferedReader din = new BufferedReader(new InputStreamReader(stream));
		
		final AclfAdjNetwork adjNet = loadFile(din, msg);
  		// System.out.println(adjNet.net2String());
	  		
  		if (adjNet != null) {
  			simuCtx.setNetType(SimuCtxType.ACLF_ADJ_NETWORK);
  	  		simuCtx.setAclfAdjNet(adjNet);
  	  		simuCtx.setName(filepath.substring(filepath.lastIndexOf(File.separatorChar)+1));
  	  		simuCtx.setDesc("This project is created by input file " + filepath);
  		}
  		else { 
  			msg.sendErrorMsg("Error to load file: " + filepath);
  			IpssLogger.getLogger().severe("Error to load file: " + filepath);
  		}
	}
	
	/**
	 * Create a SimuContext object and Load the data in the data file, specified by the filepath, into the object. 
	 * An AclfAdjNetwork object will be created to hold the data for loadflow analysis.
	 * 
	 * @param filepath full path path of the input file
	 * @param msg the SessionMsg object
	 * @return the created SimuContext object.
	 */
	@Override
	public SimuContext load(final String filepath, final IPSSMsgHub msg) throws Exception{
  		final SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.NOT_DEFINED, msg);
  		load(simuCtx, filepath, msg);
  		return simuCtx;
	}
	
	/**
	 * This method is currently not implemented, since the loadflow results are not going to write
	 * back to a data file.
	 */
	@Override
	public boolean save(final String filepath, final SimuContext net, final IPSSMsgHub msg) throws Exception{
		throw new InvalidOperationException("FileAdapter_IeeeCommonFormat.save not implemented");
	}

    private static AclfAdjNetwork loadFile(final java.io.BufferedReader din, final IPSSMsgHub msg) throws Exception {
    	final AclfAdjNetwork  aclfNet = CoreObjectFactory.createAclfAdjNetwork();
    	aclfNet.setAllowParallelBranch(true);
    	aclfNet.setBaseKva(100000.0);   // no base kva definition in UCTE, use 100 MVA

    	boolean noError = true;
      	String str;   
      	RecType recType = RecType.NotDefined;
    	do {
          	str = din.readLine();   
        	if (str != null && !str.trim().equals("")) {
        		String countryId = "";
    			try {
    				if (str.startsWith(Token_CommentBlock))
    					recType = RecType.Comment;
    				else if (str.startsWith(Token_NodeBlock))
    					recType = RecType.Node;
    				else if (str.startsWith(Token_ISOCountryId) && recType == RecType.Node)
    					countryId = "";
    				else if (str.startsWith(Token_LineBlock))
    					recType = RecType.Line;
    				else if (str.startsWith(Token_2WXfrBlock))
    					recType = RecType.Xfr2W;
    				else if (str.startsWith(Token_2WXfrRegBlock))
    					recType = RecType.Xfr2WReg;
    				else {
    					if (!processRecord(str, recType, countryId, aclfNet, msg))
    						noError = false;
    				}
    			} catch (final Exception e) {
    				IpssLogger.logErr(e);
    				msg.sendErrorMsg("Error Line: " + str + ", " + e.toString());
    			}
        	}
       	} while (str != null);

    	return noError? aclfNet : null;
    }

    private static boolean processRecord(String str, RecType recType, String countryId, AclfAdjNetwork  aclfNet, final IPSSMsgHub msg) {
    	boolean noError = true;
    	if (recType == RecType.Comment) {
    	    if (!processCommentRecord(str, aclfNet))
    	    	noError = false;
    	}
    	else if (recType == RecType.Node) {
    	    if (!processNodeRecord(str, countryId, aclfNet, msg))
    	    	noError = false;
    	}
    	else if (recType == RecType.Line) {
    	    if (!processLineRecord(str, aclfNet, msg))
    	    	noError = false;
    	}
    	else if (recType == RecType.Xfr2W) {
    	    if (!processXfr2WindingRecord(str, aclfNet, msg))
    	    	noError = false;
    	}
    	else if (recType == RecType.Xfr2WReg) {
    	    if (!processXfr2WRegulationRecord(str, aclfNet, msg))
    	    	noError = false;
    	}
    	else if (recType == RecType.Xfr2WDesc) {
    	    if (!processXfr2SpecialDescRecord(str, aclfNet))
    	    	noError = false;
    	}
    	return noError;
    }

    private static boolean processCommentRecord(String str, AclfAdjNetwork  aclfNet) {
		IpssLogger.getLogger().info("Comment: " + str);
		aclfNet.setDesc(aclfNet.getDesc() + str + "\n");
    	return true;
    }

    private static boolean processNodeRecord(String str, String countryId, AclfAdjNetwork  aclfNet, IPSSMsgHub msg) {
		IpssLogger.getLogger().info("Node Record: " + str);
		String id = StringUtil.getString(str, 1, 8).trim();
		String name = StringUtil.getString(str, 10, 21).trim();

		double baseKv = 0.0;
		int status, nodeType;
		double voltage, pLoadMW, qLoadMvar, pGenMW, qGenMvar;
		
		double 	minGenMW, maxGenMW, minGenMVar, maxGenMVar, 
				staticPrimaryControl, normalPoewrPrimaryControl,
				scMVA3P, x_rRatio;
		
		try {
			baseKv = getBaseVoltageKv(id);

			status = StringUtil.getInt(str, 23, 23);  // 0 real, 1 equivalent
			nodeType = StringUtil.getInt(str, 25, 25);  // 0 PQ, 1 QAng, 2 PV, 3 Swing
			voltage = StringUtil.getDouble(str, 27, 32);  
			pLoadMW = StringUtil.getDouble(str, 34, 40);  
			qLoadMvar = StringUtil.getDouble(str, 42, 48);  
			pGenMW = StringUtil.getDouble(str, 50, 56);  
			qGenMvar = StringUtil.getDouble(str, 58, 64);
			
			// optional fields
			minGenMW = StringUtil.getDouble(str, 66, 72); 
			maxGenMW = StringUtil.getDouble(str, 74, 80);
			minGenMVar = StringUtil.getDouble(str, 82, 88); 
			maxGenMVar = StringUtil.getDouble(str, 90, 96); 
			staticPrimaryControl = StringUtil.getDouble(str, 98, 102); 
			normalPoewrPrimaryControl = StringUtil.getDouble(str, 104, 110);
			scMVA3P = StringUtil.getDouble(str, 112, 118);
			x_rRatio = StringUtil.getDouble(str, 120, 126);
		} catch (Exception e) {
			IpssLogger.logErr(e);
			msg.sendErrorMsg("Error: " + str + ", " + e.toString());
			return false;
		}
		String powerPlanType = StringUtil.getString(str, 128, 128);
		
      	final AclfBus bus = CoreObjectFactory.createAclfBus(id);
      	bus.setName(name);
    	bus.setBaseVoltage(baseKv, UnitType.kV);
    	aclfNet.addBus(bus);
		
    	switch (nodeType) {
    	case 0:   // PQ bus
    		bus.setGenCode(AclfGenCode.GEN_PQ);
    		bus.setLoadCode(AclfLoadCode.CONST_P);
   			final PQBusAdapter pqGen = (PQBusAdapter)bus.adapt(PQBusAdapter.class);
    		pqGen.setGen(new Complex(pGenMW, qGenMvar), UnitType.mVA, aclfNet.getBaseKva());
    		pqGen.setLoad(new Complex(pLoadMW, qLoadMvar), UnitType.mVA, aclfNet.getBaseKva());
    		break;
		case 1:  // Q angle bus
			break;
		case 2:  // PV bus
   		 	bus.setGenCode(AclfGenCode.GEN_PV);
   		 	bus.setLoadCode(AclfLoadCode.CONST_P);
  			final PVBusAdapter pvGen = (PVBusAdapter)bus.adapt(PVBusAdapter.class);
  			pvGen.setGenP(pGenMW, UnitType.mW, aclfNet.getBaseKva());
  			pvGen.setVoltMag(voltage, UnitType.kV);
  			pvGen.setLoad(new Complex(pLoadMW, qLoadMvar), UnitType.mVA, aclfNet.getBaseKva());
  			if (((maxGenMVar != 0.0) || (minGenMVar != 0.0)) && 
  					maxGenMVar > minGenMVar) {
  				// PV Bus limit control
				IpssLogger.getLogger().fine("Bus is a PVLimitBus, id: " + id);
				final PVBusLimit pvLimit = CoreObjectFactory.createPVBusLimit(
						aclfNet, id);
				pvLimit.setQLimit(new LimitType(maxGenMVar, minGenMVar), UnitType.mVar, aclfNet.getBaseKva());
  			}
  			break;
		case 3:  // swing bus
   		 	bus.setGenCode(AclfGenCode.SWING);
   		 	bus.setLoadCode(AclfLoadCode.CONST_P);
  			final SwingBusAdapter swingGen = (SwingBusAdapter)bus.adapt(SwingBusAdapter.class);
  			swingGen.setVoltMag(voltage, UnitType.kV);
  			swingGen.setVoltAng(0.0, UnitType.Deg);
  			swingGen.setLoad(new Complex(pLoadMW, qLoadMvar), UnitType.mVA, aclfNet.getBaseKva());
			break;
		default: 
			// error bus nodeType code
			msg.sendErrorMsg("Wrong node type code, " + nodeType);
			return false;
    	}
    	return true;
    }
    
    private static boolean processLineRecord(String str, AclfAdjNetwork  aclfNet, IPSSMsgHub msg) {
		IpssLogger.getLogger().info("Line Record: " + str);
		String fromNodeId = StringUtil.getString(str, 1, 8).trim();
		String toNodeId = StringUtil.getString(str, 10, 17).trim();
		String orderCode = StringUtil.getString(str, 19, 19);
		
		int status, currentLimit;
		double rOhm, xOhm, bMuS;  

		try {
			status = StringUtil.getInt(str, 21, 21);  // 0 real, i equivalent
			rOhm = StringUtil.getDouble(str, 23, 28);  
			xOhm = StringUtil.getDouble(str, 30, 35);  
			bMuS = StringUtil.getDouble(str, 37, 44);  
			currentLimit = StringUtil.getInt(str, 46, 51);  
		} catch (Exception e) {
			IpssLogger.logErr(e);
			msg.sendErrorMsg("Error: " + str + ", " + e.toString());
			return false;
		}
		String elemName = StringUtil.getString(str, 53, 64);
    	
    	// create an AclfBranch object
      	final AclfBranch branch = CoreObjectFactory.createAclfBranch();
      	branch.setName(elemName);
      	// add the object into the network container
      	aclfNet.addBranch(branch, fromNodeId, toNodeId);    
		
    	branch.setBranchCode(AclfBranchCode.LINE);
		final LineAdapter line = (LineAdapter)branch.adapt(LineAdapter.class);
    	line.setZ(new Complex(rOhm,xOhm), UnitType.Ohm, branch.getFromAclfBus().getBaseVoltage(), aclfNet.getBaseKva(), msg);
    	line.setHShuntY(new Complex(0.0,0.5*bMuS), UnitType.MicroMho, branch.getFromAclfBus().getBaseVoltage(), aclfNet.getBaseKva()); 
      	
    	// by default the branch is active
    	if (status == 7 || status == 8 || status == 9) 
    		branch.setStatus(false);
		return true;
    }
    
    private static boolean processXfr2WindingRecord(String str, AclfAdjNetwork  aclfNet, IPSSMsgHub msg) {
		IpssLogger.getLogger().info("Xfr 2W Record: " + str);
		String fromNodeId = StringUtil.getString(str, 1, 8).trim();
		String toNodeId = StringUtil.getString(str, 10, 17).trim();
		String orderCode = StringUtil.getString(str, 19, 19);

		int status, currentLimit;
		double fromRatedKV, toRatedKV, normialMva,
		       rOhm, xOhm, bMuS, gMuS;  

		try {
			status = StringUtil.getInt(str, 21, 21);  // 0 real, i equivalent
			fromRatedKV = StringUtil.getDouble(str, 23, 27);  
			toRatedKV = StringUtil.getDouble(str, 29, 33);  
			normialMva = StringUtil.getDouble(str, 35, 39);  
			rOhm = StringUtil.getDouble(str, 41, 46);  
			xOhm = StringUtil.getDouble(str, 48, 53);  
			bMuS = StringUtil.getDouble(str, 55, 62);  
			gMuS = StringUtil.getDouble(str, 64, 69);  
			currentLimit = StringUtil.getInt(str, 71, 76);  
		} catch (Exception e) {
			IpssLogger.logErr(e);
			msg.sendErrorMsg("Error: " + str + ", " + e.toString());
			return false;
		}
		String elemName = StringUtil.getString(str, 78, 89);
		
    	// create an AclfBranch object
      	final AclfBranch branch = CoreObjectFactory.createAclfBranch();
      	branch.setName(elemName);
      	// add the object into the network container
      	aclfNet.addBranch(branch, fromNodeId, toNodeId);    
      	
	 	branch.setBranchCode(AclfBranchCode.XFORMER);
		final XfrAdapter xfr = (XfrAdapter)branch.adapt(XfrAdapter.class);
		// it is assumed that the r and x is measured at high voltage side
		double baseV = branch.getFromAclfBus().getBaseVoltage() > branch.getToAclfBus().getBaseVoltage()?
				branch.getFromAclfBus().getBaseVoltage() : branch.getToAclfBus().getBaseVoltage();
    	xfr.setZ(new Complex(rOhm,xOhm), UnitType.Ohm, baseV, aclfNet.getBaseKva(), msg);
		//if ( branch.getFromAclfBus().getBaseVoltage() > branch.getToAclfBus().getBaseVoltage())
    	//xfr.setHShuntY(new Complex(0.0,0.5*bMuS), UnitType.MicroMho, branch.getFromAclfBus().getBaseVoltage(), aclfNet.getBaseKva()); 
    	xfr.setFromTurnRatio(1.0, UnitType.PU);
    	xfr.setToTurnRatio(1.0, UnitType.PU); 
    	return true;
    }
    
    private static boolean processXfr2WRegulationRecord(String str, AclfAdjNetwork aclfNet, IPSSMsgHub msg) {
		IpssLogger.getLogger().info("Xfr 2W Reg Record: " + str);
		String fromNodeId = StringUtil.getString(str, 1, 8).trim();
		String toNodeId = StringUtil.getString(str, 10, 17).trim();
		String orderCode = StringUtil.getString(str, 19, 19);

		double dUPercentPhaes, uKvPhase, dUPercentAngle, thetaDegAngle, pMwAngle;  
		int nPhase, n1Phase, nAngle, n1Angle;  

		try {
			dUPercentPhaes = StringUtil.getDouble(str, 21, 25);  
			nPhase = StringUtil.getInt(str, 27, 28);  
			n1Phase = StringUtil.getInt(str, 30, 32);  
			uKvPhase = StringUtil.getDouble(str, 34, 38);  

			dUPercentAngle = StringUtil.getDouble(str, 40, 44);  
			thetaDegAngle = StringUtil.getDouble(str, 46, 50);  
			nAngle = StringUtil.getInt(str, 52, 53);  
			n1Angle = StringUtil.getInt(str, 55, 57);  
			pMwAngle = StringUtil.getDouble(str, 59, 63);  
		} catch (Exception e) {
			IpssLogger.logErr(e);
			msg.sendErrorMsg("Error: " + str + ", " + e.toString());
			return false;
		}

		String type = StringUtil.getString(str, 65, 68);
    	return true;
    }
    
    private static boolean processXfr2SpecialDescRecord(String str, AclfAdjNetwork  aclfNet) {
		IpssLogger.getLogger().info("Xfr 2W Desc Record: " + str);
    	return true;
    }
    
    private static double getBaseVoltageKv(String nodeId) throws Exception {
    	int code = StringUtil.getInt(nodeId, 7, 7);
    	return getBaseVoltageKv(code);
    }
    
    private static double getBaseVoltageKv(int code) {
    	switch(code) {
    	case 0 : return 750.0;
    	case 1 : return 380.0;
    	case 2 : return 220.0;
    	case 3 : return 150.0;
    	case 4 : return 120.0;
    	case 5 : return 110.0;
    	case 6 : return 70.0;
//    	case 7 : return 27.0;
//    	case 8 : return 330.0;
    	case 7 : return 14.0;
    	case 8 : return 18.0;
    	case 9 : return 500.0;
    	default: 
    		IpssLogger.getLogger().severe("Wrong base voltage code, " + code);
    		return 0.0;
    	}
    }
}
