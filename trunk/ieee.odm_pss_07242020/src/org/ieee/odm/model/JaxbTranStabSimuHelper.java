/*
 * @(#)JaxbTranStabSimuHelper.java   
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
 * @Author Stephen Hau, Mike Zhou
 * @Version 1.0
 * @Date 02/11/2009
 * 
 *   Revision History
 *   ================
 *
 */

package org.ieee.odm.model;

import org.ieee.odm.schema.ExciterDataListXmlType;
import org.ieee.odm.schema.ExciterXmlType;
import org.ieee.odm.schema.FaultXmlType;
import org.ieee.odm.schema.GeneratorXmlType;
import org.ieee.odm.schema.LoadCharacteristicXmlType;
import org.ieee.odm.schema.NegativeSequenceDataListXmlType;
import org.ieee.odm.schema.PostiveSequenceDataListXmlType;
import org.ieee.odm.schema.ScenarioXmlType;
import org.ieee.odm.schema.StabilizerDataListXmlType;
import org.ieee.odm.schema.StabilizerXmlType;
import org.ieee.odm.schema.TransientSimulationXmlType;
import org.ieee.odm.schema.TurbineGovernorDataListXmlType;
import org.ieee.odm.schema.TurbineGovernorXmlType;
import org.ieee.odm.schema.ZeroSequenceDataListXmlType;

public class JaxbTranStabSimuHelper {
	public static TransientSimulationXmlType getTransientSimlation(ScenarioXmlType scenario){
		if(scenario.getTransientSimlation()==null){
			TransientSimulationXmlType tranSimu = new TransientSimulationXmlType(); 
			scenario.setTransientSimlation(tranSimu);

			//tranSimu.addNewDynamicDataList();
			//tranSimu.getDynamicDataList().addNewFaultList();
			//tranSimu.getDynamicDataList().addNewBranchDynDataList();
			//tranSimu.getDynamicDataList().addNewBusDynDataList();
			//tranSimu.getDynamicDataList().addNewSequenceDataList();			
			//tranSimu.getDynamicDataList().getSequenceDataList().addNewNegativeSequenceDataList();
			//tranSimu.getDynamicDataList().getSequenceDataList().getNegativeSequenceDataList().
			//                    addNewGeneratorNegativeList();
			//tranSimu.getDynamicDataList().getSequenceDataList().getNegativeSequenceDataList()
			//                  .addNewShuntLoadNegativeList();
			//tranSimu.getDynamicDataList().getSequenceDataList().addNewPostiveSequenceDataList();
			//tranSimu.getDynamicDataList().getSequenceDataList().getPostiveSequenceDataList()
			//                  .addNewGeneratorPostiveList();
			//tranSimu.getDynamicDataList().getSequenceDataList().addNewZeroSequenceDataList();
			//tranSimu.getDynamicDataList().getSequenceDataList().getZeroSequenceDataList()
			//                  .addNewGeneratorZeroList();
			//tranSimu.getDynamicDataList().getSequenceDataList().getZeroSequenceDataList()
            //                   .addNewLineZeroList();
			//tranSimu.getDynamicDataList().getSequenceDataList().getZeroSequenceDataList()
            //                   .addNewMutualImpedanceZeroList();
			//tranSimu.getDynamicDataList().getSequenceDataList().getZeroSequenceDataList()
            //                 .addNewShuntLoadZeroList();
			//tranSimu.getDynamicDataList().getSequenceDataList().getZeroSequenceDataList()
            //                  .addNewSwitchShuntedZeroList();
			//tranSimu.getDynamicDataList().getSequenceDataList().getZeroSequenceDataList()
            //                  .addNewXfrZeroList();
			//tranSimu.getDynamicDataList().getBusDynDataList().addNewGeneratorDataList();
			//tranSimu.getDynamicDataList().getBusDynDataList().addNewLoadCharacteristicDataList();
			
			//tranSimu.addNewOutPutSetting();
			//tranSimu.addNewPowerFlowInitialization();
			//tranSimu.addNewSimulationSetting();
		}
		return scenario.getTransientSimlation();
	}	
	
