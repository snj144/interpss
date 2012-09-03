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

import static com.interpss.common.util.IpssLogger.ipssLogger;
import static org.interpss.mapper.odm.ODMUnitHelper.ToAngleUnit;
import static org.interpss.mapper.odm.ODMUnitHelper.ToYUnit;
import static org.interpss.mapper.odm.ODMUnitHelper.ToZUnit;

import org.apache.commons.math3.complex.Complex;
import org.ieee.odm.schema.AngleAdjustmentXmlType;
import org.ieee.odm.schema.AngleUnitType;
import org.ieee.odm.schema.ApparentPowerUnitType;
import org.ieee.odm.schema.LineBranchEnumType;
import org.ieee.odm.schema.LineBranchXmlType;
import org.ieee.odm.schema.PSXfr3WBranchXmlType;
import org.ieee.odm.schema.PSXfrBranchXmlType;
import org.ieee.odm.schema.TapAdjustmentEnumType;
import org.ieee.odm.schema.TapAdjustmentXmlType;
import org.ieee.odm.schema.Transformer3WInfoXmlType;
import org.ieee.odm.schema.TransformerInfoXmlType;
import org.ieee.odm.schema.VoltageUnitType;
import org.ieee.odm.schema.Xfr3WBranchXmlType;
import org.ieee.odm.schema.XfrBranchXmlType;
import org.ieee.odm.schema.YXmlType;
import org.interpss.numeric.datatype.LimitType;
import org.interpss.numeric.datatype.Unit.UnitType;

import com.interpss.CoreObjectFactory;
import com.interpss.common.datatype.UnitHelper;
import com.interpss.common.exp.InterpssException;
import com.interpss.core.aclf.Aclf3WXformer;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBranchCode;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclf.adj.AdjControlType;
import com.interpss.core.aclf.adj.PSXfrPControl;
import com.interpss.core.aclf.adj.TapControl;
import com.interpss.core.aclf.adpter.AclfLine;
import com.interpss.core.aclf.adpter.AclfPSXformer;
import com.interpss.core.aclf.adpter.AclfXformer;
import com.interpss.core.aclf.adpter.PSXfr3WAdapter;
import com.interpss.core.aclf.adpter.Xfr3WAdapter;
import com.interpss.core.net.Branch;

/**
 * Aclf branch data ODM mapping helper functions 
 * 
 * @author mzhou
 *
 */
public class AclfBranchDataHelper {
	private AclfNetwork aclfNet = null;
	private Branch branch = null;
	
	/**
	 * constructor
	 * 
	 * @param aclfNet
	 * @param bra
	 */
	public AclfBranchDataHelper(AclfNetwork aclfNet, Branch bra) {
		this.aclfNet = aclfNet;
		this.branch = bra;
	}
	
	/**
	 * 	 map the Aclf Line ODM object info to the AclfBranch object
	 * 
	 * @param xmlLineBranch
	 * @throws InterpssException
	 */
	public void setLineBranchData(LineBranchXmlType xmlLineBranch) throws InterpssException {
		AclfBranch aclfBra = (AclfBranch)this.branch;
		double baseKva = aclfNet.getBaseKva();

		if (xmlLineBranch.getLineInfo() != null && xmlLineBranch.getLineInfo().getType() == LineBranchEnumType.BREAKER)
			aclfBra.setBranchCode(AclfBranchCode.BREAKER);
		else
			aclfBra.setBranchCode(AclfBranchCode.LINE);

		//System.out.println(braXmlData.getLineData().getZ().getIm());
		AclfLine line = aclfBra.toLine();
		if (xmlLineBranch.getZ() == null) {
		throw new InterpssException("Line data error, Z == null, branch id: " + xmlLineBranch.getId());
		}

		line.setZ(new Complex(xmlLineBranch.getZ().getRe(), xmlLineBranch.getZ().getIm()), 
				ToZUnit.f(xmlLineBranch.getZ().getUnit()), 
			aclfBra.getFromAclfBus().getBaseVoltage());
		if (xmlLineBranch.getTotalShuntY() != null)
		line.setHShuntY(new Complex(0.5 * xmlLineBranch.getTotalShuntY().getRe(),
					0.5 * xmlLineBranch.getTotalShuntY().getIm()),
					ToYUnit.f(xmlLineBranch.getTotalShuntY().getUnit()), 
					aclfBra.getFromAclfBus().getBaseVoltage());

		YXmlType fromShuntY = xmlLineBranch.getFromShuntY(),
				 toShuntY = xmlLineBranch.getToShuntY();

		if (fromShuntY != null) {
			Complex ypu = UnitHelper.yConversion(new Complex(fromShuntY.getRe(),	
					fromShuntY.getIm()),
					aclfBra.getFromAclfBus().getBaseVoltage(), baseKva,
					ToYUnit.f(fromShuntY.getUnit()), UnitType.PU);
			aclfBra.setFromShuntY(ypu);
		}
		if (toShuntY != null) {
			Complex ypu = UnitHelper.yConversion(new Complex(toShuntY.getRe(),	
					toShuntY.getIm()),
					aclfBra.getToAclfBus().getBaseVoltage(), baseKva,
					ToYUnit.f(toShuntY.getUnit()), UnitType.PU);
			aclfBra.setToShuntY(ypu);
		}
	}

