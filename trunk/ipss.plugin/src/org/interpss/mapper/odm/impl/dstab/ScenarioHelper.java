package org.interpss.mapper.odm.impl.dstab;

import org.apache.commons.math.complex.Complex;
import org.ieee.odm.schema.AclfAlgorithmXmlType;
import org.ieee.odm.schema.AcscFaultCategoryDataType;
import org.ieee.odm.schema.AcscFaultDataType;
import org.ieee.odm.schema.AcscFaultXmlType;
import org.ieee.odm.schema.AnalysisTypeXmlType;
import org.ieee.odm.schema.ApparentPowerXmlType;
import org.ieee.odm.schema.BaseBranchXmlType;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.DanamicEventType;
import org.ieee.odm.schema.DynamicGeneratorXmlType;
import org.ieee.odm.schema.EventTypeType;
import org.ieee.odm.schema.PreFaultBusVoltageType;
import org.ieee.odm.schema.ScenarioXmlType;
import org.ieee.odm.schema.StaticLoadModelCatType;
import org.ieee.odm.schema.StaticLoadModelType;
import org.ieee.odm.schema.TimePeriodUnitType;
import org.ieee.odm.schema.TimePeriodXmlType;
import org.ieee.odm.schema.TransientSimulationXmlType;
import org.ieee.odm.schema.ZXmlType;
import org.ieee.odm.schema.TransientSimulationXmlType.SimulationSetting;
import org.interpss.mapper.odm.ODMXmlHelper;
import org.interpss.mapper.odm.impl.AcscScenarioHelper;

import com.interpss.core.CoreObjectFactory;
import com.interpss.core.acsc.AcscBranch;
import com.interpss.core.acsc.AcscBranchFault;
import com.interpss.core.acsc.AcscBus;
import com.interpss.core.acsc.AcscBusFault;
import com.interpss.core.acsc.SimpleFaultCode;
import com.interpss.core.acsc.SimpleFaultNetwork;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuAlgorithm;
import com.interpss.dstab.mach.Machine;



public class ScenarioHelper {
	
	private DStabilityNetwork dstabNet = null;
	private DynamicSimuAlgorithm algo = null;
	
	public ScenarioHelper(DStabilityNetwork dstabNet,DynamicSimuAlgorithm algo) {
		this.dstabNet = dstabNet;
		this.algo = algo;		
	}
	double frequency =dstabNet.getFrequency();
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
			algo.setSimuMethod(DynamicSimuMethods);
		}else if (method.equals("RungerKutta")){
			algo.setSimuMethod(DynamicSimuMethods)
		}
		// map total time, unit is sec
		TimePeriodXmlType tolTime = settings.getTotalTime();		
		double tolTimeInSec = convertTimeUnit2Sec(tolTime,frequency);
		algo.setTotalSimuTimeSec(tolTimeInSec);
		// map time set,  unit is sec
		TimePeriodXmlType stepTime = settings.getStep();		
		double stepTimeInSec = convertTimeUnit2Sec(tolTime,frequency);
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
		AcscScenarioHelper.mapAcscFaultNetwork(faultXml);	
				
		
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
