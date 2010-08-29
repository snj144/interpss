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

package org.interpss.mapper.odm.impl.dstab;

import org.ieee.odm.schema.Eq11Ed11MachineXmlType;
import org.ieee.odm.schema.Eq11MachineXmlType;
import org.ieee.odm.schema.Eq1Ed1MachineXmlType;
import org.ieee.odm.schema.Eq1MachineXmlType;

import com.interpss.common.datatype.UnitType;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.mach.Eq1Ed1Machine;
import com.interpss.dstab.mach.Eq1Machine;
import com.interpss.dstab.mach.RoundRotorMachine;
import com.interpss.dstab.mach.SalientPoleMachine;


public class MachDataHelper {
	private DStabBus dstabBus = null;
	
	public MachDataHelper(DStabBus dstabBus) {
		this.dstabBus = dstabBus;
	}
	
	public void setEq1Data(Eq1Machine mach, Eq1MachineXmlType machXml) {
		// set machine data
		mach.setRating(machXml.getRatedPower().getValue(), UnitType.mVA, dstabBus.getNetwork().getBaseKva());
		//mach.setRatedVoltage(machXml.getRatedVoltage().getValue(), "Kv");
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
			
		}
	}
	
	public void setEq1Ed1Data(Eq1Ed1Machine mach, Eq1Ed1MachineXmlType machXml) {
		setEq1Data(mach, machXml);
		mach.setXq1(machXml.getXq1());
		mach.setTq01(machXml.getTq01().getValue());
	}
	
	public void setEq11Data(SalientPoleMachine mach, Eq11MachineXmlType machXml) {
		setEq1Data(mach, machXml);
		mach.setXd11(machXml.getXd11());
		mach.setTd011(machXml.getTd011().getValue());
	}
	
	public void setEq11Eq11Data(RoundRotorMachine mach, Eq11Ed11MachineXmlType machXml) {
		setEq1Ed1Data(mach, machXml);
		mach.setXq11(machXml.getXq11());
		mach.setTq011(machXml.getTq011().getValue());
		mach.setXq11(machXml.getXd11());
		mach.setTq011(machXml.getTd011().getValue());
	}
}