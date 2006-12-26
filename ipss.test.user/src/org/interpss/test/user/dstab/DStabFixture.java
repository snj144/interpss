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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.interpss.test.user.core.AcscFixture;

import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.acsc.AcscBusFault;
import com.interpss.core.acsc.SimpleFaultCode;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.util.CoreUtilFunc;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuAlgorithm;
import com.interpss.dstab.devent.DStabBranchFault;
import com.interpss.dstab.devent.DynamicEvent;
import com.interpss.dstab.devent.DynamicEventType;
import com.interpss.dstab.devent.LoadChangeEvent;
import com.interpss.dstab.devent.SetPointChangeEvent;
import com.interpss.dstab.device.DynamicBusDevice;
import com.interpss.dstab.device.DynamicBusDeviceType;
import com.interpss.dstab.mach.ControllerType;
import com.interpss.dstab.mach.Machine;
import com.interpss.dstab.test.StateVariableTestRecorder;
import com.interpss.dstab.test.YMatrixChangeTestRecorder;
import com.interpss.dstab.test.StateVariableTestRecorder.TestRecord;
import com.interpss.simu.SimuSpringAppContext;

public class DStabFixture extends AcscFixture {
	// ActionFixture
	private static DynamicSimuAlgorithm dSimuAlgorithm;
	private DynamicEvent currentDEvent;
	
	private static int timePoints = 0;
	private static double[] timePointArray;
	private static StateVariableTestRecorder stateTestRecorder;
	private static YMatrixChangeTestRecorder yTestRecorder;
	
	// ColumnFixture
	public static String machId;
	public static double measureTime;
	public static String variableType;          // Machine, Exciter, Governor, Stabilizer, Bus
	public static String variableName;
	public static double errorTolerance;
	
	
	/**
	 * Called when start this fixture
	 *
	 */
	public void createDStabNetwork() {
		simuCtx = SimuSpringAppContext.getSimuContextTypeDStab();
		yTestRecorder = null;
	}	

	/**
	 * Get the number of machines in the net
	 * 
	 * @return
	 */
	public int noOfMachines() {
		int cnt = 0;
		for (Object device : getNet().getDBusDeviceList()) {
			if (((DynamicBusDevice)device).getDeviceType() == DynamicBusDeviceType.DYNAMIC_MACHINE_LITERAL) {
				cnt++;
			}
		}
		return cnt;
	}

	/**
	 * Get the number of exc in the net
	 * 
	 * @return
	 */
	public int noOfExciters() {
		int cnt = 0;
		for (Object device : getNet().getDBusDeviceList()) {
			if (((DynamicBusDevice)device).getDeviceType() == DynamicBusDeviceType.DYNAMIC_MACHINE_LITERAL) {
				if (((Machine)device).hasExciter())
					cnt++;
			}
		}
		return cnt;
	}

	/**
	 * Get the number of gov in the net
	 * 
	 * @return
	 */
	public int noOfGovernors() {
		int cnt = 0;
		for (Object device : getNet().getDBusDeviceList()) {
			if (((DynamicBusDevice)device).getDeviceType() == DynamicBusDeviceType.DYNAMIC_MACHINE_LITERAL)
				if (((Machine)device).hasGovernor())
					cnt++;
		}
		return cnt;
	}

	/**
	 * Get the number of pss in the net
	 * 
	 * @return
	 */
	public int noOfStabilizers() {
		int cnt = 0;
		for (Object device : getNet().getDBusDeviceList()) {
			if (((DynamicBusDevice)device).getDeviceType() == DynamicBusDeviceType.DYNAMIC_MACHINE_LITERAL)
				if (((Machine)device).hasStabilizer())
					cnt++;
		}
		return cnt;
	}
	
	/**
	 * Init the DStab network for transient stability simulation.
	 *
	 */
	public void initDStabNet() {
		getNet().initialization(msg);
	}

