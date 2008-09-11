 /*
  * @(#)ControlledShuntDataRec.java   
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
import com.interpss.ext.ge.aclf.GEAclfFactory;
import com.interpss.ext.ge.aclf.GeAclfBus;
import com.interpss.ext.ge.aclf.GeAclfNetwork;
import com.interpss.ext.ge.aclf.GeControlledShunt;
import com.interpss.ext.ge.aclf.IntDoublePair;

/*
<bus>		SVD terminal bus
<"name">	SVD terminal bus name enclosed in quotation marks
<bkv>		SVD terminal bus base voltage (kV)
<"id">		Two character SVD identifier enclosed in quotation marks
<"long id">	Long Identifier (up to 8 characters) enclosed in quotation marks

<st>		SVD status
				1 = in service
				0 = out of service
<ty>		Device type
				0 = Locked (Susceptance is held constant)
				1 = Switched stepwise control. Steps switched on/off as necessary
				2 = Artificial continuous control. Continuous control between tota maximum and minimum susceptance
<kreg bus>	Bus number whose bus voltage is regulated by this SVD
<"kreg name">	Regulated bus name enclosed in quotation marks
<kreg bkv>	Regulated bus base voltage
<ar>		SVD area number
<z>			SVD zone number

<g>			Constant admittance real power (Pu)			
<b>			Constant admittance reactive power (Pu)
<bmin>		Minimum susceptance of continuous element (Pu)
<bmax>		Maximum susceptance of continuous element (Pu)
<vband> 	With of voltage control band
<befmin>	Minimum total susceptance (Pu)
<befmax>	Maximum total susceptance (Pu)
<d_in>		In service date (yymmdd)
<d_out>		Retirement date (yymmdd)
<proj id>	Project Identifier ( information only )
<nst>		Normal SVD status
				1 = in service
				0 = out of service
<o1>		SVD owner 1
<p1>		SVD owner 1 participation factor (0.0 - 1.0)
<o2>		SVD owner 2
<p2>		SVD owner 2 participation factor (0.0 - 1.0)
<o3>		SVD owner 3
<p3>		SVD owner 3 participation factor (0.0 - 1.0)
<o4>		SVD owner 4
<p4>		SVD owner 4 participation factor (0.0 - 1.0)
<n1>		Number of equal admittance steps in first stage
<b1>		Susceptance of each switched element in first stage
<ni>		Number of equal admittance steps in i-th stage, (i <=10)
<bi>		Susceptance of each switched element in i-th stage

   30430 "FULTON 2" 230.00 "v " "        " :  ...
   
   1  0   30430 "FULTON 2" 230.00    1    1 
   
   0.0000 3.7500 0.0000 0.0000 0.1000 0.0000 3.7500   400101   391231   0 
   
   1   1 1.000   0 0.000   0 0.000   0 0.000 
   nst        
   
   1  0.750  1  0.750  1  0.750  1  0.750  1  0.750  0  0.000  0  0.000  0  0.000 0  0.000  0  0.000
   n1        n2                                                                             n10   
 */

public class ControlledShuntDataRec extends BusHeaderRec {
			public int st, ty, kregBus, nst;
			public String kregName;
			public double kregBkv, g, b, bmin, bmax, vband, befmin, befmax;
			public int[] oAry, nAry;
			public double[] pAry, bAry;			

