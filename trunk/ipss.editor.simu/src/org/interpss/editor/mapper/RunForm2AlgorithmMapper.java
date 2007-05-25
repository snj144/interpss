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

package org.interpss.editor.mapper;

import org.apache.commons.math.complex.Complex;
import org.interpss.editor.data.acsc.AcscFaultData;
import org.interpss.editor.data.dstab.DStabDEventData;
import org.interpss.editor.data.dstab.DStabLoadChangeData;
import org.interpss.editor.data.proj.AclfCaseData;
import org.interpss.editor.data.proj.AcscCaseData;
import org.interpss.editor.data.proj.DStabCaseData;
import org.interpss.editor.runAct.AclfRunForm;
import org.interpss.editor.runAct.AcscRunForm;
import org.interpss.editor.runAct.DStabRunForm;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Constants;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.exp.InvalidParameterException;
import com.interpss.common.mapper.AbstractMapper;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.acsc.AcscBranchFault;
import com.interpss.core.acsc.AcscBusFault;
import com.interpss.core.acsc.SimpleFaultCode;
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
import com.interpss.dstab.devent.DStabBranchFault;
import com.interpss.dstab.devent.DynamicEvent;
import com.interpss.dstab.devent.DynamicEventType;
import com.interpss.dstab.devent.LoadChangeEvent;
import com.interpss.dstab.devent.SetPointChangeEvent;
import com.interpss.dstab.mach.ControllerType;
import com.interpss.dstab.mach.Machine;

public class RunForm2AlgorithmMapper extends AbstractMapper {

	public RunForm2AlgorithmMapper() {
	}

	/**
	 * map(load) a <*>RunForm object into an Algorithm object
	 * 
	 * @param fromObj a <*>RunForm object
	 * @param toObj an Algorithm object
	 * @param kclass class type of the toObj 
	 */	
	public boolean mapping(Object fromObj, Object toObj, Class<?> klass) {
		if (klass == LoadflowAlgorithm.class) {
			AclfRunForm runForm = (AclfRunForm)fromObj;
	  		LoadflowAlgorithm algo = (LoadflowAlgorithm)toObj;
	  		aclfRunForm2LFAlgorithmMapping(runForm, algo);
		}
		else if (klass == SimpleFaultAlgorithm.class) {
			AcscRunForm runForm = (AcscRunForm)fromObj;
			SimpleFaultAlgorithm algo = (SimpleFaultAlgorithm)toObj;
			acscRunForm2SimpleFaultAlgorithmMapping(runForm, algo);
		}
		else if (klass == AcscBusFault.class) {
			AcscFaultData data = (AcscFaultData)fromObj;
			AcscBusFault fault = (AcscBusFault)toObj;
			acscFaultData2AcscBusFaultMapping(data, fault);
		}
		else if (klass == AcscBranchFault.class) {
			AcscFaultData data = (AcscFaultData)fromObj;
			AcscBranchFault fault = (AcscBranchFault)toObj;
			acscFaultData2AcscBranchFaultMapping(data, fault);
		}
		else if (klass == DynamicSimuAlgorithm.class) {
			DStabRunForm runForm = (DStabRunForm)fromObj;
			DynamicSimuAlgorithm algo = (DynamicSimuAlgorithm)toObj;
			dStabRunForm2DynamicSimuAlgorithmMapping(runForm, algo);
		}
		return true;
	}
	
	private void aclfRunForm2LFAlgorithmMapping(AclfRunForm runForm, LoadflowAlgorithm algo) {
		aclfRunForm2LFAlgorithmMapping(runForm.getAclfCaseData(), algo);
	}

	private void aclfRunForm2LFAlgorithmMapping(AclfCaseData caseData, LoadflowAlgorithm algo) {
	  	algo.setLfMethod(caseData.getMethod().equals(AclfCaseData.Method_NR)? AclfMethod.NR_LITERAL :
	  				(caseData.getMethod().equals(AclfCaseData.Method_PQ)? AclfMethod.PQ_LITERAL : AclfMethod.GS_LITERAL));
/* no need for this. PQ method can handle PSXfr now
	  	if (algo.getAclfAdjNetwork().hasPSXfr() && algo.getLfMethod() == AclfMethod.PQ_LITERAL)
		  	algo.setLfMethod(AclfMethod.NR_LITERAL);
*/	  		
	  	algo.setMaxIterations(caseData.getMaxIteration());
	  	algo.setTolerance(caseData.getTolerance());
	  	algo.setInitBusVoltage(caseData.getInitBusVolt());
	  	algo.setGsAccFactor(caseData.getAccFactor());			
	}
	
	private void acscRunForm2SimpleFaultAlgorithmMapping(AcscRunForm runForm, SimpleFaultAlgorithm algo) {
		algo.setMultiFactor(runForm.getAcscCaseData().getMFactor()*0.01);
		// algo.multiFactor in PU and acscData.getMFactor in %
		algo.setScBusVoltage(runForm.getAcscCaseData().getBusInitVolt().equals(AcscCaseData.ScBusVolt_UnitVolt)?
				ScBusVoltage.UNIT_VOLT_LITERAL : ScBusVoltage.LOADFLOW_VOLT_LITERAL); // UnitV | LFVolt	
	}

