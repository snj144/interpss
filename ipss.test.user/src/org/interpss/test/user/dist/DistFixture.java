 /*
  * @(#)DistFixture.java   
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

package org.interpss.test.user.dist;

import java.util.StringTokenizer;

import org.apache.commons.math.complex.Complex;
import org.interpss.test.user.IpssFixture;
import org.interpss.test.user.core.AclfFixture;
import org.interpss.test.user.core.AcscFixture;

import com.interpss.common.datatype.UnitType;
import com.interpss.common.exp.InterpssRuntimeException;
import com.interpss.core.util.CoreUtilFunc;
import com.interpss.dist.BreakerAdapter;
import com.interpss.dist.DistBranch;
import com.interpss.dist.DistBranchCode;
import com.interpss.dist.DistBus;
import com.interpss.dist.DistBusCode;
import com.interpss.dist.DistObjectFactory;
import com.interpss.dist.FeederAdapter;
import com.interpss.dist.GeneratorAdapter;
import com.interpss.dist.IndMotorAdapter;
import com.interpss.dist.MixedLoadAdapter;
import com.interpss.dist.MotorAdapter;
import com.interpss.dist.SynMotorAdapter;
import com.interpss.dist.TransformConnectCode;
import com.interpss.dist.TransformerAdapter;
import com.interpss.dist.UtilityAdapter;
import com.interpss.simu.SimuSpringAppContext;

public class DistFixture extends IpssFixture {
	public void createDistNetwork() {
		simuCtx = SimuSpringAppContext.getSimuContextTypeDist();
	}	
	
	public void outputDistDebugInfo() {
		System.out.println(simuCtx.getDistNet().net2String());
		System.out.println(simuCtx.getDistNet().getFaultNet().net2String());
	}

	public void initAcscNetData() {
		simuCtx.getDistNet().createAcscNetData(msg);
		simuCtx.getDistNet().getFaultNet().setLfDataLoaded(true);
		simuCtx.getDistNet().getFaultNet().setScDataLoaded(true);
	}	
	
	/*
	 * Run Aclf analysi
	 */
	public void runDistLoadFlow() {
		simuCtx.getDistNet().setNameplateAclfNetData(msg);
		AclfFixture fixture = new AclfFixture();
		fixture.runAcLoadFlow();	  	
	}
	
	public boolean lfConverged() {
		AclfFixture fixture = new AclfFixture();
		return fixture.lfConverged();
	}

	/*
	 * Run Acsc Analysis
	 */
	
	public void runAcShortCircuit() {
		AcscFixture fixture = new AcscFixture();
		fixture.runAcShortCircuit();
	}
	
	/*
	 * Define fault
	 */
	
	// format: busId,faultType(3P/LG/LLG/LL)
	public void setAcscBusFault(String data) {
		AcscFixture fixture = new AcscFixture();
		fixture.setAcscBusFault(data);
	}
	
	// format: busId,faultType(3P/LG/LLG/LL),rLG_PU,xLG_PU,rLL_PU,xLL_PU
	public void setAcscBusFaultWithZ(String data) {
		AcscFixture fixture = new AcscFixture();
		fixture.setAcscBusFaultWithZ(data);
	}
	
	// format: busId,faultType(3P/LG/LLG/LL),distance(%fromBus)
	public void setAcscBranchFault(String data) {
		AcscFixture fixture = new AcscFixture();
		fixture.setAcscBranchFault(data);
	}
	
	// format: busId,faultType(3P/LG/LLG/LL),distance(%fromBus),rLG_PU,xLG_PU,rLL_PU,xLL_PU
	public void setAcscBranchFaultWithZ(String data) {
		AcscFixture fixture = new AcscFixture();
		fixture.setAcscBranchFaultWithZ(data);
	}

	
	/*
	 * Check Aclf results
	 */
	public double busVoltage() throws Exception {
		AclfFixture fixture = new AclfFixture();
		return fixture.busVoltage();
	}

	public double busAngle() throws Exception {
		AclfFixture fixture = new AclfFixture();
		return fixture.busAngle();
	}

	public double busLoadP() throws Exception {
		AclfFixture fixture = new AclfFixture();
		return fixture.busLoadP();
	}

	public double busLoadQ() throws Exception {
		AclfFixture fixture = new AclfFixture();
		return fixture.busLoadQ();
	}

	public double busGenP() throws Exception {
		AclfFixture fixture = new AclfFixture();
		return fixture.busGenP();
	}

	public double busGenQ() throws Exception {
		AclfFixture fixture = new AclfFixture();
		return fixture.busGenQ();
	}
	
	public double branchFrom2ToP() throws Exception {
		AclfFixture fixture = new AclfFixture();
		return fixture.branchFrom2ToP();
	}

	public double branchFrom2ToQ() throws Exception {
		AclfFixture fixture = new AclfFixture();
		return fixture.branchFrom2ToQ();
	}

	public double branchTo2FromP() throws Exception {
		AclfFixture fixture = new AclfFixture();
		return fixture.branchTo2FromP();
	}

	public double branchTo2FromQ() throws Exception {
		AclfFixture fixture = new AclfFixture();
		return fixture.branchTo2FromQ();
	}
	
	/*
	 * Check Acsc results
	 */
	public double faultAmpPhaseAreal() {
		AcscFixture fixture = new AcscFixture();
		return fixture.faultAmpPhaseAreal();
	}
	
	public double faultAmpPhaseAimage() {
		AcscFixture fixture = new AcscFixture();
		return fixture.faultAmpPhaseAimage();
	}

	public double faultAmpPhaseBreal() {
		AcscFixture fixture = new AcscFixture();
		return fixture.faultAmpPhaseBreal();
	}
	
	public double faultAmpPhaseBimage() {
		AcscFixture fixture = new AcscFixture();
		return fixture.faultAmpPhaseBimage();
	}

	public double faultAmpPhaseCreal() {
		AcscFixture fixture = new AcscFixture();
		return fixture.faultAmpPhaseCreal();
	}
	
	public double faultAmpPhaseCimage() {
		AcscFixture fixture = new AcscFixture();
		return fixture.faultAmpPhaseCimage();
	}

	public double faultAmpPhase0real() {
		AcscFixture fixture = new AcscFixture();
		return fixture.faultAmpPhase0real();
	}
	
	public double faultAmpPhase0image() {
		AcscFixture fixture = new AcscFixture();
		return fixture.faultAmpPhase0image();
	}

	public double faultAmpPhase1real() {
		AcscFixture fixture = new AcscFixture();
		return fixture.faultAmpPhase1real();
	}
	
	public double faultAmpPhase1image() {
		AcscFixture fixture = new AcscFixture();
		return fixture.faultAmpPhase1image();
	}

	public double faultAmpPhase2real() {
		AcscFixture fixture = new AcscFixture();
		return fixture.faultAmpPhase2real();
	}
	
	public double faultAmpPhase2image() {
		AcscFixture fixture = new AcscFixture();
		return fixture.faultAmpPhase2image();
	}
	
	/*
	 * Bus input function
	 */
	
	// format: busId,busCode(Utility/Generator/SynMotor/IndMotor/MixedLoad/Non-Contribute),baseVoltage
	public void addDistBus(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		busId = st.nextToken();
		DistBusCode busCode = getDistBusCode(st.nextToken());
		double baseVolt = new Double(st.nextToken()).doubleValue();
		
  		DistBus bus = DistObjectFactory.createDistBus();
  		bus.setId(busId);
  		bus.setAttributes(busId, "");
  		bus.setBaseVoltage(baseVolt);
		bus.setBusCode(busCode);
  		simuCtx.getDistNet().addBus(bus);
  	}

	// format: busId,voltMag_PU,voltAng_Deg,3PMvaRating_mva,3P_XoverR,1PMvaRating_mva,1P_XoverR,groundCode(Ungrounded/ZGrounded/SolidGrounded),rG_Ohm,xG_Ohm
	public void setUtilityBusData(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		busId = st.nextToken();
		double voltMag = new Double(st.nextToken()).doubleValue();
		double voltAng = new Double(st.nextToken()).doubleValue();
		double mvaRating3P = new Double(st.nextToken()).doubleValue();
		double x_r3P = new Double(st.nextToken()).doubleValue();
		double mvaRating1P = new Double(st.nextToken()).doubleValue();
		double x_r1P = new Double(st.nextToken()).doubleValue();
		String gCode = st.nextToken(); 
		double gR = new Double(st.nextToken()).doubleValue();
		double gX = new Double(st.nextToken()).doubleValue();
		
		DistBus bus = (DistBus)simuCtx.getDistNet().getBus(busId);
		UtilityAdapter ut = (UtilityAdapter)bus.adapt(UtilityAdapter.class);
		ut.setVoltage(voltMag, "PU", voltAng, "Deg");
		ut.setMvaRating(mvaRating3P, mvaRating1P, "MVA");
		ut.setX_R(x_r3P, x_r1P);
		ut.getGrounding().setCode(CoreUtilFunc.scGroundType2BusGroundCode(gCode));
		ut.getGrounding().setZ(new Complex(gR,gX), UnitType.Ohm, bus.getBaseVoltage(), simuCtx.getDistNet().getBaseKva());
	}
	
	// format: busId,ratedKW,ratingUnit(Kva,KW,Mva,MW),ratedV_PU,loading_%,pfactor_PU,r1_PU,x1_PU,r0_PU,x0_PU,r2_PU,x2_PU,groundCode(Ungrounded/ZGrounded/SolidGrounded),rG_Ohm,xG_Ohm
	public void setGeneratorBusData(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		busId = st.nextToken();
		double ratedKW = new Double(st.nextToken()).doubleValue();
		String ratingUnit = st.nextToken();
		double ratedV = new Double(st.nextToken()).doubleValue();
		double loading = new Double(st.nextToken()).doubleValue();
		double pf = new Double(st.nextToken()).doubleValue();
		double r1 = new Double(st.nextToken()).doubleValue();
		double x1 = new Double(st.nextToken()).doubleValue();
		double r0 = new Double(st.nextToken()).doubleValue();
		double x0 = new Double(st.nextToken()).doubleValue();
		double r2 = new Double(st.nextToken()).doubleValue();
		double x2 = new Double(st.nextToken()).doubleValue();
		String gCode = st.nextToken(); 
		double gR = new Double(st.nextToken()).doubleValue();
		double gX = new Double(st.nextToken()).doubleValue();		
		
		DistBus bus = (DistBus)simuCtx.getDistNet().getBus(busId);
		GeneratorAdapter gen = (GeneratorAdapter)bus.adapt(GeneratorAdapter.class);
		gen.setRatedKW(ratedKW, ratingUnit);
		gen.setLoading(loading);
		gen.setRatedVoltage(ratedV, "PU");
		gen.setPFactor(pf, "PU");
		gen.setZ1(new Complex(r1,x1));
		gen.setZ0_2(new Complex(r0,x0), new Complex(r2,x2));
		gen.setZUnit("PU");
		gen.getGrounding().setCode(CoreUtilFunc.scGroundType2BusGroundCode(gCode));
		gen.getGrounding().setZ(new Complex(gR,gX), UnitType.Ohm, bus.getBaseVoltage(), simuCtx.getDistNet().getBaseKva());
	}

	// format: busId,ratedHP,ratingUnit(HP,KW),eff_%,loading_%,pfactor_PU,r1_PU,x1_PU,r0_PU,x0_PU,r2_PU,x2_PU,groundCode(Ungrounded/ZGrounded/SolidGrounded),rG_Ohm,xG_Ohm
	public void setMotorBusData(String data, MotorAdapter mot, double baseV) {
		StringTokenizer st = new StringTokenizer(data, ",");
		busId = st.nextToken();
		double ratedHP = new Double(st.nextToken()).doubleValue();
		String ratingUnit = st.nextToken();
		double eff = new Double(st.nextToken()).doubleValue();
		double loading = new Double(st.nextToken()).doubleValue();
		double pf = new Double(st.nextToken()).doubleValue();
		double r1 = new Double(st.nextToken()).doubleValue();
		double x1 = new Double(st.nextToken()).doubleValue();
		double r0 = new Double(st.nextToken()).doubleValue();
		double x0 = new Double(st.nextToken()).doubleValue();
		double r2 = new Double(st.nextToken()).doubleValue();
		double x2 = new Double(st.nextToken()).doubleValue();
		String gCode = st.nextToken(); 
		double gR = new Double(st.nextToken()).doubleValue();
		double gX = new Double(st.nextToken()).doubleValue();		
		
		mot.setRatedHP(ratedHP, ratingUnit);
		mot.setEffLoading(eff, loading);
		mot.setPFactor(pf, "PU");
		mot.setZ1(new Complex(r1,x1));
		mot.setZ0_2(new Complex(r0,x0), new Complex(r2,x2));
		mot.setZUnit("PU");
		mot.getGrounding().setCode(CoreUtilFunc.scGroundType2BusGroundCode(gCode));
		mot.getGrounding().setZ(new Complex(gR,gX), UnitType.Ohm, baseV, simuCtx.getDistNet().getBaseKva());
}

	public void setSynMotorBusData(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		busId = st.nextToken();
		DistBus bus = (DistBus)simuCtx.getDistNet().getBus(busId);
		SynMotorAdapter mot = (SynMotorAdapter)bus.adapt(SynMotorAdapter.class);
		setMotorBusData(data, mot, bus.getBaseVoltage());
	}

	public void setIndMotorBusData(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		busId = st.nextToken();
		DistBus bus = (DistBus)simuCtx.getDistNet().getBus(busId);
		IndMotorAdapter mot = (IndMotorAdapter)bus.adapt(IndMotorAdapter.class);
		setMotorBusData(data, mot, bus.getBaseVoltage());
	}

	// format: busId,totalKva,ratingUnit(Kva,Mva),motorPercent_%,r1_PU,x1_PU,r0_PU,x0_PU,r2_PU,x2_PU,groundCode(Ungrounded/ZGrounded/SolidGrounded),rG_Ohm,xG_Ohm
	public void setMixLoadBusData(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		busId = st.nextToken();
		double totalKva = new Double(st.nextToken()).doubleValue();
		String ratingUnit = st.nextToken();
		double motorPercent = new Double(st.nextToken()).doubleValue();
		double r1 = new Double(st.nextToken()).doubleValue();
		double x1 = new Double(st.nextToken()).doubleValue();
		double r0 = new Double(st.nextToken()).doubleValue();
		double x0 = new Double(st.nextToken()).doubleValue();
		double r2 = new Double(st.nextToken()).doubleValue();
		double x2 = new Double(st.nextToken()).doubleValue();
		String gCode = st.nextToken(); 
		double gR = new Double(st.nextToken()).doubleValue();
		double gX = new Double(st.nextToken()).doubleValue();		
		
		DistBus bus = (DistBus)simuCtx.getDistNet().getBus(busId);
		MixedLoadAdapter mload = (MixedLoadAdapter)bus.adapt(MixedLoadAdapter.class);
		mload.setTotalKva(totalKva, ratingUnit);
		mload.setMotorPercent(motorPercent);		
		mload.setZ1(new Complex(r1,x1));
		mload.setZ0_2(new Complex(r0,x0), new Complex(r2,x2));
		mload.setZUnit("PU");
		mload.getGrounding().setCode(CoreUtilFunc.scGroundType2BusGroundCode(gCode));
		mload.getGrounding().setZ(new Complex(gR,gX), UnitType.Ohm, bus.getBaseVoltage(), simuCtx.getDistNet().getBaseKva());
}
	
	/*
	 * Branch input function 
	 */
	
	// format: branchFromBusId,branchToBusId,branchCode(Feeder/Breaker/Xformer/3WXformer)
	public void addDistBranch(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		branchFromBusId = st.nextToken();
		branchToBusId = st.nextToken();
		DistBranchCode branchCode = getDistBranchCode(st.nextToken());
		
  		DistBranch branch = DistObjectFactory.createDistBranch();
  		simuCtx.getDistNet().addBranch(branch, branchFromBusId, branchToBusId);
  		branch.setBranchCode(branchCode);
  	}
	
	// format: branchFromBusId,branchToBusId,length,r1,x1(ohm/1000),halfB1(microMhos/1000),r0,x0,halfB0
	public void setFeederBranchData(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		branchFromBusId = st.nextToken();
		branchToBusId = st.nextToken();
		double length = new Double(st.nextToken()).doubleValue();
		double r1 = new Double(st.nextToken()).doubleValue();
		double x1 = new Double(st.nextToken()).doubleValue();
		double b1 = new Double(st.nextToken()).doubleValue();
		double r0 = new Double(st.nextToken()).doubleValue();
		double x0 = new Double(st.nextToken()).doubleValue();
		double b0 = new Double(st.nextToken()).doubleValue();
		
		DistBranch branch = (DistBranch)simuCtx.getDistNet().getBranch(branchFromBusId, branchToBusId);
		FeederAdapter feeder = (FeederAdapter)branch.adapt(FeederAdapter.class);
		feeder.setLength(length, "M");
		feeder.setZ(new Complex(r1,x1), new Complex(r0,x0), "Ohm");
		feeder.setHShuntB(b1, b0, "MicroMhos");
	}

	// format: branchFromBusId,branchToBusId,r_PU
	public void setBreakerBranchData(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		branchFromBusId = st.nextToken();
		branchToBusId = st.nextToken();
		double r = new Double(st.nextToken()).doubleValue();
		
		DistBranch branch = (DistBranch)simuCtx.getDistNet().getBranch(branchFromBusId, branchToBusId);
		BreakerAdapter breaker = (BreakerAdapter)branch.adapt(BreakerAdapter.class);
		breaker.setR(r, "PU");
	}

	// format: branchPrimaryBusId,branchSecondaryBusId,rating,ratingUnit(Kva,Mva),primaryRatedV_pu,sendaryRatedV_pu,r1,x1,r0,x0,primaryTurnRatio_pu,secondaryTurnRatio_pu
	public void setXformerBranchData(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		branchFromBusId = st.nextToken();
		branchToBusId = st.nextToken();
		double rating = new Double(st.nextToken()).doubleValue();
		String ratingUnit = st.nextToken();
		double priRatedV = new Double(st.nextToken()).doubleValue();
		double senRatedV = new Double(st.nextToken()).doubleValue();
		double r1 = new Double(st.nextToken()).doubleValue();
		double x1 = new Double(st.nextToken()).doubleValue();
		double r0 = new Double(st.nextToken()).doubleValue();
		double x0 = new Double(st.nextToken()).doubleValue();
		double priTap = new Double(st.nextToken()).doubleValue();
		double secTap = new Double(st.nextToken()).doubleValue();
		
		DistBranch branch = (DistBranch)simuCtx.getDistNet().getBranch(branchFromBusId, branchToBusId);
		TransformerAdapter xfr = (TransformerAdapter)branch.adapt(TransformerAdapter.class);
		xfr.setRating(rating, ratingUnit);
		xfr.setRatedVoltage(priRatedV, senRatedV, "PU");
		xfr.setZ(new Complex(r1,x1), new Complex(r0,x0), "PU");
		xfr.setTap(priTap, secTap, "PU");
	}
	
	// format: branchPrimaryBusId,branchSecondaryBusId,primaryConnCode(Delta/Wye),groundCode(Ungrounded/ZGrounded/SolidGrounded),rG_Ohm,xG_Ohm,secondaryConnCode(Delta/Wye),groundCode(Ungrounded/ZGrounded/SolidGrounded),rG_Ohm,xG_Ohm
	public void setXformerGroundingData(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		branchFromBusId = st.nextToken();
		branchToBusId = st.nextToken();
		String priConnCode = st.nextToken();
		String priGCode = st.nextToken(); 
		double priGR = new Double(st.nextToken()).doubleValue();
		double priGX = new Double(st.nextToken()).doubleValue();
		String secConnCode = st.nextToken();
		String secGCode = st.nextToken(); 
		double secGR = new Double(st.nextToken()).doubleValue();
		double secGX = new Double(st.nextToken()).doubleValue();
		
		DistBranch branch = (DistBranch)simuCtx.getDistNet().getBranch(branchFromBusId, branchToBusId);
		TransformerAdapter xfr = (TransformerAdapter)branch.adapt(TransformerAdapter.class);
		xfr.setConnect(getXfrConnCode(priConnCode), getXfrConnCode(secConnCode));
		double fromBaseV = simuCtx.getDistNet().getBus(branchFromBusId).getBaseVoltage();
		double toBaseV = simuCtx.getDistNet().getBus(branchToBusId).getBaseVoltage();
		xfr.getPrimaryGrounding().setCode(CoreUtilFunc.scGroundType2BusGroundCode(priGCode));
		xfr.getPrimaryGrounding().setZ(new Complex(priGR,priGX), UnitType.Ohm, fromBaseV, simuCtx.getDistNet().getBaseKva());
		xfr.getSecondaryGrounding().setCode(CoreUtilFunc.scGroundType2BusGroundCode(secGCode));
		xfr.getSecondaryGrounding().setZ(new Complex(secGR,secGX), UnitType.Ohm, toBaseV, simuCtx.getDistNet().getBaseKva());
	}

	public void set3WXformerBranchData(String data) {
		throw new InterpssRuntimeException("function not implemented");
	}
	
	/*
	 * private functions
	 */
	
	private TransformConnectCode getXfrConnCode(String code) {
		if ("Wye".equals(code))
			return TransformConnectCode.WYE;
		else
			return TransformConnectCode.DELTA;
	}
	private DistBusCode getDistBusCode(String code) {
		if ("Utility".equals(code))
			return DistBusCode.UTILITY;
		else if ("Generator".equals(code))
			return DistBusCode.GENERATOR;
		else if ("SynMotor".equals(code))
			return DistBusCode.SYN_MOTOR;
		else if ("IndMotor".equals(code))
			return DistBusCode.IND_MOTOR;
		else if ("MixedLoad".equals(code))
			return DistBusCode.MIXED_LOAD;
		else
			return DistBusCode.NON_CONTRIBUTE;
	}

	private DistBranchCode getDistBranchCode(String code) {
		if ("Feeder".equals(code))
			return DistBranchCode.FEEDER;
		else if ("Xformer".equals(code))
			return DistBranchCode.TRANSFROMER;
		else if ("Breaker".equals(code))
			return DistBranchCode.BREAKER;
		else
			return DistBranchCode.W3_TRANSFORMER;
	}
}
