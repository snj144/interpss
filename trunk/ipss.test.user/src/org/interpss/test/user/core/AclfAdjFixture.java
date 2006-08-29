package org.interpss.test.user.core;

import java.util.StringTokenizer;

import com.interpss.common.datatype.Constants;
import com.interpss.common.datatype.LimitType;
import com.interpss.common.datatype.UnitType;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclfadj.FlowControlType;
import com.interpss.core.aclfadj.FunctionLoad;
import com.interpss.core.aclfadj.PQBusLimit;
import com.interpss.core.aclfadj.PSXfrPControl;
import com.interpss.core.aclfadj.PVBusLimit;
import com.interpss.core.aclfadj.RemoteQBus;
import com.interpss.core.aclfadj.RemoteQControlType;
import com.interpss.core.aclfadj.TapControl;

public class AclfAdjFixture extends AclfBuildFixture {
	/*
	 * PVBusLimit
	 */
	
	// format: busId,maxQ_PU,minQ_PU
	public void addPVBusLimit(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		busId = st.nextToken();
		double max = new Double(st.nextToken()).doubleValue();
		double min = new Double(st.nextToken()).doubleValue();
		
	  	PVBusLimit pvLimit = CoreObjectFactory.createPVBusLimit(simuCtx.getAclfAdjNet(), busId);
		pvLimit.setQLimit(new LimitType(max, min), UnitType.PU, simuCtx.getAclfAdjNet().getBaseKva());
  	}

	public boolean pvBusLimitStatus() {
		PVBusLimit pvLimit = simuCtx.getAclfAdjNet().getPVBusLimit(busId);
		return pvLimit.isActive();
	}

	public double pvBusLimitMaxQ() {
		PVBusLimit pvLimit = simuCtx.getAclfAdjNet().getPVBusLimit(busId);
		return formatDouble(pvLimit.getQLimit().getMax());
	}
	
	public double pvBusLimitMinQ() {
		PVBusLimit pvLimit = simuCtx.getAclfAdjNet().getPVBusLimit(busId);
		return formatDouble(pvLimit.getQLimit().getMin());
	}

	/*
	 * PQBusLimit 
	 */
	
	// format: busId,maxVolt_PU,minVolt_PU
	public void addPQBusLimit(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		busId = st.nextToken();
		double max = new Double(st.nextToken()).doubleValue();
		double min = new Double(st.nextToken()).doubleValue();
		
	  	PQBusLimit pqLimit = CoreObjectFactory.createPQBusLimit(simuCtx.getAclfAdjNet(), busId);
		pqLimit.setVLimit(new LimitType(max, min), UnitType.PU);
  	}

	public boolean pqBusLimitStatus() {
		PQBusLimit pqLimit = simuCtx.getAclfAdjNet().getPQBusLimit(busId);
		return pqLimit.isActive();
	}

	public double pqBusLimitMaxV() {
		PQBusLimit pqLimit = simuCtx.getAclfAdjNet().getPQBusLimit(busId);
		return formatDouble(pqLimit.getVLimit().getMax());
	}
	
	public double pqBusLimitMinV() {
		PQBusLimit pqLimit = simuCtx.getAclfAdjNet().getPQBusLimit(busId);
		return formatDouble(pqLimit.getVLimit().getMin());
	}
	
	/*
	 * Functional Load
	 */
	
	// format: busId,pA_PU,pB_PU,qA_PU,qB_PU
	public void addFunctionLoad(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		busId = st.nextToken();
		double p_a = new Double(st.nextToken()).doubleValue();
		double p_b = new Double(st.nextToken()).doubleValue();
		double q_a = new Double(st.nextToken()).doubleValue();
		double q_b = new Double(st.nextToken()).doubleValue();
		
	  	FunctionLoad fload = CoreObjectFactory.createFunctionLoad(simuCtx.getAclfAdjNet(), busId);
  		fload.getP().setA(p_a);
  		fload.getP().setB(p_b);
  		fload.getQ().setA(q_a);
  		fload.getQ().setB(q_b);	  	
  	}

	public double funcLoadP0() {
		FunctionLoad fload = simuCtx.getAclfAdjNet().getFunctionLoad(busId);
		return formatDouble(fload.getP().getLoad0());
	}

	public double funcLoadP_A() {
		FunctionLoad fload = simuCtx.getAclfAdjNet().getFunctionLoad(busId);
		return formatDouble(fload.getP().getA());
	}
	
