package com.interpss.test.user.core;

import java.util.StringTokenizer;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.datatype.UnitType;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBranchCode;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfGenCode;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.CapacitorBusAdapter;
import com.interpss.core.aclf.LineAdapter;
import com.interpss.core.aclf.LoadBusAdapter;
import com.interpss.core.aclf.PQBusAdapter;
import com.interpss.core.aclf.PSXfrAdapter;
import com.interpss.core.aclf.PVBusAdapter;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.aclf.XfrAdapter;
import com.interpss.simu.SimuSpringAppContext;

public class AclfBuildFixture extends AclfFixture {
	
	public void createAclfNetwork() {
		simuCtx = SimuSpringAppContext.getSimuContextTypeAclfAdj();
	}
	
	// format: busId,baseVoltage,voltMag_PU,voltAng_Deg,loadP_PU,loadQ_PU
	public void addSwingBus(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		busId = st.nextToken();
		double baseVolt = new Double(st.nextToken()).doubleValue();
		double voltMag = new Double(st.nextToken()).doubleValue();
		double voltAng = new Double(st.nextToken()).doubleValue();
		double loadP = new Double(st.nextToken()).doubleValue();
		double loadQ = new Double(st.nextToken()).doubleValue();
		
  		AclfBus bus = CoreObjectFactory.createAclfBus(busId);
  		bus.setAttributes(busId, "");
  		bus.setBaseVoltage(baseVolt);
  		bus.setGenCode(AclfGenCode.SWING_LITERAL);
  		bus.setLoadCode(AclfLoadCode.CONST_P_LITERAL);
  		SwingBusAdapter swingBus = (SwingBusAdapter)bus.adapt(SwingBusAdapter.class);
  		swingBus.setVoltMag(voltMag, UnitType.PU);
  		swingBus.setVoltAng(voltAng, UnitType.Deg);
  		swingBus.setLoad(new Complex(loadP, loadQ), UnitType.PU, simuCtx.getAclfNet().getBaseKva());
  		simuCtx.getAclfNet().addBus(bus);
  	}

	// format: busId,baseVoltage,genP_PU,genVolt_PU,loadP_PU,loadQ_PU
	public void addPVBus(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		busId = st.nextToken();
		double baseVolt = new Double(st.nextToken()).doubleValue();
		double genP = new Double(st.nextToken()).doubleValue();
		double genVolt = new Double(st.nextToken()).doubleValue();
		double loadP = new Double(st.nextToken()).doubleValue();
		double loadQ = new Double(st.nextToken()).doubleValue();

		AclfBus bus = CoreObjectFactory.createAclfBus(busId);
  		bus.setAttributes(busId, "");
  		bus.setBaseVoltage(baseVolt);
  		bus.setGenCode(AclfGenCode.GEN_PV_LITERAL);
  		bus.setLoadCode(AclfLoadCode.CONST_P_LITERAL);
  		PVBusAdapter pvBus = (PVBusAdapter)bus.adapt(PVBusAdapter.class);
  		pvBus.setGenP(genP, UnitType.PU, simuCtx.getAclfNet().getBaseKva());
  		pvBus.setVoltMag(genVolt, UnitType.PU);
  		pvBus.setLoad(new Complex(loadP, loadQ), UnitType.PU, simuCtx.getAclfNet().getBaseKva());
  		simuCtx.getAclfNet().addBus(bus);
  	}
	
	// format: busId,baseVoltage,capQ_PU,loadP_PU,loadQ_PU
	public void addCapacitorBus(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		busId = st.nextToken();
		double baseVolt = new Double(st.nextToken()).doubleValue();
		double capQ = new Double(st.nextToken()).doubleValue();
		double loadP = new Double(st.nextToken()).doubleValue();
		double loadQ = new Double(st.nextToken()).doubleValue();

		AclfBus bus = CoreObjectFactory.createAclfBus(busId);
  		bus.setAttributes(busId, "");
  		bus.setBaseVoltage(baseVolt);
  		bus.setGenCode(AclfGenCode.CAPACITOR_LITERAL);
  		bus.setLoadCode(AclfLoadCode.CONST_P_LITERAL);
  		CapacitorBusAdapter capBus = (CapacitorBusAdapter)bus.adapt(CapacitorBusAdapter.class);
  		capBus.setQ(capQ, UnitType.PU, simuCtx.getAclfNet().getBaseKva());
  		capBus.setLoad(new Complex(loadP, loadQ), UnitType.PU, simuCtx.getAclfNet().getBaseKva());
  		simuCtx.getAclfNet().addBus(bus);
  	}	