	public static FaultXmlType addNewFault(ScenarioXmlType scenario){		
		FaultXmlType fault = new FaultXmlType();
		scenario.getTransientSimlation().getDynamicDataList().getFaultList().getFault().add(fault);
		return fault;
	}
	
	public static GeneratorXmlType addNewGen(ScenarioXmlType scenario){		
		GeneratorXmlType gen = new GeneratorXmlType();
		scenario.getTransientSimlation().getDynamicDataList().
		             getBusDynDataList().getGeneratorDataList().getGenerator().add(gen);
		return gen;
	}
	
	public static ExciterDataListXmlType getExciterList(TransientSimulationXmlType tranSimu){
		//if(tranSimu.getDynamicDataList().
		//		getBusDynDataList().getExciterDataList()==null){
		//	tranSimu.getDynamicDataList().
		//	getBusDynDataList().addNewExciterDataList();
		//}
		return tranSimu.getDynamicDataList().getBusDynDataList().getExciterDataList();
	}
	
	public static ExciterXmlType addNewExciter(TransientSimulationXmlType tranSimu){
		ExciterXmlType exc = new ExciterXmlType();
		getExciterList(tranSimu).getExciter().add(exc);
		return exc;
	}
	
	public static TurbineGovernorDataListXmlType getTurbineGovernorDataList(TransientSimulationXmlType tranSimu){
		//if(tranSimu.getDynamicDataList().
		//		getBusDynDataList().getTurbineGovernorDataList()==null){
		//	tranSimu.getDynamicDataList().getBusDynDataList().addNewTurbineGovernorDataList();
		//}
		return tranSimu.getDynamicDataList().getBusDynDataList().getTurbineGovernorDataList();
	}
	
	public static TurbineGovernorXmlType addNewTurbineGovernor(TransientSimulationXmlType tranSimu){
		TurbineGovernorXmlType gov = new TurbineGovernorXmlType();
		getTurbineGovernorDataList(tranSimu).getTurbineGovernor().add(gov);
		return gov;
	}
	
	public static StabilizerDataListXmlType getPSSDataList(TransientSimulationXmlType tranSimu){
		//if(tranSimu.getDynamicDataList().
		//		getBusDynDataList().getStabilizerDataList()==null){
		//	tranSimu.getDynamicDataList().getBusDynDataList().addNewStabilizerDataList();
		//}
		return tranSimu.getDynamicDataList().getBusDynDataList().getStabilizerDataList();
	}
	
	public static StabilizerXmlType addNewStablilizerGovernor(TransientSimulationXmlType tranSimu){
		StabilizerXmlType pss = new StabilizerXmlType();
		getPSSDataList(tranSimu).getStabilizer().add(pss);
		return pss;
	}
	
	
	public static LoadCharacteristicXmlType addNewLoad(TransientSimulationXmlType tranSimu){
		LoadCharacteristicXmlType load = new LoadCharacteristicXmlType();
		tranSimu.getDynamicDataList().
		    getBusDynDataList().getLoadCharacteristicDataList().getLoad().add(load);
		return load;
	}
	
	public static ZeroSequenceDataListXmlType.GeneratorZeroList.GeneratorZero addNewGenZero(TransientSimulationXmlType tranSimu){
		ZeroSequenceDataListXmlType.GeneratorZeroList.GeneratorZero zero = new
			ZeroSequenceDataListXmlType.GeneratorZeroList.GeneratorZero();
		tranSimu.getDynamicDataList()
			.getSequenceDataList().getZeroSequenceDataList().
		       getGeneratorZeroList().getGeneratorZero().add(zero);
		return zero;
	}
	
	public static ZeroSequenceDataListXmlType.LineZeroList.LineZero addNewLineZero(TransientSimulationXmlType tranSimu){
		ZeroSequenceDataListXmlType.LineZeroList.LineZero zero = new 
			ZeroSequenceDataListXmlType.LineZeroList.LineZero();
		tranSimu.getDynamicDataList()
			.getSequenceDataList().getZeroSequenceDataList()
			.getLineZeroList().getLineZero().add(zero);
		return zero;
	}
	
