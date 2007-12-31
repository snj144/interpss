 /*
  * @(#)Xml2AlgorithmMapperImpl.java   
  *
  * Copyright (C) 2006-2007 www.interpss.org
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
  * @Date 09/15/2007
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.mapper.runCase;

import org.interpss.editor.data.acsc.AcscFaultData;
import org.interpss.editor.data.dstab.DStabDEventData;
import org.interpss.schema.AcscFaultXmlType;
import org.interpss.schema.DEventTypeXmlData;
import org.interpss.schema.DStabControllerTypeXmlData;
import org.interpss.schema.DStabDEventXmlType;
import org.interpss.schema.DStabLoadChangeTypeXmlData;
import org.interpss.schema.DStabLoadChangeXmlType;
import org.interpss.schema.DStabSimuStaticLoadTypeXmlData;
import org.interpss.schema.DynamicSimuMethodXmlData;
import org.interpss.schema.FaultCategoryXmlData;
import org.interpss.schema.RunDStabStudyCaseXmlType;

import com.interpss.common.SpringAppContext;
import com.interpss.common.exp.InvalidParameterException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.acsc.AcscBusFault;
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

public class Xml2DStabAlgorithmMapperImpl {
	/**
	 * Map RunDStabStudyCaseXmlType object to a DynamicSimuAlgorithm object. Modifications defined inside the study case
	 * also applied to the DStabilityNetwork object
	 * 
	 * @param caseData
	 * @param algo
	 */
	public static boolean dstabCaseData2AlgoMapping(RunDStabStudyCaseXmlType caseData, DynamicSimuAlgorithm algo, IPSSMsgHub msg) {
		Xml2AlgorithmMapperImpl.aclfCaseData2AlgoMapping(caseData.getAclfAlgorithm(), algo.getAclfAlgorithm());

		algo.setSimuMethod(caseData.getSimuMethod() == DynamicSimuMethodXmlData.MODIFIED_EULER?
				 			DynamicSimuMethods.MODIFIED_EULER : DynamicSimuMethods.RUNGE_KUTTA);
		algo.setTotalSimuTimeSec(caseData.getTotalSimuTimeSec());
		algo.setSimuStepSec(caseData.getSimuStepSec());	
		algo.setDisableDynamicEvent(caseData.getDisableDEvent());
		
		if (caseData.getAbsoluteMachAngValue()) {
			algo.setRefMachine(null);
		}
		else {
			Machine mach = algo.getDStabNet().getMachine(caseData.getRefMachineBusId());
			if (mach == null ) {
				IpssLogger.getLogger().severe("Ref mach cannot be found, mach id : " + caseData.getRefMachineBusId());
				return false;
			}
			IpssLogger.getLogger().info("Ref mach set to : " + mach.getId());
			algo.setRefMachine(mach);
		}
		return dstabCaseData2NetMapping(caseData, algo.getDStabNet(), msg);
	}

	private static boolean dstabCaseData2NetMapping(RunDStabStudyCaseXmlType dstabData, DStabilityNetwork dstabNet, IPSSMsgHub msg) {
		if (dstabData.getNetEqnItrNoEvent() != 0);
			dstabNet.setNetEqnIterationNoEvent(dstabData.getNetEqnItrNoEvent());
		if (dstabData.getNetEqnItrWithEvent() != 0)
			dstabNet.setNetEqnIterationWithEvent(dstabData.getNetEqnItrWithEvent());

		if (dstabData.getStaticLoadModel() != null) {
			dstabNet.setStaticLoadModel(dstabData.getStaticLoadModel().getType() == DStabSimuStaticLoadTypeXmlData.CONSTANT_Z?
					StaticLoadModel.CONST_Z : StaticLoadModel.CONST_P);
			if (dstabData.getStaticLoadModel().getSwitchVolt() != 0.0)
				dstabNet.setStaticLoadSwitchVolt(dstabData.getStaticLoadModel().getSwitchVolt());
			if (dstabData.getStaticLoadModel().getSwitchDeadZone() != 0.0)
				dstabNet.setStaticLoadSwitchDeadZone(dstabData.getStaticLoadModel().getSwitchDeadZone());
		}

		if (dstabData.getDisableDEvent()) {
			if (dstabData.getSetpointChange()) {
				IpssLogger.getLogger().info("Dynamic Event Type: SetPointChange");
				String machId = dstabData.getSetpointChangeData().getMachId();
				DynamicEvent event = DStabObjectFactory.createDEvent("SetPointChange@"+machId, "SetPointChange", 
										DynamicEventType.SET_POINT_CHANGE, dstabNet, msg);
				event.setStartTimeSec(0.0);
				event.setDurationSec(dstabData.getTotalSimuTimeSec());
				SetPointChangeEvent eSetPoint = DStabObjectFactory.createSetPointChangeEvent(machId, dstabNet);
				eSetPoint.setControllerType(
						dstabData.getSetpointChangeData().getControllerType() == DStabControllerTypeXmlData.EXCITER? ControllerType.EXCITER :
							dstabData.getSetpointChangeData().getControllerType() == DStabControllerTypeXmlData.GOVERNOR? 
									ControllerType.GOVERNOR : ControllerType.STABILIZER);
				eSetPoint.setChangeValue(dstabData.getSetpointChangeData().getChangeValue());
				eSetPoint.setAbusoluteChange(dstabData.getSetpointChangeData().getAbsoluteChange());
				event.setBusDynamicEvent(eSetPoint);
			}
		}
		else {
			for (DStabDEventXmlType eventData : dstabData.getDynamicEventsArray()) {
				// make sure that event name is not "" or NewEventName
				IpssLogger.getLogger().info("Event Data: " + eventData);
				// create event name
				String name = "EventAt_" + eventData.getStartTimeSec() + eventData.getType();
				// map event type 
				DynamicEventType deType = getDEventType(eventData.getType());
				// create the DStabEvent
				DynamicEvent event = DStabObjectFactory.createDEvent(eventData.getName(), name, deType, dstabNet, msg);
					if (event == null) {
						SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Error to create DynamicEvent", "Please see the log file for details");
						return false;
					}

					try {
						setEventData(event, eventData, dstabData.getTotalSimuTimeSec(), dstabNet, msg);
					} catch (Exception e) {
						IpssLogger.logErr(e);
						SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Error to process DynamicEvent", "See log file for details, " + e.toString());
						return false;				
					}
			}
		}
		return true;
	}
	
	private static DynamicEventType getDEventType(DEventTypeXmlData.Enum eventDataType) {
		if (eventDataType == DEventTypeXmlData.BUS_FAULT)
			return DynamicEventType.BUS_FAULT;
		else if (eventDataType == DEventTypeXmlData.BRANCH_FAULT)
			return DynamicEventType.BRANCH_FAULT;
		else if (eventDataType == DEventTypeXmlData.LOAD_CHANGE)
			return DynamicEventType.LOAD_CHANGE;		
		else if (eventDataType == DEventTypeXmlData.SET_POINT_CHANGE)
			return DynamicEventType.SET_POINT_CHANGE;		
		else if (eventDataType == DEventTypeXmlData.BRANCH_OUTAGE)
			return DynamicEventType.BRANCH_OUTAGE;		
		else 
			throw new InvalidParameterException("Programming error, eventDataType: " + eventDataType);
	}
	
	private static void setEventData(DynamicEvent event, DStabDEventXmlType eventData, 
			double toltalSimuTime, DStabilityNetwork dstabNet, IPSSMsgHub msg) throws Exception {
		// for LoadChange
		//       LowFreq and LowVolt startTime will set by system
		//       FixedTime startTime = threshhold
		//   always permanent
		if (eventData.getType() == DEventTypeXmlData.LOAD_CHANGE) {
			event.setPermanent(true);
			eventData.setDurationSec(0.0);
			if (eventData.getLoadChange().getType() == DStabLoadChangeTypeXmlData.FIXED_TIME)
				eventData.setStartTimeSec(eventData.getLoadChange().getThreshhold());
			else
				eventData.setStartTimeSec(toltalSimuTime);
		}
		
		event.setStartTimeSec(eventData.getStartTimeSec());
		event.setPermanent(eventData.getPermanent());
		if (event.isPermanent()) {
			event.setDurationSec(toltalSimuTime);
		}
		else {
			event.setDurationSec(eventData.getDurationSec());
		}
		
		if (eventData.getType() == DEventTypeXmlData.LOAD_CHANGE) {
			IpssLogger.getLogger().info("Dynamic Event Type: LoadChange");
			event.setType(DynamicEventType.LOAD_CHANGE);
			DStabLoadChangeXmlType ldata = eventData.getLoadChange();
			LoadChangeEvent eLoad = DStabObjectFactory.createLoadChangeEvent(ldata.getBusId(), dstabNet);
			eLoad.setType(ldata.getType() == DStabLoadChangeTypeXmlData.LOW_FREQUENCY? LoadChangeEventType.LOW_FREQUENCY : (
							ldata.getType() == DStabLoadChangeTypeXmlData.LOW_VOLTAGE)?
									LoadChangeEventType.LOW_VOLTAGE : LoadChangeEventType.FIXED_TIME );
			if (ldata.getChangeFactor() != 0.0)
				eLoad.setChangeFactor(ldata.getChangeFactor());
			if (ldata.getThreshhold() != 0.0)
				eLoad.setThreshhold(ldata.getThreshhold());
			if (ldata.getDelayTime() != 0.0)
					eLoad.setDelaySec(ldata.getDelayTime());
			event.setBusDynamicEvent(eLoad);
		}
		else if (eventData.getType()  == DEventTypeXmlData.BRANCH_OUTAGE) {
			IpssLogger.getLogger().info("Dynamic Event Type: BranchOutage");
			event.setType(DynamicEventType.BRANCH_OUTAGE);
			AcscFaultXmlType fdata = eventData.getFault();
			BranchOutageEvent bOutageEvent = DStabObjectFactory.createBranchOutageEvent(fdata.getBusBranchId(), dstabNet);
			if (fdata.getCategory() == FaultCategoryXmlData.OUTAGE_3_PHASE)
				bOutageEvent.setOutageType(BranchOutageType.THREE_PHASE);
			else if (fdata.getCategory() == FaultCategoryXmlData.OUTAGE_1_PHASE)
				bOutageEvent.setOutageType(BranchOutageType.SINGLE_PHASE);
			else if (fdata.getCategory() == FaultCategoryXmlData.OUTAGE_2_PHASE)
				bOutageEvent.setOutageType(BranchOutageType.DOUBLE_PHASE);
			event.setBranchDynamicEvent(bOutageEvent);
		}
		else {
			IpssLogger.getLogger().info("Dynamic Event Type: Fualt");
			event.setType(eventData.getType().equals(DStabDEventData.DEventType_BusFault) ? 
					DynamicEventType.BUS_FAULT : DynamicEventType.BRANCH_FAULT );
			
			AcscFaultXmlType fdata = eventData.getFault();
			if (fdata.getType().equals(AcscFaultData.FaultType_BusFault)) {
				AcscBusFault fault = CoreObjectFactory.createAcscBusFault("Bus Fault at " +	fdata.getBusBranchId());
				Xml2AlgorithmMapperImpl.acscFaultData2AcscBusFaultMapping(fdata, fault);
				event.setBusFault(fault);
				DStabBus bus = dstabNet.getDStabBus(fdata.getBusBranchId());
				if (bus != null)
					fault.setFaultBus(bus);
				else {
					throw new InvalidParameterException("Programming erroe, Bus cannot be found, id:" + fdata.getBusBranchId());
				}
			}
			else {
				DStabBranchFault fault = createDStabBranchFault(fdata, dstabNet);
				event.setBranchFault(fault);
				if (fault.isReclosure()) {
					String name = "EventAt_" + eventData.getStartTimeSec() + eventData.getType();
					DynamicEvent event2 = DStabObjectFactory.createDEvent(
							event.getId()+"-Reclosure", name, DynamicEventType.BRANCH_RECLOSURE, dstabNet, msg);
					event2.setStartTimeSec(fault.getReclosureTime());
					event2.setDurationSec(toltalSimuTime);
					event2.setPermanent(true);
					event2.setBranchFault(createDStabBranchFault(fdata, dstabNet));
				}
			}
		}
	}
	
	private static DStabBranchFault createDStabBranchFault(AcscFaultXmlType fdata, DStabilityNetwork dstabNet) {
		DStabBranchFault fault = DStabObjectFactory.createDStabBranchFault("Branch Fault at " + fdata.getBusBranchId());
		Xml2AlgorithmMapperImpl.acscFaultData2AcscBranchFaultMapping(fdata, fault);
		fault.setReclosure(fdata.getBranchReclosure());
		fault.setReclosureTime(fdata.getReclosureTime());
		DStabBranch branch = dstabNet.getDStabBranch(fdata.getBusBranchId());
		if (branch != null)
			fault.setFaultBranch(branch);
		else {
			throw new InvalidParameterException("Programming error, Branch cannot be found, id:" + fdata.getBusBranchId());
		}
		return fault;
	}
}