	public double funcLoadP_B() {
		FunctionLoad fload = simuCtx.getAclfAdjNet().getFunctionLoad(busId);
		return formatDouble(fload.getP().getB());
	}

	public double funcLoadQ0() {
		FunctionLoad fload = simuCtx.getAclfAdjNet().getFunctionLoad(busId);
		return formatDouble(fload.getQ().getLoad0());
	}

	public double funcLoadQ_A() {
		FunctionLoad fload = simuCtx.getAclfAdjNet().getFunctionLoad(busId);
		return formatDouble(fload.getQ().getA());
	}
	
	public double funcLoadQ_B() {
		FunctionLoad fload = simuCtx.getAclfAdjNet().getFunctionLoad(busId);
		return formatDouble(fload.getQ().getB());
	}
	
	/*
	 * TapControl
	 */
	// format: xfrFromBusId,xfrToBusId,busId,vSpec_PU,vcBusOnFromSide(true/false),maxTap,minTap,adjSteps,tapOnFromSide(true/false)
	public void addTapControlVoltage(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		branchFromBusId = st.nextToken();
		branchToBusId = st.nextToken();
		busId = st.nextToken();
		double vSpec = new Double(st.nextToken()).doubleValue();
		boolean vcBusOnFromSide = new Boolean(st.nextToken()).booleanValue();
		double maxTap = new Double(st.nextToken()).doubleValue();
		double minTap = new Double(st.nextToken()).doubleValue();
		int    steps  = new Integer(st.nextToken()).intValue();
		boolean tapOnFromSide = new Boolean(st.nextToken()).booleanValue();
		
  		TapControl tapv = CoreObjectFactory.createTapVControlBusVoltage(simuCtx.getAclfAdjNet(), getBranchId(), busId,
  				FlowControlType.POINT_CONTROL_LITERAL);
  		tapv.setTapLimit(new LimitType(maxTap, minTap));
  		tapv.setVSpecified(vSpec);
  		tapv.setVcBusOnFromSide(vcBusOnFromSide);
  		if (steps > 0)
  			tapv.setTapStepSize((maxTap-minTap)/steps);
  		else
  			tapv.setTapStepSize(0.0);
  		tapv.setControlOnFromSide(tapOnFromSide);
  	}

	// format: xfrFromBusId,xfrToBusId,MvarSpec_PU,maxTap,minTap,adjSteps,tapOnFromSide(true/false),flowFrom2To(true/false),mvarSpecFromSide(true/false)
	public void addTapControlMvarFlow(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		branchFromBusId = st.nextToken();
		branchToBusId = st.nextToken();
		double  mvaSpec = new Double(st.nextToken()).doubleValue();
		double  maxTap = new Double(st.nextToken()).doubleValue();
		double  minTap = new Double(st.nextToken()).doubleValue();
		int     steps  = new Integer(st.nextToken()).intValue();
		boolean tapOnFromSide = new Boolean(st.nextToken()).booleanValue();
		boolean flowFrom2To = new Boolean(st.nextToken()).booleanValue();
		boolean mvarSpecOnFromSide = new Boolean(st.nextToken()).booleanValue();
		
  		TapControl tapv = CoreObjectFactory.createTapVControlMvarFlow(simuCtx.getAclfAdjNet(), getBranchId(),
  				FlowControlType.POINT_CONTROL_LITERAL);
  		tapv.setTapLimit(new LimitType(maxTap, minTap));
  		tapv.setMvarSpecified(mvaSpec);
  		if (steps > 0)
  			tapv.setTapStepSize((maxTap-minTap)/steps);
  		else
  			tapv.setTapStepSize(0.0);
  		tapv.setTapOnFromSide(tapOnFromSide);
  		tapv.setFlowFrom2To(flowFrom2To);
  		tapv.setMeteredOnFromSide(mvarSpecOnFromSide);
  	}

	public double tapControlMaxTap() {
		TapControl tapCon = simuCtx.getAclfAdjNet().getTapControl(getBranchId());
		return formatDouble(tapCon.getTapLimit().getMax());
	}

	public double tapControlMinTap() {
		TapControl tapCon = simuCtx.getAclfAdjNet().getTapControl(getBranchId());
		return formatDouble(tapCon.getTapLimit().getMin());
	}
	
	public boolean tapControlStatus() {
		TapControl tapCon = simuCtx.getAclfAdjNet().getTapControl(getBranchId());
		return tapCon.isActive();
	}	
	
