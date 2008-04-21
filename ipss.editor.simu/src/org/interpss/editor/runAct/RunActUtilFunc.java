/*
 * @(#)RunActUtilFunc.java   
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

package org.interpss.editor.runAct;

import java.util.ArrayList;
import java.util.List;

import org.interpss.display.AcscOutFunc;
import org.interpss.editor.data.proj.ProjData;
import org.interpss.editor.jgraph.GraphSpringAppContext;
import org.interpss.editor.jgraph.ui.app.IAppSimuContext;
import org.interpss.editor.ui.IOutputTextDialog;
import org.interpss.editor.ui.UISpringAppContext;
import org.interpss.gridgain.util.IpssGridGainUtil;
import org.interpss.schema.RunStudyCaseXmlType;

import com.interpss.common.SpringAppContext;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.aclfadj.FunctionLoad;
import com.interpss.core.aclfadj.PQBusLimit;
import com.interpss.core.aclfadj.PSXfrPControl;
import com.interpss.core.aclfadj.PVBusLimit;
import com.interpss.core.aclfadj.RemoteQBus;
import com.interpss.core.aclfadj.RemoteQControlType;
import com.interpss.core.aclfadj.TapControl;
import com.interpss.core.acsc.SimpleFaultNetwork;
import com.interpss.core.net.Area;
import com.interpss.core.net.IRegulationDevice;
import com.interpss.dstab.DynamicSimuAlgorithm;
import com.interpss.dstab.util.IDStabSimuDatabaseOutputHandler;

public class RunActUtilFunc {
	public static String AllControlDevices = "All Control Devices";

	public static Object[] getFunctionLoadList(AclfAdjNetwork adjNet,
			double tolerance, IPSSMsgHub msg) {
		List<String> list = new ArrayList<String>();
		list.add(AllControlDevices);
		for (int i = 0; i < adjNet.getFunctionLoadList().size(); i++) {
			FunctionLoad load = (FunctionLoad) adjNet.getFunctionLoadList()
					.get(i);
			if (load.needAdjust(tolerance, adjNet.getBaseKva(), msg))
				list.add(load.getId() + " at " + load.getBus().getName());
		}
		return list.toArray();
	}

	public static Object[] getPVBusLimitList(AclfAdjNetwork adjNet,
			IPSSMsgHub msg) {
		List<String> list = new ArrayList<String>();
		list.add(AllControlDevices);
		for (int i = 0; i < adjNet.getPvBusLimitList().size(); i++) {
			PVBusLimit pvLimit = (PVBusLimit) adjNet.getPvBusLimitList().get(i);
			if (pvLimit.needAdjust(0.0, adjNet.getBaseKva(), msg))
				list.add(pvLimit.getId() + " at " + pvLimit.getBus().getName()
						+ "(" + (pvLimit.isActive() ? "on" : "off") + ")");
		}
		return list.toArray();
	}

	public static Object[] getPQBusLimitList(AclfAdjNetwork adjNet,
			IPSSMsgHub msg) {
		List<String> list = new ArrayList<String>();
		list.add(AllControlDevices);
		for (int i = 0; i < adjNet.getPqBusLimitList().size(); i++) {
			PQBusLimit pqLimit = (PQBusLimit) adjNet.getPqBusLimitList().get(i);
			if (pqLimit.needAdjust(0.0, adjNet.getBaseKva(), msg))
				list.add(pqLimit.getId() + " at " + pqLimit.getBus().getName()
						+ "(" + (pqLimit.isActive() ? "on" : "off") + ")");
		}
		return list.toArray();
	}

	public static Object[] getRemoteQBusList(AclfAdjNetwork adjNet,
			double tolerance, IPSSMsgHub msg) {
		List<String> list = new ArrayList<String>();
		list.add(AllControlDevices);
		for (int i = 0; i < adjNet.getRemoteQBusList().size(); i++) {
			RemoteQBus reQ = (RemoteQBus) adjNet.getRemoteQBusList().get(i);
			if (reQ.needAdjust(tolerance, adjNet.getBaseKva(), msg)) {
				if (reQ.getControlType() == RemoteQControlType.BUS_VOLTAGE)
					list.add(reQ.getId() + " at " + reQ.getBus().getName()
							+ "-> Bus:" + reQ.getRemoteBus().getId());
				else
					list.add(reQ.getId() + " at " + reQ.getBus().getName()
							+ "-> Branch:" + reQ.getRemoteBranch().getId());
			}
		}
		return list.toArray();
	}

	public static Object[] getXfrTapControlList(AclfAdjNetwork adjNet,
			double tolerance, IPSSMsgHub msg) {
		List<String> list = new ArrayList<String>();
		list.add(AllControlDevices);
		for (int i = 0; i < adjNet.getTapControlList().size(); i++) {
			TapControl xfr = (TapControl) adjNet.getTapControlList().get(i);
			if (xfr.needAdjust(tolerance, adjNet.getBaseKva(), msg)) {
				list.add(xfr.getId() + " at " + xfr.getAclfBranch().getName());
			}
		}
		return list.toArray();
	}

	public static Object[] getPSXfrPControlList(AclfAdjNetwork adjNet,
			double tolerance, IPSSMsgHub msg) {
		List<String> list = new ArrayList<String>();
		list.add(AllControlDevices);
		for (int i = 0; i < adjNet.getPsXfrPControlList().size(); i++) {
			PSXfrPControl psXfr = (PSXfrPControl) adjNet.getPsXfrPControlList()
					.get(i);
			if (psXfr.needAdjust(tolerance, adjNet.getBaseKva(), msg)) {
				list.add(psXfr.getId() + " at "
						+ psXfr.getAclfBranch().getName());
			}
		}
		return list.toArray();
	}

	public static Object[] getInterareaPControlList(AclfAdjNetwork adjNet,
			IPSSMsgHub msg) {
		List<String> list = new ArrayList<String>();
		list.add(AllControlDevices);
		for (Object obj : adjNet.getAreaList()) {
			Area a = (Area) obj;
			if (a.getRegDeviceList().size() > 0) {
				IRegulationDevice regDevice = (IRegulationDevice) a
						.getRegDeviceList().get(0);
				if (regDevice.needAdjustment(a, adjNet, msg))
					list.add(a.getNumber() + " name: " + a.getName());
			}
		}
		return list.toArray();
	}

	/**
	 * display fault analysis summary
	 * 
	 * @parem faultNet
	 */
	public static void displayAcscSummaryResult(SimpleFaultNetwork faultNet) {
		IOutputTextDialog dialog = UISpringAppContext
				.getOutputTextDialog("Short Circuit Analysis Result Summary");
		dialog.display(AcscOutFunc.faultResult2String(faultNet));
	}

	/**
	 * Display Aclf summary if selected by the user
	 * 
	 * @param algo
	 */
	public static void displayAclfSummaryResult(DynamicSimuAlgorithm algo) {
		IOutputTextDialog dialog = UISpringAppContext
				.getOutputTextDialog("Loadflow Analysis Info");
		dialog.display(algo);
	}

	/**
	 * Create a DB output handler object for UI based DStab run.
	 * 
	 * @param algo
	 * @return
	 */
	public static IDStabSimuDatabaseOutputHandler createDBOutputHandler(
			DynamicSimuAlgorithm algo) throws Exception {
		return createDBOutputHandler(algo, null);
	}

	/**
	 * Create a DB output handler object. If dstabXmlCase != null, it RecId will
	 * be appended to the db case name.
	 * 
	 * @param algo
	 * @param dstabXmlCase
	 * @return
	 */
	public static IDStabSimuDatabaseOutputHandler createDBOutputHandler(
			DynamicSimuAlgorithm algo, RunStudyCaseXmlType.RunDStabStudyCase.DStabStudyCaseList.DStabStudyCaseRec dstabRec) 
				throws Exception {
		IDStabSimuDatabaseOutputHandler handler = (IDStabSimuDatabaseOutputHandler) algo
				.getSimuOutputHandler();
		IAppSimuContext appSimuCtx = GraphSpringAppContext
				.getIpssGraphicEditor().getCurrentAppSimuContext();
		ProjData projData = (ProjData) appSimuCtx.getProjData();
		try {
			// to avoid conflict with StudyCase name, we add " SimuRecord" to
			// the SimuRecord case.
			String casename = "SimuRecord_";
			if (dstabRec != null)
				casename += dstabRec.getRecId();
			else
				casename += projData.getDStabCaseName();
			if (!handler.init(projData.getProjectDbId(), casename))
				return null;
		} catch (Exception e) {
			IpssLogger.logErr(e);
			SpringAppContext.getEditorDialogUtil().showErrMsgDialog(
					"Error to Create DB SimuRecord",
					e.toString() + "\nPlease contact InterPSS support");
		}
		appSimuCtx.setDbSimuCaseId(handler.getDBCaseId());
		return handler;
	}

	/**
	 * Check DStab algo and DStab net data
	 * 
	 * @param algo
	 * @param msg
	 * @return
	 */
	public static boolean checkDStabSimuData(DynamicSimuAlgorithm algo,
			IPSSMsgHub msg) {
		if (!algo.checkData(msg)) {
			IpssLogger.getLogger().warning(
					"DStab simulation data checking failed");
			return false;
		}

		// dstab net data changed in the mapping process
		if (!algo.getDStabNet().checkData(msg)) {
			IpssLogger.getLogger()
					.warning("DStab network data checking failed");
			return false;
		}
		return true;
	}

	/**
	 * check if grid computing is enabled for the study case
	 * 
	 * @param xmlStudyCase study case object
	 * @return
	 */
	public static boolean isGridEnabled(RunStudyCaseXmlType xmlStudyCase) {
		return 	IpssGridGainUtil.isGridEnabled()
				&& xmlStudyCase.getGridRun() != null
				&& xmlStudyCase.getGridRun().getEnableGridRun();
	}	
}
