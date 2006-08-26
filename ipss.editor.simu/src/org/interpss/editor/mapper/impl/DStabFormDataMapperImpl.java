package org.interpss.editor.mapper.impl;

import java.util.List;

import org.apache.commons.math.complex.Complex;
import org.interpss.editor.data.dstab.DStabExcData;
import org.interpss.editor.data.dstab.DStabGovData;
import org.interpss.editor.data.dstab.DStabMachData;
import org.interpss.editor.data.dstab.DStabPssData;
import org.interpss.editor.form.GBranchForm;
import org.interpss.editor.form.GBusForm;
import org.interpss.editor.form.GFormContainer;
import org.interpss.editor.form.GNetForm;

import com.interpss.common.datatype.Constants;
import com.interpss.common.datatype.ScGroundType;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.exp.InvalidParameterException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.acsc.AcscBranch;
import com.interpss.core.util.CoreUtilFunc;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.mach.Controller;
import com.interpss.dstab.mach.DynamicMachine;
import com.interpss.dstab.mach.EConstMachine;
import com.interpss.dstab.mach.Eq1Ed1Machine;
import com.interpss.dstab.mach.Eq1Machine;
import com.interpss.dstab.mach.Machine;
import com.interpss.dstab.mach.MachineType;
import com.interpss.dstab.mach.RoundRotorMachine;
import com.interpss.dstab.mach.SalientPoleMachine;
import com.interpss.simu.util.SimuSpringAppCtxUtil;

/**
 * Map functions for BaseNetForm, BaseBusForm, BaseBranchForm to/from Network, Bus, Branch simu objects
 */


public class DStabFormDataMapperImpl {
    /**
     * Map the GNetContainer object to a DStabilityNetwork object
     * 
     * @param editNet the GFormContainer object
     * @param msg the SessionMsg object
     * @return a DStabilityNetwork object
     */
	public static DStabilityNetwork mapEditNet2DStabNet(GFormContainer editNet, IPSSMsgHub msg) {
		DStabilityNetwork dstabNet = DStabObjectFactory.createDStabilityNetwork();

		BaseFormDataMapperImpl.setBaseNetInfo((GNetForm)editNet.getGNetForm(), dstabNet);
		AclfFormDataMapperImpl.setAclfNetInfo(editNet, dstabNet, msg);

		List busList = editNet.getBusFormList();
		for ( int i = 0; i < busList.size(); i++ ) {
			GBusForm busForm = (GBusForm)busList.get(i);
			if (busForm.getDStabBusData().isMachineBus()) {
				setMachineInfo(busForm.getDStabBusData().getMachData(), dstabNet, busForm.getId(), msg);
			}
		}

		List branchList = editNet.getBranchFormList();
		for ( int i = 0; i < branchList.size(); i++ ) {
			// For each AcscBranch xml object, parse for an AcscBranch form object
			GBranchForm branchForm = (GBranchForm)branchList.get(i);
			// TODO: multiple branch situation
			AcscBranch branch = (AcscBranch)dstabNet.getBranch(branchForm.getFromId(), branchForm.getToId());
			AcscFormDataMapperImpl.setBranchInfo(branchForm, branch, dstabNet, msg);
		}
		
		return dstabNet;
	}

	private static void setMachineInfo(DStabMachData machData, DStabilityNetwork dstabNet, String busId, IPSSMsgHub msg) {
		IpssLogger.getLogger().info("Set Machine info, busId: " + busId);
		if (machData.getType().equals(DStabMachData.MachType_InfiniteBus)) {
			Complex z1 = new Complex(0.0, 0.0);
			if (machData.getScMva3P() > 0.0 && machData.getX_R_3P() > 0.0)
				z1 = CoreUtilFunc.calUitilityZ1PU(machData.getScMva3P()*1000, machData.getX_R_3P(), dstabNet.getBaseKva());
			Complex z0 = new Complex(0.0, 0.0);
			if (machData.getScMva1P() > 0 && machData.getX_R_1P() > 0.0 )
				z0 = CoreUtilFunc.calUitilityZ0PU(machData.getScMva1P()*1000, machData.getX_R_1P(), dstabNet.getBaseKva(), z1);
			DStabObjectFactory.createInfiniteMachine(Constants.MachIdToken+busId, machData.getName(), z1, z0, dstabNet, busId);
		}
		else {
			Machine mach = DStabObjectFactory.createMachine(Constants.MachIdToken+busId, machData.getName(), getMachType(machData.getType()), dstabNet, busId);
			mach.setRating(machData.getRating(), "Mva", dstabNet.getBaseKva());
			mach.setRatedVoltage(machData.getRatedVolt());
			mach.setMultiFactors();
			mach.setH(machData.getInertia());
			mach.setD(machData.getDamping());
			mach.setPoles(machData.getPoles());
			mach.setX0(machData.getX0());
			mach.setX2(machData.getX2());
			ScGroundType gtype = new ScGroundType();
			gtype.setCode(machData.getGround().getCode());
			gtype.setZ(new Complex(machData.getGround().getR(),machData.getGround().getX()), 
						UnitType.toUnit(machData.getGround().getUnit()), 
						machData.getRatedVolt(), machData.getRating()*1000.0);
			mach.setGrounding(gtype);
			mach.setGroundZUnit("PU");
			
			if (mach.getType() == MachineType.ECONSTANT_LITERAL) {
				EConstMachine m = (EConstMachine)mach;
				m.setXd1(machData.getXd1());
			}
			else {
				DynamicMachine m = (DynamicMachine)mach;
				m.setRa(machData.getRa());
				m.setXl(machData.getXl());
				m.setXd(machData.getXd());
				m.setXq(machData.getXq());
				m.setSliner(machData.getSliner()); 
				m.setS100(machData.getS100());
				m.setS120(machData.getS120());

				Eq1Machine mEq1 = (Eq1Machine)mach;
				mEq1.setXd1(machData.getXd1());
				mEq1.setTd01(machData.getTd01());

				if (mach.getType() == MachineType.EQ1_ED1_MODEL_LITERAL) {
					Eq1Ed1Machine mEq1Ed1 = (Eq1Ed1Machine)mach;
					mEq1Ed1.setXq1(machData.getXq1());
					mEq1Ed1.setTq01(machData.getTq01());
				}
				else if (mach.getType() == MachineType.EQ11_ED11_SALIENT_POLE_LITERAL || 
						 mach.getType() == MachineType.EQ11_ED11_ROUND_ROTOR_LITERAL) {
					SalientPoleMachine mPole = (SalientPoleMachine)mach;
					mPole.setXd11(machData.getXd11());
					mPole.setXq11(machData.getXq11());
					mPole.setTd011(machData.getTd011());
					mPole.setTq011(machData.getTq011());
					if (mach.getType() == MachineType.EQ11_ED11_ROUND_ROTOR_LITERAL) {
						RoundRotorMachine mRotor = (RoundRotorMachine)mach;
						mRotor.setXq1(machData.getXq1());
						mRotor.setTq01(machData.getTq01());
					}
				}
			}

			if (machData.getHasExc()) {
				setExciterInfo(machData, mach, msg);
			}

			if (machData.getHasGov()) {
				setGovernorInfo(machData.getGovData(), mach, msg);
			}
		}
   		IpssLogger.getLogger().info("Machine info set to: " + machData.toString());
	}