	public ControlledShuntDataRec(String lineStr, GEDataRec.VersionNo version) {
		//System.out.println("ControlledShunt data->" + lineStr);
		
		String str1 = lineStr.substring(0, lineStr.indexOf(':')),
        	   str2 = lineStr.substring(lineStr.indexOf(':')+1);
	
		StringTokenizer st = new StringTokenizer(str1, "\"");
		this.number = new Integer(st.nextToken().trim()).intValue();	
		this.name = st.nextToken(); 									
		this.bkv = new Double(st.nextToken().trim()).doubleValue();	
		this.id = st.nextToken(); 										
		st.nextToken();
		this.longId = st.nextToken();	
		
		st = new StringTokenizer(str2, "\"");
		String part_1 = st.nextToken();
		this.kregName = st.nextToken();
		String part_3 = st.nextToken();

		st = new StringTokenizer(part_1);
		this.st = new Integer(st.nextToken().trim()).intValue(); 
		this.ty = new Integer(st.nextToken().trim()).intValue(); 
		this.kregBus = new Integer(st.nextToken().trim()).intValue();		

		st = new StringTokenizer(part_3);
		this.kregBkv = new Double(st.nextToken().trim()).doubleValue();	//Regulated bus base voltage
		this.ar = new Integer(st.nextToken().trim()).intValue();		//SVD area number
		this.z = new Integer(st.nextToken().trim()).intValue();			//SVD zone number

		this.g = new Double(st.nextToken().trim()).doubleValue();			//Constant admittance real power (Pu)			
		this.b = new Double(st.nextToken().trim()).doubleValue();			//Constant admittance reactive power (Pu)
		this.bmin = new Double(st.nextToken().trim()).doubleValue();		//Minimum susceptance of continuous element (Pu)
		this.bmax = new Double(st.nextToken().trim()).doubleValue();		//Maximum susceptance of continuous element (Pu)
		this.vband = new Double(st.nextToken().trim()).doubleValue(); 	//With of voltage control band
		this.befmin = new Double(st.nextToken().trim()).doubleValue();	//Minimum total susceptance (Pu)
		this.befmax = new Double(st.nextToken().trim()).doubleValue();	//Maximum total susceptance (Pu)
		this.d_in = st.nextToken();		//In service date (yymmdd)
		this.d_out = st.nextToken();		//Retirement date (yymmdd)
		this.projId = st.nextToken();	//Project Identifier ( information only )
		this.nst = new Integer(st.nextToken().trim()).intValue();		//Normal SVD status		
		
		oAry = new int[4]; pAry = new double[4];
		for (int i = 0; i < 4; i++) {
			this.oAry[i] = new Integer(st.nextToken().trim()).intValue();		//Shunt owner 1
			this.pAry[i] = new Double(st.nextToken().trim()).doubleValue();		//Shunt owner 1 participation factor (0.0 - 1.0)
		}
		
		nAry = new int[10]; bAry = new double[10];
		for (int i = 0; i < 10; i++) {
			this.nAry[i] = new Integer(st.nextToken().trim()).intValue();		
			this.bAry[i] = new Double(st.nextToken().trim()).doubleValue();	
		}
	}
	public void setControlledShunt(GeAclfNetwork net, IPSSMsgHub msg) throws Exception {
		GeControlledShunt shunt = ExtensionObjectFactory.createGeControlledShunt();
		
		GeAclfBus  bus = Ge2IpssUtilFunc.getBus(this.number, net, msg);
		bus.setControlledShunt(shunt);
		
		shunt.setId(this.id);
		shunt.setLongId(this.longId);									
		shunt.setGeAreaNo(this.ar);
		shunt.setGeZoneNo(this.z);
		shunt.setInSevice(this.st==1);
		shunt.setNormalInService(this.nst==1);
		shunt.setType(this.ty); 

		if (this.kregBus > 0) {
			GeAclfBus  b = Ge2IpssUtilFunc.getBus(this.kregBus, net, msg);
			shunt.setRegBus(b);
		}
		
		shunt.setG(this.g);			
		shunt.setB(this.b);
		shunt.setBmin(this.bmin);
		shunt.setBmax(this.bmax);	
		shunt.setVband(this.vband);
		shunt.setBefmin(this.befmin);
		shunt.setBefmax(this.befmax);

		for (int i = 0; i < 10; i++) {
			if (this.nAry[i]>0) {
				IntDoublePair pair = GEAclfFactory.eINSTANCE.createIntDoublePair();
				pair.setN(this.nAry[i]);		
				pair.setB(this.bAry[i]);
				shunt.getOwnerRecs().add(pair);
			}
		}
	}
	
	public String toString() {
		String str = super.toString();
		str += "st, ty, kregBus, nst, kregName: " + st + ", " + ty + ", " + kregBus + ", " + nst + ", " + kregName + "\n"; 
		str += "kregBkv, g, b, bmin, bmax, vband, befmin, befmax: " + kregBkv + ", " + g + ", " + b + ", " + bmin + ", " + bmax + ", " + vband + ", " + befmin + ", " + befmax + "\n";
		//public int[] oAry, nAry;
		//public double[] pAry, bAry;			
		return str;
	}	
	
}
