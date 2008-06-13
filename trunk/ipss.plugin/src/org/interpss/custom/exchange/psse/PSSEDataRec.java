package org.interpss.custom.exchange.psse;

import java.util.StringTokenizer;


public class PSSEDataRec {
	public enum VersionNo {
		NotDefined, Old, PSS_E_29, PSS_E_30
	}

	static public class HeaderRec {
		public String indicator = "0", baseMva;

		public HeaderRec(String lineStr, VersionNo version) {
			if (version == PSSEDataRec.VersionNo.Old) {
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
	 * 
	 * Bus numbers, or extended bus names enclosed in single quotes (see Section 4.1.2),
		of the "dummy buses" connected by the branches that comprise this multisection
		line grouping. No defaults allowed.
	 */
	static public class MultiSecLineGroupRec {
		public String i, j, id;
		public String[] dumBusId = new String[9];
		public String[] dumBusName = new String[9];

		public MultiSecLineGroupRec(String lineStr, VersionNo version) {
			StringTokenizer st = new StringTokenizer(lineStr, ",");
			i = st.nextToken().trim();
			j = st.nextToken().trim();
			id = st.nextToken().trim();
			if (st.hasMoreTokens())
				dumBusId[0] = st.nextToken().trim();
			if (st.hasMoreTokens())
				dumBusId[1] = st.nextToken().trim();
			if (st.hasMoreTokens())
				dumBusId[2] = st.nextToken().trim();
			if (st.hasMoreTokens())
				dumBusId[3] = st.nextToken().trim();
			if (st.hasMoreTokens())
				dumBusId[4] = st.nextToken().trim();
			if (st.hasMoreTokens())
				dumBusId[5] = st.nextToken().trim();
			if (st.hasMoreTokens())
				dumBusId[6] = st.nextToken().trim();
			if (st.hasMoreTokens())
				dumBusId[7] = st.nextToken().trim();
			if (st.hasMoreTokens())
				dumBusId[8] = st.nextToken().trim();
		}
	}
}
