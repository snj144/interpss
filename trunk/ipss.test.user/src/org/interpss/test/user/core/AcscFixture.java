 /*
  * @(#)AcscFixture.java   
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

package org.interpss.test.user.core;

import java.util.StringTokenizer;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.datatype.ScGroundType;
import com.interpss.common.datatype.UnitType;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBranchCode;
import com.interpss.core.acsc.AcscBranch;
import com.interpss.core.acsc.AcscBranchFault;
import com.interpss.core.acsc.AcscBus;
import com.interpss.core.acsc.AcscBusFault;
import com.interpss.core.acsc.AcscPSXfrAdapter;
import com.interpss.core.acsc.AcscXfrAdapter;
import com.interpss.core.acsc.BusScCode;
import com.interpss.core.acsc.SequenceCode;
import com.interpss.core.acsc.SimpleFaultCode;
import com.interpss.core.acsc.XfrConnectCode;
import com.interpss.simu.SimuSpringAppContext;

public class AcscFixture extends AclfBuildFixture {
	private static AcscBusFault acscFault = null;
	
	public void createAcscNetwork() {
		simuCtx = SimuSpringAppContext.getSimuContextTypeAcscFault();
	}
	
	public void outputAcscDebugInfo() {
		System.out.println(simuCtx.getAcscFaultNet().net2String());
	}
	
	public void runAcShortCircuit() {
		simuCtx.setSimpleFaultAlgorithm(SimuSpringAppContext.getSimpleFaultAlgorithm());
	  	if (acscFault instanceof AcscBranchFault)
	  		simuCtx.getSimpleFaultAlgorithm().calculateBranchFault((AcscBranchFault)acscFault, msg);		
	  	else
	  		simuCtx.getSimpleFaultAlgorithm().calculateBusFault(acscFault, msg);		
	  	
		//System.out.println(AcscOut.faultResult2String(simuCtx.getAcscFaultNet()));
	}
	
	/*
	 * Define fault
	 */
	
	// format: busId,faultType(3P/LG/LLG/LL)
	public void setAcscBusFault(String data) {
		setAcscBusFaultWithZ(data+",0.0,0.0,0.0,0.0");	
	}
	
	// format: busId,faultType(3P/LG/LLG/LL),distance(%fromBus)
	public void setAcscBranchFault(String data) {
		setAcscBranchFaultWithZ(data+",0.0,0.0,0.0,0.0");	
	}	
		
	// format: busId,faultType(3P/LG/LLG/LL),rLG_PU,xLG_PU,rLL_PU,xLL_PU
	public void setAcscBusFaultWithZ(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		busId = st.nextToken();
		SimpleFaultCode fcode = getFaultCode(st.nextToken());
		double rLG = new Double(st.nextToken()).doubleValue();
		double xLG = new Double(st.nextToken()).doubleValue();
		double rLL = new Double(st.nextToken()).doubleValue();
		double xLL = new Double(st.nextToken()).doubleValue();
		
		acscFault = CoreObjectFactory.createAcscBusFault(busId, simuCtx.getAcscFaultNet());
		acscFault.setFaultCode(fcode);
		acscFault.setZLGFault(new Complex(rLG, xLG));
		acscFault.setZLLFault(new Complex(rLL, xLL));		
	}

	// format: branchFromBusId,branchToBusId,faultType(3P/LG/LLG/LL),distance(%fromBus),rLG_PU,xLG_PU,rLL_PU,xLL_PU
	public void setAcscBranchFaultWithZ(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		branchFromBusId = st.nextToken();
		branchToBusId = st.nextToken();
		SimpleFaultCode fcode = getFaultCode(st.nextToken());
		double distance = new Double(st.nextToken()).doubleValue();
		double rLG = new Double(st.nextToken()).doubleValue();
		double xLG = new Double(st.nextToken()).doubleValue();
		double rLL = new Double(st.nextToken()).doubleValue();
		double xLL = new Double(st.nextToken()).doubleValue();
		
		acscFault = CoreObjectFactory.createAcscBranchFault(getBranchId(), simuCtx.getAcscFaultNet());
		acscFault.setFaultCode(fcode);
		acscFault.setZLGFault(new Complex(rLG, xLG));
		acscFault.setZLLFault(new Complex(rLL, xLL));
		((AcscBranchFault)acscFault).setDistance(distance,UnitType.Percent);
	}	
	
    /*
     * Add bus
     */
	
	// format: busId,baseVoltage
	public void addScNonContributeBus(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		busId = st.nextToken();
		double baseVolt = new Double(st.nextToken()).doubleValue();
		
	  	AcscBus bus = CoreObjectFactory.createAcscBus(busId);
		bus.setScCode(BusScCode.NON_CONTRI_LITERAL);
		bus.setBaseVoltage(baseVolt, UnitType.Volt );
		bus.setZ(new Complex(0.0, 1.0e10), SequenceCode.POSITIVE_LITERAL);
		bus.setZ(new Complex(0.0, 1.0e10), SequenceCode.NEGATIVE_LITERAL);
		bus.setZ(new Complex(0.0, 1.0e10), SequenceCode.ZERO_LITERAL);
		simuCtx.getAcscFaultNet().addBus(bus);
	}

	// format: busId,baseVoltage,r1_PU,x1_PU,r2_PU,x2_PU,r0_PU,x0_PU,groundCode(Ungrounded/ZGrounded/SolidGrounded),rg_Ohms,xg_Ohms
	public void addScContributeBus(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		busId = st.nextToken();
		double baseVolt = new Double(st.nextToken()).doubleValue();
		double r1 = new Double(st.nextToken()).doubleValue();
		double x1 = new Double(st.nextToken()).doubleValue();
		double r2 = new Double(st.nextToken()).doubleValue();
		double x2 = new Double(st.nextToken()).doubleValue();
		double r0 = new Double(st.nextToken()).doubleValue();
		double x0 = new Double(st.nextToken()).doubleValue();
		String gCode = st.nextToken();
		double rg = new Double(st.nextToken()).doubleValue();
		double xg = new Double(st.nextToken()).doubleValue();

		AcscBus bus = CoreObjectFactory.createAcscBus(busId);
		bus.setScCode(BusScCode.CONTRIBUTE_LITERAL);
		bus.setBaseVoltage(baseVolt, UnitType.Volt );
		bus.setZ(new Complex(r1, x1), SequenceCode.POSITIVE_LITERAL, UnitType.PU, simuCtx.getAcscFaultNet().getBaseKva());
		bus.setZ(new Complex(r2, x2), SequenceCode.NEGATIVE_LITERAL, UnitType.PU, simuCtx.getAcscFaultNet().getBaseKva());
		bus.setZ(new Complex(r0, x0), SequenceCode.ZERO_LITERAL, UnitType.PU, simuCtx.getAcscFaultNet().getBaseKva());
		ScGroundType type = new ScGroundType();
		type.setCode(gCode);
		type.setZ(new Complex(rg,xg), UnitType.Ohm, baseVolt, simuCtx.getAcscFaultNet().getBaseKva());
		bus.setGrounding(type);
		simuCtx.getAcscFaultNet().addBus(bus);		
	}

	/*
	 * Add branch
	 */
	
	// format: fromBusId,toBusId,r1_PU,x1_PU,r0_PU,x0_PU
	public void addAcscLineBranch(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		branchFromBusId = st.nextToken();
		branchToBusId = st.nextToken();
		double r1 = new Double(st.nextToken()).doubleValue();
		double x1 = new Double(st.nextToken()).doubleValue();
		double r0 = new Double(st.nextToken()).doubleValue();
		double x0 = new Double(st.nextToken()).doubleValue();
		
		AcscBranch branch = CoreObjectFactory.createAcscBranch();
		branch.setBranchCode(AclfBranchCode.LINE_LITERAL);
		branch.setZ( new Complex(r1,x1), msg );
		branch.setZ0( new Complex(r0,x0), msg );
		simuCtx.getAcscFaultNet().addBranch(branch, branchFromBusId, branchToBusId);
	}

	// format: fromBusId,toBusId,r1_PU,x1_PU,r0_PU,x0_PU,fromConnectCode(Delta/WyeUngrounded/WyeSolidGrounded/WyeZGrounded),fromRg_Ohm,fromXg_Ohm,toConnectCode(fromConnectCode),toRg_Ohm,toXg_Ohm,
	public void addAcscXformerBranch(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		branchFromBusId = st.nextToken();
		branchToBusId = st.nextToken();
		double r1 = new Double(st.nextToken()).doubleValue();
		double x1 = new Double(st.nextToken()).doubleValue();
		double r0 = new Double(st.nextToken()).doubleValue();
		double x0 = new Double(st.nextToken()).doubleValue();
		XfrConnectCode fromConCode = getXfrConnectCode(st.nextToken());
		double fromRg = new Double(st.nextToken()).doubleValue();
		double fromXg = new Double(st.nextToken()).doubleValue();
		XfrConnectCode toConCode = getXfrConnectCode(st.nextToken());
		double toRg = new Double(st.nextToken()).doubleValue();
		double toXg = new Double(st.nextToken()).doubleValue();
		
		AcscBranch branch = CoreObjectFactory.createAcscBranch();
		branch.setBranchCode(AclfBranchCode.XFORMER_LITERAL);
		simuCtx.getAcscFaultNet().addBranch(branch, branchFromBusId, branchToBusId);
		branch.setZ( new Complex(r1,x1), msg  );
		branch.setZ0( new Complex(r0,x0), msg  );
		AcscXfrAdapter xfr = (AcscXfrAdapter)branch.adapt(AcscXfrAdapter.class);
		xfr.setFromConnectGroundZ(fromConCode, new Complex(fromRg,fromXg), UnitType.Ohm, simuCtx.getAcscFaultNet().getBaseKva());
		xfr.setToConnectGroundZ(toConCode, new Complex(toRg,toXg), UnitType.Ohm, simuCtx.getAcscFaultNet().getBaseKva());
	}
	
	// format: fromBusId,toBusId,r1_PU,x1_PU,angle_Deg,r0_PU,x0_PU,fromConnectCode(Delta/WyeUngrounded/WyeSolidGrounded/WyeZGrounded),fromRg_Ohm,fromXg_Ohm,toConnectCode(fromConnectCode),toRg_Ohm,toXg_Ohm,
	public void addAcscPSXfromerBranch(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		branchFromBusId = st.nextToken();
		branchToBusId = st.nextToken();
		double r1 = new Double(st.nextToken()).doubleValue();
		double x1 = new Double(st.nextToken()).doubleValue();
		double angDeg = new Double(st.nextToken()).doubleValue();
		double r0 = new Double(st.nextToken()).doubleValue();
		double x0 = new Double(st.nextToken()).doubleValue();
		XfrConnectCode fromConCode = getXfrConnectCode(st.nextToken());
		double fromRg = new Double(st.nextToken()).doubleValue();
		double fromXg = new Double(st.nextToken()).doubleValue();
		XfrConnectCode toConCode = getXfrConnectCode(st.nextToken());
		double toRg = new Double(st.nextToken()).doubleValue();
		double toXg = new Double(st.nextToken()).doubleValue();
		
		AcscBranch branch = CoreObjectFactory.createAcscBranch();
		branch.setBranchCode(AclfBranchCode.XFORMER_LITERAL);
		simuCtx.getAcscFaultNet().addBranch(branch, branchFromBusId, branchToBusId);
		branch.setZ( new Complex(r1,x1), msg  );
		branch.setZ0( new Complex(r0,x0), msg  );
		AcscPSXfrAdapter xfr = (AcscPSXfrAdapter)branch.adapt(AcscPSXfrAdapter.class);
		xfr.setFromAngle(angDeg, UnitType.Deg);
		xfr.setFromConnectGroundZ(fromConCode, new Complex(fromRg,fromXg), UnitType.Ohm, simuCtx.getAcscFaultNet().getBaseKva());
		xfr.setToConnectGroundZ(toConCode, new Complex(toRg,toXg), UnitType.Ohm, simuCtx.getAcscFaultNet().getBaseKva());
	}

	/*
	 * Check results
	 */
	
	public double faultAmpPhaseAreal() {
		return formatDouble(acscFault.getFaultResult().getSCCurrent_abc().a_0.getReal());
	}
	
	public double faultAmpPhaseAimage() {
		return formatDouble(acscFault.getFaultResult().getSCCurrent_abc().a_0.getImaginary());
	}

	public double faultAmpPhaseBreal() {
		return formatDouble(acscFault.getFaultResult().getSCCurrent_abc().b_1.getReal());
	}
	
	public double faultAmpPhaseBimage() {
		return formatDouble(acscFault.getFaultResult().getSCCurrent_abc().b_1.getImaginary());
	}

	public double faultAmpPhaseCreal() {
		return formatDouble(acscFault.getFaultResult().getSCCurrent_abc().c_2.getReal());
	}
	
	public double faultAmpPhaseCimage() {
		return formatDouble(acscFault.getFaultResult().getSCCurrent_abc().c_2.getImaginary());
	}

	public double faultAmpPhase0real() {
		return formatDouble(acscFault.getFaultResult().getSCCurrent_012().a_0.getReal());
	}
	
	public double faultAmpPhase0image() {
		return formatDouble(acscFault.getFaultResult().getSCCurrent_012().a_0.getImaginary());
	}

	public double faultAmpPhase1real() {
		return formatDouble(acscFault.getFaultResult().getSCCurrent_012().b_1.getReal());
	}
	
	public double faultAmpPhase1image() {
		return formatDouble(acscFault.getFaultResult().getSCCurrent_012().b_1.getImaginary());
	}

	public double faultAmpPhase2real() {
		return formatDouble(acscFault.getFaultResult().getSCCurrent_012().c_2.getReal());
	}
	
	public double faultAmpPhase2image() {
		return formatDouble(acscFault.getFaultResult().getSCCurrent_012().c_2.getImaginary());
	}

	/*
	 * private functions
	 */
	
	private XfrConnectCode getXfrConnectCode(String code) {
		if ("WyeUngrounded".equals(code))
			return XfrConnectCode.WYE_UNGROUNDED_LITERAL;
		else if ("WyeSolidGrounded".equals(code))
			return XfrConnectCode.WYE_SOLID_GROUNDED_LITERAL;
		else if ("WyeZGrounded".equals(code))
			return XfrConnectCode.WYE_ZGROUNDED_LITERAL;
		else
			return XfrConnectCode.DELTA_LITERAL;
	}

	private SimpleFaultCode getFaultCode(String code) {
		if ("3P".equals(code))
			return SimpleFaultCode.GROUND_3P_LITERAL;
		else if ("LG".equals(code))
			return SimpleFaultCode.GROUND_LG_LITERAL;
		else if ("LLG".equals(code))
			return SimpleFaultCode.GROUND_LLG_LITERAL;
		else
			return SimpleFaultCode.GROUND_LL_LITERAL;
	}
}
