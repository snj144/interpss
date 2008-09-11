 /*
  * @(#)ShuntDataRec.java   
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

package org.interpss.custom.exchange.ge;

import java.util.StringTokenizer;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.ext.ExtensionObjectFactory;
import com.interpss.ext.ge.aclf.GeAclfBus;
import com.interpss.ext.ge.aclf.GeAclfNetwork;
import com.interpss.ext.ge.aclf.GeBranchSection;
import com.interpss.ext.ge.aclf.GeShunt;

/*
<fbus> 		From shunt terminal bus
<"fname"> 	From shunt terminal bus name enclosed in quotation marks
<fbkv>		From shunt terminal bus base voltage(kV)
<"id">		Two character shunt identifier enclosed in quotation marks
<tbus>		To shunt terminal bus
<"tname">	To shunt terminal bus name enclosed in quotation marks
<tbkv>		To shunt terminal bus base voltage (kV)
<"ck">		Two character shunt circuit enclosed in quotation marks
<sec>		Section number (1-9 in ascending order beginning at "from" end)
<"long id">	Long Identifier (up to 8 characters) enclosed in quotation marks

<st>		Shunt status
				1 =	 in service
				0 =  out of service
<a>			Shunt area number
<z>			Shunt Zone number
<g>			Actual shunt conductance (MW)
<b>			Actual shunt susceptance (MVAR)
<d_in>		In service date (yymmdd)
<d_out>		Retirement date (yymmdd)	
<proj id> 	Project Identifier (information only )
<nst>		Normal shunt status 1 = in service, 0 = out of service
<o1>		Shunt owner 1
<p1>		Shunt owner 1 participation factor (0.0 - 1.0)
<o2>		Shunt owner 2
<p2>		Shunt owner 2 participation factor (0.0 - 1.0)
<o3>		Shunt owner 3
<p3>		Shunt owner 3 participation factor (0.0 - 1.0)
<o4>		Shunt owner 4
<p4>		Shunt owner 4 participation factor (0.0 - 1.0)
<reg bus>	Number of bus whose voltage is controlled by this shunt
<"rname">	Regulating bus name enclosed in quotation marks
<rkv>		Regulating bus base voltage

Bus sample:

     30055 "GATES  6" 500.00 "b "        0 "        "   0.0   "  "  0 "        "  :    
                                       tbus                    ck  sec  long id
1   1    1  0.00000 -0.90700   400101   391231   0 1   1 1.000   0 0.000   0 0.000   0 0.000   -1      "       " 0.0    
st                                                 nst                                       reg_bus


Line sample

    1292 "[1292SAN"   1.00 "f "     6102 "[6102MCK"   1.00  "1 "  1 "        "  :  

1   1    1  0.00000 -0.14840   400101   391231   0 1   1 1.000   0 1.000   0 1.000   0 1.000   -1      "       " 0.0

 */
public class ShuntDataRec extends BusHeaderRec {
	public int fbus, tbus, sec, st, nst, regBus; 
	public String fname, tname, ck, rname; 
	public double fbkv, tbkv, g, b, rkv;
	public int[] oAry;
	public double[] pAry;
	
	public ShuntDataRec(String lineStr, GEDataRec.VersionNo version) {
		//System.out.println("shunt data->" + lineStr);
		
		String str1 = lineStr.substring(0, lineStr.indexOf(':')),
	           str2 = lineStr.substring(lineStr.indexOf(':')+1);
		
		StringTokenizer st = new StringTokenizer(str1, "\"");
		this.fbus = new Integer(st.nextToken().trim()).intValue();		//From shunt terminal bus
		this.fname = st.nextToken(); 									//From shunt terminal bus name enclosed in quotation marks
		this.fbkv = new Double(st.nextToken().trim()).doubleValue();	//From shunt terminal bus base voltage(kV)
		this.id = st.nextToken(); 										//Two character shunt identifier enclosed in quotation marks
		this.tbus = new Integer(st.nextToken().trim()).intValue();		//To shunt terminal bus
		this.tname = st.nextToken();									//To shunt terminal bus name enclosed in quotation marks
		this.tbkv = new Double(st.nextToken().trim()).doubleValue();	//To shunt terminal bus base voltage (kV)
		this.ck = st.nextToken();										//Two character shunt circuit enclosed in quotation marks
		this.sec = new Integer(st.nextToken().trim()).intValue();	
		this.longId = st.nextToken();									

		st = new StringTokenizer(str2, "\"");
		String part_1 = st.nextToken();
		this.rname = st.nextToken();
		this.rkv = new Double(st.nextToken().trim()).doubleValue();
		
		st = new StringTokenizer(part_1);
		this.st = new Integer(st.nextToken().trim()).intValue();		//Shunt status
		this.ar = new Integer(st.nextToken().trim()).intValue();			//Shunt area number
		this.z = new Integer(st.nextToken().trim()).intValue();			//Shunt Zone number
		this.g = new Double(st.nextToken().trim()).doubleValue();			//Actual shunt conductance (MW)
		this.b = new Double(st.nextToken().trim()).doubleValue();			//Actual shunt susceptance (MVAR)
		this.d_in = st.nextToken();		//In service date (yymmdd)
		this.d_out = st.nextToken();		//Retirement date (yymmdd)	
		this.projId = st.nextToken(); 	//Project Identifier (information only )
		this.nst = new Integer(st.nextToken().trim()).intValue();		//Normal shunt status 1 = in service, 0 = out of service

		oAry = new int[4]; pAry = new double[4];
		for (int i = 0; i < 4; i++) {
			this.oAry[i] = new Integer(st.nextToken().trim()).intValue();		//Shunt owner 1
			this.pAry[i] = new Double(st.nextToken().trim()).doubleValue();		//Shunt owner 1 participation factor (0.0 - 1.0)
		}
		this.regBus = new Integer(st.nextToken().trim()).intValue();	
	}
	
	public void setShunt(GeAclfNetwork net, IPSSMsgHub msg) throws Exception {
		GeShunt shunt = ExtensionObjectFactory.createGeShunt();
		if (this.tbus == 0) {
			// connect to a Bus
			GeAclfBus  bus = Ge2IpssUtilFunc.getBus(this.number, net, msg);
			bus.setShunt(shunt);
		}
		else {
			// connect to a branch
			GeBranchSection sec = Ge2IpssUtilFunc.getBranchSection(this.fbus, this.tbus, this.ck, this.sec, net, msg);
			sec.getShuntList().add(shunt);
		}
		
		shunt.setId(this.id);
		shunt.setLongId(this.longId);									
		shunt.setGeAreaNo(this.ar);
		shunt.setGeZoneNo(this.z);
		shunt.setInSevice(this.st==1);
		shunt.setNormalInService(this.nst==1);
		
		// this part is not used
		if (this.regBus > 0) {
			GeAclfBus  bus = Ge2IpssUtilFunc.getBus(this.regBus, net, msg);
			shunt.setRegBus(bus);
		}

		shunt.setG(this.g);
		shunt.setB(this.b);
	}
	
	public String toString() {
		String str = super.toString();
		str += "fbus, tbus, sec, st, nst, regBus:" + fbus + ", " + tbus + ", " + sec + ", " + st + ", " + nst + ", " + regBus + "\n"; 
		str += "fname, tname, ck, rname: " + fname + ", " + tname + ", " + ck + ", " + rname + "\n"; 
		str += "fbkv, tbkv, g, b, rkv: " + fbkv + ", " + tbkv + ", " + g + ", " + b + ", " + rkv + "\n";
		return str;
	}	
}
