package org.interpss.custom.exchange.psse;

import java.util.StringTokenizer;

public class PSSEDataRec {
	public enum VersionNo {
		NotDefined, Unkown, PSS_E_29, PSS_E_30
	}

	static public class HeaderRec {
		public String indicator = "0", baseMva;

		public HeaderRec(String lineStr, VersionNo version) {
			if (version == PSSEDataRec.VersionNo.Unkown) {
				// "0 100.0"
				StringTokenizer st = new StringTokenizer(lineStr);
				st.nextToken();
				baseMva = st.nextToken().trim();
			} else {
				StringTokenizer st = new StringTokenizer(lineStr, ",");
				indicator = st.nextToken();
				// at here we have "100.00 / PSS/E-29.0 THU, JUN 20 2002 14:19"
				st = new StringTokenizer(st.nextToken(), "/");
				baseMva = st.nextToken().trim();
			}
		}
	}

	/*
	 * AreaInterchangeData I,ISW,PDES,PTOL,'ARNAM'
	 */
	static public class AreaInterchangeRec {
		public String i, isw, pdes, ptol, arnam;

		public AreaInterchangeRec(String lineStr, VersionNo version) {
			StringTokenizer st = new StringTokenizer(lineStr, ",");
			i = st.nextToken().trim();
			isw = st.nextToken().trim();
			pdes = st.nextToken().trim();
			ptol = st.nextToken().trim();
			arnam = st.nextToken().trim();
		}
	}

	/*
	 * ZoneData Format: I, ’ZONAME’
	 */
	static public class ZoneRec {
		public String i, name;

		public ZoneRec(String lineStr, VersionNo version) {
			StringTokenizer st = new StringTokenizer(lineStr, ",");
			i = st.nextToken().trim();
			name = st.nextToken().trim();
		}
	}

	/*
	 * InterareaTransfer format: ARFROM, ARTO, TRID, PTRAN
	 */
	static public class InterareaTransferRec {
		public String arfrom, arto, trid, ptran;

		public InterareaTransferRec(String lineStr, VersionNo version) {
			StringTokenizer st = new StringTokenizer(lineStr, ",");
			arfrom = st.nextToken().trim();
			arto = st.nextToken().trim();
			trid = st.nextToken().trim();
			ptran = st.nextToken().trim();
		}
	}

	/*
	 * Owner format : I, ’OWNAME’
	 */
	static public class OwnerRec {
		public String i, name;

		public OwnerRec(String lineStr, VersionNo version) {
			StringTokenizer st = new StringTokenizer(lineStr, ",");
			i = st.nextToken().trim();
			name = st.nextToken().trim();
		}
	}

	/*
	 * MultiSectionLineGroup format: I, J, ID, DUM1, DUM2, ... DUM9
	 * 
	 * J is entered as a negative number or with a minus sign before the first
	 * character of the extended bus name to designate it as the metered end;
	 * otherwise, bus I is assumed to be the metered end.
	 */
	static public class MultiSectionLineGroupRec {
		public String i, j, id;
		public String[] dum = new String[9];

		public MultiSectionLineGroupRec(String lineStr, VersionNo version) {
			StringTokenizer st = new StringTokenizer(lineStr, ",");
			i = st.nextToken().trim();
			j = st.nextToken().trim();
			id = st.nextToken().trim();
			if (st.hasMoreTokens())
				dum[0] = st.nextToken().trim();
			if (st.hasMoreTokens())
				dum[1] = st.nextToken().trim();
			if (st.hasMoreTokens())
				dum[2] = st.nextToken().trim();
			if (st.hasMoreTokens())
				dum[3] = st.nextToken().trim();
			if (st.hasMoreTokens())
				dum[4] = st.nextToken().trim();
			if (st.hasMoreTokens())
				dum[5] = st.nextToken().trim();
			if (st.hasMoreTokens())
				dum[6] = st.nextToken().trim();
			if (st.hasMoreTokens())
				dum[7] = st.nextToken().trim();
			if (st.hasMoreTokens())
				dum[8] = st.nextToken().trim();
		}
	}

