/*
 * @(#)ODM2SimuCtxMapperImpl.java   
 *
 * Copyright (C) 2008 www.interpss.org
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
 * @Date 02/15/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.mapper.ieee_odm;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BranchRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBranchDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBusDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.StudyCaseXmlType;
import org.ieee.pes.odm.pss.model.IEEEODMPSSModelParser;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.net.Area;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Network;
import com.interpss.core.net.Zone;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuSpringAppContext;


public class ODM2SimuCtxMapperImpl {
	public static boolean odm2SimuCtxMapping(IEEEODMPSSModelParser parser, SimuContext simuCtx) {
		boolean noError = true;
		if (parser.getStudyCase().getNetworkCategory() == StudyCaseXmlType.NetworkCategory.TRANSMISSION &&
			parser.getStudyCase().getAnalysisCategory() == StudyCaseXmlType.AnalysisCategory.LOADFLOW ) {
			
			simuCtx = SimuSpringAppContext.getSimuContextTypeAclfAdj();
			simuCtx.getAclfAdjNet().setAllowParallelBranch(true);
			
			PSSNetworkXmlType xmlNet = parser.getBaseCase();
			
			if (!setNetworkData(xmlNet, simuCtx.getNetwork(), simuCtx.getMsgHub())) 
				noError = false;
			
			for ( BusRecordXmlType busRec : xmlNet.getBusList().getBusArray()) {
				AclfBus aclfBus = CoreObjectFactory.createAclfBus(busRec.getId());
				aclfBus.setBaseVoltage(busRec.getBaseVoltageUnit() == BusRecordXmlType.BaseVoltageUnit.KV?
						busRec.getBaseVoltage()*1000.0 : busRec.getBaseVoltage());
				aclfBus.setStatus(!busRec.getOffLine());
				if (busRec.getName() != null)
					aclfBus.setName(busRec.getName());
				if (busRec.getDesc() != null)
					aclfBus.setDesc(busRec.getDesc());
				Area area = CoreObjectFactory.createArea(busRec.getArea(), simuCtx.getNetwork());
				Zone zone = CoreObjectFactory.createZone(busRec.getZone(), simuCtx.getNetwork());
				aclfBus.setArea(area);
				aclfBus.setZone(zone);
				simuCtx.getNetwork().addBus(aclfBus);

				setBusLoadflowData(busRec.getLoadflowBusData(), aclfBus, simuCtx.getMsgHub());
			}

			for ( BranchRecordXmlType branchRec : xmlNet.getBranchList().getBranchArray()) {
				AclfBranch aclfBranch = CoreObjectFactory.createAclfBranch();
				aclfBranch.setName(branchRec.getName());
				aclfBranch.setStatus(!branchRec.getOffLine());
				Area area = CoreObjectFactory.createArea(branchRec.getArea(), simuCtx.getNetwork());
				Zone zone = CoreObjectFactory.createZone(branchRec.getZone(), simuCtx.getNetwork());
				aclfBranch.setArea(area);
				aclfBranch.setZone(zone);
//				simuCtx.getNetwork().addBranch((Branch)aclfBranch, branchRec.getFromBus().getIdRef(), 
//						branchRec.getToBus().getIdRef(), branchRec.getCircuitId());
				
				setBranchLoadflowData(branchRec.getLoadflowBranchData(), aclfBranch, simuCtx.getMsgHub());
			}
		}
		else {
			IpssLogger.getLogger().severe("Error: currently only Transmission NetworkType and Loadflow ApplicationType has been implemented");
			return false;
		}
		return noError;
	}
	
	private static boolean setNetworkData(PSSNetworkXmlType xmlNet, Network ipssNet, IPSSMsgHub msg) {
		double baseKva = xmlNet.getBaseKva();
		if (xmlNet.getBaseKvaUnit() == PSSNetworkXmlType.BaseKvaUnit.MVA)
			ipssNet.setBaseKva(baseKva*1000.0);
		else
			ipssNet.setBaseKva(xmlNet.getBaseKvaUnit() == PSSNetworkXmlType.BaseKvaUnit.MVA?
					xmlNet.getBaseKva()*1000.0 : xmlNet.getBaseKva());
		return true;
	}
	
	private static boolean setBusLoadflowData(LoadflowBusDataXmlType busLfData, AclfBus aclfBus, IPSSMsgHub msg) {
		return true;
	}

	private static boolean setBranchLoadflowData(LoadflowBranchDataXmlType braLfData, AclfBranch aclfBranch, IPSSMsgHub msg) {
		return true;
	}
}