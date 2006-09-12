 /*
  * @(#)AcscResultMapperImpl.java   
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

package org.interpss.report.mapper.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.math.complex.ComplexFormat;
import org.interpss.report.bean.acsc.RptAcscVoltAmpsBean;
import org.interpss.report.bean.acsc.RptFaultSummaryBean;

import com.interpss.common.datatype.Complex3x1;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.Num2Str;
import com.interpss.core.acsc.AcscBranch;
import com.interpss.core.acsc.AcscBranchFault;
import com.interpss.core.acsc.AcscBus;
import com.interpss.core.acsc.AcscBusFault;
import com.interpss.core.acsc.SimpleFaultCode;
import com.interpss.core.acsc.SimpleFaultNetwork;

public class AcscResultMapperImpl {
	public static void mapAcscFaultSummary(SimpleFaultNetwork faultNet, RptFaultSummaryBean bean) {
		double baseKVA = faultNet.getBaseKva();
		Object fault = faultNet.getFaultList().get(0);
		if (fault instanceof AcscBranchFault) {
			AcscBranchFault fBranch = (AcscBranchFault)fault;
			double baseV =  fBranch.getFaultBranch().getFromAcscBus().getBaseVoltage();
			bean.setType(RptFaultSummaryBean.Type_BranchFault);
			bean.setBusId(fBranch.getFaultBranch().getId());
			bean.setBusName(fBranch.getFaultBranch().getName());
			bean.setFaultType("BranchFault");
			bean.setFaultCode(fBranch.getFaultCode().toString());
			bean.setFaultAmpspu(ComplexFormat.formatComplex(fBranch.getFaultResult().getSCCurrent_012().b_1));
			bean.setFaultAmps(ComplexFormat.formatComplex(fBranch.getFaultResult().getSCCurrent_012(UnitType.Amp, baseV, baseKVA).b_1));
			bean.setFaultDistance(Num2Str.toStr( "##0.0", fBranch.getDistance()*100.0)+"%");
		}
		else {
			AcscBusFault fBus = (AcscBusFault)fault;
			double baseV =  fBus.getAcscBus().getBaseVoltage();
			bean.setType(RptFaultSummaryBean.Type_BusFault);
			bean.setBusId(fBus.getAcscBus().getId());
			bean.setBusName(fBus.getAcscBus().getName());
			bean.setFaultType("BusFault");
			bean.setFaultCode(fBus.getFaultCode().toString());
			bean.setFaultAmpspu(ComplexFormat.formatComplex(fBus.getFaultResult().getSCCurrent_012().b_1));
			bean.setFaultAmps(ComplexFormat.formatComplex(fBus.getFaultResult().getSCCurrent_012(UnitType.Amp, baseV, baseKVA).b_1));
			bean.setFaultDistance(" ");
		}
	}
	
	public static Object[] createAcscVoltAmpsBeanArray(SimpleFaultNetwork faultNet) {
		List<RptAcscVoltAmpsBean> list = new ArrayList<RptAcscVoltAmpsBean>();
	  	try {
		  	double baseKva = faultNet.getBaseKva();
		  	AcscBusFault fault = (AcscBusFault)faultNet.getFaultList().get(0);
			if (fault != null) {
				fault.getFaultResult().calContributingCurrent(faultNet);
				if (fault.getFaultCode() == SimpleFaultCode.GROUND_3P_LITERAL) {
					for( Iterator itr = faultNet.getBusList().iterator(); itr.hasNext();) {
						AcscBus bus = (AcscBus)itr.next();
						RptAcscVoltAmpsBean bean = new RptAcscVoltAmpsBean();
						bean.setRecType(RptAcscVoltAmpsBean.RecType_Bus3P);
						bean.setBusName(bus.getName());
						bean.setBusId(bus.getId());
						double vpu = fault.getFaultResult().getFaultVoltage_012(bus.getSortNumber()).b_1.abs();
						Complex3x1 ampPu = fault.getFaultResult().getContriAmps_012(bus.getSortNumber());
						Complex3x1 amps  = fault.getFaultResult().getContriAmps_012(bus.getSortNumber(), UnitType.Amp, 
												bus.getBaseVoltage(), baseKva);
						bean.setBusFaultVoltpu(Num2Str.toStr("####0.##", vpu ));
						bean.setBusFaultVolt(Num2Str.toStr("######0.#", vpu*bus.getBaseVoltage()));
						bean.setBusContribAmpspu(Num2Str.toStr("####0.##", ampPu.b_1.abs()));
						bean.setBusContribAmps(Num2Str.toStr("######0.#", amps.b_1.abs()));
						list.add(bean);
					}
				}
				else {
					for( Iterator itr = faultNet.getBusList().iterator(); itr.hasNext();) {
						AcscBus bus = (AcscBus)itr.next();
						RptAcscVoltAmpsBean bean = new RptAcscVoltAmpsBean();
						bean.setRecType(RptAcscVoltAmpsBean.RecType_Bus012);
						bean.setBusName(bus.getName());
						bean.setBusId(bus.getId());

						Complex3x1 v012 = fault.getFaultResult().getFaultVoltage_012(bus.getSortNumber());
						double vpu1 = v012.b_1.abs();
						bean.setBusFaultVoltpu(Num2Str.toStr("####0.##", vpu1));
						bean.setBusFaultVolt(Num2Str.toStr("######0.#", vpu1*bus.getBaseVoltage()));

						double vpu0 = v012.a_0.abs();
						bean.setBusFaultVolt0pu(Num2Str.toStr("####0.##", vpu0 ));
						bean.setBusFaultVolt0(Num2Str.toStr("######0.#", vpu0*bus.getBaseVoltage() ));

						double vpu2 = v012.c_2.abs();
						bean.setBusFaultVolt2pu(Num2Str.toStr("####0.##", vpu2 ));
						bean.setBusFaultVolt2(Num2Str.toStr("######0.#", vpu2*bus.getBaseVoltage() ));

						Complex3x1 ampPu = fault.getFaultResult().getContriAmps_012(bus.getSortNumber());
						Complex3x1 amps  = fault.getFaultResult().getContriAmps_012(bus.getSortNumber(), UnitType.Amp, 
												bus.getBaseVoltage(), baseKva);
						bean.setBusContribAmpspu(Num2Str.toStr("####0.##", ampPu.b_1.abs()));
						bean.setBusContribAmps(Num2Str.toStr("######0.#", amps.b_1.abs()));
						list.add(bean);
					}

					for( Iterator itr = faultNet.getBusList().iterator(); itr.hasNext();) {
						AcscBus bus = (AcscBus)itr.next();
						RptAcscVoltAmpsBean bean = new RptAcscVoltAmpsBean();
						bean.setRecType(RptAcscVoltAmpsBean.RecType_BusABC);
						bean.setBusName(bus.getName());
						bean.setBusId(bus.getId());

						Complex3x1 v012 = fault.getFaultResult().getFaultVoltage_012(bus.getSortNumber());
						Complex3x1 vabc = Complex3x1.z12_to_abc(v012);

						double vpu1 = vabc.a_0.abs();
						bean.setBusFaultVoltApu(Num2Str.toStr("####0.##", vpu1 ));
						bean.setBusFaultVoltA(Num2Str.toStr("#####0.#", vpu1*bus.getBaseVoltage() ));

						double vpu0 = vabc.b_1.abs();
						bean.setBusFaultVoltBpu(Num2Str.toStr("####0.##", vpu0 ));
						bean.setBusFaultVoltB(Num2Str.toStr("######0.#", vpu0*bus.getBaseVoltage() ));

						double vpu2 = vabc.c_2.abs();
						bean.setBusFaultVoltCpu(Num2Str.toStr("####0.##", vpu2 ));
						bean.setBusFaultVoltC(Num2Str.toStr("######0.#", vpu2*bus.getBaseVoltage() ));

						Complex3x1 ampPu = fault.getFaultResult().getContriAmps_012(bus.getSortNumber());
						Complex3x1 amps  = fault.getFaultResult().getContriAmps_012(bus.getSortNumber(), UnitType.Amp, 
												bus.getBaseVoltage(), baseKva);
						bean.setBusContribAmpspu(Num2Str.toStr("####0.##", ampPu.b_1.abs()));
						bean.setBusContribAmps(Num2Str.toStr("######0.#", amps.b_1.abs()));

						list.add(bean);
					}
				}
				
				fault.getFaultResult().calBranchCurrent(faultNet);
				if (fault.getFaultCode() == SimpleFaultCode.GROUND_3P_LITERAL) {
					List branchList = faultNet.getBranchList();
					int cnt = 0;
					for ( int n = 0; n < branchList.size(); n++ ) {
						AcscBranch bra = (AcscBranch)branchList.get(n);
						RptAcscVoltAmpsBean bean = new RptAcscVoltAmpsBean();
						bean.setRecType(RptAcscVoltAmpsBean.RecType_Branch3P);
						bean.setBranchId(bra.getId());
						bean.setBranchName(bra.getName());
						Complex3x1 cpu   = fault.getFaultResult().getFaultAmps_012From2To(++cnt);
						Complex3x1 camp  = fault.getFaultResult().getFaultAmps_012From2To(cnt, UnitType.Amp, bra.getFromBus().getBaseVoltage(), baseKva);
						bean.setBranchFaultAmpspu(Num2Str.toStr("###0.##", cpu.b_1.abs()));
						bean.setBranchFaultAmps(Num2Str.toStr("######0.#", camp.b_1.abs()));
						list.add(bean);
					}
				}
				else {
					List branchList = faultNet.getBranchList();
					int cnt = 0;
					for ( int n = 0; n < branchList.size(); n++ ) {
						AcscBranch bra = (AcscBranch)branchList.get(n);
						RptAcscVoltAmpsBean beanFrom2To = new RptAcscVoltAmpsBean();
						beanFrom2To.setRecType(RptAcscVoltAmpsBean.RecType_Branch012);
						beanFrom2To.setBranchId(bra.getId());
						beanFrom2To.setBranchName(bra.getName());
						
						RptAcscVoltAmpsBean beanTo2From = new RptAcscVoltAmpsBean();
						beanTo2From.setRecType(RptAcscVoltAmpsBean.RecType_Branch012);
						beanTo2From.setBranchId("<--    ");
						beanTo2From.setBranchName("");


						try {
							Complex3x1 cpu   = fault.getFaultResult().getFaultAmps_012From2To(++cnt);
							Complex3x1 camp  = fault.getFaultResult().getFaultAmps_012From2To(cnt, UnitType.Amp, 
									bra.getFromBus().getBaseVoltage(), faultNet.getBaseKva());
							beanFrom2To.setBranchFaultAmpspu(Num2Str.toStr("###0.##", cpu.b_1.abs()));
							beanFrom2To.setBranchFaultAmps(Num2Str.toStr("######0.", camp.b_1.abs()));		
							beanFrom2To.setBranchFaultAmps0pu(Num2Str.toStr("###0.##", cpu.a_0.abs()));
							beanFrom2To.setBranchFaultAmps0(Num2Str.toStr("######0.#", camp.a_0.abs()));		
							beanFrom2To.setBranchFaultAmps2pu(Num2Str.toStr("###0.##", cpu.c_2.abs()));
							beanFrom2To.setBranchFaultAmps2(Num2Str.toStr("######0.#", camp.c_2.abs()));		

							cpu   = fault.getFaultResult().getFaultAmps_012To2From(cnt);
							camp  = fault.getFaultResult().getFaultAmps_012To2From(cnt, UnitType.Amp, 
									bra.getToBus().getBaseVoltage(), faultNet.getBaseKva());
							beanTo2From.setBranchFaultAmpspu(Num2Str.toStr("###0.##", cpu.b_1.abs()));
							beanTo2From.setBranchFaultAmps(Num2Str.toStr("######0.#", camp.b_1.abs()));		
							beanTo2From.setBranchFaultAmps0pu(Num2Str.toStr("###0.##", cpu.a_0.abs()));
							beanTo2From.setBranchFaultAmps0(Num2Str.toStr("######0.#", camp.a_0.abs()));		
							beanTo2From.setBranchFaultAmps2pu(Num2Str.toStr("###0.##", cpu.c_2.abs()));
							beanTo2From.setBranchFaultAmps2(Num2Str.toStr("######0.#", camp.c_2.abs()));		
						} catch (Exception e) {
							IpssLogger.logErr(e);
						}
						list.add(beanFrom2To);
						list.add(beanTo2From);
					}

					cnt = 0;
					for ( int n = 0; n < branchList.size(); n++ ) {
						AcscBranch bra = (AcscBranch)branchList.get(n);
						RptAcscVoltAmpsBean beanFrom2To = new RptAcscVoltAmpsBean();
						RptAcscVoltAmpsBean beanTo2From = new RptAcscVoltAmpsBean();
						beanFrom2To.setRecType(RptAcscVoltAmpsBean.RecType_BranchABC);
						beanFrom2To.setBranchId(bra.getId());
						beanFrom2To.setBranchName(bra.getName());

						beanTo2From.setRecType(RptAcscVoltAmpsBean.RecType_BranchABC);
						beanTo2From.setBranchId("<--     ");
						beanTo2From.setBranchName("");

						try {
							Complex3x1 cpu   = fault.getFaultResult().getFaultAmps_abcFrom2To(++cnt);
							Complex3x1 camp  = fault.getFaultResult().getFaultAmps_abcFrom2To(cnt, UnitType.Amp, 
									bra.getFromBus().getBaseVoltage(), faultNet.getBaseKva());
							beanFrom2To.setBranchFaultAmpsApu(Num2Str.toStr("###0.##", cpu.a_0.abs()));
							beanFrom2To.setBranchFaultAmpsA(Num2Str.toStr("######0.#", camp.a_0.abs()));		
							beanFrom2To.setBranchFaultAmpsBpu(Num2Str.toStr("###0.##", cpu.b_1.abs()));
							beanFrom2To.setBranchFaultAmpsB(Num2Str.toStr("######0.#", camp.b_1.abs()));		
							beanFrom2To.setBranchFaultAmpsCpu(Num2Str.toStr("###0.##", cpu.c_2.abs()));
							beanFrom2To.setBranchFaultAmpsC(Num2Str.toStr("######0.#", camp.c_2.abs()));		

							cpu   = fault.getFaultResult().getFaultAmps_abcTo2From(cnt);
							camp  = fault.getFaultResult().getFaultAmps_abcTo2From(cnt, UnitType.Amp, 
									bra.getToBus().getBaseVoltage(), faultNet.getBaseKva());
							beanTo2From.setBranchFaultAmpsApu(Num2Str.toStr("###0.##", cpu.a_0.abs()));
							beanTo2From.setBranchFaultAmpsA(Num2Str.toStr("######0.#", camp.a_0.abs()));		
							beanTo2From.setBranchFaultAmpsBpu(Num2Str.toStr("###0.##", cpu.b_1.abs()));
							beanTo2From.setBranchFaultAmpsB(Num2Str.toStr("######0.#", camp.b_1.abs()));		
							beanTo2From.setBranchFaultAmpsCpu(Num2Str.toStr("###0.##", cpu.c_2.abs()));
							beanTo2From.setBranchFaultAmpsC(Num2Str.toStr("######0.#", camp.c_2.abs()));		
						} catch (Exception e) {
							IpssLogger.logErr(e);
						}
						list.add(beanFrom2To);
						list.add(beanTo2From);
					}
				}
			}
	  	} catch (Exception e) {
	  		IpssLogger.logErr(e);
	  		return null;
	  	}		
		return list.toArray();
	}	
	
}