	/*
	 * RemoteQBus
	 */
	// format: controlBusId,remoteBusId,spec_PU,maxQ,minQ
	public void addRemoteQBusVoltage(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		busId = st.nextToken();
		String remoteBusId = st.nextToken();
		double spec = new Double(st.nextToken()).doubleValue();
		double maxQ = new Double(st.nextToken()).doubleValue();
		double minQ = new Double(st.nextToken()).doubleValue();
		
  		RemoteQBus reQ = CoreObjectFactory.createRemoteQBus(simuCtx.getAclfAdjNet(), busId, 
  				RemoteQControlType.BUS_VOLTAGE_LITERAL, remoteBusId);
  		reQ.setQLimit(new LimitType(maxQ, minQ));
  		reQ.setVSpecified(spec);
  	}
	
	// format: controlBusId,remoteBranchId,spec_PU,maxQ,minQ,onFromSide(true/false),flowFrom2To(true/false)
	public void addRemoteQBusMvarFlow(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		busId = st.nextToken();
		String remoteBranchId = st.nextToken();
		double spec = new Double(st.nextToken()).doubleValue();
		double maxQ = new Double(st.nextToken()).doubleValue();
		double minQ = new Double(st.nextToken()).doubleValue();
		boolean onFromSide = new Boolean(st.nextToken()).booleanValue();
		boolean flowFrom2To = new Boolean(st.nextToken()).booleanValue();
		
  		RemoteQBus reQ = CoreObjectFactory.createRemoteQBus(simuCtx.getAclfAdjNet(), busId, 
  							RemoteQControlType.BRANCH_Q_LITERAL, remoteBranchId);
  		reQ.setQLimit(new LimitType(maxQ, minQ));
  		reQ.setVSpecified(spec);
  		reQ.setMvarOnFromSide(onFromSide);
  		reQ.setFlowFrom2To(flowFrom2To);
  	}

	public boolean remoteQBusStatus() {
		RemoteQBus reBus = simuCtx.getAclfAdjNet().getRemoteQBus(busId);
		return reBus.isActive();
	}

	public double remoteQBusMaxQ() {
		RemoteQBus reBus = simuCtx.getAclfAdjNet().getRemoteQBus(busId);
		return formatDouble(reBus.getQLimit().getMax());
	}
	
	public double remoteQBusMinQ() {
		RemoteQBus reBus = simuCtx.getAclfAdjNet().getRemoteQBus(busId);
		return formatDouble(reBus.getQLimit().getMin());
	}
	
	/*
	 * PSXfrControl
	 */
	// format: branchFromBusId,branchToBusId,pSpec_PU,maxAng_Deg,minAng_Deg,specOnFromSide(true/false),flowFrom2To(true/false)
	public void addPSXfrPControl(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		branchFromBusId = st.nextToken();
		branchToBusId = st.nextToken();
		double pSpec = new Double(st.nextToken()).doubleValue();
		double maxAng = new Double(st.nextToken()).doubleValue();
		double minAng = new Double(st.nextToken()).doubleValue();
		boolean onFromSide = new Boolean(st.nextToken()).booleanValue();
		boolean flowFrom2To = new Boolean(st.nextToken()).booleanValue();
		
		PSXfrPControl psXfrControl = CoreObjectFactory.createPSXfrPControl(simuCtx.getAclfAdjNet(), getBranchId(),
										FlowControlType.POINT_CONTROL_LITERAL);
		psXfrControl.setPSpecified(pSpec);
		psXfrControl.setAngLimit(new LimitType(maxAng*Constants.DtoR, minAng*Constants.DtoR));
		psXfrControl.setControlOnFromSide(onFromSide);		
		psXfrControl.setFlowFrom2To(flowFrom2To);		
  	}

	public double psXfrPControlMaxAng() {
		PSXfrPControl psCon = simuCtx.getAclfAdjNet().getPSXfrPControl(getBranchId());
		return formatDouble(psCon.getAngLimit(UnitType.Deg).getMax());
	}

	public double psXfrPControlMinAng() {
		PSXfrPControl psCon = simuCtx.getAclfAdjNet().getPSXfrPControl(getBranchId());
		return formatDouble(psCon.getAngLimit(UnitType.Deg).getMin());
	}
	
	public boolean psXfrPControlStatus() {
		PSXfrPControl psCon = simuCtx.getAclfAdjNet().getPSXfrPControl(getBranchId());
		return psCon.isStatus();
	}	
}