	/*
	 * BusData Format: I, ’NAME’, BASKV, IDE, GL, BL, AREA, ZONE, VM, VA, OWNER
	 */
	static public class BusRec {
		public String i, name, baseKv, ide, gl = "0.0", bl = "0.0", area = "1",
				zone = "1", vm = "1.0", va = "0.0", owner = "1";

		public BusRec(String lineStr, VersionNo version) {
			StringTokenizer st;
			if (version == VersionNo.Unkown) {
				// old verdion: 80001 'TOMKE ' 220.00 1 0.00 0.00 703 1 1.0784
				// -38.614 1 /* [TOMKENJC A014] */
				st = new StringTokenizer(removeTailComment(lineStr), "'");
				i = st.nextToken().trim();
				name = st.nextToken().trim();
				st = new StringTokenizer(st.nextToken());
			} else {
				st = new StringTokenizer(lineStr, ",");
				i = st.nextToken().trim();
				name = st.nextToken().trim();
			}

			baseKv = st.nextToken().trim();
			ide = st.nextToken().trim();
			if (st.hasMoreTokens())
				gl = st.nextToken().trim();
			if (st.hasMoreTokens())
				bl = st.nextToken().trim();
			if (st.hasMoreTokens())
				area = st.nextToken().trim();
			if (st.hasMoreTokens())
				zone = st.nextToken().trim();
			if (st.hasMoreTokens())
				vm = st.nextToken().trim();
			if (st.hasMoreTokens())
				va = st.nextToken().trim();
			if (st.hasMoreTokens())
				owner = st.nextToken().trim();
		}
	}

	/*
	 * LoadData I, ID, STATUS, AREA, ZONE, PL, QL, IP, IQ, YP, YQ, OWNER
	 */
	static public class LoadRec {
		public String i, id, status, area = "1", zone = "1", pl = "0.0",
				ql = "0.0", ip = "0.0", iq = "0.0", yp = "0.0", yq = "0.0",
				owner = "1";

		public LoadRec(String lineStr, VersionNo version) {
			StringTokenizer st;
			if (version == VersionNo.Unkown) {
				// 74611 '99' 1 702 181 1.106 0.258 0.000 0.000 0.000 0.000 1 /*
				// [STA_204 999 ] */
				st = new StringTokenizer(removeTailComment(lineStr), "'");
				i = st.nextToken().trim();
				id = st.nextToken().trim();
				st = new StringTokenizer(st.nextToken());
			} else {
				st = new StringTokenizer(lineStr, ",");
				i = st.nextToken().trim();
				id = st.nextToken().trim();
			}
			status = st.nextToken().trim();
			area = st.nextToken().trim();
			zone = st.nextToken().trim();
			pl = st.nextToken().trim();
			ql = st.nextToken().trim();
			ip = st.nextToken().trim();
			iq = st.nextToken().trim();
			yp = st.nextToken().trim();
			yq = st.nextToken().trim();
			owner = st.nextToken().trim();
		}
	}

	/*
	 * GenData
	 * I,ID,PG,QG,QT,QB,VS,IREG,MBASE,ZR,ZX,RT,XT,GTAP,STAT,RMPCT,PT,PB,O1,F1,...,O4,F4
	 * 
	 * The standard generator boundary condition is a specification of real
	 * power output at the high-voltage bus, bus k, and of voltage magnitude at
	 * some designated bus, not necessarily bus k.
	 */
	static public class GenRec {
		public String i, id, pg, qg, qt, qb, vs, ireg, mbase, zr, zx, rt, xt,
				gtap, stat, rmpact, pt, pb, o1 = "0", f1 = "0.0", o2 = "0",
				f2 = "0.0", o3 = "0", f3 = "0.0", o4 = "0", f4 = "0.0";

