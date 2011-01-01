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

package org.interpss.mapper.runCase.dep;

import org.interpss.schema.AcscFaultCategoryDataType;
import org.interpss.schema.AcscFaultDataType;
import org.interpss.schema.AcscFaultXmlType;
import org.interpss.schema.DStabStudyCaseXmlType;
import org.interpss.schema.DynamicEventDataType;
import org.interpss.schema.MachineControllerDataType;
import org.interpss.schema.DStabStudyCaseXmlType.DynamicEventData;
import org.interpss.schema.DStabStudyCaseXmlType.DynamicEventData.EventList.Event.LoadChangeData;
import org.interpss.schema.DStabStudyCaseXmlType.DynamicEventData.EventList.Event.SetPointChangeData;
import org.interpss.schema.DStabStudyCaseXmlType.SimuConfig.SimuMethod;
import org.interpss.schema.DStabStudyCaseXmlType.StaticLoadModel.StaticLoadType;

import com.interpss.common.datatype.Constants;
import com.interpss.common.exp.InvalidParameterException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.acsc.fault.AcscBusFault;
import com.interpss.dstab.DStabBranch;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuAlgorithm;
import com.interpss.dstab.DynamicSimuMethod;
import com.interpss.dstab.StaticLoadModel;
import com.interpss.dstab.devent.BranchOutageEvent;
import com.interpss.dstab.devent.BranchOutageType;
import com.interpss.dstab.devent.DStabBranchFault;
import com.interpss.dstab.devent.DynamicEvent;
import com.interpss.dstab.devent.DynamicEventType;
import com.interpss.dstab.devent.LoadChangeEvent;
import com.interpss.dstab.devent.LoadChangeEventType;
import com.interpss.dstab.devent.SetPointChangeEvent;
import com.interpss.dstab.mach.Machine;
import com.interpss.dstab.mach.MachineControllerType;
import com.interpss.spring.CoreCommonSpringCtx;

public class Xml2DStabAlgorithmMapperImpl {
	/**
	 * Map RunDStabStudyCaseXmlType object to a DynamicSimuAlgorithm object.
	 * Modifications defined inside the study case also applied to the
	 * DStabilityNetwork object
	 * 
	 * @param caseRec
	 * @param algo
	 */
	public static boolean dstabCaseData2AlgoMapping(
			DStabStudyCaseXmlType dstabCase,
			DynamicSimuAlgorithm algo, IPSSMsgHub msg) {
		Xml2AlgorithmMapperImpl.aclfCaseData2AlgoMapping(dstabCase.getAclfAlgorithm(), algo
				.getAclfAlgorithm(), msg);

		algo.setSimuMethod(dstabCase.getSimuConfig().getSimuMethod() == SimuMethod.MODIFIED_EULER ? DynamicSimuMethod.MODIFIED_EULER
						: DynamicSimuMethod.RUNGE_KUTTA);
		algo.setTotalSimuTimeSec(dstabCase.getSimuConfig().getTotalSimuTimeSec());
		algo.setSimuStepSec(dstabCase.getSimuConfig().getSimuStepSec());
		algo.setDisableDynamicEvent(dstabCase.getDynamicEventData()
				.getDisableEvent());

		if (dstabCase.getSimuConfig().getAbsoluteMachAngValue()) {
			algo.setRefMachine(null);
		} else {
			Machine mach = getMachine(algo.getDStabNet(), dstabCase
					.getSimuConfig().getRefMachineBusId());
			if (mach == null)
				return false;
			IpssLogger.getLogger().info("Ref mach set to : " + mach.getId());
			algo.setRefMachine(mach);
		}

		// transfer output variable filter info to the DStabAlgo object, which
		// then
		// will be carried by the object to the remote grid node
		algo.setOutputFiltered(dstabCase.getOutputConfig() != null && 
				dstabCase.getOutputConfig().getOutputFilter());
		if (algo.isOutputFiltered()) {
			algo.setOutputVarIdList(dstabCase.getOutputConfig()
					.getOutputVarList().getVariableNameArray());
		}

		return dstabCaseData2NetMapping(dstabCase, algo.getDStabNet(), msg);
	}

