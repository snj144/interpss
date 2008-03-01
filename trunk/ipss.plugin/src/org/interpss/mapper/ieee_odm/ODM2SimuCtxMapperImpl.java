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
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.StudyCaseXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageXmlType;
import org.ieee.pes.odm.pss.model.IEEEODMPSSModelParser;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.net.Area;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;
import com.interpss.core.net.Network;
import com.interpss.core.net.Zone;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;

public class ODM2SimuCtxMapperImpl {
	public static boolean odm2SimuCtxMapping(IEEEODMPSSModelParser parser,
			SimuContext simuCtx) {
		boolean noError = true;
		if (parser.getStudyCase().getNetworkCategory() == StudyCaseXmlType.NetworkCategory.TRANSMISSION
				&& parser.getStudyCase().getAnalysisCategory() == StudyCaseXmlType.AnalysisCategory.LOADFLOW) {

			simuCtx.setNetType(SimuCtxType.ACLF_ADJ_NETWORK);
			AclfAdjNetwork aclfNet = CoreObjectFactory.createAclfAdjNetwork();
			simuCtx.setAclfAdjNet(aclfNet);
			aclfNet.setAllowParallelBranch(true);

			PSSNetworkXmlType xmlNet = parser.getBaseCase();

			if (!setNetworkData(xmlNet, simuCtx.getNetwork(), simuCtx
					.getMsgHub()))
				noError = false;

			for (BusRecordXmlType busRec : xmlNet.getBusList().getBusArray()) {
				AclfBus aclfBus = CoreObjectFactory.createAclfBus(busRec
						.getId());
				setBusRecord(busRec, aclfBus, simuCtx.getNetwork(), simuCtx
						.getMsgHub());
				simuCtx.getNetwork().addBus(aclfBus);
				if (busRec.getLoadflowBusData() != null)
					if (!ODMLoadflowDataMapperImpl
							.setBusLoadflowData(busRec.getLoadflowBusData(),
									aclfBus, 
									simuCtx.getNetwork().getBaseKva(),
									simuCtx.getMsgHub()))
						noError = false;
			}

			for (BranchRecordXmlType branchRec : xmlNet.getBranchList()
					.getBranchArray()) {
				AclfBranch aclfBranch = CoreObjectFactory.createAclfBranch();
				setBranchRecord(branchRec, aclfBranch, simuCtx.getNetwork(),
						simuCtx.getMsgHub());
				simuCtx.getNetwork().addBranch((Branch) aclfBranch,
						branchRec.getFromBus().getIdRef(),
						branchRec.getToBus().getIdRef(),
						branchRec.getCircuitId());
				if (branchRec.getLoadflowBranchData() != null)
					if (!ODMLoadflowDataMapperImpl.setBranchLoadflowData(
							branchRec.getLoadflowBranchData(), 
							aclfBranch,
							simuCtx.getNetwork().getBaseKva(),
							simuCtx.getMsgHub()))
						noError = false;
			}
		} else {
			IpssLogger
					.getLogger()
					.severe(
							"Error: currently only Transmission NetworkType and Loadflow ApplicationType has been implemented");
			return false;
		}
		return noError;
	}

	private static boolean setNetworkData(PSSNetworkXmlType xmlNet,
			Network ipssNet, IPSSMsgHub msg) {
		double baseKva = xmlNet.getBasePower();
		if (xmlNet.getBasePowerUnit() == PSSNetworkXmlType.BasePowerUnit.MVA)
			ipssNet.setBaseKva(baseKva * 1000.0);
		else
			ipssNet
					.setBaseKva(xmlNet.getBasePowerUnit() == PSSNetworkXmlType.BasePowerUnit.MVA ? xmlNet
							.getBasePower() * 1000.0
							: xmlNet.getBasePower());
		return true;
	}

	private static boolean setBusRecord(BusRecordXmlType busRec, Bus bus,
			Network net, IPSSMsgHub msg) {
		bus
				.setBaseVoltage(busRec.getBaseVoltage().getUnit() == VoltageXmlType.Unit.KV ? busRec
						.getBaseVoltage().getVoltage() * 1000.0
						: busRec.getBaseVoltage().getVoltage());
		bus.setStatus(!busRec.getOffLine());
		if (busRec.getName() != null)
			bus.setName(busRec.getName());
		if (busRec.getDesc() != null)
			bus.setDesc(busRec.getDesc());
		Area area = CoreObjectFactory.createArea(busRec.getArea(), net);
		Zone zone = CoreObjectFactory.createZone(busRec.getZone(), net);
		bus.setArea(area);
		bus.setZone(zone);
		return true;
	}

	private static boolean setBranchRecord(BranchRecordXmlType branchRec,
			Branch branch, Network net, IPSSMsgHub msg) {
		branch.setName(branchRec.getName());
		branch.setStatus(!branchRec.getOffLine());
		Area area = CoreObjectFactory.createArea(branchRec.getArea(), net);
		Zone zone = CoreObjectFactory.createZone(branchRec.getZone(), net);
		branch.setArea(area);
		branch.setZone(zone);
		return true;
	}
}