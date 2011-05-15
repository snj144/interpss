 /*
  * @(#)GenDataRec.java   
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

package org.interpss.custom.dep.exchange.ge;

import java.util.StringTokenizer;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.ext.ExtensionObjectFactory;
import com.interpss.ext.ge.aclf.GeAclfBus;
import com.interpss.ext.ge.aclf.GeAclfNetwork;
import com.interpss.ext.ge.aclf.GeGenerator;

public class GenDataRec extends BusHeaderRec {
	public int st, igregBus, nst; 
	public String igregName, hName, tName;
	public double igregBkv, prf, qrf, pgen, pmax, pmin, qgen, qmax, qmin;
	public double mbase, rcomp, xcomp, zgenr, zgenx, hBus, hBkv, tBus;
	public double tBkv, rtr, xtr, gtap;
	public int[] oAry = new int[8];
	public double[] pAry = new double[8];
	public int govFlag, agcFlag, dispatchFlag, baseloadFlag, turbineType, qtab;
	public double airTemp, pmax2;

	public GenDataRec(String lineStr, GEDataRec.VersionNo version) {
		//System.out.println("gen data->" + lineStr);
/*
generator data  [   4]     id   long_id_    st ---no--     reg_name       prf  qrf  ar zone   pgen   pmax   pmin   qgen   qmax   qmin   mbase cmp_r cmp_x gen_r gen_x           hbus                    tbus           date_in date_out pid N
    101 "NORTH-G1"  16.00 "h1" "        " :  1     101 "NORTH-G1"  16.00  1.00 0.50  1    1  523.44  550.0   0.0  110.8  999.0 -999.0  750.00 0.000 0.872 0.000 0.200  -1      "       " 0.0   -1      "       " 0.0    400101   391231   0 0 /
 0.0000 0.0000 0.0000   0 0.000   0 0.000   0 0.000   0 0.000   0 0.000   0 0.000   0 0.000   0 0.000

 */		
		String str1 = lineStr.substring(0, lineStr.indexOf(':')),
	           str2 = lineStr.substring(lineStr.indexOf(':')+1);
	
		//  <bus> <"name"> <bkv> <"id"> <"long id"> : 
		setHeaderData(str1);

		StringTokenizer st = new StringTokenizer(str2, "\"");

		StringTokenizer st1 = new StringTokenizer(st.nextToken());
		// <st> <igreg bus>
		if (st1.hasMoreTokens())
			this.st = new Integer(st1.nextToken()).intValue();
		if (st1.hasMoreTokens())
			this.igregBus =  new Integer(st1.nextToken()).intValue();

		// <"igreg name"> /
		st1 = new StringTokenizer(st.nextToken());
		if (st1.hasMoreElements()) 
			this.igregName = st1.nextToken();
	
		// <igreg bkv> <prf> <qrf> <ar> <z> <pgen> <pmax> <pmin> <qgen> <qmax> <qmin> /
		//   <mbase> <rcomp> <xcomp> <zgenr> <zgenx> <h bus> 
		st1 = new StringTokenizer(st.nextToken());
		if (st1.hasMoreTokens())
			this.igregBkv = new Double(st1.nextToken()).doubleValue();
		if (st1.hasMoreTokens())
			this.prf = new Double(st1.nextToken()).doubleValue();
		if (st1.hasMoreTokens())
			this.qrf = new Double(st1.nextToken()).doubleValue();
		if (st1.hasMoreTokens())
			this.ar = new Integer(st1.nextToken().trim()).intValue();
		if (st1.hasMoreTokens())
			this.z = new Integer(st1.nextToken().trim()).intValue();
		if (st1.hasMoreTokens())
			this.pgen = new Double(st1.nextToken()).doubleValue();
		if (st1.hasMoreTokens())
			this.pmax = new Double(st1.nextToken()).doubleValue();
		if (st1.hasMoreTokens())
			this.pmin = new Double(st1.nextToken()).doubleValue();
		if (st1.hasMoreTokens())
			this.qgen = new Double(st1.nextToken()).doubleValue();
		if (st1.hasMoreTokens())
			this.qmax = new Double(st1.nextToken()).doubleValue();
		if (st1.hasMoreTokens())
			this.qmin = new Double(st1.nextToken()).doubleValue();
		if (st1.hasMoreTokens())
			this.mbase = new Double(st1.nextToken()).doubleValue();
		if (st1.hasMoreTokens())
			this.rcomp = new Double(st1.nextToken()).doubleValue();
		if (st1.hasMoreTokens())
			this.xcomp = new Double(st1.nextToken()).doubleValue();
		if (st1.hasMoreTokens())
			this.zgenr = new Double(st1.nextToken()).doubleValue();
		if (st1.hasMoreTokens())
			this.zgenx = new Double(st1.nextToken()).doubleValue();

		if (st1.hasMoreTokens())
			this.hBus = new Integer(st1.nextToken().trim()).intValue(); 
		
		//  <"h name"> 
		this.hName = st.nextToken();
		   
		//   <h bkv> <t bus>
		st1 = new StringTokenizer(st.nextToken());
		if (st1.hasMoreTokens())
			this.hBkv = new Double(st1.nextToken()).doubleValue();
		if (st1.hasMoreTokens())
			this.tBus = new Integer(st1.nextToken().trim()).intValue(); 
		   
		//   <"t name"> 
		this.tName = st.nextToken();
		   
		//   <t bkv> <d_in> <d_out> <projid> <snt> <rtr> <xtr> <gtap> /
		//   <o1> <p1> <o2> <p2> <o3> <p3> <o4> <p4> <o5> <p5> <o6> <p6> <o7> <p7> <o8> <p8> 
		//   <gov_flag> <agc_flag> <dispatch_flag> <baseload_flag> <air_temp> / <turbine_type> <qtab> <pmax2>
		if (st.hasMoreElements()) {
			st1 = new StringTokenizer(st.nextToken());
			if (st1.hasMoreTokens())
				this.tBkv = new Double(st1.nextToken()).doubleValue();

			GEDataRec.setDates(st1, this.d_in, this.d_out, this.projId);

			if (st1.hasMoreTokens())
				this.nst  = new Integer(st1.nextToken().trim()).intValue();
			if (st1.hasMoreTokens())
				this.rtr = new Double(st1.nextToken()).doubleValue();
			if (st1.hasMoreTokens())
				this.xtr = new Double(st1.nextToken()).doubleValue();
			if (st1.hasMoreTokens())
				this.gtap = new Double(st1.nextToken()).doubleValue();
			
			GEDataRec.setOwnerAry(st1, this.oAry, this.pAry);
			
			if (st1.hasMoreTokens())
				this.govFlag = new Integer(st1.nextToken().trim()).intValue(); 
			if (st1.hasMoreTokens())
				this.agcFlag = new Integer(st1.nextToken().trim()).intValue(); 
			if (st1.hasMoreTokens())
				this.dispatchFlag = new Integer(st1.nextToken().trim()).intValue(); 
			if (st1.hasMoreTokens())
				this.baseloadFlag = new Integer(st1.nextToken().trim()).intValue(); 
			if (st1.hasMoreTokens())
				this.airTemp  = new Double(st1.nextToken()).doubleValue();
			if (st1.hasMoreTokens())
				this.turbineType = new Integer(st1.nextToken().trim()).intValue(); 
			if (st1.hasMoreTokens())
				this.qtab = new Integer(st1.nextToken().trim()).intValue(); 
			if (st1.hasMoreTokens())
				this.pmax2 = new Double(st1.nextToken()).doubleValue();
		}
	}

	public void setGen(GeAclfNetwork net, IPSSMsgHub msg) throws Exception {
		GeAclfBus  bus = Ge2IpssUtilFunc.getBus(this.number, net, msg);
		
		GeGenerator gen = ExtensionObjectFactory.createGeGenerator(id, longId);
		bus.getGenList().add(gen);
		gen.setId(this.id);
		gen.setLongId(this.longId);
		gen.setGeAreaNo(this.ar);
		gen.setGeZoneNo(this.z);
		// <st> Load status 1 =	in service; 0 =	out of service
		gen.setInSevice(this.st == 1);
		// <nst> Normal load status 1=in service; 0=out of service
		gen.setNormalInService(this.nst == 1);		
		/*
		<igreg bus> Number of bus whose voltage is controlled by this generator
		<"igreg name"> Regulating bus name enclosed in quotation marks
		<igreg bkv> Regulating bus base voltage
		*/
		gen.setRegBusNumber(this.igregBus);
		/*
		<prf> Real power regulating assignment factor (0.0 - 1.0)
		<qrf> Reactive power regulating assignment factor (0.0 - 1.0)
		 */
		gen.setPRegFactor(this.prf);
		gen.setQRegFactor(this.qrf);
		if (this.prf != 1.0 || this.qrf != 1.0) {
			IpssLogger.getLogger().warning("this.prf != 1.0 || this.qrf != 1.0 at bus " + this.number);
		}
		/*
		<pgen> Actual real power output (MW)
		<pmax> Maximum real power output (MW)
		<pmin> Minimum real power output (MW)
		<qgen> Actual reactive power output (MVAr)
		<qmax> Maximum reactive power output (MVAr)
		<qmin> Minimum reactive power output (MVAr)
		<mbase> Generator base (MVA)
		 */
		gen.setPMw(this.pgen);
		gen.setPMwMax(this.pmax);
		gen.setPMwMin(this.pmin);
		gen.setQMvar(this.qgen);
		gen.setQMvarMax(this.qmax);
		gen.setQMvarMin(this.qmin);
		gen.setGenBaseMva(this.mbase);
		/*
		<rcomp> Compensating resistance (pu)
		<xcomp> Compensating reactance (pu)
		<zgenr> Generator characteristic resistance (pu)
		<zgenx> Generator characteristic reactance (pu)
*/		
		gen.setRCompenPU(this.rcomp);
		gen.setXCompenPU(this.xcomp);
		gen.setRCharactPU(this.zgenr);
		gen.setXCharactPU(this.zgenx);
	}	

	@Override
	public String toString() {
		String str = super.toString();
		str += "st, igregBus, nst, igregName, hName, tName: " + st + ", " + igregBus + ", " + nst + ", " + igregName + ", " + hName + ", " + tName + "\n" ;
		str += "igregBkv, prf, qrf, pgen, pmax, pmin, qgen, qmax, qmin: " + 
				igregBkv + ", " + prf + ", " + qrf + ", " + pgen + ", " + pmax + ", " + pmin + ", " + qgen + ", " + qmax + ", " + qmin + "\n";
		str += "mbase, rcomp, xcomp, zgenr, zgenx, hBus, hBkv, tBus: " + 
				mbase + ", " + rcomp + ", " + xcomp + ", " + zgenr + ", " + zgenx + ", " + hBus + ", " + hBkv + ", " + tBus + "\n";
		str += "tBkv, rtr, xtr, gtap: " + tBkv + ", " + rtr + ", " + xtr + ", " + gtap + "\n";
		str += "oAry, pAry: " + oAry[0] + ", " + pAry[0] + ", " + oAry[1] + ", " + pAry[1] + ", " + oAry[2] + ", " + pAry[2] + ", " +
				                oAry[3] + ", " + pAry[3] + ", " + oAry[4] + ", " + pAry[4] + ", " + oAry[5] + ", " + pAry[5] + ", " + 
				                oAry[6] + ", " + pAry[6] + ", " + oAry[7] + ", " + pAry[7] + "\n";
		str += "govFlag, agcFlag, dispatchFlag, baseloadFlag, turbineType, qtab: " + 
				govFlag + ", " + agcFlag + ", " + dispatchFlag + ", " + baseloadFlag + ", " + turbineType + ", " + qtab + "\n";
		str += "airTemp, pmax2: " + airTemp + ", " + pmax2 + "\n";			
		return str;
	}
	
}