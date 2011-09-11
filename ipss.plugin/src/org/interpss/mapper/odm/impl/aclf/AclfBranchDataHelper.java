/*
 * @(#)AclfBranchDataHelper.java   
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
 * @Date 02/01/2011
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.mapper.odm.impl.aclf;

import org.apache.commons.math.complex.Complex;
import org.ieee.odm.schema.ApparentPowerUnitType;
import org.ieee.odm.schema.LineBranchXmlType;
import org.ieee.odm.schema.PSXfr3WBranchXmlType;
import org.ieee.odm.schema.PSXfrBranchXmlType;
import org.ieee.odm.schema.Transformer3WInfoXmlType;
import org.ieee.odm.schema.TransformerInfoXmlType;
import org.ieee.odm.schema.Xfr3WBranchXmlType;
import org.ieee.odm.schema.XfrBranchXmlType;
import org.ieee.odm.schema.YXmlType;
import org.interpss.mapper.odm.ODMXmlHelper;

import com.interpss.common.datatype.UnitType;
import com.interpss.common.exp.InterpssException;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.aclf.Aclf3WXformer;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBranchCode;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclf.adpter.LineAdapter;
import com.interpss.core.aclf.adpter.PSXfr3WAdapter;
import com.interpss.core.aclf.adpter.PSXfrAdapter;
import com.interpss.core.aclf.adpter.Xfr3WAdapter;
import com.interpss.core.aclf.adpter.XfrAdapter;
import com.interpss.core.net.Branch;

public class AclfBranchDataHelper {
	private AclfNetwork aclfNet = null;
	private Branch branch = null;
	
	public AclfBranchDataHelper(AclfNetwork aclfNet, Branch bra) {
		this.aclfNet = aclfNet;
		this.branch = bra;
	}
	
	public void setLineBranchData(LineBranchXmlType braLine) throws InterpssException {
		AclfBranch aclfBra = (AclfBranch)branch;
		double baseKva = aclfNet.getBaseKva();

		aclfBra.setBranchCode(AclfBranchCode.LINE);
		//System.out.println(braXmlData.getLineData().getZ().getIm());
		LineAdapter line = aclfBra.toLine();
		if (braLine.getZ() == null) {
		throw new InterpssException("Line data error, Z == null, branch id: " + braLine.getId());
		}

		line.setZ(new Complex(braLine.getZ().getRe(), braLine.getZ().getIm()), 
			ODMXmlHelper.toZUnit(braLine.getZ().getUnit()), 
			aclfBra.getFromAclfBus().getBaseVoltage());
		if (braLine.getTotalShuntY() != null)
		line.setHShuntY(new Complex(0.5 * braLine.getTotalShuntY().getRe(),
					0.5 * braLine.getTotalShuntY().getIm()),
					ODMXmlHelper.toYUnit(braLine.getTotalShuntY().getUnit()), 
					aclfBra.getFromAclfBus().getBaseVoltage());

		YXmlType fromShuntY = braLine.getFromShuntY(),
				 toShuntY = braLine.getToShuntY();

		if (fromShuntY != null) {
			Complex ypu = UnitType.yConversion(new Complex(fromShuntY.getRe(),	
					fromShuntY.getIm()),
					aclfBra.getFromAclfBus().getBaseVoltage(), baseKva,
					ODMXmlHelper.toYUnit(fromShuntY.getUnit()), UnitType.PU);
			aclfBra.setFromShuntY(ypu);
		}
		if (toShuntY != null) {
			Complex ypu = UnitType.yConversion(new Complex(toShuntY.getRe(),	
					toShuntY.getIm()),
					aclfBra.getToAclfBus().getBaseVoltage(), baseKva,
					ODMXmlHelper.toYUnit(toShuntY.getUnit()), UnitType.PU);
			aclfBra.setToShuntY(ypu);
		}
	}
	
	public void setXfrBranchData(XfrBranchXmlType braXfr) throws InterpssException {
		AclfBranch aclfBra = (AclfBranch)branch;
		double baseKva = aclfNet.getBaseKva();
		
		aclfBra.setBranchCode(AclfBranchCode.XFORMER);
		setXformerInfoData(braXfr, aclfBra);

		YXmlType fromShuntY = braXfr.getMagnitizingY();
		if (fromShuntY != null) {
			Complex ypu = UnitType.yConversion(new Complex(fromShuntY.getRe(),	fromShuntY.getIm()),
					aclfBra.getFromAclfBus().getBaseVoltage(), baseKva,
					ODMXmlHelper.toYUnit(fromShuntY.getUnit()), UnitType.PU);
			aclfBra.setFromShuntY(ypu);
		}
	}
	
	public void setPsXfrBranchData(PSXfrBranchXmlType braPsXfr) throws InterpssException {
		AclfBranch aclfBra = (AclfBranch)branch;
		aclfBra.setBranchCode(AclfBranchCode.PS_XFORMER);

		setXfrBranchData(braPsXfr);
		
		PSXfrAdapter psXfr = aclfBra.toPSXfr();
		if(braPsXfr.getFromAngle() != null)
			psXfr.setFromAngle(braPsXfr.getFromAngle().getValue(), 
						ODMXmlHelper.toAngleUnit(braPsXfr.getFromAngle().getUnit()));
		if(braPsXfr.getToAngle() != null)
			psXfr.setToAngle(braPsXfr.getToAngle().getValue(), 
						ODMXmlHelper.toAngleUnit(braPsXfr.getToAngle().getUnit()));
	}

	private void setXformerInfoData(XfrBranchXmlType xfrBranch, AclfBranch aclfBra) {
		double baseKva = aclfNet.getBaseKva();

		double fromBaseV = aclfBra.getFromAclfBus().getBaseVoltage(), 
		       toBaseV = aclfBra.getToAclfBus().getBaseVoltage();
		// turn ratio is based on xfr rated voltage
		// voltage units should be same for both side 
		double fromRatedV = fromBaseV;
		double toRatedV = toBaseV;
		double zratio = 1.0;
		double tapratio = 1.0;
		
		TransformerInfoXmlType xfrData = xfrBranch.getXfrInfo();
		if (xfrData != null) {
			if (xfrData.getFromRatedVoltage() != null)
				fromRatedV = xfrData.getFromRatedVoltage().getValue();
			if (xfrData.getToRatedVoltage() != null)
				toRatedV = xfrData.getToRatedVoltage().getValue();

			if (xfrData.isDataOnSystemBase() != null && !xfrData.isDataOnSystemBase()) {
				if (xfrData.getRatedPower() != null) {
					if (xfrData.getRatedPower().getValue() > 0.0) 
						zratio = xfrData.getRatedPower().getUnit() == ApparentPowerUnitType.KVA?
								baseKva / xfrData.getRatedPower().getValue() :
								0.001 * baseKva / xfrData.getRatedPower().getValue();
				}
				tapratio = (fromRatedV/fromBaseV) / (toRatedV/toBaseV) ;
			}
		}
		
		double baseV = fromBaseV > toBaseV ? fromBaseV : toBaseV;
		XfrAdapter xfr = aclfBra.toXfr();
		xfr.setZ(new Complex(xfrBranch.getZ().getRe()*zratio, xfrBranch.getZ().getIm()*zratio),
				ODMXmlHelper.toZUnit(xfrBranch.getZ().getUnit()), baseV);
		xfr.setFromTurnRatio(xfrBranch.getFromTurnRatio().getValue() == 0.0 ? 1.0 : 
				xfrBranch.getFromTurnRatio().getValue()*tapratio, UnitType.PU);
		xfr.setToTurnRatio(xfrBranch.getToTurnRatio().getValue() == 0.0 ? 1.0 : 
				xfrBranch.getToTurnRatio().getValue()/tapratio, UnitType.PU);
	}
	
	/*
	 *   	3W Xfr
	 */
	
	public void setXfr3WBranchData(Xfr3WBranchXmlType xml3WXfr) throws InterpssException {
		IpssLogger.getLogger().info("Xfr3WBranchXmlType: " + xml3WXfr.getId());
		
		Aclf3WXformer branch3W = (Aclf3WXformer)branch;
		branch3W.setBranchCode(AclfBranchCode.W3_XFORMER);
		branch3W.create2WBranches(AclfBranchCode.XFORMER);
		
		// set winding status
		branch3W.getFromAclfBranch().setStatus(!xml3WXfr.isWind1OffLine());
		branch3W.getToAclfBranch().setStatus(!xml3WXfr.isWind2OffLine());
		branch3W.getTertAclfBranch().setStatus(!xml3WXfr.isWind3OffLine());
		
		Xfr3WAdapter xfr3W = branch3W.to3WXfr();
		
		setXfr3WData(xml3WXfr, xfr3W);
	}
	
	public void setPsXfr3WBranchData(PSXfr3WBranchXmlType xmlPsXfr3W) throws InterpssException {
		IpssLogger.getLogger().info("PSXfr3WBranchXmlType: " + xmlPsXfr3W.getId());
		
		Aclf3WXformer branch3W = (Aclf3WXformer)branch;
		branch3W.setBranchCode(AclfBranchCode.W3_PS_XFORMER);
		branch3W.create2WBranches(AclfBranchCode.PS_XFORMER);
		
		// set winding status
		branch3W.getFromAclfBranch().setStatus(!xmlPsXfr3W.isWind1OffLine());
		branch3W.getToAclfBranch().setStatus(!xmlPsXfr3W.isWind2OffLine());
		branch3W.getTertAclfBranch().setStatus(!xmlPsXfr3W.isWind3OffLine());

		PSXfr3WAdapter psXfr3W = branch3W.toPS3WXfr();
		
		setXfr3WData(xmlPsXfr3W, psXfr3W);
/*
        <fromAngle unit="DEG" value="0.0"/>
        <toAngle unit="DEG" value="0.0"/>
        <tertShiftAngle unit="DEG" value="30.0"/>
 */
		if (xmlPsXfr3W.getFromAngle() != null && xmlPsXfr3W.getFromAngle().getValue() != 0.0) {
			byte unit = ODMXmlHelper.toAngleUnit(xmlPsXfr3W.getFromAngle().getUnit());
			psXfr3W.setFromAngle(xmlPsXfr3W.getFromAngle().getValue(), unit);
		}
		if (xmlPsXfr3W.getToAngle() != null && xmlPsXfr3W.getToAngle().getValue() != 0.0) {
			byte unit = ODMXmlHelper.toAngleUnit(xmlPsXfr3W.getToAngle().getUnit());
			psXfr3W.setToAngle(xmlPsXfr3W.getToAngle().getValue(), unit);
		}
		if (xmlPsXfr3W.getTertShiftAngle() != null && xmlPsXfr3W.getTertShiftAngle().getValue() != 0.0) {
			byte unit = ODMXmlHelper.toAngleUnit(xmlPsXfr3W.getTertShiftAngle().getUnit());
			psXfr3W.setTertAngle(xmlPsXfr3W.getTertShiftAngle().getValue(), unit);
		}
	}

	private void setXfr3WData(Xfr3WBranchXmlType xml3WXfr, Xfr3WAdapter xfr3W) throws InterpssException {
		Aclf3WXformer branch3W = (Aclf3WXformer)branch;
		double baseKva = aclfNet.getBaseKva();
		
//        <magnitizingY unit="PU" im="-0.0042" re="0.0012"/>
		YXmlType fromShuntY = xml3WXfr.getMagnitizingY();
		if (fromShuntY != null) {
			Complex ypu = UnitType.yConversion(new Complex(fromShuntY.getRe(),	fromShuntY.getIm()),
					branch3W.getFromBus().getBaseVoltage(), baseKva,
					ODMXmlHelper.toYUnit(fromShuntY.getUnit()), UnitType.PU);
			branch3W.getFromAclfBranch().setFromShuntY(ypu);
		}

//      <meterLocation>ToSide</meterLocation>
		
		
		double fromBaseV = branch3W.getFromBus().getBaseVoltage(), 
	       		toBaseV = branch3W.getToBus().getBaseVoltage(),
	       		tertBaseV = branch3W.getToBus().getBaseVoltage();
		// turn ratio is based on xfr rated voltage
		// voltage units should be same for both side 
		double fromRatedV = fromBaseV;
		double toRatedV = toBaseV;
		double tertRatedV = tertBaseV;

		double zratio = 1.0;
		double tapratio = 1.0;
		
		Transformer3WInfoXmlType xfrData = (Transformer3WInfoXmlType)xml3WXfr.getXfrInfo();
		/*
            <xfrInfo xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:type="Transformer3WInfoXmlType">
                <dataOnSystemBase>true</dataOnSystemBase>
                <ratedPower unit="MVA" value="1000.0"/>
                <starVMag unit="PU" value="0.99004"/>
                <starVAng unit="DEG" value="1.5349"/>
                <ratedPower23 unit="MVA" value="1000.0"/>
                <ratedPower31 unit="MVA" value="1000.0"/>
            </xfrInfo>
		 */
		if (xfrData != null) {
			if (xfrData.getFromRatedVoltage() != null)
				fromRatedV = xfrData.getFromRatedVoltage().getValue();
			if (xfrData.getToRatedVoltage() != null)
				toRatedV = xfrData.getToRatedVoltage().getValue();
			if (xfrData.getTertRatedVoltage() != null)
				tertRatedV = xfrData.getTertRatedVoltage().getValue();

			if (!xfrData.isDataOnSystemBase() &&
					xfrData.getRatedPower() != null && 
					xfrData.getRatedPower().getValue() > 0.0) 
				zratio = xfrData.getRatedPower().getUnit() == ApparentPowerUnitType.KVA?
						baseKva / xfrData.getRatedPower().getValue() :
							0.001 * baseKva / xfrData.getRatedPower().getValue();

			if (!xfrData.isDataOnSystemBase())
				tapratio = (fromRatedV/fromBaseV) / (toRatedV/toBaseV) ;
		}	
		
		/*
            <z unit="PU" im="0.025" re="2.0E-4"/>
            <fromTurnRatio unit="PU" value="1.0101"/>
            <toTurnRatio unit="PU" value="1.05"/>
            <z23 unit="PU" im="0.01" re="3.0E-4"/>
            <z31 unit="PU" im="0.011" re="4.0E-4"/>
            <tertTurnRatio unit="PU" value="1.01"/>
*/
		double baseV = fromBaseV > toBaseV ? fromBaseV : toBaseV;
		baseV = baseV > tertBaseV ? baseV : tertBaseV;
		Complex z12 = new Complex(xml3WXfr.getZ().getRe()*zratio, xml3WXfr.getZ().getIm()*zratio);
		Complex z23 = new Complex(xml3WXfr.getZ23().getRe()*zratio, xml3WXfr.getZ23().getIm()*zratio);
		Complex z31 = new Complex(xml3WXfr.getZ31().getRe()*zratio, xml3WXfr.getZ31().getIm()*zratio);
		byte unit = ODMXmlHelper.toZUnit(xml3WXfr.getZ().getUnit());
		xfr3W.setZ(z12, z31, z23, unit, baseV);

		double fromRatio = xml3WXfr.getFromTurnRatio().getValue()*tapratio;
		double toRatio = xml3WXfr.getToTurnRatio().getValue()*tapratio;
		double tertRatio = xml3WXfr.getTertTurnRatio().getValue()*tapratio;
		
		xfr3W.setFromTurnRatio(fromRatio == 0.0 ? 1.0 : fromRatio);
		xfr3W.setToTurnRatio(toRatio == 0.0 ? 1.0 : fromRatio);
		xfr3W.setTertTurnRatio(tertRatio == 0.0 ? 1.0 : fromRatio);
		
/*
                <ratingLimit>
                    <mva unit="MVA" rating3="1090.0" rating2="1150.0" rating1="1200.0"/>
                </ratingLimit>
                <ratingLimit23>
                    <mva unit="MVA" rating3="1112.0" rating2="1175.0" rating1="1250.0"/>
                </ratingLimit23>
                <ratingLimit13>
                    <mva unit="MVA" rating3="1157.0" rating2="1200.0" rating1="1280.0"/>
                </ratingLimit13>
 */
		
/*
                <tapAdjustment offLine="false">
                    <adjustmentType>Voltage</adjustmentType>
                    <tapLimit unit="PU" min="0.92" max="1.1002"/>
                    <tapAdjStep>33</tapAdjStep>
                    <tapAdjOnFromSide>false</tapAdjOnFromSide>
                    <voltageAdjData desiredValue="0.0" mode="RangeAdjustment" min="0.93" max="1.16"/>
                </tapAdjustment>
*/
	}
}