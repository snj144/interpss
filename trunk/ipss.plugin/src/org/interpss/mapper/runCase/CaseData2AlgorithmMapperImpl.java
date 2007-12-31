 /*
  * @(#)RunForm2AlgorithmMapper.java   
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

package org.interpss.mapper.runCase;

import org.apache.commons.math.complex.Complex;
import org.interpss.editor.data.acsc.AcscFaultData;
import org.interpss.editor.data.dstab.DStabDEventData;
import org.interpss.editor.data.dstab.DStabLoadChangeData;
import org.interpss.editor.data.proj.AclfCaseData;
import org.interpss.editor.data.proj.AcscCaseData;
import org.interpss.editor.data.proj.DStabCaseData;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Constants;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.exp.InvalidParameterException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.acsc.AcscBranch;
import com.interpss.core.acsc.AcscBranchFault;
import com.interpss.core.acsc.AcscBus;
import com.interpss.core.acsc.AcscBusFault;
import com.interpss.core.acsc.SimpleFaultCode;
import com.interpss.core.acsc.SimpleFaultNetwork;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.algorithm.ScBusVoltage;
import com.interpss.core.algorithm.SimpleFaultAlgorithm;
import com.interpss.dstab.DStabBranch;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuAlgorithm;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.StaticLoadModel;
import com.interpss.dstab.devent.BranchOutageEvent;
import com.interpss.dstab.devent.BranchOutageType;
import com.interpss.dstab.devent.DStabBranchFault;
import com.interpss.dstab.devent.DynamicEvent;
import com.interpss.dstab.devent.DynamicEventType;
import com.interpss.dstab.devent.LoadChangeEvent;
import com.interpss.dstab.devent.LoadChangeEventType;
import com.interpss.dstab.devent.SetPointChangeEvent;
import com.interpss.dstab.mach.ControllerType;
import com.interpss.dstab.mach.Machine;

public class CaseData2AlgorithmMapperImpl {
	/**
	 * Map AclfCaseData to a LoadflowAlgorithm object
	 * 
	 * @param caseData
	 * @param algo
	 */
	public static void aclfCaseData2AlgoMapping(AclfCaseData caseData, LoadflowAlgorithm algo) {
	  	algo.setLfMethod(caseData.getMethod().equals(AclfCaseData.Method_NR)? AclfMethod.NR :
	  				(caseData.getMethod().equals(AclfCaseData.Method_PQ)? AclfMethod.PQ : AclfMethod.GS));
    /* no need for this. PQ method can handle PSXfr now
	  	if (algo.getAclfAdjNetwork().hasPSXfr() && algo.getLfMethod() == AclfMethod.PQ)
		  	algo.setLfMethod(AclfMethod.NR);
    */	  		
	  	algo.setMaxIterations(caseData.getMaxIteration());
	  	algo.setTolerance(caseData.getTolerance());
	  	algo.setAdjustChangeStep(caseData.getAdjustChangeStep());
	  	algo.setInitBusVoltage(caseData.getInitBusVolt());
	  	algo.setGsAccFactor(caseData.getAccFactor());			
	}
	
	/**
	 * Map AcscCaseData to a SimpleFaultAlgorithm object, Fault data will be mapped into the 
	 * SimpleFaultNetwork object
	 * 
	 * @param caseData
	 * @param algo
	 */
	public static boolean acscCaseData2AlgoMapping(AcscCaseData caseData, SimpleFaultAlgorithm algo) {
		SimpleFaultNetwork faultNet = algo.getSimpleFaultNetwork();
		String faultIdStr = algo.getDesc();
		if (caseData.getFaultData().getType().equals(AcscFaultData.FaultType_BusFault)) {
	  		AcscBus faultBus = (AcscBus)faultNet.getBus(caseData.getFaultData().getBusId());
			if (faultBus == null) {
				IpssLogger.getLogger().severe("Programming Error - Fault bus/branch not found");
	  			return false;
	  		}
			
			AcscBusFault fault = CoreObjectFactory.createAcscBusFault("Bus Fault at " +	faultBus.getId());
  	  		acscFaultData2AcscBusFaultMapping(caseData.getFaultData(), fault);
  	  		if (caseData.getFaultData().getCategory().equals(AcscFaultData.FaultCaty_Fault_All)) {
  	  			addAllFaultCategory(faultBus.getId(), faultIdStr, fault, faultNet);
  	  		}
  	  		else
  				faultNet.addBusFault(faultBus.getId(), faultIdStr, fault);
		}
		else {
	  		AcscBranch faultBranch = (AcscBranch)faultNet.getBranch(caseData.getFaultData().getBusId()+"(1)");
			if (faultBranch == null) {
				IpssLogger.getLogger().severe("Programming Error - Fault bus/branch not found, this maybe a parallel branch issue");
	  			return false;
	  		}
			
			AcscBranchFault fault = CoreObjectFactory.createAcscBranchFault("Branch Fault at " + faultBranch.getId());
  	  		acscFaultData2AcscBranchFaultMapping(caseData.getFaultData(), fault);
  	  		if (caseData.getFaultData().getCategory().equals(AcscFaultData.FaultCaty_Fault_All)) {
  	  			addAllFaultCategory(faultBranch.getId(), faultIdStr, fault, faultNet);
  	  		}
  	  		else
  				faultNet.addBranchFault(faultBranch.getId(), faultIdStr, fault);
		}
		
  	  	algo.setMultiFactor(caseData.getMFactor()*0.01);
		// algo.multiFactor in PU and acscData.getMFactor in %
		algo.setScBusVoltage(caseData.getBusInitVolt().equals(AcscCaseData.ScBusVolt_UnitVolt)?
				ScBusVoltage.UNIT_VOLT : ScBusVoltage.LOADFLOW_VOLT); // UnitV | LFVolt
		return true;
	}

	/**
	 * Map DstabCaseData to a stability algorithm object
	 * 
	 * @param dstabData
	 * @param aclfData
	 * @param algo
	 */
	public static boolean dstabCaseData2AlgoMapping(DStabCaseData dstabData, AclfCaseData aclfData, DynamicSimuAlgorithm algo, IPSSMsgHub msg) {
		CaseData2AlgorithmMapperImpl.aclfCaseData2AlgoMapping(aclfData, algo.getAclfAlgorithm());

		algo.setSimuMethod(dstabData.getSimuMethod().equals(DStabCaseData.Method_RungeKutta)?
				DynamicSimuMethods.RUNGE_KUTTA : DynamicSimuMethods.MODIFIED_EULER);
		algo.setTotalSimuTimeSec(dstabData.getTotalSimuTime());
		algo.setSimuStepSec(dstabData.getSimuStep());	
		algo.setDisableDynamicEvent(dstabData.getDisableDynamicEvent());
		
		if (dstabData.isAbsoluteMachValue()) {
			algo.setRefMachine(null);
		}
		else {
			Machine mach = algo.getDStabNet().getMachine(dstabData.getRefMachId());
			IpssLogger.getLogger().info("Ref mach set to : " + mach.getId());
			algo.setRefMachine(mach);
		}
		
		return dstabCaseData2NetMapping(dstabData, algo.getDStabNet(), msg);
	}

	/**
	 * Map a DStabCaseData info to the DStabNet object 
	 * 
	 * @param dstabData
	 * @param dstabNet
	 * @param msg
	 */
	private static boolean dstabCaseData2NetMapping(DStabCaseData dstabData, DStabilityNetwork dstabNet, IPSSMsgHub msg) {
		dstabNet.setNetEqnIterationNoEvent(dstabData.getNetEqnItrNoEvent());
		dstabNet.setNetEqnIterationWithEvent(dstabData.getNetEqnItrWithEvent());

		dstabNet.setStaticLoadModel(dstabData.getStaticLoadType().equals(
				DStabCaseData.StaticLoad_Const_Z)? StaticLoadModel.CONST_Z : StaticLoadModel.CONST_P);
		dstabNet.setStaticLoadSwitchVolt(dstabData.getStaticLoadSwitchVolt());
		dstabNet.setStaticLoadSwitchDeadZone(dstabData.getStaticLoadSwitchDeadZone());

		if (dstabData.getDisableDynamicEvent()) {
			if (dstabData.isSetPointChange()) {
				IpssLogger.getLogger().info("Dynamic Event Type: SetPointChange");
				String machId = dstabData.getSetPointChangeMachId();
				DynamicEvent event = DStabObjectFactory.createDEvent("SetPointChange@"+machId, "SetPointChange", 
						DynamicEventType.SET_POINT_CHANGE, dstabNet, msg);
				event.setStartTimeSec(0.0);
				event.setDurationSec(dstabData.getTotalSimuTime());
				SetPointChangeEvent eSetPoint = DStabObjectFactory.createSetPointChangeEvent(machId, dstabNet);
				eSetPoint.setControllerType(
						dstabData.getSelectedController().equals(Constants.Token_Exciter)? ControllerType.EXCITER :
							dstabData.getSelectedController().equals(Constants.Token_Governor)? 
									ControllerType.GOVERNOR : ControllerType.STABILIZER);
				eSetPoint.setChangeValue(dstabData.getSetPointValueChange());
				eSetPoint.setAbusoluteChange(dstabData.isSetPointChangeAbsolute());
				event.setBusDynamicEvent(eSetPoint);
			}
		}
		else {
			for (int i = 0; i < dstabData.getDEventList().size(); i++) {
				DStabDEventData eventData = (DStabDEventData)dstabData.getDEventList().get(i);
				// make sure that event name is not "" or NewEventName
				if (!eventData.getEventName().equals(DStabDEventData.NewEventName) && !eventData.getEventName().trim().equals("")) {
					IpssLogger.getLogger().info("Event Data: " + eventData);
					// create event name
					String name = "EventAt_" + eventData.getStartTime() + eventData.getType();
					// map event type 
					DynamicEventType deType = CaseData2AlgorithmMapperImpl.getDEventType(eventData.getType());
					// create the DStabEvent
					DynamicEvent event = DStabObjectFactory.createDEvent(eventData.getEventName(), name, deType, dstabNet, msg);
					if (event == null) {
						SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Error to create DynamicEvent", "Please see the log file for details");
						return false;
					}

					try {
						CaseData2AlgorithmMapperImpl.setEventData(event, eventData, dstabData.getTotalSimuTime(), dstabNet, msg);
					} catch (Exception e) {
						IpssLogger.logErr(e);
						SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Error to process DynamicEvent", "See log file for details, " + e.toString());
						return false;				
					}
				}
			}
		}
		return true;
	}
	
	private static void addAllFaultCategory(String busId, String faultIdStr, AcscBusFault fault, SimpleFaultNetwork faultNet) {
		String id = fault.getId();

		fault.setId(id + "_3P");
		fault.setFaultCode(SimpleFaultCode.GROUND_3P);
		faultNet.addBusFault(busId, faultIdStr, fault);
	  	
	  	fault.setId(id + "_LG");
	  	fault.setFaultCode(SimpleFaultCode.GROUND_LG);
		faultNet.addBusFault(busId, faultIdStr, fault);
	  	
	  	fault.setId(id + "_LLG");
	  	fault.setFaultCode(SimpleFaultCode.GROUND_LLG);
		faultNet.addBusFault(busId, faultIdStr, fault);
	  	
	  	fault.setId(id + "_LL");
	  	fault.setFaultCode(SimpleFaultCode.GROUND_LL);
		faultNet.addBusFault(busId, faultIdStr, fault);
	}
	
	private static void acscFaultData2AcscBusFaultMapping(AcscFaultData data, AcscBusFault fault) {
		fault.setFaultCode(data.getCategory().equals(AcscFaultData.FaultCaty_Fault_LLG)? SimpleFaultCode.GROUND_LLG :
			(data.getCategory().equals(AcscFaultData.FaultCaty_Fault_LG)? SimpleFaultCode.GROUND_LG :
				(data.getCategory().equals(AcscFaultData.FaultCaty_Fault_LL)? SimpleFaultCode.GROUND_LL :
					SimpleFaultCode.GROUND_3P)));
		fault.setZLGFault(new Complex(data.getLG_R(), data.getLG_X()));
		fault.setZLLFault(new Complex(data.getLL_R(), data.getLL_X())); 
	}
	
	private static void acscFaultData2AcscBranchFaultMapping(AcscFaultData data, AcscBranchFault fault) {
		fault.setFaultCode(data.getCategory().equals(AcscFaultData.FaultCaty_Fault_LLG)? SimpleFaultCode.GROUND_LLG :
			(data.getCategory().equals(AcscFaultData.FaultCaty_Fault_LG)? SimpleFaultCode.GROUND_LG :
				(data.getCategory().equals(AcscFaultData.FaultCaty_Fault_LL)? SimpleFaultCode.GROUND_LL :
					SimpleFaultCode.GROUND_3P)));
		fault.setZLGFault(new Complex(data.getLG_R(), data.getLG_X()));
		fault.setZLLFault(new Complex(data.getLL_R(), data.getLL_X()));  		
		fault.setDistance(data.getDistance(), UnitType.Percent);
	}
	
	private static DynamicEventType getDEventType(String eventDataType) {
		if (eventDataType.equals(DStabDEventData.DEventType_BusFault))
			return DynamicEventType.BUS_FAULT;
		else if (eventDataType.equals(DStabDEventData.DEventType_BranchFault))
			return DynamicEventType.BRANCH_FAULT;
		else if (eventDataType.equals(DStabDEventData.DEventType_LoadChange))
			return DynamicEventType.LOAD_CHANGE;		
		else if (eventDataType.equals(DStabDEventData.DEventType_SetPointChange))
			return DynamicEventType.SET_POINT_CHANGE;		
		else if (eventDataType.equals(DStabDEventData.DEventType_BranchOutage))
			return DynamicEventType.BRANCH_OUTAGE;		
		else 
			throw new InvalidParameterException("Programming error, eventDataType: " + eventDataType);
	}
	
	private static void setEventData(DynamicEvent event, DStabDEventData eventData, 
			double toltalSimuTime, DStabilityNetwork dstabNet, IPSSMsgHub msg) throws Exception {
		// for LoadChange
		//       LowFreq and LowVolt startTime will set by system
		//       FixedTime startTime = threshhold
		//   always permanent
		if (eventData.getType().equals(DStabDEventData.DEventType_LoadChange)) {
			event.setPermanent(true);
			eventData.setDuration(0.0);
			if (eventData.getLoadChangeData().getChangeType().equals(DStabLoadChangeData.FixedTime ))
				eventData.setStartTime(eventData.getLoadChangeData().getThreshhold());
			else
				eventData.setStartTime(toltalSimuTime);
		}
		
		event.setStartTimeSec(eventData.getStartTime());
		event.setPermanent(eventData.isPermanent());
		if (event.isPermanent()) {
			event.setDurationSec(toltalSimuTime);
		}
		else {
			event.setDurationSec(eventData.getDuration());
		}
		
		if (eventData.getType().equals(DStabDEventData.DEventType_LoadChange)) {
			IpssLogger.getLogger().info("Dynamic Event Type: LoadChange");
			event.setType(DynamicEventType.LOAD_CHANGE);
			DStabLoadChangeData ldata = eventData.getLoadChangeData();
			LoadChangeEvent eLoad = DStabObjectFactory.createLoadChangeEvent(ldata.getBusId(), dstabNet);
			eLoad.setType(ldata.getChangeType().equals(DStabLoadChangeData.LowFreq)? LoadChangeEventType.LOW_FREQUENCY : (
							ldata.getChangeType().equals(DStabLoadChangeData.LowVolt)?
									LoadChangeEventType.LOW_VOLTAGE : LoadChangeEventType.FIXED_TIME ));
			eLoad.setChangeFactor(ldata.getChangeFactor());
			eLoad.setThreshhold(ldata.getThreshhold());
			eLoad.setDelaySec(ldata.getDelayTime());
			event.setBusDynamicEvent(eLoad);
		}
		else if (eventData.getType().equals(DStabDEventData.DEventType_BranchOutage)) {
			IpssLogger.getLogger().info("Dynamic Event Type: BranchOutage");
			event.setType(DynamicEventType.BRANCH_OUTAGE);
			AcscFaultData fdata = eventData.getFaultData();
			BranchOutageEvent bOutageEvent = DStabObjectFactory.createBranchOutageEvent(fdata.getBranchId(), dstabNet);
			if (fdata.getCategory().equals(AcscFaultData.FaultCaty_Outage_3P))
				bOutageEvent.setOutageType(BranchOutageType.THREE_PHASE);
			else if (fdata.getCategory().equals(AcscFaultData.FaultCaty_Outage_1P))
				bOutageEvent.setOutageType(BranchOutageType.SINGLE_PHASE);
			else if (fdata.getCategory().equals(AcscFaultData.FaultCaty_Outage_2P))
				bOutageEvent.setOutageType(BranchOutageType.DOUBLE_PHASE);
			event.setBranchDynamicEvent(bOutageEvent);
		}
		else {
			IpssLogger.getLogger().info("Dynamic Event Type: Fualt");
			event.setType(eventData.getType().equals(DStabDEventData.DEventType_BusFault) ? 
					DynamicEventType.BUS_FAULT : DynamicEventType.BRANCH_FAULT );
			
			AcscFaultData fdata = eventData.getFaultData();
			if (fdata.getType().equals(AcscFaultData.FaultType_BusFault)) {
				AcscBusFault fault = CoreObjectFactory.createAcscBusFault("Bus Fault at " +	fdata.getBusId());
				CaseData2AlgorithmMapperImpl.acscFaultData2AcscBusFaultMapping(fdata, fault);
				event.setBusFault(fault);
				DStabBus bus = dstabNet.getDStabBus(fdata.getBusId());
				if (bus != null)
					fault.setFaultBus(bus);
				else {
					throw new InvalidParameterException("Programming erroe, Bus cannot be found, id:" + fdata.getBusId());
				}
			}
			else {
				DStabBranchFault fault = CaseData2AlgorithmMapperImpl.createDStabBranchFault(fdata, dstabNet);
				event.setBranchFault(fault);
				if (fault.isReclosure()) {
					String name = "EventAt_" + eventData.getStartTime() + eventData.getType();
					DynamicEvent event2 = DStabObjectFactory.createDEvent(
							event.getId()+"-Reclosure", name, DynamicEventType.BRANCH_RECLOSURE, dstabNet, msg);
					event2.setStartTimeSec(fault.getReclosureTime());
					event2.setDurationSec(toltalSimuTime);
					event2.setPermanent(true);
					event2.setBranchFault(CaseData2AlgorithmMapperImpl.createDStabBranchFault(fdata, dstabNet));
				}
			}
		}
	}

	private static DStabBranchFault createDStabBranchFault(AcscFaultData fdata, DStabilityNetwork dstabNet) {
		DStabBranchFault fault = DStabObjectFactory.createDStabBranchFault("Branch Fault at " + fdata.getBranchId());
		acscFaultData2AcscBranchFaultMapping(fdata, fault);
		fault.setReclosure(fdata.isBranchReclosure());
		fault.setReclosureTime(fdata.getReclosureTime());
		DStabBranch branch = dstabNet.getDStabBranch(fdata.getBranchId());
		if (branch != null)
			fault.setFaultBranch(branch);
		else {
			throw new InvalidParameterException("Programming error, Branch cannot be found, id:" + fdata.getBranchId());
		}
		return fault;
	}
}