 /*
  * @(#)LoadDataRec.java   
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
  * @Date 06/01/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.ieee.odm.adapter.ge.impl;

import java.util.StringTokenizer;
import java.util.logging.Logger;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ApparentPowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowLoadDataXmlType;
import org.ieee.odm.adapter.ge.GE_PSLF_Adapter;
import org.ieee.odm.model.xbean.XBeanDataSetter;
import org.ieee.odm.model.xbean.XBeanParserHelper;
import org.ieee.odm.model.xbean.XBeanODMModelParser;

public class LoadDataRec extends BusHeaderRec {
	public int st, nst, owner;
	public double p, q, ip, iq, g, b;
			
	public LoadDataRec(String lineStr, GE_PSLF_Adapter.VersionNo version, final XBeanODMModelParser parser, Logger logger) {
		//System.out.println("load data->" + lineStr);
/*
	<bus> <"name"> <bkv> <"id"> <"long id"> : <st> <p> <q> <ip> <iq> <g> <b> /
	<ar> <z> <d_in> <d_out> <proj id> <nst> <owner>

       2 "P-2     " 380.00 "1 " "        "  :  1  868.096    0.000    0.000    0.000    0.000    0.000   1  201   400101   391231   0 0   1
 */		
		String str1 = lineStr.substring(0, lineStr.indexOf(':')),
        	   str2 = lineStr.substring(lineStr.indexOf(':')+1);

		setHeaderData(str1);

	    final String busId = XBeanODMModelParser.BusIdPreFix+this.number;
		BusRecordXmlType busRec = parser.getBusRecord(busId);
	    if (busRec == null){
	    	logger.severe("Bus "+ busId+ " not found in the network");
	    	return;
	    }

		StringTokenizer st = new StringTokenizer(str2);
		if (st.hasMoreElements())
			this.st = new Integer(st.nextToken().trim()).intValue();
		if (st.hasMoreElements())
			this.p = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.q = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.ip = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.iq = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.g = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.b = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.ar = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.z = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.d_in = st.nextToken();
		if (st.hasMoreElements())
			this.d_out = st.nextToken();
		if (st.hasMoreElements())
			this.projId = st.nextToken();
		if (st.hasMoreElements())
			this.nst = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.owner = new Integer(st.nextToken()).intValue();

	    // ODM allows one equiv load has many contribute loads, but here, we assume there is only one contribute load.

	    LoadflowLoadDataXmlType contribLoad = XBeanParserHelper.createContriLoad(busRec); 

		contribLoad.setAreaNumber(this.ar);
		contribLoad.setZoneNumber(this.z);
		//load.setOwner(this.owner);
		// <st> Load status 1 =	in service; 0 =	out of service
		contribLoad.setOffLine(this.st != 1);
		// <nst> Normal load status 1=in service; 0=out of service
		contribLoad.setNormalOffLineStatus(this.nst != 1);

		/*
		<p> Constant real power (MW)
		<q> Constant reactive power (MVAR)
		<ip> Constant current real power (MW)
		<iq> Constant current reactive power (MVAR)
		<g> Constant admittance real power (MW)
		<b> Constant admittance reactive power (MVAR)
 */		
		if (this.p != 0.0 || this.q != 0.0)
			XBeanDataSetter.setPowerData(contribLoad.addNewConstPLoad(), this.p, this.q, ApparentPowerUnitType.MVA);
		if (this.ip != 0.0 || this.iq != 0.0)
			XBeanDataSetter.setPowerData(contribLoad.addNewConstILoad(), this.ip, this.iq, ApparentPowerUnitType.MVA);
		if (this.g != 0.0 || this.b != 0.0)
			XBeanDataSetter.setPowerData(contribLoad.addNewConstZLoad(), this.g, this.b, ApparentPowerUnitType.MVA);
	}
		
	public String toString() {
		String str = super.toString();
		str += "st, nst, owner, d_in, d_out, proj id: " + st + ", " + nst + ", " + owner + ", " + d_in + ", " + d_out + ", " + projId + "\n";
		str += "p, q, ip, iq, g, b: " + p + ", " + q + ", " + ip + ", " + iq + ", " + g + ", " + b + "\n";
		return str;
	}
	
}
