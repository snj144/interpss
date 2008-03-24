 /*
  * @(#)FileAdapter_PTIFormat.java   
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

/*
 * PTI PSS/E File input adapter. The implementation is Based on 
 * PSS/E 29, published Oct 2002.
 * 
 * The following records are implemented
 * 
 * 		Case Identification
		Bus Data
		Gnerator Data
		Nontransformer Branch Data
		Transformer Data
		Area Interchange Data
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.math.complex.Complex;
import org.interpss.custom.exchange.psse.PSSEBranchDataRecord;
import org.interpss.custom.exchange.psse.PSSEBusDataRecord;
import org.interpss.custom.exchange.psse.PSSEDCLintDataRecord;
import org.interpss.custom.exchange.psse.PSSEDataRec;
import org.interpss.custom.exchange.psse.PSSENetDataRecord;
import org.interpss.custom.exchange.psse.PSSESwitchedShuntDataRecord;
import org.interpss.custom.exchange.psse.PSSEUtilFunc;
import org.interpss.custom.exchange.psse.aclf.PSSEGen;
import org.interpss.custom.exchange.psse.aclf.PSSELoad;
import org.interpss.custom.exchange.psse.aclf.PSSEXformer;

import com.interpss.common.datatype.Constants;
import com.interpss.common.datatype.LimitType;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.exp.InvalidOperationException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfGenCode;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.PQBusAdapter;
import com.interpss.core.aclf.PVBusAdapter;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.aclfadj.FlowControlType;
import com.interpss.core.aclfadj.FunctionLoad;
import com.interpss.core.aclfadj.PSXfrPControl;
import com.interpss.core.aclfadj.PVBusLimit;
import com.interpss.core.aclfadj.RemoteQBus;
import com.interpss.core.aclfadj.RemoteQControlType;
import com.interpss.core.aclfadj.TapControl;
import com.interpss.core.net.Bus;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;


public class FileAdapter_PTIFormat extends IpssFileAdapterBase {


	private PSSEDataRec.VersionNo version = PSSEDataRec.VersionNo.NotDefined;
	
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
		if (this.getVersionSelected() != null && !this.getVersionSelected().equals("")) {
			IpssLogger.getLogger().info("PSS/E version: " + this.getVersionSelected());
			if (this.getVersionSelected().contains("30"))
				this.version = PSSEDataRec.VersionNo.PSS_E_30;
			else if (this.getVersionSelected().contains("29"))
				this.version = PSSEDataRec.VersionNo.PSS_E_29;
		}
			
		final File file = new File(filepath);
		final InputStream stream = new FileInputStream(file);
		final BufferedReader din = new BufferedReader(new InputStreamReader(stream));
		
		// load the loadflow data into the AclfAdjNetwork object
		final AclfAdjNetwork adjNet = loadFile(din, msg);
		if (adjNet == null)
			return;
  		// System.out.println(adjNet.net2String());

		processPSSEDataAfterLoad(adjNet, msg);
		
		// set the simuContext object
  		simuCtx.setNetType(SimuCtxType.ACLF_ADJ_NETWORK);
  		simuCtx.setAclfAdjNet(adjNet);
  		simuCtx.setName(filepath.substring(filepath.lastIndexOf(File.separatorChar)+1));
  		simuCtx.setDesc("This project is created by input file " + filepath);
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
		throw new InvalidOperationException("FileAdapter_PTIFormat.save not implemented");
	}
	
	/** 
	 * Build an AclfAdjNetwork object from the input file stream in PTI format
	 *
	 * @param din input file stream
	 * @param msgHub the message hub object
	 */
	private AclfAdjNetwork loadFile(
				java.io.BufferedReader din, 
				IPSSMsgHub msgHub) throws Exception {
  		AclfAdjNetwork adjNet = CoreObjectFactory.createAclfAdjNetwork();
  		adjNet.setAllowParallelBranch(true);
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
      		do {
      			lineStr = din.readLine();
      			if (lineStr != null) {
      				lineNo++;
      				if (!headerProcessed) {
      					if (lineNo == 1 && version == PSSEDataRec.VersionNo.NotDefined) {
      						// check version number
      						if (lineStr.contains("PSS/E-30"))
      							version = PSSEDataRec.VersionNo.PSS_E_30;
      						else if (lineStr.contains("PSS/E-29"))
      							version = PSSEDataRec.VersionNo.PSS_E_29;
      						else {
      							msgHub.sendWarnMsg("Unsupported PSS/E verion, " + lineStr);
      							version = PSSEDataRec.VersionNo.Unkown;
      						}
      					}
						if (lineNo == 3) 
      						headerProcessed = true;
						PSSENetDataRecord.processHeader(adjNet, lineStr, lineNo, version, msgHub);
      				}
      				else if (!busProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr)) {
							 busProcessed = true;
							 IpssLogger.getLogger().info("PSS/E Bus record processed");
						}	 
						else {
							PSSEBusDataRecord.processBus(adjNet, lineStr, lineNo, version, msgHub);
						}	 
      				}
      				else if (!loadProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr)) {
							 loadProcessed = true;
							 IpssLogger.getLogger().info("PSS/E Load record processed");
						}
						else {
							PSSEBusDataRecord.processLoad(adjNet, lineStr, lineNo, version, msgHub);
						}	 
      				}
      				else if (!genProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr)) {
							 genProcessed = true;
							 IpssLogger.getLogger().info("PSS/E Gen record processed");
						}
						else {
							PSSEBusDataRecord.processGen(adjNet, lineStr, lineNo, version, msgHub);
						}	 
      				}
      				else if (!lineProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr)) {
							 lineProcessed = true;
							 IpssLogger.getLogger().info("PSS/E Line record processed");
						}
						else {
							PSSEBranchDataRecord.processLine(adjNet, lineStr, lineNo, version, msgHub);
						}	 
      				}
      				else if (!xfrProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr)) {
							 xfrProcessed = true;
							 IpssLogger.getLogger().info("PSS/E Xfr record processed");
						}
						else {
							int n = lineNo;
      						String lineStr2 = din.readLine();
      						String lineStr3 = din.readLine();
      						String lineStr4 = din.readLine();
      						lineNo++; lineNo++; lineNo++;
      						String lineStr5 = "";
      						if (PSSEUtilFunc.is3WXfr(lineStr)) {
          						lineStr4 = din.readLine();
          						lineNo++;
      						}
							PSSEBranchDataRecord.processXfr(adjNet, lineStr, lineStr2, lineStr3, lineStr4, lineStr5, n, version, msgHub);
						}	 
      				}
      				else if (!areaInterProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr)) {
							 areaInterProcessed = true;
							 IpssLogger.getLogger().info("PSS/E AreaInterchange record processed");
						}
						else {
							PSSENetDataRecord.processAreaInterchange(adjNet, lineStr, lineNo, version, msgHub);
						}	 
      				}
      				else if (!dcLine2TProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr)) {
							 dcLine2TProcessed = true;
							 IpssLogger.getLogger().info("PSS/E DC line record processed");
						}
						else {
      						String lineStr2 = din.readLine();
      						String lineStr3 = din.readLine();
      						lineNo++; lineNo++;
      						PSSEDCLintDataRecord.processDCLine(adjNet, lineStr, lineStr2, lineStr3, lineNo, msgHub);
						}	 
      				}
      				else if (!vscDcLineProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr)) {
							vscDcLineProcessed = true;
							 IpssLogger.getLogger().info("PSS/E vscDcLine record processed");
						}
						else {
      						PSSEDCLintDataRecord.processVscDCLine(adjNet, lineStr, lineNo, msgHub);
						}	 
      				}
      				else if (!switchedShuntProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr)) {
							 switchedShuntProcessed = true;
							 IpssLogger.getLogger().info("PSS/E switched shunt record processed");
						}
						else {
							PSSESwitchedShuntDataRecord.processSwitchedShunt(adjNet, lineStr, lineNo, version, msgHub);
						}	 
      				}
      				else if (!xfrZCorrectionProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr)) {
							xfrZCorrectionProcessed = true;
							IpssLogger.getLogger().info("PSS/E Xfr table record processed");
						}
						else {
							PSSEBranchDataRecord.processXfrZCorrectionTable(adjNet, lineStr, lineNo, msgHub);
						}	 
      				}
      				else if (!dcLineMTProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr)) {
							dcLineMTProcessed = true;
							 IpssLogger.getLogger().info("PSS/E multi terminal DC Line record processed");
						}
						else {
							PSSEDCLintDataRecord.processMultiTerminalDCLine(adjNet, lineStr, lineNo, msgHub);
						}	 
      				}
      				else if (!multiSectionLineGroupProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr)) {
							multiSectionLineGroupProcessed = true;
							 IpssLogger.getLogger().info("PSS/E multi section Line Group record processed");
						}
						else {
							PSSENetDataRecord.processMultiSectionLineGroup(adjNet, lineStr, lineNo, version, msgHub);
						}	 
      				}
      				else if (!zoneProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr)) {
							zoneProcessed = true;
							 IpssLogger.getLogger().info("PSS/E Zone record processed");
						}
						else {
							PSSENetDataRecord.processZone(adjNet, lineStr, lineNo, version, msgHub);
						}	 
      				}
      				else if (!interareaTransferProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr)) {
							interareaTransferProcessed = true;
							 IpssLogger.getLogger().info("PSS/E Interarea Transfer record processed");
						}
						else {
							PSSENetDataRecord.processInterareaTransfer(adjNet, lineStr, lineNo, version, msgHub);
						}	 
      				}
      				else if (!ownerProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr)) {
							ownerProcessed = true;
							 IpssLogger.getLogger().info("PSS/E Owner record processed");
						}
						else {
							PSSENetDataRecord.processOwner(adjNet, lineStr, lineNo, version, msgHub);
						}	 
      				}
      				else if (!factsProcessed) {
						if (PSSEUtilFunc.isEndRecLine(lineStr)) {
							factsProcessed = true;
							 IpssLogger.getLogger().info("PSS/E FACTS record processed");
						}
						else {
							PSSESwitchedShuntDataRecord.processFACTS(adjNet, lineStr, lineNo, msgHub);
						}	 
      				}
      				
      			}
    		} while (lineStr != null);
  		} catch (Exception e) {
    		throw new Exception("PSSE data input error, line no " + lineNo + ", " + e.toString());
  		}
  		return adjNet;
	}
	
	private void processPSSEDataAfterLoad(AclfAdjNetwork adjNet, IPSSMsgHub msg) {
		for( Bus b : adjNet.getBusList()) {
			AclfBus bus = (AclfBus)b;

			double loadPSum = 0.0, loadQSum = 0.0;
			boolean isFuncLoad = false;
			double constP_P = 0.0, constP_Q = 0.0;
			double constI_P = 0.0, constI_Q = 0.0;

			String remoteBusId = null;
			double genPSum = 0.0, genQSum = 0.0, vSpec = 0.0;
			double genQmax = 0.0, genQmin = 0.0;
			
			if (bus.getRegDeviceList().size() > 0) {
				for( Object obj : bus.getRegDeviceList()) {
					if (obj instanceof PSSELoad) {
						PSSELoad load = (PSSELoad)obj;
						loadPSum += load.getConstPLoad().getReal() + load.getConstILoad().getReal() +load.getConstZLoad().getReal(); 
						loadQSum += load.getConstPLoad().getImaginary() + load.getConstILoad().getImaginary() +load.getConstZLoad().getImaginary(); 
						constP_P += load.getConstPLoad().getReal(); 
						constI_P += load.getConstILoad().getReal(); 
						constP_Q += load.getConstPLoad().getImaginary(); 
						constI_Q += load.getConstILoad().getImaginary();
						if (load.getConstILoad().getReal() != 0.0 ||
							load.getConstZLoad().getReal() != 0.0 ||
							load.getConstILoad().getImaginary() != 0.0 ||
							load.getConstILoad().getImaginary() != 0.0)
							isFuncLoad = true;
					}
					else if (obj instanceof PSSEGen) {
						PSSEGen gen = (PSSEGen)obj;
						genPSum += gen.getPGen();
						genQSum += gen.getQGen();
						if (vSpec == 0.0)
							vSpec = gen.getVSpec();
						else if (vSpec != gen.getVSpec()) {
							msg.sendErrorMsg("Inconsistance Gen VSpec at Bus " + bus.getId());
						}
						if (remoteBusId == null)
							remoteBusId = gen.getVControlBusId();
						else if (!remoteBusId.equals(gen.getVControlBusId())) {
							msg.sendErrorMsg("Inconsistance Gen IREG at Bus " + bus.getId());
						}
						genQmax += gen.getQLimit().getMax();
						genQmin += gen.getQLimit().getMin();
					}
				}
			}
			
			if (genPSum != 0.0 || vSpec != 0.0) {
				IpssLogger.getLogger().fine("genPSum, genQSum, vSpec, genQmax, genQmin: " + 
						genPSum + ", " + genQSum + ", " + vSpec + ", " + genQmax + ", " + genQmin);
				if (bus.isSwing()) {
		  			final SwingBusAdapter gen = (SwingBusAdapter)bus.adapt(SwingBusAdapter.class);
		  			gen.setVoltMag(vSpec, UnitType.PU);
				}
				else if (bus.isGenPV()) {
					if (remoteBusId.equals("0")) {
						// PVLimit
			  			final PVBusAdapter gen = (PVBusAdapter)bus.adapt(PVBusAdapter.class);
			  			gen.setGenP(genPSum, UnitType.PU, adjNet.getBaseKva());
			  			gen.setVoltMag(vSpec, UnitType.PU);
	  					IpssLogger.getLogger().fine("Bus is a PVLimitBus, id: " + bus.getId());
	  			  		final PVBusLimit pvLimit = CoreObjectFactory.createPVBusLimit(adjNet, bus.getId());
	  			  		pvLimit.setQLimit(new LimitType(genQmax, genQmin), UnitType.PU, adjNet.getBaseKva());
					}
					else {
						// remote bus voltage
	  					IpssLogger.getLogger().fine("Bus is a RemoteQBus, id: " + bus.getId());
	  					bus.setGenCode(AclfGenCode.GEN_PQ);
	  			  		final RemoteQBus reQ1 = CoreObjectFactory.createRemoteQBus(adjNet, bus.getId(), 
	  			  				RemoteQControlType.BUS_VOLTAGE, remoteBusId);
			  			final PQBusAdapter gen = (PQBusAdapter)bus.adapt(PQBusAdapter.class);
			  			gen.setGen(new Complex(genPSum,genQSum), UnitType.PU, adjNet.getBaseKva());
	  			  		reQ1.setQLimit(new LimitType(genQmax, genQmin), UnitType.PU, adjNet.getBaseKva());
	  			  		reQ1.setVSpecified(vSpec);
	  			  	}
				}
				else {
					msg.sendErrorMsg("Generator data error, Bus IDE != 2 at Bus " + bus.getId());
				}
			}
			
			if (loadPSum != 0.0 || loadQSum != 0.0 || isFuncLoad ) {
				bus.setLoadCode(AclfLoadCode.CONST_P);
				bus.setLoadP(loadPSum);
				bus.setLoadQ(loadQSum);
				if (isFuncLoad) {
			  		FunctionLoad fload = CoreObjectFactory.createFunctionLoad(adjNet, bus.getId());
			  		fload.getP().setA(constP_P/loadPSum);
			  		fload.getP().setB(constI_P/loadPSum);
			  		fload.getQ().setA(constP_Q/loadQSum);
			  		fload.getQ().setB(constI_Q/loadQSum);					
				}
			}
			
		}
 /*
		RMA, RMI The upper and lower limits, respectively, of either:
			• Off-nominal turns ratio in pu of winding one bus base voltage when |COD|
				is 1 or 2 and CW is 1; RMA = 1.1 and RMI = 0.9 by default.
			• Actual winding one voltage in kV when |COD| is 1 or 2 and CW is 2. No
				default is allowed.
			• Phase shift angle in degrees when |COD| is 3. No default is allowed.
			• Not used when |COD| is 0 or 4; RMA = 1.1 and RMI = 0.9 by default.

		VMA, VMI The upper and lower limits, respectively, of either:
			• Voltage at the controlled bus (bus |CONT|) in pu when |COD| is 1.
				VMA = 1.1 and VMI = 0.9 by default.
			• Reactive power flow into the transformer at the winding one bus end in
				Mvar when |COD| is 2. No default is allowed.
			• Active power flow into the transformer at the winding one bus end in MW
				when |COD| is 3. No default is allowed.
			• Not used when |COD| is 0 or 4; VMA = 1.1 and VMI = 0.9 by default.
*/
		for( Object obj : adjNet.getBranchList()) {
			if (obj instanceof PSSEXformer) {
				PSSEXformer xfr = (PSSEXformer)obj;
	          	if (xfr.getControlMode() == 1) {
	          		// ±1 for voltage control; a negative control mode suppresses the automatic adjustment of this
	          		// transformer.
	          		/*
					The tap ratio of each transformer is adjusted to hold a voltage
					magnitude between the limits VMIN to VMAX.
	          		 */
	          		IpssLogger.getLogger().info("Xfr " + xfr.getFromAclfBus().getId() + "->" + xfr.getToAclfBus().getId() + " has voltage control");
	          		final TapControl tapv = CoreObjectFactory.createTapVControlBusVoltage(
	          				adjNet, xfr.getId(), xfr.getContBusId(), FlowControlType.RANGE_CONTROL);
	          		tapv.setTapLimit(xfr.getRmLimit());
	          		tapv.setControlRange(xfr.getVmLimit());
	          		tapv.setVSpecified(1.0);
	          		tapv.setTapStepSize((xfr.getRmLimit().getMax()-xfr.getRmLimit().getMin())/xfr.getAdjSteps());
	          		// we use from side tap to control
	          		tapv.setControlOnFromSide(true);
	          		tapv.setMeteredOnFromSide(xfr.getControlOnFromSide());
	          		tapv.setCompensateZ(xfr.getLoadDropCZ());
	          		adjNet.addTapControl(tapv, xfr.getContBusId());   
	          	}
	          	else if (xfr.getControlMode() == 2) {
	          		// ±2 for reactive power flow control; 
	          		/*
					The tap ratio is adjusted to hold the Mvar on the tap side of the transformer between the limits
					VMIN-VMAX.	        
	          		 */
	          		IpssLogger.getLogger().info("Xfr " + xfr.getFromAclfBus().getId() + "->" + xfr.getToAclfBus().getId() + " has reactive power flow control");
	          		final TapControl tapv = CoreObjectFactory.createTapVControlMvarFlow(adjNet, xfr.getId(), FlowControlType.RANGE_CONTROL);
	          		tapv.setTapLimit(xfr.getRmLimit());
	          		tapv.setControlRange(xfr.getVmLimit());
	          		tapv.setTapStepSize((xfr.getRmLimit().getMax()-xfr.getRmLimit().getMin())/xfr.getAdjSteps());
	          		// we use from side tap to control
	          		tapv.setControlOnFromSide(true);
	          		tapv.setMeteredOnFromSide(xfr.getControlOnFromSide());
	          		tapv.setFlowFrom2To(true);
	          		tapv.setCompensateZ(xfr.getLoadDropCZ());
	          		adjNet.addTapControl(tapv, xfr.getContBusId());   
	          	}
	          	else if (xfr.getControlMode() == 3) {
	          		// ±3 for active power flow control;
	          		/*
					The phase-shift angle of each phase shifter is adjusted, as necessary, to keep the real power flow
					through the phase shifter between the limits VMAX and VMIN.
	          		 */
	          		IpssLogger.getLogger().info("PSXfr " + xfr.getFromAclfBus().getId() + "->" + xfr.getToAclfBus().getId() + " has active power control");
	          		final PSXfrPControl ps = CoreObjectFactory.createPSXfrPControl(adjNet, xfr.getId(), FlowControlType.RANGE_CONTROL);
	          		ps.setAngLimit(new LimitType(xfr.getRmLimit().getMax()*Constants.DtoR, 
	          									 xfr.getRmLimit().getMin()*Constants.DtoR));
	          		double baseMva = adjNet.getBaseKva() * 0.001;
	          		ps.setControlRange(new LimitType(xfr.getVmLimit().getMax()/baseMva, xfr.getVmLimit().getMin()/baseMva));
	          		// we use from side angle to control
	          		ps.setControlOnFromSide(true);
	          		ps.setMeteredOnFromSide(xfr.getControlOnFromSide());
	          		ps.setFlowFrom2To(true);
	          		if (xfr.getControlMode() == -3)
	          			ps.setStatus(false);
          			adjNet.addPSXfrPControl(ps, xfr.getId());   
	          	}
	          	else if (xfr.getControlMode() == 4) {
	          		// ±4 for control of a dc line quantity.
	          		msg.sendWarnMsg("Xfr " + xfr.getFromAclfBus().getId() + "->" + xfr.getToAclfBus().getId() + " has control of a dc line capacity");
	          	}
			}
		}
	}
}