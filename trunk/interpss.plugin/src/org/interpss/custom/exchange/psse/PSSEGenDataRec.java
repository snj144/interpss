 /*
  * @(#)PSSEGenDataRec.java   
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

import java.util.StringTokenizer;

import org.apache.commons.math.complex.Complex;
import org.interpss.custom.exchange.psse.PSSEDataRec.VersionNo;

import com.interpss.common.datatype.LimitType;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.ext.ExtensionObjectFactory;
import com.interpss.ext.psse.aclf.PSSEAclfGen;

public class PSSEGenDataRec {
	/*
	 * GenData
	 * I,ID,PG,QG,QT,QB,VS,IREG,MBASE,ZR,ZX,RT,XT,GTAP,STAT,RMPCT,PT,PB,O1,F1,...,O4,F4
	 * 
	 * The standard generator boundary condition is a specification of real
	 * power output at the high-voltage bus, bus k, and of voltage magnitude at
	 * some designated bus, not necessarily bus k.
	 */
	private int i, ireg, stat ;
	private String id;
	private double pg, qg, qt, qb, vs, mbase, zr, zx, rt, xt, gtap, rmpct, pt, pb;
	private int o1 = 0, o2 = 0, o3 = 0, o4 = 0;
	private double f1 = 0.0, f2 = 0.0, f3 = 0.0, f4 = 0.0;

	public PSSEGenDataRec(String lineStr, VersionNo version) {
		StringTokenizer st;
		if (version == VersionNo.Old) {
			// 80041 '1 ' 56.78 -8.79 28.000 -14.000 1.0000 0 61.2 0.0 1.0
			// 0.0 0.0 1.0 1 100.0 61.20 -5.60 1 1.00 /* [SMOKY AG1234 ] */
			st = new StringTokenizer(PSSE2IpssUtilFunc.removeTailComment(lineStr), "'");
			i = new Integer(st.nextToken().trim()).intValue();
			id = st.nextToken().trim();
			st = new StringTokenizer(st.nextToken());
		} else {
			st = new StringTokenizer(lineStr, ",");
			i = new Integer(st.nextToken().trim()).intValue();
			id = st.nextToken().trim();
		}
		pg = new Double(st.nextToken().trim()).doubleValue();
		qg = new Double(st.nextToken().trim()).doubleValue();
		qt = new Double(st.nextToken().trim()).doubleValue();
		qb = new Double(st.nextToken().trim()).doubleValue();
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
	}
	
	/** 
	 * Process generator record lines
	 *
	 * @param adjNet the AclfAdjNetwork object
	 * @param msgHub the message hub object
	 */
	public void processGen(
				AclfAdjNetwork adjNet, 
				IPSSMsgHub msg) throws Exception {
/*
		I,ID,PG,QG,QT,QB,VS,IREG,MBASE,ZR,ZX,RT,XT,GTAP,STAT,RMPCT,PT,PB,O1,F1,...,O4,F4

		The standard generator boundary condition is a specification of real power output at the
		high-voltage bus, bus k, and of voltage magnitude at some designated bus, not necessarily bus k.
*/		
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
		
		if (this.pt == 0.0 & this.pb == 0.0) {
			this.pt = 9999.0; this.pb = -9999.0;
		}
		gen.setPLimit(new LimitType(UnitType.pConversion(this.pt, adjNet.getBaseKva(), UnitType.mW, UnitType.PU),
				                    UnitType.pConversion(this.pb, adjNet.getBaseKva(), UnitType.mW, UnitType.PU)));
		if (this.qt == 0.0 & this.qb == 0.0) {
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
	}			
	
	public String toString() {
		String str = "";
		str += "Bus number, GenId:" + i + ", " + id + "\n";
		str += "PG, QG, Qmax, Qmin, Vspec:" + pg + ", " + qg + ", " + qt + ", " + qb + ", " + vs + "\n";
		str += "Ireg, MvaBase, Zr, Zx, Rt, Xt:" + 
					ireg + ", " + mbase + ", " + zr + ", " + zx + ", " + rt + ", " + xt + "\n";
		str += "Gtap, RegMar%, Pmax, Pmin:" + gtap + ", " + stat + ", " + rmpct + ", " + pt + ", " + pb + "\n";
		str += "O1, F1, O2, F2, O3, F3, O4, F4:" + 
			o1 + ", " + f1 + ", " + o2 + ", " + f2  + ", " + o3 + ", " + f3 + ", " + o4 + ", " + f4 + "\n";
		return str;
	}	
}
