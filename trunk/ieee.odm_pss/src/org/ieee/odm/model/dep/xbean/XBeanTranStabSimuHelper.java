/*
 * @(#)IeeeCDFAdapter.java   
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

package org.ieee.odm.model.dep.xbean;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ExciterDataListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ExciterXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.FaultXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.GeneratorXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadCharacteristicXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NegativeSequenceDataListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PostiveSequenceDataListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ScenarioXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.StabilizerDataListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.StabilizerXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TransientSimulationXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TurbineGovernorDataListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TurbineGovernorXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZeroSequenceDataListXmlType;

public class XBeanTranStabSimuHelper {
	public static TransientSimulationXmlType getTransientSimlation(ScenarioXmlType scenario){
		if(scenario.getTransientSimlation()==null){
			TransientSimulationXmlType tranSimu=scenario.addNewTransientSimlation();
			tranSimu.addNewDynamicDataList();
			tranSimu.getDynamicDataList().addNewFaultList();
			tranSimu.getDynamicDataList().addNewBranchDynDataList();
			tranSimu.getDynamicDataList().addNewBusDynDataList();
			tranSimu.getDynamicDataList().addNewSequenceDataList();			
			tranSimu.getDynamicDataList().getSequenceDataList().addNewNegativeSequenceDataList();
			tranSimu.getDynamicDataList().getSequenceDataList().getNegativeSequenceDataList().
			                    addNewGeneratorNegativeList();
			tranSimu.getDynamicDataList().getSequenceDataList().getNegativeSequenceDataList()
			                   .addNewShuntLoadNegativeList();
			tranSimu.getDynamicDataList().getSequenceDataList().addNewPostiveSequenceDataList();
			tranSimu.getDynamicDataList().getSequenceDataList().getPostiveSequenceDataList()
			                   .addNewGeneratorPostiveList();
			tranSimu.getDynamicDataList().getSequenceDataList().addNewZeroSequenceDataList();
			tranSimu.getDynamicDataList().getSequenceDataList().getZeroSequenceDataList()
			                   .addNewGeneratorZeroList();
			tranSimu.getDynamicDataList().getSequenceDataList().getZeroSequenceDataList()
                               .addNewLineZeroList();
			tranSimu.getDynamicDataList().getSequenceDataList().getZeroSequenceDataList()
                               .addNewMutualImpedanceZeroList();
			tranSimu.getDynamicDataList().getSequenceDataList().getZeroSequenceDataList()
                              .addNewShuntLoadZeroList();
			tranSimu.getDynamicDataList().getSequenceDataList().getZeroSequenceDataList()
                              .addNewSwitchShuntedZeroList();
			tranSimu.getDynamicDataList().getSequenceDataList().getZeroSequenceDataList()
                              .addNewXfrZeroList();
			tranSimu.getDynamicDataList().getBusDynDataList().addNewGeneratorDataList();
			tranSimu.getDynamicDataList().getBusDynDataList().addNewLoadCharacteristicDataList();
			
			//tranSimu.addNewOutPutSetting();
			//tranSimu.addNewPowerFlowInitialization();
			//tranSimu.addNewSimulationSetting();
		}
		return scenario.getTransientSimlation();
	}	
	
	public static FaultXmlType addNewFault(ScenarioXmlType scenario){		
		return scenario.getTransientSimlation().getDynamicDataList().getFaultList().addNewFault();
	}
	
	public static GeneratorXmlType addNewGen(ScenarioXmlType scenario){		
		return scenario.getTransientSimlation().getDynamicDataList().
		             getBusDynDataList().getGeneratorDataList().addNewGenerator();
	}
	
	public static ExciterDataListXmlType getExciterList(TransientSimulationXmlType tranSimu){
		if(tranSimu.getDynamicDataList().
				getBusDynDataList().getExciterDataList()==null){
			tranSimu.getDynamicDataList().
			getBusDynDataList().addNewExciterDataList();
		}
		return tranSimu.getDynamicDataList().getBusDynDataList().getExciterDataList();
	}
	
	public static ExciterXmlType addNewExciter(TransientSimulationXmlType tranSimu){
		return getExciterList(tranSimu).addNewExciter();
	}
	
	public static TurbineGovernorDataListXmlType getTurbineGovernorDataList(TransientSimulationXmlType tranSimu){
		if(tranSimu.getDynamicDataList().
				getBusDynDataList().getTurbineGovernorDataList()==null){
			tranSimu.getDynamicDataList().getBusDynDataList().addNewTurbineGovernorDataList();
		}
		return tranSimu.getDynamicDataList().getBusDynDataList().getTurbineGovernorDataList();
	}
	
	public static TurbineGovernorXmlType addNewTurbineGovernor(TransientSimulationXmlType tranSimu){
		return getTurbineGovernorDataList(tranSimu).addNewTurbineGovernor();
	}
	
	public static StabilizerDataListXmlType getPSSDataList(TransientSimulationXmlType tranSimu){
		if(tranSimu.getDynamicDataList().
				getBusDynDataList().getStabilizerDataList()==null){
			tranSimu.getDynamicDataList().getBusDynDataList().addNewStabilizerDataList();
		}
		return tranSimu.getDynamicDataList().getBusDynDataList().getStabilizerDataList();
	}
	
	public static StabilizerXmlType addNewStablilizerGovernor(TransientSimulationXmlType tranSimu){
		return getPSSDataList(tranSimu).addNewStabilizer();
	}
	
	
	public static LoadCharacteristicXmlType addNewLoad(TransientSimulationXmlType tranSimu){
		return tranSimu.getDynamicDataList().
		    getBusDynDataList().getLoadCharacteristicDataList().addNewLoad();
	}
	
	public static ZeroSequenceDataListXmlType.GeneratorZeroList.GeneratorZero addNewGenZero(TransientSimulationXmlType tranSimu){
		return tranSimu.getDynamicDataList()
		.getSequenceDataList().getZeroSequenceDataList().
		       getGeneratorZeroList().addNewGeneratorZero();
	}
	
	public static ZeroSequenceDataListXmlType.LineZeroList.LineZero addNewLineZero(TransientSimulationXmlType tranSimu){
		return tranSimu.getDynamicDataList()
		.getSequenceDataList().getZeroSequenceDataList()
		.getLineZeroList().addNewLineZero();
	}
	
	public static ZeroSequenceDataListXmlType.MutualImpedanceZeroList.MutualImpedanceZero addNewMutualZero(TransientSimulationXmlType tranSimu){
		return tranSimu.getDynamicDataList()
		.getSequenceDataList().getZeroSequenceDataList()
		.getMutualImpedanceZeroList().addNewMutualImpedanceZero();
	}
	
	public static ZeroSequenceDataListXmlType.ShuntLoadZeroList.ShuntLoadZero addNewShuntLoadZero(TransientSimulationXmlType tranSimu){
		return tranSimu.getDynamicDataList()
		.getSequenceDataList().getZeroSequenceDataList()
		.getShuntLoadZeroList().addNewShuntLoadZero();
	}
	
	public static ZeroSequenceDataListXmlType.SwitchShuntedZeroList.SwitchShuntedZeroType addNewSwitchShuntZero(TransientSimulationXmlType tranSimu){
		return tranSimu.getDynamicDataList()
		.getSequenceDataList().getZeroSequenceDataList()
		.getSwitchShuntedZeroList().addNewSwitchShuntedZeroType();
	}
	
	public static ZeroSequenceDataListXmlType.XfrZeroList.XfrZero addNewXfrZero(TransientSimulationXmlType tranSimu){
		return tranSimu.getDynamicDataList()
		.getSequenceDataList().getZeroSequenceDataList()
		.getXfrZeroList().addNewXfrZero();
	}
	
	public static PostiveSequenceDataListXmlType.GeneratorPostiveList.GerneratorPostive addNewGenPos(TransientSimulationXmlType tranSimu){
		return tranSimu.getDynamicDataList()
		.getSequenceDataList().getPostiveSequenceDataList().getGeneratorPostiveList()
		.addNewGerneratorPostive();
	}
	
	public static NegativeSequenceDataListXmlType.GeneratorNegativeList.GeneratorNegative addNewGenNeg(TransientSimulationXmlType tranSimu){
		return tranSimu.getDynamicDataList()
		.getSequenceDataList().getNegativeSequenceDataList().getGeneratorNegativeList()
		.addNewGeneratorNegative();
	}
	
	public static NegativeSequenceDataListXmlType.ShuntLoadNegativeList.ShuntLoadNegative addNewShuntLoadNeg(TransientSimulationXmlType tranSimu){
		return tranSimu.getDynamicDataList()
		.getSequenceDataList().getNegativeSequenceDataList().getShuntLoadNegativeList()
		.addNewShuntLoadNegative();
	}

}