	private static void setExciterInfo(DStabMachData machData, Machine mach, IPSSMsgHub msg) {
   		IpssLogger.getLogger().info("Set Exciter info, machid: " + mach.getId());		
		DStabExcData excData = machData.getExcData();
		Controller controller = SimuSpringAppCtxUtil.getExciter(excData.getTypeName());
   		if (controller != null) {
   			controller.setData(excData.getDataXmlStr(), controller.getDataClass());
   	   		mach.addExciter(controller);
   	   		IpssLogger.getLogger().info("Exciter info set to: " + excData.getDataXmlStr());		
   			if (machData.getHasPss()) {
   				setStabilizerInfo(machData.getPssData(), mach, msg);
   			}
   		}
   		else {
   			IpssLogger.getLogger().warning("Exciter not found, machid: " + mach.getId());
   			msg.sendWarnMsg("Exciter not found, machid: " + mach.getId());
   		}
	}	

	private static void setGovernorInfo(DStabGovData govData, Machine mach, IPSSMsgHub msg) {
   		IpssLogger.getLogger().info("Set Governor info, machid: " + mach.getId());		
		Controller controller = SimuSpringAppCtxUtil.getGovernor(govData.getTypeName());
		if (controller != null) {
	   		controller.setData(govData.getDataXmlStr(), controller.getDataClass());
	   		IpssLogger.getLogger().info("Governor info set to: " + govData.getDataXmlStr());
	   		mach.addGovernor(controller);
		}
   		else {
   			IpssLogger.getLogger().warning("Governor not found, machid: " + mach.getId());
   			msg.sendWarnMsg("Governor not found, machid: " + mach.getId());
   		}
	}	

	private static void setStabilizerInfo(DStabPssData pssData, Machine mach, IPSSMsgHub msg) {
   		IpssLogger.getLogger().info("Set Stabilizer info, machid: " + mach.getId());		
		Controller controller = SimuSpringAppCtxUtil.getStabilizer(pssData.getTypeName());
   		if (controller != null) {
   			controller.setDataXmlString(pssData.getDataXmlStr());
   	   		IpssLogger.getLogger().info("Stabilizer info set to: " + pssData.getDataXmlStr());
   	   		mach.addStabilizer(controller);
   		}
   		else {
   			IpssLogger.getLogger().warning("Stabilizer not found, machid: " + mach.getId());
   			msg.sendWarnMsg("Stabilizer not found, machid: " + mach.getId());
   		}
	}	
	
	private static MachineType getMachType(String mtype) {
		if (mtype.equals(DStabMachData.MachType_EConst))
			return MachineType.ECONSTANT_LITERAL;
		else if (mtype.equals(DStabMachData.MachType_Eq1))
			return MachineType.EQ1_MODEL_LITERAL;
		else if (mtype.equals(DStabMachData.MachType_Eq1Ed1))
			return MachineType.EQ1_ED1_MODEL_LITERAL;
		else if (mtype.equals(DStabMachData.MachType_SalientPole))
			return MachineType.EQ11_ED11_SALIENT_POLE_LITERAL;
		else if (mtype.equals(DStabMachData.MachType_RoundRotor))
			return MachineType.EQ11_ED11_ROUND_ROTOR_LITERAL;
		else {
			IpssLogger.getLogger().severe("Wrong Machine Type String: " + mtype);
			throw new InvalidParameterException("Wrong Machine Type String: " + mtype);
		}
	}
}