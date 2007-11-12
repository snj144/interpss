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

import org.interpss.editor.data.proj.AcscCaseData;
import org.interpss.editor.runAct.AclfRunForm;
import org.interpss.editor.runAct.AcscRunForm;
import org.interpss.editor.runAct.DStabRunForm;
import org.interpss.mapper.runCase.CaseData2AlgorithmMapperImpl;

import com.interpss.common.mapper.AbstractMapper;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.algorithm.ScBusVoltage;
import com.interpss.core.algorithm.SimpleFaultAlgorithm;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuAlgorithm;

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
		/*
		else if (klass == AcscBusFault.class) {
			AcscFaultData data = (AcscFaultData)fromObj;
			AcscBusFault fault = (AcscBusFault)toObj;
			RunForm2AlgorithmMapperImpl.acscFaultData2AcscBusFaultMapping(data, fault);
		}
		else if (klass == AcscBranchFault.class) {
			AcscFaultData data = (AcscFaultData)fromObj;
			AcscBranchFault fault = (AcscBranchFault)toObj;
			RunForm2AlgorithmMapperImpl.acscFaultData2AcscBranchFaultMapping(data, fault);
		}
		*/
		else if (klass == DynamicSimuAlgorithm.class) {
			DStabRunForm runForm = (DStabRunForm)fromObj;
			DynamicSimuAlgorithm algo = (DynamicSimuAlgorithm)toObj;
			dStabRunForm2DynamicSimuAlgorithmMapping(runForm, algo);
		}
		/*
		else if (klass == BranchOutageEvent.class) {
			AcscFaultData data = (AcscFaultData)fromObj;
			BranchOutageEvent event = (BranchOutageEvent)toObj;
			if (data.getCategory().equals(AcscFaultData.FaultCaty_Outage_3P))
				event.setOutageType(BranchOutageType.THREE_PHASE);
			else if (data.getCategory().equals(AcscFaultData.FaultCaty_Outage_1P))
				event.setOutageType(BranchOutageType.SINGLE_PHASE);
			else if (data.getCategory().equals(AcscFaultData.FaultCaty_Outage_2P))
				event.setOutageType(BranchOutageType.DOUBLE_PHASE);
		}
		*/
		return true;
	}
	
	private void aclfRunForm2LFAlgorithmMapping(AclfRunForm runForm, LoadflowAlgorithm algo) {
		CaseData2AlgorithmMapperImpl.aclfCaseData2AlgoMapping(runForm.getAclfCaseData(), algo);
	}

	private void acscRunForm2SimpleFaultAlgorithmMapping(AcscRunForm runForm, SimpleFaultAlgorithm algo) {
		algo.setMultiFactor(runForm.getAcscCaseData().getMFactor()*0.01);
		// algo.multiFactor in PU and acscData.getMFactor in %
		algo.setScBusVoltage(runForm.getAcscCaseData().getBusInitVolt().equals(AcscCaseData.ScBusVolt_UnitVolt)?
				ScBusVoltage.UNIT_VOLT : ScBusVoltage.LOADFLOW_VOLT); // UnitV | LFVolt	
	}

	private void dStabRunForm2DynamicSimuAlgorithmMapping(DStabRunForm runForm, DynamicSimuAlgorithm algo) {
		CaseData2AlgorithmMapperImpl.dstabCaseData2AlgoMapping(runForm.getDStabCaseData(), runForm.getAclfCaseData(), algo);
		
		DStabilityNetwork dstabNet = algo.getDStabNet();
		CaseData2AlgorithmMapperImpl.dstabCaseData2NetMapping(runForm.getDStabCaseData(), dstabNet, msg);
	}
}