	// format: busId,baseVoltage,genP_PU,genQ_PU,loadP_PU,loadQ_PU
	public void addPQBus(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		busId = st.nextToken();
		double baseVolt = new Double(st.nextToken()).doubleValue();
		double genP = new Double(st.nextToken()).doubleValue();
		double genQ = new Double(st.nextToken()).doubleValue();
		double loadP = new Double(st.nextToken()).doubleValue();
		double loadQ = new Double(st.nextToken()).doubleValue();

		AclfBus bus = CoreObjectFactory.createAclfBus(busId);
  		bus.setAttributes(busId, "");
  		bus.setBaseVoltage(baseVolt);
  		bus.setGenCode(AclfGenCode.GEN_PQ_LITERAL);
  		bus.setLoadCode(AclfLoadCode.CONST_P_LITERAL);
  		PQBusAdapter pqBus = (PQBusAdapter)bus.adapt(PQBusAdapter.class);
  		pqBus.setGen(new Complex(genP, genQ), UnitType.PU, simuCtx.getAclfNet().getBaseKva());
  		pqBus.setLoad(new Complex(loadP, loadQ), UnitType.PU, simuCtx.getAclfNet().getBaseKva());
  		simuCtx.getAclfNet().addBus(bus);
  	}

	// format: busId,baseVoltage
	public void addNonGenNonLoadBus(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		busId = st.nextToken();
		double baseVolt = new Double(st.nextToken()).doubleValue();

		AclfBus bus = CoreObjectFactory.createAclfBus(busId);
  		bus.setAttributes(busId, "");
  		bus.setBaseVoltage(baseVolt);
  		bus.setGenCode(AclfGenCode.NON_GEN_LITERAL);
  		bus.setLoadCode(AclfLoadCode.NON_LOAD_LITERAL);
  		simuCtx.getAclfNet().addBus(bus);
  	}
	
	// format: busId,baseVoltage,loadP_PU,loadQ_PU
	public void addLoadBus(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		busId = st.nextToken();
		double baseVolt = new Double(st.nextToken()).doubleValue();
		double loadP = new Double(st.nextToken()).doubleValue();
		double loadQ = new Double(st.nextToken()).doubleValue();

		AclfBus bus = CoreObjectFactory.createAclfBus(busId);
  		bus.setAttributes(busId, "");
  		bus.setBaseVoltage(baseVolt);
  		bus.setGenCode(AclfGenCode.NON_GEN_LITERAL);
  		bus.setLoadCode(AclfLoadCode.CONST_P_LITERAL);
  		LoadBusAdapter loadBus = (LoadBusAdapter)bus.adapt(LoadBusAdapter.class);
  		loadBus.setLoad(new Complex(loadP, loadQ), UnitType.PU, simuCtx.getAclfNet().getBaseKva());
  		simuCtx.getAclfNet().addBus(bus);
  	}

	// format: busId,baseVoltage,loadP_PU,loadQ_PU
	public void addLoadBusConstZ(String data) {
		addLoadBus(data);
		simuCtx.getAclfNet().getAclfBus(busId).setLoadCode(AclfLoadCode.CONST_Z_LITERAL);
  	}
	
	// format: busId,baseVoltage,loadP_PU,loadQ_PU
	public void addLoadBusConstI(String data) {
		addLoadBus(data);
		simuCtx.getAclfNet().getAclfBus(busId).setLoadCode(AclfLoadCode.CONST_I_LITERAL);
  	}

