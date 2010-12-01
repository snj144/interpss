/*
 * @(#)XmlCaseData2AlgorithmMapperImpl.java   
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

import org.interpss.PluginSpringCtx;
import org.interpss.editor.data.dstab.DStabDEventData;
import org.interpss.schema.AcscFaultCategoryDataType;
import org.interpss.schema.AcscFaultDataType;
import org.interpss.schema.AcscFaultXmlType;
import org.interpss.schema.DStabStudyCaseXmlType;
import org.interpss.schema.DynamicEventDataType;
import org.interpss.schema.MachineControllerDataType;
import org.interpss.schema.DStabStudyCaseXmlType.DynamicEventData.EventList.Event.LoadChangeData;
import org.interpss.schema.DStabStudyCaseXmlType.DynamicEventData.EventList.Event.LoadChangeData.LoadChangeType;

import com.interpss.common.CoreCommonSpringCtx;
import com.interpss.common.datatype.Constants;
import com.interpss.common.exp.InvalidParameterException;
import com.interpss.common.mapper.AbstractMapping;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.NetUtilFunc;
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
import com.interpss.dstab.mach.MachineControllerType;
import com.interpss.dstab.mach.Machine;

public class XmlCaseData2DStabAlgorithmMapperImpl extends AbstractMapping<DStabStudyCaseXmlType, DynamicSimuAlgorithm> {
	public XmlCaseData2DStabAlgorithmMapperImpl(IPSSMsgHub msg) {
		super(msg);
	}
	/**
	 * Map DstabCaseData to a stability algorithm object
	 * 
	 * @param xmlDstabData
	 * @param aclfData
	 * @param algo
	 */
	@Override
	public boolean map2Model(DStabStudyCaseXmlType xmlDstabData, DynamicSimuAlgorithm algo) {
		//System.out.println(xmlDstabData.toString());
		
		PluginSpringCtx.getXml2LfAlgorithmMapper()
				.map2Model(xmlDstabData.getAclfAlgorithm(), algo.getAclfAlgorithm());
		algo.setSimuMethod(xmlDstabData.getSimuConfig().getSimuMethod() == DStabStudyCaseXmlType.SimuConfig.SimuMethod.MODIFIED_EULER ? 
						DynamicSimuMethod.MODIFIED_EULER : DynamicSimuMethod.RUNGE_KUTTA );
		algo.setTotalSimuTimeSec(xmlDstabData.getSimuConfig().getTotalSimuTimeSec());
		algo.setSimuStepSec(xmlDstabData.getSimuConfig().getSimuStepSec());
		algo.setDisableDynamicEvent(xmlDstabData.getDynamicEventData().getDisableEvent());

		if (xmlDstabData.getSimuConfig().getAbsoluteMachAngValue()) {
			algo.setRefMachine(null);
		} else {
			Machine mach = algo.getDStabNet().getMachine(xmlDstabData.getSimuConfig().getRefMachineBusId());
			IpssLogger.getLogger().info("Ref mach set to : " + mach.getId());
			algo.setRefMachine(mach);
		}

		return dstabCaseData2NetMapping(xmlDstabData, algo.getDStabNet(), msg);
	}

	/**
	 * Map a DStabCaseData info to the DStabNet object
	 * 
	 * @param xmlDstabData
	 * @param dstabNet
	 * @param msg
	 */
	private static boolean dstabCaseData2NetMapping(DStabStudyCaseXmlType xmlDstabData, DStabilityNetwork dstabNet, IPSSMsgHub msg) {
		dstabNet.setNetEqnIterationNoEvent(3);
		dstabNet.setNetEqnIterationWithEvent(5);
		if (xmlDstabData.getNetEqnSolveConfig() != null) {
			dstabNet.setNetEqnIterationNoEvent(xmlDstabData.getNetEqnSolveConfig().getNetEqnItrNoEvent());
			dstabNet.setNetEqnIterationWithEvent(xmlDstabData.getNetEqnSolveConfig().getNetEqnItrWithEvent());
		}

		dstabNet.setStaticLoadModel(xmlDstabData.getStaticLoadModel().getStaticLoadType() == 
					DStabStudyCaseXmlType.StaticLoadModel.StaticLoadType.CONST_Z ? 
							StaticLoadModel.CONST_Z	: StaticLoadModel.CONST_P);
		dstabNet.setStaticLoadSwitchVolt(xmlDstabData.getStaticLoadModel().getSwitchVolt());
		dstabNet.setStaticLoadSwitchDeadZone(xmlDstabData.getStaticLoadModel().getSwitchDeadZone());

		if (xmlDstabData.getDynamicEventData().getDisableEvent()) {
			if (xmlDstabData.getDynamicEventData().getEventList() != null && 
					xmlDstabData.getDynamicEventData().getEventList().getEventArray().length > 0) {
				DStabStudyCaseXmlType.DynamicEventData.EventList.Event xmlEvent = xmlDstabData.getDynamicEventData().getEventList().getEventArray(0); 
				if (xmlEvent.getEventType() == DynamicEventDataType.SET_POINT_CHANGE) {
					IpssLogger.getLogger().info("Dynamic Event Type: SetPointChange");
					String machId = xmlEvent.getSetPointChangeData().getMachId();
					DynamicEvent event = DStabObjectFactory.createDEvent(
							Constants.Token_SetPointChangeId + machId,
							"SetPointChange", DynamicEventType.SET_POINT_CHANGE,
							dstabNet, msg);
					event.setStartTimeSec(0.0);
					event.setDurationSec(xmlDstabData.getSimuConfig().getTotalSimuTimeSec());
					SetPointChangeEvent eSetPoint = DStabObjectFactory.createSetPointChangeEvent(machId, dstabNet);
					eSetPoint.setControllerType(xmlEvent.getSetPointChangeData().getControllerType() == MachineControllerDataType.EXCITER ?
									MachineControllerType.EXCITER : 
										xmlEvent.getSetPointChangeData().getControllerType() == MachineControllerDataType.GOVERNOR ?
											MachineControllerType.GOVERNOR : MachineControllerType.STABILIZER);
					eSetPoint.setChangeValue(xmlEvent.getSetPointChangeData().getChangeValue());
					eSetPoint.setAbusoluteChange(xmlEvent.getSetPointChangeData().getValueChangeType() == 
									DStabStudyCaseXmlType.DynamicEventData.EventList.Event.SetPointChangeData.ValueChangeType.ABSOLUTE);
					event.setBusDynamicEvent(eSetPoint);
				}
			}
		} else {
			for (DStabStudyCaseXmlType.DynamicEventData.EventList.Event xmlEvent : xmlDstabData.getDynamicEventData().getEventList().getEventArray()) {
				// make sure that event name is not "" or NewEventName
				if (!xmlEvent.getRecName().equals(DStabDEventData.NewEventName)
						&& !xmlEvent.getRecName().trim().equals("")) {
					IpssLogger.getLogger().info("Event Data: " + xmlEvent.toString());
					// create event name
					String name = "EventAt_" + xmlEvent.getStartTimeSec() + xmlEvent.getEventType();
					// map event type
					DynamicEventType deType = XmlCaseData2DStabAlgorithmMapperImpl.getDEventType(xmlEvent.getEventType(), xmlEvent.getFault().getFaultType());
					// create the DStabEvent
					DynamicEvent event = DStabObjectFactory.createDEvent(
							xmlEvent.getRecName(), name, deType, dstabNet,
							msg);
					if (event == null) {
						CoreCommonSpringCtx.getEditorDialogUtil()
								.showErrMsgDialog("Error to create DynamicEvent", "Please see the log file for details");
						return false;
					}

					try {
						setEventData(event,	xmlEvent, xmlDstabData.getSimuConfig().getTotalSimuTimeSec(),
								dstabNet, msg);
					} catch (Exception e) {
						IpssLogger.logErr(e);
						CoreCommonSpringCtx.getEditorDialogUtil().showErrMsgDialog(
										"Error to process DynamicEvent", "See log file for details, " + e.toString());
						return false;
					}
				}
			}
		}
		return true;
	}

	private static void setEventData(DynamicEvent event,
			DStabStudyCaseXmlType.DynamicEventData.EventList.Event xmlEvent, double toltalSimuTime,
			DStabilityNetwork dstabNet, IPSSMsgHub msg) throws Exception {
		// for LoadChange  LowFreq and LowVolt startTime will set by system
		// FixedTime startTime = threshhold  always permanent
		if (xmlEvent.getEventType() == DynamicEventDataType.LOAD_CHANGE) {
			event.setPermanent(true);
			xmlEvent.setDurationSec(0.0);
			if (xmlEvent.getLoadChangeData().getLoadChangeType() == LoadChangeType.FIXED_TIME)
				xmlEvent.setStartTimeSec(xmlEvent.getLoadChangeData().getThreshhold());
			else
				xmlEvent.setStartTimeSec(toltalSimuTime);
		}

		event.setStartTimeSec(xmlEvent.getStartTimeSec());
		event.setPermanent(xmlEvent.getPermanent());
		if (event.isPermanent()) {
			event.setDurationSec(toltalSimuTime);
		} else {
			event.setDurationSec(xmlEvent.getDurationSec());
		}

		if (xmlEvent.getEventType() == DynamicEventDataType.LOAD_CHANGE) {
			IpssLogger.getLogger().info("Dynamic Event Type: LoadChange");
			event.setType(DynamicEventType.LOAD_CHANGE);
			LoadChangeData ldata = xmlEvent.getLoadChangeData();
			LoadChangeEvent eLoad = DStabObjectFactory.createLoadChangeEvent(ldata.getBusId(), dstabNet);
			eLoad.setType(ldata.getLoadChangeType() == LoadChangeType.LOW_FREQUENCY ? 
						LoadChangeEventType.LOW_FREQUENCY
							: (ldata.getLoadChangeType() == LoadChangeType.LOW_VOLTAGE? 
									LoadChangeEventType.LOW_VOLTAGE	: LoadChangeEventType.FIXED_TIME));
			eLoad.setChangeFactor(ldata.getChangeFactor());
			eLoad.setThreshhold(ldata.getThreshhold());
			eLoad.setDelaySec(ldata.getDelayTime());
			event.setBusDynamicEvent(eLoad);
		} 
		else if (xmlEvent.getEventType() == DynamicEventDataType.FAULT) {
			AcscFaultXmlType fdata = xmlEvent.getFault();
			if (xmlEvent.getFault().getFaultType() == AcscFaultDataType.BRANCH_OUTAGE) {
				IpssLogger.getLogger().info("Dynamic Event Type: BranchOutage");
				event.setType(DynamicEventType.BRANCH_OUTAGE);
				BranchOutageEvent bOutageEvent = DStabObjectFactory
						.createBranchOutageEvent(fdata.getBusBranchId(), dstabNet);
				if (fdata.getFaultCategory() == AcscFaultCategoryDataType.OUTAGE_3_PHASE)
					bOutageEvent.setOutageType(BranchOutageType.THREE_PHASE);
				else if (fdata.getFaultCategory() == AcscFaultCategoryDataType.OUTAGE_1_PHASE)
					bOutageEvent.setOutageType(BranchOutageType.SINGLE_PHASE);
				else if (fdata.getFaultCategory() == AcscFaultCategoryDataType.OUTAGE_2_PHASE)
					bOutageEvent.setOutageType(BranchOutageType.DOUBLE_PHASE);
				event.setBranchDynamicEvent(bOutageEvent);
			} 
			else if (fdata.getFaultType() == AcscFaultDataType.BUS_FAULT) {
				event.setType(DynamicEventType.BUS_FAULT);
				AcscBusFault fault = CoreObjectFactory.createAcscBusFault(Constants.Token_BusFaultId + fdata.getBusBranchId());
				RunCaseMapperHelper.acscFaultData2AcscBusFaultMapping(fdata, fault);
				event.setBusFault(fault);
				DStabBus bus = dstabNet.getDStabBus(NetUtilFunc.getBusIdFromDisplayNameId(fdata.getBusBranchId()));
				if (bus != null)
					fault.setFaultBus(bus);
				else {
					throw new InvalidParameterException("Programming erroe, Bus cannot be found, id:" + fdata.getBusBranchId());
				}
			} 
			else if (fdata.getFaultType() == AcscFaultDataType.BRANCH_FAULT) {
				event.setType(DynamicEventType.BRANCH_FAULT);
				DStabBranchFault fault = XmlCaseData2DStabAlgorithmMapperImpl.createDStabBranchFault(fdata, dstabNet);
				event.setBranchFault(fault);
				if (fault.isReclosure()) {
					String name = "EventAt_" + xmlEvent.getStartTimeSec() + xmlEvent.getEventType();
					DynamicEvent event2 = DStabObjectFactory.createDEvent(event.getId()
							+ "-Reclosure", name, DynamicEventType.BRANCH_RECLOSURE, dstabNet, msg);
					event2.setStartTimeSec(fault.getReclosureTime());
					event2.setDurationSec(toltalSimuTime);
					event2.setPermanent(true);
					event2.setBranchFault(XmlCaseData2DStabAlgorithmMapperImpl
							.createDStabBranchFault(fdata, dstabNet));
				}
			}
		}
	}

	private static DStabBranchFault createDStabBranchFault(AcscFaultXmlType fdata,	DStabilityNetwork dstabNet) {
		DStabBranchFault fault = DStabObjectFactory
				.createDStabBranchFault(Constants.Token_BranchFaultId + fdata.getBusBranchId());
		RunCaseMapperHelper.acscFaultData2AcscBranchFaultMapping(fdata, fault);
		fault.setReclosure(fdata.getBranchReclosure());
		fault.setReclosureTime(fdata.getReclosureTime());
		DStabBranch branch = dstabNet.getDStabBranch(NetUtilFunc.getBranchIdFromDisplayNameId(fdata.getBusBranchId()));
		if (branch != null)
			fault.setFaultBranch(branch);
		else {
			throw new InvalidParameterException(
					"Programming error, Branch cannot be found, id:" + fdata.getBusBranchId());
		}
		return fault;
	}

	private static DynamicEventType getDEventType(DynamicEventDataType.Enum xmlEventType, AcscFaultDataType.Enum xmlFaultType) {
		if (xmlEventType == DynamicEventDataType.FAULT) {
			if (xmlFaultType == AcscFaultDataType.BUS_FAULT)
				return DynamicEventType.BUS_FAULT;
			else if (xmlFaultType == AcscFaultDataType.BRANCH_FAULT)
				return DynamicEventType.BRANCH_FAULT;
			else if (xmlFaultType == AcscFaultDataType.BRANCH_OUTAGE)
				return DynamicEventType.BRANCH_OUTAGE;
		}
		else if (xmlEventType == DynamicEventDataType.LOAD_CHANGE) 
			return DynamicEventType.LOAD_CHANGE;
		else if (xmlEventType == DynamicEventDataType.SET_POINT_CHANGE) 
			return DynamicEventType.SET_POINT_CHANGE;
		else {
			throw new InvalidParameterException("Programming error, eventDataType: " + xmlEventType);
		}
		return null;
	}
}