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
  * @Date 11/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.test.user.dstab;

import java.util.StringTokenizer;

import org.apache.commons.math.complex.Complex;
import org.interpss.test.user.core.AcscFixture;

import com.interpss.common.datatype.Constants;
import com.interpss.common.exp.InvalidParameterException;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.acsc.AcscBusFault;
import com.interpss.core.acsc.SimpleFaultCode;
import com.interpss.dstab.DStabBranch;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuAlgorithm;
import com.interpss.dstab.devent.DStabBranchFault;
import com.interpss.dstab.devent.DynamicEvent;
import com.interpss.dstab.devent.DynamicEventType;
import com.interpss.dstab.devent.LoadChangeEvent;
import com.interpss.dstab.devent.SetPointChangeEvent;
import com.interpss.dstab.mach.ControllerType;
import com.interpss.dstab.mach.Machine;
import com.interpss.dstab.test.StateVariableTestRecorder;
import com.interpss.dstab.test.YMatrixChangeTestRecorder;
import com.interpss.simu.SimuSpringAppContext;

public class DStabFixture extends AcscFixture {
	private DynamicSimuAlgorithm dSimuAlgorithm;
	private DynamicEvent currentDEvent;
	
	private StateVariableTestRecorder stateTestRecorder;
	private int timePoints = 0;
	private double[] timePointArray;
	
	private YMatrixChangeTestRecorder yTestRecorder;
	
	public void createDStabNetwork() {
		simuCtx = SimuSpringAppContext.getSimuContextTypeDStab();
	}	

	private DStabilityNetwork getNet() {
		return simuCtx.getDStabilityNet();
	}
	/**
	 * Create DynamicSimulationAlgorithm and set the parameters
	 * 
	 * @param startTime
	 * @param timeStep
	 * @param simuMethod  // not used currently
	 * @param machId
	 */
	public void cecreateDynamicSimuAlgorithm(double startTime, double timeStep, String simuMethod, String machId) {
		dSimuAlgorithm = DStabObjectFactory.createDynamicSimuAlgorithm(getNet(), msg);
		dSimuAlgorithm.setSimuStepSec(startTime);
		dSimuAlgorithm.setTotalSimuTimeSec(timeStep);
		Machine mach = getNet().getMachine(machId);
		dSimuAlgorithm.setRefMachine(mach);
	}
	
	/**
	 * Disable dynamic event
	 *
	 */
	public void disableDynamicEvent() {
		dSimuAlgorithm.setDisableDynamicEvent(true);
	}
	
	/**
	 * Define a controller set point change event
	 * 
	 * @param machId
	 * @param controllerType "Exciter", "Governor" or "Stabilizer"
	 * @param changeValue
	 * @param absoluteChange
	 */
	public void defineSetPointChange(String machId, String controllerType, double changeValue, boolean absoluteChange) {
		dSimuAlgorithm.setDisableDynamicEvent(true);
		currentDEvent = DStabObjectFactory.createDEvent("SetPointChange@"+machId, "SetPointChange", 
							DynamicEventType.SET_POINT_CHANGE_LITERAL, getNet(), msg);
		currentDEvent.setStartTimeSec(0.0);
		currentDEvent.setDurationSec(dSimuAlgorithm.getTotalSimuTimeSec());
		SetPointChangeEvent eSetPoint = DStabObjectFactory.createSetPointChangeEvent(machId, getNet());
		eSetPoint.setControllerType(
				controllerType.equals("Exciter")? ControllerType.EXCITER_LITERAL :
					controllerType.equals("Governor")? ControllerType.GOVERNOR_LITERAL : ControllerType.STABILIZER_LITERAL);
		eSetPoint.setChangeValue(changeValue);
		eSetPoint.setAbusoluteChange(absoluteChange);
		currentDEvent.setBusDynamicEvent(eSetPoint);
	}

	/**
	 * Create a dynamic event
	 * 
	 * @param id
	 * @param name
	 * @param type "BusFault", "BranchFault", "LoadChange"
	 */
	public void createDynamicEvent(String id, String name, String type) {
		this.currentDEvent = DStabObjectFactory.createDEvent(id, name, 
				type.equals("BusFault")? DynamicEventType.BUS_FAULT_LITERAL :
					type.equals("BranchFault")? DynamicEventType.BRANCH_FAULT_LITERAL : DynamicEventType.LOAD_CHANGE_LITERAL, 
				getNet(), msg);
	}
	