	// format: fromBusId,toBusId,r_PU,x_PU,halfB_PU
	public void addLineBranch(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		branchFromBusId = st.nextToken();
		branchToBusId = st.nextToken();
		double r = new Double(st.nextToken()).doubleValue();
		double x = new Double(st.nextToken()).doubleValue();
		double halfB = new Double(st.nextToken()).doubleValue();
		
		AclfBranch branch = CoreObjectFactory.createAclfBranch();
  		branch.setAttributes(branchFromBusId+"->"+branchToBusId, "", "1");
  		branch.setBranchCode(AclfBranchCode.LINE_LITERAL);
		LineAdapter lineBranch = (LineAdapter)branch.adapt(LineAdapter.class);
  		lineBranch.setZ(new Complex(r, x), UnitType.PU, 4000.0, simuCtx.getAclfNet().getBaseKva(), msg);
  		lineBranch.setHShuntY(new Complex(0.0, halfB), UnitType.PU, 4000.0, simuCtx.getAclfNet().getBaseKva());
  		simuCtx.getAclfNet().addBranch(branch, branchFromBusId, branchToBusId);		
	}
	
	// format: fromBusId,toBusId,r_PU,x_PU,fromTurnRatio_PU,toTurnRatio_PU
	public void addXformerBranch(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		branchFromBusId = st.nextToken();
		branchToBusId = st.nextToken();
		double r = new Double(st.nextToken()).doubleValue();
		double x = new Double(st.nextToken()).doubleValue();
		double fromRatio = new Double(st.nextToken()).doubleValue();
		double toRatio = new Double(st.nextToken()).doubleValue();
		
		AclfBranch bra = CoreObjectFactory.createAclfBranch();
		simuCtx.getAclfNet().addBranch(bra, branchFromBusId, branchToBusId);
		bra.setBranchCode(AclfBranchCode.XFORMER_LITERAL);
		XfrAdapter xfr = (XfrAdapter)bra.adapt(XfrAdapter.class);
		double baseV = bra.getFromAclfBus().getBaseVoltage() > bra.getToAclfBus().getBaseVoltage() ?
				           bra.getFromAclfBus().getBaseVoltage() : bra.getToAclfBus().getBaseVoltage();
		xfr.setZ(new Complex(r,x), UnitType.PU, baseV, simuCtx.getAclfNet().getBaseKva(), msg);
		xfr.setFromTurnRatio(fromRatio, UnitType.PU);
		xfr.setToTurnRatio(toRatio, UnitType.PU);		
	}

	// format: fromBusId,toBusId,r_PU,x_PU,fromTurnRatio_PU,toTurnRatio_PU,shiftAngle_Deg
	public void addPSXfrBranch(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		branchFromBusId = st.nextToken();
		branchToBusId = st.nextToken();
		double r = new Double(st.nextToken()).doubleValue();
		double x = new Double(st.nextToken()).doubleValue();
		double fromRatio = new Double(st.nextToken()).doubleValue();
		double toRatio = new Double(st.nextToken()).doubleValue();
		double angle = new Double(st.nextToken()).doubleValue();
		
		AclfBranch bra = CoreObjectFactory.createAclfBranch();
		simuCtx.getAclfNet().addBranch(bra, branchFromBusId, branchToBusId);
		bra.setBranchCode(AclfBranchCode.PS_XFORMER_LITERAL);
		PSXfrAdapter xfr = (PSXfrAdapter)bra.adapt(PSXfrAdapter.class);
		double baseV = bra.getFromAclfBus().getBaseVoltage() > bra.getToAclfBus().getBaseVoltage() ?
				           bra.getFromAclfBus().getBaseVoltage() : bra.getToAclfBus().getBaseVoltage();
		xfr.setZ(new Complex(r,x), UnitType.PU, baseV, simuCtx.getAclfNet().getBaseKva(), msg);
		xfr.setFromTurnRatio(fromRatio, UnitType.PU);
		xfr.setToTurnRatio(toRatio, UnitType.PU);	
		xfr.setAngle(angle, UnitType.Deg);
	}
}
