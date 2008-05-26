package org.interpss.custom.exchange.ge;

public class GEDataRec {
	public static enum VersionNo {PSLF15};
	
	static private class BaseRec {
		public String d_in, d_out;   // yymmdd
		public String projid_info;
	}

	static public class TitleRec {
		public String title;

		public TitleRec(String lineStr, VersionNo version) {
			System.out.println("title->" + lineStr);
		}
	}
	
	static public class CommentsRec {
		public String title;

		public CommentsRec(String lineStr, VersionNo version) {
			System.out.println("comment->" + lineStr);
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
	 */	
	static public class SolutionParamRec {
		public int tap, phas, area, svd, dctap, gcd;
		public double jump, toler, sbase;

		public SolutionParamRec(String lineStr, VersionNo version) {
			System.out.println("solutionParam->" + lineStr);
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
