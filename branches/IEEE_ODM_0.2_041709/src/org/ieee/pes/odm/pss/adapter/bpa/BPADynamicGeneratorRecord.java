/*
 * @(#)BPADynamicRecord.java   
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
 * @Author Stephen Hou
 * @Version 1.0
 * @Date 02/11/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.ieee.pes.odm.pss.adapter.bpa;

import java.text.NumberFormat;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.GeneratorModelListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.GeneratorXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PerUnitXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PercentXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PostiveSequenceDataListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TimeXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TransientSimulationXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZeroSequenceDataListXmlType;
import org.ieee.pes.odm.pss.model.ODMData2XmlHelper;
import org.ieee.pes.odm.pss.model.StringUtil;

public class BPADynamicGeneratorRecord {

	public static void processGeneratorData(String str, String str1,
			TransientSimulationXmlType tranSimu, PSSNetworkXmlType baseCaseNet,
			BPAAdapter adapter, String genType) {

		PostiveSequenceDataListXmlType.GeneratorPostiveList.GerneratorPostive posGen = tranSimu
				.getDynamicDataList().getSequenceDataList()
				.getPostiveSequenceDataList().getGeneratorPostiveList()
				.addNewGerneratorPostive();
		ZeroSequenceDataListXmlType.GeneratorZeroList.GeneratorZero zeroGen = tranSimu
				.getDynamicDataList().getSequenceDataList()
				.getZeroSequenceDataList().getGeneratorZeroList()
				.addNewGeneratorZero();
		zeroGen.addNewZRZer().setValue(0);
		zeroGen.addNewZXZer().setValue(0);

		final String strAry[] = getGeneratorDataFields(str, str1, adapter);
		if (genType == "subTransient") {
			GeneratorXmlType gen = tranSimu.getDynamicDataList()
					.getBusDynDataList().getGeneratorDataList()
					.addNewGenerator();
			gen.addNewGeneratorModel();
			String busId = strAry[1];
			gen.addNewLocatedBus().setName(busId);
			// posGen.addNewBusId().setName(busId);
			// zeroGen.addNewBusId().setName(busId);
			double ratedVoltage = 0.0;
			if (!strAry[2].equals("")) {
				ratedVoltage = new Double(strAry[2]).doubleValue();
				ODMData2XmlHelper.setVoltageData(gen.addNewBusRatedVoltage(),
						ratedVoltage, VoltageXmlType.Unit.KV);
			}
			String genId = "1";
			if (!strAry[3].equals("")) {
				genId = strAry[3];
			}
			String owner = "";
			if (!strAry[7].equals("")) {
				owner = strAry[7];
			}
			double xd11 = StringUtil.getDouble(strAry[8], 0.0);
			if (xd11 > 10) {
				xd11 = xd11 / 10000;
			}
			double xq11 = StringUtil.getDouble(strAry[9], 0.0);
			if (xq11 > 10) {
				xq11 = xq11 / 10000;
			}
			double td011 = StringUtil.getDouble(strAry[10], 0.0);
			if (td011 > 1) {
				td011 = td011 / 10000;
			}
			double tq011 = StringUtil.getDouble(strAry[11], 0.0);
			if (tq011 > 1) {
				tq011 = tq011 / 10000;
			}

			double pContri = StringUtil.getDouble(strAry[17], 0.0);
			if (pContri <= 1.0 && pContri != 0.0) {
				pContri = pContri * 100;
				gen.addNewPContribution().setValue(pContri);
				gen.getPContribution().setUnit(PercentXmlType.Unit.PERCENT);
			}
			double qContri = StringUtil.getDouble(strAry[18], 0.0);
			if (qContri <= 1.0 && qContri != 0.0) {
				qContri = qContri * 100;
				gen.addNewQContribution().setValue(qContri);
				gen.getQContribution().setUnit(PercentXmlType.Unit.PERCENT);
			}
			double Emws = StringUtil.getDouble(strAry[16], 0.0);

			double MvaBase = StringUtil.getDouble(strAry[19], baseCaseNet
					.getBasePower());

			double h = 0.0;

			double ra = StringUtil.getDouble(strAry[20], 0.0);
			if (ra > 1) {
				ra = ra / 10000;
			}
			double xd1 = StringUtil.getDouble(strAry[21], 0.0);
			if (xd1 > 10) {
				xd1 = xd1 / 10000;
			}
			double xq1 = StringUtil.getDouble(strAry[22], 0.0);
			if (xq1 > 10) {
				xq1 = xq1 / 10000;
			}
			double xd = StringUtil.getDouble(strAry[23], 0.0);
			if (xd > 10) {
				xd = xd / 10000;
			}
			double xq = StringUtil.getDouble(strAry[24], 0.0);
			if (xq > 10) {
				xq = xq / 10000;
			}
			double td01 = StringUtil.getDouble(strAry[25], 0.0);
			if (td01 > 100) {
				td01 = td01 / 100;
			}
			double tq01 = StringUtil.getDouble(strAry[26], 0.0);
			if (tq01 > 10) {
				tq01 = tq01 / 100;
			}
			double xl = StringUtil.getDouble(strAry[27], 0.0);
			if (xl > 10) {
				xl = xl / 1000;
			}
			double E1 = 1.0, SE1 = 0.0;
			if (!strAry[28].equals("")) {
				SE1 = new Double(strAry[28]).doubleValue();
				if (SE1 > 1) {
					SE1 = SE1 / 10000;
				}
			}
			double E2 = 1.2, SE2 = 0.0;
			if (!strAry[29].equals("")) {
				SE2 = new Double(strAry[29]).doubleValue();
				if (SE2 > 1) {
					SE2 = SE2 / 1000;
				}
			}

			double D = 0.0;
			if (!strAry[30].equals("")) {
				D = new Double(strAry[30]).doubleValue();
			}

			gen.addNewGenId().setName(genId);
			if (xq1 == xq) { // sailent-pole generator
				GeneratorModelListXmlType.SailentPoleSubTransientModel saGen = gen
						.getGeneratorModel()
						.addNewSailentPoleSubTransientModel();
				gen
						.setGeneratorType(GeneratorXmlType.GeneratorType.SAILENT_POLE_SUBTRANS_MODEL);
				saGen.setBasePower(MvaBase);
				saGen
						.setBasePowerUnit(GeneratorModelListXmlType.SailentPoleSubTransientModel.BasePowerUnit.MVA);
				ODMData2XmlHelper.setPUData(saGen.addNewRa(), ra,
						PerUnitXmlType.Unit.PU);
				ODMData2XmlHelper.setPUData(saGen.addNewXd1(), xd1,
						PerUnitXmlType.Unit.PU);
				// ODMData2XmlHelper.setPUData(saGen.addNewXq1(), xq1,
				// PerUnitXmlType.Unit.PU);
				ODMData2XmlHelper.setPUData(saGen.addNewXd(), xd,
						PerUnitXmlType.Unit.PU);
				ODMData2XmlHelper.setPUData(saGen.addNewXq(), xq,
						PerUnitXmlType.Unit.PU);
				ODMData2XmlHelper.setTimeData(saGen.addNewTdo1(), td01,
						TimeXmlType.Unit.SEC);
				// ODMData2XmlHelper.setTimeData(saGen.addNewTq01(),
				// tq01, TimeXmlType.Unit.SEC);
				ODMData2XmlHelper.setPUData(saGen.addNewXr(), xl,
						PerUnitXmlType.Unit.PU);
				if (Emws != 0.0) {
					h = Emws / MvaBase;
					NumberFormat ddf1 = NumberFormat.getInstance();
					ddf1.setMaximumFractionDigits(4);
					h = new Double(ddf1.format(h)).doubleValue();
					ODMData2XmlHelper.setPUData(saGen.addNewH(), h,
							PerUnitXmlType.Unit.PU);
				}
				saGen.setE1(1.0);
				saGen.setSE1(SE1);
				saGen.setE2(1.2);
				saGen.setSE2(SE2);
				ODMData2XmlHelper.setPUData(saGen.addNewD(), D,
						PerUnitXmlType.Unit.PU);
				ODMData2XmlHelper.setPUData(saGen.addNewXd11(), xd11,
						PerUnitXmlType.Unit.PU);

				// ODMData2XmlHelper.setPUData(saGen.addNewXq11(),
				// xq11, PerUnitXmlType.Unit.PU);

				ODMData2XmlHelper.setTimeData(saGen.addNewTd011(), td011,
						TimeXmlType.Unit.SEC);

				ODMData2XmlHelper.setTimeData(saGen.addNewTq011(), tq011,
						TimeXmlType.Unit.SEC);

			} else { // non sailent-pole generator
				GeneratorModelListXmlType.NonSailentPoleSubTransientModel nonSaGen = gen
						.getGeneratorModel()
						.addNewNonSailentPoleSubTransientModel();
				gen
						.setGeneratorType(GeneratorXmlType.GeneratorType.NONSAILENT_POLE_SUBTRANS_MODEL);

				nonSaGen.setBasePower(MvaBase);
				nonSaGen
						.setBasePowerUnit(GeneratorModelListXmlType.NonSailentPoleSubTransientModel.BasePowerUnit.MVA);
				ODMData2XmlHelper.setPUData(nonSaGen.addNewRa(), ra,
						PerUnitXmlType.Unit.PU);
				ODMData2XmlHelper.setPUData(nonSaGen.addNewXd1(), xd1,
						PerUnitXmlType.Unit.PU);
				ODMData2XmlHelper.setPUData(nonSaGen.addNewXq1(), xq1,
						PerUnitXmlType.Unit.PU);
				ODMData2XmlHelper.setPUData(nonSaGen.addNewXd(), xd,
						PerUnitXmlType.Unit.PU);
				ODMData2XmlHelper.setPUData(nonSaGen.addNewXq(), xq,
						PerUnitXmlType.Unit.PU);
				ODMData2XmlHelper.setTimeData(nonSaGen.addNewTdo1(), td01,
						TimeXmlType.Unit.SEC);
				ODMData2XmlHelper.setTimeData(nonSaGen.addNewTq01(), tq01,
						TimeXmlType.Unit.SEC);
				ODMData2XmlHelper.setPUData(nonSaGen.addNewXr(), xl,
						PerUnitXmlType.Unit.PU);
				if (Emws != 0.0) {
					h = Emws / MvaBase;
					NumberFormat ddf1 = NumberFormat.getInstance();
					ddf1.setMaximumFractionDigits(4);
					h = new Double(ddf1.format(h)).doubleValue();
					ODMData2XmlHelper.setPUData(nonSaGen.addNewH(), h,
							PerUnitXmlType.Unit.PU);
				}
				nonSaGen.setE1(1.0);
				nonSaGen.setSE1(SE1);
				nonSaGen.setE2(1.2);
				nonSaGen.setSE2(SE2);
				ODMData2XmlHelper.setPUData(nonSaGen.addNewD(), D,
						PerUnitXmlType.Unit.PU);
				ODMData2XmlHelper.setPUData(nonSaGen.addNewXd11(), xd11,
						PerUnitXmlType.Unit.PU);

				ODMData2XmlHelper.setPUData(nonSaGen.addNewXq11(), xq11,
						PerUnitXmlType.Unit.PU);

				ODMData2XmlHelper.setTimeData(nonSaGen.addNewTd011(), td011,
						TimeXmlType.Unit.SEC);

				ODMData2XmlHelper.setTimeData(nonSaGen.addNewTq011(), tq011,
						TimeXmlType.Unit.SEC);

			}
			ODMData2XmlHelper.setPUData(posGen.addNewZRPos(), 0.0,
					PerUnitXmlType.Unit.PU);
			ODMData2XmlHelper.setPUData(posGen.addNewZXPos(), xd1,
					PerUnitXmlType.Unit.PU);
			posGen.addNewBusId().setName(busId);
			posGen.addNewMacId().setName(genId);
			zeroGen.addNewMacId().setName(genId);
			zeroGen.addNewBusId().setName(busId);
		} else if (genType == "transient") {
			GeneratorXmlType gen = tranSimu.getDynamicDataList()
					.getBusDynDataList().getGeneratorDataList()
					.addNewGenerator();
			String busId = strAry[1];
			posGen.addNewBusId().setName(busId);
			gen.addNewLocatedBus().setName(busId);
			zeroGen.addNewBusId().setName(busId);
			double ratedVoltage = 0.0;
			if (!strAry[2].equals("")) {
				ratedVoltage = new Double(strAry[2]).doubleValue();
				ODMData2XmlHelper.setVoltageData(gen.addNewBusRatedVoltage(),
						ratedVoltage, VoltageXmlType.Unit.KV);
			}
			gen
					.setGeneratorType(GeneratorXmlType.GeneratorType.TRANSIENT_MODEL);
			GeneratorModelListXmlType.TransModel tranGen = gen
					.addNewGeneratorModel().addNewTransModel();
			String genId = "1";
			if (!strAry[3].equals("")) {
				genId = strAry[3];
			}
			gen.addNewGenId().setName(genId);
			posGen.addNewMacId().setName(genId);
			zeroGen.addNewMacId().setName(genId);
			double Emws = 0.0;
			if (!strAry[4].equals("")) {
				Emws = new Double(strAry[4]).doubleValue();
			}
			
			
			double ra = StringUtil.getDouble(strAry[8], 0.0);
			if (ra > 1) {
				ra = ra / 10000;
			}
			double xd1 = StringUtil.getDouble(strAry[9], 0.0);
			if (xd1 > 10) {
				xd1 = xd1 / 10000;
			}
			double xq1 = StringUtil.getDouble(strAry[10], 0.0);
			if (xq1 > 10) {
				xq1 = xq1 / 10000;
			}
			double xd = StringUtil.getDouble(strAry[11], 0.0);
			if (xd > 10) {
				xd = xd / 10000;
			}
			double xq = StringUtil.getDouble(strAry[12], 0.0);
			if (xq > 10) {
				xq = xq / 10000;
			}
			double td01 = StringUtil.getDouble(strAry[13], 0.0);
			if (td01 > 100) {
				td01 = td01 / 100;
			}
			double tq01 = StringUtil.getDouble(strAry[14], 0.0);
			if (tq01 > 10) {
				tq01 = tq01 / 100;
			}
			double xl = StringUtil.getDouble(strAry[15], 0.0);
			if (xl > 10) {
				xl = xl / 1000;
			}
			double E1 = 1.0, SE1 = 0.0;
			if (!strAry[28].equals("")) {
				SE1 = new Double(strAry[16]).doubleValue();
				if (SE1 > 1) {
					SE1 = SE1 / 10000;
				}
			}
			double E2 = 1.2, SE2 = 0.0;
			if (!strAry[29].equals("")) {
				SE2 = new Double(strAry[17]).doubleValue();
				if (SE2 > 1) {
					SE2 = SE2 / 1000;
				}
			}

			ODMData2XmlHelper.setPUData(tranGen.addNewRa(), ra,
					PerUnitXmlType.Unit.PU);
			ODMData2XmlHelper.setPUData(tranGen.addNewXd1(), xd1,
					PerUnitXmlType.Unit.PU);
			 ODMData2XmlHelper.setPUData(tranGen.addNewXq1(), xq1,
			 PerUnitXmlType.Unit.PU);
			ODMData2XmlHelper.setPUData(tranGen.addNewXd(), xd,
					PerUnitXmlType.Unit.PU);
			ODMData2XmlHelper.setPUData(tranGen.addNewXq(), xq,
					PerUnitXmlType.Unit.PU);
			ODMData2XmlHelper.setTimeData(tranGen.addNewTdo1(), td01,
					TimeXmlType.Unit.SEC);
			ODMData2XmlHelper.setTimeData(tranGen.addNewTq01(),
			 tq01, TimeXmlType.Unit.SEC);
			
			
			tranGen.setE1(1.0);
			tranGen.setSE1(SE1);
			tranGen.setE2(1.2);
			tranGen.setSE2(SE2);
			
			// infinit bus			
			double MvaBase = 0.0;
			if (!strAry[7].equals("")) {
				MvaBase = new Double(strAry[7]).doubleValue();
			} else {
				MvaBase = baseCaseNet.getBasePower();
			}
			double h = 0.0;
			if (Emws != 0.0) {
				h = Emws / MvaBase;
				NumberFormat ddf1 = NumberFormat.getInstance();
				ddf1.setMaximumFractionDigits(4);
				h = new Double(ddf1.format(h)).doubleValue();
				ODMData2XmlHelper.setPUData(tranGen.addNewH(), h,
						PerUnitXmlType.Unit.PU);
			}
			double pContri = 0.0, qContri = 0.0;
			if (!strAry[5].equals("")) {
				pContri = new Double(strAry[5]).doubleValue();
				if (pContri <= 1.0 && qContri != 0.0) {
					pContri = pContri * 100;
				}
				gen.addNewPContribution().setValue(pContri);
				gen.getPContribution().setUnit(PercentXmlType.Unit.PERCENT);
			}
			if (!strAry[6].equals("")) {
				qContri = new Double(strAry[6]).doubleValue();
				if (qContri <= 1.0 && qContri != 0.0) {
					qContri = qContri * 100;
				}
				gen.addNewQContribution().setValue(qContri);
				gen.getQContribution().setUnit(PercentXmlType.Unit.PERCENT);
			}

			tranGen.setBasePower(MvaBase);
			tranGen
					.setBasePowerUnit(GeneratorModelListXmlType.TransModel.BasePowerUnit.MVA);
			if (!strAry[9].equals("")) {
				xd1 = new Double(strAry[9]).doubleValue();
				ODMData2XmlHelper.setPUData(tranGen.addNewXd1(), xd1,
						PerUnitXmlType.Unit.PU);
			}
		
		ODMData2XmlHelper.setPUData(posGen.addNewZRPos(), 0.0,
				PerUnitXmlType.Unit.PU);
		ODMData2XmlHelper.setPUData(posGen.addNewZXPos(), xd1,
				PerUnitXmlType.Unit.PU);
		double D = 2.0;
		if (!strAry[18].equals("")) {
			D = new Double(strAry[18]).doubleValue();
		}
		ODMData2XmlHelper.setPUData(tranGen.addNewD(), D,
				PerUnitXmlType.Unit.PU);
				

		} else if (genType == "classical") {
			GeneratorXmlType gen = tranSimu.getDynamicDataList()
					.getBusDynDataList().getGeneratorDataList()
					.addNewGenerator();
			String busId = strAry[1];
			posGen.addNewBusId().setName(busId);
			gen.addNewLocatedBus().setName(busId);
			zeroGen.addNewBusId().setName(busId);
			double ratedVoltage = 0.0;
			if (!strAry[2].equals("")) {
				ratedVoltage = new Double(strAry[2]).doubleValue();
				ODMData2XmlHelper.setVoltageData(gen.addNewBusRatedVoltage(),
						ratedVoltage, VoltageXmlType.Unit.KV);
			}
			gen
					.setGeneratorType(GeneratorXmlType.GeneratorType.CLASSICAL_MODEL);
			GeneratorModelListXmlType.ClassicalModel claGen = gen
					.addNewGeneratorModel().addNewClassicalModel();
			String genId = "1";
			if (!strAry[3].equals("")) {
				genId = strAry[3];
			}
			gen.addNewGenId().setName(genId);
			posGen.addNewMacId().setName(genId);
			zeroGen.addNewMacId().setName(genId);
			double Emws = 0.0;
			if (!strAry[4].equals("")) {
				Emws = new Double(strAry[4]).doubleValue();
			}
			// infinit bus
			double xd1 = 0.0;
			if (Emws == 999999) {
				ODMData2XmlHelper.setPUData(claGen.addNewH(), 999999,
						PerUnitXmlType.Unit.PU);
				if (!strAry[9].equals("")) {
					xd1 = new Double(strAry[9]).doubleValue();
					ODMData2XmlHelper.setPUData(claGen.addNewXd1(), xd1,
							PerUnitXmlType.Unit.PU);
				}
			} else {
				double MvaBase = 0.0;
				if (!strAry[7].equals("")) {
					MvaBase = new Double(strAry[7]).doubleValue();
				} else {
					MvaBase = baseCaseNet.getBasePower();
				}
				double h = 0.0;
				if (Emws != 0.0) {
					h = Emws / MvaBase;
					NumberFormat ddf1 = NumberFormat.getInstance();
					ddf1.setMaximumFractionDigits(4);
					h = new Double(ddf1.format(h)).doubleValue();
					ODMData2XmlHelper.setPUData(claGen.addNewH(), h,
							PerUnitXmlType.Unit.PU);
				}
				double pContri = 0.0, qContri = 0.0;
				if (!strAry[5].equals("")) {
					pContri = new Double(strAry[5]).doubleValue();
					if (pContri <= 1.0 && qContri != 0.0) {
						pContri = pContri * 100;
					}
					gen.addNewPContribution().setValue(pContri);
					gen.getPContribution().setUnit(PercentXmlType.Unit.PERCENT);
				}
				if (!strAry[6].equals("")) {
					qContri = new Double(strAry[6]).doubleValue();
					if (qContri <= 1.0 && qContri != 0.0) {
						qContri = qContri * 100;
					}
					gen.addNewQContribution().setValue(qContri);
					gen.getQContribution().setUnit(PercentXmlType.Unit.PERCENT);
				}

				claGen.setBasePower(MvaBase);
				claGen
						.setBasePowerUnit(GeneratorModelListXmlType.ClassicalModel.BasePowerUnit.MVA);
				if (!strAry[9].equals("")) {
					xd1 = new Double(strAry[9]).doubleValue();
					ODMData2XmlHelper.setPUData(claGen.addNewXd1(), xd1,
							PerUnitXmlType.Unit.PU);
				}
			}
			ODMData2XmlHelper.setPUData(posGen.addNewZRPos(), 0.0,
					PerUnitXmlType.Unit.PU);
			ODMData2XmlHelper.setPUData(posGen.addNewZXPos(), xd1,
					PerUnitXmlType.Unit.PU);
			double D = 2.0;
			if (!strAry[18].equals("")) {
				D = new Double(strAry[18]).doubleValue();
			}
			ODMData2XmlHelper.setPUData(claGen.addNewD(), D,
					PerUnitXmlType.Unit.PU);
		}
	}

	private static String[] getGeneratorDataFields(final String str,
			final String str1, BPAAdapter adapter) {
		final String[] strAry = new String[31];

		try {
			if (str.substring(0, 2).trim().equals("M") && !str1.equals("")) {

				strAry[0] = StringUtil.getStringReturnEmptyString(str, 1, 2)
						.trim();
				strAry[1] = StringUtil.getStringReturnEmptyString(str, 4, 11)
						.trim();
				strAry[2] = StringUtil.getStringReturnEmptyString(str, 12, 15)
						.trim();
				strAry[3] = StringUtil.getStringReturnEmptyString(str, 16, 16)
						.trim();
				strAry[4] = StringUtil.getStringReturnEmptyString(str, 17, 21)
						.trim();
				strAry[5] = StringUtil.getStringReturnEmptyString(str, 23, 25)
						.trim();
				strAry[6] = StringUtil.getStringReturnEmptyString(str, 31, 32)
						.trim();
				strAry[7] = StringUtil.getStringReturnEmptyString(str, 34, 36)
						.trim();
				strAry[8] = StringUtil.getStringReturnEmptyString(str, 38, 42)
						.trim();
				strAry[9] = StringUtil.getStringReturnEmptyString(str, 43, 47)
						.trim();
				strAry[10] = StringUtil.getStringReturnEmptyString(str, 48, 51)
						.trim();
				strAry[11] = StringUtil.getStringReturnEmptyString(str, 52, 55)
						.trim();

				strAry[12] = StringUtil.getStringReturnEmptyString(str1, 1, 2)
						.trim();
				strAry[13] = StringUtil.getStringReturnEmptyString(str1, 4, 11)
						.trim();
				strAry[14] = StringUtil
						.getStringReturnEmptyString(str1, 12, 15).trim();
				strAry[15] = StringUtil
						.getStringReturnEmptyString(str1, 16, 16).trim();
				strAry[16] = StringUtil
						.getStringReturnEmptyString(str1, 17, 22).trim();
				strAry[17] = StringUtil
						.getStringReturnEmptyString(str1, 23, 25).trim();
				strAry[18] = StringUtil
						.getStringReturnEmptyString(str1, 26, 28).trim();
				strAry[19] = StringUtil
						.getStringReturnEmptyString(str1, 29, 32).trim();
				strAry[20] = StringUtil
						.getStringReturnEmptyString(str1, 33, 36).trim();
				strAry[21] = StringUtil
						.getStringReturnEmptyString(str1, 37, 41).trim();
				strAry[22] = StringUtil
						.getStringReturnEmptyString(str1, 42, 46).trim();
				strAry[23] = StringUtil
						.getStringReturnEmptyString(str1, 47, 51).trim();
				strAry[24] = StringUtil
						.getStringReturnEmptyString(str1, 52, 56).trim();
				strAry[25] = StringUtil
						.getStringReturnEmptyString(str1, 57, 60).trim();
				strAry[26] = StringUtil
						.getStringReturnEmptyString(str1, 61, 63).trim();
				strAry[27] = StringUtil
						.getStringReturnEmptyString(str1, 64, 68).trim();
				strAry[28] = StringUtil
						.getStringReturnEmptyString(str1, 69, 73).trim();
				strAry[29] = StringUtil
						.getStringReturnEmptyString(str1, 74, 77).trim();
				strAry[30] = StringUtil
						.getStringReturnEmptyString(str1, 78, 80).trim();

			} else if (str.substring(0, 2).trim().equals("MC")
					|| str.substring(0, 2).trim().equals("MF")) {

				strAry[0] = StringUtil.getStringReturnEmptyString(str, 1, 2)
						.trim();
				strAry[1] = StringUtil.getStringReturnEmptyString(str, 4, 11)
						.trim();
				strAry[2] = StringUtil.getStringReturnEmptyString(str, 12, 15)
						.trim();
				strAry[3] = StringUtil.getStringReturnEmptyString(str, 16, 16)
						.trim();
				strAry[4] = StringUtil.getStringReturnEmptyString(str, 17, 22)
						.trim();
				strAry[5] = StringUtil.getStringReturnEmptyString(str, 23, 25)
						.trim();
				strAry[6] = StringUtil.getStringReturnEmptyString(str, 26, 28)
						.trim();
				strAry[7] = StringUtil.getStringReturnEmptyString(str, 29, 32)
						.trim();
				// ra
				strAry[8] = StringUtil.getStringReturnEmptyString(str, 33, 36)
						.trim();
				//xd1
				strAry[9] = StringUtil.getStringReturnEmptyString(str, 37, 41)
						.trim();
				//xd
				strAry[10] = StringUtil.getStringReturnEmptyString(str, 42, 46)
						.trim();
				//xq
				strAry[11] = StringUtil.getStringReturnEmptyString(str, 47, 51)
						.trim();
				//td01
				strAry[12] = StringUtil.getStringReturnEmptyString(str, 52, 56)
						.trim();
				//tq01
				strAry[13] = StringUtil.getStringReturnEmptyString(str, 57, 60)
						.trim();
				strAry[14] = StringUtil.getStringReturnEmptyString(str, 61, 63)
						.trim();
				//xl
				strAry[15] = StringUtil.getStringReturnEmptyString(str, 64, 68)
						.trim();
				//s1.0
				strAry[16] = StringUtil.getStringReturnEmptyString(str, 69, 73)
						.trim();
				//s1.2
				strAry[17] = StringUtil.getStringReturnEmptyString(str, 74, 77)
						.trim();
				//d
				strAry[18] = StringUtil.getStringReturnEmptyString(str, 78, 80)
						.trim();
			} else if (str.substring(0, 2).trim().equals("LN")) {

				strAry[0] = StringUtil.getStringReturnEmptyString(str, 1, 2)
						.trim();
				strAry[1] = StringUtil.getStringReturnEmptyString(str, 4, 11)
						.trim();
				strAry[2] = StringUtil.getStringReturnEmptyString(str, 12, 15)
						.trim();
				strAry[3] = StringUtil.getStringReturnEmptyString(str, 19, 26)
						.trim();
				strAry[4] = StringUtil.getStringReturnEmptyString(str, 27, 30)
						.trim();
				strAry[5] = StringUtil.getStringReturnEmptyString(str, 34, 41)
						.trim();
				strAry[6] = StringUtil.getStringReturnEmptyString(str, 42, 45)
						.trim();
				strAry[7] = StringUtil.getStringReturnEmptyString(str, 50, 56)
						.trim();
				strAry[8] = StringUtil.getStringReturnEmptyString(str, 57, 60)
						.trim();
				strAry[9] = StringUtil.getStringReturnEmptyString(str, 64, 71)
						.trim();
				strAry[10] = StringUtil.getStringReturnEmptyString(str, 72, 75)
						.trim();
			}
		} catch (Exception e) {
			adapter.logErr(e.toString());
		}

		return strAry;
	}

}