		public GenRec(String lineStr, VersionNo version) {
			StringTokenizer st;
			if (version == VersionNo.Unkown) {
				// 80041 '1 ' 56.78 -8.79 28.000 -14.000 1.0000 0 61.2 0.0 1.0
				// 0.0 0.0 1.0 1 100.0 61.20 -5.60 1 1.00 /* [SMOKY AG1234 ] */
				st = new StringTokenizer(removeTailComment(lineStr), "'");
				i = st.nextToken().trim();
				id = st.nextToken().trim();
				st = new StringTokenizer(st.nextToken());
			} else {
				st = new StringTokenizer(lineStr, ",");
				i = st.nextToken().trim();
				id = st.nextToken().trim();
			}
			pg = st.nextToken().trim();
			qg = st.nextToken().trim();
			qt = st.nextToken().trim();
			qb = st.nextToken().trim();
			vs = st.nextToken().trim();
			ireg = st.nextToken().trim();
			mbase = st.nextToken().trim();
			zr = st.nextToken().trim();
			zx = st.nextToken().trim();
			rt = st.nextToken().trim();
			xt = st.nextToken().trim();
			gtap = st.nextToken().trim();
			stat = st.nextToken().trim();
			rmpact = st.nextToken().trim();
			pt = st.nextToken().trim();
			pb = st.nextToken().trim();

			if (st.hasMoreTokens())
				o1 = st.nextToken().trim();
			if (st.hasMoreTokens())
				f1 = st.nextToken().trim();
			if (st.hasMoreTokens())
				o2 = st.nextToken().trim();
			if (st.hasMoreTokens())
				f2 = st.nextToken().trim();
			if (st.hasMoreTokens())
				o3 = st.nextToken().trim();
			if (st.hasMoreTokens())
				f3 = st.nextToken().trim();
			if (st.hasMoreTokens())
				o4 = st.nextToken().trim();
			if (st.hasMoreTokens())
				f4 = st.nextToken().trim();
		}
	}

	/*
	 * ShuntData I,MODSW,VSWHI,VSWLO,SWREM,BINIT,N1,B1,N2,B2...N8,B8
	 */
	static public class ShuntRec {
		public String i, modsw, vswhi, vswlo, swrem, binit;
		public String[] b = { "0.0", "0.0", "0.0", "0.0", "0.0", "0.0", "0.0",
				"0.0" }, n = { "0", "0", "0", "0", "0", "0", "0", "0" };

		public ShuntRec(String lineStr, VersionNo version) {
			StringTokenizer st;
			if (version == VersionNo.Unkown) {
				// 99214 0 1.000 1.000 0 0.00 1 4.20 1 6.00 1 8.40
				st = new StringTokenizer(removeTailComment(lineStr));
			} else {
				st = new StringTokenizer(removeTailComment(lineStr), ",");
			}

			i = st.nextToken().trim();
			modsw = st.nextToken().trim();
			vswhi = st.nextToken().trim();
			vswlo = st.nextToken().trim();
			swrem = st.nextToken().trim();
			binit = st.nextToken().trim();
			if (st.hasMoreTokens())
				n[0] = st.nextToken().trim();
			if (st.hasMoreTokens())
				b[0] = st.nextToken().trim();
			if (st.hasMoreTokens())
				n[1] = st.nextToken().trim();
			if (st.hasMoreTokens())
				b[1] = st.nextToken().trim();
			if (st.hasMoreTokens())
				n[2] = st.nextToken().trim();
			if (st.hasMoreTokens())
				b[2] = st.nextToken().trim();
			if (st.hasMoreTokens())
				n[3] = st.nextToken().trim();
			if (st.hasMoreTokens())
				b[3] = st.nextToken().trim();
			if (st.hasMoreTokens())
				n[4] = st.nextToken().trim();
			if (st.hasMoreTokens())
				b[4] = st.nextToken().trim();
			if (st.hasMoreTokens())
				n[5] = st.nextToken().trim();
			if (st.hasMoreTokens())
				b[5] = st.nextToken().trim();
			if (st.hasMoreTokens())
				n[6] = st.nextToken().trim();
			if (st.hasMoreTokens())
				b[6] = st.nextToken().trim();
			if (st.hasMoreTokens())
				n[7] = st.nextToken().trim();
			if (st.hasMoreTokens())
				b[7] = st.nextToken().trim();
		}
	}

