package org.interpss.mapper.odm.impl.dstab;

import org.apache.commons.math.complex.Complex;
import org.ieee.odm.schema.AclfAlgorithmXmlType;
import org.ieee.odm.schema.AcscFaultXmlType;
import org.ieee.odm.schema.AnalysisCategoryEnumType;
import org.ieee.odm.schema.ApparentPowerXmlType;
import org.ieee.odm.schema.BaseBranchXmlType;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.DStabMethodEnumType;
import org.ieee.odm.schema.DStabSimuSettingXmlType;
import org.ieee.odm.schema.DStabilitySimulationXmlType;
import org.ieee.odm.schema.DynamicEventXmlType;
import org.ieee.odm.schema.DynamicGeneratorXmlType;
import org.ieee.odm.schema.IpssStudyScenarioXmlType;
import org.ieee.odm.schema.LfMethodEnumType;
import org.ieee.odm.schema.ScenarioXmlType;
import org.ieee.odm.schema.StaticLoadEnumType;
import org.ieee.odm.schema.StaticLoadModelXmlType;
import org.ieee.odm.schema.TimePeriodUnitType;
import org.ieee.odm.schema.TimePeriodXmlType;
import org.ieee.odm.schema.ZXmlType;

import com.interpss.common.exp.InterpssException;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.acsc.AcscBusFault;
import com.interpss.core.acsc.SimpleFaultCode;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.net.Branch;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuAlgorithm;
import com.interpss.dstab.DynamicSimuMethod;
import com.interpss.dstab.StaticLoadModel;
import com.interpss.dstab.devent.BranchOutageEvent;
import com.interpss.dstab.devent.DStabBranchFault;
import com.interpss.dstab.devent.DynamicEvent;
import com.interpss.dstab.devent.DynamicEventType;
import com.interpss.dstab.mach.Machine;

public class DStabScenarioHelper {
	
	private DStabilityNetwork dstabNet = null;
	private DynamicSimuAlgorithm dstabAlgo = null;	
	public DStabScenarioHelper(DStabilityNetwork dstabNet, DynamicSimuAlgorithm algo) {
		this.dstabNet = dstabNet;
		this.dstabAlgo = algo;	
	}
	
	public void mapOneFaultScenario( IpssStudyScenarioXmlType sScenarioXml) throws InterpssException {
		if(sScenarioXml.getAnalysisCategory() == AnalysisCategoryEnumType.TRANSIENT_STABILITY &&
				sScenarioXml.getScenarioList().getScenario() != null &&
				sScenarioXml.getScenarioList().getScenario().size() == 1){
			// first we check if dstab analysis type, scenario is defined and only one scenario 
			// is defined
			ScenarioXmlType scenario = sScenarioXml.getScenarioList().getScenario().get(0);
			if (scenario.getSimuAlgo() != null && scenario.getSimuAlgo().getDStabAnalysis() != null)
				// then we check if simuAlgo and dstabAnalysis info if defined
				mapDStabSimuAlgo(scenario.getSimuAlgo().getDStabAnalysis());
			else
				throw new InterpssException("Acsc Scenario mapping error: data not defined properly");
		}
		else {
			throw new InterpssException("Acsc StudyScenario mapping error: data not defined properly");
		}
	}
	
