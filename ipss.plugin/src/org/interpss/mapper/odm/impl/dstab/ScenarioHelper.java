package org.interpss.mapper.odm.impl.dstab;

import org.ieee.odm.schema.AclfAlgorithmXmlType;
import org.ieee.odm.schema.AnalysisTypeXmlType;
import org.ieee.odm.schema.ApparentPowerXmlType;
import org.ieee.odm.schema.BranchXmlType;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.DanamicEventType;
import org.ieee.odm.schema.DynamicGeneratorXmlType;
import org.ieee.odm.schema.ScenarioXmlType;
import org.ieee.odm.schema.StaticLoadModelCatType;
import org.ieee.odm.schema.StaticLoadModelType;
import org.ieee.odm.schema.TimePeriodUnitType;
import org.ieee.odm.schema.TimePeriodXmlType;
import org.ieee.odm.schema.TransientSimulationXmlType;
import org.ieee.odm.schema.TransientSimulationXmlType.SimulationSetting;
import org.interpss.mapper.odm.impl.AcscScenarioHelper;

import com.interpss.core.CoreObjectFactory;
import com.interpss.core.acsc.AcscBranchFault;
import com.interpss.core.acsc.AcscBusFault;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.dstab.DStabBranch;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuAlgorithm;
import com.interpss.dstab.DynamicSimuMethod;
import com.interpss.dstab.StaticLoadModel;
import com.interpss.dstab.devent.BranchDynamicEvent;
import com.interpss.dstab.devent.BranchOutageEvent;
import com.interpss.dstab.devent.BusDynamicEvent;
import com.interpss.dstab.devent.DeventFactory;
import com.interpss.dstab.devent.DynamicEvent;
import com.interpss.dstab.devent.DynamicEventType;
import com.interpss.dstab.mach.Machine;



public class ScenarioHelper {
	
	private DStabilityNetwork dstabNet = null;
	private DynamicSimuAlgorithm algo = null;	
	
	public ScenarioHelper(DStabilityNetwork dstabNet,DynamicSimuAlgorithm algo) {
		this.dstabNet = dstabNet;
		this.algo = algo;		
	}
	
	//double frequency =dstabNet.getFrequency(); this will cause problem, since at the
	//                                           initial point dstabNet = null
	
	public void mapDstabFaultScenario(ScenarioXmlType faultXml){
		AnalysisTypeXmlType faultAnalysisXml= faultXml.getAnalysisType();
		TransientSimulationXmlType dstabFaultXml = faultAnalysisXml.getDStabAnalysis();		
		String idStr = dstabFaultXml.getName() != null? dstabFaultXml.getName() : dstabFaultXml.getDesc(); 
		
		SimulationSetting settings = dstabFaultXml.getSimulationSetting();
		mapGeneralSettings(settings,algo);
		AclfAlgorithmXmlType lfInit = dstabFaultXml.getAclfInitialization();
		mapAclfInitialization (lfInit);		
		for (DanamicEventType eventXml : dstabFaultXml.getDynamicEventList().getDanamicEvent()) {			
			mapDynamicEvent ( eventXml, dstabNet,faultXml);
		}		
	}
	private void mapGeneralSettings(SimulationSetting settings, DynamicSimuAlgorithm algo){
		// map numerical iteration method
		String method =  settings.getMethod();
		if(method.equals("ModifiedEuler")){
			algo.setSimuMethod(DynamicSimuMethod.MODIFIED_EULER);
		}else if (method.equals("RungerKutta")){
			algo.setSimuMethod(DynamicSimuMethod.RUNGE_KUTTA);
		}
		// map total time, unit is sec
		TimePeriodXmlType tolTime = settings.getTotalTime();		
		double tolTimeInSec = convertTimeUnit2Sec(tolTime,this.dstabNet.getFrequency());
		algo.setTotalSimuTimeSec(tolTimeInSec);
		// map time step,  unit is sec
		TimePeriodXmlType stepTime = settings.getStep();		
		double stepTimeInSec = convertTimeUnit2Sec(stepTime,this.dstabNet.getFrequency());
		algo.setSimuStepSec(stepTimeInSec);
		
		algo.setDisableDynamicEvent(settings.isDisableDynEvents());	
		
		if(!settings.isAbsMachineAngle()){
			String refMachId=((DynamicGeneratorXmlType)settings.getRefMachine().getIdRef()).getGenId().getId();
			Machine mach = dstabNet.getMachine(refMachId); 
			algo.setRefMachine(mach);			
		} 
		//set net equn interation
		int intNoEvent = settings.getNetEqnIterationNoEvent();
		int intWEvent = settings.getNetEqnIterationWithEvent();
		if(intNoEvent != 0){
			dstabNet.setNetEqnIterationNoEvent(intNoEvent);
		}
        if(intWEvent != 0){
		    dstabNet.setNetEqnIterationWithEvent(intWEvent);	
		}
        // 
        algo.setOutputFiltered(settings.isOutPutVariableFilter());
        
        StaticLoadModelType statLoad = settings.getStaticLoadModel();
        StaticLoadModelCatType loadType = statLoad.getType();
        if(loadType.toString().equals("CONSTANT_Z")){
        	dstabNet.setStaticLoadModel(StaticLoadModel.CONST_Z);
        }else {
        	// set switch vol and dead zone for constant-P static load
        	dstabNet.setStaticLoadModel(StaticLoadModel.CONST_P);
        	double deadZone =settings.getStaticLoadModel()
			.getConstantP().getDeadZone();
        	double switchVolt =settings.getStaticLoadModel()
			.getConstantP().getSwitchVolt();        	
        	 
        	dstabNet.setStaticLoadSwitchDeadZone(deadZone);
        	dstabNet.setStaticLoadSwitchVolt(switchVolt);
        }
	}
	