	/**
	 * 	 map the Aclf Xfr ODM object info to the AclfBranch object
	 * 
	 * @param xmlXfrBranch
	 * @throws InterpssException
	 */
	public void setXfrBranchData(XfrBranchXmlType xmlXfrBranch) throws InterpssException {
		AclfBranch aclfBra = (AclfBranch)this.branch;
		double baseKva = aclfNet.getBaseKva();
		
		aclfBra.setBranchCode(AclfBranchCode.XFORMER);
		setXfrData(xmlXfrBranch, aclfBra, baseKva);
	}

	
	private void setXfrData(XfrBranchXmlType xmlXfrBranch, AclfBranch aclfBra, double baseKva) throws InterpssException {
		setXformerInfoData(xmlXfrBranch, aclfBra);

		YXmlType fromShuntY = xmlXfrBranch.getMagnitizingY();
		if (fromShuntY != null) {
			Complex ypu = UnitHelper.yConversion(new Complex(fromShuntY.getRe(),	fromShuntY.getIm()),
					aclfBra.getFromAclfBus().getBaseVoltage(), baseKva,
					ToYUnit.f(fromShuntY.getUnit()), UnitType.PU);
			aclfBra.setFromShuntY(ypu);
		}
	}
	
	/**
	 * 	 map the Aclf PSXfr ODM object info to the AclfBranch object
	 * 
	 * @param xmlPsXfrBranch
	 * @throws InterpssException
	 */
	public void setPsXfrBranchData(PSXfrBranchXmlType xmlPsXfrBranch) throws InterpssException {
		AclfBranch aclfBra = (AclfBranch)this.branch;
		aclfBra.setBranchCode(AclfBranchCode.PS_XFORMER);
		double baseKva = aclfNet.getBaseKva();
		
		setXfrData(xmlPsXfrBranch, aclfBra, baseKva);
		
		AclfPSXformer psXfr = aclfBra.toPSXfr();
		if(xmlPsXfrBranch.getFromAngle() != null)
			psXfr.setFromAngle(xmlPsXfrBranch.getFromAngle().getValue(), 
					ToAngleUnit.f(xmlPsXfrBranch.getFromAngle().getUnit()));
		if(xmlPsXfrBranch.getToAngle() != null)
			psXfr.setToAngle(xmlPsXfrBranch.getToAngle().getValue(), 
					ToAngleUnit.f(xmlPsXfrBranch.getToAngle().getUnit()));
		
		if (xmlPsXfrBranch.getAngleAdjustment() != null) {
			AngleAdjustmentXmlType xmlAngAdj = xmlPsXfrBranch.getAngleAdjustment();
	/* Sample code
		PSXfrPControl psxfr = CoreObjectFactory.createPSXfrPControl(branch, AdjControlType.POINT_CONTROL); 
		psxfr.setControlSpec(0.4);
		psxfr.setAngLimit(new LimitType(5.0, -0.5), UnitType.Deg);
		psxfr.setControlOnFromSide(true);
		psxfr.setFlowFrom2To(true);
	*/
		}
		
		// TODO PsXfr shift angle control
	}

