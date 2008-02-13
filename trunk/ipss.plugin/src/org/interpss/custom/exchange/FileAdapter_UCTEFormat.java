 /*
  * @(#)FileAdapter_UCTEFormat.java   
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
  * @Date 02/01/2008
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
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math.complex.Complex;
import org.interpss.custom.exchange.ucte.UCTENetwork;
import org.interpss.custom.exchange.ucte.UCTEBranch;
import org.interpss.custom.exchange.ucte.UCTEBus;

import com.interpss.common.datatype.Constants;
import com.interpss.common.datatype.LimitType;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.exp.InvalidOperationException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.StringUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBranchCode;
import com.interpss.core.aclf.AclfGenCode;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.LineAdapter;
import com.interpss.core.aclf.PQBusAdapter;
import com.interpss.core.aclf.PSXfrAdapter;
import com.interpss.core.aclf.PVBusAdapter;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.aclf.XfrAdapter;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.aclfadj.FlowControlType;
import com.interpss.core.aclfadj.PSXfrPControl;
import com.interpss.core.aclfadj.PVBusLimit;
import com.interpss.core.aclfadj.TapControl;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;
import com.interpss.simu.io.IpssFileAdapterBase;

public class FileAdapter_UCTEFormat extends IpssFileAdapterBase {
	private final static String PsXfrType_ASYM = "ASYM"; 
	
	private enum RecType {Comment, BaseVoltage, Node, Line, Xfr2W, Xfr2WReg, Xfr2WLookup, ExPower, NotDefined};

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
		
		final AclfAdjNetwork adjNet = loadFile(din, StringUtil.getFileName(filepath), msg);
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
		throw new InvalidOperationException("FileAdapter_UCTEFormat.save not implemented");
	}

    private static AclfAdjNetwork loadFile(final java.io.BufferedReader din, String filename, final IPSSMsgHub msg) throws Exception {
    	final UCTENetwork  aclfNet = new UCTENetwork(filename, "UCTE Network createb by InterPSS");
    	
    	aclfNet.setAllowParallelBranch(true);
    	
    	// no base kva definition in UCTE format, so use 100 MVA
    	// UCTE data are in actual units, mw, mva ...
    	aclfNet.setBaseKva(100000.0);   

    	// scan all lines and process the data
    	customBaseVoltage = false;
    	boolean noError = true;
      	String str;   
      	RecType recType = RecType.NotDefined;
    	do {
          	str = din.readLine();   
        	if (str != null && !str.trim().equals("")) {
        		String isoId = "";
    			try {
    				if (str.startsWith("##C"))
    					recType = RecType.Comment;
    				else if (str.startsWith("##BaseVoltage")) {
    					// this is an extension, not defined in the UCTE spec
    					recType = RecType.BaseVoltage;
    			    	customBaseVoltage = true;
    					customBaseVoltageList.clear();
    				}
    				else if (str.startsWith("##N"))
    					recType = RecType.Node;
    				else if (str.startsWith("##Z") && recType == RecType.Node) 
    					isoId = str.substring(3);
    				else if (str.startsWith("##L"))
    					recType = RecType.Line;
    				else if (str.startsWith("##T"))
    					recType = RecType.Xfr2W;
    				else if (str.startsWith("##R"))
    					recType = RecType.Xfr2WReg;
    				else if (str.startsWith("##TT"))
    					recType = RecType.Xfr2WLookup;
    				else if (str.startsWith("##E"))
    					recType = RecType.ExPower;
    				else {
    					// process data lines
    					if (recType == RecType.Comment) {
    			    	    if (!processCommentRecord(str, aclfNet))
    			    	    	noError = false;
    			    	}
    					else if (recType == RecType.BaseVoltage) {
    			    	    if (!processBaseVoltageRecord(str))
    			    	    	noError = false;
    			    	}
    			    	else if (recType == RecType.Node) {
    			    	    if (!processNodeRecord(str, isoId, aclfNet, msg))
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
    			    	else if (recType == RecType.Xfr2WLookup) {
    			    	    if (!processXfr2LookupRecord(str, aclfNet, msg))
    			    	    	noError = false;
    			    	}
    			    	else if (recType == RecType.ExPower) {
    			    	    if (!processExchangePowerRecord(str, aclfNet, msg))
    			    	    	noError = false;
    			    	}
    				}
    			} catch (final Exception e) {
    				IpssLogger.logErr(e);
    				msg.sendErrorMsg("Error Line: " + str + ", " + e.toString());
    			}
        	}
       	} while (str != null);

    	// if data input error, a null object returned
    	return noError? aclfNet : null;
    }

    /*
     * ##C section
     */
    private static boolean processCommentRecord(String str, AclfAdjNetwork  aclfNet) {
		IpssLogger.getLogger().info("Comment: " + str);
		// comment lines are added into the desc field
		aclfNet.setDesc(aclfNet.getDesc() + str + "\n");
    	return true;
    }

    /*
     * ##N and ##Z sections
     */
    private static boolean processNodeRecord(String str, String isoId, AclfAdjNetwork  aclfNet, IPSSMsgHub msg) {
		IpssLogger.getLogger().info("Node Record: " + str);

		// parse the input line for node information
		String id, name;
		double baseKv = 0.0;
		int status, nodeType;
		double voltage, pLoadMW, qLoadMvar, pGenMW, qGenMvar;
		double 	minGenMW, maxGenMW, minGenMVar, maxGenMVar, 
				staticPrimaryControl, normalPoewrPrimaryControl,
				scMVA3P, x_rRatio;
		String powerPlanType;
		try {
			id = StringUtil.getString(str, 1, 8).trim().replace(' ', '_');
			name = StringUtil.getString(str, 10, 21).trim();

			if (!customBaseVoltage)
				baseKv = getBaseVoltageKv(id);

			status = StringUtil.getInt(str, 23, 23);  // 0 real, 1 equivalent
			nodeType = StringUtil.getInt(str, 25, 25);  // 0 PQ, 1 QAng, 2 PV, 3 Swing
			voltage = StringUtil.getDouble(str, 27, 32);  
			if (customBaseVoltage) {
				baseKv = findCustomBaseVoltage(voltage);
				if (baseKv == 0.0) {
					IpssLogger.getLogger().severe("Custom base voltage lookup, cannot find proper value");
					msg.sendErrorMsg("Custom base voltage lookup, cannot find proper value");
					return false;
				}
			}
			else { 
				if (voltage == 0.0)
					voltage = baseKv;
			}
			
			pLoadMW = StringUtil.getDouble(str, 34, 40);  
			qLoadMvar = StringUtil.getDouble(str, 42, 48);  
			pGenMW = -StringUtil.getDouble(str, 50, 56);    // UCTE assumes out next as the positive direction
			qGenMvar = -StringUtil.getDouble(str, 58, 64);
			
			// optional fields
			minGenMW = -StringUtil.getDouble(str, 66, 72); 
			maxGenMW = -StringUtil.getDouble(str, 74, 80);
			minGenMVar = -StringUtil.getDouble(str, 82, 88); 
			maxGenMVar = -StringUtil.getDouble(str, 90, 96); 
			staticPrimaryControl = StringUtil.getDouble(str, 98, 102); 
			normalPoewrPrimaryControl = StringUtil.getDouble(str, 104, 110);
			scMVA3P = StringUtil.getDouble(str, 112, 118);
			x_rRatio = StringUtil.getDouble(str, 120, 126);

			powerPlanType = StringUtil.getString(str, 128, 128);
		} catch (Exception e) {
			IpssLogger.logErr(e);
			msg.sendErrorMsg("Error: " + str + ", " + e.toString());
			return false;
		}
		
		// create an UCTE bus object and add to the network
      	final UCTEBus bus = new UCTEBus(id, name, isoId);
    	bus.setBaseVoltage(baseKv, UnitType.kV);
    	aclfNet.addBus(bus);
		
    	// set node info into InterPSS simulation engine 
    	switch (nodeType) {
		case 0: // PQ bus
			bus.setGenCode(AclfGenCode.GEN_PQ);
			bus.setLoadCode(AclfLoadCode.CONST_P);
			final PQBusAdapter pqGen = (PQBusAdapter) bus
					.adapt(PQBusAdapter.class);
			pqGen.setGen(new Complex(pGenMW, qGenMvar), UnitType.mVA, aclfNet
					.getBaseKva());
			pqGen.setLoad(new Complex(pLoadMW, qLoadMvar), UnitType.mVA,
					aclfNet.getBaseKva());
			break;
		case 1: // Q angle bus
			IpssLogger.getLogger().severe("Node type = 1, not support currently. Please contact support@interpss.org");
			msg.sendErrorMsg("Node type = 1, not support currently. Please contact support@interpss.org");
			return false;
		case 2: // PV bus
			bus.setGenCode(AclfGenCode.GEN_PV);
			bus.setLoadCode(AclfLoadCode.CONST_P);
			final PVBusAdapter pvGen = (PVBusAdapter) bus
					.adapt(PVBusAdapter.class);
			pvGen.setGenP(pGenMW, UnitType.mW, aclfNet.getBaseKva());
			pvGen.setVoltMag(voltage, UnitType.kV);
			pvGen.setLoad(new Complex(pLoadMW, qLoadMvar), UnitType.mVA,
					aclfNet.getBaseKva());
			if (((maxGenMVar != 0.0) || (minGenMVar != 0.0))
					&& maxGenMVar > minGenMVar) {
				// PV Bus limit control
				IpssLogger.getLogger().fine("Bus is a PVLimitBus, id: " + id);
				final PVBusLimit pvLimit = CoreObjectFactory.createPVBusLimit(
						aclfNet, id);
				pvLimit.setQLimit(new LimitType(maxGenMVar, minGenMVar),
						UnitType.mVar, aclfNet.getBaseKva());
			}
			break;
		case 3: // swing bus
			bus.setGenCode(AclfGenCode.SWING);
			bus.setLoadCode(AclfLoadCode.CONST_P);
			final SwingBusAdapter swingGen = (SwingBusAdapter) bus
					.adapt(SwingBusAdapter.class);
			swingGen.setVoltMag(voltage, UnitType.kV);
			swingGen.setVoltAng(0.0, UnitType.Deg);
			swingGen.setLoad(new Complex(pLoadMW, qLoadMvar), UnitType.mVA,
					aclfNet.getBaseKva());
			break;
		default:
			// error bus nodeType code
			msg.sendErrorMsg("Wrong node type code, " + nodeType);
			return false;
		}

    	// set extra info which is not used in InterPSS simulation engine
    	bus.setUcteStatus(status);
    	bus.setMinGenMW(minGenMW);
    	bus.setMaxGenMW(maxGenMW);
    	bus.setStaticPrimaryControl(staticPrimaryControl);
    	bus.setNormalPoewrPrimaryControl(normalPoewrPrimaryControl);
    	bus.setScMVA3P(scMVA3P);
    	bus.setX_rRatio(x_rRatio);
    	bus.setPowerPlanType(powerPlanType);
    	return true;
    }
    
    /*
     * ##L section
     */
    private static boolean processLineRecord(String str, AclfAdjNetwork  aclfNet, IPSSMsgHub msg) {
		IpssLogger.getLogger().info("Line Record: " + str);

		// parse the input line for line information
		String fromNodeId, toNodeId, orderCode, elemName;
		int status, currentLimit;
		double rOhm, xOhm, bMuS;  
		try {
			fromNodeId = StringUtil.getString(str, 1, 8).trim().replace(' ', '_');
			toNodeId = StringUtil.getString(str, 10, 17).trim().replace(' ', '_');
			orderCode = StringUtil.getString(str, 19, 19);

			status = StringUtil.getInt(str, 21, 21);  // 0 real, i equivalent
			rOhm = StringUtil.getDouble(str, 23, 28);  
			xOhm = StringUtil.getDouble(str, 30, 35);  
			bMuS = StringUtil.getDouble(str, 37, 44);  
			currentLimit = StringUtil.getInt(str, 46, 51);  

			elemName = StringUtil.getString(str, 53, 64);
		} catch (Exception e) {
			IpssLogger.logErr(e);
			msg.sendErrorMsg("Error: " + str + ", " + e.toString());
			return false;
		}
    	
    	// create an UCTEBranch object
      	final UCTEBranch branch = new UCTEBranch(elemName, orderCode);
      	// add the object into the network container
      	aclfNet.addBranch(branch, fromNodeId, toNodeId);    
		
    	// set line info into InterPSS simulation engine 
    	branch.setBranchCode(AclfBranchCode.LINE);
		final LineAdapter line = (LineAdapter)branch.adapt(LineAdapter.class);
    	line.setZ(new Complex(rOhm,xOhm), UnitType.Ohm, branch.getFromAclfBus().getBaseVoltage(), aclfNet.getBaseKva(), msg);
    	line.setHShuntY(new Complex(0.0,0.5*bMuS), UnitType.MicroMho, branch.getFromAclfBus().getBaseVoltage(), aclfNet.getBaseKva()); 
      	
    	// by default the branch is active
    	if (status == 8 || status == 9) 
    		branch.setStatus(false);

    	// set extra info which is not used in InterPSS simulation engine
    	branch.setCurrentLimit(currentLimit);
    	
    	return true;
    }
    
    /*
     * ##T section
     */
    private static boolean processXfr2WindingRecord(String str, AclfAdjNetwork  aclfNet, IPSSMsgHub msg) {
		IpssLogger.getLogger().info("Xfr 2W Record: " + str);

		// parse the input line for xformer information
		String fromNodeId, toNodeId, orderCode, elemName;
		int status, currentLimit;
		double fromRatedKV, toRatedKV, normialMva,
		       rOhm, xOhm, bMuS, gMuS;  
		try {
			fromNodeId = StringUtil.getString(str, 1, 8).trim().replace(' ', '_');
			toNodeId = StringUtil.getString(str, 10, 17).trim().replace(' ', '_');
			orderCode = StringUtil.getString(str, 19, 19);

			status = StringUtil.getInt(str, 21, 21);  // 0 real, i equivalent
			fromRatedKV = StringUtil.getDouble(str, 23, 27);  
			toRatedKV = StringUtil.getDouble(str, 29, 33);  
			normialMva = StringUtil.getDouble(str, 35, 39);  
			rOhm = StringUtil.getDouble(str, 41, 46);  
			xOhm = StringUtil.getDouble(str, 48, 53);  
			bMuS = StringUtil.getDouble(str, 55, 62);  
			gMuS = StringUtil.getDouble(str, 64, 69);  
			currentLimit = StringUtil.getInt(str, 71, 76);  

			elemName = StringUtil.getString(str, 78, 89);
		} catch (Exception e) {
			IpssLogger.logErr(e);
			msg.sendErrorMsg("Error: " + str + ", " + e.toString());
			return false;
		}

    	if (status == 0 || status == 8) {
    		if (rOhm < 0.0 || xOhm < 0.0) {
    			IpssLogger.getLogger().severe("Error: transform r < 0 or x < 0, data line: " + str);
    			msg.sendErrorMsg("Error: transform r < 0 or x < 0, data line: " + str);
    			return false;
    		}
    	}

    	// create an UCTEBranch object and add to the network object
      	final UCTEBranch branch = new UCTEBranch(elemName, orderCode);
      	aclfNet.addBranch(branch, fromNodeId, toNodeId);    
      	
    	// set xfr info into InterPSS simulation engine 
	 	branch.setBranchCode(AclfBranchCode.XFORMER);
		final XfrAdapter xfr = (XfrAdapter)branch.adapt(XfrAdapter.class);
		// r, x, g, b are measured at from side
    	xfr.setZ(new Complex(rOhm,xOhm), UnitType.Ohm, fromRatedKV, aclfNet.getBaseKva(), msg);
    	Complex yPU = UnitType.yConversion(new Complex(gMuS,bMuS), fromRatedKV, 
    			aclfNet.getBaseKva(), UnitType.MicroMho, UnitType.PU);
    	xfr.setToShuntY(yPU, UnitType.PU, aclfNet.getBaseKva()); 
    	xfr.setFromTurnRatio(1.0, UnitType.PU);
    	xfr.setToTurnRatio(1.0, UnitType.PU); 

    	// by default the branch is active
    	if (status == 8 || status == 9) 
    		branch.setStatus(false);
    	
    	// set extra info which is not used in InterPSS simulation engine
    	branch.setCurrentLimit(currentLimit);
    	branch.setFromRatedKV(fromRatedKV);
   		branch.setToRatedKV(toRatedKV);
		branch.setNormialMva(normialMva);

    	return true;
    }
    
    /*
     * ##R section
     */
    private static boolean processXfr2WRegulationRecord(String str, AclfAdjNetwork aclfNet, IPSSMsgHub msg) {
		IpssLogger.getLogger().info("Xfr 2W Reg Record: " + str);

		String fromNodeId, toNodeId, orderCode, type;

		double dUPhase, uKvPhase; 
		int nPhase, n1Phase;  

		double dUAngle, thetaDegAngle, pMwAngle;  
		int nAngle, n1Angle;  

		try {
			fromNodeId = StringUtil.getString(str, 1, 8).trim().replace(' ', '_');
			toNodeId = StringUtil.getString(str, 10, 17).trim().replace(' ', '_');
			orderCode = StringUtil.getString(str, 19, 19);

			dUPhase = StringUtil.getDouble(str, 21, 25);  
			nPhase = StringUtil.getInt(str, 27, 28);  
			n1Phase = StringUtil.getInt(str, 30, 32);  
			uKvPhase = StringUtil.getDouble(str, 34, 38);  

			dUAngle = StringUtil.getDouble(str, 40, 44);  
			thetaDegAngle = StringUtil.getDouble(str, 46, 50);  
			nAngle = StringUtil.getInt(str, 52, 53);  
			n1Angle = StringUtil.getInt(str, 55, 57);  
			pMwAngle = StringUtil.getDouble(str, 59, 63);  

			type = StringUtil.getString(str, 65, 68);
		} catch (Exception e) {
			IpssLogger.logErr(e);
			msg.sendErrorMsg("Error: " + str + ", " + e.toString());
			return false;
		}
		
		if (dUPhase > 0.0 && dUAngle > 0.0) {
			IpssLogger.getLogger().severe("Error: both phase regulation and angle regulation data are presented");
			msg.sendErrorMsg("Error: both phase regulation and angle regulation data are presented");
			return false;
		}
		
      	final UCTEBranch branch = (UCTEBranch)aclfNet.getBranch(fromNodeId, toNodeId, orderCode); 
      	if (branch == null) {
			IpssLogger.getLogger().severe("Error: branch cannot be found, line: " + str);
			msg.sendErrorMsg("Error: branch cannot be found, line: " + str);
      		return false;
      	}
      	
      	if (dUPhase > 0.0) {
			IpssLogger.getLogger().info("Phase regulation data persented");
			branch.setDUPhase(dUPhase);
			branch.setNPhase(nPhase);
			branch.setN1Phase(n1Phase);
			branch.setUKvPhase(uKvPhase);
			
			final XfrAdapter xfr = (XfrAdapter)branch.adapt(XfrAdapter.class);
			double x = 1.0 / (1.0 + n1Phase*dUPhase*0.01);
			// UCTE model at toside x : 1.0, InterPSS model 1.0:turnRatio
			xfr.setToTurnRatio(1.0/x, UnitType.PU);
			
			if (uKvPhase > 0.0) {
				// tap control of voltage at to node side
//              2 - Variable tap for voltage control (TCUL, LTC)
          		final TapControl tapv = CoreObjectFactory.createTapVControlBusVoltage(aclfNet, branch.getId(), 
          									toNodeId, FlowControlType.POINT_CONTROL);
          		double maxTap = (1.0 + nPhase*dUPhase*0.01), 
          		       minTap = (1.0 - nPhase*dUPhase*0.01);
         		tapv.setTapLimit(new LimitType(maxTap, minTap));
          		tapv.setVSpecified(uKvPhase, UnitType.kV);
          		tapv.setTapStepSize(2*nPhase+1);
          		tapv.setControlOnFromSide(false);
          		aclfNet.addTapControl(tapv, toNodeId);          		
			}
		}
		else if (dUAngle > 0.0) {
			IpssLogger.getLogger().info("angle regulation data persented");
			branch.setDUAngle(dUAngle);
			branch.setThetaDegAngle(thetaDegAngle);
			branch.setNAngle(nAngle);
			branch.setN1Angle(n1Angle);
			branch.setPMwAngle(pMwAngle);
	
		 	branch.setBranchCode(AclfBranchCode.PS_XFORMER);
			final PSXfrAdapter psXfr = (PSXfrAdapter)branch.adapt(PSXfrAdapter.class);
			double ang = 0.0, angMax = 0.0, angMin = 0.0, x = 1.0;
			double a    = n1Angle*dUAngle*0.01,
				   aMax = nAngle*dUAngle*0.01,
			       aMin = -nAngle*dUAngle*0.01;
			if (type.equals(PsXfrType_ASYM)) {
				if (thetaDegAngle == 90.0) {
					ang = Math.atan(a);
					angMax = Math.atan(aMax);
					angMin = Math.atan(aMin);
					x = 1.0 / Math.sqrt(1.0 + a*a);
				}
				else {
					double theta = thetaDegAngle * Constants.DtoR,
					       asin = a*Math.sin(theta),
					       acos = 1.0 + a*Math.cos(theta),
					       asinMax = aMax*Math.sin(theta),
					       acosMax = 1.0 + aMax*Math.cos(theta),
					       asinMin = aMin*Math.sin(theta),
					       acosMin = 1.0 + aMin*Math.cos(theta);
					ang = Math.atan(asin/acos);
					angMax = Math.atan(asinMax/acosMax);
					angMin = Math.atan(asinMin/acosMin);
					x = 1.0 / Math.sqrt(asin*asin + acos*acos);
				}
			}
			else {  // default type is SYMM
				ang = 2.0 * Math.atan(a/2.0);
				angMax = 2.0 * Math.atan(aMax/2.0);
				angMin = 2.0 * Math.atan(aMin/2.0);
			}
			psXfr.setToAngle(-ang, UnitType.Rad);
			psXfr.setToTurnRatio(1/x, UnitType.PU);
			
			if (pMwAngle != 0.0) {
          		final PSXfrPControl ps = CoreObjectFactory.createPSXfrPControl(aclfNet, branch.getId(), FlowControlType.POINT_CONTROL);
          		ps.setPSpecified(pMwAngle, UnitType.mW, aclfNet.getBaseKva());
          		ps.setAngLimit(new LimitType(angMax, angMin));
          		ps.setControlOnFromSide(false);
          		aclfNet.addPSXfrPControl(ps, branch.getId());          		
			}
		}
		
    	return true;
    }
    
    /*
     * ##TT section
     */
    private static boolean processXfr2LookupRecord(String str, AclfAdjNetwork aclfNet, IPSSMsgHub msg) {
		IpssLogger.getLogger().info("Xfr 2W Desc Record: " + str);
		IpssLogger.getLogger().severe("##TT not implemented yet. Contact support@interpss.org for more info");
		msg.sendErrorMsg("##TT not implemented yet. Contact support@interpss.org for more info");
		return false;
    }
    
    /*
     * ##E section
     */
    private static boolean processExchangePowerRecord(String str, UCTENetwork aclfNet, IPSSMsgHub msg) {
		IpssLogger.getLogger().info("Exchange Power Record: " + str);

		String fromIsoId, toIsoId, comment;
		double exPower;  

		try {
			fromIsoId = StringUtil.getString(str, 1, 2);
			toIsoId = StringUtil.getString(str, 4, 5);
			exPower = StringUtil.getDouble(str, 7, 13);  
			comment = StringUtil.getString(str, 15, 26);
		} catch (Exception e) {
			IpssLogger.logErr(e);
			msg.sendErrorMsg("Error: " + str + ", " + e.toString());
			return false;
		}

		aclfNet.addExchangePower(new UCTENetwork.ExchangePower(
						fromIsoId, toIsoId, exPower, comment));
		return true;
    }

    /*
     * util functions and extenstions 
     */

    // custom base voltage is an extension to the UCTE std
	private static List<Double> customBaseVoltageList = new ArrayList<Double>();
	private static boolean customBaseVoltage = false;

    
    private static boolean processBaseVoltageRecord(String str) {
    	customBaseVoltageList.add(new Double(str));
    	return true;
    }

    private static double getBaseVoltageKv(String nodeId) throws Exception {
        // According to the spec the node base voltage code is stored at the 7th char
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
    	case 7 : return 27.0;
    	case 8 : return 330.0;
    	case 9 : return 500.0;
    	default: 
    		IpssLogger.getLogger().severe("Wrong base voltage code, " + code);
    		return 0.0;
    	}
    }
    
	private static double findCustomBaseVoltage(double voltage) {
		double baseKv = 0.0;
		double e = Constants.LargeDouble;
		for (Double bv : customBaseVoltageList) {
			if (Math.abs(voltage - bv.doubleValue()) < e) {
				baseKv = bv.doubleValue();
				e = Math.abs(voltage - bv.doubleValue());
			}
		}
		return baseKv;
	}
    
}
