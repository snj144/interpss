package org.interpss.mapper.odm.impl.dstab;

import org.ieee.odm.schema.AclfAlgorithmXmlType;
import org.ieee.odm.schema.AnalysisTypeXmlType;
import org.ieee.odm.schema.ApparentPowerXmlType;
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
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuAlgorithm;
import com.interpss.dstab.DynamicSimuMethod;
import com.interpss.dstab.devent.BranchDynamicEvent;
import com.interpss.dstab.devent.BranchOutageEvent;
import com.interpss.dstab.devent.BusDynamicEvent;
import com.interpss.dstab.devent.DeventFactory;
import com.interpss.dstab.devent.DynamicEvent;



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
		for (DanamicEventType event : dstabFaultXml.getDynamicEventList().getDanamicEvent()) {			
			mapDynamicEvent ( event, dstabNet,faultXml);
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
		// map time set,  unit is sec
		TimePeriodXmlType stepTime = settings.getStep();		
		double stepTimeInSec = convertTimeUnit2Sec(tolTime,this.dstabNet.getFrequency());
		algo.setSimuStepSec(stepTimeInSec);
		
		algo.setDisableDynamicEvent(settings.isDisableDynEvents());	
		
		if(settings.isAbsMachineAngle()){
			String refMachId=((DynamicGeneratorXmlType)settings.getRefMachine().getIdRef()).getGenId().getId();
			//Machine mach = 
			//algo.setRefMachine(mach);			
		} 
		//set net equn interation
		int intNoEvent = settings.getNetEqnIterationNoEvent();
		int intWEvent = settings.getNetEqnIterationWithEvent();
		if(intNoEvent != 0){
			
		}
        if(intWEvent != 0){
			
		}
        // 
        algo.setOutputFiltered(settings.isOutPutVariableFilter());
        
        StaticLoadModelType statLoad = settings.getStaticLoadModel();
        StaticLoadModelCatType loadType = statLoad.getType();
        if(loadType.equals("Constant_Z")){
        	
        }else {
        	
        }
        // set switch vol and dead zone for constant-P static load
        
        
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
		
		lfAlgo.setGsAccFactor(lfInit.getAccFactor());
		lfAlgo.setNonDivergent(lfInit.isNonDivergent());
		// set load flow initialization in the dstab analysis
		algo.setAclfAlgorithm(lfAlgo);
		
	}
	
	public void mapDynamicEvent (DanamicEventType event, DStabilityNetwork dstabNet,
			ScenarioXmlType faultXml){
		
		String eventId = faultXml.getId();
		String faultType = event.getFault().getFaultType().toString();
		DeventFactory dEventFact = DeventFactory.eINSTANCE; 		
		// create a new event
		DynamicEvent dEvent= dEventFact.createDynamicEvent();
		// specify the type of this dEvent
		if(faultType.equals("BusFault")){
			BusDynamicEvent busEvent = dEventFact.createBusDynamicEvent();
			busEvent.setId(eventId);
			dEvent.setBusDynamicEvent(busEvent);
		}else if (faultType.equals("BranchFault")){
			BranchDynamicEvent braEvent =dEventFact.createBranchDynamicEvent();
			braEvent.setId(eventId);
			dEvent.setBranchDynamicEvent(braEvent);
		}else if (faultType.equals("BranchOutage")){
			BranchOutageEvent braOutEvent = dEventFact.createBranchOutageEvent();
			braOutEvent.setId(eventId);
			//(TODO: lack setBranchOutageEvent method)
		}
		// set the fault data under this event
		
		// ??????????I have some confusing here: should I use this method to map
		new AcscScenarioHelper(dstabNet)
			.mapAcscFaultNetwork(faultXml);	
		
		//?????????? Or should I use the following:
		//AcscBusFault acscBusFault = CoreObjectFactory.createAcscBusFault(faultBusId);
		//dEvent.setBusFault(acscBusFault);
		
		// add the event to dynamic simu algo
		algo.setDisableDynamicEvent(true);		
		
	}
	
	public double convertTimeUnit2Sec(TimePeriodXmlType timeXml, double frequency){
		Double val = timeXml.getValue();
		TimePeriodUnitType unit= timeXml.getUnit();
		if(unit.equals("Min")){
			val=val*60;
		}else if(unit.equals("Hour")){
			val=val*60*60;
		}if(unit.equals("Cycle")){
			val=1/frequency*val;
		}
		return val;
		
	}		

}