	private void acscFaultData2AcscBusFaultMapping(AcscFaultData data, AcscBusFault fault) {
		fault.setFaultCode(data.getCategory().equals(AcscFaultData.FaultCaty_LLG)? SimpleFaultCode.GROUND_LLG_LITERAL :
			(data.getCategory().equals(AcscFaultData.FaultCaty_LG)? SimpleFaultCode.GROUND_LG_LITERAL :
				(data.getCategory().equals(AcscFaultData.FaultCaty_LL)? SimpleFaultCode.GROUND_LL_LITERAL :
					SimpleFaultCode.GROUND_3P_LITERAL)));
		fault.setZLGFault(new Complex(data.getLG_R(), data.getLG_X()));
		fault.setZLLFault(new Complex(data.getLL_R(), data.getLL_X())); 
	}
	
	private void acscFaultData2AcscBranchFaultMapping(AcscFaultData data, AcscBranchFault fault) {
		fault.setFaultCode(data.getCategory().equals(AcscFaultData.FaultCaty_LLG)? SimpleFaultCode.GROUND_LLG_LITERAL :
			(data.getCategory().equals(AcscFaultData.FaultCaty_LG)? SimpleFaultCode.GROUND_LG_LITERAL :
				(data.getCategory().equals(AcscFaultData.FaultCaty_LL)? SimpleFaultCode.GROUND_LL_LITERAL :
					SimpleFaultCode.GROUND_3P_LITERAL)));
		fault.setZLGFault(new Complex(data.getLG_R(), data.getLG_X()));
		fault.setZLLFault(new Complex(data.getLL_R(), data.getLL_X()));  		
		fault.setDistance(data.getDistance(), UnitType.Percent);
	}

	private void dStabRunForm2DynamicSimuAlgorithmMapping(DStabRunForm runForm, DynamicSimuAlgorithm algo) {
		mapDStabAlgorithm(runForm, algo);
		
		map2DStabNetwork(runForm, algo);

		DStabilityNetwork dstabNet = algo.getDStabNet();
		if (runForm.getDStabCaseData().getDisableDynamicEvent()) {
			if (runForm.getDStabCaseData().isSetPointChange()) {
				IpssLogger.getLogger().info("Dynamic Event Type: SetPointChange");
				DStabCaseData caseData = runForm.getDStabCaseData();
				String machId = caseData.getSetPointChangeMachId();
				DynamicEvent event = DStabObjectFactory.createDEvent("SetPointChange@"+machId, "SetPointChange", 
						DynamicEventType.SET_POINT_CHANGE_LITERAL, dstabNet, msg);
				event.setStartTimeSec(0.0);
				event.setDurationSec(runForm.getDStabCaseData().getTotalSimuTime());
				SetPointChangeEvent eSetPoint = DStabObjectFactory.createSetPointChangeEvent(machId, dstabNet);
				eSetPoint.setControllerType(
						caseData.getSelectedController().equals(Constants.ExciterToken)? ControllerType.EXCITER_LITERAL :
							caseData.getSelectedController().equals(Constants.GovernorToken)? 
									ControllerType.GOVERNOR_LITERAL : ControllerType.STABILIZER_LITERAL);
				eSetPoint.setChangeValue(caseData.getSetPointValueChange());
				eSetPoint.setAbusoluteChange(caseData.isSetPointChangeAbsolute());
				event.setBusDynamicEvent(eSetPoint);
			}
		}
		else {
			for (int i = 0; i < runForm.getDStabCaseData().getDEventList().size(); i++) {
				DStabDEventData eventData = (DStabDEventData)runForm.getDStabCaseData().getDEventList().get(i);
				// make sure that event name is not "" or NewEventName
				if (!eventData.getEventName().equals(DStabDEventData.NewEventName) && !eventData.getEventName().trim().equals("")) {
					IpssLogger.getLogger().info("Event Data: " + eventData);
					// create event name
					String name = "EventAt_" + eventData.getStartTime() + eventData.getType();
					// map event type 
					DynamicEventType deType = getDEventType(eventData.getType());
					// create the DStabEvent
					DynamicEvent event = DStabObjectFactory.createDEvent(eventData.getEventName(), name, deType, dstabNet, msg);
					if (event == null) {
						SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Error to create DynamicEvent", "Please see the log file for details");
						return;
					}

					try {
						setEventData(event, eventData, runForm.getDStabCaseData().getTotalSimuTime(), dstabNet, msg);
					} catch (Exception e) {
						IpssLogger.logErr(e);
						SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Error to process DynamicEvent", "See log file for details, " + e.toString());
						return;				
					}
				}
			}
		}
	}
	
	private DynamicEventType getDEventType(String eventDataType) {
		if (eventDataType.equals(DStabDEventData.DEventType_BusFault))
			return DynamicEventType.BUS_FAULT_LITERAL;
		else if (eventDataType.equals(DStabDEventData.DEventType_BranchFault))
			return DynamicEventType.BRANCH_FAULT_LITERAL;
		else if (eventDataType.equals(DStabDEventData.DEventType_LoadChange))
			return DynamicEventType.LOAD_CHANGE_LITERAL;		
		else if (eventDataType.equals(DStabDEventData.DEventType_SetPointChange))
			return DynamicEventType.SET_POINT_CHANGE_LITERAL;		
		else 
			throw new InvalidParameterException("Programming error, eventDataType: " + eventDataType);
	}
	
