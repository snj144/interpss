 /*
  * @(#)PSSEV30GenDataRec.java   
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

package org.ieee.pes.odm.pss.adapter.psse.v30.impl;

import java.util.StringTokenizer;
import java.util.logging.Logger;

import org.ieee.pes.odm.pss.adapter.psse.v30.PSSEV30Adapter.VersionNo;

public class PSSEV30GenDataRec {
	/*
	 * GenData
	 * I,ID,PG,QG,QT,QB,VS,IREG,MBASE,ZR,ZX,RT,XT,GTAP,STAT,RMPCT,PT,PB,O1,F1,...,O4,F4
	 * 
	 * The standard generator boundary condition is a specification of real
	 * power output at the high-voltage bus, bus k, and of voltage magnitude at
	 * some designated bus, not necessarily bus k.
	 */

	public static void procLine(String lineStr, VersionNo version, Logger logger) {
		int i, ireg, stat ;
		String id;
		double pg, qg, qt, qb, vs, mbase, zr, zx, rt, xt, gtap, rmpct, pt, pb;
		int o1 = 0, o2 = 0, o3 = 0, o4 = 0;
		double f1 = 0.0, f2 = 0.0, f3 = 0.0, f4 = 0.0;

		StringTokenizer st;

		st = new StringTokenizer(lineStr, ",");
		i = new Integer(st.nextToken().trim()).intValue();
		id = st.nextToken().trim();

		pg = new Double(st.nextToken().trim()).doubleValue();
		qg = new Double(st.nextToken().trim()).doubleValue();
		
		qt = new Double(st.nextToken().trim()).doubleValue();
		qb = new Double(st.nextToken().trim()).doubleValue();
		if (qt < qb) {
			logger.warning("Gen Data qt (qMax: " + qt + ") < qb (qMin:" + qb + "), \n" + lineStr);
		}
		vs = new Double(st.nextToken().trim()).doubleValue();
		ireg = new Integer(st.nextToken().trim()).intValue();
		mbase = new Double(st.nextToken().trim()).doubleValue();
		zr = new Double(st.nextToken().trim()).doubleValue();
		zx = new Double(st.nextToken().trim()).doubleValue();
		rt = new Double(st.nextToken().trim()).doubleValue();
		xt = new Double(st.nextToken().trim()).doubleValue();
		gtap = new Double(st.nextToken().trim()).doubleValue();
		stat = new Integer(st.nextToken().trim()).intValue();
		rmpct = new Double(st.nextToken().trim()).doubleValue();
		
		pt = new Double(st.nextToken().trim()).doubleValue();
		pb = new Double(st.nextToken().trim()).doubleValue();
		if (pt < pb) {
			logger.warning("Gen Data pt (pMax:" + pt + ") < pb (pMin:" + pb + "), \n" + lineStr);
		}

		if (st.hasMoreTokens())
			o1 = new Integer(st.nextToken().trim()).intValue();
		if (st.hasMoreTokens())
			f1 = new Double(st.nextToken().trim()).doubleValue();
		if (st.hasMoreTokens())
			o2 = new Integer(st.nextToken().trim()).intValue();
		if (st.hasMoreTokens())
			f2 = new Double(st.nextToken().trim()).doubleValue();
		if (st.hasMoreTokens())
			o3 = new Integer(st.nextToken().trim()).intValue();
		if (st.hasMoreTokens())
			f3 = new Double(st.nextToken().trim()).doubleValue();
		if (st.hasMoreTokens())
			o4 = new Integer(st.nextToken().trim()).intValue();
		if (st.hasMoreTokens())
			f4 = new Double(st.nextToken().trim()).doubleValue();

/*
		I,ID,PG,QG,QT,QB,VS,IREG,MBASE,ZR,ZX,RT,XT,GTAP,STAT,RMPCT,PT,PB,O1,F1,...,O4,F4

		The standard generator boundary condition is a specification of real power output at the
		high-voltage bus, bus k, and of voltage magnitude at some designated bus, not necessarily bus k.
		
		STAT - Initial machine status of one for in-service and zero for out-of-service; STAT = 1 by default.
*/		
		/*
		String iStr = new Integer(this.i).toString();
		AclfBus bus = adjNet.getAclfBus(iStr);
		if (bus == null) {
			throw new Exception ("Bus not found in the network, bus number: " + this.i);
		}
		
		PSSEAclfGen gen = ExtensionObjectFactory.createPSSEAclfGen();
		gen.setId(this.id);
		gen.setName("Gen:" + this.id + "(" + this.i + ")");
		gen.setDesc("PSSE Generator " + this.id + " at Bus " + this.i);
		gen.setStatus(this.stat==1);

		gen.setPGen(UnitType.pConversion(this.pg, adjNet.getBaseKva(), UnitType.mW, UnitType.PU));
		gen.setQGen(UnitType.pConversion(this.qg, adjNet.getBaseKva(), UnitType.mVar, UnitType.PU));
		gen.setVSpec(this.vs);
		
		if (this.pt == 0.0 & this.pb == 0.0 || this.pt < this.pb ) {
			this.pt = 9999.0; this.pb = -9999.0;
		}
		gen.setPLimit(new LimitType(UnitType.pConversion(this.pt, adjNet.getBaseKva(), UnitType.mW, UnitType.PU),
				                    UnitType.pConversion(this.pb, adjNet.getBaseKva(), UnitType.mW, UnitType.PU)));
		if (this.qt == 0.0 & this.qb == 0.0 || this.qt < this.qb) {
			this.qt = 9999.0; this.qb = -9999.0;
		}
		gen.setQLimit(new LimitType(UnitType.pConversion(this.qt, adjNet.getBaseKva(), UnitType.mVar, UnitType.PU),
                                    UnitType.pConversion(this.qb, adjNet.getBaseKva(), UnitType.mVar, UnitType.PU)));
		
		gen.setVControlBusId(new Integer(this.ireg).toString());
		
		gen.setMvaBase(this.mbase);
		gen.setZGen(new Complex(this.zr,this.zx));
		gen.setZXfr(new Complex(this.rt,this.xt));
		gen.setXfrTap(this.gtap);
		gen.setContribFactor(this.rmpct*0.01);

		gen.getOwnerList().add(ExtensionObjectFactory.createPSSEOwner(this.o1, this.f1));
		gen.getOwnerList().add(ExtensionObjectFactory.createPSSEOwner(this.o2, this.f2));
		gen.getOwnerList().add(ExtensionObjectFactory.createPSSEOwner(this.o3, this.f3));
		gen.getOwnerList().add(ExtensionObjectFactory.createPSSEOwner(this.o4, this.f4));
		
		bus.getRegDeviceList().add(gen);
		*/
	}			
}