	private void mapAclfInitialization (AclfAlgorithmXmlType lfInit){
		LoadflowAlgorithm lfAlgo = CoreObjectFactory.createLoadflowAlgorithm(dstabNet, algo.getMsgHub());
		// set lf method
		String lfMethod = lfInit.getLfMethod();
		if(lfMethod.equals("NR")){
			lfAlgo.setLfMethod(AclfMethod.NR);			
		}else if(lfMethod.equals("PQ")){
			lfAlgo.setLfMethod(AclfMethod.PQ);			
		}else if(lfMethod.equals("GS")){
			lfAlgo.setLfMethod(AclfMethod.GS);			
		}
		int maxInt =lfInit.getMaxIterations();
		lfAlgo.setMaxIterations(maxInt);
		ApparentPowerXmlType tol = lfInit.getTolerance();
		lfAlgo.setTolerance(tol.getValue());
		lfAlgo.setInitBusVoltage(lfInit.isInitBusVoltage());
		if(lfInit.getAccFactor()!=null){
			lfAlgo.setGsAccFactor(lfInit.getAccFactor());
		}
		if(lfInit.isNonDivergent()!=null){
			lfAlgo.setNonDivergent(lfInit.isNonDivergent());
		}		
		// set load flow initialization in the dstab analysis
		algo.setAclfAlgorithm(lfAlgo);
		
	}
	
	public void mapDynamicEvent (DanamicEventType eventXml, DStabilityNetwork dstabNet,
			ScenarioXmlType faultXml){
		
		String eventId = faultXml.getId();
		String faultType = eventXml.getFault().getFaultType().toString();
		DeventFactory dEventFact = DeventFactory.eINSTANCE; 		
		// create a new event
		DynamicEvent dEvent= dEventFact.createDynamicEvent();
		
		new AcscScenarioHelper(dstabNet)
		.mapAcscFaultNetwork(faultXml);
		
		// specify the type of this dEvent
		if(faultType.equals("BUS_FAULT")){
			
			BusDynamicEvent busEvent = dEventFact.createBusDynamicEvent();
			busEvent.setId(eventId);
			dEvent.setType(DynamicEventType.BUS_FAULT);
			dEvent.setBusDynamicEvent(busEvent);
			String faultBusId=((BusXmlType)eventXml.getFault().getBusBranchId().getIdRef()).getId();
			AcscBusFault acscBusFault = dstabNet.getFault(faultBusId);
			dEvent.setBusFault(acscBusFault);
			
		}else if (faultType.equals("BRANCH_FAULT")){
			BranchDynamicEvent braEvent =dEventFact.createBranchDynamicEvent();
			braEvent.setId(eventId);
			dEvent.setType(DynamicEventType.BRANCH_FAULT);
			dEvent.setBranchDynamicEvent(braEvent);
			String faultBraId=((BranchXmlType)eventXml.getFault().getBusBranchId().getIdRef()).getId();
			//DStabBranchFault dstabBranch =;			
			//dEvent.setBranchFault(dstabBranch);
			
		}else if (faultType.equals("BRANCH_OUTAGE")){
			BranchOutageEvent braOutEvent = dEventFact.createBranchOutageEvent();
			braOutEvent.setId(eventId);
			dEvent.setType(DynamicEventType.BRANCH_OUTAGE);
			//(TODO: lack setBranchOutageEvent method)
		}
	
		dEvent.setPermanent(eventXml.isPermanentFault());
		TimePeriodXmlType startTime = eventXml.getStartTime();
		double startTimeInSec= convertTimeUnit2Sec(startTime,this.dstabNet.getFrequency());
		dEvent.setStartTimeSec(startTimeInSec);
		double durationTimeInSec = convertTimeUnit2Sec(eventXml.getDuration(),
				this.dstabNet.getFrequency());
		dEvent.setDurationSec(durationTimeInSec);
		
		dstabNet.addDynamicEvent(dEvent, eventId, algo.getMsgHub());				
		
	}
	
	public double convertTimeUnit2Sec(TimePeriodXmlType timeXml, double frequency){
		Double val = timeXml.getValue();
		TimePeriodUnitType unit= timeXml.getUnit();
		if(unit.equals("Min")){
			val=val*60;
		}else if(unit.equals("Hour")){
			val=val*60*60;
		}else if(unit.equals("Cycle")){
			val=1/frequency*val;
		}
		return val;
		
	}		

}
