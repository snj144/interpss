 /*
  * @(#)AclfFormDataMapperImpl.java   
  *
  * Copyright (C) 2006 www.interpss.org
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
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.mapper.editor;

import org.apache.commons.math.complex.Complex;
import org.interpss.editor.data.aclf.AclfAdjBranchData;
import org.interpss.editor.data.aclf.AclfAdjBusData;
import org.interpss.editor.data.aclf.AclfBranchData;
import org.interpss.editor.data.aclf.AclfBusData;
import org.interpss.editor.form.GBranchForm;
import org.interpss.editor.form.GBusForm;
import org.interpss.editor.form.GFormContainer;
import org.interpss.editor.form.GNetForm;
import org.interpss.editor.jgraph.ui.form.IGBranchForm;
import org.interpss.mapper.editor.BaseFormDataMapperImpl;
import org.interpss.editor.ui.UISpringAppContext;
import org.interpss.editor.ui.util.CoreScriptUtilFunc;
import org.interpss.editor.ui.util.ScriptJavacUtilFunc;

import com.interpss.common.datatype.Constants;
import com.interpss.common.datatype.LimitType;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.exp.InterpssRuntimeException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.MemoryJavaCompiler;
import com.interpss.common.util.NetUtilFunc;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBranchCode;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfGenCode;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclf.BaseAclfBranch;
import com.interpss.core.aclf.BaseAclfBus;
import com.interpss.core.aclf.CapacitorBusAdapter;
import com.interpss.core.aclf.LineAdapter;
import com.interpss.core.aclf.LoadBusAdapter;
import com.interpss.core.aclf.PQBusAdapter;
import com.interpss.core.aclf.PSXfrAdapter;
import com.interpss.core.aclf.PVBusAdapter;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.aclf.XfrAdapter;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.aclfadj.FlowControlType;
import com.interpss.core.aclfadj.FunctionLoad;
import com.interpss.core.aclfadj.PQBusLimit;
import com.interpss.core.aclfadj.PSXfrPControl;
import com.interpss.core.aclfadj.PVBusLimit;
import com.interpss.core.aclfadj.RemoteQBus;
import com.interpss.core.aclfadj.RemoteQControlType;
import com.interpss.core.aclfadj.TapControl;
import com.interpss.core.acsc.AcscNetwork;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;

/**
 * Map functions for BaseNetForm, BaseBusForm, BaseBranchForm to/from Network, Bus, Branch simu objects
 */


public class AclfFormDataMapperImpl {
    /**
     * Map the GFormContainer object to a AclfNetwork object
     * 
     * @param editNet the GFormContainer object
     * @param msg a SessionMsg object
     * @return an AclfAdjNetwork object
     */
	public static AclfAdjNetwork mapEditNet2AclfNet(GFormContainer editNet, IPSSMsgHub msg) {
		AclfAdjNetwork aclfNet = CoreObjectFactory.createAclfAdjNetwork();

		BaseFormDataMapperImpl.setBaseNetInfo((GNetForm)editNet.getGNetForm(), aclfNet);
		// no extra aclf net info needed to map

		setAclfNetInfo(editNet, aclfNet, msg);
		//System.out.println(aclfNet.net2String());
		return aclfNet;
	}
	
