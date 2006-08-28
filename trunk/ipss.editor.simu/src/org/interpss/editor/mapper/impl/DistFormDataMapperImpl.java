package org.interpss.editor.mapper.impl;

/*
 *  Provide mapping functions to map DistNetForm, DistBusForm and DistBranchForm object to an AcscAdjNetwork
 *  simu object.
 */

import java.util.List;

import org.apache.commons.math.complex.Complex;
import org.interpss.editor.data.common.GroundData;
import org.interpss.editor.data.common.ScPointData;
import org.interpss.editor.data.common.XfrConnectData;
import org.interpss.editor.data.common.ZData;
import org.interpss.editor.data.dist.DistBranchData;
import org.interpss.editor.data.dist.DistBusData;
import org.interpss.editor.data.dist.DistNetData;
import org.interpss.editor.form.GBranchForm;
import org.interpss.editor.form.GBusForm;
import org.interpss.editor.form.GFormContainer;
import org.interpss.editor.form.GNetForm;
import org.interpss.editor.jgraph.ui.form.IGBranchForm;

import com.interpss.common.datatype.ScGroundType;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.dist.DistBranch;
import com.interpss.dist.DistBranchCode;
import com.interpss.dist.DistBus;
import com.interpss.dist.DistBusCode;
import com.interpss.dist.DistNetwork;
import com.interpss.dist.DistObjectFactory;
import com.interpss.dist.ScStanderd;
import com.interpss.dist.TransformConnectCode;
import com.interpss.dist.datatype.ScPointType;


public class DistFormDataMapperImpl {
    /**
     * Map the GNetContainer object to a DistNetwork object
     * 
     * @param editNet a NetContainer object, containing the net info
     * @param msg a SessionMsg object
     * @return the DistNetwork object
     */
	public static DistNetwork mapEditNet2DistNet(GFormContainer editNet, IPSSMsgHub msg) {
		// Parse the AcscNet xml object into a AcscNet form object
		DistNetwork distNet = DistFormDataMapperImpl.createDistNet((GNetForm)editNet.getGNetForm());

		List busList = editNet.getBusFormList();
		for ( int i = 0; i < busList.size(); i++ ) {
			// For each AcscBus xml object, parse for an AcscBus form object
			GBusForm busForm = (GBusForm)busList.get(i);
			DistFormDataMapperImpl.addBusForm2Net(busForm, distNet);
		}

		List branchList = editNet.getBranchFormList();
		for ( int i = 0; i < branchList.size(); i++ ) {
			// For each AcscBranch xml object, parse for an AcscBranch form object
			GBranchForm branchForm = (GBranchForm)branchList.get(i);
			DistFormDataMapperImpl.addBranchForm2Net(branchForm, distNet);
			//System.out.println("\nBranch info, #:" + (i+1));
			//System.out.println(formBranch.toString());
		}

		// populate the FaultNet with initial data.
		distNet.createAcscNetData(msg);

		distNet.getFaultNet().setLfDataLoaded(true);
		distNet.getFaultNet().setScDataLoaded(true);
		/* the checkData() need to be called at high level
		if (!distNet.getFaultNet().checkData(msg)) {
			msg.sendErrorMsg("AcscAdjNetwork data ckeck error, \n" + distNet.toString());
			throw new InterpssRuntimeException("AcscAdjNetwork data ckeck error, \n" + distNet.toString());
		}
		*/
		return distNet;
	}	

	/**
	 * Create a empty DistNetwork object based on the formNet object. Only network level attributes are
	 * set at this stage. There is no bus or branch in the net yet.
	 * 
	 * @param formData a DistNetForm object from the EditorJGraph
	 * @return the DistNetwork ojbect
	 */
	private static DistNetwork createDistNet(GNetForm netForm) {
		DistNetwork net = DistObjectFactory.createDistNetwork();
		DistNetData netData = netForm.getDistNetData();

		BaseFormDataMapperImpl.setBaseNetInfo(netForm, net);
		
		// multi-point load data
		// if loadSchedulePoints = 0, no load schedule analysis
		net.getLoadNetData().setSchedulePoints(netData.getLoadSchedulePoints());
		net.getLoadNetData().setSchedulePeriodLength(netData.getLoadSchedulePeriodLength());
		net.getLoadNetData().setSchedulePeriodUnit(netData.getLoadSchedulePeriodUnit());
		
		// multi-point SC data
		net.setScStd(netData.getScStd().equals(DistNetData.ScStd_Generic)?ScStanderd.GENERIC_LITERAL:
						(netData.getScStd().equals(DistNetData.ScStd_ANSI)?ScStanderd.ANSI_LITERAL:ScStanderd.IEC_LITERAL));
		
	    java.util.List plist = netData.getScPointList(); 
		for ( int i = 0; i < plist.size(); i++) {
			ScPointData row = (ScPointData)plist.get(i);
			if (row.getEnable()) {
				ScPointType p = new ScPointType(row.getName(), row.getDescription(), row.getEnable());  
				net.getScPointNetData().getScPointList().add(p);
			}
		}	
		return net;
	}
	
