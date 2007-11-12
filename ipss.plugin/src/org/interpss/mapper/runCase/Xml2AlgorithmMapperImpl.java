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

package org.interpss.mapper.runCase;

import org.interpss.core.adapter.IpssXmlAdapter;
import org.interpss.schema.AclfMethodDataType;
import org.interpss.schema.BranchChangeRecType;
import org.interpss.schema.BusChangeRecType;
import org.interpss.schema.ModificationType;
import org.interpss.schema.RunAclfStudyCaseType;
import org.interpss.schema.UnitDataType;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Network;

public class Xml2AlgorithmMapperImpl {
	/**
	 * Map AclfCaseData to a LoadflowAlgorithm object
	 * 
	 * @param caseData
	 * @param algo
	 */
	public static boolean aclfCaseData2AlgoMapping(RunAclfStudyCaseType caseData, LoadflowAlgorithm algo) {
	  	algo.setLfMethod(caseData.getLfMethod()==AclfMethodDataType.NR? AclfMethod.NR :
	  				       (caseData.getLfMethod()==AclfMethodDataType.PQ? AclfMethod.PQ : 
	  				    	   AclfMethod.GS));
	  	algo.setMaxIterations(caseData.getMaxIterations());
  		double e = caseData.getTolerance();
	  	if (caseData.getToleranceUnit() != UnitDataType.PU) {
	  		byte unit = IpssXmlAdapter.mapXmlUnitType2IpssUnitType(caseData.getToleranceUnit());
	  		e = UnitType.pConversion(e, algo.getAclfNetwork().getBaseKva(), unit, UnitType.PU);
	  	}
  		algo.setTolerance(e);
	  	algo.setInitBusVoltage(caseData.getInitBusVoltage());
	  	if (caseData.getAccFactor() != 0.0)	
	  		algo.setGsAccFactor(caseData.getAccFactor());
	  	
	  	if (caseData.getModificationArray().length > 0) {
	  		for (ModificationType mod : caseData.getModificationArray()) {
	  			if (mod.getNetChangeRec() != null) {
	  				Network net = algo.getAclfNetwork();
	  				if (mod.getNetChangeRec().getBusChangeRecArray().length > 0) {
	  					for (BusChangeRecType bus : mod.getNetChangeRec().getBusChangeRecArray()) {
	  						
	  					}
	  				}
	  				
	  				if (mod.getNetChangeRec().getBranchChangeRecArray().length > 0) {
	  					for (BranchChangeRecType braRec : mod.getNetChangeRec().getBranchChangeRecArray()) {
	  						String fromId = braRec.getFromBusId();
	  						String toId = braRec.getToBusId();
	  						Branch branch = null;
	  						String cirNo = braRec.getCircuitNumber();
	  						if (cirNo != null)
	  							branch = net.getBranch(fromId, toId, cirNo);
	  						else
	  							branch = net.getBranch(fromId, toId);
	  						if (branch != null) {
	  							branch.setStatus(braRec.getSetInService());
	  							IpssLogger.getLogger().info("Branch " + branch.getId() + " service status has been set to " + branch.isActive());
	  						}
	  						else {
	  							IpssLogger.getLogger().warning("Branch not found, fromId, toId, cirNo: " + fromId + ", " + toId + ", " + cirNo);
	  				  			SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Error in Xml", 
	  				  				"Branch not found, fromId, toId, cirNo: " + fromId + ", " + toId + ", " + cirNo);
	  						}
	  					}
	  				}
	  			}
	  			
	  			if (mod.getAclfNetChangeRec() != null) {
	  				
	  			}
	  		}
	  	}
	  	return true;
	}
}