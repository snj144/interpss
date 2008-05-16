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

import org.interpss.PluginSpringAppContext;
import org.interpss.display.DclfOutFunc;
import org.interpss.editor.ui.IOutputTextDialog;
import org.interpss.editor.ui.UISpringAppContext;
import org.interpss.schema.DclfBranchSensitivityXmlType;
import org.interpss.schema.DclfBusSensitivityXmlType;
import org.interpss.schema.DclfSensitivityXmlType;
import org.interpss.schema.DclfStudyCaseXmlType;
import org.interpss.schema.InterPSSXmlType;
import org.interpss.schema.ModificationXmlType;
import org.interpss.schema.RunStudyCaseXmlType;
import org.interpss.schema.RunStudyCaseXmlType.CustomRun.RunDclfStudyCase.DclfStudyCaseList.DclfStudyCaseRec;

import com.interpss.common.mapper.IpssMapper;
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
	public static boolean runDclf(InterPSSXmlType ipssXmlDoc, AclfNetwork aclfNet,
			IPSSMsgHub msg) {
		if (ipssXmlDoc.getRunStudyCase().getCustomRun().getRunDclfStudyCase() != null) {
			RunStudyCaseXmlType.CustomRun.RunDclfStudyCase xmlRunDclfCase = ipssXmlDoc.getRunStudyCase().getCustomRun().getRunDclfStudyCase();

			DclfAlgorithm algo = CoreObjectFactory.createDclfAlgorithm(aclfNet);
			if (!algo.checkCondition(msg))
				return false;

			IOutputTextDialog dialog = UISpringAppContext
					.getOutputTextDialog("DC Loadflow Analysis Info");
			dialog.clearTextArea();

			DclfStudyCaseXmlType xmlDefaultCase = xmlRunDclfCase.getDafaultDclfStudyCase(); 
			
			for ( DclfStudyCaseRec rec : xmlRunDclfCase.getDclfStudyCaseList().getDclfStudyCaseRecArray()) {
				if (rec.getModification() != null) {
					IpssMapper mapper = PluginSpringAppContext.getIpssXmlMapper();
					mapper.mapping(rec.getModification(), aclfNet, ModificationXmlType.class);
				}

				DclfStudyCaseXmlType xmlCase = rec.getDclfStudyCase();
				if (xmlCase == null) {
					if (xmlDefaultCase == null) {
						msg.sendErrorMsg("No Dclf study case defined");
						return false;
					}
					xmlCase = xmlDefaultCase;
				} 

				if (xmlCase.getCaculatelDclf()) {
					algo.calculateDclf(msg);
					String str = DclfOutFunc.dclfResults(algo);
					dialog.appendText(str);
				}

				for (DclfBusSensitivityXmlType sen : xmlCase.getSensitivityArray()) {
					if (sen.getSenType() == DclfSensitivityXmlType.SenType.P_ANGLE) {
						algo.calculateSensitivity(DclfSensitivityType.PANGLE, sen
								.getInjectBusId(), msg);
						String str = DclfOutFunc.pAngleSensitivityResults(sen,
								algo, msg);
						dialog.appendText(str);
					} else if (sen.getSenType() == DclfSensitivityXmlType.SenType.Q_VOLTAGE) {
						algo.calculateSensitivity(DclfSensitivityType.QVOLTAGE, sen
								.getInjectBusId(), msg);
						String str = DclfOutFunc.qVoltageSensitivityResults(sen,
								algo, msg);
						dialog.appendText(str);
					}
				}

				for (DclfBranchSensitivityXmlType gsFactor : xmlCase
						.getGenShiftFactorArray()) {
					algo.calculateSensitivity(DclfSensitivityType.PANGLE, gsFactor
							.getInjectBusId(), msg);
					String str = DclfOutFunc.genShiftFactorResults(gsFactor, algo,
							msg);
					dialog.appendText(str);
				}

				for (DclfBranchSensitivityXmlType tdFactor : xmlCase
						.getPTransferDistFactorArray()) {
					algo.calculateSensitivity(DclfSensitivityType.PANGLE, tdFactor
							.getInjectBusId(), tdFactor.getWithdrawBusId(), msg);
					String str = DclfOutFunc.pTransferDistFactorResults(tdFactor,
							algo, msg);
					dialog.appendText(str);
				}
			}
			
			dialog.showDialog();
		} 
		return true;
	}
}
