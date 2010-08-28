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

import com.interpss.common.datatype.UnitType;
import com.interpss.common.util.IpssLogger;
import com.interpss.dstab.DStabBranch;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.mach.Eq1Ed1Machine;
import com.interpss.dstab.mach.MachineType;
import com.interpss.dstab.mach.RoundRotorMachine;
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
		for (DynamicGeneratorXmlType m : dstabBusXml.getMachineList().getMachine()) {
			MachineModelXmlType machXmlRec = m.getMachineModel().getValue();
			if (machXmlRec instanceof EquiMachineXmlType) {
				
			}
			else if (machXmlRec instanceof ClassicMachineXmlType) {
				
			}
			else if (machXmlRec instanceof EquiMachineXmlType) {
			}
			else if (machXmlRec instanceof Eq1MachineXmlType) {
			}
			else if (machXmlRec instanceof Eq1Ed1MachineXmlType) {
				Eq1Ed1MachineXmlType machXml = (Eq1Ed1MachineXmlType)machXmlRec;
				// create a machine and connect to the bus
				Eq1Ed1Machine mach = (Eq1Ed1Machine)DStabObjectFactory.
									createMachine("MachId", "MachName", MachineType.EQ1_ED1_MODEL, 
									dstabNet, dstabBus.getId());
				// set machine data
				mach.setRating(machXml.getRatedPower().getValue(), UnitType.mVA, dstabNet.getBaseKva());
				//mach.setRatedVoltage(machXml.getRatedVoltage().getValue(), "Kv");
				// the multiply factor is calculated using machine ratedP and ratedV against system 
				// base kva and bus base voltage
				mach.setMultiFactors(dstabBus);
				mach.setH(5.0);
				mach.setD(0.01);
				mach.setXd(1.1);
				mach.setXl(0.14);
				mach.setXq(1.08);
				mach.setXd1(0.23);
				mach.setXq1(0.23);
				mach.setX0(0.1);
				mach.setX2(0.2);
				mach.setRa(0.003);
				mach.setTd01(5.6);
				mach.setTq01(1.5);
				mach.setSliner(2.0);  // no saturation
				mach.setSe100(1.0);
				mach.setSe120(1.0);	
			}
			else if (machXmlRec instanceof Eq11MachineXmlType) {
			}
			else if (machXmlRec instanceof Eq11Ed11MachineXmlType) {
				Eq11Ed11MachineXmlType machXml = (Eq11Ed11MachineXmlType)machXmlRec;
				// create a machine and connect to the bus "Gen"
				RoundRotorMachine mach = (RoundRotorMachine)DStabObjectFactory.
									createMachine("MachId", "MachName", MachineType.EQ11_ED11_ROUND_ROTOR, dstabNet, dstabBus.getId());
				// set machine data
				mach.setRating(100, UnitType.mVA, dstabNet.getBaseKva());
				mach.setRatedVoltage(1000.0);
				mach.setMultiFactors(dstabBus);
				mach.setH(machXml.getH());
				mach.setD(machXml.getD());
				mach.setX0(machXml.getX0());
				mach.setX2(machXml.getX2());
				mach.setRa(machXml.getRa());
				mach.setXl(machXml.getXl());
				mach.setXd(machXml.getXd());
				mach.setXq(machXml.getXq());
				mach.setXd1(machXml.getXd1());
				mach.setTd01(machXml.getTdo1().getValue());
				mach.setXq1(machXml.getXq1());
				mach.setTq01(machXml.getTq01().getValue());
				mach.setXd11(machXml.getXd11());
				mach.setTq011(machXml.getTq011().getValue());
				mach.setXq11(machXml.getXq11());
				mach.setTd011(machXml.getTd011().getValue());
				if (machXml.getSeFmt1() != null) {
					mach.setSliner(machXml.getSeFmt1().getSliner());
					mach.setSe100(machXml.getSeFmt1().getSE100());
					mach.setSe120(machXml.getSeFmt1().getSE120());					
				}
				else if (machXml.getSeFmt2() != null) {
					
				}
			}
		}
	}
}