package org.interpss.custom.exchange.ge;

import java.util.StringTokenizer;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.ext.ExtensionObjectFactory;
import com.interpss.ext.ge.aclf.GeAclfNetwork;
import com.interpss.ext.ge.aclf.GeArea;
import com.interpss.ext.ge.aclf.GeInterface;
import com.interpss.ext.ge.aclf.GeInterfaceBranch;
import com.interpss.ext.ge.aclf.GeOwner;
import com.interpss.ext.ge.aclf.GeZone;

public class GEDataRec {
	public static enum VersionNo {PSLF15};
	
	static public class TitleRec {
		public String title = "";

		public void processLineStr(String lineStr, VersionNo version) {
			//System.out.println("title->" + lineStr);
			title += lineStr + "\n";
		}

		public String toString() {
			return "Title: " + title;
		}
	}
	
	static public class CommentsRec {
		public String comments = "";

		public void processLineStr(String lineStr, VersionNo version) {
			//System.out.println("comment->" + lineStr);
			comments += lineStr + "\n";
		}

		public String toString() {
			return "Comments: " + comments;
		}
	}

	/*
	tap <1 or 0> TCUL adjustment flag
	phas <1 or 0> Phase shifter adjustment flag
	area <1 or 0> Area interchange control flag
	svd <1 or 0> Control shunt adjustment flag
	dctap <1 or 0> DC converter control flag
	gcd <1 or 0> GCD control flag
	jump <value> Jumper threshold impedance, pu
	toler <value> Newton solution tolerance, MVA
	sbase <value> System base, MVA
	
	sample data
		tap    1    tcul  enabled/disabled
		phas   1    ps    enabled/disabled
		area   1    area  enabled/disabled
		svd    1    svd   enabled/disabled
		dctap  1    dc    enabled/disabled
		ped    1    ped   enabled/disabled  // not defined in V15
		jump  0.000100    jumper threshold
		toler   0.1000    newton tolerance
		sbase    100.0    system mva base	
	 */	
	static public class SolutionParamRec {
		public int tap, phas, area, svd, dctap, gcd;
		public double jump, toler, sbase;

		public void processLineStr(String lineStr, VersionNo version) {
			//System.out.println("solutionParam->" + lineStr);
			StringTokenizer st = new StringTokenizer(lineStr);
			st.nextElement();
			String str = st.nextToken();
			if (lineStr.startsWith("tap"))
				tap = new Integer(str).intValue();
			else if (lineStr.startsWith("phas"))
				phas = new Integer(str).intValue();
			else if (lineStr.startsWith("area"))
				area = new Integer(str).intValue();
			else if (lineStr.startsWith("svd"))
				svd = new Integer(str).intValue();
			else if (lineStr.startsWith("dctap"))
				dctap = new Integer(str).intValue();
			else if (lineStr.startsWith("gcd"))
				gcd = new Integer(str).intValue();
			else if (lineStr.startsWith("jump"))
				jump = new Double(str).doubleValue();
			else if (lineStr.startsWith("toler"))
				toler = new Double(str).doubleValue();
			else if (lineStr.startsWith("sbase"))
				sbase = new Double(str).doubleValue();
		}
	
		public void setAclfNet(GeAclfNetwork net) {
	  		net.setBaseKva(this.sbase*1000.0);
	  		net.setTapAdjFlag(tap);
	  		net.setPsXfrAdjFlag(phas);
	  		net.setAreaInterExControlFlag(area);
	  		net.setShuntAdjFlag(svd);
	  		net.setDcLineControlFlag(dctap);
	  		net.setGcdControlFlag(gcd);
	  		net.setJumperThreshZ(jump);
	  		net.setTolerance(toler);
		}
		
		public String toString() {
			String str = "Solution Paramters: \n";
			str += "tap, phas, area, svd, dctap, gcd: " + tap + ", " + phas + ", " + area + ", " + svd + ", " + dctap + ", " + gcd + "\n";
			str += "jump, toler, sbase: " + jump + ", " + toler + ", " + sbase + "\n";
			return str;
		}
	}

	/*
	<arnum> Area number (0 - 999)
	<"arnam"> Area name up to 32 characters enclosed in quotation marks
	<swing> Bus number at which area swing generator is located
	<pnetdes> Scheduled real power net interchange (MW)
	<pnettol> Real power net interchange tolerance (MW)
	<pnet> Actual real power net interchange (MW)
	<qnet> Actual reactive power net interchange (MVAR)
	
        1 "P                               "       0      0.0   1000.0    -88.2    -84.1	
	 */
	static public class AreaRec {
		public int arnum, swing;
		public String arnam;
		public double pnetdes, pnettol, pnet, qnet;