    /**
     * Set AclfNet Bus and Branch info into the aclfNet Object
     * 
     * @param editNet the GFormContainer object
     * @param aclfNet the AclfNetwork object
     * @param msg a SessionMsg object
     */
	public static void setAclfNetInfo(GFormContainer editNet, AclfAdjNetwork aclfNet, IPSSMsgHub msg) {
		IpssLogger.getLogger().info("AclfFormDataMapperImpl.setBaseNetInfo() called");

		// first put AclfBus and AclfBranch info into Net
		for ( Object obj : editNet.getBusFormList() ) {
			// For each AcscBus xml object, parse for an AcscBus form object
			GBusForm busForm = (GBusForm)obj;
			setAddBusForm2Net(busForm, aclfNet);
			//System.out.println("\nBus info, #:" + (i+1));
			//System.out.println(busForm.toString());
		}

		for ( Object obj : editNet.getBranchFormList()) {
			// For each AcscBranch xml object, parse for an AcscBranch form object
			GBranchForm branchForm = (GBranchForm)obj;
			setAddBranchForm2Net(branchForm, aclfNet, msg);
			//System.out.println("\nBranch info, #:" + (i+1));
			//System.out.println(branchForm.toString());
		}

		// Then put AclfAdjBus and AclfAdjBranch info into Net
		if (((GNetForm)editNet.getGNetForm()).getAcscNetData().isHasAdjustment()) {
			for ( Object obj : editNet.getBusFormList() ) {
				// For each AcscBus xml object, parse for an AcscBus form object
				GBusForm busForm = (GBusForm)obj;
				addAclfAdjBusFormInfo(busForm, aclfNet);
				//System.out.println("\nBus info, #:" + (i+1));
				//System.out.println(busForm.toString());
			}

			for ( Object obj : editNet.getBranchFormList() ) {
				// For each AcscBranch xml object, parse for an AcscBranch form object
				GBranchForm branchForm = (GBranchForm)obj;
				addAclfAdjBranchFormInfo(branchForm, aclfNet, msg);
				//System.out.println("\nBranch info, #:" + (i+1));
				//System.out.println(branchForm.toString());
			}		
		}

		aclfNet.setLfDataLoaded(true);
		/*
		if (!aclfNet.checkData(msg)) {
			msg.sendErrorMsg("AclfAdjNetwork data ckeck error, \n" + aclfNet.toString());
			throw new InterpssRuntimeException("AclfAdjNetwork data ckeck error, \n" + aclfNet.toString());
		}
		*/
	}

	/**
	 * Create and set the aclf bus info, then add the bus object to the AclfNet
	 *  
	 * @param form a GBusForm object
	 * @param net the aclf net object, it may be an AcscNetwork object
	 * @return the status 
	 */
	public static boolean setAddBusForm2Net(GBusForm form, AclfAdjNetwork net) {
		AclfBus bus = null;
		if (net instanceof DStabilityNetwork)
			bus = DStabObjectFactory.createDStabBus(form.getId(), (DStabilityNetwork)net);
		else {
			if (net instanceof AcscNetwork) {
				bus = CoreObjectFactory.createAcscBus(form.getId());
			}	
			else {
				bus = CoreObjectFactory.createAclfBus(form.getId());
			}	
			net.addBus(bus);
		}

		BaseFormDataMapperImpl.setBaseBusInfo(form, bus, net);
		return setAclfBusFormInfo(form, bus, net);
	}

	/**
	 * Create and set the aclf branch info, then add the branch object to the AclfNet
	 * 
	 * @param form a GBranchForm object
	 * @param aclfNet the aclf net object, it may be an AcscNetwork object
	 * @return the Branch object of type AclfBranch or AcscBranch
	 */
	public static AclfBranch setAddBranchForm2Net(GBranchForm form, AclfAdjNetwork net, IPSSMsgHub msg)  {
		AclfBranch branch = null;
		if (net instanceof DStabilityNetwork)
			branch = DStabObjectFactory.createDStabBranch(form.getFromId(), form.getToId(), (DStabilityNetwork)net);
		else {
			if (net instanceof AcscNetwork) {
				branch = CoreObjectFactory.createAcscBranch();
			}	
			else { 
				branch = CoreObjectFactory.createAclfBranch();
			}
		  	net.addBranch(branch, form.getFromId(), form.getToId());
		}

		BaseFormDataMapperImpl.setBaseBranchInfo(form, branch, net);
		setAclfBranchFormInfo(form, branch, net, true, msg);
		
		return branch;
	}
	