	private void setXformerInfoData(XfrBranchXmlType xmlXfrBranch, AclfBranch aclfBra) {
		double baseKva = aclfNet.getBaseKva();

		double fromBaseV = aclfBra.getFromAclfBus().getBaseVoltage(), 
		       toBaseV = aclfBra.getToAclfBus().getBaseVoltage();
		// turn ratio is based on xfr rated voltage
		// voltage units should be same for both side 
		double fromRatedV = fromBaseV;
		double toRatedV = toBaseV;
		double zratio = 1.0;
		double fromTapratio = 1.0, toTapratio = 1.0;
		
		TransformerInfoXmlType xfrData = xmlXfrBranch.getXfrInfo();
		if (xfrData != null) {
			if (xfrData.getFromRatedVoltage() != null) {
				fromRatedV = xfrData.getFromRatedVoltage().getValue();
				if (xfrData.getFromRatedVoltage().getUnit() == VoltageUnitType.KV)
					fromRatedV *= 1000.0;
			}
			if (xfrData.getToRatedVoltage() != null) {
				toRatedV = xfrData.getToRatedVoltage().getValue();
				if (xfrData.getToRatedVoltage().getUnit() == VoltageUnitType.KV)
					toRatedV *= 1000.0;
			}

			if (xfrData.isDataOnSystemBase() != null && !xfrData.isDataOnSystemBase()) {
				if (xfrData.getRatedPower() != null) {
					if (xfrData.getRatedPower().getValue() > 0.0) 
						zratio = xfrData.getRatedPower().getUnit() == ApparentPowerUnitType.KVA?
								baseKva / xfrData.getRatedPower().getValue() :
								0.001 * baseKva / xfrData.getRatedPower().getValue();
				}
				fromTapratio = fromRatedV/fromBaseV;
				toTapratio = toRatedV/toBaseV ;
			}
		}
		
		double baseV = fromBaseV > toBaseV ? fromBaseV : toBaseV;
		AclfXformer xfr = aclfBra.toXfr();
		xfr.setZ(new Complex(xmlXfrBranch.getZ().getRe()*zratio, xmlXfrBranch.getZ().getIm()*zratio),
				ToZUnit.f(xmlXfrBranch.getZ().getUnit()), baseV);
		double ratio = xmlXfrBranch.getFromTurnRatio().getValue()*(fromRatedV != fromBaseV?fromTapratio:1.0);
		xfr.setFromTurnRatio(ratio == 0.0 ? 1.0 : ratio, UnitType.PU);
		ratio = xmlXfrBranch.getToTurnRatio().getValue()*(toRatedV != toBaseV?toTapratio:1.0);
		xfr.setToTurnRatio(ratio == 0.0 ? 1.0 : ratio, UnitType.PU);
		
		if (xmlXfrBranch.getTapAdjustment() != null) {
			TapAdjustmentXmlType xmlTapAdj = xmlXfrBranch.getTapAdjustment();
			if (xmlTapAdj.getAdjustmentType() == TapAdjustmentEnumType.VOLTAGE) {
	/* Sample code
		AclfBranch branch = net.getAclfBranch("0001->0002(1)");
		TapControl tap = CoreObjectFactory.createTapVControlBusVoltage(branch, 
							AdjControlType.POINT_CONTROL, net, "0002");
		tap.setControlLimit(new LimitType(1.10, 0.9));
		tap.setControlOnFromSide(false);
		tap.setTapOnFromSide(false);
		tap.setControlSpec(0.95);
	 */
        		
			}
			else if (xmlTapAdj.getAdjustmentType() == TapAdjustmentEnumType.M_VAR_FLOW) {

        		
			}
		}
		
		// TODO: XfrTapControl data mapping
	}
	
	/*
	 *   	3W Xfr
	 */
	