	private void setEventData(DynamicEvent event, DStabDEventData eventData, 
			double toltalSimuTime, DStabilityNetwork dstabNet, IPSSMsgHub msg) throws Exception {
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
			event.setType(DynamicEventType.LOAD_CHANGE_LITERAL);
			DStabLoadChangeData ldata = eventData.getLoadChangeData();
			LoadChangeEvent eLoad = DStabObjectFactory.createLoadChangeEvent(ldata.getBusId(), dstabNet);
			eLoad.setChangeFactor(ldata.getChangeFactor());
			event.setBusDynamicEvent(eLoad);
		}
		else {
			IpssLogger.getLogger().info("Dynamic Event Type: Fualt");
			event.setType(eventData.getType().equals(DStabDEventData.DEventType_BusFault) ? 
					DynamicEventType.BUS_FAULT_LITERAL : DynamicEventType.BRANCH_FAULT_LITERAL );
			
			AcscFaultData fdata = eventData.getFaultData();
			if (fdata.getType().equals(AcscFaultData.FaultType_Bus)) {
				AcscBusFault fault = CoreObjectFactory.createAcscBusFault("Bus Fault at " +	fdata.getBusId());
				mapping(fdata, fault, AcscBusFault.class);
				event.setBusFault(fault);
				DStabBus bus = dstabNet.getDStabBus(fdata.getBusId());
				if (bus != null)
					fault.setFaultBus(bus);
				else {
					throw new InvalidParameterException("Programming erroe, Bus cannot be found, id:" + fdata.getBusId());
				}
			}
			else {
				DStabBranchFault fault = createDStabBranchFault(fdata, dstabNet);
				event.setBranchFault(fault);
				if (fault.isReclosure()) {
					String name = "EventAt_" + eventData.getStartTime() + eventData.getType();
					DynamicEvent event2 = DStabObjectFactory.createDEvent(
							event.getId()+"-Reclosure", name, DynamicEventType.BRANCH_RECLOSURE_LITERAL, dstabNet, msg);
					event2.setStartTimeSec(fault.getReclosureTime());
					event2.setDurationSec(toltalSimuTime);
					event2.setPermanent(true);
					event2.setBranchFault(createDStabBranchFault(fdata, dstabNet));
				}
			}
		}
	}

	private DStabBranchFault createDStabBranchFault(AcscFaultData fdata, DStabilityNetwork dstabNet) {
		DStabBranchFault fault = DStabObjectFactory.createDStabBranchFault("Branch Fault at " + fdata.getBranchId());
		mapping(fdata, fault, AcscBranchFault.class);
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
	
	private void mapDStabAlgorithm(DStabRunForm runForm, DynamicSimuAlgorithm algo) {
		aclfRunForm2LFAlgorithmMapping(runForm.getAclfCaseData(), algo.getAclfAlgorithm());

		algo.setSimuMethod(runForm.getDStabCaseData().getSimuMethod().equals(DStabCaseData.Method_RungeKutta)?
				DynamicSimuMethods.RUNGE_KUTTA_LITERAL : DynamicSimuMethods.MODIFIED_EULER_LITERAL);
		algo.setTotalSimuTimeSec(runForm.getDStabCaseData().getTotalSimuTime());
		algo.setSimuStepSec(runForm.getDStabCaseData().getSimuStep());	
		algo.setDisableDynamicEvent(runForm.getDStabCaseData().getDisableDynamicEvent());
		
		if (runForm.getDStabCaseData().isAbsoluteMachValue()) {
			algo.setRefMachine(null);
		}
		else {
			Machine mach = algo.getDStabNet().getMachine(runForm.getDStabCaseData().getRefMachId());
			IpssLogger.getLogger().info("Ref mach set to : " + mach.getId());
			algo.setRefMachine(mach);
		}
	}
	
	private void map2DStabNetwork(DStabRunForm runForm, DynamicSimuAlgorithm algo) {
		DStabilityNetwork dstabNet = algo.getDStabNet();
		dstabNet.setNetEqnIterationNoEvent(runForm.getDStabCaseData().getNetEqnItrNoEvent());
		dstabNet.setNetEqnIterationWithEvent(runForm.getDStabCaseData().getNetEqnItrWithEvent());

		dstabNet.setStaticLoadModel(runForm.getDStabCaseData().getStaticLoadType().equals(
				DStabCaseData.StaticLoad_Const_Z)? StaticLoadModel.CONST_Z_LITERAL : StaticLoadModel.CONST_P_LITERAL);
		dstabNet.setStaticLoadSwitchVolt(runForm.getDStabCaseData().getStaticLoadSwitchVolt());
		dstabNet.setStaticLoadSwitchDeadZone(runForm.getDStabCaseData().getStaticLoadSwitchDeadZone());
	}
}
