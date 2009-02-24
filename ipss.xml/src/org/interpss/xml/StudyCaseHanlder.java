/*
 * @(#)StudyCaseHanlder.java   
 *
 * Copyright (C) 2006-2008 www.interpss.org
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
 * @Date 09/15/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.xml;

import org.interpss.schema.AclfAlgorithmXmlType;
import org.interpss.schema.AclfStudyCaseXmlType;
import org.interpss.schema.AcscFaultCategoryDataType;
import org.interpss.schema.AcscFaultDataType;
import org.interpss.schema.AcscFaultXmlType;
import org.interpss.schema.AcscStudyCaseXmlType;
import org.interpss.schema.AreaRecXmlType;
import org.interpss.schema.AreaTransferAnalysisXmlType;
import org.interpss.schema.DStabStudyCaseXmlType;
import org.interpss.schema.DclfBranchSensitivityXmlType;
import org.interpss.schema.DclfStudyCaseXmlType;
import org.interpss.schema.DynamicEventDataType;
import org.interpss.schema.GridComputingXmlType;
import org.interpss.schema.InterPSSDocument;
import org.interpss.schema.NodeTransferAnalysisXmlType;
import org.interpss.schema.TradingStudyCaseXmlType;


public class StudyCaseHanlder {
	private InterPSSDocument ipssXmlDoc;

	public StudyCaseHanlder(InterPSSDocument ipssXmlDoc) {
		this.ipssXmlDoc = ipssXmlDoc;
	}
	
	/**
	 * Get the Ipss Xml document
	 * 
	 * @return
	 */
	public InterPSSDocument getIpssXmlDoc() {
		return this.ipssXmlDoc;
	}
	
	/**
	 * Get the grid computing option record from the Ipss Xml document
	 * 
	 * @return
	 */
	public GridComputingXmlType getGridOption() {
		return this.ipssXmlDoc.getInterPSS().getRunStudyCase().getGridRunOption();
	}
	
	// Aclf Study Case
	// ===============
	
	/**
	 * Delete the study case
	 * 
	 * @param casename
	 * @return true if deleted
	 */
	public boolean deleteAclfStudyCase(String casename) {
		int cnt = 0;
		for (AclfStudyCaseXmlType scase : getAclfStudyCaseArray()) {
			if (scase.getRecName().equals(casename)) {
				this.ipssXmlDoc.getInterPSS().getRunStudyCase().getStandardRun().
					getRunAclfStudyCase().getAclfStudyCaseList().removeAclfStudyCase(cnt);
				return true;
			}
			cnt++;
		}
		return false;
	}
	
	/**
	 * add a new Aclf Study case
	 * 
	 * @param casename
	 * @return
	 */
	public boolean addNewAclfStudyCase(String casename) {
		AclfStudyCaseXmlType scase = this.ipssXmlDoc.getInterPSS().getRunStudyCase().
					getStandardRun().getRunAclfStudyCase().getAclfStudyCaseList().addNewAclfStudyCase();
		scase.setRecId(casename.replaceAll(" ", "_"));
		scase.setRecName(casename);
		scase.addNewAclfAlgorithm();
        scase.getAclfAlgorithm().setLfMethod(AclfAlgorithmXmlType.LfMethod.NR);
       	scase.getAclfAlgorithm().setTolerance(0.0001);
       	scase.getAclfAlgorithm().setMaxIterations(20);
       	scase.getAclfAlgorithm().setAccFactor(1.0);
       	scase.getAclfAlgorithm().setNonDivergent(true);
       	scase.getAclfAlgorithm().setInitBusVoltage(true);
       	scase.getAclfAlgorithm().setDisplaySummary(true);
		return true;
	}
	
	/**
	 * Get the AclfStudyCase record list
	 * 
	 * @return
	 */
	public AclfStudyCaseXmlType[] getAclfStudyCaseArray() {
		return this.ipssXmlDoc.getInterPSS().
				getRunStudyCase().getStandardRun().getRunAclfStudyCase().getAclfStudyCaseList().getAclfStudyCaseArray();
	}

	/**
	 * Get the AclfStudyCase record by the record name
	 * 
	 * @param recName
	 * @return
	 */
	public AclfStudyCaseXmlType getAclfStudyCase(String recName) {
		return 	(AclfStudyCaseXmlType)IpssXmlUtilFunc.getRecordByName(recName, getAclfStudyCaseArray());
	}
	
	/**
	 * Get AclfStudyCase name array
	 * 
	 * @return
	 */
	public String[] getAclfStudyCaseNameArray() {
		return IpssXmlUtilFunc.getRecNameArray(getAclfStudyCaseArray());
	}

	// Dclf/SensitivityAnalysis Study Case
	// ===================================
	
	/**
	 * Delete the study case
	 * 
	 * @param casename
	 * @return true if deleted
	 */
	public boolean deleteDclfStudyCase(String casename) {
		int cnt = 0;
		for (DclfStudyCaseXmlType scase : getDclfStudyCaseArray()) {
			if (scase.getRecName().equals(casename)) {
				this.ipssXmlDoc.getInterPSS().getRunStudyCase().getStandardRun().
					getRunDclfStudyCase().getDclfStudyCaseList().removeDclfStudyCase(cnt);
				return true;
			}
			cnt++;
		}
		return false;
	}
	
	/**
	 * add a new Dclf Study case
	 * 
	 * @param casename
	 * @return
	 */
	public boolean addNewDclfStudyCase(String casename) {
		DclfStudyCaseXmlType scase = this.ipssXmlDoc.getInterPSS().getRunStudyCase().
					getStandardRun().getRunDclfStudyCase().getDclfStudyCaseList().addNewDclfStudyCase();
		scase.setRecId(casename.replaceAll(" ", "_"));
		scase.setRecName(casename);
		
		addNewTDFactor(scase);
		setNewAreaTransfer(scase.addNewAreaTransferAnalysis());
		return true;
	}
	
	public static void addNewTDFactor(DclfStudyCaseXmlType scase) {
		DclfBranchSensitivityXmlType tdFactor = scase.addNewPTransferDistFactor();
		tdFactor.addNewInjectBusList();
		tdFactor.getInjectBusList().addNewInjectBus();
		tdFactor.addNewWithdrawBusList();
		tdFactor.getWithdrawBusList().addNewWithdrawBus();		
	}

	public static void setNewAreaTransfer(AreaTransferAnalysisXmlType areaTrans) {
		AreaRecXmlType a = areaTrans.addNewFromArea();
		a.setAreaNo(1);
		a = areaTrans.addNewToArea();
		a.setAreaNo(1);
		areaTrans.addNewInjectBusList();
		areaTrans.addNewWithdrawBusList();
	}

	/**
	 * Get the DclfStudyCase record list
	 * 
	 * @return
	 */
	public DclfStudyCaseXmlType[] getDclfStudyCaseArray() {
		return this.ipssXmlDoc.getInterPSS().getRunStudyCase().getStandardRun().
					getRunDclfStudyCase().getDclfStudyCaseList().getDclfStudyCaseArray();
	}

	/**
	 * Get the DclfStudyCase record by the record name
	 * 
	 * @param recName
	 * @return
	 */
	public DclfStudyCaseXmlType getDclfStudyCase(String recName) {
		return 	(DclfStudyCaseXmlType)IpssXmlUtilFunc.getRecordByName(recName, getDclfStudyCaseArray());
	}
	
	/**
	 * Get DclfStudyCase name array
	 * 
	 * @return
	 */
	public String[] getDclfStudyCaseNameArray() {
		return IpssXmlUtilFunc.getRecNameArray(getDclfStudyCaseArray());
	}

	// Acsc Study Case
	// ===============
	
	/**
	 * Delete the study case
	 * 
	 * @param casename
	 * @return true if deleted
	 */
	public boolean deleteAcscStudyCase(String casename) {
		int cnt = 0;
		for (AcscStudyCaseXmlType scase : getAcscStudyCaseArray()) {
			if (scase.getRecName().equals(casename)) {
				this.ipssXmlDoc.getInterPSS().getRunStudyCase().getStandardRun().
					getRunAcscStudyCase().getAcscStudyCaseList().removeAcscStudyCase(cnt);
				return true;
			}
			cnt++;
		}
		return false;
	}
	
	/**
	 * add a new Acsc Study case
	 * 
	 * @param casename
	 * @return
	 */
	public boolean addNewAcscStudyCase(String casename) {
		AcscStudyCaseXmlType scase = this.ipssXmlDoc.getInterPSS().getRunStudyCase().
					getStandardRun().getRunAcscStudyCase().getAcscStudyCaseList().addNewAcscStudyCase();
		scase.setRecId(casename.replaceAll(" ", "_"));
		scase.setRecName(casename);
		
		scase.setBusAcscInitVolt(AcscStudyCaseXmlType.BusAcscInitVolt.UNIT_VOLT);
		scase.setMultiFactor(100.0);
		AcscFaultXmlType faultData = scase.addNewFaultData();
		setDefaultFaultData(faultData);
		return true;
	}
	
	private static void setDefaultFaultData(AcscFaultXmlType faultData) {
		faultData.setFaultType(AcscFaultDataType.BUS_FAULT);
		faultData.setFaultCategory(AcscFaultCategoryDataType.FAULT_3_P);
		faultData.addNewZLG();
		faultData.addNewZLL();
	}
	
	/**
	 * Get the AcscStudyCase record list
	 * 
	 * @return
	 */
	public AcscStudyCaseXmlType[] getAcscStudyCaseArray() {
		return this.ipssXmlDoc.getInterPSS().getRunStudyCase().getStandardRun().
					getRunAcscStudyCase().getAcscStudyCaseList().getAcscStudyCaseArray();
	}

	/**
	 * Get the AcscStudyCase record by the record name
	 * 
	 * @param recName
	 * @return
	 */
	public AcscStudyCaseXmlType getAcscStudyCase(String recName) {
		return 	(AcscStudyCaseXmlType)IpssXmlUtilFunc.getRecordByName(recName, getAcscStudyCaseArray());
	}
	
	/**
	 * Get AcscStudyCase name array
	 * 
	 * @return
	 */
	public String[] getAcscStudyCaseNameArray() {
		return IpssXmlUtilFunc.getRecNameArray(getAcscStudyCaseArray());
	}

	// DStab Study Case
	// ================
	
	/**
	 * Delete the study case
	 * 
	 * @param casename
	 * @return true if deleted
	 */
	public boolean deleteDStabStudyCase(String casename) {
		int cnt = 0;
		for (DStabStudyCaseXmlType scase : getDStabStudyCaseArray()) {
			if (scase.getRecName().equals(casename)) {
				this.ipssXmlDoc.getInterPSS().getRunStudyCase().getStandardRun().
					getRunDStabStudyCase().getDStabStudyCaseList().removeDStabStudyCase(cnt);
				return true;
			}
			cnt++;
		}
		return false;
	}
	
	/**
	 * add a new DStab Study case
	 * 
	 * @param casename
	 * @return
	 */
	public boolean addNewDStabStudyCase(String casename) {
		DStabStudyCaseXmlType scase = this.ipssXmlDoc.getInterPSS().getRunStudyCase().
					getStandardRun().getRunDStabStudyCase().getDStabStudyCaseList().addNewDStabStudyCase();
		scase.setRecId(casename.replaceAll(" ", "_"));
		scase.setRecName(casename);
		
		return true;
	}
	
	/**
	 * Get the DStabStudyCase record list
	 * 
	 * @return
	 */
	public DStabStudyCaseXmlType[] getDStabStudyCaseArray() {
		return this.ipssXmlDoc.getInterPSS().getRunStudyCase().getStandardRun().
					getRunDStabStudyCase().getDStabStudyCaseList().getDStabStudyCaseArray();
	}

	/**
	 * Get the DStabStudyCase record by the record name
	 * 
	 * @param recName
	 * @return
	 */
	public DStabStudyCaseXmlType getDStabStudyCase(String recName) {
		return 	(DStabStudyCaseXmlType)IpssXmlUtilFunc.getRecordByName(recName, getDStabStudyCaseArray());
	}
	
	/**
	 * Get DStabStudyCase name array
	 * 
	 * @return
	 */
	public String[] getDStabStudyCaseNameArray() {
		return IpssXmlUtilFunc.getRecNameArray(getDStabStudyCaseArray());
	}
	
	public static void setDefaultEventData(DStabStudyCaseXmlType.DynamicEventData.EventList.Event eventData) {
		eventData.setRecId("New_Dynamic_Event");
		eventData.setRecName("New Dynamic Event");
		eventData.setEventType(DynamicEventDataType.FAULT);
		eventData.setDurationSec(0.1);
		eventData.setPermanent(false);
		eventData.setStartTimeSec(0.0);
		setDefaultFaultData(eventData.getFault());
	}

	// TradingAnalysis Study Case
	// ==========================
	
	/**
	 * Delete the TradingAnalysis study case
	 * 
	 * @param casename
	 * @return true if deleted
	 */
	public boolean deleteTradingStudyCase(String casename) {
		int cnt = 0;
		for (TradingStudyCaseXmlType scase : getTradingStudyCaseArray()) {
			if (scase.getRecName().equals(casename)) {
				this.ipssXmlDoc.getInterPSS().getRunStudyCase().getTradingAnalysis()
								.getTradingStudyCaseList().removeTradingStudyCase(cnt);
				return true;
			}
			cnt++;
		}
		return false;
	}
	
	public boolean deleteZonalTransfer(String tradeName) {
		return false;
	}
	
	public boolean deleteNodalTransfer(String tradeName) {
		return false;
	}

	/**
	 * add a new TrasingAnalysis Study case
	 * 
	 * @param casename
	 * @return
	 */
	public boolean addNewTradingStudyCase(String casename) {
		TradingStudyCaseXmlType scase = this.ipssXmlDoc.getInterPSS().getRunStudyCase().getTradingAnalysis()
									.getTradingStudyCaseList().addNewTradingStudyCase();
		scase.setRecId(casename.replaceAll(" ", "_"));
		scase.setRecName(casename);
		
		setNewAreaTransfer(scase.addNewAreaTransferAnalysis());
		return true;
	}
	
	public boolean addNewZonalTransfer(String tradeName, TradingStudyCaseXmlType parent) {
		return false;
	}
	
	public boolean addNewNodalTransfer(String tradeName, TradingStudyCaseXmlType parent) {
		return false;
	}

	/**
	 * Get the TradingStudyCase record list
	 * 
	 * @return
	 */
	public TradingStudyCaseXmlType[] getTradingStudyCaseArray() {
		return this.ipssXmlDoc.getInterPSS().getRunStudyCase().getTradingAnalysis()
						.getTradingStudyCaseList().getTradingStudyCaseArray();
	}

	public AreaTransferAnalysisXmlType[] getZonalTransferArray(TradingStudyCaseXmlType parent) {
		return parent.getAreaTransferAnalysisArray();
	}

	public NodeTransferAnalysisXmlType[] getNodalTransferArray(TradingStudyCaseXmlType parent) {
		return parent.getNodeTransferAnalysisArray();
	}

	/**
	 * Get the TradingStudyCase record by the record name
	 * 
	 * @param recName
	 * @return
	 */
	public TradingStudyCaseXmlType getTradingStudyCase(String recName) {
		return 	(TradingStudyCaseXmlType)IpssXmlUtilFunc.getRecordByName(recName, getTradingStudyCaseArray());
	}
	
	public TradingStudyCaseXmlType getZonalTransfer(String tradeName, TradingStudyCaseXmlType parent) {
		return null;
	}
	
	public TradingStudyCaseXmlType getNodalTransfer(String tradeName, TradingStudyCaseXmlType parent) {
		return null;
	}

	/**
	 * Get TradingStudyCase name array
	 * 
	 * @return
	 */
	public String[] getTradingStudyCaseNameArray() {
		return IpssXmlUtilFunc.getRecNameArray(getTradingStudyCaseArray());
	}
	
	public String[] getZonalTransferNameArray(TradingStudyCaseXmlType parent) {
		return IpssXmlUtilFunc.getRecNameArray(getZonalTransferArray(parent));
	}	

	public String[] getNodalTransferNameArray(TradingStudyCaseXmlType parent) {
		return IpssXmlUtilFunc.getRecNameArray(getNodalTransferArray(parent));
	}	
}