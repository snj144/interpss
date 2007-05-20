 /*
  * @(#)AclfBuildFixture.java   
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

import com.interpss.common.datatype.UnitType;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.CapacitorBusAdapter;
import com.interpss.core.aclf.PQBusAdapter;
import com.interpss.core.aclf.PVBusAdapter;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.util.input.AclfInputUtilFunc;
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
		
		AclfBus bus = AclfInputUtilFunc.addSwingBusTo(simuCtx.getAclfNet(), busId, baseVolt, 1, 1, 
				voltMag, UnitType.PU, voltAng, UnitType.Deg);
  		SwingBusAdapter swingBus = (SwingBusAdapter)bus.adapt(SwingBusAdapter.class);
  		bus.setLoadCode(AclfLoadCode.CONST_P_LITERAL);
  		swingBus.setLoad(new Complex(loadP, loadQ), UnitType.PU, simuCtx.getAclfNet().getBaseKva());
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

		AclfBus bus = AclfInputUtilFunc.addPVBusTo(simuCtx.getAclfNet(), busId, baseVolt, 1, 1, 
				genP, UnitType.PU, genVolt, UnitType.PU);
  		PVBusAdapter pvBus = (PVBusAdapter)bus.adapt(PVBusAdapter.class);
  		bus.setLoadCode(AclfLoadCode.CONST_P_LITERAL);
  		pvBus.setLoad(new Complex(loadP, loadQ), UnitType.PU, simuCtx.getAclfNet().getBaseKva());
  	}
	
	// format: busId,baseVoltage,capQ_PU,loadP_PU,loadQ_PU
	public void addCapacitorBus(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		busId = st.nextToken();
		double baseVolt = new Double(st.nextToken()).doubleValue();
		double capQ = new Double(st.nextToken()).doubleValue();
		double loadP = new Double(st.nextToken()).doubleValue();
		double loadQ = new Double(st.nextToken()).doubleValue();

		AclfBus bus = AclfInputUtilFunc.addCapacitorBusTo(simuCtx.getAclfNet(), busId, baseVolt, 1, 1, 
				capQ, UnitType.PU);
  		CapacitorBusAdapter capBus = (CapacitorBusAdapter)bus.adapt(CapacitorBusAdapter.class);
  		bus.setLoadCode(AclfLoadCode.CONST_P_LITERAL);
  		capBus.setLoad(new Complex(loadP, loadQ), UnitType.PU, simuCtx.getAclfNet().getBaseKva());
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

		AclfBus bus = AclfInputUtilFunc.addPQBusTo(simuCtx.getAclfNet(), busId, baseVolt, 1, 1, 
				genP, genQ, UnitType.PU);
  		PQBusAdapter pqBus = (PQBusAdapter)bus.adapt(PQBusAdapter.class);
  		bus.setLoadCode(AclfLoadCode.CONST_P_LITERAL);
  		pqBus.setLoad(new Complex(loadP, loadQ), UnitType.PU, simuCtx.getAclfNet().getBaseKva());
  	}

	// format: busId,baseVoltage
	public void addNonGenNonLoadBus(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		busId = st.nextToken();
		double baseVolt = new Double(st.nextToken()).doubleValue();

		AclfInputUtilFunc.addNonGenNonLoadBusTo(simuCtx.getAclfNet(), busId, baseVolt, 1, 1);
  	}
	
	// format: busId,baseVoltage,loadP_PU,loadQ_PU
	public void addLoadBus(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		busId = st.nextToken();
		double baseVolt = new Double(st.nextToken()).doubleValue();
		double loadP = new Double(st.nextToken()).doubleValue();
		double loadQ = new Double(st.nextToken()).doubleValue();

		AclfInputUtilFunc.addLoadBusTo(simuCtx.getAclfNet(), busId, baseVolt, 1, 1, 
				AclfLoadCode.CONST_P_LITERAL, loadP, loadQ, UnitType.PU);
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
		
		AclfInputUtilFunc.addLineBranchTo(simuCtx.getAclfNet(), branchFromBusId, branchToBusId, 
				r, x, UnitType.PU, halfB, UnitType.PU, simuCtx.getMsgHub());
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
		
		AclfInputUtilFunc.addXfrBranchTo(simuCtx.getAclfNet(), branchFromBusId, branchToBusId, 
				r, x, UnitType.PU, fromRatio, toRatio, UnitType.PU, simuCtx.getMsgHub());
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
		double fangle = new Double(st.nextToken()).doubleValue();
		double tangle = new Double(st.nextToken()).doubleValue();
		
		AclfInputUtilFunc.addPsXfrBranchTo(simuCtx.getAclfNet(), branchFromBusId, branchToBusId, 
				r, x, UnitType.PU, fromRatio, toRatio, UnitType.PU, 
				fangle, tangle, UnitType.Deg, simuCtx.getMsgHub());
	}
}