	private static boolean dstabCaseData2NetMapping(
			DStabStudyCaseXmlType dstabData,
			DStabilityNetwork dstabNet, IPSSMsgHub msg) {
		dstabNet.setNetEqnIterationNoEvent(dstabData.getNetEqnSolveConfig() != null &&
				dstabData.getNetEqnSolveConfig().getNetEqnItrNoEvent() != 0 ? 
						dstabData.getNetEqnSolveConfig().getNetEqnItrNoEvent() : 
							Constants.DStabNetItrNoEvent);
		dstabNet.setNetEqnIterationWithEvent(dstabData.getNetEqnSolveConfig() != null &&
				dstabData.getNetEqnSolveConfig().getNetEqnItrWithEvent() != 0 ? 
						dstabData.getNetEqnSolveConfig().getNetEqnItrWithEvent()
							: Constants.DStabNetItrWithEvent);

		if (dstabData.getStaticLoadModel() != null) {
			dstabNet
					.setStaticLoadModel(dstabData.getStaticLoadModel()
							.getStaticLoadType() == StaticLoadType.CONST_Z ? StaticLoadModel.CONST_Z
							: StaticLoadModel.CONST_P);
			if (dstabData.getStaticLoadModel().getSwitchVolt() != 0.0)
				dstabNet.setStaticLoadSwitchVolt(dstabData.getStaticLoadModel()
						.getSwitchVolt());
			if (dstabData.getStaticLoadModel().getSwitchDeadZone() != 0.0)
				dstabNet.setStaticLoadSwitchDeadZone(dstabData
						.getStaticLoadModel().getSwitchDeadZone());
		}

		if (dstabData.getDynamicEventData().getDisableEvent()) {
			if (dstabData.getDynamicEventData().getEventList() != null && 
			    dstabData.getDynamicEventData().getEventList().sizeOfEventArray() > 0 && 
					dstabData.getDynamicEventData().getEventList().getEventArray(0).getEventType() == DynamicEventDataType.SET_POINT_CHANGE) {
				SetPointChangeData scdata = dstabData.getDynamicEventData().getEventList().getEventArray(0).getSetPointChangeData();
				if (scdata != null) {
					IpssLogger.getLogger().info("Dynamic Event Type: SetPointChange");
					String machId = scdata.getMachId();
					Machine mach = getMachine(dstabNet, machId);
					if (mach == null)
						return false;
					IpssLogger.getLogger().info("SetPointChange mach id : " + mach.getId());

					DynamicEvent event = DStabObjectFactory.createDEvent(
							Constants.Token_SetPointChangeId + machId,
							"SetPointChange", DynamicEventType.SET_POINT_CHANGE,
							dstabNet, msg);
					event.setStartTimeSec(0.0);
					event.setDurationSec(dstabData.getSimuConfig()
							.getTotalSimuTimeSec());
					SetPointChangeEvent eSetPoint = DStabObjectFactory.createSetPointChangeEvent(machId, dstabNet);
					eSetPoint.setControllerType(scdata.getControllerType() == MachineControllerDataType.EXCITER ? MachineControllerType.EXCITER
									: scdata.getControllerType() == MachineControllerDataType.GOVERNOR ? MachineControllerType.GOVERNOR
											: MachineControllerType.STABILIZER);
					eSetPoint.setChangeValue(scdata.getChangeValue());
					eSetPoint.setAbusoluteChange(scdata.getValueChangeType() == SetPointChangeData.ValueChangeType.ABSOLUTE);
					event.setBusDynamicEvent(eSetPoint);
				}
			}
		} else {
			for (DynamicEventData.EventList.Event eventData : dstabData.getDynamicEventData().getEventList().getEventArray()) {
				// make sure that event name is not "" or NewEventName
				IpssLogger.getLogger().info("Event Data: " + eventData);
				// create event name
				String name = "EventAt_" + eventData.getStartTimeSec() + eventData.getEventType();
				// map event type
				DynamicEventType deType = getDEventType(eventData.getEventType(), eventData.getFault().getFaultType());
				// create the DStabEvent
				DynamicEvent event = DStabObjectFactory.createDEvent(eventData.getRecName(), name, deType, dstabNet, msg);
				if (event == null) {
					CoreCommonSpringCtx.getEditorDialogUtil().showErrMsgDialog(
							"Error to create DynamicEvent",
							"Please see the log file for details");
					return false;
				}

				try {
					setEventData(event, eventData, dstabData.getSimuConfig()
							.getTotalSimuTimeSec(), dstabNet, msg);
				} catch (Exception e) {
					IpssLogger.logErr(e);
					CoreCommonSpringCtx.getEditorDialogUtil().showErrMsgDialog(
							"Error to process DynamicEvent",
							"See log file for details, " + e.toString());
					return false;
				}
			}
		}
		return true;
	}