	/**
	 * Set the AclfBusData info to the AclfBus object
	 * 
	 * @param formBus the GBusForm object, containing AclfBusData info 
	 * @param bus the Aclf bus 
	 * @param aclfNet an Network object containing the bus object.
	 * @return the status
	 */
	public static boolean setAclfBusFormInfo(GBusForm formBus, AclfBus bus, AclfAdjNetwork aclfNet) {
		AclfBusData busData = formBus.getAcscBusData();
		if (busData.getGenCode().equals(AclfBusData.GenCode_PQ)) {   
			bus.setGenCode(AclfGenCode.GEN_PQ);
			PQBusAdapter pqBus = (PQBusAdapter)bus.adapt(PQBusAdapter.class);
		  	pqBus.setGen(new Complex(busData.getGenP(), busData.getGenQ()), 
		  			UnitType.toUnit(busData.getGenUnit()), aclfNet.getBaseKva() );
		}
		else if (busData.getGenCode().equals(AclfBusData.GenCode_PV)) {   
		  	bus.setGenCode(AclfGenCode.GEN_PV);
			PVBusAdapter pvBus = (PVBusAdapter)bus.adapt(PVBusAdapter.class);
		  	pvBus.setGenP(busData.getGenP(), UnitType.toUnit(busData.getGenUnit()), aclfNet.getBaseKva());
	    	// VoltgeMsg is used to hold PV-VSpec, ReQVolt-VSpec and ReQMvarFlow-MvarSpec
		  	pvBus.setVoltMag(busData.getVoltageMag(),	UnitType.toUnit(busData.getVoltageMagUnit()) );
		}
		else if (busData.getGenCode().equals(AclfBusData.GenCode_Swing)) {  
			bus.setGenCode(AclfGenCode.SWING);
			SwingBusAdapter swing = (SwingBusAdapter)bus.adapt(SwingBusAdapter.class);
		  	swing.setVoltMag( busData.getVoltageMag(), UnitType.toUnit(busData.getVoltageMagUnit()) );
		  	swing.setVoltAng( busData.getVoltageAng(), UnitType.toUnit(busData.getVoltageAngUnit()) );
		}
		else if (busData.getGenCode().equals(AclfBusData.GenCode_Capacitor)) {   // capacitor bus
			bus.setGenCode(AclfGenCode.CAPACITOR);
			CapacitorBusAdapter cBus = (CapacitorBusAdapter)bus.adapt(CapacitorBusAdapter.class);
			cBus.setQ(busData.getCapQ(), UnitType.toUnit(busData.getCapQUnit()), aclfNet.getBaseKva());
		}
		else if (busData.getGenCode().equals(AclfBusData.GenCode_GenScripting)) {   
			bus.setGenCode(AclfGenCode.GEN_SCRIPTING);
			//bus.setScripts(busData.getScripts());
		}
		else {   
			bus.setGenCode(AclfGenCode.NON_GEN);
		}
		
		bus.setLoadCode(parseLoadCode(busData.getLoadCode()));
		if (busData.getLoadCode().equals(AclfBusData.LoadCode_LoadScripting)) {
			//bus.setScripts(busData.getScripts());
		}
		else {
			LoadBusAdapter loadBus = (LoadBusAdapter)bus.adapt(LoadBusAdapter.class);
			if (!busData.getLoadCode().equals(AclfBusData.LoadCode_NonLoad))
				loadBus.setLoad(new Complex(busData.getLoadP(),busData.getLoadQ()), 
					UnitType.toUnit(busData.getLoadUnit()), aclfNet.getBaseKva());
		}
		
		Complex ypu = UnitType.yConversion(new Complex(busData.getShuntG(),busData.getShuntB()), bus.getBaseVoltage(), 
						aclfNet.getBaseKva(), UnitType.toUnit(busData.getShuntYUnit()), UnitType.PU);
		bus.setShuntY(ypu);
		
		if (busData.getGenCode().equals(AclfBusData.GenCode_GenScripting) ||
			busData.getLoadCode().equals(AclfBusData.LoadCode_LoadScripting)) {
			if (busData.getScriptLanguage() == AclfBusData.ScriptLanguage_Java) {
				// compile the source code
				String classname = "";
				String javacode = busData.getScripts(); 
				if (javacode.startsWith(ScriptJavacUtilFunc.Token_CodeReuse)) {    // format @busId
					classname = ScriptJavacUtilFunc.createScriptingClassname(javacode.substring(1));
				}
				else {
					classname = ScriptJavacUtilFunc.createScriptingClassname(bus.getId());
					javacode = CoreScriptUtilFunc.parseAclfJavaCode(busData.getScripts(), classname, 
									CoreScriptUtilFunc.Tag_AclfScriptBus_Baseclass, 
									CoreScriptUtilFunc.Tag_AclfScriptBus_Begin);
				}
				try {
					bus.setExternalAclfBus((BaseAclfBus)MemoryJavaCompiler.javac( 
							CoreScriptUtilFunc.AclfScriptingPackageName+"/"+classname, javacode));
				} catch (Exception e) {
					IpssLogger.logErr(e);
					return false;
				}
			}
			else {
				Object plugin = UISpringAppContext.getCustomAclfBusScriptPlugin(busData.getScriptPluginName());
				bus.setExternalAclfBus((BaseAclfBus)plugin); 
			}
		}
 		return true;
	}