	/*
	 * BranchData
	 * I,J,CKT,R,X,B,RATEA,RATEB,RATEC,GI,BI,GJ,BJ,ST,LEN,O1,F1,...,O4,F4
	 */
	static public class BranchRec {
		public String i, j, ckt, r, x, b, rateA, rateB, rateC, gi, bi, gj, bj,
				status, len, o1 = "0", f1 = "0.0", o2 = "0", f2 = "0.0",
				o3 = "0", f3 = "0.0", o4 = "0", f4 = "0.0";

		public BranchRec(String lineStr, VersionNo version) {
			StringTokenizer st;
			if (version == VersionNo.Unkown) {
				// 79831 82157 1 0.000200 0.000500 0.00000 0 0 0 0.0000 0.000
				// 0.0 0.0 0.0 0.0 0 0.000 86 1.00 /* [KENORASP_PS2_1 A ] */
				st = new StringTokenizer(removeTailComment(lineStr));
			} else {
				st = new StringTokenizer(lineStr, ",");
			}
			i = st.nextToken().trim();
			j = st.nextToken().trim();
			ckt = st.nextToken().trim();
			r = st.nextToken().trim();
			x = st.nextToken().trim();
			b = st.nextToken().trim();
			rateA = st.nextToken().trim();
			rateB = st.nextToken().trim();
			rateC = st.nextToken().trim();
			gi = st.nextToken().trim();
			bi = st.nextToken().trim();
			gj = st.nextToken().trim();
			bj = st.nextToken().trim();
			status = st.nextToken().trim();
			len = st.nextToken().trim();

			if (st.hasMoreTokens())
				o1 = st.nextToken().trim();
			if (st.hasMoreTokens())
				f1 = st.nextToken().trim();
			if (st.hasMoreTokens())
				o2 = st.nextToken().trim();
			if (st.hasMoreTokens())
				f2 = st.nextToken().trim();
			if (st.hasMoreTokens())
				o3 = st.nextToken().trim();
			if (st.hasMoreTokens())
				f3 = st.nextToken().trim();
			if (st.hasMoreTokens())
				o4 = st.nextToken().trim();
			if (st.hasMoreTokens())
				f4 = st.nextToken().trim();
		}
	}

	/*
	 * XfrData For 2W Xfr:
	 * I,J,K,CKT,CW,CZ,CM,MAG1,MAG2,NMETR,’NAME’,STAT,O1,F1,...,O4,F4
	 * R1-2,X1-2,SBASE1-2
	 * WINDV1,NOMV1,ANG1,RATA1,RATB1,RATC1,COD,CONT,RMA,RMI,VMA,VMI,NTP,TAB,CR,CX
	 * WINDV2,NOMV2
	 * 
	 * Three-winding:
	 * I,J,K,CKT,CW,CZ,CM,MAG1,MAG2,NMETR,’NAME’,STAT,O1,F1,...,O4,F4
	 * R1-2,X1-2,SBASE1-2,R2-3,X2-3,SBASE2-3,R3-1,X3-1,SBASE3-1,VMSTAR,ANSTAR
	 * WINDV1,NOMV1,ANG1,RATA1,RATB1,RATC1,COD,CONT,RMA,RMI,VMA,VMI,NTP,TAB,CR,CX
	 * WINDV2,NOMV2,ANG2,RATA2,RATB2,RATC2 WINDV3,NOMV3,ANG3,RATA3,RATB3,RATC3
	 */
	static public class Xfr2WRec {
		public String i, j, k, ckt, cw, cz, cm, mag1, mag2, nmetr, name, stat,
				o1 = "0", f1 = "0.0", o2 = "0", f2 = "0.0", o3 = "0",
				f3 = "0.0", o4 = "0", f4 = "0.0";
		public String r1_2, x1_2, sbase1_2;
		public String windv1, nomv1, ang1, rata1, ratb1, ratc1, cod, cont, rma,
				rmi, vma, vmi, ntp, tab, cr, cx;
		public String windv2, nomv2;

