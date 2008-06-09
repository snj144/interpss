package org.interpss.custom.exchange.ge;

import java.util.StringTokenizer;

public class XformerDataRec extends BaseBranchDataRec {
	public int type, kregBus, zt, iintBus, tertBus;
	public double kregBkv, iintBkv, tertBkv, tbase, zpsr;
	public String kregName, iintName, tertName;
	public double zpsx, zptr, zptx, ztsr, ztsx, vnomp, vnoms, vnomt, anglp, gmag, bmag;
	public double aloss, tmax, tmin, vtmax, vtmin, stepp, tapp, tapfp, tapfs, tapft;
	public double tbasept, tbasets, angls, anglt;
	public double rs1, rs2, rs3, rt1, rt2, rt3, alosss, alosst, rxunits, gbunits, tunits, rcomp, xcomp;

	public XformerDataRec(String lineStr, GEDataRec.VersionNo version) {
		/*
		<f bus> <"f name"> <f bkv> <t bus> <"t name"> <t bkv> <"ck"> <"long id">:
		<st> <type> <kreg bus> <"kreg name"> <kreg bkv> <zt> <iint bus> <"iint name"> /
		<iint bkv> <tert bus> <"tert name"> <tert bkv> <area> <zone> <tbase> <zpsr> /
		<zpsx> <zptr> <zptx> <ztsr> <ztsx> <vnomp> <vnoms> <vnomt> <anglp> <gmag> /
		<bmag> <r1> <r2> <r3> <r4> <aloss> <tmax> <tmin> <vtmax> <vtmin> <stepp> <tapp> <tapfp> <tapfs> <tapft> <date_in> <date_out> <projid> <stn> /
		<r5> <r6> <r7> <r8> <o1> <p1> <o2> <p2> <o3> <p3> <o4> <p4> <o5> <p5> /
		<o6> <p6> <o7> <p7> <o8> <p8> <ohms> <tbasept> <tbasets> <angls> <anglt> /
		<rs1> <rs2> <rs3> <rt1> <rt2> <rt3> <alosss> <alosst> <rxunits> <gbunits> / <tunits> <rcomp> <xcomp>

       	1 "NORTH-01" 230.00      101 "NORTH-G1"  16.00 "1 " "        " :  
       	1  1   -1      "        " 000.00   0   -1      "        " 000.00   -1      "        " 
       	000.00   1    1  600.0 0.00000 0.10000 0.00000 0.00000 0.00000 0.00000 /
       	230.00  16.00   0.00    0.0 0.00000 0.00000  600.0    0.0    0.0    
       	0.0 0.000 1.5000 0.5100 1.5000 0.5100 0.00000 1.0000 1.0000 1.0000 1.0000   400101   391231   0 0     0.0    0.0    0.0    0.0 /
       	0 0.000   0 0.000   0 0.000   0 0.000   0 0.000   0 0.000   0 0.000   0 0.000		 
	 	*/
		// System.out.println("xfr data->" + lineStr);
		
		String str1 = lineStr.substring(0, lineStr.indexOf(':')),
               str2 = lineStr.substring(lineStr.indexOf(':')+1);
	
		this.setHeaderData(str1);		

		StringTokenizer st = new StringTokenizer(str2, "\"");
		String s1 = st.nextToken();
		this.kregName = st.nextToken();
		String s2 = st.nextToken();
		this.iintName = st.nextToken();
		String s3 = st.nextToken();
		this.tertName = st.nextToken();
		String s4 = st.nextToken();
		
		// 1  1   -1  <st> <type> <kreg bus>    
		st = new StringTokenizer(s1);
		this.st = new Integer(st.nextToken()).intValue();
		this.type = new Integer(st.nextToken()).intValue();
		this.kregBus = new Integer(st.nextToken()).intValue();

		// 000.00   0   -1    <kreg bkv> <zt> <iint bus>  
		st = new StringTokenizer(s2);
		this.kregBkv = new Double(st.nextToken()).doubleValue();
		this.zt = new Integer(st.nextToken()).intValue();
		this.iintBus = new Integer(st.nextToken()).intValue();
		
		// 000.00   -1 <iint bkv> <tert bus>
		st = new StringTokenizer(s3);
		this.iintBkv = new Double(st.nextToken()).doubleValue();
		this.tertBus = new Integer(st.nextToken()).intValue();

		/*
		000.00   1    1  600.0 0.00000 0.10000 0.00000 0.00000 0.00000 0.00000 /
       	230.00  16.00   0.00    0.0 0.00000 0.00000  600.0    0.0    0.0    
       	0.0 0.000 1.5000 0.5100 1.5000 0.5100 0.00000 1.0000 1.0000 1.0000 1.0000   400101   391231   0 0     0.0    0.0    0.0    0.0 /
       	0 0.000   0 0.000   0 0.000   0 0.000   0 0.000   0 0.000   0 0.000   0 0.000
       	
		<tert bkv> <area> <zone> <tbase> <zpsr> /
		<zpsx> <zptr> <zptx> <ztsr> <ztsx> <vnomp> <vnoms> <vnomt> <anglp> <gmag> /
		<bmag> <r1> <r2> <r3> <r4> <aloss> <tmax> <tmin> <vtmax> <vtmin> <stepp> <tapp> <tapfp> <tapfs> <tapft> <date_in> <date_out> <projid> <stn> /
		<r5> <r6> <r7> <r8> <o1> <p1> <o2> <p2> <o3> <p3> <o4> <p4> <o5> <p5> /
		<o6> <p6> <o7> <p7> <o8> <p8> <ohms> <tbasept> <tbasets> <angls> <anglt> /
		<rs1> <rs2> <rs3> <rt1> <rt2> <rt3> <alosss> <alosst> <rxunits> <gbunits> / <tunits> <rcomp> <xcomp>       	
       	*/
		st = new StringTokenizer(s4);
		this.tertBkv = new Double(st.nextToken()).doubleValue();
		this.ar = new Integer(st.nextToken()).intValue();
		this.z = new Integer(st.nextToken()).intValue();
		this.tbase = new Double(st.nextToken()).doubleValue();
		this.zpsr = new Double(st.nextToken()).doubleValue();
		this.zpsx = new Double(st.nextToken()).doubleValue();
		this.zptr = new Double(st.nextToken()).doubleValue();
		this.zptx = new Double(st.nextToken()).doubleValue();
		this.ztsr = new Double(st.nextToken()).doubleValue();
		this.ztsx = new Double(st.nextToken()).doubleValue();
		this.vnomp = new Double(st.nextToken()).doubleValue();
		this.vnoms = new Double(st.nextToken()).doubleValue();
		this.vnomt = new Double(st.nextToken()).doubleValue();
		this.anglp = new Double(st.nextToken()).doubleValue();
		this.gmag = new Double(st.nextToken()).doubleValue();
		this.bmag = new Double(st.nextToken()).doubleValue(); 
		
		// <r1> <r2> <r3> <r4>
		this.setRMvaAry1_4(st); 
		
		this.aloss = new Double(st.nextToken()).doubleValue();
		this.tmax = new Double(st.nextToken()).doubleValue();
		this.tmin = new Double(st.nextToken()).doubleValue();
		this.vtmax = new Double(st.nextToken()).doubleValue();
		this.vtmin = new Double(st.nextToken()).doubleValue();
		this.stepp = new Double(st.nextToken()).doubleValue();
		this.tapp = new Double(st.nextToken()).doubleValue();
		this.tapfp = new Double(st.nextToken()).doubleValue();
		this.tapfs = new Double(st.nextToken()).doubleValue();
		this.tapft  = new Double(st.nextToken()).doubleValue();
		
		// <d_in> <d_out> <proj id>
		this.setDates(st);
		
		//<stn> 
		this.nst = new Integer(st.nextToken()).intValue();
		
		// <r5> <r6> <r7> <r8>
		this.setRMvaAry5_8(st);
			
		// <o1> <p1> <o2> <p2> <o3> <p3> <o4> <p4> <o5> <p5> <o6> <p6> <o7> <p7> <o8> <p8>
		this.setOwnerAry(st);
		
		if (st.hasMoreElements())
			this.ohms = new Integer(st.nextToken()).intValue();
		if (st.hasMoreElements())
			this.tbasept = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.tbasets = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.angls = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.anglt = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.rs1 = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.rs2 = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.rs3 = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.rt1 = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.rt2 = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.rt3 = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.alosss = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.alosst = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.rxunits = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.gbunits = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.tunits = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.rcomp = new Double(st.nextToken()).doubleValue();
		if (st.hasMoreElements())
			this.xcomp = new Double(st.nextToken()).doubleValue();       	
	}
}