	/**
	 * Set the AclfAdjBusData info to the AclfBus object
	 * 
	 * @param formBus the GBusForm object, containing AclfBusData info 
	 * @param aclfNet an Network object containing the bus object.
	 * @return the status
	 */
	private static boolean addAclfAdjBusFormInfo(GBusForm formBus, AclfAdjNetwork aclfNet) {
		AclfBus bus = aclfNet.getAclfBus(formBus.getId()); 
		AclfBusData busData = formBus.getAcscBusData();
		if (busData.getGenCode().equals(AclfBusData.GenCode_PQ)) {   
			AclfAdjBusData adjData = formBus.getAcscBusData();
			if (adjData.isHasRemoteVControl()) {
				if (adjData.getReQControlType() == AclfAdjBusData.ReQControlType_Voltage) {
					String remoteBusId = NetUtilFunc.getBusIdFromDisplayNameId(adjData.getRemoteControlBusId());
					RemoteQBus reQ = CoreObjectFactory.createRemoteQBus(aclfNet, bus.getId(), 
										RemoteQControlType.BUS_VOLTAGE, remoteBusId);
					reQ.setQLimit(new LimitType(adjData.getMaxGenQ(), adjData.getMinGenQ()));
					// VoltgeMsg is used to hold PV-VSpec, ReQVolt-VSpec and ReQMvarFlow-MvarSpec
					reQ.setVSpecified(adjData.getVoltageMag());		 
				}
				else if (adjData.getReQControlType() == AclfAdjBusData.ReQControlType_MvarFlow) {
					String remoteBranchId = NetUtilFunc.getBranchIdFromDisplayNameId(adjData.getRemoteControlBranchId());
					RemoteQBus reQ = CoreObjectFactory.createRemoteQBus(aclfNet, bus.getId(), 
										RemoteQControlType.BRANCH_Q, remoteBranchId);
					reQ.setQLimit(new LimitType(adjData.getMaxGenQ(), adjData.getMinGenQ()));
					// VoltgeMsg is used to hold PV-VSpec, ReQVolt-VSpec and ReQMvarFlow-MvarSpec
					reQ.setMvarSpecified(adjData.getVoltageMag(), UnitType.PU, aclfNet.getBaseKva());		
					reQ.setFlowFrom2To(adjData.isFlowFrom2To());
					reQ.setMvarOnFromSide(adjData.isMvarControlOnFromSide());
				}
			}
			else if (adjData.isHasLimitControl()) {
				double max = adjData.getMaxVoltMag();
				double min = adjData.getMinVoltMag();
			  	PQBusLimit pqLimit = CoreObjectFactory.createPQBusLimit(aclfNet, bus.getId());
				pqLimit.setVLimit(new LimitType(max, min), UnitType.PU);	
			}
		}
		else if (busData.getGenCode().equals(AclfBusData.GenCode_PV)) {   
			AclfAdjBusData adjData = formBus.getAcscBusData();
			if (adjData.isHasLimitControl()) {
				double max = adjData.getMaxGenQ();
				double min = adjData.getMinGenQ();
			  	PVBusLimit pvLimit = CoreObjectFactory.createPVBusLimit(aclfNet, bus.getId());
				pvLimit.setQLimit(new LimitType(max, min), UnitType.PU, aclfNet.getBaseKva());				
			}
		}
		
		if (busData.getLoadCode().equals(AclfBusData.LoadCode_FuncLoad)) {
			AclfAdjBusData adjData = formBus.getAcscBusData();
		  	FunctionLoad fload = CoreObjectFactory.createFunctionLoad(aclfNet, bus.getId());
	  		fload.getP().setA(adjData.getLoadP_PPct(), UnitType.Percent);
	  		fload.getP().setB(adjData.getLoadP_IPct(), UnitType.Percent);
	  		fload.getQ().setA(adjData.getLoadQ_PPct(), UnitType.Percent);
	  		fload.getQ().setB(adjData.getLoadQ_IPct(), UnitType.Percent);	  				
	  	}
		return true;
	}

	private static AclfLoadCode parseLoadCode(String code) {
		return code.equals(AclfBusData.LoadCode_ConstP) || code.equals(AclfBusData.LoadCode_FuncLoad) ? AclfLoadCode.CONST_P : 
				(code.equals(AclfBusData.LoadCode_ConstI)? AclfLoadCode.CONST_I : 
					(code.equals(AclfBusData.LoadCode_ConstZ)? AclfLoadCode.CONST_Z : 
						(code.equals(AclfBusData.LoadCode_LoadScripting)? AclfLoadCode.LOAD_SCRIPTING : 
							AclfLoadCode.NON_LOAD)));
	}
	