	/**
	 * 	 map the Aclf 3W xfr ODM object info to the AclfBranch object
	 * 
	 * @param xml3WXfr
	 */
	public void setXfr3WBranchData(Xfr3WBranchXmlType xml3WXfr) throws InterpssException {
		ipssLogger.info("Xfr3WBranchXmlType: " + xml3WXfr.getId());
		
		Aclf3WXformer branch3W = (Aclf3WXformer)this.branch;
		branch3W.setBranchCode(AclfBranchCode.W3_XFORMER);
		// create three 2W xfr branch objects and a star bus object 
		branch3W.create2WBranches(AclfBranchCode.XFORMER);
		
		// set winding status
		branch3W.getFromAclfBranch().setStatus(!xml3WXfr.isOffLine() && !xml3WXfr.isWind1OffLine());
		branch3W.getToAclfBranch().setStatus(!xml3WXfr.isOffLine() && !xml3WXfr.isWind2OffLine());
		branch3W.getTertAclfBranch().setStatus(!xml3WXfr.isOffLine() && !xml3WXfr.isWind3OffLine());
		
		// create a 3W xfr wrapper (adapter) for processing 3W data
		Xfr3WAdapter xfr3W = branch3W.to3WXfr();
		
		setXfr3WData(xml3WXfr, xfr3W);
	}
	
	public void setPsXfr3WBranchData(PSXfr3WBranchXmlType xmlPsXfr3W) throws InterpssException {
		ipssLogger.info("PSXfr3WBranchXmlType: " + xmlPsXfr3W.getId());
		
		Aclf3WXformer branch3W = (Aclf3WXformer)this.branch;
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
			UnitType unit = ToAngleUnit.f(xmlPsXfr3W.getFromAngle().getUnit());
			psXfr3W.setFromAngle(xmlPsXfr3W.getFromAngle().getValue(), unit);
		}
		if (xmlPsXfr3W.getToAngle() != null && xmlPsXfr3W.getToAngle().getValue() != 0.0) {
			UnitType unit = ToAngleUnit.f(xmlPsXfr3W.getToAngle().getUnit());
			psXfr3W.setToAngle(xmlPsXfr3W.getToAngle().getValue(), unit);
		}
		if (xmlPsXfr3W.getTertShiftAngle() != null && xmlPsXfr3W.getTertShiftAngle().getValue() != 0.0) {
			UnitType unit = ToAngleUnit.f(xmlPsXfr3W.getTertShiftAngle().getUnit());
			psXfr3W.setTertAngle(xmlPsXfr3W.getTertShiftAngle().getValue(), unit);
		}
	}

	private void setXfr3WData(Xfr3WBranchXmlType xml3WXfr, Xfr3WAdapter xfr3W) throws InterpssException {
		Aclf3WXformer branch3W = (Aclf3WXformer)this.branch;
		double baseKva = aclfNet.getBaseKva();
		
//        <magnitizingY unit="PU" im="-0.0042" re="0.0012"/>
		YXmlType fromShuntY = xml3WXfr.getMagnitizingY();
		if (fromShuntY != null) {
			Complex ypu = UnitHelper.yConversion(new Complex(fromShuntY.getRe(),	fromShuntY.getIm()),
					branch3W.getFromBus().getBaseVoltage(), baseKva,
					ToYUnit.f(fromShuntY.getUnit()), UnitType.PU);
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
			
			if (xfrData.getStarVMag() != null && xfrData.getStarVAng() != null) {
				if (xfrData.getStarVMag().getUnit() == VoltageUnitType.PU || xfrData.getStarVAng().getUnit() == AngleUnitType.DEG) {
					AclfBus starBus = (AclfBus)xfr3W.getAclf3WBranch().getStarBus();
					starBus.setVoltage(xfrData.getStarVMag().getValue(),
					                   Math.toRadians(xfrData.getStarVAng().getValue()));
					xfr3W.getAclf3WBranch().setVoltageStarBus(starBus.getVoltage());
				}
				else {
					throw new InterpssException("function not implemented yet"); 
				}
			}
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
		UnitType unit = ToZUnit.f(xml3WXfr.getZ().getUnit());
		// set 3W xfr branch z to the three 2W xfr branches
		xfr3W.setZ(z12, z31, z23, unit, baseV);

		double fromRatio = xml3WXfr.getFromTurnRatio().getValue()*tapratio;
		double toRatio = xml3WXfr.getToTurnRatio().getValue()*tapratio;
		double tertRatio = xml3WXfr.getTertTurnRatio().getValue()*tapratio;
		
		xfr3W.setFromTurnRatio(fromRatio == 0.0 ? 1.0 : fromRatio);
		xfr3W.setToTurnRatio(toRatio == 0.0 ? 1.0 : toRatio);
		xfr3W.setTertTurnRatio(tertRatio == 0.0 ? 1.0 : tertRatio);
		
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