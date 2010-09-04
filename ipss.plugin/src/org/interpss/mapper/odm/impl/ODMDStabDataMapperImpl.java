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
import org.ieee.odm.schema.BranchXmlType;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.DStabBusXmlType;
import org.ieee.odm.schema.DStabNetXmlType;
import org.ieee.odm.schema.DynamicGeneratorXmlType;
import org.ieee.odm.schema.ExciterModelXmlType;
import org.ieee.odm.schema.GovernorModelXmlType;
import org.ieee.odm.schema.LineBranchXmlType;
import org.ieee.odm.schema.LineDStabXmlType;
import org.ieee.odm.schema.LineShortCircuitXmlType;
import org.ieee.odm.schema.LoadflowBusXmlType;
import org.ieee.odm.schema.MachineModelXmlType;
import org.ieee.odm.schema.NetworkCategoryEnumType;
import org.ieee.odm.schema.OriginalDataFormatEnumType;
import org.ieee.odm.schema.PSXfrBranchXmlType;
import org.ieee.odm.schema.PSXfrDStabXmlType;
import org.ieee.odm.schema.PSXfrShortCircuitXmlType;
import org.ieee.odm.schema.ShortCircuitBusXmlType;
import org.ieee.odm.schema.StabilizerModelXmlType;
import org.ieee.odm.schema.XfrBranchXmlType;
import org.ieee.odm.schema.XfrDStabXmlType;
import org.ieee.odm.schema.XfrShortCircuitXmlType;
import org.interpss.mapper.odm.ODMXmlHelper;
import org.interpss.mapper.odm.impl.dstab.ExciterDataHelper;
import org.interpss.mapper.odm.impl.dstab.GovernorDataHelper;
import org.interpss.mapper.odm.impl.dstab.MachDataHelper;
import org.interpss.mapper.odm.impl.dstab.StabilizerDataHelper;

import com.interpss.common.exp.InterpssException;
import com.interpss.common.util.IpssLogger;
import com.interpss.dstab.DStabBranch;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.mach.Machine;
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
			// get the base net xml record from the parser object
			DStabNetXmlType xmlNet = parser.getDStabNet();
			try {
				// create a DStabilityNetwork object and map the net info 
				DStabilityNetwork dstabNet = mapNetworkData(xmlNet);
				simuCtx.setDStabilityNet(dstabNet);

				// map the bus info
				for (JAXBElement<? extends BusXmlType> bus : xmlNet.getBusList().getBus()) {
					// for DStab, the bus could be aclfBus, acscBus or dstabBus
					// inheritance relationship aclfBus <- acscBus <- dstabBus
					if (bus.getValue() instanceof LoadflowBusXmlType) {
						LoadflowBusXmlType aclfBusXml = (LoadflowBusXmlType)bus.getValue();
						DStabBus dstabBus = DStabObjectFactory.createDStabBus(aclfBusXml.getId(), dstabNet);
						
						// base the base bus info part
						ODMNetDataMapperImpl.mapBaseBusData(aclfBusXml, dstabBus, dstabNet);
						
						// map the Aclf info part
						ODMAclfDataMapperImpl.setAclfBusData(aclfBusXml, dstabBus, dstabNet);
						
						// if the record includes Acsc info, do the mapping
						if (bus.getValue() instanceof ShortCircuitBusXmlType) {
							ShortCircuitBusXmlType acscBusXml = (ShortCircuitBusXmlType) bus.getValue();
							ODMAcscDataMapperImpl.setAcscBusData(acscBusXml, dstabBus);
						}

						// if the record includes DStab info, do the mapping
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

				// map the branch info
				for (JAXBElement<? extends BaseBranchXmlType> branch : xmlNet.getBranchList().getBranch()) {
					// for DStab, the branch could be (LineBranchXmlType, ...), (LineShortCircuitXmlType ...) or (LineDStabXmlType ... )
					// inheritance relationship (LineBranchXmlType, ...) <- (LineShortCircuitXmlType ...) <- (LineDStabXmlType ... )
					if (branch.getValue() instanceof LineBranchXmlType || 
							branch.getValue() instanceof XfrBranchXmlType ||
								branch.getValue() instanceof PSXfrBranchXmlType) {
						DStabBranch dstabBranch = DStabObjectFactory.createDStabBranch();
						ODMAclfDataMapperImpl.mapAclfBranchData(branch.getValue(), dstabBranch, dstabNet, simuCtx.getMsgHub());

						if (branch.getValue() instanceof LineShortCircuitXmlType || 
								branch.getValue() instanceof XfrShortCircuitXmlType ||
									branch.getValue() instanceof PSXfrShortCircuitXmlType) {
							BranchXmlType acscBraXml = (BranchXmlType)branch.getValue(); 
							ODMAcscDataMapperImpl.setAcscBranchData(acscBraXml, dstabBranch, simuCtx.getMsgHub());
						}

						if (branch.getValue() instanceof LineDStabXmlType || 
								branch.getValue() instanceof XfrDStabXmlType ||
									branch.getValue() instanceof PSXfrDStabXmlType) {
							// current no DStab branch info are defined
						}
					}
					else {
						IpssLogger.getLogger().severe( "Error: only aclf<Branch>, acsc<Branch> and dstab<Branch> could be used for DStab study");
						noError = false;
					}
				}
			} catch (Exception e) {
				IpssLogger.getLogger().severe(e.toString());
				e.printStackTrace();
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
		ODMAcscDataMapperImpl.mapNetworkData(dstabNet, xmlNet);
		dstabNet.setSaturatedMachineParameter(xmlNet.isSaturatedMachineParameter());
		return dstabNet;
	}	
	
	private static void setDStabBusData(DStabBusXmlType dstabBusXml, DStabBus dstabBus)  throws InterpssException {
		int cnt = 0;
		if (dstabBusXml.getMachineList() != null)
			for (DynamicGeneratorXmlType dyGen : dstabBusXml.getMachineList().getMachine()) {
				// create the machine model and added to the parent bus object
				MachineModelXmlType machXmlRec = dyGen.getMachineModel().getValue();
				String machId = dstabBus.getId() + "mach" + ++cnt;
				Machine mach = new MachDataHelper(dstabBus, dyGen.getRatedPower(), dyGen.getRatedVoltage())
									.createMachine(machXmlRec, machId);
				
				if (dyGen.getExciter() != null) {
					// create the exc model and add to the parent machine object
					ExciterModelXmlType excXml = dyGen.getExciter().getValue();
					new ExciterDataHelper(mach).createExciter(excXml);
					
					if (dyGen.getStabilizer() != null) {
						// create the pss model and add to the parent machine object
						StabilizerModelXmlType pssXml = dyGen.getStabilizer().getValue();
						new StabilizerDataHelper(mach).createStabilizer(pssXml);
					}
				}

				if (dyGen.getGovernor() != null) {
					// create the gov model and add to the parent machine object
					GovernorModelXmlType govXml = dyGen.getGovernor().getValue();
					new GovernorDataHelper(mach).createGovernor(govXml);
				}
			}
	}
}