	/**
	 * Set the AclfBranchData info to the AclfBranch object
	 * 
	 * @param formBranch a GBranchForm object containing the AclfBranchData object.
	 * @param branch the AclfBranch object
	 * @param aclfNet a Network object containing the branch object
	 * @return the status
	 */
	public static boolean setAclfBranchFormInfo(GBranchForm formBranch, AclfBranch branch, 
							AclfAdjNetwork aclfNet, boolean aclf, IPSSMsgHub msg) {
		AclfBranchData data = formBranch.getAcscBranchData();
		if (data.getLfCode().equals(IGBranchForm.TransBranchLfCode_Line)) {   // line branch
			return setLineBranchFormInfo(formBranch, branch, aclfNet, msg);
		}
		else if (data.getLfCode().equals(IGBranchForm.TransBranchLfCode_Xfr)) {   // xfr branch
			setXfrBranchFormInfo(formBranch, branch, aclfNet, msg);
			return true;
		}
		else if (data.getLfCode().equals(IGBranchForm.TransBranchLfCode_PsXfr)) {   // psxfr branch
			setPSXfrBranchFormInfo(formBranch, branch, aclfNet, msg);
			return true;
		}
		else if (data.getLfCode().equals(IGBranchForm.TransBranchCode_Scripting) && aclf) { 
			branch.setBranchCode(AclfBranchCode.BRANCH_SCRIPTING);
			//branch.setScripts(data.getScripts());
			String classname = ScriptJavacUtilFunc.createScriptingClassname(branch.getId());
			String javacode = CoreScriptUtilFunc.parseAclfJavaCode(data.getScripts(), classname, 
								CoreScriptUtilFunc.Tag_AclfScriptBranch_Baseclass, 
								CoreScriptUtilFunc.Tag_AclfScriptBranch_Begin);
			try {
				branch.setExternalAclfBranch((BaseAclfBranch)MemoryJavaCompiler.javac( 
					CoreScriptUtilFunc.AclfScriptingPackageName+"/"+classname, javacode));
			} catch (Exception e) {
				IpssLogger.logErr(e);
				return false;
			}			
			return true;
		}
		return false;
	}

	private static boolean addAclfAdjBranchFormInfo(GBranchForm formBranch, 
			AclfAdjNetwork aclfNet, IPSSMsgHub msg) {
		AclfBranch branch = (AclfBranch)aclfNet.getBranch(formBranch.getFromId(), formBranch.getToId());
		AclfBranchData data = formBranch.getAcscBranchData();
		if (data.getLfCode().equals(IGBranchForm.TransBranchLfCode_Xfr)) {   // xfr branch
			setXfrAdjBranchFormInfo(formBranch, branch, aclfNet, msg);
			return true;
		}
		else if (data.getLfCode().equals(IGBranchForm.TransBranchLfCode_PsXfr)) {   // psxfr branch
			setPSXfrAdjBranchFormInfo(formBranch, branch, aclfNet, msg);
			return true;
		}
		return true;
	}
	
	private static boolean setLineBranchFormInfo(GBranchForm branchForm, AclfBranch branch, 
						AclfNetwork net, IPSSMsgHub msg) {
		try {
			AclfBranchData data = branchForm.getAcscBranchData();
			branch.setBranchCode(AclfBranchCode.LINE);
			LineAdapter line = (LineAdapter)branch.adapt(LineAdapter.class);
			line.setZ(new Complex(data.getZR(), data.getZX()), UnitType.toUnit(data.getZUnit()), 
						branch.getFromAclfBus().getBaseVoltage(), net.getBaseKva(), msg);
			line.setHShuntY(new Complex(0.0, data.getHalfShuntB()), UnitType.toUnit(data.getHalfShuntBUnit()), 
						branch.getFromAclfBus().getBaseVoltage(), net.getBaseKva());
			line.setMvaRating1(data.getRating1());
			line.setMvaRating2(data.getRating2());
			line.setMvaRating3(data.getRating3());
			return true;
		} catch (Exception e) {
      		IpssLogger.logErr(e);
      		throw new InterpssRuntimeException(e.toString());
		}
	}
	