		public Xfr2WRec(String lineStr1, String lineStr2, String lineStr3,
				String lineStr4, VersionNo version) {
			if (version == VersionNo.Unkown) {
				/*
				 * 	I,J,CKT,ICONT,RMA,RMI,VMA,VMI,STEP,TABLE 
				 * 		I - From bus number 
				 * 		J - To bus number 
				 * 		CKT - Circuit number 
				 * 		ICONT - Number of bus to control. If different from I or J, sign of ICONT determines
				 * 				control. Positive sign, close to impedance (untapped) bus of
				 * 				transformer. Negative sign, opposite. 
				 * 		RMA - Upper limit of turns ratio or phase shift 
				 * 		RMI - Lower limit of turns ratio or phase shift 
				 * 		VMA - Upper limit of controlled volts, MW or MVAR 
				 * 		VMI - Lower limit of controlled volts, MW or MVAR 
				 * 		STEP - Turns ratio step increment 
				 * 		TABLE - Zero, or number of a transformer impedance correction table 1-5
				 */
				StringTokenizer st = new StringTokenizer(removeTailComment(lineStr1));
				i = st.nextToken().trim();
				j = st.nextToken().trim();
				ckt = st.nextToken().trim();
				cont = st.nextToken().trim();
				rma = st.nextToken().trim();
				rmi = st.nextToken().trim();
				vma = st.nextToken().trim();
				vmi = st.nextToken().trim();

			} else {
				StringTokenizer st = new StringTokenizer(lineStr1, ",");
				i = st.nextToken().trim();
				j = st.nextToken().trim();
				k = st.nextToken().trim();
				ckt = st.nextToken().trim();
				cw = st.nextToken().trim();
				cz = st.nextToken().trim();
				cm = st.nextToken().trim();
				mag1 = st.nextToken().trim();
				mag2 = st.nextToken().trim();
				nmetr = st.nextToken().trim();
				name = st.nextToken().trim();
				stat = st.nextToken().trim();

				if (st.hasMoreTokens())
					o1 = st.nextToken().trim();
				if (st.hasMoreTokens())
					f1 = st.nextToken().trim();
				if (st.hasMoreTokens())
					o2 = st.nextToken().trim();
				if (st.hasMoreTokens())
					f2 = st.nextToken().trim();
				if (st.hasMoreTokens())
					o3 = st.nextToken().trim();
				if (st.hasMoreTokens())
					f3 = st.nextToken().trim();
				if (st.hasMoreTokens())
					o4 = st.nextToken().trim();
				if (st.hasMoreTokens())
					f4 = st.nextToken().trim();

				st = new StringTokenizer(lineStr2, ",");
				r1_2 = st.nextToken().trim();
				x1_2 = st.nextToken().trim();
				sbase1_2 = st.nextToken().trim();

				st = new StringTokenizer(lineStr3, ",");
				windv1 = st.nextToken().trim();
				nomv1 = st.nextToken().trim();
				ang1 = st.nextToken().trim();
				rata1 = st.nextToken().trim();
				ratb1 = st.nextToken().trim();
				ratc1 = st.nextToken().trim();
				cod = st.nextToken().trim();
				cont = st.nextToken().trim();
				rma = st.nextToken().trim();
				rmi = st.nextToken().trim();
				vma = st.nextToken().trim();
				vmi = st.nextToken().trim();
				ntp = st.nextToken().trim();
				tab = st.nextToken().trim();
				cr = st.nextToken().trim();
				cx = st.nextToken().trim();

				st = new StringTokenizer(lineStr4, ",");
				windv2 = st.nextToken().trim();
				nomv2 = st.nextToken().trim();
			}
		}
	}

	private static String removeTailComment(String s) {
		return s.substring(0, s.indexOf("/*"));
	}
}
