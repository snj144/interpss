 /*
  * @(#)BusDataRecord.java   
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

package org.interpss.custom.exchange.psse;

import org.apache.commons.math.complex.Complex;
import org.interpss.custom.exchange.psse.aclf.PSSEGen;
import org.interpss.custom.exchange.psse.aclf.PSSELoad;

import com.interpss.common.datatype.LimitType;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.XmlUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfGenCode;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.aclfadj.AclfAdjNetwork;

public class PSSEBusDataRecord {
	/** 
	 * Process bus record lines
	 *
	 * @param adjNet the AclfAdjNetwork object
	 * @param lineStr a input line string
	 * @param lineNo the line number
	 * @param msgHub the message hub object
	 */
	public static void processBus(
				AclfAdjNetwork adjNet, 
				String lineStr,
				int lineNo, 
				PSSEDataRec.VersionNo version,
				IPSSMsgHub msg) throws Exception {
/*
		Format: I,    ’NAME’,    BASKV, IDE,  GL,      BL,  AREA, ZONE, VM, VA, OWNER
*/
		PSSEDataRec.BusRec rec = new PSSEDataRec.BusRec(lineStr, version);
		
    	int I = new Integer(rec.i).intValue();
    	String NAME = PSSEUtilFunc.trimQuote(rec.name);
		double BASKV = new Double(rec.baseKv).doubleValue();
		int IDE = new Integer(rec.ide).intValue();
		
		double GL = new Double(rec.gl).doubleValue();
		double BL = new Double(rec.bl).doubleValue();
		int AREA = new Integer(rec.area).intValue();
		int ZONE = new Integer(rec.zone).intValue();
		double VM = new Double(rec.vm).doubleValue();
		double VA = new Double(rec.va).doubleValue();
		int OWNER = new Integer(rec.owner).intValue();
		
		IpssLogger.getLogger().fine("Bus data Line:" + lineNo + "-->" + lineStr);
		IpssLogger.getLogger().fine("Bus number, type, name:" + I + ", " + IDE + ", '" + NAME + "'");
		IpssLogger.getLogger().fine("Area, Zone:" + AREA + ", " + ZONE);
		IpssLogger.getLogger().fine("baseKV, Vm, Va:" + BASKV + ", " + VM + ", " + VA);
		IpssLogger.getLogger().fine("Pl, Ql, OWNER:" + GL + ", " + BL + ", " + OWNER);

		String iStr = new Integer(I).toString();
		final AclfBus bus = CoreObjectFactory.createAclfBus(iStr, AREA, ZONE, new Integer(OWNER).toString(), adjNet);
      	bus.setName(NAME);
    	bus.setBaseVoltage(BASKV, UnitType.kV);
    	double factor = 1000.0/adjNet.getBaseKva();  // for transfer G+jB to PU on system base 
    	bus.setShuntY(new Complex(GL*factor,BL*factor));
      	
    	// add the bus object into the network container
    	adjNet.addBus(bus);

    	// set input data to the bus object
      	if ( IDE == 3 ) {
      		// Swing bus
   		 	bus.setGenCode(AclfGenCode.SWING);
    		bus.setLoadCode(AclfLoadCode.NON_LOAD);
  			final SwingBusAdapter gen = (SwingBusAdapter)bus.adapt(SwingBusAdapter.class);
  			gen.setVoltMag(VM, UnitType.PU);
  			gen.setVoltAng(VA, UnitType.Deg);
    	}
    	else if ( IDE == 2 ) {
    		// Gen bus, we first set it to a PQ bus. It will be adjusted in the 
    		// Generator data section.
    		bus.setGenCode(AclfGenCode.GEN_PV);
    		bus.setLoadCode(AclfLoadCode.NON_LOAD);
    	}
    	else if ( IDE == 1 ) {
    		// Non-gen load bus
   		 	bus.setGenCode(AclfGenCode.NON_GEN);
    		bus.setLoadCode(AclfLoadCode.NON_LOAD);
    	}
    	else {
    		// Isolated bus, an isolated bus will not participate in Loadflow calculaiton
    		bus.setGenCode(AclfGenCode.NON_GEN);
    		bus.setLoadCode(AclfLoadCode.NON_LOAD);
    		bus.setStatus(false);
    	}
	}			
	
	/** 
	 * Process load data record lines
	 *
	 * @param adjNet the AclfAdjNetwork object
	 * @param lineStr a input line string
	 * @param lineNo the line number
	 * @param msgHub the message hub object
	 */
	public static void processLoad(
				AclfAdjNetwork adjNet, 
				String lineStr,
				int lineNo, 
				PSSEDataRec.VersionNo version,
				IPSSMsgHub msg) throws Exception {
/*
		I, ID, STATUS, AREA, ZONE, PL, QL, IP, IQ, YP, YQ, OWNER
*/		
		PSSEDataRec.LoadRec rec = new PSSEDataRec.LoadRec(lineStr, version);

		int I = new Integer(rec.i).intValue();
		String ID = PSSEUtilFunc.trimQuote(rec.id);
		int STATUS = new Integer(rec.status).intValue();
		int AREA = new Integer(rec.area).intValue();
		int ZONE = new Integer(rec.zone).intValue();
		double PL = new Double(rec.pl).doubleValue();
		double QL = new Double(rec.ql).doubleValue();
		double IP = new Double(rec.ip).doubleValue();
		double IQ = new Double(rec.iq).doubleValue();
		double YP = new Double(rec.yp).doubleValue();
		double YQ = new Double(rec.yq).doubleValue();
		int OWNER = new Integer(rec.owner).intValue();

		IpssLogger.getLogger().fine("Load data Line:" + lineNo + "-->" + lineStr);
		IpssLogger.getLogger().fine("Bus number, id, status, area, zone:" + I + ", " + ID + ", " + STATUS + ", " + AREA + ", " + ZONE);
		IpssLogger.getLogger().fine("PL, QL, IP, iQ, YP, YQ, OWNER:" + PL + ", " + QL + ", " + IP + ", " + IQ + ", " + YP + ", " + YQ + ", " + OWNER);
		
		String iStr = new Integer(I).toString();
		AclfBus bus = adjNet.getAclfBus(iStr);
		if (bus == null) {
			throw new Exception ("Bus not found in the network, bus number: " + I);
		}
		
		PSSELoad load = new PSSELoad();
		load.setId(ID);
		load.setName("Load:" + ID + "(" + I + ")");
		load.setDesc("PSSE Load " + ID + " at Bus " + I);
		load.setStatus(STATUS==1);
		load.setAreaNo(ZONE);
		load.setZoneNo(ZONE);
		load.setOwnerNo(OWNER);
		
		double baseMva = adjNet.getBaseKva() / 1000.0;
		load.setConstPLoad(new Complex(PL/baseMva,QL/baseMva));
		load.setConstILoad(new Complex(IP/baseMva,IQ/baseMva));
		load.setConstZLoad(new Complex(YP/baseMva,YQ/baseMva));

		bus.getRegDeviceList().add(load);
		
		IpssLogger.getLogger().fine("PSSELoad: " + XmlUtil.toXmlString(load));
	}			

	/** 
	 * Process generator record lines
	 *
	 * @param adjNet the AclfAdjNetwork object
	 * @param lineStr a input line string
	 * @param lineNo the line number
	 * @param msgHub the message hub object
	 */
	public static void processGen(
				AclfAdjNetwork adjNet, 
				String lineStr,
				int lineNo, 
				PSSEDataRec.VersionNo version,
				IPSSMsgHub msg) throws Exception {
/*
		I,ID,PG,QG,QT,QB,VS,IREG,MBASE,ZR,ZX,RT,XT,GTAP,STAT,RMPCT,PT,PB,O1,F1,...,O4,F4

		The standard generator boundary condition is a specification of real power output at the
		high-voltage bus, bus k, and of voltage magnitude at some designated bus, not necessarily bus k.
*/		
		PSSEDataRec.GenRec rec = new PSSEDataRec.GenRec(lineStr, version);
  			
		int I = new Integer(rec.i).intValue();
		String ID = PSSEUtilFunc.trimQuote(rec.id);
		double PG = new Double(rec.pg).doubleValue();
		double QG = new Double(rec.qg).doubleValue();
		double QT = new Double(rec.qt).doubleValue();
		double QB = new Double(rec.qb).doubleValue();
		double VS = new Double(rec.vs).doubleValue();
		int IREG = new Integer(rec.ireg).intValue();
		double MBASE = new Double(rec.mbase).doubleValue();
		double ZR = new Double(rec.zr).doubleValue();
		double ZX = new Double(rec.zx).doubleValue();
		double RT = new Double(rec.rt).doubleValue();
		double XT = new Double(rec.xt).doubleValue();
		double GTAP = new Double(rec.gtap).doubleValue();
		int STAT = new Integer(rec.stat).intValue();
		double RMPCT = new Double(rec.rmpact).doubleValue();
		double PT = new Double(rec.pt).doubleValue();
		double PB = new Double(rec.pb).doubleValue();

		int O1 = new Integer(rec.o1).intValue();
		double F1 = new Double(rec.f1).doubleValue();
		int O2 = new Integer(rec.o2).intValue();
		double F2 = new Double(rec.f2).doubleValue();
		int O3 = new Integer(rec.o3).intValue();
		double F3 = new Double(rec.f3).doubleValue();
		int O4 = new Integer(rec.o4).intValue();
		double F4 = new Double(rec.f4).doubleValue();

		IpssLogger.getLogger().fine("Gen data Line:" + lineNo + "-->" + lineStr);
		IpssLogger.getLogger().fine("Bus number, GenId:" + I + ", " + ID);
		IpssLogger.getLogger().fine("PG, QG, Qmax, Qmin, Vspec:" + PG + ", " + QG + ", " + QT + ", " + QB + ", " + VS);
		IpssLogger.getLogger().fine("Ireg, MvaBase, Zr, Zx, Rt, Xt:" + IREG + ", " + MBASE + ", " + ZR + ", " + ZX + ", " + RT + ", " + XT);
		IpssLogger.getLogger().fine("Gtap, RegMar%, Pmax, Pmin:" + GTAP + ", " + STAT + ", " + RMPCT + ", " + PT + ", " + PB);
		IpssLogger.getLogger().fine("O1, F1, O2, F2, O3, F3, O4, F4:" + O1 + ", " + F1 + ", " + O2 + ", " + F2  + ", " + O3 + ", " + F3 + ", " + O4 + ", " + F4);
		
		String iStr = new Integer(I).toString();
		AclfBus bus = adjNet.getAclfBus(iStr);
		if (bus == null) {
			throw new Exception ("Bus not found in the network, bus number: " + I);
		}
		PSSEGen gen = new PSSEGen();
		gen.setId(ID);
		gen.setName("Gen:" + ID + "(" + I + ")");
		gen.setDesc("PSSE Generator " + ID + " at Bus " + I);
		gen.setStatus(STAT==1);

		gen.setPGen(UnitType.pConversion(PG, adjNet.getBaseKva(), UnitType.mW, UnitType.PU));
		gen.setQGen(UnitType.pConversion(QG, adjNet.getBaseKva(), UnitType.mVar, UnitType.PU));
		gen.setVSpec(VS);
		
		gen.setPLimit(new LimitType(UnitType.pConversion(PT, adjNet.getBaseKva(), UnitType.mW, UnitType.PU),
				                    UnitType.pConversion(PB, adjNet.getBaseKva(), UnitType.mW, UnitType.PU)));
		gen.setQLimit(new LimitType(UnitType.pConversion(QT, adjNet.getBaseKva(), UnitType.mVar, UnitType.PU),
                                    UnitType.pConversion(QB, adjNet.getBaseKva(), UnitType.mVar, UnitType.PU)));
		
		gen.setVControlBusId(new Integer(IREG).toString());
		
		gen.setMvaBase(MBASE);
		gen.setZGen(new Complex(ZR,ZX));
		gen.setZXfr(new Complex(RT,XT));
		gen.setXfrTap(GTAP);
		gen.setContribFactor(RMPCT*0.01);

		gen.getOwnerRec(0).setOwnerNumber(O1);
		gen.getOwnerRec(0).setOwnershipFactor(F1);
		gen.getOwnerRec(1).setOwnerNumber(O2);
		gen.getOwnerRec(1).setOwnershipFactor(F2);
		gen.getOwnerRec(2).setOwnerNumber(O3);
		gen.getOwnerRec(2).setOwnershipFactor(F3);
		gen.getOwnerRec(3).setOwnerNumber(O4);
		gen.getOwnerRec(3).setOwnershipFactor(F4);
		
		bus.getRegDeviceList().add(gen);
		
		IpssLogger.getLogger().fine("PSSEGen: " + XmlUtil.toXmlString(gen));	
	}			
}