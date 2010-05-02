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

package org.ieee.odm.adapter.psse.xbean.v30.impl;

import java.util.StringTokenizer;
import java.util.logging.Logger;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ActivePowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ApparentPowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowGenDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ReactivePowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZUnitType;
import org.ieee.odm.adapter.psse.PsseVersion;
import org.ieee.odm.model.xbean.XBeanDataSetter;
import org.ieee.odm.model.xbean.XBeanParserHelper;
import org.ieee.odm.model.xbean.XBeanODMModelParser;

public class XBeanPSSEV30GenDataRec {
	private static int i, ireg, stat ;
	private static String id;
	private static double pg, qg, qt, qb, vs, mbase, zr, zx, rt, xt, gtap, rmpct, pt, pb;
	private static int o1 = 0, o2 = 0, o3 = 0, o4 = 0;
	private static double f1 = 0.0, f2 = 0.0, f3 = 0.0, f4 = 0.0;
	
	/*
	 * GenData
	 * I,ID,PG,QG,QT,QB,VS,IREG,MBASE,ZR,ZX,RT,XT,GTAP,STAT,RMPCT,PT,PB,O1,F1,...,O4,F4
	 * 
	 * The standard generator boundary condition is a specification of real
	 * power output at the high-voltage bus, bus k, and of voltage magnitude at
	 * some designated bus, not necessarily bus k.
	 */

	public static void procLineString(String lineStr, PsseVersion version, final XBeanODMModelParser parser, Logger logger) {
		procFields(lineStr, version, logger);

/*
		I,ID,PG,QG,QT,QB,VS,IREG,MBASE,ZR,ZX,RT,XT,GTAP,STAT,RMPCT,PT,PB,O1,F1,...,O4,F4

		The standard generator boundary condition is a specification of real power output at the
		high-voltage bus, bus k, and of voltage magnitude at some designated bus, not necessarily bus k.
		
		STAT - Initial machine status of one for in-service and zero for out-of-service; STAT = 1 by default.
*/		
	    final String busId = XBeanODMModelParser.BusIdPreFix+i;
		BusRecordXmlType busRec = parser.getBusRecord(busId);
	    if (busRec == null){
	    	logger.severe("Bus "+ busId+ " not found in the network");
	    	return;
	    }
	    
	    LoadflowGenDataXmlType contriGen = XBeanParserHelper.createContriGen(busRec);
	    
	    contriGen.setId(id);
	    contriGen.setName("Gen:" + id + "(" + i + ")");
	    contriGen.setDesc("PSSE Generator " + id + " at Bus " + i);
	    contriGen.setOffLine(stat!=1);

	    XBeanDataSetter.setPowerData(contriGen.addNewPower(), pg, qg, ApparentPowerUnitType.MVA);

	    XBeanDataSetter.setVoltageData(contriGen.addNewDesiredVoltage(), vs, VoltageUnitType.PU);
		
		if (pt == 0.0 & pb == 0.0 || pt < pb ) {
			pt = 9999.0; pb = -9999.0;
		}
		XBeanDataSetter.setActivePowerLimitData(contriGen.addNewPLimit(), pt, pb, ActivePowerUnitType.MW);
		
		if (qt == 0.0 & qb == 0.0 || qt < qb) {
			qt = 9999.0; qb = -9999.0;
		}
		XBeanDataSetter.setReactivePowerLimitData(contriGen.addNewQLimit(), qt, qb, ReactivePowerUnitType.MVAR);
		
	    if (ireg > 0) {
	    	final String reBusId = XBeanODMModelParser.BusIdPreFix+ireg;
	    	contriGen.addNewRemoteVoltageControlBus().setIdRef(reBusId);
	    }
	    
		XBeanDataSetter.setPowerMva(contriGen.addNewRatedPower(), mbase);

		if ( zr != 0.0 || zx != 0.0 )
			XBeanDataSetter.setZValue(contriGen.addNewSourceZ(), zr, zx, ZUnitType.PU);

		if ( rt != 0.0 || xt != 0.0 ) {
			XBeanDataSetter.setZValue(contriGen.addNewXfrZ(), rt, xt, ZUnitType.PU);
			contriGen.setXfrTap(gtap);
		}
		
		contriGen.setMvarVControlParticipateFactor(rmpct*0.01);

		XBeanParserHelper.addOwner(contriGen, 
				new Integer(o1).toString(), f1, 
				new Integer(o2).toString(), o2==0?0.0:f2, 
				new Integer(o3).toString(), o3==0?0.0:f3, 
				new Integer(o4).toString(), o4==0?0.0:f4);
	}
	
	private static void procFields(String lineStr, PsseVersion version, Logger logger) {
		StringTokenizer st;

		st = new StringTokenizer(lineStr, ",");
		i = new Integer(st.nextToken().trim()).intValue();
		id = st.nextToken().trim();

		pg = new Double(st.nextToken().trim()).doubleValue();
		qg = new Double(st.nextToken().trim()).doubleValue();
		
		qt = new Double(st.nextToken().trim()).doubleValue();
		qb = new Double(st.nextToken().trim()).doubleValue();
		if (qt < qb) {
			logger.warning("Gen Data qt (qMax: " + qt + ") < qb (qMin:" + qb + "), set to [9999.0, -9999.0]\n" + lineStr);
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
			logger.warning("Gen Data pt (pMax:" + pt + ") < pb (pMin:" + pb + "), set to [9999.0, -9999.0] \n" + lineStr);
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
	}
}