	/**
	 * Create DynamicSimulationAlgorithm and set the parameters
	 * 
	 * @param data, format: double simuTime, double timeStep, String simuMethod, String machId
	 */
	public void createDynamicSimuAlgorithm(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		double simuTime = new Double(st.nextToken()).doubleValue();
		double timeStep = new Double(st.nextToken()).doubleValue();
		String simuMethod = st.nextToken();
		String refMachId = st.nextToken();
		dSimuAlgorithm = DStabObjectFactory.createDynamicSimuAlgorithm(getNet(), msg);
		dSimuAlgorithm.setTotalSimuTimeSec(simuTime);
		dSimuAlgorithm.setSimuStepSec(timeStep);
		Machine mach = getNet().getMachine(refMachId);
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
	 * @param data, format: String machId, String controllerType("Exciter", "Governor" or "Stabilizer"), 
	 *                      double changeValue, boolean absoluteChange
	 */
	public void defineSetPointChange(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		String machId = st.nextToken();
		String contType = st.nextToken();
		double cValue = new Double(st.nextToken()).doubleValue();
		boolean absChange = new Boolean(st.nextToken()).booleanValue();
		dSimuAlgorithm.setDisableDynamicEvent(true);
		this.currentDEvent = DStabObjectFactory.createDEvent("SetPointChange@"+machId, "SetPointChange", 
							DynamicEventType.SET_POINT_CHANGE_LITERAL, getNet(), msg);
		this.currentDEvent.setStartTimeSec(0.0);
		this.currentDEvent.setDurationSec(dSimuAlgorithm.getTotalSimuTimeSec());
		SetPointChangeEvent eSetPoint = DStabObjectFactory.createSetPointChangeEvent(machId, getNet());
		eSetPoint.setControllerType(
				contType.equals("Exciter")? ControllerType.EXCITER_LITERAL :
					contType.equals("Governor")? ControllerType.GOVERNOR_LITERAL : ControllerType.STABILIZER_LITERAL);
		eSetPoint.setChangeValue(cValue);
		eSetPoint.setAbusoluteChange(absChange);
		this.currentDEvent.setBusDynamicEvent(eSetPoint);
	}

	/**
	 * Create a dynamic event
	 * 
	 * @param data format: String id, String name, String type(BusFault, BranchFault, LoadChange)
	 */
	public void createDynamicEvent(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		String id = st.nextToken();
		String name = st.nextToken();
		String type = st.nextToken();
		this.currentDEvent = DStabObjectFactory.createDEvent(id, name, 
				type.equals("BusFault")? DynamicEventType.BUS_FAULT_LITERAL :
					type.equals("BranchFault")? DynamicEventType.BRANCH_FAULT_LITERAL : DynamicEventType.LOAD_CHANGE_LITERAL, 
				getNet(), msg);
	}
	
	/**
	 * Set event attributes
	 * 
	 * @param data, format: double startTime, double duration, boolean permanent
	 * @param duration
	 * @param permanent
	 */
	public void setDynamicEventTiming(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		double startTime = new Double(st.nextToken()).doubleValue();
		double duration = new Double(st.nextToken()).doubleValue();
		boolean permanent = new Boolean(st.nextToken()).booleanValue();
		this.currentDEvent.setStartTimeSec(startTime);
		this.currentDEvent.setPermanent(permanent);
		if (this.currentDEvent.isPermanent()) {
			this.currentDEvent.setDurationSec(dSimuAlgorithm.getTotalSimuTimeSec());
		}
		else {
			this.currentDEvent.setDurationSec(duration);
		}
	}
	
	/**
	 * add a Bus fault to the event object
	 * 
	 * @param data, format: String id, String type, double rLG, double xLG, double rLL, double xLL
	 */
	public void addBusFault(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		String id = st.nextToken();
		String type = st.nextToken();
		double rLG = new Double(st.nextToken()).doubleValue();
		double xLG = new Double(st.nextToken()).doubleValue();
		double rLL = new Double(st.nextToken()).doubleValue();
		double xLL = new Double(st.nextToken()).doubleValue();
		DStabBus faultBus = getNet().getDStabBus(id);
		AcscBusFault fault = CoreObjectFactory.createAcscBusFault("Bus Fault@"+id );
  		fault.setAcscBus(faultBus);
  		CoreUtilFunc.setBusFaultData(fault, toFaultCode(type), rLG, xLG, rLL, xLL);
  		this.currentDEvent.setBusFault(fault);
	}

	/**
	 * add a branch fault to the event object
	 * 
	 * @param data, format: String fromBusId, String toBusId, String type, double distance, 
	 *                      double rLG, double xLG, double rLL, double xLL, boolean reclosure, double reclosureTime
	 */
	public void addBranchFault(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		String fromBusId = st.nextToken();
		String toBusId = st.nextToken();
		String type = st.nextToken();
		double distance = new Double(st.nextToken()).doubleValue();
		double rLG = new Double(st.nextToken()).doubleValue();
		double xLG = new Double(st.nextToken()).doubleValue();
		double rLL = new Double(st.nextToken()).doubleValue();
		double xLL = new Double(st.nextToken()).doubleValue();
		boolean reclosure = new Boolean(st.nextToken()).booleanValue();
		double reclosureTime = new Double(st.nextToken()).doubleValue();
		DStabBranchFault fault = DStabObjectFactory.createDStabbranchFault(getNet(), fromBusId, toBusId, toFaultCode(type), distance, 
				rLG, xLG, rLL, xLL, reclosure, reclosureTime);
		this.currentDEvent.setBranchFault(fault);
		if (fault.isReclosure()) {
			String name = "EventAt_" + this.currentDEvent.getStartTimeSec() + this.currentDEvent.getType();
			String id = this.currentDEvent.getId()+"-Reclosure"; 
			DStabObjectFactory.createBranchReclosureEvent(getNet(), fault, id, name, msg);
		}
	}

	/**
	 * add a load change to the event object
	 * 
	 * @param data, format: String loadBusId, double changeFactor
	 * @param changeFactor change factor in %, for example 110%
	 */
	public void addLoadChangeEvent(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		String loadBusId = st.nextToken();
		double changeFactor = new Double(st.nextToken()).doubleValue();
		this.currentDEvent.setType(DynamicEventType.LOAD_CHANGE_LITERAL);
		LoadChangeEvent eLoad = DStabObjectFactory.createLoadChangeEvent(loadBusId, getNet());
		eLoad.setChangeFactor(changeFactor);
		this.currentDEvent.setBusDynamicEvent(eLoad);
	}
	
	/*
	 *  File Based test data approach
	 *  =============================
	 */
	
	/**
	 * Create a StateVariableTestRecorder object  
	 * 
	 * @param data, format: double measureTolerance
	 */
	public void createFileBasedStateTestRecorder(String data) {
		double tolerance = new Double(data).doubleValue();
		stateTestRecorder = new StateVariableTestRecorder(tolerance);
	}

	/**
	 * load machine state variable test data
	 * 
	 * @param data, format: String machId, String filename
	 */
	public void loadMachineTestStateData(String data) {
		loadTestStateData(data, StateVariableTestRecorder.RecType_Machine);
	}
	
	/**
	 * load exiter state variable test data
	 * 
	 * @param data, format: String machId, String filename
	 */
	public void loadExciterTestStateData(String data) {
		loadTestStateData(data, StateVariableTestRecorder.RecType_Exciter);
	}
	
	/**
	 * load governor state variable test data
	 * 
	 * @param data, format:  String machId, String filename
	 */
	public void loadGovernorTestStateData(String data) {
		loadTestStateData(data, StateVariableTestRecorder.RecType_Governor);
	}
	
	/**
	 * load stabilizer state variable test data
	 * 
	 * @param data, format:  String machId, String fileaname
	 */
	public void loadStabilizerTestStateData(String data) {
		loadTestStateData(data, StateVariableTestRecorder.RecType_Stabilizer);
	}	

	/**
	 * load bus state variable test data
	 * 
	 * @param data, format: String busd, String filename
	 */
	public void loadBusTestOutputData(String data) {
		loadTestStateData(data, StateVariableTestRecorder.RecType_Bus);
	}
	
	/*
	 *  Array Based test data approach
	 *  ==============================
	 */

	/**
	 * Create a StateVariableTestRecorder object  
	 * 
	 * @param data, format: int points, double measureTolerance, String timePointList [0.0,1.0,2.0 ...]
	 */
	public void createStateTestRecorder(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		timePoints = new Integer(st.nextToken()).intValue();
		double tolerance = new Double(st.nextToken()).doubleValue();
		String timePointList = data.substring(data.indexOf('[')+1, data.indexOf(']'));
		stateTestRecorder = new StateVariableTestRecorder(tolerance);
		timePointArray = buildDoubleArray(timePoints, timePointList);
	}
	
	/**
	 * add machine state variable test record
	 * 
	 * @param data, format: String machId, String statename, String expectedPoints
	 */
	public void addMachineTestStateRecord(String data) {
		addTestStateRecord(data, StateVariableTestRecorder.RecType_Machine);
	}
	
	/**
	 * add exiter state variable test record
	 * 
	 * @param data, format: String machId, String statename, String expectedPoints
	 */
	public void addExciterTestStateRecord(String data) {
		addTestStateRecord(data, StateVariableTestRecorder.RecType_Exciter);
	}
	
	/**
	 * add governor state variable test record
	 * 
	 * @param data, format: String machId, String statename, String expectedPoints
	 */
	public void addGovernorTestStateRecord(String data) {
		addTestStateRecord(data, StateVariableTestRecorder.RecType_Governor);
	}
	
	/**
	 * add stabilizer state variable test record
	 * 
	 * @param data, format: String machId, String statename, String expectedPoints
	 */
	public void addStabilizerTestStateRecord(String data) {
		addTestStateRecord(data, StateVariableTestRecorder.RecType_Stabilizer);
	}	
	
	/**
	 * add bus state variable test record
	 * 
	 * @param data, format: String busd, String vname, String expectedPoints
	 */
	public void addBusTestOutputRecord(String data) {
		addTestStateRecord(data, StateVariableTestRecorder.RecType_Bus);
	}

	/**
	 * Create a Y-matrix test recorder
	 *
	 * @param data, format: double measureTolerance
	 */
	public void createYMatrixTestRecorder(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		double tolerance = new Double(st.nextToken()).doubleValue();
		yTestRecorder = new YMatrixChangeTestRecorder(tolerance);		
	}
	
	/**
	 * Add a bus yii test record
	 * 
	 * @param data, format: String yiiBusId, double time
	 */
	public void addBusYiiTest(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		String yiiBusId = st.nextToken();
		double time = new Double(st.nextToken()).doubleValue();
		yTestRecorder.addTestRecord(new YMatrixChangeTestRecorder.TestRecord(yiiBusId, time));
	}
	
	/**
	 * Add a branch yij test record
	 * 
	 * @param data, format: String fromBusId, String toBusId, double time
	 * @param toBusId
	 * @param time
	 */
	public void addBranchYijTest(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		String fromBusId = st.nextToken();
		String toBusId = st.nextToken();
		double time = new Double(st.nextToken()).doubleValue();
		yTestRecorder.addTestRecord(new YMatrixChangeTestRecorder.TestRecord(fromBusId, toBusId, time));
	}

	public void runDStabSimu() {
		LoadflowAlgorithm aclfAlgo = dSimuAlgorithm.getAclfAlgorithm();
		aclfAlgo.loadflow(msg);
		
		dSimuAlgorithm.setSimuOutputHandler(stateTestRecorder);
	  	
		if (yTestRecorder != null) {
			yTestRecorder.initBusNumber(getNet());
			getNet().setNetChangeListener(yTestRecorder);	
		}

		if (dSimuAlgorithm.initialization(msg)) {
			dSimuAlgorithm.performSimulation(msg);
		}		
	}
	
	public void outputDStabDebugInfo() {
		System.out.println(simuCtx.getDStabilityNet().net2String());
		System.out.println(dSimuAlgorithm.toString());
	}

	public void outputStateTestRecorderInfo() {
		System.out.println(stateTestRecorder);
	}

	public void outputYMatrixTestRecorderInfo() {
		System.out.println(yTestRecorder);
	}

	/*
	 *  Reuslt check functions 
	 */
	
	// busId, measureTime needs to be set
	public double yiiReal() {
		return formatDouble(yTestRecorder.getTestRecord(measureTime, busId).y.getReal());
	}
	
	// busId, measureTime needs to be set
	public double yiiImaginary() {
		return formatDouble(yTestRecorder.getTestRecord(measureTime, busId).y.getImaginary());
	}

	// busId, measureTime needs to be set
	public boolean yiiChanged() {
		return yTestRecorder.getTestRecord(measureTime, busId).measured;
	}
	
	// busId, measureTime needs to be set
	public double yijReal() {
		return formatDouble(yTestRecorder.getTestRecord(measureTime, branchFromBusId, branchToBusId).y.getReal());
	}
	
	// busId, measureTime needs to be set
	public double yijImaginary() {
		return formatDouble(yTestRecorder.getTestRecord(measureTime, branchFromBusId, branchToBusId).y.getImaginary());
	}

	// busId, measureTime needs to be set
	public boolean yijChanged() {
		return yTestRecorder.getTestRecord(measureTime, branchFromBusId, branchToBusId).measured;
	}
	
	// busId, variableType (Machine, Exciter, Governor, Stabilizer, Bus), variableName, errorTolerance need to be defined
	public boolean totalDiffLTErrorTolerance() {
		if (variableType.equals("Bus")) {
			return stateTestRecorder.diffTotal(busId, StateVariableTestRecorder.RecType_Bus, 
					variableName) < errorTolerance;
		}
		else {
			return stateTestRecorder.diffTotal(machId, 
					variableType.equals("Machine")?StateVariableTestRecorder.RecType_Machine :
						variableType.equals("Exciter")?StateVariableTestRecorder.RecType_Exciter :
							variableType.equals("Governor")?StateVariableTestRecorder.RecType_Governor :
								StateVariableTestRecorder.RecType_Stabilizer, 
					variableName) < errorTolerance;
		}
	}
	
	/*
	 * Private methods
	 * ===============
	 */
	private void loadTestStateData(String data, int type) {
		StringTokenizer st = new StringTokenizer(data, ",");
		String id = st.nextToken();
		String filename = st.nextToken();
		//System.out.println("id, filename--->" + id + ", " + filename);
		/*
		 * format : 
		 *       line1: time, statename1, statename2, .... statenamen
		 *       line2: 0.0,  0.1,        0.2,        .... 0.4
		 *          
		 */
		final BufferedReader din;
		int cnt = 0;
		try {
			final File file = new File(filename);
			final InputStream stream = new FileInputStream(file);
			din = new BufferedReader(new InputStreamReader(stream));

			boolean fileend = false;
			String[] nameList = null;
			while (!fileend) {
				String str = din.readLine();
				//System.out.println("str--->" + str);
				if (str!= null && !str.trim().equals("")) {
					if (cnt++ == 0) {
						st = new StringTokenizer(str, ",");
						nameList = new String[st.countTokens()-1];  
						st.nextElement();  // first element is Time
						for (int i = 0; i < nameList.length; i++)
							nameList[i] = st.nextToken();
						//System.out.println("nameList--->" + nameList.toString());
					}
					else {
						st = new StringTokenizer(str, ",");
						double time = new Double(st.nextToken()).doubleValue();
						for (int i = 0; i < nameList.length; i++) {
							double value = new Double(st.nextToken()).doubleValue();
							stateTestRecorder.addTestRecord(new TestRecord(id, type, time, nameList[i], value));
						}
					}
				}
				else {
					fileend = true;
				}
	       	} 
		} catch (Exception e) {
			System.err.println("Load test data file error, at line" + cnt + "," + e.toString()); 
		}
	}	

	private void addTestStateRecord(String data, int type) {
		StringTokenizer st = new StringTokenizer(data, ",");
		String id = st.nextToken();
		String name = st.nextToken();
		String pointList = data.substring(data.indexOf('[')+1, data.indexOf(']'));
		double[] statePoints =  buildDoubleArray(timePoints, pointList);
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
			dAry[cnt++] = t;
		}
		return dAry;
	}	
	
	private SimpleFaultCode toFaultCode(String fStr) {
		return fStr.equals("3P")? SimpleFaultCode.GROUND_3P_LITERAL :
				fStr.equals("LG")? SimpleFaultCode.GROUND_LG_LITERAL :
					fStr.equals("LL")? SimpleFaultCode.GROUND_LL_LITERAL : SimpleFaultCode.GROUND_LLG_LITERAL;
	}	

	private DStabilityNetwork getNet() {
		return simuCtx.getDStabilityNet();
	}
}