	public static ZeroSequenceDataListXmlType.MutualImpedanceZeroList.MutualImpedanceZero addNewMutualZero(TransientSimulationXmlType tranSimu){
		ZeroSequenceDataListXmlType.MutualImpedanceZeroList.MutualImpedanceZero zero = new
			ZeroSequenceDataListXmlType.MutualImpedanceZeroList.MutualImpedanceZero();
		tranSimu.getDynamicDataList()
			.getSequenceDataList().getZeroSequenceDataList()
			.getMutualImpedanceZeroList().getMutualImpedanceZero().add(zero);
		return zero;
	}
	
	public static ZeroSequenceDataListXmlType.ShuntLoadZeroList.ShuntLoadZero addNewShuntLoadZero(TransientSimulationXmlType tranSimu){
		ZeroSequenceDataListXmlType.ShuntLoadZeroList.ShuntLoadZero zero = new
		ZeroSequenceDataListXmlType.ShuntLoadZeroList.ShuntLoadZero();
		tranSimu.getDynamicDataList()
			.getSequenceDataList().getZeroSequenceDataList()
			.getShuntLoadZeroList().getShuntLoadZero().add(zero);
		return zero;
	}
	
	public static ZeroSequenceDataListXmlType.SwitchShuntedZeroList.SwitchShuntedZeroType addNewSwitchShuntZero(TransientSimulationXmlType tranSimu){
		ZeroSequenceDataListXmlType.SwitchShuntedZeroList.SwitchShuntedZeroType zero = new 
			ZeroSequenceDataListXmlType.SwitchShuntedZeroList.SwitchShuntedZeroType();
		tranSimu.getDynamicDataList()
			.getSequenceDataList().getZeroSequenceDataList()
			.getSwitchShuntedZeroList().getSwitchShuntedZeroType().add(zero);
		return zero;
	}
	
	public static ZeroSequenceDataListXmlType.XfrZeroList.XfrZero addNewXfrZero(TransientSimulationXmlType tranSimu){
		ZeroSequenceDataListXmlType.XfrZeroList.XfrZero zero = new
			ZeroSequenceDataListXmlType.XfrZeroList.XfrZero();
		tranSimu.getDynamicDataList()
			.getSequenceDataList().getZeroSequenceDataList()
			.getXfrZeroList().getXfrZero().add(zero);
		return zero;
	}
	
	public static PostiveSequenceDataListXmlType.GeneratorPostiveList.GerneratorPostive addNewGenPos(TransientSimulationXmlType tranSimu){
		PostiveSequenceDataListXmlType.GeneratorPostiveList.GerneratorPostive gen = new
			PostiveSequenceDataListXmlType.GeneratorPostiveList.GerneratorPostive();
		tranSimu.getDynamicDataList()
			.getSequenceDataList().getPostiveSequenceDataList().getGeneratorPostiveList()
			.getGerneratorPostive().add(gen);
		return gen;
	}
	
	public static NegativeSequenceDataListXmlType.GeneratorNegativeList.GeneratorNegative addNewGenNeg(TransientSimulationXmlType tranSimu){
		NegativeSequenceDataListXmlType.GeneratorNegativeList.GeneratorNegative gen = new
			NegativeSequenceDataListXmlType.GeneratorNegativeList.GeneratorNegative();
		tranSimu.getDynamicDataList()
			.getSequenceDataList().getNegativeSequenceDataList().getGeneratorNegativeList()
			.getGeneratorNegative().add(gen);
		return gen;
	}
	
	public static NegativeSequenceDataListXmlType.ShuntLoadNegativeList.ShuntLoadNegative addNewShuntLoadNeg(TransientSimulationXmlType tranSimu){
		NegativeSequenceDataListXmlType.ShuntLoadNegativeList.ShuntLoadNegative shuntLoad = new
			NegativeSequenceDataListXmlType.ShuntLoadNegativeList.ShuntLoadNegative();
		tranSimu.getDynamicDataList()
			.getSequenceDataList().getNegativeSequenceDataList().getShuntLoadNegativeList()
			.getShuntLoadNegative().add(shuntLoad);
		return shuntLoad;
	}

}