	/**
	 * Set event attributes
	 * 
	 * @param startTime
	 * @param duration
	 * @param permanent
	 */
	public void setDynamicEventTiming(double startTime, double duration, boolean permanent) {
		currentDEvent.setStartTimeSec(startTime);
		currentDEvent.setPermanent(permanent);
		if (permanent) {
			currentDEvent.setDurationSec(dSimuAlgorithm.getTotalSimuTimeSec());
		}
		else {
			currentDEvent.setDurationSec(0.1);
		}
	}
	
	/**
	 * add a Bus fault to the event object
	 * 
	 * @param id
	 * @param type "3P', 'LG', 'LL', 'LLG'
	 * @param rLG
	 * @param xLG
	 * @param rLL
	 * @param xLL
	 */
	public void addBusFault(String id, String type, double rLG, double xLG, double rLL, double xLL) {
		DStabBus faultBus = getNet().getDStabBus(id);
		AcscBusFault fault = CoreObjectFactory.createAcscBusFault("Bus Fault@"+id );
  		fault.setAcscBus(faultBus);
  		setFaultData(fault, type, rLG, xLG, rLL, xLL);
		currentDEvent.setBusFault(fault);
	}

	/**
	 * add a branch fault to the event object
	 * 
	 * @param fromBusId
	 * @param toBusId
	 * @param type
	 * @param distance
	 * @param rLG
	 * @param xLG
	 * @param rLL
	 * @param xLL
	 * @param reclosure
	 * @param reclosureTime
	 */
	public void addBranchFault(String fromBusId, String toBusId, String type, double distance, 
			double rLG, double xLG, double rLL, double xLL, boolean reclosure, double reclosureTime) {
		DStabBranchFault fault = createDStabbranchFault(fromBusId, toBusId, type, distance, 
									rLG, xLG, rLL, xLL, reclosure, reclosureTime);
		currentDEvent.setBranchFault(fault);
		if (fault.isReclosure()) {
			String name = "EventAt_" + currentDEvent.getStartTimeSec() + currentDEvent.getType();
			DynamicEvent event2 = DStabObjectFactory.createDEvent(currentDEvent.getId()+"-Reclosure", 
					name, DynamicEventType.BRANCH_RECLOSURE_LITERAL, getNet(), msg);
			event2.setStartTimeSec(fault.getReclosureTime());
			event2.setDurationSec(dSimuAlgorithm.getTotalSimuTimeSec());
			event2.setPermanent(true);
			event2.setBranchFault(createDStabbranchFault(fromBusId, toBusId, type, distance, 
									rLG, xLG, rLL, xLL, reclosure, reclosureTime));
		}
	}

	/**
	 * add a load change to the event object
	 * 
	 * @param loadBusId load change bus id
	 * @param changeFactor change factor in %, for example 110%
	 */
	public void addLoadChangeEvent(String loadBusId, double changeFactor) {
		currentDEvent.setType(DynamicEventType.LOAD_CHANGE_LITERAL);
		LoadChangeEvent eLoad = DStabObjectFactory.createLoadChangeEvent(loadBusId, getNet());
		eLoad.setChangeFactor(changeFactor);
		currentDEvent.setBusDynamicEvent(eLoad);
	}

	/**
	 * Create a  StateVariableTestRecorder object  
	 * 
	 * @param points
	 * @param timePointList, time points list string, format: 0.0,1.0,2.0 ...
	 */
	public void createStateTestRecorder(int points, String timePointList) {
		stateTestRecorder = new StateVariableTestRecorder(0.0001);
		timePoints = points;
		timePointArray = buildDoubleArray(points, timePointList);
	}

	
	/**
	 * add machine state variable test record
	 * 
	 * @param machId
	 * @param statename
	 * @param expectedPoints
	 */
	public void addMachineTestStateRecord(String machId, String statename, String expectedPoints) {
		addTestStateRecord(machId, statename, StateVariableTestRecorder.RecType_Machine, expectedPoints);
	}
	
	/**
	 * add exiter state variable test record
	 * 
	 * @param machId
	 * @param statename
	 * @param expectedPoints
	 */
	public void addExciterTestStateRecord(String machId, String statename, String expectedPoints) {
		addTestStateRecord(machId, statename, StateVariableTestRecorder.RecType_Exciter, expectedPoints);
	}
	
	/**
	 * add governor state variable test record
	 * 
	 * @param machId
	 * @param statename
	 * @param expectedPoints
	 */
	public void addGovernorTestStateRecord(String machId, String statename, String expectedPoints) {
		addTestStateRecord(machId, statename, StateVariableTestRecorder.RecType_Governor, expectedPoints);
	}
	