		public AreaRec(String lineStr, VersionNo version) {
			//System.out.println("area->" + lineStr);
			StringTokenizer st = new StringTokenizer(lineStr, "\"");
			
			this.arnum = new Integer(st.nextToken().trim()).intValue();
			this.arnam = st.nextToken();
			
			String str = st.nextToken();
			//        0      0.0   1000.0    -88.2    -84.1
			st = new StringTokenizer(str);
			this.swing = new Integer(st.nextToken()).intValue();
			this.pnetdes = new Double(st.nextToken()).doubleValue();
			this.pnettol = new Double(st.nextToken()).doubleValue();
			this.pnet = new Double(st.nextToken()).doubleValue();
			this.qnet = new Double(st.nextToken()).doubleValue();	
		}
		
		public void setAreaData(GeAclfNetwork net) {
			GeArea area = ExtensionObjectFactory.createGeArea(this.arnum, this.arnam);
			area.setSwingNumber(this.swing);
			area.setNetMw(this.pnet);
			area.setNetMvar(this.qnet);
			area.setScheduledMw(this.pnetdes);
			area.setExTolerance(this.pnettol);
			net.getGeAreaList().add(area);
		}
		
		public String toString() {
			String str = "";
			str += "arnum, swing, arnam: " + arnum + ", " + swing + ", " + arnam + "\n";
			str += "pnetdes, pnettol, pnet, qnet: " + pnetdes + ", " + pnettol + ", " + pnet + ", " + qnet + "\n";
			return str;
		}
	}

	/*
	<zonum> Zone number (0 - 999)
	<"zonam"> Zone name up to 32 characters enclosed in quotation marks
	<pznet> Actual real power interchange (MW)
	<qznet> Actual reactive power interchange (MVAR)
	
    	2 "Italyz2                         "    9.448  112.738
	 */
	static public class ZoneRec {
		public int zonum;
		public String zonam;
		public double pznet, qznet;

		public ZoneRec(String lineStr, VersionNo version) {
			//System.out.println("zone->" + lineStr);
			StringTokenizer st = new StringTokenizer(lineStr, "\"");
			
			this.zonum = new Integer(st.nextToken().trim()).intValue();
			this.zonam = st.nextToken();
			
			String str = st.nextToken();
			st = new StringTokenizer(str);
			this.pznet = new Double(st.nextToken()).doubleValue();
			this.qznet = new Double(st.nextToken()).doubleValue();
		}

		public void setZoneData(GeAclfNetwork net) {
			GeZone zone = ExtensionObjectFactory.createGeZone(this.zonum, this.zonam);
			zone.setNetMw(this.pznet);
			zone.setNetMvar(this.qznet);
			net.getGeZoneList().add(zone);
		}

		public String toString() {
			String str = "zonum, zonam, pznet, qznet: " + zonum + ", " + zonam + ", " + pznet + ", " + qznet + "\n";
			return str;
		}
	}

	/*
	<owner no> Owner number
	<"oname"> Owner name up to 32 characters enclosed in quotation mark
	<"s name"> Owner short name up to 4 characters enclosed in quotation marks
	<net_mw> Actual real power net interchange (MW)
	<net_mvar> Actual reactive power net interchange (MVAr)
	<sch_mw> Schedule real power net interchange (MW)
	<sch_mvar> Schedule reactive power net interchange (MVAr)
	<ar> Area number
	
       1 "1                               " "    "       0.00       0.00       0.00       0.00   0
	 */
	static public class OwnerRec {
		public int ownerNo, ar;
		public String oname, sname;
		public double net_mw, net_mvar, sch_mw, sch_mvar;

		public OwnerRec(String lineStr, VersionNo version) {
			//System.out.println("owner->" + lineStr);
			StringTokenizer st = new StringTokenizer(lineStr, "\"");
			this.ownerNo = new Integer(st.nextToken().trim()).intValue();
			this.oname = st.nextToken();
			st.nextToken();
			this.sname = st.nextToken();
			
			//        0.00       0.00       0.00       0.00   0
			String str = st.nextToken();
			st = new StringTokenizer(str);
			this.net_mw = new Double(st.nextToken()).doubleValue();
			this.net_mvar = new Double(st.nextToken()).doubleValue();
			this.sch_mw = new Double(st.nextToken()).doubleValue();
			this.sch_mvar = new Double(st.nextToken()).doubleValue();
			this.ar = new Integer(st.nextToken().trim()).intValue();
		}
		
		public void setOwnerData(GeAclfNetwork net) {
			GeOwner o = ExtensionObjectFactory.createGeOwner(this.ownerNo, this.oname, this.sname);
			o.setNetMw(this.net_mw);
			o.setNetMvar(this.net_mvar);
			o.setScheduledMw(sch_mw);
			o.setScheduledMvar(sch_mvar);
			o.setAreaNumber(this.ar);
			net.getGeOwnerList().add(o);
		}		
	