	private static Machine getMachine(DStabilityNetwork net, String machId) {
		Machine mach = net.getMachine(machId);
		if (mach == null) {
			CoreCommonSpringCtx.getEditorDialogUtil().showErrMsgDialog(
					"Machine Id Error",
					"Machine cannot be found, mach id : " + machId);
			IpssLogger.getLogger().severe(
					"Machine cannot be found, mach id : " + machId);
		}
		return mach;
	}

	private static DynamicEventType getDEventType(DynamicEventDataType.Enum eventType,
			AcscFaultDataType.Enum faultType) {
		if (eventType == DynamicEventDataType.FAULT) {
			if (faultType == AcscFaultDataType.BUS_FAULT)
				return DynamicEventType.BUS_FAULT;
			else if (faultType == AcscFaultDataType.BRANCH_FAULT)
				return DynamicEventType.BRANCH_FAULT;
			else if (faultType == AcscFaultDataType.BRANCH_OUTAGE)
				return DynamicEventType.BRANCH_OUTAGE;

		} else {
			if (eventType == DynamicEventDataType.LOAD_CHANGE)
				return DynamicEventType.LOAD_CHANGE;
			else if (eventType == DynamicEventDataType.SET_POINT_CHANGE)
				return DynamicEventType.SET_POINT_CHANGE;
		}
		CoreCommonSpringCtx.getEditorDialogUtil().showErrMsgDialog(
				"Dynamic Event Type Error", "EventDataType: " + eventType);
		throw new InvalidParameterException(
				"Programming error, eventDataType: " + eventType);
	}

