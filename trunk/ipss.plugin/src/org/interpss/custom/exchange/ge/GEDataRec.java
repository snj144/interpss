package org.interpss.custom.exchange.ge;

import java.util.StringTokenizer;

import com.interpss.ext.ge.aclf.GeAclfNetwork;

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
	 */
	static public class AreaRec {
		public int arnum;
		public String arnam, swing;
		public double pnetdes, pnettol, pnet, qnet;

		public AreaRec(String lineStr, VersionNo version) {
			System.out.println("area->" + lineStr);
		}
	}

	/*
	<zonum> Zone number (0 - 999)
	<"zonam"> Zone name up to 32 characters enclosed in quotation marks
	<pznet> Actual real power interchange (MW)
	<qznet> Actual reactive power interchange (MVAR)
	 */
	static public class ZoneRec {
		public int zonum;
		public String zonam;
		public double pznet, qznet;

		public ZoneRec(String lineStr, VersionNo version) {
			System.out.println("zone->" + lineStr);
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
	 */
	static public class OwnerRec {
		public int ownerNo, ar;
		public String oname, sName;
		public double net_mw, net_mvar, sch_mw, sch_mvar;

		public OwnerRec(String lineStr, VersionNo version) {
			System.out.println("owner->" + lineStr);
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
 */	
	static public class InterfaceRec {
		public int ifno;
		public String name;
		public double pnet, qnet, r1, r2, r3, r4, r5, r6, r7, r8;
		
		public InterfaceRec(String lineStr, VersionNo version) {
			System.out.println("interface->" + lineStr);
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
	<ifn> Number of interface of which this branch is a member <pf> Fraction of the flow 
	             on this branch that is to be counted as part of the interface flow
*/	
	static public class InterfaceBranchRec {
		public int fBus, tBus, ifn;
		public String fName, tName, ck;
		public double fBkv, tBkv;

		public InterfaceBranchRec(String lineStr, VersionNo version) {
			System.out.println("inter branch->" + lineStr);
		}
	}
}
