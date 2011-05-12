 /*
  * @(#)AclfResultMapperImpl.java   
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

import org.apache.commons.math.complex.Complex;
import org.interpss.report.bean.aclf.RptAclfBusStyleBean;
import org.interpss.report.bean.aclf.RptAclfMaxMismatchBean;
import org.interpss.report.bean.aclf.RptAclfSummaryBusBean;
import org.interpss.report.bean.aclf.RptFuncLoadBean;
import org.interpss.report.bean.aclf.RptPQLimitBean;
import org.interpss.report.bean.aclf.RptPSXfrPControlBean;
import org.interpss.report.bean.aclf.RptPVLimitBean;
import org.interpss.report.bean.aclf.RptRemoteQBusBean;
import org.interpss.report.bean.aclf.RptTapVControlBean;

import com.interpss.common.datatype.UnitType;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.Num2Str;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclf.CapacitorBusAdapter;
import com.interpss.core.aclf.GenBusAdapter;
import com.interpss.core.aclf.PSXfrAdapter;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.aclfadj.FunctionLoad;
import com.interpss.core.aclfadj.PQBusLimit;
import com.interpss.core.aclfadj.PSXfrPControl;
import com.interpss.core.aclfadj.PVBusLimit;
import com.interpss.core.aclfadj.RemoteQBus;
import com.interpss.core.aclfadj.RemoteQControlType;
import com.interpss.core.aclfadj.TapControl;
import com.interpss.core.aclfadj.XfrTapControlType;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.datatype.Mismatch;

public class AclfResultMapperImpl {
	public static void mapAclfMaxMismatch(AclfNetwork net, RptAclfMaxMismatchBean bean) {
		double baseKVA = net.getBaseKva();
		Mismatch mis = net.maxMismatch(AclfMethod.NR_LITERAL);
		bean.setPMaxBusId(mis.maxPBus.getId());
		bean.setPMaxPu(Num2Str.toStr( "####0.000000",mis.maxMis.getReal()));
		bean.setPMaxKva(Num2Str.toStr( "####0.000", baseKVA*mis.maxMis.getReal()));
		bean.setQMaxBusId(mis.maxQBus.getId());
		bean.setQMaxPu(Num2Str.toStr( "####0.000000",mis.maxMis.getImaginary()));
		bean.setQMaxKva(Num2Str.toStr( "####0.000", baseKVA*mis.maxMis.getImaginary()));			
	}
	
	public static Object[] createAclfSummaryBusBeanArray(AclfNetwork net) {
		List<RptAclfSummaryBusBean> list = new ArrayList<RptAclfSummaryBusBean>();
	  	try {
		  	double baseKVA = net.getBaseKva();
			for( Iterator itr = net.getBusList().iterator(); itr.hasNext();) {
				AclfBus bus = (AclfBus)itr.next();
				GenBusAdapter genBus = (GenBusAdapter)bus.adapt(GenBusAdapter.class);
				Complex busPQ = genBus.getGenResults(UnitType.PU, baseKVA).subtract(genBus.getLoadResults(UnitType.PU, baseKVA));
				if ( bus.isCapacitor() ) {
					CapacitorBusAdapter cap = (CapacitorBusAdapter)bus.adapt(CapacitorBusAdapter.class);
					busPQ = busPQ.add(new Complex(0.0, cap.getQResults(bus.getVoltageMag(), UnitType.PU, baseKVA)));				
				}
				RptAclfSummaryBusBean bean = new RptAclfSummaryBusBean();
				bean.setBusId(new String(bus.getId()));
				bean.setBusCode(Num2Str.toStr(-13, bus.code2String() ));
				bean.setBusVolt(Num2Str.toStr("####0.0000", bus.getVoltageMag(UnitType.PU)));
				bean.setBusAngle(Num2Str.toStr("####0.00", bus.getVoltageAng(UnitType.Deg)));
				bean.setBusP(Num2Str.toStr("####0.0000", busPQ.getReal()));
				bean.setBusQ(Num2Str.toStr("####0.0000", busPQ.getImaginary()));
				list.add(bean); 
			}
	  	} catch (Exception e) {
	  		IpssLogger.logErr(e);
	  		return null;
	  	}		
		return list.toArray();
	}	
	
	public static Object[] createAclfBusStyleBeanArray(AclfNetwork net) {
		List<RptAclfBusStyleBean> list = new ArrayList<RptAclfBusStyleBean>();
	  	try {
		  	double baseKVA = net.getBaseKva();
			for( Iterator itr = net.getBusList().iterator(); itr.hasNext();) {
				AclfBus bus = (AclfBus)itr.next();
				GenBusAdapter genBus = (GenBusAdapter)bus.adapt(GenBusAdapter.class);
				Complex busGen = genBus.getGenResults(UnitType.mVA, baseKVA);
				Complex busLoad = genBus.getLoadResults(UnitType.mVA, baseKVA);
				if ( bus.isCapacitor() ) {
					CapacitorBusAdapter cap = (CapacitorBusAdapter)bus.adapt(CapacitorBusAdapter.class);
					busGen = busGen.add(new Complex(0.0, cap.getQResults(bus.getVoltageMag(), UnitType.PU, baseKVA)));				
				}
				RptAclfBusStyleBean bean = new RptAclfBusStyleBean();
				bean.setBusId(bus.getId());
				bean.setBaseVolt(Num2Str.toStr( "#######0", bus.getBaseVoltage()));
				bean.setVoltMsg(Num2Str.toStr( "0.0000", bus.getVoltageMag(UnitType.PU)));
				bean.setVoltAng(Num2Str.toStr( "##0.0", bus.getVoltageAng(UnitType.Deg)));
				bean.setPGen(Num2Str.toStr( "####0.00", busGen.getReal()));
				bean.setQGen(Num2Str.toStr( "####0.00", busGen.getImaginary()));
				bean.setPLoad(Num2Str.toStr( "####0.00", busLoad.getReal()));
				bean.setQLoad(Num2Str.toStr( "####0.00", busLoad.getImaginary()));
				
				Iterator eb = bus.getBranchList().iterator();
				int cnt = 0;
				while (eb.hasNext()) {
					AclfBranch bra = (AclfBranch) eb.next();
					AclfBus busj;
					if ( bus.equals(bra.getFromAclfBus()) )
						busj = bra.getToAclfBus();
					else
						busj = bra.getFromAclfBus();

					Complex pq = new Complex(0.0,0.0);
					double  amp = 0.0, fromRatio = 1.0, toRatio = 1.0;
					if (bra.isActive()) {
						if ( bus.equals(bra.getFromAclfBus()) ) {
							pq  = bra.powerFrom2To(UnitType.mVA, baseKVA);
							amp = UnitType.iConversion(bra.current(UnitType.PU, baseKVA),
								         bra.getFromAclfBus().getBaseVoltage(),
								         baseKVA, UnitType.PU, UnitType.Amp );
							if (bra.isXfr() || bra.isPSXfr()) {
								fromRatio = bra.getFromTurnRatio();
								toRatio = bra.getToTurnRatio();
							}	
						}
						else {
							pq   = bra.powerTo2From(UnitType.mVA, baseKVA);
							amp  = UnitType.iConversion( bra.current(UnitType.PU, baseKVA),
								         bra.getToAclfBus().getBaseVoltage(),
								         baseKVA, UnitType.PU, UnitType.Amp );
							if (bra.isXfr() || bra.isPSXfr()) {
								toRatio = bra.getFromTurnRatio();
								fromRatio = bra.getToTurnRatio();
							}	
						}
					}
					if (cnt++ > 0) {
						bean = new RptAclfBusStyleBean();
						bean.setBusId("");
						bean.setBaseVolt("");
						bean.setVoltMsg("");
						bean.setVoltAng("");
						bean.setPGen("");
						bean.setQGen("");
						bean.setPLoad("");
						bean.setQLoad("");
					}  
					bean.setToBusId(busj.getId());
					bean.setBranchP(Num2Str.toStr( "####0.00", pq.getReal() ));
					bean.setBranchQ(Num2Str.toStr( "####0.00", pq.getImaginary()));
					bean.setBranchKA(Num2Str.toStr( "##0.0##", 0.001*amp));
					bean.setXfrRatioFrom("");
					bean.setXfrRatioTo("");
					bean.setPsXfrAngle("");
					if (bra.isXfr() || bra.isPSXfr()) {
						if (fromRatio != 1.0)
							bean.setXfrRatioFrom(Num2Str.toStr( "0.0###", fromRatio ));

						if (toRatio != 1.0)
							bean.setXfrRatioTo(Num2Str.toStr( "0.0###", toRatio ));

						if (bra.isPSXfr()) {
							PSXfrAdapter psXfr = (PSXfrAdapter)bra.adapt(PSXfrAdapter.class);
							bean.setPsXfrAngle(Num2Str.toStr( "##0.0", psXfr.getFromAngle(UnitType.Deg)));
						}	
					}
					list.add(bean);
				}  // while ...
			}
	  	} catch (Exception e) {
	  		IpssLogger.logErr(e);
	  		return null;
	  	}			
		return list.toArray();
	}
	
	public static Object[] createPVBusLimitBeanArray(AclfAdjNetwork net) {
		List<RptPVLimitBean> list = new ArrayList<RptPVLimitBean>();
	  	double baseKva = net.getBaseKva();
		for( Iterator itr = net.getPvBusLimitList().iterator(); itr.hasNext();) {
			PVBusLimit pv = (PVBusLimit)itr.next();
			GenBusAdapter genBus = (GenBusAdapter)pv.getAclfBus().adapt(GenBusAdapter.class);
			RptPVLimitBean bean = new RptPVLimitBean();
			bean.setBusId(Num2Str.toStr(-8, pv.getAclfBus().getId()));
			bean.setVact(Num2Str.toStr( "###0.0000", pv.getAclfBus().getVoltageMag(UnitType.PU)));
			bean.setVspec(Num2Str.toStr( "###0.0000", pv.getVSpecified(UnitType.PU) ));
			bean.setQ(Num2Str.toStr( "#####0.00", genBus.getGenResults(UnitType.PU,baseKva).getImaginary() ));
			bean.setQmax(Num2Str.toStr( "#####0.00", pv.getQLimit(UnitType.PU,baseKva).getMax() ));
			bean.setQmin(Num2Str.toStr( "#####0.00", pv.getQLimit(UnitType.PU,baseKva).getMin() ));
			bean.setStatus(Num2Str.toStr(6, pv.isActive() ? "on" : "off" ) + "\n");
			list.add(bean); 
		}
		return list.toArray();
	}	

	public static Object[] createPQBusLimitBeanArray(AclfAdjNetwork net) {
		List<RptPQLimitBean> list = new ArrayList<RptPQLimitBean>();
	  	double baseKva = net.getBaseKva();
		for( Iterator itr = net.getPqBusLimitList().iterator(); itr.hasNext();) {
			PQBusLimit pq = (PQBusLimit)itr.next();
			GenBusAdapter genBus = (GenBusAdapter)pq.getAclfBus().adapt(GenBusAdapter.class);
			RptPQLimitBean bean = new RptPQLimitBean();
			bean.setBusId(Num2Str.toStr(-8, pq.getAclfBus().getId()));
			bean.setQact(Num2Str.toStr("####0.00",genBus.getGenResults(UnitType.PU,baseKva).getImaginary()));
			bean.setQspec(Num2Str.toStr("####0.00",pq.getQSpecified(UnitType.PU,baseKva)));
			bean.setV(Num2Str.toStr("##0.0000",pq.getAclfBus().getVoltageMag(UnitType.PU)));
			bean.setVmax(Num2Str.toStr("##0.0000",pq.getVLimit(UnitType.PU).getMax()));
			bean.setVmin(Num2Str.toStr("##0.0000",pq.getVLimit(UnitType.PU).getMin()));
			bean.setStatus(Num2Str.toStr(5, pq.isActive() ? "on" : "off" ));
			list.add(bean); 
		}
		return list.toArray();
	}

	public static Object[] createFunctionLoadBeanArray(AclfAdjNetwork net) {
		List<RptFuncLoadBean> list = new ArrayList<RptFuncLoadBean>();
	  	double baseKva = net.getBaseKva();
		for( Iterator itr = net.getFunctionLoadList().iterator(); itr.hasNext();) {
			FunctionLoad fload = (FunctionLoad)itr.next();
		  	double vpu = fload.getAclfBus().getVoltage().abs();
			RptFuncLoadBean bean = new RptFuncLoadBean();
			bean.setBusId(fload.getAclfBus().getId());
			bean.setPact(Num2Str.toStr("##0.0000",fload.getP().getLoad(vpu,UnitType.PU,baseKva)));
			bean.setQact(Num2Str.toStr("##0.0000",fload.getQ().getLoad(vpu,UnitType.PU,baseKva)));
			bean.setV(Num2Str.toStr("##0.0000",fload.getAclfBus().getVoltageMag(UnitType.PU)));
			bean.setP0(Num2Str.toStr("##0.0000",fload.getP().getLoad0(UnitType.PU,baseKva)));
			bean.setQ0(Num2Str.toStr("##0.0000",fload.getQ().getLoad0(UnitType.PU,baseKva)));
			bean.setStatus(Num2Str.toStr(5, fload.isActive() ? "on" : "off" ));
			list.add(bean); 
		}
		return list.toArray();
	}

	public static Object[] createRemoteQBusBeanArray(AclfAdjNetwork net) {
		List<RptRemoteQBusBean> list = new ArrayList<RptRemoteQBusBean>();
	  	double baseKva = net.getBaseKva();
		for( Iterator itr = net.getRemoteQBusList().iterator(); itr.hasNext();) {
			RemoteQBus re = (RemoteQBus)itr.next();
			GenBusAdapter genBus = (GenBusAdapter)re.getAclfBus().adapt(GenBusAdapter.class);
			RptRemoteQBusBean bean = new RptRemoteQBusBean();
			bean.setVcBusId(re.getAclfBus().getId());
			bean.setType(Num2Str.toStr(-9, (re.getControlType()==RemoteQControlType.BUS_VOLTAGE_LITERAL?
					 				" Voltage":"MvarFlow")));
			bean.setReQBusBranch(Num2Str.toStr(15, re.getControlType()==RemoteQControlType.BUS_VOLTAGE_LITERAL?
									re.getRemoteBus().getId():re.getRemoteBranch().getId()));
			bean.setActual(Num2Str.toStr( "###0.0000", re.getControlType()==RemoteQControlType.BUS_VOLTAGE_LITERAL?
					re.getRemoteBus().getVoltageMag(UnitType.PU): 
						re.getMvarFlowCalculated(re.getRemoteBranch(), UnitType.PU, baseKva) ));
			bean.setSpec(Num2Str.toStr( "###0.0000", re.getVSpecified(UnitType.PU) ));
			bean.setQ(Num2Str.toStr( "#####0.00", genBus.getGenResults(UnitType.PU,baseKva).getImaginary()));
			bean.setQmax(Num2Str.toStr( "#####0.00", re.getQLimit(UnitType.PU,baseKva).getMax() ));
			bean.setQmin(Num2Str.toStr( "#####0.00", re.getQLimit(UnitType.PU,baseKva).getMin()));
			bean.setStatus(Num2Str.toStr(6, re.isActive() ? "on" : "off" ));
			list.add(bean); 
		}
		return list.toArray();
	}

	public static Object[] createPSXfrPControlBeanArray(AclfAdjNetwork net) {
		List<RptPSXfrPControlBean> list = new ArrayList<RptPSXfrPControlBean>();
	  	double baseKva = net.getBaseKva();
		for( Iterator itr = net.getPsXfrPControlList().iterator(); itr.hasNext();) {
			PSXfrPControl psCtrl = (PSXfrPControl)itr.next();
			RptPSXfrPControlBean bean = new RptPSXfrPControlBean();
			bean.setBranchId(psCtrl.getAclfBranch().getId());
			bean.setPact(Num2Str.toStr("##0.0000", (psCtrl.isControlOnFromSide()?
							psCtrl.getAclfBranch().powerFrom2To(UnitType.PU,baseKva).getReal() :
								psCtrl.getAclfBranch().powerTo2From(UnitType.PU,baseKva).getReal())));
			bean.setPspec(Num2Str.toStr("##0.0000", psCtrl.getPSpecified(UnitType.PU,baseKva)));
			PSXfrAdapter psXfr = (PSXfrAdapter)psCtrl.getAclfBranch().adapt(PSXfrAdapter.class);
			bean.setAngle(Num2Str.toStr("#0.00", psXfr.getFromAngle(UnitType.Deg)));
			bean.setAngMax(Num2Str.toStr("#0.00", psCtrl.getAngLimit(UnitType.Deg).getMax()));
			bean.setAngMin(Num2Str.toStr("#0.00", psCtrl.getAngLimit(UnitType.Deg).getMin()));
			bean.setStatus(Num2Str.toStr(6, psCtrl.isActive() ? "on" : "off" ));
			list.add(bean); 
		}
		return list.toArray();
	}

	public static Object[] createTapVControlBeanArray(AclfAdjNetwork net) {
		List<RptTapVControlBean> list = new ArrayList<RptTapVControlBean>();
	  	double baseKva = net.getBaseKva();
		for( Iterator itr = net.getTapControlList().iterator(); itr.hasNext();) {
			TapControl tap = (TapControl)itr.next();
			RptTapVControlBean bean = new RptTapVControlBean();
			bean.setBranchId(tap.getAclfBranch().getId());
			if (tap.getControlType() == XfrTapControlType.BUS_VOLTAGE_LITERAL) {
				bean.setVcBusId(tap.getVcBus().getId());
				bean.setActual(Num2Str.toStr("##0.0000", tap.getVcBus().getVoltageMag(UnitType.PU)));
				bean.setSpec(Num2Str.toStr("##0.0000", tap.getVSpecified(UnitType.PU)));
			}
			else {
				bean.setVcBusId(Num2Str.toStr(-8, " "));
				bean.setActual(Num2Str.toStr("##0.0000", tap.getMvarFlowCalculated(UnitType.PU,baseKva)));
				bean.setSpec(Num2Str.toStr("##0.0000", tap.getMvarSpecified(UnitType.PU,baseKva)));
			}
			bean.setTap(Num2Str.toStr("0.000", (tap.isControlOnFromSide()? tap.getAclfBranch().getFromTurnRatio() :
												tap.getAclfBranch().getToTurnRatio())));
			bean.setTapMax(Num2Str.toStr("0.000", tap.getTapLimit().getMax()));
			bean.setTapMin(Num2Str.toStr("0.000", tap.getTapLimit().getMin()));
			bean.setStepSize(Num2Str.toStr("####0", tap.getTapStepSize()));
			bean.setStatus(Num2Str.toStr(6, tap.isActive() ? "on" : "off" ));
			list.add(bean); 
		}
		return list.toArray();
	}
}