	private static boolean setXfrBranchFormInfo(GBranchForm branchForm, AclfBranch branch, 
						AclfAdjNetwork net, IPSSMsgHub msg) {
		try {
			AclfBranchData data = branchForm.getAcscBranchData();
			branch.setBranchCode(AclfBranchCode.XFORMER);
		    double fromBaseV = branch.getFromAclfBus().getBaseVoltage(),
		  	       toBaseV = branch.getToAclfBus().getBaseVoltage();
	        // the follow only applies if zUnit is in Ohms, which is very unlikely
			double baseV = fromBaseV > toBaseV ? fromBaseV : toBaseV;
			XfrAdapter  xfr = (XfrAdapter)branch.adapt(XfrAdapter.class);
			xfr.setZ(new Complex(data.getZR(), data.getZX()), UnitType.toUnit(data.getZUnit()), 
						baseV, net.getBaseKva(), msg);

			xfr.setFromTurnRatio(data.getXfrTapFromSideTap(), UnitType.toUnit(data.getXfrTapUnit()));
			xfr.setToTurnRatio(data.getXfrTapToSideTap(), UnitType.toUnit(data.getXfrTapUnit()));
			xfr.setMvaRating1(data.getRating1());
			xfr.setMvaRating2(data.getRating2());
			xfr.setMvaRating3(data.getRating3());
			return true;
		} catch (Exception e) {
      		IpssLogger.logErr(e);
      		throw new InterpssRuntimeException(e.toString());
		}
	}

	private static boolean setXfrAdjBranchFormInfo(GBranchForm branchForm, AclfBranch branch, 
			AclfAdjNetwork net, IPSSMsgHub msg) {
		AclfAdjBranchData adjData = branchForm.getAcscBranchData();
		if (adjData.isHasTapVControl()) {
	  		TapControl tapv = null;
			if (adjData.getTapVControlType() == AclfAdjBranchData.TapControlType_Voltage) {
				String vcBusId = NetUtilFunc.getBusIdFromDisplayNameId(adjData.getVcBusId());
		  		tapv = CoreObjectFactory.createTapVControlBusVoltage(net, branch.getId(), vcBusId, FlowControlType.POINT_CONTROL);
		  		tapv.setVSpecified(adjData.getVcVSpec());
		  		tapv.setVcBusOnFromSide(adjData.isVCBusOnFromSide());
			}
			else {
		  		tapv = CoreObjectFactory.createTapVControlMvarFlow(net, branch.getId(), FlowControlType.POINT_CONTROL);
		  		tapv.setMvarSpecified(adjData.getMvarFlowSpec());
		  		tapv.setMeteredOnFromSide(adjData.isMvarSpecOnFromSide());
		  		tapv.setFlowFrom2To(adjData.isFlowFrom2To());
			}
	  		tapv.setTapLimit(new LimitType(adjData.getVcTapMax(), adjData.getVcTapMin()));
	  		double stepSize = 0.0;
	  		if (adjData.getVcStep() > 0) {
	  			stepSize = ( adjData.getVcTapMax() - adjData.getVcTapMin() ) / adjData.getVcStep();
	  		}
	  		tapv.setTapStepSize(stepSize);
	  		tapv.setTapOnFromSide(adjData.isVCTapOnFromSide());		
	  	}
		return true;
	}

	private static boolean setPSXfrBranchFormInfo(GBranchForm formBranch, AclfBranch branch, 
						AclfAdjNetwork net, IPSSMsgHub msg) {
		setXfrBranchFormInfo(formBranch, branch, net, msg);
		AclfBranchData data = formBranch.getAcscBranchData();
		branch.setBranchCode(AclfBranchCode.PS_XFORMER);
		PSXfrAdapter psXfr = (PSXfrAdapter)branch.adapt(PSXfrAdapter.class);
		psXfr.setFromAngle(data.getPhaseShiftAngle(), UnitType.toUnit(data.getPhaseShiftAngleUnit()));
		return true;
	}

	private static boolean setPSXfrAdjBranchFormInfo(GBranchForm formBranch, AclfBranch branch, 
			AclfAdjNetwork net, IPSSMsgHub msg) {
		AclfAdjBranchData adjData = formBranch.getAcscBranchData();
		if (adjData.isHasPSXfrPControl()) {
			PSXfrPControl psXfrControl = CoreObjectFactory.createPSXfrPControl(net, branch.getId(), FlowControlType.POINT_CONTROL);
			psXfrControl.setPSpecified(adjData.getPcPSpec());
			psXfrControl.setAngLimit(new LimitType(adjData.getPcAngMax()*Constants.DtoR, adjData.getPcAngMin()*Constants.DtoR));
			psXfrControl.setControlOnFromSide(adjData.isPcOnFromSide());			
			psXfrControl.setFlowFrom2To(adjData.isFlowFrom2To());			
		}
		return true;
	}
	
}