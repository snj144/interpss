package org.ieee.pes.odm.pss.adapter.psse.v30.impl;

import java.util.StringTokenizer;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.NameValuePairListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BaseRecordXmlType.OwnerList.Owner;
import org.ieee.pes.odm.pss.adapter.psse.v30.PSSEV30Adapter;
import org.ieee.pes.odm.pss.adapter.psse.v30.PSSEV30Adapter.VersionNo;
import org.ieee.pes.odm.pss.model.DataSetter;
import org.ieee.pes.odm.pss.model.ParserHelper;


public class PSSEV30NetDataRec {
	public static double ZeroImpedenc = 0.00001;
	
	static public class HeaderRec {
		public static void procLine(String lineStr, int lineNo, PSSEV30Adapter.VersionNo version, final PSSNetworkXmlType baseCaseNet) {
			if (lineNo == 1) {
				StringTokenizer st = new StringTokenizer(lineStr, ",");
				int indicator = new Integer(st.nextToken().trim()).intValue();
				// at here we have "100.00 / PSS/E-29.0 THU, JUN 20 2002 14:19"
				st = new StringTokenizer(st.nextToken(), "/");
				double baseMva = new Double(st.nextToken().trim()).doubleValue();
				
				DataSetter.setPowerMva(baseCaseNet.addNewBasePower(), baseMva);
				
				NameValuePairListXmlType nvList = baseCaseNet.addNewNvPairList();
				ParserHelper.addNVPair(nvList, "CaseIndicator", new Integer(indicator).toString());
			}
			else if (lineNo == 2) {
				// The 2nd line is treated as description
				baseCaseNet.setDesc(lineStr);
			}
			else {
				// the 3rd line is treated as the network id and network name
				baseCaseNet.setName(lineStr);
			}
		}			
	}

	/*
	 * AreaInterchangeData I,ISW,PDES,PTOL,'ARNAM'
	 */
	static public class AreaInterchangeRec {
		private int i, isw;
		private double pdes, ptol;
		private String arnam;

		public AreaInterchangeRec(String lineStr, PSSEV30Adapter.VersionNo version) {
			StringTokenizer st = new StringTokenizer(lineStr, ",");
			i = new Integer(st.nextToken().trim()).intValue();
			isw = new Integer(st.nextToken().trim()).intValue();
			pdes = new Double(st.nextToken().trim()).doubleValue();
			ptol = new Double(st.nextToken().trim()).doubleValue();
			arnam = st.nextToken().trim();

	/*
			I,ISW,PDES,PTOL,'ARNAM'
	*/
			/*
			AclfBus bus = adjNet.getAclfBus(new Integer(this.isw).toString());
			if (bus == null) {
				IpssLogger.getLogger().warning("Area interchange poewr controller, Swing bus not found, ISW: " + this.isw + 
						", this data line is ignored");
			} else {
				AreaInterchangeControl controller = CoreObjectFactory.createAreaInterchangeController(this.i, this.arnam, adjNet);
				controller.setAclfBus(bus);
				controller.setPSpecOut(this.pdes, UnitType.mW, adjNet.getBaseKva());
				controller.setTolerance(this.ptol, UnitType.mW, adjNet.getBaseKva());
			}
			*/
		}
		
		public String toString() {
			String str = "";
			str += "Area number, Swing Bus Number:" + i + ", " + isw + "\n";
			str += "Pspec, Perror, Name:" + pdes + ", " + ptol + ", "  + arnam + "\n";
			return str;
		}
	}

	/*
	 * ZoneData Format: I, ’ZONAME’
	 */
	static public class ZoneRec {
		private int i;
		private String name;

		public ZoneRec(String lineStr, PSSEV30Adapter.VersionNo version) {
			StringTokenizer st = new StringTokenizer(lineStr, ",");
			i = new Integer(st.nextToken().trim()).intValue();
			name = st.nextToken().trim();

			/*
			 * Format: I, ’ZONAME’
			 */
	      	//Zone zone = CoreObjectFactory.createZone(i, adjNet);
			//zone.setName(name);
		}		

		public String toString() {
			String str = "";
			str += "Zone number, name:" + i + ", " + name;
			return str;
		}
	}

	/*
	 * InterareaTransfer format: ARFROM, ARTO, TRID, PTRAN
	 */
	static public class InterareaTransferRec {
		private int arfrom, arto;
		private String trid;
		private double ptran;

		public InterareaTransferRec(String lineStr, PSSEV30Adapter.VersionNo version) {
			StringTokenizer st = new StringTokenizer(lineStr, ",");
			arfrom = new Integer(st.nextToken().trim()).intValue();
			arto = new Integer(st.nextToken().trim()).intValue();
			trid = st.nextToken().trim();
			ptran = new Double(st.nextToken().trim()).doubleValue();

			/*
			 * format: ARFROM, ARTO, TRID, PTRAN

			ARFROM "From area" number (1 through the maximum number of areas at the 
					current size level; see Table P-1).
			ARTO "To area" number (1 through the maximum number of areas at the current 
					size level; see Table P-1).
			TRID Single-character (0 through 9 or A through Z) upper case interarea transfer identifier
					used to distinguish among multiple transfers between areas ARFROM and
					ARTO. TRID = ’1’ by default.
			PTRAN MW comprising this transfer. A positive PTRAN indicates that area ARFROM is
					selling to area ARTO. PTRAN = 0.0 by default.
					
				- FromAreaNo_ToAreaNo_TRID is unique					 
			*/
			//InterareaTransfer tr = CoreObjectFactory.createInterareaTransfer(adjNet, this.arfrom, this.arto, this.trid);
			//tr.setTransferMW(this.ptran);
		}		

		public String toString() {
			String str = "";
			str += "From area number, From area number, id, value:" + arfrom + ", " + arto  + ", " + trid  + ", " + ptran;
			return str;
		}
	}

	/*
	 * Owner format : I, ’OWNAME’
	 */
	static public class OwnerRec {
		private int i;
		private String name;

		public OwnerRec(String lineStr, PSSEV30Adapter.VersionNo version) {
			StringTokenizer st = new StringTokenizer(lineStr, ",");
			i = new Integer(st.nextToken().trim()).intValue();
			name = st.nextToken().trim();

			/*
			 * format : I, ’OWNAME’
			 */
	      	//Owner owner = CoreObjectFactory.createOwner(new Integer(i).toString(), adjNet);
			//owner.setName(name);
		}

		public String toString() {
			String str = "";
			str += "Zone number, name:" + i + ", " + name;
			return str;
		}
	}
}
