/*
 * @(#)ODMDStabDataMapperImpl.java   
 *
 * Copyright (C) 2008-2010 www.interpss.org
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

package org.interpss.mapper.odm.impl;

import javax.xml.bind.JAXBElement;

import org.ieee.odm.model.dstab.DStabModelParser;
import org.ieee.odm.schema.AnalysisCategoryEnumType;
import org.ieee.odm.schema.BaseBranchXmlType;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.ClassicMachineXmlType;
import org.ieee.odm.schema.DStabBusXmlType;
import org.ieee.odm.schema.DStabNetXmlType;
import org.ieee.odm.schema.DynamicGeneratorXmlType;
import org.ieee.odm.schema.Eq11Ed11MachineXmlType;
import org.ieee.odm.schema.Eq11MachineXmlType;
import org.ieee.odm.schema.Eq1Ed1MachineXmlType;
import org.ieee.odm.schema.Eq1MachineXmlType;
import org.ieee.odm.schema.EquiMachineXmlType;
import org.ieee.odm.schema.LineBranchXmlType;
import org.ieee.odm.schema.LoadflowBusXmlType;
import org.ieee.odm.schema.MachineModelXmlType;
import org.ieee.odm.schema.NetworkCategoryEnumType;
import org.ieee.odm.schema.OriginalDataFormatEnumType;
import org.ieee.odm.schema.PSXfrBranchXmlType;
import org.ieee.odm.schema.ShortCircuitBusXmlType;
import org.ieee.odm.schema.XfrBranchXmlType;
import org.interpss.mapper.odm.ODMXmlHelper;
import org.interpss.mapper.odm.impl.dstab.MachDataHelper;

import com.interpss.common.util.IpssLogger;
import com.interpss.dstab.DStabBranch;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.mach.Eq1Ed1Machine;
import com.interpss.dstab.mach.Eq1Machine;
import com.interpss.dstab.mach.MachineType;
import com.interpss.dstab.mach.RoundRotorMachine;
import com.interpss.dstab.mach.SalientPoleMachine;
import com.interpss.simu.SimuContext;


public class ODMDStabDataMapperImpl {

	
	/**
	 * transfer info stored in the parser object into simuCtx object
	 * 
	 * @param parser
	 * @param simuCtx
	 * @return
	 */
	public static boolean odm2SimuCtxMapping(DStabModelParser parser, SimuContext simuCtx) {
		boolean noError = true;
		
		if (parser.getDStabNet().getNetworkCategory() == NetworkCategoryEnumType.TRANSMISSION
				&& parser.getAclfNet().getAnalysisCategory() == AnalysisCategoryEnumType.TRANSIENT_STABILITY) {
			DStabNetXmlType xmlNet = parser.getDStabNet();
			try {
				DStabilityNetwork dstabNet = mapNetworkData(xmlNet);
				simuCtx.setDStabilityNet(dstabNet);

				for (JAXBElement<? extends BusXmlType> bus : xmlNet.getBusList().getBus()) {
					// for DStab, the bus could be aclfBus, acscBus or dstabBus
					if (bus.getValue() instanceof LoadflowBusXmlType) {
						LoadflowBusXmlType aclfBusXml = (LoadflowBusXmlType)bus.getValue();
						DStabBus dstabBus = DStabObjectFactory.createDStabBus(aclfBusXml.getId(), dstabNet);
						ODMNetDataMapperImpl.mapBaseBusData(aclfBusXml, dstabBus, dstabNet);
						ODMAclfDataMapperImpl.setAclfBusData(aclfBusXml, dstabBus, dstabNet);
						
						if (bus.getValue() instanceof ShortCircuitBusXmlType) {
							ShortCircuitBusXmlType acscBusXml = (ShortCircuitBusXmlType) bus.getValue();
							ODMAcscDataMapperImpl.setAcdcBusData(acscBusXml, dstabBus);
						}

						if (bus.getValue() instanceof DStabBusXmlType) {
							DStabBusXmlType dstabBusXml = (DStabBusXmlType) bus.getValue();
							setDStabBusData(dstabBusXml, dstabBus);
						}
					}
					else {
						IpssLogger.getLogger().severe( "Error: only aclfBus, acscBus and dstabBus could be used for DStab study");
						noError = false;
					}
				}

				for (JAXBElement<? extends BaseBranchXmlType> branch : xmlNet.getBranchList().getBranch()) {
					if (branch.getValue() instanceof LineBranchXmlType || 
							branch.getValue() instanceof XfrBranchXmlType ||
								branch.getValue() instanceof PSXfrBranchXmlType) {
						DStabBranch dstabBranch = DStabObjectFactory.createDStabBranch();
						ODMAclfDataMapperImpl.mapAclfBranchData(branch.getValue(), dstabBranch, dstabNet, simuCtx.getMsgHub());
					}
					else {
						IpssLogger.getLogger().severe( "Error: only aclf<Branch>, acsc<Branch> and dstab<Branch> could be used for DStab study");
						noError = false;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				IpssLogger.getLogger().severe(e.toString());
				noError = false;
			}
		} 
		else {
			IpssLogger.getLogger().severe( "Error: wrong Transmission NetworkType and/or ApplicationType");
			return false;
		}
		
		OriginalDataFormatEnumType ofmt = parser.getStudyCase().getContentInfo().getOriginalDataFormat();
		simuCtx.getNetwork().setOriginalDataFormat(ODMXmlHelper.map(ofmt));		
		return noError;
	}
	
	private static DStabilityNetwork mapNetworkData(DStabNetXmlType xmlNet) throws Exception {
		DStabilityNetwork dstabNet = DStabObjectFactory.createDStabilityNetwork();
		ODMNetDataMapperImpl.mapNetworkData(dstabNet, xmlNet);
		return dstabNet;
	}	
	
	private static void setDStabBusData(DStabBusXmlType dstabBusXml, DStabBus dstabBus) {
		DStabilityNetwork dstabNet = (DStabilityNetwork)dstabBus.getNetwork();
		MachDataHelper machHelper = new MachDataHelper(dstabBus);
		int cnt = 0;
		for (DynamicGeneratorXmlType m : dstabBusXml.getMachineList().getMachine()) {
			MachineModelXmlType machXmlRec = m.getMachineModel().getValue();
			String machId = dstabBus.getId() + "mach" + ++cnt;
			if (machXmlRec instanceof EquiMachineXmlType) {
				
			}
			else if (machXmlRec instanceof ClassicMachineXmlType) {
				
			}
			else if (machXmlRec instanceof EquiMachineXmlType) {
			}
			else if (machXmlRec instanceof Eq1MachineXmlType) {
				Eq1MachineXmlType machXml = (Eq1MachineXmlType)machXmlRec;
				// create a machine and connect to the bus
				Eq1Machine mach = (Eq1Ed1Machine)DStabObjectFactory.
									createMachine(machId, machXml.getName(), MachineType.EQ1_MODEL, 
									dstabNet, dstabBus.getId());
				machHelper.setEq1Data(mach, machXml);
			}
			else if (machXmlRec instanceof Eq1Ed1MachineXmlType) {
				Eq1Ed1MachineXmlType machXml = (Eq1Ed1MachineXmlType)machXmlRec;
				// create a machine and connect to the bus
				Eq1Ed1Machine mach = (Eq1Ed1Machine)DStabObjectFactory.
									createMachine(machId, machXml.getName(), MachineType.EQ1_ED1_MODEL, 
									dstabNet, dstabBus.getId());
				machHelper.setEq1Ed1Data(mach, machXml);
			}
			else if (machXmlRec instanceof Eq11MachineXmlType) {
				Eq11MachineXmlType machXml = (Eq11MachineXmlType)machXmlRec;
				// create a machine and connect to the bus
				SalientPoleMachine mach = (SalientPoleMachine)DStabObjectFactory.
									createMachine(machId, machXml.getName(), MachineType.EQ11_SALIENT_POLE, 
									dstabNet, dstabBus.getId());
				machHelper.setEq11Data(mach, machXml);
			}
			else if (machXmlRec instanceof Eq11Ed11MachineXmlType) {
				Eq11Ed11MachineXmlType machXml = (Eq11Ed11MachineXmlType)machXmlRec;
				// create a machine and connect to the bus "Gen"
				RoundRotorMachine mach = (RoundRotorMachine)DStabObjectFactory.
									createMachine(machId, machXml.getName(), MachineType.EQ11_ED11_ROUND_ROTOR, dstabNet, dstabBus.getId());
				machHelper.setEq11Eq11Data(mach, machXml);
			}
		}
	}
}