	/**
	 * add stabilizer state variable test record
	 * 
	 * @param machId
	 * @param statename
	 * @param expectedPoints
	 */
	public void addStabilizerTestStateRecord(String machId, String statename, String expectedPoints) {
		addTestStateRecord(machId, statename, StateVariableTestRecorder.RecType_Stabilizer, expectedPoints);
	}	
	
	/**
	 * add bus state variable test record
	 * 
	 * @param machId
	 * @param statename
	 * @param expectedPoints
	 */
	public void addBusTestOutputRecord(String id, String name, String expectedPoints) {
		addTestStateRecord(id, name, StateVariableTestRecorder.RecType_Bus, expectedPoints);
	}

	/**
	 * Create a Y-matrix test recorder
	 *
	 */
	public void createYMatrixTestRecorder() {
		yTestRecorder = new YMatrixChangeTestRecorder(0.0001);		
	}
	
	/**
	 * Add a bus yii test record
	 * 
	 * @param yiiBusId
	 * @param time
	 */
	public void addBusYiiTest(String yiiBusId, double time) {
		yTestRecorder.addTestRecord(new YMatrixChangeTestRecorder.TestRecord(yiiBusId, time));
	}
	
	/**
	 * Add a branch yij test record
	 * 
	 * @param fromBusId
	 * @param toBusId
	 * @param time
	 */
	public void addBranchYijTest(String fromBusId, String toBusId, double time) {
		yTestRecorder.addTestRecord(new YMatrixChangeTestRecorder.TestRecord(fromBusId, toBusId, time));
	}

	public void outputDStabDebugInfo() {
		System.out.println(simuCtx.getDStabilityNet().net2String());
	}

	private void addTestStateRecord(String id, String name, int type, String expectedPoints) {
		double[] statePoints =  buildDoubleArray(timePoints, expectedPoints);
		stateTestRecorder.addTestRecords(id, type, name, timePointArray, statePoints);
	}	

	private double[] buildDoubleArray(int points, String pointList) {
		StringTokenizer st = new StringTokenizer(pointList, ",");
		if (st.countTokens() != points) {
			IpssLogger.getLogger().severe("Number of in timePointList != points:"+points);
			throw new RuntimeException("Number of in timePointList != points:" + points);
		}
		double dAry[] = new double[points];
		int cnt = 0;
		while(st.hasMoreTokens()) {
			double t = new Double(st.nextToken()).doubleValue();
			timePointArray[cnt++] = t;
		}
		return dAry;
	}	
	
	private SimpleFaultCode toFaultCode(String fStr) {
		return fStr.equals("3P")? SimpleFaultCode.GROUND_3P_LITERAL :
				fStr.equals("LG")? SimpleFaultCode.GROUND_LG_LITERAL :
					fStr.equals("LL")? SimpleFaultCode.GROUND_LL_LITERAL : SimpleFaultCode.GROUND_LLG_LITERAL;
	}	

	private void setFaultData(AcscBusFault fault, String type, double rLG, double xLG, double rLL, double xLL) {
		fault.setFaultCode(toFaultCode(type));
		Complex zLG = new Complex(rLG, xLG);
		if (zLG.abs() < Constants.SmallScZ.abs())
			zLG = Constants.SmallScZ;
		fault.setZLGFault(zLG);
		Complex zLL = new Complex(rLL, xLL);
		if (zLL.abs() < Constants.SmallScZ.abs())
			zLL = Constants.SmallScZ;
		fault.setZLLFault(zLL);
	}
	
	private DStabBranchFault createDStabbranchFault(String fromBusId, String toBusId, String type, double distance, 
			double rLG, double xLG, double rLL, double xLL, boolean reclosure, double reclosureTime) {
		DStabBranchFault fault = DStabObjectFactory.createDStabBranchFault("BranchFault@" + fromBusId+"->"+toBusId);
		DStabBranch fBranch = (DStabBranch)getNet().getBranch(fromBusId, toBusId);
		if (fBranch != null)
			fault.setFaultBranch(fBranch);
		else {
			throw new InvalidParameterException("Branch cannot be found");
		}
		setFaultData(fault, type, rLG, xLG, rLL, xLL);
		fault.setDistance(distance);
		fault.setReclosure(reclosure);
		fault.setReclosureTime(reclosureTime);
		return fault;
	}
}