		public String toString() {
			String str = "ownerNo, ar, oname, sname: " + ownerNo + ", " + ar + ", " + oname + ", " + sname + "\n";
			str += "net_mw, net_mvar, sch_mw, sch_mvar: " + net_mw + ", " + net_mvar + ", " + sch_mw + ", " + sch_mvar + "\n";
			return str;
		}
	}
	
/*
	<ifno> Interface number 
	<"name"> Interface name up to 32 characters enclosed in quotation marks
	<pnet> Actual real power flow across interface (MW)
	<qnet> Actual reactive power flow across interface (MVAR)
	<r1> First Interface Rating (MVA)
	<r2> Second Interface Rating (MVA)
	<r3> Third Interface Rating (MVA)
	<r4> Fourth Interface Rating (MVA)
	<r5> Fifth Interface Rating (MVA)
	<r6> Sixth Interface Rating (MVA)
	<r7> Seventh Interface Rating (MVA)
	<r8> Eighth Interface Rating (MVA)
	
    1 "E-P                             "   88.209   84.065  2275.0     0.0     0.0    0.0     0.0     0.0     0.0     0.0 
	
 */	
	static public class InterfaceRec {
		public int ifno;
		public String name;
		public double pnet, qnet; 
		double[] rAry = new double[8];
		
		public InterfaceRec(String lineStr, VersionNo version) {
			// System.out.println("interface->" + lineStr);
			StringTokenizer st = new StringTokenizer(lineStr, "\"");
			
			this.ifno = new Integer(st.nextToken().trim()).intValue();
			this.name = st.nextToken();
			
			String str = st.nextToken();
			st = new StringTokenizer(str);
			this.pnet = new Double(st.nextToken()).doubleValue();
			this.qnet = new Double(st.nextToken()).doubleValue();
			if (st.hasMoreElements())
				this.rAry[0] = new Double(st.nextToken()).doubleValue();
			if (st.hasMoreElements())
				this.rAry[1] = new Double(st.nextToken()).doubleValue();
			if (st.hasMoreElements())
				this.rAry[2] = new Double(st.nextToken()).doubleValue();
			if (st.hasMoreElements())
				this.rAry[3] = new Double(st.nextToken()).doubleValue();
			if (st.hasMoreElements())
				this.rAry[4] = new Double(st.nextToken()).doubleValue();
			if (st.hasMoreElements())
				this.rAry[5] = new Double(st.nextToken()).doubleValue();
			if (st.hasMoreElements())
				this.rAry[6] = new Double(st.nextToken()).doubleValue();
			if (st.hasMoreElements())
				this.rAry[7] = new Double(st.nextToken()).doubleValue();
		}

		public void setInterfaceData(GeAclfNetwork net) {
			GeInterface inf = ExtensionObjectFactory.createGeInterface(this.ifno, this.name);
			inf.setNetMw(this.pnet);
			inf.setNetMvar(this.qnet);
			for (int i = 0; i < 8; i++)
				inf.getMvaRatingAry().add(i, this.rAry[i]);
			net.getGeInterfaceList().add(inf);
		}

		public String toString() {
			String str = "ifno, name, pnet, qnet: " + ifno + ", " + name + ", " + pnet + ", " + qnet + "\n";
			return str;
		}
	}
	
/*
	<f bus> From bus number
	<"f name"> From bus name enclosed in quotation marks
	<f bkv> From bus base voltage (kV)
	<t bus> To bus number
	<"t name"> To bus name enclosed in quotation marks
	<t bkv> To bus base voltage (kV)
	<"ck"> Two character circuit identifier enclosed in quotation marks
	<ifn> Number of interface of which this branch is a member 
	<pf> Fraction of the flow on this branch that is to be counted as part of the interface flow
	             
     79 "E-55    " 380.00       1 "P-1     " 380.00 "1 "   :      1     1.000
*/	
	static public class InterfaceBranchRec extends BranchHeaderRec{
		public int ifn;
		public double pf;

		public InterfaceBranchRec(String lineStr, VersionNo version) {
			//System.out.println("inter branch->" + lineStr);
			String str1 = lineStr.substring(0, lineStr.indexOf(':')),
	               str2 = lineStr.substring(lineStr.indexOf(':')+1);
		
			this.setHeaderData(str1);
			StringTokenizer st = new StringTokenizer(str2);
			if (st.hasMoreElements())
				this.ifn = new Integer(st.nextToken()).intValue();
			if (st.hasMoreElements())
				this.pf = new Double(st.nextToken()).doubleValue();			
		}

		public void setInterfaceBranchData(GeAclfNetwork net, IPSSMsgHub msg) throws Exception {
			GeInterface inf = net.getInterface(this.ifn);
			if (inf == null) {
				msg.sendErrorMsg("Interface can not be found, interface number: " + this.ifn);
				throw new Exception("Interface can not be found");				
			}
			GeInterfaceBranch infBra = ExtensionObjectFactory.createGeInterfaceBranch();
			infBra.setParticipateFactor(pf);
			inf.getInfBranchList().add(infBra);
		}

		public String toString() {
			String str = "";
			return str;
		}
	}
}
