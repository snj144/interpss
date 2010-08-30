/*
 * @(#)MachDataHelper.java   
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
 * @Date 08/15/2010
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.mapper.odm.impl.dstab;

import org.ieee.odm.schema.ActivePowerXmlType;
import org.ieee.odm.schema.ClassicMachineXmlType;
import org.ieee.odm.schema.Eq11Ed11MachineXmlType;
import org.ieee.odm.schema.Eq11MachineXmlType;
import org.ieee.odm.schema.Eq1Ed1MachineXmlType;
import org.ieee.odm.schema.Eq1MachineXmlType;
import org.ieee.odm.schema.EquiMachineXmlType;
import org.ieee.odm.schema.MachineModelXmlType;
import org.ieee.odm.schema.VoltageXmlType;
import org.interpss.mapper.odm.ODMXmlHelper;

import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.mach.Eq1Ed1Machine;
import com.interpss.dstab.mach.Eq1Machine;
import com.interpss.dstab.mach.MachineType;
import com.interpss.dstab.mach.RoundRotorMachine;
import com.interpss.dstab.mach.SalientPoleMachine;


public class MachDataHelper {
	private DStabBus dstabBus = null;
	private ActivePowerXmlType ratedPower = null;
	VoltageXmlType ratedVoltage = null;
	
	
	public MachDataHelper(DStabBus dstabBus, ActivePowerXmlType ratedP,	VoltageXmlType ratedV) {
		this.dstabBus = dstabBus;
		this.ratedPower = ratedP;
		this.ratedVoltage = ratedV;
	}
	
	public void createMachine(MachineModelXmlType machXmlRec, String machId) {
		if (machXmlRec instanceof ClassicMachineXmlType) {
			
		}
		else if (machXmlRec instanceof EquiMachineXmlType) {
			
		}
		else if (machXmlRec instanceof Eq1MachineXmlType) {
			Eq1MachineXmlType machXml = (Eq1MachineXmlType)machXmlRec;
			// create a machine and connect to the bus
			Eq1Machine mach = (Eq1Ed1Machine)DStabObjectFactory.
								createMachine(machId, machXml.getName(), MachineType.EQ1_MODEL, 
								(DStabilityNetwork)this.dstabBus.getNetwork(), dstabBus.getId());
			setEq1Data(mach, machXml);
		}
		else if (machXmlRec instanceof Eq1Ed1MachineXmlType) {
			Eq1Ed1MachineXmlType machXml = (Eq1Ed1MachineXmlType)machXmlRec;
			// create a machine and connect to the bus
			Eq1Ed1Machine mach = (Eq1Ed1Machine)DStabObjectFactory.
								createMachine(machId, machXml.getName(), MachineType.EQ1_ED1_MODEL, 
								(DStabilityNetwork)this.dstabBus.getNetwork(), dstabBus.getId());
			setEq1Ed1Data(mach, machXml);
		}
		else if (machXmlRec instanceof Eq11MachineXmlType) {
			Eq11MachineXmlType machXml = (Eq11MachineXmlType)machXmlRec;
			// create a machine and connect to the bus
			SalientPoleMachine mach = (SalientPoleMachine)DStabObjectFactory.
								createMachine(machId, machXml.getName(), MachineType.EQ11_SALIENT_POLE, 
								(DStabilityNetwork)this.dstabBus.getNetwork(), dstabBus.getId());
			setEq11Data(mach, machXml);
		}
		else if (machXmlRec instanceof Eq11Ed11MachineXmlType) {
			Eq11Ed11MachineXmlType machXml = (Eq11Ed11MachineXmlType)machXmlRec;
			// create a machine and connect to the bus "Gen"
			RoundRotorMachine mach = (RoundRotorMachine)DStabObjectFactory.
								createMachine(machId, machXml.getName(), MachineType.EQ11_ED11_ROUND_ROTOR, 
								(DStabilityNetwork)this.dstabBus.getNetwork(), dstabBus.getId());
			setEq11Eq11Data(mach, machXml);
		}
	}
	
	private void setEq1Data(Eq1Machine mach, Eq1MachineXmlType machXml) {
		// set machine data
		mach.setRating(this.ratedPower.getValue(), ODMXmlHelper.toUnit(this.ratedPower.getUnit()), dstabBus.getNetwork().getBaseKva());
		mach.setRatedVoltage(this.ratedVoltage.getValue(), ODMXmlHelper.toUnit(this.ratedVoltage.getUnit()));
		// the multiply factor is calculated using machine ratedP and ratedV against system 
		// base kva and bus base voltage
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
		mach.setTd01(machXml.getTd01().getValue());
		if (machXml.getSeFmt1() != null) {
			mach.setSliner(machXml.getSeFmt1().getSliner());
			mach.setSe100(machXml.getSeFmt1().getSe100());
			mach.setSe120(machXml.getSeFmt1().getSe120());					
		}
		else if (machXml.getSeFmt2() != null) {
			// TODO
		}
	}
	
	private void setEq1Ed1Data(Eq1Ed1Machine mach, Eq1Ed1MachineXmlType machXml) {
		setEq1Data(mach, machXml);
		mach.setXq1(machXml.getXq1());
		mach.setTq01(machXml.getTq01().getValue());
	}
	
	private void setEq11Data(SalientPoleMachine mach, Eq11MachineXmlType machXml) {
		setEq1Data(mach, machXml);
		mach.setXd11(machXml.getXd11());
		mach.setTd011(machXml.getTd011().getValue());
	}
	
	private void setEq11Eq11Data(RoundRotorMachine mach, Eq11Ed11MachineXmlType machXml) {
		setEq1Ed1Data(mach, machXml);
		mach.setXq11(machXml.getXq11());
		mach.setTq011(machXml.getTq011().getValue());
		mach.setXq11(machXml.getXd11());
		mach.setTq011(machXml.getTd011().getValue());
	}
}