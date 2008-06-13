 /*
  * @(#)PSSE2IpssUtilFunc.java   
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

package org.interpss.custom.exchange.psse;

import java.util.StringTokenizer;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.datatype.Constants;
import com.interpss.common.datatype.LimitType;
import com.interpss.common.datatype.UnitType;
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
import com.interpss.ext.psse.aclf.PSSEAclfGen;
import com.interpss.ext.psse.aclf.PSSEAclfLoad;
import com.interpss.ext.psse.aclf.PSSEAclfXformer;

public class PSSE2IpssUtilFunc {
	/**
	 * Transfer PSSE data model into InterPSS object model
	 * 
	 * @param adjNet
	 * @param msg
	 * @return
	 */
	public static boolean transferData(AclfAdjNetwork adjNet, IPSSMsgHub msg) {
		boolean hasError = false;
		
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
					if (obj instanceof PSSEAclfLoad) {
						PSSEAclfLoad load = (PSSEAclfLoad)obj;
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
					else if (obj instanceof PSSEAclfGen) {
						PSSEAclfGen gen = (PSSEAclfGen)obj;
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
			if (obj instanceof PSSEAclfXformer) {
				PSSEAclfXformer xfr = (PSSEAclfXformer)obj;
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
	          		tapv.setMeteredOnFromSide(xfr.isControlOnFromSide());
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
	          		tapv.setMeteredOnFromSide(xfr.isControlOnFromSide());
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
	          		ps.setMeteredOnFromSide(xfr.isControlOnFromSide());
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
		
		return !hasError;
	}	

	/**
	 * PTI use 0 to indicate end of a data set, Bus Data for example. This function checks
	 * if the input line is the end of record line
	 *
	 * @param str a input data line string
	 */
	public static boolean isEndRecLine(String str) {
		return str.startsWith("0") || str.startsWith("/") || str.startsWith("Q");
	}
	
	public static String trimQuote(String str) {
		return str.substring(1, str.length()-1);
	}
	
	public static boolean is3WXfr(String str) {
		// for 2W xfr, line1, K = 0
  		StringTokenizer st = new StringTokenizer(str, ",");
		st.nextToken();
		st.nextToken();
		int K = new Integer(st.nextToken().trim()).intValue();
		return K != 0;
	}
	
	public static String removeTailComment(String s) {
		if (s.indexOf("/*") > 0)
			return s.substring(0, s.indexOf("/*"));
		else
			return s;
	}	
}