	/**
	 * Create DistBus object basred on the DisBusForm object, containing a DistBusData object and 
	 * add it to the DistNetwork object
	 *  
	 * @param formData a BusForm object containing DistBusData object
	 * @param distNet the DistNetwork object 
	 * @return the DistBus object
	 */
	private static DistBus addBusForm2Net(GBusForm form, DistNetwork distNet) {
		DistBus bus = DistObjectFactory.createDistBus();
		DistBusData busData = form.getDistBusData();

		BaseFormDataMapperImpl.setBaseBusInfo(form, bus, distNet);
		// Utility | Generator | SynMotor | IndMotor | MixedLoad | Non-Contribute
		bus.setBusCode(busData.getBusCode().equals(DistBusData.BusCode_Utility)? DistBusCode.UTILITY_LITERAL :
						(busData.getBusCode().equals(DistBusData.BusCode_Generator)? DistBusCode.GENERATOR_LITERAL :
							(busData.getBusCode().equals(DistBusData.BusCode_SynMotor)? DistBusCode.SYN_MOTOR_LITERAL :
								(busData.getBusCode().equals(DistBusData.BusCode_IndMotor)? DistBusCode.IND_MOTOR_LITERAL :
									(busData.getBusCode().equals(DistBusData.BusCode_MixedLoad)? DistBusCode.MIXED_LOAD_LITERAL :
										DistBusCode.NON_CONTRIBUTE_LITERAL)))));
		bus.setVoltageMag(busData.getVoltage());
		bus.setVMagUnit(busData.getVoltageUnit());
		bus.setVoltageAng(busData.getVAngle());
		bus.setVAngUnit(busData.getVAngleUnit());
		bus.setMvaRating3P(busData.getMvaRating3P());
		bus.setMvaRating1P(busData.getMvaRating1P());
		bus.setMvaRatingUnit(busData.getMvaRatingUnit());
		bus.setX_R3P(busData.getX_r3P());
		bus.setX_R1P(busData.getX_r1P());
		bus.setRatedVoltage(busData.getRatedVolt());
		bus.setRatedVUnit(busData.getRatedVoltUnit());
		bus.setBusRating(busData.getBusRating());
		bus.setBusRatingUnit(busData.getBusRatingUnit());
		bus.setPFactor(busData.getPFactor());
		bus.setPfUnit(busData.getPFactorUnit());
		bus.setEff(busData.getEff());
		bus.setMotorPercent(busData.getMotorPercent());
		bus.setLoading(busData.getLoading());
		for (int i=0; i<busData.getZ1List().size(); i++) {
			ZData zdata = (ZData)busData.getZ1List().get(i);
			bus.getScPointBusData().getZ1List().add(new Complex(zdata.getR(), zdata.getX()));
		}
		bus.setZ1(new Complex(busData.getZ1R(),busData.getZ1X()));
		bus.setZ0(new Complex(busData.getZ0R(),busData.getZ0X()));
		bus.setZ2(new Complex(busData.getZ2R(),busData.getZ2X()));
		bus.setZUnit(busData.getZUnit());
		bus.setGrounding(createScGroundType(busData.getGround(), bus.getBaseVoltage(), distNet.getBaseKva()));

		if (distNet.getLoadNetData().getSchedulePoints() > 0 && busData.isHasLoadSchedule()) {
			for (int i = 0; i < busData.getLoadScheduleList().size(); i++) {
				bus.getLoadBusData().getLoadScheduleList().add(i, busData.getLoadSchedule(i));
				bus.getLoadBusData().getPointVoltageList().add(i, new Complex(1.0,0.0));
			}
		}
		distNet.addBus(bus);
		return bus;
	}

