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
import org.interpss.schema.AreaTransferAnalysisXmlType;
import org.interpss.schema.BusRecXmlType;
import org.interpss.schema.DclfBranchSensitivityXmlType;
import org.interpss.schema.DclfBusSensitivityXmlType;
import org.interpss.schema.DclfSensitivityXmlType;
import org.interpss.schema.DclfStudyCaseXmlType;
import org.interpss.schema.InterPSSXmlType;
import org.interpss.schema.ModificationXmlType;
import org.interpss.schema.RunStudyCaseXmlType;
import org.interpss.schema.SenAnalysisBusRecXmlType;
import org.interpss.schema.SenBusAnalysisDataType;

import com.interpss.common.mapper.IpssMapper;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.dclf.BusSenAnalysisType;
import com.interpss.core.dclf.DclfAlgorithm;
import com.interpss.core.dclf.SenAnalysisType;

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
		if (ipssXmlDoc.getRunStudyCase().getStandardRun().getRunDclfStudyCase() != null) {
			RunStudyCaseXmlType.StandardRun.RunDclfStudyCase xmlRunDclfCase = ipssXmlDoc.getRunStudyCase().getStandardRun().getRunDclfStudyCase();

			DclfAlgorithm algo = CoreObjectFactory.createDclfAlgorithm(aclfNet, msg);
			if (!algo.checkCondition())
				return false;

			IOutputTextDialog dialog = UISpringAppContext
					.getOutputTextDialog("DC Loadflow Analysis Info");
			dialog.clearTextArea();

			DclfStudyCaseXmlType xmlDefaultCase = xmlRunDclfCase.getDafaultDclfStudyCase(); 
			
			for ( DclfStudyCaseXmlType xmlCase : xmlRunDclfCase.getDclfStudyCaseList().getDclfStudyCaseArray()) {
				if (xmlCase.getModification() != null) {
					IpssMapper mapper = PluginSpringAppContext.getIpssXmlMapper();
					mapper.mapping(xmlCase.getModification(), aclfNet);
				}

				if (xmlCase == null) {
					if (xmlDefaultCase == null) {
						msg.sendErrorMsg("No Dclf study case defined");
						return false;
					}
					xmlCase = xmlDefaultCase;
				} 

				if (xmlCase.getCaculatelDclf()) {
					algo.calculateDclf();
					String str = DclfOutFunc.dclfResults(algo);
					dialog.appendText(str);
				}

				for (DclfBusSensitivityXmlType sen : xmlCase.getSensitivityArray()) {
					String inBusId = sen.getInjectBusList().getInjectBusArray(0).getBusId();
					if (sen.getSenType() == DclfSensitivityXmlType.SenType.P_ANGLE) {
						algo.calculateSensitivity(SenAnalysisType.PANGLE, inBusId);
						String str = DclfOutFunc.pAngleSensitivityResults(sen, algo);
						dialog.appendText(str);
					} else if (sen.getSenType() == DclfSensitivityXmlType.SenType.Q_VOLTAGE) {
						algo.calculateSensitivity(SenAnalysisType.QVOLTAGE, inBusId);
						String str = DclfOutFunc.qVoltageSensitivityResults(sen, algo);
						dialog.appendText(str);
					}
				}

				for (DclfBranchSensitivityXmlType gsFactor : xmlCase.getGenShiftFactorArray()) {
					String inBusId = gsFactor.getInjectBusList().getInjectBusArray(0).getBusId();
					algo.calculateSensitivity(SenAnalysisType.PANGLE, inBusId);
					String str = DclfOutFunc.genShiftFactorResults(gsFactor, algo);
					dialog.appendText(str);
				}

				for (DclfBranchSensitivityXmlType tdFactor : xmlCase.getPTransferDistFactorArray()) {
					calPTDistFactor(tdFactor, algo, msg);
					String str = DclfOutFunc.pTransferDistFactorResults(tdFactor, algo);
					dialog.appendText(str);
				}
			}
			
			dialog.showDialog();
		} 
		return true;
	}
	
	public static void calPTDistFactor(DclfBranchSensitivityXmlType tdFactor, DclfAlgorithm algo, IPSSMsgHub msg) {
		algo.getInjectBusList().clear();
		algo.getWithdrawBusList().clear();

		if (tdFactor.getInjectBusType() == SenBusAnalysisDataType.SINGLE_BUS) {
			algo.setInjectBusType(BusSenAnalysisType.SINGLE_BUS);
			String inBusId = tdFactor.getInjectBusList().getInjectBusArray(0).getBusId();
			algo.addInjectBus(inBusId, 100.0);
			algo.calculateSensitivity(SenAnalysisType.PANGLE, inBusId);
		}
		else if (tdFactor.getInjectBusType() == SenBusAnalysisDataType.MULTIPLE_BUS) {
			algo.setInjectBusType(BusSenAnalysisType.MULTIPLE_BUS);
			for (BusRecXmlType bus :  tdFactor.getInjectBusList().getInjectBusArray()){
				algo.calculateSensitivity(SenAnalysisType.PANGLE, bus.getBusId());
				algo.addInjectBus(bus.getBusId(), 100.0);
			}
		}		
		
		if (tdFactor.getWithdrawBusType() == SenBusAnalysisDataType.SINGLE_BUS) {
			algo.setWithdrawBusType(BusSenAnalysisType.SINGLE_BUS);
			String wdBusId = tdFactor.getWithdrawBusList().getWithdrawBusArray(0).getBusId();
			algo.addWithdrawBus(wdBusId, 100.0);
			algo.calculateSensitivity(SenAnalysisType.PANGLE, wdBusId);
		}
		else if (tdFactor.getWithdrawBusType() == SenBusAnalysisDataType.MULTIPLE_BUS) {
			algo.setWithdrawBusType(BusSenAnalysisType.MULTIPLE_BUS);
			for (SenAnalysisBusRecXmlType bus :  tdFactor.getWithdrawBusList().getWithdrawBusArray()){
				algo.calculateSensitivity(SenAnalysisType.PANGLE, bus.getBusId());
				algo.addWithdrawBus(bus.getBusId(), bus.getPercent());
			}
		}		
	}

	public static void calAreaTransferFactor(AreaTransferAnalysisXmlType areaTransfer, DclfAlgorithm algo, IPSSMsgHub msg) {
		algo.getInjectBusList().clear();
		algo.getWithdrawBusList().clear();

		algo.setInjectBusType(BusSenAnalysisType.MULTIPLE_BUS);
		for (SenAnalysisBusRecXmlType bus :  areaTransfer.getInjectBusList().getInjectBusArray()){
			algo.calculateSensitivity(SenAnalysisType.PANGLE, bus.getBusId());
			algo.addInjectBus(bus.getBusId(), bus.getPercent());
		}

		algo.setWithdrawBusType(BusSenAnalysisType.MULTIPLE_BUS);
		for (SenAnalysisBusRecXmlType bus :  areaTransfer.getWithdrawBusList().getWithdrawBusArray()){
			algo.calculateSensitivity(SenAnalysisType.PANGLE, bus.getBusId());
			algo.addWithdrawBus(bus.getBusId(), bus.getPercent());
		}
	}
}
