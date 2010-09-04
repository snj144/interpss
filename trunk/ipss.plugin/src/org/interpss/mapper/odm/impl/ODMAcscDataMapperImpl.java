/*
 * @(#)ODMAclfDataMapperImpl.java   
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

package org.interpss.mapper.odm.impl;

import org.apache.commons.math.complex.Complex;
import org.ieee.odm.schema.BranchXmlType;
import org.ieee.odm.schema.GroundingEnumType;
import org.ieee.odm.schema.GroundingXmlType;
import org.ieee.odm.schema.LineShortCircuitXmlType;
import org.ieee.odm.schema.PSXfrShortCircuitXmlType;
import org.ieee.odm.schema.ShortCircuitBusEnumType;
import org.ieee.odm.schema.ShortCircuitBusXmlType;
import org.ieee.odm.schema.ShortCircuitNetXmlType;
import org.ieee.odm.schema.XformerConnectionXmlType;
import org.ieee.odm.schema.XformrtConnectionEnumType;
import org.ieee.odm.schema.XfrShortCircuitXmlType;
import org.ieee.odm.schema.YXmlType;
import org.ieee.odm.schema.ZXmlType;
import org.interpss.mapper.odm.ODMXmlHelper;

import com.interpss.common.datatype.Constants;
import com.interpss.common.exp.InterpssException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.acsc.AcscBranch;
import com.interpss.core.acsc.AcscBus;
import com.interpss.core.acsc.AcscLineAdapter;
import com.interpss.core.acsc.AcscNetwork;
import com.interpss.core.acsc.AcscXfrAdapter;
import com.interpss.core.acsc.BusGroundCode;
import com.interpss.core.acsc.BusScCode;
import com.interpss.core.acsc.SequenceCode;
import com.interpss.core.acsc.XfrConnectCode;


public class ODMAcscDataMapperImpl {
	/**
	 * Map the network info only
	 * 
	 * @param xmlNet
	 * @return
	 */
	public static void mapNetworkData(AcscNetwork net, ShortCircuitNetXmlType xmlNet) {
		ODMAclfDataMapperImpl.mapNetworkData(net, xmlNet);
		net.setPositiveSeqDataOnly(xmlNet.isPositiveSeqDataOnly());
	}	

	/**
	 * Set SC bus info only
	 * 
	 * @param acscBusXml
	 * @param acscBus
	 */
	public static void setAcscBusData(ShortCircuitBusXmlType acscBusXml, AcscBus acscBus) throws InterpssException {
		if (acscBusXml.getScCode() == ShortCircuitBusEnumType.CONTRIBUTING) {
			setContributeBusFormInfo(acscBusXml, acscBus);
		} else { // non-contributing
			setNonContributeBusFormInfo(acscBus);
		} 
	}
	
	private static void setNonContributeBusFormInfo(AcscBus acscBus) {
		acscBus.setScCode(BusScCode.NON_CONTRI);
		acscBus.setZ(Constants.LargeBusZ, SequenceCode.POSITIVE);
		acscBus.setZ(Constants.LargeBusZ, SequenceCode.NEGATIVE);
		acscBus.setZ(Constants.LargeBusZ, SequenceCode.ZERO);
		acscBus.getGrounding().setCode(BusGroundCode.UNGROUNDED);
		acscBus.getGrounding().setZ(Constants.LargeBusZ);
	}
	
	private static void setContributeBusFormInfo(ShortCircuitBusXmlType busData, AcscBus acscBus) {
		acscBus.setScCode(BusScCode.CONTRIBUTE);
		if (busData.getScGenData() != null) {
			setBusScZ(acscBus, acscBus.getNetwork().getBaseKva(), 
					busData.getScGenData().getPotiveZ(),
					busData.getScGenData().getNegativeZ(),
					busData.getScGenData().getZeroZ());
			setBusScZg(acscBus, acscBus.getBaseVoltage(), acscBus.getNetwork().getBaseKva(), 
					busData.getScGenData().getGrounding());
		}
	}
	
	private static void setBusScZ(AcscBus bus, double baseKVA, 
			ZXmlType z1, ZXmlType z2, ZXmlType z0) {
		byte zUnit = ODMXmlHelper.toUnit(z1.getUnit());
		bus.setZ(new Complex(z1.getRe(), z1.getIm()), SequenceCode.POSITIVE, zUnit);
		bus.setZ(new Complex(z2.getRe(), z2.getIm()), SequenceCode.NEGATIVE, zUnit);
		bus.setZ(new Complex(z0.getRe(), z0.getIm()), SequenceCode.ZERO, zUnit);
	}

	private static void setBusScZg(AcscBus bus, double baseV, double baseKVA, GroundingXmlType g) {
		ZXmlType z = g.getGroundZ();
		byte zgUnit = ODMXmlHelper.toUnit(z.getUnit());
		bus.getGrounding().setCode(ODMXmlHelper.toBusGroundCode(g.getConnection()));
		bus.getGrounding().setZ(new Complex(z.getRe(), z.getIm()), zgUnit, baseV, baseKVA);
	}
	
	/**
	 * Set SC branch info only
	 * 
	 * @param acscBraXml
	 * @param acscBra
	 * @param msg
	 * @return
	 */
	public static void setAcscBranchData(BranchXmlType acscBraXml, AcscBranch acscBra, IPSSMsgHub msg) {

		if (acscBraXml instanceof LineShortCircuitXmlType) { // line branch
			setAcscLineFormInfo((LineShortCircuitXmlType)acscBraXml, acscBra, msg);
		} 
		else if ( acscBraXml instanceof XfrShortCircuitXmlType ||
				acscBraXml instanceof PSXfrShortCircuitXmlType) { // xfr or psxfr branch
			setAcscXfrFormInfo((XfrShortCircuitXmlType)acscBraXml, acscBra, msg);
		}
	}
	
	private static void setAcscLineFormInfo(LineShortCircuitXmlType braXml,	AcscBranch acscBra, IPSSMsgHub msg) {
		double baseV = acscBra.getFromAclfBus().getBaseVoltage();
		AcscLineAdapter line = (AcscLineAdapter) acscBra.getAdapter(AcscLineAdapter.class);
		ZXmlType z0 = braXml.getZ0();
		if (z0 != null)
			line.setZ0(new Complex(z0.getRe(), z0.getIm()),	ODMXmlHelper.toUnit(z0.getUnit()), baseV, msg);
		YXmlType y0 = braXml.getY0Shunt();
		if (y0 != null)
			line.setHB0(0.5*y0.getIm(), ODMXmlHelper.toUnit(y0.getUnit()), baseV);
	}

	// for SC, Xfr and PSXfr behave the same
	private static void setAcscXfrFormInfo(XfrShortCircuitXmlType braXml, AcscBranch acscBra, IPSSMsgHub msg) {
		double baseV = acscBra.getFromAclfBus().getBaseVoltage() > acscBra
				.getToAclfBus().getBaseVoltage() ? acscBra.getFromAclfBus()
				.getBaseVoltage() : acscBra.getToAclfBus().getBaseVoltage();
		AcscXfrAdapter xfr = (AcscXfrAdapter) acscBra.getAdapter(AcscXfrAdapter.class);
		ZXmlType z0 = braXml.getZ0();
		if (z0 != null)
			xfr.setZ0(new Complex(z0.getRe(), z0.getIm()), ODMXmlHelper.toUnit(z0.getUnit()), baseV, msg);

		XformerConnectionXmlType connect = braXml.getFromSideConnection();
		if (connect != null && connect.getGrounding() != null) {
			ZXmlType z = connect.getGrounding().getGroundZ();
			if (z != null) 
				xfr.setFromConnectGroundZ(calXfrConnectCode(connect), new Complex(z.getRe(), z.getIm()),
						ODMXmlHelper.toUnit(z.getUnit()));
		}

		connect = braXml.getToSideConnection();
		if (connect != null && connect.getGrounding() != null) {
			ZXmlType z = connect.getGrounding().getGroundZ();
			if (z != null) 
				xfr.setFromConnectGroundZ(calXfrConnectCode(connect), new Complex(z.getRe(), z.getIm()),
						ODMXmlHelper.toUnit(z.getUnit()));
		}
	}
	
	private static XfrConnectCode calXfrConnectCode(XformerConnectionXmlType connect) {
		// connectCode : [Delta | Wye]
		// groundCode : [SolidGrounded | ZGrounded | Ungrounded ]
		if (connect.getConnection() == XformrtConnectionEnumType.DELTA)
			return XfrConnectCode.DELTA;
		else {  // Wye connection
			if (connect.getGrounding().getConnection() == GroundingEnumType.SOLID_GROUNDED)
				return XfrConnectCode.WYE_SOLID_GROUNDED;
			else if (connect.getGrounding().getConnection() == GroundingEnumType.Z_GROUNDED)
				return XfrConnectCode.WYE_ZGROUNDED;
			else 
				return XfrConnectCode.WYE_UNGROUNDED;
		}
	}
}