	/**
	 * Create DistBranch object basred on the DisBranchForm object, containing a DistBranchData object and 
	 * add it to the DistNetwork object
	 *  
	 * @param formData a BranchForm object containing DistBranchData object
	 * @param distNet the DistNetwork object 
	 * @return the DistBranch object
	 */
	private static DistBranch addBranchForm2Net(GBranchForm branchForm, DistNetwork distNet) {
		DistBranch branch = DistObjectFactory.createDistBranch();
		DistBranchData branchData = branchForm.getDistBranchData();
		
		BaseFormDataMapperImpl.setBaseBranchInfo(branchForm, branch, distNet);
		
		branch.setBranchCode(branchData.getBranchCode().equals(IGBranchForm.DistBranchCode_Feeder)? DistBranchCode.FEEDER_LITERAL :
								(branchData.getBranchCode().equals(IGBranchForm.DistBranchCode_Breaker)? DistBranchCode.BREAKER_LITERAL :
									(branchData.getBranchCode().equals(IGBranchForm.DistBranchCode_Xfr)? DistBranchCode.TRANSFROMER_LITERAL :
										DistBranchCode.W3_TRANSFORMER_LITERAL)));
		branch.setZ1(new Complex(branchData.getZR(),branchData.getZX()));
		branch.setZ0(new Complex(branchData.getZ0R(),branchData.getZ0X()));
		if (branch.getBranchCode() == DistBranchCode.FEEDER_LITERAL ||
			branch.getBranchCode() == DistBranchCode.BREAKER_LITERAL) {
			branch.setZUnit("Ohm");
		}
		else
			branch.setZUnit(branchData.getZUnit());
		branch.setHShuntB(branchData.getHalfShuntB());
		branch.setHShuntB0(branchData.getHalfShuntB0());
		branch.setShuntBUnit(branchData.getHalfShuntBUnit());
		branch.setLength(branchData.getLength());
		branch.setLengthUnit(branchData.getLengthUnit());
		branch.setPrimaryTap(branchData.getXfrTapFromSideTap());
		branch.setSecondaryTap(branchData.getXfrTapToSideTap());
		branch.setXfrTapUnit(branchData.getXfrTapUnit());
		branch.setXfrRating(branchData.getXfrRating());
		branch.setXfrRatingUnit(branchData.getXfrRatingUnit());
		branch.setPrimaryRatedV(branchData.getFromRatedVolt());
		branch.setSecondaryRatedV(branchData.getToRatedVolt());
		branch.setRatedVUnit(branchData.getRatedVoltUnit());

		branch.setPrimaryConnect(branchData.getFromXfrConnectData().getCode().equals(XfrConnectData.Code_Wye)?
				TransformConnectCode.WYE_LITERAL : TransformConnectCode.DELTA_LITERAL );
		branch.setSecondaryConnect(branchData.getToXfrConnectData().getCode().equals(XfrConnectData.Code_Wye)?
				TransformConnectCode.WYE_LITERAL : TransformConnectCode.DELTA_LITERAL);
		double baseV = 1.0;
		if (!branchData.getFromXfrConnectData().getGrounding().getUnit().toUpperCase().equals("PU")) {
			baseV = distNet.getBus(branchForm.getFromId()).getBaseVoltage();
		}
		branch.setPrimaryGrounding(createScGroundType(branchData.getFromXfrConnectData().getGrounding(),
				baseV, distNet.getFrequency()));
		if (!branchData.getToXfrConnectData().getGrounding().getUnit().toUpperCase().equals("PU")) {
			baseV = distNet.getBus(branchForm.getToId()).getBaseVoltage();
		}
		branch.setSecondaryGrounding(createScGroundType(branchData.getToXfrConnectData().getGrounding(),
				baseV, distNet.getBaseKva()));

		distNet.addBranch(branch, branchForm.getFromId(), branchForm.getToId());
		return branch;
	}
	
	private static ScGroundType createScGroundType(GroundData gform, double baseV, double baseKva) {
		ScGroundType stype = new ScGroundType();
		//	Ungrounded | ZGrounded |SolidGrounded
		stype.setCode(gform.getCode());
		stype.setZ(new Complex(gform.getR(),gform.getX()), UnitType.toUnit(gform.getUnit()), baseV, baseKva);
		return stype;
	}
}