	private static void setEventData(DynamicEvent event,
			DynamicEventData.EventList.Event eventData, double toltalSimuTime,
			DStabilityNetwork dstabNet, IPSSMsgHub msg) throws Exception {
		// for LoadChange
		// LowFreq and LowVolt startTime will set by system
		// FixedTime startTime = threshhold
		// always permanent
		IpssLogger.getLogger().info(
				"Dynamic Event Type: " + eventData.getEventType().toString());

		if (eventData.getEventType() == DynamicEventDataType.LOAD_CHANGE) {
			event.setPermanent(true);
			eventData.setDurationSec(0.0);
			if (eventData.getLoadChangeData().getLoadChangeType() == LoadChangeData.LoadChangeType.FIXED_TIME)
				eventData.setStartTimeSec(eventData.getLoadChangeData()
						.getThreshhold());
			else
				eventData.setStartTimeSec(toltalSimuTime);
		}

		event.setStartTimeSec(eventData.getStartTimeSec());
		event.setPermanent(eventData.getPermanent());
		if (event.isPermanent()) {
			event.setDurationSec(toltalSimuTime);
		} else {
			event.setDurationSec(eventData.getDurationSec());
		}

		if (eventData.getEventType() == DynamicEventDataType.LOAD_CHANGE) {
			event.setType(DynamicEventType.LOAD_CHANGE);
			LoadChangeData ldata = eventData.getLoadChangeData();
			LoadChangeEvent eLoad = DStabObjectFactory.createLoadChangeEvent(
					ldata.getBusId(), dstabNet);
			eLoad
					.setType(ldata.getLoadChangeType() == LoadChangeData.LoadChangeType.LOW_FREQUENCY ? LoadChangeEventType.LOW_FREQUENCY
							: (ldata.getLoadChangeType() == LoadChangeData.LoadChangeType.LOW_VOLTAGE) ? LoadChangeEventType.LOW_VOLTAGE
									: LoadChangeEventType.FIXED_TIME);
			if (ldata.getChangeFactor() != 0.0)
				eLoad.setChangeFactor(ldata.getChangeFactor());
			if (ldata.getThreshhold() != 0.0)
				eLoad.setThreshhold(ldata.getThreshhold());
			if (ldata.getDelayTime() != 0.0)
				eLoad.setDelaySec(ldata.getDelayTime());
			event.setBusDynamicEvent(eLoad);
		} else if (eventData.getEventType() == DynamicEventDataType.FAULT) {
			AcscFaultXmlType fdata = eventData.getFault();
			if (eventData.getFault().getFaultType() == AcscFaultDataType.BRANCH_OUTAGE) {
				event.setType(DynamicEventType.BRANCH_OUTAGE);
				BranchOutageEvent bOutageEvent = DStabObjectFactory
						.createBranchOutageEvent(fdata.getBusBranchId(),
								dstabNet);
				if (fdata.getFaultCategory() == AcscFaultCategoryDataType.OUTAGE_3_PHASE)
					bOutageEvent.setOutageType(BranchOutageType.THREE_PHASE);
				else if (fdata.getFaultCategory() == AcscFaultCategoryDataType.OUTAGE_1_PHASE)
					bOutageEvent.setOutageType(BranchOutageType.SINGLE_PHASE);
				else if (fdata.getFaultCategory() == AcscFaultCategoryDataType.OUTAGE_2_PHASE)
					bOutageEvent.setOutageType(BranchOutageType.DOUBLE_PHASE);
				event.setBranchDynamicEvent(bOutageEvent);
			} else if (eventData.getFault().getFaultType() == AcscFaultDataType.BUS_FAULT) {
				event.setType(DynamicEventType.BUS_FAULT);
				AcscBusFault fault = CoreObjectFactory
						.createAcscBusFault(Constants.Token_BusFaultId
								+ fdata.getBusBranchId());
				Xml2AlgorithmMapperImpl.acscFaultData2AcscBusFaultMapping(
						fdata, fault);
				event.setBusFault(fault);
				DStabBus bus = dstabNet.getDStabBus(fdata.getBusBranchId());
				if (bus != null)
					fault.setFaultBus(bus);
				else {
					CoreCommonSpringCtx.getEditorDialogUtil()
							.showErrMsgDialog(
									"Bus Data Error",
									"Bus cannot be found, id:"
											+ fdata.getBusBranchId());
					throw new InvalidParameterException(
							"Programming erroe, Bus cannot be found, id:"
									+ fdata.getBusBranchId());
				}
			} else if (eventData.getFault().getFaultType() == AcscFaultDataType.BRANCH_FAULT) {
				event.setType(DynamicEventType.BRANCH_FAULT);
				DStabBranchFault fault = createDStabBranchFault(fdata, dstabNet);
				event.setBranchFault(fault);
				if (fault.isReclosure()) {
					String name = "EventAt_" + eventData.getStartTimeSec()
							+ eventData.getEventType();
					DynamicEvent event2 = DStabObjectFactory.createDEvent(event
							.getId()
							+ "-Reclosure", name,
							DynamicEventType.BRANCH_RECLOSURE, dstabNet, msg);
					event2.setStartTimeSec(fault.getReclosureTime());
					event2.setDurationSec(toltalSimuTime);
					event2.setPermanent(true);
					event2.setBranchFault(createDStabBranchFault(fdata,
							dstabNet));
				}
			}
		}
	}

	private static DStabBranchFault createDStabBranchFault(
			AcscFaultXmlType fdata, DStabilityNetwork dstabNet) {
		DStabBranchFault fault = DStabObjectFactory
				.createDStabBranchFault(Constants.Token_BranchFaultId
						+ fdata.getBusBranchId());
		Xml2AlgorithmMapperImpl.acscFaultData2AcscBranchFaultMapping(fdata,
				fault);
		fault.setReclosure(fdata.getBranchReclosure());
		fault.setReclosureTime(fdata.getReclosureTime());
		DStabBranch branch = dstabNet.getDStabBranch(fdata.getBusBranchId());
		if (branch != null)
			fault.setFaultBranch(branch);
		else {
			CoreCommonSpringCtx.getEditorDialogUtil().showErrMsgDialog(
					"Branch Data Error",
					"Branch cannot be found, id:" + fdata.getBusBranchId());
			throw new InvalidParameterException(
					"Programming error, Branch cannot be found, id:"
							+ fdata.getBusBranchId());
		}
		return fault;
	}
}