	private void mapDStabSimuAlgo(DStabilitySimulationXmlType dstabSimuXml) {
		DStabSimuSettingXmlType settings = dstabSimuXml.getSimulationSetting();
		mapGeneralSettings(settings);
		
		AclfAlgorithmXmlType lfInit = dstabSimuXml.getAclfInitialization();
		mapAclfInitialization (lfInit);		
		
		dstabAlgo.setDisableDynamicEvent(dstabSimuXml.getDynamicEvents().isDisableDynEvents());
		for (DynamicEventXmlType eventXml : dstabSimuXml.getDynamicEvents().getDynamicEvent()) {			
			mapDynamicEvent( eventXml);
		}		
	}

	
	private void mapGeneralSettings(DStabSimuSettingXmlType settings){
		// map numerical iteration method
		DStabMethodEnumType method =  settings.getDstabMethod();
		if(method == DStabMethodEnumType.RUNGER_KUTTA){
			dstabAlgo.setSimuMethod(DynamicSimuMethod.RUNGE_KUTTA);
		}
		else {
			dstabAlgo.setSimuMethod(DynamicSimuMethod.MODIFIED_EULER);
		}
		
		// map total time, unit is sec
		TimePeriodXmlType tolTime = settings.getTotalTime();		
		double tolTimeInSec = convertTimeUnit2Sec(tolTime,this.dstabNet.getFrequency());
		dstabAlgo.setTotalSimuTimeSec(tolTimeInSec);
		
		// map time step,  unit is sec
		TimePeriodXmlType stepTime = settings.getStep();		
		double stepTimeInSec = convertTimeUnit2Sec(stepTime,this.dstabNet.getFrequency());
		dstabAlgo.setSimuStepSec(stepTimeInSec);
		
		if (settings.isAbsMachineAngle() != null) {
			if(!settings.isAbsMachineAngle()){
				String refMachId=((DynamicGeneratorXmlType)settings.getRefMachine().getIdRef()).getGenId().getId();
				Machine mach = dstabNet.getMachine(refMachId); 
				dstabAlgo.setRefMachine(mach);			
			} 
		}

		// TODO set refMach
		
		//set net equn interation
		if (settings.getNetEqnSolveConfig() != null) {
			int intNoEvent = settings.getNetEqnSolveConfig().getNetEqnItrNoEvent();
			int intWEvent = settings.getNetEqnSolveConfig().getNetEqnItrWithEvent();
			if(intNoEvent != 0){
				dstabNet.setNetEqnIterationNoEvent(intNoEvent);
			}
	        if(intWEvent != 0){
			    dstabNet.setNetEqnIterationWithEvent(intWEvent);	
			}
		}
        
        StaticLoadModelXmlType statLoad = settings.getStaticLoadModel();
        if(statLoad.getStaticLoadType() == StaticLoadEnumType.CONST_Z){
        	dstabNet.setStaticLoadModel(StaticLoadModel.CONST_Z);
        }
        else {
        	// set switch vol and dead zone for constant-P static load
        	dstabNet.setStaticLoadModel(StaticLoadModel.CONST_P);
        
        	if (settings.getStaticLoadModel().getSwitchDeadZone() != null) {
        		double deadZone = settings.getStaticLoadModel().getSwitchDeadZone();
            	dstabNet.setStaticLoadSwitchDeadZone(deadZone);
        	}

        	if (settings.getStaticLoadModel().getSwitchVolt() != null)  {
            	double switchVolt = settings.getStaticLoadModel().getSwitchVolt();        	
            	dstabNet.setStaticLoadSwitchVolt(switchVolt);
        	}
        }
	}
	
	private void mapAclfInitialization (AclfAlgorithmXmlType lfInit){
		LoadflowAlgorithm aclfAlgo = this.dstabAlgo.getAclfAlgorithm();	
		
		// set lf method
		LfMethodEnumType lfMethod = lfInit.getLfMethod();
		if(lfMethod == LfMethodEnumType.PQ){
			aclfAlgo.setLfMethod(AclfMethod.PQ);			
		}else if(lfMethod == LfMethodEnumType.GS){
			aclfAlgo.setLfMethod(AclfMethod.GS);			
		}
		else 
			aclfAlgo.setLfMethod(AclfMethod.NR);			

		int maxInt =lfInit.getMaxIterations();
		aclfAlgo.setMaxIterations(maxInt);
		ApparentPowerXmlType tol = lfInit.getTolerance();
		aclfAlgo.setTolerance(tol.getValue());
		aclfAlgo.setInitBusVoltage(lfInit.isInitBusVoltage());
		
		if(lfInit.getAccFactor()!=null){
			aclfAlgo.setGsAccFactor(lfInit.getAccFactor());
		}
		
		if(lfInit.isNonDivergent()!=null){
			aclfAlgo.setNonDivergent(lfInit.isNonDivergent());
		}	
		
		// set load flow initialization in the dstab analysis
		dstabAlgo.setAclfAlgorithm(aclfAlgo);
	}
	
