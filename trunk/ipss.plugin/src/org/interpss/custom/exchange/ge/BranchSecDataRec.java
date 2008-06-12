 /*
  * @(#)BranchSecDataRec.java   
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
import com.interpss.ext.ge.aclf.GeAclfLine;
import com.interpss.ext.ge.aclf.GeAclfNetwork;
import com.interpss.ext.ge.aclf.GeBranchSection;

public class BranchSecDataRec extends BaseBranchDataRec {
	public double r, x, b;
	public double al, l_info, gi, tf, tt;
	public int type = 0;   //Type of line 0=normal line

	/*
		<f bus> <"f name"> <f bkv> <t bus> <"t name"> <t bkv> <"ck"> <sec> <"long id">: 
		<st> <r> <x> <b> <r1> <r2> <r3> <r4> <al> <l> <ar> <z> <gi> <tf> <tt> /
		<d_in> <d_out> <proj id> <nst> <type> <r5> <r6> <r7> <r8> 
		<o1> <p1> <o2> <p2> <o3> <p3> <o4> <p4> <o5> <p5> <o6> <p6> <o7> <p7> <o8> <p8> <ohms>
	 
      	1 "P-1     " 380.00       2 "P-2     " 380.00 "1 "  1 "        " :  1 0.00000 0.02348 0.00000    
      	0.0    0.0    0.0    0.0 1.000    1.0 /
  		1 201 0.0000 0.000 1.000   400101   391231   0 1  0    0.0    0.0    0.0    
  		0.0   1 1.000   0 1.000   0 1.000   0 1.000   0 0.000   0 0.000   0 0.000   0 0.000  0
	 */
	public BranchSecDataRec(String lineStr, GEDataRec.VersionNo version) {
		//System.out.println("branch sec->" + lineStr);

		String str1 = lineStr.substring(0, lineStr.indexOf(':')),
	           str2 = lineStr.substring(lineStr.indexOf(':')+1);
		
		this.setHeaderData(str1);
/*
		<r> Branch section resistance (pu)
		<x> Branch section reactance (pu)
		<b> Branch section susceptance (pu)
		<r1> First Branch Rating (MVA)
		<r2> Second Branch Rating (MVA)
		<r3> Third Branch Rating (MVA)
 		<ohms> Ohmic data flag
			1 if impedances in ohms
			0 if in per unit
*/		
		StringTokenizer st = new StringTokenizer(str2);
		if (st.hasMoreElements())
			this.st = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.r = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.x = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.b = new Double(st.nextToken()).doubleValue();

		// <r1> <r2> <r3> <r4>
		this.setRMvaAry1_4(st);

		if (st.hasMoreElements())
			this.al = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.l_info = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.ar = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.z = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.gi = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.tf = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.tt = new Double(st.nextToken()).doubleValue();

		// <d_in> <d_out> <proj id>
		this.setDates(st);

		if (st.hasMoreElements())
			this.nst = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.type = new Integer(st.nextToken()).intValue();

		// <r5> <r6> <r7> <r8>
		this.setRMvaAry5_8(st);
		
		// <o1> <p1> <o2> <p2> <o3> <p3> <o4> <p4> <o5> <p5> <o6> <p6> <o7> <p7> <o8> <p8>
		this.setOwnerAry(st);
		
		if (st.hasMoreElements())
			this.ohms =	new Integer(st.nextToken()).intValue();	
	}
	
	public void setBranchSection(GeAclfNetwork net, IPSSMsgHub msg) throws Exception {
		GeAclfLine  branch = null;
		if (this.sec == 1) {
			// first section
			branch = ExtensionObjectFactory.createGeAclfLine();
			net.addBranch(branch, new Integer(this.f_bus).toString(), new Integer(this.t_bus).toString(), this.ck);
		}
		else {
			branch = (GeAclfLine)net.getBranch(new Integer(this.f_bus).toString(), new Integer(this.t_bus).toString(), this.ck);
			if (branch == null) {
				msg.sendErrorMsg("Branch section data error, branch cannot be found, fromBus, toBus: " + f_bus + ", " + t_bus);
				throw new Exception("Branch cannot be found");
			}
		}
		
		GeBranchSection braSec = ExtensionObjectFactory.createGeBranchSection();
		setBaseBranchData(braSec);
		braSec.setType(this.type);
		braSec.setR(this.r);
		braSec.setX(this.x);
		braSec.setB(this.b);
		braSec.setLossFactor(this.al);
		braSec.setGi(this.gi);
		braSec.setFromTap(this.tf);
		braSec.setToTap(this.tt);

		branch.getBranchSecList().add(braSec);
	}
	
	public String toString() {
		String str = super.toString();
		str += "r, x, b, type: " + st + ", " + r + ", " + x + ", " + b + ", " + type + "\n";
		str += "al, l_info, gi, tf, tt: " + al + ", " + l_info + ", " + gi + ", " + tf + ", " + tt + "\n";
		return str;
	}	
}
