/*
 * @(#)XmlScriptDclfRun.java   
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
 * @Date 01/15/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.editor.runAct.xml;

import org.interpss.display.DclfOutFunc;
import org.interpss.editor.ui.IOutputTextDialog;
import org.interpss.editor.ui.UISpringAppContext;
import org.interpss.schema.DclfBranchSensitivityXmlType;
import org.interpss.schema.DclfBusSensitivityXmlType;
import org.interpss.schema.DclfSensitivityXmlType;
import org.interpss.schema.RunStudyCaseXmlType;
import org.interpss.xml.IpssXmlParser;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.dclf.DclfAlgorithm;
import com.interpss.core.dclf.DclfSensitivityType;

public class XmlScriptDclfRun {
	/**
	 * Run Dclf run or run(s) defined in the Xml scripts
	 * 
	 * @param parser
	 *            The InterPSS xml parser object
	 * @param aclfNet
	 * @param msg
	 * @return
	 */
	public static boolean runDclf(IpssXmlParser parser, AclfNetwork aclfNet,
			IPSSMsgHub msg) {
		if (parser.getRunDclfStudyCaseList().length > 0) {
			if (parser.getRunDclfStudyCaseList().length == 1) {
				RunStudyCaseXmlType.DclfStudyCaseList.DclfStudyCase dclfCase = parser
						.getRunDclfStudyCaseList()[0];

				DclfAlgorithm algo = CoreObjectFactory
						.createDclfAlgorithm(aclfNet);
				if (!algo.checkCondition(msg))
					return false;

				IOutputTextDialog dialog = UISpringAppContext
						.getOutputTextDialog("DC Loadflow Analysis Info");

				if (dclfCase.getCaculatelDclf()) {
					algo.calculateDclf(msg);
					dialog.appendText(DclfOutFunc.dclfResults(algo));
				}

				for (DclfBusSensitivityXmlType sen : dclfCase
						.getSensitivityArray()) {
					if (sen.getSenType() == DclfSensitivityXmlType.SenType.P_ANGLE) {
						algo.calculateSensitivity(DclfSensitivityType.PANGLE,
								sen.getInjectBusId(), msg);
						dialog.appendText(DclfOutFunc.pAngleSensitivityResults(
								sen, algo, msg));
						/*
						 * for (BusRecXmlType bus : sen.getBusArray()) { double
						 * pang = algo.getBusSensitivity(
						 * DclfSensitivityType.PANGLE, bus.getBusId(), msg);
						 * IpssLogger.getLogger().info( "P-Angle Sensitivity (" +
						 * bus.getBusId() + "," + sen.getInjectBusId() + ") : " +
						 * pang); }
						 */
					} else if (sen.getSenType() == DclfSensitivityXmlType.SenType.Q_VOLTAGE) {
						algo.calculateSensitivity(DclfSensitivityType.QVOLTAGE,
								sen.getInjectBusId(), msg);
						dialog.appendText(DclfOutFunc
								.qVoltageSensitivityResults(sen, algo, msg));
						/*
						 * for (BusRecXmlType bus : sen.getBusArray()) { double
						 * qvolt = algo.getBusSensitivity(
						 * DclfSensitivityType.QVOLTAGE, bus .getBusId(), msg);
						 * IpssLogger.getLogger().info( "Q-Voltage Sensitivity (" +
						 * bus.getBusId() + "," + sen.getInjectBusId() + ") : " +
						 * qvolt); }
						 */
					}
				}

				for (DclfBranchSensitivityXmlType gsFactor : dclfCase
						.getGenShiftFactorArray()) {
					algo.calculateSensitivity(DclfSensitivityType.PANGLE,
							gsFactor.getInjectBusId(), msg);
					dialog.appendText(DclfOutFunc.genShiftFactorResults(
							gsFactor, algo, msg));
					/*
					 * for (BranchRecXmlType branch : gsFactor.getBranchArray()) {
					 * double gsf = algo.getGenShiftFactor(branch
					 * .getFromBusId(), branch.getToBusId(), msg);
					 * IpssLogger.getLogger() .info( "GenShiftFactor (" +
					 * branch.getFromBusId() + "->" + branch.getToBusId() + "," +
					 * gsFactor.getInjectBusId() + ") : " + gsf); }
					 */
				}

				for (DclfBranchSensitivityXmlType tdFactor : dclfCase
						.getPTransferDistFactorArray()) {
					algo.calculateSensitivity(DclfSensitivityType.PANGLE,
							tdFactor.getInjectBusId(), tdFactor
									.getWithdrawBusId(), msg);
					dialog.appendText(DclfOutFunc.pTransferDistFactorResults(
							tdFactor, algo, msg));
					/*
					 * for (BranchRecXmlType branch : tdFactor.getBranchArray()) {
					 * double ptdf = algo.getPTransferDistFactor(branch
					 * .getFromBusId(), branch.getToBusId(), msg);
					 * IpssLogger.getLogger().info(
					 * "PowerTransferDistributionFactor (" +
					 * branch.getFromBusId() + "->" + branch.getToBusId() + "," +
					 * tdFactor.getInjectBusId() + "[in]," +
					 * tdFactor.getWithdrawBusId() + "[out]) : " + ptdf); }
					 */
				}

				dialog.showDialog();
			} else {
				for (RunStudyCaseXmlType.DclfStudyCaseList.DclfStudyCase dclfCase : parser
						.getRunDclfStudyCaseList()) {
				}
			}
		}
		return true;
	}
}