	public void mapDynamicEvent (DynamicEventXmlType eventXml){
		AcscFaultXmlType fault=eventXml.getFault();
		String eventId = eventXml.getId();
		//String eventName = eventXml.getName();
		String faultType = fault.getFaultType().toString();
		String faultCate = fault.getFaultCategory().toString();
		ZXmlType zLG = fault.getZLG();
		ZXmlType zLL = fault.getZLL();
		SimpleFaultCode faultCode =null;
		if(faultCate.equals("FAULT_3_P")){
			faultCode=SimpleFaultCode.GROUND_3P;
		}else if (faultCate.equals("FAULT_LG")){
			faultCode=SimpleFaultCode.GROUND_LG;
		}else if (faultCate.equals("FAULT_LL")){
			faultCode=SimpleFaultCode.GROUND_LL;
		}else if (faultCate.equals("FAULT_LLG")){
			faultCode=SimpleFaultCode.GROUND_LLG;
		}
				
		// create a new event		
		DynamicEvent dEvent = null;
		
		//new AcscScenarioHelper(dstabNet)
		//.mapAcscFaultNetwork(faultXml);
		
		// specify the type of this dEvent
		if(faultType.equals("BUS_FAULT")){
			dEvent = DStabObjectFactory.createDEvent(eventId, eventName, 
					DynamicEventType.BUS_FAULT, dstabNet, dstabAlgo.getMsgHub());			
			
			String faultBusId=((BusXmlType)fault.getBusBranchId().getIdRef()).getId();
			DStabBus faultBus = dstabNet.getDStabBus(faultBusId);
			/*AcscBusFault acscBusFault = dstabNet.getFault(faultBusId);*/
			AcscBusFault acscBusFault = CoreObjectFactory.createAcscBusFault(eventId);
			acscBusFault.setAcscBus(faultBus);
			acscBusFault.setFaultCode(faultCode);
			if(zLG != null){
				acscBusFault.setZLGFault(new Complex (zLG.getRe(),zLG.getIm()));
			}
			if(zLL != null){
				acscBusFault.setZLLFault(new Complex (zLL.getRe(),zLL.getIm()));
			}			
			dEvent.setBusFault(acscBusFault);
			
		}else if (faultType.equals("BRANCH_FAULT")){
			dEvent = DStabObjectFactory.createDEvent(eventId, eventName, 
					DynamicEventType.BRANCH_FAULT, dstabNet, dstabAlgo.getMsgHub());			
			
			String faultBranchId=((BaseBranchXmlType)fault.getBusBranchId().getIdRef()).getId();
			Branch bra = dstabNet.getBranch(faultBranchId);
			String fromBusId = bra.getFromBusId();
			String toBusId = bra.getToBusId();
			double distance = fault.getDistance();
			
			double reclosureTime = convertTimeUnit2Sec(fault.getReclosureTime(), this.dstabNet.getFrequency());
			double rLG=0;
			double xLG=0;
			double rLL=0;
			double xLL=0;
			if(zLG != null){
				rLG=zLG.getRe();
				xLG=zLG.getIm();
			}
			if(zLL != null){
				rLL=zLL.getRe();
				xLL=zLL.getIm();
			}			
			DStabBranchFault dBraFault = DStabObjectFactory.createDStabBranchFault(dstabNet, 
					fromBusId, toBusId, faultCode, distance, rLG, xLG, 
					rLL, xLL, fault.isBranchReclosure(), reclosureTime);
			dEvent.setBranchFault(dBraFault);
			
			
		}else if (faultType.equals("BRANCH_OUTAGE")){
			String branchId=((BaseBranchXmlType)fault.getBusBranchId().getIdRef()).getId();			
			
			BranchOutageEvent braOutEvent = DStabObjectFactory.createBranchOutageEvent(branchId, dstabNet);			
			
			//(TODO: HOW TO SET BRANCH-OUTAGE-EVENT?)			
			
		}
	
		dEvent.setPermanent(eventXml.isPermanentFault());
		TimePeriodXmlType startTime = eventXml.getStartTime();
		double startTimeInSec= convertTimeUnit2Sec(startTime,this.dstabNet.getFrequency());
		dEvent.setStartTimeSec(startTimeInSec);
		double durationTimeInSec = convertTimeUnit2Sec(eventXml.getDuration(),
				this.dstabNet.getFrequency());
		dEvent.setDurationSec(durationTimeInSec);
		
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
